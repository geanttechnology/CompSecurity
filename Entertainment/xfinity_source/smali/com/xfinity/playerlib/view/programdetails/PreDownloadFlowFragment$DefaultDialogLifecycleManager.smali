.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DefaultDialogLifecycleManager"
.end annotation


# instance fields
.field private final dialogId:Ljava/lang/String;

.field private final dialogProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/comcast/cim/android/view/common/CALDialogFragment;",
            ">;"
        }
    .end annotation
.end field

.field private managedDialog:Lcom/comcast/cim/android/view/common/CALDialogFragment;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V
    .locals 1
    .param p3, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/comcast/cim/android/view/common/CALDialogFragment;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1051
    .local p2, "dialogProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/comcast/cim/android/view/common/CALDialogFragment;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    .line 1052
    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->dialogId:Ljava/lang/String;

    .line 1053
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->dialogProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 1054
    return-void
.end method


# virtual methods
.method protected dismissDialog()V
    .locals 1

    .prologue
    .line 1072
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->managedDialog:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->dismiss()V

    .line 1073
    return-void
.end method

.method protected getDialogId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1058
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->dialogId:Ljava/lang/String;

    return-object v0
.end method

.method protected showDialogWithDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    .locals 3
    .param p1, "dismissListener"    # Landroid/content/DialogInterface$OnDismissListener;

    .prologue
    .line 1063
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Resuming dialog with id "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->dialogId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 1065
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->dialogProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/view/common/CALDialogFragment;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->managedDialog:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .line 1066
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->managedDialog:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 1067
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->managedDialog:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "caldialogfragment"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 1068
    return-void
.end method
