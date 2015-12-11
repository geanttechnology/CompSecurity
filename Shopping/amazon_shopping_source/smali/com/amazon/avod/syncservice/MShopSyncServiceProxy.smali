.class public Lcom/amazon/avod/syncservice/MShopSyncServiceProxy;
.super Lcom/amazon/mShop/android/platform/services/ProxyIntentService;
.source "MShopSyncServiceProxy.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    const-string/jumbo v0, "AIV.SyncService"

    invoke-direct {p0, v0}, Lcom/amazon/mShop/android/platform/services/ProxyIntentService;-><init>(Ljava/lang/String;)V

    .line 9
    return-void
.end method
