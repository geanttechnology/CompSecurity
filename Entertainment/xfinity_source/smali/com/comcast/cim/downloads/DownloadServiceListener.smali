.class public interface abstract Lcom/comcast/cim/downloads/DownloadServiceListener;
.super Ljava/lang/Object;
.source "DownloadServiceListener.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Lcom/comcast/cim/downloads/DownloadFile;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
.end method

.method public abstract onDownloadServiceConnected()V
.end method

.method public abstract onFileDownloadError(Lcom/comcast/cim/downloads/DownloadFile;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation
.end method

.method public abstract onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation
.end method

.method public abstract onFileDownloadStarted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation
.end method

.method public abstract onFileListUpdated()V
.end method

.method public abstract onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation
.end method
