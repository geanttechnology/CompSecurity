.class public Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;
.super Ljava/lang/Object;
.source "CompositeDibicResourceCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/Task;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        ">;"
    }
.end annotation


# instance fields
.field private final caches:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public varargs constructor <init>([Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p1, "caches":[Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "[Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    invoke-static {p1}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    .line 17
    .local v0, "cacheSet":Ljava/util/Set;, "Ljava/util/Set<Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;>;"
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;->caches:Ljava/util/Set;

    .line 18
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 0

    .prologue
    .line 50
    return-void
.end method

.method public execute()Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 4

    .prologue
    .line 35
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    .line 36
    .local v0, "allResources":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;->caches:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 37
    .local v1, "cache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 39
    .end local v1    # "cache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    :cond_0
    new-instance v2, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;

    invoke-direct {v2, v0}, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;-><init>(Ljava/util/Set;)V

    return-object v2
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 11
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;->execute()Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 5

    .prologue
    .line 22
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    .line 23
    .local v0, "allResources":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;->caches:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 24
    .local v1, "cache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 25
    .local v2, "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    if-nez v2, :cond_0

    .line 26
    const/4 v3, 0x0

    .line 30
    .end local v1    # "cache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    .end local v2    # "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    :goto_1
    return-object v3

    .line 28
    .restart local v1    # "cache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    .restart local v2    # "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    :cond_0
    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 30
    .end local v1    # "cache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    .end local v2    # "resource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    :cond_1
    new-instance v3, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;

    invoke-direct {v3, v0}, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResource;-><init>(Ljava/util/Set;)V

    goto :goto_1
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 11
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;->getCachedResultIfAvailable()Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 1

    .prologue
    .line 64
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 11
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;->getSecondLevelStaleResultIfAvailable()Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 11
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;->getStaleResultIfAvailable()Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 54
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/CompositeDibicResourceCache;->caches:Ljava/util/Set;

    invoke-virtual {v0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
