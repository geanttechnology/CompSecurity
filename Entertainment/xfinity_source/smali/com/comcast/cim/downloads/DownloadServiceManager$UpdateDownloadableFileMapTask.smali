.class abstract Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "UpdateDownloadableFileMapTask"
.end annotation


# instance fields
.field private final identifiers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

.field private final uuidToFileMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "TD;>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/util/List;Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "TD;>;)V"
        }
    .end annotation

    .prologue
    .line 971
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>.UpdateDownloadableFileMapTask;"
    .local p2, "identifiers":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;>;"
    .local p3, "uuidToFileMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;TD;>;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 972
    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->identifiers:Ljava/util/List;

    .line 973
    iput-object p3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->uuidToFileMap:Ljava/util/Map;

    .line 974
    return-void
.end method


# virtual methods
.method protected abstract onFileMapRetrieved()V
.end method

.method public run()V
    .locals 17

    .prologue
    .line 978
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;, "Lcom/comcast/cim/downloads/DownloadServiceManager<TD;TT;TS;>.UpdateDownloadableFileMapTask;"
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v8

    .line 979
    .local v8, "newFileSet":Ljava/util/Set;, "Ljava/util/Set<TD;>;"
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->identifiers:Ljava/util/List;

    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_0
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_1

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 981
    .local v2, "bufferedId":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v14

    const/4 v15, 0x4

    if-ne v14, v15, :cond_0

    move-object v1, v2

    .line 982
    check-cast v1, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 983
    .local v1, "bufferedAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # invokes: Lcom/comcast/cim/downloads/DownloadServiceManager;->getDownloadFile(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;
    invoke-static {v14, v1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$800(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;

    move-result-object v14

    invoke-interface {v8, v14}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 985
    .end local v1    # "bufferedAsset":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_0
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    const/4 v15, 0x1

    # setter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->hasOldFiles:Z
    invoke-static {v14, v15}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1602(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z

    goto :goto_0

    .line 990
    .end local v2    # "bufferedId":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_1
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v4

    .line 991
    .local v4, "deletedFiles":Ljava/util/Set;, "Ljava/util/Set<TD;>;"
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->uuidToFileMap:Ljava/util/Map;

    monitor-enter v14

    .line 992
    :try_start_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->uuidToFileMap:Ljava/util/Map;

    invoke-interface {v13}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v13

    invoke-static {v13}, Lcom/google/common/collect/Sets;->newHashSet(Ljava/lang/Iterable;)Ljava/util/HashSet;

    move-result-object v9

    .line 993
    .local v9, "oldFileSet":Ljava/util/Set;, "Ljava/util/Set<TD;>;"
    invoke-static {v9, v8}, Lcom/google/common/collect/Sets;->difference(Ljava/util/Set;Ljava/util/Set;)Lcom/google/common/collect/Sets$SetView;

    move-result-object v13

    invoke-static {v13}, Lcom/google/common/collect/ImmutableSet;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v12

    .line 994
    .local v12, "removedFromNewFileSet":Ljava/util/Set;, "Ljava/util/Set<TD;>;"
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;
    invoke-static {v13}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1100(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;

    move-result-object v15

    monitor-enter v15
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 998
    :try_start_1
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->pendingDeletes:Ljava/util/Map;
    invoke-static {v13}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1100(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Map;

    move-result-object v13

    invoke-interface {v13}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v13

    invoke-interface {v13}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .line 999
    .local v11, "pendingDeletesIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<TD;Ljava/util/concurrent/CountDownLatch;>;>;"
    :cond_2
    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_3

    .line 1000
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 1001
    .local v5, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TD;Ljava/util/concurrent/CountDownLatch;>;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/comcast/cim/downloads/DownloadFile;

    .line 1002
    .local v10, "pendingDelete":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/concurrent/CountDownLatch;

    .line 1003
    .local v6, "latch":Ljava/util/concurrent/CountDownLatch;
    invoke-interface {v12, v10}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 1004
    invoke-interface {v4, v10}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1005
    invoke-interface {v11}, Ljava/util/Iterator;->remove()V

    .line 1006
    invoke-virtual {v6}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_1

    .line 1009
    .end local v5    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TD;Ljava/util/concurrent/CountDownLatch;>;"
    .end local v6    # "latch":Ljava/util/concurrent/CountDownLatch;
    .end local v10    # "pendingDelete":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    .end local v11    # "pendingDeletesIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<TD;Ljava/util/concurrent/CountDownLatch;>;>;"
    :catchall_0
    move-exception v13

    monitor-exit v15
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v13

    .line 1014
    .end local v9    # "oldFileSet":Ljava/util/Set;, "Ljava/util/Set<TD;>;"
    .end local v12    # "removedFromNewFileSet":Ljava/util/Set;, "Ljava/util/Set<TD;>;"
    :catchall_1
    move-exception v13

    monitor-exit v14
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v13

    .line 1009
    .restart local v9    # "oldFileSet":Ljava/util/Set;, "Ljava/util/Set<TD;>;"
    .restart local v11    # "pendingDeletesIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<TD;Ljava/util/concurrent/CountDownLatch;>;>;"
    .restart local v12    # "removedFromNewFileSet":Ljava/util/Set;, "Ljava/util/Set<TD;>;"
    :cond_3
    :try_start_3
    monitor-exit v15
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1010
    :try_start_4
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->uuidToFileMap:Ljava/util/Map;

    invoke-interface {v13}, Ljava/util/Map;->clear()V

    .line 1011
    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_2
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_4

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/comcast/cim/downloads/DownloadFile;

    .line 1012
    .local v7, "newFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->uuidToFileMap:Ljava/util/Map;

    invoke-virtual {v7}, Lcom/comcast/cim/downloads/DownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v16

    invoke-interface/range {v16 .. v16}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-interface {v15, v0, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 1014
    .end local v7    # "newFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :cond_4
    monitor-exit v14
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1017
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_3
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_5

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/downloads/DownloadFile;

    .line 1018
    .local v3, "deletedFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v14

    const-string v15, "Calling onFileDeleted for {}"

    invoke-interface {v14, v15, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1019
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v14, v3}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onFileDeleted(Lcom/comcast/cim/downloads/DownloadFile;)V

    goto :goto_3

    .line 1022
    .end local v3    # "deletedFile":Lcom/comcast/cim/downloads/DownloadFile;, "TD;"
    :cond_5
    invoke-virtual/range {p0 .. p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->onFileMapRetrieved()V

    .line 1024
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v13}, Lcom/comcast/cim/downloads/DownloadServiceManager;->isFileListReady()Z

    move-result v13

    if-eqz v13, :cond_6

    .line 1025
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->initializationLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v13}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1700(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v13

    invoke-virtual {v13}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 1026
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$UpdateDownloadableFileMapTask;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v13}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onFileListUpdated()V

    .line 1028
    :cond_6
    return-void
.end method
