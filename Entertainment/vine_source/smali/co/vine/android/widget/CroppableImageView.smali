.class public Lco/vine/android/widget/CroppableImageView;
.super Lco/vine/android/widget/MultiTouchImageView;
.source "CroppableImageView.java"


# static fields
.field public static final CROP_NAME_ORIGINAL_ASPECT_RATION:Ljava/lang/String; = "original_aspect"

.field public static final CROP_NAME_SQUARE:Ljava/lang/String; = "square_aspect"

.field public static final CROP_TYPE_EDIT_PROFILE:I = 0x0

.field public static final CROP_TYPE_ORIGINAL_ASPECT_RATIO:I = 0x1

.field public static final CROP_TYPE_SQUARE:I = 0x2


# instance fields
.field private mCropRectPadding:I

.field private mCropType:I

.field private mShadowPaint:Landroid/graphics/Paint;

.field private mShadowRect:Landroid/graphics/RectF;

.field private mStrokePaint:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lco/vine/android/widget/MultiTouchImageView;-><init>(Landroid/content/Context;)V

    .line 62
    invoke-virtual {p0}, Lco/vine/android/widget/CroppableImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 63
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f090083

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    const v2, 0x7f090091

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-direct {p0, v1, v2}, Lco/vine/android/widget/CroppableImageView;->init(II)V

    .line 64
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 67
    const v0, 0x7f01001d

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/CroppableImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v6, 0x0

    .line 71
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/widget/MultiTouchImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 73
    sget-object v5, Lco/vine/android/R$styleable;->CroppableImageView:[I

    invoke-virtual {p1, p2, v5, p3, v6}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 75
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v6, v6}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v1

    .line 77
    .local v1, "cropRectPadding":I
    if-lez v1, :cond_0

    .line 78
    iput v1, p0, Lco/vine/android/widget/CroppableImageView;->mCropRectPadding:I

    .line 81
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/widget/CroppableImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 82
    .local v3, "res":Landroid/content/res/Resources;
    const/4 v5, 0x1

    const v6, 0x7f090083

    invoke-virtual {v3, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    .line 85
    .local v2, "cropRectStrokeColor":I
    const/4 v5, 0x2

    const v6, 0x7f090091

    invoke-virtual {v3, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v4

    .line 87
    .local v4, "shadowColor":I
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 89
    invoke-direct {p0, v2, v4}, Lco/vine/android/widget/CroppableImageView;->init(II)V

    .line 90
    return-void
.end method

.method private init(II)V
    .locals 3
    .param p1, "strokeColor"    # I
    .param p2, "shadowColor"    # I

    .prologue
    .line 48
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    .line 49
    .local v1, "strokePaint":Landroid/graphics/Paint;
    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 50
    sget-object v2, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 51
    iput-object v1, p0, Lco/vine/android/widget/CroppableImageView;->mStrokePaint:Landroid/graphics/Paint;

    .line 53
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    .line 54
    .local v0, "shadowPaint":Landroid/graphics/Paint;
    invoke-virtual {v0, p2}, Landroid/graphics/Paint;->setColor(I)V

    .line 55
    iput-object v0, p0, Lco/vine/android/widget/CroppableImageView;->mShadowPaint:Landroid/graphics/Paint;

    .line 56
    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    iput-object v2, p0, Lco/vine/android/widget/CroppableImageView;->mShadowRect:Landroid/graphics/RectF;

    .line 57
    const/4 v2, 0x0

    iput v2, p0, Lco/vine/android/widget/CroppableImageView;->mCropType:I

    .line 58
    return-void
.end method


# virtual methods
.method public getCropRect()Landroid/graphics/RectF;
    .locals 3

    .prologue
    .line 176
    new-instance v1, Landroid/graphics/RectF;

    iget-object v2, p0, Lco/vine/android/widget/CroppableImageView;->mTransformBounds:Landroid/graphics/RectF;

    invoke-direct {v1, v2}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    .line 177
    .local v1, "rect":Landroid/graphics/RectF;
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    .line 178
    .local v0, "invertedMatrix":Landroid/graphics/Matrix;
    iget-object v2, p0, Lco/vine/android/widget/CroppableImageView;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v2, v0}, Landroid/graphics/Matrix;->invert(Landroid/graphics/Matrix;)Z

    .line 179
    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 180
    return-object v1
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 10
    .param p1, "canvas"    # Landroid/graphics/Canvas;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    const/4 v9, 0x0

    .line 137
    invoke-super {p0, p1}, Lco/vine/android/widget/MultiTouchImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 138
    iget-object v1, p0, Lco/vine/android/widget/CroppableImageView;->mTransformBounds:Landroid/graphics/RectF;

    .line 139
    .local v1, "rect":Landroid/graphics/RectF;
    iget-object v5, p0, Lco/vine/android/widget/CroppableImageView;->mStrokePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v5}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 141
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v4

    .line 142
    .local v4, "width":I
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    .line 144
    .local v0, "height":I
    iget-object v2, p0, Lco/vine/android/widget/CroppableImageView;->mShadowPaint:Landroid/graphics/Paint;

    .line 145
    .local v2, "shadowPaint":Landroid/graphics/Paint;
    iget-object v3, p0, Lco/vine/android/widget/CroppableImageView;->mShadowRect:Landroid/graphics/RectF;

    .line 148
    .local v3, "shadowRect":Landroid/graphics/RectF;
    iget v5, v1, Landroid/graphics/RectF;->top:F

    iget v6, v1, Landroid/graphics/RectF;->left:F

    iget v7, v1, Landroid/graphics/RectF;->bottom:F

    invoke-virtual {v3, v9, v5, v6, v7}, Landroid/graphics/RectF;->set(FFFF)V

    .line 149
    invoke-virtual {p1, v3, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 152
    int-to-float v5, v4

    iget v6, v1, Landroid/graphics/RectF;->top:F

    invoke-virtual {v3, v9, v9, v5, v6}, Landroid/graphics/RectF;->set(FFFF)V

    .line 153
    invoke-virtual {p1, v3, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 156
    iget v5, v1, Landroid/graphics/RectF;->right:F

    iget v6, v1, Landroid/graphics/RectF;->top:F

    int-to-float v7, v4

    iget v8, v1, Landroid/graphics/RectF;->bottom:F

    invoke-virtual {v3, v5, v6, v7, v8}, Landroid/graphics/RectF;->set(FFFF)V

    .line 157
    invoke-virtual {p1, v3, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 160
    iget v5, v1, Landroid/graphics/RectF;->bottom:F

    int-to-float v6, v4

    int-to-float v7, v0

    invoke-virtual {v3, v9, v5, v6, v7}, Landroid/graphics/RectF;->set(FFFF)V

    .line 161
    invoke-virtual {p1, v3, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 162
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
    .line 171
    invoke-super/range {p0 .. p5}, Lco/vine/android/widget/MultiTouchImageView;->onLayout(ZIIII)V

    .line 172
    iget v0, p0, Lco/vine/android/widget/CroppableImageView;->mCropRectPadding:I

    iget v1, p0, Lco/vine/android/widget/CroppableImageView;->mCropType:I

    invoke-virtual {p0, v0, v1}, Lco/vine/android/widget/CroppableImageView;->setCropPadding(II)V

    .line 173
    return-void
.end method

.method protected onMeasure(II)V
    .locals 0
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 166
    invoke-super {p0, p1, p2}, Lco/vine/android/widget/MultiTouchImageView;->onMeasure(II)V

    .line 167
    return-void
.end method

.method public setCropPadding(II)V
    .locals 11
    .param p1, "padding"    # I
    .param p2, "type"    # I

    .prologue
    .line 100
    iput p2, p0, Lco/vine/android/widget/CroppableImageView;->mCropType:I

    .line 101
    iput p1, p0, Lco/vine/android/widget/CroppableImageView;->mCropRectPadding:I

    .line 102
    invoke-virtual {p0}, Lco/vine/android/widget/CroppableImageView;->getMeasuredWidth()I

    move-result v6

    .line 103
    .local v6, "width":I
    invoke-virtual {p0}, Lco/vine/android/widget/CroppableImageView;->getMeasuredHeight()I

    move-result v0

    .line 104
    .local v0, "height":I
    const/4 v3, 0x0

    .line 105
    .local v3, "rectWidth":I
    const/4 v2, 0x0

    .line 106
    .local v2, "rectHeight":I
    iget v7, p0, Lco/vine/android/widget/CroppableImageView;->mBitmapWidth:F

    iget v8, p0, Lco/vine/android/widget/CroppableImageView;->mBitmapHeight:F

    div-float v1, v7, v8

    .line 107
    .local v1, "imageAr":F
    int-to-float v7, v6

    int-to-float v8, v0

    div-float v5, v7, v8

    .line 111
    .local v5, "viewAr":F
    cmpl-float v7, v5, v1

    if-lez v7, :cond_1

    .line 112
    int-to-float v7, p1

    div-float/2addr v7, v1

    float-to-int v7, v7

    sub-int v2, v0, v7

    .line 113
    iget v7, p0, Lco/vine/android/widget/CroppableImageView;->mBitmapHeight:F

    int-to-float v8, v0

    div-float v4, v7, v8

    .line 114
    .local v4, "scale":F
    iget v7, p0, Lco/vine/android/widget/CroppableImageView;->mBitmapWidth:F

    div-float/2addr v7, v4

    float-to-int v7, v7

    sub-int v3, v7, p1

    .line 122
    :goto_0
    if-nez p2, :cond_2

    .line 123
    div-int/lit8 v2, v3, 0x2

    .line 132
    :cond_0
    :goto_1
    int-to-float v7, v3

    int-to-float v8, v2

    sget-object v9, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    const/4 v10, 0x0

    invoke-virtual {p0, v7, v8, v9, v10}, Lco/vine/android/widget/CroppableImageView;->setTransformDimensions(FFLandroid/widget/ImageView$ScaleType;Z)V

    .line 133
    return-void

    .line 116
    .end local v4    # "scale":F
    :cond_1
    sub-int v3, v6, p1

    .line 117
    iget v7, p0, Lco/vine/android/widget/CroppableImageView;->mBitmapWidth:F

    int-to-float v8, v6

    div-float v4, v7, v8

    .line 118
    .restart local v4    # "scale":F
    iget v7, p0, Lco/vine/android/widget/CroppableImageView;->mBitmapHeight:F

    div-float/2addr v7, v4

    float-to-int v7, v7

    int-to-float v8, p1

    div-float/2addr v8, v1

    float-to-int v8, v8

    sub-int v2, v7, v8

    goto :goto_0

    .line 124
    :cond_2
    const/4 v7, 0x2

    if-ne p2, v7, :cond_0

    .line 125
    if-ge v2, v3, :cond_3

    .line 126
    move v3, v2

    goto :goto_1

    .line 128
    :cond_3
    move v2, v3

    goto :goto_1
.end method

.method public setCropType(I)V
    .locals 1
    .param p1, "type"    # I

    .prologue
    .line 93
    iget v0, p0, Lco/vine/android/widget/CroppableImageView;->mCropType:I

    if-eq v0, p1, :cond_0

    .line 94
    iput p1, p0, Lco/vine/android/widget/CroppableImageView;->mCropType:I

    .line 95
    invoke-virtual {p0}, Lco/vine/android/widget/CroppableImageView;->invalidate()V

    .line 97
    :cond_0
    return-void
.end method
