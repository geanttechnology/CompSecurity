.class public Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
.super Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
.source "HalTvSeriesConsumable.java"


# instance fields
.field seasons:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;-><init>()V

    .line 12
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 77
    if-ne p0, p1, :cond_1

    .line 94
    :cond_0
    :goto_0
    return v1

    .line 80
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 81
    goto :goto_0

    .line 83
    :cond_3
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 84
    goto :goto_0

    :cond_4
    move-object v0, p1

    .line 87
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 90
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 91
    goto :goto_0
.end method

.method public findEpisodeByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .locals 5
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 52
    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 53
    .local v1, "nextSeason":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getEpisodes()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 54
    .local v0, "nextEpisode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {v4, p1}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 60
    .end local v0    # "nextEpisode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .end local v1    # "nextSeason":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    :goto_0
    return-object v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public findEpisodeByVideoId(J)Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .locals 9
    .param p1, "videoId"    # J

    .prologue
    .line 38
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 39
    .local v1, "nextSeason":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getEpisodes()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 40
    .local v0, "nextEpisode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getVideos()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    .line 41
    .local v2, "nextVideo":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;->getVideoId()J

    move-result-wide v6

    cmp-long v6, v6, p1

    if-nez v6, :cond_2

    .line 48
    .end local v0    # "nextEpisode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .end local v1    # "nextSeason":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    .end local v2    # "nextVideo":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    :goto_0
    return-object v0

    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public findSeasonForEpisode(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;)Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    .locals 6
    .param p1, "episodeEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .prologue
    .line 64
    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 65
    .local v1, "nextSeason":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getEpisodes()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 66
    .local v0, "nextEpisode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 72
    .end local v0    # "nextEpisode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .end local v1    # "nextSeason":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    :goto_0
    return-object v1

    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    return-object v0
.end method

.method public getSeasons()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 99
    invoke-super {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->hashCode()I

    move-result v0

    .line 100
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 101
    return v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 5
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 16
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 18
    const-string v3, "season"

    invoke-virtual {p1, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 19
    .local v2, "seasonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v2, :cond_0

    .line 20
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 21
    .local v0, "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v1, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    invoke-direct {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;-><init>()V

    .line 22
    .local v1, "nextSeason":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 23
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->seasons:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 26
    .end local v0    # "item":Lcom/comcast/cim/microdata/model/MicrodataItem;
    .end local v1    # "nextSeason":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    :cond_0
    return-void
.end method
