.class public Lcom/amazon/mShop/search/viewit/CameraPreview;
.super Landroid/view/SurfaceView;
.source "CameraPreview.java"

# interfaces
.implements Landroid/hardware/Camera$PreviewCallback;
.implements Landroid/view/SurfaceHolder$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    }
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field private mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

.field protected mCamera:Landroid/hardware/Camera;

.field protected mCameraPreviewSize:Landroid/hardware/Camera$Size;

.field private mHolder:Landroid/view/SurfaceHolder;

.field protected mIsCameraPaused:Z

.field private mIsJustCreated:Z

.field private mMaxHeight:I

.field private mMinHeight:I

.field protected mOrientation:I

.field protected mPreviewImageFormat:I

.field protected mRoiHeight:I

.field protected mRoiWidth:I

.field protected mRoiX:I

.field protected mRoiY:I

.field private m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    const/4 v0, -0x1

    .line 87
    invoke-direct {p0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    .line 36
    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mRoiX:I

    .line 37
    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mRoiY:I

    .line 38
    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mRoiWidth:I

    .line 39
    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mRoiHeight:I

    .line 40
    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mPreviewImageFormat:I

    .line 44
    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mOrientation:I

    .line 45
    const/16 v0, 0x2d0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mMaxHeight:I

    .line 46
    const/16 v0, 0x140

    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mMinHeight:I

    .line 50
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mIsCameraPaused:Z

    .line 51
    iput-boolean v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mIsJustCreated:Z

    .line 54
    new-instance v0, Lcom/amazon/mShop/search/viewit/CameraPreview$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/CameraPreview$1;-><init>(Lcom/amazon/mShop/search/viewit/CameraPreview;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->handler:Landroid/os/Handler;

    .line 88
    check-cast p1, Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .line 90
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mHolder:Landroid/view/SurfaceHolder;

    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mHolder:Landroid/view/SurfaceHolder;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 96
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/CameraPreview;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/CameraPreview;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->restart()V

    return-void
.end method

.method private calculateBestPreviewSizeAndAdjustLayout(Landroid/hardware/Camera;Landroid/graphics/Rect;III)Landroid/hardware/Camera$Size;
    .locals 24
    .param p1, "camera"    # Landroid/hardware/Camera;
    .param p2, "surfaceSize"    # Landroid/graphics/Rect;
    .param p3, "orientation"    # I
    .param p4, "minHeight"    # I
    .param p5, "maxHeight"    # I

    .prologue
    .line 255
    const/4 v10, 0x0

    .line 256
    .local v10, "optimalSizeAndRatio":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-double v0, v0

    move-wide/from16 v20, v0

    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    div-double v18, v20, v22

    .line 257
    .local v18, "targetRatio":D
    move/from16 v0, p3

    rem-int/lit16 v0, v0, 0xb4

    move/from16 v20, v0

    const/16 v21, 0x5a

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_1

    .line 259
    const-wide/high16 v20, 0x3ff0000000000000L    # 1.0

    div-double v18, v20, v18

    .line 260
    new-instance v20, Landroid/graphics/Point;

    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v21, v0

    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v22, v0

    invoke-direct/range {v20 .. v22}, Landroid/graphics/Point;-><init>(II)V

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    .line 264
    :goto_0
    sget v20, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v21, 0xe

    move/from16 v0, v20

    move/from16 v1, v21

    if-lt v0, v1, :cond_2

    const/16 v20, 0x10e

    move/from16 v0, p3

    move/from16 v1, v20

    if-eq v0, v1, :cond_2

    const/4 v5, 0x1

    .line 265
    .local v5, "allowedResize":Z
    :goto_1
    invoke-virtual/range {p1 .. p1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewSizes()Ljava/util/List;

    move-result-object v17

    .line 268
    .local v17, "supportedPreviewSizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 269
    .local v6, "cameraSizesAndRatios":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;>;"
    invoke-interface/range {v17 .. v17}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/hardware/Camera$Size;

    .line 270
    .local v15, "s":Landroid/hardware/Camera$Size;
    iget v0, v15, Landroid/hardware/Camera$Size;->height:I

    move/from16 v20, v0

    move/from16 v0, v20

    move/from16 v1, p4

    if-lt v0, v1, :cond_0

    iget v0, v15, Landroid/hardware/Camera$Size;->height:I

    move/from16 v20, v0

    move/from16 v0, v20

    move/from16 v1, p5

    if-gt v0, v1, :cond_0

    .line 273
    iget v0, v15, Landroid/hardware/Camera$Size;->width:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-double v0, v0

    move-wide/from16 v20, v0

    iget v0, v15, Landroid/hardware/Camera$Size;->height:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    div-double v11, v20, v22

    .line 274
    .local v11, "ratio":D
    new-instance v16, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v15, v11, v12}, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;-><init>(Lcom/amazon/mShop/search/viewit/CameraPreview;Landroid/hardware/Camera$Size;D)V

    .line 275
    .local v16, "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 262
    .end local v5    # "allowedResize":Z
    .end local v6    # "cameraSizesAndRatios":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;>;"
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v11    # "ratio":D
    .end local v15    # "s":Landroid/hardware/Camera$Size;
    .end local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    .end local v17    # "supportedPreviewSizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    :cond_1
    new-instance v20, Landroid/graphics/Point;

    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v21, v0

    move-object/from16 v0, p2

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    move/from16 v22, v0

    invoke-direct/range {v20 .. v22}, Landroid/graphics/Point;-><init>(II)V

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    goto :goto_0

    .line 264
    :cond_2
    const/4 v5, 0x0

    goto :goto_1

    .line 279
    .restart local v5    # "allowedResize":Z
    .restart local v6    # "cameraSizesAndRatios":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;>;"
    .restart local v7    # "i$":Ljava/util/Iterator;
    .restart local v17    # "supportedPreviewSizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    :cond_3
    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v20

    if-eqz v20, :cond_4

    .line 280
    const/16 v20, 0x0

    .line 345
    :goto_3
    return-object v20

    .line 284
    :cond_4
    new-instance v20, Lcom/amazon/mShop/search/viewit/CameraPreview$2;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/amazon/mShop/search/viewit/CameraPreview$2;-><init>(Lcom/amazon/mShop/search/viewit/CameraPreview;)V

    move-object/from16 v0, v20

    invoke-static {v6, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 292
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_5
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_6

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;

    .line 293
    .restart local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v20, v0

    sub-double v20, v20, v18

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->abs(D)D

    move-result-wide v20

    const-wide v22, 0x3f9999999999999aL    # 0.025

    cmpg-double v20, v20, v22

    if-gez v20, :cond_5

    .line 294
    move-object/from16 v10, v16

    .line 298
    .end local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    :cond_6
    if-eqz v10, :cond_7

    .line 299
    iget-object v0, v10, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    move-object/from16 v20, v0

    goto :goto_3

    .line 303
    :cond_7
    if-eqz v5, :cond_d

    .line 305
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_8
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_9

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;

    .line 306
    .restart local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v20, v0

    const-wide v22, 0x3ffc71c71c71c71cL    # 1.7777777777777777

    sub-double v20, v20, v22

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->abs(D)D

    move-result-wide v20

    const-wide v22, 0x3f9999999999999aL    # 0.025

    cmpg-double v20, v20, v22

    if-gez v20, :cond_8

    .line 307
    move-object/from16 v10, v16

    .line 311
    .end local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    :cond_9
    if-eqz v10, :cond_a

    .line 313
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    move-object/from16 v21, v0

    iget-wide v0, v10, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v22, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-wide/from16 v2, v22

    move/from16 v4, p3

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->adjustSurfaceSize(Lcom/amazon/mShop/search/viewit/FSECameraActivity;DI)Landroid/graphics/Point;

    move-result-object v20

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    .line 314
    iget-object v0, v10, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    move-object/from16 v20, v0

    goto/16 :goto_3

    .line 318
    :cond_a
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_b
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_c

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;

    .line 319
    .restart local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v20, v0

    const-wide v22, 0x3ff5555555555555L    # 1.3333333333333333

    sub-double v20, v20, v22

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->abs(D)D

    move-result-wide v20

    const-wide v22, 0x3f9999999999999aL    # 0.025

    cmpg-double v20, v20, v22

    if-gez v20, :cond_b

    .line 320
    move-object/from16 v10, v16

    .line 324
    .end local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    :cond_c
    if-eqz v10, :cond_d

    .line 326
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    move-object/from16 v21, v0

    iget-wide v0, v10, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v22, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-wide/from16 v2, v22

    move/from16 v4, p3

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->adjustSurfaceSize(Lcom/amazon/mShop/search/viewit/FSECameraActivity;DI)Landroid/graphics/Point;

    move-result-object v20

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    .line 327
    iget-object v0, v10, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    move-object/from16 v20, v0

    goto/16 :goto_3

    .line 332
    :cond_d
    const-wide v8, 0x7fefffffffffffffL    # Double.MAX_VALUE

    .line 333
    .local v8, "minRatioDifference":D
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_e
    :goto_4
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_f

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;

    .line 334
    .restart local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    move-object/from16 v0, v16

    iget-wide v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v20, v0

    sub-double v20, v20, v18

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->abs(D)D

    move-result-wide v13

    .line 335
    .local v13, "ratioDifference":D
    cmpg-double v20, v13, v8

    if-gez v20, :cond_e

    .line 336
    move-wide v8, v13

    .line 337
    move-object/from16 v10, v16

    goto :goto_4

    .line 341
    .end local v13    # "ratioDifference":D
    .end local v16    # "sr":Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    :cond_f
    if-eqz v5, :cond_10

    .line 342
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    move-object/from16 v21, v0

    iget-wide v0, v10, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->ratio:D

    move-wide/from16 v22, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-wide/from16 v2, v22

    move/from16 v4, p3

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->adjustSurfaceSize(Lcom/amazon/mShop/search/viewit/FSECameraActivity;DI)Landroid/graphics/Point;

    move-result-object v20

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    .line 345
    :cond_10
    iget-object v0, v10, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    move-object/from16 v20, v0

    goto/16 :goto_3
.end method

.method private restart()V
    .locals 2

    .prologue
    .line 148
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mIsCameraPaused:Z

    if-nez v0, :cond_0

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    if-nez v0, :cond_1

    .line 158
    :cond_0
    :goto_0
    return-void

    .line 152
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->handler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 154
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->stopPreview()V

    .line 156
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->startPreview()V

    goto :goto_0
.end method

.method private schedRestart()V
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 249
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 250
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->handler:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 252
    :cond_0
    return-void
.end method


# virtual methods
.method public onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 76
    invoke-super {p0}, Landroid/view/SurfaceView;->onDetachedFromWindow()V

    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->handler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 80
    return-void
.end method

.method public onPreviewFrame([BLandroid/hardware/Camera;)V
    .locals 2
    .param p1, "data"    # [B
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 235
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->getOrientation(Landroid/content/Context;)I

    move-result v0

    .line 236
    .local v0, "newOrientation":I
    iget v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mOrientation:I

    if-eq v0, v1, :cond_0

    .line 237
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->schedRestart()V

    .line 239
    :cond_0
    return-void
.end method

.method public setCamera(Landroid/hardware/Camera;)V
    .locals 0
    .param p1, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    .line 104
    return-void
.end method

.method public setIsCameraPaused(Z)V
    .locals 0
    .param p1, "isPaused"    # Z

    .prologue
    .line 107
    iput-boolean p1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mIsCameraPaused:Z

    .line 108
    return-void
.end method

.method public setMaxHeight(I)V
    .locals 0
    .param p1, "maxHeight"    # I

    .prologue
    .line 71
    iput p1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mMaxHeight:I

    .line 72
    return-void
.end method

.method public setMinHeight(I)V
    .locals 0
    .param p1, "minHeight"    # I

    .prologue
    .line 67
    iput p1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mMinHeight:I

    .line 68
    return-void
.end method

.method protected startPreview()V
    .locals 23

    .prologue
    .line 165
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mHolder:Landroid/view/SurfaceHolder;

    invoke-virtual {v1, v2}, Landroid/hardware/Camera;->setPreviewDisplay(Landroid/view/SurfaceHolder;)V

    .line 166
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->getOrientation(Landroid/content/Context;)I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mOrientation:I

    .line 167
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    move-object/from16 v0, p0

    iget v2, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mOrientation:I

    invoke-virtual {v1, v2}, Landroid/hardware/Camera;->setDisplayOrientation(I)V

    .line 169
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v1}, Landroid/view/SurfaceHolder;->getSurfaceFrame()Landroid/graphics/Rect;

    move-result-object v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mOrientation:I

    move-object/from16 v0, p0

    iget v5, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mMinHeight:I

    move-object/from16 v0, p0

    iget v6, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mMaxHeight:I

    move-object/from16 v1, p0

    invoke-direct/range {v1 .. v6}, Lcom/amazon/mShop/search/viewit/CameraPreview;->calculateBestPreviewSizeAndAdjustLayout(Landroid/hardware/Camera;Landroid/graphics/Rect;III)Landroid/hardware/Camera$Size;

    move-result-object v14

    .line 170
    .local v14, "size":Landroid/hardware/Camera$Size;
    if-nez v14, :cond_0

    .line 171
    new-instance v1, Ljava/lang/Exception;

    const-string/jumbo v2, "No no available preview sizes found by continouse-scan."

    invoke-direct {v1, v2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 201
    .end local v14    # "size":Landroid/hardware/Camera$Size;
    :catch_0
    move-exception v7

    .line 202
    .local v7, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "CameraPreview"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Error starting camera preview: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v7}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 204
    .end local v7    # "e":Ljava/lang/Exception;
    :goto_0
    return-void

    .line 174
    .restart local v14    # "size":Landroid/hardware/Camera$Size;
    :cond_0
    :try_start_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    move-object/from16 v0, p0

    invoke-static {v1, v14, v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->setCameraParameters(Landroid/hardware/Camera;Landroid/hardware/Camera$Size;Landroid/hardware/Camera$PreviewCallback;)V

    .line 175
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getPreviewSize()Landroid/hardware/Camera$Size;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    .line 176
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getPreviewFormat()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mPreviewImageFormat:I

    .line 179
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v1}, Landroid/view/SurfaceHolder;->getSurfaceFrame()Landroid/graphics/Rect;

    move-result-object v18

    .line 180
    .local v18, "surfaceSize":Landroid/graphics/Rect;
    move-object/from16 v0, v18

    iget v1, v0, Landroid/graphics/Rect;->bottom:I

    move-object/from16 v0, v18

    iget v2, v0, Landroid/graphics/Rect;->top:I

    sub-int v17, v1, v2

    .line 181
    .local v17, "surfaceHeight":I
    move-object/from16 v0, v18

    iget v1, v0, Landroid/graphics/Rect;->right:I

    move-object/from16 v0, v18

    iget v2, v0, Landroid/graphics/Rect;->left:I

    sub-int v19, v1, v2

    .line 182
    .local v19, "surfaceWidth":I
    move/from16 v0, v19

    int-to-double v1, v0

    move/from16 v0, v17

    int-to-double v3, v0

    div-double v15, v1, v3

    .line 183
    .local v15, "surfaceAspectRatio":D
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v10, v1, Landroid/graphics/Point;->y:I

    .line 184
    .local v10, "newCameraScreenHeight":I
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v11, v1, Landroid/graphics/Point;->x:I

    .line 185
    .local v11, "newCameraScreenWidth":I
    int-to-double v1, v11

    int-to-double v3, v10

    div-double v12, v1, v3

    .line 186
    .local v12, "newScreenAspectRatio":D
    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    cmpg-double v1, v15, v1

    if-gez v1, :cond_1

    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    cmpl-double v1, v12, v1

    if-gtz v1, :cond_2

    :cond_1
    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    cmpl-double v1, v15, v1

    if-lez v1, :cond_3

    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    cmpg-double v1, v12, v1

    if-gez v1, :cond_3

    .line 189
    :cond_2
    move/from16 v20, v17

    .line 190
    .local v20, "tmp":I
    move/from16 v17, v19

    .line 191
    move/from16 v19, v20

    .line 193
    .end local v20    # "tmp":I
    :cond_3
    move/from16 v0, v17

    int-to-double v1, v0

    int-to-double v3, v10

    div-double v8, v1, v3

    .line 194
    .local v8, "heightRatio":D
    move/from16 v0, v19

    int-to-double v1, v0

    int-to-double v3, v11

    div-double v21, v1, v3

    .line 195
    .local v21, "widthRatio":D
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mRoiX:I

    .line 196
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mRoiY:I

    .line 197
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v1, v1, Landroid/hardware/Camera$Size;->width:I

    int-to-double v1, v1

    mul-double v1, v1, v21

    double-to-int v1, v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mRoiWidth:I

    .line 198
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v1, v1, Landroid/hardware/Camera$Size;->height:I

    int-to-double v1, v1

    mul-double/2addr v1, v8

    double-to-int v1, v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mRoiHeight:I

    .line 200
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->startPreview()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method protected stopPreview()V
    .locals 4

    .prologue
    .line 210
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    if-eqz v1, :cond_0

    .line 212
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/hardware/Camera;->setPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 218
    :goto_0
    :try_start_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->stopPreview()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 224
    :cond_0
    :goto_1
    return-void

    .line 213
    :catch_0
    move-exception v0

    .line 215
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "CameraPreview"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Error camera setPreviewCallback: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 219
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 221
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string/jumbo v1, "CameraPreview"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Error camera stopPreview: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 125
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    if-nez v0, :cond_0

    .line 134
    :goto_0
    return-void

    .line 128
    :cond_0
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mIsJustCreated:Z

    if-eqz v0, :cond_1

    .line 129
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mIsJustCreated:Z

    .line 130
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->startPreview()V

    goto :goto_0

    .line 132
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->restart()V

    goto :goto_0
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 116
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mIsJustCreated:Z

    .line 117
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 142
    return-void
.end method

.method public translatePoint(Landroid/graphics/PointF;)Landroid/graphics/PointF;
    .locals 4
    .param p1, "point"    # Landroid/graphics/PointF;

    .prologue
    .line 367
    iget v0, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mOrientation:I

    sparse-switch v0, :sswitch_data_0

    .line 378
    new-instance v0, Landroid/graphics/PointF;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v1, v1, Landroid/hardware/Camera$Size;->height:I

    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/PointF;->y:F

    sub-float/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->height:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget v2, p1, Landroid/graphics/PointF;->x:F

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v3, v3, Landroid/hardware/Camera$Size;->width:I

    int-to-float v3, v3

    div-float/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    :goto_0
    return-object v0

    .line 369
    :sswitch_0
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p1, Landroid/graphics/PointF;->x:F

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->width:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget v2, p1, Landroid/graphics/PointF;->y:F

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v3, v3, Landroid/hardware/Camera$Size;->height:I

    int-to-float v3, v3

    div-float/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    goto :goto_0

    .line 372
    :sswitch_1
    new-instance v0, Landroid/graphics/PointF;

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v1, v1, Landroid/hardware/Camera$Size;->width:I

    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/PointF;->x:F

    sub-float/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->width:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->height:I

    int-to-float v2, v2

    iget v3, p1, Landroid/graphics/PointF;->y:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v3, v3, Landroid/hardware/Camera$Size;->height:I

    int-to-float v3, v3

    div-float/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    goto :goto_0

    .line 375
    :sswitch_2
    new-instance v0, Landroid/graphics/PointF;

    iget v1, p1, Landroid/graphics/PointF;->y:F

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->height:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v2, v2, Landroid/hardware/Camera$Size;->width:I

    int-to-float v2, v2

    iget v3, p1, Landroid/graphics/PointF;->x:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->m_updatedCameraFrameLayoutSize:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview;->mCameraPreviewSize:Landroid/hardware/Camera$Size;

    iget v3, v3, Landroid/hardware/Camera$Size;->width:I

    int-to-float v3, v3

    div-float/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroid/graphics/PointF;-><init>(FF)V

    goto :goto_0

    .line 367
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0xb4 -> :sswitch_1
        0x10e -> :sswitch_2
    .end sparse-switch
.end method
