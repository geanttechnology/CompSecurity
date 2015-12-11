.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->promptForParentalControlPin(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;)V
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
        "Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

.field final synthetic val$pin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 787
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;->val$pin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;
    .locals 2

    .prologue
    .line 789
    new-instance v0, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;-><init>()V

    .line 790
    .local v0, "fragment":Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->setPinValidator(Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;)V

    .line 800
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 801
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 787
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;->get()Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    move-result-object v0

    return-object v0
.end method
