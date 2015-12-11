.class Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$1;
.super Ljava/lang/Object;
.source "DownloadTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->onSuccess(Ljava/io/File;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;


# direct methods
.method constructor <init>(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$1;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    .line 543
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 546
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 547
    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$1;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$1(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&status=success&size="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 548
    iget-object v1, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$1;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$1(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 546
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 550
    return-void
.end method
