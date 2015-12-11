.class public Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;
.super Lcom/comcast/cim/downloads/DownloadFileFactory;
.source "DownloadableFileFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/downloads/DownloadFileFactory",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final downloadMetaDataDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;",
            ">;"
        }
    .end annotation
.end field

.field private final entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

.field private final watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;Lcom/comcast/cim/utils/JsonDeserializer;Lcom/xfinity/playerlib/model/consumable/WatchableCodec;)V
    .locals 1
    .param p1, "entityCache"    # Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
    .param p3, "watchableCodec"    # Lcom/xfinity/playerlib/model/consumable/WatchableCodec;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;",
            "Lcom/comcast/cim/utils/JsonDeserializer",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;",
            ">;",
            "Lcom/xfinity/playerlib/model/consumable/WatchableCodec;",
            ")V"
        }
    .end annotation

    .prologue
    .line 26
    .local p2, "downloadMetaDataDeserializer":Lcom/comcast/cim/utils/JsonDeserializer;, "Lcom/comcast/cim/utils/JsonDeserializer<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;>;"
    invoke-direct {p0}, Lcom/comcast/cim/downloads/DownloadFileFactory;-><init>()V

    .line 20
    const-class v0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->LOG:Lorg/slf4j/Logger;

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    .line 28
    iput-object p2, p0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->downloadMetaDataDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    .line 29
    iput-object p3, p0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    .line 30
    return-void
.end method


# virtual methods
.method public bridge synthetic create(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/comcast/cim/downloads/DownloadFile;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->create(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v0

    return-object v0
.end method

.method public create(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .locals 11
    .param p1, "asset"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .prologue
    .line 34
    new-instance v4, Lorg/apache/commons/lang3/time/StopWatch;

    invoke-direct {v4}, Lorg/apache/commons/lang3/time/StopWatch;-><init>()V

    .line 36
    .local v4, "timer":Lorg/apache/commons/lang3/time/StopWatch;
    invoke-virtual {v4}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 37
    iget-object v8, p0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->downloadMetaDataDeserializer:Lcom/comcast/cim/utils/JsonDeserializer;

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->metadata()Ljava/lang/String;

    move-result-object v9

    const-class v10, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    invoke-virtual {v8, v9, v10}, Lcom/comcast/cim/utils/JsonDeserializer;->deserialize(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;

    .line 38
    .local v2, "metaData":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getUuid()Ljava/util/UUID;

    move-result-object v5

    .line 39
    .local v5, "uuid":Ljava/util/UUID;
    iget-object v8, p0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->entityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    invoke-virtual {v8, v5}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->retrieve(Ljava/util/UUID;)Lcom/comcast/cim/cmasl/utils/container/Either;

    move-result-object v0

    .line 40
    .local v0, "backingEntity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;->getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v7

    .line 41
    .local v7, "watchableKey":Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    new-instance v1, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;

    invoke-direct {v1, v7, v0}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/comcast/cim/cmasl/utils/container/Either;)V

    .line 42
    .local v1, "encodedWatchable":Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;
    iget-object v8, p0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    invoke-virtual {v8, v1}, Lcom/xfinity/playerlib/model/consumable/WatchableCodec;->decode(Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v6

    .line 43
    .local v6, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    new-instance v3, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-direct {v3, p1, v2, v6}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;-><init>(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadMetaData;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 44
    .local v3, "playerDownloadFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual {v4}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 46
    iget-object v8, p0, Lcom/xfinity/playerlib/model/downloads/DownloadableFileFactory;->LOG:Lorg/slf4j/Logger;

    const-string v9, "Created new PlayerDownloadFile {} in {}"

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v8, v9, v10, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 48
    return-object v3
.end method
