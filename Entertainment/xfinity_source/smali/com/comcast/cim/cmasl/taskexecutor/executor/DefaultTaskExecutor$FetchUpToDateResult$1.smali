.class Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;
.super Ljava/lang/Object;
.source "DefaultTaskExecutor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

.field final synthetic val$finalCaughtException:Ljava/lang/RuntimeException;

.field final synthetic val$finalResult:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;Ljava/lang/RuntimeException;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 107
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->val$finalCaughtException:Ljava/lang/RuntimeException;

    iput-object p3, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->val$finalResult:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 109
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult.1;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    iget-object v0, v0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->pendingListeners:Ljava/util/Set;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$500(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Ljava/util/Set;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->access$800(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$300()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Up to date result fetch from {} completed"

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    iget-object v2, v2, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->task:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;->access$200(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 111
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->val$finalCaughtException:Ljava/lang/RuntimeException;

    if-eqz v0, :cond_2

    .line 112
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->access$800(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->val$finalCaughtException:Ljava/lang/RuntimeException;

    instance-of v0, v0, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->val$finalCaughtException:Ljava/lang/RuntimeException;

    check-cast v0, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    :goto_0
    invoke-interface {v1, v0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    .line 119
    :cond_0
    :goto_1
    return-void

    .line 112
    :cond_1
    new-instance v0, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->val$finalCaughtException:Ljava/lang/RuntimeException;

    invoke-direct {v0, v2}, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;-><init>(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 116
    :cond_2
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->this$1:Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->executionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;->access$800(Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/executor/DefaultTaskExecutor$FetchUpToDateResult$1;->val$finalResult:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onPostExecute(Ljava/lang/Object;)V

    goto :goto_1
.end method
