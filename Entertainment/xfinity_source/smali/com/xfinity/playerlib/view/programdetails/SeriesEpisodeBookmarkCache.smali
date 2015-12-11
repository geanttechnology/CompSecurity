.class public Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;
.source "SeriesEpisodeBookmarkCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask",
        "<",
        "Ljava/util/Map",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
        "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
        ">;>;"
    }
.end annotation


# instance fields
.field private final bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO",
            "<*>;"
        }
    .end annotation
.end field

.field private final tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;)V
    .locals 0
    .param p1, "bookmarkDAO"    # Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .param p2, "tvSeriesFacade"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 24
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .line 25
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 0

    .prologue
    .line 83
    return-void
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->execute()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public execute()Ljava/util/Map;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 60
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v3

    .line 61
    .local v3, "watchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    .line 63
    .local v0, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 64
    .local v2, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_1
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 66
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 67
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    invoke-virtual {v6, v1, v2}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v6

    invoke-interface {v0, v1, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 72
    .end local v1    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v2    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_2
    return-object v0
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->getCachedResultIfAvailable()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Ljava/util/Map;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v3

    .line 31
    .local v3, "watchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 33
    .local v1, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 34
    .local v2, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 35
    .local v0, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 39
    .end local v0    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v2    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    invoke-virtual {v4, v1}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getCachedVideoToBookmarkMapIfAvailable(Ljava/util/Set;)Ljava/util/Map;

    move-result-object v4

    return-object v4
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->getSecondLevelStaleResultIfAvailable()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 50
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->getStaleResultIfAvailable()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 45
    const/4 v0, 0x0

    return-object v0
.end method
