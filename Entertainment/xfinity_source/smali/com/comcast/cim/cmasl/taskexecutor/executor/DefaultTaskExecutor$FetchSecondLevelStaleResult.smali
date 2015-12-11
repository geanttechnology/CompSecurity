.class Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;
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
    name = "FetchSecondLevelStaleResult"
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
    .line 57
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>.FetchSecondLevelStaleResult;"
    .local p2, "executionListener":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<TT;>;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 59
    return-void
.end method

.method synthetic constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;
    .param p2, "x1"    # Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .param p3, "x2"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$1;

    .prologue
    .line 54
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>.FetchSecondLevelStaleResult;"
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    return-void
.end method

.method static synthetic access$400(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 62
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor<TT;>.FetchSecondLevelStaleResult;"
    const/4 v2, 0x0

    .line 64
    .local v2, "result":Ljava/lang/Object;, "TT;"
    :try_start_0
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$200(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    move-object v1, v2

    .line 70
    .end local v2    # "result":Ljava/lang/Object;, "TT;"
    .local v1, "finalResult":Ljava/lang/Object;, "TT;"
    .local v1, "result":Ljava/lang/Object;, "TT;"
    :goto_0
    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->foregroundExecutor:Ljava/util/concurrent/Executor;
    invoke-static {v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$700(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Ljava/util/concurrent/Executor;

    move-result-object v3

    new-instance v4, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;

    invoke-direct {v4, p0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;Ljava/lang/Object;)V

    invoke-interface {v3, v4}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 85
    return-void

    .line 65
    .end local v1    # "result":Ljava/lang/Object;, "TT;"
    .restart local v2    # "result":Ljava/lang/Object;, "TT;"
    :catch_0
    move-exception v0

    .line 66
    .local v0, "e":Ljava/lang/RuntimeException;
    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$300()Lorg/slf4j/Logger;

    move-result-object v3

    const-string v4, "Caught exception while retrieving second level stale result, ignoring"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v1, v2

    .end local v2    # "result":Ljava/lang/Object;, "TT;"
    .local v1, "result":Ljava/lang/Object;, "TT;"
    goto :goto_0
.end method
