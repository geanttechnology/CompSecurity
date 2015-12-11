.class public Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;
.super Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;
.source "CategoryBrowseDCMLogger.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/log/CategoryBrowseLogger;


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "DefaultLocale"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private currentCategoryBrowseMetricEvent:Lcom/amazon/client/metrics/MetricEvent;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    .line 32
    const-class v0, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "config"    # Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/metrics/BaseAbstractDCMLogger;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;)V

    .line 28
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->currentCategoryBrowseMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 42
    return-void
.end method

.method private getBrowseConcurrentMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getBrowseProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->getConcurrentMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method

.method private getBrowseMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/metrics/SourceName;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->config:Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/RetailSearchLoggingConfig;->getBrowseProgramName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->getMetricEvent(Ljava/lang/String;Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public recordDeparmentMenuClickInNav()V
    .locals 3

    .prologue
    .line 83
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->getBrowseMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 84
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->NavActivityRefinementMenuClicked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 85
    return-void
.end method

.method public recordDepartmentMenuClickInBrowse()V
    .locals 3

    .prologue
    .line 76
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->getBrowseMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 77
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->BrowseActivityRefinementMenuClicked:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 78
    return-void
.end method

.method public recordPageLoaded()V
    .locals 3

    .prologue
    .line 69
    sget-object v1, Lcom/amazon/retailsearch/metrics/SourceName;->Engagement:Lcom/amazon/retailsearch/metrics/SourceName;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->getBrowseMetricEvent(Lcom/amazon/retailsearch/metrics/SourceName;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 70
    .local v0, "event":Lcom/amazon/client/metrics/MetricEvent;
    sget-object v1, Lcom/amazon/retailsearch/metrics/MetricName;->BrowsePageLoaded:Lcom/amazon/retailsearch/metrics/MetricName;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/metrics/MetricName;->name()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/retailsearch/metrics/CategoryBrowseDCMLogger;->recordCounter(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;I)V

    .line 71
    return-void
.end method
