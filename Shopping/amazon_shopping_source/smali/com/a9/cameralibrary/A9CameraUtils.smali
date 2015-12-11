.class public Lcom/a9/cameralibrary/A9CameraUtils;
.super Ljava/lang/Object;
.source "A9CameraUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static hasBackFacingCamera()Z
    .locals 4

    .prologue
    .line 12
    new-instance v2, Landroid/hardware/Camera$CameraInfo;

    invoke-direct {v2}, Landroid/hardware/Camera$CameraInfo;-><init>()V

    .line 13
    .local v2, "cameraInfo":Landroid/hardware/Camera$CameraInfo;
    invoke-static {}, Landroid/hardware/Camera;->getNumberOfCameras()I

    move-result v1

    .line 14
    .local v1, "cameraCount":I
    const/4 v0, 0x0

    .local v0, "camIdx":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 15
    invoke-static {v0, v2}, Landroid/hardware/Camera;->getCameraInfo(ILandroid/hardware/Camera$CameraInfo;)V

    .line 16
    iget v3, v2, Landroid/hardware/Camera$CameraInfo;->facing:I

    if-nez v3, :cond_0

    .line 17
    const/4 v3, 0x1

    .line 20
    :goto_1
    return v3

    .line 14
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 20
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public static hasFrontFacingCamera()Z
    .locals 5

    .prologue
    const/4 v3, 0x1

    .line 24
    new-instance v2, Landroid/hardware/Camera$CameraInfo;

    invoke-direct {v2}, Landroid/hardware/Camera$CameraInfo;-><init>()V

    .line 25
    .local v2, "cameraInfo":Landroid/hardware/Camera$CameraInfo;
    invoke-static {}, Landroid/hardware/Camera;->getNumberOfCameras()I

    move-result v1

    .line 26
    .local v1, "cameraCount":I
    const/4 v0, 0x0

    .local v0, "camIdx":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 27
    invoke-static {v0, v2}, Landroid/hardware/Camera;->getCameraInfo(ILandroid/hardware/Camera$CameraInfo;)V

    .line 28
    iget v4, v2, Landroid/hardware/Camera$CameraInfo;->facing:I

    if-ne v4, v3, :cond_0

    .line 32
    :goto_1
    return v3

    .line 26
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 32
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method
