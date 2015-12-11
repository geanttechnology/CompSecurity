.class public interface abstract Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
.super Ljava/lang/Object;
.source "VideoState.java"


# virtual methods
.method public abstract adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
.end method

.method public abstract adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
.end method

.method public abstract adComplete(J)V
.end method

.method public abstract adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
.end method

.method public abstract adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
.end method

.method public abstract emergencyAlertCompleted(Ljava/lang/String;)V
.end method

.method public abstract emergencyAlertFailed(Ljava/lang/String;)V
.end method

.method public abstract emergencyAlertStarted(Ljava/lang/String;)V
.end method

.method public abstract getStateName()Ljava/lang/String;
.end method

.method public abstract onAMSContinueException(Ljava/lang/Exception;)V
.end method

.method public abstract onAcquiringLicense(Ljava/lang/String;)V
.end method

.method public abstract onActivityPaused()V
.end method

.method public abstract onActivityResumed()V
.end method

.method public abstract onAmsAuthenticationException(Ljava/lang/Exception;)V
.end method

.method public abstract onAmsAuthenticationSuccess()V
.end method

.method public abstract onAmsPinRequired()V
.end method

.method public abstract onBabyGuideButton()V
.end method

.method public abstract onBackButton()V
.end method

.method public abstract onBitrateChanged(JLjava/lang/String;II)V
.end method

.method public abstract onBufferComplete()V
.end method

.method public abstract onBufferStart()V
.end method

.method public abstract onCCButton()V
.end method

.method public abstract onConfigurationLoaded()V
.end method

.method public abstract onConnectivityChanged()V
.end method

.method public abstract onDrmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
.end method

.method public abstract onDrmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
.end method

.method public abstract onDroppedFPSChanged(J)V
.end method

.method public abstract onDurationChanged(J)V
.end method

.method public abstract onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V
.end method

.method public abstract onFavoritesButton()V
.end method

.method public abstract onFpsChanged(J)V
.end method

.method public abstract onFragmentDestroyed()V
.end method

.method public abstract onHeadsetButtonEvent(I)V
.end method

.method public abstract onHeadsetNoiseDetected()V
.end method

.method public abstract onHistoryButton()V
.end method

.method public abstract onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
.end method

.method public abstract onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
.end method

.method public abstract onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
.end method

.method public abstract onLiveStreamPlaySelected(Ljava/lang/String;)V
.end method

.method public abstract onMediaEnded()V
.end method

.method public abstract onMediaFailed(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract onMediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJDZ)V
.end method

.method public abstract onMediaProgress(JDJJI)V
.end method

.method public abstract onMediaWarning(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
.end method

.method public abstract onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
.end method

.method public abstract onNumberOfAlternativeAudioStreamsChanged(I)V
.end method

.method public abstract onOfflineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
.end method

.method public abstract onOfflineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract onPauseButton()V
.end method

.method public abstract onPinCanceled()V
.end method

.method public abstract onPlayButton()V
.end method

.method public abstract onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
.end method

.method public abstract onPlaybackSpeedChanged(D)V
.end method

.method public abstract onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V
.end method

.method public abstract onSAPButton()V
.end method

.method public abstract onScreenTouch()V
.end method

.method public abstract onSeekRequest(J)V
.end method

.method public abstract onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
.end method

.method public abstract onTimelineUpdated()V
.end method

.method public abstract onUserMovedSeekBar(I)V
.end method

.method public abstract onUserSeekEnded(Z)V
.end method

.method public abstract onUserSeekStarted()V
.end method

.method public abstract onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
.end method

.method public abstract onVideoFetchFailed()V
.end method

.method public abstract onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
.end method

.method public abstract onVideoSeekComplete()V
.end method

.method public abstract onVideoSeekStart()V
.end method

.method public abstract onVolumeChanged()V
.end method

.method public abstract run()V
.end method

.method public abstract transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
.end method
