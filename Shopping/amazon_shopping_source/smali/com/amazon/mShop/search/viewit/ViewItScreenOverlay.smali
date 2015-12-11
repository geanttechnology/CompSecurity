.class public Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;
.super Ljava/lang/Object;
.source "ViewItScreenOverlay.java"


# instance fields
.field private mDescriptionLine1:Ljava/lang/String;

.field private mDescriptionLine2:Ljava/lang/String;

.field private mInstructionalTextHeight:I

.field private mOverLayStartText:Ljava/lang/String;

.field private mScreenHeight:I

.field private mScreenWidth:I

.field private mStatus:Ljava/lang/String;

.field private mSteadyText:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/FSECameraActivity;)V
    .locals 3
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->scanit_search_camera_overlay_start_text:I

    invoke-virtual {p1, v1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mOverLayStartText:Ljava/lang/String;

    .line 40
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->scanit_search_camera_overlay_steady:I

    invoke-virtual {p1, v1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mSteadyText:Ljava/lang/String;

    .line 41
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->scanit_search_camera_overlay_info_text_line1:I

    invoke-virtual {p1, v1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mDescriptionLine1:Ljava/lang/String;

    .line 42
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->scanit_search_camera_overlay_info_text_line2:I

    invoke-virtual {p1, v1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mDescriptionLine2:Ljava/lang/String;

    .line 43
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_barcode_scan_toolbar_height:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iput v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    .line 44
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mOverLayStartText:Ljava/lang/String;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mStatus:Ljava/lang/String;

    .line 46
    invoke-static {p1}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->getScreenSize(Lcom/amazon/mShop/AmazonActivity;)Landroid/graphics/Point;

    move-result-object v0

    .line 47
    .local v0, "size":Landroid/graphics/Point;
    iget v1, v0, Landroid/graphics/Point;->x:I

    iput v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mScreenWidth:I

    .line 48
    iget v1, v0, Landroid/graphics/Point;->y:I

    iput v1, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mScreenHeight:I

    .line 49
    return-void
.end method

.method private getScanBoxRect(Lcom/amazon/mShop/search/viewit/FSECameraActivity;)Landroid/graphics/Rect;
    .locals 12
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    .prologue
    const/high16 v10, 0x40000000    # 2.0f

    const v9, 0x3fb33333    # 1.4f

    const/high16 v8, 0x3f400000    # 0.75f

    .line 203
    iget v5, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mScreenWidth:I

    .line 205
    .local v5, "width":I
    iget v6, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mScreenHeight:I

    iget v7, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    mul-int/lit8 v7, v7, 0x2

    sub-int v2, v6, v7

    .line 208
    .local v2, "height":I
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v6

    iget v6, v6, Landroid/content/res/Configuration;->orientation:I

    const/4 v7, 0x1

    if-ne v6, v7, :cond_0

    .line 209
    int-to-float v6, v5

    div-float v1, v6, v9

    .line 210
    .local v1, "boxWidth":F
    mul-float v0, v1, v8

    .line 215
    .local v0, "boxHeight":F
    :goto_0
    int-to-float v6, v5

    sub-float/2addr v6, v1

    div-float v3, v6, v10

    .line 216
    .local v3, "originX":F
    int-to-float v6, v2

    sub-float/2addr v6, v0

    div-float/2addr v6, v10

    iget v7, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-float v7, v7

    add-float v4, v6, v7

    .line 218
    .local v4, "originY":F
    new-instance v6, Landroid/graphics/Rect;

    invoke-static {v3}, Landroid/util/FloatMath;->floor(F)F

    move-result v7

    float-to-int v7, v7

    float-to-double v8, v4

    invoke-static {v8, v9}, Ljava/lang/Math;->floor(D)D

    move-result-wide v8

    double-to-int v8, v8

    add-float v9, v3, v1

    invoke-static {v9}, Landroid/util/FloatMath;->ceil(F)F

    move-result v9

    float-to-int v9, v9

    add-float v10, v4, v0

    float-to-double v10, v10

    invoke-static {v10, v11}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v10

    double-to-int v10, v10

    invoke-direct {v6, v7, v8, v9, v10}, Landroid/graphics/Rect;-><init>(IIII)V

    return-object v6

    .line 212
    .end local v0    # "boxHeight":F
    .end local v1    # "boxWidth":F
    .end local v3    # "originX":F
    .end local v4    # "originY":F
    :cond_0
    int-to-float v6, v2

    div-float v0, v6, v9

    .line 213
    .restart local v0    # "boxHeight":F
    div-float v1, v0, v8

    .restart local v1    # "boxWidth":F
    goto :goto_0
.end method

.method private initPaint(Landroid/graphics/Paint;)V
    .locals 3
    .param p1, "paint"    # Landroid/graphics/Paint;

    .prologue
    const/4 v2, 0x1

    const/16 v1, 0xff

    .line 190
    sget-object v0, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 191
    invoke-virtual {p1, v1, v1, v1, v1}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 192
    invoke-virtual {p1, v2}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 193
    invoke-virtual {p1, v2}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 194
    invoke-virtual {p1, v2}, Landroid/graphics/Paint;->setDither(Z)V

    .line 195
    sget-object v0, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 196
    return-void
.end method


# virtual methods
.method public drawScreenOverlay(Lcom/amazon/mShop/search/viewit/FSECameraActivity;Landroid/graphics/Canvas;Ljava/util/List;Lcom/amazon/mShop/search/viewit/CameraPreview;Z)V
    .locals 44
    .param p1, "activity"    # Lcom/amazon/mShop/search/viewit/FSECameraActivity;
    .param p2, "canvas"    # Landroid/graphics/Canvas;
    .param p4, "preview"    # Lcom/amazon/mShop/search/viewit/CameraPreview;
    .param p5, "scanningSuccess"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/search/viewit/FSECameraActivity;",
            "Landroid/graphics/Canvas;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/search/viewit/FSEGraphic;",
            ">;",
            "Lcom/amazon/mShop/search/viewit/CameraPreview;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 62
    .local p3, "graphicList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/search/viewit/FSEGraphic;>;"
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->getCameraScreenMarginLeft()I

    move-result v33

    .line 64
    .local v33, "leftMargin":I
    move-object/from16 v0, p1

    iget-boolean v4, v0, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->mIsBarcodeScanOnly:Z

    if-nez v4, :cond_0

    .line 65
    invoke-static/range {p3 .. p3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 66
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v32

    .local v32, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface/range {v32 .. v32}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface/range {v32 .. v32}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v30

    check-cast v30, Lcom/amazon/mShop/search/viewit/FSEGraphic;

    .line 67
    .local v30, "g":Lcom/amazon/mShop/search/viewit/FSEGraphic;
    move-object/from16 v0, v30

    move-object/from16 v1, p2

    move-object/from16 v2, p4

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/FSEGraphic;->draw(Landroid/graphics/Canvas;Lcom/amazon/mShop/search/viewit/CameraPreview;)V

    goto :goto_0

    .line 71
    .end local v30    # "g":Lcom/amazon/mShop/search/viewit/FSEGraphic;
    .end local v32    # "i$":Ljava/util/Iterator;
    :cond_0
    if-eqz v33, :cond_1

    .line 72
    invoke-virtual/range {p2 .. p2}, Landroid/graphics/Canvas;->save()I

    .line 73
    invoke-static/range {v33 .. v33}, Ljava/lang/Math;->abs(I)I

    move-result v4

    int-to-float v4, v4

    const/4 v5, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Canvas;->translate(FF)V

    .line 76
    :cond_1
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$color;->photo_capture_dark_background:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    .line 77
    .local v8, "darkBackground":I
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$color;->photo_capture_light_background:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    .line 78
    .local v9, "lightBackground":I
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v4

    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Display;->getWidth()I

    move-result v40

    .line 79
    .local v40, "screenWidth":I
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v4

    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Display;->getHeight()I

    move-result v41

    .line 81
    .local v41, "screenheight":I
    new-instance v35, Landroid/graphics/Paint;

    invoke-direct/range {v35 .. v35}, Landroid/graphics/Paint;-><init>()V

    .line 82
    .local v35, "paint":Landroid/graphics/Paint;
    new-instance v37, Landroid/graphics/Rect;

    invoke-direct/range {v37 .. v37}, Landroid/graphics/Rect;-><init>()V

    .line 83
    .local v37, "rect":Landroid/graphics/Rect;
    sget-object v4, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    move-object/from16 v0, v35

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 84
    move-object/from16 v0, v35

    invoke-virtual {v0, v8}, Landroid/graphics/Paint;->setColor(I)V

    .line 86
    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget v6, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-double v6, v6

    const-wide/high16 v11, 0x3fe8000000000000L    # 0.75

    mul-double/2addr v6, v11

    double-to-int v6, v6

    move-object/from16 v0, v37

    move/from16 v1, v40

    invoke-virtual {v0, v4, v5, v1, v6}, Landroid/graphics/Rect;->set(IIII)V

    .line 87
    move-object/from16 v0, p2

    move-object/from16 v1, v37

    move-object/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 89
    new-instance v3, Landroid/graphics/LinearGradient;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget v5, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-double v5, v5

    const-wide/high16 v11, 0x3fe8000000000000L    # 0.75

    mul-double/2addr v5, v11

    double-to-int v5, v5

    int-to-float v5, v5

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget v7, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-float v7, v7

    sget-object v10, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    invoke-direct/range {v3 .. v10}, Landroid/graphics/LinearGradient;-><init>(FFFFIILandroid/graphics/Shader$TileMode;)V

    .line 90
    .local v3, "lgTop":Landroid/graphics/LinearGradient;
    move-object/from16 v0, v35

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 91
    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget v5, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-double v5, v5

    const-wide/high16 v11, 0x3fe8000000000000L    # 0.75

    mul-double/2addr v5, v11

    double-to-int v5, v5

    move-object/from16 v0, p0

    iget v6, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    move-object/from16 v0, v37

    move/from16 v1, v40

    invoke-virtual {v0, v4, v5, v1, v6}, Landroid/graphics/Rect;->set(IIII)V

    .line 92
    move-object/from16 v0, p2

    move-object/from16 v1, v37

    move-object/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 95
    new-instance v10, Landroid/graphics/LinearGradient;

    const/4 v11, 0x0

    move-object/from16 v0, p0

    iget v4, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    sub-int v4, v41, v4

    int-to-float v12, v4

    const/4 v13, 0x0

    move-object/from16 v0, p0

    iget v4, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-double v4, v4

    const-wide/high16 v6, 0x3fe8000000000000L    # 0.75

    mul-double/2addr v4, v6

    double-to-int v4, v4

    sub-int v4, v41, v4

    int-to-float v14, v4

    sget-object v17, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    move v15, v9

    move/from16 v16, v8

    invoke-direct/range {v10 .. v17}, Landroid/graphics/LinearGradient;-><init>(FFFFIILandroid/graphics/Shader$TileMode;)V

    .line 96
    .local v10, "lgBottom":Landroid/graphics/LinearGradient;
    move-object/from16 v0, v35

    invoke-virtual {v0, v10}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 97
    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget v5, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    sub-int v5, v41, v5

    move-object/from16 v0, p0

    iget v6, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-double v6, v6

    const-wide/high16 v11, 0x3fe8000000000000L    # 0.75

    mul-double/2addr v6, v11

    double-to-int v6, v6

    sub-int v6, v41, v6

    move-object/from16 v0, v37

    move/from16 v1, v40

    invoke-virtual {v0, v4, v5, v1, v6}, Landroid/graphics/Rect;->set(IIII)V

    .line 98
    move-object/from16 v0, p2

    move-object/from16 v1, v37

    move-object/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 100
    move-object/from16 v0, v35

    invoke-virtual {v0, v8}, Landroid/graphics/Paint;->setColor(I)V

    .line 101
    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget v5, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-double v5, v5

    const-wide/high16 v11, 0x3fe8000000000000L    # 0.75

    mul-double/2addr v5, v11

    double-to-int v5, v5

    sub-int v5, v41, v5

    move-object/from16 v0, v37

    move/from16 v1, v40

    move/from16 v2, v41

    invoke-virtual {v0, v4, v5, v1, v2}, Landroid/graphics/Rect;->set(IIII)V

    .line 102
    move-object/from16 v0, p2

    move-object/from16 v1, v37

    move-object/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 106
    new-instance v43, Landroid/text/TextPaint;

    invoke-direct/range {v43 .. v43}, Landroid/text/TextPaint;-><init>()V

    .line 107
    .local v43, "tp":Landroid/text/TextPaint;
    move-object/from16 v0, p0

    move-object/from16 v1, v43

    invoke-direct {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->initPaint(Landroid/graphics/Paint;)V

    .line 108
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$dimen;->scanit_help_text_font_size:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v4

    move-object/from16 v0, v43

    invoke-virtual {v0, v4}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 109
    sget-object v4, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    const/4 v5, 0x1

    invoke-static {v4, v5}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object v4

    move-object/from16 v0, v43

    invoke-virtual {v0, v4}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 110
    invoke-virtual/range {v43 .. v43}, Landroid/text/TextPaint;->ascent()F

    move-result v4

    neg-float v4, v4

    invoke-virtual/range {v43 .. v43}, Landroid/text/TextPaint;->descent()F

    move-result v5

    add-float v42, v4, v5

    .line 111
    .local v42, "topTextHeight":F
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mStatus:Ljava/lang/String;

    const/4 v5, 0x5

    const/high16 v6, 0x40000000    # 2.0f

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v11, Lcom/amazon/mShop/android/lib/R$dimen;->a9_barcode_scanit_overlay_view_instructional_text_padding:I

    invoke-virtual {v7, v11}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v7

    mul-float/2addr v6, v7

    float-to-int v6, v6

    sub-int v6, v40, v6

    move-object/from16 v0, v43

    invoke-static {v4, v5, v0, v6}, Lcom/amazon/mShop/util/UIUtils;->breakLines(Ljava/lang/String;ILandroid/text/TextPaint;I)Ljava/util/List;

    move-result-object v34

    .line 113
    .local v34, "lines":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v34, :cond_2

    .line 114
    const/16 v31, 0x0

    .local v31, "i":I
    :goto_1
    invoke-interface/range {v34 .. v34}, Ljava/util/List;->size()I

    move-result v4

    move/from16 v0, v31

    if-ge v0, v4, :cond_2

    .line 115
    move-object/from16 v0, v34

    move/from16 v1, v31

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v38

    check-cast v38, Ljava/lang/String;

    .line 117
    .local v38, "s":Ljava/lang/String;
    move/from16 v0, v40

    int-to-float v4, v0

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    move-object/from16 v0, p0

    iget v5, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    int-to-float v5, v5

    invoke-interface/range {v34 .. v34}, Ljava/util/List;->size()I

    move-result v6

    int-to-float v6, v6

    mul-float v6, v6, v42

    sub-float/2addr v5, v6

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    move/from16 v0, v31

    int-to-float v6, v0

    mul-float v6, v6, v42

    add-float/2addr v5, v6

    invoke-virtual/range {v43 .. v43}, Landroid/text/TextPaint;->ascent()F

    move-result v6

    neg-float v6, v6

    add-float/2addr v5, v6

    move-object/from16 v0, p2

    move-object/from16 v1, v38

    move-object/from16 v2, v43

    invoke-virtual {v0, v1, v4, v5, v2}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 114
    add-int/lit8 v31, v31, 0x1

    goto :goto_1

    .line 122
    .end local v31    # "i":I
    .end local v38    # "s":Ljava/lang/String;
    :cond_2
    new-instance v27, Landroid/graphics/Paint;

    invoke-direct/range {v27 .. v27}, Landroid/graphics/Paint;-><init>()V

    .line 123
    .local v27, "bottomPaint":Landroid/graphics/Paint;
    move-object/from16 v0, p0

    move-object/from16 v1, v27

    invoke-direct {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->initPaint(Landroid/graphics/Paint;)V

    .line 124
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$dimen;->scanit_bottom_description_text_font_size:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v4

    move-object/from16 v0, v27

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 125
    invoke-virtual/range {v27 .. v27}, Landroid/graphics/Paint;->ascent()F

    move-result v4

    neg-float v4, v4

    invoke-virtual/range {v27 .. v27}, Landroid/graphics/Paint;->descent()F

    move-result v5

    add-float v28, v4, v5

    .line 126
    .local v28, "bottomTextHeight":F
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mDescriptionLine1:Ljava/lang/String;

    move/from16 v0, v40

    int-to-float v5, v0

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    move-object/from16 v0, p0

    iget v6, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    div-int/lit8 v6, v6, 0x2

    sub-int v6, v41, v6

    int-to-float v6, v6

    sub-float v6, v6, v28

    invoke-virtual/range {v27 .. v27}, Landroid/graphics/Paint;->ascent()F

    move-result v7

    neg-float v7, v7

    add-float/2addr v6, v7

    move-object/from16 v0, p2

    move-object/from16 v1, v27

    invoke-virtual {v0, v4, v5, v6, v1}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 127
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mDescriptionLine2:Ljava/lang/String;

    move/from16 v0, v40

    int-to-float v5, v0

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    move-object/from16 v0, p0

    iget v6, v0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mInstructionalTextHeight:I

    div-int/lit8 v6, v6, 0x2

    sub-int v6, v41, v6

    int-to-float v6, v6

    invoke-virtual/range {v27 .. v27}, Landroid/graphics/Paint;->ascent()F

    move-result v7

    neg-float v7, v7

    add-float/2addr v6, v7

    move-object/from16 v0, p2

    move-object/from16 v1, v27

    invoke-virtual {v0, v4, v5, v6, v1}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 130
    new-instance v16, Landroid/graphics/Paint;

    invoke-direct/range {v16 .. v16}, Landroid/graphics/Paint;-><init>()V

    .line 131
    .local v16, "rectBoxPaint":Landroid/graphics/Paint;
    sget-object v4, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 132
    const/high16 v4, 0x40a00000    # 5.0f

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 133
    if-eqz p5, :cond_4

    const v29, -0xff0100

    .line 134
    .local v29, "color":I
    :goto_2
    move-object/from16 v0, v16

    move/from16 v1, v29

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 135
    invoke-direct/range {p0 .. p1}, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->getScanBoxRect(Lcom/amazon/mShop/search/viewit/FSECameraActivity;)Landroid/graphics/Rect;

    move-result-object v39

    .line 136
    .local v39, "scanBoxRect":Landroid/graphics/Rect;
    move-object/from16 v0, v39

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v24, v0

    .line 137
    .local v24, "arrowBoxLeft":I
    move-object/from16 v0, v39

    iget v4, v0, Landroid/graphics/Rect;->top:I

    add-int/lit8 v26, v4, -0x12

    .line 138
    .local v26, "arrowBoxTop":I
    move-object/from16 v0, v39

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v25, v0

    .line 139
    .local v25, "arrowBoxRight":I
    move-object/from16 v0, v39

    iget v4, v0, Landroid/graphics/Rect;->bottom:I

    add-int/lit8 v23, v4, 0x12

    .line 142
    .local v23, "arrowBoxBottom":I
    move/from16 v0, v24

    int-to-float v12, v0

    move/from16 v0, v26

    int-to-float v13, v0

    move/from16 v0, v25

    int-to-float v14, v0

    move/from16 v0, v26

    int-to-float v15, v0

    move-object/from16 v11, p2

    invoke-virtual/range {v11 .. v16}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 144
    move/from16 v0, v24

    int-to-float v12, v0

    move/from16 v0, v23

    int-to-float v13, v0

    move/from16 v0, v25

    int-to-float v14, v0

    move/from16 v0, v23

    int-to-float v15, v0

    move-object/from16 v11, p2

    invoke-virtual/range {v11 .. v16}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 147
    const/high16 v4, 0x40400000    # 3.0f

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 148
    sget-object v4, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 150
    new-instance v36, Landroid/graphics/Path;

    invoke-direct/range {v36 .. v36}, Landroid/graphics/Path;-><init>()V

    .line 151
    .local v36, "path":Landroid/graphics/Path;
    move/from16 v0, v24

    int-to-float v4, v0

    move/from16 v0, v26

    int-to-float v5, v0

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->moveTo(FF)V

    .line 152
    move/from16 v0, v24

    int-to-float v4, v0

    add-int/lit8 v5, v26, 0x12

    int-to-float v5, v5

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 153
    add-int/lit8 v4, v24, 0x12

    int-to-float v4, v4

    move/from16 v0, v26

    int-to-float v5, v0

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 154
    invoke-virtual/range {v36 .. v36}, Landroid/graphics/Path;->close()V

    .line 155
    move-object/from16 v0, p2

    move-object/from16 v1, v36

    move-object/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 157
    move/from16 v0, v25

    int-to-float v4, v0

    move/from16 v0, v26

    int-to-float v5, v0

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->moveTo(FF)V

    .line 158
    move/from16 v0, v25

    int-to-float v4, v0

    add-int/lit8 v5, v26, 0x12

    int-to-float v5, v5

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 159
    add-int/lit8 v4, v25, -0x12

    int-to-float v4, v4

    move/from16 v0, v26

    int-to-float v5, v0

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 160
    invoke-virtual/range {v36 .. v36}, Landroid/graphics/Path;->close()V

    .line 161
    move-object/from16 v0, p2

    move-object/from16 v1, v36

    move-object/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 163
    move/from16 v0, v24

    int-to-float v4, v0

    move/from16 v0, v23

    int-to-float v5, v0

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->moveTo(FF)V

    .line 164
    move/from16 v0, v24

    int-to-float v4, v0

    add-int/lit8 v5, v23, -0x12

    int-to-float v5, v5

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 165
    add-int/lit8 v4, v24, 0x12

    int-to-float v4, v4

    move/from16 v0, v23

    int-to-float v5, v0

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 166
    invoke-virtual/range {v36 .. v36}, Landroid/graphics/Path;->close()V

    .line 167
    move-object/from16 v0, p2

    move-object/from16 v1, v36

    move-object/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 169
    move/from16 v0, v25

    int-to-float v4, v0

    move/from16 v0, v23

    int-to-float v5, v0

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->moveTo(FF)V

    .line 170
    move/from16 v0, v25

    int-to-float v4, v0

    add-int/lit8 v5, v23, -0x12

    int-to-float v5, v5

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 171
    add-int/lit8 v4, v25, -0x12

    int-to-float v4, v4

    move/from16 v0, v23

    int-to-float v5, v0

    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Path;->lineTo(FF)V

    .line 172
    invoke-virtual/range {v36 .. v36}, Landroid/graphics/Path;->close()V

    .line 173
    move-object/from16 v0, p2

    move-object/from16 v1, v36

    move-object/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 176
    move/from16 v0, v26

    int-to-float v4, v0

    sub-int v5, v23, v26

    int-to-float v5, v5

    const/high16 v6, 0x3f000000    # 0.5f

    mul-float/2addr v5, v6

    add-float v19, v4, v5

    .line 177
    .local v19, "verticalMiddle":F
    new-instance v22, Landroid/graphics/Paint;

    invoke-direct/range {v22 .. v22}, Landroid/graphics/Paint;-><init>()V

    .line 178
    .local v22, "midLinePaint":Landroid/graphics/Paint;
    const/16 v4, 0xff

    const/16 v5, 0x99

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v0, v22

    invoke-virtual {v0, v4, v5, v6, v7}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 179
    const/high16 v4, 0x40000000    # 2.0f

    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 180
    sget-object v4, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 181
    add-int/lit8 v4, v24, 0x12

    int-to-float v0, v4

    move/from16 v18, v0

    add-int/lit8 v4, v25, -0x12

    int-to-float v0, v4

    move/from16 v20, v0

    move-object/from16 v17, p2

    move/from16 v21, v19

    invoke-virtual/range {v17 .. v22}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 183
    if-eqz v33, :cond_3

    .line 184
    invoke-virtual/range {p2 .. p2}, Landroid/graphics/Canvas;->restore()V

    .line 187
    .end local v3    # "lgTop":Landroid/graphics/LinearGradient;
    .end local v8    # "darkBackground":I
    .end local v9    # "lightBackground":I
    .end local v10    # "lgBottom":Landroid/graphics/LinearGradient;
    .end local v16    # "rectBoxPaint":Landroid/graphics/Paint;
    .end local v19    # "verticalMiddle":F
    .end local v22    # "midLinePaint":Landroid/graphics/Paint;
    .end local v23    # "arrowBoxBottom":I
    .end local v24    # "arrowBoxLeft":I
    .end local v25    # "arrowBoxRight":I
    .end local v26    # "arrowBoxTop":I
    .end local v27    # "bottomPaint":Landroid/graphics/Paint;
    .end local v28    # "bottomTextHeight":F
    .end local v29    # "color":I
    .end local v34    # "lines":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v35    # "paint":Landroid/graphics/Paint;
    .end local v36    # "path":Landroid/graphics/Path;
    .end local v37    # "rect":Landroid/graphics/Rect;
    .end local v39    # "scanBoxRect":Landroid/graphics/Rect;
    .end local v40    # "screenWidth":I
    .end local v41    # "screenheight":I
    .end local v42    # "topTextHeight":F
    .end local v43    # "tp":Landroid/text/TextPaint;
    :cond_3
    return-void

    .line 133
    .restart local v3    # "lgTop":Landroid/graphics/LinearGradient;
    .restart local v8    # "darkBackground":I
    .restart local v9    # "lightBackground":I
    .restart local v10    # "lgBottom":Landroid/graphics/LinearGradient;
    .restart local v16    # "rectBoxPaint":Landroid/graphics/Paint;
    .restart local v27    # "bottomPaint":Landroid/graphics/Paint;
    .restart local v28    # "bottomTextHeight":F
    .restart local v34    # "lines":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v35    # "paint":Landroid/graphics/Paint;
    .restart local v37    # "rect":Landroid/graphics/Rect;
    .restart local v40    # "screenWidth":I
    .restart local v41    # "screenheight":I
    .restart local v42    # "topTextHeight":F
    .restart local v43    # "tp":Landroid/text/TextPaint;
    :cond_4
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/search/viewit/FSECameraActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$color;->view_it_screen_rect_orange_line:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v29

    goto/16 :goto_2
.end method

.method public setSteadyStatus(Z)V
    .locals 1
    .param p1, "status"    # Z

    .prologue
    .line 223
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mOverLayStartText:Ljava/lang/String;

    :goto_0
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mStatus:Ljava/lang/String;

    .line 224
    return-void

    .line 223
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItScreenOverlay;->mSteadyText:Ljava/lang/String;

    goto :goto_0
.end method
