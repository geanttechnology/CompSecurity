.class public Lco/vine/android/widget/RoundedCornerBitmapImageView;
.super Landroid/widget/ImageView;
.source "RoundedCornerBitmapImageView.java"


# instance fields
.field public mCanvasBitmap:Landroid/graphics/Bitmap;

.field public mRadius:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/RoundedCornerBitmapImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x0

    .line 38
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 39
    sget-object v1, Lco/vine/android/R$styleable;->RoundedCornerImageView:[I

    invoke-virtual {p1, p2, v1, p3, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 41
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v2, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v1

    iput v1, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mRadius:I

    .line 42
    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 12
    .param p1, "c"    # Landroid/graphics/Canvas;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    const/4 v11, 0x0

    .line 45
    invoke-virtual {p0}, Lco/vine/android/widget/RoundedCornerBitmapImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 46
    .local v2, "d":Landroid/graphics/drawable/Drawable;
    instance-of v8, v2, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v8, :cond_4

    .line 47
    check-cast v2, Landroid/graphics/drawable/BitmapDrawable;

    .end local v2    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v2}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 48
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    invoke-virtual {p0}, Lco/vine/android/widget/RoundedCornerBitmapImageView;->getMeasuredWidth()I

    move-result v7

    .line 49
    .local v7, "width":I
    invoke-virtual {p0}, Lco/vine/android/widget/RoundedCornerBitmapImageView;->getMeasuredHeight()I

    move-result v3

    .line 51
    .local v3, "height":I
    iget-object v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mCanvasBitmap:Landroid/graphics/Bitmap;

    if-eqz v8, :cond_0

    iget-object v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mCanvasBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v8

    if-ne v7, v8, :cond_0

    iget-object v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mCanvasBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    if-eq v3, v8, :cond_2

    .line 52
    :cond_0
    iget-object v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mCanvasBitmap:Landroid/graphics/Bitmap;

    if-eqz v8, :cond_1

    .line 53
    iget-object v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mCanvasBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->recycle()V

    .line 56
    :cond_1
    sget-object v8, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v7, v3, v8}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v8

    iput-object v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mCanvasBitmap:Landroid/graphics/Bitmap;

    .line 59
    :cond_2
    new-instance v1, Landroid/graphics/Canvas;

    iget-object v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mCanvasBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v1, v8}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 60
    .local v1, "bitmapCanvas":Landroid/graphics/Canvas;
    const/4 v8, 0x0

    sget-object v9, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v1, v8, v9}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    .line 62
    invoke-super {p0, v1}, Landroid/widget/ImageView;->draw(Landroid/graphics/Canvas;)V

    .line 64
    if-eqz v0, :cond_3

    .line 66
    new-instance v6, Landroid/graphics/BitmapShader;

    iget-object v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mCanvasBitmap:Landroid/graphics/Bitmap;

    sget-object v9, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    sget-object v10, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    invoke-direct {v6, v8, v9, v10}, Landroid/graphics/BitmapShader;-><init>(Landroid/graphics/Bitmap;Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    .line 68
    .local v6, "shader":Landroid/graphics/BitmapShader;
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    .line 69
    .local v4, "paint":Landroid/graphics/Paint;
    const/4 v8, 0x1

    invoke-virtual {v4, v8}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 70
    invoke-virtual {v4, v6}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 72
    new-instance v5, Landroid/graphics/RectF;

    int-to-float v8, v7

    int-to-float v9, v3

    invoke-direct {v5, v11, v11, v8, v9}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 74
    .local v5, "rect":Landroid/graphics/RectF;
    iget v8, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mRadius:I

    int-to-float v8, v8

    iget v9, p0, Lco/vine/android/widget/RoundedCornerBitmapImageView;->mRadius:I

    int-to-float v9, v9

    invoke-virtual {p1, v5, v8, v9, v4}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 81
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "bitmapCanvas":Landroid/graphics/Canvas;
    .end local v3    # "height":I
    .end local v4    # "paint":Landroid/graphics/Paint;
    .end local v5    # "rect":Landroid/graphics/RectF;
    .end local v6    # "shader":Landroid/graphics/BitmapShader;
    .end local v7    # "width":I
    :goto_0
    return-void

    .line 76
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    .restart local v1    # "bitmapCanvas":Landroid/graphics/Canvas;
    .restart local v3    # "height":I
    .restart local v7    # "width":I
    :cond_3
    invoke-super {p0, p1}, Landroid/widget/ImageView;->draw(Landroid/graphics/Canvas;)V

    goto :goto_0

    .line 79
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "bitmapCanvas":Landroid/graphics/Canvas;
    .end local v3    # "height":I
    .end local v7    # "width":I
    .restart local v2    # "d":Landroid/graphics/drawable/Drawable;
    :cond_4
    invoke-super {p0, p1}, Landroid/widget/ImageView;->draw(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method
