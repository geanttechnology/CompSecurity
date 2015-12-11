.class public Lcom/wishabi/flipp/widget/ViewPagerIndicator;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field private a:Landroid/support/v4/view/ViewPager;

.field private final b:Landroid/graphics/Paint;

.field private final c:Landroid/graphics/Paint;

.field private d:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 37
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 23
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v6}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->b:Landroid/graphics/Paint;

    .line 24
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v6}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->c:Landroid/graphics/Paint;

    .line 39
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 40
    if-nez v0, :cond_1

    .line 73
    :cond_0
    :goto_0
    return-void

    .line 43
    :cond_1
    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 45
    if-eqz v1, :cond_0

    .line 48
    sget-object v2, Lcom/wishabi/flipp/b;->ViewPagerIndicator:[I

    invoke-virtual {p1, p2, v2, p3, v7}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v2

    .line 50
    if-eqz v2, :cond_0

    .line 53
    const/4 v3, 0x2

    const/high16 v4, 0x40a00000    # 5.0f

    invoke-static {v6, v4, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v4

    float-to-int v4, v4

    int-to-float v4, v4

    invoke-virtual {v2, v3, v4}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v3

    float-to-int v3, v3

    .line 57
    const/4 v4, 0x3

    const/high16 v5, 0x40400000    # 3.0f

    invoke-static {v6, v5, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v1

    float-to-int v1, v1

    int-to-float v1, v1

    invoke-virtual {v2, v4, v1}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v1

    float-to-int v1, v1

    iput v1, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->d:I

    .line 62
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->b:Landroid/graphics/Paint;

    const v4, 0x7f090063

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v2, v7, v4}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v4

    invoke-virtual {v1, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 65
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->b:Landroid/graphics/Paint;

    int-to-float v4, v3

    invoke-virtual {v1, v4}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 67
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->c:Landroid/graphics/Paint;

    const v4, 0x7f090064

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v2, v6, v0}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 70
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->c:Landroid/graphics/Paint;

    int-to-float v1, v3

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 72
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    goto :goto_0
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 11

    .prologue
    .line 77
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 81
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    const/4 v1, 0x3

    .line 83
    const/4 v0, 0x5

    move v6, v0

    move v7, v1

    .line 98
    :goto_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->getPaddingTop()I

    move-result v0

    int-to-float v0, v0

    .line 99
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->getPaddingLeft()I

    move-result v1

    int-to-float v9, v1

    .line 100
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->getPaddingRight()I

    move-result v1

    int-to-float v1, v1

    .line 101
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->getWidth()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v2, v9

    sub-float v1, v2, v1

    .line 103
    iget v2, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->d:I

    add-int/lit8 v3, v6, -0x1

    mul-int/2addr v2, v3

    int-to-float v2, v2

    sub-float/2addr v1, v2

    int-to-float v2, v6

    div-float/2addr v1, v2

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v10

    .line 106
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->getHeight()I

    move-result v1

    int-to-float v1, v1

    sub-float/2addr v1, v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->getPaddingBottom()I

    move-result v2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    const/high16 v2, 0x40000000    # 2.0f

    div-float/2addr v1, v2

    add-float v2, v0, v1

    .line 109
    const/4 v0, 0x0

    move v8, v0

    :goto_1
    if-ge v8, v6, :cond_1

    .line 110
    int-to-float v0, v8

    iget v1, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->d:I

    int-to-float v1, v1

    add-float/2addr v1, v10

    mul-float/2addr v0, v1

    add-float v1, v9, v0

    .line 111
    add-float v3, v1, v10

    .line 112
    if-ne v8, v7, :cond_3

    iget-object v5, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->c:Landroid/graphics/Paint;

    :goto_2
    move-object v0, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 109
    add-int/lit8 v0, v8, 0x1

    move v8, v0

    goto :goto_1

    .line 85
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->a:Landroid/support/v4/view/ViewPager;

    if-nez v0, :cond_2

    .line 115
    :cond_1
    return-void

    .line 88
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->a:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/ae;

    move-result-object v0

    .line 89
    if-eqz v0, :cond_1

    .line 92
    invoke-virtual {v0}, Landroid/support/v4/view/ae;->c()I

    move-result v0

    .line 93
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->a:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    .line 94
    if-eqz v0, :cond_1

    move v6, v0

    move v7, v1

    goto :goto_0

    .line 112
    :cond_3
    iget-object v5, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->b:Landroid/graphics/Paint;

    goto :goto_2
.end method

.method public setViewPager(Landroid/support/v4/view/ViewPager;)V
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->a:Landroid/support/v4/view/ViewPager;

    if-ne v0, p1, :cond_0

    .line 127
    :goto_0
    return-void

    .line 121
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->a:Landroid/support/v4/view/ViewPager;

    if-eqz v0, :cond_1

    .line 122
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->a:Landroid/support/v4/view/ViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/cd;)V

    .line 125
    :cond_1
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->a:Landroid/support/v4/view/ViewPager;

    .line 126
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->invalidate()V

    goto :goto_0
.end method
