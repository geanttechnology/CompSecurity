.class Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;
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
    name = "PerformClick"
.end annotation


# instance fields
.field mClickMotionPosition:I

.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method private constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 1

    .prologue
    .line 2492
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V
    .locals 0
    .param p1, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "x1"    # Lit/sephiroth/android/library/widget/AbsHListView$1;

    .prologue
    .line 2492
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 2500
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-boolean v3, v3, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    if-eqz v3, :cond_1

    .line 2514
    :cond_0
    :goto_0
    return-void

    .line 2502
    :cond_1
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v0, v3, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    .line 2503
    .local v0, "adapter":Landroid/widget/ListAdapter;
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->mClickMotionPosition:I

    .line 2504
    .local v1, "motionPosition":I
    if-eqz v0, :cond_0

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v3, v3, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    if-lez v3, :cond_0

    const/4 v3, -0x1

    if-eq v1, v3, :cond_0

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v3

    if-ge v1, v3, :cond_0

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->sameWindow()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2507
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v4, v4, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int v4, v1, v4

    invoke-virtual {v3, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 2510
    .local v2, "view":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 2511
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$PerformClick;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    invoke-virtual {v3, v2, v1, v4, v5}, Lit/sephiroth/android/library/widget/AbsHListView;->performItemClick(Landroid/view/View;IJ)Z

    goto :goto_0
.end method
