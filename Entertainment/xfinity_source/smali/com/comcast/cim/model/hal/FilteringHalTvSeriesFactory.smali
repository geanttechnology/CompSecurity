.class public Lcom/comcast/cim/model/hal/FilteringHalTvSeriesFactory;
.super Lcom/comcast/cim/model/hal/HalTvSeriesFactory;
.source "FilteringHalTvSeriesFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/model/hal/HalTvSeriesFactory",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final videoFilter:Lcom/comcast/cim/model/hal/HalVideoFilter;


# virtual methods
.method public bridge synthetic createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;
    .locals 1

    .prologue
    .line 13
    .local p0, "this":Lcom/comcast/cim/model/hal/FilteringHalTvSeriesFactory;, "Lcom/comcast/cim/model/hal/FilteringHalTvSeriesFactory<TT;>;"
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/model/hal/FilteringHalTvSeriesFactory;->createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    move-result-object v0

    return-object v0
.end method

.method public createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    .locals 10
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;)",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/model/hal/FilteringHalTvSeriesFactory;, "Lcom/comcast/cim/model/hal/FilteringHalTvSeriesFactory<TT;>;"
    .local p2, "halHttpClient":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/model/hal/HalTvSeriesFactory;->createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 25
    .local v4, "halObject":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getSeasons()Ljava/util/List;

    move-result-object v7

    .line 26
    .local v7, "seasons":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;>;"
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 27
    .local v6, "seasonIter":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 28
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 29
    .local v5, "season":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getEpisodes()Ljava/util/List;

    move-result-object v2

    .line 30
    .local v2, "episodes":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 31
    .local v1, "episodeIter":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 32
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 33
    .local v0, "episode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    iget-object v8, p0, Lcom/comcast/cim/model/hal/FilteringHalTvSeriesFactory;->videoFilter:Lcom/comcast/cim/model/hal/HalVideoFilter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getVideos()Ljava/util/List;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/comcast/cim/model/hal/HalVideoFilter;->filter(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    .line 34
    .local v3, "filteredVideos":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;>;"
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v8

    if-nez v8, :cond_1

    .line 35
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_1

    .line 37
    :cond_1
    invoke-virtual {v0, v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->setVideos(Ljava/util/List;)V

    goto :goto_1

    .line 41
    .end local v0    # "episode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .end local v3    # "filteredVideos":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;>;"
    :cond_2
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v8

    if-nez v8, :cond_0

    .line 42
    invoke-interface {v6}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 46
    .end local v1    # "episodeIter":Ljava/util/Iterator;
    .end local v2    # "episodes":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;>;"
    .end local v5    # "season":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    :cond_3
    return-object v4
.end method
