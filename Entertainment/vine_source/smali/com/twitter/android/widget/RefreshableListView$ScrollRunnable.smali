.class Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;
.super Ljava/lang/Object;
.source "RefreshableListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/twitter/android/widget/RefreshableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ScrollRunnable"
.end annotation


# static fields
.field private static final AUTO_SCROLL_DURATION:I = 0x1c2


# instance fields
.field private mLastY:I

.field final synthetic this$0:Lcom/twitter/android/widget/RefreshableListView;


# direct methods
.method constructor <init>(Lcom/twitter/android/widget/RefreshableListView;)V
    .locals 0

    .prologue
    .line 944
    iput-object p1, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 945
    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v4, 0x0

    .line 956
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v6, 0xa

    invoke-virtual {v5, v6}, Lcom/twitter/android/widget/RefreshableListView;->isMode(I)Z

    move-result v5

    if-nez v5, :cond_0

    .line 988
    :goto_0
    return-void

    .line 960
    :cond_0
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    iget-object v2, v5, Lcom/twitter/android/widget/RefreshableListView;->mScroller:Landroid/widget/Scroller;

    .line 961
    .local v2, "scroller":Landroid/widget/Scroller;
    invoke-virtual {v2}, Landroid/widget/Scroller;->timePassed()I

    move-result v5

    const/16 v6, 0x1c2

    if-ge v5, v6, :cond_1

    invoke-virtual {v2}, Landroid/widget/Scroller;->computeScrollOffset()Z

    move-result v5

    if-eqz v5, :cond_1

    const/4 v1, 0x1

    .line 963
    .local v1, "more":Z
    :goto_1
    if-eqz v1, :cond_2

    invoke-virtual {v2}, Landroid/widget/Scroller;->getCurrY()I

    move-result v3

    .line 968
    .local v3, "y":I
    :goto_2
    iget v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->mLastY:I

    sub-int v0, v5, v3

    .line 969
    .local v0, "delta":I
    iput v3, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->mLastY:I

    .line 972
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v5, v0}, Lcom/twitter/android/widget/RefreshableListView;->offsetChildrenTopAndBottom(I)V

    .line 973
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v5}, Lcom/twitter/android/widget/RefreshableListView;->invalidate()V

    .line 974
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v5}, Lcom/twitter/android/widget/RefreshableListView;->requestLastChildLayout()V

    .line 977
    if-eqz v1, :cond_3

    .line 978
    iget-object v4, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v4, p0}, Lcom/twitter/android/widget/RefreshableListView;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .end local v0    # "delta":I
    .end local v1    # "more":Z
    .end local v3    # "y":I
    :cond_1
    move v1, v4

    .line 961
    goto :goto_1

    .line 963
    .restart local v1    # "more":Z
    :cond_2
    invoke-virtual {v2}, Landroid/widget/Scroller;->getFinalY()I

    move-result v3

    goto :goto_2

    .line 980
    .restart local v0    # "delta":I
    .restart local v3    # "y":I
    :cond_3
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/twitter/android/widget/RefreshableListView;->unsetMode(I)V

    .line 982
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v6, 0x20

    invoke-virtual {v5, v6}, Lcom/twitter/android/widget/RefreshableListView;->isMode(I)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 983
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v5, v4, v3}, Lcom/twitter/android/widget/RefreshableListView;->setSelectionFromTop(II)V

    goto :goto_0

    .line 985
    :cond_4
    iget-object v4, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v4}, Lcom/twitter/android/widget/RefreshableListView;->detach()V

    goto :goto_0
.end method

.method scroll(I)V
    .locals 6
    .param p1, "distance"    # I

    .prologue
    const/4 v1, 0x0

    .line 948
    iput v1, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->mLastY:I

    .line 949
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Lcom/twitter/android/widget/RefreshableListView;->setMode(I)V

    .line 950
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    iget-object v0, v0, Lcom/twitter/android/widget/RefreshableListView;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0}, Landroid/widget/Scroller;->abortAnimation()V

    .line 951
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    iget-object v0, v0, Lcom/twitter/android/widget/RefreshableListView;->mScroller:Landroid/widget/Scroller;

    const/16 v5, 0x1c2

    move v2, v1

    move v3, v1

    move v4, p1

    invoke-virtual/range {v0 .. v5}, Landroid/widget/Scroller;->startScroll(IIIII)V

    .line 952
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$ScrollRunnable;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0, p0}, Lcom/twitter/android/widget/RefreshableListView;->post(Ljava/lang/Runnable;)Z

    .line 953
    return-void
.end method
