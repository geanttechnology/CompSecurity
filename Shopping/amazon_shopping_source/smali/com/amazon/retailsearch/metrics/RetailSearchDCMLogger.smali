.class public Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;
.super Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;
.source "RetailSearchDCMLogger.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "DefaultLocale"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger$1;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

.field private searchInitTimer:Lcom/amazon/client/metrics/MetricEvent;

.field searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const-class v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    .line 49
    const-class v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "config"    # Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    .prologue
    const/4 v0, 0x0

    .line 62
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V

    .line 41
    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    .line 42
    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 43
    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchInitTimer:Lcom/amazon/client/metrics/MetricEvent;

    .line 44
    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 45
    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 63
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 64
    return-void
.end method

.method private getIssConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 417
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getSearchProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getConcurrentMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method private getIssMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 406
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getIssProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method private getSearchConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 395
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getSearchProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getConcurrentMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method private getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 384
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getSearchProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method private recordSearchInitTime()V
    .locals 2

    .prologue
    .line 341
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchInitTimer:Lcom/amazon/client/metrics/MetricEvent;

    if-eqz v0, :cond_0

    .line 343
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchInitTimer:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 344
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchInitTimer:Lcom/amazon/client/metrics/MetricEvent;

    .line 346
    :cond_0
    return-void
.end method


# virtual methods
.method public error(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 263
    :try_start_0
    sget-object v2, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 264
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->addEventInfo(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 265
    invoke-virtual {p0, p2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getErrorMetric(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {p0, v0, v2, v3}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 274
    .end local v0    # "event":Lcom/amazon/client/metrics/MetricEvent;
    :cond_0
    :goto_0
    return-void

    .line 267
    :catch_0
    move-exception v1

    .line 269
    .local v1, "t":Ljava/lang/Throwable;
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 271
    sget-object v2, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Error"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public filterMenuClosed()V
    .locals 2

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    if-nez v0, :cond_0

    .line 123
    sget-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "An attempt was made to log closing the filter menu without a valid metric event. This request will be ignored"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 129
    :goto_0
    return-void

    .line 126
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-static {v0}, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->logMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 127
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 128
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    goto :goto_0
.end method

.method public filterMenuInvoked(Ljava/lang/String;)V
    .locals 4
    .param p1, "sourceLayout"    # Ljava/lang/String;

    .prologue
    .line 102
    sget-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->Filter:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 103
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->MenuInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchesPerFilterAccess:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 105
    return-void
.end method

.method public filterMenuSearch()V
    .locals 4

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    if-nez v0, :cond_0

    .line 112
    sget-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "An attempt was made to log a search using the filter menu without a valid metric event. This request will be ignored"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 116
    :goto_0
    return-void

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentFilterMenuEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->SearchesPerFilterAccess:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    goto :goto_0
.end method

.method public recordAsinImpressions(Ljava/util/List;)V
    .locals 5
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
    .line 353
    .local p1, "asinImpressions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;>;"
    sget-object v4, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v4}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v3

    .line 355
    .local v3, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;

    .line 357
    .local v0, "ai":Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;->toLoggingFormat()Ljava/lang/String;

    move-result-object v1

    .line 358
    .local v1, "aiLog":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 360
    sget-object v4, Lcom/amazon/retailsearch/metrics/MetricName;->ClientVisibleImpression:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v1}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 363
    .end local v0    # "ai":Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;
    .end local v1    # "aiLog":Ljava/lang/String;
    :cond_1
    invoke-interface {v3}, Lcom/amazon/client/metrics/MetricEvent;->getAsDataPoints()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_2

    .line 365
    iget-object v4, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v4, v3}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 367
    :cond_2
    return-void
.end method

.method public recordDetailPageTransition(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/DetailPageType;)V
    .locals 4
    .param p1, "sourceLayout"    # Ljava/lang/String;
    .param p2, "type"    # Lcom/amazon/retailsearch/metrics/DetailPageType;

    .prologue
    .line 76
    sget-object v2, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 77
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    const/4 v1, 0x0

    .line 78
    .local v1, "metricName":Ljava/lang/String;
    sget-object v2, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger$1;->$SwitchMap$com$amazon$retailsearch$metrics$DetailPageType:[I

    invoke-virtual {p2}, Lcom/amazon/retailsearch/metrics/DetailPageType;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 96
    :goto_0
    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 97
    return-void

    .line 81
    :pswitch_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedNeva:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 83
    goto :goto_0

    .line 85
    :pswitch_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedTwister:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 87
    goto :goto_0

    .line 89
    :pswitch_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/amazon/retailsearch/metrics/MetricName;->AlternateDetailPageInvokedForcedPrime:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 91
    goto :goto_0

    .line 93
    :pswitch_3
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/amazon/retailsearch/metrics/MetricName;->DetailPageInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 78
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public recordEndOfResults()V
    .locals 3

    .prologue
    .line 248
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 249
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->EndOfResults:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 250
    return-void
.end method

.method public recordLayoutSwitch(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "fromLayout"    # Ljava/lang/String;
    .param p2, "toLayout"    # Ljava/lang/String;

    .prologue
    .line 69
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 70
    .local v0, "layoutSwitchEvent":Lcom/amazon/client/metrics/MetricEvent;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-super {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 71
    return-void
.end method

.method public recordRelatedSearchesInvoked()V
    .locals 3

    .prologue
    .line 372
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 373
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->RelatedSearchesInvoked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 374
    return-void
.end method

.method public saveSearchInitTime(J)V
    .locals 4
    .param p1, "searchInitializationTime"    # J

    .prologue
    .line 329
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchInitTimer:Lcom/amazon/client/metrics/MetricEvent;

    if-nez v0, :cond_0

    .line 331
    sget-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchInitTimer:Lcom/amazon/client/metrics/MetricEvent;

    .line 332
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchInitTimer:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->InitTime:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    long-to-double v2, p1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/MetricEvent;->addTimer(Ljava/lang/String;D)V

    .line 334
    :cond_0
    return-void
.end method

.method public searchATFReached()V
    .locals 2

    .prologue
    .line 216
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchATFReached()V

    .line 219
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    if-nez v0, :cond_0

    .line 221
    sget-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "An attempt was made to log ATF without a valid metric event"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 231
    :goto_0
    return-void

    .line 224
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->ClientATF:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 225
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATF:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 226
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopViewTypeMetrics()V

    .line 227
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopConnectionTypeMetrics()V

    .line 228
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->getEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->logMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 229
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->getEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 230
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    goto :goto_0
.end method

.method public searchFirstByteReceived()V
    .locals 2

    .prologue
    .line 203
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    if-nez v0, :cond_0

    .line 205
    sget-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "Retail Search : An attempt was made to log first byte without a valid metric event. This request will be ignored"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 210
    :goto_0
    return-void

    .line 208
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToFirstByte:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 209
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->ClientATF:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public searchSRDSAssetsCompleted()V
    .locals 2

    .prologue
    .line 296
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    if-nez v0, :cond_0

    .line 298
    sget-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "An attempt was made to log srds assets latency without a valid metric event. This request will be ignored"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 305
    :goto_0
    return-void

    .line 301
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->RequestLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 302
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-static {v0}, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->logMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 303
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 304
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    goto :goto_0
.end method

.method public searchSRDSAssetsError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;
    .param p3, "serviceCall"    # Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;
    .param p4, "fetchType"    # Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .prologue
    .line 313
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->AssetsSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 314
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    if-eqz p4, :cond_0

    .line 316
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->AssetFetchType:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p4}, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->toLoggingString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 318
    :cond_0
    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->addEventInfo(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 319
    if-eqz p3, :cond_1

    .line 321
    invoke-virtual {p0, v0, p3}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->addServiceCallInfo(Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;)V

    .line 323
    :cond_1
    invoke-virtual {p0, p2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getErrorMetric(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 324
    return-void
.end method

.method public searchSRDSAssetsStarted(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
    .locals 3
    .param p1, "fetchType"    # Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    .prologue
    .line 282
    sget-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->AssetsSRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 283
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->RequestLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V

    .line 284
    if-eqz p1, :cond_0

    .line 286
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSAssetsEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->AssetFetchType:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/retailsearch/data/assets/AssetFetchType;->toLoggingString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 288
    :cond_0
    return-void
.end method

.method public searchSRDSCompleted()V
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchSRDSCompleted()V

    .line 149
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    if-nez v0, :cond_0

    .line 151
    sget-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "An attempt was made to log srds latency without a valid metric event. This request will be ignored"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 158
    :goto_0
    return-void

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->RequestLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 155
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-static {v0}, Lcom/amazon/retailsearch/debug/RetailSearchDebug;->logMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 156
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->metricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 157
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    goto :goto_0
.end method

.method public searchSRDSError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;
    .param p3, "serviceCall"    # Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;

    .prologue
    .line 236
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->SRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 237
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->addEventInfo(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 238
    if-eqz p3, :cond_0

    .line 240
    invoke-virtual {p0, v0, p3}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->addServiceCallInfo(Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/searchapp/retailsearch/client/web/ServiceCall;)V

    .line 242
    :cond_0
    invoke-virtual {p0, p2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getErrorMetric(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 243
    return-void
.end method

.method public searchSRDSResponseBeginParse()V
    .locals 2

    .prologue
    .line 163
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    if-nez v0, :cond_0

    .line 165
    sget-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "An attempt was made to log srds parse time (begin) without a valid metric event. This request will be ignored"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 169
    :goto_0
    return-void

    .line 168
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->ResponseParseTime:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public searchSRDSResponseEndParse()V
    .locals 2

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    if-nez v0, :cond_0

    .line 176
    sget-object v0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v1, "Retail Search : An attempt was made to log srds parse time (end) without a valid metric event. This request will be ignored"

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->warn(Ljava/lang/String;)V

    .line 180
    :goto_0
    return-void

    .line 179
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->ResponseParseTime:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public searchSRDSStarted()V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchSRDSStarted()V

    .line 138
    sget-object v0, Lcom/amazon/retailsearch/metrics/SourceName;->SRDSRequest:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 139
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSRDSSearchEvent:Lcom/amazon/client/metrics/MetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->RequestLatency:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V

    .line 140
    return-void
.end method

.method public searchStarted()V
    .locals 3

    .prologue
    .line 186
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->searchMetricsListenerInvoker:Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricsListenerInvoker;->searchStarted()V

    .line 191
    invoke-direct {p0}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->recordSearchInitTime()V

    .line 193
    new-instance v0, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Search:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->getSearchConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->context:Landroid/content/Context;

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;-><init>(Lcom/amazon/client/metrics/MetricEvent;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    .line 194
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToFirstByte:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    .line 195
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->TapToATF:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startTimer(Ljava/lang/String;)V

    .line 196
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startViewTypeMetrics()V

    .line 197
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/RetailSearchDCMLogger;->currentSearchEvent:Lcom/amazon/retailsearch/metrics/SearchMetricEvent;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/SearchMetricEvent;->startConnectionTypeMetrics()V

    .line 198
    return-void
.end method
