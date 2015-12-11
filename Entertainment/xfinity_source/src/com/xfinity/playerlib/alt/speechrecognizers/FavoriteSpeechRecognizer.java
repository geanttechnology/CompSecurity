// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.alt.speechrecognizers;

import com.comcast.cim.android.accessibility.SpeechPresentationMode;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.Favorite;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.database.FavoriteDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class FavoriteSpeechRecognizer extends PlayerSpeechRecognizer
{
    private class FavoriteTask extends NonCachingBaseTask
    {

        final FavoriteSpeechRecognizer this$0;

        public Tuple4 execute()
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(favoriteDAO.getAllFavorite());
            for (Iterator iterator = liveStreamBookmarkDAO.getFavorites().iterator(); iterator.hasNext(); arraylist.add(new LiveStreamFavorite((LiveStreamBookmark)iterator.next()))) { }
            Collections.sort(arraylist, new Comparator() {

                final FavoriteTask this$1;

                public int compare(Favorite favorite, Favorite favorite1)
                {
                    return favorite1.getCreated().compareTo(favorite.getCreated());
                }

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((Favorite)obj, (Favorite)obj1);
                }

            
            {
                this$1 = FavoriteTask.this;
                super();
            }
            });
            return new Tuple4(arraylist, (DibicResource)dibicCombinedCache.execute(), (VideoEntitlement)videoEntitlementCache.execute(), (HalLiveStreamResource)liveStreamResourceCache.execute());
        }

        public volatile Object execute()
        {
            return execute();
        }

        private FavoriteTask()
        {
            this$0 = FavoriteSpeechRecognizer.this;
            super();
        }

    }


    private final Task dibicCombinedCache = PlayerContainer.getInstance().getDibicCombinedCache();
    private FavoriteDAO favoriteDAO;
    private LiveStreamBookmarkDAO liveStreamBookmarkDAO;
    private final Task liveStreamResourceCache = PlayerContainer.getInstance().getLiveStreamResourceCache();
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;
    private final TaskExecutorFactory taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
    private final Task videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();

    public FavoriteSpeechRecognizer()
    {
        favoriteDAO = PlayerContainer.getInstance().getFavoriteDAO();
        liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
        taskExecutor = taskExecutorFactory.create(new FavoriteTask());
    }

    public void attemptSearch(final String terms[], final SpeechPresentationMode presentationMode)
    {
        if (presentationMode.equals(SpeechPresentationMode.SEARCH))
        {
            super.attemptSearch(terms, presentationMode);
            return;
        } else
        {
            final String filterText = StringUtils.join(terms, " ");
            taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

                final FavoriteSpeechRecognizer this$0;
                final String val$filterText;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(Tuple4 tuple4)
                {
                    Object obj = (List)tuple4.e1;
                    DibicResource dibicresource = (DibicResource)tuple4.e2;
                    VideoEntitlement videoentitlement = (VideoEntitlement)tuple4.e3;
                    tuple4 = (HalLiveStreamResource)tuple4.e4;
                    obj = ((List) (obj)).iterator();
label0:
                    do
                    {
                        Object obj1;
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break label0;
                            }
                            obj1 = (Favorite)((Iterator) (obj)).next();
                            if (!(obj1 instanceof VideoFavorite))
                            {
                                continue;
                            }
                            obj1 = dibicresource.getProgramByMerlinId(((VideoFavorite)obj1).getMerlinId());
                            if (playOrShowIfVideoMatches(filterText, ((com.xfinity.playerlib.model.dibic.DibicProgram) (obj1)), presentationMode, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
                            {
                                return;
                            }
                            continue label0;
                        } while (!(obj1 instanceof LiveStreamFavorite));
                        obj1 = (LiveStreamFavorite)obj1;
                        if (checkTitleMatch(((LiveStreamFavorite) (obj1)).getTitle(), filterText))
                        {
                            playLiveStream(((LiveStreamFavorite) (obj1)).getStreamId(), tuple4, videoentitlement);
                            return;
                        }
                    } while (true);
                    attemptSearch(terms, presentationMode);
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple4)obj);
                }

            
            {
                this$0 = FavoriteSpeechRecognizer.this;
                filterText = s;
                presentationMode = speechpresentationmode;
                terms = as;
                super();
            }
            });
            return;
        }
    }

    protected TaskExecutionListener getTaskExecutionListener()
    {
        return taskExecutionListener;
    }

    protected TaskExecutor getTaskExecutor()
    {
        return taskExecutor;
    }







}
