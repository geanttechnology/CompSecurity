.class Lco/vine/android/dragsort/DragSortWidget$DropAnimator;
.super Lco/vine/android/animation/SmoothAnimator;
.source "DragSortWidget.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/dragsort/DragSortWidget;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DropAnimator"
.end annotation


# instance fields
.field private mDeltaX:F

.field private mDeltaY:F

.field private mTargetPosition:I

.field private mTargetX:I

.field private mTargetY:I

.field final synthetic this$0:Lco/vine/android/dragsort/DragSortWidget;


# direct methods
.method public constructor <init>(Lco/vine/android/dragsort/DragSortWidget;FI)V
    .locals 0
    .param p2, "smoothness"    # F
    .param p3, "duration"    # I

    .prologue
    .line 799
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    .line 800
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/animation/SmoothAnimator;-><init>(Landroid/view/View;FI)V

    .line 801
    return-void
.end method


# virtual methods
.method public onStart()V
    .locals 4

    .prologue
    .line 805
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I
    invoke-static {v1}, Lco/vine/android/dragsort/DragSortWidget;->access$100(Lco/vine/android/dragsort/DragSortWidget;)I

    move-result v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetPosition:I

    .line 806
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v1}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v1

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetPosition:I

    iget-object v3, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v3}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {v1, v2}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 807
    .local v0, "hoverItem":Landroid/view/View;
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    const/4 v2, 0x1

    iput-boolean v2, v1, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    .line 808
    if-eqz v0, :cond_0

    .line 809
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v1

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v2}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetY:I

    .line 810
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v1

    iget-object v2, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v2}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetX:I

    .line 816
    :goto_0
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I
    invoke-static {v1}, Lco/vine/android/dragsort/DragSortWidget;->access$700(Lco/vine/android/dragsort/DragSortWidget;)I

    move-result v1

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetX:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mDeltaX:F

    .line 817
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I
    invoke-static {v1}, Lco/vine/android/dragsort/DragSortWidget;->access$800(Lco/vine/android/dragsort/DragSortWidget;)I

    move-result v1

    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetY:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    iput v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mDeltaY:F

    .line 818
    return-void

    .line 812
    :cond_0
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    const/4 v2, 0x0

    iput-boolean v2, v1, Lco/vine/android/dragsort/DragSortWidget;->mDropping:Z

    .line 813
    iget-object v1, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mFloatViewDestroyAnimator:Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;
    invoke-static {v1}, Lco/vine/android/dragsort/DragSortWidget;->access$600(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/dragsort/DragSortWidget$FloatViewDestroyAnimator;->start()V

    .line 814
    invoke-virtual {p0}, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->cancel()V

    goto :goto_0
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 840
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # invokes: Lco/vine/android/dragsort/DragSortWidget;->finishDrop()V
    invoke-static {v0}, Lco/vine/android/dragsort/DragSortWidget;->access$900(Lco/vine/android/dragsort/DragSortWidget;)V

    .line 841
    return-void
.end method

.method public onUpdate(FF)V
    .locals 7
    .param p1, "frac"    # F
    .param p2, "smoothFrac"    # F

    .prologue
    .line 822
    iget v2, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetX:I

    .line 823
    .local v2, "newTargetX":I
    iget v3, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetY:I

    .line 824
    .local v3, "newTargetY":I
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v4}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v4

    iget v5, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetPosition:I

    iget-object v6, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v6}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/views/HorizontalListView;->getFirstVisiblePosition()I

    move-result v6

    sub-int/2addr v5, v6

    invoke-virtual {v4, v5}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 825
    .local v1, "hoverItem":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 826
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v4

    iget-object v5, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v5}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/views/HorizontalListView;->getTop()I

    move-result v5

    add-int v3, v4, v5

    .line 827
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v4

    iget-object v5, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mListView:Lco/vine/android/views/HorizontalListView;
    invoke-static {v5}, Lco/vine/android/dragsort/DragSortWidget;->access$000(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/views/HorizontalListView;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/views/HorizontalListView;->getLeft()I

    move-result v5

    add-int v2, v4, v5

    .line 829
    :cond_0
    iput v2, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetX:I

    .line 830
    iput v3, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetY:I

    .line 832
    const/high16 v4, 0x3f800000    # 1.0f

    sub-float v0, v4, p2

    .line 833
    .local v0, "f":F
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    iget v5, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetX:I

    iget v6, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mDeltaX:F

    mul-float/2addr v6, v0

    float-to-int v6, v6

    add-int/2addr v5, v6

    # setter for: Lco/vine/android/dragsort/DragSortWidget;->mFloatViewX:I
    invoke-static {v4, v5}, Lco/vine/android/dragsort/DragSortWidget;->access$702(Lco/vine/android/dragsort/DragSortWidget;I)I

    .line 834
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    iget v5, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mTargetY:I

    iget v6, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->mDeltaY:F

    mul-float/2addr v6, v0

    float-to-int v6, v6

    add-int/2addr v5, v6

    # setter for: Lco/vine/android/dragsort/DragSortWidget;->mFloatViewY:I
    invoke-static {v4, v5}, Lco/vine/android/dragsort/DragSortWidget;->access$802(Lco/vine/android/dragsort/DragSortWidget;I)I

    .line 835
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DropAnimator;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    invoke-virtual {v4}, Lco/vine/android/dragsort/DragSortWidget;->invalidate()V

    .line 836
    return-void
.end method
