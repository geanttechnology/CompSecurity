.class public Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
.super Ljava/lang/Object;
.source "HalLiveStreamResource.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private liveStreamMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->liveStreamMap:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public getLiveStream(Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .locals 1
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->liveStreamMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    return-object v0
.end method

.method public getLiveStreams()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation

    .prologue
    .line 37
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->liveStreamMap:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 8
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 21
    const-string v4, "streams"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 22
    .local v2, "items":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 23
    .local v1, "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v3, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-direct {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;-><init>()V

    .line 26
    .local v3, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    :try_start_0
    invoke-virtual {p1, v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    :try_end_0
    .catch Lcom/comcast/cim/microdata/exception/PropertyNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 32
    iget-object v5, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->liveStreamMap:Ljava/util/Map;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 27
    :catch_0
    move-exception v0

    .line 28
    .local v0, "e":Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;
    sget-object v5, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->LOG:Lorg/slf4j/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Failed to parse Live Stream: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 34
    .end local v0    # "e":Lcom/comcast/cim/microdata/exception/PropertyNotFoundException;
    .end local v1    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    .end local v3    # "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    :cond_0
    return-void
.end method
