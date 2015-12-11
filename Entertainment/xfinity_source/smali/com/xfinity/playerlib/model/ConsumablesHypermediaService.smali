.class public Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;
.super Lcom/comcast/cim/cmasl/hal/task/HypermediaService;
.source "ConsumablesHypermediaService.java"


# direct methods
.method public constructor <init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V
    .locals 0
    .param p1, "services"    # Lcom/comcast/cim/microdata/model/MicrodataItem;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/hal/task/HypermediaService;-><init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V

    .line 20
    return-void
.end method


# virtual methods
.method public getConsumablesUri(Ljava/lang/String;Ljava/lang/String;)Ljava/net/URI;
    .locals 2
    .param p1, "programId"    # Ljava/lang/String;
    .param p2, "maxDimension"    # Ljava/lang/String;

    .prologue
    .line 35
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 36
    .local v0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "programId"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    const-string v1, "maxDimension"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    const-string v1, "getProgramVideos"

    invoke-virtual {p0, v1, v0}, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;->fetchServiceUriPath(Ljava/lang/String;Ljava/util/Map;)Ljava/net/URI;

    move-result-object v1

    return-object v1
.end method

.method public getDibicMoviesUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 27
    const-string v0, "getMoviePrograms"

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;->fetchServiceUriPath(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method public getDibicTvSeriesUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 31
    const-string v0, "getTvSeriesPrograms"

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;->fetchServiceUriPath(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method public getTagsUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 23
    const-string v0, "getTags"

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;->fetchServiceUriPath(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method
