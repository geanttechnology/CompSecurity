.class public Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;
.super Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;
.source "SearchBoxDCMLogger.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "DefaultLocale"
    }
.end annotation


# instance fields
.field private currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "config"    # Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V

    .line 42
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 46
    return-void
.end method

.method private getIssConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getSearchProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getConcurrentMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method private getIssMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getIssProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method private getSearchConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getSearchProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getConcurrentMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method private getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getSearchProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public recordEntryVoiceInvoked()V
    .locals 3

    .prologue
    .line 151
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 152
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->EntryVoiceInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 153
    return-void
.end method

.method public recordFlowInvoked()V
    .locals 3

    .prologue
    .line 172
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 173
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->FlowInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 174
    return-void
.end method

.method public recordQueryBuilderUsage()V
    .locals 3

    .prologue
    .line 186
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getIssMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 187
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->QueryBuilder:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 188
    return-void
.end method

.method public recordRecentSearchCleared()V
    .locals 3

    .prologue
    .line 179
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getIssMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 180
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->RecentSearchesClear:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 181
    return-void
.end method

.method public recordScanItInvoked()V
    .locals 3

    .prologue
    .line 158
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 159
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->BarcodeInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 160
    return-void
.end method

.method public recordSnapItInvoked()V
    .locals 3

    .prologue
    .line 165
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 166
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->ImageInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 167
    return-void
.end method

.method public searchSRDSPersonalizedISSError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;
    .param p3, "serviceCall"    # Lcom/amazon/searchapp/retailsearch/client/PersonalizedSuggestionsServiceCall;

    .prologue
    .line 119
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->PersonalizedISSSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 120
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->addEventInfo(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 121
    if-eqz p3, :cond_0

    .line 123
    invoke-virtual {p0, v0, p3}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->addServiceCallInfo(Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;)V

    .line 125
    :cond_0
    invoke-virtual {p0, p2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getErrorMetric(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 126
    return-void
.end method

.method public searchSuggestionsEngagment(Ljava/util/Map;)V
    .locals 5
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
    .line 131
    .local p1, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 146
    :goto_0
    return-void

    .line 135
    :cond_0
    sget-object v4, Lcom/amazon/retailsearch/metrics/SourceName;->Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v4}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getIssConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 136
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 138
    .local v2, "key":Ljava/lang/String;
    invoke-interface {p1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 139
    .local v3, "value":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 141
    invoke-interface {v0, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 144
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "value":Ljava/lang/String;
    :cond_2
    invoke-static {v0}, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->logMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 145
    iget-object v4, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v4, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    goto :goto_0
.end method

.method public searchSuggestionsFirstEntryShowed()V
    .locals 2

    .prologue
    .line 102
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;

    if-nez v0, :cond_0

    .line 104
    sget-object v0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "An attempt was made to log ISS latency without a valid metric event"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 111
    :goto_0
    return-void

    .line 107
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TimeToFirstSuggestion:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 108
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-static {v0}, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->logMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 109
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 110
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;

    goto :goto_0
.end method

.method public searchSuggestionsFirstKeyStroke()V
    .locals 2

    .prologue
    .line 95
    sget-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->ISS:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->getIssConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 96
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/SearchBoxDCMLogger;->currentISSEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TimeToFirstSuggestion:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V

    .line 97
    return-void
.end method
