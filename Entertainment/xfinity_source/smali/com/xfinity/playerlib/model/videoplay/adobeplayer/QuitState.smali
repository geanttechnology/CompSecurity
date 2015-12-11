.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;
.super Ljava/lang/Object;
.source "QuitState.java"

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
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 34
    return-void
.end method


# virtual methods
.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 349
    return-void
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 344
    return-void
.end method

.method public adComplete(J)V
    .locals 0
    .param p1, "id"    # J

    .prologue
    .line 364
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "progress"    # I
    .param p4, "timeRemaining"    # J

    .prologue
    .line 359
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 354
    return-void
.end method

.method public emergencyAlertCompleted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 259
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 269
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 264
    return-void
.end method

.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    const-string v0, "QuitState"

    return-object v0
.end method

.method public onAMSContinueException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 414
    return-void
.end method

.method public onAcquiringLicense(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;

    .prologue
    .line 334
    return-void
.end method

.method public onActivityPaused()V
    .locals 0

    .prologue
    .line 399
    return-void
.end method

.method public onActivityResumed()V
    .locals 0

    .prologue
    .line 404
    return-void
.end method

.method public onAmsAuthenticationException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 194
    return-void
.end method

.method public onAmsAuthenticationSuccess()V
    .locals 0

    .prologue
    .line 199
    return-void
.end method

.method public onAmsPinRequired()V
    .locals 0

    .prologue
    .line 189
    return-void
.end method

.method public onBabyGuideButton()V
    .locals 0

    .prologue
    .line 69
    return-void
.end method

.method public onBackButton()V
    .locals 0

    .prologue
    .line 119
    return-void
.end method

.method public onBitrateChanged(JLjava/lang/String;II)V
    .locals 0
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # I
    .param p5, "videoWidth"    # I

    .prologue
    .line 224
    return-void
.end method

.method public onBufferComplete()V
    .locals 0

    .prologue
    .line 234
    return-void
.end method

.method public onBufferStart()V
    .locals 0

    .prologue
    .line 229
    return-void
.end method

.method public onCCButton()V
    .locals 0

    .prologue
    .line 59
    return-void
.end method

.method public onConfigurationLoaded()V
    .locals 0

    .prologue
    .line 164
    return-void
.end method

.method public onConnectivityChanged()V
    .locals 0

    .prologue
    .line 379
    return-void
.end method

.method public onDrmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 339
    return-void
.end method

.method public onDrmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 0
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "drmMetadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 319
    return-void
.end method

.method public onDroppedFPSChanged(J)V
    .locals 0
    .param p1, "droppedFPS"    # J

    .prologue
    .line 249
    return-void
.end method

.method public onDurationChanged(J)V
    .locals 0
    .param p1, "duration"    # J

    .prologue
    .line 254
    return-void
.end method

.method public onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 0
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 114
    return-void
.end method

.method public onFavoritesButton()V
    .locals 0

    .prologue
    .line 79
    return-void
.end method

.method public onFpsChanged(J)V
    .locals 0
    .param p1, "FPS"    # J

    .prologue
    .line 274
    return-void
.end method

.method public onFragmentDestroyed()V
    .locals 0

    .prologue
    .line 409
    return-void
.end method

.method public onHeadsetButtonEvent(I)V
    .locals 0
    .param p1, "keyEventCode"    # I

    .prologue
    .line 389
    return-void
.end method

.method public onHeadsetNoiseDetected()V
    .locals 0

    .prologue
    .line 394
    return-void
.end method

.method public onHistoryButton()V
    .locals 0

    .prologue
    .line 74
    return-void
.end method

.method public onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 109
    return-void
.end method

.method public onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 184
    return-void
.end method

.method public onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 94
    return-void
.end method

.method public onLiveStreamPlaySelected(Ljava/lang/String;)V
    .locals 0
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 99
    return-void
.end method

.method public onMediaEnded()V
    .locals 0

    .prologue
    .line 279
    return-void
.end method

.method public onMediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 284
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
    .line 289
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
    .line 294
    return-void
.end method

.method public onMediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 299
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 89
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 84
    return-void
.end method

.method public onNumberOfAlternativeAudioStreamsChanged(I)V
    .locals 0
    .param p1, "numberOfAlternativeAudioStreams"    # I

    .prologue
    .line 304
    return-void
.end method

.method public onOfflineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 324
    return-void
.end method

.method public onOfflineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 329
    return-void
.end method

.method public onPauseButton()V
    .locals 0

    .prologue
    .line 129
    return-void
.end method

.method public onPinCanceled()V
    .locals 0

    .prologue
    .line 219
    return-void
.end method

.method public onPlayButton()V
    .locals 0

    .prologue
    .line 124
    return-void
.end method

.method public onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 0
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 314
    return-void
.end method

.method public onPlaybackSpeedChanged(D)V
    .locals 0
    .param p1, "speed"    # D

    .prologue
    .line 309
    return-void
.end method

.method public onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 169
    return-void
.end method

.method public onSAPButton()V
    .locals 0

    .prologue
    .line 64
    return-void
.end method

.method public onScreenTouch()V
    .locals 0

    .prologue
    .line 54
    return-void
.end method

.method public onSeekRequest(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 134
    return-void
.end method

.method public onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 0
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 104
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 0

    .prologue
    .line 159
    return-void
.end method

.method public onUserMovedSeekBar(I)V
    .locals 0
    .param p1, "progress"    # I

    .prologue
    .line 149
    return-void
.end method

.method public onUserSeekEnded(Z)V
    .locals 0
    .param p1, "willSeek"    # Z

    .prologue
    .line 144
    return-void
.end method

.method public onUserSeekStarted()V
    .locals 0

    .prologue
    .line 139
    return-void
.end method

.method public onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 0
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 214
    return-void
.end method

.method public onVideoFetchFailed()V
    .locals 0

    .prologue
    .line 174
    return-void
.end method

.method public onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 179
    return-void
.end method

.method public onVideoSeekComplete()V
    .locals 0

    .prologue
    .line 244
    return-void
.end method

.method public onVideoSeekStart()V
    .locals 0

    .prologue
    .line 239
    return-void
.end method

.method public onVolumeChanged()V
    .locals 0

    .prologue
    .line 154
    return-void
.end method

.method public run()V
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shutdownAndFinishActivity()V

    .line 49
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 3
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 38
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Not allowed to transition from QuitState.  Attempted transition to "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->getStateName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
