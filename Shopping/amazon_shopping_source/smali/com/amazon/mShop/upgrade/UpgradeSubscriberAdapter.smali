.class public Lcom/amazon/mShop/upgrade/UpgradeSubscriberAdapter;
.super Ljava/lang/Object;
.source "UpgradeSubscriberAdapter.java"

# interfaces
.implements Lcom/amazon/mShop/upgrade/UpgradeSubscriber;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public awareUniqueId()Z
    .locals 1

    .prologue
    .line 41
    const/4 v0, 0x1

    return v0
.end method

.method public onCompeleted(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V
    .locals 1
    .param p1, "info"    # Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/amazon/mShop/upgrade/UpgradeSubscriberAdapter;->awareUniqueId()Z

    move-result v0

    invoke-static {p1, v0}, Lcom/amazon/mShop/util/UpgradeUtil;->isNewUpgrade(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27
    invoke-static {p1}, Lcom/amazon/mShop/util/UpgradeUtil;->saveNewUpgradeInfo(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V

    .line 28
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/upgrade/UpgradeSubscriberAdapter;->onUpgradeAvailable(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V

    .line 33
    :goto_0
    return-void

    .line 30
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->clearNewUpgradeInfo()V

    .line 31
    invoke-virtual {p0}, Lcom/amazon/mShop/upgrade/UpgradeSubscriberAdapter;->onNoUpgrade()V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 12
    return-void
.end method

.method public onNoUpgrade()V
    .locals 0

    .prologue
    .line 22
    return-void
.end method

.method public onUpgradeAvailable(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V
    .locals 0
    .param p1, "info"    # Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    .prologue
    .line 17
    return-void
.end method
