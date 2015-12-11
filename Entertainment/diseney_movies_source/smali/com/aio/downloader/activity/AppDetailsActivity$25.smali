.class Lcom/aio/downloader/activity/AppDetailsActivity$25;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1254
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 1259
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 1260
    const-class v2, Lcom/aio/downloader/activity/AppDetatils_moreActivity;

    .line 1259
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1261
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "dea_title"

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1262
    const-string v1, "dea_sheart"

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPpshort_desc()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1263
    const-string v1, "dea_dea"

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDetail()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1264
    const-string v1, "dea_up"

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getRelease_date()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1265
    const-string v1, "dea_ver"

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1266
    const-string v1, "dea_down"

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloads()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1267
    const-string v1, "dea_size"

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSize()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1268
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$25;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 1269
    return-void
.end method
