.class public Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;
.super Landroid/support/v4/util/LruCache;
.source "MemoryLimitedLruCache.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/cache/ResourceCache;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
        "<*>;>",
        "Landroid/support/v4/util/LruCache",
        "<TK;TV;>;",
        "Lcom/amazon/ansel/fetch/cache/ResourceCache",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field private final listener:Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheListener",
            "<TK;TV;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(ILcom/amazon/ansel/fetch/cache/ResourceCacheListener;)V
    .locals 0
    .param p1, "maxBytes"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheListener",
            "<TK;TV;>;)V"
        }
    .end annotation

    .prologue
    .line 10
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;, "Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache<TK;TV;>;"
    .local p2, "listener":Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheListener<TK;TV;>;"
    invoke-direct {p0, p1}, Landroid/support/v4/util/LruCache;-><init>(I)V

    .line 11
    iput-object p2, p0, Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;->listener:Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;

    .line 12
    return-void
.end method


# virtual methods
.method protected entryRemoved(ZLjava/lang/Object;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;)V
    .locals 1
    .param p1, "evicted"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZTK;TV;TV;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;, "Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache<TK;TV;>;"
    .local p2, "key":Ljava/lang/Object;, "TK;"
    .local p3, "oldValue":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "TV;"
    .local p4, "newValue":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "TV;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;->listener:Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;

    if-eqz v0, :cond_1

    if-eqz p4, :cond_0

    if-eq p4, p3, :cond_1

    .line 22
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;->listener:Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;

    invoke-interface {v0, p2, p3}, Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;->evict(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 24
    :cond_1
    return-void
.end method

.method protected bridge synthetic entryRemoved(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Z
    .param p2, "x1"    # Ljava/lang/Object;
    .param p3, "x2"    # Ljava/lang/Object;
    .param p4, "x3"    # Ljava/lang/Object;

    .prologue
    .line 5
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;, "Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache<TK;TV;>;"
    check-cast p3, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;

    .end local p3    # "x2":Ljava/lang/Object;
    check-cast p4, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;

    .end local p4    # "x3":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;->entryRemoved(ZLjava/lang/Object;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;)V

    return-void
.end method

.method protected sizeOf(Ljava/lang/Object;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)I"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;, "Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "TV;"
    invoke-virtual {p2}, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->getByteCount()I

    move-result v0

    return v0
.end method

.method protected bridge synthetic sizeOf(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 5
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;, "Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache<TK;TV;>;"
    check-cast p2, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;->sizeOf(Ljava/lang/Object;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;)I

    move-result v0

    return v0
.end method
