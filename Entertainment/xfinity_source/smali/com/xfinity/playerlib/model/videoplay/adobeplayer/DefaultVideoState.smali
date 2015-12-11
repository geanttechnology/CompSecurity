.class public abstract Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.super Ljava/lang/Object;
.source "DefaultVideoState.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 40
    return-void
.end method


# virtual methods
.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 230
    return-void
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 228
    return-void
.end method

.method public adComplete(J)V
    .locals 0
    .param p1, "id"    # J

    .prologue
    .line 236
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "progress"    # I
    .param p4, "timeRemaining"    # J

    .prologue
    .line 234
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 232
    return-void
.end method

.method public emergencyAlertCompleted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 167
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 171
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 169
    return-void
.end method

.method public abstract getStateName()Ljava/lang/String;
.end method

.method protected handleExceptionCaughtDuringAmsOperation(Ljava/lang/Exception;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 6
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "retryState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 271
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    const-string v4, "amsFailure"

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getBasicVideoErrorEventData(Ljava/lang/String;)Lcom/comcast/cim/analytics/VideoErrorEventData;

    move-result-object v0

    .line 272
    .local v0, "amsContinueError":Lcom/comcast/cim/analytics/VideoErrorEventData;
    const-string v3, "AmsException"

    invoke-virtual {v0, v3}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setEventType(Ljava/lang/String;)V

    .line 274
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v2

    .line 275
    .local v2, "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    if-eqz v2, :cond_0

    .line 276
    invoke-virtual {v2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getDescription()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorMessage(Ljava/lang/String;)V

    .line 279
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setErrorTitle(Ljava/lang/String;)V

    .line 280
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getSplunker()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v3

    invoke-interface {v3, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V

    .line 282
    instance-of v3, p1, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    if-eqz v3, :cond_2

    move-object v3, p1

    check-cast v3, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    move-object v1, v3

    .line 283
    .local v1, "amsError":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    :goto_0
    if-eqz v1, :cond_5

    .line 284
    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v3

    const/16 v4, 0x195

    if-eq v3, v4, :cond_1

    .line 285
    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v3

    const/16 v4, 0x197

    if-ne v3, v4, :cond_3

    .line 286
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-static {v4, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;->newUpsellErrorState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/Exception;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 299
    :goto_1
    return-void

    .line 282
    .end local v1    # "amsError":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0

    .line 290
    .restart local v1    # "amsError":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    :cond_3
    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v3

    const/16 v4, 0x451

    if-eq v3, v4, :cond_4

    .line 291
    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getDetailedStatusCode()I

    move-result v3

    const/16 v4, 0x44e

    if-ne v3, v4, :cond_5

    .line 292
    :cond_4
    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->LOG:Lorg/slf4j/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AMS returned "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->getStatusCodeForDisplay()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", resetting player"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 293
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v4, v5, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_1

    .line 298
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v4, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v4, v5, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/Throwable;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_1
.end method

.method public onAMSContinueException(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 266
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->cancelAmsContinueCalls()V

    .line 267
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v0, v1, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->handleExceptionCaughtDuringAmsOperation(Ljava/lang/Exception;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 268
    return-void
.end method

.method public onAcquiringLicense(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;

    .prologue
    .line 224
    return-void
.end method

.method public onActivityPaused()V
    .locals 3

    .prologue
    .line 253
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 254
    return-void
.end method

.method public onActivityResumed()V
    .locals 0

    .prologue
    .line 257
    return-void
.end method

.method public onAmsAuthenticationException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 136
    return-void
.end method

.method public onAmsAuthenticationSuccess()V
    .locals 0

    .prologue
    .line 138
    return-void
.end method

.method public onAmsPinRequired()V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public onBabyGuideButton()V
    .locals 0

    .prologue
    .line 72
    return-void
.end method

.method public onBackButton()V
    .locals 3

    .prologue
    .line 95
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 96
    return-void
.end method

.method public onBitrateChanged(JLjava/lang/String;II)V
    .locals 0
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # I
    .param p5, "videoWidth"    # I

    .prologue
    .line 153
    return-void
.end method

.method public onBufferComplete()V
    .locals 0

    .prologue
    .line 157
    return-void
.end method

.method public onBufferStart()V
    .locals 0

    .prologue
    .line 155
    return-void
.end method

.method public onCCButton()V
    .locals 0

    .prologue
    .line 68
    return-void
.end method

.method public onConfigurationLoaded()V
    .locals 0

    .prologue
    .line 119
    return-void
.end method

.method public onConnectivityChanged()V
    .locals 0

    .prologue
    .line 243
    return-void
.end method

.method public onDrmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 226
    return-void
.end method

.method public onDrmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 0
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "drmMetadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 218
    return-void
.end method

.method public onDroppedFPSChanged(J)V
    .locals 0
    .param p1, "droppedFPS"    # J

    .prologue
    .line 163
    return-void
.end method

.method public onDurationChanged(J)V
    .locals 0
    .param p1, "duration"    # J

    .prologue
    .line 165
    return-void
.end method

.method public onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 0
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 90
    return-void
.end method

.method public onFavoritesButton()V
    .locals 0

    .prologue
    .line 76
    return-void
.end method

.method public onFpsChanged(J)V
    .locals 0
    .param p1, "FPS"    # J

    .prologue
    .line 173
    return-void
.end method

.method public onFragmentDestroyed()V
    .locals 3

    .prologue
    .line 261
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 262
    return-void
.end method

.method public onHeadsetButtonEvent(I)V
    .locals 0
    .param p1, "keyEventCode"    # I

    .prologue
    .line 247
    return-void
.end method

.method public onHeadsetNoiseDetected()V
    .locals 0

    .prologue
    .line 249
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
    .line 88
    return-void
.end method

.method public onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveSteam"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 130
    return-void
.end method

.method public onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 82
    return-void
.end method

.method public onLiveStreamPlaySelected(Ljava/lang/String;)V
    .locals 0
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 84
    return-void
.end method

.method public onMediaEnded()V
    .locals 0

    .prologue
    .line 175
    return-void
.end method

.method public onMediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 179
    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v3

    invoke-direct {v2, p1, p2, v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 180
    .local v2, "platformError":Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;
    sget-object v3, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Media failed. code: %s, description: %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    const/4 v6, 0x1

    aput-object p2, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 183
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformErrorException;->getMajorCode()I

    move-result v3

    const v4, 0x19e13

    if-eq v3, v4, :cond_0

    .line 184
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v1

    .line 186
    .local v1, "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->isFailedOperationRetryable()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 187
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getDescription()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v6, v7, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 191
    .local v0, "errorState":Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;
    :goto_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 193
    .end local v0    # "errorState":Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;
    .end local v1    # "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    :cond_0
    return-void

    .line 189
    .restart local v1    # "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    :cond_1
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getDescription()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v0, v3, v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v0    # "errorState":Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;
    goto :goto_0
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
    .line 196
    return-void
.end method

.method public onMediaProgress(JDJJI)V
    .locals 5
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    const-wide/16 v2, 0x0

    .line 199
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    cmp-long v0, p1, v2

    if-ltz v0, :cond_1

    .line 200
    cmp-long v0, p1, v2

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->hasPreroll()Z

    move-result v0

    if-nez v0, :cond_1

    .line 201
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v2

    invoke-virtual {v0, p1, p2, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->onPlayerProgress(JJ)V

    .line 204
    :cond_1
    return-void
.end method

.method public onMediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 208
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Media warning. code: {}, description: {}"

    invoke-interface {v0, v1, p1, p2}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 209
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 0
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 80
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 78
    return-void
.end method

.method public onNumberOfAlternativeAudioStreamsChanged(I)V
    .locals 0
    .param p1, "numberOfAlternativeAudioStreams"    # I

    .prologue
    .line 212
    return-void
.end method

.method public onOfflineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 220
    return-void
.end method

.method public onOfflineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 222
    return-void
.end method

.method public onPauseButton()V
    .locals 0

    .prologue
    .line 101
    return-void
.end method

.method public onPinCanceled()V
    .locals 0

    .prologue
    .line 142
    return-void
.end method

.method public onPlayButton()V
    .locals 0

    .prologue
    .line 99
    return-void
.end method

.method public onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 0
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 216
    return-void
.end method

.method public onPlaybackSpeedChanged(D)V
    .locals 0
    .param p1, "speed"    # D

    .prologue
    .line 214
    return-void
.end method

.method public onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 122
    return-void
.end method

.method public onSAPButton()V
    .locals 0

    .prologue
    .line 70
    return-void
.end method

.method public onScreenTouch()V
    .locals 0

    .prologue
    .line 66
    return-void
.end method

.method public onSeekRequest(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 103
    return-void
.end method

.method public onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 0
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 86
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 0

    .prologue
    .line 115
    return-void
.end method

.method public onUserMovedSeekBar(I)V
    .locals 0
    .param p1, "progress"    # I

    .prologue
    .line 109
    return-void
.end method

.method public onUserSeekEnded(Z)V
    .locals 0
    .param p1, "willSeek"    # Z

    .prologue
    .line 107
    return-void
.end method

.method public onUserSeekStarted()V
    .locals 0

    .prologue
    .line 105
    return-void
.end method

.method public onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 0
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 140
    return-void
.end method

.method public onVideoFetchFailed()V
    .locals 0

    .prologue
    .line 125
    return-void
.end method

.method public onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 127
    return-void
.end method

.method public onVideoSeekComplete()V
    .locals 0

    .prologue
    .line 161
    return-void
.end method

.method public onVideoSeekStart()V
    .locals 0

    .prologue
    .line 159
    return-void
.end method

.method public onVolumeChanged()V
    .locals 0

    .prologue
    .line 112
    return-void
.end method

.method public run()V
    .locals 0

    .prologue
    .line 62
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 3
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 43
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->getStateName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->getStateName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 44
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Attempted to change to the same state: {}, ignoring"

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->getStateName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 57
    :goto_0
    return-void

    .line 48
    :cond_0
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    if-nez v0, :cond_1

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ResetPlayerState;

    if-nez v0, :cond_1

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    if-nez v0, :cond_1

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    if-nez v0, :cond_1

    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DestroyedState;

    if-eqz v0, :cond_2

    .line 53
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0

    .line 55
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Illegal State Change: From "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->getStateName()Ljava/lang/String;

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
