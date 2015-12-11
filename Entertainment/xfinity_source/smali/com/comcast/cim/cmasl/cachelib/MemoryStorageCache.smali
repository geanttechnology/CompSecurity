.class public Lcom/comcast/cim/cmasl/cachelib/MemoryStorageCache;
.super Ljava/lang/Object;
.source "MemoryStorageCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/StorageCache;


# instance fields
.field private final inputStreamMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/io/InputStream;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/MemoryStorageCache;->inputStreamMap:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public remove(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/MemoryStorageCache;->inputStreamMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    return-void
.end method

.method public removeAll()V
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/MemoryStorageCache;->inputStreamMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 36
    return-void
.end method

.method public retrieve(Ljava/lang/String;)Ljava/io/InputStream;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/MemoryStorageCache;->inputStreamMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/InputStream;

    return-object v0
.end method

.method public store(Ljava/io/InputStream;Ljava/lang/String;)V
    .locals 1
    .param p1, "data"    # Ljava/io/InputStream;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/MemoryStorageCache;->inputStreamMap:Ljava/util/Map;

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 16
    return-void
.end method
