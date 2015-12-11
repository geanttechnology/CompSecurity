.class public Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "AdultContentSettingChangeActivity.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private pinListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation
.end field

.field private pinProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation
.end field

.field private progressDialog:Landroid/app/ProgressDialog;

.field private userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    .line 25
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getParentalControlsSettingsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->pinProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 26
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 27
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;)Landroid/app/ProgressDialog;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->progressDialog:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method


# virtual methods
.method protected onPause()V
    .locals 2

    .prologue
    .line 80
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onPause()V

    .line 81
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->pinProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->pinListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->progressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    .line 83
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 85
    :cond_0
    return-void
.end method

.method protected onResume()V
    .locals 8

    .prologue
    .line 33
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onResume()V

    .line 35
    new-instance v5, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$1;-><init>(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;)V

    .line 42
    .local v5, "cancelListener":Landroid/content/DialogInterface$OnCancelListener;
    const-string v0, ""

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->checking_parental_controls_progress_message:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {p0, v0, v1, v2}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->progressDialog:Landroid/app/ProgressDialog;

    .line 43
    iget-object v7, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->pinProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->pinProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-object v1, p0

    move-object v3, p0

    move-object v6, v5

    invoke-direct/range {v0 .. v6}, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity$2;-><init>(Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;Landroid/content/DialogInterface$OnCancelListener;)V

    invoke-interface {v7, v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;->pinListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 76
    return-void
.end method
