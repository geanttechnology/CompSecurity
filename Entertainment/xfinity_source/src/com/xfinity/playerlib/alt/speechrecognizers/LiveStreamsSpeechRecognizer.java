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
import com.comcast.cim.cmasl.utils.container.Tuple3;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class LiveStreamsSpeechRecognizer extends PlayerSpeechRecognizer
{
    private class DataTask extends NonCachingBaseTask
    {

        final LiveStreamsSpeechRecognizer this$0;

        public Tuple3 execute()
        {
            List list = liveStreamBookmarkDAO.getFavorites();
            return new Tuple3((VideoEntitlement)videoEntitlementCache.execute(), (HalLiveStreamResource)liveStreamResourceCache.execute(), list);
        }

        public volatile Object execute()
        {
            return execute();
        }

        private DataTask()
        {
            this$0 = LiveStreamsSpeechRecognizer.this;
            super();
        }

    }


    private LiveStreamBookmarkDAO liveStreamBookmarkDAO;
    private List liveStreamBookmarks;
    private Task liveStreamResourceCache;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;
    private TaskExecutorFactory taskExecutorFactory;
    private VideoEntitlement videoEntitlement;
    private Task videoEntitlementCache;

    public LiveStreamsSpeechRecognizer()
    {
        liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
        taskExecutorFactory = PlayerContainer.getInstance().getTaskExecutorFactory();
        liveStreamResourceCache = PlayerContainer.getInstance().getLiveStreamResourceCache();
        videoEntitlementCache = PlayerContainer.getInstance().getVideoEntitlementCache();
        taskExecutor = taskExecutorFactory.create(new DataTask());
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

                final LiveStreamsSpeechRecognizer this$0;
                final String val$filterText;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(Tuple3 tuple3)
                {
                    videoEntitlement = (VideoEntitlement)tuple3.e1;
                    liveStreamBookmarks = (List)tuple3.e3;
                    for (Iterator iterator = liveStreamBookmarks.iterator(); iterator.hasNext();)
                    {
                        LiveStreamBookmark livestreambookmark = (LiveStreamBookmark)iterator.next();
                        if (checkTitleMatch(livestreambookmark.getTitle(), filterText))
                        {
                            playLiveStream(livestreambookmark.getStreamId(), (HalLiveStreamResource)tuple3.e2, videoEntitlement);
                            return;
                        }
                    }

                    attemptSearch(terms, presentationMode);
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple3)obj);
                }

            
            {
                this$0 = LiveStreamsSpeechRecognizer.this;
                filterText = s;
                terms = as;
                presentationMode = speechpresentationmode;
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
    static VideoEntitlement access$102(LiveStreamsSpeechRecognizer livestreamsspeechrecognizer, VideoEntitlement videoentitlement)
    {
        livestreamsspeechrecognizer.videoEntitlement = videoentitlement;
        return videoentitlement;
    }

*/



/*
    static List access$202(LiveStreamsSpeechRecognizer livestreamsspeechrecognizer, List list)
    {
        livestreamsspeechrecognizer.liveStreamBookmarks = list;
        return list;
    }

*/





}
