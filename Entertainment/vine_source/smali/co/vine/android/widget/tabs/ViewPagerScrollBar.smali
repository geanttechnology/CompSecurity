.class public Lco/vine/android/widget/tabs/ViewPagerScrollBar;
.super Landroid/view/View;
.source "ViewPagerScrollBar.java"


# instance fields
.field private mColorIds:[I

.field private mHeight:I

.field private mNavBottomSet:Z

.field private mOffset:I

.field private mOffsetPixels:I

.field private final mPaint:Landroid/graphics/Paint;

.field private mPosition:I

.field private mRange:I

.field private final mTabBounds:Landroid/graphics/RectF;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 40
    const/4 v0, 0x0

    const v1, 0x7f010046

    invoke-direct {p0, p1, v0, v1}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 44
    const v0, 0x7f010046

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 45
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 48
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 31
    iput v6, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mHeight:I

    .line 33
    iput v5, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mRange:I

    .line 36
    iput v6, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mOffset:I

    .line 37
    iput-boolean v6, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mNavBottomSet:Z

    .line 49
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    iput-object v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPaint:Landroid/graphics/Paint;

    .line 50
    new-instance v4, Landroid/graphics/RectF;

    invoke-direct {v4}, Landroid/graphics/RectF;-><init>()V

    iput-object v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mTabBounds:Landroid/graphics/RectF;

    .line 51
    sget-object v4, Lco/vine/android/R$styleable;->ViewPagerScrollBar:[I

    invoke-virtual {p1, p2, v4, p3, v6}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 54
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v4, 0x2

    invoke-virtual {v0, v4, v6}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .line 55
    .local v1, "colorArrayRes":I
    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v4

    iput v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mHeight:I

    .line 56
    if-lez v1, :cond_1

    .line 57
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v1}, Landroid/content/res/Resources;->obtainTypedArray(I)Landroid/content/res/TypedArray;

    move-result-object v3

    .line 58
    .local v3, "ta":Landroid/content/res/TypedArray;
    invoke-virtual {v3}, Landroid/content/res/TypedArray;->length()I

    move-result v4

    new-array v4, v4, [I

    iput-object v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mColorIds:[I

    .line 59
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {v3}, Landroid/content/res/TypedArray;->length()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 60
    iget-object v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mColorIds:[I

    invoke-virtual {v3, v2, v6}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v5

    aput v5, v4, v2

    .line 59
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 62
    :cond_0
    invoke-virtual {v3}, Landroid/content/res/TypedArray;->recycle()V

    .line 63
    iget-object v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPaint:Landroid/graphics/Paint;

    iget-object v5, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mColorIds:[I

    aget v5, v5, v6

    invoke-virtual {v4, v5}, Landroid/graphics/Paint;->setColor(I)V

    .line 69
    .end local v2    # "i":I
    .end local v3    # "ta":Landroid/content/res/TypedArray;
    :goto_1
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 70
    return-void

    .line 66
    :cond_1
    iget-object v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPaint:Landroid/graphics/Paint;

    const/4 v5, -0x1

    invoke-virtual {v0, v6, v5}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/graphics/Paint;->setColor(I)V

    goto :goto_1
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 83
    iget-object v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mTabBounds:Landroid/graphics/RectF;

    iget-object v1, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 84
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 1
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 74
    invoke-super/range {p0 .. p5}, Landroid/view/View;->onLayout(ZIIII)V

    .line 75
    iget-boolean v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mNavBottomSet:Z

    if-nez v0, :cond_0

    .line 76
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->getHeight()I

    move-result v0

    iput v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mOffset:I

    .line 78
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->updateBounds()V

    .line 79
    return-void
.end method

.method public scroll(II)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "pixels"    # I

    .prologue
    .line 119
    iput p1, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPosition:I

    .line 120
    iget v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mRange:I

    div-int v0, p2, v0

    int-to-float v0, v0

    invoke-static {v0}, Landroid/util/FloatMath;->ceil(F)F

    move-result v0

    float-to-int v0, v0

    iput v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mOffsetPixels:I

    .line 121
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->updateBounds()V

    .line 122
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->invalidate()V

    .line 123
    return-void
.end method

.method public setColorIds(I)V
    .locals 3
    .param p1, "colorsResId"    # I

    .prologue
    .line 133
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mColorIds:[I

    .line 134
    iget-object v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPaint:Landroid/graphics/Paint;

    iget-object v1, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mColorIds:[I

    const/4 v2, 0x0

    aget v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 135
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->requestLayout()V

    .line 136
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->invalidate()V

    .line 137
    return-void
.end method

.method public setLineColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 140
    iget-object v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 141
    return-void
.end method

.method public setNavOffset(I)V
    .locals 1
    .param p1, "offset"    # I

    .prologue
    .line 102
    iput p1, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mOffset:I

    .line 103
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mNavBottomSet:Z

    .line 104
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->updateBounds()V

    .line 105
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->invalidate()V

    .line 106
    return-void
.end method

.method public setPageColor(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 127
    iget-object v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mColorIds:[I

    if-eqz v0, :cond_0

    .line 128
    iget-object v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPaint:Landroid/graphics/Paint;

    iget-object v1, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mColorIds:[I

    aget v1, v1, p1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 130
    :cond_0
    return-void
.end method

.method public setPosition(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 95
    iput p1, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPosition:I

    .line 96
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mOffsetPixels:I

    .line 97
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->updateBounds()V

    .line 98
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->invalidate()V

    .line 99
    return-void
.end method

.method public setRange(I)V
    .locals 2
    .param p1, "range"    # I

    .prologue
    .line 109
    iput p1, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mRange:I

    .line 110
    iget v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mRange:I

    if-nez v0, :cond_0

    .line 111
    const/4 v0, 0x1

    iput v0, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mRange:I

    .line 112
    new-instance v0, Lco/vine/android/VineLoggingException;

    const-string v1, "Someone is trying to set the range to be 0, defaulting back to 1."

    invoke-direct {v0, v1}, Lco/vine/android/VineLoggingException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 114
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->requestLayout()V

    .line 115
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->invalidate()V

    .line 116
    return-void
.end method

.method public updateBounds()V
    .locals 8

    .prologue
    .line 87
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->getWidth()I

    move-result v4

    iget v5, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mRange:I

    div-int/2addr v4, v5

    int-to-float v3, v4

    .line 88
    .local v3, "width":F
    iget v1, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mOffsetPixels:I

    .line 89
    .local v1, "v":I
    iget v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mPosition:I

    int-to-float v4, v4

    mul-float v2, v3, v4

    .line 90
    .local v2, "w":F
    int-to-float v4, v1

    add-float v0, v4, v2

    .line 91
    .local v0, "left":F
    iget-object v4, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mTabBounds:Landroid/graphics/RectF;

    iget v5, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mOffset:I

    iget v6, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mHeight:I

    sub-int/2addr v5, v6

    int-to-float v5, v5

    add-float v6, v0, v3

    iget v7, p0, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->mOffset:I

    int-to-float v7, v7

    invoke-virtual {v4, v0, v5, v6, v7}, Landroid/graphics/RectF;->set(FFFF)V

    .line 92
    return-void
.end method
