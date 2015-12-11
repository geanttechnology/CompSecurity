.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;
.super Ljava/lang/Object;
.source "ResetPlayerState.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;


# instance fields
.field private keyguardReciever:Landroid/content/BroadcastReceiver;

.field private final previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

.field private final stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "previousState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 32
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 33
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->unregisterKeyguardReceiver()V

    return-void
.end method

.method private declared-synchronized unregisterKeyguardReceiver()V
    .locals 2

    .prologue
    .line 435
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    if-eqz v0, :cond_0

    .line 436
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 437
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->keyguardReciever:Landroid/content/BroadcastReceiver;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 439
    :cond_0
    monitor-exit p0

    return-void

    .line 435
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 357
    return-void
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 352
    return-void
.end method

.method public adComplete(J)V
    .locals 0
    .param p1, "id"    # J

    .prologue
    .line 372
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "progress"    # I
    .param p4, "timeRemaining"    # J

    .prologue
    .line 367
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 362
    return-void
.end method

.method public emergencyAlertCompleted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 267
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 277
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 272
    return-void
.end method

.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    const-string v0, "ResetPlayerState"

    return-object v0
.end method

.method public onAMSContinueException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 449
    return-void
.end method

.method public onAcquiringLicense(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;

    .prologue
    .line 342
    return-void
.end method

.method public onActivityPaused()V
    .locals 0

    .prologue
    .line 407
    return-void
.end method

.method public onActivityResumed()V
    .locals 5

    .prologue
    .line 411
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    instance-of v1, v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    if-eqz v1, :cond_0

    .line 412
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v1

    const-string v2, "keyguard"

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/KeyguardManager;

    .line 413
    .local v0, "keyguardManager":Landroid/app/KeyguardManager;
    invoke-virtual {v0}, Landroid/app/KeyguardManager;->inKeyguardRestrictedInputMode()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 415
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->unregisterKeyguardReceiver()V

    .line 417
    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    .line 427
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    new-instance v3, Landroid/content/IntentFilter;

    const-string v4, "android.intent.action.USER_PRESENT"

    invoke-direct {v3, v4}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 432
    .end local v0    # "keyguardManager":Landroid/app/KeyguardManager;
    :cond_0
    :goto_0
    return-void

    .line 429
    .restart local v0    # "keyguardManager":Landroid/app/KeyguardManager;
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    goto :goto_0
.end method

.method public onAmsAuthenticationException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 202
    return-void
.end method

.method public onAmsAuthenticationSuccess()V
    .locals 0

    .prologue
    .line 207
    return-void
.end method

.method public onAmsPinRequired()V
    .locals 0

    .prologue
    .line 197
    return-void
.end method

.method public onBabyGuideButton()V
    .locals 0

    .prologue
    .line 77
    return-void
.end method

.method public onBackButton()V
    .locals 0

    .prologue
    .line 127
    return-void
.end method

.method public onBitrateChanged(JLjava/lang/String;II)V
    .locals 0
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # I
    .param p5, "videoWidth"    # I

    .prologue
    .line 232
    return-void
.end method

.method public onBufferComplete()V
    .locals 0

    .prologue
    .line 242
    return-void
.end method

.method public onBufferStart()V
    .locals 0

    .prologue
    .line 237
    return-void
.end method

.method public onCCButton()V
    .locals 0

    .prologue
    .line 67
    return-void
.end method

.method public onConfigurationLoaded()V
    .locals 0

    .prologue
    .line 172
    return-void
.end method

.method public onConnectivityChanged()V
    .locals 0

    .prologue
    .line 387
    return-void
.end method

.method public onDrmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 347
    return-void
.end method

.method public onDrmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 0
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "drmMetadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 327
    return-void
.end method

.method public onDroppedFPSChanged(J)V
    .locals 0
    .param p1, "droppedFPS"    # J

    .prologue
    .line 257
    return-void
.end method

.method public onDurationChanged(J)V
    .locals 0
    .param p1, "duration"    # J

    .prologue
    .line 262
    return-void
.end method

.method public onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 0
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 122
    return-void
.end method

.method public onFavoritesButton()V
    .locals 0

    .prologue
    .line 87
    return-void
.end method

.method public onFpsChanged(J)V
    .locals 0
    .param p1, "FPS"    # J

    .prologue
    .line 282
    return-void
.end method

.method public onFragmentDestroyed()V
    .locals 0

    .prologue
    .line 444
    return-void
.end method

.method public onHeadsetButtonEvent(I)V
    .locals 0
    .param p1, "keyEventCode"    # I

    .prologue
    .line 397
    return-void
.end method

.method public onHeadsetNoiseDetected()V
    .locals 0

    .prologue
    .line 402
    return-void
.end method

.method public onHistoryButton()V
    .locals 0

    .prologue
    .line 82
    return-void
.end method

.method public onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 117
    return-void
.end method

.method public onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 192
    return-void
.end method

.method public onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 102
    return-void
.end method

.method public onLiveStreamPlaySelected(Ljava/lang/String;)V
    .locals 0
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 107
    return-void
.end method

.method public onMediaEnded()V
    .locals 0

    .prologue
    .line 287
    return-void
.end method

.method public onMediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 292
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
    .line 297
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
    .line 302
    return-void
.end method

.method public onMediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 307
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 97
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 92
    return-void
.end method

.method public onNumberOfAlternativeAudioStreamsChanged(I)V
    .locals 0
    .param p1, "numberOfAlternativeAudioStreams"    # I

    .prologue
    .line 312
    return-void
.end method

.method public onOfflineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 332
    return-void
.end method

.method public onOfflineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 337
    return-void
.end method

.method public onPauseButton()V
    .locals 0

    .prologue
    .line 137
    return-void
.end method

.method public onPinCanceled()V
    .locals 0

    .prologue
    .line 217
    return-void
.end method

.method public onPlayButton()V
    .locals 0

    .prologue
    .line 132
    return-void
.end method

.method public onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 0
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 322
    return-void
.end method

.method public onPlaybackSpeedChanged(D)V
    .locals 0
    .param p1, "speed"    # D

    .prologue
    .line 317
    return-void
.end method

.method public onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 177
    return-void
.end method

.method public onSAPButton()V
    .locals 0

    .prologue
    .line 72
    return-void
.end method

.method public onScreenTouch()V
    .locals 0

    .prologue
    .line 62
    return-void
.end method

.method public onSeekRequest(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 142
    return-void
.end method

.method public onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 0
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 112
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 0

    .prologue
    .line 167
    return-void
.end method

.method public onUserMovedSeekBar(I)V
    .locals 0
    .param p1, "progress"    # I

    .prologue
    .line 157
    return-void
.end method

.method public onUserSeekEnded(Z)V
    .locals 0
    .param p1, "willSeek"    # Z

    .prologue
    .line 152
    return-void
.end method

.method public onUserSeekStarted()V
    .locals 0

    .prologue
    .line 147
    return-void
.end method

.method public onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 0
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 212
    return-void
.end method

.method public onVideoFetchFailed()V
    .locals 0

    .prologue
    .line 182
    return-void
.end method

.method public onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 187
    return-void
.end method

.method public onVideoSeekComplete()V
    .locals 0

    .prologue
    .line 252
    return-void
.end method

.method public onVideoSeekStart()V
    .locals 0

    .prologue
    .line 247
    return-void
.end method

.method public onVolumeChanged()V
    .locals 0

    .prologue
    .line 162
    return-void
.end method

.method public run()V
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    instance-of v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    if-nez v0, :cond_0

    .line 55
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 57
    :cond_0
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 3
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->unregisterKeyguardReceiver()V

    .line 38
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;

    if-nez v0, :cond_0

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    if-eqz v0, :cond_1

    .line 41
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 45
    return-void

    .line 43
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Illegal State Change: From "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;->getStateName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " to "

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
