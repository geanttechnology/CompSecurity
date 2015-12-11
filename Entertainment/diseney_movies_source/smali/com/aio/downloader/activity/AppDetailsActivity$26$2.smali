.class Lcom/aio/downloader/activity/AppDetailsActivity$26$2;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity$26;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/AppDetailsActivity$26;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity$26;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$26$2;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$26;

    .line 1338
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1343
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=app&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1344
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$26$2;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$26;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$26;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$26;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$26;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1345
    const-string v1, "&from=google"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 1343
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1351
    :goto_0
    return-void

    .line 1347
    :catch_0
    move-exception v0

    goto :goto_0
.end method
