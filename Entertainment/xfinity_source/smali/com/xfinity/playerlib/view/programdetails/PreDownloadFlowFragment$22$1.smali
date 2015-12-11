.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22$1;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;->get()Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;

    .prologue
    .line 790
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public validatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 3
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 793
    new-instance v1, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    invoke-direct {v1, p1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;->val$pin:Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    invoke-virtual {v1, v2}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 794
    .local v0, "pinValidated":Z
    if-eqz v0, :cond_0

    .line 795
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchTitaniumTicket()V
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 797
    :cond_0
    invoke-interface {p2, v0}, Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;->onPinValidationComplete(Z)V

    .line 798
    return-void
.end method
