.class public Lcom/thin/downloadmanager/ThinDownloadManager;
.super Ljava/lang/Object;
.source "ThinDownloadManager.java"

# interfaces
.implements Lcom/thin/downloadmanager/DownloadManager;


# instance fields
.field private mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-direct {v0}, Lcom/thin/downloadmanager/DownloadRequestQueue;-><init>()V

    iput-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    .line 13
    iget-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequestQueue;->start()V

    .line 14
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "threadPoolSize"    # I

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-direct {v0, p1}, Lcom/thin/downloadmanager/DownloadRequestQueue;-><init>(I)V

    iput-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    .line 21
    iget-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequestQueue;->start()V

    .line 22
    return-void
.end method


# virtual methods
.method public add(Lcom/thin/downloadmanager/DownloadRequest;)I
    .locals 2
    .param p1, "request"    # Lcom/thin/downloadmanager/DownloadRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 35
    if-nez p1, :cond_0

    .line 36
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "DownloadRequest cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 39
    :cond_0
    iget-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-virtual {v0, p1}, Lcom/thin/downloadmanager/DownloadRequestQueue;->add(Lcom/thin/downloadmanager/DownloadRequest;)I

    move-result v0

    return v0
.end method

.method public cancel(I)I
    .locals 1
    .param p1, "downloadId"    # I

    .prologue
    .line 45
    iget-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-virtual {v0, p1}, Lcom/thin/downloadmanager/DownloadRequestQueue;->cancel(I)I

    move-result v0

    return v0
.end method

.method public cancelAll()V
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequestQueue;->cancelAll()V

    .line 52
    return-void
.end method

.method public query(I)I
    .locals 1
    .param p1, "downloadId"    # I

    .prologue
    .line 57
    iget-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-virtual {v0, p1}, Lcom/thin/downloadmanager/DownloadRequestQueue;->query(I)I

    move-result v0

    return v0
.end method

.method public release()V
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequestQueue;->release()V

    .line 64
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/thin/downloadmanager/ThinDownloadManager;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    .line 66
    :cond_0
    return-void
.end method
