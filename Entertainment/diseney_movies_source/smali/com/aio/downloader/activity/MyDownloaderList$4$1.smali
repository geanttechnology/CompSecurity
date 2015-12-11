.class Lcom/aio/downloader/activity/MyDownloaderList$4$1;
.super Ljava/lang/Object;
.source "MyDownloaderList.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyDownloaderList$4;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList$4;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    .line 258
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 262
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 265
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$16(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v2

    .line 266
    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v4

    .line 267
    iget-object v5, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v6}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v6

    invoke-virtual {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v6

    .line 268
    iget-object v7, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v7}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v7

    invoke-virtual {v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v7

    iget-object v8, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getCreate_time()Ljava/lang/Long;

    move-result-object v8

    .line 269
    iget-object v9, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v9}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v9

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getVersion()Ljava/lang/String;

    move-result-object v9

    .line 265
    invoke-virtual/range {v0 .. v9}, Lcom/aio/downloader/db/TypeDbUtils;->insertApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;)V

    .line 271
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 272
    const-string v1, "downloadtask2"

    const-string v2, "file_id=?"

    .line 273
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/aio/downloader/activity/MyDownloaderList$4$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$4;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyDownloaderList$4;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 271
    invoke-virtual {v0, v1, v2, v3}, Lnet/tsz/afinal/FinalDBChen;->deleteItem(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 275
    return-void
.end method
