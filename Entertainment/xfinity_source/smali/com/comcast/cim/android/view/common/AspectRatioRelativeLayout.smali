.class public Lcom/comcast/cim/android/view/common/AspectRatioRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "AspectRatioRelativeLayout.java"


# instance fields
.field private aspectRatio:Ljava/lang/Float;


# virtual methods
.method public onMeasure(II)V
    .locals 5
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v4, -0x80000000

    .line 33
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/AspectRatioRelativeLayout;->aspectRatio:Ljava/lang/Float;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/comcast/cim/android/view/common/AspectRatioRelativeLayout;->aspectRatio:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    const/4 v3, 0x0

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_1

    .line 34
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/RelativeLayout;->onMeasure(II)V

    .line 40
    :goto_0
    return-void

    .line 36
    :cond_1
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    .line 37
    .local v1, "newWidthSpec":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/comcast/cim/android/view/common/AspectRatioRelativeLayout;->aspectRatio:Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    div-float/2addr v2, v3

    float-to-int v2, v2

    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 38
    .local v0, "newHeightSpec":I
    invoke-super {p0, v1, v0}, Landroid/widget/RelativeLayout;->onMeasure(II)V

    goto :goto_0
.end method
