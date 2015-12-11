.class public Lcom/amazon/mShop/wearable/WearableMetricHelper;
.super Ljava/lang/Object;
.source "WearableMetricHelper.java"


# static fields
.field private static final DEBUG:Z

.field private static final TAG:Ljava/lang/String;

.field private static sInstance:Lcom/amazon/mShop/wearable/WearableMetricHelper;


# instance fields
.field final mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->sInstance:Lcom/amazon/mShop/wearable/WearableMetricHelper;

    .line 33
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->DEBUG:Z

    .line 34
    const-class v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    invoke-static {p1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 46
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/mShop/wearable/WearableMetricHelper;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 49
    const-class v1, Lcom/amazon/mShop/wearable/WearableMetricHelper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->sInstance:Lcom/amazon/mShop/wearable/WearableMetricHelper;

    if-nez v0, :cond_0

    .line 50
    new-instance v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/wearable/WearableMetricHelper;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->sInstance:Lcom/amazon/mShop/wearable/WearableMetricHelper;

    .line 52
    :cond_0
    sget-object v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->sInstance:Lcom/amazon/mShop/wearable/WearableMetricHelper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 49
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public addLatencyMetric(Ljava/lang/String;Ljava/lang/String;D)V
    .locals 4
    .param p1, "sourceName"    # Ljava/lang/String;
    .param p2, "timerName"    # Ljava/lang/String;
    .param p3, "timerValue"    # D

    .prologue
    .line 76
    sget-boolean v1, Lcom/amazon/mShop/wearable/WearableMetricHelper;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 77
    sget-object v1, Lcom/amazon/mShop/wearable/WearableMetricHelper;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "addLatencyMetric :: sourceName"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ", timerName:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ", timerValue:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3, p4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v2, "MShopAndroidPhoneApp"

    invoke-interface {v1, v2, p1}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 80
    .local v0, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    invoke-interface {v0, p2, p3, p4}, Lcom/amazon/client/metrics/MetricEvent;->addTimer(Ljava/lang/String;D)V

    .line 81
    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v1, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 82
    return-void
.end method

.method public emitClickStream(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 11
    .param p1, "sourceName"    # Ljava/lang/String;
    .param p2, "pageType"    # Ljava/lang/String;
    .param p3, "pageTypeID"    # Ljava/lang/String;
    .param p4, "subPageType"    # Ljava/lang/String;
    .param p5, "hitType"    # Ljava/lang/String;
    .param p6, "pageAction"    # Ljava/lang/String;
    .param p7, "counterName"    # Ljava/lang/String;
    .param p8, "reftag"    # Ljava/lang/String;
    .param p9, "count"    # I

    .prologue
    .line 89
    sget-boolean v7, Lcom/amazon/mShop/wearable/WearableMetricHelper;->DEBUG:Z

    if-eqz v7, :cond_0

    .line 90
    sget-object v7, Lcom/amazon/mShop/wearable/WearableMetricHelper;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "emitClickStream :: sourceName:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ", pageType:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ", pageTypeID"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ", subPageType:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ", hitType"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move-object/from16 v0, p5

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ", pageAction:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move-object/from16 v0, p6

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ", counterName"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move-object/from16 v0, p7

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ", refTag:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move-object/from16 v0, p8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ", count:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move/from16 v0, p9

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 93
    :cond_0
    iget-object v7, p0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v8, "MShopAndroidPhoneApp"

    invoke-interface {v7, v8, p1}, Lcom/amazon/client/metrics/MetricsFactory;->createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;

    move-result-object v3

    .line 94
    .local v3, "metricEvent":Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
    new-instance v6, Lcom/amazon/client/metrics/clickstream/UsageInfo;

    const-string/jumbo v7, "mobile-sensory"

    const-string/jumbo v8, "wear"

    move-object/from16 v0, p5

    invoke-direct {v6, p2, v0, v7, v8}, Lcom/amazon/client/metrics/clickstream/UsageInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    .local v6, "usageInfo":Lcom/amazon/client/metrics/clickstream/UsageInfo;
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 96
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v7

    invoke-virtual {v6, v7}, Lcom/amazon/client/metrics/clickstream/UsageInfo;->setIsPrimeCustomer(Z)Lcom/amazon/client/metrics/clickstream/UsageInfo;

    .line 99
    :cond_1
    move-object/from16 v0, p6

    invoke-virtual {v6, v0}, Lcom/amazon/client/metrics/clickstream/UsageInfo;->setPageAction(Ljava/lang/String;)Lcom/amazon/client/metrics/clickstream/UsageInfo;

    .line 100
    invoke-virtual {v6, p3}, Lcom/amazon/client/metrics/clickstream/UsageInfo;->setPageTypeID(Ljava/lang/String;)Lcom/amazon/client/metrics/clickstream/UsageInfo;

    .line 101
    invoke-virtual {v6, p4}, Lcom/amazon/client/metrics/clickstream/UsageInfo;->setSubPageType(Ljava/lang/String;)Lcom/amazon/client/metrics/clickstream/UsageInfo;

    .line 103
    invoke-interface {v3, v6}, Lcom/amazon/client/metrics/ClickStreamMetricsEvent;->setUsageInfo(Lcom/amazon/client/metrics/clickstream/UsageInfo;)V

    .line 106
    :try_start_0
    invoke-static/range {p8 .. p8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 107
    new-instance v4, Lcom/amazon/client/metrics/DataPoint;

    const-string/jumbo v7, "ref-override"

    const/4 v8, 0x1

    sget-object v9, Lcom/amazon/client/metrics/DataPointType;->CK:Lcom/amazon/client/metrics/DataPointType;

    move-object/from16 v0, p8

    invoke-direct {v4, v7, v0, v8, v9}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 108
    .local v4, "refTagDataPoint":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {v3, v4}, Lcom/amazon/client/metrics/ClickStreamMetricsEvent;->addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V

    .line 113
    .end local v4    # "refTagDataPoint":Lcom/amazon/client/metrics/DataPoint;
    :cond_2
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    const-string/jumbo v8, "detail"

    invoke-virtual {v7, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_3

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    const-string/jumbo v8, "addedasintowl"

    invoke-virtual {v7, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 114
    :cond_3
    new-instance v1, Lcom/amazon/client/metrics/DataPoint;

    const-string/jumbo v7, "is-glance-view"

    const-string/jumbo v8, "Y"

    const/4 v9, 0x1

    sget-object v10, Lcom/amazon/client/metrics/DataPointType;->CK:Lcom/amazon/client/metrics/DataPointType;

    invoke-direct {v1, v7, v8, v9, v10}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 115
    .local v1, "glanceDataPoint":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {v3, v1}, Lcom/amazon/client/metrics/ClickStreamMetricsEvent;->addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V

    .line 117
    new-instance v5, Lcom/amazon/client/metrics/DataPoint;

    const-string/jumbo v7, "page-type-id-source"

    const-string/jumbo v8, "ASIN"

    const/4 v9, 0x1

    sget-object v10, Lcom/amazon/client/metrics/DataPointType;->CK:Lcom/amazon/client/metrics/DataPointType;

    invoke-direct {v5, v7, v8, v9, v10}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 118
    .local v5, "sourceDataPoint":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {v3, v5}, Lcom/amazon/client/metrics/ClickStreamMetricsEvent;->addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V
    :try_end_0
    .catch Lcom/amazon/client/metrics/MetricsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 124
    .end local v1    # "glanceDataPoint":Lcom/amazon/client/metrics/DataPoint;
    .end local v5    # "sourceDataPoint":Lcom/amazon/client/metrics/DataPoint;
    :cond_4
    :goto_0
    move/from16 v0, p9

    int-to-double v7, v0

    move-object/from16 v0, p7

    invoke-interface {v3, v0, v7, v8}, Lcom/amazon/client/metrics/ClickStreamMetricsEvent;->addCounter(Ljava/lang/String;D)V

    .line 125
    iget-object v7, p0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v7, v3}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 126
    return-void

    .line 120
    :catch_0
    move-exception v2

    .line 121
    .local v2, "me":Lcom/amazon/client/metrics/MetricsException;
    sget-object v7, Lcom/amazon/mShop/wearable/WearableMetricHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Metric exception thrown while trying to add datapoint to clickStream"

    invoke-static {v7, v8, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public incrementPMETCounter(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 4
    .param p1, "sourceName"    # Ljava/lang/String;
    .param p2, "counterName"    # Ljava/lang/String;
    .param p3, "count"    # I

    .prologue
    .line 56
    sget-boolean v1, Lcom/amazon/mShop/wearable/WearableMetricHelper;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 57
    sget-object v1, Lcom/amazon/mShop/wearable/WearableMetricHelper;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "incrementPMETCounter:: sourceName:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ", counterName:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ", count:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v2, "MShopAndroidPhoneApp"

    invoke-interface {v1, v2, p1}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    .line 61
    .local v0, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    int-to-double v1, p3

    invoke-interface {v0, p2, v1, v2}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 62
    iget-object v1, p0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    invoke-interface {v1, v0}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 63
    return-void
.end method

.method public logRefMarker(Ljava/lang/String;)V
    .locals 3
    .param p1, "refMarker"    # Ljava/lang/String;

    .prologue
    .line 66
    sget-boolean v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 67
    sget-object v0, Lcom/amazon/mShop/wearable/WearableMetricHelper;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "logRefmarker:: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 70
    :cond_0
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 71
    invoke-static {p1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 73
    :cond_1
    return-void
.end method
