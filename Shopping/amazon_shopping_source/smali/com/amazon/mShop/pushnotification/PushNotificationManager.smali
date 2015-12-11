.class public Lcom/amazon/mShop/pushnotification/PushNotificationManager;
.super Ljava/lang/Object;
.source "PushNotificationManager.java"


# static fields
.field private static final DEBUG:Z

.field public static final TAG:Ljava/lang/String;

.field private static sInstanceAvailable:Z

.field private static sPushNotificationManager:Lcom/amazon/mShop/pushnotification/PushNotificationManager;


# instance fields
.field private mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->TAG:Ljava/lang/String;

    .line 25
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->DEBUG:Z

    .line 33
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sInstanceAvailable:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Z
    .locals 1

    .prologue
    .line 21
    sget-boolean v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->DEBUG:Z

    return v0
.end method

.method public static declared-synchronized clearInstance()V
    .locals 2

    .prologue
    .line 65
    const-class v1, Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    monitor-enter v1

    const/4 v0, 0x0

    :try_start_0
    sput-object v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sPushNotificationManager:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    .line 66
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sInstanceAvailable:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 67
    monitor-exit v1

    return-void

    .line 65
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    .locals 5

    .prologue
    .line 43
    const-class v3, Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    monitor-enter v3

    :try_start_0
    sget-object v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sPushNotificationManager:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    if-nez v2, :cond_2

    sget-boolean v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sInstanceAvailable:Z

    if-eqz v2, :cond_2

    .line 44
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 46
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;->getInstance()Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/pushnotification/NotificationProviderFactory;->newNotificationProvider()Lcom/amazon/mShop/pushnotification/NotificationProvider;

    move-result-object v1

    .line 48
    .local v1, "notificationProvider":Lcom/amazon/mShop/pushnotification/NotificationProvider;
    invoke-interface {v1, v0}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->isAvailable(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 49
    sget-boolean v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 50
    sget-object v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "device can\'t support push notification feature"

    invoke-static {v2, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 53
    :cond_0
    const/4 v2, 0x0

    sput-boolean v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sInstanceAvailable:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 54
    const/4 v2, 0x0

    .line 61
    :goto_0
    monitor-exit v3

    return-object v2

    .line 56
    :cond_1
    :try_start_1
    new-instance v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    invoke-direct {v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;-><init>()V

    sput-object v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sPushNotificationManager:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    .line 57
    sget-object v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sPushNotificationManager:Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    invoke-direct {v2, v0, v1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->initializePushNotification(Landroid/content/Context;Lcom/amazon/mShop/pushnotification/NotificationProvider;)Z

    .line 61
    :cond_2
    sget-object v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->sPushNotificationManager:Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 43
    .end local v1    # "notificationProvider":Lcom/amazon/mShop/pushnotification/NotificationProvider;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method private initializePushNotification(Landroid/content/Context;Lcom/amazon/mShop/pushnotification/NotificationProvider;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "notificationProvider"    # Lcom/amazon/mShop/pushnotification/NotificationProvider;

    .prologue
    .line 80
    invoke-interface {p2, p1}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->isAvailable(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 81
    sget-boolean v1, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 82
    sget-object v1, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "device can\'t support push notification feature"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 84
    :cond_0
    const/4 v1, 0x0

    .line 103
    :goto_0
    return v1

    .line 87
    :cond_1
    iput-object p2, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    .line 89
    invoke-direct {p0, p1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->startRegistration(Landroid/content/Context;)V

    .line 91
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v0

    .line 92
    .local v0, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    if-eqz v0, :cond_2

    .line 93
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager$1;

    invoke-direct {v2, p0, v0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager$1;-><init>(Lcom/amazon/mShop/pushnotification/PushNotificationManager;Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 103
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private startRegistration(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->startRegister(Landroid/content/Context;)V

    .line 114
    return-void
.end method


# virtual methods
.method public enableNotificationsForNewMarketplace(Ljava/lang/String;)V
    .locals 4
    .param p1, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 217
    new-instance v1, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    new-instance v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager$4;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager$4;-><init>(Lcom/amazon/mShop/pushnotification/PushNotificationManager;)V

    invoke-direct {v1, v2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;)V

    .line 246
    .local v1, "settingController":Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v0

    .line 247
    .local v0, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->toggleMarketPlace(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;ZLcom/amazon/mShop/control/TaskCallback;)V

    .line 248
    return-void
.end method

.method public enbleNotificationForAnonymousCustomer()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 260
    new-instance v1, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    new-instance v2, Lcom/amazon/mShop/pushnotification/PushNotificationManager$5;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager$5;-><init>(Lcom/amazon/mShop/pushnotification/PushNotificationManager;)V

    invoke-direct {v1, v2}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;)V

    .line 264
    .local v1, "settingController":Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v0

    .line 265
    .local v0, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2, v3}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->toggleMarketPlace(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;ZLcom/amazon/mShop/control/TaskCallback;)V

    .line 266
    return-void
.end method

.method public getCurrentMShopDeviceToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->getCurrentMShopRegistrationToken()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentPushNotificationErrorId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->getCurrentPushNotificationErrorId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getErrorMessage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 269
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->getErrorMessage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 1
    .param p1, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 277
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v0

    return-object v0
.end method

.method public getNotificationProvider()Lcom/amazon/mShop/pushnotification/NotificationProvider;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    return-object v0
.end method

.method public handleClickActionOnErrorButton(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 307
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->handleClickActionOnErrorButton(Landroid/app/Activity;Ljava/lang/String;)V

    .line 308
    return-void
.end method

.method public handlePushMessage(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 297
    iget-object v2, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v2, p2}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->constructNotificationParams(Landroid/content/Intent;)Lcom/amazon/mShop/pushnotification/NotificationParams;

    move-result-object v1

    .line 298
    .local v1, "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/platform/AppLocale;->getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 301
    .local v0, "currentMarketplace":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/mShop/pushnotification/NotificationParams;->getMarketPlace()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Lcom/amazon/mShop/pushnotification/NotificationParams;->getMarketPlace()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 302
    invoke-static {p1, v1}, Lcom/amazon/mShop/pushnotification/MShopNotificationGenerator;->generateNotification(Landroid/content/Context;Lcom/amazon/mShop/pushnotification/NotificationParams;)V

    .line 304
    :cond_0
    return-void
.end method

.method public matchNotificationProvider(Ljava/lang/Class;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 311
    .local p1, "providerClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    if-nez v0, :cond_1

    .line 312
    :cond_0
    const/4 v0, 0x0

    .line 314
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public onMainActivityDestroyed(Landroid/content/Context;)V
    .locals 1
    .param p1, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 273
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->onMainActivityDestroyed(Landroid/content/Context;)V

    .line 274
    return-void
.end method

.method public setCurrentPushNotificationErrorId(Ljava/lang/String;)V
    .locals 1
    .param p1, "errorId"    # Ljava/lang/String;

    .prologue
    .line 293
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->setCurrentPushNotificationErrorId(Ljava/lang/String;)V

    .line 294
    return-void
.end method

.method public updateDataStore(Ljava/lang/String;)V
    .locals 2
    .param p1, "registrationID"    # Ljava/lang/String;

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->setCurrentMShopRegistrationToken(Ljava/lang/String;)V

    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->setCurrentPushNotificationErrorId(Ljava/lang/String;)V

    .line 206
    return-void
.end method

.method public updateDeviceToken(Ljava/lang/String;)V
    .locals 6
    .param p1, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 160
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 201
    :cond_0
    :goto_0
    return-void

    .line 162
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->mNotificationProvider:Lcom/amazon/mShop/pushnotification/NotificationProvider;

    invoke-interface {v4}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->getCurrentMShopRegistrationToken()Ljava/lang/String;

    move-result-object v1

    .line 164
    .local v1, "lastRegistrationId":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 168
    new-instance v3, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;

    new-instance v4, Lcom/amazon/mShop/pushnotification/PushNotificationManager$3;

    invoke-direct {v4, p0, p1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager$3;-><init>(Lcom/amazon/mShop/pushnotification/PushNotificationManager;Ljava/lang/String;)V

    invoke-direct {v3, v4}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;-><init>(Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;)V

    .line 191
    .local v3, "settingController":Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v2

    .line 192
    .local v2, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getApplicationId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->getType()I

    move-result v5

    invoke-virtual {v3, v4, v5, v1, p1}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->updateDeviceToken(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 195
    .end local v2    # "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .end local v3    # "settingController":Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    :cond_2
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 196
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->updateDataStore(Ljava/lang/String;)V

    .line 197
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 198
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/kiang/KiangController;->getInstance()Lcom/amazon/mShop/kiang/KiangController;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/amazon/mShop/kiang/KiangController;->kiangUpdate(Landroid/content/Context;)V

    goto :goto_0
.end method
