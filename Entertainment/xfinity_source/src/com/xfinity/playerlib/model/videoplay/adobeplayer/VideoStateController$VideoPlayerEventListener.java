// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.comcast.cim.analytics.VideoErrorEventData;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformErrorException;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            VideoStateController, VideoState

private class <init> extends AbstractPlayerPlatformVideoEventListener
{

    final VideoStateController this$0;

    public void acquiringLicense(String s)
    {
        VideoStateController.access$500(VideoStateController.this).onAcquiringLicense(s);
    }

    public void adBreakComplete(VideoAdBreak videoadbreak)
    {
        VideoStateController.access$500(VideoStateController.this).adBreakComplete(videoadbreak);
    }

    public void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
        VideoStateController.access$500(VideoStateController.this).adBreakStart(videoadbreak, videoad);
    }

    public void adComplete(String s)
    {
        VideoStateController.access$500(VideoStateController.this).adComplete(Long.parseLong(s));
    }

    public void adProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
    {
        VideoStateController.access$500(VideoStateController.this).adProgress(videoadbreak, videoad, i, l);
    }

    public void adStart(VideoAd videoad)
    {
        VideoStateController.access$500(VideoStateController.this).adStart(videoad);
    }

    public void bitrateChanged(long l, String s, long l1, long l2)
    {
        VideoStateController.access$402(VideoStateController.this, l);
        VideoStateController.access$500(VideoStateController.this).onBitrateChanged(l, s, (int)l1, (int)l2);
    }

    public void drmComplete(String s, Date date, Date date1)
    {
        VideoStateController.access$500(VideoStateController.this).onDrmComplete(s, date, date1);
    }

    public void drmFailure(String s, String s1, String s2, Exception exception)
    {
        s2 = getBasicVideoErrorEventData("drmFailure");
        s2.setErrorCodes(s);
        s2.setErrorTitle(s1);
        s = formatError(new PlayerPlatformErrorException(s, s1, shouldUseDownloadFile()));
        if (s != null)
        {
            s2.setErrorMessage(s.getDescription());
        }
        VideoStateController.access$600(VideoStateController.this).logData(s2);
    }

    public void drmMetaDataAvailable(DRMManager drmmanager, DRMMetadata drmmetadata)
    {
        VideoStateController.access$500(VideoStateController.this).onDrmMetaDataAvailable(drmmanager, drmmetadata);
    }

    public void droppedFPSChanged(long l)
    {
        VideoStateController.access$500(VideoStateController.this).onDroppedFPSChanged(l);
    }

    public void durationChanged(long l)
    {
        VideoStateController.access$500(VideoStateController.this).onDurationChanged(l);
    }

    public void emergencyAlertCompleted(String s)
    {
        VideoStateController.access$500(VideoStateController.this).emergencyAlertCompleted(s);
    }

    public void emergencyAlertFailed(String s, String s1)
    {
        VideoStateController.access$500(VideoStateController.this).emergencyAlertFailed(s);
    }

    public void emergencyAlertStarted(String s)
    {
        VideoStateController.access$500(VideoStateController.this).emergencyAlertStarted(s);
    }

    public void fpsChanged(long l)
    {
        VideoStateController.access$500(VideoStateController.this).onFpsChanged(l);
    }

    public void mediaEnded()
    {
        VideoStateController.access$500(VideoStateController.this).onMediaEnded();
    }

    public void mediaFailed(String s, String s1)
    {
        VideoErrorEventData videoerroreventdata = getBasicVideoErrorEventData("mediaFailed");
        videoerroreventdata.setErrorTitle(s1);
        videoerroreventdata.setErrorCodes(s);
        FormattedError formattederror = formatError(new PlayerPlatformErrorException(s, s1, shouldUseDownloadFile()));
        if (formattederror != null)
        {
            videoerroreventdata.setErrorMessage(formattederror.getDescription());
        }
        VideoStateController.access$600(VideoStateController.this).logData(videoerroreventdata);
        VideoStateController.access$500(VideoStateController.this).onMediaFailed(s, s1);
    }

    public void mediaOpened(String s, String s1, List list, List list1, List list2, long l, 
            long l1, long l2, double d, boolean flag)
    {
        VideoStateController.access$500(VideoStateController.this).onMediaOpened(s, s1, list, list1, l, l1, d, flag);
    }

    public void mediaProgress(long l, double d, long l1, long l2, int i)
    {
        VideoStateController.access$500(VideoStateController.this).onMediaProgress(l, d, l1, l2, i);
        if (VideoStateController.access$700(VideoStateController.this) <= 0) goto _L2; else goto _L1
_L1:
        if (!isLiveStream()) goto _L4; else goto _L3
_L3:
        if (VideoStateController.access$700(VideoStateController.this) > 300 || VideoStateController.access$700(VideoStateController.this) % 60 != 0) goto _L6; else goto _L5
_L5:
        VideoStateController.access$900(VideoStateController.this).trackLiveStreamIncremental(VideoStateController.access$800(VideoStateController.this).getTitle(), VideoStateController.access$800(VideoStateController.this).getStreamId(), VideoStateController.access$700(VideoStateController.this), 60);
_L2:
        VideoStateController.access$708(VideoStateController.this);
        return;
_L6:
        if (VideoStateController.access$700(VideoStateController.this) > 300 && VideoStateController.access$700(VideoStateController.this) % 300 == 0)
        {
            VideoStateController.access$900(VideoStateController.this).trackLiveStreamIncremental(VideoStateController.access$800(VideoStateController.this).getTitle(), VideoStateController.access$800(VideoStateController.this).getStreamId(), VideoStateController.access$700(VideoStateController.this), 300);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (VideoStateController.access$700(VideoStateController.this) <= 300 && VideoStateController.access$700(VideoStateController.this) % 60 == 0)
        {
            VideoStateController.access$900(VideoStateController.this).trackVideoIncremental(VideoStateController.access$1000(VideoStateController.this), VideoStateController.access$1100(VideoStateController.this), VideoStateController.access$700(VideoStateController.this), 60);
        } else
        if (VideoStateController.access$700(VideoStateController.this) > 300 && VideoStateController.access$700(VideoStateController.this) % 300 == 0)
        {
            VideoStateController.access$900(VideoStateController.this).trackVideoIncremental(VideoStateController.access$1000(VideoStateController.this), VideoStateController.access$1100(VideoStateController.this), VideoStateController.access$700(VideoStateController.this), 300);
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void mediaWarning(String s, String s1)
    {
        VideoStateController.access$500(VideoStateController.this).onMediaWarning(s, s1);
    }

    public void numberOfAlternativeAudioStreamsChanged(int i)
    {
        VideoStateController.access$500(VideoStateController.this).onNumberOfAlternativeAudioStreamsChanged(i);
    }

    public void offlineDRMComplete(String s, Date date, Date date1, String s1)
    {
        VideoStateController.access$500(VideoStateController.this).onOfflineDRMComplete(s, date, date1, s1);
    }

    public void offlineDRMFailure(String s, String s1)
    {
        VideoStateController.access$500(VideoStateController.this).onOfflineDRMFailure(s, s1);
    }

    public void onBufferComplete()
    {
        VideoStateController.access$500(VideoStateController.this).onBufferComplete();
    }

    public void onBufferStart()
    {
        VideoStateController.access$500(VideoStateController.this).onBufferStart();
    }

    public void onPlayStarted()
    {
        if (!VideoStateController.access$1200(VideoStateController.this))
        {
            VideoStateController.access$1202(VideoStateController.this, true);
            com.comcast.cim.analytics.VideoPlaybackEventData videoplaybackeventdata = getVideoPlaybackEventData("VIDEO_START");
            getSplunker().logData(videoplaybackeventdata);
        }
    }

    public void onSeekComplete(long l)
    {
        getUiController().eking(Boolean.valueOf(false));
        VideoStateController.access$500(VideoStateController.this).onVideoSeekComplete();
    }

    public void onSeekStart()
    {
        VideoStateController.access$500(VideoStateController.this).onVideoSeekStart();
    }

    public void onTimelineUpdated()
    {
        VideoStateController.access$500(VideoStateController.this).onTimelineUpdated();
    }

    public void playStateChanged(PlayerStatus playerstatus)
    {
        VideoStateController.access$100().warn((new StringBuilder()).append("NEW PLAYER STATE: ").append(playerstatus).toString());
        VideoStateController.access$500(VideoStateController.this).onPlayStateChanged(playerstatus);
    }

    public void playbackSpeedChanged(float f)
    {
        VideoStateController.access$500(VideoStateController.this).onPlaybackSpeedChanged(f);
    }

    private ()
    {
        this$0 = VideoStateController.this;
        super();
    }

    it>(it> it>)
    {
        this();
    }
}
