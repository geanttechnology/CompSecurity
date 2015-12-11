.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->onFailure(Ljava/lang/Throwable;)V
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
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;

.field final synthetic val$t:Ljava/lang/Throwable;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;

    .prologue
    .line 929
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;->val$t:Ljava/lang/Throwable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .locals 4

    .prologue
    .line 932
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;->val$t:Ljava/lang/Throwable;

    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1$1;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;)V

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    .line 938
    .local v0, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 939
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 929
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;->get()Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    return-object v0
.end method
