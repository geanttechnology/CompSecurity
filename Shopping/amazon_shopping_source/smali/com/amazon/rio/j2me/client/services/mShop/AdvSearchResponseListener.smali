.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;
.super Ljava/lang/Object;
.source "AdvSearchResponseListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/ResponseListener;


# virtual methods
.method public abstract aboutToReceiveArrayOfSize(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedAdvSearchResults(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedHyperText(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method

.method public abstract receivedMainResults(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end method
