// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.view.SurfaceHolder;
import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.SeriesWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            VideoState, VideoStateController

public class QuitState
    implements VideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/QuitState);
    private VideoStateController stateController;

    public QuitState(VideoStateController videostatecontroller)
    {
        stateController = videostatecontroller;
    }

    public void adBreakComplete(VideoAdBreak videoadbreak)
    {
    }

    public void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad)
    {
    }

    public void adComplete(long l)
    {
    }

    public void adProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l)
    {
    }

    public void adStart(VideoAd videoad)
    {
    }

    public void emergencyAlertCompleted(String s)
    {
    }

    public void emergencyAlertFailed(String s)
    {
    }

    public void emergencyAlertStarted(String s)
    {
    }

    public String getStateName()
    {
        return "QuitState";
    }

    public void onAMSContinueException(Exception exception)
    {
    }

    public void onAcquiringLicense(String s)
    {
    }

    public void onActivityPaused()
    {
    }

    public void onActivityResumed()
    {
    }

    public void onAmsAuthenticationException(Exception exception)
    {
    }

    public void onAmsAuthenticationSuccess()
    {
    }

    public void onAmsPinRequired()
    {
    }

    public void onBabyGuideButton()
    {
    }

    public void onBackButton()
    {
    }

    public void onBitrateChanged(long l, String s, int i, int j)
    {
    }

    public void onBufferComplete()
    {
    }

    public void onBufferStart()
    {
    }

    public void onCCButton()
    {
    }

    public void onConfigurationLoaded()
    {
    }

    public void onConnectivityChanged()
    {
    }

    public void onDrmComplete(String s, Date date, Date date1)
    {
    }

    public void onDrmMetaDataAvailable(DRMManager drmmanager, DRMMetadata drmmetadata)
    {
    }

    public void onDroppedFPSChanged(long l)
    {
    }

    public void onDurationChanged(long l)
    {
    }

    public void onFavoriteItemDetailSelected(VideoFavorite videofavorite)
    {
    }

    public void onFavoritesButton()
    {
    }

    public void onFpsChanged(long l)
    {
    }

    public void onFragmentDestroyed()
    {
    }

    public void onHeadsetButtonEvent(int i)
    {
    }

    public void onHeadsetNoiseDetected()
    {
    }

    public void onHistoryButton()
    {
    }

    public void onHistoryItemDetailSelected(VideoBookmark videobookmark)
    {
    }

    public void onLiveStreamFetched(HalLiveStream hallivestream)
    {
    }

    public void onLiveStreamPlaySelected(HalLiveStream hallivestream)
    {
    }

    public void onLiveStreamPlaySelected(String s)
    {
    }

    public void onMediaEnded()
    {
    }

    public void onMediaFailed(String s, String s1)
    {
    }

    public void onMediaOpened(String s, String s1, List list, List list1, long l, long l1, double d, boolean flag)
    {
    }

    public void onMediaProgress(long l, double d, long l1, long l2, int i)
    {
    }

    public void onMediaWarning(String s, String s1)
    {
    }

    public void onNewVideoPlayOrResumeSelected(VideoBookmark videobookmark)
    {
    }

    public void onNewVideoPlayOrResumeSelected(VideoFacade videofacade, Watchable watchable)
    {
    }

    public void onNumberOfAlternativeAudioStreamsChanged(int i)
    {
    }

    public void onOfflineDRMComplete(String s, Date date, Date date1, String s1)
    {
    }

    public void onOfflineDRMFailure(String s, String s1)
    {
    }

    public void onPauseButton()
    {
    }

    public void onPinCanceled()
    {
    }

    public void onPlayButton()
    {
    }

    public void onPlayStateChanged(PlayerStatus playerstatus)
    {
    }

    public void onPlaybackSpeedChanged(double d)
    {
    }

    public void onPlayerSurfaceCreated(SurfaceHolder surfaceholder)
    {
    }

    public void onSAPButton()
    {
    }

    public void onScreenTouch()
    {
    }

    public void onSeekRequest(long l)
    {
    }

    public void onSeriesWatchableDetailSelected(SeriesWatchable serieswatchable)
    {
    }

    public void onTimelineUpdated()
    {
    }

    public void onUserMovedSeekBar(int i)
    {
    }

    public void onUserSeekEnded(boolean flag)
    {
    }

    public void onUserSeekStarted()
    {
    }

    public void onValidatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
    {
    }

    public void onVideoFetchFailed()
    {
    }

    public void onVideoFetched(VideoFacade videofacade, Watchable watchable)
    {
    }

    public void onVideoSeekComplete()
    {
    }

    public void onVideoSeekStart()
    {
    }

    public void onVolumeChanged()
    {
    }

    public void run()
    {
        stateController.shutdownAndFinishActivity();
    }

    public void transitionToState(VideoState videostate)
    {
        throw new IllegalStateException((new StringBuilder()).append("Not allowed to transition from QuitState.  Attempted transition to ").append(videostate.getStateName()).toString());
    }

}
