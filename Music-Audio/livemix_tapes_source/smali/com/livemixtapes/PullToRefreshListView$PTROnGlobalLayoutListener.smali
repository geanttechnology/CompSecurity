.class Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;
.super Ljava/lang/Object;
.source "PullToRefreshListView.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/PullToRefreshListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PTROnGlobalLayoutListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/PullToRefreshListView;


# direct methods
.method private constructor <init>(Lcom/livemixtapes/PullToRefreshListView;)V
    .locals 0

    .prologue
    .line 543
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/PullToRefreshListView;Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;)V
    .locals 0

    .prologue
    .line 543
    invoke-direct {p0, p1}, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;-><init>(Lcom/livemixtapes/PullToRefreshListView;)V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 3

    .prologue
    .line 547
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;
    invoke-static {v1}, Lcom/livemixtapes/PullToRefreshListView;->access$9(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v0

    .line 549
    .local v0, "initialHeaderHeight":I
    if-lez v0, :cond_0

    .line 550
    invoke-static {v0}, Lcom/livemixtapes/PullToRefreshListView;->access$10(I)V

    .line 552
    # getter for: Lcom/livemixtapes/PullToRefreshListView;->measuredHeaderHeight:I
    invoke-static {}, Lcom/livemixtapes/PullToRefreshListView;->access$2()I

    move-result v1

    if-lez v1, :cond_0

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;
    invoke-static {v1}, Lcom/livemixtapes/PullToRefreshListView;->access$0(Lcom/livemixtapes/PullToRefreshListView;)Lcom/livemixtapes/PullToRefreshListView$State;

    move-result-object v1

    sget-object v2, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-eq v1, v2, :cond_0

    .line 553
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->measuredHeaderHeight:I
    invoke-static {}, Lcom/livemixtapes/PullToRefreshListView;->access$2()I

    move-result v2

    neg-int v2, v2

    # invokes: Lcom/livemixtapes/PullToRefreshListView;->setHeaderPadding(I)V
    invoke-static {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->access$4(Lcom/livemixtapes/PullToRefreshListView;I)V

    .line 554
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView;->requestLayout()V

    .line 558
    :cond_0
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 559
    return-void
.end method
