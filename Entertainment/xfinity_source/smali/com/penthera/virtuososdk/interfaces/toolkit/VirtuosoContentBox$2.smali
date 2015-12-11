.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$2;
.super Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;
.source "VirtuosoContentBox.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$2;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    .line 254
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public collectionsChanged([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 0
    .param p1, "aChangedCollections"    # [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 301
    return-void
.end method

.method public collectionsDeleted([Ljava/lang/String;)V
    .locals 0
    .param p1, "aDeletedCollections"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 294
    return-void
.end method

.method public downloadEngineStatusDidChange(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 3
    .param p1, "aStatus"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 272
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$2;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$2(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 274
    return-void

    .line 272
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IEngineObserver;

    .line 273
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IEngineObserver;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/client/IEngineObserver;->downloadEngineStatusDidChange(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V

    goto :goto_0
.end method

.method public engineContentInList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
    .locals 0
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "aOffset"    # I
    .param p3, "aListSize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 287
    return-void
.end method

.method public engineListChanged()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 280
    return-void
.end method

.method public itemUpdated(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 0
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 266
    return-void
.end method

.method public settingChanged(I)V
    .locals 3
    .param p1, "aFlags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 260
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$2;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$2(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 262
    return-void

    .line 260
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IEngineObserver;

    .line 261
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IEngineObserver;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/client/IEngineObserver;->settingChanged(I)V

    goto :goto_0
.end method
