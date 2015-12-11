.class interface abstract Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
.super Ljava/lang/Object;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x608
    name = "DownloaderObserver"
.end annotation


# virtual methods
.method public abstract downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
.end method

.method public abstract fragmentsComplete(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
.end method

.method public abstract hdsProgressUpdate(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
.end method

.method public abstract quotaUpdate(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
.end method

.method public abstract saveFileState(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
.end method
