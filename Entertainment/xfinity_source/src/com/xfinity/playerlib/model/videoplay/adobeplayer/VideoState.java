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

public interface VideoState
{

    public abstract void adBreakComplete(VideoAdBreak videoadbreak);

    public abstract void adBreakStart(VideoAdBreak videoadbreak, VideoAd videoad);

    public abstract void adComplete(long l);

    public abstract void adProgress(VideoAdBreak videoadbreak, VideoAd videoad, int i, long l);

    public abstract void adStart(VideoAd videoad);

    public abstract void emergencyAlertCompleted(String s);

    public abstract void emergencyAlertFailed(String s);

    public abstract void emergencyAlertStarted(String s);

    public abstract String getStateName();

    public abstract void onAMSContinueException(Exception exception);

    public abstract void onAcquiringLicense(String s);

    public abstract void onActivityPaused();

    public abstract void onActivityResumed();

    public abstract void onAmsAuthenticationException(Exception exception);

    public abstract void onAmsAuthenticationSuccess();

    public abstract void onAmsPinRequired();

    public abstract void onBabyGuideButton();

    public abstract void onBackButton();

    public abstract void onBitrateChanged(long l, String s, int i, int j);

    public abstract void onBufferComplete();

    public abstract void onBufferStart();

    public abstract void onCCButton();

    public abstract void onConfigurationLoaded();

    public abstract void onConnectivityChanged();

    public abstract void onDrmComplete(String s, Date date, Date date1);

    public abstract void onDrmMetaDataAvailable(DRMManager drmmanager, DRMMetadata drmmetadata);

    public abstract void onDroppedFPSChanged(long l);

    public abstract void onDurationChanged(long l);

    public abstract void onFavoriteItemDetailSelected(VideoFavorite videofavorite);

    public abstract void onFavoritesButton();

    public abstract void onFpsChanged(long l);

    public abstract void onFragmentDestroyed();

    public abstract void onHeadsetButtonEvent(int i);

    public abstract void onHeadsetNoiseDetected();

    public abstract void onHistoryButton();

    public abstract void onHistoryItemDetailSelected(VideoBookmark videobookmark);

    public abstract void onLiveStreamFetched(HalLiveStream hallivestream);

    public abstract void onLiveStreamPlaySelected(HalLiveStream hallivestream);

    public abstract void onLiveStreamPlaySelected(String s);

    public abstract void onMediaEnded();

    public abstract void onMediaFailed(String s, String s1);

    public abstract void onMediaOpened(String s, String s1, List list, List list1, long l, long l1, double d, boolean flag);

    public abstract void onMediaProgress(long l, double d, long l1, long l2, int i);

    public abstract void onMediaWarning(String s, String s1);

    public abstract void onNewVideoPlayOrResumeSelected(VideoBookmark videobookmark);

    public abstract void onNewVideoPlayOrResumeSelected(VideoFacade videofacade, Watchable watchable);

    public abstract void onNumberOfAlternativeAudioStreamsChanged(int i);

    public abstract void onOfflineDRMComplete(String s, Date date, Date date1, String s1);

    public abstract void onOfflineDRMFailure(String s, String s1);

    public abstract void onPauseButton();

    public abstract void onPinCanceled();

    public abstract void onPlayButton();

    public abstract void onPlayStateChanged(PlayerStatus playerstatus);

    public abstract void onPlaybackSpeedChanged(double d);

    public abstract void onPlayerSurfaceCreated(SurfaceHolder surfaceholder);

    public abstract void onSAPButton();

    public abstract void onScreenTouch();

    public abstract void onSeekRequest(long l);

    public abstract void onSeriesWatchableDetailSelected(SeriesWatchable serieswatchable);

    public abstract void onTimelineUpdated();

    public abstract void onUserMovedSeekBar(int i);

    public abstract void onUserSeekEnded(boolean flag);

    public abstract void onUserSeekStarted();

    public abstract void onValidatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener);

    public abstract void onVideoFetchFailed();

    public abstract void onVideoFetched(VideoFacade videofacade, Watchable watchable);

    public abstract void onVideoSeekComplete();

    public abstract void onVideoSeekStart();

    public abstract void onVolumeChanged();

    public abstract void run();

    public abstract void transitionToState(VideoState videostate);
}
