.class Lcom/amazon/mShop/home/web/MShopWebGatewayActivity$MShopGatewayWebViewContener;
.super Lcom/amazon/mShop/web/MShopWebViewContainer;
.source "MShopWebGatewayActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MShopGatewayWebViewContener"
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 356
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;-><init>(Landroid/content/Context;)V

    .line 357
    return-void
.end method


# virtual methods
.method public showSpinner()V
    .locals 2

    .prologue
    .line 361
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSpinner()V

    .line 363
    invoke-virtual {p0}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity$MShopGatewayWebViewContener;->getProgressBarContainer()Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 364
    return-void
.end method
