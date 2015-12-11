.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ParentalControlPinFragmentLifecycleManager"
.end annotation


# instance fields
.field private fragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

.field private final fragmentProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1080
    .local p2, "fragmentProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    .line 1081
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;->fragmentProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 1082
    return-void
.end method


# virtual methods
.method protected dismissDialog()V
    .locals 1

    .prologue
    .line 1100
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;->fragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->dismiss()V

    .line 1101
    return-void
.end method

.method protected getDialogId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1086
    const-string v0, "parental control pin fragment"

    return-object v0
.end method

.method protected showDialogWithDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    .locals 3
    .param p1, "dismissListener"    # Landroid/content/DialogInterface$OnDismissListener;

    .prologue
    .line 1091
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;->fragmentProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;->fragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    .line 1092
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 1093
    .local v0, "ft":Landroid/app/FragmentTransaction;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 1094
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;->fragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    invoke-virtual {v1, p1}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 1095
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;->fragment:Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    const-string v2, "dialog"

    invoke-virtual {v1, v0, v2}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->show(Landroid/app/FragmentTransaction;Ljava/lang/String;)I

    .line 1096
    return-void
.end method
