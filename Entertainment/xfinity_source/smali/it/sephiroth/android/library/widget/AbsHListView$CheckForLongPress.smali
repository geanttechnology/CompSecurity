.class Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;
.super Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;
.source "AbsHListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AbsHListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CheckForLongPress"
.end annotation


# instance fields
.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method private constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 1

    .prologue
    .line 2517
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V
    .locals 0
    .param p1, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "x1"    # Lit/sephiroth/android/library/widget/AbsHListView$1;

    .prologue
    .line 2517
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2521
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v5, v6, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 2522
    .local v5, "motionPosition":I
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v7, v7, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int v7, v5, v7

    invoke-virtual {v6, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 2523
    .local v0, "child":Landroid/view/View;
    if-eqz v0, :cond_1

    .line 2524
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v4, v6, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    .line 2525
    .local v4, "longPressPosition":I
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v6, v6, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v7, v7, Lit/sephiroth/android/library/widget/AbsHListView;->mMotionPosition:I

    invoke-interface {v6, v7}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    .line 2527
    .local v2, "longPressId":J
    const/4 v1, 0x0

    .line 2528
    .local v1, "handled":Z
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->sameWindow()Z

    move-result v6

    if-eqz v6, :cond_0

    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-boolean v6, v6, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    if-nez v6, :cond_0

    .line 2529
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6, v0, v4, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->performLongPress(Landroid/view/View;IJ)Z

    move-result v1

    .line 2531
    :cond_0
    if-eqz v1, :cond_2

    .line 2532
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v7, -0x1

    iput v7, v6, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    .line 2533
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6, v8}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 2534
    invoke-virtual {v0, v8}, Landroid/view/View;->setPressed(Z)V

    .line 2539
    .end local v1    # "handled":Z
    .end local v2    # "longPressId":J
    .end local v4    # "longPressPosition":I
    :cond_1
    :goto_0
    return-void

    .line 2536
    .restart local v1    # "handled":Z
    .restart local v2    # "longPressId":J
    .restart local v4    # "longPressPosition":I
    :cond_2
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v7, 0x2

    iput v7, v6, Lit/sephiroth/android/library/widget/AbsHListView;->mTouchMode:I

    goto :goto_0
.end method
