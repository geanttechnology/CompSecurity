.class public Lcom/amazon/mShop/account/CreateNewAccountView;
.super Landroid/widget/ScrollView;
.source "CreateNewAccountView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/control/account/NewAccountSubscriber;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;
    }
.end annotation


# instance fields
.field private final MIN_PASSWORD_LENGTH:I

.field private cnaLegalInformationLink:Landroid/widget/TextView;

.field private final content:Landroid/view/View;

.field private continueButton:Landroid/widget/Button;

.field private email:Landroid/widget/EditText;

.field emailTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

.field private fullName:Landroid/widget/EditText;

.field private furigana:Landroid/widget/EditText;

.field furiganaTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

.field private final loginActivity:Lcom/amazon/mShop/account/LoginActivity;

.field private final mRefMarker:Ljava/lang/String;

.field nameTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

.field private final newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;

.field private password:Landroid/widget/EditText;

.field passwordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

.field private reenter_password:Landroid/widget/EditText;

.field reenterpasswordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

.field private final taskCallback:Lcom/amazon/mShop/control/TaskCallback;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/account/LoginActivity;Ljava/lang/String;)V
    .locals 11
    .param p1, "loginActivity"    # Lcom/amazon/mShop/account/LoginActivity;
    .param p2, "refMarker"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x0

    .line 64
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 40
    const/4 v8, 0x6

    iput v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->MIN_PASSWORD_LENGTH:I

    .line 65
    iput-object p1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    .line 66
    iput-object p2, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->mRefMarker:Ljava/lang/String;

    .line 69
    invoke-virtual {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-static {v8}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    .line 70
    .local v5, "layoutInflater":Landroid/view/LayoutInflater;
    sget v8, Lcom/amazon/mShop/android/lib/R$layout;->create_new_account:I

    const/4 v9, 0x0

    invoke-virtual {v5, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    .line 72
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    sget v9, Lcom/amazon/mShop/android/lib/R$id;->create_account_button:I

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/Button;

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->continueButton:Landroid/widget/Button;

    .line 73
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->continueButton:Landroid/widget/Button;

    new-instance v9, Lcom/amazon/mShop/account/CreateNewAccountView$1;

    invoke-direct {v9, p0, p1}, Lcom/amazon/mShop/account/CreateNewAccountView$1;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;Lcom/amazon/mShop/account/LoginActivity;)V

    invoke-virtual {v8, v9}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 94
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->continueButton:Landroid/widget/Button;

    invoke-virtual {v8, v10}, Landroid/widget/Button;->setEnabled(Z)V

    .line 96
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cna_name_edit:I

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/EditText;

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->fullName:Landroid/widget/EditText;

    .line 97
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cna_furigana_edit:I

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/EditText;

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->furigana:Landroid/widget/EditText;

    .line 98
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cna_email_edit:I

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/EditText;

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;

    .line 101
    iget-object v9, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;

    invoke-virtual {p1}, Lcom/amazon/mShop/account/LoginActivity;->isAccountPhoneNumberNeeded()Z

    move-result v8

    if-eqz v8, :cond_1

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->cna_email_phone_number_hint:I

    :goto_0
    invoke-virtual {v9, v8}, Landroid/widget/EditText;->setHint(I)V

    .line 103
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cna_password_edit:I

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/EditText;

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    .line 104
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cna_duplicate_password_edit:I

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/EditText;

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->reenter_password:Landroid/widget/EditText;

    .line 106
    new-instance v8, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;

    iget-object v9, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->fullName:Landroid/widget/EditText;

    invoke-direct {v8, p0, v9}, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;Landroid/widget/EditText;)V

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->nameTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    .line 107
    new-instance v8, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;

    iget-object v9, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->furigana:Landroid/widget/EditText;

    invoke-direct {v8, p0, v9}, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;Landroid/widget/EditText;)V

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->furiganaTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    .line 108
    new-instance v8, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;

    iget-object v9, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;

    invoke-direct {v8, p0, v9}, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;Landroid/widget/EditText;)V

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->emailTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    .line 109
    new-instance v8, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;

    iget-object v9, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    invoke-direct {v8, p0, v9}, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;Landroid/widget/EditText;)V

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->passwordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    .line 110
    new-instance v8, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;

    iget-object v9, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->reenter_password:Landroid/widget/EditText;

    invoke-direct {v8, p0, v9}, Lcom/amazon/mShop/account/CreateNewAccountView$CreateNewTextWatcher;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;Landroid/widget/EditText;)V

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->reenterpasswordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    .line 112
    sget v8, Lcom/amazon/mShop/android/lib/R$string;->config_cna_requires_furigana:I

    invoke-static {p1, v8}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 113
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->furigana:Landroid/widget/EditText;

    invoke-virtual {v8, v10}, Landroid/widget/EditText;->setVisibility(I)V

    .line 118
    :goto_1
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->fullName:Landroid/widget/EditText;

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_name_rule:I

    invoke-static {v8, v9}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 119
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->furigana:Landroid/widget/EditText;

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_furigana_rule:I

    invoke-static {v8, v9}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 120
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_email_rule:I

    invoke-static {v8, v9}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 121
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_password_rule:I

    invoke-static {v8, v9}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 122
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->reenter_password:Landroid/widget/EditText;

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_password_rule:I

    invoke-static {v8, v9}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 123
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cna_legal_information:I

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->cnaLegalInformationLink:Landroid/widget/TextView;

    .line 124
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->cnaLegalInformationLink:Landroid/widget/TextView;

    new-instance v9, Lcom/amazon/mShop/account/CreateNewAccountView$2;

    invoke-direct {v9, p0, p1}, Lcom/amazon/mShop/account/CreateNewAccountView$2;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;Lcom/amazon/mShop/account/LoginActivity;)V

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 137
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    sget v9, Lcom/amazon/mShop/android/lib/R$id;->cna_registration_agreement:I

    invoke-virtual {v8, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 138
    .local v4, "cnaRegistrationAgreement":Landroid/widget/TextView;
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_registration_agreement:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 139
    .local v6, "registrationAgreementText":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 141
    new-instance v7, Landroid/text/SpannableString;

    invoke-direct {v7, v6}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 143
    .local v7, "ss":Landroid/text/SpannableString;
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_conditions_of_use_and_sale_text:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 144
    .local v0, "cnaConditionsOfUseAndSaleText":Ljava/lang/String;
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_conditions_of_use_and_sale_url:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 146
    .local v1, "cnaConditionsOfUseAndSaleUrl":Ljava/lang/String;
    invoke-static {p1, v7, v6, v0, v1}, Lcom/amazon/mShop/util/UIUtils;->addEmbeddedLink(Lcom/amazon/mShop/AmazonActivity;Landroid/text/SpannableString;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_privacy_notice_text:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 150
    .local v2, "cnaPrivacyNoticeText":Ljava/lang/String;
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->cna_privacy_notice_url:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 152
    .local v3, "cnaPrivacyNoticeUrl":Ljava/lang/String;
    invoke-static {p1, v7, v6, v2, v3}, Lcom/amazon/mShop/util/UIUtils;->addEmbeddedLink(Lcom/amazon/mShop/AmazonActivity;Landroid/text/SpannableString;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 155
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v8

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 160
    .end local v0    # "cnaConditionsOfUseAndSaleText":Ljava/lang/String;
    .end local v1    # "cnaConditionsOfUseAndSaleUrl":Ljava/lang/String;
    .end local v2    # "cnaPrivacyNoticeText":Ljava/lang/String;
    .end local v3    # "cnaPrivacyNoticeUrl":Ljava/lang/String;
    .end local v7    # "ss":Landroid/text/SpannableString;
    :cond_0
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->content:Landroid/view/View;

    invoke-virtual {p0, v8}, Lcom/amazon/mShop/account/CreateNewAccountView;->addView(Landroid/view/View;)V

    .line 161
    new-instance v8, Lcom/amazon/mShop/control/account/NewAccountController;

    invoke-direct {v8, p0}, Lcom/amazon/mShop/control/account/NewAccountController;-><init>(Lcom/amazon/mShop/control/account/NewAccountSubscriber;)V

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;

    .line 162
    new-instance v8, Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {v8, p1}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iget-object v9, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;

    sget v10, Lcom/amazon/mShop/android/lib/R$string;->cna_in_progress:I

    invoke-virtual {v8, v9, p1, v10}, Lcom/amazon/mShop/TaskCallbackFactory;->getFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    .line 163
    return-void

    .line 101
    .end local v4    # "cnaRegistrationAgreement":Landroid/widget/TextView;
    .end local v6    # "registrationAgreementText":Ljava/lang/String;
    :cond_1
    sget v8, Lcom/amazon/mShop/android/lib/R$string;->cna_email_hint:I

    goto/16 :goto_0

    .line 115
    :cond_2
    iget-object v8, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->furigana:Landroid/widget/EditText;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/widget/EditText;->setVisibility(I)V

    goto/16 :goto_1
.end method

.method static synthetic access$000(Lcom/amazon/mShop/account/CreateNewAccountView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->isValidEmail()Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/account/CreateNewAccountView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->isValidPassword()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/account/CreateNewAccountView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->updateContinueButtonEnabled()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/account/NewAccountController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->fullName:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->furigana:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/account/CreateNewAccountView;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/control/TaskCallback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/account/CreateNewAccountView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->mRefMarker:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/mShop/account/CreateNewAccountView;)Lcom/amazon/mShop/account/LoginActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/account/CreateNewAccountView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    return-object v0
.end method

.method private checkValidAccountFormat()Z
    .locals 3

    .prologue
    .line 208
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->newAccountController:Lcom/amazon/mShop/control/account/NewAccountController;

    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/control/account/NewAccountController;->isValidEmail(Ljava/lang/String;)Z

    move-result v0

    .line 212
    .local v0, "validEmail":Z
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_account_phone_number_support:I

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/account/LoginActivity;->isAccountPhoneNumberNeeded()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    .end local v0    # "validEmail":Z
    :cond_0
    return v0
.end method

.method private isValidEmail()Z
    .locals 3

    .prologue
    .line 195
    invoke-direct {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->checkValidAccountFormat()Z

    move-result v0

    if-nez v0, :cond_0

    .line 200
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 201
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->email:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->cna_email_requirement_error:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setError(Ljava/lang/CharSequence;)V

    .line 202
    const/4 v0, 0x0

    .line 204
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private isValidPassword()Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 177
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->reenter_password:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 180
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->requestFocus()Z

    .line 181
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->cna_no_passwords_not_same_error:I

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setError(Ljava/lang/CharSequence;)V

    .line 191
    :goto_0
    return v0

    .line 184
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    const/4 v2, 0x6

    if-ge v1, v2, :cond_1

    .line 187
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->requestFocus()Z

    .line 188
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->password:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->cna_password_requirement_error:I

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setError(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 191
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private updateContinueButtonEnabled()V
    .locals 3

    .prologue
    .line 171
    iget-object v1, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->continueButton:Landroid/widget/Button;

    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->emailTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->isWatchedNonZeroLength()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->passwordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->isWatchedNonZeroLength()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->reenterpasswordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->isWatchedNonZeroLength()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->nameTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->isWatchedNonZeroLength()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_cna_requires_furigana:I

    invoke-static {v0, v2}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->furiganaTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->isWatchedNonZeroLength()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/Button;->setEnabled(Z)V

    .line 174
    return-void

    .line 171
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 34
    invoke-virtual {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 167
    invoke-virtual {p0}, Lcom/amazon/mShop/account/CreateNewAccountView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->cna_title:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 275
    iget-object v0, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    invoke-static {v0, p1}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/Exception;)V

    .line 276
    return-void
.end method

.method public onNewAccountCreation(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 4
    .param p1, "successful"    # Z
    .param p2, "notification"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 218
    if-eqz p1, :cond_0

    .line 219
    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/account/LoginActivity;->setResult(I)V

    .line 222
    :cond_0
    if-eqz p2, :cond_4

    .line 223
    new-instance v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v3, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    invoke-direct {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v2

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    .line 227
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getType()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_2

    .line 229
    new-instance v1, Lcom/amazon/mShop/account/CreateNewAccountView$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/account/CreateNewAccountView$3;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;)V

    .line 248
    .local v1, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 249
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_cancel_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 266
    :goto_0
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 271
    .end local v0    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .end local v1    # "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    :cond_1
    :goto_1
    return-void

    .line 252
    .restart local v0    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    :cond_2
    const/4 v1, 0x0

    .line 253
    .restart local v1    # "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    if-eqz p1, :cond_3

    .line 255
    new-instance v1, Lcom/amazon/mShop/account/CreateNewAccountView$4;

    .end local v1    # "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    invoke-direct {v1, p0}, Lcom/amazon/mShop/account/CreateNewAccountView$4;-><init>(Lcom/amazon/mShop/account/CreateNewAccountView;)V

    .line 263
    .restart local v1    # "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    :cond_3
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_dialog_ok_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    goto :goto_0

    .line 267
    .end local v0    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .end local v1    # "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    :cond_4
    if-eqz p1, :cond_1

    .line 268
    iget-object v2, p0, Lcom/amazon/mShop/account/CreateNewAccountView;->loginActivity:Lcom/amazon/mShop/account/LoginActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/account/LoginActivity;->finish()V

    goto :goto_1
.end method
