.class Lcom/aio/downloader/service/ServiceUpdate$6;
.super Ljava/util/TimerTask;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceUpdate;->onCreate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/ServiceUpdate;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$6;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 490
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 495
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 496
    .local v0, "msg":Landroid/os/Message;
    const/16 v1, 0x64

    iput v1, v0, Landroid/os/Message;->what:I

    .line 497
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$6;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate;->access$54(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 499
    return-void
.end method
