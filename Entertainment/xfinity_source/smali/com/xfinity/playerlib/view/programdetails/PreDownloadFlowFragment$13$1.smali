.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->onPostExecute(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;)V
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
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;

    .prologue
    .line 517
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .locals 6

    .prologue
    .line 520
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 521
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "description"

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->no_matching_profile_error:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 523
    const-string v3, "inputPromptDlg"

    invoke-static {v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .line 524
    .local v2, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v2, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 526
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 527
    .local v1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    new-instance v3, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->dlg_btn_try_again:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;)V

    invoke-direct {v3, v4, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 536
    new-instance v3, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->dlg_btn_cancel:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/comcast/cim/android/view/common/CancellingClickListener;

    invoke-direct {v5}, Lcom/comcast/cim/android/view/common/CancellingClickListener;-><init>()V

    invoke-direct {v3, v4, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 538
    invoke-virtual {v2, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setButtonList(Ljava/util/List;)V

    .line 539
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 541
    return-object v2
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 517
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;->get()Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    return-object v0
.end method
