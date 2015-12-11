.class Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;
.super Ljava/util/TimerTask;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceUpdate$Mya7;->ShowResult7(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    .line 2107
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 2111
    const-string v2, "qaz"

    .line 2112
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v1, "updateservise"

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2113
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$3(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$2(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)I

    move-result v4

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 2112
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 2111
    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2114
    new-instance v0, Landroid/content/Intent;

    const-string v1, "\u53d1\u9001\u5347\u7ea7\u5e7f\u64ad"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2115
    .local v0, "mIntent":Landroid/content/Intent;
    const-string v2, "appid"

    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$3(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$2(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 2116
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    .line 2115
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2117
    const-string v2, "appvirsion"

    .line 2118
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$3(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$2(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getVersion()Ljava/lang/String;

    move-result-object v1

    .line 2117
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2119
    const-string v2, "appurl"

    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$3(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    iget-object v1, v1, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->showup:I
    invoke-static {v3}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$2(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 2120
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getLink_url()Ljava/lang/String;

    move-result-object v1

    .line 2119
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2121
    iget-object v1, p0, Lcom/aio/downloader/service/ServiceUpdate$Mya7$1;->this$1:Lcom/aio/downloader/service/ServiceUpdate$Mya7;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate$Mya7;->this$0:Lcom/aio/downloader/service/ServiceUpdate;
    invoke-static {v1}, Lcom/aio/downloader/service/ServiceUpdate$Mya7;->access$3(Lcom/aio/downloader/service/ServiceUpdate$Mya7;)Lcom/aio/downloader/service/ServiceUpdate;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/aio/downloader/service/ServiceUpdate;->sendBroadcast(Landroid/content/Intent;)V

    .line 2122
    return-void
.end method
