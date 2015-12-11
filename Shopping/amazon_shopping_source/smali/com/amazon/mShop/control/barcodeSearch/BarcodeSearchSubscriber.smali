.class public interface abstract Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;
.super Ljava/lang/Object;
.source "BarcodeSearchSubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/control/GenericSubscriber;


# virtual methods
.method public abstract onCompleted()V
.end method

.method public abstract onImageReceived([BI)V
.end method

.method public abstract onMatchedItemReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)V
.end method

.method public abstract onMatchedItemThumbnailReceived([B)V
.end method

.method public abstract onMatchedItemsReturnedReceived(Z)V
.end method

.method public abstract onQueryDescriptorReceived(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V
.end method

.method public abstract onResultsTitleReceived(Ljava/lang/String;)V
.end method

.method public abstract onSearchResultReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;I)V
.end method
