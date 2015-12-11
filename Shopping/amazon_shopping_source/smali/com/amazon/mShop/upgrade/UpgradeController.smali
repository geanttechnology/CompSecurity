.class public Lcom/amazon/mShop/upgrade/UpgradeController;
.super Lcom/amazon/mShop/control/BaseController;
.source "UpgradeController.java"

# interfaces
.implements Lcom/amazon/mShop/control/Cancellable;
.implements Lcom/amazon/rio/j2me/client/services/mShop/CheckUpgradeResponseListener;


# instance fields
.field private mSubscriber:Lcom/amazon/mShop/upgrade/UpgradeSubscriber;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    return-void
.end method


# virtual methods
.method public checkForUpgrade(Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 2
    .param p1, "callback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeRequest;-><init>()V

    invoke-interface {v0, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->checkUpgrade(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckUpgradeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/mShop/upgrade/UpgradeController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 31
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 19
    if-eqz p1, :cond_0

    .line 20
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;->getUpgradeInfo()Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    move-result-object v0

    .line 21
    .local v0, "info":Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;
    iget-object v1, p0, Lcom/amazon/mShop/upgrade/UpgradeController;->mSubscriber:Lcom/amazon/mShop/upgrade/UpgradeSubscriber;

    if-eqz v1, :cond_0

    .line 22
    iget-object v1, p0, Lcom/amazon/mShop/upgrade/UpgradeController;->mSubscriber:Lcom/amazon/mShop/upgrade/UpgradeSubscriber;

    invoke-interface {v1, v0}, Lcom/amazon/mShop/upgrade/UpgradeSubscriber;->onCompeleted(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V

    .line 26
    .end local v0    # "info":Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/upgrade/UpgradeController;->serviceCallCompleted()V

    .line 27
    return-void
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 13
    invoke-virtual {p0}, Lcom/amazon/mShop/upgrade/UpgradeController;->getSubscriber()Lcom/amazon/mShop/upgrade/UpgradeSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/upgrade/UpgradeSubscriber;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/upgrade/UpgradeController;->mSubscriber:Lcom/amazon/mShop/upgrade/UpgradeSubscriber;

    return-object v0
.end method

.method public setSubscriber(Lcom/amazon/mShop/upgrade/UpgradeSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/upgrade/UpgradeSubscriber;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/upgrade/UpgradeController;->mSubscriber:Lcom/amazon/mShop/upgrade/UpgradeSubscriber;

    .line 35
    return-void
.end method
