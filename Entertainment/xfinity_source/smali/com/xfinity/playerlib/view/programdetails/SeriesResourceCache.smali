.class public Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;
.source "SeriesResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask",
        "<",
        "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
        ">;"
    }
.end annotation


# instance fields
.field private final dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field private final entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private final seriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation
.end field

.field private final seriesEpisodeBookmarkCache:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;",
            "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p1, "entitlementCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    .local p2, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    .local p3, "dibicResourceCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    .local p4, "seriesEpisodeBookmarkCache":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<*>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 27
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->seriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 28
    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 29
    iput-object p4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->seriesEpisodeBookmarkCache:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 30
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 0

    .prologue
    .line 80
    return-void
.end method

.method public execute()Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    .locals 7

    .prologue
    .line 63
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->seriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v6}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 64
    .local v4, "seriesConsumable":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v6}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 65
    .local v3, "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v6}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 66
    .local v2, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    new-instance v5, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    invoke-direct {v5, v4}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V

    .line 67
    .local v5, "tvSeriesFacade":Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->seriesEpisodeBookmarkCache:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    invoke-direct {v0, v6, v5}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;-><init>(Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;)V

    .line 68
    .local v0, "bookmarkCache":Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->execute()Ljava/util/Map;

    move-result-object v1

    .line 69
    .local v1, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    new-instance v6, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    invoke-direct {v6, v3, v5, v2, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;-><init>(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/model/dibic/DibicResource;Ljava/util/Map;)V

    return-object v6
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->execute()Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 34
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->seriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 35
    .local v4, "seriesConsumable":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->entitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 36
    .local v3, "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v7}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 37
    .local v2, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    if-eqz v4, :cond_0

    if-eqz v3, :cond_0

    if-nez v2, :cond_1

    .line 48
    :cond_0
    :goto_0
    return-object v6

    .line 41
    :cond_1
    new-instance v5, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    invoke-direct {v5, v4}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V

    .line 42
    .local v5, "tvSeriesFacade":Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->seriesEpisodeBookmarkCache:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    invoke-direct {v0, v7, v5}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;-><init>(Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;)V

    .line 43
    .local v0, "bookmarkCache":Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeBookmarkCache;->getCachedResultIfAvailable()Ljava/util/Map;

    move-result-object v1

    .line 44
    .local v1, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    if-eqz v1, :cond_0

    .line 48
    new-instance v6, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    invoke-direct {v6, v3, v5, v2, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;-><init>(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/model/dibic/DibicResource;Ljava/util/Map;)V

    goto :goto_0
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->getCachedResultIfAvailable()Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    .locals 1

    .prologue
    .line 58
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->getSecondLevelStaleResultIfAvailable()Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    .locals 1

    .prologue
    .line 53
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesResourceCache;->getStaleResultIfAvailable()Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    move-result-object v0

    return-object v0
.end method
