.class Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$4;
.super Ljava/lang/Object;
.source "DownloadTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
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
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$4;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    .line 800
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 803
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://android.downloadatoz.com/_201409/market/hits.php?type=app&action=retry_fail&id="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 804
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$4;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$1(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 805
    const-string v2, "&size="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$4;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$1(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getCurrentProgress()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 803
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 806
    .local v0, "retry_hint_url":Ljava/lang/String;
    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 807
    return-void
.end method
