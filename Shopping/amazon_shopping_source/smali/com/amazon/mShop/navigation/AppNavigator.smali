.class public Lcom/amazon/mShop/navigation/AppNavigator;
.super Ljava/lang/Object;
.source "AppNavigator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/navigation/AppNavigator$1;,
        Lcom/amazon/mShop/navigation/AppNavigator$Target;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/mShop/navigation/AppNavigator;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/navigation/AppNavigator;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 160
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    sget-object v0, Lcom/amazon/mShop/navigation/AppNavigator;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "target"    # Lcom/amazon/mShop/navigation/AppNavigator$Target;

    .prologue
    .line 36
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 37
    return-void
.end method

.method public static navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "target"    # Lcom/amazon/mShop/navigation/AppNavigator$Target;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/mShop/navigation/AppNavigator$Target;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)V"
        }
    .end annotation

    .prologue
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    const/4 v3, 0x0

    const/4 v6, 0x1

    const/4 v1, 0x0

    const/4 v9, -0x1

    .line 40
    sget-object v0, Lcom/amazon/mShop/navigation/AppNavigator$1;->$SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target:[I

    invoke-virtual {p1}, Lcom/amazon/mShop/navigation/AppNavigator$Target;->ordinal()I

    move-result v2

    aget v0, v0, v2

    packed-switch v0, :pswitch_data_0

    .line 158
    :goto_0
    return-void

    .line 42
    :pswitch_0
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    goto :goto_0

    .line 45
    :pswitch_1
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startCategoryBrowseActivity(Landroid/content/Context;)Z

    goto :goto_0

    .line 48
    :pswitch_2
    const-string/jumbo v0, "goldBoxLaunchParameters"

    const-class v1, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;

    invoke-static {p2, v0, v1}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;

    const-string/jumbo v1, "clickStreamOrigin"

    const-class v2, Ljava/lang/String;

    invoke-static {p2, v1, v2}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string/jumbo v2, "ref"

    const-string/jumbo v3, "refMarker"

    const-class v4, Ljava/lang/String;

    invoke-static {p2, v3, v4}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v3

    const-string/jumbo v2, "isReorderToFront"

    const-class v4, Ljava/lang/Boolean;

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static {p2, v2, v4, v5}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-static {p0, v0, v1, v3, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;Ljava/util/Map;Z)Z

    goto :goto_0

    .line 56
    :pswitch_3
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->more_email_gift_card_url:I

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/WebUtils;->openWebview(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 59
    :pswitch_4
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startRecentlyViewedItemsActivity(Landroid/content/Context;)Z

    goto :goto_0

    .line 62
    :pswitch_5
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->smile_url:I

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "smi_ac_menu_yc_cycsc"

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/util/WebUtils;->openWebview(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 65
    :pswitch_6
    const-string/jumbo v0, "clickStreamOrigin"

    const-class v1, Ljava/lang/String;

    invoke-static {p2, v0, v1}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string/jumbo v1, "ref"

    const-string/jumbo v2, "refMarker"

    const-class v3, Ljava/lang/String;

    invoke-static {p2, v2, v3}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v1, "extraFlag"

    const-class v3, Ljava/lang/Integer;

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p2, v1, v3, v4}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-static {p0, v0, v2, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startWishListActivity(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;I)Z

    goto/16 :goto_0

    .line 72
    :pswitch_7
    const-string/jumbo v0, "orderId"

    const-class v1, Ljava/lang/String;

    invoke-static {p2, v0, v1}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string/jumbo v0, "orderActionKey"

    const-class v2, Ljava/lang/String;

    invoke-static {p2, v0, v2}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string/jumbo v0, "shipmentIndex"

    const-class v3, Ljava/lang/Integer;

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p2, v0, v3, v4}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    const-string/jumbo v0, "refMarker"

    const-class v4, Ljava/lang/String;

    invoke-static {p2, v0, v4}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const-string/jumbo v0, "isReorderToFront"

    const-class v5, Ljava/lang/Boolean;

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-static {p2, v0, v5, v6}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    const-string/jumbo v0, "extraFlag"

    const-class v6, Ljava/lang/Integer;

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-static {p2, v0, v6, v9}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v6

    move-object v0, p0

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/util/ActivityUtils;->startYourOrdersActivity(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZI)Z

    goto/16 :goto_0

    .line 82
    :pswitch_8
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startYourAccountActivity(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 85
    :pswitch_9
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startRecommendationsActivity(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 88
    :pswitch_a
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startSnsManageYourSubscribesActivity(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 91
    :pswitch_b
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startBackupYourPhotosActivity(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 94
    :pswitch_c
    new-array v0, v3, [I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startLocaleSwitchActivity(Landroid/content/Context;[I)Z

    goto/16 :goto_0

    .line 97
    :pswitch_d
    const-string/jumbo v0, "category"

    const-class v1, Ljava/lang/String;

    invoke-static {p2, v0, v1}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startNotificationSettingActivity(Landroid/content/Context;Ljava/lang/String;)Z

    goto/16 :goto_0

    .line 102
    :pswitch_e
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startContactUsActivity(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 105
    :pswitch_f
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startHelpActivity(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 108
    :pswitch_10
    new-array v0, v3, [I

    invoke-static {p0, v1, v6, v1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startLoginActivity(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;[I)Z

    goto/16 :goto_0

    .line 111
    :pswitch_11
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startLogoutActivity(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 114
    :pswitch_12
    const-string/jumbo v0, "url"

    const-class v1, Ljava/lang/String;

    invoke-static {p2, v0, v1}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/WebUtils;->openWebview(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 117
    :pswitch_13
    const-string/jumbo v0, "url"

    const-class v1, Ljava/lang/String;

    invoke-static {p2, v0, v1}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 118
    .local v8, "url":Ljava/lang/String;
    const-string/jumbo v0, "forceClearHistory"

    const-class v1, Ljava/lang/Boolean;

    invoke-static {p2, v0, v1}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    .line 119
    .local v7, "forceClearHistory":Z
    invoke-static {p0, v8, v7}, Lcom/amazon/mShop/util/ActivityUtils;->startAIVWebActivity(Landroid/content/Context;Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 122
    .end local v7    # "forceClearHistory":Z
    .end local v8    # "url":Ljava/lang/String;
    :pswitch_14
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startAIVSettingsActivity(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 125
    :pswitch_15
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startHelpActivityWithAIVHelpPage(Landroid/content/Context;)Z

    goto/16 :goto_0

    .line 140
    :pswitch_16
    invoke-virtual {p1}, Lcom/amazon/mShop/navigation/AppNavigator$Target;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, v6}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivity(Landroid/content/Context;Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 143
    :pswitch_17
    if-nez p2, :cond_0

    move-object v0, v1

    :goto_1
    invoke-static {p0, v1, v9, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startAIVGatewayActivity(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)Z

    goto/16 :goto_0

    :cond_0
    const-string/jumbo v0, "url"

    const-class v2, Ljava/lang/String;

    invoke-static {p2, v0, v2}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_1

    .line 147
    :pswitch_18
    if-nez p2, :cond_1

    :goto_2
    invoke-static {p0, v9, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startPrimeUpsellActivity(Landroid/content/Context;ILjava/lang/String;)V

    goto/16 :goto_0

    :cond_1
    const-string/jumbo v0, "url"

    const-class v1, Ljava/lang/String;

    invoke-static {p2, v0, v1}, Lcom/amazon/mShop/util/Maps;->get(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    move-object v1, v0

    goto :goto_2

    .line 151
    :pswitch_19
    const-string/jumbo v0, "hm_exit_ok"

    const-string/jumbo v1, "hm_exit_cancel"

    invoke-static {p0, v0, v1}, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper;->create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    goto/16 :goto_0

    .line 40
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_16
        :pswitch_17
        :pswitch_18
        :pswitch_19
    .end packed-switch
.end method
