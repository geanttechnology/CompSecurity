.class public Lcom/amazon/mShop/sso/CentralSSOLoginActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "CentralSSOLoginActivity.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mIsCreateNewAccount:Z

.field private mProgressDialog:Landroid/app/ProgressDialog;

.field private mUserInitiatedLogin:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    const-class v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 44
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 55
    iput-boolean v0, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mUserInitiatedLogin:Z

    .line 56
    iput-boolean v0, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mIsCreateNewAccount:Z

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method static synthetic access$100(Landroid/content/Context;I)V
    .locals 0
    .param p0, "x0"    # Landroid/content/Context;
    .param p1, "x1"    # I

    .prologue
    .line 44
    invoke-static {p0, p1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->showErrorToast(Landroid/content/Context;I)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method static synthetic access$500()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    sget-object v0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mUserInitiatedLogin:Z

    return v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method static synthetic access$800(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/CentralSSOLoginActivity;
    .param p1, "x1"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->notifyUserSignin(Lcom/amazon/mShop/model/auth/User;)V

    return-void
.end method

.method private static buildBundleParams(Landroid/content/Context;)Landroid/os/Bundle;
    .locals 6
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    const/4 v5, 0x1

    .line 201
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 202
    .local v3, "registrationOptions":Landroid/os/Bundle;
    invoke-static {p0, v5}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 204
    .local v1, "domain":Ljava/lang/String;
    const-string/jumbo v4, "com.amazon.identity.ap.domain"

    invoke-virtual {v1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_map_auth_portal_associate_handle:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 213
    .local v0, "associationHandle":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 214
    const-string/jumbo v4, "com.amazon.identity.ap.assoc_handle"

    invoke-virtual {v3, v4, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    :cond_0
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_map_auth_portal_pageid:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v2

    .line 219
    .local v2, "pageId":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 220
    const-string/jumbo v4, "com.amazon.identity.ap.pageid"

    invoke-virtual {v3, v4, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    :cond_1
    const-string/jumbo v4, "progressbar_state"

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;->SPINNER_MEDIUM:Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 225
    const-string/jumbo v4, "progressbar_position"

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;->CENTER_CENTER:Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 228
    return-object v3
.end method

.method private confirmCredentials(Ljava/lang/String;)V
    .locals 4
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v0

    .line 130
    .local v0, "accountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->buildBundleParams(Landroid/content/Context;)Landroid/os/Bundle;

    move-result-object v2

    .line 131
    .local v2, "registrationOptions":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->setKeepTopActivityFlag()V

    .line 133
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/net/CookieBridge;->getAtMainCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 134
    .local v1, "prevAtMain":Ljava/lang/String;
    new-instance v3, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;

    invoke-direct {v3, p0, v1, p1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$1;-><init>(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, p0, p1, v2, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->confirmCredential(Landroid/app/Activity;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 167
    return-void
.end method

.method private forceRegistration()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 232
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v0

    .line 238
    .local v0, "accountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    invoke-static {v4}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 240
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->buildBundleParams(Landroid/content/Context;)Landroid/os/Bundle;

    move-result-object v1

    .line 242
    .local v1, "registrationOptions":Landroid/os/Bundle;
    const-string/jumbo v3, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 244
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->setKeepTopActivityFlag()V

    .line 249
    iget-boolean v3, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mIsCreateNewAccount:Z

    if-eqz v3, :cond_0

    sget-object v2, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewCreateAccount:Lcom/amazon/identity/auth/device/api/SigninOption;

    .line 250
    .local v2, "signinOption":Lcom/amazon/identity/auth/device/api/SigninOption;
    :goto_0
    new-instance v3, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$3;-><init>(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;)V

    invoke-virtual {v0, p0, v2, v1, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 362
    return-void

    .line 249
    .end local v2    # "signinOption":Lcom/amazon/identity/auth/device/api/SigninOption;
    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    goto :goto_0
.end method

.method private notifyUserSignin(Lcom/amazon/mShop/model/auth/User;)V
    .locals 2
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 365
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$4;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$4;-><init>(Lcom/amazon/mShop/sso/CentralSSOLoginActivity;Lcom/amazon/mShop/model/auth/User;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 373
    return-void
.end method

.method private static showErrorToast(Landroid/content/Context;I)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "errorCode"    # I

    .prologue
    .line 178
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    if-eq p1, v1, :cond_0

    .line 180
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    if-ne v1, p1, :cond_1

    sget v0, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    .line 182
    .local v0, "errorMessageId":I
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;

    invoke-direct {v2, p1, p0, v0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity$2;-><init>(ILandroid/content/Context;I)V

    invoke-interface {v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 193
    .end local v0    # "errorMessageId":I
    :cond_0
    return-void

    .line 180
    :cond_1
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->map_auth_portal_authentication_error:I

    goto :goto_0
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v1, 0x0

    .line 377
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/AmazonActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 379
    const/16 v0, 0x64

    if-ne v0, p1, :cond_0

    .line 380
    if-nez p2, :cond_0

    .line 381
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 382
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->setResult(I)V

    .line 383
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->finish()V

    .line 386
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 62
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 63
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "USER_INITIATED_LOGIN"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mUserInitiatedLogin:Z

    .line 64
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "CREATE_NEW_ACCOUNT"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mIsCreateNewAccount:Z

    .line 66
    new-instance v2, Landroid/app/ProgressDialog;

    invoke-direct {v2, p0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 67
    iget-object v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v2, v4}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 68
    iget-object v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sign_in_in_progress:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 69
    iget-object v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v2, v4}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 70
    iget-object v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/app/ProgressDialog;->setIndeterminate(Z)V

    .line 74
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "force_signin"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 75
    .local v1, "forceSignin":Z
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 76
    .local v0, "currentAccount":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    if-eqz v1, :cond_1

    .line 84
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v2}, Landroid/app/ProgressDialog;->show()V

    .line 85
    invoke-direct {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->forceRegistration()V

    .line 89
    :goto_0
    return-void

    .line 87
    :cond_1
    invoke-direct {p0, v0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->confirmCredentials(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 393
    const/4 v0, 0x0

    return v0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 115
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 117
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 120
    :cond_0
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 109
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onPause()V

    .line 110
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->resumeTimersIfNeeded()V

    .line 111
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 93
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 94
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;->pauseTimersIfNeeded()V

    .line 95
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 401
    const/4 v0, 0x0

    return v0
.end method
