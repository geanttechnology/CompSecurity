.class Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$2;
.super Ljava/lang/Object;
.source "FloatWindowService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;


# direct methods
.method constructor <init>(Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$2;->this$1:Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$2;->this$1:Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;

    # getter for: Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->access$0(Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;)Lcom/aio/downloader/floatwindow/FloatWindowService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->removeSmallWindow(Landroid/content/Context;)V

    .line 85
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask$2;->this$1:Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;

    # getter for: Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/FloatWindowService;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;->access$0(Lcom/aio/downloader/floatwindow/FloatWindowService$RefreshTask;)Lcom/aio/downloader/floatwindow/FloatWindowService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/floatwindow/FloatWindowService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->removeBigWindow(Landroid/content/Context;)V

    .line 86
    return-void
.end method
