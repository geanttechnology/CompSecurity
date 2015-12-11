.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;
.super Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;
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
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    .line 129
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public collectionsComplete([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 0
    .param p1, "aCompletedCollections"    # [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 243
    return-void
.end method

.method public collectionsProgressUpdated([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 0
    .param p1, "aUpdatedCollections"    # [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 236
    return-void
.end method

.method public downloadEngineDidFinishDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 227
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$1(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 229
    return-void

    .line 227
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IQueueObserver;

    .line 228
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IQueueObserver;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/client/IQueueObserver;->downloadEngineDidFinishDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public downloadEngineDidFinishDownloadingFileMin(Ljava/lang/String;IDDI)V
    .locals 9
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 156
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    move-wide v6, p5

    move/from16 v8, p7

    # invokes: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFileWithMinData(Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-static/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$0(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    .line 157
    .local v0, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-nez v0, :cond_0

    .line 159
    :goto_0
    return-void

    .line 158
    :cond_0
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->downloadEngineDidFinishDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public downloadEngineDidStartDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 217
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$1(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 220
    return-void

    .line 217
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IQueueObserver;

    .line 218
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IQueueObserver;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/client/IQueueObserver;->downloadEngineDidStartDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public downloadEngineDidStartDownloadingFileMin(Ljava/lang/String;IDDI)V
    .locals 9
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 136
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    move-wide v6, p5

    move/from16 v8, p7

    # invokes: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFileWithMinData(Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-static/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$0(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    .line 137
    .local v0, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-nez v0, :cond_0

    .line 139
    :goto_0
    return-void

    .line 138
    :cond_0
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->downloadEngineDidStartDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public downloadEngineFileWithError(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 209
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$1(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 212
    return-void

    .line 209
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IQueueObserver;

    .line 210
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IQueueObserver;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/client/IQueueObserver;->downloadEngineFileWithError(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public downloadEngineFileWithErrorMin(Ljava/lang/String;IDDI)V
    .locals 9
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 166
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    move-wide v6, p5

    move/from16 v8, p7

    # invokes: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFileWithMinData(Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-static/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$0(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    .line 167
    .local v0, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-nez v0, :cond_0

    .line 169
    :goto_0
    return-void

    .line 168
    :cond_0
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->downloadEngineFileWithError(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 201
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$1(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 203
    return-void

    .line 201
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IQueueObserver;

    .line 202
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IQueueObserver;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/client/IQueueObserver;->downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public downloadEngineProgressUpdatedForFileMin(Ljava/lang/String;IDDI)V
    .locals 9
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 146
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    move-wide v6, p5

    move/from16 v8, p7

    # invokes: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFileWithMinData(Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-static/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$0(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    .line 147
    .local v0, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-nez v0, :cond_0

    .line 149
    :goto_0
    return-void

    .line 148
    :cond_0
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public engineContentInQueuedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
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
    .line 250
    return-void
.end method

.method public engineDownloadQueueChanged()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 192
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$1(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 195
    return-void

    .line 192
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IQueueObserver;

    .line 193
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IQueueObserver;
    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IQueueObserver;->engineDownloadQueueChanged()V

    goto :goto_0
.end method

.method public fragmentComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 184
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$1(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 187
    return-void

    .line 184
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/client/IQueueObserver;

    .line 185
    .local v0, "observer":Lcom/penthera/virtuososdk/client/IQueueObserver;
    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/client/IQueueObserver;->fragmentComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method

.method public fragmentCompleteMin(Ljava/lang/String;IDDI)V
    .locals 9
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 175
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    move-wide v6, p5

    move/from16 v8, p7

    # invokes: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFileWithMinData(Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-static/range {v1 .. v8}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$0(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    .line 176
    .local v0, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-nez v0, :cond_0

    .line 178
    :goto_0
    return-void

    .line 177
    :cond_0
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;->fragmentComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto :goto_0
.end method
