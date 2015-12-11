.class Lcom/comcast/cim/downloads/DownloadServiceManager$4;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IQueueObserver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 187
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public downloadEngineDidFinishDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "iVirtuosoIdentifier"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 221
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4;"
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Callback downloadEngineDidFinishDownloadingFile"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 222
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    move-object v0, p1

    .line 223
    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 224
    .local v0, "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v1, v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v2, Lcom/comcast/cim/downloads/DownloadServiceManager$4$3;

    invoke-direct {v2, p0, v0}, Lcom/comcast/cim/downloads/DownloadServiceManager$4$3;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$4;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 233
    .end local v0    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_0
    return-void
.end method

.method public downloadEngineDidStartDownloadingFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "iVirtuosoIdentifier"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 191
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4;"
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Callback downloadEngineDidStartDownloadingFile"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 192
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    move-object v0, p1

    .line 193
    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 194
    .local v0, "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v1, v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v2, Lcom/comcast/cim/downloads/DownloadServiceManager$4$1;

    invoke-direct {v2, p0, v0}, Lcom/comcast/cim/downloads/DownloadServiceManager$4$1;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$4;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 202
    .end local v0    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_0
    return-void
.end method

.method public downloadEngineFileWithError(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "iVirtuosoIdentifier"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 237
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4;"
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Callback downloadEngineFileWithError"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 238
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    move-object v0, p1

    .line 239
    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 240
    .local v0, "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v1, v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v2, Lcom/comcast/cim/downloads/DownloadServiceManager$4$4;

    invoke-direct {v2, p0, v0}, Lcom/comcast/cim/downloads/DownloadServiceManager$4$4;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$4;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 248
    .end local v0    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_0
    return-void
.end method

.method public downloadEngineProgressUpdatedForFile(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "iVirtuosoIdentifier"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 206
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4;"
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Callback downloadEngineProgressUpdatedForFile"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 207
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    move-object v0, p1

    .line 208
    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 209
    .local v0, "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v1, v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v2, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;

    invoke-direct {v2, p0, v0}, Lcom/comcast/cim/downloads/DownloadServiceManager$4$2;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$4;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 217
    .end local v0    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_0
    return-void
.end method

.method public engineDownloadQueueChanged()V
    .locals 4

    .prologue
    .line 267
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$4$6;

    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;
    invoke-static {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$500(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/penthera/virtuososdk/client/Virtuoso;

    move-result-object v2

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/client/Virtuoso;->queuedRootList()Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->queuedFilesMap:Ljava/util/Map;
    invoke-static {v3}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$900(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;

    move-result-object v3

    invoke-direct {v1, p0, v2, v3}, Lcom/comcast/cim/downloads/DownloadServiceManager$4$6;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$4;Ljava/util/List;Ljava/util/Map;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 273
    return-void
.end method

.method public fragmentComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 3
    .param p1, "iVirtuosoIdentifier"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 252
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$4;, "Lcom/comcast/cim/downloads/DownloadServiceManager$4;"
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Callback downloadEngineProgressUpdatedForFile"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 253
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    move-object v0, p1

    .line 254
    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 255
    .local v0, "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$4;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v1, v1, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v2, Lcom/comcast/cim/downloads/DownloadServiceManager$4$5;

    invoke-direct {v2, p0, v0}, Lcom/comcast/cim/downloads/DownloadServiceManager$4$5;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$4;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 263
    .end local v0    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_0
    return-void
.end method
