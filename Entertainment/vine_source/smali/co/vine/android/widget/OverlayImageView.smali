.class public Lco/vine/android/widget/OverlayImageView;
.super Landroid/widget/ImageView;
.source "OverlayImageView.java"


# instance fields
.field private mFramed:Z

.field private mImageHeight:I

.field private mImageWidth:I

.field private mOverlayDrawable:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/widget/OverlayImageView;->init(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 35
    invoke-direct {p0, p1, p2}, Lco/vine/android/widget/OverlayImageView;->init(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 39
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 40
    invoke-direct {p0, p1, p2}, Lco/vine/android/widget/OverlayImageView;->init(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 41
    return-void
.end method

.method private init(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 44
    if-nez p2, :cond_0

    .line 54
    :goto_0
    return-void

    .line 48
    :cond_0
    sget-object v2, Lco/vine/android/R$styleable;->OverlayImageView:[I

    invoke-virtual {p1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 49
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 50
    .local v1, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_1

    .line 51
    invoke-virtual {p0, v1}, Lco/vine/android/widget/OverlayImageView;->setOverlayDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 53
    :cond_1
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    goto :goto_0
.end method

.method private setDrawableBounds(Landroid/graphics/drawable/Drawable;)V
    .locals 4
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v3, 0x0

    .line 117
    iget-boolean v2, p0, Lco/vine/android/widget/OverlayImageView;->mFramed:Z

    if-eqz v2, :cond_0

    if-eqz p1, :cond_0

    .line 118
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->getMeasuredWidth()I

    move-result v1

    .line 119
    .local v1, "width":I
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->getMeasuredHeight()I

    move-result v0

    .line 120
    .local v0, "height":I
    invoke-virtual {p1, v3, v3, v1, v0}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 121
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->invalidate()V

    .line 123
    .end local v0    # "height":I
    .end local v1    # "width":I
    :cond_0
    return-void
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 2

    .prologue
    .line 67
    invoke-super {p0}, Landroid/widget/ImageView;->drawableStateChanged()V

    .line 68
    iget-object v0, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    .line 69
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 70
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 72
    :cond_0
    return-void
.end method

.method public invalidateDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "dr"    # Landroid/graphics/drawable/Drawable;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 101
    iget-object v0, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    if-ne p1, v0, :cond_0

    .line 102
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->invalidate()V

    .line 106
    :goto_0
    return-void

    .line 104
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->invalidateDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 58
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 59
    iget-object v0, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    .line 60
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 61
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 63
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 7
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 76
    iget v3, p0, Lco/vine/android/widget/OverlayImageView;->mImageWidth:I

    .line 77
    .local v3, "imageWidth":I
    iget v2, p0, Lco/vine/android/widget/OverlayImageView;->mImageHeight:I

    .line 78
    .local v2, "imageHeight":I
    if-lez v3, :cond_2

    if-lez v2, :cond_2

    .line 79
    invoke-static {v3, p1}, Lco/vine/android/widget/OverlayImageView;->getDefaultSize(II)I

    move-result v4

    .line 80
    .local v4, "width":I
    invoke-static {v2, p2}, Lco/vine/android/widget/OverlayImageView;->getDefaultSize(II)I

    move-result v0

    .line 81
    .local v0, "height":I
    mul-int v5, v3, v0

    .line 82
    .local v5, "widthScale":I
    mul-int v1, v2, v4

    .line 83
    .local v1, "heightScale":I
    if-le v5, v1, :cond_1

    .line 84
    div-int v0, v1, v3

    .line 88
    :cond_0
    :goto_0
    invoke-virtual {p0, v4, v0}, Lco/vine/android/widget/OverlayImageView;->setMeasuredDimension(II)V

    .line 92
    .end local v0    # "height":I
    .end local v1    # "heightScale":I
    .end local v4    # "width":I
    .end local v5    # "widthScale":I
    :goto_1
    iget-object v6, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0, v6}, Lco/vine/android/widget/OverlayImageView;->setDrawableBounds(Landroid/graphics/drawable/Drawable;)V

    .line 93
    return-void

    .line 85
    .restart local v0    # "height":I
    .restart local v1    # "heightScale":I
    .restart local v4    # "width":I
    .restart local v5    # "widthScale":I
    :cond_1
    if-ge v5, v1, :cond_0

    .line 86
    div-int v4, v5, v2

    goto :goto_0

    .line 90
    .end local v0    # "height":I
    .end local v1    # "heightScale":I
    .end local v4    # "width":I
    .end local v5    # "widthScale":I
    :cond_2
    invoke-super {p0, p1, p2}, Landroid/widget/ImageView;->onMeasure(II)V

    goto :goto_1
.end method

.method protected setFrame(IIII)Z
    .locals 2
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "r"    # I
    .param p4, "b"    # I

    .prologue
    .line 110
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ImageView;->setFrame(IIII)Z

    move-result v0

    .line 111
    .local v0, "changed":Z
    const/4 v1, 0x1

    iput-boolean v1, p0, Lco/vine/android/widget/OverlayImageView;->mFramed:Z

    .line 112
    iget-object v1, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    invoke-direct {p0, v1}, Lco/vine/android/widget/OverlayImageView;->setDrawableBounds(Landroid/graphics/drawable/Drawable;)V

    .line 113
    return v0
.end method

.method public setImageSize(II)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 143
    iget v1, p0, Lco/vine/android/widget/OverlayImageView;->mImageWidth:I

    .line 144
    .local v1, "oldWidth":I
    iget v0, p0, Lco/vine/android/widget/OverlayImageView;->mImageHeight:I

    .line 145
    .local v0, "oldHeight":I
    if-ne v1, p1, :cond_0

    if-eq v0, p2, :cond_1

    .line 146
    :cond_0
    iput p1, p0, Lco/vine/android/widget/OverlayImageView;->mImageWidth:I

    .line 147
    iput p2, p0, Lco/vine/android/widget/OverlayImageView;->mImageHeight:I

    .line 148
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->requestLayout()V

    .line 150
    :cond_1
    return-void
.end method

.method public setOverlayDrawable(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 96
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/widget/OverlayImageView;->setOverlayDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 97
    return-void
.end method

.method public setOverlayDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 126
    iget-object v0, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    if-eq v0, p1, :cond_2

    .line 127
    iget-object v0, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 128
    iget-object v0, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 129
    iget-object v0, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v0}, Lco/vine/android/widget/OverlayImageView;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 131
    :cond_0
    iput-object p1, p0, Lco/vine/android/widget/OverlayImageView;->mOverlayDrawable:Landroid/graphics/drawable/Drawable;

    .line 132
    if-eqz p1, :cond_1

    .line 133
    invoke-virtual {p1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 134
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 135
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->getDrawableState()[I

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 138
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/widget/OverlayImageView;->requestLayout()V

    .line 140
    :cond_2
    return-void
.end method
