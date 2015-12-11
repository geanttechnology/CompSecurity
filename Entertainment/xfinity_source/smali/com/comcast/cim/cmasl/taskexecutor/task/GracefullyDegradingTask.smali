.class public abstract Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;
.super Ljava/lang/Object;
.source "GracefullyDegradingTask.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/Task;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final delegateTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 7
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask<TT;>;"
    .local p1, "delegateTask":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;->delegateTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 9
    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 1

    .prologue
    .line 47
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;->delegateTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 48
    return-void
.end method

.method public execute()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask<TT;>;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;->delegateTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 20
    :goto_0
    return-object v1

    .line 18
    :catch_0
    move-exception v0

    .line 19
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;->handleException(Ljava/lang/Throwable;)V

    .line 20
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;->getDefaultValue()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 12
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;->delegateTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getDefaultValue()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method public getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;->delegateTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/task/GracefullyDegradingTask;->delegateTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getStaleResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected abstract handleException(Ljava/lang/Throwable;)V
.end method
