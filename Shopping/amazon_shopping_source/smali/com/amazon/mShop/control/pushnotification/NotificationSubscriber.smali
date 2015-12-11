.class public interface abstract Lcom/amazon/mShop/control/pushnotification/NotificationSubscriber;
.super Ljava/lang/Object;
.source "NotificationSubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserSubscriber;


# virtual methods
.method public abstract onDeviceTokenUpdated()V
.end method

.method public abstract onMarketplaceToggled(Ljava/lang/String;Z)V
.end method

.method public abstract onSubscriptionUpdated()V
.end method

.method public abstract onSubscriptionsReceived(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;)V
.end method
