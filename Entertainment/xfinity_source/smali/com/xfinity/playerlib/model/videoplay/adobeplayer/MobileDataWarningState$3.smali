.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;
.super Ljava/lang/Object;
.source "MobileDataWarningState.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->postMobileDataWarningDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 98
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getPlayerDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v1

    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->setCellularDataThreshold(D)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setUseCellularWhenAvailable(Z)V

    .line 105
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->transitionState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 106
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 107
    :goto_0
    return-void

    .line 99
    :catch_0
    move-exception v0

    .line 100
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 101
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getPlayerDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState$3;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v2, v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->showCrashDialog(Landroid/content/Context;Ljava/lang/Exception;)V

    goto :goto_0
.end method
