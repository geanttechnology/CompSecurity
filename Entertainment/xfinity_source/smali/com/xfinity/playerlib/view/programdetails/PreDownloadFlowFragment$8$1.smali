.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8$1;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;->get()Lcom/comcast/cim/android/view/common/CALDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;

    .prologue
    .line 401
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 405
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v1

    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->setCellularDataThreshold(D)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 410
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setUseCellularWhenAvailable(Z)V

    .line 411
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchVideoEntitlement()V
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1000(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 412
    :goto_0
    return-void

    .line 406
    :catch_0
    move-exception v0

    .line 407
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->showCrashDialog(Landroid/content/Context;Ljava/lang/Exception;)V

    goto :goto_0
.end method
