.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/QueryResponseListener;
.super Ljava/lang/Object;
.source "QueryResponseListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ResponseListener;


# virtual methods
.method public abstract aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedCategoryResult(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedCounts(Lcom/amazon/rio/j2me/client/services/mShop/SearchResultsCounts;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedImage([BILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedSearchResult(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method
