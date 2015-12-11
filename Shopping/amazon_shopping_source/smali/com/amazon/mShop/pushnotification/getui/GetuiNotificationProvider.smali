.class public Lcom/amazon/mShop/pushnotification/getui/GetuiNotificationProvider;
.super Ljava/lang/Object;
.source "GetuiNotificationProvider.java"

# interfaces
.implements Lcom/amazon/mShop/pushnotification/NotificationProvider;


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/amazon/mShop/pushnotification/getui/GetuiNotificationProvider;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/pushnotification/getui/GetuiNotificationProvider;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public constructNotificationParams(Landroid/content/Intent;)Lcom/amazon/mShop/pushnotification/NotificationParams;
    .locals 37
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 142
    const-string/jumbo v8, "payload"

    move-object/from16 v0, p1

    invoke-virtual {v0, v8}, Landroid/content/Intent;->getByteArrayExtra(Ljava/lang/String;)[B

    move-result-object v36

    .line 143
    .local v36, "payloadBytes":[B
    new-instance v35, Ljava/lang/String;

    invoke-direct/range {v35 .. v36}, Ljava/lang/String;-><init>([B)V

    .line 145
    .local v35, "payload":Ljava/lang/String;
    invoke-static/range {v35 .. v35}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 146
    const/4 v2, 0x0

    .line 202
    :cond_0
    :goto_0
    return-object v2

    .line 150
    :cond_1
    :try_start_0
    new-instance v33, Lorg/json/JSONObject;

    move-object/from16 v0, v33

    move-object/from16 v1, v35

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 152
    .local v33, "jsonPayload":Lorg/json/JSONObject;
    const/4 v2, 0x0

    .line 153
    .local v2, "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    const-string/jumbo v8, "msg_type"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 154
    .local v3, "notificationType":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 156
    const-string/jumbo v8, "alert"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    const-string/jumbo v8, "alert"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 157
    .local v5, "message":Ljava/lang/String;
    :goto_1
    const-string/jumbo v8, "marketplace"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    const-string/jumbo v8, "marketplace"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 158
    .local v4, "marketPlace":Ljava/lang/String;
    :goto_2
    const-string/jumbo v8, "ref"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    const-string/jumbo v8, "ref"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 160
    .local v7, "refMarker":Ljava/lang/String;
    :goto_3
    const-string/jumbo v8, "DP"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 161
    const-string/jumbo v8, "asin"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    const-string/jumbo v8, "asin"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 162
    .local v6, "asin":Ljava/lang/String;
    :goto_4
    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;

    .end local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    invoke-direct/range {v2 .. v7}, Lcom/amazon/mShop/pushnotification/NotificationParams$ProductDetailNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    .restart local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto :goto_0

    .line 156
    .end local v4    # "marketPlace":Ljava/lang/String;
    .end local v5    # "message":Ljava/lang/String;
    .end local v6    # "asin":Ljava/lang/String;
    .end local v7    # "refMarker":Ljava/lang/String;
    :cond_2
    const-string/jumbo v5, ""

    goto :goto_1

    .line 157
    .restart local v5    # "message":Ljava/lang/String;
    :cond_3
    const-string/jumbo v4, ""

    goto :goto_2

    .line 158
    .restart local v4    # "marketPlace":Ljava/lang/String;
    :cond_4
    const-string/jumbo v7, ""

    goto :goto_3

    .line 161
    .restart local v7    # "refMarker":Ljava/lang/String;
    :cond_5
    const-string/jumbo v6, ""

    goto :goto_4

    .line 166
    :cond_6
    const-string/jumbo v8, "LD"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_a

    .line 167
    const-string/jumbo v8, "asin"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    const-string/jumbo v8, "asin"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 168
    .restart local v6    # "asin":Ljava/lang/String;
    :goto_5
    const-string/jumbo v8, "browse_node"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_8

    const-string/jumbo v8, "browse_node"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 169
    .local v13, "category":Ljava/lang/String;
    :goto_6
    const-string/jumbo v8, "browse_node_display_name"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_9

    const-string/jumbo v8, "browse_node_display_name"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 170
    .local v14, "categoryDisplayName":Ljava/lang/String;
    :goto_7
    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;

    .end local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object v8, v2

    move-object v9, v3

    move-object v10, v4

    move-object v11, v5

    move-object v12, v6

    move-object v15, v7

    invoke-direct/range {v8 .. v15}, Lcom/amazon/mShop/pushnotification/NotificationParams$DealNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    .restart local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_0

    .line 167
    .end local v6    # "asin":Ljava/lang/String;
    .end local v13    # "category":Ljava/lang/String;
    .end local v14    # "categoryDisplayName":Ljava/lang/String;
    :cond_7
    const-string/jumbo v6, ""

    goto :goto_5

    .line 168
    .restart local v6    # "asin":Ljava/lang/String;
    :cond_8
    const-string/jumbo v13, ""

    goto :goto_6

    .line 169
    .restart local v13    # "category":Ljava/lang/String;
    :cond_9
    const-string/jumbo v14, ""

    goto :goto_7

    .line 173
    .end local v6    # "asin":Ljava/lang/String;
    .end local v13    # "category":Ljava/lang/String;
    :cond_a
    const-string/jumbo v8, "OD"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_c

    .line 174
    const-string/jumbo v8, "order_id"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_b

    const-string/jumbo v8, "order_id"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 175
    .local v19, "orderId":Ljava/lang/String;
    :goto_8
    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;

    .end local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object v15, v2

    move-object/from16 v16, v3

    move-object/from16 v17, v4

    move-object/from16 v18, v5

    move-object/from16 v20, v7

    invoke-direct/range {v15 .. v20}, Lcom/amazon/mShop/pushnotification/NotificationParams$OrderNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    .restart local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_0

    .line 174
    .end local v19    # "orderId":Ljava/lang/String;
    :cond_b
    const-string/jumbo v19, ""

    goto :goto_8

    .line 178
    :cond_c
    const-string/jumbo v8, "AD"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_d

    .line 179
    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationParams;

    .end local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    invoke-direct {v2, v3, v4, v5, v7}, Lcom/amazon/mShop/pushnotification/NotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_0

    .line 182
    :cond_d
    const-string/jumbo v8, "SNS"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_f

    .line 183
    const-string/jumbo v8, "token"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_e

    const-string/jumbo v8, "token"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 184
    .local v25, "token":Ljava/lang/String;
    :goto_9
    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;

    .end local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object/from16 v20, v2

    move-object/from16 v21, v3

    move-object/from16 v22, v4

    move-object/from16 v23, v5

    move-object/from16 v24, v7

    invoke-direct/range {v20 .. v25}, Lcom/amazon/mShop/pushnotification/NotificationParams$SnsNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    .restart local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_0

    .line 183
    .end local v25    # "token":Ljava/lang/String;
    :cond_e
    const-string/jumbo v25, ""

    goto :goto_9

    .line 187
    :cond_f
    const-string/jumbo v8, "DL"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_10

    .line 188
    const-string/jumbo v8, "url"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v31

    .line 189
    .local v31, "url":Ljava/lang/String;
    invoke-static/range {v31 .. v31}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getLocaleNameFromUri(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v34

    .line 190
    .local v34, "localeName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v8

    move-object/from16 v0, v34

    invoke-virtual {v8, v0}, Lcom/amazon/mShop/platform/AppLocale;->getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 191
    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationParams$DeepLinkNotificationParams;

    .end local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object/from16 v26, v2

    move-object/from16 v27, v3

    move-object/from16 v28, v4

    move-object/from16 v29, v5

    move-object/from16 v30, v7

    invoke-direct/range {v26 .. v31}, Lcom/amazon/mShop/pushnotification/NotificationParams$DeepLinkNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    .restart local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_0

    .line 193
    .end local v31    # "url":Ljava/lang/String;
    .end local v34    # "localeName":Ljava/lang/String;
    :cond_10
    const-string/jumbo v8, "SL"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 194
    const-string/jumbo v8, "url"

    move-object/from16 v0, v33

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v31

    .line 195
    .restart local v31    # "url":Ljava/lang/String;
    invoke-static/range {v31 .. v31}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->getLocaleNameFromUri(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v34

    .line 196
    .restart local v34    # "localeName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v8

    move-object/from16 v0, v34

    invoke-virtual {v8, v0}, Lcom/amazon/mShop/platform/AppLocale;->getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 197
    new-instance v2, Lcom/amazon/mShop/pushnotification/NotificationParams$SmartLinkNotificationParams;

    .end local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    move-object/from16 v26, v2

    move-object/from16 v27, v3

    move-object/from16 v28, v4

    move-object/from16 v29, v5

    move-object/from16 v30, v7

    invoke-direct/range {v26 .. v31}, Lcom/amazon/mShop/pushnotification/NotificationParams$SmartLinkNotificationParams;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .restart local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    goto/16 :goto_0

    .line 201
    .end local v2    # "params":Lcom/amazon/mShop/pushnotification/NotificationParams;
    .end local v3    # "notificationType":Ljava/lang/String;
    .end local v4    # "marketPlace":Ljava/lang/String;
    .end local v5    # "message":Ljava/lang/String;
    .end local v7    # "refMarker":Ljava/lang/String;
    .end local v31    # "url":Ljava/lang/String;
    .end local v33    # "jsonPayload":Lorg/json/JSONObject;
    .end local v34    # "localeName":Ljava/lang/String;
    :catch_0
    move-exception v32

    .line 202
    .local v32, "e":Lorg/json/JSONException;
    const/4 v2, 0x0

    goto/16 :goto_0
.end method

.method public getCurrentMShopRegistrationToken()Ljava/lang/String;
    .locals 2

    .prologue
    .line 84
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 85
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "getuiRegistrationId"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getCurrentPushNotificationErrorId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 102
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 103
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "getui_master_app_download_url"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 105
    .local v1, "downloadUrl":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 106
    const-string/jumbo v2, "SERVICE_NOT_AVAILABE"

    .line 108
    :goto_0
    return-object v2

    :cond_0
    const-string/jumbo v2, "MASTER_APP_NOT_FOUND"

    goto :goto_0
.end method

.method public getErrorMessage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 62
    const-string/jumbo v0, "MASTER_APP_NOT_FOUND"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->getui_error_download_master_app:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 65
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->getui_error_service_not_available:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 4
    .param p1, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 71
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/getui/GetuiNotificationProvider;->getCurrentMShopRegistrationToken()Ljava/lang/String;

    move-result-object v0

    .line 72
    .local v0, "currentRegistrationId":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 73
    const/4 v1, 0x0

    .line 79
    :goto_1
    return-object v1

    .end local v0    # "currentRegistrationId":Ljava/lang/String;
    :cond_0
    move-object v0, p1

    .line 71
    goto :goto_0

    .line 75
    .restart local v0    # "currentRegistrationId":Ljava/lang/String;
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 76
    sget-object v1, Lcom/amazon/mShop/pushnotification/getui/GetuiNotificationProvider;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "GETUI registration id : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    :cond_2
    const-string/jumbo v1, "com.amazon.mShop.android"

    const/4 v2, 0x3

    invoke-static {v1, v2, v0}, Lcom/amazon/mShop/control/pushnotification/NotificationSettingController;->constructNotificationTarget(Ljava/lang/String;ILjava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v1

    goto :goto_1
.end method

.method public getProviderName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 209
    const-string/jumbo v0, "GETUI"

    return-object v0
.end method

.method public handleClickActionOnErrorButton(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 120
    const-string/jumbo v2, "MASTER_APP_NOT_FOUND"

    invoke-virtual {v2, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 121
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 122
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "getui_master_app_download_url"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 124
    .local v1, "downloadUrl":Ljava/lang/String;
    invoke-static {}, Lcom/igexin/sdk/MessageManager;->getInstance()Lcom/igexin/sdk/MessageManager;

    move-result-object v2

    invoke-virtual {v2, p1, v1}, Lcom/igexin/sdk/MessageManager;->startWeb(Landroid/content/Context;Ljava/lang/String;)V

    .line 125
    const-string/jumbo v2, "pn_dl_getui"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 132
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v1    # "downloadUrl":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-virtual {p1}, Landroid/app/Activity;->finish()V

    .line 133
    return-void

    .line 127
    :cond_1
    const-string/jumbo v2, "SERVICE_NOT_AVAILABE"

    invoke-virtual {v2, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 129
    invoke-static {}, Lcom/igexin/sdk/MessageManager;->getInstance()Lcom/igexin/sdk/MessageManager;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/igexin/sdk/MessageManager;->initialize(Landroid/content/Context;)V

    .line 130
    const-string/jumbo v2, "pn_getui_unavailable"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public isAvailable(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 56
    const/4 v0, 0x1

    return v0
.end method

.method public onMainActivityDestroyed(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 51
    return-void
.end method

.method public setCurrentMShopRegistrationToken(Ljava/lang/String;)V
    .locals 2
    .param p1, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 90
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 91
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    if-nez p1, :cond_0

    .line 92
    const-string/jumbo v1, "getuiRegistrationId"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 97
    :goto_0
    return-void

    .line 94
    :cond_0
    const-string/jumbo v1, "getuiRegistrationId"

    invoke-interface {v0, v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setCurrentPushNotificationErrorId(Ljava/lang/String;)V
    .locals 0
    .param p1, "errorId"    # Ljava/lang/String;

    .prologue
    .line 116
    return-void
.end method

.method public startRegister(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 45
    invoke-static {}, Lcom/igexin/sdk/MessageManager;->getInstance()Lcom/igexin/sdk/MessageManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/igexin/sdk/MessageManager;->initialize(Landroid/content/Context;)V

    .line 46
    return-void
.end method
