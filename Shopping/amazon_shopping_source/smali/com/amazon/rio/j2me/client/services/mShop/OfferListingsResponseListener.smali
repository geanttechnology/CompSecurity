.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsResponseListener;
.super Ljava/lang/Object;
.source "OfferListingsResponseListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ResponseListener;


# virtual methods
.method public abstract aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedOfferListing(Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method
