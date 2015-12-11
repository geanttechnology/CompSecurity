.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;
.super Ljava/lang/Object;
.source "DestroyedState.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 34
    return-void
.end method


# virtual methods
.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 353
    return-void
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 348
    return-void
.end method

.method public adComplete(J)V
    .locals 0
    .param p1, "id"    # J

    .prologue
    .line 368
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "progress"    # I
    .param p4, "timeRemaining"    # J

    .prologue
    .line 363
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 358
    return-void
.end method

.method public emergencyAlertCompleted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 263
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 273
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 268
    return-void
.end method

.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onAMSContinueException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 418
    return-void
.end method

.method public onAcquiringLicense(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;

    .prologue
    .line 338
    return-void
.end method

.method public onActivityPaused()V
    .locals 0

    .prologue
    .line 403
    return-void
.end method

.method public onActivityResumed()V
    .locals 0

    .prologue
    .line 408
    return-void
.end method

.method public onAmsAuthenticationException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 198
    return-void
.end method

.method public onAmsAuthenticationSuccess()V
    .locals 0

    .prologue
    .line 203
    return-void
.end method

.method public onAmsPinRequired()V
    .locals 0

    .prologue
    .line 193
    return-void
.end method

.method public onBabyGuideButton()V
    .locals 0

    .prologue
    .line 73
    return-void
.end method

.method public onBackButton()V
    .locals 0

    .prologue
    .line 123
    return-void
.end method

.method public onBitrateChanged(JLjava/lang/String;II)V
    .locals 0
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # I
    .param p5, "videoWidth"    # I

    .prologue
    .line 228
    return-void
.end method

.method public onBufferComplete()V
    .locals 0

    .prologue
    .line 238
    return-void
.end method

.method public onBufferStart()V
    .locals 0

    .prologue
    .line 233
    return-void
.end method

.method public onCCButton()V
    .locals 0

    .prologue
    .line 63
    return-void
.end method

.method public onConfigurationLoaded()V
    .locals 0

    .prologue
    .line 168
    return-void
.end method

.method public onConnectivityChanged()V
    .locals 0

    .prologue
    .line 383
    return-void
.end method

.method public onDrmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 343
    return-void
.end method

.method public onDrmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 0
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "drmMetadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 323
    return-void
.end method

.method public onDroppedFPSChanged(J)V
    .locals 0
    .param p1, "droppedFPS"    # J

    .prologue
    .line 253
    return-void
.end method

.method public onDurationChanged(J)V
    .locals 0
    .param p1, "duration"    # J

    .prologue
    .line 258
    return-void
.end method

.method public onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 0
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 118
    return-void
.end method

.method public onFavoritesButton()V
    .locals 0

    .prologue
    .line 83
    return-void
.end method

.method public onFpsChanged(J)V
    .locals 0
    .param p1, "FPS"    # J

    .prologue
    .line 278
    return-void
.end method

.method public onFragmentDestroyed()V
    .locals 0

    .prologue
    .line 413
    return-void
.end method

.method public onHeadsetButtonEvent(I)V
    .locals 0
    .param p1, "keyEventCode"    # I

    .prologue
    .line 393
    return-void
.end method

.method public onHeadsetNoiseDetected()V
    .locals 0

    .prologue
    .line 398
    return-void
.end method

.method public onHistoryButton()V
    .locals 0

    .prologue
    .line 78
    return-void
.end method

.method public onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 113
    return-void
.end method

.method public onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 188
    return-void
.end method

.method public onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 98
    return-void
.end method

.method public onLiveStreamPlaySelected(Ljava/lang/String;)V
    .locals 0
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 103
    return-void
.end method

.method public onMediaEnded()V
    .locals 0

    .prologue
    .line 283
    return-void
.end method

.method public onMediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 288
    return-void
.end method

.method public onMediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJDZ)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "mediaType"    # Ljava/lang/String;
    .param p3, "playbackSpeeds"    # Ljava/util/List;
    .param p4, "availableAudioLanguages"    # Ljava/util/List;
    .param p5, "width"    # J
    .param p7, "height"    # J
    .param p9, "openingLatency"    # D
    .param p11, "hasCC"    # Z

    .prologue
    .line 293
    return-void
.end method

.method public onMediaProgress(JDJJI)V
    .locals 0
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 298
    return-void
.end method

.method public onMediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 303
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 93
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 88
    return-void
.end method

.method public onNumberOfAlternativeAudioStreamsChanged(I)V
    .locals 0
    .param p1, "numberOfAlternativeAudioStreams"    # I

    .prologue
    .line 308
    return-void
.end method

.method public onOfflineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 328
    return-void
.end method

.method public onOfflineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 333
    return-void
.end method

.method public onPauseButton()V
    .locals 0

    .prologue
    .line 133
    return-void
.end method

.method public onPinCanceled()V
    .locals 0

    .prologue
    .line 223
    return-void
.end method

.method public onPlayButton()V
    .locals 0

    .prologue
    .line 128
    return-void
.end method

.method public onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 0
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 318
    return-void
.end method

.method public onPlaybackSpeedChanged(D)V
    .locals 0
    .param p1, "speed"    # D

    .prologue
    .line 313
    return-void
.end method

.method public onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 173
    return-void
.end method

.method public onSAPButton()V
    .locals 0

    .prologue
    .line 68
    return-void
.end method

.method public onScreenTouch()V
    .locals 0

    .prologue
    .line 58
    return-void
.end method

.method public onSeekRequest(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 138
    return-void
.end method

.method public onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 0
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 108
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 0

    .prologue
    .line 163
    return-void
.end method

.method public onUserMovedSeekBar(I)V
    .locals 0
    .param p1, "progress"    # I

    .prologue
    .line 153
    return-void
.end method

.method public onUserSeekEnded(Z)V
    .locals 0
    .param p1, "willSeek"    # Z

    .prologue
    .line 148
    return-void
.end method

.method public onUserSeekStarted()V
    .locals 0

    .prologue
    .line 143
    return-void
.end method

.method public onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 0
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 218
    return-void
.end method

.method public onVideoFetchFailed()V
    .locals 0

    .prologue
    .line 178
    return-void
.end method

.method public onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 183
    return-void
.end method

.method public onVideoSeekComplete()V
    .locals 0

    .prologue
    .line 248
    return-void
.end method

.method public onVideoSeekStart()V
    .locals 0

    .prologue
    .line 243
    return-void
.end method

.method public onVolumeChanged()V
    .locals 0

    .prologue
    .line 158
    return-void
.end method

.method public run()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shutdown()V

    .line 53
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 3
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 42
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Not allowed to transition from DestroyedState.  Attempted transition to {}"

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->getStateName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Object;)V

    .line 43
    return-void
.end method
