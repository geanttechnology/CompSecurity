.class Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;
.super Ljava/util/TimerTask;
.source "FloatWindowService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/floatwindow/FloatWindowService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "RefreshTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;


# direct methods
.method constructor <init>(Lcom/aio/downloader/floatwindow/FloatWindowService;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;)Lcom/aio/downloader/floatwindow/FloatWindowService;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;

    # invokes: Lcom/aio/downloader/floatwindow/FloatWindowService;->isHome()Z
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->access$0(Lcom/aio/downloader/floatwindow/FloatWindowService;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Lcom/aio/downloader/floatwindow/MyWindowManager;->isWindowShowing()Z

    move-result v0

    if-nez v0, :cond_1

    .line 67
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;

    # getter for: Lcom/aio/downloader/floatwindow/FloatWindowService;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->access$1(Lcom/aio/downloader/floatwindow/FloatWindowService;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$1;-><init>(Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 100
    :cond_0
    :goto_0
    return-void

    .line 78
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;

    # invokes: Lcom/aio/downloader/floatwindow/FloatWindowService;->isHome()Z
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->access$0(Lcom/aio/downloader/floatwindow/FloatWindowService;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-static {}, Lcom/aio/downloader/floatwindow/MyWindowManager;->isWindowShowing()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 79
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;

    # getter for: Lcom/aio/downloader/floatwindow/FloatWindowService;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->access$1(Lcom/aio/downloader/floatwindow/FloatWindowService;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$2;-><init>(Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 90
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;

    # invokes: Lcom/aio/downloader/floatwindow/FloatWindowService;->isHome()Z
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->access$0(Lcom/aio/downloader/floatwindow/FloatWindowService;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/aio/downloader/floatwindow/MyWindowManager;->isWindowShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;

    # getter for: Lcom/aio/downloader/floatwindow/FloatWindowService;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->access$1(Lcom/aio/downloader/floatwindow/FloatWindowService;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$3;-><init>(Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method
