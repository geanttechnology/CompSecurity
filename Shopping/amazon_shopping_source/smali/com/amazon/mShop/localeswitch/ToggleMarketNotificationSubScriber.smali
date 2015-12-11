.class public Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;
.super Lcom/amazon/mShop/control/pushnotification/MShopNotificationSubScriber;
.source "ToggleMarketNotificationSubScriber.java"


# instance fields
.field private mChain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

.field private mProgDiag:Lcom/amazon/mShop/AmazonProgressDialog;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V
    .locals 1
    .param p1, "chain"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    .prologue
    const/4 v0, 0x0

    .line 28
    invoke-direct {p0}, Lcom/amazon/mShop/control/pushnotification/MShopNotificationSubScriber;-><init>()V

    .line 19
    iput-object v0, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mChain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    .line 20
    iput-object v0, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mProgDiag:Lcom/amazon/mShop/AmazonProgressDialog;

    .line 29
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mChain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    .line 30
    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mChain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    iget-object v1, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mProgDiag:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->setExistentProgressDialog(Lcom/amazon/mShop/AmazonProgressDialog;)V

    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mChain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    invoke-virtual {v0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->process()V

    .line 35
    return-void
.end method

.method public onMarketplaceToggled(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "marketPlaceId"    # Ljava/lang/String;
    .param p2, "isMarketplaceSupportsNotifications"    # Z

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mChain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    invoke-virtual {v0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->process()V

    .line 41
    return-void
.end method

.method public onMarketplaceToggledReuseProgress(Ljava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;)V
    .locals 1
    .param p1, "marketPlaceId"    # Ljava/lang/String;
    .param p2, "progDiag"    # Lcom/amazon/mShop/AmazonProgressDialog;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mChain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    invoke-virtual {v0, p2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->setExistentProgressDialog(Lcom/amazon/mShop/AmazonProgressDialog;)V

    .line 49
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mChain:Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    invoke-virtual {v0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->process()V

    .line 50
    return-void
.end method

.method public setProgDiag(Lcom/amazon/mShop/AmazonProgressDialog;)V
    .locals 0
    .param p1, "progDiag"    # Lcom/amazon/mShop/AmazonProgressDialog;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/ToggleMarketNotificationSubScriber;->mProgDiag:Lcom/amazon/mShop/AmazonProgressDialog;

    .line 27
    return-void
.end method
