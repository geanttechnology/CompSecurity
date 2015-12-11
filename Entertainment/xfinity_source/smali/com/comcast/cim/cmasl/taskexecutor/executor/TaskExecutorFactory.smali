.class public Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
.super Ljava/lang/Object;
.source "TaskExecutorFactory.java"


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final backgroundExecutorFactory:Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;

.field private final foregroundExecutor:Ljava/util/concurrent/Executor;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;Ljava/util/concurrent/Executor;)V
    .locals 1
    .param p1, "backgroundExecutorFactory"    # Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;
    .param p2, "foregroundExecutor"    # Ljava/util/concurrent/Executor;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const-class v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->LOG:Lorg/slf4j/Logger;

    .line 24
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->backgroundExecutorFactory:Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;

    .line 25
    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->foregroundExecutor:Ljava/util/concurrent/Executor;

    .line 26
    return-void
.end method


# virtual methods
.method public create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT;>;)",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 29
    .local p1, "c":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->backgroundExecutorFactory:Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;->create()Ljava/util/concurrent/Executor;

    move-result-object v0

    .line 30
    .local v0, "backgroundExecutor":Ljava/util/concurrent/Executor;
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->foregroundExecutor:Ljava/util/concurrent/Executor;

    invoke-direct {v1, p1, v0, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    return-object v1
.end method

.method public create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T1:",
            "Ljava/lang/Object;",
            "T2:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT1;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT2;>;)",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<TT1;TT2;>;>;"
        }
    .end annotation

    .prologue
    .line 34
    .local p1, "c1":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT1;>;"
    .local p2, "c2":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT2;>;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->backgroundExecutorFactory:Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;->create()Ljava/util/concurrent/Executor;

    move-result-object v0

    .line 35
    .local v0, "backgroundExecutor":Ljava/util/concurrent/Executor;
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;

    invoke-direct {v1, p1, p2}, Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 36
    .local v1, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TupleTask<TT1;TT2;>;"
    new-instance v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->foregroundExecutor:Ljava/util/concurrent/Executor;

    invoke-direct {v2, v1, v0, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    return-object v2
.end method

.method public create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T1:",
            "Ljava/lang/Object;",
            "T2:",
            "Ljava/lang/Object;",
            "T3:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT1;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT2;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT3;>;)",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<TT1;TT2;TT3;>;>;"
        }
    .end annotation

    .prologue
    .line 40
    .local p1, "c1":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT1;>;"
    .local p2, "c2":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT2;>;"
    .local p3, "c3":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT3;>;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->backgroundExecutorFactory:Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;->create()Ljava/util/concurrent/Executor;

    move-result-object v0

    .line 41
    .local v0, "backgroundExecutor":Ljava/util/concurrent/Executor;
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;

    invoke-direct {v1, p1, p2, p3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 42
    .local v1, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple3Task<TT1;TT2;TT3;>;"
    new-instance v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->foregroundExecutor:Ljava/util/concurrent/Executor;

    invoke-direct {v2, v1, v0, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    return-object v2
.end method

.method public create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 4
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
            ">(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT1;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT2;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT3;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<TT4;>;)",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<TT1;TT2;TT3;TT4;>;>;"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "c1":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT1;>;"
    .local p2, "c2":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT2;>;"
    .local p3, "c3":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT3;>;"
    .local p4, "c4":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<TT4;>;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->backgroundExecutorFactory:Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/utils/executor/ExecutorFactory;->create()Ljava/util/concurrent/Executor;

    move-result-object v0

    .line 47
    .local v0, "backgroundExecutor":Ljava/util/concurrent/Executor;
    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;

    invoke-direct {v1, p1, p2, p3, p4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    .line 48
    .local v1, "combinedCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Tuple4Task<TT1;TT2;TT3;TT4;>;"
    new-instance v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->foregroundExecutor:Ljava/util/concurrent/Executor;

    invoke-direct {v2, v1, v0, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V

    return-object v2
.end method
