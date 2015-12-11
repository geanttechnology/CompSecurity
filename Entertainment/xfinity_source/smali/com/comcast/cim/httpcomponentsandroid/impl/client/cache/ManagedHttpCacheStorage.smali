.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;
.super Ljava/lang/Object;
.source "ManagedHttpCacheStorage.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field private final entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

.field private final morque:Ljava/lang/ref/ReferenceQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/ReferenceQueue",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;",
            ">;"
        }
    .end annotation
.end field

.field private final resources:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;",
            ">;"
        }
    .end annotation
.end field

.field private volatile shutdown:Z


# direct methods
.method private ensureValidState()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 72
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->shutdown:Z

    if-eqz v0, :cond_0

    .line 73
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cache has been shut down"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :cond_0
    return-void
.end method

.method private keepResourceReference(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 3
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 78
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;->getResource()Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v1

    .line 79
    .local v1, "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    if-eqz v1, :cond_0

    .line 81
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->morque:Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0, p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;Ljava/lang/ref/ReferenceQueue;)V

    .line 82
    .local v0, "ref":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->resources:Ljava/util/Set;

    invoke-interface {v2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 84
    .end local v0    # "ref":Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ResourceReference;
    :cond_0
    return-void
.end method


# virtual methods
.method public getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 101
    if-nez p1, :cond_0

    .line 102
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "URL may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 104
    :cond_0
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->ensureValidState()V

    .line 105
    monitor-enter p0

    .line 106
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    monitor-exit p0

    return-object v0

    .line 107
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public putEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 87
    if-nez p1, :cond_0

    .line 88
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "URL may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 90
    :cond_0
    if-nez p2, :cond_1

    .line 91
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cache entry may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 93
    :cond_1
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->ensureValidState()V

    .line 94
    monitor-enter p0

    .line 95
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    invoke-direct {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->keepResourceReference(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 97
    monitor-exit p0

    .line 98
    return-void

    .line 97
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public removeEntry(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 111
    if-nez p1, :cond_0

    .line 112
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "URL may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 114
    :cond_0
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->ensureValidState()V

    .line 115
    monitor-enter p0

    .line 118
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 119
    monitor-exit p0

    .line 120
    return-void

    .line 119
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public updateEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 125
    if-nez p1, :cond_0

    .line 126
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "URL may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 128
    :cond_0
    if-nez p2, :cond_1

    .line 129
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Callback may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 131
    :cond_1
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->ensureValidState()V

    .line 132
    monitor-enter p0

    .line 133
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v2, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .line 134
    .local v0, "existing":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    invoke-interface {p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;->update(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v1

    .line 135
    .local v1, "updated":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->entries:Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;

    invoke-virtual {v2, p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/CacheMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 136
    if-eq v0, v1, :cond_2

    .line 137
    invoke-direct {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/ManagedHttpCacheStorage;->keepResourceReference(Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 139
    :cond_2
    monitor-exit p0

    .line 140
    return-void

    .line 139
    .end local v0    # "existing":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .end local v1    # "updated":Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method
