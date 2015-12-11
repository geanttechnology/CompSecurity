.class public Lcom/amazon/avod/syncservice/MShopNetworkInfoIntentServiceProxy;
.super Lcom/amazon/mShop/android/platform/services/ProxyIntentService;
.source "MShopNetworkInfoIntentServiceProxy.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    const-class v0, Lcom/amazon/avod/syncservice/MShopNetworkInfoIntentServiceProxy;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;-><init>(Ljava/lang/String;)V

    .line 9
    return-void
.end method
