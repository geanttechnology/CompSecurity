.class public Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;
.super Landroid/app/Activity;
.source "PlayNowSignoutActivity.java"


# instance fields
.field private androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field private launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

.field private playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private userManager:Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/UserManager",
            "<+",
            "Lcom/comcast/cim/model/user/User;",
            "+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 23
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 24
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLaunchStrategy()Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    .line 25
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 26
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)Lcom/comcast/cim/model/user/UserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->userManager:Lcom/comcast/cim/model/user/UserManager;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 30
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 32
    iget-object v3, p0, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {v3}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->isKindle()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 33
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->getWindow()Landroid/view/Window;

    move-result-object v3

    const/16 v4, 0x400

    invoke-virtual {v3, v4}, Landroid/view/Window;->addFlags(I)V

    .line 36
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 37
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "title"

    sget v4, Lcom/xfinity/playerlib/R$string;->settings_signout_title:I

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    const-string v3, "description"

    sget v4, Lcom/xfinity/playerlib/R$string;->settings_signout_message:I

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    const-string v3, "inputPromptDlg"

    invoke-static {v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .line 41
    .local v2, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v2, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 43
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 44
    .local v1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    new-instance v3, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    sget v4, Lcom/xfinity/playerlib/R$string;->dlg_btn_yes:I

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$1;-><init>(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)V

    invoke-direct {v3, v4, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 62
    new-instance v3, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->dlg_btn_no:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$2;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$2;-><init>(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)V

    invoke-direct {v3, v4, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 69
    invoke-virtual {v2, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setButtonList(Ljava/util/List;)V

    .line 71
    new-instance v3, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$3;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity$3;-><init>(Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 78
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    const-string v4, "caldialogfragment"

    invoke-virtual {v2, v3, v4}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 79
    return-void
.end method
