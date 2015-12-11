.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/android/view/common/CALDialogFragment;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;

.field final synthetic val$exception:Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;

    .prologue
    .line 978
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;->val$exception:Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .locals 5

    .prologue
    .line 981
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;->val$exception:Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v1

    .line 982
    .local v1, "formattedError":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;->val$exception:Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    new-instance v4, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1$1;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;)V

    invoke-virtual {v2, v3, v1, v4}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    .line 996
    .local v0, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 998
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 978
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener$1;->get()Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    return-object v0
.end method
