.class public interface abstract Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
.super Ljava/lang/Object;
.source "RetailSearchLogger.java"


# virtual methods
.method public abstract error(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract filterMenuClosed()V
.end method

.method public abstract filterMenuInvoked(Ljava/lang/String;)V
.end method

.method public abstract filterMenuSearch()V
.end method

.method public abstract recordAsinImpressions(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract recordDetailPageTransition(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/DetailPageType;)V
.end method

.method public abstract recordEndOfResults()V
.end method

.method public abstract recordLayoutSwitch(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract recordRelatedSearchesInvoked()V
.end method

.method public abstract saveSearchInitTime(J)V
.end method

.method public abstract searchATFReached()V
.end method

.method public abstract searchFirstByteReceived()V
.end method

.method public abstract searchSRDSAssetsCompleted()V
.end method

.method public abstract searchSRDSAssetsError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
.end method

.method public abstract searchSRDSAssetsStarted(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
.end method

.method public abstract searchSRDSCompleted()V
.end method

.method public abstract searchSRDSError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;)V
.end method

.method public abstract searchSRDSResponseBeginParse()V
.end method

.method public abstract searchSRDSResponseEndParse()V
.end method

.method public abstract searchSRDSStarted()V
.end method

.method public abstract searchStarted()V
.end method
