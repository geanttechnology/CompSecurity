.class Lcom/aio/downloader/service/ServiceUpdate$7;
.super Ljava/lang/Thread;
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
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 504
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 509
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 510
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    const-string v3, "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=1"

    invoke-static {v2, v3}, Lcom/aio/downloader/service/ServiceUpdate;->access$55(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 512
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->url1:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$56(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 513
    .local v0, "jsonData":Ljava/lang/String;
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 514
    .local v1, "messagemeiri":Landroid/os/Message;
    const/16 v2, 0xa

    iput v2, v1, Landroid/os/Message;->what:I

    .line 515
    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 516
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate$7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceUpdate;->access$54(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 517
    return-void
.end method
