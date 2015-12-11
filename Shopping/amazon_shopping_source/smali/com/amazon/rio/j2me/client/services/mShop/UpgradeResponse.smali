.class public Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;
.super Ljava/lang/Object;
.source "UpgradeResponse.java"


# instance fields
.field private upgradeInfo:Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getUpgradeInfo()Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;->upgradeInfo:Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    return-object v0
.end method

.method public setUpgradeInfo(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeResponse;->upgradeInfo:Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    .line 26
    return-void
.end method
