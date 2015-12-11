.class public Lcom/comcast/cim/downloads/MaxDownloadsReachedException;
.super Lcom/comcast/cim/downloads/DownloadServiceException;
.source "MaxDownloadsReachedException.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>()V

    .line 7
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 10
    invoke-direct {p0, p1}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/String;)V

    .line 11
    return-void
.end method
