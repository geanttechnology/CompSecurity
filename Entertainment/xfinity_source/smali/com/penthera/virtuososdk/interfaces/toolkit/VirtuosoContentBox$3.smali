.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$3;
.super Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub;
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
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$3;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    .line 304
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public engineContentInDownloadedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
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
    .line 316
    return-void
.end method

.method public engineDownloadedListChanged()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 308
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$3;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$3(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 310
    return-void

    .line 308
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IDownloadedObserver;

    .line 309
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IDownloadedObserver;
    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IDownloadedObserver;->engineDownloadedListChanged()V

    goto :goto_0
.end method
