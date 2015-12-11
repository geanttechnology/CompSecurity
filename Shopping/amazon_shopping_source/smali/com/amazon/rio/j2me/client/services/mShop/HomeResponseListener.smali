.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;
.super Ljava/lang/Object;
.source "HomeResponseListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ResponseListener;


# virtual methods
.method public abstract completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedCartItems(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedCompletedRemembersItemIds(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation
.end method

.method public abstract receivedLoginData(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedPromoSlot0(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedPromoSlot1(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedShoveler0(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedShoveler1(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method
