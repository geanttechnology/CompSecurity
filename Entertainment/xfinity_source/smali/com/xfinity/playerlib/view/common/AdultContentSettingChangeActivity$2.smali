.class Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;
.super Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;
.source "AdultContentSettingChangeActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

.field final synthetic val$cancelListener:Landroid/content/DialogInterface$OnCancelListener;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;Landroid/content/DialogInterface$OnCancelListener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;
    .param p3, "x1"    # Landroid/content/Context;
    .param p4, "x2"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .param p5, "x3"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 43
    .local p2, "x0":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    iput-object p6, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->val$cancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;)V
    .locals 6
    .param p1, "resource"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    .prologue
    .line 45
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    # getter for: Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->progressDialog:Landroid/app/ProgressDialog;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->access$000(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;)Landroid/app/ProgressDialog;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/ProgressDialog;->dismiss()V

    .line 47
    invoke-virtual {p1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->getParentalPin()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    move-result-object v3

    .line 49
    .local v3, "pin":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    # getter for: Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->access$100(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 50
    .local v4, "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsAdultContent()Z

    move-result v5

    if-nez v5, :cond_0

    const/4 v0, 0x1

    .line 51
    .local v0, "desiredSetting":Z
    :goto_0
    if-nez v3, :cond_1

    .line 52
    invoke-virtual {v4, v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setWantsAdultContent(Z)V

    .line 53
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->finish()V

    .line 74
    :goto_1
    return-void

    .line 50
    .end local v0    # "desiredSetting":Z
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 57
    .restart local v0    # "desiredSetting":Z
    :cond_1
    new-instance v1, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;

    invoke-direct {v1}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;-><init>()V

    .line 58
    .local v1, "fragment":Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;
    new-instance v5, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;

    invoke-direct {v5, p0, v3, v4, v0}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2$1;-><init>(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;Z)V

    invoke-virtual {v1, v5}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->setPinValidator(Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidator;)V

    .line 69
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->val$cancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-virtual {v1, v5}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 71
    iget-object v5, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->this$0:Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 72
    .local v2, "ft":Landroid/app/FragmentTransaction;
    const/4 v5, 0x0

    invoke-virtual {v2, v5}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 73
    const-string v5, "dialog"

    invoke-virtual {v1, v2, v5}, Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;->show(Landroid/app/FragmentTransaction;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;->onPostExecute(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;)V

    return-void
.end method
