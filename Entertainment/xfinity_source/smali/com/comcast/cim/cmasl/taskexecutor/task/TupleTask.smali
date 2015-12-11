.class public Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;
.super Ljava/lang/Object;
.source "TupleTask.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/Task;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T1:",
        "Ljava/lang/Object;",
        "T2:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<TT1;TT2;>;>;"
    }
.end annotation


# instance fields
.field private final c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT1;>;"
        }
    .end annotation
.end field

.field private final c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT2;>;"
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
            "<TT1;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT2;>;)V"
        }
    .end annotation

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    .local p1, "c1":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT1;>;"
    .local p2, "c2":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT2;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 11
    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 12
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 1

    .prologue
    .line 60
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 61
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 62
    return-void
.end method

.method public execute()Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TT1;TT2;>;"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    new-instance v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TT1;TT2;>;"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    const/4 v2, 0x0

    .line 17
    .local v2, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 18
    .local v0, "cachedR1":Ljava/lang/Object;, "TT1;"
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 19
    .local v1, "cachedR2":Ljava/lang/Object;, "TT2;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 20
    new-instance v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .end local v2    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    invoke-direct {v2, v0, v1}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 22
    .restart local v2    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    :cond_0
    return-object v2
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->getCachedResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TT1;TT2;>;"
        }
    .end annotation

    .prologue
    .line 38
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    const/4 v2, 0x0

    .line 39
    .local v2, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 40
    .local v0, "r1":Ljava/lang/Object;, "TT1;"
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 41
    .local v1, "r2":Ljava/lang/Object;, "TT2;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 42
    new-instance v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .end local v2    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    invoke-direct {v2, v0, v1}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 44
    .restart local v2    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    :cond_0
    return-object v2
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->getSecondLevelStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TT1;TT2;>;"
        }
    .end annotation

    .prologue
    .line 27
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    const/4 v2, 0x0

    .line 28
    .local v2, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 29
    .local v0, "r1":Ljava/lang/Object;, "TT1;"
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 30
    .local v1, "r2":Ljava/lang/Object;, "TT2;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 31
    new-instance v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .end local v2    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    invoke-direct {v2, v0, v1}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 33
    .restart local v2    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    :cond_0
    return-object v2
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->getStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 66
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
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

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

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
