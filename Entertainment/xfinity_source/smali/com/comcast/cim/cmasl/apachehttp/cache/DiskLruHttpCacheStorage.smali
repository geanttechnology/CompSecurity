.class public Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;
.super Ljava/lang/Object;
.source "DiskLruHttpCacheStorage.java"


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final lockMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/util/concurrent/locks/ReentrantLock;",
            ">;>;"
        }
    .end annotation
.end field

.field private lruCache:Lcom/jakewharton/DiskLruCache;

.field private final lruCacheProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/jakewharton/DiskLruCache;",
            ">;"
        }
    .end annotation
.end field

.field private final resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

.field private volatileCache:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/utils/provider/Provider;Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;)V
    .locals 2
    .param p2, "resourceFactory"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/jakewharton/DiskLruCache;",
            ">;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;",
            ")V"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "lruCacheProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/jakewharton/DiskLruCache;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    const-class v0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->LOG:Lorg/slf4j/Logger;

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lockMap:Ljava/util/Map;

    .line 44
    new-instance v0, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->volatileCache:Ljava/util/LinkedHashMap;

    .line 47
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lruCacheProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 48
    iput-object p2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    .line 49
    return-void
.end method

.method private copyEntry(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 7
    .param p1, "source"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .param p2, "updatedResource"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .prologue
    .line 144
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getRequestDate()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResponseDate()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v4

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getVariantMap()Ljava/util/Map;

    move-result-object v6

    move-object v5, p2

    invoke-direct/range {v0 .. v6}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;-><init>(Ljava/util/Date;Ljava/util/Date;Lcom/comcast/cim/httpcomponentsandroid/StatusLine;[Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;Ljava/util/Map;)V

    return-object v0
.end method

.method private getLock(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)Ljava/util/concurrent/locks/ReentrantLock;
    .locals 4
    .param p1, "key"    # Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    .prologue
    .line 181
    iget-object v3, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lockMap:Ljava/util/Map;

    monitor-enter v3

    .line 182
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lockMap:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ref/WeakReference;

    .line 183
    .local v1, "lockRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/util/concurrent/locks/ReentrantLock;>;"
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/locks/ReentrantLock;

    move-object v0, v2

    .line 184
    .local v0, "lock":Ljava/util/concurrent/locks/ReentrantLock;
    :goto_0
    if-nez v0, :cond_0

    .line 185
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    .end local v0    # "lock":Ljava/util/concurrent/locks/ReentrantLock;
    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    .line 186
    .restart local v0    # "lock":Ljava/util/concurrent/locks/ReentrantLock;
    new-instance v1, Ljava/lang/ref/WeakReference;

    .end local v1    # "lockRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/util/concurrent/locks/ReentrantLock;>;"
    invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 187
    .restart local v1    # "lockRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/util/concurrent/locks/ReentrantLock;>;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lockMap:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 189
    :cond_0
    monitor-exit v3

    return-object v0

    .line 183
    .end local v0    # "lock":Ljava/util/concurrent/locks/ReentrantLock;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 190
    .end local v1    # "lockRef":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Ljava/util/concurrent/locks/ReentrantLock;>;"
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method private declared-synchronized getLruCache()Lcom/jakewharton/DiskLruCache;
    .locals 1

    .prologue
    .line 194
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lruCache:Lcom/jakewharton/DiskLruCache;

    if-nez v0, :cond_0

    .line 195
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lruCacheProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jakewharton/DiskLruCache;

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lruCache:Lcom/jakewharton/DiskLruCache;

    .line 197
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->lruCache:Lcom/jakewharton/DiskLruCache;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 194
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private removeEntryQuietly(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)V
    .locals 3
    .param p1, "key"    # Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    .prologue
    .line 162
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->removeEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 166
    :goto_0
    return-void

    .line 163
    :catch_0
    move-exception v0

    .line 164
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Caught exception trying to remove entry"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public getEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 17
    .param p1, "key"    # Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 89
    invoke-direct/range {p0 .. p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLock(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v9

    .line 90
    .local v9, "lock":Ljava/util/concurrent/locks/ReentrantLock;
    invoke-virtual {v9}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 92
    :try_start_0
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->volatileCache:Ljava/util/LinkedHashMap;

    move-object/from16 v0, p1

    invoke-virtual {v14, v0}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 93
    .local v6, "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    if-eqz v6, :cond_0

    .line 139
    invoke-virtual {v9}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .end local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :goto_0
    return-object v6

    .line 97
    .restart local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :cond_0
    const/4 v7, 0x0

    .line 98
    .local v7, "keyInputStream":Ljava/io/ObjectInputStream;
    const/4 v4, 0x0

    .line 99
    .local v4, "entryInputStream":Ljava/io/ObjectInputStream;
    const/4 v10, 0x0

    .line 101
    .local v10, "resourceInputStream":Ljava/io/InputStream;
    :try_start_1
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v14

    invoke-virtual/range {p1 .. p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->toDigest()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Lcom/jakewharton/DiskLruCache;->get(Ljava/lang/String;)Lcom/jakewharton/DiskLruCache$Snapshot;
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v11

    .line 102
    .local v11, "snapshot":Lcom/jakewharton/DiskLruCache$Snapshot;
    if-nez v11, :cond_1

    .line 103
    const/4 v6, 0x0

    .line 133
    .end local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_start_2
    invoke-static {v7}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 134
    invoke-static {v4}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 135
    invoke-static {v10}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 136
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v14

    invoke-virtual {v14}, Lcom/jakewharton/DiskLruCache;->flush()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 139
    invoke-virtual {v9}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    .line 105
    .restart local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :cond_1
    :try_start_3
    new-instance v8, Ljava/io/ObjectInputStream;

    const/4 v14, 0x0

    invoke-virtual {v11, v14}, Lcom/jakewharton/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v14

    invoke-direct {v8, v14}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_3
    .catch Ljava/lang/ClassNotFoundException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 106
    .end local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    .local v8, "keyInputStream":Ljava/io/ObjectInputStream;
    :try_start_4
    invoke-virtual {v8}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;

    move-result-object v14

    invoke-static {v14}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    .line 107
    .local v13, "storedKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    move-object/from16 v0, p1

    invoke-virtual {v13, v0}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_2

    .line 109
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->LOG:Lorg/slf4j/Logger;

    const-string v15, "Apparent hash collision for cache entry for key {}, stored key is {}"

    move-object/from16 v0, p1

    invoke-interface {v14, v15, v0, v13}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 110
    invoke-direct/range {p0 .. p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->removeEntryQuietly(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)V
    :try_end_4
    .catch Ljava/lang/ClassNotFoundException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 111
    const/4 v6, 0x0

    .line 133
    .end local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_start_5
    invoke-static {v8}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 134
    invoke-static {v4}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 135
    invoke-static {v10}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 136
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v14

    invoke-virtual {v14}, Lcom/jakewharton/DiskLruCache;->flush()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 139
    invoke-virtual {v9}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    .line 113
    .restart local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :cond_2
    :try_start_6
    new-instance v5, Ljava/io/ObjectInputStream;

    const/4 v14, 0x1

    invoke-virtual {v11, v14}, Lcom/jakewharton/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v14

    invoke-direct {v5, v14}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_6
    .catch Ljava/lang/ClassNotFoundException; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 114
    .end local v4    # "entryInputStream":Ljava/io/ObjectInputStream;
    .local v5, "entryInputStream":Ljava/io/ObjectInputStream;
    :try_start_7
    invoke-virtual {v5}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;

    move-result-object v14

    invoke-static {v14}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .line 121
    .local v12, "storedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    const/4 v14, 0x2

    invoke-virtual {v11, v14}, Lcom/jakewharton/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v10

    .line 122
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->resourceFactory:Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;

    invoke-virtual/range {p1 .. p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->getKey()Ljava/lang/String;

    move-result-object v15

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-interface {v14, v15, v10, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;->generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v2

    .line 124
    .local v2, "copiedResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    move-object/from16 v0, p0

    invoke-direct {v0, v12, v2}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->copyEntry(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v1

    .line 125
    .local v1, "copiedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->volatileCache:Ljava/util/LinkedHashMap;

    move-object/from16 v0, p1

    invoke-virtual {v14, v0, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->LOG:Lorg/slf4j/Logger;

    const-string v15, "Returning cached entry for key {}"

    move-object/from16 v0, p1

    invoke-interface {v14, v15, v0}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_7
    .catch Ljava/lang/ClassNotFoundException; {:try_start_7 .. :try_end_7} :catch_2
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 133
    :try_start_8
    invoke-static {v8}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 134
    invoke-static {v5}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 135
    invoke-static {v10}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 136
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v14

    invoke-virtual {v14}, Lcom/jakewharton/DiskLruCache;->flush()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 139
    invoke-virtual {v9}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    move-object v6, v1

    goto/16 :goto_0

    .line 128
    .end local v1    # "copiedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .end local v2    # "copiedResource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .end local v5    # "entryInputStream":Ljava/io/ObjectInputStream;
    .end local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    .end local v11    # "snapshot":Lcom/jakewharton/DiskLruCache$Snapshot;
    .end local v12    # "storedEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .end local v13    # "storedKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    .restart local v4    # "entryInputStream":Ljava/io/ObjectInputStream;
    .restart local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    :catch_0
    move-exception v3

    .line 129
    .local v3, "e":Ljava/lang/ClassNotFoundException;
    :goto_1
    :try_start_9
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->LOG:Lorg/slf4j/Logger;

    const-string v15, "Caught exception trying to read object, removing entry"

    invoke-interface {v14, v15, v3}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 130
    invoke-direct/range {p0 .. p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->removeEntryQuietly(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 131
    const/4 v6, 0x0

    .line 133
    .end local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_start_a
    invoke-static {v7}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 134
    invoke-static {v4}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 135
    invoke-static {v10}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 136
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v14

    invoke-virtual {v14}, Lcom/jakewharton/DiskLruCache;->flush()V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 139
    invoke-virtual {v9}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto/16 :goto_0

    .line 133
    .end local v3    # "e":Ljava/lang/ClassNotFoundException;
    .restart local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :catchall_0
    move-exception v14

    :goto_2
    :try_start_b
    invoke-static {v7}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 134
    invoke-static {v4}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 135
    invoke-static {v10}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 136
    invoke-direct/range {p0 .. p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v15

    invoke-virtual {v15}, Lcom/jakewharton/DiskLruCache;->flush()V

    throw v14
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    .line 139
    .end local v4    # "entryInputStream":Ljava/io/ObjectInputStream;
    .end local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .end local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    .end local v10    # "resourceInputStream":Ljava/io/InputStream;
    :catchall_1
    move-exception v14

    invoke-virtual {v9}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v14

    .line 133
    .restart local v4    # "entryInputStream":Ljava/io/ObjectInputStream;
    .restart local v6    # "httpCacheEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .restart local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v10    # "resourceInputStream":Ljava/io/InputStream;
    .restart local v11    # "snapshot":Lcom/jakewharton/DiskLruCache$Snapshot;
    :catchall_2
    move-exception v14

    move-object v7, v8

    .end local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    goto :goto_2

    .end local v4    # "entryInputStream":Ljava/io/ObjectInputStream;
    .end local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v5    # "entryInputStream":Ljava/io/ObjectInputStream;
    .restart local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v13    # "storedKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    :catchall_3
    move-exception v14

    move-object v4, v5

    .end local v5    # "entryInputStream":Ljava/io/ObjectInputStream;
    .restart local v4    # "entryInputStream":Ljava/io/ObjectInputStream;
    move-object v7, v8

    .end local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    goto :goto_2

    .line 128
    .end local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    .end local v13    # "storedKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    .restart local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    :catch_1
    move-exception v3

    move-object v7, v8

    .end local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    goto :goto_1

    .end local v4    # "entryInputStream":Ljava/io/ObjectInputStream;
    .end local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v5    # "entryInputStream":Ljava/io/ObjectInputStream;
    .restart local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v13    # "storedKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    :catch_2
    move-exception v3

    move-object v4, v5

    .end local v5    # "entryInputStream":Ljava/io/ObjectInputStream;
    .restart local v4    # "entryInputStream":Ljava/io/ObjectInputStream;
    move-object v7, v8

    .end local v8    # "keyInputStream":Ljava/io/ObjectInputStream;
    .restart local v7    # "keyInputStream":Ljava/io/ObjectInputStream;
    goto :goto_1
.end method

.method public putEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 9
    .param p1, "key"    # Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLock(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v5

    .line 53
    .local v5, "lock":Ljava/util/concurrent/locks/ReentrantLock;
    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 54
    iget-object v7, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->volatileCache:Ljava/util/LinkedHashMap;

    invoke-virtual {v7, p1, p2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    const/4 v0, 0x0

    .line 56
    .local v0, "editor":Lcom/jakewharton/DiskLruCache$Editor;
    const/4 v3, 0x0

    .line 57
    .local v3, "keyOutputStream":Ljava/io/ObjectOutputStream;
    const/4 v1, 0x0

    .line 58
    .local v1, "entryOutputStream":Ljava/io/ObjectOutputStream;
    const/4 v6, 0x0

    .line 60
    .local v6, "resourceOutputStream":Ljava/io/OutputStream;
    :try_start_0
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v7

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->toDigest()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/jakewharton/DiskLruCache;->edit(Ljava/lang/String;)Lcom/jakewharton/DiskLruCache$Editor;

    move-result-object v0

    .line 61
    new-instance v4, Ljava/io/ObjectOutputStream;

    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Lcom/jakewharton/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v7

    invoke-direct {v4, v7}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 62
    .end local v3    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    .local v4, "keyOutputStream":Ljava/io/ObjectOutputStream;
    :try_start_1
    invoke-virtual {v4, p1}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V

    .line 63
    new-instance v2, Ljava/io/ObjectOutputStream;

    const/4 v7, 0x1

    invoke-virtual {v0, v7}, Lcom/jakewharton/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v7

    invoke-direct {v2, v7}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 64
    .end local v1    # "entryOutputStream":Ljava/io/ObjectOutputStream;
    .local v2, "entryOutputStream":Ljava/io/ObjectOutputStream;
    :try_start_2
    invoke-virtual {v2, p2}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V

    .line 69
    const/4 v7, 0x2

    invoke-virtual {v0, v7}, Lcom/jakewharton/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v6

    .line 70
    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v7

    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;->getInputStream()Ljava/io/InputStream;

    move-result-object v7

    invoke-static {v7, v6}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;)I

    .line 72
    invoke-virtual {v0}, Lcom/jakewharton/DiskLruCache$Editor;->commit()V

    .line 73
    iget-object v7, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->LOG:Lorg/slf4j/Logger;

    const-string v8, "Successfully wrote cache entry for key {}"

    invoke-interface {v7, v8, p1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 75
    invoke-static {v4}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 76
    invoke-static {v2}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 77
    invoke-static {v6}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 78
    if-eqz v0, :cond_0

    .line 79
    invoke-virtual {v0}, Lcom/jakewharton/DiskLruCache$Editor;->abortUnlessCommitted()V

    .line 83
    :cond_0
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v7

    invoke-virtual {v7}, Lcom/jakewharton/DiskLruCache;->flush()V

    .line 84
    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 86
    return-void

    .line 75
    .end local v2    # "entryOutputStream":Ljava/io/ObjectOutputStream;
    .end local v4    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    .restart local v1    # "entryOutputStream":Ljava/io/ObjectOutputStream;
    .restart local v3    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    :catchall_0
    move-exception v7

    :goto_0
    invoke-static {v3}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 76
    invoke-static {v1}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 77
    invoke-static {v6}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 78
    if-eqz v0, :cond_1

    .line 79
    invoke-virtual {v0}, Lcom/jakewharton/DiskLruCache$Editor;->abortUnlessCommitted()V

    .line 83
    :cond_1
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v8

    invoke-virtual {v8}, Lcom/jakewharton/DiskLruCache;->flush()V

    .line 84
    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v7

    .line 75
    .end local v3    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    .restart local v4    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    :catchall_1
    move-exception v7

    move-object v3, v4

    .end local v4    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    .restart local v3    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    goto :goto_0

    .end local v1    # "entryOutputStream":Ljava/io/ObjectOutputStream;
    .end local v3    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    .restart local v2    # "entryOutputStream":Ljava/io/ObjectOutputStream;
    .restart local v4    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    :catchall_2
    move-exception v7

    move-object v1, v2

    .end local v2    # "entryOutputStream":Ljava/io/ObjectOutputStream;
    .restart local v1    # "entryOutputStream":Ljava/io/ObjectOutputStream;
    move-object v3, v4

    .end local v4    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    .restart local v3    # "keyOutputStream":Ljava/io/ObjectOutputStream;
    goto :goto_0
.end method

.method public removeEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)V
    .locals 3
    .param p1, "key"    # Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 149
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLock(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v0

    .line 150
    .local v0, "lock":Ljava/util/concurrent/locks/ReentrantLock;
    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 152
    :try_start_0
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;->toDigest()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jakewharton/DiskLruCache;->remove(Ljava/lang/String;)Z

    .line 153
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Removed entry for key {}"

    invoke-interface {v1, v2, p1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 155
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jakewharton/DiskLruCache;->flush()V

    .line 156
    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 158
    return-void

    .line 155
    :catchall_0
    move-exception v1

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLruCache()Lcom/jakewharton/DiskLruCache;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jakewharton/DiskLruCache;->flush()V

    .line 156
    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v1
.end method

.method public updateEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;)V
    .locals 4
    .param p1, "key"    # Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    .param p2, "callback"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateException;
        }
    .end annotation

    .prologue
    .line 169
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getLock(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v1

    .line 170
    .local v1, "lock":Ljava/util/concurrent/locks/ReentrantLock;
    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 172
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v0

    .line 173
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    invoke-interface {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;->update(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v2

    invoke-virtual {p0, p1, v2}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->putEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 174
    iget-object v2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Updated entry for key {}"

    invoke-interface {v2, v3, p1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 176
    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 178
    return-void

    .line 176
    .end local v0    # "entry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :catchall_0
    move-exception v2

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v2
.end method
