.class public Lcom/poshmark/ui/MainActivity;
.super Lcom/poshmark/ui/PMContainerActivity;
.source "MainActivity.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field public static final FEED_TAB_INDEX:I = 0x0

.field public static final NEWS_TAB_INDEX:I = 0x3

.field public static final SHOP_TAB_INDEX:I = 0x1

.field public static final SHOP_TAB_SEARCH_FLAG_KEY:Ljava/util/UUID;


# instance fields
.field NEWS_NOTIFICATION:I

.field PARTY_NOTIFICATION:I

.field activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

.field bNewListingCompleted:Z

.field currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

.field currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

.field currentTabIndex:I

.field delayedDeepLinkLaunchInfo:Lcom/poshmark/utils/DeepLinkLaunchInfo;

.field feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

.field isActivityBeingPoppedFromPMStack:Z

.field isActivityBeingResurrected:Z

.field private isBacktracking:Z

.field newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

.field sellTab:Lcom/poshmark/ui/customviews/PMTabButton;

.field sellTabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

.field shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

.field stack:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Lcom/poshmark/ui/customviews/PMTabButton;",
            ">;"
        }
    .end annotation
.end field

.field tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

.field tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

.field userTab:Lcom/poshmark/ui/customviews/PMTabButton;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 78
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/poshmark/ui/MainActivity;->SHOP_TAB_SEARCH_FLAG_KEY:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 68
    invoke-direct {p0}, Lcom/poshmark/ui/PMContainerActivity;-><init>()V

    .line 70
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/MainActivity;->stack:Ljava/util/Stack;

    .line 72
    iput v1, p0, Lcom/poshmark/ui/MainActivity;->PARTY_NOTIFICATION:I

    .line 73
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/MainActivity;->NEWS_NOTIFICATION:I

    .line 80
    iput-boolean v1, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingResurrected:Z

    .line 81
    iput-boolean v1, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingPoppedFromPMStack:Z

    .line 84
    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    .line 85
    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 86
    const/4 v0, -0x1

    iput v0, p0, Lcom/poshmark/ui/MainActivity;->currentTabIndex:I

    .line 87
    iput-boolean v1, p0, Lcom/poshmark/ui/MainActivity;->isBacktracking:Z

    .line 95
    iput-boolean v1, p0, Lcom/poshmark/ui/MainActivity;->bNewListingCompleted:Z

    .line 98
    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->delayedDeepLinkLaunchInfo:Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .line 784
    new-instance v0, Lcom/poshmark/ui/MainActivity$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/MainActivity$2;-><init>(Lcom/poshmark/ui/MainActivity;)V

    iput-object v0, p0, Lcom/poshmark/ui/MainActivity;->tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    .line 818
    new-instance v0, Lcom/poshmark/ui/MainActivity$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/MainActivity$3;-><init>(Lcom/poshmark/ui/MainActivity;)V

    iput-object v0, p0, Lcom/poshmark/ui/MainActivity;->sellTabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/MainActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/MainActivity;

    .prologue
    .line 68
    iget-boolean v0, p0, Lcom/poshmark/ui/MainActivity;->isBacktracking:Z

    return v0
.end method

.method static synthetic access$002(Lcom/poshmark/ui/MainActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/MainActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 68
    iput-boolean p1, p0, Lcom/poshmark/ui/MainActivity;->isBacktracking:Z

    return p1
.end method

.method private checkForCrashes()V
    .locals 2

    .prologue
    .line 551
    const-string v0, "01486de8725142766a044552d92ef77f"

    new-instance v1, Lcom/poshmark/utils/PMCrashManagerListener;

    invoke-direct {v1}, Lcom/poshmark/utils/PMCrashManagerListener;-><init>()V

    invoke-static {p0, v0, v1}, Lnet/hockeyapp/android/CrashManager;->register(Landroid/content/Context;Ljava/lang/String;Lnet/hockeyapp/android/CrashManagerListener;)V

    .line 552
    return-void
.end method

.method private clearAllNotifications()V
    .locals 3

    .prologue
    .line 378
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "notification"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 379
    .local v0, "mNotificationManager":Landroid/app/NotificationManager;
    invoke-virtual {v0}, Landroid/app/NotificationManager;->cancelAll()V

    .line 381
    invoke-static {}, Lcom/poshmark/utils/NMostRecentPushNotifications;->clearAllSavedPushNotifications()V

    .line 382
    return-void
.end method

.method private collapseAllStacks()V
    .locals 1

    .prologue
    .line 579
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMTabButton;->collapseFragmentStack()V

    .line 580
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMTabButton;->collapseFragmentStack()V

    .line 581
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMTabButton;->collapseFragmentStack()V

    .line 582
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->userTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMTabButton;->collapseFragmentStack()V

    .line 583
    return-void
.end method

.method private doPostLoginSteps()V
    .locals 6

    .prologue
    .line 529
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    const v4, 0x7f0c01fe

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTabBar;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTabButton;

    .line 530
    .local v2, "userTab":Lcom/poshmark/ui/customviews/PMTabButton;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "@"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setText(Ljava/lang/CharSequence;)V

    .line 532
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    const v4, 0x7f0c01fd

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTabBar;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTabButton;

    iput-object v3, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 533
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 534
    .local v0, "b":Landroid/os/Bundle;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/notifications?pageName=NEWS_ROOT"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 535
    .local v1, "url":Ljava/lang/String;
    const-string v3, "URL"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "https://www.poshmark.com"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 536
    const-string v3, "SHOW_REFRESH"

    const/4 v4, 0x1

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 537
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    const-class v4, Lcom/poshmark/ui/fragments/NewsPageFragment;

    invoke-virtual {v3, v4, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->setFragmentToLaunch(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 538
    return-void
.end method

.method private endKochavaSession()V
    .locals 1

    .prologue
    .line 347
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getKochavaTracker()Lcom/kochava/android/tracker/Feature;

    move-result-object v0

    invoke-virtual {v0}, Lcom/kochava/android/tracker/Feature;->endSession()V

    .line 348
    return-void
.end method

.method private fireBeacons()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 352
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    .line 353
    .local v1, "handler":Landroid/os/Handler;
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 354
    .local v0, "context":Landroid/content/Context;
    new-instance v2, Lcom/poshmark/ui/MainActivity$1;

    invoke-direct {v2, p0, v0}, Lcom/poshmark/ui/MainActivity$1;-><init>(Lcom/poshmark/ui/MainActivity;Landroid/content/Context;)V

    .line 361
    .local v2, "runnable":Ljava/lang/Runnable;
    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 363
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    if-nez v3, :cond_0

    .line 364
    new-instance v3, Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-direct {v3}, Lcom/poshmark/data_model/models/ActiveUserInfo;-><init>()V

    iput-object v3, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    .line 365
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    const-string v4, "direct"

    iput-object v4, v3, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    .line 367
    :cond_0
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-static {v5, v3}, Lcom/poshmark/http/api/PMApi;->becameActive(Lcom/poshmark/http/api/PMApiResponseHandler;Lcom/poshmark/data_model/models/ActiveUserInfo;)V

    .line 368
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    iget-object v3, v3, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    const-string v4, "push_ntf"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    iget-object v3, v3, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    const-string v4, "local_ntf"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 371
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-static {v3}, Lcom/poshmark/http/api/PMApi;->trackPushNotificationClick(Lcom/poshmark/data_model/models/ActiveUserInfo;)V

    .line 373
    :cond_2
    iput-object v5, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    .line 374
    return-void
.end method

.method private handleAppLaunchIntent(Landroid/content/Intent;)V
    .locals 13
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v12, 0x0

    const/4 v11, 0x1

    .line 439
    const-string v9, "NOTIFICATION_BUNDLE"

    invoke-virtual {p1, v9}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 440
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_5

    .line 441
    const-string v9, "IS_CONSUMED"

    const/4 v10, 0x0

    invoke-virtual {p1, v9, v10}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 442
    .local v1, "bConsumed":Z
    if-nez v1, :cond_1

    .line 443
    const-string v9, "TYPE"

    invoke-virtual {v0, v9}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v7

    .line 444
    .local v7, "notificationType":I
    iget v9, p0, Lcom/poshmark/ui/MainActivity;->PARTY_NOTIFICATION:I

    if-ne v7, v9, :cond_3

    .line 445
    new-instance v9, Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-direct {v9}, Lcom/poshmark/data_model/models/ActiveUserInfo;-><init>()V

    iput-object v9, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    .line 446
    iget-object v9, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    const-string v10, "local_ntf"

    iput-object v10, v9, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    .line 447
    const-string v9, "FRAGMENT_DATA"

    invoke-virtual {v0, v9}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 448
    .local v4, "fragment_bundle":Landroid/os/Bundle;
    const-string v9, "ID"

    invoke-virtual {v4, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 449
    .local v3, "eventId":Ljava/lang/String;
    iget-object v9, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-virtual {v9, v3}, Lcom/poshmark/data_model/models/ActiveUserInfo;->addLocalNotification(Ljava/lang/String;)V

    .line 450
    invoke-static {v3}, Lcom/poshmark/notifications/PMDisplayedAlerts;->isEventAlertDisplayed(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 451
    invoke-static {v3}, Lcom/poshmark/notifications/PMDisplayedAlerts;->addEventToDisplayedList(Ljava/lang/String;)V

    .line 453
    :cond_0
    invoke-static {}, Lcom/poshmark/utils/PoshLearnManager;->getInstance()Lcom/poshmark/utils/PoshLearnManager;

    move-result-object v9

    invoke-virtual {v9, v11}, Lcom/poshmark/utils/PoshLearnManager;->setDeepLinkLaunchFlag(Z)V

    .line 454
    const-string v9, "FRAGMENT"

    invoke-virtual {v0, v9}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v9

    check-cast v9, Ljava/lang/Class;

    invoke-virtual {p0, v4, v9, v12}, Lcom/poshmark/ui/MainActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 471
    .end local v3    # "eventId":Ljava/lang/String;
    .end local v4    # "fragment_bundle":Landroid/os/Bundle;
    .end local v7    # "notificationType":I
    :cond_1
    :goto_0
    const-string v9, "IS_CONSUMED"

    invoke-virtual {p1, v9, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 472
    invoke-virtual {p0, v12}, Lcom/poshmark/ui/MainActivity;->setIntent(Landroid/content/Intent;)V

    .line 487
    .end local v1    # "bConsumed":Z
    :cond_2
    :goto_1
    return-void

    .line 455
    .restart local v1    # "bConsumed":Z
    .restart local v7    # "notificationType":I
    :cond_3
    iget v9, p0, Lcom/poshmark/ui/MainActivity;->NEWS_NOTIFICATION:I

    if-ne v7, v9, :cond_1

    .line 456
    const-string v9, "PUSH_MESSAGE"

    invoke-virtual {v0, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 457
    .local v5, "message":Ljava/lang/String;
    const-string v9, "BADGE"

    invoke-virtual {v0, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 458
    .local v2, "badge":Ljava/lang/String;
    const-string v9, "PUSH_MESSAGE_TYPE"

    invoke-virtual {v0, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 459
    .local v6, "messageType":Ljava/lang/String;
    new-instance v9, Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-direct {v9}, Lcom/poshmark/data_model/models/ActiveUserInfo;-><init>()V

    iput-object v9, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    .line 460
    iget-object v9, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    const-string v10, "push_ntf"

    iput-object v10, v9, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    .line 461
    iget-object v9, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-virtual {v9, v5, v2, v6}, Lcom/poshmark/data_model/models/ActiveUserInfo;->addPushNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 462
    iget-object v9, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eqz v9, :cond_4

    .line 463
    iget-object v9, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v10, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eq v9, v10, :cond_1

    .line 464
    iget-object v9, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v10, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    goto :goto_0

    .line 467
    :cond_4
    const/4 v9, 0x3

    iput v9, p0, Lcom/poshmark/ui/MainActivity;->currentTabIndex:I

    goto :goto_0

    .line 475
    .end local v1    # "bConsumed":Z
    .end local v2    # "badge":Ljava/lang/String;
    .end local v5    # "message":Ljava/lang/String;
    .end local v6    # "messageType":Ljava/lang/String;
    .end local v7    # "notificationType":I
    :cond_5
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v8

    .line 476
    .local v8, "uri":Landroid/net/Uri;
    if-eqz v8, :cond_6

    .line 477
    invoke-virtual {p0, v8, v11}, Lcom/poshmark/ui/MainActivity;->handleDeepLinkLaunch(Landroid/net/Uri;Z)V

    .line 483
    :goto_2
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v9

    if-nez v9, :cond_2

    .line 484
    sget-object v9, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v9}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->fetchFbDeferredDeepLink()V

    goto :goto_1

    .line 479
    :cond_6
    new-instance v9, Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-direct {v9}, Lcom/poshmark/data_model/models/ActiveUserInfo;-><init>()V

    iput-object v9, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    .line 480
    iget-object v9, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    const-string v10, "direct"

    iput-object v10, v9, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    goto :goto_2
.end method

.method private handleNewsPushNotification(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    .line 522
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    sget v1, Lcom/poshmark/data_model/models/BadgeCount;->count:I

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTabButton;->setBadge(I)V

    .line 523
    return-void
.end method

.method private launchDeepLink(Lcom/poshmark/utils/DeepLinkLaunchInfo;)V
    .locals 3
    .param p1, "launchInfo"    # Lcom/poshmark/utils/DeepLinkLaunchInfo;

    .prologue
    .line 505
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 506
    iget-boolean v0, p1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->switchTabs:Z

    if-eqz v0, :cond_0

    .line 507
    iget v0, p1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->tab:I

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/MainActivity;->gotoTab(I)V

    .line 509
    :cond_0
    iget-object v0, p1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->fragmentClass:Ljava/lang/Class;

    if-eqz v0, :cond_1

    .line 510
    iget-object v0, p1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->bundle:Landroid/os/Bundle;

    iget-object v1, p1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->fragmentClass:Ljava/lang/Class;

    iget-object v2, p1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->data:Ljava/lang/Object;

    invoke-virtual {p0, v0, v1, v2}, Lcom/poshmark/ui/MainActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 516
    :cond_1
    :goto_0
    return-void

    .line 514
    :cond_2
    iput-object p1, p0, Lcom/poshmark/ui/MainActivity;->delayedDeepLinkLaunchInfo:Lcom/poshmark/utils/DeepLinkLaunchInfo;

    goto :goto_0
.end method

.method private registerForEvents()V
    .locals 0

    .prologue
    .line 548
    return-void
.end method

.method private registerForGCMNotifications()V
    .locals 2

    .prologue
    .line 541
    new-instance v0, Lcom/poshmark/utils/GCMUtils;

    invoke-direct {v0}, Lcom/poshmark/utils/GCMUtils;-><init>()V

    .line 542
    .local v0, "utils":Lcom/poshmark/utils/GCMUtils;
    invoke-virtual {v0, p0}, Lcom/poshmark/utils/GCMUtils;->checkPlayServices(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 543
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/GCMUtils;->registerWithGCM(Landroid/content/Context;)V

    .line 545
    :cond_0
    return-void
.end method

.method private saveResurectionType(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x0

    .line 140
    if-eqz p1, :cond_0

    .line 141
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingResurrected:Z

    .line 142
    const-string v0, "POPPED_FROM_STACK"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingPoppedFromPMStack:Z

    .line 146
    :goto_0
    const/4 v0, 0x0

    return-object v0

    .line 144
    :cond_0
    iput-boolean v1, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingResurrected:Z

    goto :goto_0
.end method

.method private setupPMTabs()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x1

    .line 626
    const v2, 0x7f0c004a

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTabBar;

    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    .line 629
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    const v3, 0x7f0c01fa

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabBar;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTabButton;

    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 630
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setTabListener(Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;)V

    .line 631
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 632
    .local v0, "b":Landroid/os/Bundle;
    iget-boolean v2, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingResurrected:Z

    if-eqz v2, :cond_1

    .line 633
    const-string v2, "RESURRECTION"

    invoke-virtual {v0, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 634
    iget-boolean v2, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingPoppedFromPMStack:Z

    if-eqz v2, :cond_0

    .line 635
    const-string v2, "FRAGMENT_BEING_POPPED_OFF_STACK"

    invoke-virtual {v0, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 642
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    const-class v3, Lcom/poshmark/ui/fragments/NewFeedFragment;

    invoke-virtual {v2, v3, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->setFragmentToLaunch(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 645
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    const v3, 0x7f0c01fb

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabBar;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTabButton;

    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 646
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setTabListener(Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;)V

    .line 647
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

    const-class v3, Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-virtual {v2, v3, v6}, Lcom/poshmark/ui/customviews/PMTabButton;->setFragmentToLaunch(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 650
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    const v3, 0x7f0c01fc

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabBar;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTabButton;

    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->sellTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 651
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->sellTab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->sellTabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setTabListener(Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;)V

    .line 654
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    const v3, 0x7f0c01fd

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabBar;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTabButton;

    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 655
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setTabListener(Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;)V

    .line 656
    new-instance v0, Landroid/os/Bundle;

    .end local v0    # "b":Landroid/os/Bundle;
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 657
    .restart local v0    # "b":Landroid/os/Bundle;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "/mapp/users/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/notifications?pageName=NEWS_ROOT"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 658
    .local v1, "url":Ljava/lang/String;
    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 659
    const-string v2, "SHOW_REFRESH"

    invoke-virtual {v0, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 660
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    const-class v3, Lcom/poshmark/ui/fragments/NewsPageFragment;

    invoke-virtual {v2, v3, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->setFragmentToLaunch(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 661
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    sget v3, Lcom/poshmark/data_model/models/BadgeCount;->count:I

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setBadge(I)V

    .line 664
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    const v3, 0x7f0c01fe

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabBar;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTabButton;

    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->userTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 665
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->userTab:Lcom/poshmark/ui/customviews/PMTabButton;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "@"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setText(Ljava/lang/CharSequence;)V

    .line 666
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->userTab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabListener:Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setTabListener(Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;)V

    .line 667
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->userTab:Lcom/poshmark/ui/customviews/PMTabButton;

    const-class v3, Lcom/poshmark/ui/fragments/UserSettingsFragment;

    invoke-virtual {v2, v3, v6}, Lcom/poshmark/ui/customviews/PMTabButton;->setFragmentToLaunch(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 668
    return-void

    .line 637
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    const-string v2, "FRAGMENT_BEING_POPPED_OFF_STACK"

    invoke-virtual {v0, v2, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 640
    :cond_1
    const-string v2, "RESURRECTION"

    invoke-virtual {v0, v2, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0
.end method

.method private setupUserTrackingSessions()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 326
    sget-object v1, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v2, Lcom/poshmark/config/Env;->PRODUCTION:Lcom/poshmark/config/Env;

    if-eq v1, v2, :cond_2

    .line 327
    invoke-static {p0, v3}, Lnet/singular/sdk/Singular;->initialize(Landroid/content/Context;Z)V

    .line 331
    :goto_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    .line 332
    .local v0, "session":Lcom/poshmark/application/PMApplicationSession;
    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v1

    if-ne v1, v3, :cond_1

    .line 333
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 334
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/mobileapptracker/MobileAppTracker;->setUserId(Ljava/lang/String;)V

    .line 337
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lnet/singular/sdk/Singular;->setCustomUserId(Ljava/lang/String;)V

    .line 339
    :cond_1
    return-void

    .line 329
    .end local v0    # "session":Lcom/poshmark/application/PMApplicationSession;
    :cond_2
    const/4 v1, 0x0

    invoke-static {p0, v1}, Lnet/singular/sdk/Singular;->initialize(Landroid/content/Context;Z)V

    goto :goto_0
.end method

.method private showPoshLearnScreen()V
    .locals 3

    .prologue
    .line 301
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 302
    invoke-static {}, Lcom/poshmark/utils/PoshLearnManager;->getInstance()Lcom/poshmark/utils/PoshLearnManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/PoshLearnManager;->shouldShowPoshLearnScreen()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 303
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/controllers/GlobalPartiesController;->disablePartyAlerts()V

    .line 304
    new-instance v0, Lcom/poshmark/utils/AppInfoCache;

    invoke-direct {v0}, Lcom/poshmark/utils/AppInfoCache;-><init>()V

    .line 305
    .local v0, "appInfoCache":Lcom/poshmark/utils/AppInfoCache;
    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/poshmark/utils/AppInfoCache;->setCurrentVersion(Ljava/lang/String;)V

    .line 306
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMTabButton;->getFragment()Lcom/poshmark/ui/fragments/RootTabFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/RootTabFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 307
    .local v1, "manager":Landroid/support/v4/app/FragmentManager;
    invoke-static {}, Lcom/poshmark/utils/PoshLearnManager;->getInstance()Lcom/poshmark/utils/PoshLearnManager;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/poshmark/utils/PoshLearnManager;->lauchPoshLearn(Landroid/support/v4/app/FragmentManager;)V

    .line 310
    .end local v0    # "appInfoCache":Lcom/poshmark/utils/AppInfoCache;
    .end local v1    # "manager":Landroid/support/v4/app/FragmentManager;
    :cond_0
    return-void
.end method

.method private startKochavaSession()V
    .locals 1

    .prologue
    .line 343
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getKochavaTracker()Lcom/kochava/android/tracker/Feature;

    move-result-object v0

    invoke-virtual {v0}, Lcom/kochava/android/tracker/Feature;->startSession()V

    .line 344
    return-void
.end method

.method private transitionTabsToInitialState()V
    .locals 0

    .prologue
    .line 688
    return-void
.end method


# virtual methods
.method public getCurrentRootFragment()Lcom/poshmark/ui/fragments/RootTabFragment;
    .locals 1

    .prologue
    .line 555
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    return-object v0
.end method

.method public getTabFromIndex(I)Lcom/poshmark/ui/customviews/PMTabButton;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 590
    const/4 v0, 0x0

    .line 591
    .local v0, "tab":Lcom/poshmark/ui/customviews/PMTabButton;
    packed-switch p1, :pswitch_data_0

    .line 602
    :goto_0
    :pswitch_0
    return-object v0

    .line 593
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 594
    goto :goto_0

    .line 596
    :pswitch_2
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 597
    goto :goto_0

    .line 599
    :pswitch_3
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    goto :goto_0

    .line 591
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public getVisibleFragment()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/RootTabFragment;->getCurrentActiveChildFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    return-object v0
.end method

.method public gotoFeedTab()V
    .locals 2

    .prologue
    .line 586
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 587
    return-void
.end method

.method public gotoTab(I)V
    .locals 2
    .param p1, "tabIndex"    # I

    .prologue
    .line 605
    packed-switch p1, :pswitch_data_0

    .line 623
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 607
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eq v0, v1, :cond_0

    .line 608
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    goto :goto_0

    .line 612
    :pswitch_2
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eq v0, v1, :cond_0

    .line 613
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    goto :goto_0

    .line 617
    :pswitch_3
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eq v0, v1, :cond_0

    .line 618
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    goto :goto_0

    .line 605
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public handleDeepLinkLaunch(Landroid/net/Uri;Z)V
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "isExternalLink"    # Z

    .prologue
    .line 490
    invoke-static {p1}, Lcom/poshmark/utils/DeepLinkUtils;->isValidDeepLink(Landroid/net/Uri;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 491
    invoke-static {p1}, Lcom/poshmark/utils/DeepLinkUtils;->getDeepLinkLaunchInfo(Landroid/net/Uri;)Lcom/poshmark/utils/DeepLinkLaunchInfo;

    move-result-object v0

    .line 492
    .local v0, "deepLinkInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    if-eqz v0, :cond_1

    .line 493
    if-eqz p2, :cond_0

    .line 494
    new-instance v1, Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/ActiveUserInfo;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    .line 495
    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    const-string v2, "deep_link"

    iput-object v2, v1, Lcom/poshmark/data_model/models/ActiveUserInfo;->type:Ljava/lang/String;

    .line 496
    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->activeUserInfo:Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/ActiveUserInfo;->addDeepLink(Ljava/lang/String;)V

    .line 498
    :cond_0
    invoke-static {}, Lcom/poshmark/utils/PoshLearnManager;->getInstance()Lcom/poshmark/utils/PoshLearnManager;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/PoshLearnManager;->setDeepLinkLaunchFlag(Z)V

    .line 499
    invoke-direct {p0, v0}, Lcom/poshmark/ui/MainActivity;->launchDeepLink(Lcom/poshmark/utils/DeepLinkLaunchInfo;)V

    .line 502
    .end local v0    # "deepLinkInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    :cond_1
    return-void
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 7
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v6, 0x1

    .line 393
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->isFinishing()Z

    move-result v4

    if-nez v4, :cond_7

    .line 394
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.poshmark.intents.INITIATE_LOGOUT"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 395
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->logout()V

    .line 435
    :cond_0
    :goto_0
    return-void

    .line 396
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.poshmark.intents.PUSH_NOTIFICATION"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 397
    const-string v4, "RESULT"

    invoke-virtual {p1, v4}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 398
    .local v0, "b":Landroid/os/Bundle;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/MainActivity;->handleNewsPushNotification(Landroid/os/Bundle;)V

    goto :goto_0

    .line 399
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.poshmark.intents.CLEAR_NEWS_BADGE"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 400
    invoke-static {}, Lcom/poshmark/data_model/models/BadgeCount;->resetCount()V

    .line 401
    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMTabButton;->clearBadge()V

    goto :goto_0

    .line 402
    :cond_3
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.poshmark.intents.NEW_BADGE_COUNT"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 403
    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->newsTab:Lcom/poshmark/ui/customviews/PMTabButton;

    sget v5, Lcom/poshmark/data_model/models/BadgeCount;->count:I

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/customviews/PMTabButton;->setBadge(I)V

    goto :goto_0

    .line 404
    :cond_4
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.poshmark.intents.SWITCH_TAB"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 405
    const-string v4, "RESULT"

    invoke-virtual {p1, v4}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 406
    .restart local v0    # "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 407
    const-string v4, "TAB_INDEX"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 408
    .local v3, "tabIndex":I
    if-ne v3, v6, :cond_5

    .line 411
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 412
    .local v2, "showRecentsOnEntry":Ljava/lang/Boolean;
    sget-object v4, Lcom/poshmark/ui/MainActivity;->SHOP_TAB_SEARCH_FLAG_KEY:Ljava/util/UUID;

    invoke-static {v4, v2}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 413
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/controllers/UserStateSummaryController;->refreshModels()V

    .line 416
    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->shopTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/PMTabButton;->getFragment()Lcom/poshmark/ui/fragments/RootTabFragment;

    move-result-object v1

    .line 417
    .local v1, "shopRoot":Lcom/poshmark/ui/fragments/RootTabFragment;
    if-eqz v1, :cond_5

    .line 418
    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/RootTabFragment;->popFragmentsToTop()V

    .line 422
    .end local v1    # "shopRoot":Lcom/poshmark/ui/fragments/RootTabFragment;
    .end local v2    # "showRecentsOnEntry":Ljava/lang/Boolean;
    :cond_5
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->isActivityInForeground()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 423
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/MainActivity;->gotoTab(I)V

    goto :goto_0

    .line 426
    :cond_6
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/MainActivity;->getTabFromIndex(I)Lcom/poshmark/ui/customviews/PMTabButton;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    goto/16 :goto_0

    .line 433
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v3    # "tabIndex":I
    :cond_7
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v4

    invoke-virtual {v4, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    goto/16 :goto_0
.end method

.method public launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    .locals 6
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;

    .prologue
    .line 725
    :try_start_0
    const-class v4, Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    if-eq p2, v4, :cond_0

    const-class v4, Lcom/poshmark/ui/fragments/ListingEditorFragment;

    if-eq p2, v4, :cond_0

    const-class v4, Lcom/poshmark/ui/fragments/ClosetFragment;

    if-ne p2, v4, :cond_3

    .line 726
    :cond_0
    new-instance v3, Landroid/content/Intent;

    const-class v4, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v3, p0, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 727
    .local v3, "intent":Landroid/content/Intent;
    const-string v4, "FRAGMENT"

    invoke-virtual {v3, v4, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 728
    const-string v4, "FRAGMENT_DATA"

    invoke-virtual {v3, v4, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 729
    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->descendants:Ljava/util/List;

    if-eqz v4, :cond_1

    .line 730
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v2

    .line 731
    .local v2, "id":Ljava/util/UUID;
    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->descendants:Ljava/util/List;

    invoke-static {v2, v4}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 732
    const-string v4, "SCREENSTACK"

    new-instance v5, Landroid/os/ParcelUuid;

    invoke-direct {v5, v2}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 734
    .end local v2    # "id":Ljava/util/UUID;
    :cond_1
    const-class v4, Lcom/poshmark/ui/fragments/ListingEditorFragment;

    if-ne p2, v4, :cond_2

    .line 735
    const/16 v4, 0x65

    invoke-virtual {p0, v3, v4}, Lcom/poshmark/ui/MainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 758
    .end local v3    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 737
    .restart local v3    # "intent":Landroid/content/Intent;
    :cond_2
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/MainActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 751
    .end local v3    # "intent":Landroid/content/Intent;
    :catch_0
    move-exception v0

    .line 753
    .local v0, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 741
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :cond_3
    :try_start_1
    invoke-virtual {p2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 742
    .local v1, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {v1, p1}, Lcom/poshmark/ui/fragments/PMFragment;->setArguments(Landroid/os/Bundle;)V

    .line 743
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 744
    if-eqz p3, :cond_4

    .line 745
    invoke-virtual {v1, p3}, Lcom/poshmark/ui/fragments/PMFragment;->setFragmentData(Ljava/lang/Object;)V

    .line 747
    :cond_4
    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->descendants:Ljava/util/List;

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/fragments/PMFragment;->setNavigationList(Ljava/util/List;)V

    .line 748
    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v4, v1}, Lcom/poshmark/ui/fragments/RootTabFragment;->startChildFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    :try_end_1
    .catch Ljava/lang/InstantiationException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 754
    .end local v1    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    :catch_1
    move-exception v0

    .line 756
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method

.method public launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V
    .locals 3
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;
    .param p4, "callingFragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p5, "requestCode"    # I

    .prologue
    .line 695
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 696
    .local v1, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {v1, p4, p5}, Lcom/poshmark/ui/fragments/PMFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 697
    invoke-virtual {v1, p1}, Lcom/poshmark/ui/fragments/PMFragment;->setArguments(Landroid/os/Bundle;)V

    .line 698
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 699
    if-eqz p3, :cond_0

    .line 700
    invoke-virtual {v1, p3}, Lcom/poshmark/ui/fragments/PMFragment;->setFragmentData(Ljava/lang/Object;)V

    .line 702
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->descendants:Ljava/util/List;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->setNavigationList(Ljava/util/List;)V

    .line 704
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v2, v1}, Lcom/poshmark/ui/fragments/RootTabFragment;->startChildFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 711
    .end local v1    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    :goto_0
    return-void

    .line 706
    :catch_0
    move-exception v0

    .line 707
    .local v0, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 708
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v0

    .line 709
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method

.method public launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    .locals 1
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;

    .prologue
    .line 715
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 716
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingPoppedFromPMStack:Z

    .line 717
    return-void
.end method

.method public logout()V
    .locals 4

    .prologue
    .line 560
    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 562
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->collapseAllStacks()V

    .line 564
    invoke-static {}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->getSyncronousBroadcastManager()Lcom/poshmark/notifications/SynchronousBroadcastManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.LOGOUT_COMPLETE"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->sendSynchronousBroadcast(Ljava/lang/String;Ljava/lang/Object;)V

    .line 566
    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-static {v1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 569
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->logout()V

    .line 570
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->logout()V

    .line 573
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 574
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "FRAGMENT"

    const-class v2, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 575
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/MainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 576
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v1, 0x1

    .line 152
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/PMContainerActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 154
    if-ne p1, v1, :cond_1

    const/4 v0, 0x2

    if-ne p2, v0, :cond_1

    .line 159
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->finish()V

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 161
    :cond_1
    const/16 v0, 0x65

    if-ne p1, v0, :cond_0

    const/16 v0, 0x66

    if-ne p2, v0, :cond_0

    .line 162
    iput-boolean v1, p0, Lcom/poshmark/ui/MainActivity;->bNewListingCompleted:Z

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 175
    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/RootTabFragment;->handleBackPressed()Z

    move-result v1

    if-nez v1, :cond_0

    .line 177
    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->stack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->empty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 178
    invoke-super {p0}, Lcom/poshmark/ui/PMContainerActivity;->onBackPressed()V

    .line 189
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->stack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTabButton;

    .line 183
    .local v0, "tab":Lcom/poshmark/ui/customviews/PMTabButton;
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/ui/MainActivity;->isBacktracking:Z

    .line 186
    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 124
    invoke-direct {p0, p1}, Lcom/poshmark/ui/MainActivity;->saveResurectionType(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    invoke-super {p0, v0}, Lcom/poshmark/ui/PMContainerActivity;->onCreate(Landroid/os/Bundle;)V

    .line 126
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->registerForGCMNotifications()V

    .line 127
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->setupUserTrackingSessions()V

    .line 129
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    invoke-static {v0}, Lcom/poshmark/config/NewRelicWrapper;->initNewRelic(Landroid/content/Context;)V

    .line 131
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/application/PMApplication;->setActivity(Lcom/poshmark/ui/MainActivity;)V

    .line 132
    const v0, 0x7f030007

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/MainActivity;->setContentView(I)V

    .line 134
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->registerForEvents()V

    .line 135
    const-string v0, "com.poshmark.intents.APP_STARTED"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 136
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/poshmark/ui/MainActivity;->handleAppLaunchIntent(Landroid/content/Intent;)V

    .line 137
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 200
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const/high16 v1, 0x7f0b0000

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 201
    const/4 v0, 0x0

    return v0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 386
    invoke-super {p0}, Lcom/poshmark/ui/PMContainerActivity;->onDestroy()V

    .line 387
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 388
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/analytics/Analytics;->onDestroy()V

    .line 389
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 102
    invoke-super {p0, p1}, Lcom/poshmark/ui/PMContainerActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 103
    invoke-direct {p0, p1}, Lcom/poshmark/ui/MainActivity;->handleAppLaunchIntent(Landroid/content/Intent;)V

    .line 104
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 207
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 222
    :goto_0
    invoke-super {p0, p1}, Lcom/poshmark/ui/PMContainerActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    return v1

    .line 209
    :pswitch_0
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->logout()V

    .line 210
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->logout()V

    .line 211
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->transitionTabsToInitialState()V

    .line 214
    const-string v1, "com.poshmark.intents.COLLAPSE_ALL_SUBFRAGMENTS"

    invoke-static {v1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 216
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 217
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "FRAGMENT"

    const-class v2, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 218
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/MainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 207
    nop

    :pswitch_data_0
    .packed-switch 0x7f0c031a
        :pswitch_0
    .end packed-switch
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 314
    invoke-super {p0}, Lcom/poshmark/ui/PMContainerActivity;->onPause()V

    .line 315
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.INITIATE_LOGOUT"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unRegisterForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 316
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PUSH_NOTIFICATION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unRegisterForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 317
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.CLEAR_NEWS_BADGE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unRegisterForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 318
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.NEW_BADGE_COUNT"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unRegisterForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 319
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SWITCH_TAB"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unRegisterForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 321
    invoke-static {}, Lnet/singular/sdk/Singular;->onPause()V

    .line 322
    return-void
.end method

.method public onResume()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    const/4 v5, -0x1

    .line 228
    invoke-super {p0}, Lcom/poshmark/ui/PMContainerActivity;->onResume()V

    .line 230
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v3

    const-string v4, "com.poshmark.intents.INITIATE_LOGOUT"

    invoke-virtual {v3, v4, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 231
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v3

    const-string v4, "com.poshmark.intents.PUSH_NOTIFICATION"

    invoke-virtual {v3, v4, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 232
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v3

    const-string v4, "com.poshmark.intents.CLEAR_NEWS_BADGE"

    invoke-virtual {v3, v4, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 233
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v3

    const-string v4, "com.poshmark.intents.NEW_BADGE_COUNT"

    invoke-virtual {v3, v4, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 234
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v3

    const-string v4, "com.poshmark.intents.SWITCH_TAB"

    invoke-virtual {v3, v4, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 235
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v3

    const-string v4, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v3, v4, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 238
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 239
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v3

    invoke-virtual {v3}, Lcom/mobileapptracker/MobileAppTracker;->measureSession()V

    .line 241
    :cond_0
    invoke-static {}, Lnet/singular/sdk/Singular;->onResume()V

    .line 242
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->isFinishing()Z

    move-result v3

    if-nez v3, :cond_2

    .line 243
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->fireBeacons()V

    .line 244
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->clearAllNotifications()V

    .line 245
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->checkForCrashes()V

    .line 246
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->setupPMTabs()V

    .line 248
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eqz v3, :cond_4

    .line 249
    iget-boolean v3, p0, Lcom/poshmark/ui/MainActivity;->bNewListingCompleted:Z

    if-eqz v3, :cond_3

    .line 250
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->gotoFeedTab()V

    .line 251
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/RootTabFragment;->collapseAllSubfragments()V

    .line 252
    const-string v3, "com.poshmark.intents.LISTING_CREATED"

    invoke-static {v3}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 274
    :cond_1
    :goto_0
    iput-boolean v6, p0, Lcom/poshmark/ui/MainActivity;->bNewListingCompleted:Z

    .line 275
    iput-boolean v6, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingPoppedFromPMStack:Z

    .line 278
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    .line 279
    .local v2, "session":Lcom/poshmark/application/PMApplicationSession;
    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v3

    if-nez v3, :cond_7

    .line 280
    new-instance v0, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v0, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 281
    .local v0, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    const-class v4, Lcom/poshmark/ui/fragments/SignInSignUpWallFragment;

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 282
    const/4 v3, 0x1

    invoke-virtual {p0, v0, v3}, Lcom/poshmark/ui/MainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 298
    .end local v0    # "intent":Landroid/content/Intent;
    .end local v2    # "session":Lcom/poshmark/application/PMApplicationSession;
    :cond_2
    :goto_1
    return-void

    .line 255
    :cond_3
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMTabBar;->getActiveTab()Lcom/poshmark/ui/customviews/PMTabButton;

    move-result-object v1

    .line 256
    .local v1, "selTab":Lcom/poshmark/ui/customviews/PMTabButton;
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eq v1, v3, :cond_1

    .line 257
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    goto :goto_0

    .line 261
    .end local v1    # "selTab":Lcom/poshmark/ui/customviews/PMTabButton;
    :cond_4
    iget v3, p0, Lcom/poshmark/ui/MainActivity;->currentTabIndex:I

    if-eq v3, v5, :cond_6

    .line 262
    iget v3, p0, Lcom/poshmark/ui/MainActivity;->currentTabIndex:I

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/MainActivity;->getTabFromIndex(I)Lcom/poshmark/ui/customviews/PMTabButton;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 264
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMTabBar;->getActiveTab()Lcom/poshmark/ui/customviews/PMTabButton;

    move-result-object v1

    .line 265
    .restart local v1    # "selTab":Lcom/poshmark/ui/customviews/PMTabButton;
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eq v1, v3, :cond_5

    .line 266
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 268
    :cond_5
    iput v5, p0, Lcom/poshmark/ui/MainActivity;->currentTabIndex:I

    goto :goto_0

    .line 270
    .end local v1    # "selTab":Lcom/poshmark/ui/customviews/PMTabButton;
    :cond_6
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->tabBar:Lcom/poshmark/ui/customviews/PMTabBar;

    iget-object v4, p0, Lcom/poshmark/ui/MainActivity;->feedtab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    goto :goto_0

    .line 286
    .restart local v2    # "session":Lcom/poshmark/application/PMApplicationSession;
    :cond_7
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->refreshAndSyncFbTokenState()V

    .line 288
    invoke-direct {p0}, Lcom/poshmark/ui/MainActivity;->showPoshLearnScreen()V

    .line 290
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v3

    invoke-virtual {v3, v7}, Lcom/poshmark/controllers/GlobalPartiesController;->firePartyAlert(Landroid/os/Bundle;)V

    .line 292
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->delayedDeepLinkLaunchInfo:Lcom/poshmark/utils/DeepLinkLaunchInfo;

    if-eqz v3, :cond_2

    .line 293
    iget-object v3, p0, Lcom/poshmark/ui/MainActivity;->delayedDeepLinkLaunchInfo:Lcom/poshmark/utils/DeepLinkLaunchInfo;

    invoke-direct {p0, v3}, Lcom/poshmark/ui/MainActivity;->launchDeepLink(Lcom/poshmark/utils/DeepLinkLaunchInfo;)V

    .line 294
    iput-object v7, p0, Lcom/poshmark/ui/MainActivity;->delayedDeepLinkLaunchInfo:Lcom/poshmark/utils/DeepLinkLaunchInfo;

    goto :goto_1
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 168
    invoke-super {p0, p1}, Lcom/poshmark/ui/PMContainerActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 169
    const-string v0, "POPPED_FROM_STACK"

    iget-boolean v1, p0, Lcom/poshmark/ui/MainActivity;->isActivityBeingPoppedFromPMStack:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 170
    return-void
.end method

.method public onStart()V
    .locals 3

    .prologue
    .line 108
    invoke-super {p0}, Lcom/poshmark/ui/PMContainerActivity;->onStart()V

    .line 109
    sget-object v1, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    .line 110
    .local v1, "manager":Lcom/poshmark/utils/DeferredDeepLinkManager;
    invoke-virtual {p0}, Lcom/poshmark/ui/MainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 111
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 112
    invoke-virtual {v0}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/utils/DeferredDeepLinkManager;->init(Landroid/net/Uri;Landroid/app/Activity;)V

    .line 114
    :cond_0
    return-void
.end method

.method public popTopFragment()V
    .locals 3

    .prologue
    .line 810
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMTabButton;->getFragment()Lcom/poshmark/ui/fragments/RootTabFragment;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    .line 811
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/RootTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 812
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 813
    .local v0, "count":I
    const/4 v2, 0x1

    if-le v0, v2, :cond_0

    .line 814
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 816
    :cond_0
    return-void
.end method

.method public pushCurrentTabToStack()V
    .locals 2

    .prologue
    .line 671
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eqz v0, :cond_0

    .line 672
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->stack:Ljava/util/Stack;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0, v1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 674
    :cond_0
    return-void
.end method

.method public removeVisitedTabFromStack(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 1
    .param p1, "tab"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 678
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->stack:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 679
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity;->stack:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->remove(Ljava/lang/Object;)Z

    .line 681
    :cond_0
    return-void
.end method

.method public replaceFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V
    .locals 3
    .param p1, "dataForFragment"    # Landroid/os/Bundle;
    .param p2, "fragmentClass"    # Ljava/lang/Class;
    .param p3, "data"    # Ljava/lang/Object;

    .prologue
    .line 765
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 766
    .local v1, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    invoke-virtual {v1, p1}, Lcom/poshmark/ui/fragments/PMFragment;->setArguments(Landroid/os/Bundle;)V

    .line 767
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->setUserVisibleHint(Z)V

    .line 768
    if-eqz p3, :cond_0

    .line 769
    invoke-virtual {v1, p3}, Lcom/poshmark/ui/fragments/PMFragment;->setFragmentData(Ljava/lang/Object;)V

    .line 771
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->descendants:Ljava/util/List;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->setNavigationList(Ljava/util/List;)V

    .line 772
    iget-object v2, p0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    invoke-virtual {v2, v1}, Lcom/poshmark/ui/fragments/RootTabFragment;->replaceChildFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 780
    .end local v1    # "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    :goto_0
    return-void

    .line 773
    :catch_0
    move-exception v0

    .line 775
    .local v0, "e":Ljava/lang/InstantiationException;
    invoke-virtual {v0}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    .line 776
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v0

    .line 778
    .local v0, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method
