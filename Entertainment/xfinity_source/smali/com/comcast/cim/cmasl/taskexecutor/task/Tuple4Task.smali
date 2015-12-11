.class public Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;
.super Ljava/lang/Object;
.source "Tuple4Task.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/Task;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T1:",
        "Ljava/lang/Object;",
        "T2:",
        "Ljava/lang/Object;",
        "T3:",
        "Ljava/lang/Object;",
        "T4:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
        "<TT1;TT2;TT3;TT4;>;>;"
    }
.end annotation


# instance fields
.field private c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT1;>;"
        }
    .end annotation
.end field

.field private c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT2;>;"
        }
    .end annotation
.end field

.field private c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT3;>;"
        }
    .end annotation
.end field

.field private c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT4;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT1;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT2;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT3;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT4;>;)V"
        }
    .end annotation

    .prologue
    .line 12
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    .local p1, "c1":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT1;>;"
    .local p2, "c2":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT2;>;"
    .local p3, "c3":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT3;>;"
    .local p4, "c4":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT4;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 14
    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 15
    iput-object p3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 16
    iput-object p4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 17
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 1

    .prologue
    .line 73
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 74
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 75
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 76
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 77
    return-void
.end method

.method public execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<TT1;TT2;TT3;TT4;>;"
        }
    .end annotation

    .prologue
    .line 60
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    new-instance v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/cim/cmasl/utils/container/Tuple4;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<TT1;TT2;TT3;TT4;>;"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    const/4 v4, 0x0

    .line 22
    .local v4, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 23
    .local v0, "cachedR1":Ljava/lang/Object;, "TT1;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 24
    .local v1, "cachedR2":Ljava/lang/Object;, "TT2;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    .line 25
    .local v2, "cachedR3":Ljava/lang/Object;, "TT3;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v3

    .line 26
    .local v3, "cachedR4":Ljava/lang/Object;, "TT4;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    if-eqz v3, :cond_0

    .line 27
    new-instance v4, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    .end local v4    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    invoke-direct {v4, v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/utils/container/Tuple4;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 29
    .restart local v4    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    :cond_0
    return-object v4
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->getCachedResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<TT1;TT2;TT3;TT4;>;"
        }
    .end annotation

    .prologue
    .line 47
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    const/4 v4, 0x0

    .line 48
    .local v4, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 49
    .local v0, "r1":Ljava/lang/Object;, "TT1;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 50
    .local v1, "r2":Ljava/lang/Object;, "TT2;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    .line 51
    .local v2, "r3":Ljava/lang/Object;, "TT3;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v3

    .line 52
    .local v3, "r4":Ljava/lang/Object;, "TT4;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    if-eqz v3, :cond_0

    .line 53
    new-instance v4, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    .end local v4    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    invoke-direct {v4, v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/utils/container/Tuple4;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 55
    .restart local v4    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    :cond_0
    return-object v4
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->getSecondLevelStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<TT1;TT2;TT3;TT4;>;"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    const/4 v4, 0x0

    .line 35
    .local v4, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 36
    .local v0, "r1":Ljava/lang/Object;, "TT1;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 37
    .local v1, "r2":Ljava/lang/Object;, "TT2;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    .line 38
    .local v2, "r3":Ljava/lang/Object;, "TT3;"
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v3

    .line 39
    .local v3, "r4":Ljava/lang/Object;, "TT4;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    if-eqz v3, :cond_0

    .line 40
    new-instance v4, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    .end local v4    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    invoke-direct {v4, v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/utils/container/Tuple4;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 42
    .restart local v4    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    :cond_0
    return-object v4
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->getStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 81
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;->c4:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
