.class Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;
.super Ljava/lang/Object;
.source "MetricsHeaderProcessorFactory.java"


# instance fields
.field private mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

.field private mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;


# direct methods
.method public constructor <init>(Lcom/amazon/device/crashmanager/AmazonPackageLookup;Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 2
    .param p1, "amazonPackageLookup"    # Lcom/amazon/device/crashmanager/AmazonPackageLookup;
    .param p2, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    if-nez p1, :cond_0

    .line 17
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Amazon Package Lookup must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 19
    :cond_0
    if-nez p2, :cond_1

    .line 20
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Metric event must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 22
    :cond_1
    iput-object p1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;->mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

    .line 23
    iput-object p2, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 24
    return-void
.end method


# virtual methods
.method public construct(Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;
    .locals 3
    .param p1, "nextProcessor"    # Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    .prologue
    .line 27
    if-nez p1, :cond_0

    .line 28
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Header processor must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 30
    :cond_0
    new-instance v0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;

    iget-object v1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;->mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

    iget-object v2, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    invoke-direct {v0, p1, v1, v2}, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;-><init>(Lcom/amazon/device/utils/DetUtil$HeaderProcessor;Lcom/amazon/device/crashmanager/AmazonPackageLookup;Lcom/amazon/client/metrics/MetricEvent;)V

    return-object v0
.end method
