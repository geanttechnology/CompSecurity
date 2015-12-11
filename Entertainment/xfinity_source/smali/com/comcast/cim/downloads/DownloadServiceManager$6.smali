.class Lcom/comcast/cim/downloads/DownloadServiceManager$6;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;->deleteFiles(Ljava/util/List;)Ljava/util/Map;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

.field final synthetic val$files:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/util/List;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 406
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$6;, "Lcom/comcast/cim/downloads/DownloadServiceManager$6;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$6;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$6;->val$files:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 409
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$6;, "Lcom/comcast/cim/downloads/DownloadServiceManager$6;"
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$6;->val$files:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/downloads/DownloadFile;

    .line 414
    .local v1, "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$6;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;
    invoke-static {v4}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$500(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/penthera/virtuososdk/client/Virtuoso;

    move-result-object v4

    invoke-virtual {v1}, Lcom/comcast/cim/downloads/DownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/penthera/virtuososdk/client/Virtuoso;->delete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 415
    :catch_0
    move-exception v0

    .line 417
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    iget-object v4, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$6;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;
    invoke-static {v4}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1100(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;

    move-result-object v4

    monitor-enter v4

    .line 418
    :try_start_1
    iget-object v5, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$6;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;
    invoke-static {v5}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1100(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/CountDownLatch;

    .line 419
    .local v2, "latch":Ljava/util/concurrent/CountDownLatch;
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 420
    if-eqz v2, :cond_0

    .line 421
    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    .line 419
    .end local v2    # "latch":Ljava/util/concurrent/CountDownLatch;
    :catchall_0
    move-exception v3

    :try_start_2
    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3

    .line 425
    .end local v0    # "e":Lcom/penthera/virtuososdk/client/ServiceException;
    .end local v1    # "file":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :cond_1
    return-void
.end method
