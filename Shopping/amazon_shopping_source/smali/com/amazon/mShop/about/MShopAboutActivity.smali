.class public Lcom/amazon/mShop/about/MShopAboutActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "MShopAboutActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onStart()V
    .locals 1

    .prologue
    .line 19
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 20
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/about/MShopAboutActivity;->setStopBehavior(I)V

    .line 21
    new-instance v0, Lcom/amazon/mShop/about/MShopAboutView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/about/MShopAboutView;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/about/MShopAboutActivity;->setRootView(Landroid/view/View;)V

    .line 22
    return-void
.end method
