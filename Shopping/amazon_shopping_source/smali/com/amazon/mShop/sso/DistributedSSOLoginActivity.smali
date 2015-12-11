.class public Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "DistributedSSOLoginActivity.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final sExecutor:Ljava/util/concurrent/Executor;


# instance fields
.field private mIsCreateNewAccount:Z

.field private mUserInitiatedLogin:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    const-class v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;

    .line 55
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->sExecutor:Ljava/util/concurrent/Executor;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 45
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 56
    iput-boolean v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->mIsCreateNewAccount:Z

    .line 58
    iput-boolean v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->mUserInitiatedLogin:Z

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    .prologue
    .line 45
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method static synthetic access$100(Landroid/content/Context;I)V
    .locals 0
    .param p0, "x0"    # Landroid/content/Context;
    .param p1, "x1"    # I

    .prologue
    .line 45
    invoke-static {p0, p1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->showErrorToast(Landroid/content/Context;I)V

    return-void
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;
    .param p1, "x1"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->notifyUserSignin(Lcom/amazon/mShop/model/auth/User;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    .prologue
    .line 45
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    .prologue
    .line 45
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method static synthetic access$400()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    sget-object v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500()Z
    .locals 1

    .prologue
    .line 45
    sget-boolean v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->DEBUG:Z

    return v0
.end method

.method static synthetic access$600()Z
    .locals 1

    .prologue
    .line 45
    sget-boolean v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->DEBUG:Z

    return v0
.end method

.method static synthetic access$700()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 45
    sget-object v0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->sExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->mUserInitiatedLogin:Z

    return v0
.end method

.method static synthetic access$900(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    .prologue
    .line 45
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->clearKeepTopActivityFlag()V

    return-void
.end method

.method private static buildBundleParams(Landroid/content/Context;)Landroid/os/Bundle;
    .locals 6
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    const/4 v5, 0x1

    .line 196
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 197
    .local v3, "registrationOptions":Landroid/os/Bundle;
    invoke-static {p0, v5}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 199
    .local v1, "domain":Ljava/lang/String;
    const-string/jumbo v4, "com.amazon.identity.ap.domain"

    invoke-virtual {v1, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_map_auth_portal_associate_handle:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 208
    .local v0, "associationHandle":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 209
    const-string/jumbo v4, "com.amazon.identity.ap.assoc_handle"

    invoke-virtual {v3, v4, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    :cond_0
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_map_auth_portal_pageid:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v2

    .line 214
    .local v2, "pageId":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 215
    const-string/jumbo v4, "com.amazon.identity.ap.pageid"

    invoke-virtual {v3, v4, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    :cond_1
    const-string/jumbo v4, "progressbar_state"

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;->SPINNER_MEDIUM:Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState;

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 220
    const-string/jumbo v4, "progressbar_position"

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;->CENTER_CENTER:Lcom/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition;

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 223
    return-object v3
.end method

.method private confirmCredentials(Ljava/lang/String;)V
    .locals 4
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 123
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v0

    .line 124
    .local v0, "accountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->buildBundleParams(Landroid/content/Context;)Landroid/os/Bundle;

    move-result-object v2

    .line 125
    .local v2, "registrationOptions":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->setKeepTopActivityFlag()V

    .line 127
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/net/CookieBridge;->getAtMainCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 128
    .local v1, "prevAtMain":Ljava/lang/String;
    new-instance v3, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$1;

    invoke-direct {v3, p0, v1, p1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$1;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, p0, p1, v2, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->confirmCredential(Landroid/app/Activity;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 162
    return-void
.end method

.method private forceRegistration()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 227
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v0

    .line 235
    .local v0, "accountManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    invoke-static {v7}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 237
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->buildBundleParams(Landroid/content/Context;)Landroid/os/Bundle;

    move-result-object v3

    .line 239
    .local v3, "registrationOptions":Landroid/os/Bundle;
    const-string/jumbo v6, "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

    invoke-virtual {v3, v6, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 242
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6, v7}, Lcom/amazon/mShop/net/CookieBridge;->getCookiesOfCurrentLocale(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v4

    .line 243
    .local v4, "secureCookies":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    const/4 v7, 0x0

    invoke-static {v6, v7}, Lcom/amazon/mShop/net/CookieBridge;->getCookiesOfCurrentLocale(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 245
    .local v1, "nonSecureCookies":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->setKeepTopActivityFlag()V

    .line 246
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/net/CookieBridge;->getAtMainCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 248
    .local v2, "prevAtMain":Ljava/lang/String;
    iget-boolean v6, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->mIsCreateNewAccount:Z

    if-eqz v6, :cond_0

    sget-object v5, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewCreateAccount:Lcom/amazon/identity/auth/device/api/SigninOption;

    .line 249
    .local v5, "signinOption":Lcom/amazon/identity/auth/device/api/SigninOption;
    :goto_0
    new-instance v6, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;

    invoke-direct {v6, p0, v4, v1, v2}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$3;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, p0, v5, v3, v6}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 414
    return-void

    .line 248
    .end local v5    # "signinOption":Lcom/amazon/identity/auth/device/api/SigninOption;
    :cond_0
    sget-object v5, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    goto :goto_0
.end method

.method private notifyUserSignin(Lcom/amazon/mShop/model/auth/User;)V
    .locals 2
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 417
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$4;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$4;-><init>(Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;Lcom/amazon/mShop/model/auth/User;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 425
    return-void
.end method

.method private static showErrorToast(Landroid/content/Context;I)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "errorCode"    # I

    .prologue
    .line 173
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->REGISTER_FAILED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    if-eq p1, v1, :cond_0

    .line 175
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v1

    if-ne v1, p1, :cond_1

    sget v0, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    .line 177
    .local v0, "errorMessageId":I
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$2;

    invoke-direct {v2, p1, p0, v0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity$2;-><init>(ILandroid/content/Context;I)V

    invoke-interface {v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 188
    .end local v0    # "errorMessageId":I
    :cond_0
    return-void

    .line 175
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

    .line 429
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/AmazonActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 431
    const/16 v0, 0x64

    if-ne v0, p1, :cond_0

    .line 432
    if-nez p2, :cond_0

    .line 433
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 434
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->setResult(I)V

    .line 435
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->finish()V

    .line 438
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

    .line 64
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "USER_INITIATED_LOGIN"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->mUserInitiatedLogin:Z

    .line 65
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "CREATE_NEW_ACCOUNT"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->mIsCreateNewAccount:Z

    .line 69
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "force_signin"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 70
    .local v1, "forceSignin":Z
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "currentAccount":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    if-eqz v1, :cond_1

    .line 72
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->forceRegistration()V

    .line 76
    :goto_0
    return-void

    .line 74
    :cond_1
    invoke-direct {p0, v0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->confirmCredentials(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 445
    const/4 v0, 0x0

    return v0
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 111
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 112
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->pauseTimersIfNeeded()V

    .line 114
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 90
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onPause()V

    .line 91
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;->resumeTimersIfNeeded()V

    .line 92
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 453
    const/4 v0, 0x0

    return v0
.end method
