.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;
.super Ljava/lang/Object;
.source "CameraPreviewFragment.java"

# interfaces
.implements Landroid/hardware/Camera$PictureCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CameraPreviewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V
    .locals 0

    .prologue
    .line 616
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getClipRect(II)Landroid/graphics/Rect;
    .locals 17
    .param p1, "bmpWidth"    # I
    .param p2, "bmpHeight"    # I

    .prologue
    .line 719
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    .line 722
    .local v2, "clipRect":Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->getSurfaceViewHeight()I

    move-result v10

    .line 723
    .local v10, "surfaceViewHeight":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->preview:Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->getSurfaceViewWidth()I

    move-result v11

    .line 727
    .local v11, "surfaceViewWidth":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-virtual {v15}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v15

    invoke-virtual {v15}, Landroid/support/v4/app/FragmentActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v15

    invoke-interface {v15}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v15

    invoke-virtual {v15}, Landroid/view/Display;->getWidth()I

    move-result v9

    .line 728
    .local v9, "screenWidth":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-virtual {v15}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v15

    invoke-virtual {v15}, Landroid/support/v4/app/FragmentActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v15

    invoke-interface {v15}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v15

    invoke-virtual {v15}, Landroid/view/Display;->getHeight()I

    move-result v8

    .line 731
    .local v8, "screenHeight":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewPortTop()I

    move-result v7

    .line 732
    .local v7, "offsetFromTop":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportLeft()I

    move-result v5

    .line 733
    .local v5, "offsetFromLeft":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewPortTop()I

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportHeight()I

    move-result v16

    add-int v15, v15, v16

    sub-int v4, v10, v15

    .line 734
    .local v4, "offsetFromBottom":I
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportLeft()I

    move-result v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportWidth()I

    move-result v16

    add-int v15, v15, v16

    sub-int v6, v11, v15

    .line 736
    .local v6, "offsetFromRight":I
    move/from16 v0, p1

    move/from16 v1, p2

    if-gt v0, v1, :cond_1

    .line 738
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportWidth()I

    move-result v15

    int-to-float v15, v15

    int-to-float v0, v11

    move/from16 v16, v0

    div-float v13, v15, v16

    .line 739
    .local v13, "x_scale_factor":F
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportHeight()I

    move-result v15

    int-to-float v15, v15

    int-to-float v0, v10

    move/from16 v16, v0

    div-float v14, v15, v16

    .line 741
    .local v14, "y_scale_factor":F
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->info:Landroid/hardware/Camera$CameraInfo;

    iget v15, v15, Landroid/hardware/Camera$CameraInfo;->orientation:I

    const/16 v16, 0xb4

    move/from16 v0, v16

    if-ne v15, v0, :cond_0

    .line 743
    int-to-float v15, v6

    int-to-float v0, v11

    move/from16 v16, v0

    div-float v15, v15, v16

    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    move-result v3

    .line 744
    .local v3, "left_offset_scale_factor":F
    int-to-float v15, v4

    int-to-float v0, v10

    move/from16 v16, v0

    div-float v15, v15, v16

    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    move-result v12

    .line 769
    .local v12, "top_offset_scale_factor":F
    :goto_0
    move/from16 v0, p1

    int-to-float v15, v0

    mul-float/2addr v15, v3

    float-to-int v15, v15

    iput v15, v2, Landroid/graphics/Rect;->left:I

    .line 770
    move/from16 v0, p2

    int-to-float v15, v0

    mul-float/2addr v15, v12

    float-to-int v15, v15

    iput v15, v2, Landroid/graphics/Rect;->top:I

    .line 771
    move/from16 v0, p1

    int-to-float v15, v0

    mul-float/2addr v15, v13

    float-to-int v15, v15

    iput v15, v2, Landroid/graphics/Rect;->right:I

    .line 772
    move/from16 v0, p2

    int-to-float v15, v0

    mul-float/2addr v15, v14

    float-to-int v15, v15

    iput v15, v2, Landroid/graphics/Rect;->bottom:I

    .line 774
    return-object v2

    .line 748
    .end local v3    # "left_offset_scale_factor":F
    .end local v12    # "top_offset_scale_factor":F
    :cond_0
    int-to-float v15, v5

    int-to-float v0, v11

    move/from16 v16, v0

    div-float v15, v15, v16

    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    move-result v3

    .line 749
    .restart local v3    # "left_offset_scale_factor":F
    int-to-float v15, v7

    int-to-float v0, v10

    move/from16 v16, v0

    div-float v15, v15, v16

    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    move-result v12

    .restart local v12    # "top_offset_scale_factor":F
    goto :goto_0

    .line 753
    .end local v3    # "left_offset_scale_factor":F
    .end local v12    # "top_offset_scale_factor":F
    .end local v13    # "x_scale_factor":F
    .end local v14    # "y_scale_factor":F
    :cond_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportWidth()I

    move-result v15

    int-to-float v15, v15

    int-to-float v0, v11

    move/from16 v16, v0

    div-float v14, v15, v16

    .line 754
    .restart local v14    # "y_scale_factor":F
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v15}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportHeight()I

    move-result v15

    int-to-float v15, v15

    int-to-float v0, v10

    move/from16 v16, v0

    div-float v13, v15, v16

    .line 756
    .restart local v13    # "x_scale_factor":F
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget-object v15, v15, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->info:Landroid/hardware/Camera$CameraInfo;

    iget v15, v15, Landroid/hardware/Camera$CameraInfo;->orientation:I

    const/16 v16, 0x5a

    move/from16 v0, v16

    if-ne v15, v0, :cond_2

    .line 758
    int-to-float v15, v7

    int-to-float v0, v10

    move/from16 v16, v0

    div-float v15, v15, v16

    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    move-result v3

    .line 759
    .restart local v3    # "left_offset_scale_factor":F
    int-to-float v15, v6

    int-to-float v0, v11

    move/from16 v16, v0

    div-float v15, v15, v16

    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    move-result v12

    .restart local v12    # "top_offset_scale_factor":F
    goto :goto_0

    .line 763
    .end local v3    # "left_offset_scale_factor":F
    .end local v12    # "top_offset_scale_factor":F
    :cond_2
    int-to-float v15, v4

    int-to-float v0, v10

    move/from16 v16, v0

    div-float v15, v15, v16

    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    move-result v3

    .line 764
    .restart local v3    # "left_offset_scale_factor":F
    int-to-float v15, v5

    int-to-float v0, v11

    move/from16 v16, v0

    div-float v15, v15, v16

    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    move-result v12

    .restart local v12    # "top_offset_scale_factor":F
    goto/16 :goto_0
.end method


# virtual methods
.method public onPictureTaken([BLandroid/hardware/Camera;)V
    .locals 22
    .param p1, "arg0"    # [B
    .param p2, "arg1"    # Landroid/hardware/Camera;

    .prologue
    .line 621
    :try_start_0
    new-instance v18, Landroid/graphics/BitmapFactory$Options;

    invoke-direct/range {v18 .. v18}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 622
    .local v18, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v3, 0x1

    move-object/from16 v0, v18

    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 623
    const/4 v3, 0x0

    move-object/from16 v0, p1

    array-length v4, v0

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-static {v0, v3, v4, v1}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeByteArray([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 624
    move-object/from16 v0, v18

    iget v10, v0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 625
    .local v10, "bmHeight":I
    move-object/from16 v0, v18

    iget v11, v0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    .line 627
    .local v11, "bmpWidth":I
    move-object/from16 v0, p0

    invoke-direct {v0, v11, v10}, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->getClipRect(II)Landroid/graphics/Rect;

    move-result-object v12

    .line 629
    .local v12, "clipRect":Landroid/graphics/Rect;
    new-instance v7, Landroid/graphics/Matrix;

    invoke-direct {v7}, Landroid/graphics/Matrix;-><init>()V

    .line 631
    .local v7, "matrix":Landroid/graphics/Matrix;
    const/high16 v21, 0x3f800000    # 1.0f

    .local v21, "scaleWidth":F
    const/high16 v20, 0x3f800000    # 1.0f

    .line 632
    .local v20, "scaleHeight":F
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATION_MODE:I

    sget v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_THUMBNAIL:I

    if-ne v3, v4, :cond_2

    .line 633
    const/high16 v3, 0x42c80000    # 100.0f

    iget v4, v12, Landroid/graphics/Rect;->right:I

    int-to-float v4, v4

    div-float v21, v3, v4

    .line 634
    const/high16 v3, 0x42c80000    # 100.0f

    iget v4, v12, Landroid/graphics/Rect;->bottom:I

    int-to-float v4, v4

    div-float v20, v3, v4

    .line 635
    move/from16 v0, v21

    move/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 643
    :cond_0
    :goto_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->cameraId:I

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget v4, v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->FRONT_CAMERA:I

    if-ne v3, v4, :cond_3

    .line 644
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->info:Landroid/hardware/Camera$CameraInfo;

    iget v3, v3, Landroid/hardware/Camera$CameraInfo;->orientation:I

    rsub-int v3, v3, 0x168

    int-to-float v3, v3

    invoke-virtual {v7, v3}, Landroid/graphics/Matrix;->postRotate(F)Z

    .line 645
    const/high16 v3, 0x3f800000    # 1.0f

    const/high16 v4, -0x40800000    # -1.0f

    invoke-virtual {v7, v3, v4}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 652
    :goto_1
    new-instance v18, Landroid/graphics/BitmapFactory$Options;

    .end local v18    # "options":Landroid/graphics/BitmapFactory$Options;
    invoke-direct/range {v18 .. v18}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 653
    .restart local v18    # "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v3, 0x1

    move-object/from16 v0, v18

    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 654
    const/4 v3, 0x0

    move-object/from16 v0, p1

    array-length v4, v0

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-static {v0, v3, v4, v5}, Landroid/graphics/BitmapRegionDecoder;->newInstance([BIIZ)Landroid/graphics/BitmapRegionDecoder;

    move-result-object v15

    .line 655
    .local v15, "decoder":Landroid/graphics/BitmapRegionDecoder;
    if-eqz v15, :cond_1

    .line 657
    new-instance v13, Landroid/graphics/Rect;

    invoke-direct {v13, v12}, Landroid/graphics/Rect;-><init>(Landroid/graphics/Rect;)V

    .line 658
    .local v13, "clipRectII":Landroid/graphics/Rect;
    iget v3, v12, Landroid/graphics/Rect;->left:I

    iget v4, v12, Landroid/graphics/Rect;->right:I

    add-int/2addr v3, v4

    iput v3, v13, Landroid/graphics/Rect;->right:I

    .line 659
    iget v3, v12, Landroid/graphics/Rect;->top:I

    iget v4, v12, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v3, v4

    iput v3, v13, Landroid/graphics/Rect;->bottom:I

    .line 660
    move-object/from16 v0, v18

    invoke-virtual {v15, v13, v0}, Landroid/graphics/BitmapRegionDecoder;->decodeRegion(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 661
    .local v2, "croppedBitmap":Landroid/graphics/Bitmap;
    const/4 v3, 0x0

    const/4 v4, 0x0

    iget v5, v12, Landroid/graphics/Rect;->right:I

    iget v6, v12, Landroid/graphics/Rect;->bottom:I

    const/4 v8, 0x1

    invoke-static/range {v2 .. v8}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v14

    .line 665
    .local v14, "correctBmp":Landroid/graphics/Bitmap;
    invoke-static {v14}, Lcom/poshmark/utils/ImageUtils;->saveBitmapToDisk(Landroid/graphics/Bitmap;)Landroid/net/Uri;

    move-result-object v19

    .line 667
    .local v19, "saveFileUri":Landroid/net/Uri;
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V

    .line 668
    const/4 v2, 0x0

    .line 669
    invoke-virtual {v14}, Landroid/graphics/Bitmap;->recycle()V

    .line 670
    const/4 v14, 0x0

    .line 671
    if-eqz v19, :cond_1

    .line 673
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATION_MODE:I

    sget v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    if-ne v3, v4, :cond_4

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-boolean v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->bIsFirstCovershot:Z

    if-eqz v3, :cond_4

    .line 674
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    move-object/from16 v0, v19

    # invokes: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->fireCameraFiltersActivity(Landroid/net/Uri;)V
    invoke-static {v3, v0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$600(Lcom/poshmark/ui/fragments/CameraPreviewFragment;Landroid/net/Uri;)V

    .line 688
    .end local v2    # "croppedBitmap":Landroid/graphics/Bitmap;
    .end local v7    # "matrix":Landroid/graphics/Matrix;
    .end local v10    # "bmHeight":I
    .end local v11    # "bmpWidth":I
    .end local v12    # "clipRect":Landroid/graphics/Rect;
    .end local v13    # "clipRectII":Landroid/graphics/Rect;
    .end local v14    # "correctBmp":Landroid/graphics/Bitmap;
    .end local v15    # "decoder":Landroid/graphics/BitmapRegionDecoder;
    .end local v18    # "options":Landroid/graphics/BitmapFactory$Options;
    .end local v19    # "saveFileUri":Landroid/net/Uri;
    .end local v20    # "scaleHeight":F
    .end local v21    # "scaleWidth":F
    :cond_1
    :goto_2
    return-void

    .line 636
    .restart local v7    # "matrix":Landroid/graphics/Matrix;
    .restart local v10    # "bmHeight":I
    .restart local v11    # "bmpWidth":I
    .restart local v12    # "clipRect":Landroid/graphics/Rect;
    .restart local v18    # "options":Landroid/graphics/BitmapFactory$Options;
    .restart local v20    # "scaleHeight":F
    .restart local v21    # "scaleWidth":F
    :cond_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATION_MODE:I

    sget v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    if-ne v3, v4, :cond_0

    .line 637
    const/high16 v3, 0x44800000    # 1024.0f

    iget v4, v12, Landroid/graphics/Rect;->right:I

    int-to-float v4, v4

    div-float v21, v3, v4

    .line 638
    const/high16 v3, 0x44800000    # 1024.0f

    iget v4, v12, Landroid/graphics/Rect;->bottom:I

    int-to-float v4, v4

    div-float v20, v3, v4

    .line 639
    move/from16 v0, v21

    move/from16 v1, v20

    invoke-virtual {v7, v0, v1}, Landroid/graphics/Matrix;->postScale(FF)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 685
    .end local v7    # "matrix":Landroid/graphics/Matrix;
    .end local v10    # "bmHeight":I
    .end local v11    # "bmpWidth":I
    .end local v12    # "clipRect":Landroid/graphics/Rect;
    .end local v18    # "options":Landroid/graphics/BitmapFactory$Options;
    .end local v20    # "scaleHeight":F
    .end local v21    # "scaleWidth":F
    :catch_0
    move-exception v16

    .line 686
    .local v16, "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_2

    .line 647
    .end local v16    # "e":Ljava/lang/Exception;
    .restart local v7    # "matrix":Landroid/graphics/Matrix;
    .restart local v10    # "bmHeight":I
    .restart local v11    # "bmpWidth":I
    .restart local v12    # "clipRect":Landroid/graphics/Rect;
    .restart local v18    # "options":Landroid/graphics/BitmapFactory$Options;
    .restart local v20    # "scaleHeight":F
    .restart local v21    # "scaleWidth":F
    :cond_3
    :try_start_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentSelectedCamera:Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->info:Landroid/hardware/Camera$CameraInfo;

    iget v3, v3, Landroid/hardware/Camera$CameraInfo;->orientation:I

    int-to-float v3, v3

    invoke-virtual {v7, v3}, Landroid/graphics/Matrix;->postRotate(F)Z

    goto/16 :goto_1

    .line 676
    .restart local v2    # "croppedBitmap":Landroid/graphics/Bitmap;
    .restart local v13    # "clipRectII":Landroid/graphics/Rect;
    .restart local v14    # "correctBmp":Landroid/graphics/Bitmap;
    .restart local v15    # "decoder":Landroid/graphics/BitmapRegionDecoder;
    .restart local v19    # "saveFileUri":Landroid/net/Uri;
    :cond_4
    new-instance v17, Landroid/content/Intent;

    invoke-direct/range {v17 .. v17}, Landroid/content/Intent;-><init>()V

    .line 677
    .local v17, "i":Landroid/content/Intent;
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 678
    .local v9, "b":Landroid/os/Bundle;
    const-string v3, "IMAGE_FILE_URI"

    move-object/from16 v0, v19

    invoke-virtual {v9, v3, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 679
    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 681
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const/4 v4, -0x1

    move-object/from16 v0, v17

    invoke-virtual {v3, v4, v0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->finishActivityWithResult(ILandroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method
