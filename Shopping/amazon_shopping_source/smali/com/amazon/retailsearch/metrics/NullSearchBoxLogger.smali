.class public Lcom/amazon/retailsearch/metrics/NullSearchBoxLogger;
.super Ljava/lang/Object;
.source "NullSearchBoxLogger.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public recordEntryVoiceInvoked()V
    .locals 0

    .prologue
    .line 44
    return-void
.end method

.method public recordFlowInvoked()V
    .locals 0

    .prologue
    .line 60
    return-void
.end method

.method public recordQueryBuilderUsage()V
    .locals 0

    .prologue
    .line 79
    return-void
.end method

.method public recordRecentSearchCleared()V
    .locals 0

    .prologue
    .line 73
    return-void
.end method

.method public recordScanItInvoked()V
    .locals 0

    .prologue
    .line 50
    return-void
.end method

.method public recordSnapItInvoked()V
    .locals 0

    .prologue
    .line 55
    return-void
.end method

.method public searchSRDSPersonalizedISSError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;
    .param p3, "serviceCall"    # Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    .prologue
    .line 67
    return-void
.end method

.method public searchSuggestionsEngagment(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 38
    .local p1, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    return-void
.end method

.method public searchSuggestionsFirstEntryShowed()V
    .locals 0

    .prologue
    .line 32
    return-void
.end method

.method public searchSuggestionsFirstKeyStroke()V
    .locals 0

    .prologue
    .line 26
    return-void
.end method
