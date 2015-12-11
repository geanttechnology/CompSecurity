.class public abstract Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;
.super Ljava/lang/Object;
.source "SimpleDownloadServiceListener.java"

# interfaces
.implements Lcom/comcast/cim/downloads/DownloadServiceListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Lcom/comcast/cim/downloads/DownloadFile;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/downloads/DownloadServiceListener",
        "<TD;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<TD;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 0
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 36
    .local p0, "this":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<TD;>;"
    return-void
.end method

.method public onDownloadServiceConnected()V
    .locals 0

    .prologue
    .line 12
    .local p0, "this":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<TD;>;"
    return-void
.end method

.method public onFileDownloadError(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p0, "this":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<TD;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    return-void
.end method

.method public onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 20
    .local p0, "this":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<TD;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    return-void
.end method

.method public onFileDownloadStarted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<TD;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    return-void
.end method

.method public onFileListUpdated()V
    .locals 0

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<TD;>;"
    return-void
.end method

.method public onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p0, "this":Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;, "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener<TD;>;"
    .local p1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    return-void
.end method
