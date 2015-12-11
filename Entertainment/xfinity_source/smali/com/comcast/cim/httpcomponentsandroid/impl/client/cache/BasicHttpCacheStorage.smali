.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;
.super Ljava/lang/Object;
.source "BasicHttpCacheStorage.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field private final entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;)V
    .locals 2
    .param p1, "config"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheConfig;->getMaxCacheEntries()I

    move-result v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    .line 55
    return-void
.end method


# virtual methods
.method public declared-synchronized getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 77
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized putEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 66
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 67
    monitor-exit p0

    return-void

    .line 66
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized removeEntry(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 87
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 88
    monitor-exit p0

    return-void

    .line 87
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized updateEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 93
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .line 94
    .local v0, "existingEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/BasicHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-interface {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;->update(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 95
    monitor-exit p0

    return-void

    .line 93
    .end local v0    # "existingEntry":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
