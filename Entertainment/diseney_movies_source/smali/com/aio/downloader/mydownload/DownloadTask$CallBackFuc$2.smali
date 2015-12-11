.class Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$2;
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
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$2;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    .line 619
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 622
    const-string v1, "pm install -r "

    .line 623
    .local v1, "cmd_install":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$2;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v3}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$1(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 624
    .local v0, "cmd":Ljava/lang/String;
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$2;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/aio/downloader/mydownload/DownloadTask;->excuteSuCMD(Ljava/lang/String;)I

    .line 625
    return-void
.end method
