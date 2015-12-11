.class public abstract Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;
.super Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;
.source "CacheableApiDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer",
        "<TT;>;"
    }
.end annotation


# static fields
.field protected static CACHE_CAPACITY:I

.field protected static CACHE_CONTAINER:Ljava/lang/String;


# instance fields
.field protected cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/disney/datg/videoplatforms/sdk/cache/Cache",
            "<TK;",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field protected expireTime:I

.field protected timeToLive:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const/16 v0, 0x64

    sput v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->CACHE_CAPACITY:I

    .line 37
    const-string v0, ""

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->CACHE_CONTAINER:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cacheContainerName"    # Ljava/lang/String;
    .param p3, "cacheCapacity"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 45
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer<TK;TT;>;"
    .local p4, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0, p4}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;-><init>(Ljava/lang/Class;)V

    .line 40
    const/4 v0, -0x1

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->timeToLive:I

    .line 41
    const/16 v0, 0x12c

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->expireTime:I

    .line 46
    if-eqz p1, :cond_0

    .line 47
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;

    invoke-direct {v0, p1}, Lcom/disney/datg/videoplatforms/sdk/cache/DiskLRUCacheImpl;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;

    .line 48
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;

    invoke-virtual {v0, p2}, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;->setCacheName(Ljava/lang/String;)V

    .line 49
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;

    invoke-virtual {v0, p3}, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;->setCapacity(I)V

    .line 51
    :cond_0
    return-void
.end method


# virtual methods
.method public createKey(Ljava/util/Map;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)TK;"
        }
    .end annotation

    .prologue
    .line 91
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer<TK;TT;>;"
    .local p1, "keyParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 92
    .local v0, "builder":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 93
    .local v2, "key":Ljava/lang/String;
    invoke-interface {p1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "_"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 95
    .end local v2    # "key":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_1

    const/4 v3, 0x0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuilder;->substring(II)Ljava/lang/String;

    move-result-object v3

    :goto_1
    return-object v3

    :cond_1
    const-string v3, ""

    goto :goto_1
.end method

.method public executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    .locals 20
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<TT;>;I",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<TT;>;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 102
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer<TK;TT;>;"
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<TT;>;"
    .local p3, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<TT;>;"
    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v13

    if-eqz v13, :cond_0

    invoke-interface/range {p1 .. p1}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v13

    invoke-virtual {v13}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->isEmpty()Z

    move-result v13

    if-eqz v13, :cond_1

    .line 104
    :cond_0
    new-instance v13, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v14, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_UNDEFINED_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v13, v14}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v13

    .line 108
    :cond_1
    new-instance v7, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$1;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v7, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;Lcom/disney/datg/videoplatforms/sdk/service/Request;)V

    .line 114
    .local v7, "keyMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->createKey(Ljava/util/Map;)Ljava/lang/Object;

    move-result-object v6

    .line 115
    .local v6, "key":Ljava/lang/Object;, "TK;"
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;

    if-eqz v13, :cond_3

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;

    invoke-virtual {v13}, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;->isEmpty()Z

    move-result v13

    if-nez v13, :cond_3

    .line 117
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->cache:Lcom/disney/datg/videoplatforms/sdk/cache/Cache;

    invoke-virtual {v13, v6}, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;->get(Ljava/lang/Object;)Lcom/disney/datg/videoplatforms/sdk/cache/Data;

    move-result-object v4

    .line 118
    .local v4, "data":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;Lorg/springframework/http/ResponseEntity<TT;>;>;"
    if-eqz v4, :cond_3

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->getValue()Ljava/lang/Object;

    move-result-object v13

    if-eqz v13, :cond_3

    .line 119
    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/springframework/http/ResponseEntity;

    .line 120
    .local v5, "dataResponse":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    const/4 v11, 0x0

    .line 121
    .local v11, "stale":Z
    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->getTtl()I

    move-result v12

    .line 122
    .local v12, "ttl":I
    if-lez v12, :cond_2

    .line 123
    new-instance v9, Ljava/util/Date;

    invoke-direct {v9}, Ljava/util/Date;-><init>()V

    .line 124
    .local v9, "now":Ljava/util/Date;
    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/cache/Data;->getAccessTime()Ljava/util/Date;

    move-result-object v8

    .line 125
    .local v8, "lastAccessed":Ljava/util/Date;
    int-to-long v14, v12

    invoke-virtual {v9}, Ljava/util/Date;->getTime()J

    move-result-wide v16

    invoke-virtual {v8}, Ljava/util/Date;->getTime()J

    move-result-wide v18

    sub-long v16, v16, v18

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    cmp-long v13, v14, v16

    if-gez v13, :cond_2

    .line 126
    const/4 v11, 0x1

    .line 129
    .end local v8    # "lastAccessed":Ljava/util/Date;
    .end local v9    # "now":Ljava/util/Date;
    :cond_2
    if-nez v11, :cond_3

    .line 130
    new-instance v10, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p1

    invoke-direct {v10, v0, v1, v2, v5}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$2;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;Lcom/disney/datg/videoplatforms/sdk/service/Request;Lorg/springframework/http/ResponseEntity;)V

    .line 205
    .end local v4    # "data":Lcom/disney/datg/videoplatforms/sdk/cache/Data;, "Lcom/disney/datg/videoplatforms/sdk/cache/Data<TK;Lorg/springframework/http/ResponseEntity<TT;>;>;"
    .end local v5    # "dataResponse":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<TT;>;"
    .end local v11    # "stale":Z
    .end local v12    # "ttl":I
    :goto_0
    return-object v10

    .line 172
    :cond_3
    new-instance v13, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v13, v0, v6, v1}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$3;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;Ljava/lang/Object;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    invoke-super {v0, v1, v2, v13}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;

    move-result-object v10

    .line 205
    .local v10, "responseEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<TT;>;>;"
    goto :goto_0
.end method
