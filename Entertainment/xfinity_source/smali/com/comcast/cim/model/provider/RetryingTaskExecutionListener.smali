.class public abstract Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "RetryingTaskExecutionListener.java"


# annotations
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
.field private cancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field private final context:Landroid/content/Context;

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private final provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "errorDialogFactory"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;",
            "Landroid/content/Context;",
            "Lcom/comcast/cim/android/view/common/ErrorDialogFactory;",
            ")V"
        }
    .end annotation

    .prologue
    .line 19
    .local p0, "this":Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;, "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener<TT;>;"
    .local p1, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<TT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 21
    iput-object p2, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->context:Landroid/content/Context;

    .line 22
    iput-object p3, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 23
    return-void
.end method

.method protected constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "errorDialogFactory"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .param p4, "cancelListener"    # Landroid/content/DialogInterface$OnCancelListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;",
            "Landroid/content/Context;",
            "Lcom/comcast/cim/android/view/common/ErrorDialogFactory;",
            "Landroid/content/DialogInterface$OnCancelListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 28
    .local p0, "this":Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;, "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener<TT;>;"
    .local p1, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<TT;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V

    .line 29
    iput-object p4, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->cancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;

    .prologue
    .line 12
    iget-object v0, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 3
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;, "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener<TT;>;"
    iget-object v1, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    new-instance v2, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;

    invoke-direct {v2, p0}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener$1;-><init>(Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;)V

    invoke-virtual {v1, p1, v2}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    .line 41
    .local v0, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    iget-object v1, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->cancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 42
    iget-object v1, p0, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->context:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "caldialogfragment"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 43
    return-void
.end method
