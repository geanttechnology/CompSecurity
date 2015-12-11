.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->checkParentalControls()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener",
        "<",
        "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 765
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;)V
    .locals 3
    .param p1, "pcSettings"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    .prologue
    .line 768
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Parental control settings fetched"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 769
    invoke-virtual {p1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->getParentalPin()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    move-result-object v0

    .line 770
    .local v0, "pin":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v2

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->pinRequiredForVideo(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z
    invoke-static {v1, p1, v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3400(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 771
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Prompting for pin"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 772
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->promptForParentalControlPin(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;)V
    invoke-static {v1, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;)V

    .line 777
    :goto_0
    return-void

    .line 774
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Pin not set or not required for video"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 775
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchTitaniumTicket()V
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 765
    check-cast p1, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;->onPostExecute(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;)V

    return-void
.end method
