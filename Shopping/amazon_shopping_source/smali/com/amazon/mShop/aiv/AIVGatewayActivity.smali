.class public Lcom/amazon/mShop/aiv/AIVGatewayActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "AIVGatewayActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onResume()V
    .locals 2

    .prologue
    .line 47
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->onResume()V

    .line 51
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVGatewayActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    const-string/jumbo v1, "mshop:aiv"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;)Z

    .line 52
    return-void
.end method

.method protected processSavedInstanceAndInitWebview(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 37
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/AIVGatewayActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 38
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 39
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->getAIVGatewayUrl(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 42
    :cond_0
    const/4 v1, 0x0

    invoke-super {p0, v1}, Lcom/amazon/mShop/web/MShopWebActivity;->processSavedInstanceAndInitWebview(Landroid/os/Bundle;)V

    .line 43
    return-void
.end method
