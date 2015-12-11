.class public Lcom/amazon/mShop/startup/StartupSetCountryActivity;
.super Lcom/amazon/mShop/startup/BaseActivity;
.source "StartupSetCountryActivity.java"

# interfaces
.implements Lcom/amazon/mShop/localeswitch/LocaleSwitcher;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/amazon/mShop/startup/BaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public changeLocale(Ljava/lang/String;)V
    .locals 0
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    .line 31
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->resetStatus()V

    .line 33
    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSetCountryActivity;->finishIfNotFinishing()V

    .line 34
    return-void
.end method

.method public onStart()V
    .locals 2

    .prologue
    .line 20
    invoke-super {p0}, Lcom/amazon/mShop/startup/BaseActivity;->onStart()V

    .line 21
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;

    invoke-direct {v0, p0, p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;-><init>(Landroid/app/Activity;Lcom/amazon/mShop/localeswitch/LocaleSwitcher;)V

    .line 22
    .local v0, "view":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/startup/StartupSetCountryActivity;->setContentView(Landroid/view/View;)V

    .line 23
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v1

    if-nez v1, :cond_0

    .line 24
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    invoke-static {p0, v1}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 26
    :cond_0
    return-void
.end method
