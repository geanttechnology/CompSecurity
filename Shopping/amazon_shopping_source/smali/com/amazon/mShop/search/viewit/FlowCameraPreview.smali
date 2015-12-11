.class public Lcom/amazon/mShop/search/viewit/FlowCameraPreview;
.super Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;
.source "FlowCameraPreview.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

.field private mFSEGraphicList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/FSEGraphic;",
            ">;"
        }
    .end annotation
.end field

.field private mScanningSuccess:Z

.field private mViewItScreenOverlay:Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;-><init>(Landroid/content/Context;)V

    .line 15
    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mScanningSuccess:Z

    .line 20
    check-cast p1, Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .line 21
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setWillNotDraw(Z)V

    .line 22
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    invoke-direct {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;-><init>(Lcom/amazon/mShop/search/viewit/FSECameraActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mViewItScreenOverlay:Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;

    .line 23
    return-void
.end method


# virtual methods
.method public drawGraphic(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/FSEGraphic;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p1, "graphicList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/FSEGraphic;>;"
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mFSEGraphicList:Ljava/util/List;

    .line 36
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->invalidate()V

    .line 37
    return-void
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 71
    invoke-super {p0, p1}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->onDraw(Landroid/graphics/Canvas;)V

    .line 73
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/SurfaceHolder;->getSurfaceFrame()Landroid/graphics/Rect;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mViewItScreenOverlay:Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mFSEGraphicList:Ljava/util/List;

    iget-boolean v5, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mScanningSuccess:Z

    move-object v2, p1

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->drawScreenOverlay(Lcom/amazon/mShop/search/viewit/FSECameraActivity;Landroid/graphics/Canvas;Ljava/util/List;Lcom/amazon/mShop/search/viewit/CameraPreview;Z)V

    .line 76
    :cond_0
    return-void
.end method

.method public onPreviewFrame([BLandroid/hardware/Camera;)V
    .locals 13
    .param p1, "data"    # [B
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 50
    :try_start_0
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v10

    .line 51
    .local v10, "frameTimestamp":J
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v2, v1, Landroid/hardware/Camera$Size;->height:I

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v3, v1, Landroid/hardware/Camera$Size;->width:I

    const/4 v4, 0x1

    iget v5, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mPreviewImageFormat:I

    const/4 v6, 0x0

    const/4 v7, 0x0

    iget v8, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mRoiWidth:I

    iget v9, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mRoiHeight:I

    move-object v1, p1

    invoke-virtual/range {v0 .. v11}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->didReceiveFrame([BIIIIIIIIJ)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 61
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_1

    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0, p1}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    .line 66
    .end local v10    # "frameTimestamp":J
    :cond_1
    :goto_0
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->onPreviewFrame([BLandroid/hardware/Camera;)V

    .line 67
    return-void

    .line 56
    :catch_0
    move-exception v12

    .line 57
    .local v12, "e":Ljava/lang/Exception;
    :try_start_1
    const-string/jumbo v0, "FlowCameraPreview"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Error receive frame data from camera:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v12}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_1

    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0, p1}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    goto :goto_0

    .line 61
    .end local v12    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mCamera:Landroid/hardware/Camera;

    if-eqz v1, :cond_2

    .line 62
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1, p1}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    :cond_2
    throw v0
.end method

.method public updateSteadyStatus(Z)V
    .locals 1
    .param p1, "status"    # Z

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->mViewItScreenOverlay:Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->setSteadyStatus(Z)V

    .line 27
    return-void
.end method
