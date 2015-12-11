.class public Lcom/amazon/mShop/imageview/BasePinchImageView;
.super Landroid/widget/ImageView;
.source "BasePinchImageView.java"


# instance fields
.field private final mBaseMatrix:Landroid/graphics/Matrix;

.field private mBitmapDisplayed:Landroid/graphics/Bitmap;

.field private final mChangeMatrix:Landroid/graphics/Matrix;

.field protected mCurrentScaleFactor:F

.field private final mDisplayMatrix:Landroid/graphics/Matrix;

.field private mInitialImageHeight:I

.field private mInitialImageWidth:I

.field private final mMatrixValues:[F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, -0x1

    .line 52
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 16
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBaseMatrix:Landroid/graphics/Matrix;

    .line 24
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mChangeMatrix:Landroid/graphics/Matrix;

    .line 30
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mDisplayMatrix:Landroid/graphics/Matrix;

    .line 35
    const/16 v0, 0x9

    new-array v0, v0, [F

    iput-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mMatrixValues:[F

    .line 42
    iput v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mInitialImageWidth:I

    .line 43
    iput v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mInitialImageHeight:I

    .line 53
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->init()V

    .line 54
    return-void
.end method

.method private center(ZZ)V
    .locals 3
    .param p1, "horizontal"    # Z
    .param p2, "vertical"    # Z

    .prologue
    const/4 v2, 0x0

    .line 233
    iget-object v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    if-nez v1, :cond_1

    .line 239
    :cond_0
    :goto_0
    return-void

    .line 235
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getCenterRectF(ZZ)Landroid/graphics/RectF;

    move-result-object v0

    .line 236
    .local v0, "rect":Landroid/graphics/RectF;
    iget v1, v0, Landroid/graphics/RectF;->left:F

    cmpl-float v1, v1, v2

    if-nez v1, :cond_2

    iget v1, v0, Landroid/graphics/RectF;->top:F

    cmpl-float v1, v1, v2

    if-eqz v1, :cond_0

    .line 237
    :cond_2
    iget v1, v0, Landroid/graphics/RectF;->left:F

    iget v2, v0, Landroid/graphics/RectF;->top:F

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/imageview/BasePinchImageView;->postTranslate(FF)V

    goto :goto_0
.end method

.method private getBitmapRect()Landroid/graphics/RectF;
    .locals 6

    .prologue
    .line 271
    iget-object v2, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    if-nez v2, :cond_0

    .line 272
    const/4 v1, 0x0

    .line 279
    :goto_0
    return-object v1

    .line 273
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object v0

    .line 277
    .local v0, "matrix":Landroid/graphics/Matrix;
    new-instance v1, Landroid/graphics/RectF;

    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getWidth()I

    move-result v2

    neg-int v2, v2

    div-int/lit8 v2, v2, 0x6

    int-to-float v2, v2

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getWidth()I

    move-result v5

    div-int/lit8 v5, v5, 0x6

    add-int/2addr v4, v5

    int-to-float v4, v4

    iget-object v5, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    invoke-virtual {v5}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v5

    int-to-float v5, v5

    invoke-direct {v1, v2, v3, v4, v5}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 278
    .local v1, "rect":Landroid/graphics/RectF;
    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    goto :goto_0
.end method

.method private getCenterRectF(ZZ)Landroid/graphics/RectF;
    .locals 11
    .param p1, "horizontal"    # Z
    .param p2, "vertical"    # Z

    .prologue
    const/high16 v10, 0x40000000    # 2.0f

    const/4 v9, 0x0

    .line 242
    iget-object v7, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    if-nez v7, :cond_0

    new-instance v7, Landroid/graphics/RectF;

    invoke-direct {v7, v9, v9, v9, v9}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 267
    :goto_0
    return-object v7

    .line 243
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getBitmapRect()Landroid/graphics/RectF;

    move-result-object v3

    .line 244
    .local v3, "rect":Landroid/graphics/RectF;
    invoke-virtual {v3}, Landroid/graphics/RectF;->height()F

    move-result v2

    .line 245
    .local v2, "height":F
    invoke-virtual {v3}, Landroid/graphics/RectF;->width()F

    move-result v6

    .line 246
    .local v6, "width":F
    const/4 v0, 0x0

    .local v0, "deltaX":F
    const/4 v1, 0x0

    .line 247
    .local v1, "deltaY":F
    if-eqz p2, :cond_1

    .line 248
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getHeight()I

    move-result v4

    .line 249
    .local v4, "viewHeight":I
    int-to-float v7, v4

    cmpg-float v7, v2, v7

    if-gez v7, :cond_3

    .line 250
    int-to-float v7, v4

    sub-float/2addr v7, v2

    div-float/2addr v7, v10

    iget v8, v3, Landroid/graphics/RectF;->top:F

    sub-float v1, v7, v8

    .line 257
    .end local v4    # "viewHeight":I
    :cond_1
    :goto_1
    if-eqz p1, :cond_2

    .line 258
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getWidth()I

    move-result v5

    .line 259
    .local v5, "viewWidth":I
    int-to-float v7, v5

    cmpg-float v7, v6, v7

    if-gez v7, :cond_5

    .line 260
    int-to-float v7, v5

    sub-float/2addr v7, v6

    div-float/2addr v7, v10

    iget v8, v3, Landroid/graphics/RectF;->left:F

    sub-float v0, v7, v8

    .line 267
    .end local v5    # "viewWidth":I
    :cond_2
    :goto_2
    new-instance v7, Landroid/graphics/RectF;

    invoke-direct {v7, v0, v1, v9, v9}, Landroid/graphics/RectF;-><init>(FFFF)V

    goto :goto_0

    .line 251
    .restart local v4    # "viewHeight":I
    :cond_3
    iget v7, v3, Landroid/graphics/RectF;->top:F

    cmpl-float v7, v7, v9

    if-lez v7, :cond_4

    .line 252
    iget v7, v3, Landroid/graphics/RectF;->top:F

    neg-float v1, v7

    goto :goto_1

    .line 253
    :cond_4
    iget v7, v3, Landroid/graphics/RectF;->bottom:F

    int-to-float v8, v4

    cmpg-float v7, v7, v8

    if-gez v7, :cond_1

    .line 254
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getHeight()I

    move-result v7

    int-to-float v7, v7

    iget v8, v3, Landroid/graphics/RectF;->bottom:F

    sub-float v1, v7, v8

    goto :goto_1

    .line 261
    .end local v4    # "viewHeight":I
    .restart local v5    # "viewWidth":I
    :cond_5
    iget v7, v3, Landroid/graphics/RectF;->left:F

    cmpl-float v7, v7, v9

    if-lez v7, :cond_6

    .line 262
    iget v7, v3, Landroid/graphics/RectF;->left:F

    neg-float v0, v7

    goto :goto_2

    .line 263
    :cond_6
    iget v7, v3, Landroid/graphics/RectF;->right:F

    int-to-float v8, v5

    cmpg-float v7, v7, v8

    if-gez v7, :cond_2

    .line 264
    int-to-float v7, v5

    iget v8, v3, Landroid/graphics/RectF;->right:F

    sub-float v0, v7, v8

    goto :goto_2
.end method


# virtual methods
.method public clear()V
    .locals 1

    .prologue
    .line 283
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 284
    return-void
.end method

.method public getDisplayBitmap()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method protected getImageViewMatrix()Landroid/graphics/Matrix;
    .locals 2

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mDisplayMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBaseMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mDisplayMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mChangeMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->postConcat(Landroid/graphics/Matrix;)Z

    .line 112
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mDisplayMatrix:Landroid/graphics/Matrix;

    return-object v0
.end method

.method public getScale()F
    .locals 2

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mChangeMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mMatrixValues:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 101
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mMatrixValues:[F

    const/4 v1, 0x0

    aget v0, v0, v1

    return v0
.end method

.method protected init()V
    .locals 1

    .prologue
    .line 58
    sget-object v0, Landroid/widget/ImageView$ScaleType;->MATRIX:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 59
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 2
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 63
    invoke-super/range {p0 .. p5}, Landroid/widget/ImageView;->onLayout(ZIIII)V

    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 65
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBaseMatrix:Landroid/graphics/Matrix;

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/imageview/BasePinchImageView;->prepareBaseMatrix(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V

    .line 66
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 68
    :cond_0
    return-void
.end method

.method protected panBy(FF)V
    .locals 5
    .param p1, "dx"    # F
    .param p2, "dy"    # F

    .prologue
    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 181
    invoke-direct {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getBitmapRect()Landroid/graphics/RectF;

    move-result-object v0

    .line 182
    .local v0, "rect":Landroid/graphics/RectF;
    if-nez v0, :cond_0

    .line 188
    :goto_0
    return-void

    .line 184
    :cond_0
    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1, p1, p2, v2, v2}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 185
    .local v1, "scrolledrect":Landroid/graphics/RectF;
    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/imageview/BasePinchImageView;->updateRect(Landroid/graphics/RectF;Landroid/graphics/RectF;)V

    .line 186
    iget v2, v1, Landroid/graphics/RectF;->left:F

    iget v3, v1, Landroid/graphics/RectF;->top:F

    invoke-virtual {p0, v2, v3}, Lcom/amazon/mShop/imageview/BasePinchImageView;->postTranslate(FF)V

    .line 187
    invoke-direct {p0, v4, v4}, Lcom/amazon/mShop/imageview/BasePinchImageView;->center(ZZ)V

    goto :goto_0
.end method

.method protected postScale(FFF)V
    .locals 1
    .param p1, "scale"    # F
    .param p2, "centerX"    # F
    .param p3, "centerY"    # F

    .prologue
    .line 163
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mChangeMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, p1, p1, p2, p3}, Landroid/graphics/Matrix;->postScale(FFFF)Z

    .line 164
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 165
    return-void
.end method

.method protected postTranslate(FF)V
    .locals 1
    .param p1, "deltaX"    # F
    .param p2, "deltaY"    # F

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mChangeMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 153
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 154
    return-void
.end method

.method protected prepareBaseMatrix(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V
    .locals 10
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "matrix"    # Landroid/graphics/Matrix;

    .prologue
    const/4 v8, -0x1

    const/high16 v9, 0x40000000    # 2.0f

    .line 122
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getWidth()I

    move-result v7

    int-to-float v5, v7

    .line 123
    .local v5, "viewWidth":F
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getHeight()I

    move-result v7

    int-to-float v4, v7

    .line 124
    .local v4, "viewHeight":F
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v7

    int-to-float v3, v7

    .line 125
    .local v3, "sourceWidth":F
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    int-to-float v2, v7

    .line 127
    .local v2, "sourceHeight":F
    iget v7, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mInitialImageWidth:I

    if-ne v7, v8, :cond_0

    move v7, v5

    :goto_0
    div-float v6, v7, v3

    .line 128
    .local v6, "widthScale":F
    iget v7, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mInitialImageHeight:I

    if-ne v7, v8, :cond_1

    move v7, v4

    :goto_1
    div-float v0, v7, v2

    .line 129
    .local v0, "heightScale":F
    invoke-static {v6, v0}, Ljava/lang/Math;->min(FF)F

    move-result v1

    .line 131
    .local v1, "scale":F
    invoke-virtual {p2}, Landroid/graphics/Matrix;->reset()V

    .line 132
    invoke-virtual {p2, v1, v1}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 133
    mul-float v7, v3, v1

    sub-float v7, v5, v7

    div-float/2addr v7, v9

    mul-float v8, v2, v1

    sub-float v8, v4, v8

    div-float/2addr v8, v9

    invoke-virtual {p2, v7, v8}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 134
    return-void

    .line 127
    .end local v0    # "heightScale":F
    .end local v1    # "scale":F
    .end local v6    # "widthScale":F
    :cond_0
    iget v7, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mInitialImageWidth:I

    int-to-float v7, v7

    goto :goto_0

    .line 128
    .restart local v6    # "widthScale":F
    :cond_1
    iget v7, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mInitialImageHeight:I

    int-to-float v7, v7

    goto :goto_1
.end method

.method public scrollBy(FF)V
    .locals 0
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 177
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/imageview/BasePinchImageView;->panBy(FF)V

    .line 178
    return-void
.end method

.method public setImageBitmap(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 72
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 74
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 75
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 76
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setDither(Z)V

    .line 79
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBitmapDisplayed:Landroid/graphics/Bitmap;

    .line 81
    if-eqz p1, :cond_1

    .line 82
    iget-object v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBaseMatrix:Landroid/graphics/Matrix;

    invoke-virtual {p0, p1, v1}, Lcom/amazon/mShop/imageview/BasePinchImageView;->prepareBaseMatrix(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V

    .line 86
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mChangeMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v1}, Landroid/graphics/Matrix;->reset()V

    .line 87
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getImageViewMatrix()Landroid/graphics/Matrix;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/imageview/BasePinchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 88
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mCurrentScaleFactor:F

    .line 89
    return-void

    .line 84
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mBaseMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v1}, Landroid/graphics/Matrix;->reset()V

    goto :goto_0
.end method

.method protected setInitialImageDisplaySize(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 142
    iput p1, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mInitialImageWidth:I

    .line 143
    iput p2, p0, Lcom/amazon/mShop/imageview/BasePinchImageView;->mInitialImageHeight:I

    .line 144
    return-void
.end method

.method protected updateRect(Landroid/graphics/RectF;Landroid/graphics/RectF;)V
    .locals 5
    .param p1, "bitmapRect"    # Landroid/graphics/RectF;
    .param p2, "scrolledRect"    # Landroid/graphics/RectF;

    .prologue
    const/4 v4, 0x0

    .line 197
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getWidth()I

    move-result v1

    .line 198
    .local v1, "width":I
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getHeight()I

    move-result v0

    .line 200
    .local v0, "height":I
    iget v2, p1, Landroid/graphics/RectF;->top:F

    cmpl-float v2, v2, v4

    if-ltz v2, :cond_0

    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    int-to-float v3, v0

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_0

    .line 201
    iput v4, p2, Landroid/graphics/RectF;->top:F

    .line 203
    :cond_0
    iget v2, p1, Landroid/graphics/RectF;->left:F

    cmpl-float v2, v2, v4

    if-ltz v2, :cond_1

    iget v2, p1, Landroid/graphics/RectF;->right:F

    int-to-float v3, v1

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_1

    .line 204
    iput v4, p2, Landroid/graphics/RectF;->left:F

    .line 208
    :cond_1
    iget v2, p1, Landroid/graphics/RectF;->top:F

    iget v3, p2, Landroid/graphics/RectF;->top:F

    add-float/2addr v2, v3

    cmpl-float v2, v2, v4

    if-ltz v2, :cond_2

    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    int-to-float v3, v0

    cmpl-float v2, v2, v3

    if-lez v2, :cond_2

    .line 209
    iget v2, p1, Landroid/graphics/RectF;->top:F

    sub-float v2, v4, v2

    iput v2, p2, Landroid/graphics/RectF;->top:F

    .line 213
    :cond_2
    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    iget v3, p2, Landroid/graphics/RectF;->top:F

    add-float/2addr v2, v3

    int-to-float v3, v0

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_3

    iget v2, p1, Landroid/graphics/RectF;->top:F

    cmpg-float v2, v2, v4

    if-gez v2, :cond_3

    .line 214
    int-to-float v2, v0

    iget v3, p1, Landroid/graphics/RectF;->bottom:F

    sub-float/2addr v2, v3

    iput v2, p2, Landroid/graphics/RectF;->top:F

    .line 218
    :cond_3
    iget v2, p1, Landroid/graphics/RectF;->left:F

    iget v3, p2, Landroid/graphics/RectF;->left:F

    add-float/2addr v2, v3

    cmpl-float v2, v2, v4

    if-ltz v2, :cond_4

    .line 219
    iget v2, p1, Landroid/graphics/RectF;->left:F

    sub-float v2, v4, v2

    iput v2, p2, Landroid/graphics/RectF;->left:F

    .line 223
    :cond_4
    iget v2, p1, Landroid/graphics/RectF;->right:F

    iget v3, p2, Landroid/graphics/RectF;->left:F

    add-float/2addr v2, v3

    int-to-float v3, v1

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_5

    .line 224
    int-to-float v2, v1

    iget v3, p1, Landroid/graphics/RectF;->right:F

    sub-float/2addr v2, v3

    iput v2, p2, Landroid/graphics/RectF;->left:F

    .line 225
    :cond_5
    return-void
.end method

.method public zoomTo(FFF)V
    .locals 4
    .param p1, "scale"    # F
    .param p2, "centerX"    # F
    .param p3, "centerY"    # F

    .prologue
    const/4 v3, 0x1

    .line 168
    const/high16 v2, 0x40800000    # 4.0f

    cmpl-float v2, p1, v2

    if-lez v2, :cond_0

    .line 169
    const/high16 p1, 0x40800000    # 4.0f

    .line 170
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->getScale()F

    move-result v1

    .line 171
    .local v1, "oldScale":F
    div-float v0, p1, v1

    .line 172
    .local v0, "deltaScale":F
    invoke-virtual {p0, v0, p2, p3}, Lcom/amazon/mShop/imageview/BasePinchImageView;->postScale(FFF)V

    .line 173
    invoke-direct {p0, v3, v3}, Lcom/amazon/mShop/imageview/BasePinchImageView;->center(ZZ)V

    .line 174
    return-void
.end method
