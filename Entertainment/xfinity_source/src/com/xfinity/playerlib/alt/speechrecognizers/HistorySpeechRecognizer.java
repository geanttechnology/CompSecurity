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
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.dibic.NullDibicResource;
import com.xfinity.playerlib.model.entitlement.NullVideoEntitlement;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class HistorySpeechRecognizer extends PlayerSpeechRecognizer
{
    private class ShortCircuitingDataFetcher extends NonCachingBaseTask
    {

        final HistorySpeechRecognizer this$0;

        public Tuple4 execute()
        {
            List list = (List)bookmarkTask.execute();
            Object obj;
            Object obj1;
            if (list.size() > 0)
            {
                obj = (DibicResource)dibicCombinedCache.execute();
                obj1 = (VideoEntitlement)videoEntitlementCache.execute();
            } else
            {
                obj = new NullDibicResource();
                obj1 = new NullVideoEntitlement();
            }
            return new Tuple4(list, obj, obj1, (HalLiveStreamResource)liveStreamResourceCache.execute());
        }

        public volatile Object execute()
        {
            return execute();
        }

        private ShortCircuitingDataFetcher()
        {
            this$0 = HistorySpeechRecognizer.this;
            super();
        }

    }


    private final CachingVideoBookmarkDAO bookmarkDAO = PlayerContainer.getInstance().getVideoBookmarkDAO();
    Task bookmarkTask;
    private final Task dibicCombinedCache = PlayerContainer.getInstance().getDibicCombinedCache();
    private final LiveStreamBookmarkDAO liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
    private HalLiveStreamResource liveStreamResource;
    private final Task liveStreamResourceCache = PlayerContainer.getInstance().getLiveStreamResourceCache();
    protected TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;
    private final TaskExecutorFactory taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();
    private final Task videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();

    public HistorySpeechRecognizer()
    {
        taskExecutor = taskExecutorFactory.create(new ShortCircuitingDataFetcher());
        bookmarkTask = new NonCachingBaseTask() {

            final HistorySpeechRecognizer this$0;

            public volatile Object execute()
            {
                return execute();
            }

            public List execute()
            {
                ArrayList arraylist = new ArrayList();
                for (Iterator iterator = bookmarkDAO.getRecentBookmarks().iterator(); iterator.hasNext(); arraylist.add((Bookmark)iterator.next())) { }
                Iterator iterator1 = liveStreamBookmarkDAO.getRecentBookmarks().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    Bookmark bookmark = (Bookmark)iterator1.next();
                    if (((PlayerUserSettings)userManager.getUserSettings()).getWantsAdultContent() || !((LiveStreamBookmark)bookmark).isAdultContent())
                    {
                        arraylist.add(bookmark);
                    }
                } while (true);
                Collections.sort(arraylist, new Comparator() {

                    final _cls2 this$1;

                    public int compare(Bookmark bookmark, Bookmark bookmark1)
                    {
                        return bookmark1.getTimestamp().compareTo(bookmark.getTimestamp());
                    }

                    public volatile int compare(Object obj, Object obj1)
                    {
                        return compare((Bookmark)obj, (Bookmark)obj1);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                return arraylist;
            }

            
            {
                this$0 = HistorySpeechRecognizer.this;
                super();
            }
        };
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

                final HistorySpeechRecognizer this$0;
                final String val$filterText;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(Tuple4 tuple4)
                {
                    DibicResource dibicresource = (DibicResource)tuple4.e2;
                    VideoEntitlement videoentitlement = (VideoEntitlement)tuple4.e3;
                    liveStreamResource = (HalLiveStreamResource)tuple4.e4;
                    tuple4 = ((List)tuple4.e1).iterator();
label0:
                    do
                    {
                        Object obj;
                        do
                        {
                            if (!tuple4.hasNext())
                            {
                                break label0;
                            }
                            obj = (Bookmark)tuple4.next();
                            if (!(obj instanceof VideoBookmark))
                            {
                                continue;
                            }
                            obj = (VideoBookmark)obj;
                            com.xfinity.playerlib.model.dibic.DibicProgram dibicprogram = dibicresource.getProgramByMerlinId(((VideoBookmark) (obj)).getParentMerlinIdIfApplicable());
                            if (playOrShowIfEpisodeMatches(filterText, presentationMode, ((VideoBookmark) (obj)), dibicprogram, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAY_FROM_HISTORY) || playOrShowIfVideoMatches(filterText, dibicprogram, presentationMode, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAY_FROM_HISTORY))
                            {
                                return;
                            }
                            continue label0;
                        } while (!(obj instanceof LiveStreamBookmark));
                        obj = (LiveStreamBookmark)obj;
                        if (checkTitleMatch(((LiveStreamBookmark) (obj)).getTitle(), filterText))
                        {
                            playLiveStream(((LiveStreamBookmark) (obj)).getStreamId(), liveStreamResource, videoentitlement);
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
                this$0 = HistorySpeechRecognizer.this;
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



/*
    static HalLiveStreamResource access$102(HistorySpeechRecognizer historyspeechrecognizer, HalLiveStreamResource hallivestreamresource)
    {
        historyspeechrecognizer.liveStreamResource = hallivestreamresource;
        return hallivestreamresource;
    }

*/








}
