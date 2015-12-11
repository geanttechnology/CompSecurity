.class public Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;
.super Ljava/lang/Object;
.source "Tuple3Task.java"

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
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
        "<TT1;TT2;TT3;>;>;"
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

.field private final c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT3;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT1;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT2;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT3;>;)V"
        }
    .end annotation

    .prologue
    .line 10
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    .local p1, "c1":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT1;>;"
    .local p2, "c2":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT2;>;"
    .local p3, "c3":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT3;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 12
    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 13
    iput-object p3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 14
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 1

    .prologue
    .line 66
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 67
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 68
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 69
    return-void
.end method

.method public execute()Lcom/comcast/cim/cmasl/utils/container/Tuple3;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<TT1;TT2;TT3;>;"
        }
    .end annotation

    .prologue
    .line 54
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    new-instance v0, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/cmasl/utils/container/Tuple3;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple3;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<TT1;TT2;TT3;>;"
        }
    .end annotation

    .prologue
    .line 18
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    const/4 v3, 0x0

    .line 19
    .local v3, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 20
    .local v0, "cachedR1":Ljava/lang/Object;, "TT1;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 21
    .local v1, "cachedR2":Ljava/lang/Object;, "TT2;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    .line 22
    .local v2, "cachedR3":Ljava/lang/Object;, "TT3;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    .line 23
    new-instance v3, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    .end local v3    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    invoke-direct {v3, v0, v1, v2}, Lcom/comcast/cim/cmasl/utils/container/Tuple3;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 25
    .restart local v3    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    :cond_0
    return-object v3
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->getCachedResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple3;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<TT1;TT2;TT3;>;"
        }
    .end annotation

    .prologue
    .line 42
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    const/4 v3, 0x0

    .line 43
    .local v3, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 44
    .local v0, "r1":Ljava/lang/Object;, "TT1;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 45
    .local v1, "r2":Ljava/lang/Object;, "TT2;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    .line 46
    .local v2, "r3":Ljava/lang/Object;, "TT3;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    .line 47
    new-instance v3, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    .end local v3    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    invoke-direct {v3, v0, v1, v2}, Lcom/comcast/cim/cmasl/utils/container/Tuple3;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 49
    .restart local v3    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    :cond_0
    return-object v3
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->getSecondLevelStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple3;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<TT1;TT2;TT3;>;"
        }
    .end annotation

    .prologue
    .line 30
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    const/4 v3, 0x0

    .line 31
    .local v3, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    .line 32
    .local v0, "r1":Ljava/lang/Object;, "TT1;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    .line 33
    .local v1, "r2":Ljava/lang/Object;, "TT2;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    .line 34
    .local v2, "r3":Ljava/lang/Object;, "TT3;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    .line 35
    new-instance v3, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    .end local v3    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    invoke-direct {v3, v0, v1, v2}, Lcom/comcast/cim/cmasl/utils/container/Tuple3;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 37
    .restart local v3    # "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<TT1;TT2;TT3;>;"
    :cond_0
    return-object v3
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->getStaleResultIfAvailable()Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 73
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
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

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c1:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c2:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;->c3:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

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
