.class public Lco/vine/android/widget/DotIndicators;
.super Landroid/view/View;
.source "DotIndicators.java"


# instance fields
.field private mActivePos:I

.field private mDotHeight:I

.field private mDotPadding:I

.field private mDotWidth:I

.field private mFinalIconOff:Landroid/graphics/Bitmap;

.field private mFinalIconOn:Landroid/graphics/Bitmap;

.field private mFinalIconWidth:I

.field private mHeight:I

.field private mNum:I

.field private mOff:Landroid/graphics/Bitmap;

.field private mOffAlpha:Z

.field private mOffAlphaValue:I

.field private mOn:Landroid/graphics/Bitmap;

.field private mPaint:Landroid/graphics/Paint;

.field private mShowFinalIcon:Z

.field private mWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 41
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/widget/DotIndicators;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 45
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/DotIndicators;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/16 v5, 0x64

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 59
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 61
    sget-object v4, Lco/vine/android/R$styleable;->DotIndicators:[I

    invoke-virtual {p1, p2, v4, p3, v6}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 64
    .local v0, "a":Landroid/content/res/TypedArray;
    const v4, 0x7f020221

    invoke-virtual {v0, v7, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    .line 67
    .local v2, "offRes":I
    const v4, 0x7f020222

    invoke-virtual {v0, v6, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    .line 70
    .local v3, "onRes":I
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-static {v4, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/widget/DotIndicators;->mOff:Landroid/graphics/Bitmap;

    .line 71
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-static {v4, v3}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/widget/DotIndicators;->mOn:Landroid/graphics/Bitmap;

    .line 73
    const/4 v4, 0x2

    invoke-virtual {v0, v4, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    .line 74
    .local v1, "offAlpha":I
    if-eq v1, v5, :cond_0

    .line 75
    iput-boolean v7, p0, Lco/vine/android/widget/DotIndicators;->mOffAlpha:Z

    .line 76
    iput v1, p0, Lco/vine/android/widget/DotIndicators;->mOffAlphaValue:I

    .line 79
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020220

    invoke-static {v4, v5}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/widget/DotIndicators;->mFinalIconOn:Landroid/graphics/Bitmap;

    .line 81
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02021f

    invoke-static {v4, v5}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/widget/DotIndicators;->mFinalIconOff:Landroid/graphics/Bitmap;

    .line 84
    const/4 v4, 0x3

    invoke-virtual {v0, v4, v6}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v4

    iput v4, p0, Lco/vine/android/widget/DotIndicators;->mDotPadding:I

    .line 86
    iget-object v4, p0, Lco/vine/android/widget/DotIndicators;->mFinalIconOff:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    iput v4, p0, Lco/vine/android/widget/DotIndicators;->mFinalIconWidth:I

    .line 87
    iget-object v4, p0, Lco/vine/android/widget/DotIndicators;->mOn:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    iput v4, p0, Lco/vine/android/widget/DotIndicators;->mDotWidth:I

    .line 88
    iget-object v4, p0, Lco/vine/android/widget/DotIndicators;->mOn:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    iput v4, p0, Lco/vine/android/widget/DotIndicators;->mDotHeight:I

    .line 89
    iput-boolean v7, p0, Lco/vine/android/widget/DotIndicators;->mShowFinalIcon:Z

    .line 90
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    iput-object v4, p0, Lco/vine/android/widget/DotIndicators;->mPaint:Landroid/graphics/Paint;

    .line 91
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 92
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 10
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v9, 0x0

    .line 96
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 98
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mHeight:I

    if-eqz v5, :cond_0

    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mWidth:I

    if-eqz v5, :cond_0

    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mNum:I

    if-nez v5, :cond_1

    .line 146
    :cond_0
    :goto_0
    return-void

    .line 102
    :cond_1
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mNum:I

    div-int/lit8 v5, v5, 0x2

    int-to-double v5, v5

    invoke-static {v5, v6}, Ljava/lang/Math;->floor(D)D

    move-result-wide v5

    double-to-int v2, v5

    .line 103
    .local v2, "numLeftDots":I
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mWidth:I

    div-int/lit8 v3, v5, 0x2

    .line 105
    .local v3, "screenHalf":I
    iget-boolean v5, p0, Lco/vine/android/widget/DotIndicators;->mShowFinalIcon:Z

    if-eqz v5, :cond_3

    .line 106
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mDotWidth:I

    iget v6, p0, Lco/vine/android/widget/DotIndicators;->mDotPadding:I

    add-int/2addr v5, v6

    mul-int/2addr v5, v2

    sub-int v5, v3, v5

    iget v6, p0, Lco/vine/android/widget/DotIndicators;->mFinalIconWidth:I

    div-int/lit8 v6, v6, 0x2

    sub-int v1, v5, v6

    .line 111
    .local v1, "left":I
    :goto_1
    iget-boolean v5, p0, Lco/vine/android/widget/DotIndicators;->mShowFinalIcon:Z

    if-eqz v5, :cond_4

    .line 112
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mNum:I

    rem-int/lit8 v5, v5, 0x2

    if-eqz v5, :cond_2

    .line 113
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mDotWidth:I

    iget v6, p0, Lco/vine/android/widget/DotIndicators;->mDotPadding:I

    add-int/2addr v5, v6

    div-int/lit8 v5, v5, 0x2

    sub-int/2addr v1, v5

    .line 122
    :cond_2
    :goto_2
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mHeight:I

    div-int/lit8 v5, v5, 0x2

    iget v6, p0, Lco/vine/android/widget/DotIndicators;->mDotHeight:I

    sub-int v4, v5, v6

    .line 124
    .local v4, "top":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_3
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mNum:I

    if-ge v0, v5, :cond_7

    .line 125
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mActivePos:I

    if-ne v5, v0, :cond_5

    .line 126
    iget-object v5, p0, Lco/vine/android/widget/DotIndicators;->mOn:Landroid/graphics/Bitmap;

    int-to-float v6, v1

    int-to-float v7, v4

    invoke-virtual {p1, v5, v6, v7, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 135
    :goto_4
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mDotWidth:I

    iget v6, p0, Lco/vine/android/widget/DotIndicators;->mDotPadding:I

    add-int/2addr v5, v6

    add-int/2addr v1, v5

    .line 124
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 108
    .end local v0    # "i":I
    .end local v1    # "left":I
    .end local v4    # "top":I
    :cond_3
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mDotWidth:I

    iget v6, p0, Lco/vine/android/widget/DotIndicators;->mDotPadding:I

    add-int/2addr v5, v6

    mul-int/2addr v5, v2

    sub-int v1, v3, v5

    .restart local v1    # "left":I
    goto :goto_1

    .line 116
    :cond_4
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mNum:I

    rem-int/lit8 v5, v5, 0x2

    if-nez v5, :cond_2

    .line 117
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mDotPadding:I

    div-int/lit8 v5, v5, 0x2

    add-int/2addr v1, v5

    goto :goto_2

    .line 128
    .restart local v0    # "i":I
    .restart local v4    # "top":I
    :cond_5
    iget-boolean v5, p0, Lco/vine/android/widget/DotIndicators;->mOffAlpha:Z

    if-eqz v5, :cond_6

    .line 129
    iget-object v5, p0, Lco/vine/android/widget/DotIndicators;->mPaint:Landroid/graphics/Paint;

    iget v6, p0, Lco/vine/android/widget/DotIndicators;->mOffAlphaValue:I

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 130
    iget-object v5, p0, Lco/vine/android/widget/DotIndicators;->mOn:Landroid/graphics/Bitmap;

    int-to-float v6, v1

    int-to-float v7, v4

    iget-object v8, p0, Lco/vine/android/widget/DotIndicators;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v5, v6, v7, v8}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto :goto_4

    .line 132
    :cond_6
    iget-object v5, p0, Lco/vine/android/widget/DotIndicators;->mOff:Landroid/graphics/Bitmap;

    int-to-float v6, v1

    int-to-float v7, v4

    invoke-virtual {p1, v5, v6, v7, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto :goto_4

    .line 139
    :cond_7
    iget-boolean v5, p0, Lco/vine/android/widget/DotIndicators;->mShowFinalIcon:Z

    if-eqz v5, :cond_0

    .line 140
    iget v5, p0, Lco/vine/android/widget/DotIndicators;->mActivePos:I

    iget v6, p0, Lco/vine/android/widget/DotIndicators;->mNum:I

    if-ne v5, v6, :cond_8

    .line 141
    iget-object v5, p0, Lco/vine/android/widget/DotIndicators;->mFinalIconOn:Landroid/graphics/Bitmap;

    int-to-float v6, v1

    int-to-float v7, v4

    invoke-virtual {p1, v5, v6, v7, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 143
    :cond_8
    iget-object v5, p0, Lco/vine/android/widget/DotIndicators;->mFinalIconOff:Landroid/graphics/Bitmap;

    int-to-float v6, v1

    int-to-float v7, v4

    invoke-virtual {p1, v5, v6, v7, v9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0
.end method

.method protected onSizeChanged(IIII)V
    .locals 0
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 150
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/View;->onSizeChanged(IIII)V

    .line 151
    iput p1, p0, Lco/vine/android/widget/DotIndicators;->mWidth:I

    .line 152
    iput p2, p0, Lco/vine/android/widget/DotIndicators;->mHeight:I

    .line 153
    return-void
.end method

.method public setActiveDot(I)V
    .locals 0
    .param p1, "active"    # I

    .prologue
    .line 165
    iput p1, p0, Lco/vine/android/widget/DotIndicators;->mActivePos:I

    .line 166
    invoke-virtual {p0}, Lco/vine/android/widget/DotIndicators;->invalidate()V

    .line 167
    return-void
.end method

.method public setFinalIcon(Z)V
    .locals 0
    .param p1, "finalIcon"    # Z

    .prologue
    .line 160
    iput-boolean p1, p0, Lco/vine/android/widget/DotIndicators;->mShowFinalIcon:Z

    .line 161
    return-void
.end method

.method public setNumberOfDots(I)V
    .locals 0
    .param p1, "num"    # I

    .prologue
    .line 156
    iput p1, p0, Lco/vine/android/widget/DotIndicators;->mNum:I

    .line 157
    return-void
.end method
