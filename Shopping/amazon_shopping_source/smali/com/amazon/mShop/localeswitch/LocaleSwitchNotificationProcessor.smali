.class public Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;
.super Ljava/lang/Object;
.source "LocaleSwitchNotificationProcessor.java"

# interfaces
.implements Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public doProcess(Ljava/lang/String;Landroid/content/Context;Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V
    .locals 14
    .param p1, "localeName"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "chain"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    .prologue
    .line 24
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v10

    invoke-virtual {v10}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v3

    .line 25
    .local v3, "originalLocale":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_0

    invoke-static {p1}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_0

    const/4 v5, 0x1

    .line 26
    .local v5, "switchLocaleInCA":Z
    :goto_0
    invoke-static {p1}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v9

    .line 28
    .local v9, "triggerSwitchLocaleInCA":Z
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v10

    if-eqz v10, :cond_3

    .line 29
    new-instance v8, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;

    move-object/from16 v0, p3

    invoke-direct {v8, v0}, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;-><init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V

    .line 30
    .local v8, "toggleNotifReps":Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;
    new-instance v4, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;

    invoke-direct {v4, p0, v8, v9}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$1;-><init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;Z)V

    .line 96
    .local v4, "settingController":Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    if-eqz v5, :cond_1

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->config_notifications_changing_language:I

    .line 97
    .local v7, "titleId":I
    :goto_1
    new-instance v1, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$2;

    invoke-direct {v1, p0, v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor$2;-><init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;)V

    .line 104
    .local v1, "cancelable":Lcom/amazon/mShop/control/Cancellable;
    if-eqz v9, :cond_2

    new-instance v10, Lcom/amazon/mShop/TaskCallbackFactory;

    move-object/from16 v0, p2

    invoke-direct {v10, v0}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    const/4 v11, 0x0

    move-object/from16 v0, p2

    invoke-static {v0, v7, p1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v12

    const/4 v13, 0x0

    invoke-virtual {v10, v1, v11, v12, v13}, Lcom/amazon/mShop/TaskCallbackFactory;->getLocaleSwitchFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v6

    .line 107
    .local v6, "taskCallback":Lcom/amazon/mShop/control/TaskCallback;
    :goto_2
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v2

    .line 108
    .local v2, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    const/4 v10, 0x0

    invoke-virtual {v2, v10}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v10

    const/4 v11, 0x0

    invoke-virtual {v4, v10, v11, v6}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->toggleMarketPlace(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;ZLcom/amazon/mShop/control/TaskCallback;)V

    .line 115
    .end local v1    # "cancelable":Lcom/amazon/mShop/control/Cancellable;
    .end local v2    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    .end local v4    # "settingController":Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    .end local v6    # "taskCallback":Lcom/amazon/mShop/control/TaskCallback;
    .end local v7    # "titleId":I
    .end local v8    # "toggleNotifReps":Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;
    :goto_3
    return-void

    .line 25
    .end local v5    # "switchLocaleInCA":Z
    .end local v9    # "triggerSwitchLocaleInCA":Z
    :cond_0
    const/4 v5, 0x0

    goto :goto_0

    .line 96
    .restart local v4    # "settingController":Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    .restart local v5    # "switchLocaleInCA":Z
    .restart local v8    # "toggleNotifReps":Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;
    .restart local v9    # "triggerSwitchLocaleInCA":Z
    :cond_1
    sget v7, Lcom/amazon/mShop/android/lib/R$string;->config_notifications_changing_country:I

    goto :goto_1

    .line 104
    .restart local v1    # "cancelable":Lcom/amazon/mShop/control/Cancellable;
    .restart local v7    # "titleId":I
    :cond_2
    new-instance v10, Lcom/amazon/mShop/TaskCallbackFactory;

    move-object/from16 v0, p2

    invoke-direct {v10, v0}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    move-object/from16 v0, p2

    invoke-static {v0, v7, p1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v1, v11}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;Ljava/lang/String;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v6

    goto :goto_2

    .line 113
    .end local v1    # "cancelable":Lcom/amazon/mShop/control/Cancellable;
    .end local v4    # "settingController":Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;
    .end local v7    # "titleId":I
    .end local v8    # "toggleNotifReps":Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;
    :cond_3
    invoke-virtual/range {p3 .. p3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->process()V

    goto :goto_3
.end method
