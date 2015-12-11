.class public Lcom/comcast/cim/android/view/settings/SignoutActivity;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "SignoutActivity.java"


# instance fields
.field private launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

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
    .line 17
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    .line 19
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getUserManager()Lcom/comcast/cim/model/user/UserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 20
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getLaunchStrategy()Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/view/settings/SignoutActivity;)Lcom/comcast/cim/model/user/UserManager;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/settings/SignoutActivity;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity;->userManager:Lcom/comcast/cim/model/user/UserManager;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/view/settings/SignoutActivity;)Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/view/settings/SignoutActivity;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 26
    new-instance v0, Lcom/comcast/cim/android/view/settings/SignoutActivity$1;

    invoke-direct {v0, p0, p0}, Lcom/comcast/cim/android/view/settings/SignoutActivity$1;-><init>(Lcom/comcast/cim/android/view/settings/SignoutActivity;Landroid/content/Context;)V

    .line 33
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    const-string v1, "Are you sure you want to sign out?"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 35
    const/4 v1, -0x1

    const-string v2, "Yes"

    new-instance v3, Lcom/comcast/cim/android/view/settings/SignoutActivity$2;

    invoke-direct {v3, p0}, Lcom/comcast/cim/android/view/settings/SignoutActivity$2;-><init>(Lcom/comcast/cim/android/view/settings/SignoutActivity;)V

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 44
    const/4 v1, -0x2

    const-string v2, "No"

    new-instance v3, Lcom/comcast/cim/android/view/settings/SignoutActivity$3;

    invoke-direct {v3, p0}, Lcom/comcast/cim/android/view/settings/SignoutActivity$3;-><init>(Lcom/comcast/cim/android/view/settings/SignoutActivity;)V

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/AlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 50
    new-instance v1, Lcom/comcast/cim/android/view/settings/SignoutActivity$4;

    invoke-direct {v1, p0}, Lcom/comcast/cim/android/view/settings/SignoutActivity$4;-><init>(Lcom/comcast/cim/android/view/settings/SignoutActivity;)V

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 57
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 58
    return-void
.end method
