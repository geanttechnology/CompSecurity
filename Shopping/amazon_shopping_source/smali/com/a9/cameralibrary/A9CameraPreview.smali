.class public Lcom/a9/cameralibrary/A9CameraPreview;
.super Landroid/view/SurfaceView;
.source "A9CameraPreview.java"

# interfaces
.implements Landroid/hardware/Camera$PreviewCallback;
.implements Landroid/view/SurfaceHolder$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    }
.end annotation


# instance fields
.field private m_camera:Landroid/hardware/Camera;

.field private m_cameraCallbackListener:Lcom/a9/cameralibrary/CameraFrameListener;

.field private m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

.field private m_cameraParameters:Landroid/hardware/Camera$Parameters;

.field private m_cameraSize:Landroid/hardware/Camera$Size;

.field private m_focusMode:Ljava/lang/String;

.field private m_focusing:Z

.field private m_framesTilNextFocus:I

.field private m_holder:Landroid/view/SurfaceHolder;

.field private m_isCameraReleased:Z

.field private m_lastFocus:Ljava/util/Date;

.field private m_maxHeight:I

.field private m_minHeight:I

.field private m_orientation:I

.field private m_previewImageFormat:I

.field private m_roiHeight:I

.field private m_roiWidth:I

.field private m_roiX:I

.field private m_roiY:I

.field private m_screenHeight:I

.field private m_screenWidth:I

.field private m_supportsContinuousFocus:Z

.field private m_surfaceCreatedListener:Lcom/a9/cameralibrary/OnSurfaceCreatedListener;

.field private m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/a9/cameralibrary/CameraFrameListener;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "a_interface"    # Lcom/a9/cameralibrary/CameraFrameListener;

    .prologue
    const/4 v1, -0x1

    .line 82
    invoke-direct {p0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    .line 50
    sget-object v0, Lcom/a9/cameralibrary/CameraOpenMode;->UNKOWN:Lcom/a9/cameralibrary/CameraOpenMode;

    iput-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

    .line 52
    iput v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    .line 53
    const/16 v0, 0x300

    iput v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_maxHeight:I

    .line 55
    const/16 v0, 0x140

    iput v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_minHeight:I

    .line 59
    iput v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_previewImageFormat:I

    .line 63
    const-string/jumbo v0, "auto"

    iput-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_focusMode:Ljava/lang/String;

    .line 70
    iput v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiX:I

    .line 71
    iput v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiY:I

    .line 72
    iput v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    .line 73
    iput v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    .line 83
    iput-object p2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraCallbackListener:Lcom/a9/cameralibrary/CameraFrameListener;

    .line 86
    invoke-virtual {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iput-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_holder:Landroid/view/SurfaceHolder;

    .line 87
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_holder:Landroid/view/SurfaceHolder;

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 89
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_holder:Landroid/view/SurfaceHolder;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 90
    return-void
.end method

.method static synthetic access$000(Lcom/a9/cameralibrary/A9CameraPreview;)Z
    .locals 1
    .param p0, "x0"    # Lcom/a9/cameralibrary/A9CameraPreview;

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_isCameraReleased:Z

    return v0
.end method

.method static synthetic access$102(Lcom/a9/cameralibrary/A9CameraPreview;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/a9/cameralibrary/A9CameraPreview;
    .param p1, "x1"    # Z

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_focusing:Z

    return p1
.end method

.method static synthetic access$202(Lcom/a9/cameralibrary/A9CameraPreview;I)I
    .locals 0
    .param p0, "x0"    # Lcom/a9/cameralibrary/A9CameraPreview;
    .param p1, "x1"    # I

    .prologue
    .line 33
    iput p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_framesTilNextFocus:I

    return p1
.end method

.method static synthetic access$302(Lcom/a9/cameralibrary/A9CameraPreview;Ljava/util/Date;)Ljava/util/Date;
    .locals 0
    .param p0, "x0"    # Lcom/a9/cameralibrary/A9CameraPreview;
    .param p1, "x1"    # Ljava/util/Date;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_lastFocus:Ljava/util/Date;

    return-object p1
.end method

.method static synthetic access$400(Lcom/a9/cameralibrary/A9CameraPreview;)Z
    .locals 1
    .param p0, "x0"    # Lcom/a9/cameralibrary/A9CameraPreview;

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_supportsContinuousFocus:Z

    return v0
.end method

.method static synthetic access$500(Lcom/a9/cameralibrary/A9CameraPreview;)Landroid/hardware/Camera;
    .locals 1
    .param p0, "x0"    # Lcom/a9/cameralibrary/A9CameraPreview;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    return-object v0
.end method

.method static synthetic access$600(Lcom/a9/cameralibrary/A9CameraPreview;)V
    .locals 0
    .param p0, "x0"    # Lcom/a9/cameralibrary/A9CameraPreview;

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->setFocusArea()V

    return-void
.end method

.method private calcRoiCoordinates()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 353
    const-wide/16 v0, 0x0

    .line 354
    .local v0, "heightRatio":D
    const-wide/16 v2, 0x0

    .line 356
    .local v2, "widthRatio":D
    iget v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    rem-int/lit16 v4, v4, 0xb4

    const/16 v5, 0x5a

    if-ne v4, v5, :cond_0

    .line 358
    iget v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenWidth:I

    int-to-double v4, v4

    iget-object v6, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    int-to-double v6, v6

    div-double v0, v4, v6

    .line 359
    iget v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenHeight:I

    int-to-double v4, v4

    iget-object v6, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    int-to-double v6, v6

    div-double v2, v4, v6

    .line 368
    :goto_0
    iput v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiX:I

    .line 369
    iput v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiY:I

    .line 370
    iget-object v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v4, v4, Landroid/hardware/Camera$Size;->width:I

    int-to-double v4, v4

    mul-double/2addr v4, v2

    double-to-int v4, v4

    iput v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    .line 371
    iget-object v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v4, v4, Landroid/hardware/Camera$Size;->height:I

    int-to-double v4, v4

    mul-double/2addr v4, v0

    double-to-int v4, v4

    iput v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    .line 372
    return-void

    .line 362
    :cond_0
    iget v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenHeight:I

    int-to-double v4, v4

    iget-object v6, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->y:I

    int-to-double v6, v6

    div-double v0, v4, v6

    .line 363
    iget v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenWidth:I

    int-to-double v4, v4

    iget-object v6, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v6, v6, Landroid/graphics/Point;->x:I

    int-to-double v6, v6

    div-double v2, v4, v6

    goto :goto_0
.end method

.method private calculateBestPreviewSizeAndAdjustLayout()Landroid/hardware/Camera$Size;
    .locals 25

    .prologue
    .line 427
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    move-object/from16 v21, v0

    if-nez v21, :cond_0

    .line 428
    sget-object v21, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_OBJECT_NULL:Lcom/a9/cameralibrary/CameraErrorReason;

    const-string/jumbo v22, "Camera Object is null while calculating best preview size"

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/a9/cameralibrary/A9CameraPreview;->triggerCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 429
    const/16 v21, 0x0

    .line 527
    :goto_0
    return-object v21

    .line 431
    :cond_0
    const/4 v10, 0x0

    .line 433
    .local v10, "optimalSizeAndRatio":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_holder:Landroid/view/SurfaceHolder;

    move-object/from16 v21, v0

    invoke-interface/range {v21 .. v21}, Landroid/view/SurfaceHolder;->getSurfaceFrame()Landroid/graphics/Rect;

    move-result-object v18

    .line 434
    .local v18, "surfaceSize":Landroid/graphics/Rect;
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-double v0, v0

    move-wide/from16 v21, v0

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-double v0, v0

    move-wide/from16 v23, v0

    div-double v19, v21, v23

    .line 435
    .local v19, "targetRatio":D
    invoke-direct/range {p0 .. p0}, Lcom/a9/cameralibrary/A9CameraPreview;->getOrientation()I

    move-result v5

    .line 436
    .local v5, "currentOrientation":I
    rem-int/lit16 v0, v5, 0xb4

    move/from16 v21, v0

    const/16 v22, 0x5a

    move/from16 v0, v21

    move/from16 v1, v22

    if-ne v0, v1, :cond_2

    .line 438
    const-wide/high16 v21, 0x3ff0000000000000L    # 1.0

    div-double v19, v21, v19

    .line 439
    new-instance v21, Landroid/graphics/Point;

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v22, v0

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v23, v0

    invoke-direct/range {v21 .. v23}, Landroid/graphics/Point;-><init>(II)V

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    .line 443
    :goto_1
    sget v21, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v22, 0xe

    move/from16 v0, v21

    move/from16 v1, v22

    if-lt v0, v1, :cond_3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

    move-object/from16 v21, v0

    sget-object v22, Lcom/a9/cameralibrary/CameraOpenMode;->FIRST_BACK_FACING:Lcom/a9/cameralibrary/CameraOpenMode;

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    if-ne v0, v1, :cond_3

    move-object/from16 v0, p0

    iget v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    move/from16 v21, v0

    const/16 v22, 0x10e

    move/from16 v0, v21

    move/from16 v1, v22

    if-eq v0, v1, :cond_3

    const/4 v3, 0x1

    .line 444
    .local v3, "allowedResize":Z
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewSizes()Ljava/util/List;

    move-result-object v17

    .line 447
    .local v17, "supportedPreviewSizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 448
    .local v4, "cameraSizesAndRatios":Ljava/util/List;, "Ljava/util/List<Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;>;"
    invoke-interface/range {v17 .. v17}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_3
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_4

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/hardware/Camera$Size;

    .line 449
    .local v15, "s":Landroid/hardware/Camera$Size;
    iget v0, v15, Landroid/hardware/Camera$Size;->height:I

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_minHeight:I

    move/from16 v22, v0

    move/from16 v0, v21

    move/from16 v1, v22

    if-lt v0, v1, :cond_1

    iget v0, v15, Landroid/hardware/Camera$Size;->height:I

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_maxHeight:I

    move/from16 v22, v0

    move/from16 v0, v21

    move/from16 v1, v22

    if-gt v0, v1, :cond_1

    .line 452
    iget v0, v15, Landroid/hardware/Camera$Size;->width:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-double v0, v0

    move-wide/from16 v21, v0

    iget v0, v15, Landroid/hardware/Camera$Size;->height:I

    move/from16 v23, v0

    move/from16 v0, v23

    int-to-double v0, v0

    move-wide/from16 v23, v0

    div-double v11, v21, v23

    .line 453
    .local v11, "ratio":D
    new-instance v16, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v15, v11, v12}, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;-><init>(Lcom/a9/cameralibrary/A9CameraPreview;Landroid/hardware/Camera$Size;D)V

    .line 454
    .local v16, "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_3

    .line 525
    .end local v3    # "allowedResize":Z
    .end local v4    # "cameraSizesAndRatios":Ljava/util/List;, "Ljava/util/List<Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;>;"
    .end local v5    # "currentOrientation":I
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v10    # "optimalSizeAndRatio":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    .end local v11    # "ratio":D
    .end local v15    # "s":Landroid/hardware/Camera$Size;
    .end local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    .end local v17    # "supportedPreviewSizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    .end local v18    # "surfaceSize":Landroid/graphics/Rect;
    .end local v19    # "targetRatio":D
    :catch_0
    move-exception v6

    .line 526
    .local v6, "e":Ljava/lang/Exception;
    sget-object v21, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_EXCEPTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v23, "Error while calculating best preview size. Exception = "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/a9/cameralibrary/A9CameraPreview;->triggerCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 527
    const/16 v21, 0x0

    goto/16 :goto_0

    .line 441
    .end local v6    # "e":Ljava/lang/Exception;
    .restart local v5    # "currentOrientation":I
    .restart local v10    # "optimalSizeAndRatio":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    .restart local v18    # "surfaceSize":Landroid/graphics/Rect;
    .restart local v19    # "targetRatio":D
    :cond_2
    :try_start_1
    new-instance v21, Landroid/graphics/Point;

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v22, v0

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v23, v0

    invoke-direct/range {v21 .. v23}, Landroid/graphics/Point;-><init>(II)V

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    goto/16 :goto_1

    .line 443
    :cond_3
    const/4 v3, 0x0

    goto/16 :goto_2

    .line 458
    .restart local v3    # "allowedResize":Z
    .restart local v4    # "cameraSizesAndRatios":Ljava/util/List;, "Ljava/util/List<Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;>;"
    .restart local v7    # "i$":Ljava/util/Iterator;
    .restart local v17    # "supportedPreviewSizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    :cond_4
    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v21

    if-eqz v21, :cond_5

    .line 459
    sget-object v21, Lcom/a9/cameralibrary/CameraErrorReason;->NO_PREVIEW_SIZES_MEET_CONSTRAINTS:Lcom/a9/cameralibrary/CameraErrorReason;

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v23, "There are no available sizes given Min Height = "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_minHeight:I

    move/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string/jumbo v23, " and Max Height = "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_maxHeight:I

    move/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/a9/cameralibrary/A9CameraPreview;->triggerCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 460
    const/16 v21, 0x0

    goto/16 :goto_0

    .line 464
    :cond_5
    new-instance v21, Lcom/a9/cameralibrary/A9CameraPreview$1;

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/a9/cameralibrary/A9CameraPreview$1;-><init>(Lcom/a9/cameralibrary/A9CameraPreview;)V

    move-object/from16 v0, v21

    invoke-static {v4, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 472
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_6
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_7

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;

    .line 473
    .restart local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v21, v0

    sub-double v21, v21, v19

    invoke-static/range {v21 .. v22}, Ljava/lang/Math;->abs(D)D

    move-result-wide v21

    const-wide v23, 0x3f9999999999999aL    # 0.025

    cmpg-double v21, v21, v23

    if-gez v21, :cond_6

    .line 474
    move-object/from16 v10, v16

    .line 478
    .end local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    :cond_7
    if-eqz v10, :cond_8

    .line 479
    iget-object v0, v10, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    move-object/from16 v21, v0

    goto/16 :goto_0

    .line 483
    :cond_8
    if-eqz v3, :cond_e

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_surfaceCreatedListener:Lcom/a9/cameralibrary/OnSurfaceCreatedListener;

    move-object/from16 v21, v0

    if-eqz v21, :cond_e

    .line 485
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_9
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_a

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;

    .line 486
    .restart local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v21, v0

    const-wide v23, 0x3ffc71c71c71c71cL    # 1.7777777777777777

    sub-double v21, v21, v23

    invoke-static/range {v21 .. v22}, Ljava/lang/Math;->abs(D)D

    move-result-wide v21

    const-wide v23, 0x3f9999999999999aL    # 0.025

    cmpg-double v21, v21, v23

    if-gez v21, :cond_9

    .line 487
    move-object/from16 v10, v16

    .line 491
    .end local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    :cond_a
    if-eqz v10, :cond_b

    .line 493
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_surfaceCreatedListener:Lcom/a9/cameralibrary/OnSurfaceCreatedListener;

    move-object/from16 v21, v0

    iget-wide v0, v10, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v22, v0

    move-object/from16 v0, v21

    move-wide/from16 v1, v22

    invoke-interface {v0, v1, v2, v5}, Lcom/a9/cameralibrary/OnSurfaceCreatedListener;->adjustSurfaceSize(DI)Landroid/graphics/Point;

    move-result-object v21

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    .line 494
    iget-object v0, v10, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    move-object/from16 v21, v0

    goto/16 :goto_0

    .line 498
    :cond_b
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_c
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_d

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;

    .line 499
    .restart local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v21, v0

    const-wide v23, 0x3ff5555555555555L    # 1.3333333333333333

    sub-double v21, v21, v23

    invoke-static/range {v21 .. v22}, Ljava/lang/Math;->abs(D)D

    move-result-wide v21

    const-wide v23, 0x3f9999999999999aL    # 0.025

    cmpg-double v21, v21, v23

    if-gez v21, :cond_c

    .line 500
    move-object/from16 v10, v16

    .line 504
    .end local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    :cond_d
    if-eqz v10, :cond_e

    .line 506
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_surfaceCreatedListener:Lcom/a9/cameralibrary/OnSurfaceCreatedListener;

    move-object/from16 v21, v0

    iget-wide v0, v10, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v22, v0

    move-object/from16 v0, v21

    move-wide/from16 v1, v22

    invoke-interface {v0, v1, v2, v5}, Lcom/a9/cameralibrary/OnSurfaceCreatedListener;->adjustSurfaceSize(DI)Landroid/graphics/Point;

    move-result-object v21

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    .line 507
    iget-object v0, v10, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    move-object/from16 v21, v0

    goto/16 :goto_0

    .line 511
    :cond_e
    const-wide v8, 0x7fefffffffffffffL    # Double.MAX_VALUE

    .line 512
    .local v8, "minRatioDifference":D
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_f
    :goto_4
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_10

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;

    .line 513
    .restart local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v21, v0

    sub-double v21, v21, v19

    invoke-static/range {v21 .. v22}, Ljava/lang/Math;->abs(D)D

    move-result-wide v13

    .line 514
    .local v13, "ratioDifference":D
    cmpg-double v21, v13, v8

    if-gez v21, :cond_f

    .line 515
    move-wide v8, v13

    .line 516
    move-object/from16 v10, v16

    goto :goto_4

    .line 520
    .end local v13    # "ratioDifference":D
    .end local v16    # "sr":Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
    :cond_10
    if-eqz v3, :cond_11

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_surfaceCreatedListener:Lcom/a9/cameralibrary/OnSurfaceCreatedListener;

    move-object/from16 v21, v0

    if-eqz v21, :cond_11

    .line 521
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/a9/cameralibrary/A9CameraPreview;->m_surfaceCreatedListener:Lcom/a9/cameralibrary/OnSurfaceCreatedListener;

    move-object/from16 v21, v0

    iget-wide v0, v10, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v22, v0

    move-object/from16 v0, v21

    move-wide/from16 v1, v22

    invoke-interface {v0, v1, v2, v5}, Lcom/a9/cameralibrary/OnSurfaceCreatedListener;->adjustSurfaceSize(DI)Landroid/graphics/Point;

    move-result-object v21

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    .line 524
    :cond_11
    iget-object v0, v10, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    move-object/from16 v21, v0
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method private checkFocus()V
    .locals 4

    .prologue
    .line 538
    iget-boolean v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_supportsContinuousFocus:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_focusing:Z

    if-nez v0, :cond_1

    iget v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_framesTilNextFocus:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_framesTilNextFocus:I

    if-gez v0, :cond_1

    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_lastFocus:Ljava/util/Date;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_lastFocus:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/16 v2, 0xbb8

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 539
    :cond_0
    invoke-direct {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->focus()V

    .line 541
    :cond_1
    return-void
.end method

.method private focus()V
    .locals 3

    .prologue
    .line 544
    iget-boolean v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_isCameraReleased:Z

    if-eqz v1, :cond_0

    .line 585
    :goto_0
    return-void

    .line 548
    :cond_0
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_focusing:Z

    .line 550
    :try_start_0
    iget-boolean v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_supportsContinuousFocus:Z

    if-eqz v1, :cond_1

    .line 551
    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v0

    .line 552
    .local v0, "parameters":Landroid/hardware/Camera$Parameters;
    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_focusMode:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    .line 553
    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v1, v0}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 556
    .end local v0    # "parameters":Landroid/hardware/Camera$Parameters;
    :cond_1
    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    new-instance v2, Lcom/a9/cameralibrary/A9CameraPreview$2;

    invoke-direct {v2, p0}, Lcom/a9/cameralibrary/A9CameraPreview$2;-><init>(Lcom/a9/cameralibrary/A9CameraPreview;)V

    invoke-virtual {v1, v2}, Landroid/hardware/Camera;->autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 582
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private getOrientation()I
    .locals 7

    .prologue
    .line 196
    invoke-virtual {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->getContext()Landroid/content/Context;

    move-result-object v5

    const-string/jumbo v6, "window"

    invoke-virtual {v5, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/WindowManager;

    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 197
    .local v0, "display":Landroid/view/Display;
    invoke-virtual {v0}, Landroid/view/Display;->getRotation()I

    move-result v4

    .line 200
    .local v4, "rotation":I
    packed-switch v4, :pswitch_data_0

    .line 203
    const/16 v3, 0x5a

    .line 204
    .local v3, "orientation":I
    const/4 v1, 0x1

    .line 219
    .local v1, "expectPortrait":Z
    :goto_0
    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v5

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v6

    if-le v5, v6, :cond_1

    const/4 v2, 0x1

    .line 220
    .local v2, "isPortrait":Z
    :goto_1
    if-eq v2, v1, :cond_0

    .line 221
    add-int/lit16 v5, v3, 0x10e

    rem-int/lit16 v3, v5, 0x168

    .line 223
    :cond_0
    return v3

    .line 207
    .end local v1    # "expectPortrait":Z
    .end local v2    # "isPortrait":Z
    .end local v3    # "orientation":I
    :pswitch_0
    const/4 v3, 0x0

    .line 208
    .restart local v3    # "orientation":I
    const/4 v1, 0x0

    .line 209
    .restart local v1    # "expectPortrait":Z
    goto :goto_0

    .line 211
    .end local v1    # "expectPortrait":Z
    .end local v3    # "orientation":I
    :pswitch_1
    const/16 v3, 0x10e

    .line 212
    .restart local v3    # "orientation":I
    const/4 v1, 0x1

    .line 213
    .restart local v1    # "expectPortrait":Z
    goto :goto_0

    .line 215
    .end local v1    # "expectPortrait":Z
    .end local v3    # "orientation":I
    :pswitch_2
    const/16 v3, 0xb4

    .line 216
    .restart local v3    # "orientation":I
    const/4 v1, 0x0

    .restart local v1    # "expectPortrait":Z
    goto :goto_0

    .line 219
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 200
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private setFocusArea()V
    .locals 7

    .prologue
    .line 588
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xe

    if-lt v3, v4, :cond_0

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v3}, Landroid/hardware/Camera$Parameters;->getMaxNumFocusAreas()I

    move-result v3

    if-lez v3, :cond_0

    .line 590
    :try_start_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 591
    .local v1, "areas":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Area;>;"
    new-instance v0, Landroid/graphics/Rect;

    const/16 v3, -0x96

    const/16 v4, -0xfa

    const/16 v5, 0x96

    const/16 v6, 0xfa

    invoke-direct {v0, v3, v4, v5, v6}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 593
    .local v0, "areaRect":Landroid/graphics/Rect;
    new-instance v3, Landroid/hardware/Camera$Area;

    const/16 v4, 0x3e8

    invoke-direct {v3, v0, v4}, Landroid/hardware/Camera$Area;-><init>(Landroid/graphics/Rect;I)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 594
    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v3, v1}, Landroid/hardware/Camera$Parameters;->setFocusAreas(Ljava/util/List;)V

    .line 595
    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    iget-object v4, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v3, v4}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 600
    .end local v0    # "areaRect":Landroid/graphics/Rect;
    .end local v1    # "areas":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Area;>;"
    :cond_0
    :goto_0
    return-void

    .line 596
    :catch_0
    move-exception v2

    .line 597
    .local v2, "e":Ljava/lang/Exception;
    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/hardware/Camera$Parameters;->setFocusAreas(Ljava/util/List;)V

    goto :goto_0
.end method


# virtual methods
.method public callFocus()V
    .locals 1

    .prologue
    .line 532
    iget-boolean v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_focusing:Z

    if-nez v0, :cond_0

    .line 533
    invoke-direct {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->focus()V

    .line 535
    :cond_0
    return-void
.end method

.method public getScreenHeight()F
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 115
    iget v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    sparse-switch v0, :sswitch_data_0

    .line 117
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    int-to-float v1, v1

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/A9CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    iget v0, v0, Landroid/graphics/PointF;->y:F

    .line 123
    :goto_0
    return v0

    .line 119
    :sswitch_0
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v1, v1

    invoke-direct {v0, v2, v1}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/A9CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    iget v0, v0, Landroid/graphics/PointF;->y:F

    goto :goto_0

    .line 121
    :sswitch_1
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    int-to-float v1, v1

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v2, v2

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/A9CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    iget v0, v0, Landroid/graphics/PointF;->y:F

    goto :goto_0

    .line 123
    :sswitch_2
    new-instance v0, Landroid/graphics/PointF;

    invoke-direct {v0, v2, v2}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/A9CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    iget v0, v0, Landroid/graphics/PointF;->y:F

    goto :goto_0

    .line 115
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0xb4 -> :sswitch_2
        0x10e -> :sswitch_0
    .end sparse-switch
.end method

.method public getScreenWidth()F
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 128
    iget v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    sparse-switch v0, :sswitch_data_0

    .line 130
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    int-to-float v1, v1

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/A9CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    iget v0, v0, Landroid/graphics/PointF;->x:F

    .line 136
    :goto_0
    return v0

    .line 132
    :sswitch_0
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v1, v1

    invoke-direct {v0, v2, v1}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/A9CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    iget v0, v0, Landroid/graphics/PointF;->x:F

    goto :goto_0

    .line 134
    :sswitch_1
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    int-to-float v1, v1

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v2, v2

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/A9CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    iget v0, v0, Landroid/graphics/PointF;->x:F

    goto :goto_0

    .line 136
    :sswitch_2
    new-instance v0, Landroid/graphics/PointF;

    invoke-direct {v0, v2, v2}, Landroid/graphics/PointF;-><init>(FF)V

    invoke-virtual {p0, v0}, Lcom/a9/cameralibrary/A9CameraPreview;->translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;

    move-result-object v0

    iget v0, v0, Landroid/graphics/PointF;->x:F

    goto :goto_0

    .line 128
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0xb4 -> :sswitch_2
        0x10e -> :sswitch_0
    .end sparse-switch
.end method

.method public onPreviewFrame([BLandroid/hardware/Camera;)V
    .locals 12
    .param p1, "data"    # [B
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 231
    :try_start_0
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v10

    .line 233
    .local v10, "frame_timestamp":J
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraCallbackListener:Lcom/a9/cameralibrary/CameraFrameListener;

    if-eqz v0, :cond_0

    .line 234
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraCallbackListener:Lcom/a9/cameralibrary/CameraFrameListener;

    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v1, Landroid/hardware/Camera$Size;->height:I

    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v3, v1, Landroid/hardware/Camera$Size;->width:I

    const/4 v4, 0x1

    iget v5, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_previewImageFormat:I

    iget v6, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiX:I

    iget v7, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiY:I

    iget v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    iget v9, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    move-object v1, p1

    invoke-interface/range {v0 .. v11}, Lcom/a9/cameralibrary/CameraFrameListener;->didReceiveFrame([BIIIIIIIIJ)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 241
    :cond_0
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v0, p1}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    .line 243
    .end local v10    # "frame_timestamp":J
    :goto_0
    invoke-direct {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->checkFocus()V

    .line 244
    return-void

    .line 237
    :catch_0
    move-exception v0

    .line 241
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v0, p1}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v1, p1}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    throw v0
.end method

.method public setCamera(Landroid/hardware/Camera;)V
    .locals 0
    .param p1, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    .line 100
    return-void
.end method

.method public setCameraOpenMode(Lcom/a9/cameralibrary/CameraOpenMode;)V
    .locals 0
    .param p1, "a_cameraOpenMode"    # Lcom/a9/cameralibrary/CameraOpenMode;

    .prologue
    .line 111
    iput-object p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraOpenMode:Lcom/a9/cameralibrary/CameraOpenMode;

    .line 112
    return-void
.end method

.method public setIsCameraReleased(Z)V
    .locals 0
    .param p1, "a_isReleased"    # Z

    .prologue
    .line 146
    iput-boolean p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_isCameraReleased:Z

    .line 147
    return-void
.end method

.method public setMaxHeight(I)V
    .locals 0
    .param p1, "a_maxHeight"    # I

    .prologue
    .line 107
    iput p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_maxHeight:I

    .line 108
    return-void
.end method

.method public setMinHeight(I)V
    .locals 0
    .param p1, "a_minHeight"    # I

    .prologue
    .line 103
    iput p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_minHeight:I

    .line 104
    return-void
.end method

.method public setOnSurfaceCreatedListener(Lcom/a9/cameralibrary/OnSurfaceCreatedListener;)V
    .locals 0
    .param p1, "a_listener"    # Lcom/a9/cameralibrary/OnSurfaceCreatedListener;

    .prologue
    .line 150
    iput-object p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_surfaceCreatedListener:Lcom/a9/cameralibrary/OnSurfaceCreatedListener;

    .line 151
    return-void
.end method

.method public setScreenSize(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 344
    iput p1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenWidth:I

    .line 345
    iput p2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenHeight:I

    .line 346
    return-void
.end method

.method protected startPreview()V
    .locals 11
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "InlinedApi"
        }
    .end annotation

    .prologue
    const/16 v10, 0x7530

    .line 253
    :try_start_0
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    iget-object v9, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_holder:Landroid/view/SurfaceHolder;

    invoke-virtual {v8, v9}, Landroid/hardware/Camera;->setPreviewDisplay(Landroid/view/SurfaceHolder;)V

    .line 254
    invoke-direct {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->getOrientation()I

    move-result v8

    iput v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    .line 255
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    iget v9, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    invoke-virtual {v8, v9}, Landroid/hardware/Camera;->setDisplayOrientation(I)V

    .line 256
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v8}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v8

    iput-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    .line 259
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v8}, Landroid/hardware/Camera$Parameters;->getSupportedFocusModes()Ljava/util/List;

    move-result-object v6

    .line 260
    .local v6, "supportedFocusModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v6, :cond_2

    .line 261
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 262
    .local v2, "focusMode":Ljava/lang/String;
    const-string/jumbo v8, "continuous-picture"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 263
    const/4 v8, 0x1

    iput-boolean v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_supportsContinuousFocus:Z

    .line 265
    :cond_1
    const-string/jumbo v8, "macro"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 267
    const-string/jumbo v8, "macro"

    iput-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_focusMode:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 325
    .end local v2    # "focusMode":Ljava/lang/String;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v6    # "supportedFocusModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_0
    move-exception v1

    .line 326
    .local v1, "e":Ljava/lang/Exception;
    sget-object v8, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_EXCEPTION_ERROR:Lcom/a9/cameralibrary/CameraErrorReason;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "Error while calling start preview. Exception = "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {p0, v8, v9}, Lcom/a9/cameralibrary/A9CameraPreview;->triggerCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 328
    .end local v1    # "e":Ljava/lang/Exception;
    :goto_1
    return-void

    .line 271
    .restart local v6    # "supportedFocusModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_2
    :try_start_1
    iget-boolean v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_supportsContinuousFocus:Z

    if-eqz v8, :cond_3

    .line 272
    invoke-direct {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->setFocusArea()V

    .line 273
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    const-string/jumbo v9, "continuous-picture"

    invoke-virtual {v8, v9}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    .line 274
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    iget-object v9, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v8, v9}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 276
    :cond_3
    const/4 v8, 0x0

    iput-boolean v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_focusing:Z

    .line 277
    const/4 v8, 0x0

    iput-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_lastFocus:Ljava/util/Date;

    .line 278
    const/4 v8, 0x0

    iput v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_framesTilNextFocus:I

    .line 283
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v8}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewFpsRange()Ljava/util/List;

    move-result-object v7

    .line 284
    .local v7, "supportedFpsRange":Ljava/util/List;, "Ljava/util/List<[I>;"
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [I

    .line 285
    .local v5, "range":[I
    array-length v8, v5

    const/4 v9, 0x2

    if-ne v8, v9, :cond_4

    const/4 v8, 0x0

    aget v8, v5, v8

    if-ne v8, v10, :cond_4

    const/4 v8, 0x1

    aget v8, v5, v8

    if-ne v8, v10, :cond_4

    .line 286
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    const/4 v9, 0x0

    aget v9, v5, v9

    const/4 v10, 0x1

    aget v10, v5, v10

    invoke-virtual {v8, v9, v10}, Landroid/hardware/Camera$Parameters;->setPreviewFpsRange(II)V

    .line 298
    .end local v5    # "range":[I
    :cond_5
    sget v8, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v9, 0xe

    if-lt v8, v9, :cond_6

    sget-object v8, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string/jumbo v9, "Nexus 4"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 300
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    const/4 v9, 0x1

    invoke-virtual {v8, v9}, Landroid/hardware/Camera$Parameters;->setRecordingHint(Z)V

    .line 303
    :cond_6
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    iget-object v9, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v9, v9, Landroid/hardware/Camera$Size;->width:I

    iget-object v10, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v10, v10, Landroid/hardware/Camera$Size;->height:I

    invoke-virtual {v8, v9, v10}, Landroid/hardware/Camera$Parameters;->setPreviewSize(II)V

    .line 304
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    const/16 v9, 0x11

    invoke-virtual {v8, v9}, Landroid/hardware/Camera$Parameters;->setPreviewFormat(I)V

    .line 308
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    iget-object v9, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v8, v9}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 309
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v8}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v8

    iput-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    .line 310
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v8}, Landroid/hardware/Camera$Parameters;->getPreviewSize()Landroid/hardware/Camera$Size;

    move-result-object v8

    iput-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    .line 311
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v8}, Landroid/hardware/Camera$Parameters;->getPreviewFormat()I

    move-result v8

    iput v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_previewImageFormat:I

    .line 312
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v8}, Landroid/hardware/Camera;->startPreview()V

    .line 313
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v8, p0}, Landroid/hardware/Camera;->setPreviewCallbackWithBuffer(Landroid/hardware/Camera$PreviewCallback;)V

    .line 315
    invoke-direct {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->calcRoiCoordinates()V

    .line 318
    new-instance v4, Landroid/graphics/PixelFormat;

    invoke-direct {v4}, Landroid/graphics/PixelFormat;-><init>()V

    .line 319
    .local v4, "p":Landroid/graphics/PixelFormat;
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v8}, Landroid/hardware/Camera$Parameters;->getPreviewFormat()I

    move-result v8

    invoke-static {v8, v4}, Landroid/graphics/PixelFormat;->getPixelFormatInfo(ILandroid/graphics/PixelFormat;)V

    .line 320
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v8, v8, Landroid/hardware/Camera$Size;->width:I

    iget-object v9, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v9, v9, Landroid/hardware/Camera$Size;->height:I

    mul-int/2addr v8, v9

    iget v9, v4, Landroid/graphics/PixelFormat;->bitsPerPixel:I

    mul-int/2addr v8, v9

    div-int/lit8 v0, v8, 0x8

    .line 323
    .local v0, "bufSize":I
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    new-array v9, v0, [B

    invoke-virtual {v8, v9}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    .line 324
    iget-object v8, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    new-array v9, v0, [B

    invoke-virtual {v8, v9}, Landroid/hardware/Camera;->addCallbackBuffer([B)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1
.end method

.method protected stopPreview()V
    .locals 2

    .prologue
    .line 336
    :try_start_0
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->setPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V

    .line 337
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->stopPreview()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 341
    :goto_0
    return-void

    .line 338
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 0
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 172
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 159
    invoke-direct {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->calculateBestPreviewSizeAndAdjustLayout()Landroid/hardware/Camera$Size;

    move-result-object v0

    iput-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    .line 160
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    if-eqz v0, :cond_0

    .line 161
    invoke-virtual {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->startPreview()V

    .line 163
    :cond_0
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/a9/cameralibrary/A9CameraPreview;->stopPreview()V

    .line 180
    return-void
.end method

.method public torchOff()V
    .locals 2

    .prologue
    .line 634
    :try_start_0
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    const-string/jumbo v1, "off"

    invoke-virtual {v0, v1}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 635
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 639
    :goto_0
    return-void

    .line 636
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public torchOn()V
    .locals 2

    .prologue
    .line 622
    :try_start_0
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    const-string/jumbo v1, "torch"

    invoke-virtual {v0, v1}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 623
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;

    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraParameters:Landroid/hardware/Camera$Parameters;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 627
    :goto_0
    return-void

    .line 624
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;
    .locals 4
    .param p1, "point"    # Landroid/graphics/PointF;

    .prologue
    .line 382
    iget v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    sparse-switch v0, :sswitch_data_0

    .line 384
    new-instance v0, Landroid/graphics/PointF;

    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v1, v1, Landroid/hardware/Camera$Size;->height:I

    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/PointF;->y:F

    sub-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->height:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget v2, p1, Landroid/graphics/PointF;->x:F

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v3, v3, Landroid/hardware/Camera$Size;->width:I

    int-to-float v3, v3

    div-float/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    .line 390
    :goto_0
    return-object v0

    .line 386
    :sswitch_0
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p1, Landroid/graphics/PointF;->y:F

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->height:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->width:I

    int-to-float v2, v2

    iget v3, p1, Landroid/graphics/PointF;->x:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v3, v3, Landroid/hardware/Camera$Size;->width:I

    int-to-float v3, v3

    div-float/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    goto :goto_0

    .line 388
    :sswitch_1
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p1, Landroid/graphics/PointF;->x:F

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->width:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget v2, p1, Landroid/graphics/PointF;->y:F

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v3, v3, Landroid/hardware/Camera$Size;->height:I

    int-to-float v3, v3

    div-float/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    goto :goto_0

    .line 390
    :sswitch_2
    new-instance v0, Landroid/graphics/PointF;

    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v1, v1, Landroid/hardware/Camera$Size;->width:I

    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/PointF;->x:F

    sub-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->width:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->height:I

    int-to-float v2, v2

    iget v3, p1, Landroid/graphics/PointF;->y:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v3, v3, Landroid/hardware/Camera$Size;->height:I

    int-to-float v3, v3

    div-float/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    goto :goto_0

    .line 382
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0xb4 -> :sswitch_2
        0x10e -> :sswitch_0
    .end sparse-switch
.end method

.method public translatePointInPlace(Landroid/graphics/PointF;)V
    .locals 3
    .param p1, "point"    # Landroid/graphics/PointF;

    .prologue
    .line 403
    iget v0, p1, Landroid/graphics/PointF;->x:F

    .line 404
    .local v0, "oldX":F
    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_orientation:I

    sparse-switch v1, :sswitch_data_0

    .line 406
    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/PointF;->y:F

    sub-float/2addr v1, v2

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenWidth:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p1, Landroid/graphics/PointF;->x:F

    .line 407
    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenHeight:I

    int-to-float v1, v1

    mul-float/2addr v1, v0

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p1, Landroid/graphics/PointF;->y:F

    .line 422
    :goto_0
    return-void

    .line 410
    :sswitch_0
    iget v1, p1, Landroid/graphics/PointF;->y:F

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->height:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p1, Landroid/graphics/PointF;->x:F

    .line 411
    iget-object v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v1, v1, Landroid/hardware/Camera$Size;->width:I

    int-to-float v1, v1

    sub-float/2addr v1, v0

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->width:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p1, Landroid/graphics/PointF;->y:F

    goto :goto_0

    .line 414
    :sswitch_1
    iget v1, p1, Landroid/graphics/PointF;->x:F

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenWidth:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p1, Landroid/graphics/PointF;->x:F

    .line 415
    iget v1, p1, Landroid/graphics/PointF;->y:F

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenHeight:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p1, Landroid/graphics/PointF;->y:F

    goto :goto_0

    .line 418
    :sswitch_2
    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/PointF;->x:F

    sub-float/2addr v1, v2

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenWidth:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiWidth:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p1, Landroid/graphics/PointF;->x:F

    .line 419
    iget v1, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/PointF;->y:F

    sub-float/2addr v1, v2

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_screenHeight:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_roiHeight:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p1, Landroid/graphics/PointF;->y:F

    goto :goto_0

    .line 404
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0xb4 -> :sswitch_2
        0x10e -> :sswitch_0
    .end sparse-switch
.end method

.method public triggerCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V
    .locals 1
    .param p1, "a_reason"    # Lcom/a9/cameralibrary/CameraErrorReason;
    .param p2, "a_extraInfo"    # Ljava/lang/String;

    .prologue
    .line 183
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraCallbackListener:Lcom/a9/cameralibrary/CameraFrameListener;

    if-eqz v0, :cond_0

    .line 184
    iget-object v0, p0, Lcom/a9/cameralibrary/A9CameraPreview;->m_cameraCallbackListener:Lcom/a9/cameralibrary/CameraFrameListener;

    invoke-interface {v0, p1, p2}, Lcom/a9/cameralibrary/CameraFrameListener;->cameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 186
    :cond_0
    return-void
.end method
