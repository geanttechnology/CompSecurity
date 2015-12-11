.class public Lcom/amazon/retailsearch/metrics/NullRetailSearchLogger;
.super Ljava/lang/Object;
.source "NullRetailSearchLogger.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public error(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 92
    return-void
.end method

.method public filterMenuClosed()V
    .locals 0

    .prologue
    .line 155
    return-void
.end method

.method public filterMenuInvoked(Ljava/lang/String;)V
    .locals 0
    .param p1, "sourceLayout"    # Ljava/lang/String;

    .prologue
    .line 143
    return-void
.end method

.method public filterMenuSearch()V
    .locals 0

    .prologue
    .line 149
    return-void
.end method

.method public recordAsinImpressions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 132
    .local p1, "asinImpressions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;>;"
    return-void
.end method

.method public recordDetailPageTransition(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/DetailPageType;)V
    .locals 0
    .param p1, "sourceLayout"    # Ljava/lang/String;
    .param p2, "type"    # Lcom/amazon/retailsearch/metrics/DetailPageType;

    .prologue
    .line 38
    return-void
.end method

.method public recordEndOfResults()V
    .locals 0

    .prologue
    .line 137
    return-void
.end method

.method public recordFlowInvoked()V
    .locals 0

    .prologue
    .line 114
    return-void
.end method

.method public recordLayoutSwitch(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "fromLayout"    # Ljava/lang/String;
    .param p2, "toLayout"    # Ljava/lang/String;

    .prologue
    .line 32
    return-void
.end method

.method public recordRelatedSearchesInvoked()V
    .locals 0

    .prologue
    .line 162
    return-void
.end method

.method public recordSnapItInvoked()V
    .locals 0

    .prologue
    .line 109
    return-void
.end method

.method public saveSearchInitTime(J)V
    .locals 0
    .param p1, "searchInitializationTime"    # J

    .prologue
    .line 98
    return-void
.end method

.method public searchATFReached()V
    .locals 0

    .prologue
    .line 68
    return-void
.end method

.method public searchFirstByteReceived()V
    .locals 0

    .prologue
    .line 44
    return-void
.end method

.method public searchSRDSAssetsCompleted()V
    .locals 0

    .prologue
    .line 120
    return-void
.end method

.method public searchSRDSAssetsError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;
    .param p3, "serviceCall"    # Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;
    .param p4, "fetchType"    # Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .prologue
    .line 126
    return-void
.end method

.method public searchSRDSAssetsStarted(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
    .locals 0
    .param p1, "fetchType"    # Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .prologue
    .line 104
    return-void
.end method

.method public searchSRDSCompleted()V
    .locals 0

    .prologue
    .line 62
    return-void
.end method

.method public searchSRDSError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;
    .param p3, "serviceCall"    # Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;

    .prologue
    .line 74
    return-void
.end method

.method public searchSRDSResponseBeginParse()V
    .locals 0

    .prologue
    .line 80
    return-void
.end method

.method public searchSRDSResponseEndParse()V
    .locals 0

    .prologue
    .line 86
    return-void
.end method

.method public searchSRDSStarted()V
    .locals 0

    .prologue
    .line 56
    return-void
.end method

.method public searchStarted()V
    .locals 0

    .prologue
    .line 50
    return-void
.end method
