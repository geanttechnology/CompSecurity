.class public Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;
.source "EpisodeBookmarkCache.java"


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

.field private final episode:Lcom/xfinity/playerlib/model/consumable/Watchable;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "bookmarkDAO"    # Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .param p2, "episode"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 20
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->episode:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 21
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 0

    .prologue
    .line 65
    return-void
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 13
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->execute()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public execute()Ljava/util/Map;
    .locals 5
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
    .line 47
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    .line 48
    .local v0, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->episode:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 50
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 51
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->episode:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-virtual {v3, v1, v4}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 54
    .end local v1    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_1
    return-object v0
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 13
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->getCachedResultIfAvailable()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Ljava/util/Map;
    .locals 2
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
    .line 25
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->episode:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v0

    .line 27
    .local v0, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getCachedVideoToBookmarkMapIfAvailable(Ljava/util/Set;)Ljava/util/Map;

    move-result-object v1

    return-object v1
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 13
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->getSecondLevelStaleResultIfAvailable()Ljava/util/Map;

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
    .line 37
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 13
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;->getStaleResultIfAvailable()Ljava/util/Map;

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
    .line 32
    const/4 v0, 0x0

    return-object v0
.end method
