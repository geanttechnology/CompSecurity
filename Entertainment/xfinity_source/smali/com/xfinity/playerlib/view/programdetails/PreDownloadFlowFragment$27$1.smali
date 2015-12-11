.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
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
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;

    .prologue
    .line 888
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .locals 5

    .prologue
    .line 891
    const-string v2, "errorDlgRetryable"

    invoke-static {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v1

    .line 892
    .local v1, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1;)V

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setTryAgainListener(Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)V

    .line 898
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 899
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "description"

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->player_platform_error_msg_connection_problem:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 900
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 901
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 902
    return-object v1
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 888
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27$1;->get()Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    return-object v0
.end method
