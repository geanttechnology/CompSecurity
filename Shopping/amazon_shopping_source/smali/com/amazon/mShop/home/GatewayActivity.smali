.class public Lcom/amazon/mShop/home/GatewayActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "GatewayActivity.java"


# instance fields
.field private mHomeView:Lcom/amazon/mShop/home/HomeView;

.field private mJustCreated:Z

.field private mLaunchSignInPrompt:Z

.field private mNeedFetchMenusFromServer:Z

.field private mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 47
    iput-boolean v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mLaunchSignInPrompt:Z

    .line 53
    iput-boolean v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mNeedFetchMenusFromServer:Z

    .line 115
    iput-boolean v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mJustCreated:Z

    return-void
.end method

.method private checkAndShowShortcutInstallDialog()V
    .locals 3

    .prologue
    .line 160
    const/4 v0, 0x0

    .line 161
    .local v0, "isFirstStart":Z
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->getAppStartCountInCurrentVersion(Landroid/content/Context;)I

    move-result v1

    .line 164
    .local v1, "launchTimes":I
    const/4 v2, 0x1

    if-gt v1, v2, :cond_0

    .line 165
    const/4 v0, 0x1

    .line 167
    :cond_0
    if-eqz v0, :cond_1

    .line 168
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/share/SharableAppInfoManager;->isCnMshopPackage(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_shortcut_install:I

    invoke-static {v2}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 171
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->isShortcutInstalled(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_1

    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->isAbleToInstallShortcut(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 173
    invoke-static {p0}, Lcom/amazon/mShop/util/ShortcutUtil;->installShortcut(Landroid/app/Activity;)V

    .line 177
    :cond_1
    return-void
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x1

    .line 237
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->isPushAnimationInProgress()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 278
    :cond_0
    :goto_0
    return v2

    .line 241
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/home/GatewayActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 245
    const/4 v3, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v4

    if-ne v3, v4, :cond_4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_4

    .line 250
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 251
    .local v0, "currentView":Landroid/view/View;
    if-eqz v0, :cond_2

    invoke-virtual {v0, p1}, Landroid/view/View;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 257
    :cond_2
    instance-of v3, v0, Lcom/amazon/mShop/home/HomeView;

    if-eqz v3, :cond_3

    .line 258
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_hasExitApp:I

    invoke-static {p0, v3}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 259
    const-string/jumbo v3, "hm_exit_ok"

    const-string/jumbo v4, "hm_exit_cancel"

    invoke-static {p0, v3, v4}, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper;->create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    goto :goto_0

    .line 266
    :cond_3
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/home/GatewayActivity;->popView(Z)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 269
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 270
    instance-of v3, v0, Lcom/amazon/mShop/home/HomeView;

    if-eqz v3, :cond_0

    move-object v1, v0

    .line 271
    check-cast v1, Lcom/amazon/mShop/home/HomeView;

    .line 272
    .local v1, "homeView":Lcom/amazon/mShop/home/HomeView;
    invoke-virtual {v1}, Lcom/amazon/mShop/home/HomeView;->postHomePageImpression()V

    goto :goto_0

    .line 278
    .end local v0    # "currentView":Landroid/view/View;
    .end local v1    # "homeView":Lcom/amazon/mShop/home/HomeView;
    :cond_4
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    goto :goto_0
.end method

.method protected handleForceSignIn()V
    .locals 1

    .prologue
    .line 331
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->needSigninPrompt()Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mLaunchSignInPrompt:Z

    .line 332
    return-void
.end method

.method protected insertErrorBox(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 306
    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 307
    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/home/HomeView;->insertErrorBox(Landroid/view/View;)V

    .line 312
    :goto_0
    return-void

    .line 309
    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->insertErrorBox(Landroid/view/View;)V

    goto :goto_0
.end method

.method public isHomeActivityJustCreated()Z
    .locals 1

    .prologue
    .line 118
    iget-boolean v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mJustCreated:Z

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 336
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/AmazonActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 337
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mLaunchSignInPrompt:Z

    .line 338
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 133
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 134
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/mShop/home/GatewayActivity;->mJustCreated:Z

    .line 137
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 138
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "INTENT_EXTRA_STARTED_NO_NEED_COUNT_APPSTART"

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 139
    .local v1, "noNeedCountAppStart":Z
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/control/home/HomeController;->setNoNeedCountAppStart(Z)V

    .line 141
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/home/GatewayActivity;->setStopBehavior(I)V

    .line 145
    new-instance v2, Lcom/amazon/mShop/TimeChangedReceiver;

    invoke-direct {v2}, Lcom/amazon/mShop/TimeChangedReceiver;-><init>()V

    iput-object v2, p0, Lcom/amazon/mShop/home/GatewayActivity;->mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

    .line 146
    iget-object v2, p0, Lcom/amazon/mShop/home/GatewayActivity;->mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

    sget-object v3, Lcom/amazon/mShop/TimeChangedReceiver;->INTENT_FILTER:Landroid/content/IntentFilter;

    invoke-virtual {p0, v2, v3}, Lcom/amazon/mShop/home/GatewayActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 150
    invoke-static {}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->populateCachedFiles()V

    .line 154
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 205
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 208
    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeView;->destroy()V

    .line 210
    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/GatewayActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 211
    iput-object v1, p0, Lcom/amazon/mShop/home/GatewayActivity;->mTimeChangedReceiver:Lcom/amazon/mShop/TimeChangedReceiver;

    .line 212
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 213
    invoke-static {v1}, Lcom/amazon/mShop/control/home/HomeController;->setInstance(Lcom/amazon/mShop/control/home/HomeController;)V

    .line 225
    invoke-static {}, Lcom/amazon/mShop/home/GatewayActivity;->isNeedRestart()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 226
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/amazon/mShop/home/GatewayActivity;->setNeedRestart(Z)V

    .line 227
    invoke-static {p0}, Lcom/amazon/mShop/util/AppUtils;->launchApp(Landroid/content/Context;)V

    .line 229
    :cond_0
    return-void
.end method

.method public onEulaAccepted()V
    .locals 3

    .prologue
    .line 290
    new-instance v1, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/HomeView;

    const/4 v2, 0x1

    invoke-direct {v1, p0, v0, v2}, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/DelayedInitView;Z)V

    .line 291
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 95
    const-string/jumbo v3, "newIntentOrigin"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 97
    .local v1, "newIntentOrigin":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ViewAnimator;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 98
    .local v2, "view":Landroid/view/View;
    const-string/jumbo v3, "home"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 99
    instance-of v3, v2, Lcom/amazon/mShop/home/HomeView;

    if-eqz v3, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ViewAnimator;->getChildCount()I

    move-result v3

    const/4 v4, 0x1

    if-le v3, v4, :cond_0

    move-object v0, v2

    .line 100
    check-cast v0, Lcom/amazon/mShop/home/HomeView;

    .line 101
    .local v0, "homeView":Lcom/amazon/mShop/home/HomeView;
    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeView;->postHomePageImpression()V

    .line 105
    .end local v0    # "homeView":Lcom/amazon/mShop/home/HomeView;
    :cond_0
    instance-of v3, v2, Lcom/amazon/mShop/home/HomeView;

    if-eqz v3, :cond_1

    move-object v0, v2

    .line 107
    check-cast v0, Lcom/amazon/mShop/home/HomeView;

    .line 108
    .restart local v0    # "homeView":Lcom/amazon/mShop/home/HomeView;
    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeView;->scollToTop()V

    .line 111
    .end local v0    # "homeView":Lcom/amazon/mShop/home/HomeView;
    :cond_1
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 112
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 57
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 62
    invoke-static {}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->getInstance()Lcom/amazon/mShop/home/GatewayWeblabUtil;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->updateGatewayWeblabState()Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    move-result-object v0

    .line 63
    .local v0, "featureStateChangeType":Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    instance-of v1, v1, Lcom/amazon/mShop/home/HomeView;

    if-eqz v1, :cond_3

    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->NO_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    if-eq v1, v0, :cond_3

    iget-boolean v1, p0, Lcom/amazon/mShop/home/GatewayActivity;->mLaunchSignInPrompt:Z

    if-nez v1, :cond_3

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->needSigninPrompt()Z

    move-result v1

    if-nez v1, :cond_3

    .line 65
    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->TREATMENT_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    if-ne v1, v0, :cond_2

    .line 67
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->reloadHomeActivity(Lcom/amazon/mShop/AmazonActivity;)V

    .line 88
    :cond_0
    :goto_0
    iget-boolean v1, p0, Lcom/amazon/mShop/home/GatewayActivity;->mNeedFetchMenusFromServer:Z

    if-eqz v1, :cond_1

    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 89
    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->getInstance()Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->uploadCrashReportAsync()V

    .line 91
    :cond_1
    return-void

    .line 68
    :cond_2
    sget-object v1, Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;->CACHETIMESTAMP_CHANGE:Lcom/amazon/mShop/feature/Features$FeatureStateChangeType;

    if-ne v1, v0, :cond_0

    .line 70
    invoke-static {}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->getInstance()Lcom/amazon/mShop/home/GatewayWeblabUtil;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->postGatewayFeatureTrigger(Z)V

    goto :goto_0

    .line 77
    :cond_3
    iget-boolean v1, p0, Lcom/amazon/mShop/home/GatewayActivity;->mLaunchSignInPrompt:Z

    if-eqz v1, :cond_4

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v1

    if-nez v1, :cond_4

    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSignInPrompt()Z

    move-result v1

    if-nez v1, :cond_0

    .line 81
    :cond_4
    invoke-direct {p0}, Lcom/amazon/mShop/home/GatewayActivity;->checkAndShowShortcutInstallDialog()V

    goto :goto_0
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 285
    iget-boolean v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mLaunchSignInPrompt:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onSearchRequested()Z

    move-result v0

    goto :goto_0
.end method

.method protected onStart()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 181
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 182
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->removeTemporaryBlankView()V

    .line 183
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 184
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    iget-boolean v2, p0, Lcom/amazon/mShop/home/GatewayActivity;->mLaunchSignInPrompt:Z

    if-nez v2, :cond_0

    const-string/jumbo v2, "upgradeShouldShowDialog"

    invoke-interface {v0, v2, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string/jumbo v2, "upgradeLastDialogTime"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    const-wide/32 v4, 0x48190800

    invoke-static {v2, v3, v4, v5}, Lcom/amazon/mShop/util/UpgradeUtil;->checkTimeout(JJ)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 187
    invoke-static {p0}, Lcom/amazon/mShop/util/UpgradeUtil;->showUpgradeNotificationDialog(Landroid/content/Context;)V

    .line 190
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    .line 191
    .local v1, "top":Landroid/view/View;
    if-nez v1, :cond_2

    .line 192
    iput-boolean v6, p0, Lcom/amazon/mShop/home/GatewayActivity;->mNeedFetchMenusFromServer:Z

    .line 194
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->home_v2:I

    const/4 v3, 0x0

    invoke-static {p0, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/home/HomeView;

    iput-object v2, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    .line 195
    iget-object v2, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/home/GatewayActivity;->setRootView(Landroid/view/View;)V

    .line 201
    .end local v1    # "top":Landroid/view/View;
    :cond_1
    :goto_0
    return-void

    .line 196
    .restart local v1    # "top":Landroid/view/View;
    :cond_2
    instance-of v2, v1, Lcom/amazon/mShop/home/HomeView;

    if-eqz v2, :cond_1

    .line 197
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/mShop/home/GatewayActivity;->mNeedFetchMenusFromServer:Z

    .line 198
    check-cast v1, Lcom/amazon/mShop/home/HomeView;

    .end local v1    # "top":Landroid/view/View;
    iput-object v1, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    .line 199
    new-instance v2, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;

    iget-object v3, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    invoke-direct {v2, p0, v3, v6}, Lcom/amazon/mShop/AmazonActivity$DelayedInitializer;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/DelayedInitView;Z)V

    goto :goto_0
.end method

.method public pushView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 297
    const/4 v0, -0x1

    invoke-virtual {p1, v0}, Landroid/view/View;->setBackgroundColor(I)V

    .line 298
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 299
    return-void
.end method

.method protected removeErrorBox(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 319
    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 320
    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayActivity;->mHomeView:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/home/HomeView;->removeErrorBox(Landroid/view/View;)V

    .line 324
    :goto_0
    return-void

    .line 322
    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->removeErrorBox(Landroid/view/View;)V

    goto :goto_0
.end method

.method public setHomeActivityJustCreated(Z)V
    .locals 0
    .param p1, "justCreated"    # Z

    .prologue
    .line 122
    iput-boolean p1, p0, Lcom/amazon/mShop/home/GatewayActivity;->mJustCreated:Z

    .line 123
    return-void
.end method

.method protected updateGNOMenuItems()V
    .locals 2

    .prologue
    .line 342
    invoke-virtual {p0}, Lcom/amazon/mShop/home/GatewayActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    .line 343
    .local v0, "gnoDrawer":Lcom/amazon/mShop/gno/GNODrawer;
    if-eqz v0, :cond_0

    .line 347
    iget-boolean v1, p0, Lcom/amazon/mShop/home/GatewayActivity;->mNeedFetchMenusFromServer:Z

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->updateMenuItems(Z)V

    .line 349
    :cond_0
    return-void
.end method
