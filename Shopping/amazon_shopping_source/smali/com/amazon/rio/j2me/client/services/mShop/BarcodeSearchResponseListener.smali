.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;
.super Ljava/lang/Object;
.source "BarcodeSearchResponseListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ResponseListener;


# virtual methods
.method public abstract aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedCounts(Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedImage([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedMatchedItem(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedMatchedItemThumbnail([BLcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedMatchedItemsReturned(Ljava/lang/Boolean;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedResultsTitle(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedSearchResult(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method
