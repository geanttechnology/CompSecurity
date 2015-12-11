.class public Lcom/amazon/mShop/details/web/WebProductDetailsActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "WebProductDetailsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public finishIfAlreadyRedirectToAppStore(Ljava/lang/String;)V
    .locals 5
    .param p1, "mobileAppAsin"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 20
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v3, "isFromDetailInterception"

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    .line 22
    .local v2, "launchFromDetailInterception":Z
    if-eqz v2, :cond_0

    .line 23
    const-string/jumbo v3, "interceptedAsin"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 24
    .local v1, "interceptedAsin":Ljava/lang/String;
    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 25
    invoke-virtual {p0}, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;->finish()V

    .line 28
    .end local v1    # "interceptedAsin":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method protected handleForceSignIn()V
    .locals 1

    .prologue
    .line 32
    invoke-virtual {p0}, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;->isLaunchedFromPublicUrl()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 33
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->handleSigninPrompt(Landroid/content/Context;)Z

    .line 35
    :cond_0
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 0

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;->refresh()V

    .line 41
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->userSuccessfullySignedIn()V

    .line 42
    return-void
.end method
