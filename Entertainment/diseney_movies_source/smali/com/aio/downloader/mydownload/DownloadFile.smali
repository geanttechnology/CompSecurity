.class public Lcom/aio/downloader/mydownload/DownloadFile;
.super Ljava/lang/Object;
.source "DownloadFile.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private isStop:Z

.field private mHttpHandler:Lnet/tsz/afinal/http/HttpHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lnet/tsz/afinal/http/HttpHandler",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getmHttpHandler()Lnet/tsz/afinal/http/HttpHandler;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lnet/tsz/afinal/http/HttpHandler",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .prologue
    .line 94
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadFile;->mHttpHandler:Lnet/tsz/afinal/http/HttpHandler;

    return-object v0
.end method

.method public isStop()Z
    .locals 1

    .prologue
    .line 85
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/DownloadFile;->getmHttpHandler()Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v0

    invoke-virtual {v0}, Lnet/tsz/afinal/http/HttpHandler;->isStop()Z

    move-result v0

    iput-boolean v0, p0, Lcom/aio/downloader/mydownload/DownloadFile;->isStop:Z

    .line 86
    iget-boolean v0, p0, Lcom/aio/downloader/mydownload/DownloadFile;->isStop:Z

    return v0
.end method

.method public setStop(Z)V
    .locals 0
    .param p1, "isStop"    # Z

    .prologue
    .line 90
    iput-boolean p1, p0, Lcom/aio/downloader/mydownload/DownloadFile;->isStop:Z

    .line 91
    return-void
.end method

.method public setmHttpHandler(Lnet/tsz/afinal/http/HttpHandler;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lnet/tsz/afinal/http/HttpHandler",
            "<",
            "Ljava/io/File;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 98
    .local p1, "mHttpHandler":Lnet/tsz/afinal/http/HttpHandler;, "Lnet/tsz/afinal/http/HttpHandler<Ljava/io/File;>;"
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadFile;->mHttpHandler:Lnet/tsz/afinal/http/HttpHandler;

    .line 99
    return-void
.end method

.method public startDownloadFileByUrl(Ljava/lang/String;Ljava/lang/String;Lnet/tsz/afinal/http/AjaxCallBack;)Lcom/aio/downloader/mydownload/DownloadFile;
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "toPath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lnet/tsz/afinal/http/AjaxCallBack",
            "<",
            "Ljava/io/File;",
            ">;)",
            "Lcom/aio/downloader/mydownload/DownloadFile;"
        }
    .end annotation

    .prologue
    .line 48
    .local p3, "downCallBack":Lnet/tsz/afinal/http/AjaxCallBack;, "Lnet/tsz/afinal/http/AjaxCallBack<Ljava/io/File;>;"
    if-nez p3, :cond_0

    .line 49
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "AjaxCallBack\u5bf9\u8c61\u4e0d\u80fd\u4e3anull"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 51
    :cond_0
    new-instance v0, Lnet/tsz/afinal/FinalHttp;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalHttp;-><init>()V

    .line 53
    .local v0, "down":Lnet/tsz/afinal/FinalHttp;
    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, v1, p3}, Lnet/tsz/afinal/FinalHttp;->download(Ljava/lang/String;Ljava/lang/String;ZLnet/tsz/afinal/http/AjaxCallBack;)Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/mydownload/DownloadFile;->setmHttpHandler(Lnet/tsz/afinal/http/HttpHandler;)V

    .line 56
    return-object p0
.end method

.method public startDownloadFileByUrlNoCatch(Ljava/lang/String;Ljava/lang/String;Lnet/tsz/afinal/http/AjaxCallBack;)Lcom/aio/downloader/mydownload/DownloadFile;
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "toPath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lnet/tsz/afinal/http/AjaxCallBack",
            "<",
            "Ljava/io/File;",
            ">;)",
            "Lcom/aio/downloader/mydownload/DownloadFile;"
        }
    .end annotation

    .prologue
    .line 61
    .local p3, "downCallBack":Lnet/tsz/afinal/http/AjaxCallBack;, "Lnet/tsz/afinal/http/AjaxCallBack<Ljava/io/File;>;"
    if-nez p3, :cond_0

    .line 63
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "AjaxCallBack\u5bf9\u8c61\u4e0d\u80fd\u4e3anull"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 66
    :cond_0
    new-instance v0, Lnet/tsz/afinal/FinalHttp;

    invoke-direct {v0}, Lnet/tsz/afinal/FinalHttp;-><init>()V

    .line 68
    .local v0, "down":Lnet/tsz/afinal/FinalHttp;
    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, v1, p3}, Lnet/tsz/afinal/FinalHttp;->download(Ljava/lang/String;Ljava/lang/String;ZLnet/tsz/afinal/http/AjaxCallBack;)Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/mydownload/DownloadFile;->setmHttpHandler(Lnet/tsz/afinal/http/HttpHandler;)V

    .line 71
    return-object p0
.end method

.method public stopDownload()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 74
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/DownloadFile;->getmHttpHandler()Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 75
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/DownloadFile;->getmHttpHandler()Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v0

    invoke-virtual {v0}, Lnet/tsz/afinal/http/HttpHandler;->stop()V

    .line 76
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/DownloadFile;->getmHttpHandler()Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/http/HttpHandler;->cancel(Z)Z

    .line 77
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/DownloadFile;->getmHttpHandler()Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v0

    invoke-virtual {v0}, Lnet/tsz/afinal/http/HttpHandler;->isStop()Z

    move-result v0

    if-nez v0, :cond_0

    .line 78
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/DownloadFile;->getmHttpHandler()Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v0

    invoke-virtual {v0}, Lnet/tsz/afinal/http/HttpHandler;->stop()V

    .line 79
    invoke-virtual {p0}, Lcom/aio/downloader/mydownload/DownloadFile;->getmHttpHandler()Lnet/tsz/afinal/http/HttpHandler;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnet/tsz/afinal/http/HttpHandler;->cancel(Z)Z

    .line 82
    :cond_0
    return-void
.end method
