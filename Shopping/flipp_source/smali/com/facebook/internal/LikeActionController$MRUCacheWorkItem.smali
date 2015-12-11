.class Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static mruCachedItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private cacheItem:Ljava/lang/String;

.field private shouldTrim:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 1346
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->mruCachedItems:Ljava/util/ArrayList;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 1350
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1351
    iput-object p1, p0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->cacheItem:Ljava/lang/String;

    .line 1352
    iput-boolean p2, p0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->shouldTrim:Z

    .line 1353
    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1357
    iget-object v0, p0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->cacheItem:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 1358
    sget-object v0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->mruCachedItems:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->cacheItem:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 1359
    sget-object v0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->mruCachedItems:Ljava/util/ArrayList;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->cacheItem:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 1361
    :cond_0
    iget-boolean v0, p0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->shouldTrim:Z

    if-eqz v0, :cond_1

    sget-object v0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->mruCachedItems:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/16 v1, 0x80

    if-lt v0, v1, :cond_1

    .line 1362
    :goto_0
    const/16 v0, 0x40

    sget-object v1, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->mruCachedItems:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 1364
    sget-object v0, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->mruCachedItems:Ljava/util/ArrayList;

    sget-object v1, Lcom/facebook/internal/LikeActionController$MRUCacheWorkItem;->mruCachedItems:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1367
    # getter for: Lcom/facebook/internal/LikeActionController;->cache:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {}, Lcom/facebook/internal/LikeActionController;->access$400()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1370
    :cond_1
    return-void
.end method
