.class Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;
.super Ljava/lang/Object;
.source "RetryingTaskExecutionListener.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;


# direct methods
.method constructor <init>(Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;, "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;"
    iput-object p1, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;->this$0:Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public tryAgain()V
    .locals 2

    .prologue
    .line 37
    .local p0, "this":Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;, "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;"
    iget-object v0, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;->this$0:Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;

    # getter for: Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    invoke-static {v0}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->access$000(Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;->this$0:Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 38
    return-void
.end method
