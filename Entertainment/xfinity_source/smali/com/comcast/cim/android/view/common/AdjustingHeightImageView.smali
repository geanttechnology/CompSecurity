.class public Lcom/comcast/cim/android/view/common/AdjustingHeightImageView;
.super Landroid/widget/ImageView;
.source "AdjustingHeightImageView.java"


# virtual methods
.method public onMeasure(II)V
    .locals 5
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/AdjustingHeightImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 24
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    move v3, p2

    .line 25
    .local v3, "newHeight":I
    if-eqz v0, :cond_0

    .line 26
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 27
    .local v2, "drawableWidth":I
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    .line 28
    .local v1, "drawableHeight":I
    mul-int v4, p1, v1

    div-int v3, v4, v2

    .line 29
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v4

    invoke-virtual {p0, v4, v3}, Lcom/comcast/cim/android/view/common/AdjustingHeightImageView;->setMeasuredDimension(II)V

    .line 34
    .end local v1    # "drawableHeight":I
    .end local v2    # "drawableWidth":I
    :goto_0
    return-void

    .line 31
    :cond_0
    invoke-super {p0, p1, v3}, Landroid/widget/ImageView;->onMeasure(II)V

    goto :goto_0
.end method
