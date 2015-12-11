.class abstract Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "RetryingExecutionListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method protected constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 971
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<TT;>;"
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<TT;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    .line 972
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 973
    return-void
.end method

.method static synthetic access$4700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;

    .prologue
    .line 967
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 4
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 978
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;

    invoke-direct {v1, p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    const-string v2, "RetryingTaskExecutionListener"

    const/4 v3, 0x0

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V
    invoke-static {v0, v1, v2, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V

    .line 1001
    return-void
.end method
