.class public Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "LocaleSwitchActivity.java"

# interfaces
.implements Lcom/amazon/mShop/localeswitch/LocaleSwitcher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 75
    return-void
.end method


# virtual methods
.method public changeLocale(Ljava/lang/String;)V
    .locals 1
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 62
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->isCurrentLocale(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity;->finish()V

    .line 68
    :goto_0
    return-void

    .line 66
    :cond_0
    const/4 v0, 0x0

    invoke-static {p1, p0, v0}, Lcom/amazon/mShop/util/LocaleUtils;->changeLocale(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0
.end method

.method protected getLocaleSwitchView()Landroid/view/View;
    .locals 1

    .prologue
    .line 40
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;

    invoke-direct {v0, p0, p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;-><init>(Landroid/app/Activity;Lcom/amazon/mShop/localeswitch/LocaleSwitcher;)V

    return-object v0
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 72
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 73
    return-void
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 20
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 21
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_0

    .line 28
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity;->getLocaleSwitchView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity;->setRootView(Landroid/view/View;)V

    .line 30
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v0

    if-nez v0, :cond_1

    .line 31
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 33
    :cond_1
    return-void
.end method
