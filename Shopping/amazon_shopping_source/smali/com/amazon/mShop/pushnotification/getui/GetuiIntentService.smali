.class public Lcom/amazon/mShop/pushnotification/getui/GetuiIntentService;
.super Landroid/app/IntentService;
.source "GetuiIntentService.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/mShop/pushnotification/getui/GetuiIntentService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/pushnotification/getui/GetuiIntentService;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/amazon/mShop/pushnotification/getui/GetuiIntentService;->TAG:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 20
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 9
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 24
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v6

    const-class v7, Lcom/amazon/mShop/pushnotification/getui/GetuiNotificationProvider;

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->matchNotificationProvider(Ljava/lang/Class;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 69
    :cond_0
    :goto_0
    return-void

    .line 29
    :cond_1
    if-eqz p1, :cond_0

    .line 30
    const-string/jumbo v6, "type"

    const/4 v7, 0x0

    invoke-virtual {p1, v6, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v3

    .line 31
    .local v3, "type":I
    packed-switch v3, :pswitch_data_0

    goto :goto_0

    .line 33
    :pswitch_0
    const-string/jumbo v6, "vcid"

    invoke-virtual {p1, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 34
    .local v5, "vcid":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 35
    sget-object v6, Lcom/amazon/mShop/pushnotification/getui/GetuiIntentService;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "vcid:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 37
    :cond_2
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v6

    invoke-virtual {v6, v5}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->updateDeviceToken(Ljava/lang/String;)V

    goto :goto_0

    .line 43
    .end local v5    # "vcid":Ljava/lang/String;
    :pswitch_1
    const-string/jumbo v6, "url"

    invoke-virtual {p1, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 44
    .local v4, "url":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 45
    sget-object v6, Lcom/amazon/mShop/pushnotification/getui/GetuiIntentService;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "download url:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    :cond_3
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 50
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 51
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v6, "getui_master_app_download_url"

    invoke-interface {v0, v6, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getCurrentMShopDeviceToken()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 53
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->updateDataStore(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 58
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v4    # "url":Ljava/lang/String;
    :pswitch_2
    const-string/jumbo v6, "payload"

    invoke-virtual {p1, v6}, Landroid/content/Intent;->getByteArrayExtra(Ljava/lang/String;)[B

    move-result-object v2

    .line 59
    .local v2, "payloadBytes":[B
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>([B)V

    .line 61
    .local v1, "payload":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 62
    sget-object v6, Lcom/amazon/mShop/pushnotification/getui/GetuiIntentService;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "payload:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 65
    :cond_4
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v6

    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/getui/GetuiIntentService;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v6, v7, p1}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->handlePushMessage(Landroid/content/Context;Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 31
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
