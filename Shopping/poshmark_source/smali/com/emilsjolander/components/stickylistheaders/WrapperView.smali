.class Lcom/emilsjolander/components/stickylistheaders/WrapperView;
.super Landroid/view/ViewGroup;
.source "WrapperView.java"


# instance fields
.field mDivider:Landroid/graphics/drawable/Drawable;

.field mDividerHeight:I

.field mHeader:Landroid/view/View;

.field mItem:Landroid/view/View;

.field mItemTop:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 27
    return-void
.end method


# virtual methods
.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v2, 0x0

    .line 132
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 133
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDivider:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_1

    .line 136
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-ge v0, v1, :cond_0

    .line 137
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->getWidth()I

    move-result v0

    iget v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDividerHeight:I

    invoke-virtual {p1, v2, v2, v0, v1}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 139
    :cond_0
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDivider:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 141
    :cond_1
    return-void
.end method

.method hasHeader()Z
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onLayout(ZIIII)V
    .locals 3
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 110
    const/4 p2, 0x0

    .line 111
    const/4 p3, 0x0

    .line 112
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->getWidth()I

    move-result p4

    .line 113
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->getHeight()I

    move-result p5

    .line 115
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 116
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    .line 117
    .local v0, "headerHeight":I
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    invoke-virtual {v1, p2, p3, p4, v0}, Landroid/view/View;->layout(IIII)V

    .line 118
    iput v0, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItemTop:I

    .line 119
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    invoke-virtual {v1, p2, v0, p4, p5}, Landroid/view/View;->layout(IIII)V

    .line 128
    .end local v0    # "headerHeight":I
    :goto_0
    return-void

    .line 120
    :cond_0
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDivider:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_1

    .line 121
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDivider:Landroid/graphics/drawable/Drawable;

    iget v2, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDividerHeight:I

    invoke-virtual {v1, p2, p3, p4, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 122
    iget v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDividerHeight:I

    iput v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItemTop:I

    .line 123
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    iget v2, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDividerHeight:I

    invoke-virtual {v1, p2, v2, p4, p5}, Landroid/view/View;->layout(IIII)V

    goto :goto_0

    .line 125
    :cond_1
    iput p3, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItemTop:I

    .line 126
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    invoke-virtual {v1, p2, p3, p4, p5}, Landroid/view/View;->layout(IIII)V

    goto :goto_0
.end method

.method protected onMeasure(II)V
    .locals 8
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v7, 0x40000000    # 2.0f

    const/4 v6, 0x0

    .line 73
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 74
    .local v2, "measuredWidth":I
    invoke-static {v2, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 76
    .local v0, "childWidthMeasureSpec":I
    const/4 v1, 0x0

    .line 79
    .local v1, "measuredHeight":I
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    if-eqz v4, :cond_2

    .line 80
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .line 81
    .local v3, "params":Landroid/view/ViewGroup$LayoutParams;
    if-eqz v3, :cond_1

    iget v4, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-lez v4, :cond_1

    .line 82
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    iget v5, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    invoke-static {v5, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    invoke-virtual {v4, v0, v5}, Landroid/view/View;->measure(II)V

    .line 88
    :goto_0
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    add-int/2addr v1, v4

    .line 94
    .end local v3    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    :goto_1
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .line 95
    .restart local v3    # "params":Landroid/view/ViewGroup$LayoutParams;
    if-eqz v3, :cond_3

    iget v4, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-lez v4, :cond_3

    .line 96
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    iget v5, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    invoke-static {v5, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    invoke-virtual {v4, v0, v5}, Landroid/view/View;->measure(II)V

    .line 102
    :goto_2
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    add-int/2addr v1, v4

    .line 104
    invoke-virtual {p0, v2, v1}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->setMeasuredDimension(II)V

    .line 105
    return-void

    .line 85
    :cond_1
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    invoke-static {v6, v6}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    invoke-virtual {v4, v0, v5}, Landroid/view/View;->measure(II)V

    goto :goto_0

    .line 89
    .end local v3    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_2
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDivider:Landroid/graphics/drawable/Drawable;

    if-eqz v4, :cond_0

    .line 90
    iget v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDividerHeight:I

    add-int/2addr v1, v4

    goto :goto_1

    .line 99
    .restart local v3    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_3
    iget-object v4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    invoke-static {v6, v6}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v5

    invoke-virtual {v4, v0, v5}, Landroid/view/View;->measure(II)V

    goto :goto_2
.end method

.method update(Landroid/view/View;Landroid/view/View;Landroid/graphics/drawable/Drawable;I)V
    .locals 3
    .param p1, "item"    # Landroid/view/View;
    .param p2, "header"    # Landroid/view/View;
    .param p3, "divider"    # Landroid/graphics/drawable/Drawable;
    .param p4, "dividerHeight"    # I

    .prologue
    .line 32
    if-nez p1, :cond_0

    .line 33
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "List view item must not be null."

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 37
    :cond_0
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    if-eq v1, p1, :cond_2

    .line 38
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->removeView(Landroid/view/View;)V

    .line 39
    iput-object p1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mItem:Landroid/view/View;

    .line 40
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 41
    .local v0, "parent":Landroid/view/ViewParent;
    if-eqz v0, :cond_1

    if-eq v0, p0, :cond_1

    .line 42
    instance-of v1, v0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_1

    .line 43
    check-cast v0, Landroid/view/ViewGroup;

    .end local v0    # "parent":Landroid/view/ViewParent;
    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 46
    :cond_1
    invoke-virtual {p0, p1}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->addView(Landroid/view/View;)V

    .line 50
    :cond_2
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    if-eq v1, p2, :cond_4

    .line 51
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    if-eqz v1, :cond_3

    .line 52
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    invoke-virtual {p0, v1}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->removeView(Landroid/view/View;)V

    .line 54
    :cond_3
    iput-object p2, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mHeader:Landroid/view/View;

    .line 55
    if-eqz p2, :cond_4

    .line 56
    invoke-virtual {p0, p2}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->addView(Landroid/view/View;)V

    .line 60
    :cond_4
    iget-object v1, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDivider:Landroid/graphics/drawable/Drawable;

    if-eq v1, p3, :cond_5

    .line 61
    iput-object p3, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDivider:Landroid/graphics/drawable/Drawable;

    .line 62
    iput p4, p0, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->mDividerHeight:I

    .line 63
    invoke-virtual {p0}, Lcom/emilsjolander/components/stickylistheaders/WrapperView;->invalidate()V

    .line 65
    :cond_5
    return-void
.end method
