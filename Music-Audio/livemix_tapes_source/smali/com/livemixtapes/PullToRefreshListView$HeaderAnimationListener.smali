.class Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;
.super Ljava/lang/Object;
.source "PullToRefreshListView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/PullToRefreshListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HeaderAnimationListener"
.end annotation


# instance fields
.field private height:I

.field private stateAtAnimationStart:Lcom/livemixtapes/PullToRefreshListView$State;

.field final synthetic this$0:Lcom/livemixtapes/PullToRefreshListView;

.field private translation:I


# direct methods
.method public constructor <init>(Lcom/livemixtapes/PullToRefreshListView;I)V
    .locals 0
    .param p2, "translation"    # I

    .prologue
    .line 490
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 491
    iput p2, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->translation:I

    .line 492
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;)Lcom/livemixtapes/PullToRefreshListView;
    .locals 1

    .prologue
    .line 485
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    return-object v0
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 5
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    const/4 v2, 0x0

    .line 510
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->stateAtAnimationStart:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v4, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v1, v4, :cond_2

    move v1, v2

    :goto_0
    # invokes: Lcom/livemixtapes/PullToRefreshListView;->setHeaderPadding(I)V
    invoke-static {v3, v1}, Lcom/livemixtapes/PullToRefreshListView;->access$4(Lcom/livemixtapes/PullToRefreshListView;I)V

    .line 512
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->setSelection(I)V

    .line 514
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 515
    .local v0, "lp":Landroid/view/ViewGroup$LayoutParams;
    iget v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->height:I

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 516
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/livemixtapes/PullToRefreshListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 518
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->scrollbarEnabled:Z
    invoke-static {v1}, Lcom/livemixtapes/PullToRefreshListView;->access$1(Lcom/livemixtapes/PullToRefreshListView;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 519
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/livemixtapes/PullToRefreshListView;->setVerticalScrollBarEnabled(Z)V

    .line 522
    :cond_0
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->bounceBackHeader:Z
    invoke-static {v1}, Lcom/livemixtapes/PullToRefreshListView;->access$5(Lcom/livemixtapes/PullToRefreshListView;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 523
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-static {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->access$6(Lcom/livemixtapes/PullToRefreshListView;Z)V

    .line 525
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    new-instance v2, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener$1;

    invoke-direct {v2, p0}, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener$1;-><init>(Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;)V

    .line 531
    const-wide/16 v3, 0x64

    .line 525
    invoke-virtual {v1, v2, v3, v4}, Lcom/livemixtapes/PullToRefreshListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 536
    :cond_1
    :goto_1
    return-void

    .line 510
    .end local v0    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_2
    # getter for: Lcom/livemixtapes/PullToRefreshListView;->measuredHeaderHeight:I
    invoke-static {}, Lcom/livemixtapes/PullToRefreshListView;->access$2()I

    move-result v1

    neg-int v1, v1

    .line 511
    iget-object v4, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->headerContainer:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/livemixtapes/PullToRefreshListView;->access$3(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/LinearLayout;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getTop()I

    move-result v4

    sub-int/2addr v1, v4

    goto :goto_0

    .line 533
    .restart local v0    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_3
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->stateAtAnimationStart:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v2, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-eq v1, v2, :cond_1

    .line 534
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    sget-object v2, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    # invokes: Lcom/livemixtapes/PullToRefreshListView;->setState(Lcom/livemixtapes/PullToRefreshListView$State;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->access$8(Lcom/livemixtapes/PullToRefreshListView;Lcom/livemixtapes/PullToRefreshListView$State;)V

    goto :goto_1
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 540
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 3
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 496
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;
    invoke-static {v1}, Lcom/livemixtapes/PullToRefreshListView;->access$0(Lcom/livemixtapes/PullToRefreshListView;)Lcom/livemixtapes/PullToRefreshListView$State;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->stateAtAnimationStart:Lcom/livemixtapes/PullToRefreshListView$State;

    .line 498
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 499
    .local v0, "lp":Landroid/view/ViewGroup$LayoutParams;
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    iput v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->height:I

    .line 500
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView;->getHeight()I

    move-result v1

    iget v2, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->translation:I

    sub-int/2addr v1, v2

    iput v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 501
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v1, v0}, Lcom/livemixtapes/PullToRefreshListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 503
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    # getter for: Lcom/livemixtapes/PullToRefreshListView;->scrollbarEnabled:Z
    invoke-static {v1}, Lcom/livemixtapes/PullToRefreshListView;->access$1(Lcom/livemixtapes/PullToRefreshListView;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 504
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/livemixtapes/PullToRefreshListView;->setVerticalScrollBarEnabled(Z)V

    .line 506
    :cond_0
    return-void
.end method
