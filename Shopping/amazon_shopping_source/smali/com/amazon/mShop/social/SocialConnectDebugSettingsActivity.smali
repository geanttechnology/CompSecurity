.class public Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "SocialConnectDebugSettingsActivity.java"


# instance fields
.field private mClearUserCB:Landroid/widget/CheckBox;

.field private mRadioAlways:Landroid/widget/RadioButton;

.field private mRadioShowNever:Landroid/widget/RadioButton;

.field private mRadioShowOnce:Landroid/widget/RadioButton;

.field private mURLEdit:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->saveDebugSettings()V

    return-void
.end method

.method public static getSocialConnectDebugMode()Ljava/lang/String;
    .locals 2

    .prologue
    .line 63
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 64
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "socialConnectDebugMode"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private initSettings()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 104
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->getSocialConnectDebugMode()Ljava/lang/String;

    move-result-object v1

    .line 106
    .local v1, "mode":Ljava/lang/String;
    const-string/jumbo v3, "never"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 107
    iget-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mRadioShowNever:Landroid/widget/RadioButton;

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 114
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 115
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "socialConnectDebugUrl"

    invoke-interface {v0, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 116
    .local v2, "value":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 117
    const-string/jumbo v2, ""

    .line 119
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mURLEdit:Landroid/widget/EditText;

    invoke-virtual {v3, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 120
    return-void

    .line 108
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v2    # "value":Ljava/lang/String;
    :cond_1
    const-string/jumbo v3, "once"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 109
    iget-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mRadioShowOnce:Landroid/widget/RadioButton;

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0

    .line 111
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mRadioAlways:Landroid/widget/RadioButton;

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0
.end method

.method private saveDebugSettings()V
    .locals 4

    .prologue
    .line 80
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 82
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "once"

    .line 83
    .local v1, "mode":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mRadioShowNever:Landroid/widget/RadioButton;

    invoke-virtual {v2}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 84
    const-string/jumbo v1, "never"

    .line 93
    :goto_0
    const-string/jumbo v2, "socialConnectDebugMode"

    invoke-interface {v0, v2, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const-string/jumbo v2, "socialConnectDebugUrl"

    iget-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mURLEdit:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    iget-object v2, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mClearUserCB:Landroid/widget/CheckBox;

    invoke-virtual {v2}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 98
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getInstance()Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->clearDatabase()V

    .line 100
    :cond_0
    return-void

    .line 85
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mRadioAlways:Landroid/widget/RadioButton;

    invoke-virtual {v2}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 86
    const-string/jumbo v1, "always"

    goto :goto_0

    .line 90
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mClearUserCB:Landroid/widget/CheckBox;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0
.end method

.method public static shouldAlwaysDisplay()Z
    .locals 2

    .prologue
    .line 68
    const-string/jumbo v0, "always"

    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->getSocialConnectDebugMode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static shouldDisplayOnce()Z
    .locals 2

    .prologue
    .line 76
    const-string/jumbo v0, "once"

    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->getSocialConnectDebugMode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static shouldNeverDisplay()Z
    .locals 2

    .prologue
    .line 72
    const-string/jumbo v0, "never"

    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->getSocialConnectDebugMode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 36
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 37
    .local v1, "inflater":Landroid/view/LayoutInflater;
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->social_connect_debug_settings:I

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    .line 39
    .local v0, "content":Landroid/widget/ScrollView;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->social_connect_once:I

    invoke-virtual {v0, v3}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    iput-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mRadioShowOnce:Landroid/widget/RadioButton;

    .line 40
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->social_connect_never:I

    invoke-virtual {v0, v3}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    iput-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mRadioShowNever:Landroid/widget/RadioButton;

    .line 41
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->social_connect_always:I

    invoke-virtual {v0, v3}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    iput-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mRadioAlways:Landroid/widget/RadioButton;

    .line 43
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->social_connect_clear_data:I

    invoke-virtual {v0, v3}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/CheckBox;

    iput-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mClearUserCB:Landroid/widget/CheckBox;

    .line 44
    iget-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mClearUserCB:Landroid/widget/CheckBox;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 46
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->social_connect_url:I

    invoke-virtual {v0, v3}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->mURLEdit:Landroid/widget/EditText;

    .line 48
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->social_connect_save:I

    invoke-virtual {v0, v3}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 49
    .local v2, "saveButton":Landroid/widget/Button;
    new-instance v3, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity$1;-><init>(Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    invoke-direct {p0}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->initSettings()V

    .line 59
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->pushView(Landroid/view/View;)V

    .line 60
    return-void
.end method
