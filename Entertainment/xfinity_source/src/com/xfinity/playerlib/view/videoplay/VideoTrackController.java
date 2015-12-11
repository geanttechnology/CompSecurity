// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.database.VideoBookmarkDAO;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.tracking.FoxAnalyticsEventData;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.tracking.VideoMilestone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VideoTrackController
{

    private static final List foxNetworks = new ArrayList(Arrays.asList(new String[] {
        "utilisma", "20th century fox", "fox", "bigtennetwork", "foxbusiness", "foxnews", "foxsports", "fx", "fox", "fx", 
        "fxm", "fxx", "mundofox", "nat geo wild", "national geographic", "fox sports 1", "foxdeportes"
    }));
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private int MIN_RESUMABLE_PROGRESS;
    private AnalyticsLogger foxLogger;
    private boolean hasSavedResumePoint;
    private int lastTrackedPosition;
    private HalLiveStream liveStream;
    private LiveStreamBookmarkDAO liveStreamBookmarkDAO;
    private long resumePoint;
    private long trackingPosition;
    private PlayNowTrackingService trackingService;
    private PlayNowUserManager userManager;
    private VideoBookmarkDAO videoBookmarkDAO;
    private VideoFacade videoFacade;
    private Watchable watchable;

    public VideoTrackController(VideoBookmarkDAO videobookmarkdao, LiveStreamBookmarkDAO livestreambookmarkdao, PlayNowUserManager playnowusermanager, PlayNowTrackingService playnowtrackingservice, AnalyticsLogger analyticslogger)
    {
        trackingPosition = 0L;
        hasSavedResumePoint = false;
        MIN_RESUMABLE_PROGRESS = 10000;
        lastTrackedPosition = 0;
        videoBookmarkDAO = videobookmarkdao;
        liveStreamBookmarkDAO = livestreambookmarkdao;
        userManager = playnowusermanager;
        trackingService = playnowtrackingservice;
        foxLogger = analyticslogger;
    }

    private boolean isFox()
    {
        String s = videoFacade.getNetworkInfo().getParentCompany();
        String s1 = videoFacade.getNetworkInfo().getName();
        String s2 = videoFacade.getNetworkInfo().getBrand();
        if (s != null)
        {
            return s.equals("FOX");
        }
        return s1 != null && foxNetworks.contains(s1.toLowerCase()) || s2 != null && foxNetworks.contains(s2.toLowerCase());
    }

    private void resetTrackingItems()
    {
        videoFacade = null;
        watchable = null;
        liveStream = null;
        hasSavedResumePoint = false;
        trackingPosition = 0L;
        resumePoint = 0L;
    }

    private void saveLiveStreamTrackingPositionAndLastWatched(long l)
    {
        LiveStreamBookmark livestreambookmark = liveStreamBookmarkDAO.getOrCreateBookmarkWithLiveStream(liveStream, true);
        if (livestreambookmark != null)
        {
            if ((long)livestreambookmark.getDuration() != l)
            {
                livestreambookmark.setDuration((int)l);
            }
            livestreambookmark.setPosition((int)trackingPosition);
            liveStreamBookmarkDAO.saveBookmark(livestreambookmark, true);
            if (!((PlayerUserSettings)userManager.getUserSettings()).getShowLastWatched())
            {
                ((PlayerUserSettings)userManager.getUserSettings()).setShowLastWatched(true);
                userManager.saveUserAsync();
                return;
            }
        }
    }

    private void saveResumePoint(long l, long l1)
    {
        if (l < (long)MIN_RESUMABLE_PROGRESS)
        {
            trackingPosition = 0L;
        } else
        {
            trackingPosition = l;
        }
        saveTrackingPositionAndLastWatched(l1);
        hasSavedResumePoint = true;
    }

    private void saveTrackingPositionAndLastWatched(long l)
    {
        if (liveStream != null)
        {
            saveLiveStreamTrackingPositionAndLastWatched(l);
            return;
        } else
        {
            saveVideoTrackingPositionAndLastWatched(l);
            return;
        }
    }

    private void saveVideoTrackingPositionAndLastWatched(long l)
    {
        VideoBookmark videobookmark = videoBookmarkDAO.getOrCreateBookmarkWithVideo(videoFacade, watchable);
        if (trackingPosition == 0L && videobookmark.getLastTrackedMilestone() != VideoMilestone.NOT_STARTED)
        {
            videobookmark.setLastTrackedMilestone(VideoMilestone.NOT_STARTED);
            videoBookmarkDAO.saveBookmark(videobookmark);
        }
        trackOmnitureVideoMilestone(videoFacade, videobookmark);
        if ((long)videobookmark.getDuration() != l)
        {
            videobookmark.setDuration((int)l);
        }
        videobookmark.setPosition((int)trackingPosition);
        if (!videoFacade.isAdult())
        {
            videobookmark.addCategory(com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RECENT);
        }
        videobookmark.addCategory(com.xfinity.playerlib.bookmarks.VideoBookmark.BookmarkCategory.CATEGORY_RESUMEPOINT);
        videoBookmarkDAO.saveBookmark(videobookmark);
        if (!((PlayerUserSettings)userManager.getUserSettings()).getShowLastWatched())
        {
            ((PlayerUserSettings)userManager.getUserSettings()).setShowLastWatched(true);
            userManager.saveUserAsync();
        }
    }

    private void setResumePoint()
    {
        VideoBookmark videobookmark = videoBookmarkDAO.getOrCreateBookmarkWithVideo(videoFacade, watchable);
        resumePoint = videobookmark.getPosition();
        int i = videobookmark.getDuration();
        if ((double)resumePoint / (double)i > 0.97999999999999998D)
        {
            resumePoint = 0L;
        }
    }

    private void trackFox(String s, VideoFacade videofacade, VideoBookmark videobookmark)
    {
        s = new FoxAnalyticsEventData(s, videofacade, videobookmark);
        foxLogger.logData(s);
    }

    private void trackFoxProgress(long l, VideoFacade videofacade, VideoBookmark videobookmark)
    {
        int i = (int)(l / 60000L);
        if (i < 5 && i >= 1 && i - lastTrackedPosition >= 1 || i >= 5 && i - lastTrackedPosition >= 5)
        {
            trackFox("event39", videofacade, videobookmark);
            lastTrackedPosition = i;
        }
    }

    private void trackOmnitureVideoMilestone(VideoFacade videofacade, VideoBookmark videobookmark)
    {
        Object obj = videobookmark.getLastTrackedMilestone();
        VideoMilestone videomilestone = VideoMilestone.decodePosition((int)trackingPosition, videofacade);
        LOG.debug("trackVideoMilestone() lastTrackedMilestone={} currentMilestone={}", obj, videomilestone);
        obj = ((VideoMilestone) (obj)).valuesBetween(videomilestone);
        LOG.debug("trackVideoMilestone() milestones={}", obj);
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            VideoMilestone videomilestone1 = (VideoMilestone)((Iterator) (obj)).next();
            if (videomilestone1 != VideoMilestone.NOT_STARTED)
            {
                trackingService.trackVideoPlaybackMilestone(videomilestone1, videofacade, watchable, 0);
                videobookmark.setLastTrackedMilestone(videomilestone1);
                if (isFox())
                {
                    trackFox(videomilestone1.getEvent(), videofacade, videobookmark);
                }
            }
        } while (true);
        if (isFox())
        {
            trackFoxProgress(trackingPosition, videofacade, videobookmark);
        }
    }

    public long getResumePoint()
    {
        return resumePoint;
    }

    public void onCustomUpdateEvent(long l, long l1)
    {
        if (l > (long)MIN_RESUMABLE_PROGRESS || trackingPosition > (long)MIN_RESUMABLE_PROGRESS)
        {
            saveResumePoint(l, l1);
        }
    }

    public void onEndPlayback(long l, long l1)
    {
        if (hasSavedResumePoint)
        {
            saveResumePoint(l, l1);
        }
    }

    public void onPlayerProgress(long l, long l1)
    {
        if (l < (long)MIN_RESUMABLE_PROGRESS && trackingPosition > (long)MIN_RESUMABLE_PROGRESS || Math.abs(l - trackingPosition) > (long)MIN_RESUMABLE_PROGRESS)
        {
            saveResumePoint(l, l1);
        }
    }

    public void setTrackingItems(VideoFacade videofacade, Watchable watchable1)
    {
        resetTrackingItems();
        videoFacade = videofacade;
        watchable = watchable1;
        setResumePoint();
        trackingPosition = resumePoint;
    }

    public void setTrackingItems(HalLiveStream hallivestream)
    {
        resetTrackingItems();
        liveStream = hallivestream;
        trackingPosition = resumePoint;
    }

    public void trackOmnitureLiveStreamStartedMilestone()
    {
        trackingService.trackLiveStreamPlaybackMilestone(VideoMilestone.LIVE_STREAM_STARTED, liveStream.getTitle(), liveStream.getStreamId(), 0);
    }

}
