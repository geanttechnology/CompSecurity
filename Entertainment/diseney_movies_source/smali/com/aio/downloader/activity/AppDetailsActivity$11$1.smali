.class Lcom/aio/downloader/activity/AppDetailsActivity$11$1;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity$11;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/AppDetailsActivity$11;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity$11;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$11$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$11;

    .line 337
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 347
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=action=download_invalid&type=app&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 349
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$11$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$11;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$11;->id:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$11;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$11;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&size="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$11$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$11;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$11;->size:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$11;->access$1(Lcom/aio/downloader/activity/AppDetailsActivity$11;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&content="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 350
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$11$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$11;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$11;->content:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$11;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$11;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 347
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 352
    return-void
.end method
