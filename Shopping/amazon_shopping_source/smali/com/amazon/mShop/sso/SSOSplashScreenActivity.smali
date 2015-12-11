.class public Lcom/amazon/mShop/sso/SSOSplashScreenActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "SSOSplashScreenActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 18
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SSOSplashScreenActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawer;->lock(Z)V

    .line 21
    new-instance v0, Lcom/amazon/mShop/sso/SSOSplashScreenView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/sso/SSOSplashScreenView;-><init>(Landroid/content/Context;)V

    .line 22
    .local v0, "ssoSplashScreenView":Lcom/amazon/mShop/sso/SSOSplashScreenView;
    invoke-virtual {p0, v0, v2}, Lcom/amazon/mShop/sso/SSOSplashScreenActivity;->pushView(Landroid/view/View;Z)V

    .line 23
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 27
    const/4 v0, 0x0

    return v0
.end method
