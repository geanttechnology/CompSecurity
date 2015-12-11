.class public Lcom/poshmark/ui/customviews/RoundedCornersImageView;
.super Lcom/poshmark/ui/customviews/PMAvataarImageView;
.source "RoundedCornersImageView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;-><init>(Landroid/content/Context;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMAvataarImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 30
    return-void
.end method

.method public static getCroppedBitmapFromView(Lcom/poshmark/ui/customviews/RoundedCornersImageView;I)Landroid/graphics/Bitmap;
    .locals 17
    .param p0, "imageView"    # Lcom/poshmark/ui/customviews/RoundedCornersImageView;
    .param p1, "pixels"    # I

    .prologue
    .line 53
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v13

    check-cast v13, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v13}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 55
    .local v1, "b":Landroid/graphics/Bitmap;
    const/4 v6, 0x0

    .line 56
    .local v6, "isDefaultImage":Z
    if-nez v1, :cond_1

    .line 57
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v13

    invoke-virtual {v13}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const-string v14, "ic_user_default"

    const-string v15, "drawable"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v13 .. v16}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v5

    .line 58
    .local v5, "id":I
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v13

    invoke-virtual {v13}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    invoke-static {v13, v5}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 59
    .local v2, "bitmap":Landroid/graphics/Bitmap;
    const/4 v6, 0x1

    .line 65
    .end local v5    # "id":I
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getWidth()I

    move-result v13

    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getHeight()I

    move-result v14

    sget-object v15, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v13, v14, v15}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v7

    .line 66
    .local v7, "output":Landroid/graphics/Bitmap;
    new-instance v3, Landroid/graphics/Canvas;

    invoke-direct {v3, v7}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 68
    .local v3, "canvas":Landroid/graphics/Canvas;
    const/4 v4, -0x1

    .line 69
    .local v4, "color":I
    new-instance v8, Landroid/graphics/Paint;

    invoke-direct {v8}, Landroid/graphics/Paint;-><init>()V

    .line 70
    .local v8, "paint":Landroid/graphics/Paint;
    new-instance v9, Landroid/graphics/Rect;

    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getWidth()I

    move-result v15

    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getHeight()I

    move-result v16

    move/from16 v0, v16

    invoke-direct {v9, v13, v14, v15, v0}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 71
    .local v9, "rect":Landroid/graphics/Rect;
    new-instance v10, Landroid/graphics/RectF;

    invoke-direct {v10, v9}, Landroid/graphics/RectF;-><init>(Landroid/graphics/Rect;)V

    .line 72
    .local v10, "rectF":Landroid/graphics/RectF;
    move/from16 v0, p1

    int-to-float v11, v0

    .line 74
    .local v11, "roundPx":F
    const/4 v13, 0x1

    invoke-virtual {v8, v13}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 75
    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-virtual {v3, v13, v14, v15, v0}, Landroid/graphics/Canvas;->drawARGB(IIII)V

    .line 76
    const/4 v13, -0x1

    invoke-virtual {v8, v13}, Landroid/graphics/Paint;->setColor(I)V

    .line 77
    invoke-virtual {v3, v10, v11, v11, v8}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 79
    new-instance v13, Landroid/graphics/PorterDuffXfermode;

    sget-object v14, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v13, v14}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v8, v13}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 80
    new-instance v12, Landroid/graphics/Rect;

    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v15

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v16

    invoke-direct/range {v12 .. v16}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 81
    .local v12, "srcRect":Landroid/graphics/Rect;
    invoke-virtual {v3, v2, v12, v9, v8}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 83
    if-nez v6, :cond_0

    .line 84
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V

    .line 86
    :cond_0
    return-object v7

    .line 62
    .end local v2    # "bitmap":Landroid/graphics/Bitmap;
    .end local v3    # "canvas":Landroid/graphics/Canvas;
    .end local v4    # "color":I
    .end local v7    # "output":Landroid/graphics/Bitmap;
    .end local v8    # "paint":Landroid/graphics/Paint;
    .end local v9    # "rect":Landroid/graphics/Rect;
    .end local v10    # "rectF":Landroid/graphics/RectF;
    .end local v11    # "roundPx":F
    .end local v12    # "srcRect":Landroid/graphics/Rect;
    :cond_1
    sget-object v13, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    const/4 v14, 0x1

    invoke-virtual {v1, v13, v14}, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;

    move-result-object v2

    .restart local v2    # "bitmap":Landroid/graphics/Bitmap;
    goto :goto_0
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v3, 0x0

    .line 35
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 37
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-nez v0, :cond_1

    .line 49
    :cond_0
    :goto_0
    return-void

    .line 41
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getWidth()I

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getHeight()I

    move-result v2

    if-eqz v2, :cond_0

    .line 45
    const/16 v2, 0x8

    invoke-static {p0, v2}, Lcom/poshmark/ui/customviews/RoundedCornersImageView;->getCroppedBitmapFromView(Lcom/poshmark/ui/customviews/RoundedCornersImageView;I)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 46
    .local v1, "roundBitmap":Landroid/graphics/Bitmap;
    const/4 v2, 0x0

    invoke-virtual {p1, v1, v3, v3, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 48
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    goto :goto_0
.end method
