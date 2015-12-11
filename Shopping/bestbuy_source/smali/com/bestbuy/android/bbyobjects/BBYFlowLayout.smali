.class public Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;
.super Landroid/view/ViewGroup;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 12
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 16
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 20
    return-void
.end method


# virtual methods
.method protected onLayout(ZIIII)V
    .locals 10

    .prologue
    const/4 v0, 0x0

    .line 63
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingLeft()I

    move-result v2

    .line 64
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingTop()I

    move-result v1

    .line 66
    sub-int v5, p4, p2

    move v3, v2

    move v2, v1

    move v1, v0

    .line 67
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getChildCount()I

    move-result v4

    if-ge v0, v4, :cond_2

    .line 68
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 69
    invoke-virtual {v6}, Landroid/view/View;->getVisibility()I

    move-result v4

    const/16 v7, 0x8

    if-ne v4, v7, :cond_0

    .line 67
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 72
    :cond_0
    invoke-virtual {v6}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    .line 73
    invoke-virtual {v6}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    .line 74
    invoke-static {v4, v1}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 75
    add-int v8, v7, v3

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingRight()I

    move-result v9

    add-int/2addr v8, v9

    if-le v8, v5, :cond_1

    .line 76
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingLeft()I

    move-result v3

    .line 77
    add-int/lit8 v1, v1, 0x2

    add-int/2addr v2, v1

    move v1, v4

    .line 80
    :cond_1
    add-int v8, v3, v7

    add-int/2addr v4, v2

    invoke-virtual {v6, v3, v2, v8, v4}, Landroid/view/View;->layout(IIII)V

    .line 81
    add-int/lit8 v4, v7, 0xf

    add-int/2addr v3, v4

    goto :goto_1

    .line 83
    :cond_2
    return-void
.end method

.method protected onMeasure(II)V
    .locals 10

    .prologue
    const/4 v1, 0x0

    .line 24
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingLeft()I

    move-result v2

    .line 25
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingTop()I

    move-result v0

    .line 29
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    move v3, v0

    move v4, v2

    move v0, v1

    move v2, v1

    .line 31
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getChildCount()I

    move-result v5

    if-ge v0, v5, :cond_2

    .line 32
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    .line 33
    invoke-virtual {v5}, Landroid/view/View;->getVisibility()I

    move-result v7

    const/16 v8, 0x8

    if-ne v7, v8, :cond_0

    .line 31
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 37
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingLeft()I

    move-result v7

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingRight()I

    move-result v8

    add-int/2addr v7, v8

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    iget v8, v8, Landroid/view/ViewGroup$LayoutParams;->width:I

    invoke-static {p1, v7, v8}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getChildMeasureSpec(III)I

    move-result v7

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingTop()I

    move-result v8

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingBottom()I

    move-result v9

    add-int/2addr v8, v9

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    iget v9, v9, Landroid/view/ViewGroup$LayoutParams;->height:I

    invoke-static {p2, v8, v9}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getChildMeasureSpec(III)I

    move-result v8

    invoke-virtual {v5, v7, v8}, Landroid/view/View;->measure(II)V

    .line 43
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    .line 44
    invoke-virtual {v5}, Landroid/view/View;->getMeasuredHeight()I

    move-result v5

    .line 47
    invoke-static {v5, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 48
    add-int v8, v7, v4

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingRight()I

    move-result v9

    add-int/2addr v8, v9

    if-le v8, v6, :cond_1

    .line 50
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingLeft()I

    move-result v4

    .line 51
    add-int/lit8 v2, v2, 0x2

    add-int/2addr v3, v2

    move v2, v5

    .line 54
    :cond_1
    add-int/lit8 v5, v7, 0xf

    add-int/2addr v4, v5

    goto :goto_1

    .line 56
    :cond_2
    add-int v0, v3, v2

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->getPaddingBottom()I

    move-result v2

    add-int/2addr v0, v2

    add-int/2addr v0, v1

    .line 57
    invoke-static {v0, p2}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->resolveSize(II)I

    move-result v0

    invoke-virtual {p0, v6, v0}, Lcom/bestbuy/android/bbyobjects/BBYFlowLayout;->setMeasuredDimension(II)V

    .line 59
    return-void
.end method
