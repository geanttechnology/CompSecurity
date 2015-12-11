.class Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FullWidthFixedViewLayout;
.super Landroid/widget/FrameLayout;
.source "HeaderGridView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FullWidthFixedViewLayout"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;Landroid/content/Context;)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 202
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FullWidthFixedViewLayout;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;

    .line 203
    invoke-direct {p0, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 204
    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 3
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 208
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FullWidthFixedViewLayout;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getMeasuredWidth()I

    move-result v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FullWidthFixedViewLayout;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getPaddingLeft()I

    move-result v2

    sub-int/2addr v1, v2

    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView$FullWidthFixedViewLayout;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/HeaderGridView;->getPaddingRight()I

    move-result v2

    sub-int v0, v1, v2

    .line 211
    .local v0, "targetWidth":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p1

    .line 213
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    .line 214
    return-void
.end method
