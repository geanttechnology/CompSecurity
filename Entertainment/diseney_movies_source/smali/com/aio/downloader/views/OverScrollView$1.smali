.class Lcom/aio/downloader/views/OverScrollView$1;
.super Landroid/os/Handler;
.source "OverScrollView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/OverScrollView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/OverScrollView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/OverScrollView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    .line 53
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 10
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v9, 0x0

    .line 58
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    const-wide/high16 v1, 0x4014000000000000L    # 5.0

    const-wide/high16 v3, 0x402e000000000000L    # 15.0

    const-wide v5, 0x3ff921fb54442d18L    # 1.5707963267948966

    .line 59
    iget-object v7, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    invoke-virtual {v7}, Lcom/aio/downloader/views/OverScrollView;->getMeasuredHeight()I

    move-result v7

    int-to-double v7, v7

    div-double/2addr v5, v7

    iget-object v7, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    iget v7, v7, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    iget-object v8, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    # getter for: Lcom/aio/downloader/views/OverScrollView;->pullUpY:F
    invoke-static {v8}, Lcom/aio/downloader/views/OverScrollView;->access$0(Lcom/aio/downloader/views/OverScrollView;)F

    move-result v8

    invoke-static {v8}, Ljava/lang/Math;->abs(F)F

    move-result v8

    add-float/2addr v7, v8

    float-to-double v7, v7

    mul-double/2addr v5, v7

    .line 58
    invoke-static {v5, v6}, Ljava/lang/Math;->tan(D)D

    move-result-wide v5

    mul-double/2addr v3, v5

    add-double/2addr v1, v3

    double-to-float v1, v1

    iput v1, v0, Lcom/aio/downloader/views/OverScrollView;->MOVE_SPEED:F

    .line 60
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    iget v0, v0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    cmpl-float v0, v0, v9

    if-lez v0, :cond_3

    .line 61
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    iget v1, v0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    iget v2, v2, Lcom/aio/downloader/views/OverScrollView;->MOVE_SPEED:F

    sub-float/2addr v1, v2

    iput v1, v0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 64
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    iget v0, v0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    cmpg-float v0, v0, v9

    if-gez v0, :cond_1

    .line 66
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    iput v9, v0, Lcom/aio/downloader/views/OverScrollView;->pullDownY:F

    .line 67
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    # getter for: Lcom/aio/downloader/views/OverScrollView;->timer:Lcom/aio/downloader/views/OverScrollView$MyTimer;
    invoke-static {v0}, Lcom/aio/downloader/views/OverScrollView;->access$2(Lcom/aio/downloader/views/OverScrollView;)Lcom/aio/downloader/views/OverScrollView$MyTimer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/views/OverScrollView$MyTimer;->cancel()V

    .line 69
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    # getter for: Lcom/aio/downloader/views/OverScrollView;->pullUpY:F
    invoke-static {v0}, Lcom/aio/downloader/views/OverScrollView;->access$0(Lcom/aio/downloader/views/OverScrollView;)F

    move-result v0

    cmpl-float v0, v0, v9

    if-lez v0, :cond_2

    .line 71
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    invoke-static {v0, v9}, Lcom/aio/downloader/views/OverScrollView;->access$1(Lcom/aio/downloader/views/OverScrollView;F)V

    .line 72
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    # getter for: Lcom/aio/downloader/views/OverScrollView;->timer:Lcom/aio/downloader/views/OverScrollView$MyTimer;
    invoke-static {v0}, Lcom/aio/downloader/views/OverScrollView;->access$2(Lcom/aio/downloader/views/OverScrollView;)Lcom/aio/downloader/views/OverScrollView$MyTimer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/views/OverScrollView$MyTimer;->cancel()V

    .line 75
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/OverScrollView;->requestLayout()V

    .line 76
    return-void

    .line 62
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    # getter for: Lcom/aio/downloader/views/OverScrollView;->pullUpY:F
    invoke-static {v0}, Lcom/aio/downloader/views/OverScrollView;->access$0(Lcom/aio/downloader/views/OverScrollView;)F

    move-result v0

    cmpg-float v0, v0, v9

    if-gez v0, :cond_0

    .line 63
    iget-object v0, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    # getter for: Lcom/aio/downloader/views/OverScrollView;->pullUpY:F
    invoke-static {v0}, Lcom/aio/downloader/views/OverScrollView;->access$0(Lcom/aio/downloader/views/OverScrollView;)F

    move-result v1

    iget-object v2, p0, Lcom/aio/downloader/views/OverScrollView$1;->this$0:Lcom/aio/downloader/views/OverScrollView;

    iget v2, v2, Lcom/aio/downloader/views/OverScrollView;->MOVE_SPEED:F

    add-float/2addr v1, v2

    invoke-static {v0, v1}, Lcom/aio/downloader/views/OverScrollView;->access$1(Lcom/aio/downloader/views/OverScrollView;F)V

    goto :goto_0
.end method
