.class Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache$1;
.super Ljava/lang/Object;
.source "LimitedDiscCache.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;->calculateCacheSizeAndFillUsageMap()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;


# direct methods
.method constructor <init>(Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache$1;->this$0:Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;

    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 74
    const/4 v2, 0x0

    .line 75
    .local v2, "size":I
    iget-object v3, p0, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache$1;->this$0:Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;

    iget-object v3, v3, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;->cacheDir:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    .line 76
    .local v1, "cachedFiles":[Ljava/io/File;
    if-eqz v1, :cond_0

    .line 77
    array-length v4, v1

    const/4 v3, 0x0

    :goto_0
    if-lt v3, v4, :cond_1

    .line 81
    iget-object v3, p0, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache$1;->this$0:Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;

    # getter for: Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;->cacheSize:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v3}, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;->access$1(Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 83
    :cond_0
    return-void

    .line 77
    :cond_1
    aget-object v0, v1, v3

    .line 78
    .local v0, "cachedFile":Ljava/io/File;
    iget-object v5, p0, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache$1;->this$0:Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;

    invoke-virtual {v5, v0}, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;->getSize(Ljava/io/File;)I

    move-result v5

    add-int/2addr v2, v5

    .line 79
    iget-object v5, p0, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache$1;->this$0:Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;

    # getter for: Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;->lastUsageDates:Ljava/util/Map;
    invoke-static {v5}, Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;->access$0(Lcom/nostra13/universalimageloader/cache/disc/LimitedDiscCache;)Ljava/util/Map;

    move-result-object v5

    invoke-virtual {v0}, Ljava/io/File;->lastModified()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-interface {v5, v0, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method
