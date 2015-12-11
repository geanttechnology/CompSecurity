.class Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;
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
    name = "CheckForKeyLongPress"
.end annotation


# instance fields
.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method private constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 1

    .prologue
    .line 2542
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lit/sephiroth/android/library/widget/AbsHListView$WindowRunnnable;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V

    return-void
.end method

.method synthetic constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;Lit/sephiroth/android/library/widget/AbsHListView$1;)V
    .locals 0
    .param p1, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "x1"    # Lit/sephiroth/android/library/widget/AbsHListView$1;

    .prologue
    .line 2542
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;-><init>(Lit/sephiroth/android/library/widget/AbsHListView;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 2546
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/AbsHListView;->isPressed()Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v3, v3, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    if-ltz v3, :cond_1

    .line 2547
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v3, v3, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v4, v4, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    sub-int v1, v3, v4

    .line 2548
    .local v1, "index":I
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v3, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 2550
    .local v2, "v":Landroid/view/View;
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-boolean v3, v3, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    if-nez v3, :cond_2

    .line 2551
    const/4 v0, 0x0

    .line 2552
    .local v0, "handled":Z
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->sameWindow()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2553
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v4, v4, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedPosition:I

    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-wide v6, v5, Lit/sephiroth/android/library/widget/AbsHListView;->mSelectedColId:J

    invoke-virtual {v3, v2, v4, v6, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->performLongPress(Landroid/view/View;IJ)Z

    move-result v0

    .line 2555
    :cond_0
    if-eqz v0, :cond_1

    .line 2556
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v3, v8}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 2557
    invoke-virtual {v2, v8}, Landroid/view/View;->setPressed(Z)V

    .line 2564
    .end local v0    # "handled":Z
    .end local v1    # "index":I
    .end local v2    # "v":Landroid/view/View;
    :cond_1
    :goto_0
    return-void

    .line 2560
    .restart local v1    # "index":I
    .restart local v2    # "v":Landroid/view/View;
    :cond_2
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$CheckForKeyLongPress;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v3, v8}, Lit/sephiroth/android/library/widget/AbsHListView;->setPressed(Z)V

    .line 2561
    if-eqz v2, :cond_1

    invoke-virtual {v2, v8}, Landroid/view/View;->setPressed(Z)V

    goto :goto_0
.end method
