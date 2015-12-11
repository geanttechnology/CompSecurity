.class public Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
.super Ljava/lang/Object;
.source "TvSeriesFacade.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/Program;
.implements Ljava/io/Serializable;


# instance fields
.field private final allEpisodes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;",
            ">;"
        }
    .end annotation
.end field

.field private final allWatchables:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;",
            ">;"
        }
    .end annotation
.end field

.field private final seasonNumberToEpisodeMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;",
            ">;>;"
        }
    .end annotation
.end field

.field private final tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V
    .locals 12
    .param p1, "tvSeriesEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 28
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 29
    invoke-static {}, Ljava/util/Collections;->reverseOrder()Ljava/util/Comparator;

    move-result-object v8

    invoke-static {v8}, Lcom/google/common/collect/Maps;->newTreeMap(Ljava/util/Comparator;)Ljava/util/TreeMap;

    move-result-object v7

    .line 30
    .local v7, "seasonNumberToEpisodeMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 31
    .local v0, "allEpisodes":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 32
    .local v1, "allWatchables":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getSeasons()Ljava/util/List;

    move-result-object v6

    .line 33
    .local v6, "seasonEntries":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;>;"
    if-eqz v6, :cond_3

    .line 34
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 35
    .local v5, "season":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getEpisodes()Ljava/util/List;

    move-result-object v3

    .line 36
    .local v3, "episodeEntries":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;>;"
    if-eqz v3, :cond_0

    .line 37
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_1
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 38
    .local v2, "episode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getVideos()Ljava/util/List;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v8

    if-lez v8, :cond_1

    .line 39
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getSeasonNumber()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 40
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getSeasonNumber()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v7, v8, v11}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    :cond_2
    new-instance v4, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    invoke-direct {v4, v2, p1}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V

    .line 44
    .local v4, "episodeFacade":Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getSeasonNumber()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-interface {v8, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 45
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 46
    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 52
    .end local v2    # "episode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .end local v3    # "episodeEntries":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;>;"
    .end local v4    # "episodeFacade":Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;
    .end local v5    # "season":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    :cond_3
    invoke-static {v7}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v8

    iput-object v8, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->seasonNumberToEpisodeMap:Ljava/util/Map;

    .line 53
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v8

    iput-object v8, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->allEpisodes:Ljava/util/List;

    .line 54
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v8

    iput-object v8, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->allWatchables:Ljava/util/List;

    .line 55
    return-void
.end method


# virtual methods
.method public findEpisodeById(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;
    .locals 3
    .param p1, "episodeId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 58
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->allEpisodes:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    .line 59
    .local v0, "episodeFacade":Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 64
    .end local v0    # "episodeFacade":Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public findWatchableByVideoId(J)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .locals 5
    .param p1, "videoId"    # J

    .prologue
    .line 68
    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->allWatchables:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 69
    .local v1, "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    invoke-interface {v1, p1, p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v0

    .line 70
    .local v0, "videoById":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    if-eqz v0, :cond_0

    .line 74
    .end local v0    # "videoById":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v1    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getAllEpisodeFacades()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 78
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->allWatchables:Ljava/util/List;

    return-object v0
.end method

.method public getCast()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->castListAsString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getDescription()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    return-object v0
.end method

.method public getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getReviews()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalReview;",
            ">;"
        }
    .end annotation

    .prologue
    .line 119
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getReviews()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSeasonNumberToEpisodeMap()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->seasonNumberToEpisodeMap:Ljava/util/Map;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isMovie()Z
    .locals 1

    .prologue
    .line 107
    const/4 v0, 0x0

    return v0
.end method
