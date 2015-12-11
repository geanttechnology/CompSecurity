.class public Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
.super Ljava/lang/Object;
.source "CachingVideoBookmarkDAO.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;"
    }
.end annotation


# instance fields
.field private final cache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/BookmarkId;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation
.end field

.field private cacheVersion:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TV;"
        }
    .end annotation
.end field

.field private final delegate:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

.field private final revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TV;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;I)V
    .locals 1
    .param p1, "delegate"    # Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;
    .param p3, "cacheSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TV;>;I)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    .local p2, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    .line 26
    iput-object p2, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    .line 27
    new-instance v0, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    invoke-direct {v0, p3}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;-><init>(I)V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cache:Ljava/util/Map;

    .line 28
    return-void
.end method

.method private addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 3
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 129
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cache:Ljava/util/Map;

    monitor-enter v1

    .line 130
    :try_start_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->clearCacheIfInvalid()V

    .line 131
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cache:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getId()Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    monitor-exit v1

    .line 133
    return-void

    .line 132
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private clearCacheIfInvalid()V
    .locals 2

    .prologue
    .line 136
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cacheVersion:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->shouldRevalidate(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 138
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->getCurrentVersion()Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cacheVersion:Ljava/lang/Object;

    .line 140
    :cond_0
    return-void
.end method


# virtual methods
.method public deleteBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Z
    .locals 2
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 84
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cache:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getId()Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->deleteBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Z

    move-result v0

    return v0
.end method

.method protected getCachedBookmarkIfAvailable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .locals 3
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 117
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cache:Ljava/util/Map;

    monitor-enter v1

    .line 119
    :try_start_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 120
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->clearCacheIfInvalid()V

    .line 121
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->cache:Ljava/util/Map;

    new-instance v2, Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    invoke-direct {v2, p1}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;-><init>(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    monitor-exit v1

    .line 123
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 125
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getCachedVideoToBookmarkMapIfAvailable(Ljava/util/Set;)Ljava/util/Map;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;)",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 105
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    .local p1, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    .line 106
    .local v0, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 107
    .local v2, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getCachedBookmarkIfAvailable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v1

    .line 108
    .local v1, "cachedBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    if-nez v1, :cond_1

    .line 109
    const/4 v0, 0x0

    .line 113
    .end local v0    # "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    .end local v1    # "cachedBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .end local v2    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_0
    return-object v0

    .line 111
    .restart local v0    # "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    .restart local v1    # "cachedBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .restart local v2    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_1
    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .locals 2

    .prologue
    .line 32
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v0

    .line 33
    .local v0, "lastWatchedBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    if-eqz v0, :cond_0

    .line 34
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 36
    :cond_0
    return-object v0
.end method

.method public getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 62
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getCachedBookmarkIfAvailable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v0

    .line 63
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    if-nez v0, :cond_0

    .line 64
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v1, p1, p2}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move-result-object v0

    .line 65
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 67
    :cond_0
    return-object v0
.end method

.method public getRecentBookmarks()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 41
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->getRecentBookmarks()Ljava/util/List;

    move-result-object v1

    .line 42
    .local v1, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 43
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    goto :goto_0

    .line 45
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_0
    return-object v1
.end method

.method public saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 1
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 78
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 79
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 80
    return-void
.end method

.method public updateLastTrackedMilestones()V
    .locals 1

    .prologue
    .line 96
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO<TV;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->updateLastTrackedMilestones()V

    .line 97
    return-void
.end method
