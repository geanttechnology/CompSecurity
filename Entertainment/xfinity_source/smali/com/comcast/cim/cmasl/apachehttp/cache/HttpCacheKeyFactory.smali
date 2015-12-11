.class public Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;
.super Ljava/lang/Object;
.source "HttpCacheKeyFactory.java"


# instance fields
.field private final keyCache:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    new-instance v0, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    const/16 v1, 0x1e

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;->keyCache:Ljava/util/LinkedHashMap;

    return-void
.end method


# virtual methods
.method public create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 13
    iget-object v2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;->keyCache:Ljava/util/LinkedHashMap;

    monitor-enter v2

    .line 14
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;->keyCache:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    .line 15
    .local v0, "cacheKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    if-nez v0, :cond_0

    .line 16
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;

    .end local v0    # "cacheKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    invoke-direct {v0, p1}, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;-><init>(Ljava/lang/String;)V

    .line 17
    .restart local v0    # "cacheKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKeyFactory;->keyCache:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 19
    :cond_0
    monitor-exit v2

    return-object v0

    .line 20
    .end local v0    # "cacheKey":Lcom/comcast/cim/cmasl/apachehttp/cache/HttpCacheKey;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
