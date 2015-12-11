.class public Lcom/amazon/mShop/pushnotification/gcm/GCMNotificationProvider;
.super Ljava/lang/Object;
.source "GCMNotificationProvider.java"

# interfaces
.implements Lcom/amazon/mShop/pushnotification/NotificationProvider;


# static fields
.field private static final DEBUG:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/pushnotification/gcm/GCMNotificationProvider;->DEBUG:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public constructNotificationParams(Landroid/content/Intent;)Lcom/amazon/mShop/pushnotification/NotificationParams;
    .locals 42
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 194
    const/4 v1, 0x0

    .line 195
    .local v1, "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    const-string/jumbo v7, "msg_type"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 196
    .local v2, "notificationType":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    move-object/from16 v41, v1

    .line 248
    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    .local v41, "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    :goto_0
    return-object v41

    .line 198
    .end local v41    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    :cond_0
    const-string/jumbo v7, "alert"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 199
    .local v4, "message":Ljava/lang/String;
    const-string/jumbo v7, "marketplace"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 200
    .local v3, "marketPlace":Ljava/lang/String;
    const-string/jumbo v7, "ref"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 202
    .local v6, "refMarker":Ljava/lang/String;
    const-string/jumbo v7, "DP"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 203
    const-string/jumbo v7, "asin"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 204
    .local v5, "asin":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;

    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    invoke-direct/range {v1 .. v6}, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .end local v5    # "asin":Ljava/lang/String;
    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    :cond_1
    :goto_1
    move-object/from16 v41, v1

    .line 248
    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    .restart local v41    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto :goto_0

    .line 208
    .end local v41    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    :cond_2
    const-string/jumbo v7, "LD"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 209
    const-string/jumbo v7, "asin"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 210
    .restart local v5    # "asin":Ljava/lang/String;
    const-string/jumbo v7, "browse_node"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 211
    .local v12, "category":Ljava/lang/String;
    const-string/jumbo v7, "browse_node_display_name"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 212
    .local v13, "categoryDisplayName":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;

    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object v7, v1

    move-object v8, v2

    move-object v9, v3

    move-object v10, v4

    move-object v11, v5

    move-object v14, v6

    invoke-direct/range {v7 .. v14}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto :goto_1

    .line 215
    .end local v5    # "asin":Ljava/lang/String;
    .end local v12    # "category":Ljava/lang/String;
    .end local v13    # "categoryDisplayName":Ljava/lang/String;
    :cond_3
    const-string/jumbo v7, "OD"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 216
    const-string/jumbo v7, "order_id"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    .line 217
    .local v18, "orderId":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;

    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object v14, v1

    move-object v15, v2

    move-object/from16 v16, v3

    move-object/from16 v17, v4

    move-object/from16 v19, v6

    invoke-direct/range {v14 .. v19}, Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto :goto_1

    .line 220
    .end local v18    # "orderId":Ljava/lang/String;
    :cond_4
    const-string/jumbo v7, "AD"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 221
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationParams;

    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    invoke-direct {v1, v2, v3, v4, v6}, Lcom/amazon/mShop/pushnotification/NotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto :goto_1

    .line 224
    :cond_5
    const-string/jumbo v7, "SNS"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_6

    .line 225
    const-string/jumbo v7, "token"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 226
    .local v24, "token":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;

    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object/from16 v19, v1

    move-object/from16 v20, v2

    move-object/from16 v21, v3

    move-object/from16 v22, v4

    move-object/from16 v23, v6

    invoke-direct/range {v19 .. v24}, Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 227
    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_1

    .line 228
    .end local v24    # "token":Ljava/lang/String;
    :cond_6
    const-string/jumbo v7, "DL"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 229
    const-string/jumbo v7, "url"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    .line 230
    .local v30, "url":Ljava/lang/String;
    invoke-static/range {v30 .. v30}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getLocaleNameFromUri(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v40

    .line 231
    .local v40, "localeName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v7

    move-object/from16 v0, v40

    invoke-virtual {v7, v0}, Lcom/amazon/mShop/platform/AppLocale;->getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 232
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationParams$DeepLinkNotificationParams;

    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object/from16 v25, v1

    move-object/from16 v26, v2

    move-object/from16 v27, v3

    move-object/from16 v28, v4

    move-object/from16 v29, v6

    invoke-direct/range {v25 .. v30}, Lcom/amazon/mShop/pushnotification/NotificationParams$DeepLinkNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_1

    .line 234
    .end local v30    # "url":Ljava/lang/String;
    .end local v40    # "localeName":Ljava/lang/String;
    :cond_7
    const-string/jumbo v7, "SL"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_8

    .line 235
    const-string/jumbo v7, "url"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    .line 236
    .restart local v30    # "url":Ljava/lang/String;
    invoke-static/range {v30 .. v30}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getLocaleNameFromUri(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v40

    .line 237
    .restart local v40    # "localeName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v7

    move-object/from16 v0, v40

    invoke-virtual {v7, v0}, Lcom/amazon/mShop/platform/AppLocale;->getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 238
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationParams$SmartLinkNotificationParams;

    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object/from16 v25, v1

    move-object/from16 v26, v2

    move-object/from16 v27, v3

    move-object/from16 v28, v4

    move-object/from16 v29, v6

    invoke-direct/range {v25 .. v30}, Lcom/amazon/mShop/pushnotification/NotificationParams$SmartLinkNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_1

    .end local v30    # "url":Ljava/lang/String;
    .end local v40    # "localeName":Ljava/lang/String;
    :cond_8
    const-string/jumbo v7, "COINS"

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 240
    const-string/jumbo v7, "url"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v30

    .line 241
    .restart local v30    # "url":Ljava/lang/String;
    const-string/jumbo v7, "title"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v34

    .line 242
    .local v34, "title":Ljava/lang/String;
    const-string/jumbo v7, "icon"

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v39

    .line 243
    .local v39, "icon":Ljava/lang/String;
    invoke-static/range {v39 .. v39}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_9

    const/16 v36, 0x1

    .line 245
    .local v36, "useCoinsIcon":Z
    :goto_2
    new-instance v1, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;

    .end local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object/from16 v31, v1

    move-object/from16 v32, v2

    move-object/from16 v33, v3

    move-object/from16 v35, v4

    move-object/from16 v37, v6

    move-object/from16 v38, v30

    invoke-direct/range {v31 .. v38}, Lcom/amazon/mShop/pushnotification/NotificationParams$CoinsNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .restart local v1    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_1

    .line 243
    .end local v36    # "useCoinsIcon":Z
    :cond_9
    const/16 v36, 0x0

    goto :goto_2
.end method

.method public getCurrentMShopRegistrationToken()Ljava/lang/String;
    .locals 2

    .prologue
    .line 140
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 141
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "gcmRegistrationId"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getCurrentPushNotificationErrorId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 146
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 147
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "gcmErrorId"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getErrorMessage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 100
    const-string/jumbo v0, ""

    .line 101
    .local v0, "errorMessage":Ljava/lang/String;
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "SERVICE_NOT_AVAILABLE"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 108
    :cond_0
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->notification_gcm_unavailable:I

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 120
    :cond_1
    :goto_0
    return-object v0

    .line 109
    :cond_2
    const-string/jumbo v1, "ACCOUNT_MISSING"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string/jumbo v1, "AUTHENTICATION_FAILED"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 118
    :cond_3
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->notification_google_account_error:I

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 4
    .param p1, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 125
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    invoke-static {v1}, Lcom/google/android/gcm/GCMRegistrar;->getRegistrationId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 128
    .local v0, "currentRegistrationId":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 129
    const/4 v1, 0x0

    .line 135
    :goto_1
    return-object v1

    .end local v0    # "currentRegistrationId":Ljava/lang/String;
    :cond_0
    move-object v0, p1

    .line 125
    goto :goto_0

    .line 131
    .restart local v0    # "currentRegistrationId":Ljava/lang/String;
    :cond_1
    sget-boolean v1, Lcom/amazon/mShop/pushnotification/gcm/GCMNotificationProvider;->DEBUG:Z

    if-eqz v1, :cond_2

    .line 132
    const-string/jumbo v1, "MShopPushNotificationUtils"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "GCM registration id : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    :cond_2
    const-string/jumbo v1, "com.amazon.mShop.android"

    const/4 v2, 0x1

    invoke-static {v1, v2, v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->constructNotificationTarget(Ljava/lang/String;ILjava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v1

    goto :goto_1
.end method

.method public getProviderName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 259
    const-string/jumbo v0, "GCM"

    return-object v0
.end method

.method public handleClickActionOnErrorButton(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 254
    invoke-virtual {p1}, Landroid/app/Activity;->finish()V

    .line 255
    return-void
.end method

.method public isAvailable(Landroid/content/Context;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 80
    const/4 v0, 0x0

    .line 82
    .local v0, "checkDevice":Z
    :try_start_0
    invoke-static {p1}, Lcom/google/android/gcm/GCMRegistrar;->checkDevice(Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    const/4 v0, 0x1

    .line 87
    :goto_0
    const/4 v1, 0x0

    .line 89
    .local v1, "checkManifest":Z
    :try_start_1
    invoke-static {p1}, Lcom/google/android/gcm/GCMRegistrar;->checkManifest(Landroid/content/Context;)V
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_1

    .line 90
    const/4 v1, 0x1

    .line 94
    :goto_1
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    const/4 v2, 0x1

    :goto_2
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_2

    .line 84
    .end local v1    # "checkManifest":Z
    :catch_0
    move-exception v2

    goto :goto_0

    .line 91
    .restart local v1    # "checkManifest":Z
    :catch_1
    move-exception v2

    goto :goto_1
.end method

.method public onMainActivityDestroyed(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 74
    invoke-static {p1}, Lcom/google/android/gcm/GCMRegistrar;->onDestroy(Landroid/content/Context;)V

    .line 75
    return-void
.end method

.method public setCurrentMShopRegistrationToken(Ljava/lang/String;)V
    .locals 2
    .param p1, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 152
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 153
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    if-nez p1, :cond_0

    .line 154
    const-string/jumbo v1, "gcmRegistrationId"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 158
    :goto_0
    return-void

    .line 156
    :cond_0
    const-string/jumbo v1, "gcmRegistrationId"

    invoke-interface {v0, v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setCurrentPushNotificationErrorId(Ljava/lang/String;)V
    .locals 2
    .param p1, "errorId"    # Ljava/lang/String;

    .prologue
    .line 162
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 163
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    if-nez p1, :cond_0

    .line 164
    const-string/jumbo v1, "gcmErrorId"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 169
    :goto_0
    return-void

    .line 166
    :cond_0
    const-string/jumbo v1, "gcmErrorId"

    invoke-interface {v0, v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public startRegister(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 58
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/pushnotification/gcm/GCMNotificationProvider;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v1

    if-nez v1, :cond_0

    .line 60
    const/4 v1, 0x1

    :try_start_0
    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string/jumbo v3, "16912134167"

    aput-object v3, v1, v2

    invoke-static {p1, v1}, Lcom/google/android/gcm/GCMRegistrar;->register(Landroid/content/Context;[Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    :cond_0
    :goto_0
    return-void

    .line 61
    :catch_0
    move-exception v0

    .line 62
    .local v0, "e":Ljava/lang/SecurityException;
    const-string/jumbo v1, "MShopPushNotificationUtils"

    invoke-virtual {v0}, Ljava/lang/SecurityException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
