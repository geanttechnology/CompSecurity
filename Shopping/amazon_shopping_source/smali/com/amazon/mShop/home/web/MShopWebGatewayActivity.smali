.class public Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "MShopWebGatewayActivity.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/home/web/MShopWebGatewayActivity$MShopGatewayWebViewContener;
    }
.end annotation


# static fields
.field private static final DEBUG:Z


# instance fields
.field private lastUserSigninInTimeMillis:J

.field private mIsGatewayJustCreated:Z

.field private mLaunchForceSignInPage:Z

.field private mNeedReloadHomeActivity:Z

.field private mSignInFromHtmlGatewayPage:Z

.field private mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

.field private mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->DEBUG:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 51
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    .line 52
    iput-boolean v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mLaunchForceSignInPage:Z

    .line 53
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    .line 57
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mIsGatewayJustCreated:Z

    .line 63
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->lastUserSigninInTimeMillis:J

    .line 65
    iput-boolean v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mNeedReloadHomeActivity:Z

    .line 67
    iput-boolean v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mSignInFromHtmlGatewayPage:Z

    .line 353
    return-void
.end method

.method private checkAndShowShortcutInstallDialog()V
    .locals 3

    .prologue
    .line 155
    const/4 v0, 0x0

    .line 156
    .local v0, "isFirstStart":Z
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->getAppStartCountInCurrentVersion(Landroid/content/Context;)I

    move-result v1

    .line 159
    .local v1, "launchTimes":I
    const/4 v2, 0x1

    if-gt v1, v2, :cond_0

    .line 160
    const/4 v0, 0x1

    .line 162
    :cond_0
    if-eqz v0, :cond_1

    .line 163
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/share/SharableAppInfoManager;->isCnMshopPackage(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_shortcut_install:I

    invoke-static {v2}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 166
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->isShortcutInstalled(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_1

    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->isAbleToInstallShortcut(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 168
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->installShortcut(Landroid/app/Activity;)V

    .line 172
    :cond_1
    return-void
.end method


# virtual methods
.method public authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
    .locals 1
    .param p1, "primaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;
    .param p2, "secondaryCallback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .prologue
    .line 335
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mSignInFromHtmlGatewayPage:Z

    .line 336
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 337
    return-void
.end method

.method protected createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 1

    .prologue
    .line 350
    new-instance v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity$MShopGatewayWebViewContener;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity$MShopGatewayWebViewContener;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 253
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->isPushAnimationInProgress()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0, p1}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 265
    :cond_0
    :goto_0
    return v0

    .line 256
    :cond_1
    const/4 v1, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    if-ne v1, v2, :cond_2

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_2

    .line 257
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasExitApp:I

    invoke-static {p0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 258
    const-string/jumbo v1, "hm_exit_ok"

    const-string/jumbo v2, "hm_exit_cancel"

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper;->create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    goto :goto_0

    .line 265
    :cond_2
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public getClassLoader()Ljava/lang/ClassLoader;
    .locals 2

    .prologue
    .line 372
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 373
    .local v0, "classLoader":Ljava/lang/ClassLoader;
    if-nez v0, :cond_0

    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .end local v0    # "classLoader":Ljava/lang/ClassLoader;
    :cond_0
    return-object v0
.end method

.method protected handleForceSignIn()V
    .locals 0

    .prologue
    .line 294
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->handleSigninPrompt(Landroid/content/Context;)Z

    .line 295
    return-void
.end method

.method protected initWebView()V
    .locals 3

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/web/MShopWebFragment;->initWebViewContainer(Lcom/amazon/mShop/web/MShopWebActivity;)V

    .line 102
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isHtmlGatewayWebViewHAOff()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 103
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebView;->setLayerType(ILandroid/graphics/Paint;)V

    .line 105
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->initLayout()V

    .line 106
    return-void
.end method

.method public isActionBarSearchIconFadeable()Z
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    instance-of v0, v0, Lcom/amazon/mShop/actionBar/ActionBarIconController;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    invoke-interface {v0}, Lcom/amazon/mShop/actionBar/ActionBarIconController;->isActionBarSearchIconFadeable()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected loadHTMLGateway()V
    .locals 4

    .prologue
    .line 109
    sget-boolean v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 110
    const-string/jumbo v0, "WebGatewayActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "loadHTMLGateway with start time, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getRealClickTime()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 112
    :cond_0
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->loadUrl()V

    .line 113
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 176
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/web/MShopWebActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 177
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mLaunchForceSignInPage:Z

    .line 178
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 211
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->onCreate(Landroid/os/Bundle;)V

    .line 213
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 216
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 217
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "INTENT_EXTRA_STARTED_NO_NEED_COUNT_APPSTART"

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 218
    .local v1, "noNeedCountAppStart":Z
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/control/home/HomeController;->setNoNeedCountAppStart(Z)V

    .line 220
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->setStopBehavior(I)V

    .line 224
    new-instance v2, Lcom/amazon/mShop/TimeChangedReceiver;

    invoke-direct {v2}, Lcom/amazon/mShop/TimeChangedReceiver;-><init>()V

    iput-object v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

    .line 225
    iget-object v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

    sget-object v3, Lcom/amazon/mShop/TimeChangedReceiver;->INTENT_FILTER:Landroid/content/IntentFilter;

    invoke-virtual {p0, v2, v3}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 226
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 277
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 278
    iput-object v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

    .line 280
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->onDestroy()V

    .line 282
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 283
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 284
    invoke-static {v1}, Lcom/amazon/mShop/control/home/HomeController;->setInstance(Lcom/amazon/mShop/control/home/HomeController;)V

    .line 286
    invoke-static {}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->isNeedRestart()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 287
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->setNeedRestart(Z)V

    .line 288
    invoke-static {p0}, Lcom/amazon/mShop/util/AppUtils;->launchApp(Landroid/content/Context;)V

    .line 290
    :cond_0
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 117
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->onResume()V

    .line 121
    invoke-static {}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->getInstance()Lcom/amazon/mShop/home/GatewayWeblabUtil;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->updateGatewayWeblabState()Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    move-result-object v0

    .line 122
    .local v0, "featureStateChangeType":Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;
    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->NO_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    if-eq v1, v0, :cond_3

    iget-boolean v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mLaunchForceSignInPage:Z

    if-nez v1, :cond_3

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->needSigninPrompt()Z

    move-result v1

    if-nez v1, :cond_3

    .line 123
    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->TREATMENT_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    if-ne v1, v0, :cond_2

    .line 124
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mNeedReloadHomeActivity:Z

    .line 126
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->reloadHomeActivity(Lcom/amazon/mShop/AmazonActivity;)V

    .line 146
    :cond_0
    :goto_0
    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 147
    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->uploadCrashReportAsync()V

    .line 149
    :cond_1
    return-void

    .line 127
    :cond_2
    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->CACHETIMESTAMP_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    if-ne v1, v0, :cond_0

    .line 129
    invoke-static {}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->getInstance()Lcom/amazon/mShop/home/GatewayWeblabUtil;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->postGatewayFeatureTrigger(Z)V

    goto :goto_0

    .line 136
    :cond_3
    iget-boolean v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mLaunchForceSignInPage:Z

    if-eqz v1, :cond_4

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v1

    if-nez v1, :cond_4

    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSignInPrompt()Z

    move-result v1

    if-nez v1, :cond_0

    .line 140
    :cond_4
    invoke-direct {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->checkAndShowShortcutInstallDialog()V

    goto :goto_0
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 272
    iget-boolean v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mLaunchForceSignInPage:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->onSearchRequested()Z

    move-result v0

    goto :goto_0
.end method

.method protected onStart()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 71
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->onStart()V

    .line 73
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 74
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    iget-boolean v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mLaunchForceSignInPage:Z

    if-nez v1, :cond_0

    const-string/jumbo v1, "upgradeShouldShowDialog"

    invoke-interface {v0, v1, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v1, "upgradeLastDialogTime"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getLong(Ljava/lang/String;)J

    move-result-wide v1

    const-wide/32 v3, 0x48190800

    invoke-static {v1, v2, v3, v4}, Lcom/amazon/mShop/util/UpgradeUtil;->checkTimeout(JJ)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 77
    invoke-static {p0}, Lcom/amazon/mShop/util/UpgradeUtil;->showUpgradeNotificationDialog(Landroid/content/Context;)V

    .line 80
    :cond_0
    iget-boolean v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mIsGatewayJustCreated:Z

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    if-eqz v1, :cond_1

    .line 81
    new-instance v1, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;

    iget-object v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    invoke-direct {v1, p0, v2, v5}, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/DelayedInitView;Z)V

    .line 83
    :cond_1
    iput-boolean v5, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mIsGatewayJustCreated:Z

    .line 84
    return-void
.end method

.method protected processSavedInstanceAndInitWebview(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 243
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 244
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 245
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v3}, Lcom/amazon/mShop/util/ActivityUtils;->getHTMLGatewayUrl(Landroid/content/Context;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 248
    :cond_0
    invoke-super {p0, v3}, Lcom/amazon/mShop/web/MShopWebActivity;->processSavedInstanceAndInitWebview(Landroid/os/Bundle;)V

    .line 249
    return-void
.end method

.method public reloadHtmlGateway(J)V
    .locals 5
    .param p1, "startTime"    # J

    .prologue
    .line 190
    iget-boolean v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mNeedReloadHomeActivity:Z

    if-eqz v1, :cond_1

    .line 191
    sget-boolean v1, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 192
    const-string/jumbo v1, "WebGatewayActivity"

    const-string/jumbo v2, "reloadHtmlGateway - no need to reload the gateway url when reload gateway activity"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 207
    :cond_0
    :goto_0
    return-void

    .line 197
    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->setWebviewStartTime(J)V

    .line 198
    sget-boolean v1, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->DEBUG:Z

    if-eqz v1, :cond_2

    .line 199
    const-string/jumbo v1, "WebGatewayActivity"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "reloadHtmlGateway with start time, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getRealClickTime()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 201
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 202
    .local v0, "webView":Landroid/webkit/WebView;
    if-eqz v0, :cond_0

    .line 203
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->stopLoading()V

    .line 204
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearHistory()V

    .line 205
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setWebviewStartTime(J)V
    .locals 0
    .param p1, "startTime"    # J

    .prologue
    .line 181
    iput-wide p1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebviewLoadStartTime:J

    .line 182
    return-void
.end method

.method protected setupCustomizedActionbar(Landroid/widget/ViewAnimator;)Landroid/view/View;
    .locals 3
    .param p1, "orignalViewAnimator"    # Landroid/widget/ViewAnimator;

    .prologue
    .line 90
    iget-object v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    if-nez v1, :cond_0

    .line 91
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->web_home_bar:I

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    iput-object v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    .line 93
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mWebHomeBar:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    invoke-static {p0, p1, v1}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->applyWebGatewayCustomizedActionBar(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    .line 94
    .local v0, "wrappedViewAnimator":Landroid/view/View;
    return-object v0
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 6
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 308
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 309
    .local v0, "now":J
    sget-boolean v2, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 310
    const-string/jumbo v2, "WebGatewayActivity"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Invoke userSignedIn, current time is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 315
    :cond_0
    iget-boolean v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mSignInFromHtmlGatewayPage:Z

    if-eqz v2, :cond_2

    .line 316
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->mSignInFromHtmlGatewayPage:Z

    .line 317
    iput-wide v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->lastUserSigninInTimeMillis:J

    .line 331
    :cond_1
    :goto_0
    return-void

    .line 318
    :cond_2
    iget-wide v2, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->lastUserSigninInTimeMillis:J

    sub-long v2, v0, v2

    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getUserSignInPeriod()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-lez v2, :cond_1

    .line 320
    iput-wide v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->lastUserSigninInTimeMillis:J

    .line 321
    sget-boolean v2, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->DEBUG:Z

    if-eqz v2, :cond_3

    .line 322
    const-string/jumbo v2, "WebGatewayActivity"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "refresh gateway when userSignedIn, and the time stamp is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 325
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->refresh()V

    .line 327
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSpinner()V

    goto :goto_0
.end method

.method public userSignedOut()V
    .locals 2

    .prologue
    .line 341
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->lastUserSigninInTimeMillis:J

    .line 346
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 304
    return-void
.end method
