.class public Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;
.super Ljava/lang/Object;
.source "CachingLiveStreamBookmarkDAO.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;"
    }
.end annotation


# instance fields
.field private final cache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
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

.field private final delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

.field private final revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TV;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;I)V
    .locals 1
    .param p1, "delegate"    # Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .param p3, "cacheSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<TV;>;I)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    .local p2, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 24
    iput-object p2, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    .line 25
    new-instance v0, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;

    invoke-direct {v0, p3}, Lcom/comcast/cim/cmasl/utils/collections/LruLinkedHashMap;-><init>(I)V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    .line 26
    return-void
.end method

.method private addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    .locals 3
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .prologue
    .line 187
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    monitor-enter v1

    .line 188
    :try_start_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->validateCache()Z

    move-result v0

    if-nez v0, :cond_0

    .line 189
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 191
    :cond_0
    monitor-exit v1

    .line 192
    return-void

    .line 191
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private deleteCachedFavorite(Ljava/lang/String;)V
    .locals 3
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 152
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    monitor-enter v2

    .line 153
    :try_start_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->validateCache()Z

    move-result v1

    if-nez v1, :cond_0

    .line 154
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 155
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-eqz v0, :cond_0

    .line 156
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v1

    if-nez v1, :cond_1

    .line 157
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_0
    :goto_0
    monitor-exit v2

    .line 164
    return-void

    .line 159
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_1
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->setIsFavorite(Z)V

    goto :goto_0

    .line 163
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private deleteCachedHistoryItem(Ljava/lang/String;)V
    .locals 4
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 167
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    monitor-enter v2

    .line 168
    :try_start_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->validateCache()Z

    move-result v1

    if-nez v1, :cond_0

    .line 169
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 170
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isFavorite()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 171
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 176
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_0
    :goto_0
    monitor-exit v2

    .line 177
    return-void

    .line 173
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 176
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private validateCache()Z
    .locals 3

    .prologue
    .line 195
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    const/4 v0, 0x0

    .line 196
    .local v0, "builtNewCache":Z
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cacheVersion:Ljava/lang/Object;

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->shouldRevalidate(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 197
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    .line 198
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->revalidationPolicy:Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;->getCurrentVersion()Ljava/lang/Object;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cacheVersion:Ljava/lang/Object;

    .line 201
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 202
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getBookmarks()Ljava/util/Map;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 203
    const/4 v0, 0x1

    .line 206
    :cond_1
    return v0
.end method


# virtual methods
.method public addFavorite(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 105
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v1, p1}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->addFavorite(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v0

    .line 106
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-eqz v0, :cond_0

    .line 107
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    .line 110
    :cond_0
    return-object v0
.end method

.method public deleteFavorite(Ljava/lang/String;)Z
    .locals 2
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 115
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v1, p1}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->deleteFavorite(Ljava/lang/String;)Z

    move-result v0

    .line 116
    .local v0, "success":Z
    if-eqz v0, :cond_0

    .line 117
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->deleteCachedFavorite(Ljava/lang/String;)V

    .line 119
    :cond_0
    return v0
.end method

.method public getBookmarks()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getBookmarks()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method protected getCachedBookmark(Ljava/lang/String;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 2
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 180
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    monitor-enter v1

    .line 181
    :try_start_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->validateCache()Z

    .line 182
    iget-object v0, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    monitor-exit v1

    return-object v0

    .line 183
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getFavorites()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 124
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 125
    .local v1, "favorites":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    monitor-enter v3

    .line 126
    :try_start_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->validateCache()Z

    .line 127
    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 128
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isFavorite()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 129
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 132
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 134
    return-object v1
.end method

.method public getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 2

    .prologue
    .line 35
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v0

    .line 36
    .local v0, "lastWatchedBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-eqz v0, :cond_0

    .line 37
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    .line 39
    :cond_0
    return-object v0
.end method

.method public getOrCreateBookmarkWithLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Z)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "asRecent"    # Z

    .prologue
    .line 64
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->getCachedBookmark(Ljava/lang/String;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v0

    .line 65
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    if-nez v0, :cond_1

    .line 66
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v1, p1, p2}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getOrCreateBookmarkWithLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Z)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    move-result-object v0

    .line 68
    if-eqz v0, :cond_0

    .line 69
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    .line 74
    :cond_0
    :goto_0
    return-object v0

    .line 71
    :cond_1
    if-eqz p2, :cond_0

    .line 72
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->setTimestamp(Ljava/util/Date;)V

    goto :goto_0
.end method

.method public getRecentBookmarks()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 50
    .local v1, "recentBookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    monitor-enter v3

    .line 51
    :try_start_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->validateCache()Z

    .line 52
    iget-object v2, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->cache:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 53
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTimestamp()Ljava/util/Date;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 54
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 57
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 59
    return-object v1
.end method

.method public removeHistoryItem(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z
    .locals 2
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .prologue
    .line 95
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v1, p1}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->removeHistoryItem(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z

    move-result v0

    .line 96
    .local v0, "success":Z
    if-eqz v0, :cond_0

    .line 97
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->deleteCachedHistoryItem(Ljava/lang/String;)V

    .line 100
    :cond_0
    return v0
.end method

.method public saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z
    .locals 2
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .param p2, "updateTimeStamp"    # Z

    .prologue
    .line 79
    .local p0, "this":Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;, "Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO<TV;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->delegate:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-interface {v1, p1, p2}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z

    move-result v0

    .line 80
    .local v0, "success":Z
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/database/CachingLiveStreamBookmarkDAO;->addBookmarkToCache(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    .line 82
    return v0
.end method
