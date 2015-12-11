.class Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;
.super Ljava/lang/Object;
.source "AbsHListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AbsHListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FlingRunnable"
.end annotation


# instance fields
.field private final mCheckFlywheel:Ljava/lang/Runnable;

.field private mLastFlingX:I

.field private final mScroller:Lit/sephiroth/android/library/widget/OverScroller;

.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 2

    .prologue
    .line 3712
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3685
    new-instance v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable$1;

    invoke-direct {v0, p0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable$1;-><init>(Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mCheckFlywheel:Ljava/lang/Runnable;

    .line 3713
    new-instance v0, Lit/sephiroth/android/library/widget/OverScroller;

    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/AbsHListView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lit/sephiroth/android/library/widget/OverScroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    .line 3714
    return-void
.end method

.method static synthetic access$1000(Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;)Lit/sephiroth/android/library/widget/OverScroller;
    .locals 1
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;

    .prologue
    .line 3673
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    return-object v0
.end method


# virtual methods
.method edgeReached(I)V
    .locals 6
    .param p1, "delta"    # I

    .prologue
    .line 3745
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v3

    const/4 v4, 0x0

    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v5, v5, Lit/sephiroth/android/library/widget/AbsHListView;->mOverflingDistance:I

    invoke-virtual {v2, v3, v4, v5}, Lit/sephiroth/android/library/widget/OverScroller;->notifyHorizontalEdgeReached(III)V

    .line 3746
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getOverScrollMode()I

    move-result v0

    .line 3747
    .local v0, "overscrollMode":I
    if-eqz v0, :cond_0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_3

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->contentFits()Z
    invoke-static {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->access$1300(Lit/sephiroth/android/library/widget/AbsHListView;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 3748
    :cond_0
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v3, 0x6

    iput v3, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3749
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/OverScroller;->getCurrVelocity()F

    move-result v2

    float-to-int v1, v2

    .line 3750
    .local v1, "vel":I
    if-lez p1, :cond_2

    .line 3751
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # getter for: Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowTop:Lit/sephiroth/android/library/widget/EdgeEffect;
    invoke-static {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->access$1400(Lit/sephiroth/android/library/widget/AbsHListView;)Lit/sephiroth/android/library/widget/EdgeEffect;

    move-result-object v2

    invoke-virtual {v2, v1}, Lit/sephiroth/android/library/widget/EdgeEffect;->onAbsorb(I)V

    .line 3761
    .end local v1    # "vel":I
    :cond_1
    :goto_0
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 3762
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v2, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v2, p0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 3763
    return-void

    .line 3753
    .restart local v1    # "vel":I
    :cond_2
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # getter for: Lit/sephiroth/android/library/widget/AbsHListView;->mEdgeGlowBottom:Lit/sephiroth/android/library/widget/EdgeEffect;
    invoke-static {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->access$1500(Lit/sephiroth/android/library/widget/AbsHListView;)Lit/sephiroth/android/library/widget/EdgeEffect;

    move-result-object v2

    invoke-virtual {v2, v1}, Lit/sephiroth/android/library/widget/EdgeEffect;->onAbsorb(I)V

    goto :goto_0

    .line 3756
    .end local v1    # "vel":I
    :cond_3
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v3, -0x1

    iput v3, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3757
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v2, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    if-eqz v2, :cond_1

    .line 3758
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v2, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScroller:Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    goto :goto_0
.end method

.method endFling()V
    .locals 10

    .prologue
    const/4 v1, 0x0

    .line 3775
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v2, -0x1

    iput v2, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3777
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0, p0}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 3778
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mCheckFlywheel:Ljava/lang/Runnable;

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 3780
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    .line 3781
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->clearScrollingCache()V
    invoke-static {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->access$1600(Lit/sephiroth/android/library/widget/AbsHListView;)V

    .line 3782
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/OverScroller;->abortAnimation()V

    .line 3784
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move v2, v1

    move v3, v1

    move v4, v1

    move v5, v1

    move v6, v1

    move v7, v1

    move v8, v1

    move v9, v1

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->overScrollBy(IIIIIIIIZ)Z
    invoke-static/range {v0 .. v9}, Lit/sephiroth/android/library/widget/AbsHListView;->access$1700(Lit/sephiroth/android/library/widget/AbsHListView;IIIIIIIIZ)Z

    .line 3786
    return-void
.end method

.method flywheelTouch()V
    .locals 4

    .prologue
    .line 3789
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mCheckFlywheel:Ljava/lang/Runnable;

    const-wide/16 v2, 0x28

    invoke-virtual {v0, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 3790
    return-void
.end method

.method public run()V
    .locals 29

    .prologue
    .line 3794
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v2, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    packed-switch v2, :pswitch_data_0

    .line 3796
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    .line 3905
    :cond_0
    :goto_0
    return-void

    .line 3800
    :pswitch_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/OverScroller;->isFinished()Z

    move-result v2

    if-nez v2, :cond_0

    .line 3805
    :pswitch_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-boolean v2, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    if-eqz v2, :cond_1

    .line 3806
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->layoutChildren()V

    .line 3809
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v2, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-eqz v2, :cond_2

    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v2

    if-nez v2, :cond_3

    .line 3810
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    goto :goto_0

    .line 3814
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    move-object/from16 v26, v0

    .line 3815
    .local v26, "scroller":Lit/sephiroth/android/library/widget/OverScroller;
    invoke-virtual/range {v26 .. v26}, Lit/sephiroth/android/library/widget/OverScroller;->computeScrollOffset()Z

    move-result v22

    .line 3816
    .local v22, "more":Z
    invoke-virtual/range {v26 .. v26}, Lit/sephiroth/android/library/widget/OverScroller;->getCurrX()I

    move-result v28

    .line 3820
    .local v28, "x":I
    move-object/from16 v0, p0

    iget v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mLastFlingX:I

    sub-int v19, v2, v28

    .line 3823
    .local v19, "delta":I
    if-lez v19, :cond_6

    .line 3825
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v4, v4, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    iput v4, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 3826
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v20

    .line 3827
    .local v20, "firstView":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual/range {v20 .. v20}, Landroid/view/View;->getLeft()I

    move-result v4

    iput v4, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewOriginalLeft:I

    .line 3830
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v2

    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v4

    sub-int/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingLeft()I

    move-result v4

    sub-int/2addr v2, v4

    add-int/lit8 v2, v2, -0x1

    move/from16 v0, v19

    invoke-static {v2, v0}, Ljava/lang/Math;->min(II)I

    move-result v19

    .line 3844
    .end local v20    # "firstView":Landroid/view/View;
    :goto_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v4, v4, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    move-object/from16 v0, p0

    iget-object v6, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v6, v6, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int/2addr v4, v6

    invoke-virtual {v2, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v23

    .line 3845
    .local v23, "motionView":Landroid/view/View;
    const/16 v25, 0x0

    .line 3846
    .local v25, "oldLeft":I
    if-eqz v23, :cond_4

    .line 3847
    invoke-virtual/range {v23 .. v23}, Landroid/view/View;->getLeft()I

    move-result v25

    .line 3851
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move/from16 v0, v19

    move/from16 v1, v19

    invoke-virtual {v2, v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->trackMotionScroll(II)Z

    move-result v14

    .line 3852
    .local v14, "atEdge":Z
    if-eqz v14, :cond_7

    if-eqz v19, :cond_7

    const/4 v15, 0x1

    .line 3853
    .local v15, "atEnd":Z
    :goto_2
    if-eqz v15, :cond_8

    .line 3854
    if-eqz v23, :cond_5

    .line 3856
    invoke-virtual/range {v23 .. v23}, Landroid/view/View;->getLeft()I

    move-result v2

    sub-int v2, v2, v25

    sub-int v2, v19, v2

    neg-int v3, v2

    .line 3857
    .local v3, "overshoot":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object/from16 v0, p0

    iget-object v9, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v9, v9, Lit/sephiroth/android/library/widget/AbsHListView;->mOverflingDistance:I

    const/4 v10, 0x0

    const/4 v11, 0x0

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->overScrollBy(IIIIIIIIZ)Z
    invoke-static/range {v2 .. v11}, Lit/sephiroth/android/library/widget/AbsHListView;->access$1800(Lit/sephiroth/android/library/widget/AbsHListView;IIIIIIIIZ)Z

    .line 3859
    .end local v3    # "overshoot":I
    :cond_5
    if-eqz v22, :cond_0

    .line 3860
    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->edgeReached(I)V

    goto/16 :goto_0

    .line 3833
    .end local v14    # "atEdge":Z
    .end local v15    # "atEnd":Z
    .end local v23    # "motionView":Landroid/view/View;
    .end local v25    # "oldLeft":I
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v2

    add-int/lit8 v24, v2, -0x1

    .line 3834
    .local v24, "offsetToLast":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v4, v4, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    add-int v4, v4, v24

    iput v4, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 3836
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move/from16 v0, v24

    invoke-virtual {v2, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v21

    .line 3837
    .local v21, "lastView":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual/range {v21 .. v21}, Landroid/view/View;->getLeft()I

    move-result v4

    iput v4, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionViewOriginalLeft:I

    .line 3840
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v2

    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingRight()I

    move-result v4

    sub-int/2addr v2, v4

    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getPaddingLeft()I

    move-result v4

    sub-int/2addr v2, v4

    add-int/lit8 v2, v2, -0x1

    neg-int v2, v2

    move/from16 v0, v19

    invoke-static {v2, v0}, Ljava/lang/Math;->max(II)I

    move-result v19

    goto/16 :goto_1

    .line 3852
    .end local v21    # "lastView":Landroid/view/View;
    .end local v24    # "offsetToLast":I
    .restart local v14    # "atEdge":Z
    .restart local v23    # "motionView":Landroid/view/View;
    .restart local v25    # "oldLeft":I
    :cond_7
    const/4 v15, 0x0

    goto/16 :goto_2

    .line 3865
    .restart local v15    # "atEnd":Z
    :cond_8
    if-eqz v22, :cond_a

    if-nez v15, :cond_a

    .line 3866
    if-eqz v14, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 3867
    :cond_9
    move/from16 v0, v28

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mLastFlingX:I

    .line 3868
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v2, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v0, p0

    invoke-virtual {v2, v0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 3870
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    goto/16 :goto_0

    .line 3877
    .end local v14    # "atEdge":Z
    .end local v15    # "atEnd":Z
    .end local v19    # "delta":I
    .end local v22    # "more":Z
    .end local v23    # "motionView":Landroid/view/View;
    .end local v25    # "oldLeft":I
    .end local v26    # "scroller":Lit/sephiroth/android/library/widget/OverScroller;
    .end local v28    # "x":I
    :pswitch_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    move-object/from16 v26, v0

    .line 3878
    .restart local v26    # "scroller":Lit/sephiroth/android/library/widget/OverScroller;
    invoke-virtual/range {v26 .. v26}, Lit/sephiroth/android/library/widget/OverScroller;->computeScrollOffset()Z

    move-result v2

    if-eqz v2, :cond_11

    .line 3879
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v7

    .line 3880
    .local v7, "scrollX":I
    invoke-virtual/range {v26 .. v26}, Lit/sephiroth/android/library/widget/OverScroller;->getCurrX()I

    move-result v18

    .line 3881
    .local v18, "currX":I
    sub-int v5, v18, v7

    .line 3882
    .local v5, "deltaX":I
    move-object/from16 v0, p0

    iget-object v4, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v6, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v11, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mOverflingDistance:I

    const/4 v12, 0x0

    const/4 v13, 0x0

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->overScrollBy(IIIIIIIIZ)Z
    invoke-static/range {v4 .. v13}, Lit/sephiroth/android/library/widget/AbsHListView;->access$1900(Lit/sephiroth/android/library/widget/AbsHListView;IIIIIIIIZ)Z

    move-result v2

    if-eqz v2, :cond_10

    .line 3883
    if-gtz v7, :cond_d

    if-lez v18, :cond_d

    const/16 v17, 0x1

    .line 3884
    .local v17, "crossRight":Z
    :goto_3
    if-ltz v7, :cond_e

    if-gez v18, :cond_e

    const/16 v16, 0x1

    .line 3885
    .local v16, "crossLeft":Z
    :goto_4
    if-nez v17, :cond_b

    if-eqz v16, :cond_f

    .line 3886
    :cond_b
    invoke-virtual/range {v26 .. v26}, Lit/sephiroth/android/library/widget/OverScroller;->getCurrVelocity()F

    move-result v2

    float-to-int v0, v2

    move/from16 v27, v0

    .line 3887
    .local v27, "velocity":I
    if-eqz v16, :cond_c

    move/from16 v0, v27

    neg-int v0, v0

    move/from16 v27, v0

    .line 3890
    :cond_c
    invoke-virtual/range {v26 .. v26}, Lit/sephiroth/android/library/widget/OverScroller;->abortAnimation()V

    .line 3891
    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->start(I)V

    goto/16 :goto_0

    .line 3883
    .end local v16    # "crossLeft":Z
    .end local v17    # "crossRight":Z
    .end local v27    # "velocity":I
    :cond_d
    const/16 v17, 0x0

    goto :goto_3

    .line 3884
    .restart local v17    # "crossRight":Z
    :cond_e
    const/16 v16, 0x0

    goto :goto_4

    .line 3893
    .restart local v16    # "crossLeft":Z
    :cond_f
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->startSpringback()V

    goto/16 :goto_0

    .line 3896
    .end local v16    # "crossLeft":Z
    .end local v17    # "crossRight":Z
    :cond_10
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 3897
    move-object/from16 v0, p0

    iget-object v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v2, v2, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v0, p0

    invoke-virtual {v2, v0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 3900
    .end local v5    # "deltaX":I
    .end local v7    # "scrollX":I
    .end local v18    # "currX":I
    :cond_11
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->endFling()V

    goto/16 :goto_0

    .line 3794
    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method start(I)V
    .locals 9
    .param p1, "initialVelocity"    # I

    .prologue
    const v6, 0x7fffffff

    const/4 v2, 0x0

    .line 3717
    if-gez p1, :cond_0

    move v1, v6

    .line 3718
    .local v1, "initialX":I
    :goto_0
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mLastFlingX:I

    .line 3719
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lit/sephiroth/android/library/widget/OverScroller;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 3720
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    move v3, p1

    move v4, v2

    move v5, v2

    move v7, v2

    move v8, v6

    invoke-virtual/range {v0 .. v8}, Lit/sephiroth/android/library/widget/OverScroller;->fling(IIIIIIII)V

    .line 3721
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v2, 0x4

    iput v2, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3722
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v0, p0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 3723
    return-void

    .end local v1    # "initialX":I
    :cond_0
    move v1, v2

    .line 3717
    goto :goto_0
.end method

.method startOverfling(I)V
    .locals 11
    .param p1, "initialVelocity"    # I

    .prologue
    const/4 v2, 0x0

    .line 3737
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/widget/OverScroller;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 3738
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v1

    const/high16 v5, -0x80000000

    const v6, 0x7fffffff

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v9

    move v3, p1

    move v4, v2

    move v7, v2

    move v8, v2

    move v10, v2

    invoke-virtual/range {v0 .. v10}, Lit/sephiroth/android/library/widget/OverScroller;->fling(IIIIIIIIII)V

    .line 3739
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v1, 0x6

    iput v1, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3740
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 3741
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v0, p0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 3742
    return-void
.end method

.method startScroll(IIZ)V
    .locals 6
    .param p1, "distance"    # I
    .param p2, "duration"    # I
    .param p3, "linear"    # Z

    .prologue
    const/4 v2, 0x0

    .line 3766
    if-gez p1, :cond_0

    const v1, 0x7fffffff

    .line 3767
    .local v1, "initialX":I
    :goto_0
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mLastFlingX:I

    .line 3768
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    if-eqz p3, :cond_1

    sget-object v0, Lit/sephiroth/android/library/widget/AbsHListView;->sLinearInterpolator:Landroid/view/animation/Interpolator;

    :goto_1
    invoke-virtual {v3, v0}, Lit/sephiroth/android/library/widget/OverScroller;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 3769
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    move v3, p1

    move v4, v2

    move v5, p2

    invoke-virtual/range {v0 .. v5}, Lit/sephiroth/android/library/widget/OverScroller;->startScroll(IIIII)V

    .line 3770
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v2, 0x4

    iput v2, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3771
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v0, p0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 3772
    return-void

    .end local v1    # "initialX":I
    :cond_0
    move v1, v2

    .line 3766
    goto :goto_0

    .line 3768
    .restart local v1    # "initialX":I
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method startSpringback()V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 3726
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->mScroller:Lit/sephiroth/android/library/widget/OverScroller;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getScrollX()I

    move-result v1

    move v3, v2

    move v4, v2

    move v5, v2

    move v6, v2

    invoke-virtual/range {v0 .. v6}, Lit/sephiroth/android/library/widget/OverScroller;->springBack(IIIIII)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3727
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v1, 0x6

    iput v1, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3728
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/AbsHListView;->invalidate()V

    .line 3729
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v0, p0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 3734
    :goto_0
    return-void

    .line 3731
    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v1, -0x1

    iput v1, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 3732
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$FlingRunnable;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->reportScrollStateChange(I)V

    goto :goto_0
.end method
