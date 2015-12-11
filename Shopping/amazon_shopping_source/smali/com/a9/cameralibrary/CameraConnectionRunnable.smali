.class Lcom/a9/cameralibrary/CameraConnectionRunnable;
.super Ljava/lang/Object;
.source "CameraConnectionRunnable.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/cameralibrary/CameraConnectionRunnable$1;
    }
.end annotation


# instance fields
.field private volatile m_camera:Landroid/hardware/Camera;

.field private final m_cameraMode:Lcom/a9/cameralibrary/CameraOpenMode;

.field private volatile m_error:Ljava/lang/Throwable;

.field private final m_latch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method public constructor <init>(Lcom/a9/cameralibrary/CameraOpenMode;)V
    .locals 2
    .param p1, "a_cameraDirection"    # Lcom/a9/cameralibrary/CameraOpenMode;

    .prologue
    const/4 v0, 0x0

    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object v0, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_camera:Landroid/hardware/Camera;

    .line 16
    iput-object v0, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_error:Ljava/lang/Throwable;

    .line 20
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_latch:Ljava/util/concurrent/CountDownLatch;

    .line 21
    iput-object p1, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_cameraMode:Lcom/a9/cameralibrary/CameraOpenMode;

    .line 22
    return-void
.end method


# virtual methods
.method public await(JLjava/util/concurrent/TimeUnit;)V
    .locals 1
    .param p1, "timeout"    # J
    .param p3, "units"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 33
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    .line 34
    return-void
.end method

.method public getCamera()Landroid/hardware/Camera;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_camera:Landroid/hardware/Camera;

    return-object v0
.end method

.method public getError()Ljava/lang/Throwable;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_error:Ljava/lang/Throwable;

    return-object v0
.end method

.method public run()V
    .locals 8

    .prologue
    .line 39
    :try_start_0
    new-instance v3, Landroid/hardware/Camera$CameraInfo;

    invoke-direct {v3}, Landroid/hardware/Camera$CameraInfo;-><init>()V

    .line 41
    .local v3, "cameraInfo":Landroid/hardware/Camera$CameraInfo;
    sget-object v6, Lcom/a9/cameralibrary/CameraConnectionRunnable$1;->$SwitchMap$com$a9$cameralibrary$CameraOpenMode:[I

    iget-object v7, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_cameraMode:Lcom/a9/cameralibrary/CameraOpenMode;

    invoke-virtual {v7}, Lcom/a9/cameralibrary/CameraOpenMode;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 49
    const/4 v1, 0x0

    .line 52
    .local v1, "cameraFacingDirection":I
    :goto_0
    invoke-static {}, Landroid/hardware/Camera;->getNumberOfCameras()I

    move-result v0

    .line 53
    .local v0, "cameraCount":I
    const/4 v2, 0x0

    .line 54
    .local v2, "cameraIndexToOpen":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    if-ge v4, v0, :cond_0

    .line 55
    invoke-static {v4, v3}, Landroid/hardware/Camera;->getCameraInfo(ILandroid/hardware/Camera$CameraInfo;)V

    .line 56
    iget v6, v3, Landroid/hardware/Camera$CameraInfo;->facing:I

    if-ne v6, v1, :cond_1

    .line 57
    move v2, v4

    .line 62
    :cond_0
    invoke-static {v2}, Landroid/hardware/Camera;->open(I)Landroid/hardware/Camera;

    move-result-object v6

    iput-object v6, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_camera:Landroid/hardware/Camera;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 66
    iget-object v6, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v6}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 68
    .end local v0    # "cameraCount":I
    .end local v1    # "cameraFacingDirection":I
    .end local v2    # "cameraIndexToOpen":I
    .end local v3    # "cameraInfo":Landroid/hardware/Camera$CameraInfo;
    .end local v4    # "i":I
    :goto_2
    return-void

    .line 43
    .restart local v3    # "cameraInfo":Landroid/hardware/Camera$CameraInfo;
    :pswitch_0
    const/4 v1, 0x0

    .line 44
    .restart local v1    # "cameraFacingDirection":I
    goto :goto_0

    .line 46
    .end local v1    # "cameraFacingDirection":I
    :pswitch_1
    const/4 v1, 0x1

    .line 47
    .restart local v1    # "cameraFacingDirection":I
    goto :goto_0

    .line 54
    .restart local v0    # "cameraCount":I
    .restart local v2    # "cameraIndexToOpen":I
    .restart local v4    # "i":I
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 63
    .end local v0    # "cameraCount":I
    .end local v1    # "cameraFacingDirection":I
    .end local v2    # "cameraIndexToOpen":I
    .end local v3    # "cameraInfo":Landroid/hardware/Camera$CameraInfo;
    .end local v4    # "i":I
    :catch_0
    move-exception v5

    .line 64
    .local v5, "t":Ljava/lang/Throwable;
    :try_start_1
    iput-object v5, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_error:Ljava/lang/Throwable;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 66
    iget-object v6, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v6}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_2

    .end local v5    # "t":Ljava/lang/Throwable;
    :catchall_0
    move-exception v6

    iget-object v7, p0, Lcom/a9/cameralibrary/CameraConnectionRunnable;->m_latch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v7}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v6

    .line 41
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
