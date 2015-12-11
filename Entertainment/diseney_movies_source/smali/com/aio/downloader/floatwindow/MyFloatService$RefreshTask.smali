.class Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;
.super Ljava/util/TimerTask;
.source "MyFloatService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/floatwindow/MyFloatService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "RefreshTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/floatwindow/MyFloatService;


# direct methods
.method constructor <init>(Lcom/aio/downloader/floatwindow/MyFloatService;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;)Lcom/aio/downloader/floatwindow/MyFloatService;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 101
    invoke-static {}, Lcom/aio/downloader/floatwindow/MyWindowManager;->isWindowShowing()Z

    move-result v0

    if-nez v0, :cond_1

    .line 102
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    # getter for: Lcom/aio/downloader/floatwindow/MyFloatService;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyFloatService;->access$0(Lcom/aio/downloader/floatwindow/MyFloatService;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$1;-><init>(Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 137
    :cond_0
    :goto_0
    return-void

    .line 114
    :cond_1
    invoke-static {}, Lcom/aio/downloader/floatwindow/MyWindowManager;->isWindowShowing()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 115
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    # getter for: Lcom/aio/downloader/floatwindow/MyFloatService;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyFloatService;->access$0(Lcom/aio/downloader/floatwindow/MyFloatService;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$2;-><init>(Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 126
    :cond_2
    invoke-static {}, Lcom/aio/downloader/floatwindow/MyWindowManager;->isWindowShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    # getter for: Lcom/aio/downloader/floatwindow/MyFloatService;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyFloatService;->access$0(Lcom/aio/downloader/floatwindow/MyFloatService;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$3;-><init>(Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method
