.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;
.super Ljava/lang/Object;
.source "ProductResponseListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ResponseListener;


# virtual methods
.method public abstract aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedBasicOffer(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedBasicProduct(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedDealId(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedDimension(Lcom/amazon/rio/j2me/client/services/mShop/Dimension;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedExternalBuyLink(Lcom/amazon/rio/j2me/client/services/mShop/WebLink;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedExtraOffer(Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedExtraProduct(Lcom/amazon/rio/j2me/client/services/mShop/ExtraProductInfo;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedImage([BLcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedMultiImage(Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedSavings(Lcom/amazon/rio/j2me/client/services/mShop/Savings;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedVariationProductInfo(Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedVisualBucket(Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedWebLink(Lcom/amazon/rio/j2me/client/services/mShop/WebLink;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method
