.class public Lcom/amazon/mShop/pushnotification/MShopNotificationGenerator;
.super Ljava/lang/Object;
.source "MShopNotificationGenerator.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static createSystemNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;Ljava/lang/String;I)Landroid/app/Notification;
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "contentTitle"    # Ljava/lang/String;
    .param p2, "contentMessage"    # Ljava/lang/String;
    .param p3, "contentIntent"    # Landroid/app/PendingIntent;
    .param p4, "deleteIntent"    # Landroid/app/PendingIntent;
    .param p5, "notificationType"    # Ljava/lang/String;
    .param p6, "largeIconResourceId"    # I

    .prologue
    .line 149
    sget v10, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 150
    .local v10, "sdkVersion":I
    sget v7, Lcom/amazon/mShop/android/lib/R$drawable;->amzn_statsbar_icon:I

    .line 151
    .local v7, "smallIconResourceId":I
    const/4 v6, 0x0

    .line 153
    .local v6, "bigTextStyle":Landroid/support/v4/app/NotificationCompat$BigTextStyle;
    const/16 v0, 0xe

    if-eq v10, v0, :cond_0

    const/16 v0, 0xf

    if-ne v10, v0, :cond_1

    .line 154
    :cond_0
    sget v7, Lcom/amazon/mShop/android/lib/R$drawable;->amzn_statsbar_icon_large:I

    .line 157
    :cond_1
    const/16 v0, 0xf

    if-le v10, v0, :cond_2

    .line 158
    new-instance v6, Landroid/support/v4/app/NotificationCompat$BigTextStyle;

    .end local v6    # "bigTextStyle":Landroid/support/v4/app/NotificationCompat$BigTextStyle;
    invoke-direct {v6}, Landroid/support/v4/app/NotificationCompat$BigTextStyle;-><init>()V

    .line 159
    .restart local v6    # "bigTextStyle":Landroid/support/v4/app/NotificationCompat$BigTextStyle;
    invoke-virtual {v6, p2}, Landroid/support/v4/app/NotificationCompat$BigTextStyle;->bigText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$BigTextStyle;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v4/app/NotificationCompat$BigTextStyle;->setBigContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$BigTextStyle;

    :cond_2
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move/from16 v8, p6

    .line 163
    invoke-static/range {v0 .. v8}, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->newNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;Landroid/support/v4/app/NotificationCompat$Style;II)Landroid/app/Notification;

    move-result-object v9

    .line 175
    .local v9, "notification":Landroid/app/Notification;
    iget v0, v9, Landroid/app/Notification;->flags:I

    or-int/lit8 v0, v0, 0x10

    iput v0, v9, Landroid/app/Notification;->flags:I

    .line 176
    return-object v9
.end method

.method public static generateNotification(Landroid/content/Context;Lcom/amazon/mShop/pushnotification/NotificationParams;)V
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "params"    # Lcom/amazon/mShop/pushnotification/NotificationParams;

    .prologue
    const/4 v13, 0x0

    .line 51
    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams;->getNotificationType()Ljava/lang/String;

    move-result-object v5

    .line 52
    .local v5, "notificationType":Ljava/lang/String;
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_switchableAppName:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    .line 53
    .local v1, "contentTitle":Ljava/lang/String;
    const/4 v6, 0x0

    .line 56
    .local v6, "largeIconResourceId":I
    new-instance v8, Landroid/content/Intent;

    const-class v0, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;

    invoke-direct {v8, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 57
    .local v8, "intent":Landroid/content/Intent;
    const-string/jumbo v0, "NotificationType"

    invoke-virtual {v8, v0, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 58
    const-string/jumbo v0, "NotificationMarketPlace"

    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams;->getMarketPlace()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v8, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 59
    const-string/jumbo v0, "ref"

    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams;->getRefMarker()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v8, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 61
    const-string/jumbo v0, "LD"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 67
    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;

    invoke-static {v8, v0}, Lcom/amazon/mShop/pushnotification/MShopNotificationGenerator;->updateDealContentIntent(Landroid/content/Intent;Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;)V

    .line 125
    :cond_0
    :goto_0
    const/high16 v0, 0x8000000

    invoke-static {p0, v13, v8, v0}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    .line 129
    .local v3, "contentIntent":Landroid/app/PendingIntent;
    new-instance v7, Landroid/content/Intent;

    const-class v0, Lcom/amazon/mShop/pushnotification/MShopClearNotificationReceiver;

    invoke-direct {v7, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 130
    .local v7, "delete":Landroid/content/Intent;
    const-string/jumbo v0, "NotificationType"

    invoke-virtual {v7, v0, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 131
    const/high16 v0, 0x50000000

    invoke-static {p0, v13, v7, v0}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v4

    .line 134
    .local v4, "deleteIntent":Landroid/app/PendingIntent;
    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams;->getMessage()Ljava/lang/String;

    move-result-object v2

    move-object v0, p0

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/pushnotification/MShopNotificationGenerator;->createSystemNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;Ljava/lang/String;I)Landroid/app/Notification;

    move-result-object v9

    .line 137
    .local v9, "notification":Landroid/app/Notification;
    invoke-static {v9, p0}, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->notifyToSystem(Landroid/app/Notification;Landroid/content/Context;)V

    .line 138
    return-void

    .line 68
    .end local v3    # "contentIntent":Landroid/app/PendingIntent;
    .end local v4    # "deleteIntent":Landroid/app/PendingIntent;
    .end local v7    # "delete":Landroid/content/Intent;
    .end local v9    # "notification":Landroid/app/Notification;
    :cond_1
    const-string/jumbo v0, "OD"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 69
    const-string/jumbo v0, "GoToDetailedOrder"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-object v0, p1

    .line 70
    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;->getOrderId()Ljava/lang/String;

    move-result-object v10

    .line 71
    .local v10, "orderId":Ljava/lang/String;
    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 72
    const-string/jumbo v0, "order_id"

    invoke-virtual {v8, v0, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 73
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "?orderId="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 77
    :cond_2
    const-string/jumbo v0, "pn_shipped_r"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 78
    .end local v10    # "orderId":Ljava/lang/String;
    :cond_3
    const-string/jumbo v0, "DP"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 79
    const-string/jumbo v0, "GoToUDP"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 80
    const-string/jumbo v2, "asin"

    move-object v0, p1

    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;->getAsin()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 85
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "?asin="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object v0, p1

    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;->getAsin()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 86
    :cond_4
    const-string/jumbo v0, "AD"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 87
    const-string/jumbo v0, "GoToDealsLandingPage"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 90
    const-string/jumbo v0, "pn_dotd_r"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 91
    :cond_5
    const-string/jumbo v0, "SNS"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 92
    const-string/jumbo v2, "data"

    move-object v0, p1

    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;->getToken()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 93
    const-string/jumbo v0, "GoToSNS"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 96
    const-string/jumbo v0, "pn_sns_r"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 97
    :cond_6
    const-string/jumbo v0, "DL"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    move-object v0, p1

    .line 98
    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$DeepLinkNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$DeepLinkNotificationParams;->getUrl()Ljava/lang/String;

    move-result-object v11

    .line 99
    .local v11, "urlString":Ljava/lang/String;
    const-string/jumbo v0, "GoToDeepLink"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 100
    invoke-static {v11}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 101
    .end local v11    # "urlString":Ljava/lang/String;
    :cond_7
    const-string/jumbo v0, "SL"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    move-object v0, p1

    .line 102
    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$SmartLinkNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$SmartLinkNotificationParams;->getUrl()Ljava/lang/String;

    move-result-object v11

    .line 103
    .restart local v11    # "urlString":Ljava/lang/String;
    const-string/jumbo v0, "GoToSmartLink"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 104
    invoke-static {v11}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 105
    .end local v11    # "urlString":Ljava/lang/String;
    :cond_8
    const-string/jumbo v0, "COINS"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 106
    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->getUrl()Ljava/lang/String;

    move-result-object v11

    .line 107
    .restart local v11    # "urlString":Ljava/lang/String;
    new-instance v8, Landroid/content/Intent;

    .end local v8    # "intent":Landroid/content/Intent;
    invoke-direct {v8}, Landroid/content/Intent;-><init>()V

    .line 108
    .restart local v8    # "intent":Landroid/content/Intent;
    const-string/jumbo v0, "android.intent.action.VIEW"

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 109
    invoke-static {v11}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v8, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    move-object v0, p1

    .line 110
    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->getTitle()Ljava/lang/String;

    move-result-object v1

    move-object v0, p1

    .line 112
    check-cast v0, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;

    invoke-virtual {v0}, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;->useCoinsIcon()Z

    move-result v12

    .line 113
    .local v12, "useCoinsIcon":Z
    if-eqz v12, :cond_a

    .line 114
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xe

    if-eq v0, v2, :cond_9

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xf

    if-ne v0, v2, :cond_b

    .line 115
    :cond_9
    sget v6, Lcom/amazon/mShop/android/lib/R$drawable;->coins_icon_large:I

    .line 122
    :cond_a
    :goto_1
    const-string/jumbo v0, "pn_coins_r"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 117
    :cond_b
    sget v6, Lcom/amazon/mShop/android/lib/R$drawable;->coins_icon:I

    goto :goto_1
.end method

.method private static updateDealContentIntent(Landroid/content/Intent;Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;)V
    .locals 2
    .param p0, "dealContentIntent"    # Landroid/content/Intent;
    .param p1, "params"    # Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;

    .prologue
    .line 188
    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->getAsin()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 189
    const-string/jumbo v0, "GoToUDP"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 190
    const-string/jumbo v0, "asin"

    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 195
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "?asin="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->getAsin()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 198
    const-string/jumbo v0, "pn_single_ld_r"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 217
    :goto_0
    return-void

    .line 200
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->getCategory()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 201
    const-string/jumbo v0, "refineCategory"

    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->getCategory()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 202
    const-string/jumbo v0, "refineCategoryDisplayName"

    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->getCategoryDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 207
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "?category="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;->getCategory()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 210
    const-string/jumbo v0, "pn_group_ld_r"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 215
    :goto_1
    const-string/jumbo v0, "GoToDealListPage"

    invoke-virtual {p0, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 213
    :cond_1
    const-string/jumbo v0, "pn_all_ld_r"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_1
.end method
