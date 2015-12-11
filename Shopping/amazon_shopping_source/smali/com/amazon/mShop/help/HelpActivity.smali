.class public Lcom/amazon/mShop/help/HelpActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "HelpActivity.java"


# instance fields
.field private final mUserListener:Lcom/amazon/mShop/model/auth/UserListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 39
    new-instance v0, Lcom/amazon/mShop/help/HelpActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/help/HelpActivity$1;-><init>(Lcom/amazon/mShop/help/HelpActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/help/HelpActivity;->mUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/help/HelpActivity;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/help/HelpActivity;
    .param p1, "x1"    # Landroid/view/View;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lcom/amazon/mShop/help/HelpActivity;->setPrimeInstantVideoPageContentVisibility(Landroid/view/View;)V

    return-void
.end method

.method private getAIVHelpView()Landroid/view/View;
    .locals 3

    .prologue
    .line 260
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->help_amazon_instant_video:I

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 261
    .local v0, "aivHelp":Landroid/view/View;
    return-object v0
.end method

.method private getContactUsView()Landroid/view/View;
    .locals 6

    .prologue
    .line 145
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->contact_us_root:I

    const/4 v4, 0x0

    invoke-static {p0, v3, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 146
    .local v0, "contactUs":Landroid/view/View;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->help_provide_app_feadback_button:I

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 147
    .local v2, "provideAppFeedback":Landroid/widget/Button;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->help_contact_us_feedback_header:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\n\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->more_provide_feedback_button:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 149
    .local v1, "description":Ljava/lang/String;
    invoke-virtual {v2, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 150
    new-instance v3, Lcom/amazon/mShop/help/HelpActivity$2;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/help/HelpActivity$2;-><init>(Lcom/amazon/mShop/help/HelpActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    return-object v0
.end method

.method private getRootView()Landroid/view/View;
    .locals 15

    .prologue
    .line 171
    sget v13, Lcom/amazon/mShop/android/lib/R$string;->help_and_about_title:I

    invoke-virtual {p0, v13}, Lcom/amazon/mShop/help/HelpActivity;->setTitle(I)V

    .line 172
    const/4 v13, 0x0

    invoke-virtual {p0, v13}, Lcom/amazon/mShop/help/HelpActivity;->setStopBehavior(I)V

    .line 173
    sget v13, Lcom/amazon/mShop/android/lib/R$layout;->help_root:I

    const/4 v14, 0x0

    invoke-static {p0, v13, v14}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v12

    .line 174
    .local v12, "root":Landroid/view/View;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_root_using_amazon_remembers_button:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/Button;

    .line 175
    .local v11, "remembersButton":Landroid/widget/Button;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_using_amazon_remembers_help_with_barcode_scans_button:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    .line 177
    .local v5, "barcodeScanButton":Landroid/widget/Button;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_root_your_account_and_settings_button:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 178
    .local v1, "accountSettingPrime":Landroid/widget/Button;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_root_your_account_and_settings_button_no_prime:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 180
    .local v0, "accountSettingNoPrime":Landroid/widget/Button;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_root_shipping_and_delivery_button:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/Button;

    .line 181
    .local v7, "deliveryHasFreeSuperSaverShipping":Landroid/widget/Button;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_root_shipping_and_delivery_button_no_free_super_saver_shipping:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/Button;

    .line 183
    .local v8, "deliveryNoFreeSuperSaverShipping":Landroid/widget/Button;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_fba_group:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout;

    .line 185
    .local v9, "fba":Landroid/widget/LinearLayout;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_atoz_guarantee_group:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 187
    .local v4, "atozGuarantee":Landroid/widget/LinearLayout;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_more_amazon_apps_group:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/LinearLayout;

    .line 189
    .local v10, "moreAmazonApps":Landroid/widget/LinearLayout;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_aiv_group:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 191
    .local v2, "aivGroup":Landroid/widget/LinearLayout;
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_appstore_group:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 193
    .local v3, "appstoreGroup":Landroid/widget/LinearLayout;
    sget v13, Lcom/amazon/mShop/android/lib/R$string;->config_hasRemembers:I

    invoke-static {p0, v13}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v13

    if-eqz v13, :cond_0

    .line 194
    const/4 v13, 0x0

    invoke-virtual {v11, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 195
    const/16 v13, 0x8

    invoke-virtual {v5, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 201
    :goto_0
    sget v13, Lcom/amazon/mShop/android/lib/R$string;->config_hasPrime:I

    invoke-static {p0, v13}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v13

    if-eqz v13, :cond_1

    .line 203
    const/4 v13, 0x0

    invoke-virtual {v1, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 204
    const/16 v13, 0x8

    invoke-virtual {v0, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 210
    :goto_1
    sget v13, Lcom/amazon/mShop/android/lib/R$string;->config_hasHelpOnFreeSuperSaverShipping:I

    invoke-static {p0, v13}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 211
    const/4 v13, 0x0

    invoke-virtual {v7, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 212
    const/16 v13, 0x8

    invoke-virtual {v8, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 218
    :goto_2
    sget v13, Lcom/amazon/mShop/android/lib/R$string;->config_hasHelpOnFBA:I

    invoke-static {p0, v13}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v13

    if-eqz v13, :cond_3

    .line 219
    const/4 v13, 0x0

    invoke-virtual {v9, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 224
    :goto_3
    sget v13, Lcom/amazon/mShop/android/lib/R$string;->config_hasHelpOnAtoZGuarantee:I

    invoke-static {p0, v13}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v13

    if-eqz v13, :cond_4

    .line 225
    const/4 v13, 0x0

    invoke-virtual {v4, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 230
    :goto_4
    sget v13, Lcom/amazon/mShop/android/lib/R$string;->config_hasMoreAmazonAppsMenu:I

    invoke-static {p0, v13}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v13

    if-eqz v13, :cond_5

    .line 231
    const/4 v13, 0x0

    invoke-virtual {v10, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 236
    :goto_5
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVAvailable()Z

    move-result v13

    if-eqz v13, :cond_6

    .line 237
    const/4 v13, 0x0

    invoke-virtual {v2, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 242
    :goto_6
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v13

    if-eqz v13, :cond_7

    .line 243
    const/4 v13, 0x0

    invoke-virtual {v3, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 248
    :goto_7
    sget v13, Lcom/amazon/mShop/android/lib/R$id;->help_root_contacting_us_button:I

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/Button;

    .line 249
    .local v6, "contactUs":Landroid/widget/Button;
    new-instance v13, Lcom/amazon/mShop/help/HelpActivity$3;

    invoke-direct {v13, p0}, Lcom/amazon/mShop/help/HelpActivity$3;-><init>(Lcom/amazon/mShop/help/HelpActivity;)V

    invoke-virtual {v6, v13}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 256
    return-object v12

    .line 197
    .end local v6    # "contactUs":Landroid/widget/Button;
    :cond_0
    const/16 v13, 0x8

    invoke-virtual {v11, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 198
    const/4 v13, 0x0

    invoke-virtual {v5, v13}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0

    .line 206
    :cond_1
    const/4 v13, 0x0

    invoke-virtual {v0, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 207
    const/16 v13, 0x8

    invoke-virtual {v1, v13}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_1

    .line 214
    :cond_2
    const/16 v13, 0x8

    invoke-virtual {v7, v13}, Landroid/widget/Button;->setVisibility(I)V

    .line 215
    const/4 v13, 0x0

    invoke-virtual {v8, v13}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_2

    .line 221
    :cond_3
    const/16 v13, 0x8

    invoke-virtual {v9, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_3

    .line 227
    :cond_4
    const/16 v13, 0x8

    invoke-virtual {v4, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_4

    .line 233
    :cond_5
    const/16 v13, 0x8

    invoke-virtual {v10, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_5

    .line 239
    :cond_6
    const/16 v13, 0x8

    invoke-virtual {v2, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_6

    .line 245
    :cond_7
    const/16 v13, 0x8

    invoke-virtual {v3, v13}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_7
.end method

.method private navigateToView()V
    .locals 3

    .prologue
    .line 96
    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "source"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 97
    .local v0, "source":Ljava/lang/String;
    const-string/jumbo v1, "aiv_help"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 98
    invoke-direct {p0}, Lcom/amazon/mShop/help/HelpActivity;->getAIVHelpView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/help/HelpActivity;->setRootView(Landroid/view/View;)V

    .line 100
    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    const-string/jumbo v2, "mshop:aiv"

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;)Z

    .line 106
    :goto_0
    return-void

    .line 101
    :cond_0
    const-string/jumbo v1, "menu_contact_us"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 102
    invoke-direct {p0}, Lcom/amazon/mShop/help/HelpActivity;->getContactUsView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/help/HelpActivity;->setRootView(Landroid/view/View;)V

    goto :goto_0

    .line 104
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/help/HelpActivity;->getRootView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/help/HelpActivity;->setRootView(Landroid/view/View;)V

    goto :goto_0
.end method

.method private setPrimeInstantVideoPageContentVisibility(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/16 v3, 0x8

    .line 113
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->help_aiv_prime_instant_video:I

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    if-ne v1, v2, :cond_0

    .line 114
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    .line 116
    .local v0, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->isPrimeEligible()Z

    move-result v1

    if-nez v1, :cond_0

    .line 117
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->help_aiv_prime_instant_video_button:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 118
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->help_aiv_not_prime_member:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 121
    .end local v0    # "user":Lcom/amazon/mShop/model/auth/User;
    :cond_0
    return-void
.end method


# virtual methods
.method public aivGoldButtonsOnClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 269
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    .line 271
    .local v0, "id":I
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->help_aiv_prime_instant_video_button:I

    if-ne v1, v0, :cond_1

    .line 272
    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->prime_upsell:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 289
    :cond_0
    :goto_0
    return-void

    .line 276
    :cond_1
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->help_aiv_your_watchlist_button:I

    if-ne v1, v0, :cond_2

    .line 277
    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v2, "url"

    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_wl_url:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "forceClearHistory"

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static {v2, v3, v4, v5}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    goto :goto_0

    .line 283
    :cond_2
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->help_aiv_your_video_library_button:I

    if-ne v1, v0, :cond_0

    .line 284
    sget-object v1, Lcom/amazon/mShop/navigation/AppNavigator$Target;->aiv_webview:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const-string/jumbo v2, "url"

    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->mshop_nav_menu_aiv_yvl_url:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "forceClearHistory"

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static {v2, v3, v4, v5}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 57
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 58
    invoke-direct {p0}, Lcom/amazon/mShop/help/HelpActivity;->navigateToView()V

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/help/HelpActivity;->mUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 61
    return-void
.end method

.method protected onDestroy()V
    .locals 3

    .prologue
    .line 84
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 87
    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "source"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 88
    .local v0, "source":Ljava/lang/String;
    const-string/jumbo v1, "aiv_help"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 89
    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->resetPosition()V

    .line 92
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/help/HelpActivity;->mUserListener:Lcom/amazon/mShop/model/auth/UserListener;

    invoke-static {v1}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 93
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 77
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/help/HelpActivity;->setIntent(Landroid/content/Intent;)V

    .line 78
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 79
    invoke-direct {p0}, Lcom/amazon/mShop/help/HelpActivity;->navigateToView()V

    .line 80
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 67
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 68
    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "source"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, "source":Ljava/lang/String;
    const-string/jumbo v1, "aiv_help"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 71
    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    const-string/jumbo v2, "mshop:aiv"

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;)Z

    .line 73
    :cond_0
    return-void
.end method

.method protected onViewPopped(Landroid/view/View;Landroid/view/View;)V
    .locals 2
    .param p1, "oldTop"    # Landroid/view/View;
    .param p2, "newTop"    # Landroid/view/View;

    .prologue
    .line 139
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->help_amazon_instant_video_layout:I

    if-ne v0, v1, :cond_0

    .line 140
    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->resetPosition()V

    .line 142
    :cond_0
    return-void
.end method

.method public pushView(I)V
    .locals 3
    .param p1, "pushedViewId"    # I

    .prologue
    .line 125
    const/4 v1, 0x0

    invoke-static {p0, p1, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 126
    .local v0, "pushedView":Landroid/view/View;
    invoke-super {p0, v0}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 128
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->help_amazon_instant_video:I

    if-ne p1, v1, :cond_0

    .line 130
    invoke-virtual {p0}, Lcom/amazon/mShop/help/HelpActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    const-string/jumbo v2, "mshop:aiv"

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;)Z

    .line 134
    :goto_0
    return-void

    .line 132
    :cond_0
    invoke-direct {p0, v0}, Lcom/amazon/mShop/help/HelpActivity;->setPrimeInstantVideoPageContentVisibility(Landroid/view/View;)V

    goto :goto_0
.end method
