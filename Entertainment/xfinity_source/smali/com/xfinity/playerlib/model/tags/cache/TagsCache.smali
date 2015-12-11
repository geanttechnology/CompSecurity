.class public abstract Lcom/xfinity/playerlib/model/tags/cache/TagsCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask;
.source "TagsCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/BaseTask",
        "<",
        "Ljava/util/List",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field private final tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;"
        }
    .end annotation
.end field


# virtual methods
.method public clearCachedResult()V
    .locals 0

    .prologue
    .line 48
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    return-void
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/cache/TagsCache;->execute()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public execute()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 27
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsCache;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/tags/cache/TagsCache;->getList(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/cache/TagsCache;->getCachedResultIfAvailable()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsCache;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 22
    .local v0, "tagsRoot":Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    if-nez v0, :cond_0

    const/4 v1, 0x0

    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/tags/cache/TagsCache;->getList(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;

    move-result-object v1

    goto :goto_0
.end method

.method protected abstract getList(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/cache/TagsCache;->getSecondLevelStaleResultIfAvailable()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 37
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/cache/TagsCache;->getStaleResultIfAvailable()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 32
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsCache<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method
