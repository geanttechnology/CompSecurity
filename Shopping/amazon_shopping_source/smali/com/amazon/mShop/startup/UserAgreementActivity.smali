.class public Lcom/amazon/mShop/startup/UserAgreementActivity;
.super Lcom/amazon/mShop/startup/BaseActivity;
.source "UserAgreementActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/startup/BaseActivity;-><init>()V

    return-void
.end method

.method public static shouldShowUserAgreement()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 34
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "zh_CN"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string/jumbo v1, "app_start_agreement_dialog"

    invoke-static {v1}, Lcom/amazon/mShop/util/FeatureUtil;->isFeatureEnabled(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "appStartIndicationDialogNotRemindAgain"

    invoke-interface {v1, v2, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_0

    .line 37
    const/4 v0, 0x1

    .line 39
    :cond_0
    return v0
.end method

.method private showUserAgreement(Landroid/app/Activity;)V
    .locals 7
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v3, 0x0

    .line 57
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v2

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->dialog_checkbox:I

    const/4 v5, 0x0

    invoke-virtual {v2, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/CheckBox;

    .line 58
    .local v1, "checkBox":Landroid/widget/CheckBox;
    new-instance v6, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v6, p1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 59
    .local v6, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->app_start_indication_dialog_title:I

    invoke-virtual {v6, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v2

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->app_start_indication_dialog_msg:I

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 62
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->app_start_indication_dialog_button_agree:I

    new-instance v4, Lcom/amazon/mShop/startup/UserAgreementActivity$1;

    invoke-direct {v4, p0, v1}, Lcom/amazon/mShop/startup/UserAgreementActivity$1;-><init>(Lcom/amazon/mShop/startup/UserAgreementActivity;Landroid/widget/CheckBox;)V

    invoke-virtual {v6, v2, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 75
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->app_start_indication_dialog_button_disagree:I

    new-instance v4, Lcom/amazon/mShop/startup/UserAgreementActivity$2;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/startup/UserAgreementActivity$2;-><init>(Lcom/amazon/mShop/startup/UserAgreementActivity;)V

    invoke-virtual {v6, v2, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 85
    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    .line 87
    .local v0, "indicationDialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->padding_double:I

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    move v4, v3

    move v5, v3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/AmazonAlertDialog;->setView(Landroid/view/View;IIII)V

    .line 88
    invoke-virtual {v0, v3}, Lcom/amazon/mShop/AmazonAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 89
    invoke-virtual {v0, v3}, Lcom/amazon/mShop/AmazonAlertDialog;->setCancelable(Z)V

    .line 90
    new-instance v2, Lcom/amazon/mShop/startup/UserAgreementActivity$3;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/startup/UserAgreementActivity$3;-><init>(Lcom/amazon/mShop/startup/UserAgreementActivity;)V

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonAlertDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 96
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 97
    return-void
.end method

.method public static startActivity(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 2
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "startupTaskId"    # Ljava/lang/String;

    .prologue
    .line 29
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/startup/UserAgreementActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 30
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {p0, v0, p1}, Lcom/amazon/mShop/splashscreen/StartupActivity;->startActivityForStartup(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V

    .line 31
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 25
    invoke-direct {p0, p0}, Lcom/amazon/mShop/startup/UserAgreementActivity;->showUserAgreement(Landroid/app/Activity;)V

    .line 26
    return-void
.end method
