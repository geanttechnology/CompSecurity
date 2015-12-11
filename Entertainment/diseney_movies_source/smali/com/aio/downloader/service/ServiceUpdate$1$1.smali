.class Lcom/aio/downloader/service/ServiceUpdate$1$1;
.super Ljava/util/TimerTask;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceUpdate$1;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/ServiceUpdate$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$1$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$1;

    .line 199
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 204
    new-instance v0, Landroid/content/Intent;

    const-string v1, "\u53d1\u9001\u5347\u7ea7\u5e7f\u64ad"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 205
    .local v0, "mIntent":Landroid/content/Intent;
    const-string v2, "appid"

    .line 206
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$1$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$1;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$1;->access$1(Lcom/aio/downloader/service/ServiceUpdate$1;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$1$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$1;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$1;->showup:I
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$1;->access$0(Lcom/aio/downloader/service/ServiceUpdate$1;)I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    .line 205
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 207
    const-string v2, "appvirsion"

    .line 208
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$1$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$1;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$1;->access$1(Lcom/aio/downloader/service/ServiceUpdate$1;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$1$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$1;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$1;->showup:I
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$1;->access$0(Lcom/aio/downloader/service/ServiceUpdate$1;)I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getVersion()Ljava/lang/String;

    move-result-object v1

    .line 207
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 209
    const-string v2, "appurl"

    .line 210
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$1$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$1;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$1;->access$1(Lcom/aio/downloader/service/ServiceUpdate$1;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$1$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$1;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$1;->showup:I
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$1;->access$0(Lcom/aio/downloader/service/ServiceUpdate$1;)I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getLink_url()Ljava/lang/String;

    move-result-object v1

    .line 209
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 211
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$1$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$1;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$1;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$1;->access$1(Lcom/aio/downloader/service/ServiceUpdate$1;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/aio/downloader/service/ServiceUpdate;->sendBroadcast(Landroid/content/Intent;)V

    .line 212
    return-void
.end method
