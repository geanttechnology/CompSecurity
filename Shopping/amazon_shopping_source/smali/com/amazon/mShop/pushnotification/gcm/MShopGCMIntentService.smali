.class public Lcom/amazon/mShop/pushnotification/gcm/MShopGCMIntentService;
.super Lcom/google/android/gcm/GCMBaseIntentService;
.source "MShopGCMIntentService.java"


# static fields
.field protected static final DEBUG:Z

.field private static sRetryCounter:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/pushnotification/gcm/MShopGCMIntentService;->DEBUG:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 31
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "16912134167"

    aput-object v2, v0, v1

    invoke-direct {p0, v0}, Lcom/google/android/gcm/GCMBaseIntentService;-><init>([Ljava/lang/String;)V

    .line 32
    return-void
.end method


# virtual methods
.method protected onDeletedMessages(Landroid/content/Context;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "total"    # I

    .prologue
    .line 61
    return-void
.end method

.method public onError(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 65
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 66
    .local v0, "manager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->setCurrentPushNotificationErrorId(Ljava/lang/String;)V

    .line 67
    return-void
.end method

.method protected onMessage(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 50
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    const-class v1, Lcom/amazon/mShop/pushnotification/gcm/GCMNotificationProvider;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->matchNotificationProvider(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 56
    :goto_0
    return-void

    .line 55
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->handlePushMessage(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0
.end method

.method protected onRecoverableError(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 82
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 83
    .local v0, "manager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->setCurrentPushNotificationErrorId(Ljava/lang/String;)V

    .line 84
    sget v2, Lcom/amazon/mShop/pushnotification/gcm/MShopGCMIntentService;->sRetryCounter:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Lcom/amazon/mShop/pushnotification/gcm/MShopGCMIntentService;->sRetryCounter:I

    const/4 v3, 0x5

    if-gt v2, v3, :cond_0

    .line 85
    const/4 v1, 0x1

    .line 88
    :goto_0
    return v1

    .line 87
    :cond_0
    sput v1, Lcom/amazon/mShop/pushnotification/gcm/MShopGCMIntentService;->sRetryCounter:I

    goto :goto_0
.end method

.method protected onRegistered(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 36
    sget-boolean v0, Lcom/amazon/mShop/pushnotification/gcm/MShopGCMIntentService;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 37
    const-string/jumbo v0, "PushNotification"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Registered..ID:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 39
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->updateDeviceToken(Ljava/lang/String;)V

    .line 40
    invoke-static {p1, p2}, Lcom/amazon/mShop/util/MShopPushNotificationUtils$PushNotificationMessageReceiver;->sendPushNotificationRegisteredMessageBroadcast(Landroid/content/Context;Ljava/lang/String;)V

    .line 41
    return-void
.end method

.method protected onUnregistered(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 46
    return-void
.end method
