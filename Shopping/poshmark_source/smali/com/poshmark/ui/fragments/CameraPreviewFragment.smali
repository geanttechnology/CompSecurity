.class public Lcom/poshmark/ui/fragments/CameraPreviewFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "CameraPreviewFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/CameraPreviewFragment$9;,
        Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;,
        Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;
    }
.end annotation


# static fields
.field public static CREATE_COVERSHOT:I

.field public static CREATE_THUMBNAIL:I


# instance fields
.field BACK_CAMERA:I

.field CREATION_MODE:I

.field CROP_IMAGE:I

.field FILTER_IMAGE:I

.field FRONT_CAMERA:I

.field PICK_IMAGE:I

.field PICK_IMAGE_NO_CAMERA_PRESENT:I

.field bIsFirstCovershot:Z

.field cameraList:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;",
            ">;"
        }
    .end annotation
.end field

.field currentFlashMode:Ljava/lang/String;

.field currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

.field loadingBitmapProgressBarLayout:Landroid/widget/RelativeLayout;

.field mAutoFocusCallback:Landroid/hardware/Camera$AutoFocusCallback;

.field mCamera:Landroid/hardware/Camera;

.field private pictureCallback:Landroid/hardware/Camera$PictureCallback;

.field pictureTaken:Z

.field preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

.field screenHeight:I

.field screenWidth:I

.field state:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

.field private surfaceCallback:Landroid/view/SurfaceHolder$Callback;

.field surfaceHolder:Landroid/view/SurfaceHolder;

.field viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const/4 v0, 0x0

    sput v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_THUMBNAIL:I

    .line 52
    const/4 v0, 0x1

    sput v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 54
    const/4 v0, 0x2

    iput v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->PICK_IMAGE:I

    .line 55
    const/4 v0, 0x3

    iput v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CROP_IMAGE:I

    .line 56
    const/4 v0, 0x4

    iput v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FILTER_IMAGE:I

    .line 57
    const/4 v0, 0x5

    iput v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->PICK_IMAGE_NO_CAMERA_PRESENT:I

    .line 61
    sget-object v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->INIT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->state:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    .line 63
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    .line 64
    iput v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    .line 66
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    .line 67
    const-string v0, "off"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    .line 73
    sget v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_THUMBNAIL:I

    iput v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATION_MODE:I

    .line 74
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->bIsFirstCovershot:Z

    .line 79
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->pictureTaken:Z

    .line 434
    new-instance v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$6;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$6;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mAutoFocusCallback:Landroid/hardware/Camera$AutoFocusCallback;

    .line 586
    new-instance v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->surfaceCallback:Landroid/view/SurfaceHolder$Callback;

    .line 616
    new-instance v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->pictureCallback:Landroid/hardware/Camera$PictureCallback;

    .line 839
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->releaseCamera()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->switchCamera()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraPreviewAttributes()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/CameraPreviewFragment;Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraPreviewFragment;
    .param p1, "x1"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraPreviewDisplay(Landroid/view/SurfaceHolder;)V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)Landroid/hardware/Camera$PictureCallback;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->pictureCallback:Landroid/hardware/Camera$PictureCallback;

    return-object v0
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupButtonHandlers()V

    return-void
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/CameraPreviewFragment;Landroid/net/Uri;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CameraPreviewFragment;
    .param p1, "x1"    # Landroid/net/Uri;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->fireCameraFiltersActivity(Landroid/net/Uri;)V

    return-void
.end method

.method private doBitmapTransformations(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    .locals 16
    .param p1, "source"    # Landroid/graphics/Bitmap;
    .param p2, "rect"    # Landroid/graphics/Rect;
    .param p3, "m"    # Landroid/graphics/Matrix;
    .param p4, "filter"    # Z

    .prologue
    .line 780
    move-object/from16 v0, p2

    iget v8, v0, Landroid/graphics/Rect;->right:I

    .line 781
    .local v8, "neww":I
    move-object/from16 v0, p2

    iget v7, v0, Landroid/graphics/Rect;->bottom:I

    .line 782
    .local v7, "newh":I
    new-instance v2, Landroid/graphics/Canvas;

    invoke-direct {v2}, Landroid/graphics/Canvas;-><init>()V

    .line 786
    .local v2, "canvas":Landroid/graphics/Canvas;
    new-instance v10, Landroid/graphics/Rect;

    const/4 v12, 0x0

    const/4 v13, 0x0

    move-object/from16 v0, p2

    iget v14, v0, Landroid/graphics/Rect;->right:I

    move-object/from16 v0, p2

    iget v15, v0, Landroid/graphics/Rect;->bottom:I

    invoke-direct {v10, v12, v13, v14, v15}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 787
    .local v10, "srcR":Landroid/graphics/Rect;
    new-instance v5, Landroid/graphics/RectF;

    const/4 v12, 0x0

    const/4 v13, 0x0

    move-object/from16 v0, p2

    iget v14, v0, Landroid/graphics/Rect;->right:I

    int-to-float v14, v14

    move-object/from16 v0, p2

    iget v15, v0, Landroid/graphics/Rect;->bottom:I

    int-to-float v15, v15

    invoke-direct {v5, v12, v13, v14, v15}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 789
    .local v5, "dstR":Landroid/graphics/RectF;
    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .line 790
    .local v6, "newConfig":Landroid/graphics/Bitmap$Config;
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v3

    .line 792
    .local v3, "config":Landroid/graphics/Bitmap$Config;
    if-eqz v3, :cond_0

    .line 793
    sget-object v12, Lcom/poshmark/ui/fragments/CameraPreviewFragment$9;->$SwitchMap$android$graphics$Bitmap$Config:[I

    invoke-virtual {v3}, Landroid/graphics/Bitmap$Config;->ordinal()I

    move-result v13

    aget v12, v12, v13

    packed-switch v12, :pswitch_data_0

    .line 804
    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .line 810
    :cond_0
    :goto_0
    invoke-virtual/range {p3 .. p3}, Landroid/graphics/Matrix;->rectStaysRect()Z

    move-result v12

    if-nez v12, :cond_3

    const/4 v11, 0x1

    .line 812
    .local v11, "transformed":Z
    :goto_1
    new-instance v4, Landroid/graphics/RectF;

    invoke-direct {v4}, Landroid/graphics/RectF;-><init>()V

    .line 813
    .local v4, "deviceR":Landroid/graphics/RectF;
    move-object/from16 v0, p3

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;Landroid/graphics/RectF;)Z

    .line 815
    invoke-virtual {v4}, Landroid/graphics/RectF;->width()F

    move-result v12

    invoke-static {v12}, Ljava/lang/Math;->round(F)I

    move-result v8

    .line 816
    invoke-virtual {v4}, Landroid/graphics/RectF;->height()F

    move-result v12

    invoke-static {v12}, Ljava/lang/Math;->round(F)I

    move-result v7

    .line 818
    if-eqz v11, :cond_1

    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .end local v6    # "newConfig":Landroid/graphics/Bitmap$Config;
    :cond_1
    invoke-static {v8, v7, v6}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 820
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    iget v12, v4, Landroid/graphics/RectF;->left:F

    neg-float v12, v12

    iget v13, v4, Landroid/graphics/RectF;->top:F

    neg-float v13, v13

    invoke-virtual {v2, v12, v13}, Landroid/graphics/Canvas;->translate(FF)V

    .line 821
    move-object/from16 v0, p3

    invoke-virtual {v2, v0}, Landroid/graphics/Canvas;->concat(Landroid/graphics/Matrix;)V

    .line 823
    new-instance v9, Landroid/graphics/Paint;

    invoke-direct {v9}, Landroid/graphics/Paint;-><init>()V

    .line 824
    .local v9, "paint":Landroid/graphics/Paint;
    move/from16 v0, p4

    invoke-virtual {v9, v0}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 825
    if-eqz v11, :cond_2

    .line 826
    const/4 v12, 0x1

    invoke-virtual {v9, v12}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 834
    :cond_2
    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Landroid/graphics/Canvas;->setBitmap(Landroid/graphics/Bitmap;)V

    .line 835
    const/4 v12, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v2, v0, v12, v5, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 836
    return-object p1

    .line 795
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v4    # "deviceR":Landroid/graphics/RectF;
    .end local v9    # "paint":Landroid/graphics/Paint;
    .end local v11    # "transformed":Z
    .restart local v6    # "newConfig":Landroid/graphics/Bitmap$Config;
    :pswitch_0
    sget-object v6, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    .line 796
    goto :goto_0

    .line 798
    :pswitch_1
    sget-object v6, Landroid/graphics/Bitmap$Config;->ALPHA_8:Landroid/graphics/Bitmap$Config;

    .line 799
    goto :goto_0

    .line 810
    :cond_3
    const/4 v11, 0x0

    goto :goto_1

    .line 793
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private fireCameraFiltersActivity(Landroid/net/Uri;)V
    .locals 5
    .param p1, "imageFile"    # Landroid/net/Uri;

    .prologue
    .line 577
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 578
    .local v2, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 579
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    const-class v4, Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 580
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 581
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "FILE"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 582
    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 583
    iget v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FILTER_IMAGE:I

    invoke-virtual {p0, v1, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 584
    return-void
.end method

.method private getBestPictureSize(Landroid/hardware/Camera$Parameters;Landroid/hardware/Camera$Size;)Landroid/hardware/Camera$Size;
    .locals 9
    .param p1, "parameters"    # Landroid/hardware/Camera$Parameters;
    .param p2, "previewSize"    # Landroid/hardware/Camera$Size;

    .prologue
    .line 487
    const/4 v5, 0x0

    .line 488
    .local v5, "result":Landroid/hardware/Camera$Size;
    const v1, 0x7fffffff

    .line 489
    .local v1, "diff":I
    iget v7, p2, Landroid/hardware/Camera$Size;->height:I

    iget v8, p2, Landroid/hardware/Camera$Size;->width:I

    mul-int v4, v7, v8

    .line 490
    .local v4, "previewArea":I
    invoke-virtual {p1}, Landroid/hardware/Camera$Parameters;->getSupportedPictureSizes()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/hardware/Camera$Size;

    .line 491
    .local v6, "size":Landroid/hardware/Camera$Size;
    iget v7, v6, Landroid/hardware/Camera$Size;->height:I

    iget v8, v6, Landroid/hardware/Camera$Size;->width:I

    mul-int v0, v7, v8

    .line 492
    .local v0, "areaNew":I
    sub-int v7, v4, v0

    invoke-static {v7}, Ljava/lang/Math;->abs(I)I

    move-result v3

    .line 493
    .local v3, "newDiff":I
    if-gt v3, v1, :cond_0

    .line 494
    move-object v5, v6

    .line 495
    move v1, v3

    goto :goto_0

    .line 498
    .end local v0    # "areaNew":I
    .end local v3    # "newDiff":I
    .end local v6    # "size":Landroid/hardware/Camera$Size;
    :cond_1
    return-object v5
.end method

.method private getBestPreviewSize(IILandroid/hardware/Camera$Parameters;)Landroid/hardware/Camera$Size;
    .locals 7
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "parameters"    # Landroid/hardware/Camera$Parameters;

    .prologue
    .line 444
    const/4 v4, 0x0

    .line 445
    .local v4, "result":Landroid/hardware/Camera$Size;
    invoke-virtual {p3}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewSizes()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/hardware/Camera$Size;

    .line 446
    .local v3, "previewSize":Landroid/hardware/Camera$Size;
    invoke-virtual {p3}, Landroid/hardware/Camera$Parameters;->getSupportedPictureSizes()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/hardware/Camera$Size;

    .line 447
    .local v2, "pictureSize":Landroid/hardware/Camera$Size;
    iget v5, v2, Landroid/hardware/Camera$Size;->width:I

    iget v6, v3, Landroid/hardware/Camera$Size;->width:I

    if-ne v5, v6, :cond_1

    iget v5, v2, Landroid/hardware/Camera$Size;->height:I

    iget v6, v3, Landroid/hardware/Camera$Size;->height:I

    if-ne v5, v6, :cond_1

    .line 448
    if-nez v4, :cond_2

    .line 449
    move-object v4, v3

    goto :goto_0

    .line 452
    :cond_2
    iget v5, v4, Landroid/hardware/Camera$Size;->height:I

    iget v6, v3, Landroid/hardware/Camera$Size;->height:I

    if-lt v5, v6, :cond_3

    iget v5, v4, Landroid/hardware/Camera$Size;->width:I

    iget v6, v3, Landroid/hardware/Camera$Size;->width:I

    if-ge v5, v6, :cond_1

    .line 453
    :cond_3
    move-object v4, v3

    goto :goto_0

    .line 460
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "pictureSize":Landroid/hardware/Camera$Size;
    .end local v3    # "previewSize":Landroid/hardware/Camera$Size;
    :cond_4
    return-object v4
.end method

.method private getBestPreviewSizeII(IILandroid/hardware/Camera$Parameters;)Landroid/hardware/Camera$Size;
    .locals 7
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "parameters"    # Landroid/hardware/Camera$Parameters;

    .prologue
    .line 464
    const/4 v2, 0x0

    .line 466
    .local v2, "result":Landroid/hardware/Camera$Size;
    invoke-virtual {p3}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewSizes()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/hardware/Camera$Size;

    .line 467
    .local v4, "size":Landroid/hardware/Camera$Size;
    iget v5, v4, Landroid/hardware/Camera$Size;->width:I

    if-gt v5, p1, :cond_0

    iget v5, v4, Landroid/hardware/Camera$Size;->height:I

    if-gt v5, p2, :cond_0

    .line 468
    if-nez v2, :cond_1

    .line 469
    move-object v2, v4

    goto :goto_0

    .line 472
    :cond_1
    iget v5, v2, Landroid/hardware/Camera$Size;->width:I

    iget v6, v2, Landroid/hardware/Camera$Size;->height:I

    mul-int v3, v5, v6

    .line 473
    .local v3, "resultArea":I
    iget v5, v4, Landroid/hardware/Camera$Size;->width:I

    iget v6, v4, Landroid/hardware/Camera$Size;->height:I

    mul-int v1, v5, v6

    .line 475
    .local v1, "newArea":I
    if-le v1, v3, :cond_0

    .line 476
    move-object v2, v4

    goto :goto_0

    .line 482
    .end local v1    # "newArea":I
    .end local v3    # "resultArea":I
    .end local v4    # "size":Landroid/hardware/Camera$Size;
    :cond_2
    return-object v2
.end method

.method private getBitmapFromPickerAction(Landroid/content/Intent;Landroid/net/Uri;)V
    .locals 10
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "selectedImage"    # Landroid/net/Uri;

    .prologue
    const/4 v9, 0x0

    const/4 v2, 0x0

    .line 200
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->loadingBitmapProgressBarLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v9}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 201
    const/4 v7, 0x0

    .line 202
    .local v7, "filePath":Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 203
    invoke-virtual {p2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "file:"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 204
    invoke-virtual {p2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v7

    .line 215
    :cond_0
    :goto_0
    if-eqz v7, :cond_2

    const-string v0, "http"

    invoke-virtual {v7, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 216
    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cropImage(Ljava/lang/String;)V

    .line 221
    :goto_1
    return-void

    .line 206
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    move-object v1, p2

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 207
    .local v6, "c":Landroid/database/Cursor;
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 208
    const-string v0, "_data"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 209
    .local v8, "id":I
    const/4 v0, -0x1

    if-eq v8, v0, :cond_0

    .line 210
    invoke-interface {v6, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    goto :goto_0

    .line 219
    .end local v6    # "c":Landroid/database/Cursor;
    .end local v8    # "id":I
    :cond_2
    new-instance v0, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    const/4 v1, 0x1

    new-array v1, v1, [Landroid/net/Uri;

    aput-object p2, v1, v9

    instance-of v2, v0, Landroid/os/AsyncTask;

    if-nez v2, :cond_3

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ImageUtils$BitmapDownloader;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    :cond_3
    check-cast v0, Landroid/os/AsyncTask;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1
.end method

.method private getLargestPictureSize(Landroid/hardware/Camera$Parameters;)Landroid/hardware/Camera$Size;
    .locals 7
    .param p1, "parameters"    # Landroid/hardware/Camera$Parameters;

    .prologue
    .line 523
    const/4 v2, 0x0

    .line 525
    .local v2, "result":Landroid/hardware/Camera$Size;
    invoke-virtual {p1}, Landroid/hardware/Camera$Parameters;->getSupportedPictureSizes()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/hardware/Camera$Size;

    .line 527
    .local v4, "size":Landroid/hardware/Camera$Size;
    if-nez v2, :cond_1

    .line 528
    move-object v2, v4

    goto :goto_0

    .line 531
    :cond_1
    iget v5, v2, Landroid/hardware/Camera$Size;->width:I

    iget v6, v2, Landroid/hardware/Camera$Size;->height:I

    mul-int v3, v5, v6

    .line 532
    .local v3, "resultArea":I
    iget v5, v4, Landroid/hardware/Camera$Size;->width:I

    iget v6, v4, Landroid/hardware/Camera$Size;->height:I

    mul-int v1, v5, v6

    .line 534
    .local v1, "newArea":I
    if-le v1, v3, :cond_0

    .line 535
    move-object v2, v4

    goto :goto_0

    .line 539
    .end local v1    # "newArea":I
    .end local v3    # "resultArea":I
    .end local v4    # "size":Landroid/hardware/Camera$Size;
    :cond_2
    return-object v2
.end method

.method private getSmallestPictureSize(Landroid/hardware/Camera$Parameters;)Landroid/hardware/Camera$Size;
    .locals 7
    .param p1, "parameters"    # Landroid/hardware/Camera$Parameters;

    .prologue
    .line 502
    const/4 v2, 0x0

    .line 504
    .local v2, "result":Landroid/hardware/Camera$Size;
    invoke-virtual {p1}, Landroid/hardware/Camera$Parameters;->getSupportedPictureSizes()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/hardware/Camera$Size;

    .line 506
    .local v4, "size":Landroid/hardware/Camera$Size;
    if-nez v2, :cond_1

    .line 507
    move-object v2, v4

    goto :goto_0

    .line 510
    :cond_1
    iget v5, v2, Landroid/hardware/Camera$Size;->width:I

    iget v6, v2, Landroid/hardware/Camera$Size;->height:I

    mul-int v3, v5, v6

    .line 511
    .local v3, "resultArea":I
    iget v5, v4, Landroid/hardware/Camera$Size;->width:I

    iget v6, v4, Landroid/hardware/Camera$Size;->height:I

    mul-int v1, v5, v6

    .line 513
    .local v1, "newArea":I
    if-ge v1, v3, :cond_0

    .line 514
    move-object v2, v4

    goto :goto_0

    .line 519
    .end local v1    # "newArea":I
    .end local v3    # "resultArea":I
    .end local v4    # "size":Landroid/hardware/Camera$Size;
    :cond_2
    return-object v2
.end method

.method private releaseCamera()V
    .locals 1

    .prologue
    .line 568
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    .line 569
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->stopPreview()V

    .line 570
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->release()V

    .line 571
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    .line 573
    :cond_0
    return-void
.end method

.method private setupButtonHandlers()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 240
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getView()Landroid/view/View;

    move-result-object v5

    .line 241
    .local v5, "view":Landroid/view/View;
    const v6, 0x7f0c0095

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageButton;

    .line 242
    .local v4, "pickImageButton":Landroid/widget/ImageButton;
    const v6, 0x7f0c0094

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageButton;

    .line 243
    .local v2, "clickImageButton":Landroid/widget/ImageButton;
    const v6, 0x7f0c0093

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 245
    .local v0, "cancelButton":Landroid/widget/ImageButton;
    const v6, 0x7f0c0092

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 246
    .local v1, "changeCameraFaceButton":Landroid/widget/ImageButton;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->size()I

    move-result v6

    const/4 v7, 0x1

    if-le v6, v7, :cond_0

    .line 247
    invoke-virtual {v1, v8}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 252
    :goto_0
    const v6, 0x7f0c0091

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 253
    .local v3, "flashButton":Landroid/widget/Button;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget v6, v6, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->cameraId:I

    iget v7, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    if-ne v6, v7, :cond_1

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    const-string v7, "android.hardware.camera.flash"

    invoke-virtual {v6, v7}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 254
    invoke-virtual {v3, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 261
    :goto_1
    new-instance v6, Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    invoke-virtual {v2, v6}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 274
    new-instance v6, Lcom/poshmark/ui/fragments/CameraPreviewFragment$2;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$2;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    invoke-virtual {v4, v6}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 284
    new-instance v6, Lcom/poshmark/ui/fragments/CameraPreviewFragment$3;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$3;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    invoke-virtual {v0, v6}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 292
    new-instance v6, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    invoke-virtual {v1, v6}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 304
    new-instance v6, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    invoke-virtual {v3, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 327
    return-void

    .line 249
    .end local v3    # "flashButton":Landroid/widget/Button;
    :cond_0
    const/4 v6, 0x4

    invoke-virtual {v1, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0

    .line 257
    .restart local v3    # "flashButton":Landroid/widget/Button;
    :cond_1
    const/16 v6, 0x8

    invoke-virtual {v3, v6}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_1
.end method

.method private setupCameraFlash(Ljava/lang/String;)V
    .locals 3
    .param p1, "flashMode"    # Ljava/lang/String;

    .prologue
    .line 426
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 427
    .local v1, "p":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getSupportedFlashModes()Ljava/util/List;

    move-result-object v0

    .line 428
    .local v0, "flashModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 429
    invoke-virtual {v1, p1}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 430
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 432
    :cond_0
    return-void
.end method

.method private setupCameraPreviewAttributes()V
    .locals 9

    .prologue
    const/16 v8, 0x10e

    const/16 v7, 0x5a

    .line 358
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    if-eqz v5, :cond_2

    .line 359
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setOrientation()I

    move-result v2

    .line 361
    .local v2, "degrees":I
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v5}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v3

    .line 362
    .local v3, "p":Landroid/hardware/Camera$Parameters;
    const-string v5, "jpeg-quality"

    const/16 v6, 0x64

    invoke-virtual {v3, v5, v6}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;I)V

    .line 367
    if-eq v2, v7, :cond_0

    if-ne v2, v8, :cond_3

    .line 368
    :cond_0
    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenHeight:I

    iget v6, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenWidth:I

    invoke-direct {p0, v5, v6, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getBestPreviewSizeII(IILandroid/hardware/Camera$Parameters;)Landroid/hardware/Camera$Size;

    move-result-object v4

    .line 373
    .local v4, "previewSize":Landroid/hardware/Camera$Size;
    :goto_0
    invoke-direct {p0, v3, v4}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getBestPictureSize(Landroid/hardware/Camera$Parameters;Landroid/hardware/Camera$Size;)Landroid/hardware/Camera$Size;

    move-result-object v1

    .line 374
    .local v1, "bitmapSize":Landroid/hardware/Camera$Size;
    iget v5, v4, Landroid/hardware/Camera$Size;->width:I

    iget v6, v4, Landroid/hardware/Camera$Size;->height:I

    invoke-virtual {v3, v5, v6}, Landroid/hardware/Camera$Parameters;->setPreviewSize(II)V

    .line 375
    iget v5, v1, Landroid/hardware/Camera$Size;->width:I

    iget v6, v1, Landroid/hardware/Camera$Size;->height:I

    invoke-virtual {v3, v5, v6}, Landroid/hardware/Camera$Parameters;->setPictureSize(II)V

    .line 376
    const-string v5, "off"

    invoke-direct {p0, v5}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraFlash(Ljava/lang/String;)V

    .line 378
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v5, v3}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 381
    if-eq v2, v7, :cond_1

    if-ne v2, v8, :cond_4

    .line 382
    :cond_1
    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenWidth:I

    int-to-float v5, v5

    iget v6, v4, Landroid/hardware/Camera$Size;->height:I

    int-to-float v6, v6

    div-float/2addr v5, v6

    iget v6, v4, Landroid/hardware/Camera$Size;->width:I

    int-to-float v6, v6

    mul-float/2addr v5, v6

    float-to-int v0, v5

    .line 386
    .local v0, "adjustedViewDimension":I
    :goto_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    iget v6, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenWidth:I

    invoke-virtual {v5, v6, v0}, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->setScaledDimensions(II)V

    .line 389
    .end local v0    # "adjustedViewDimension":I
    .end local v1    # "bitmapSize":Landroid/hardware/Camera$Size;
    .end local v2    # "degrees":I
    .end local v3    # "p":Landroid/hardware/Camera$Parameters;
    .end local v4    # "previewSize":Landroid/hardware/Camera$Size;
    :cond_2
    return-void

    .line 370
    .restart local v2    # "degrees":I
    .restart local v3    # "p":Landroid/hardware/Camera$Parameters;
    :cond_3
    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenWidth:I

    iget v6, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenHeight:I

    invoke-direct {p0, v5, v6, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getBestPreviewSizeII(IILandroid/hardware/Camera$Parameters;)Landroid/hardware/Camera$Size;

    move-result-object v4

    .restart local v4    # "previewSize":Landroid/hardware/Camera$Size;
    goto :goto_0

    .line 384
    .restart local v1    # "bitmapSize":Landroid/hardware/Camera$Size;
    :cond_4
    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenWidth:I

    int-to-float v5, v5

    iget v6, v4, Landroid/hardware/Camera$Size;->width:I

    int-to-float v6, v6

    div-float/2addr v5, v6

    iget v6, v4, Landroid/hardware/Camera$Size;->height:I

    int-to-float v6, v6

    mul-float/2addr v5, v6

    float-to-int v0, v5

    .restart local v0    # "adjustedViewDimension":I
    goto :goto_1
.end method

.method private setupCameraPreviewDisplay(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 608
    :try_start_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1, p1}, Landroid/hardware/Camera;->setPreviewDisplay(Landroid/view/SurfaceHolder;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 614
    :goto_0
    return-void

    .line 609
    :catch_0
    move-exception v0

    .line 610
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 611
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->release()V

    .line 612
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    goto :goto_0
.end method

.method private switchCamera()V
    .locals 6

    .prologue
    const/16 v5, 0x8

    .line 330
    const/4 v0, 0x0

    .line 331
    .local v0, "camera":Landroid/hardware/Camera;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->cameraId:I

    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    if-ne v3, v4, :cond_0

    .line 332
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    .line 333
    iget v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    invoke-static {v3}, Landroid/hardware/Camera;->open(I)Landroid/hardware/Camera;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    .line 341
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getView()Landroid/view/View;

    move-result-object v3

    const v4, 0x7f0c0091

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 342
    .local v2, "flashButton":Landroid/widget/Button;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    const-string v4, "android.hardware.camera.flash"

    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    .line 343
    .local v1, "deviceHasFlash":Z
    if-eqz v1, :cond_2

    .line 344
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->cameraId:I

    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    if-ne v3, v4, :cond_1

    .line 345
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 354
    :goto_1
    return-void

    .line 335
    .end local v1    # "deviceHasFlash":Z
    .end local v2    # "flashButton":Landroid/widget/Button;
    :cond_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    .line 336
    iget v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    invoke-static {v3}, Landroid/hardware/Camera;->open(I)Landroid/hardware/Camera;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    goto :goto_0

    .line 348
    .restart local v1    # "deviceHasFlash":Z
    .restart local v2    # "flashButton":Landroid/widget/Button;
    :cond_1
    invoke-virtual {v2, v5}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_1

    .line 351
    :cond_2
    invoke-virtual {v2, v5}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public cropImage(Ljava/lang/String;)V
    .locals 5
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 224
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->loadingBitmapProgressBarLayout:Landroid/widget/RelativeLayout;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 225
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 226
    .local v2, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 227
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    const-class v4, Lcom/poshmark/ui/fragments/GestureTester;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 228
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 229
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "FILE"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    const-string v3, "CREATION_MODE"

    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATION_MODE:I

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 231
    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 232
    iget v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CROP_IMAGE:I

    invoke-virtual {p0, v1, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 233
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 109
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 110
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenWidth:I

    .line 111
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->screenHeight:I

    .line 112
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 8
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v7, 0x0

    const/4 v6, -0x1

    .line 163
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 165
    iput-boolean v7, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->pictureTaken:Z

    .line 166
    if-ne p2, v6, :cond_5

    .line 167
    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->PICK_IMAGE:I

    if-eq p1, v4, :cond_0

    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->PICK_IMAGE_NO_CAMERA_PRESENT:I

    if-ne p1, v4, :cond_2

    .line 168
    :cond_0
    if-eqz p3, :cond_1

    .line 169
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v3

    .line 170
    .local v3, "uri":Landroid/net/Uri;
    invoke-direct {p0, p3, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getBitmapFromPickerAction(Landroid/content/Intent;Landroid/net/Uri;)V

    .line 196
    .end local v3    # "uri":Landroid/net/Uri;
    :cond_1
    :goto_0
    return-void

    .line 172
    :cond_2
    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CROP_IMAGE:I

    if-ne p1, v4, :cond_4

    .line 173
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    .line 174
    .local v1, "croppedImageFile":Landroid/net/Uri;
    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATION_MODE:I

    sget v5, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    if-ne v4, v5, :cond_3

    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->bIsFirstCovershot:Z

    if-eqz v4, :cond_3

    .line 175
    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->fireCameraFiltersActivity(Landroid/net/Uri;)V

    goto :goto_0

    .line 177
    :cond_3
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 178
    .local v2, "i":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 179
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "IMAGE_FILE_URI"

    invoke-virtual {v0, v4, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 180
    invoke-virtual {v2, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 181
    invoke-virtual {p0, v6, v2}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0

    .line 183
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "croppedImageFile":Landroid/net/Uri;
    .end local v2    # "i":Landroid/content/Intent;
    :cond_4
    iget v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FILTER_IMAGE:I

    if-ne p1, v4, :cond_1

    .line 184
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 185
    .restart local v0    # "b":Landroid/os/Bundle;
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 186
    .restart local v2    # "i":Landroid/content/Intent;
    invoke-virtual {v2, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 187
    invoke-virtual {p0, v6, v2}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0

    .line 192
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "i":Landroid/content/Intent;
    :cond_5
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->state:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    sget-object v5, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->PICK_IMAGE_NO_CAMERA_PRESENT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    if-ne v4, v5, :cond_1

    .line 193
    const/4 v4, 0x0

    invoke-virtual {p0, v7, v4}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    .line 84
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 86
    if-eqz p1, :cond_0

    .line 87
    const-string v1, "State"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->state:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    .line 90
    :cond_0
    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->bShouldHideActionBar:Z

    .line 91
    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->hideActionBar(Z)V

    .line 92
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 93
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_1

    .line 94
    const-string v1, "CREATION_MODE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATION_MODE:I

    .line 95
    const-string v1, "IS_FIRST_IMAGE"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->bIsFirstCovershot:Z

    .line 97
    :cond_1
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 101
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 102
    const v1, 0x7f03001e

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 103
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c0096

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->loadingBitmapProgressBarLayout:Landroid/widget/RelativeLayout;

    .line 104
    return-object v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 154
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 155
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->releaseCamera()V

    .line 156
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 157
    .local v0, "layout":Landroid/widget/FrameLayout;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 158
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    .line 159
    return-void
.end method

.method public onResume()V
    .locals 6

    .prologue
    const/16 v5, 0x400

    .line 116
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onResume()V

    .line 117
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    if-nez v2, :cond_0

    .line 119
    new-instance v2, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {v2, v3, v4}, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    .line 120
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 121
    .local v0, "layout":Landroid/widget/FrameLayout;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;I)V

    .line 123
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameras()V

    .line 125
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->surfaceHolder:Landroid/view/SurfaceHolder;

    .line 126
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->surfaceHolder:Landroid/view/SurfaceHolder;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->surfaceCallback:Landroid/view/SurfaceHolder$Callback;

    invoke-interface {v2, v3}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 128
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraPreviewAttributes()V

    .line 130
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0c0090

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/CameraViewportRectView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    .line 131
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2, v5, v5}, Landroid/view/Window;->setFlags(II)V

    .line 134
    .end local v0    # "layout":Landroid/widget/FrameLayout;
    :cond_0
    sget-object v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment$9;->$SwitchMap$com$poshmark$ui$fragments$CameraPreviewFragment$STATE:[I

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->state:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 144
    :cond_1
    :goto_0
    return-void

    .line 136
    :pswitch_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    if-nez v2, :cond_1

    .line 137
    sget-object v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;->PICK_IMAGE_NO_CAMERA_PRESENT:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->state:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    .line 138
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.PICK"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 139
    .local v1, "photoPickerIntent":Landroid/content/Intent;
    const-string v2, "image/*"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 140
    iget v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->PICK_IMAGE_NO_CAMERA_PRESENT:I

    invoke-virtual {p0, v1, v2}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 134
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 148
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 149
    const-string v0, "State"

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->state:Lcom/poshmark/ui/fragments/CameraPreviewFragment$STATE;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 150
    return-void
.end method

.method public setOrientation()I
    .locals 6

    .prologue
    .line 544
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-string v5, "window"

    invoke-virtual {v4, v5}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/WindowManager;

    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 546
    .local v1, "display":Landroid/view/Display;
    invoke-virtual {v1}, Landroid/view/Display;->getRotation()I

    move-result v2

    .line 547
    .local v2, "displayRotation":I
    const/4 v0, 0x0

    .line 548
    .local v0, "degrees":I
    packed-switch v2, :pswitch_data_0

    .line 556
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->info:Landroid/hardware/Camera$CameraInfo;

    iget v4, v4, Landroid/hardware/Camera$CameraInfo;->facing:I

    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    .line 557
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->info:Landroid/hardware/Camera$CameraInfo;

    iget v4, v4, Landroid/hardware/Camera$CameraInfo;->orientation:I

    add-int/2addr v4, v0

    rem-int/lit16 v3, v4, 0x168

    .line 558
    .local v3, "result":I
    rsub-int v4, v3, 0x168

    rem-int/lit16 v3, v4, 0x168

    .line 562
    :goto_1
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v4, v3}, Landroid/hardware/Camera;->setDisplayOrientation(I)V

    .line 563
    return v3

    .line 549
    .end local v3    # "result":I
    :pswitch_0
    const/4 v0, 0x0

    goto :goto_0

    .line 550
    :pswitch_1
    const/16 v0, 0x5a

    goto :goto_0

    .line 551
    :pswitch_2
    const/16 v0, 0xb4

    goto :goto_0

    .line 552
    :pswitch_3
    const/16 v0, 0x10e

    goto :goto_0

    .line 560
    :cond_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->info:Landroid/hardware/Camera$CameraInfo;

    iget v4, v4, Landroid/hardware/Camera$CameraInfo;->orientation:I

    sub-int/2addr v4, v0

    add-int/lit16 v4, v4, 0x168

    rem-int/lit16 v3, v4, 0x168

    .restart local v3    # "result":I
    goto :goto_1

    .line 548
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 236
    const-string v0, "camera_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 237
    return-void
.end method

.method public setupCameras()V
    .locals 6

    .prologue
    .line 393
    :try_start_0
    invoke-static {}, Landroid/hardware/Camera;->getNumberOfCameras()I

    move-result v2

    .line 394
    .local v2, "numCameras":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_2

    .line 395
    new-instance v1, Landroid/hardware/Camera$CameraInfo;

    invoke-direct {v1}, Landroid/hardware/Camera$CameraInfo;-><init>()V

    .line 396
    .local v1, "info":Landroid/hardware/Camera$CameraInfo;
    invoke-static {v0, v1}, Landroid/hardware/Camera;->getCameraInfo(ILandroid/hardware/Camera$CameraInfo;)V

    .line 397
    iget v4, v1, Landroid/hardware/Camera$CameraInfo;->facing:I

    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    if-ne v4, v5, :cond_0

    .line 398
    new-instance v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    invoke-direct {v3, p0, v0, v1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;ILandroid/hardware/Camera$CameraInfo;)V

    .line 399
    .local v3, "pmInfo":Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 402
    .end local v3    # "pmInfo":Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
    :cond_0
    iget v4, v1, Landroid/hardware/Camera$CameraInfo;->facing:I

    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    if-ne v4, v5, :cond_1

    .line 403
    new-instance v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    invoke-direct {v3, p0, v0, v1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;-><init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;ILandroid/hardware/Camera$CameraInfo;)V

    .line 404
    .restart local v3    # "pmInfo":Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 394
    .end local v3    # "pmInfo":Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 408
    .end local v1    # "info":Landroid/hardware/Camera$CameraInfo;
    :cond_2
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 409
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->BACK_CAMERA:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    .line 410
    .local v1, "info":Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
    iput-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    .line 411
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget v4, v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->cameraId:I

    invoke-static {v4}, Landroid/hardware/Camera;->open(I)Landroid/hardware/Camera;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    .line 412
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    invoke-direct {p0, v4}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraFlash(Ljava/lang/String;)V

    .line 423
    .end local v0    # "i":I
    .end local v1    # "info":Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
    .end local v2    # "numCameras":I
    :cond_3
    :goto_1
    return-void

    .line 413
    .restart local v0    # "i":I
    .restart local v2    # "numCameras":I
    :cond_4
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 414
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->cameraList:Ljava/util/Map;

    iget v5, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    .line 415
    .restart local v1    # "info":Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
    iput-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    .line 416
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget v4, v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->cameraId:I

    invoke-static {v4}, Landroid/hardware/Camera;->open(I)Landroid/hardware/Camera;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    .line 417
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    invoke-direct {p0, v4}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraFlash(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 420
    .end local v0    # "i":I
    .end local v1    # "info":Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
    .end local v2    # "numCameras":I
    :catch_0
    move-exception v4

    goto :goto_1
.end method
