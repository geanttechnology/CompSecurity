.class public Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;
.source "FeaturedResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask",
        "<",
        "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
        ">;"
    }
.end annotation


# instance fields
.field private final movieAndSeriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private final videoCoverCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 12
    .local p1, "movieAndSeriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;>;"
    .local p2, "videoCoverCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->movieAndSeriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 14
    iput-object p2, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->videoCoverCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 15
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 0

    .prologue
    .line 51
    return-void
.end method

.method public execute()Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    .locals 3

    .prologue
    .line 40
    new-instance v2, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->movieAndSeriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->videoCoverCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;

    invoke-direct {v2, v0, v1}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;-><init>(Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;)V

    return-object v2
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 7
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->execute()Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    .locals 4

    .prologue
    .line 19
    const/4 v1, 0x0

    .line 20
    .local v1, "resource":Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->movieAndSeriesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    .line 21
    .local v0, "moviesAndSeriesResource":Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->videoCoverCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;

    .line 22
    .local v2, "videoCoverResource":Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;
    if-eqz v0, :cond_0

    if-eqz v2, :cond_0

    .line 23
    new-instance v1, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    .end local v1    # "resource":Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    invoke-direct {v1, v0, v2}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;-><init>(Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;)V

    .line 25
    .restart local v1    # "resource":Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    :cond_0
    return-object v1
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 7
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->getCachedResultIfAvailable()Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 7
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->getSecondLevelStaleResultIfAvailable()Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 7
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/editorial/FeaturedResourceCache;->getStaleResultIfAvailable()Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    move-result-object v0

    return-object v0
.end method
