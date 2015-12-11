.class final enum Lcom/amazon/mShop/sso/IdentityType$2;
.super Lcom/amazon/mShop/sso/IdentityType;
.source "IdentityType.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/IdentityType;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 450
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/mShop/sso/IdentityType;-><init>(Ljava/lang/String;ILcom/amazon/mShop/sso/IdentityType$1;)V

    return-void
.end method

.method private ignoreNewAddedAccount(Ljava/lang/String;)Z
    .locals 5
    .param p1, "newAddedAccount"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 530
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->isLoginTriggeredFromApplication()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 533
    invoke-static {v3}, Lcom/amazon/mShop/sso/SSOUtil;->setLoginTriggeredFromApplication(Z)V

    .line 543
    :cond_0
    :goto_0
    return v2

    .line 536
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v1

    .line 537
    .local v1, "currentAuthPool":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolFromAccount(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 539
    .local v0, "accountAuthPool":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 540
    const-string/jumbo v0, "Amazon"

    .line 543
    :cond_2
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    move v2, v3

    goto :goto_0
.end method


# virtual methods
.method public handleBackgroundService(Lcom/amazon/mShop/sso/SSOBackgroundAccountService;Landroid/content/Intent;)V
    .locals 8
    .param p1, "ssoBackgroundAccountService"    # Lcom/amazon/mShop/sso/SSOBackgroundAccountService;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v7, 0x0

    .line 455
    invoke-virtual {p1}, Lcom/amazon/mShop/sso/SSOBackgroundAccountService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 456
    .local v1, "applicationContext":Landroid/content/Context;
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 457
    .local v0, "actionName":Ljava/lang/String;
    const-string/jumbo v4, "com.amazon.dcp.sso.extra.account.directed_id"

    invoke-virtual {p2, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 459
    .local v2, "changedAccount":Ljava/lang/String;
    sget-boolean v4, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v4, :cond_0

    .line 460
    const-string/jumbo v4, "Amazon.SSOUtil"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "changedAccount = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 466
    :cond_0
    const-string/jumbo v4, "com.amazon.dcp.sso.action.account.removed"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 467
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getPreviouslySeenAmazonAccount()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 468
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->isLogoutTriggeredFromApplication()Z

    move-result v4

    if-nez v4, :cond_1

    .line 472
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->clearMShopUserDataInWorldwideAuthPool(Landroid/content/Context;)V

    .line 475
    invoke-static {v1}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->fetchNonAuthCookies(Landroid/content/Context;)V

    .line 477
    const-string/jumbo v4, ""

    invoke-static {v1, v4}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    .line 479
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v4

    invoke-virtual {v4, v1}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 481
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    new-instance v5, Lcom/amazon/mShop/sso/IdentityType$2$1;

    invoke-direct {v5, p0, v1}, Lcom/amazon/mShop/sso/IdentityType$2$1;-><init>(Lcom/amazon/mShop/sso/IdentityType$2;Landroid/content/Context;)V

    invoke-interface {v4, v5}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 490
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 491
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v3

    .line 492
    .local v3, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v3}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->enbleNotificationForAnonymousCustomer()V

    .line 496
    .end local v3    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :cond_1
    invoke-static {v7}, Lcom/amazon/mShop/sso/SSOUtil;->setLogoutTriggeredFromApplication(Z)V

    .line 500
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->removePreviousAccountInWorldwideAuthPool()V

    .line 527
    :cond_2
    :goto_0
    return-void

    .line 505
    :cond_3
    const-string/jumbo v4, "com.amazon.dcp.sso.action.account.added"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 506
    invoke-direct {p0, v2}, Lcom/amazon/mShop/sso/IdentityType$2;->ignoreNewAddedAccount(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 512
    sget-boolean v4, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v4, :cond_4

    .line 513
    const-string/jumbo v4, "Amazon.SSOUtil"

    const-string/jumbo v5, "Handle account registration in BackgroundService "

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 517
    :cond_4
    const/4 v4, 0x1

    invoke-static {v1, v7, v4, v2}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;)V

    .line 519
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v4

    invoke-virtual {v4, v1}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    .line 522
    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->startHomeCall(Landroid/content/Context;)V

    .line 524
    invoke-static {v1}, Lcom/amazon/mShop/ActivityTerminationReceiver;->sendTerminationBroadcast(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public handleSSOInit(Landroid/content/Context;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v8, 0x1

    .line 549
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 551
    .local v0, "applicationContext":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 553
    sget-boolean v6, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v6, :cond_0

    .line 554
    const-string/jumbo v6, "Amazon.SSOUtil"

    const-string/jumbo v7, "SSO.init"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 555
    invoke-static {}, Lcom/amazon/mShop/sso/DebugListener;->init()V

    .line 558
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    .line 559
    .local v2, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getPreviouslySeenAmazonAccount()Ljava/lang/String;

    move-result-object v4

    .line 560
    .local v4, "previousAccount":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->selectMatchedAccount()Ljava/lang/String;

    move-result-object v5

    .line 562
    .local v5, "selectedAccount":Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 564
    if-nez v4, :cond_2

    .line 565
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->clearMShopUserDataInWorldwideAuthPool(Landroid/content/Context;)V

    .line 568
    invoke-static {v0}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->fetchNonAuthCookies(Landroid/content/Context;)V

    .line 569
    const-string/jumbo v6, ""

    invoke-static {p1, v6}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    .line 598
    :cond_1
    :goto_0
    return-void

    .line 570
    :cond_2
    const-string/jumbo v6, ""

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 573
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->clearMShopUserDataInWorldwideAuthPool(Landroid/content/Context;)V

    .line 575
    invoke-static {v0}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->fetchNonAuthCookies(Landroid/content/Context;)V

    .line 576
    const-string/jumbo v6, ""

    invoke-static {p1, v6}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 579
    :cond_3
    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 581
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->clearMShopUserDataInWorldwideAuthPool(Landroid/content/Context;)V

    .line 584
    invoke-static {v0, v8, v8, v5}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;)V

    goto :goto_0

    .line 592
    :cond_4
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v1

    .line 593
    .local v1, "currentAuthPool":Ljava/lang/String;
    const-string/jumbo v6, "ignoreOptOutFirstLaunch"

    invoke-interface {v2, v6, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    .line 594
    .local v3, "ignoreSSOOptOut":Z
    if-nez v3, :cond_1

    .line 595
    const/4 v6, 0x0

    invoke-static {v0, v6, v8, v5}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;)V

    goto :goto_0
.end method

.method public handleSSOLogin(Landroid/app/Activity;)V
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v2, 0x0

    .line 609
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v3, v2

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/sso/IdentityType$2;->handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V

    .line 610
    return-void
.end method

.method public handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "userInitiatedLogin"    # Z
    .param p3, "forceSignIn"    # Z
    .param p4, "isCreateNewAccount"    # Z
    .param p5, "origin"    # Ljava/lang/String;

    .prologue
    .line 615
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 616
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "USER_INITIATED_LOGIN"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 617
    const-string/jumbo v1, "FORCE_SIGN_IN"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 618
    const-string/jumbo v1, "LOGIN_ORIGIN_KEY"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 619
    const-string/jumbo v1, "CREATE_NEW_ACCOUNT"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 620
    const-class v1, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v0, p1, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 621
    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 622
    return-void
.end method

.method public handleSSOLogin(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "origin"    # Ljava/lang/String;
    .param p3, "flag"    # I

    .prologue
    const/4 v2, 0x0

    .line 626
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 627
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "USER_INITIATED_LOGIN"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 628
    const-string/jumbo v1, "FORCE_SIGN_IN"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 629
    const-string/jumbo v1, "LOGIN_ORIGIN_KEY"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 630
    invoke-virtual {v0, p3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 631
    const-class v1, Lcom/amazon/mShop/sso/CentralSSOLoginActivity;

    invoke-virtual {v0, p1, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 632
    invoke-virtual {p1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 633
    return-void
.end method

.method public handleSSOLogout(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 2
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 637
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 638
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    .line 640
    return-void
.end method
