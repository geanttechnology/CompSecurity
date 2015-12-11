.class public Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;
.super Ljava/lang/Object;
.source "DiskLruHttpCacheStorageAdapter.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheStorage;


# instance fields
.field private final cacheKeyFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;

.field private final delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;)V
    .locals 0
    .param p1, "delegate"    # Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;
    .param p2, "cacheKeyFactory"    # Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;

    .line 20
    iput-object p2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->cacheKeyFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;

    .line 21
    return-void
.end method


# virtual methods
.method public getEntry(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->cacheKeyFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;

    invoke-virtual {v1, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->getEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    move-result-object v0

    return-object v0
.end method

.method public putEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->cacheKeyFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;

    invoke-virtual {v1, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->putEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V

    .line 26
    return-void
.end method

.method public removeEntry(Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 35
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->cacheKeyFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;

    invoke-virtual {v1, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->removeEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;)V

    .line 36
    return-void
.end method

.method public updateEntry(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateException;
        }
    .end annotation

    .prologue
    .line 40
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorageAdapter;->cacheKeyFactory:Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;

    invoke-virtual {v1, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage;->updateEntry(Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheUpdateCallback;)V

    .line 41
    return-void
.end method
