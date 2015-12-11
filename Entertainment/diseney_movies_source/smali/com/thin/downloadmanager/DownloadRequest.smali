.class public Lcom/thin/downloadmanager/DownloadRequest;
.super Ljava/lang/Object;
.source "DownloadRequest.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/thin/downloadmanager/DownloadRequest$Priority;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/thin/downloadmanager/DownloadRequest;",
        ">;"
    }
.end annotation


# instance fields
.field private mCanceled:Z

.field private mDestinationURI:Landroid/net/Uri;

.field private mDownloadId:I

.field private mDownloadListener:Lcom/thin/downloadmanager/DownloadStatusListener;

.field private mDownloadState:I

.field private mPriority:Lcom/thin/downloadmanager/DownloadRequest$Priority;

.field private mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

.field private mUri:Landroid/net/Uri;


# direct methods
.method public constructor <init>(Landroid/net/Uri;)V
    .locals 4
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mCanceled:Z

    .line 42
    sget-object v1, Lcom/thin/downloadmanager/DownloadRequest$Priority;->NORMAL:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    iput-object v1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mPriority:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    .line 45
    if-nez p1, :cond_0

    .line 46
    new-instance v1, Ljava/lang/NullPointerException;

    invoke-direct {v1}, Ljava/lang/NullPointerException;-><init>()V

    throw v1

    .line 49
    :cond_0
    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "scheme":Ljava/lang/String;
    if-eqz v0, :cond_1

    const-string v1, "http"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "https"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 51
    :cond_1
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Can only download HTTP/HTTPS URIs: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 53
    :cond_2
    const/4 v1, 0x1

    iput v1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadState:I

    .line 54
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mUri:Landroid/net/Uri;

    .line 55
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 134
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mCanceled:Z

    .line 135
    return-void
.end method

.method public compareTo(Lcom/thin/downloadmanager/DownloadRequest;)I
    .locals 4
    .param p1, "other"    # Lcom/thin/downloadmanager/DownloadRequest;

    .prologue
    .line 150
    invoke-virtual {p0}, Lcom/thin/downloadmanager/DownloadRequest;->getPriority()Lcom/thin/downloadmanager/DownloadRequest$Priority;

    move-result-object v0

    .line 151
    .local v0, "left":Lcom/thin/downloadmanager/DownloadRequest$Priority;
    invoke-virtual {p1}, Lcom/thin/downloadmanager/DownloadRequest;->getPriority()Lcom/thin/downloadmanager/DownloadRequest$Priority;

    move-result-object v1

    .line 155
    .local v1, "right":Lcom/thin/downloadmanager/DownloadRequest$Priority;
    if-ne v0, v1, :cond_0

    iget v2, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadId:I

    iget v3, p1, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadId:I

    sub-int/2addr v2, v3

    :goto_0
    return v2

    :cond_0
    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest$Priority;->ordinal()I

    move-result v2

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequest$Priority;->ordinal()I

    move-result v3

    sub-int/2addr v2, v3

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 5
    check-cast p1, Lcom/thin/downloadmanager/DownloadRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/thin/downloadmanager/DownloadRequest;->compareTo(Lcom/thin/downloadmanager/DownloadRequest;)I

    move-result v0

    return v0
.end method

.method finish()V
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-virtual {v0, p0}, Lcom/thin/downloadmanager/DownloadRequestQueue;->finish(Lcom/thin/downloadmanager/DownloadRequest;)V

    .line 146
    return-void
.end method

.method public getDestinationURI()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDestinationURI:Landroid/net/Uri;

    return-object v0
.end method

.method final getDownloadId()I
    .locals 1

    .prologue
    .line 90
    iget v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadId:I

    return v0
.end method

.method getDownloadListener()Lcom/thin/downloadmanager/DownloadStatusListener;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadListener:Lcom/thin/downloadmanager/DownloadStatusListener;

    return-object v0
.end method

.method getDownloadState()I
    .locals 1

    .prologue
    .line 94
    iget v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadState:I

    return v0
.end method

.method public getPriority()Lcom/thin/downloadmanager/DownloadRequest$Priority;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mPriority:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    return-object v0
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mUri:Landroid/net/Uri;

    return-object v0
.end method

.method public isCanceled()Z
    .locals 1

    .prologue
    .line 141
    iget-boolean v0, p0, Lcom/thin/downloadmanager/DownloadRequest;->mCanceled:Z

    return v0
.end method

.method public setDestinationURI(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;
    .locals 0
    .param p1, "destinationURI"    # Landroid/net/Uri;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDestinationURI:Landroid/net/Uri;

    .line 125
    return-object p0
.end method

.method final setDownloadId(I)V
    .locals 0
    .param p1, "downloadId"    # I

    .prologue
    .line 86
    iput p1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadId:I

    .line 87
    return-void
.end method

.method public setDownloadListener(Lcom/thin/downloadmanager/DownloadStatusListener;)Lcom/thin/downloadmanager/DownloadRequest;
    .locals 0
    .param p1, "downloadListener"    # Lcom/thin/downloadmanager/DownloadStatusListener;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadListener:Lcom/thin/downloadmanager/DownloadStatusListener;

    .line 107
    return-object p0
.end method

.method setDownloadRequestQueue(Lcom/thin/downloadmanager/DownloadRequestQueue;)V
    .locals 0
    .param p1, "downloadQueue"    # Lcom/thin/downloadmanager/DownloadRequestQueue;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mRequestQueue:Lcom/thin/downloadmanager/DownloadRequestQueue;

    .line 80
    return-void
.end method

.method setDownloadState(I)V
    .locals 0
    .param p1, "mDownloadState"    # I

    .prologue
    .line 98
    iput p1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mDownloadState:I

    .line 99
    return-void
.end method

.method public setPriority(Lcom/thin/downloadmanager/DownloadRequest$Priority;)Lcom/thin/downloadmanager/DownloadRequest;
    .locals 0
    .param p1, "priority"    # Lcom/thin/downloadmanager/DownloadRequest$Priority;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mPriority:Lcom/thin/downloadmanager/DownloadRequest$Priority;

    .line 71
    return-object p0
.end method

.method public setUri(Landroid/net/Uri;)Lcom/thin/downloadmanager/DownloadRequest;
    .locals 0
    .param p1, "mUri"    # Landroid/net/Uri;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequest;->mUri:Landroid/net/Uri;

    .line 116
    return-object p0
.end method
