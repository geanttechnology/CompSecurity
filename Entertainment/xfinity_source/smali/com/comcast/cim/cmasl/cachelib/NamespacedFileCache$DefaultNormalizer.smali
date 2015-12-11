.class Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;
.super Ljava/lang/Object;
.source "NamespacedFileCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/cachelib/Normalizer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DefaultNormalizer"
.end annotation


# instance fields
.field private final keyCache:Landroid/support/v4/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LruCache",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final namespace:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "namespace"    # Ljava/lang/String;

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    new-instance v0, Landroid/support/v4/util/LruCache;

    const/16 v1, 0x1e

    invoke-direct {v0, v1}, Landroid/support/v4/util/LruCache;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;->keyCache:Landroid/support/v4/util/LruCache;

    .line 112
    iput-object p1, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;->namespace:Ljava/lang/String;

    .line 113
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;

    .prologue
    .line 104
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public normalize(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 117
    iget-object v2, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;->keyCache:Landroid/support/v4/util/LruCache;

    monitor-enter v2

    .line 118
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;->keyCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v1, p1}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 119
    .local v0, "cacheKey":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 120
    new-instance v0, Ljava/lang/String;

    .end local v0    # "cacheKey":Ljava/lang/String;
    invoke-static {p1}, Lorg/apache/commons/codec/digest/DigestUtils;->sha(Ljava/lang/String;)[B

    move-result-object v1

    invoke-static {v1}, Lorg/apache/commons/codec/binary/Hex;->encodeHex([B)[C

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([C)V

    .line 121
    .restart local v0    # "cacheKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;->keyCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v1, p1, v0}, Landroid/support/v4/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;->namespace:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "."

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    monitor-exit v2

    return-object v1

    .line 124
    .end local v0    # "cacheKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
