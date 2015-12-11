.class public Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;
.super Ljava/lang/Object;
.source "ToggleMarketplaceNotificationsResponse.java"


# instance fields
.field private marketplaceId:Ljava/lang/String;

.field private marketplaceSupportsNotifications:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMarketplaceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->marketplaceId:Ljava/lang/String;

    return-object v0
.end method

.method public getMarketplaceSupportsNotifications()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->marketplaceSupportsNotifications:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setMarketplaceId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->marketplaceId:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setMarketplaceSupportsNotifications(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponse;->marketplaceSupportsNotifications:Ljava/lang/Boolean;

    .line 27
    return-void
.end method
