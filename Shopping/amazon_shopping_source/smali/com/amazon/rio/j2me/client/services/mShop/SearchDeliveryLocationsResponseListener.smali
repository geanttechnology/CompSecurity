.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;
.super Ljava/lang/Object;
.source "SearchDeliveryLocationsResponseListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ResponseListener;


# virtual methods
.method public abstract aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedMessage(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedTotalCount(Ljava/lang/Integer;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedType(Ljava/lang/Integer;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method
