.class public Lcom/penthera/virtuososdk/client/Virtuoso;
.super Ljava/lang/Object;
.source "Virtuoso.java"


# instance fields
.field private iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "iscc"    # Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;

    .prologue
    .line 39
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/penthera/virtuososdk/client/Virtuoso;-><init>(Landroid/content/Context;Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;Landroid/content/ComponentName;)V

    .line 40
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "iscc"    # Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;
    .param p3, "service"    # Landroid/content/ComponentName;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    .line 24
    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Context is invalid"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 25
    :cond_0
    if-nez p3, :cond_1

    .line 26
    new-instance p3, Landroid/content/ComponentName;

    .end local p3    # "service":Landroid/content/ComponentName;
    const-class v0, Lcom/penthera/virtuososdk/service/VirtuosoService;

    invoke-direct {p3, p1, v0}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 28
    .restart local p3    # "service":Landroid/content/ComponentName;
    :cond_1
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-direct {v0, p1, p2, p3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;-><init>(Landroid/content/Context;Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;Landroid/content/ComponentName;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    .line 29
    return-void
.end method


# virtual methods
.method public addDownloadedObserver(Lcom/penthera/virtuososdk/client/IDownloadedObserver;)V
    .locals 1
    .param p1, "obs"    # Lcom/penthera/virtuososdk/client/IDownloadedObserver;

    .prologue
    .line 159
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->addDownloadedObserver(Lcom/penthera/virtuososdk/client/IDownloadedObserver;)V

    .line 160
    return-void
.end method

.method public addEngineObserver(Lcom/penthera/virtuososdk/client/IEngineObserver;)V
    .locals 1
    .param p1, "obs"    # Lcom/penthera/virtuososdk/client/IEngineObserver;

    .prologue
    .line 149
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->addEngineObserver(Lcom/penthera/virtuososdk/client/IEngineObserver;)V

    .line 150
    return-void
.end method

.method public addQueueObserver(Lcom/penthera/virtuososdk/client/IQueueObserver;)V
    .locals 1
    .param p1, "obs"    # Lcom/penthera/virtuososdk/client/IQueueObserver;

    .prologue
    .line 141
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->addQueueObserver(Lcom/penthera/virtuososdk/client/IQueueObserver;)V

    .line 142
    return-void
.end method

.method public addToQueue(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 1
    .param p1, "item"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 69
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->addToQueue(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 70
    return-void
.end method

.method public configure(Landroid/os/Bundle;II)V
    .locals 1
    .param p1, "headers"    # Landroid/os/Bundle;
    .param p2, "connectionTimeout"    # I
    .param p3, "socketTimeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 519
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1, p2, p3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->configure(Landroid/os/Bundle;II)V

    .line 520
    return-void
.end method

.method public delete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 1
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 206
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->delete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    return-void
.end method

.method public deleteAllFiles()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 260
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->deleteAllFiles()V

    return-void
.end method

.method public downloadedRootList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation

    .prologue
    .line 115
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->downloadedRootList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public expire(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 1
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 199
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->expire(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    return-void
.end method

.method public move(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;I)V
    .locals 1
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "aNewPosition"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 191
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->move(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;I)V

    .line 192
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->onResume()V

    .line 61
    return-void
.end method

.method public overrideBatteryThreshold(D)V
    .locals 1
    .param p1, "aNewThreshold"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 382
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideBatteryThreshold(D)V

    return-void
.end method

.method public overrideCellularDataQuota(D)V
    .locals 1
    .param p1, "aNewQuota"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 360
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideCellularDataQuota(D)V

    return-void
.end method

.method public overrideHeadroom(D)V
    .locals 1
    .param p1, "aNewHeadroom"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 316
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideHeadroom(D)V

    return-void
.end method

.method public overrideMaxStorageAllowed(D)V
    .locals 1
    .param p1, "aMaxStorageAllowed"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 338
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideMaxStorageAllowed(D)V

    return-void
.end method

.method public pauseDownloads()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 230
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->pauseDownloads()V

    return-void
.end method

.method public queuedRootList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation

    .prologue
    .line 121
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->queuedRootList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public resumeDownloads()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 238
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->resumeDownloads()V

    return-void
.end method

.method public status()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 435
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->status()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v0

    return-object v0
.end method

.method public update(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)Z
    .locals 1
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 221
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->update(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)Z

    move-result v0

    return v0
.end method

.method public virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
    .locals 1
    .param p1, "aAssetId"    # Ljava/lang/String;
    .param p2, "aMetadata"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/penthera/virtuososdk/client/Virtuoso;->iContentBox:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    move-result-object v0

    return-object v0
.end method
