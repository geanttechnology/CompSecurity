.class public Lcom/a9/cameralibrary/CameraBgHelper;
.super Ljava/lang/Object;
.source "CameraBgHelper.java"


# instance fields
.field private m_activity:Landroid/app/Activity;

.field private m_camera:Landroid/hardware/Camera;

.field private m_cameraPreviewLayout:Landroid/widget/FrameLayout;

.field private m_cameraThread:Lcom/a9/cameralibrary/DataSourceThread;

.field private m_newCameraPreview:Lcom/a9/cameralibrary/NewCameraPreview;

.field private m_preview:Lcom/a9/cameralibrary/A9CameraPreview;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/a9/cameralibrary/NewCameraPreview;Landroid/widget/FrameLayout;)V
    .locals 0
    .param p1, "a_activity"    # Landroid/app/Activity;
    .param p2, "a_newCameraPreview"    # Lcom/a9/cameralibrary/NewCameraPreview;
    .param p3, "a_cameraPreviewLayout"    # Landroid/widget/FrameLayout;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_activity:Landroid/app/Activity;

    .line 33
    iput-object p2, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_newCameraPreview:Lcom/a9/cameralibrary/NewCameraPreview;

    .line 34
    iput-object p3, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraPreviewLayout:Landroid/widget/FrameLayout;

    .line 35
    return-void
.end method

.method static synthetic access$000(Lcom/a9/cameralibrary/CameraBgHelper;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/a9/cameralibrary/CameraBgHelper;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_activity:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/a9/cameralibrary/CameraBgHelper;)Landroid/widget/FrameLayout;
    .locals 1
    .param p0, "x0"    # Lcom/a9/cameralibrary/CameraBgHelper;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraPreviewLayout:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method private getCameraInstance(Lcom/a9/cameralibrary/CameraOpenMode;)Landroid/hardware/Camera;
    .locals 7
    .param p1, "a_cameraMode"    # Lcom/a9/cameralibrary/CameraOpenMode;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "InlinedApi"
        }
    .end annotation

    .prologue
    .line 131
    const/4 v0, 0x0

    .line 133
    .local v0, "c":Landroid/hardware/Camera;
    new-instance v3, Lcom/a9/cameralibrary/DataSourceThread;

    const-string/jumbo v4, "CameraThread"

    invoke-direct {v3, v4}, Lcom/a9/cameralibrary/DataSourceThread;-><init>(Ljava/lang/String;)V

    iput-object v3, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraThread:Lcom/a9/cameralibrary/DataSourceThread;

    .line 134
    iget-object v3, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraThread:Lcom/a9/cameralibrary/DataSourceThread;

    invoke-virtual {v3}, Lcom/a9/cameralibrary/DataSourceThread;->start()V

    .line 138
    new-instance v1, Lcom/a9/cameralibrary/CameraConnectionRunnable;

    invoke-direct {v1, p1}, Lcom/a9/cameralibrary/CameraConnectionRunnable;-><init>(Lcom/a9/cameralibrary/CameraOpenMode;)V

    .line 139
    .local v1, "connRunnable":Lcom/a9/cameralibrary/CameraConnectionRunnable;
    iget-object v3, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraThread:Lcom/a9/cameralibrary/DataSourceThread;

    invoke-virtual {v3, v1}, Lcom/a9/cameralibrary/DataSourceThread;->runRunnable(Ljava/lang/Runnable;)V

    .line 142
    const-wide/16 v3, 0xf

    :try_start_0
    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v3, v4, v5}, Lcom/a9/cameralibrary/CameraConnectionRunnable;->await(JLjava/util/concurrent/TimeUnit;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 146
    :goto_0
    invoke-virtual {v1}, Lcom/a9/cameralibrary/CameraConnectionRunnable;->getCamera()Landroid/hardware/Camera;

    move-result-object v0

    .line 149
    invoke-virtual {v1}, Lcom/a9/cameralibrary/CameraConnectionRunnable;->getError()Ljava/lang/Throwable;

    move-result-object v2

    .line 150
    .local v2, "error":Ljava/lang/Throwable;
    if-eqz v2, :cond_0

    .line 152
    iget-object v3, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    if-eqz v3, :cond_0

    .line 153
    iget-object v3, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    sget-object v4, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_CONNECTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Error Connecting camera. Error = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/a9/cameralibrary/A9CameraPreview;->triggerCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 157
    :cond_0
    return-object v0

    .line 143
    .end local v2    # "error":Ljava/lang/Throwable;
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method private releaseCamera()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 118
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_camera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->setPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V

    .line 120
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->release()V

    .line 121
    iput-object v1, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_camera:Landroid/hardware/Camera;

    .line 123
    :cond_0
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraThread:Lcom/a9/cameralibrary/DataSourceThread;

    if-eqz v0, :cond_1

    .line 124
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraThread:Lcom/a9/cameralibrary/DataSourceThread;

    invoke-virtual {v0}, Lcom/a9/cameralibrary/DataSourceThread;->shutdown()V

    .line 125
    iput-object v1, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraThread:Lcom/a9/cameralibrary/DataSourceThread;

    .line 127
    :cond_1
    return-void
.end method


# virtual methods
.method public pause()V
    .locals 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/a9/cameralibrary/A9CameraPreview;->setIsCameraReleased(Z)V

    .line 111
    invoke-direct {p0}, Lcom/a9/cameralibrary/CameraBgHelper;->releaseCamera()V

    .line 112
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraPreviewLayout:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 113
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    .line 115
    :cond_0
    return-void
.end method

.method public resume(IIIILcom/a9/cameralibrary/CameraOpenMode;)V
    .locals 2
    .param p1, "a_minHeight"    # I
    .param p2, "a_maxHeight"    # I
    .param p3, "a_screenWidth"    # I
    .param p4, "a_screenHeight"    # I
    .param p5, "a_cameraMode"    # Lcom/a9/cameralibrary/CameraOpenMode;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_newCameraPreview:Lcom/a9/cameralibrary/NewCameraPreview;

    invoke-interface {v0}, Lcom/a9/cameralibrary/NewCameraPreview;->newCameraPreview()Lcom/a9/cameralibrary/A9CameraPreview;

    move-result-object v0

    iput-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    .line 44
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0, p3, p4}, Lcom/a9/cameralibrary/A9CameraPreview;->setScreenSize(II)V

    .line 45
    invoke-direct {p0, p5}, Lcom/a9/cameralibrary/CameraBgHelper;->getCameraInstance(Lcom/a9/cameralibrary/CameraOpenMode;)Landroid/hardware/Camera;

    move-result-object v0

    iput-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_camera:Landroid/hardware/Camera;

    .line 46
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_cameraPreviewLayout:Landroid/widget/FrameLayout;

    iget-object v1, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 47
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0, p5}, Lcom/a9/cameralibrary/A9CameraPreview;->setCameraOpenMode(Lcom/a9/cameralibrary/CameraOpenMode;)V

    .line 48
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0, p1}, Lcom/a9/cameralibrary/A9CameraPreview;->setMinHeight(I)V

    .line 49
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-virtual {v0, p2}, Lcom/a9/cameralibrary/A9CameraPreview;->setMaxHeight(I)V

    .line 50
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    iget-object v1, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v0, v1}, Lcom/a9/cameralibrary/A9CameraPreview;->setCamera(Landroid/hardware/Camera;)V

    .line 51
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/a9/cameralibrary/A9CameraPreview;->setIsCameraReleased(Z)V

    .line 52
    iget-object v0, p0, Lcom/a9/cameralibrary/CameraBgHelper;->m_preview:Lcom/a9/cameralibrary/A9CameraPreview;

    new-instance v1, Lcom/a9/cameralibrary/CameraBgHelper$1;

    invoke-direct {v1, p0}, Lcom/a9/cameralibrary/CameraBgHelper$1;-><init>(Lcom/a9/cameralibrary/CameraBgHelper;)V

    invoke-virtual {v0, v1}, Lcom/a9/cameralibrary/A9CameraPreview;->setOnSurfaceCreatedListener(Lcom/a9/cameralibrary/OnSurfaceCreatedListener;)V

    .line 106
    return-void
.end method
