.class public Lcom/amazon/mShop/control/ServiceController;
.super Ljava/lang/Object;
.source "ServiceController.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;
    .locals 1

    .prologue
    .line 15
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    return-object v0
.end method
