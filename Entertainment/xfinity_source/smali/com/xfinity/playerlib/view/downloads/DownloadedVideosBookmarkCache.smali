.class public Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;
.source "DownloadedVideosBookmarkCache.java"


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

.field private final videos:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;Ljava/util/Map;)V
    .locals 0
    .param p1, "bookmarkDAO"    # Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 17
    .local p2, "videos":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 19
    iput-object p2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->videos:Ljava/util/Map;

    .line 20
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 0

    .prologue
    .line 59
    return-void
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->execute()Ljava/util/Map;

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
    .line 39
    new-instance v0, Ljava/util/HashMap;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->videos:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    invoke-direct {v0, v2}, Ljava/util/HashMap;-><init>(I)V

    .line 41
    .local v0, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->videos:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 43
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 44
    iget-object v4, p0, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->videos:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-virtual {v4, v1, v2}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 48
    .end local v1    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_1
    return-object v0
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->getCachedResultIfAvailable()Ljava/util/Map;

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
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->videos:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getCachedVideoToBookmarkMapIfAvailable(Ljava/util/Set;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->getSecondLevelStaleResultIfAvailable()Ljava/util/Map;

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
    .line 34
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 12
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;->getStaleResultIfAvailable()Ljava/util/Map;

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
    .line 29
    const/4 v0, 0x0

    return-object v0
.end method
