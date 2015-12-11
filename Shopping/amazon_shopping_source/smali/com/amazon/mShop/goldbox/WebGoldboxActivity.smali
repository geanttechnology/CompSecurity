.class public Lcom/amazon/mShop/goldbox/WebGoldboxActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "WebGoldboxActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected initWebView()V
    .locals 2

    .prologue
    .line 16
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->initWebView()V

    .line 20
    invoke-virtual {p0}, Lcom/amazon/mShop/goldbox/WebGoldboxActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    const/16 v1, 0x63

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setProgressHideSpinner(I)V

    .line 21
    return-void
.end method
