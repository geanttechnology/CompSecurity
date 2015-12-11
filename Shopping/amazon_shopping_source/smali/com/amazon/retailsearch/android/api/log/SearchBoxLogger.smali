.class public interface abstract Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
.super Ljava/lang/Object;
.source "SearchBoxLogger.java"


# virtual methods
.method public abstract recordEntryVoiceInvoked()V
.end method

.method public abstract recordFlowInvoked()V
.end method

.method public abstract recordQueryBuilderUsage()V
.end method

.method public abstract recordRecentSearchCleared()V
.end method

.method public abstract recordScanItInvoked()V
.end method

.method public abstract recordSnapItInvoked()V
.end method

.method public abstract searchSRDSPersonalizedISSError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;)V
.end method

.method public abstract searchSuggestionsEngagment(Ljava/util/Map;)V
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
.end method

.method public abstract searchSuggestionsFirstEntryShowed()V
.end method

.method public abstract searchSuggestionsFirstKeyStroke()V
.end method
