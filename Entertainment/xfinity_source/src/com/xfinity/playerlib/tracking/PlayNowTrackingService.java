// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.tracking;

import android.os.Build;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.model.user.UserManager;
import com.comcast.cim.tracking.TrackingService;
import com.xfinity.playerlib.model.consumable.SeriesWatchableInfo;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.tracking:
//            PlayNowAppMeasurement, VideoMilestone, PlayNowTab

public class PlayNowTrackingService extends TrackingService
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/tracking/PlayNowTrackingService);
    private final String productName;

    public PlayNowTrackingService(PlayNowUserManager playnowusermanager, String s, String s1, AndroidDevice androiddevice, Provider provider)
    {
        super(playnowusermanager, s1, androiddevice, provider);
        productName = s;
    }

    private PlayNowAppMeasurement buildAppMeasurement(String s, String s1, String s2, String s3)
    {
        s = (PlayNowAppMeasurement)getAppMeasurement(s);
        s.putCdata("contentType", s2);
        s.putCdata("networkName", s1);
        s.putCdata("contentTitle", s3);
        s.putCdata("authenticationStatus", "authenticated");
        return s;
    }

    private String getAssetType(VideoFacade videofacade)
    {
        if (videofacade.isMovie())
        {
            return "movie";
        } else
        {
            return "tvEpisode";
        }
    }

    private String getNetworkName(VideoFacade videofacade)
    {
        if (videofacade.getNetworkInfo() == null)
        {
            return "";
        } else
        {
            return videofacade.getNetworkInfo().getName();
        }
    }

    private String getTrackableTitle(VideoFacade videofacade, Watchable watchable)
    {
        if (videofacade.isMovie())
        {
            return videofacade.getTitle();
        } else
        {
            return (new StringBuilder()).append(watchable.getSeriesInfoIfApplicable().getSeriesTitle()).append(" - ").append(videofacade.getTitle()).toString();
        }
    }

    private void trackDownload(String s, String s1, VideoFacade videofacade)
    {
        String s2;
        String s3;
        long l;
        if (videofacade.getNetworkInfo() == null)
        {
            s2 = "";
        } else
        {
            s2 = videofacade.getNetworkInfo().getName();
        }
        s3 = videofacade.getTitle();
        l = videofacade.getVideoId();
        videofacade = String.format("%s %s", new Object[] {
            productName, "video"
        });
        s = (PlayNowAppMeasurement)getAppMeasurement(s);
        s.putCdata("mediaID", String.valueOf(l));
        s.putCdata("contentName", (new StringBuilder()).append(videofacade).append(" : ").append(s3).append(" (").append(s2).append(")").toString());
        s.putCdata("hashedGUID", userManager.getHashedOmnitureGuid());
        s.putCdata("deviceBrand", Build.BRAND);
        s.trackAction(s1);
    }

    private void trackEvent(PlayNowAppMeasurement playnowappmeasurement, String s, int i)
    {
        playnowappmeasurement.trackAction((new StringBuilder()).append(productName).append(" - ").append(s).append(" - ").append(i).append(" seconds watched").toString());
    }

    private void trackState(String s, String s1)
    {
        ((PlayNowAppMeasurement)getAppMeasurement(s)).trackState(s1);
    }

    public void trackAMSRelatedVideoError(String s)
    {
        LOG.debug("trackAMSRelatedVideoError");
        String s1 = (new StringBuilder()).append(productName).append(" video error : ").append(s).toString();
        PlayNowAppMeasurement playnowappmeasurement = (PlayNowAppMeasurement)appMeasurementProvider.get();
        playnowappmeasurement.setEvents("playbackError");
        playnowappmeasurement.putCdata("errorMessage", s);
        playnowappmeasurement.putCdata("t1", s1);
        playnowappmeasurement.trackState(s1);
    }

    public void trackDownloadRequest(VideoFacade videofacade)
    {
        LOG.debug("trackDownloadRequest");
        trackDownload("downloadStarted", "downloadReuest", videofacade);
    }

    public void trackDownloadSuccess(VideoFacade videofacade)
    {
        LOG.debug("trackDownloadSuccess");
        trackDownload("downloadCompleted", "downloadSuccess", videofacade);
    }

    public void trackLiveStreamEvent(String s, String s1, String s2, String s3, String s4, int i)
    {
        s = buildAppMeasurement(s, s1, s2, s3);
        s.putCdata("VODID", "live stream - no associated ID");
        s.putCdata("playbackType", "live");
        s.putCdata("liveID", s4);
        trackEvent(s, s2, i);
    }

    public void trackLiveStreamIncremental(String s, String s1, int i, int j)
    {
        s = buildAppMeasurement("event39", s, "liveStream", s);
        s.putCdata("VODID", "live stream - no associated ID");
        s.putCdata("playbackType", "live");
        s.putCdata("liveID", s1);
        s.putCdata("secondswatched", Integer.valueOf(j));
        trackEvent(s, "liveStream", i);
    }

    public void trackLiveStreamPlaybackMilestone(VideoMilestone videomilestone, String s, String s1, int i)
    {
        LOG.debug("trackVideoPlaybackMilestone() milestone={} assetName={}", videomilestone, "liveStream");
        if (VideoMilestone.NOT_STARTED.equals(videomilestone))
        {
            LOG.debug("trackVideoPlaybackMilestone() don't track not started; returning");
            return;
        } else
        {
            trackLiveStreamEvent(videomilestone.getEvent(), s, "liveStream", s, s1, i);
            return;
        }
    }

    public void trackParentalControlsPinPadRendered()
    {
        LOG.debug("trackParentalControlsPinPadRendered");
        trackState("parentalPinRendered", "parental controls pin pad");
    }

    public void trackSignInScreenRendered()
    {
        LOG.debug("trackSignInScreenRendered()");
        trackState("sign in", (new StringBuilder()).append(productName).append(" - sign in").toString());
    }

    public void trackTabRendered(PlayNowTab playnowtab)
    {
        LOG.debug((new StringBuilder()).append("trackTabRendered() tab=").append(playnowtab).toString());
        PlayNowAppMeasurement playnowappmeasurement = (PlayNowAppMeasurement)getAppMeasurement("sectionTapped");
        playnowtab = (new StringBuilder()).append(productName).append(" - ").append(playnowtab.getTabName()).toString();
        playnowappmeasurement.putCdata("pageName", playnowtab);
        playnowappmeasurement.trackState(playnowtab);
    }

    public void trackTapMovieAsset(String s, String s1, String s2)
    {
        LOG.debug("trackTapMovieAsset() movieName={} merlinId={} networkName={}", new String[] {
            s, s1, s2
        });
        PlayNowAppMeasurement playnowappmeasurement = (PlayNowAppMeasurement)getAppMeasurement("browseEntity");
        playnowappmeasurement.putCdata("entityID", s1);
        playnowappmeasurement.putCdata("contentType", (new StringBuilder()).append(productName).append(" movie").toString());
        playnowappmeasurement.putCdata("networkName", s2);
        playnowappmeasurement.putCdata("contentTitle", s);
        playnowappmeasurement.trackAction((new StringBuilder()).append(productName).append(" \u2013 movie selected").toString());
    }

    public void trackTapNetworkLogo(String s)
    {
        LOG.debug((new StringBuilder()).append("trackTapNetworkLogo() networkName=").append(s).toString());
        ((PlayNowAppMeasurement)getAppMeasurement("networkView")).trackAction((new StringBuilder()).append("android app : network tab click \u2013 Play Now : Premium Networks - ").append(s).toString());
    }

    public void trackVideoIncremental(VideoFacade videofacade, Watchable watchable, int i, int j)
    {
        Object obj = getTrackableTitle(videofacade, watchable);
        watchable = getAssetType(videofacade);
        obj = buildAppMeasurement("event39", getNetworkName(videofacade), watchable, ((String) (obj)));
        ((PlayNowAppMeasurement) (obj)).putCdata("VODID", Long.toString(videofacade.getVideoId()));
        ((PlayNowAppMeasurement) (obj)).putCdata("playbackType", "standard");
        ((PlayNowAppMeasurement) (obj)).putCdata("liveID", "vod asset \u2013 no associated live stream ID");
        ((PlayNowAppMeasurement) (obj)).putCdata("secondswatched", Integer.valueOf(j));
        trackEvent(((PlayNowAppMeasurement) (obj)), watchable, i);
    }

    public void trackVideoPlaybackMilestone(VideoMilestone videomilestone, VideoFacade videofacade, Watchable watchable, int i)
    {
        watchable = getTrackableTitle(videofacade, watchable);
        LOG.debug("trackVideoPlaybackMilestone() milestone={} assetName={}", videomilestone, watchable);
        if (VideoMilestone.NOT_STARTED.equals(videomilestone))
        {
            LOG.debug("trackVideoPlaybackMilestone() don't track not started; returning");
            return;
        } else
        {
            String s = getAssetType(videofacade);
            trackVodEvent(videomilestone.getEvent(), getNetworkName(videofacade), s, watchable, Long.toString(videofacade.getVideoId()), i);
            return;
        }
    }

    public void trackVodEvent(String s, String s1, String s2, String s3, String s4, int i)
    {
        s = buildAppMeasurement(s, s1, s2, s3);
        s.putCdata("VODID", s4);
        s.putCdata("playbackType", "standard");
        s.putCdata("liveID", "vod asset \u2013 no associated live stream ID");
        trackEvent(s, s2, i);
    }

}
