.class public Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "DistributedSSOLogoutActivity.java"

# interfaces
.implements Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;


# instance fields
.field private mLogoutMessageDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field private mProgressDialog:Landroid/app/ProgressDialog;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->logout()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;)Landroid/app/ProgressDialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method private createSignOutDialog(Ljava/lang/String;)V
    .locals 7
    .param p1, "fullName"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 73
    new-instance v0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$1;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;)V

    .line 89
    .local v0, "clickListener":Landroid/content/DialogInterface$OnClickListener;
    const/4 v3, 0x0

    .line 91
    .local v3, "logoutMessage":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 92
    .local v1, "currentAccount":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 93
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getPrimaryAccount()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    .line 94
    .local v2, "isPrimaryAccount":Z
    if-eqz v2, :cond_2

    .line 96
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->amazon_appstore_package_name:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/AppUtils;->isAppInstalled(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 97
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sign_out_confirm_message_with_appstore_installed:I

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-virtual {p0, v4, v5}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 106
    .end local v2    # "isPrimaryAccount":Z
    :cond_0
    :goto_0
    new-instance v4, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->sign_out_confirm_title:I

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v4

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->alert_cancel_button:I

    invoke-virtual {v4, v5, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->sign_out_button:I

    invoke-virtual {v4, v5, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v4

    new-instance v5, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$2;

    invoke-direct {v5, p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$2;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;)V

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mLogoutMessageDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 120
    iget-object v4, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mLogoutMessageDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 121
    return-void

    .line 99
    .restart local v2    # "isPrimaryAccount":Z
    :cond_1
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sign_out_confirm_message:I

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-virtual {p0, v4, v5}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 102
    :cond_2
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sign_out_your_app_confirm_message:I

    new-array v5, v5, [Ljava/lang/Object;

    aput-object p1, v5, v6

    invoke-virtual {p0, v4, v5}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method private getProgressDialog()Landroid/app/ProgressDialog;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 125
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    if-nez v0, :cond_0

    .line 126
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-direct {v0, p0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 127
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 128
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 129
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setIndeterminate(Z)V

    .line 131
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method private logout()V
    .locals 8

    .prologue
    .line 143
    const/4 v5, 0x1

    invoke-static {v5}, Lcom/amazon/mShop/sso/SSOUtil;->setLogoutTriggeredFromApplication(Z)V

    .line 144
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 146
    .local v0, "currentAccount":Ljava/lang/String;
    invoke-direct {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getProgressDialog()Landroid/app/ProgressDialog;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->signout_progress_message:I

    invoke-virtual {p0, v6}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 147
    invoke-direct {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getProgressDialog()Landroid/app/ProgressDialog;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/ProgressDialog;->show()V

    .line 149
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v4

    .line 150
    .local v4, "mapAccountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 152
    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getPrimaryAccount()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    .line 155
    .local v3, "isPrimaryAccount":Z
    new-instance v5, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v6, "MobileAuthenticationPlatform"

    const-string/jumbo v7, "distributed_sso_signout"

    invoke-direct {v5, v6, v7}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v5}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v1

    .line 158
    .local v1, "deregisterDeviceCall":Lcom/amazon/mShop/net/CallObserver;
    new-instance v5, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v6, "MobileAuthenticationPlatform"

    const-string/jumbo v7, "distributed_sso_signout_total"

    invoke-direct {v5, v6, v7}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v5}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v2

    .line 160
    .local v2, "deregisterDeviceTotal":Lcom/amazon/mShop/net/CallObserver;
    new-instance v5, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;

    invoke-direct {v5, p0, v1, v3, v2}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity$3;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;Lcom/amazon/mShop/net/CallObserver;ZLcom/amazon/mShop/net/CallObserver;)V

    invoke-virtual {v4, v0, v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 217
    .end local v1    # "deregisterDeviceCall":Lcom/amazon/mShop/net/CallObserver;
    .end local v2    # "deregisterDeviceTotal":Lcom/amazon/mShop/net/CallObserver;
    .end local v3    # "isPrimaryAccount":Z
    :cond_0
    return-void
.end method


# virtual methods
.method public afterFullnameFetched(Ljava/lang/String;)V
    .locals 1
    .param p1, "fullname"    # Ljava/lang/String;

    .prologue
    .line 67
    invoke-direct {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getProgressDialog()Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 68
    invoke-direct {p0, p1}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->createSignOutDialog(Ljava/lang/String;)V

    .line 69
    return-void
.end method

.method public beforeFetchingFullname()V
    .locals 2

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getProgressDialog()Landroid/app/ProgressDialog;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 57
    invoke-direct {p0}, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->getProgressDialog()Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 58
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 47
    new-instance v0, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;-><init>(Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 48
    return-void
.end method

.method public onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V
    .locals 0
    .param p1, "menu"    # Landroid/view/ContextMenu;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "menuInfo"    # Landroid/view/ContextMenu$ContextMenuInfo;

    .prologue
    .line 242
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 228
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 230
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 231
    iget-object v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 234
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 245
    const/4 v0, 0x0

    return v0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 249
    const/4 v0, 0x0

    return v0
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 223
    const/4 v0, 0x0

    return v0
.end method
