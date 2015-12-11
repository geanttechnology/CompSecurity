.class public Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "CentralSSOLogoutActivity.java"


# instance fields
.field private mLogoutMessageDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field private mProgressDialog:Landroid/app/ProgressDialog;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->logout()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;)Landroid/app/ProgressDialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method private createSignOutDialog()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 44
    new-instance v0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$1;-><init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;)V

    .line 60
    .local v0, "clickListener":Landroid/content/DialogInterface$OnClickListener;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string/jumbo v4, "com.amazon.dcp.sso.property.username"

    invoke-static {v3, v4}, Lcom/amazon/mShop/sso/SSOUtil;->peekCustomerAttribute(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 62
    .local v1, "fullName":Ljava/lang/String;
    const/4 v2, 0x0

    .line 64
    .local v2, "logoutMessage":Ljava/lang/String;
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->amazon_appstore_package_name:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, v3}, Lcom/amazon/mShop/util/AppUtils;->isAppInstalled(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 65
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sign_out_confirm_message_with_appstore_installed:I

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-virtual {p0, v3, v4}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 70
    :goto_0
    new-instance v3, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sign_out_confirm_title:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->alert_cancel_button:I

    invoke-virtual {v3, v4, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sign_out_button:I

    invoke-virtual {v3, v4, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$2;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$2;-><init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;)V

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mLogoutMessageDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 84
    iget-object v3, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mLogoutMessageDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 85
    return-void

    .line 67
    :cond_0
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sign_out_confirm_message:I

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-virtual {p0, v3, v4}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method private logout()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 91
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 93
    .local v1, "currentAccount":Ljava/lang/String;
    new-instance v4, Landroid/app/ProgressDialog;

    invoke-direct {v4, p0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v4, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 94
    iget-object v4, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v4, v6}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 95
    iget-object v4, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->signout_progress_message:I

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 96
    iget-object v4, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v4, v6}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 97
    iget-object v4, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v4, v7}, Landroid/app/ProgressDialog;->setIndeterminate(Z)V

    .line 98
    iget-object v4, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v4}, Landroid/app/ProgressDialog;->show()V

    .line 99
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v2

    .line 101
    .local v2, "mapAccountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 107
    invoke-static {v7}, Lcom/amazon/mShop/sso/SSOUtil;->setLogoutTriggeredFromApplication(Z)V

    .line 109
    new-instance v3, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v4, "MobileAuthenticationPlatform"

    const-string/jumbo v5, "central_sso_signout"

    invoke-direct {v3, v4, v5}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    .local v3, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-static {v3}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v0

    .line 112
    .local v0, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    new-instance v4, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;

    invoke-direct {v4, p0, v0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity$3;-><init>(Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;Lcom/amazon/mShop/net/CallObserver;)V

    invoke-virtual {v2, v1, v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 158
    .end local v0    # "callObserver":Lcom/amazon/mShop/net/CallObserver;
    .end local v3    # "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    :cond_0
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 39
    invoke-direct {p0}, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->createSignOutDialog()V

    .line 40
    return-void
.end method

.method public onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V
    .locals 0
    .param p1, "menu"    # Landroid/view/ContextMenu;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "menuInfo"    # Landroid/view/ContextMenu$ContextMenuInfo;

    .prologue
    .line 179
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 167
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 172
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 182
    const/4 v0, 0x0

    return v0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 186
    const/4 v0, 0x0

    return v0
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 162
    const/4 v0, 0x0

    return v0
.end method
