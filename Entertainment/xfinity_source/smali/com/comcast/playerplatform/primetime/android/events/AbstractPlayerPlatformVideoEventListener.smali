.class public abstract Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
.super Ljava/lang/Object;
.source "AbstractPlayerPlatformVideoEventListener.java"

# interfaces
.implements Ljava/util/EventListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public acquiringLicense(Ljava/lang/String;)V
    .locals 0
    .param p1, "asset"    # Ljava/lang/String;

    .prologue
    .line 192
    return-void
.end method

.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 221
    return-void
.end method

.method public adBreakExited(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 233
    return-void
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 215
    return-void
.end method

.method public adComplete(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 255
    return-void
.end method

.method public adExited(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 227
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 0
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "percentComplete"    # I
    .param p4, "timeToComplete"    # J

    .prologue
    .line 249
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 0
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 240
    return-void
.end method

.method public bitrateChanged(JLjava/lang/String;JJ)V
    .locals 0
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # J
    .param p6, "videoWidth"    # J

    .prologue
    .line 31
    return-void
.end method

.method public drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 0
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 200
    return-void
.end method

.method public drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "e"    # Ljava/lang/Exception;

    .prologue
    .line 208
    return-void
.end method

.method public drmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 0
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "drmMetadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 170
    return-void
.end method

.method public droppedFPSChanged(J)V
    .locals 0
    .param p1, "droppedFPS"    # J

    .prologue
    .line 47
    return-void
.end method

.method public durationChanged(J)V
    .locals 0
    .param p1, "duration"    # J

    .prologue
    .line 53
    return-void
.end method

.method public emergencyAlertCompleted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 72
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "errorCode"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 60
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 66
    return-void
.end method

.method public fpsChanged(J)V
    .locals 0
    .param p1, "FPS"    # J

    .prologue
    .line 78
    return-void
.end method

.method public fragmentWarning(JJJLjava/lang/String;)V
    .locals 0
    .param p1, "downloadDuration"    # J
    .param p3, "fragmentDuration"    # J
    .param p5, "fragmentSize"    # J
    .param p7, "url"    # Ljava/lang/String;

    .prologue
    .line 312
    return-void
.end method

.method public mediaEnded()V
    .locals 0

    .prologue
    .line 83
    return-void
.end method

.method public mediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 96
    return-void
.end method

.method public mediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "mediaType"    # Ljava/lang/String;
    .param p6, "width"    # J
    .param p8, "height"    # J
    .param p10, "duration"    # J
    .param p12, "openingLatency"    # D
    .param p14, "hasCC"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;",
            ">;JJJDZ)V"
        }
    .end annotation

    .prologue
    .line 122
    .local p3, "playbackSpeeds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p4, "availableAudioLanguages":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;>;"
    .local p5, "availableClosedCaptionTracks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;>;"
    return-void
.end method

.method public mediaProgress(JDJJI)V
    .locals 0
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 137
    return-void
.end method

.method public mediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 144
    return-void
.end method

.method public numberOfAlternativeAudioStreamsChanged(I)V
    .locals 0
    .param p1, "numberOfAlternativeAudioStreams"    # I

    .prologue
    .line 150
    return-void
.end method

.method public offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 0
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 179
    return-void
.end method

.method public offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 186
    return-void
.end method

.method public onBufferComplete()V
    .locals 0

    .prologue
    .line 41
    return-void
.end method

.method public onBufferStart()V
    .locals 0

    .prologue
    .line 36
    return-void
.end method

.method public onPlayStarted()V
    .locals 0

    .prologue
    .line 287
    return-void
.end method

.method public onSeekComplete(J)V
    .locals 0
    .param p1, "position"    # J

    .prologue
    .line 282
    return-void
.end method

.method public onSeekStart()V
    .locals 0

    .prologue
    .line 275
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 0

    .prologue
    .line 301
    return-void
.end method

.method public playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 0
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 163
    return-void
.end method

.method public playbackSpeedChanged(F)V
    .locals 0
    .param p1, "speed"    # F

    .prologue
    .line 156
    return-void
.end method

.method public retryAttempted(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "retryCount"    # I

    .prologue
    .line 296
    return-void
.end method
