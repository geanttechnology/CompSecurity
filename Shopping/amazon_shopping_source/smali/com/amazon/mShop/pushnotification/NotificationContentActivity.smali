.class public Lcom/amazon/mShop/pushnotification/NotificationContentActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "NotificationContentActivity.java"


# instance fields
.field private finishIfBackToForground:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 63
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->finishIfBackToForground:Z

    return-void
.end method

.method private launchTargetNotificationActivity()V
    .locals 25

    .prologue
    .line 98
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "ref"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 99
    .local v6, "refMarker":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    sget-object v11, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 104
    .local v11, "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "NotificationMarketPlace"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 105
    .local v21, "targetMarketPlace":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    move-object/from16 v0, v21

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/platform/AppLocale;->getLocaleByMarketPlaceId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 106
    .local v20, "targetLocaleName":Ljava/lang/String;
    const-string/jumbo v2, "country_name"

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-static {v0, v2, v1}, Lcom/amazon/mShop/util/ResourcesUtils;->getStringOfSpecificLocale(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 107
    .local v19, "targetCountryName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v12

    .line 108
    .local v12, "currentLocaleName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2, v12}, Lcom/amazon/mShop/platform/AppLocale;->getMarketPlaceIdByLocale(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 109
    .local v13, "currentMarketplace":Ljava/lang/String;
    move-object/from16 v0, v21

    invoke-virtual {v13, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v16

    .line 111
    .local v16, "matchCurrentMarketPlace":Z
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v9

    .line 112
    .local v9, "action":Ljava/lang/String;
    if-nez v16, :cond_5

    .line 115
    const/4 v2, 0x0

    const/4 v3, -0x1

    const/4 v4, 0x1

    move-object/from16 v0, p0

    invoke-static {v0, v2, v3, v4}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;Ljava/util/Map;IZ)Z

    .line 117
    sget v22, Lcom/amazon/mShop/android/lib/R$string;->notification_switch_locale_toast_text_for_product:I

    .line 118
    .local v22, "toastTextId":I
    const-string/jumbo v2, "GoToUDP"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 119
    sget v22, Lcom/amazon/mShop/android/lib/R$string;->notification_switch_locale_toast_text_for_deal:I

    .line 121
    const-string/jumbo v2, "pn_single_ld_t"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 135
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v19, v3, v4

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-virtual {v0, v1, v3}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;Ljava/lang/String;)V

    .line 137
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->finish()V

    .line 206
    .end local v22    # "toastTextId":I
    :cond_1
    :goto_2
    return-void

    .line 99
    .end local v9    # "action":Ljava/lang/String;
    .end local v11    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    .end local v12    # "currentLocaleName":Ljava/lang/String;
    .end local v13    # "currentMarketplace":Ljava/lang/String;
    .end local v16    # "matchCurrentMarketPlace":Z
    .end local v19    # "targetCountryName":Ljava/lang/String;
    .end local v20    # "targetLocaleName":Ljava/lang/String;
    .end local v21    # "targetMarketPlace":Ljava/lang/String;
    :cond_2
    new-instance v11, Lcom/amazon/mShop/control/item/ClickStreamTag;

    const-string/jumbo v2, ""

    invoke-direct {v11, v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 124
    .restart local v9    # "action":Ljava/lang/String;
    .restart local v11    # "clickStreamTag":Lcom/amazon/mShop/control/item/ClickStreamTag;
    .restart local v12    # "currentLocaleName":Ljava/lang/String;
    .restart local v13    # "currentMarketplace":Ljava/lang/String;
    .restart local v16    # "matchCurrentMarketPlace":Z
    .restart local v19    # "targetCountryName":Ljava/lang/String;
    .restart local v20    # "targetLocaleName":Ljava/lang/String;
    .restart local v21    # "targetMarketPlace":Ljava/lang/String;
    .restart local v22    # "toastTextId":I
    :cond_3
    const-string/jumbo v2, "GoToDealListPage"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 125
    sget v22, Lcom/amazon/mShop/android/lib/R$string;->notification_switch_locale_toast_text_for_deal_category:I

    .line 126
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->logRefMarkerForDealList()V

    goto :goto_1

    .line 129
    :cond_4
    const-string/jumbo v2, "GoToDetailedOrder"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 130
    sget v22, Lcom/amazon/mShop/android/lib/R$string;->notification_switch_locale_toast_text_for_order_details:I

    .line 132
    const-string/jumbo v2, "pn_shipped_t"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_1

    .line 141
    .end local v22    # "toastTextId":I
    :cond_5
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "NotificationType"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 142
    .local v17, "notificationType":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "NotificationType"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V

    .line 143
    invoke-static/range {v17 .. v17}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 146
    invoke-static/range {v17 .. v17}, Lcom/amazon/mShop/util/MShopSystemNotificationManagerUtil;->removeStackedNotifications(Ljava/lang/String;)V

    .line 149
    :cond_6
    const-string/jumbo v2, "GoToDealListPage"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 150
    new-instance v18, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;

    const-string/jumbo v2, "LD"

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string/jumbo v4, "refineCategory"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string/jumbo v5, "refineCategoryDisplayName"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v18

    invoke-direct {v0, v2, v3, v4}, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    .local v18, "parameters":Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;
    invoke-virtual {v11}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "ref"

    invoke-static {v3, v6}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v3

    const/4 v4, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-static {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;Z)Z

    .line 157
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->logRefMarkerForDealList()V

    goto/16 :goto_2

    .line 159
    .end local v18    # "parameters":Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;
    :cond_7
    const-string/jumbo v2, "GoToUDP"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 160
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "asin"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 161
    .local v10, "asin":Ljava/lang/String;
    new-instance v2, Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v2, v10, v11}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    const-string/jumbo v3, "ref"

    invoke-static {v3, v6}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v3

    const/4 v4, -0x1

    move-object/from16 v0, p0

    invoke-static {v0, v2, v3, v4}, Lcom/amazon/mShop/util/ActivityUtils;->launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;Ljava/util/Map;I)Z

    .line 164
    const-string/jumbo v2, "pn_single_ld_t"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 166
    .end local v10    # "asin":Ljava/lang/String;
    :cond_8
    const-string/jumbo v2, "GoToDetailedOrder"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 169
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_9

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "m5n_msh_"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_9

    .line 170
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "m5n_msh_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 173
    :cond_9
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "order_id"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "order_to_view"

    const/4 v5, -0x1

    const/4 v7, 0x0

    const/4 v8, -0x1

    move-object/from16 v2, p0

    invoke-static/range {v2 .. v8}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZI)Z

    .line 177
    const-string/jumbo v2, "pn_shipped_t"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 179
    :cond_a
    const-string/jumbo v2, "GoToSNS"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 181
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "data"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 182
    .local v23, "token":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sns_dp_block_title:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v14

    .line 184
    .local v14, "defaultTitle":Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-static {v0, v1, v14, v6}, Lcom/amazon/mShop/util/ActivityUtils;->startSnsDispatchActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    .line 187
    const-string/jumbo v2, "pn_sns_t"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 188
    .end local v14    # "defaultTitle":Ljava/lang/String;
    .end local v23    # "token":Ljava/lang/String;
    :cond_b
    const-string/jumbo v2, "GoToDealsLandingPage"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 190
    const/4 v2, 0x0

    invoke-virtual {v11}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "ref"

    invoke-static {v4, v6}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v4

    const/4 v5, 0x0

    move-object/from16 v0, p0

    invoke-static {v0, v2, v3, v4, v5}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;Z)Z

    .line 193
    const-string/jumbo v2, "pn_dotd_t"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 194
    :cond_c
    const-string/jumbo v2, "GoToDeepLink"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 195
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v24

    .line 197
    .local v24, "uri":Landroid/net/Uri;
    :try_start_0
    invoke-static/range {v24 .. v24}, Lcom/amazon/mShop/publicurl/PublicURLProcessorFactory;->getInstance(Landroid/net/Uri;)Lcom/amazon/mShop/publicurl/PublicURLProcessor;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_NOTIFICATION:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-virtual {v2, v0, v3}, Lcom/amazon/mShop/publicurl/PublicURLProcessor;->process(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/amazon/mShop/publicurl/PublicURLProcessException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_2

    .line 198
    :catch_0
    move-exception v15

    .line 199
    .local v15, "e":Lcom/amazon/mShop/publicurl/PublicURLProcessException;
    invoke-static {v15}, Lcom/amazon/mShop/net/ErrorExceptionMetricsObserver;->logMetric(Ljava/lang/Exception;)V

    goto/16 :goto_2

    .line 201
    .end local v15    # "e":Lcom/amazon/mShop/publicurl/PublicURLProcessException;
    .end local v24    # "uri":Landroid/net/Uri;
    :cond_d
    const-string/jumbo v2, "GoToSmartLink"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 202
    const-string/jumbo v2, "pn_sns_t"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 203
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v24

    .line 204
    .restart local v24    # "uri":Landroid/net/Uri;
    invoke-virtual/range {v24 .. v24}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-static {v0, v2}, Lcom/amazon/mShop/util/WebUtils;->openWebview(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_2
.end method

.method private logRefMarkerForDealList()V
    .locals 2

    .prologue
    .line 240
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "refineCategory"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 242
    const-string/jumbo v0, "pn_group_ld_t"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 247
    :goto_0
    return-void

    .line 245
    :cond_0
    const-string/jumbo v0, "pn_all_ld_t"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 69
    invoke-direct {p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->launchTargetNotificationActivity()V

    .line 70
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 210
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 211
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->setIntent(Landroid/content/Intent;)V

    .line 224
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->finishIfBackToForground:Z

    .line 225
    sget-boolean v0, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 226
    const-string/jumbo v0, "AmazonActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onNewIntent: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 229
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->launchTargetNotificationActivity()V

    .line 231
    return-void
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 74
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 79
    iget-boolean v0, p0, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->finishIfBackToForground:Z

    if-eqz v0, :cond_0

    .line 80
    invoke-virtual {p0}, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->finish()V

    .line 83
    :cond_0
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 235
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStop()V

    .line 236
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/pushnotification/NotificationContentActivity;->finishIfBackToForground:Z

    .line 237
    return-void
.end method
