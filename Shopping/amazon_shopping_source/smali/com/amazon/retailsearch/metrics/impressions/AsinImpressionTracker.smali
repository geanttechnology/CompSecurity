.class public Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
.super Ljava/lang/Object;
.source "AsinImpressionTracker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$1;,
        Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;
    }
.end annotation


# static fields
.field private static final ALREADY_IMPRESSED:Ljava/lang/Long;

.field private static final MIN_ASIN_VIEW_PERCENT_VISIBILITY:F = 0.7f

.field private static final MIN_ASIN_VISIBILITY_LENGTH_MS:I = 0x3e8


# instance fields
.field private asinToRid:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private confirmedAsinImpressions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;",
            ">;"
        }
    .end annotation
.end field

.field private firstVisibleTimes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private taskListener:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    const-wide/16 v0, -0x1

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->ALREADY_IMPRESSED:Ljava/lang/Long;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->confirmedAsinImpressions:Ljava/util/List;

    .line 40
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->firstVisibleTimes:Ljava/util/Map;

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->asinToRid:Ljava/util/Map;

    .line 42
    new-instance v0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;-><init>(Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->taskListener:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;

    .line 44
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 48
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 49
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->asinToRid:Ljava/util/Map;

    return-object v0
.end method

.method private reset()V
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->confirmedAsinImpressions:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 130
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->firstVisibleTimes:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 131
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->asinToRid:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 132
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->taskListener:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;->reset()V

    .line 133
    return-void
.end method

.method private send()V
    .locals 2

    .prologue
    .line 124
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->confirmedAsinImpressions:Ljava/util/List;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->recordAsinImpressions(Ljava/util/List;)V

    .line 125
    return-void
.end method


# virtual methods
.method public evaluateByIncrementalSnapshot(Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;)V
    .locals 7
    .param p1, "snapshot"    # Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;

    .prologue
    .line 71
    invoke-virtual {p1}, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->getAsin()Ljava/lang/String;

    move-result-object v0

    .line 75
    .local v0, "asin":Ljava/lang/String;
    sget-object v3, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->ALREADY_IMPRESSED:Ljava/lang/Long;

    iget-object v4, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->firstVisibleTimes:Ljava/util/Map;

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/Long;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 106
    :cond_0
    :goto_0
    return-void

    .line 81
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->getPercentVisible()F

    move-result v3

    const v4, 0x3f333333    # 0.7f

    cmpg-float v3, v3, v4

    if-gez v3, :cond_2

    .line 84
    iget-object v3, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->firstVisibleTimes:Ljava/util/Map;

    invoke-interface {v3, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 88
    :cond_2
    iget-object v3, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->firstVisibleTimes:Ljava/util/Map;

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 89
    .local v1, "firstTimeThisAsinBecameSufficientlyVisible":Ljava/lang/Long;
    if-nez v1, :cond_3

    .line 91
    iget-object v3, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->firstVisibleTimes:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->getTimestamp()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v3, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 96
    :cond_3
    invoke-virtual {p1}, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;->getTimestamp()J

    move-result-wide v3

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    sub-long/2addr v3, v5

    const-wide/16 v5, 0x3e8

    cmp-long v3, v3, v5

    if-ltz v3, :cond_0

    .line 98
    iget-object v3, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->asinToRid:Ljava/util/Map;

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 99
    .local v2, "rid":Ljava/lang/String;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 101
    iget-object v3, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->confirmedAsinImpressions:Ljava/util/List;

    new-instance v4, Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;

    invoke-direct {v4, v2, v0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpression;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 102
    iget-object v3, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->firstVisibleTimes:Ljava/util/Map;

    sget-object v4, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->ALREADY_IMPRESSED:Ljava/lang/Long;

    invoke-interface {v3, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public getSearchTaskListener()Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->taskListener:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker$TaskListener;

    return-object v0
.end method

.method public recordImpressions()V
    .locals 0

    .prologue
    .line 113
    invoke-direct {p0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->send()V

    .line 114
    invoke-direct {p0}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->reset()V

    .line 115
    return-void
.end method

.method public wasAsinViewed(Ljava/lang/String;)Z
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 58
    sget-object v0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->ALREADY_IMPRESSED:Ljava/lang/Long;

    iget-object v1, p0, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->firstVisibleTimes:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Long;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
