.class public Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "MShopWebDebugSettingsActivity.java"

# interfaces
.implements Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;


# instance fields
.field private mCancelOrderUrlEditText:Landroid/widget/EditText;

.field private mCartUrlEditText:Landroid/widget/EditText;

.field private mCheckOutUrlEditText:Landroid/widget/EditText;

.field private mContactUsUrlEditText:Landroid/widget/EditText;

.field private mDealsUrlEditText:Landroid/widget/EditText;

.field private mHTMLNotifications:Landroid/widget/EditText;

.field private mHtmlGatewaySetting:Landroid/widget/EditText;

.field private mHtmlRecommendationsEditText:Landroid/widget/EditText;

.field private mOneClickSetting:Landroid/widget/EditText;

.field private mOrdersDetailUrlEditText:Landroid/widget/EditText;

.field private mSNSDetailUrlEditText:Landroid/widget/EditText;

.field private mSNSMysUrlEditText:Landroid/widget/EditText;

.field private mUdpUrlEditText:Landroid/widget/EditText;

.field private mWishlistUrlEditText:Landroid/widget/EditText;

.field private mYourAccountUrlEditText:Landroid/widget/EditText;

.field private mYourOrdersUrlEditText:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getHTMLFeatureEnvSettingsView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->recordEditedSettings()V

    return-void
.end method

.method private createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;
    .locals 3
    .param p1, "featureNameId"    # I
    .param p2, "featureStoreKey"    # Ljava/lang/String;

    .prologue
    .line 270
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->debug_switch_native_vs_html_row:I

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    .line 271
    .local v0, "featureItem":Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->setFeatureName(Ljava/lang/String;)V

    .line 272
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->setFeatureKey(Ljava/lang/String;)V

    .line 273
    invoke-direct {p0, p2}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->setSelectedFeatureValue(Ljava/lang/String;)V

    .line 274
    invoke-virtual {v0, p0}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->setOnSelectionChangeListener(Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;)V

    .line 275
    return-object v0
.end method

.method private getDebugSettingsEntryView()Landroid/view/View;
    .locals 9

    .prologue
    .line 78
    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->web_debug_settings_entry:I

    const/4 v8, 0x0

    invoke-static {p0, v7, v8}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 79
    .local v0, "debugSettingsViewEntry":Landroid/view/View;
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->html_sandbox_button:I

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 80
    .local v2, "htmlSandboxBtn":Landroid/widget/Button;
    new-instance v7, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$1;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$1;-><init>(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V

    invoke-virtual {v2, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 90
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->html_feature_env_debug_settings_button:I

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 91
    .local v1, "htmlFeatureEnvSettingBtn":Landroid/widget/Button;
    new-instance v7, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$2;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$2;-><init>(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V

    invoke-virtual {v1, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->weinre_debug_settings_button:I

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/Button;

    .line 99
    .local v6, "weinreSettingBtn":Landroid/widget/Button;
    new-instance v7, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$3;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$3;-><init>(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V

    invoke-virtual {v6, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->mash_api_test_button:I

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 108
    .local v3, "mashApiTestBtn":Landroid/widget/Button;
    new-instance v7, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$4;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$4;-><init>(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V

    invoke-virtual {v3, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 118
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->prime_upsell_settings_button:I

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    .line 119
    .local v4, "primeUpsellBtn":Landroid/widget/Button;
    new-instance v7, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$5;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$5;-><init>(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V

    invoke-virtual {v4, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 129
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->social_connect_settings_button:I

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    .line 130
    .local v5, "socialConnectBtn":Landroid/widget/Button;
    new-instance v7, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$6;

    invoke-direct {v7, p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$6;-><init>(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V

    invoke-virtual {v5, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    return-object v0
.end method

.method private getHTMLFeatureEnvSettingsView()Landroid/view/View;
    .locals 7

    .prologue
    .line 144
    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->web_debug_settings:I

    const/4 v5, 0x0

    invoke-static {p0, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 146
    .local v0, "debugSettingsView":Landroid/view/View;
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->debug_settings_feature_version_switch_table:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TableLayout;

    .line 147
    .local v3, "versionSwitchTable":Landroid/widget/TableLayout;
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_spinner_control:I

    const-string/jumbo v5, "debugSpinnerDismissLogicSwitch"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 148
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_flow:I

    const-string/jumbo v5, "switchFlow"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 150
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->debug_settings_feature_switch_table:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TableLayout;

    .line 153
    .local v2, "switchTable":Landroid/widget/TableLayout;
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_contact_us_switch_setting:I

    const-string/jumbo v5, "switchContactUs"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 154
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->check_out_debug_switch:I

    const-string/jumbo v5, "switchCheckOut"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 155
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_cart:I

    const-string/jumbo v5, "switchCart"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 156
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_one_click_setting:I

    const-string/jumbo v5, "switchOneClickSetting"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 157
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_gateway:I

    const-string/jumbo v5, "debugHTMLGateway"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 159
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_block_http:I

    const-string/jumbo v5, "debugShouldBlockHttp"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 160
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_html_notifications:I

    const-string/jumbo v5, "DEBUG_SWITCH_NOTIFICATIONS_PAGE"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 161
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_html_recommendations:I

    const-string/jumbo v5, "switchRecommendations"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 162
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_amazon_smile:I

    const-string/jumbo v5, "smile"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 165
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->deals_debug_title:I

    const-string/jumbo v5, "switchDeals"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 168
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->debug_enable_sns_in_ca:I

    const-string/jumbo v5, "debugEnableSnSInCA"

    invoke-direct {p0, v4, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->createFeatureItem(ILjava/lang/String;)Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;)V

    .line 171
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->sns_detail_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mSNSDetailUrlEditText:Landroid/widget/EditText;

    .line 172
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->sns_mys_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mSNSMysUrlEditText:Landroid/widget/EditText;

    .line 173
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->cart_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCartUrlEditText:Landroid/widget/EditText;

    .line 174
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->deals_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mDealsUrlEditText:Landroid/widget/EditText;

    .line 175
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->wishlist_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mWishlistUrlEditText:Landroid/widget/EditText;

    .line 176
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->udp_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mUdpUrlEditText:Landroid/widget/EditText;

    .line 177
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->debug_contact_us_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mContactUsUrlEditText:Landroid/widget/EditText;

    .line 178
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->checkout_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCheckOutUrlEditText:Landroid/widget/EditText;

    .line 179
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->one_click_setting_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mOneClickSetting:Landroid/widget/EditText;

    .line 180
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->html_gateway_setting_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHtmlGatewaySetting:Landroid/widget/EditText;

    .line 181
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->your_account_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mYourAccountUrlEditText:Landroid/widget/EditText;

    .line 182
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->your_orders_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mYourOrdersUrlEditText:Landroid/widget/EditText;

    .line 183
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->order_detail_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mOrdersDetailUrlEditText:Landroid/widget/EditText;

    .line 184
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->cancel_order_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCancelOrderUrlEditText:Landroid/widget/EditText;

    .line 185
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mSNSDetailUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentSnsDetail"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->sns_detail_webpage:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 186
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mSNSMysUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentSnsMys"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->sns_mys_page:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 187
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCartUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentCart"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->web_cart_page:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 188
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mUdpUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentUdpUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->product_details_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 189
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mDealsUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentDealsUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->deals_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 190
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mWishlistUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentWishlistUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->wishlist_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 191
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mContactUsUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentContactUsUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->contact_us_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 192
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCheckOutUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentCheckOutUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->web_check_out:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 193
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mYourAccountUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentYourAccountUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->your_account_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 194
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mYourOrdersUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentYourOrdersUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->your_orders_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 195
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mOrdersDetailUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentOrderDetailUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->order_detail_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 196
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCancelOrderUrlEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentCancelOrderUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->cancel_order_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 197
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mOneClickSetting:Landroid/widget/EditText;

    const-string/jumbo v5, "currentOneClickSettingUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 198
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHtmlGatewaySetting:Landroid/widget/EditText;

    const-string/jumbo v5, "currentGatewayUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->gateway_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 200
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->html_notifications_setting_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHTMLNotifications:Landroid/widget/EditText;

    .line 202
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHTMLNotifications:Landroid/widget/EditText;

    const-string/jumbo v5, "CURRENT_HTML_NOTIFICATIONS_SETTING_DEBUG_URL"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->html_notifications_settings_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 204
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->html_recommendations_setting_url_edit_text:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHtmlRecommendationsEditText:Landroid/widget/EditText;

    .line 205
    iget-object v4, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHtmlRecommendationsEditText:Landroid/widget/EditText;

    const-string/jumbo v5, "currentRecommendationsUrl"

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->html_recommendations_web_page_url:I

    invoke-direct {p0, v5, v6}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getSetting(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 207
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->set_new_sns_service_url_button:I

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 208
    .local v1, "setNewUrlButton":Landroid/widget/Button;
    new-instance v4, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$7;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity$7;-><init>(Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;)V

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 216
    return-object v0
.end method

.method private getSetting(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 228
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getSetting(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultStringId"    # I

    .prologue
    .line 220
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    invoke-interface {v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 221
    .local v0, "value":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 222
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 224
    :cond_0
    return-object v0
.end method

.method private recordEditedSettings()V
    .locals 7

    .prologue
    .line 232
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 233
    .local v0, "EditSettingMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/widget/EditText;>;"
    const-string/jumbo v5, "currentSnsDetail"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mSNSDetailUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 234
    const-string/jumbo v5, "currentSnsMys"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mSNSMysUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 235
    const-string/jumbo v5, "currentCart"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCartUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 236
    const-string/jumbo v5, "currentUdpUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mUdpUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 237
    const-string/jumbo v5, "currentWishlistUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mWishlistUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 238
    const-string/jumbo v5, "currentContactUsUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mContactUsUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 239
    const-string/jumbo v5, "currentDealsUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mDealsUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 240
    const-string/jumbo v5, "currentCheckOutUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCheckOutUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 241
    const-string/jumbo v5, "currentOneClickSettingUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mOneClickSetting:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 242
    const-string/jumbo v5, "currentGatewayUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHtmlGatewaySetting:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 243
    const-string/jumbo v5, "CURRENT_HTML_NOTIFICATIONS_SETTING_DEBUG_URL"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHTMLNotifications:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 244
    const-string/jumbo v5, "currentYourAccountUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mYourAccountUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 245
    const-string/jumbo v5, "currentYourOrdersUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mYourOrdersUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 246
    const-string/jumbo v5, "currentOrderDetailUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mOrdersDetailUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 247
    const-string/jumbo v5, "currentCancelOrderUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mCancelOrderUrlEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 248
    const-string/jumbo v5, "currentRecommendationsUrl"

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->mHtmlRecommendationsEditText:Landroid/widget/EditText;

    invoke-interface {v0, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 251
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    .line 252
    .local v4, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 253
    .local v3, "key":Ljava/lang/String;
    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 254
    .local v1, "editText":Landroid/widget/EditText;
    if-eqz v1, :cond_0

    .line 255
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v3, v5}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->saveEditSetting(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 258
    .end local v1    # "editText":Landroid/widget/EditText;
    .end local v3    # "key":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private saveEditSetting(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 261
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 73
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 74
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->getDebugSettingsEntryView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->pushView(Landroid/view/View;)V

    .line 75
    return-void
.end method

.method public onSelectionChanged(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "newSelection"    # Ljava/lang/String;
    .param p2, "featureKey"    # Ljava/lang/String;

    .prologue
    .line 266
    invoke-direct {p0, p2, p1}, Lcom/amazon/mShop/web/MShopWebDebugSettingsActivity;->saveEditSetting(Ljava/lang/String;Ljava/lang/String;)V

    .line 267
    return-void
.end method
