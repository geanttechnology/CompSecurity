.class public Lcom/amazon/mShop/search/viewit/CameraBgHelper;
.super Ljava/lang/Object;
.source "CameraBgHelper.java"


# static fields
.field public static sCameraSyncObject:Ljava/lang/Object;


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

.field private mCamera:Landroid/hardware/Camera;

.field private mCameraScreenMarginLeft:I

.field private mCameraThread:Lcom/amazon/mShop/search/viewit/CameraThread;

.field private mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

.field private mPreviewLayout:Landroid/widget/FrameLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->sCameraSyncObject:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/search/viewit/FSECameraActivity;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    .line 44
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraScreenMarginLeft:I

    .line 50
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .line 51
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getCameraFrameLayout()Landroid/widget/FrameLayout;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreviewLayout:Landroid/widget/FrameLayout;

    .line 52
    return-void
.end method

.method public static getActivityOrientation(Lcom/amazon/mShop/AmazonActivity;)I
    .locals 2
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 305
    const/4 v0, 0x1

    .line 306
    .local v0, "activityOrientation":I
    invoke-static {p0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->getOrientation(Landroid/content/Context;)I

    move-result v1

    .line 307
    .local v1, "rotation":I
    sparse-switch v1, :sswitch_data_0

    .line 324
    :goto_0
    return v0

    .line 309
    :sswitch_0
    const/4 v0, 0x0

    .line 310
    goto :goto_0

    .line 312
    :sswitch_1
    const/4 v0, 0x1

    .line 313
    goto :goto_0

    .line 315
    :sswitch_2
    const/16 v0, 0x8

    .line 316
    goto :goto_0

    .line 318
    :sswitch_3
    const/16 v0, 0x9

    .line 319
    goto :goto_0

    .line 307
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x5a -> :sswitch_1
        0xb4 -> :sswitch_2
        0x10e -> :sswitch_3
    .end sparse-switch
.end method

.method public static getOrientation(Landroid/content/Context;)I
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 269
    const-string/jumbo v5, "window"

    invoke-virtual {p0, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/WindowManager;

    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 270
    .local v0, "display":Landroid/view/Display;
    invoke-virtual {v0}, Landroid/view/Display;->getOrientation()I

    move-result v4

    .line 273
    .local v4, "rotation":I
    packed-switch v4, :pswitch_data_0

    .line 276
    const/16 v3, 0x5a

    .line 277
    .local v3, "orientation":I
    const/4 v1, 0x1

    .line 292
    .local v1, "expectPortrait":Z
    :goto_0
    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v5

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v6

    if-le v5, v6, :cond_1

    const/4 v2, 0x1

    .line 293
    .local v2, "isPortrait":Z
    :goto_1
    if-eq v2, v1, :cond_0

    .line 294
    add-int/lit16 v5, v3, 0x10e

    rem-int/lit16 v3, v5, 0x168

    .line 296
    :cond_0
    return v3

    .line 280
    .end local v1    # "expectPortrait":Z
    .end local v2    # "isPortrait":Z
    .end local v3    # "orientation":I
    :pswitch_0
    const/4 v3, 0x0

    .line 281
    .restart local v3    # "orientation":I
    const/4 v1, 0x0

    .line 282
    .restart local v1    # "expectPortrait":Z
    goto :goto_0

    .line 284
    .end local v1    # "expectPortrait":Z
    .end local v3    # "orientation":I
    :pswitch_1
    const/16 v3, 0x10e

    .line 285
    .restart local v3    # "orientation":I
    const/4 v1, 0x1

    .line 286
    .restart local v1    # "expectPortrait":Z
    goto :goto_0

    .line 288
    .end local v1    # "expectPortrait":Z
    .end local v3    # "orientation":I
    :pswitch_2
    const/16 v3, 0xb4

    .line 289
    .restart local v3    # "orientation":I
    const/4 v1, 0x0

    .restart local v1    # "expectPortrait":Z
    goto :goto_0

    .line 292
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 273
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private openCamera()Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 117
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    if-nez v1, :cond_1

    .line 118
    new-instance v1, Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-direct {v1}, Lcom/amazon/mShop/search/viewit/CameraThread;-><init>()V

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraThread:Lcom/amazon/mShop/search/viewit/CameraThread;

    .line 119
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraThread:Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/CameraThread;->start()V

    .line 120
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraThread:Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/CameraThread;->openCamera()V

    .line 123
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraThread:Lcom/amazon/mShop/search/viewit/CameraThread;

    const-wide/16 v2, 0xa

    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/search/viewit/CameraThread;->openAwait(JLjava/util/concurrent/TimeUnit;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 128
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraThread:Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/CameraThread;->getCamera()Landroid/hardware/Camera;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    .line 129
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    if-nez v1, :cond_0

    .line 130
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    sget-object v2, Lcom/a9/cameralibrary/CameraErrorReason;->CAMERA_OBJECT_NULL:Lcom/a9/cameralibrary/CameraErrorReason;

    const-string/jumbo v3, ""

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->handleCameraError(Lcom/a9/cameralibrary/CameraErrorReason;Ljava/lang/String;)V

    .line 133
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    if-eqz v1, :cond_1

    const/4 v0, 0x1

    .line 135
    :cond_1
    return v0

    .line 124
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static setCameraParameters(Landroid/hardware/Camera;Landroid/hardware/Camera$Size;Landroid/hardware/Camera$PreviewCallback;)V
    .locals 10
    .param p0, "camera"    # Landroid/hardware/Camera;
    .param p1, "previewSize"    # Landroid/hardware/Camera$Size;
    .param p2, "callback"    # Landroid/hardware/Camera$PreviewCallback;

    .prologue
    const/16 v9, 0x7530

    .line 214
    :try_start_0
    invoke-virtual {p0}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v3

    .line 217
    .local v3, "parameters":Landroid/hardware/Camera$Parameters;
    iget v7, p1, Landroid/hardware/Camera$Size;->width:I

    iget v8, p1, Landroid/hardware/Camera$Size;->height:I

    invoke-virtual {v3, v7, v8}, Landroid/hardware/Camera$Parameters;->setPreviewSize(II)V

    .line 220
    const/16 v7, 0x11

    invoke-virtual {v3, v7}, Landroid/hardware/Camera$Parameters;->setPreviewFormat(I)V

    .line 223
    const-string/jumbo v7, "off"

    invoke-virtual {v3, v7}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 227
    sget v7, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0x9

    if-lt v7, v8, :cond_1

    .line 228
    invoke-virtual {v3}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewFpsRange()Ljava/util/List;

    move-result-object v6

    .line 229
    .local v6, "supportedFpsRange":Ljava/util/List;, "Ljava/util/List<[I>;"
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 230
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [I

    .line 231
    .local v5, "range":[I
    array-length v7, v5

    const/4 v8, 0x2

    if-ne v7, v8, :cond_0

    const/4 v7, 0x0

    aget v7, v5, v7

    if-ne v7, v9, :cond_0

    const/4 v7, 0x1

    aget v7, v5, v7

    if-ne v7, v9, :cond_0

    .line 232
    const/4 v7, 0x0

    aget v7, v5, v7

    const/4 v8, 0x1

    aget v8, v5, v8

    invoke-virtual {v3, v7, v8}, Landroid/hardware/Camera$Parameters;->setPreviewFpsRange(II)V

    .line 242
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v5    # "range":[I
    .end local v6    # "supportedFpsRange":Ljava/util/List;, "Ljava/util/List<[I>;"
    :cond_1
    sget v7, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0xe

    if-lt v7, v8, :cond_2

    sget-object v7, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string/jumbo v8, "Nexus 4"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 245
    const/4 v7, 0x1

    invoke-virtual {v3, v7}, Landroid/hardware/Camera$Parameters;->setRecordingHint(Z)V

    .line 249
    :cond_2
    invoke-virtual {p0, v3}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 252
    new-instance v4, Landroid/graphics/PixelFormat;

    invoke-direct {v4}, Landroid/graphics/PixelFormat;-><init>()V

    .line 253
    .local v4, "pixelFormat":Landroid/graphics/PixelFormat;
    invoke-virtual {v3}, Landroid/hardware/Camera$Parameters;->getPreviewFormat()I

    move-result v7

    invoke-static {v7, v4}, Landroid/graphics/PixelFormat;->getPixelFormatInfo(ILandroid/graphics/PixelFormat;)V

    .line 254
    iget v7, p1, Landroid/hardware/Camera$Size;->width:I

    iget v8, p1, Landroid/hardware/Camera$Size;->height:I

    mul-int/2addr v7, v8

    iget v8, v4, Landroid/graphics/PixelFormat;->bitsPerPixel:I

    mul-int/2addr v7, v8

    div-int/lit8 v0, v7, 0x8

    .line 256
    .local v0, "bufSize":I
    new-array v7, v0, [B

    invoke-virtual {p0, v7}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    .line 257
    new-array v7, v0, [B

    invoke-virtual {p0, v7}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    .line 258
    invoke-virtual {p0, p2}, Landroid/hardware/Camera;->setPreviewCallbackWithBuffer(Landroid/hardware/Camera$PreviewCallback;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 262
    .end local v0    # "bufSize":I
    .end local v3    # "parameters":Landroid/hardware/Camera$Parameters;
    .end local v4    # "pixelFormat":Landroid/graphics/PixelFormat;
    :goto_0
    return-void

    .line 259
    :catch_0
    move-exception v1

    .line 260
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v7, "CameraBgHelper"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Error set camera parameters, parameter is invalid or not supported:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method


# virtual methods
.method public adjustSurfaceSize(Lcom/amazon/mShop/search/viewit/FSECameraActivity;DI)Landroid/graphics/Point;
    .locals 15
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/FSECameraActivity;
    .param p2, "a_aspectRatio"    # D
    .param p4, "a_orientation"    # I

    .prologue
    .line 328
    move/from16 v0, p4

    rem-int/lit16 v11, v0, 0xb4

    const/16 v12, 0x5a

    if-ne v11, v12, :cond_4

    const/4 v4, 0x1

    .line 330
    .local v4, "isPortrait":Z
    :goto_0
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v11

    invoke-interface {v11}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    .line 332
    .local v3, "display":Landroid/view/Display;
    sget v11, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v12, 0xd

    if-lt v11, v12, :cond_5

    .line 333
    new-instance v8, Landroid/graphics/Point;

    invoke-direct {v8}, Landroid/graphics/Point;-><init>()V

    .line 334
    .local v8, "size":Landroid/graphics/Point;
    invoke-virtual {v3, v8}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 335
    iget v10, v8, Landroid/graphics/Point;->x:I

    .line 336
    .local v10, "windowWidth":I
    iget v9, v8, Landroid/graphics/Point;->y:I

    .line 342
    .end local v8    # "size":Landroid/graphics/Point;
    .local v9, "windowHeight":I
    :goto_1
    const/4 v5, 0x0

    .line 343
    .local v5, "leftMargin":I
    int-to-double v11, v10

    int-to-double v13, v9

    div-double v1, v11, v13

    .line 346
    .local v1, "currentRatio":D
    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    cmpg-double v11, v1, v11

    if-gez v11, :cond_0

    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    cmpl-double v11, p2, v11

    if-gtz v11, :cond_1

    :cond_0
    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    cmpl-double v11, v1, v11

    if-lez v11, :cond_2

    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    cmpg-double v11, p2, v11

    if-gez v11, :cond_2

    .line 347
    :cond_1
    const-wide/high16 v11, 0x3ff0000000000000L    # 1.0

    div-double p2, v11, p2

    .line 351
    :cond_2
    cmpl-double v11, v1, p2

    if-lez v11, :cond_6

    .line 353
    int-to-double v11, v10

    div-double v11, v11, p2

    double-to-int v9, v11

    .line 367
    :cond_3
    :goto_2
    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreviewLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v11}, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/widget/FrameLayout$LayoutParams;

    .line 368
    .local v6, "lp":Landroid/widget/FrameLayout$LayoutParams;
    iput v10, v6, Landroid/widget/FrameLayout$LayoutParams;->width:I

    .line 369
    iput v9, v6, Landroid/widget/FrameLayout$LayoutParams;->height:I

    .line 370
    const/4 v11, 0x0

    iput v11, v6, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    .line 371
    iput v5, v6, Landroid/widget/FrameLayout$LayoutParams;->leftMargin:I

    .line 372
    iput v5, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraScreenMarginLeft:I

    .line 373
    iget-object v11, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreviewLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v11, v6}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 376
    if-eqz v4, :cond_8

    new-instance v11, Landroid/graphics/Point;

    invoke-direct {v11, v9, v10}, Landroid/graphics/Point;-><init>(II)V

    :goto_3
    return-object v11

    .line 328
    .end local v1    # "currentRatio":D
    .end local v3    # "display":Landroid/view/Display;
    .end local v4    # "isPortrait":Z
    .end local v5    # "leftMargin":I
    .end local v6    # "lp":Landroid/widget/FrameLayout$LayoutParams;
    .end local v9    # "windowHeight":I
    .end local v10    # "windowWidth":I
    :cond_4
    const/4 v4, 0x0

    goto :goto_0

    .line 339
    .restart local v3    # "display":Landroid/view/Display;
    .restart local v4    # "isPortrait":Z
    :cond_5
    invoke-virtual {v3}, Landroid/view/Display;->getWidth()I

    move-result v10

    .line 340
    .restart local v10    # "windowWidth":I
    invoke-virtual {v3}, Landroid/view/Display;->getHeight()I

    move-result v9

    .restart local v9    # "windowHeight":I
    goto :goto_1

    .line 354
    .restart local v1    # "currentRatio":D
    .restart local v5    # "leftMargin":I
    :cond_6
    cmpg-double v11, v1, p2

    if-gez v11, :cond_7

    .line 356
    move v7, v10

    .line 357
    .local v7, "oldWindowWidth":I
    int-to-double v11, v9

    mul-double v11, v11, p2

    double-to-int v10, v11

    .line 358
    if-eqz v4, :cond_3

    .line 360
    sub-int v5, v7, v10

    goto :goto_2

    .line 362
    .end local v7    # "oldWindowWidth":I
    :cond_7
    cmpl-double v11, v1, p2

    if-nez v11, :cond_3

    goto :goto_2

    .line 376
    .restart local v6    # "lp":Landroid/widget/FrameLayout$LayoutParams;
    :cond_8
    new-instance v11, Landroid/graphics/Point;

    invoke-direct {v11, v10, v9}, Landroid/graphics/Point;-><init>(II)V

    goto :goto_3
.end method

.method public drawScanningGraphic(Ljava/util/List;)V
    .locals 1
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
    .line 201
    .local p1, "viewList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/FSEGraphic;>;"
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    if-eqz v0, :cond_0

    .line 202
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->drawGraphic(Ljava/util/List;)V

    .line 204
    :cond_0
    return-void
.end method

.method public focusOnClick()V
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    if-eqz v0, :cond_0

    .line 196
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->focusOnClick()V

    .line 198
    :cond_0
    return-void
.end method

.method public getCameraScreenMarginLeft()I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraScreenMarginLeft:I

    return v0
.end method

.method public isCameraFlashModeOff()Z
    .locals 2

    .prologue
    .line 186
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    if-eqz v1, :cond_0

    .line 187
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getFlashMode()Ljava/lang/String;

    move-result-object v0

    .line 188
    .local v0, "flashMode":Ljava/lang/String;
    const-string/jumbo v1, "off"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    .line 190
    .end local v0    # "flashMode":Ljava/lang/String;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isSupportedFlashTorchMode()Z
    .locals 2

    .prologue
    .line 139
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    if-eqz v1, :cond_0

    .line 140
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getSupportedFlashModes()Ljava/util/List;

    move-result-object v0

    .line 141
    .local v0, "flashModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "torch"

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 142
    const/4 v1, 0x1

    .line 145
    .end local v0    # "flashModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public pause()V
    .locals 2

    .prologue
    .line 102
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setIsCameraPaused(Z)V

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->stopPreview()V

    .line 106
    :cond_0
    return-void
.end method

.method public setCameraFlashMode(Ljava/lang/String;)Z
    .locals 6
    .param p1, "flashMode"    # Ljava/lang/String;

    .prologue
    .line 169
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    if-eqz v3, :cond_0

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 171
    :try_start_0
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 172
    .local v1, "parameters":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getSupportedFlashModes()Ljava/util/List;

    move-result-object v2

    .line 173
    .local v2, "supportedFlashModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-interface {v2, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 174
    invoke-virtual {v1, p1}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 175
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 176
    const/4 v3, 0x1

    .line 182
    .end local v1    # "parameters":Landroid/hardware/Camera$Parameters;
    .end local v2    # "supportedFlashModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return v3

    .line 178
    :catch_0
    move-exception v0

    .line 179
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v3, "CameraBgHelper"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Camera parameter is invalid or not supported:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 182
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public start(II)V
    .locals 3
    .param p1, "minHeight"    # I
    .param p2, "maxHeight"    # I

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->openCamera()Z

    move-result v0

    .line 59
    .local v0, "success":Z
    if-eqz v0, :cond_0

    .line 60
    new-instance v1, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    .line 61
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setCamera(Landroid/hardware/Camera;)V

    .line 62
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setIsCameraPaused(Z)V

    .line 63
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setMinHeight(I)V

    .line 64
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v1, p2}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setMaxHeight(I)V

    .line 65
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreviewLayout:Landroid/widget/FrameLayout;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 69
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    iget-boolean v1, v1, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsBarcodeScanOnly:Z

    if-nez v1, :cond_1

    .line 70
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mActivity:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateFlashModeButtonVisibility()V

    .line 72
    :cond_1
    return-void
.end method

.method public stop()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 78
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    if-eqz v1, :cond_0

    .line 80
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraThread:Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/CameraThread;->releaseCamera()V

    .line 81
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCameraThread:Lcom/amazon/mShop/search/viewit/CameraThread;

    const-wide/16 v2, 0x5

    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/search/viewit/CameraThread;->releaseAwait(JLjava/util/concurrent/TimeUnit;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 85
    :goto_0
    iput-object v5, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    .line 88
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    if-eqz v1, :cond_0

    .line 89
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v1, v5}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setCamera(Landroid/hardware/Camera;)V

    .line 93
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreviewLayout:Landroid/widget/FrameLayout;

    if-eqz v1, :cond_1

    .line 94
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setIsCameraPaused(Z)V

    .line 95
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreviewLayout:Landroid/widget/FrameLayout;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 96
    iput-object v5, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    .line 98
    :cond_1
    return-void

    .line 82
    :catch_0
    move-exception v0

    .line 83
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "CameraBgHelper"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Error release camera: "

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
.end method

.method public switchCameraFlashMode()Z
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_1

    .line 155
    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->isCameraFlashModeOff()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 156
    const-string/jumbo v0, "torch"

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->setCameraFlashMode(Ljava/lang/String;)Z

    move-result v0

    .line 162
    :goto_0
    return v0

    .line 158
    :cond_0
    const-string/jumbo v0, "off"

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->setCameraFlashMode(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0

    .line 162
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public unpause()V
    .locals 2

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->setIsCameraPaused(Z)V

    .line 112
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->startPreview()V

    .line 114
    :cond_0
    return-void
.end method

.method public updateSteadyStatus(Z)V
    .locals 1
    .param p1, "status"    # Z

    .prologue
    .line 380
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    if-eqz v0, :cond_0

    .line 381
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->updateSteadyStatus(Z)V

    .line 382
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->mPreview:Lcom/amazon/mShop/search/viewit/FlowCameraPreview;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/FlowCameraPreview;->invalidate()V

    .line 384
    :cond_0
    return-void
.end method
