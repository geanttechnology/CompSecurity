.class public Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
.super Ljava/lang/Object;
.source "PersistentEntityCache.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field public static final NAMESPACE:Ljava/lang/String;


# instance fields
.field private final objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private final serializer:Lcom/comcast/cim/utils/JsonSerializer;

.field private final storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->LOG:Lorg/slf4j/Logger;

    .line 28
    const-class v0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->NAMESPACE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/utils/StorageCache;Lcom/comcast/cim/utils/JsonSerializer;Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "storageCache"    # Lcom/comcast/cim/cmasl/utils/StorageCache;
    .param p2, "serializer"    # Lcom/comcast/cim/utils/JsonSerializer;
    .param p3, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    .line 37
    iput-object p2, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->serializer:Lcom/comcast/cim/utils/JsonSerializer;

    .line 38
    iput-object p3, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 39
    return-void
.end method

.method private getCacheKey(Ljava/util/UUID;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/util/UUID;

    .prologue
    .line 103
    invoke-virtual {p1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public clear()V
    .locals 2

    .prologue
    .line 107
    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    monitor-enter v1

    .line 108
    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/utils/StorageCache;->removeAll()V

    .line 109
    monitor-exit v1

    .line 110
    return-void

    .line 109
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public remove(Ljava/util/UUID;)V
    .locals 4
    .param p1, "key"    # Ljava/util/UUID;

    .prologue
    .line 95
    iget-object v2, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    monitor-enter v2

    .line 96
    :try_start_0
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->getCacheKey(Ljava/util/UUID;)Ljava/lang/String;

    move-result-object v0

    .line 97
    .local v0, "cacheKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    invoke-interface {v1, v0}, Lcom/comcast/cim/cmasl/utils/StorageCache;->remove(Ljava/lang/String;)V

    .line 98
    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Removed entity for key {}"

    invoke-interface {v1, v3, v0}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 99
    monitor-exit v2

    .line 100
    return-void

    .line 99
    .end local v0    # "cacheKey":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public retrieve(Ljava/util/UUID;)Lcom/comcast/cim/cmasl/utils/container/Either;
    .locals 12
    .param p1, "key"    # Ljava/util/UUID;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/UUID;",
            ")",
            "Lcom/comcast/cim/cmasl/utils/container/Either",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->getCacheKey(Ljava/util/UUID;)Ljava/lang/String;

    move-result-object v2

    .line 59
    .local v2, "cacheKey":Ljava/lang/String;
    iget-object v9, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    monitor-enter v9

    .line 60
    :try_start_0
    iget-object v8, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    invoke-interface {v8, v2}, Lcom/comcast/cim/cmasl/utils/StorageCache;->retrieve(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v5

    .line 61
    .local v5, "storedStream":Ljava/io/InputStream;
    if-nez v5, :cond_0

    .line 62
    sget-object v8, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->LOG:Lorg/slf4j/Logger;

    const-string v10, "Entity for key {} not found"

    invoke-interface {v8, v10, v2}, Lorg/slf4j/Logger;->info(Ljava/lang/String;Ljava/lang/Object;)V

    .line 63
    const/4 v4, 0x0

    monitor-exit v9

    .line 91
    :goto_0
    return-object v4

    .line 68
    :cond_0
    new-instance v7, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v7}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 69
    .local v7, "streamBuffer":Ljava/io/ByteArrayOutputStream;
    new-instance v6, Lorg/apache/commons/io/input/TeeInputStream;

    invoke-direct {v6, v5, v7}, Lorg/apache/commons/io/input/TeeInputStream;-><init>(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 71
    .local v6, "storedStreamProxy":Ljava/io/InputStream;
    :try_start_1
    iget-object v8, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v10, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;

    invoke-virtual {v8, v6, v10}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;

    .line 72
    .local v1, "baseConsumable":Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
    sget-object v8, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache$1;->$SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace:[I

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v10

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->ordinal()I

    move-result v10

    aget v8, v8, v10

    packed-switch v8, :pswitch_data_0

    .line 81
    new-instance v8, Ljava/lang/IllegalArgumentException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Unexpected namespace for merlin ID: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v8, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 84
    .end local v1    # "baseConsumable":Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
    :catch_0
    move-exception v3

    .line 85
    .local v3, "e":Ljava/io/IOException;
    :try_start_2
    sget-object v8, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->LOG:Lorg/slf4j/Logger;

    const-string v10, "Caught exception parsing entity stream. Stream contents: {}"

    invoke-interface {v8, v10, v7}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Object;)V

    .line 86
    new-instance v8, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v8, v3}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v8
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 88
    .end local v3    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    :try_start_3
    invoke-static {v5}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    throw v8

    .line 90
    .end local v5    # "storedStream":Ljava/io/InputStream;
    .end local v6    # "storedStreamProxy":Ljava/io/InputStream;
    .end local v7    # "streamBuffer":Ljava/io/ByteArrayOutputStream;
    :catchall_1
    move-exception v8

    monitor-exit v9
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v8

    .line 74
    .restart local v1    # "baseConsumable":Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
    .restart local v5    # "storedStream":Ljava/io/InputStream;
    .restart local v6    # "storedStreamProxy":Ljava/io/InputStream;
    .restart local v7    # "streamBuffer":Ljava/io/ByteArrayOutputStream;
    :pswitch_0
    :try_start_4
    new-instance v4, Lcom/comcast/cim/cmasl/utils/container/LeftEither;

    move-object v0, v1

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    move-object v8, v0

    invoke-direct {v4, v8}, Lcom/comcast/cim/cmasl/utils/container/LeftEither;-><init>(Ljava/lang/Object;)V

    .line 83
    .local v4, "entity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :goto_1
    sget-object v8, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->LOG:Lorg/slf4j/Logger;

    const-string v10, "Retrieved entity with ID {} for key {}"

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v11

    invoke-interface {v8, v10, v11, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 88
    :try_start_5
    invoke-static {v5}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 90
    monitor-exit v9
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_0

    .line 77
    .end local v4    # "entity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :pswitch_1
    :try_start_6
    new-instance v4, Lcom/comcast/cim/cmasl/utils/container/RightEither;

    move-object v0, v1

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    move-object v8, v0

    invoke-direct {v4, v8}, Lcom/comcast/cim/cmasl/utils/container/RightEither;-><init>(Ljava/lang/Object;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 78
    .restart local v4    # "entity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    goto :goto_1

    .line 72
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public store(Ljava/util/UUID;Lcom/comcast/cim/cmasl/utils/container/Either;)V
    .locals 8
    .param p1, "key"    # Ljava/util/UUID;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/UUID;",
            "Lcom/comcast/cim/cmasl/utils/container/Either",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p2, "entity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    iget-object v5, p2, Lcom/comcast/cim/cmasl/utils/container/Either;->e1:Ljava/lang/Object;

    if-eqz v5, :cond_0

    iget-object v5, p2, Lcom/comcast/cim/cmasl/utils/container/Either;->e1:Ljava/lang/Object;

    check-cast v5, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;

    move-object v4, v5

    .line 43
    .local v4, "which":Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
    :goto_0
    iget-object v5, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->serializer:Lcom/comcast/cim/utils/JsonSerializer;

    invoke-virtual {v5, v4}, Lcom/comcast/cim/utils/JsonSerializer;->serialize(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 44
    .local v3, "serialized":Ljava/lang/String;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    .line 45
    .local v2, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->getCacheKey(Ljava/util/UUID;)Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "cacheKey":Ljava/lang/String;
    :try_start_0
    iget-object v6, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    monitor-enter v6
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 48
    :try_start_1
    iget-object v5, p0, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;

    const-string v7, "UTF-8"

    invoke-static {v3, v7}, Lorg/apache/commons/io/IOUtils;->toInputStream(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v7

    invoke-interface {v5, v7, v0}, Lcom/comcast/cim/cmasl/utils/StorageCache;->store(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 49
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 50
    :try_start_2
    sget-object v5, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->LOG:Lorg/slf4j/Logger;

    const-string v6, "Stored entity with ID {} using key {}"

    invoke-interface {v5, v6, v2, v0}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 54
    return-void

    .line 42
    .end local v0    # "cacheKey":Ljava/lang/String;
    .end local v2    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v3    # "serialized":Ljava/lang/String;
    .end local v4    # "which":Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
    :cond_0
    iget-object v5, p2, Lcom/comcast/cim/cmasl/utils/container/Either;->e2:Ljava/lang/Object;

    check-cast v5, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;

    move-object v4, v5

    goto :goto_0

    .line 49
    .restart local v0    # "cacheKey":Ljava/lang/String;
    .restart local v2    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v3    # "serialized":Ljava/lang/String;
    .restart local v4    # "which":Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
    :catchall_0
    move-exception v5

    :try_start_3
    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v5
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    .line 51
    :catch_0
    move-exception v1

    .line 52
    .local v1, "e":Ljava/io/IOException;
    new-instance v5, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v5, v1}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v5
.end method
