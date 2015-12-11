.class public Lcom/amazon/mShop/sso/SSODebugSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "SSODebugSettingsActivity.java"


# static fields
.field private static sStrToRadioButtonIdMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field private mAccountPhoneNumberGroup:Landroid/widget/RadioGroup;

.field private mClickListener:Landroid/view/View$OnClickListener;

.field private mForceSignInGroup:Landroid/widget/RadioGroup;

.field private mSaveSettingsButon:Landroid/widget/Button;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 57
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    sput-object v1, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->sStrToRadioButtonIdMap:Ljava/util/Map;

    .line 59
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 60
    .local v0, "radioButtonOptionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    const-string/jumbo v1, "Normal"

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->sso_sign_in_normal_rbtn:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    const-string/jumbo v1, "Force"

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->sso_sign_in_force_rbtn:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    const-string/jumbo v1, "Weblab"

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->sso_sign_in_weblab_rbtn:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    sget-object v1, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->sStrToRadioButtonIdMap:Ljava/util/Map;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->sso_non_auth_force_sign_in_rgrpbtn:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    new-instance v0, Ljava/util/HashMap;

    .end local v0    # "radioButtonOptionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 66
    .restart local v0    # "radioButtonOptionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    const-string/jumbo v1, "Email"

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->account_email_rbtn:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    const-string/jumbo v1, "Email or Phone Number"

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->account_email_phone_number_rbtn:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    const-string/jumbo v1, "Account Weblab Control"

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->account_weblab_rbtn:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    sget-object v1, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->sStrToRadioButtonIdMap:Ljava/util/Map;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->account_phone_number_option_rgrpbtn:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 28
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 30
    iput-object v0, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mSaveSettingsButon:Landroid/widget/Button;

    .line 31
    iput-object v0, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mForceSignInGroup:Landroid/widget/RadioGroup;

    .line 32
    iput-object v0, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mAccountPhoneNumberGroup:Landroid/widget/RadioGroup;

    .line 33
    new-instance v0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity$1;-><init>(Lcom/amazon/mShop/sso/SSODebugSettingsActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mClickListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/SSODebugSettingsActivity;)Landroid/widget/RadioGroup;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mForceSignInGroup:Landroid/widget/RadioGroup;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/sso/SSODebugSettingsActivity;)Landroid/widget/RadioGroup;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/SSODebugSettingsActivity;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mAccountPhoneNumberGroup:Landroid/widget/RadioGroup;

    return-object v0
.end method

.method private initSSODebugSettingsView()V
    .locals 6

    .prologue
    .line 79
    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->sso_debug_settings:I

    const/4 v5, 0x0

    invoke-static {p0, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 80
    .local v3, "ssoDebugSettingsView":Landroid/view/View;
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->sso_saving_settings_btn:I

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mSaveSettingsButon:Landroid/widget/Button;

    .line 81
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->sso_non_auth_force_sign_in_rgrpbtn:I

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/RadioGroup;

    iput-object v4, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mForceSignInGroup:Landroid/widget/RadioGroup;

    .line 82
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->account_phone_number_option_rgrpbtn:I

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/RadioGroup;

    iput-object v4, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mAccountPhoneNumberGroup:Landroid/widget/RadioGroup;

    .line 83
    invoke-direct {p0, v3}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->setupRadioGroup(Landroid/view/View;)V

    .line 85
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->getSSONonAuthForceSignInOption()Ljava/lang/String;

    move-result-object v2

    .line 86
    .local v2, "selectedSignInOption":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mForceSignInGroup:Landroid/widget/RadioGroup;

    sget v5, Lcom/amazon/mShop/android/lib/R$id;->sso_non_auth_force_sign_in_rgrpbtn:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-direct {p0, v4, v5, v2}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->setCheckedRadioButton(Landroid/widget/RadioGroup;Ljava/lang/Integer;Ljava/lang/String;)V

    .line 89
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->getAccountPhoneNumberOption()Ljava/lang/String;

    move-result-object v1

    .line 90
    .local v1, "selectedAccountOption":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mAccountPhoneNumberGroup:Landroid/widget/RadioGroup;

    sget v5, Lcom/amazon/mShop/android/lib/R$id;->account_phone_number_option_rgrpbtn:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-direct {p0, v4, v5, v1}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->setCheckedRadioButton(Landroid/widget/RadioGroup;Ljava/lang/Integer;Ljava/lang/String;)V

    .line 93
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_account_phone_number_support:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v4

    if-nez v4, :cond_0

    .line 94
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->account_phone_number_option:I

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 95
    .local v0, "accountPhoneNumberOption":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 96
    const/16 v4, 0x8

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 100
    .end local v0    # "accountPhoneNumberOption":Landroid/view/View;
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mSaveSettingsButon:Landroid/widget/Button;

    iget-object v5, p0, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->mClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 101
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->setRootView(Landroid/view/View;)V

    .line 102
    return-void
.end method

.method private setCheckedRadioButton(Landroid/widget/RadioGroup;Ljava/lang/Integer;Ljava/lang/String;)V
    .locals 3
    .param p1, "radioButtonGroup"    # Landroid/widget/RadioGroup;
    .param p2, "radioGroupButtonId"    # Ljava/lang/Integer;
    .param p3, "selectedOption"    # Ljava/lang/String;

    .prologue
    .line 118
    sget-object v2, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->sStrToRadioButtonIdMap:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 119
    .local v1, "radioButtonOptionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1, p3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 120
    invoke-interface {v1, p3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {p1, v2}, Landroid/widget/RadioGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    .line 121
    .local v0, "optionRadioButton":Landroid/widget/RadioButton;
    if-eqz v0, :cond_0

    .line 122
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 125
    .end local v0    # "optionRadioButton":Landroid/widget/RadioButton;
    :cond_0
    return-void
.end method

.method private setupRadioGroup(Landroid/view/View;)V
    .locals 8
    .param p1, "debugSettingView"    # Landroid/view/View;

    .prologue
    .line 105
    sget-object v7, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->sStrToRadioButtonIdMap:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    .line 106
    .local v6, "radioButtonGroupId":Ljava/lang/Integer;
    sget-object v7, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->sStrToRadioButtonIdMap:Ljava/util/Map;

    invoke-interface {v7, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 107
    .local v4, "optionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 108
    .local v2, "option":Ljava/lang/String;
    invoke-interface {v4, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    .line 109
    .local v3, "optionId":Ljava/lang/Integer;
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v7

    invoke-virtual {p1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RadioButton;

    .line 110
    .local v5, "optionRadioButton":Landroid/widget/RadioButton;
    if-eqz v5, :cond_1

    .line 111
    invoke-virtual {v5, v2}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 115
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "option":Ljava/lang/String;
    .end local v3    # "optionId":Ljava/lang/Integer;
    .end local v4    # "optionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    .end local v5    # "optionRadioButton":Landroid/widget/RadioButton;
    .end local v6    # "radioButtonGroupId":Ljava/lang/Integer;
    :cond_2
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 75
    invoke-direct {p0}, Lcom/amazon/mShop/sso/SSODebugSettingsActivity;->initSSODebugSettingsView()V

    .line 76
    return-void
.end method
