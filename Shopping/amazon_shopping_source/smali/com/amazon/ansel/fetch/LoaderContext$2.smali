.class final Lcom/amazon/ansel/fetch/LoaderContext$2;
.super Ljava/lang/Object;
.source "LoaderContext.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/ansel/fetch/LoaderContext;->createDefaultPrimaryCacheFactory(I)Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory",
        "<",
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
        "<*>;>;"
    }
.end annotation


# instance fields
.field final synthetic val$maxBytes:I


# direct methods
.method constructor <init>(I)V
    .locals 0

    .prologue
    .line 274
    iput p1, p0, Lcom/amazon/ansel/fetch/LoaderContext$2;->val$maxBytes:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCache(Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;)Lcom/amazon/ansel/fetch/cache/ResourceCache;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheListener",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;>;)",
            "Lcom/amazon/ansel/fetch/cache/ResourceCache",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;>;"
        }
    .end annotation

    .prologue
    .line 278
    .local p1, "listener":Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheListener<Ljava/lang/Object;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<*>;>;"
    new-instance v0, Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;

    iget v1, p0, Lcom/amazon/ansel/fetch/LoaderContext$2;->val$maxBytes:I

    invoke-direct {v0, v1, p1}, Lcom/amazon/ansel/fetch/cache/MemoryLimitedLruCache;-><init>(ILcom/amazon/ansel/fetch/cache/ResourceCacheListener;)V

    return-object v0
.end method
