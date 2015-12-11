.class public Lcom/amazon/mShop/control/pushnotification/MShopNotificationSubScriber;
.super Ljava/lang/Object;
.source "MShopNotificationSubScriber.java"

# interfaces
.implements Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDeviceTokenUpdated()V
    .locals 0

    .prologue
    .line 39
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 24
    return-void
.end method

.method public onMarketplaceToggled(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "marketPlaceId"    # Ljava/lang/String;
    .param p2, "isMarketplaceSupportsNotifications"    # Z

    .prologue
    .line 45
    return-void
.end method

.method public onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .prologue
    .line 18
    return-void
.end method

.method public onSubscriptionUpdated()V
    .locals 0

    .prologue
    .line 34
    return-void
.end method

.method public onSubscriptionsReceived(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V
    .locals 0
    .param p1, "subscriptionsData"    # Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;

    .prologue
    .line 29
    return-void
.end method
