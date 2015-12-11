.class Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;
.super Ljava/lang/Object;
.source "MetricsHeaderProcessor.java"

# interfaces
.implements Lcom/amazon/device/utils/DetUtil$HeaderProcessor;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

.field private final mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

.field private final mNextProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

.field private mProcessName:Ljava/lang/String;

.field private mTag:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 16
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "MetricsHeaderProcessor"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/utils/DetUtil$HeaderProcessor;Lcom/amazon/device/crashmanager/AmazonPackageLookup;Lcom/amazon/client/metrics/MetricEvent;)V
    .locals 2
    .param p1, "nextProcessor"    # Lcom/amazon/device/utils/DetUtil$HeaderProcessor;
    .param p2, "amazonPackageLookup"    # Lcom/amazon/device/crashmanager/AmazonPackageLookup;
    .param p3, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    const/4 v0, 0x0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object v0, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mTag:Ljava/lang/String;

    .line 23
    iput-object v0, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mProcessName:Ljava/lang/String;

    .line 27
    if-nez p1, :cond_0

    .line 28
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Next processor must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 30
    :cond_0
    if-nez p2, :cond_1

    .line 31
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Package lookup must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 33
    :cond_1
    if-nez p3, :cond_2

    .line 34
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Metric Event must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 36
    :cond_2
    iput-object p1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mNextProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    .line 37
    iput-object p2, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

    .line 38
    iput-object p3, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    .line 39
    return-void
.end method


# virtual methods
.method public getProcessName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mProcessName:Ljava/lang/String;

    return-object v0
.end method

.method public process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V
    .locals 7
    .param p1, "header"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "writer"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    .line 70
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 71
    const-string/jumbo v1, "Process"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mTag:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 72
    iput-object p2, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mProcessName:Ljava/lang/String;

    .line 78
    iget-object v1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

    iget-object v4, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mProcessName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->generateFriendlyName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mTag:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v5, v6}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 102
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mNextProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    invoke-interface {v1, p1, p2, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 103
    return-void

    .line 80
    :cond_1
    const-string/jumbo v1, "hasForegroundActivities"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mProcessName:Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mTag:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 89
    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 90
    .local v0, "isForeground":Z
    if-eqz v0, :cond_0

    .line 92
    iget-object v1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mMetricEvent:Lcom/amazon/client/metrics/MetricEvent;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mAmazonPackageLookup:Lcom/amazon/device/crashmanager/AmazonPackageLookup;

    iget-object v4, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mProcessName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->generateFriendlyName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mTag:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ".foreground"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v5, v6}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    goto :goto_0

    .line 97
    .end local v0    # "isForeground":Z
    :cond_2
    sget-object v1, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "MetricsHeaderProcessor.process"

    const-string/jumbo v3, "unknown header. cannot process "

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "header"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object p1, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public setProcessTag(Ljava/lang/String;)V
    .locals 0
    .param p1, "processTag"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->mTag:Ljava/lang/String;

    .line 51
    return-void
.end method
