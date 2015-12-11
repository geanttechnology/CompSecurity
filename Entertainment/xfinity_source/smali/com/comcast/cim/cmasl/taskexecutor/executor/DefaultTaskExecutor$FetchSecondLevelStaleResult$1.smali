.class Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;
.super Ljava/lang/Object;
.source "DefaultTaskExecutor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

.field final synthetic val$finalResult:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 70
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->val$finalResult:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 72
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult.1;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    iget-object v0, v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->pendingListeners:Ljava/util/Set;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$500(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Ljava/util/Set;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->access$400(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->val$finalResult:Ljava/lang/Object;

    if-eqz v0, :cond_1

    .line 74
    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$300()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Calling listener with second level stale result from {}"

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    iget-object v2, v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$200(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 75
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->access$400(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->val$finalResult:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onStaleResultAvailable(Ljava/lang/Object;)V

    .line 79
    :goto_0
    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$300()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Second level stale result fetch complete, fetching up to date result from {}"

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    iget-object v2, v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$200(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 80
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->access$400(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onPreAsynchronousExecute()V

    .line 81
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    iget-object v0, v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->backgroundExecutor:Ljava/util/concurrent/Executor;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$600(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    iget-object v2, v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    iget-object v3, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->access$400(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {v1, v2, v3, v4}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$1;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 83
    :cond_0
    return-void

    .line 77
    :cond_1
    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$300()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Second level stale result not available from {}"

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;

    iget-object v2, v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchSecondLevelStaleResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$200(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
