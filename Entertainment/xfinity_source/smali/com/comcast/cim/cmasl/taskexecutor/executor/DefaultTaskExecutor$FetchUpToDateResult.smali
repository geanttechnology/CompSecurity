.class Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;
.super Ljava/lang/Object;
.source "DefaultTaskExecutor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FetchUpToDateResult"
.end annotation


# instance fields
.field private final executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;


# direct methods
.method private constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 91
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>.FetchUpToDateResult;"
    .local p2, "executionListener":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<TT;>;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 93
    return-void
.end method

.method synthetic constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;
    .param p2, "x1"    # Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .param p3, "x2"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$1;

    .prologue
    .line 88
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>.FetchUpToDateResult;"
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    return-void
.end method

.method static synthetic access$800(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 96
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>.FetchUpToDateResult;"
    const/4 v0, 0x0

    .line 97
    .local v0, "caughtException":Ljava/lang/RuntimeException;
    const/4 v4, 0x0

    .line 99
    .local v4, "result":Ljava/lang/Object;, "TT;"
    :try_start_0
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v5}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$200(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    move-object v3, v4

    .line 106
    .end local v4    # "result":Ljava/lang/Object;, "TT;"
    .local v3, "finalResult":Ljava/lang/Object;, "TT;"
    .local v3, "result":Ljava/lang/Object;, "TT;"
    :goto_0
    move-object v2, v0

    .line 107
    .local v2, "finalCaughtException":Ljava/lang/RuntimeException;
    iget-object v5, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->foregroundExecutor:Ljava/util/concurrent/Executor;
    invoke-static {v5}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$700(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Ljava/util/concurrent/Executor;

    move-result-object v5

    new-instance v6, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;

    invoke-direct {v6, p0, v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;Ljava/lang/RuntimeException;Ljava/lang/Object;)V

    invoke-interface {v5, v6}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 121
    return-void

    .line 100
    .end local v2    # "finalCaughtException":Ljava/lang/RuntimeException;
    .end local v3    # "result":Ljava/lang/Object;, "TT;"
    .restart local v4    # "result":Ljava/lang/Object;, "TT;"
    :catch_0
    move-exception v1

    .line 101
    .local v1, "e":Ljava/lang/RuntimeException;
    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$300()Lorg/slf4j/Logger;

    move-result-object v5

    const-string v6, "Caught exception while executing task %s"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v9}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$200(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 102
    move-object v0, v1

    move-object v3, v4

    .end local v4    # "result":Ljava/lang/Object;, "TT;"
    .local v3, "result":Ljava/lang/Object;, "TT;"
    goto :goto_0
.end method
