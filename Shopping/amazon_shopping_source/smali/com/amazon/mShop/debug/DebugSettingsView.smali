.class public Lcom/amazon/mShop/debug/DebugSettingsView;
.super Landroid/widget/ScrollView;
.source "DebugSettingsView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;,
        Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerAdapter;
    }
.end annotation


# instance fields
.field private final mCNGetuiVCID:Landroid/widget/TextView;

.field protected final mClearSessionCheckBox:Landroid/widget/CheckBox;

.field protected final mDebugActivity:Lcom/amazon/mShop/debug/DebugSettingsActivity;

.field private final mDefaultServiceSecureUrlLabel:Landroid/widget/TextView;

.field private final mDefaultServiceUrlLabel:Landroid/widget/TextView;

.field private final mLocaleOptionsSpinner:Landroid/widget/Spinner;

.field private final mSSOUrlRadioGroup:Landroid/widget/RadioGroup;

.field private mSelectedLocaleName:Ljava/lang/String;

.field protected final mServiceSecureUrlEditText:Landroid/widget/EditText;

.field protected final mServiceUrlEditText:Landroid/widget/EditText;

.field private final mSimulateNPECrashButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/debug/DebugSettingsActivity;)V
    .locals 13
    .param p1, "debugActivity"    # Lcom/amazon/mShop/debug/DebugSettingsActivity;

    .prologue
    const/4 v10, 0x0

    const/4 v12, 0x0

    .line 50
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 52
    iput-object p1, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDebugActivity:Lcom/amazon/mShop/debug/DebugSettingsActivity;

    .line 53
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    .line 54
    .local v4, "inflater":Landroid/view/LayoutInflater;
    sget v9, Lcom/amazon/mShop/android/lib/R$layout;->debug_settings_view:I

    invoke-virtual {v4, v9, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 56
    .local v3, "debugSettingsView":Landroid/widget/LinearLayout;
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->service_url_edit_text:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mServiceUrlEditText:Landroid/widget/EditText;

    .line 57
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->service_secure_url_edit_text:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mServiceSecureUrlEditText:Landroid/widget/EditText;

    .line 58
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->default_service_url_label:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDefaultServiceUrlLabel:Landroid/widget/TextView;

    .line 59
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->default_service_secure_url_label:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDefaultServiceSecureUrlLabel:Landroid/widget/TextView;

    .line 60
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->sso_check_login_url_radio_group:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/RadioGroup;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSSOUrlRadioGroup:Landroid/widget/RadioGroup;

    .line 62
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v9

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSelectedLocaleName:Ljava/lang/String;

    .line 64
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->clear_session_data_checkbox:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/CheckBox;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mClearSessionCheckBox:Landroid/widget/CheckBox;

    .line 66
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->locale_options_spinner:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/Spinner;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mLocaleOptionsSpinner:Landroid/widget/Spinner;

    .line 67
    new-instance v0, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerAdapter;

    iget-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDebugActivity:Lcom/amazon/mShop/debug/DebugSettingsActivity;

    invoke-direct {v0, p0, v9}, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerAdapter;-><init>(Lcom/amazon/mShop/debug/DebugSettingsView;Landroid/content/Context;)V

    .line 68
    .local v0, "adapter":Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerAdapter;
    iget-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mLocaleOptionsSpinner:Landroid/widget/Spinner;

    invoke-virtual {v9, v0}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 69
    new-instance v5, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;

    invoke-direct {v5, p0, v10}, Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;-><init>(Lcom/amazon/mShop/debug/DebugSettingsView;Lcom/amazon/mShop/debug/DebugSettingsView$1;)V

    .line 70
    .local v5, "listener":Lcom/amazon/mShop/debug/DebugSettingsView$LocaleSpinnerOnItemSelectedListener;
    iget-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mLocaleOptionsSpinner:Landroid/widget/Spinner;

    invoke-virtual {v9, v5}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 71
    iget-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mLocaleOptionsSpinner:Landroid/widget/Spinner;

    iget-object v10, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSelectedLocaleName:Ljava/lang/String;

    invoke-direct {p0, v10}, Lcom/amazon/mShop/debug/DebugSettingsView;->getPositionForLocaleName(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v9, v10}, Landroid/widget/Spinner;->setSelection(I)V

    .line 72
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cn_getui_vcid:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mCNGetuiVCID:Landroid/widget/TextView;

    .line 74
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->set_new_service_url_button:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/Button;

    .line 75
    .local v7, "setNewUrlButton":Landroid/widget/Button;
    new-instance v9, Lcom/amazon/mShop/debug/DebugSettingsView$1;

    invoke-direct {v9, p0}, Lcom/amazon/mShop/debug/DebugSettingsView$1;-><init>(Lcom/amazon/mShop/debug/DebugSettingsView;)V

    invoke-virtual {v7, v9}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 85
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->reset_to_prod_service_button:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/Button;

    .line 86
    .local v6, "resetButton":Landroid/widget/Button;
    new-instance v9, Lcom/amazon/mShop/debug/DebugSettingsView$2;

    invoke-direct {v9, p0}, Lcom/amazon/mShop/debug/DebugSettingsView$2;-><init>(Lcom/amazon/mShop/debug/DebugSettingsView;)V

    invoke-virtual {v6, v9}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->application_id:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 99
    .local v1, "applicationID":Landroid/widget/TextView;
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "ApplicationID: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v10

    invoke-interface {v10}, Lcom/amazon/mShop/platform/Platform;->getApplicationId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, "\n Cookies: = \n"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsView;->getContext()Landroid/content/Context;

    move-result-object v10

    const/4 v11, 0x1

    invoke-static {v10, v11}, Lcom/amazon/mShop/net/CookieBridge;->getCookiesOfCurrentLocale(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, "\n\n real Value of at-main/at-acb = "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsView;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-static {v10}, Lcom/amazon/mShop/net/CookieBridge;->getAtMainCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    invoke-direct {p0, v3}, Lcom/amazon/mShop/debug/DebugSettingsView;->showNotificationBlock(Landroid/widget/LinearLayout;)V

    .line 104
    invoke-direct {p0, v3}, Lcom/amazon/mShop/debug/DebugSettingsView;->showAIIDBlock(Landroid/widget/LinearLayout;)V

    .line 106
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/debug/DebugSettingsView;->addView(Landroid/view/View;)V

    .line 108
    iget-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSelectedLocaleName:Ljava/lang/String;

    invoke-virtual {p0, v9}, Lcom/amazon/mShop/debug/DebugSettingsView;->loadToDisplay(Ljava/lang/String;)V

    .line 110
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->simulate_npe_to_cause_crash:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/Button;

    iput-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSimulateNPECrashButton:Landroid/widget/Button;

    .line 111
    iget-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSimulateNPECrashButton:Landroid/widget/Button;

    new-instance v10, Lcom/amazon/mShop/debug/DebugSettingsView$3;

    invoke-direct {v10, p0}, Lcom/amazon/mShop/debug/DebugSettingsView$3;-><init>(Lcom/amazon/mShop/debug/DebugSettingsView;)V

    invoke-virtual {v9, v10}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 120
    const-string/jumbo v9, "zh_CN"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 121
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v9

    invoke-interface {v9}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    .line 122
    .local v2, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v9, "getuiRegistrationId"

    invoke-interface {v2, v9}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 123
    .local v8, "vcid":Ljava/lang/String;
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cn_getui_vcid_title:I

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9, v12}, Landroid/view/View;->setVisibility(I)V

    .line 124
    iget-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mCNGetuiVCID:Landroid/widget/TextView;

    invoke-virtual {v9, v12}, Landroid/widget/TextView;->setVisibility(I)V

    .line 125
    iget-object v9, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mCNGetuiVCID:Landroid/widget/TextView;

    invoke-static {v8}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_1

    .end local v8    # "vcid":Ljava/lang/String;
    :goto_0
    invoke-virtual {v9, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 127
    .end local v2    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_0
    return-void

    .line 125
    .restart local v2    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .restart local v8    # "vcid":Ljava/lang/String;
    :cond_1
    const-string/jumbo v8, "Not available"

    goto :goto_0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/debug/DebugSettingsView;)Landroid/widget/Spinner;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/debug/DebugSettingsView;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mLocaleOptionsSpinner:Landroid/widget/Spinner;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/debug/DebugSettingsView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/debug/DebugSettingsView;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSelectedLocaleName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$202(Lcom/amazon/mShop/debug/DebugSettingsView;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/debug/DebugSettingsView;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSelectedLocaleName:Ljava/lang/String;

    return-object p1
.end method

.method private getPositionForLocaleName(Ljava/lang/String;)I
    .locals 3
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 174
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getSupportedLocaleNameArray()[Ljava/lang/Object;

    move-result-object v1

    .line 175
    .local v1, "localeNameArray":[Ljava/lang/Object;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_1

    .line 176
    aget-object v2, v1, v0

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 180
    .end local v0    # "i":I
    :goto_1
    return v0

    .line 175
    .restart local v0    # "i":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 180
    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method private showAIIDBlock(Landroid/widget/LinearLayout;)V
    .locals 7
    .param p1, "debugSettingsView"    # Landroid/widget/LinearLayout;

    .prologue
    .line 152
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    .line 153
    .local v3, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v5, "applicationInstallId"

    invoke-interface {v3, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 154
    .local v1, "appInstallID":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 155
    const-string/jumbo v1, "null"

    .line 157
    :cond_0
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->app_install_id:I

    invoke-virtual {p1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 158
    .local v2, "appInstallIDTxtView":Landroid/widget/TextView;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "App Install ID: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 159
    .local v0, "aiidText":Ljava/lang/String;
    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 160
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->mail_aiid_to_me:I

    invoke-virtual {p1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    .line 161
    .local v4, "mailAIIDButton":Landroid/widget/Button;
    new-instance v5, Lcom/amazon/mShop/debug/DebugSettingsView$5;

    invoke-direct {v5, p0, v0}, Lcom/amazon/mShop/debug/DebugSettingsView$5;-><init>(Lcom/amazon/mShop/debug/DebugSettingsView;Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 171
    return-void
.end method

.method private showNotificationBlock(Landroid/widget/LinearLayout;)V
    .locals 7
    .param p1, "debugSettingsView"    # Landroid/widget/LinearLayout;

    .prologue
    .line 130
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 131
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v5, "gcmRegistrationId"

    invoke-interface {v0, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 132
    .local v3, "token":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 133
    const-string/jumbo v3, "null"

    .line 135
    :cond_0
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->notification_token:I

    invoke-virtual {p1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 136
    .local v2, "notificationToken":Landroid/widget/TextView;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "NotificationToken: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 137
    .local v4, "tokenText":Ljava/lang/String;
    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 138
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->mail_notification_to_me:I

    invoke-virtual {p1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 139
    .local v1, "mailTokenButton":Landroid/widget/Button;
    new-instance v5, Lcom/amazon/mShop/debug/DebugSettingsView$4;

    invoke-direct {v5, p0, v4}, Lcom/amazon/mShop/debug/DebugSettingsView$4;-><init>(Lcom/amazon/mShop/debug/DebugSettingsView;Ljava/lang/String;)V

    invoke-virtual {v1, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 149
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 237
    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->debug_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method protected loadToDisplay(Ljava/lang/String;)V
    .locals 8
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 184
    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsView;->getContext()Landroid/content/Context;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->config_serviceURL:I

    invoke-static {v6, v7, p1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 186
    .local v4, "defaultServiceUrl":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsView;->getContext()Landroid/content/Context;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->config_serviceSecureURL:I

    invoke-static {v6, v7, p1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 188
    .local v3, "defaultServiceSecureUrl":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDebugActivity:Lcom/amazon/mShop/debug/DebugSettingsActivity;

    invoke-virtual {v6, p1}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->getServiceUrlInMap(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 189
    .local v2, "currentServiceUrl":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 190
    move-object v2, v4

    .line 192
    :cond_0
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDebugActivity:Lcom/amazon/mShop/debug/DebugSettingsActivity;

    invoke-virtual {v6, p1}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->getServiceSecureUrlInMap(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 193
    .local v1, "currentServiceSecureUrl":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 194
    move-object v1, v3

    .line 197
    :cond_1
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDebugActivity:Lcom/amazon/mShop/debug/DebugSettingsActivity;

    invoke-virtual {v6, p1}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->getSSOCheckLoginServerInMap(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 198
    .local v0, "currentSSOCheckLoginServer":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 199
    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 200
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSSOUrlRadioGroup:Landroid/widget/RadioGroup;

    sget v7, Lcom/amazon/mShop/android/lib/R$id;->msh:I

    invoke-virtual {v6, v7}, Landroid/widget/RadioGroup;->check(I)V

    .line 212
    :goto_0
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDebugActivity:Lcom/amazon/mShop/debug/DebugSettingsActivity;

    invoke-virtual {v6, p1}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->getClearSessionDataSettingInMap(Ljava/lang/String;)Z

    move-result v5

    .line 213
    .local v5, "shouldClearSession":Z
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mClearSessionCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v6, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 215
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDefaultServiceUrlLabel:Landroid/widget/TextView;

    invoke-virtual {v6, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 216
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDefaultServiceSecureUrlLabel:Landroid/widget/TextView;

    invoke-virtual {v6, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 217
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mServiceUrlEditText:Landroid/widget/EditText;

    invoke-virtual {v6, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 218
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mServiceSecureUrlEditText:Landroid/widget/EditText;

    invoke-virtual {v6, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 221
    return-void

    .line 202
    .end local v5    # "shouldClearSession":Z
    :cond_2
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSSOUrlRadioGroup:Landroid/widget/RadioGroup;

    sget v7, Lcom/amazon/mShop/android/lib/R$id;->shm1:I

    invoke-virtual {v6, v7}, Landroid/widget/RadioGroup;->check(I)V

    goto :goto_0

    .line 205
    :cond_3
    const-string/jumbo v6, "MSH"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 206
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSSOUrlRadioGroup:Landroid/widget/RadioGroup;

    sget v7, Lcom/amazon/mShop/android/lib/R$id;->msh:I

    invoke-virtual {v6, v7}, Landroid/widget/RadioGroup;->check(I)V

    goto :goto_0

    .line 208
    :cond_4
    iget-object v6, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSSOUrlRadioGroup:Landroid/widget/RadioGroup;

    sget v7, Lcom/amazon/mShop/android/lib/R$id;->shm1:I

    invoke-virtual {v6, v7}, Landroid/widget/RadioGroup;->check(I)V

    goto :goto_0
.end method

.method protected recordEditedSettings(Ljava/lang/String;)V
    .locals 6
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 241
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mServiceUrlEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 242
    .local v2, "url":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mServiceSecureUrlEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 243
    .local v3, "secureUrl":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mClearSessionCheckBox:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v5

    .line 244
    .local v5, "shouldClearSession":Z
    const-string/jumbo v4, "MSH"

    .line 245
    .local v4, "selectedSSOCheckLoginServer":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mSSOUrlRadioGroup:Landroid/widget/RadioGroup;

    invoke-virtual {v0}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->shm1:I

    if-ne v0, v1, :cond_0

    .line 246
    const-string/jumbo v4, "SHM"

    .line 250
    :cond_0
    invoke-static {p1, v3}, Lcom/amazon/mobile/appdrawer/utils/mshopservice/MShopServiceUtils;->setServiceUrl(Ljava/lang/String;Ljava/lang/String;)V

    .line 252
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDebugActivity:Lcom/amazon/mShop/debug/DebugSettingsActivity;

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->recordInMap(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 253
    return-void
.end method

.method protected reloadDefaultUrlToDisplay(Ljava/lang/String;)V
    .locals 4
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 224
    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_serviceURL:I

    invoke-static {v2, v3, p1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 226
    .local v1, "defaultServiceUrl":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_serviceSecureURL:I

    invoke-static {v2, v3, p1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 229
    .local v0, "defaultServiceSecureUrl":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDefaultServiceUrlLabel:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 230
    iget-object v2, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mDefaultServiceSecureUrlLabel:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 231
    iget-object v2, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mServiceUrlEditText:Landroid/widget/EditText;

    invoke-virtual {v2, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 232
    iget-object v2, p0, Lcom/amazon/mShop/debug/DebugSettingsView;->mServiceSecureUrlEditText:Landroid/widget/EditText;

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 233
    return-void
.end method
