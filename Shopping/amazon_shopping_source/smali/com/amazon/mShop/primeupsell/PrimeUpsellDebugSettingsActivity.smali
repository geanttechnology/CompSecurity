.class public Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "PrimeUpsellDebugSettingsActivity.java"


# instance fields
.field private mClearUserCB:Landroid/widget/CheckBox;

.field private mForceEligible:Landroid/widget/CheckBox;

.field private mMaximumTimeToShow:Landroid/widget/EditText;

.field private mRadioAlways:Landroid/widget/RadioButton;

.field private mRadioNoShow:Landroid/widget/RadioButton;

.field private mRadioOnce:Landroid/widget/RadioButton;

.field private mURLEdit:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->saveDebugSettings()V

    return-void
.end method

.method public static getPrimeUpsellDebugMode()Ljava/lang/String;
    .locals 2

    .prologue
    .line 72
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 73
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "primeUpsellDebugMode"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private initSettings()V
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 102
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->getPrimeUpsellDebugMode()Ljava/lang/String;

    move-result-object v1

    .line 103
    .local v1, "mode":Ljava/lang/String;
    const-string/jumbo v3, "never"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 104
    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mRadioNoShow:Landroid/widget/RadioButton;

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 111
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 112
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "currentPrimeUpsellUrl"

    invoke-interface {v0, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 113
    .local v2, "value":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 114
    const-string/jumbo v2, ""

    .line 116
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mURLEdit:Landroid/widget/EditText;

    invoke-virtual {v3, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 118
    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mForceEligible:Landroid/widget/CheckBox;

    const-string/jumbo v4, "primeUpsellForceEligibleToNonPrimeUserDebug"

    const/4 v5, 0x0

    invoke-interface {v0, v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 120
    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mMaximumTimeToShow:Landroid/widget/EditText;

    const-string/jumbo v4, "primeMaximumTimeToShowDebug"

    invoke-interface {v0, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 121
    return-void

    .line 105
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v2    # "value":Ljava/lang/String;
    :cond_1
    const-string/jumbo v3, "once"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 106
    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mRadioOnce:Landroid/widget/RadioButton;

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0

    .line 108
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mRadioAlways:Landroid/widget/RadioButton;

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0
.end method

.method private saveDebugSettings()V
    .locals 4

    .prologue
    .line 77
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 78
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "once"

    .line 79
    .local v1, "mode":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mRadioNoShow:Landroid/widget/RadioButton;

    invoke-virtual {v2}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 80
    const-string/jumbo v1, "never"

    .line 88
    :goto_0
    const-string/jumbo v2, "primeUpsellDebugMode"

    invoke-interface {v0, v2, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    const-string/jumbo v2, "currentPrimeUpsellUrl"

    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mURLEdit:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    iget-object v2, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mClearUserCB:Landroid/widget/CheckBox;

    invoke-virtual {v2}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 93
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->getInstance()Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDatabaseHelper;->clearDatabase()V

    .line 96
    :cond_0
    const-string/jumbo v2, "primeUpsellForceEligibleToNonPrimeUserDebug"

    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mForceEligible:Landroid/widget/CheckBox;

    invoke-virtual {v3}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 98
    const-string/jumbo v2, "primeMaximumTimeToShowDebug"

    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mMaximumTimeToShow:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 99
    return-void

    .line 81
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mRadioAlways:Landroid/widget/RadioButton;

    invoke-virtual {v2}, Landroid/widget/RadioButton;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 82
    const-string/jumbo v1, "always"

    goto :goto_0

    .line 85
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mClearUserCB:Landroid/widget/CheckBox;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0
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
    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->prime_upsell_debug_settings:I

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 39
    .local v0, "content":Landroid/widget/LinearLayout;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->prime_upsell_none:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    iput-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mRadioNoShow:Landroid/widget/RadioButton;

    .line 40
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->prime_upsell_once:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    iput-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mRadioOnce:Landroid/widget/RadioButton;

    .line 41
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->prime_upsell_always:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    iput-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mRadioAlways:Landroid/widget/RadioButton;

    .line 43
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->prime_upsell_clear_data:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/CheckBox;

    iput-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mClearUserCB:Landroid/widget/CheckBox;

    .line 44
    iget-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mClearUserCB:Landroid/widget/CheckBox;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 46
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->prime_upsell_url:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mURLEdit:Landroid/widget/EditText;

    .line 48
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->prime_force_eligible:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/CheckBox;

    iput-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mForceEligible:Landroid/widget/CheckBox;

    .line 50
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->prime_upsell_maximum_time:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->mMaximumTimeToShow:Landroid/widget/EditText;

    .line 52
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->prime_upsell_save:I

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 53
    .local v2, "saveButton":Landroid/widget/Button;
    new-instance v3, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity$1;-><init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 61
    invoke-direct {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->initSettings()V

    .line 63
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity;->pushView(Landroid/view/View;)V

    .line 64
    return-void
.end method
