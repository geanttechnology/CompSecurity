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
import com.comcast.cim.cmasl.utils.container.Option;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.VideoBookmarkDAO;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.editorial.FeaturedResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.alt.speechrecognizers:
//            PlayerSpeechRecognizer

public class FeaturedSpeechRecognizer extends PlayerSpeechRecognizer
{

    private final Task bookmarkTask = new NonCachingBaseTask() {

        final FeaturedSpeechRecognizer this$0;

        public Option execute()
        {
            Object obj = videoBookmarkDAO.getLastWatchedBookmark();
            LiveStreamBookmark livestreambookmark = liveStreamBookmarkDAO.getLastWatchedBookmark();
            if (obj == null || livestreambookmark != null && ((VideoBookmark) (obj)).getTimestamp().compareTo(livestreambookmark.getTimestamp()) <= 0)
            {
                obj = livestreambookmark;
            }
            return new Option(obj);
        }

        public volatile Object execute()
        {
            return execute();
        }

            
            {
                this$0 = FeaturedSpeechRecognizer.this;
                super();
            }
    };
    protected LiveStreamBookmarkDAO liveStreamBookmarkDAO;
    private TaskExecutionListener taskExecutionListener;
    private TaskExecutor taskExecutor;
    protected VideoBookmarkDAO videoBookmarkDAO;

    public FeaturedSpeechRecognizer()
    {
        videoBookmarkDAO = PlayerContainer.getInstance().getVideoBookmarkDAO();
        liveStreamBookmarkDAO = PlayerContainer.getInstance().getLiveStreamBookmarkDAO();
        taskExecutor = PlayerContainer.getInstance().getTaskExecutorFactory().create(PlayerContainer.getInstance().getVideoEntitlementCache(), PlayerContainer.getInstance().getFeaturedResourceCache(), bookmarkTask, PlayerContainer.getInstance().getDibicCombinedCache());
    }

    private void playLiveStreamWithoutCheckingEntitlements(String s)
    {
        startActivity(VideoPlayerActivity.createIntentForPlayer(s));
        closeWithIgnore();
    }

    private boolean showOrPlayLastWatchIfTitleMatches(VideoEntitlement videoentitlement, String s, Bookmark bookmark, DibicResource dibicresource, SpeechPresentationMode speechpresentationmode)
    {
        if (bookmark instanceof VideoBookmark)
        {
            bookmark = (VideoBookmark)bookmark;
            dibicresource = dibicresource.getProgramByMerlinId(bookmark.getParentMerlinIdIfApplicable());
            if (playOrShowIfEpisodeMatches(s, speechpresentationmode, bookmark, dibicresource, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK) || playOrShowIfVideoMatches(s, dibicresource, speechpresentationmode, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
            {
                return true;
            }
        } else
        if (bookmark instanceof LiveStreamBookmark)
        {
            videoentitlement = (LiveStreamBookmark)bookmark;
            if (checkTitleMatch(videoentitlement.getTitle(), s))
            {
                playLiveStreamWithoutCheckingEntitlements(videoentitlement.getStreamId());
                return true;
            }
        }
        return false;
    }

    private boolean showOrPlayLastWatched(VideoEntitlement videoentitlement, String s, Bookmark bookmark, DibicResource dibicresource, SpeechPresentationMode speechpresentationmode)
    {
        if (checkTitleMatch(s, "last watched"))
        {
            if (bookmark instanceof VideoBookmark)
            {
                s = (VideoBookmark)bookmark;
                bookmark = dibicresource.getProgramByMerlinId(s.getParentMerlinIdIfApplicable());
                if (speechpresentationmode.equals(SpeechPresentationMode.PLAY))
                {
                    if (videoentitlement.isEntitled(bookmark))
                    {
                        playVideo(s.getMerlinId(), s.getParentMerlinIdIfApplicable());
                        return true;
                    } else
                    {
                        closeWithNotEntitledDibicProgram(bookmark, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK);
                        return true;
                    }
                }
                if (bookmark.isMovie())
                {
                    showVideoDetails(bookmark);
                    return true;
                } else
                {
                    showSeriesFromVideoBookmark(s);
                    return true;
                }
            }
            if (bookmark instanceof LiveStreamBookmark)
            {
                playLiveStreamWithoutCheckingEntitlements(((LiveStreamBookmark)bookmark).getStreamId());
                return true;
            }
        }
        return false;
    }

    public void attemptSearch(final String terms[], final SpeechPresentationMode presentationMode)
    {
        if (presentationMode.equals(SpeechPresentationMode.SEARCH))
        {
            super.attemptSearch(terms, presentationMode);
            return;
        } else
        {
            taskExecutionListener = taskExecutor.execute(new DefaultTaskExecutionListener() {

                final FeaturedSpeechRecognizer this$0;
                final SpeechPresentationMode val$presentationMode;
                final String val$terms[];

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    PlayerSpeechRecognizer.this.onError(0);
                }

                public void onPostExecute(Tuple4 tuple4)
                {
                    VideoEntitlement videoentitlement = (VideoEntitlement)tuple4.e1;
                    Object obj = (FeaturedResource)tuple4.e2;
                    String s = StringUtils.join(terms, " ");
                    Bookmark bookmark = (Bookmark)((Option)tuple4.e3).getValue();
                    for (tuple4 = (DibicResource)tuple4.e4; bookmark != null && (showOrPlayLastWatched(videoentitlement, s, bookmark, tuple4, presentationMode) || showOrPlayLastWatchIfTitleMatches(videoentitlement, s, bookmark, tuple4, presentationMode));)
                    {
                        return;
                    }

                    for (Iterator iterator = ((FeaturedResource) (obj)).getCoverVideos().iterator(); iterator.hasNext();)
                    {
                        EditorialProgram editorialprogram1 = (EditorialProgram)iterator.next();
                        if (playOrShowIfProgramMatches(s, editorialprogram1, tuple4, presentationMode, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
                        {
                            return;
                        }
                    }

                    for (Iterator iterator1 = ((FeaturedResource) (obj)).getMovies().iterator(); iterator1.hasNext();)
                    {
                        EditorialProgram editorialprogram2 = (EditorialProgram)iterator1.next();
                        if (playOrShowIfProgramMatches(s, editorialprogram2, tuple4, presentationMode, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
                        {
                            return;
                        }
                    }

                    for (obj = ((FeaturedResource) (obj)).getSeries().iterator(); ((Iterator) (obj)).hasNext();)
                    {
                        EditorialProgram editorialprogram = (EditorialProgram)((Iterator) (obj)).next();
                        if (playOrShowIfProgramMatches(s, editorialprogram, tuple4, presentationMode, videoentitlement, com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAYBACK))
                        {
                            return;
                        }
                    }

                    attemptSearch(terms, presentationMode);
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Tuple4)obj);
                }

            
            {
                this$0 = FeaturedSpeechRecognizer.this;
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




}
