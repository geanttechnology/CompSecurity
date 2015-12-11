.class Lcom/aio/downloader/refresh/PullToRefreshLayout$1;
.super Landroid/os/Handler;
.source "PullToRefreshLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/refresh/PullToRefreshLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;


# direct methods
.method constructor <init>(Lcom/aio/downloader/refresh/PullToRefreshLayout;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    .line 87
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 11
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x0

    .line 92
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    const-wide/high16 v1, 0x4020000000000000L    # 8.0

    const-wide/high16 v3, 0x4034000000000000L    # 20.0

    const-wide v5, 0x3ff921fb54442d18L    # 1.5707963267948966

    .line 93
    iget-object v7, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    invoke-virtual {v7}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getMeasuredHeight()I

    move-result v7

    int-to-double v7, v7

    div-double/2addr v5, v7

    iget-object v7, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iget v7, v7, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    float-to-double v7, v7

    mul-double/2addr v5, v7

    .line 92
    invoke-static {v5, v6}, Ljava/lang/Math;->tan(D)D

    move-result-wide v5

    mul-double/2addr v3, v5

    add-double/2addr v1, v3

    double-to-float v1, v1

    iput v1, v0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->MOVE_SPEED:F

    .line 94
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->isTouch:Z
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$0(Lcom/aio/downloader/refresh/PullToRefreshLayout;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$1(Lcom/aio/downloader/refresh/PullToRefreshLayout;)I

    move-result v0

    if-ne v0, v10, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iget v0, v0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F
    invoke-static {v1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$2(Lcom/aio/downloader/refresh/PullToRefreshLayout;)F

    move-result v1

    cmpg-float v0, v0, v1

    if-gtz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iget-object v1, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->refreshDist:F
    invoke-static {v1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$2(Lcom/aio/downloader/refresh/PullToRefreshLayout;)F

    move-result v1

    iput v1, v0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 98
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->timer:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$3(Lcom/aio/downloader/refresh/PullToRefreshLayout;)Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->cancel()V

    .line 102
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iget v0, v0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    cmpl-float v0, v0, v9

    if-lez v0, :cond_1

    .line 103
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iget v1, v0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    iget-object v2, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iget v2, v2, Lcom/aio/downloader/refresh/PullToRefreshLayout;->MOVE_SPEED:F

    sub-float/2addr v1, v2

    iput v1, v0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 104
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iget v0, v0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    cmpg-float v0, v0, v9

    if-gtz v0, :cond_3

    .line 106
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iput v9, v0, Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullDownY:F

    .line 107
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->pullView:Landroid/view/View;
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$4(Lcom/aio/downloader/refresh/PullToRefreshLayout;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->clearAnimation()V

    .line 109
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->state:I
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$1(Lcom/aio/downloader/refresh/PullToRefreshLayout;)I

    move-result v0

    if-eq v0, v10, :cond_2

    .line 110
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    const/4 v1, 0x0

    # invokes: Lcom/aio/downloader/refresh/PullToRefreshLayout;->changeState(I)V
    invoke-static {v0, v1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$5(Lcom/aio/downloader/refresh/PullToRefreshLayout;I)V

    .line 111
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    # getter for: Lcom/aio/downloader/refresh/PullToRefreshLayout;->timer:Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;
    invoke-static {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->access$3(Lcom/aio/downloader/refresh/PullToRefreshLayout;)Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout$MyTimer;->cancel()V

    .line 114
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullToRefreshLayout$1;->this$0:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    invoke-virtual {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->requestLayout()V

    .line 115
    return-void
.end method
