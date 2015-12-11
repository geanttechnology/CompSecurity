.class Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$3;
.super Ljava/lang/Object;
.source "MyFloatService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;


# direct methods
.method constructor <init>(Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$3;->this$1:Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;

    .line 127
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask$3;->this$1:Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;

    # getter for: Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;
    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;->access$0(Lcom/aio/downloader/floatwindow/MyFloatService$RefreshTask;)Lcom/aio/downloader/floatwindow/MyFloatService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/floatwindow/MyWindowManager;->updateUsedPercent(Landroid/content/Context;)V

    .line 134
    return-void
.end method
