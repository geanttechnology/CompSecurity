.class public Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
.super Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;
.source "PlayerEventManager.java"


# instance fields
.field listeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;-><init>()V

    .line 25
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public acquiringLicense(Ljava/lang/String;)V
    .locals 2
    .param p1, "asset"    # Ljava/lang/String;

    .prologue
    .line 340
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$22;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$22;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 350
    return-void
.end method

.method public adBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 2
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 396
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$26;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$26;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 406
    return-void
.end method

.method public adBreakExited(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 2
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 424
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$28;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$28;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 434
    return-void
.end method

.method public adBreakStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 2
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 382
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$25;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$25;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 392
    return-void
.end method

.method public adComplete(Ljava/lang/String;)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 466
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$31;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$31;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 476
    return-void
.end method

.method public adExited(Ljava/lang/String;)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 410
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$27;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$27;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 420
    return-void
.end method

.method public adProgress(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V
    .locals 8
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    .param p2, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    .param p3, "progress"    # I
    .param p4, "timeRemaining"    # J

    .prologue
    .line 452
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;

    move-object v2, p0

    move-object v3, p1

    move-object v4, p2

    move v5, p3

    move-wide v6, p4

    invoke-direct/range {v1 .. v7}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$30;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;IJ)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 462
    return-void
.end method

.method public adStart(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V
    .locals 2
    .param p1, "ad"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    .prologue
    .line 438
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$29;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$29;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 448
    return-void
.end method

.method public declared-synchronized addListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 28
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 29
    monitor-exit p0

    return-void

    .line 28
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public bitrateChanged(JLjava/lang/String;JJ)V
    .locals 10
    .param p1, "bitrate"    # J
    .param p3, "changeReason"    # Ljava/lang/String;
    .param p4, "videoHeight"    # J
    .param p6, "videoWidth"    # J

    .prologue
    .line 45
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;

    move-object v2, p0

    move-wide v3, p1

    move-object v5, p3

    move-wide v6, p4

    move-wide/from16 v8, p6

    invoke-direct/range {v1 .. v9}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$1;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;JLjava/lang/String;JJ)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 55
    return-void
.end method

.method public declared-synchronized clearListeners()V
    .locals 1

    .prologue
    .line 36
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 37
    monitor-exit p0

    return-void

    .line 36
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public drmComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V
    .locals 2
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;

    .prologue
    .line 354
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$23;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 364
    return-void
.end method

.method public drmFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 7
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "e"    # Ljava/lang/Exception;

    .prologue
    .line 368
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v6

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$24;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$24;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    invoke-virtual {v6, v0}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 378
    return-void
.end method

.method public drmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V
    .locals 2
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .param p2, "drmMetadata"    # Lcom/adobe/ave/drm/DRMMetadata;

    .prologue
    .line 298
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$19;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$19;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 308
    return-void
.end method

.method public droppedFPSChanged(J)V
    .locals 3
    .param p1, "droppedFPS"    # J

    .prologue
    .line 87
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$4;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;J)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 97
    return-void
.end method

.method public durationChanged(J)V
    .locals 3
    .param p1, "duration"    # J

    .prologue
    .line 101
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$5;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$5;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;J)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 111
    return-void
.end method

.method public emergencyAlertCompleted(Ljava/lang/String;)V
    .locals 2
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 144
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$8;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$8;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 154
    return-void
.end method

.method public emergencyAlertFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 115
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$6;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$6;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 125
    return-void
.end method

.method public emergencyAlertStarted(Ljava/lang/String;)V
    .locals 2
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 129
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$7;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$7;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 140
    return-void
.end method

.method public fpsChanged(J)V
    .locals 3
    .param p1, "FPS"    # J

    .prologue
    .line 158
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$9;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$9;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;J)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 168
    return-void
.end method

.method public fragmentWarning(JJJLjava/lang/String;)V
    .locals 11
    .param p1, "downloadDuration"    # J
    .param p3, "fragmentDuration"    # J
    .param p5, "fragmentSize"    # J
    .param p7, "url"    # Ljava/lang/String;

    .prologue
    .line 578
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v9

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;

    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    move-wide/from16 v6, p5

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$39;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;JJJLjava/lang/String;)V

    invoke-virtual {v9, v0}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 588
    return-void
.end method

.method public mediaEnded()V
    .locals 2

    .prologue
    .line 172
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$10;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$10;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 182
    return-void
.end method

.method public mediaFailed(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 200
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$12;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$12;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 210
    return-void
.end method

.method public mediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V
    .locals 18
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
    .line 214
    .local p3, "playbackSpeeds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p4, "availableAudioLanguages":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;>;"
    .local p5, "availableClosedCaptionTracks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;>;"
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v6, p4

    move-object/from16 v7, p5

    move-wide/from16 v8, p6

    move-wide/from16 v10, p8

    move-wide/from16 v12, p10

    move-wide/from16 v14, p12

    move/from16 v16, p14

    invoke-direct/range {v1 .. v16}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$13;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 224
    return-void
.end method

.method public mediaProgress(JDJJI)V
    .locals 13
    .param p1, "position"    # J
    .param p3, "playbackSpeed"    # D
    .param p5, "startPosition"    # J
    .param p7, "endPosition"    # J
    .param p9, "updateInterval"    # I

    .prologue
    .line 228
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v11

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;

    move-object v1, p0

    move-wide v2, p1

    move-wide/from16 v4, p3

    move-wide/from16 v6, p5

    move-wide/from16 v8, p7

    move/from16 v10, p9

    invoke-direct/range {v0 .. v10}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$14;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;JDJJI)V

    invoke-virtual {v11, v0}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 238
    return-void
.end method

.method public mediaWarning(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 242
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$15;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$15;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 252
    return-void
.end method

.method public numberOfAlternativeAudioStreamsChanged(I)V
    .locals 2
    .param p1, "numberOfAlternativeAudioStreams"    # I

    .prologue
    .line 256
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$16;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$16;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;I)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 266
    return-void
.end method

.method public offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 7
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 312
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v6

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$20;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 322
    return-void
.end method

.method public offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 326
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$21;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$21;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 336
    return-void
.end method

.method public onBufferComplete()V
    .locals 2

    .prologue
    .line 73
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$3;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$3;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 83
    return-void
.end method

.method public onBufferStart()V
    .locals 2

    .prologue
    .line 59
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$2;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$2;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 69
    return-void
.end method

.method public onPlayStarted()V
    .locals 2

    .prologue
    .line 536
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$36;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$36;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 546
    return-void
.end method

.method public onSeekComplete(J)V
    .locals 3
    .param p1, "position"    # J

    .prologue
    .line 522
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$35;

    invoke-direct {v1, p0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$35;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;J)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 532
    return-void
.end method

.method public onSeekStart()V
    .locals 2

    .prologue
    .line 508
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$34;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$34;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 518
    return-void
.end method

.method public onTimelineUpdated()V
    .locals 2

    .prologue
    .line 564
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$38;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$38;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 574
    return-void
.end method

.method public playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 2
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 284
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$18;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$18;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 294
    return-void
.end method

.method public playbackSpeedChanged(F)V
    .locals 2
    .param p1, "speed"    # F

    .prologue
    .line 270
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$17;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$17;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;F)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 280
    return-void
.end method

.method public declared-synchronized removeListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 40
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 41
    monitor-exit p0

    return-void

    .line 40
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public retryAttempted(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 2
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "retryCount"    # I

    .prologue
    .line 550
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager$37;-><init>(Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 560
    return-void
.end method
