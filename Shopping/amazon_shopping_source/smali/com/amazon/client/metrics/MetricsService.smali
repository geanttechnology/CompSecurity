.class public Lcom/amazon/client/metrics/MetricsService;
.super Ljava/lang/Object;
.source "MetricsService.java"

# interfaces
.implements Lcom/amazon/client/metrics/UploadIntentListener;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mBatchCreatorMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/client/metrics/Priority;",
            "Lcom/amazon/client/metrics/batch/creator/BatchCreator;",
            ">;"
        }
    .end annotation
.end field

.field private final mBatchTransmitterList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;",
            ">;"
        }
    .end annotation
.end field

.field private final mTriggerEvaluator:Lcom/amazon/client/metrics/trigger/TriggerEvaluator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/client/metrics/trigger/TriggerEvaluator",
            "<",
            "Lcom/amazon/client/metrics/MetricEntry;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    invoke-direct {v0}, Lcom/amazon/dp/logger/DPLogger;-><init>()V

    sput-object v0, Lcom/amazon/client/metrics/MetricsService;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Ljava/util/Map;Ljava/util/List;Lcom/amazon/client/metrics/trigger/TriggerEvaluator;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/client/metrics/Priority;",
            "Lcom/amazon/client/metrics/batch/creator/BatchCreator;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;",
            ">;",
            "Lcom/amazon/client/metrics/trigger/TriggerEvaluator",
            "<",
            "Lcom/amazon/client/metrics/MetricEntry;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "batchCreatorMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/batch/creator/BatchCreator;>;"
    .local p2, "batchTransmitterList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;>;"
    .local p3, "triggerEvaluator":Lcom/amazon/client/metrics/trigger/TriggerEvaluator;, "Lcom/amazon/client/metrics/trigger/TriggerEvaluator<Lcom/amazon/client/metrics/MetricEntry;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/amazon/client/metrics/MetricsService;->mBatchCreatorMap:Ljava/util/Map;

    .line 48
    iput-object p2, p0, Lcom/amazon/client/metrics/MetricsService;->mBatchTransmitterList:Ljava/util/List;

    .line 49
    iput-object p3, p0, Lcom/amazon/client/metrics/MetricsService;->mTriggerEvaluator:Lcom/amazon/client/metrics/trigger/TriggerEvaluator;

    .line 50
    invoke-static {p0}, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->addUploadIntentListener(Lcom/amazon/client/metrics/UploadIntentListener;)V

    .line 51
    return-void
.end method


# virtual methods
.method public onUploadIntentReceived()V
    .locals 7

    .prologue
    .line 95
    sget-object v3, Lcom/amazon/client/metrics/MetricsService;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "onUploadIntentReceived"

    const-string/jumbo v5, "Enqueuing all batches and triggering transmission."

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 96
    iget-object v3, p0, Lcom/amazon/client/metrics/MetricsService;->mBatchCreatorMap:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    .line 97
    .local v0, "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->enqueueBatchForTransmission()V

    goto :goto_0

    .line 99
    .end local v0    # "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    :cond_0
    iget-object v3, p0, Lcom/amazon/client/metrics/MetricsService;->mBatchTransmitterList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    .line 100
    .local v1, "batchTransmitter":Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->transmitBatches(Z)V

    goto :goto_1

    .line 102
    .end local v1    # "batchTransmitter":Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    :cond_1
    return-void
.end method

.method public record(Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/MetricEntry;)V
    .locals 7
    .param p1, "priority"    # Lcom/amazon/client/metrics/Priority;
    .param p2, "metricEntry"    # Lcom/amazon/client/metrics/MetricEntry;

    .prologue
    .line 57
    iget-object v1, p0, Lcom/amazon/client/metrics/MetricsService;->mTriggerEvaluator:Lcom/amazon/client/metrics/trigger/TriggerEvaluator;

    if-eqz v1, :cond_0

    .line 58
    iget-object v1, p0, Lcom/amazon/client/metrics/MetricsService;->mTriggerEvaluator:Lcom/amazon/client/metrics/trigger/TriggerEvaluator;

    invoke-interface {v1, p2}, Lcom/amazon/client/metrics/trigger/TriggerEvaluator;->evaluate(Ljava/lang/Object;)V

    .line 61
    :cond_0
    iget-object v1, p0, Lcom/amazon/client/metrics/MetricsService;->mBatchCreatorMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    .line 62
    .local v0, "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    if-eqz v0, :cond_1

    .line 63
    invoke-virtual {v0, p2}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->addMetricEntry(Lcom/amazon/client/metrics/MetricEntry;)V

    .line 67
    :goto_0
    return-void

    .line 65
    :cond_1
    sget-object v1, Lcom/amazon/client/metrics/MetricsService;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "record"

    const-string/jumbo v3, "Metric dropped. No batch pipeline exists at priority level."

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-string/jumbo v6, "priority"

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object p1, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public shutdown()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 73
    sget-object v4, Lcom/amazon/client/metrics/MetricsService;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "shutdown"

    const-string/jumbo v6, "Enqueuing all batches and shutting down batch creators and transmitters."

    new-array v7, v9, [Ljava/lang/Object;

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 74
    iget-object v4, p0, Lcom/amazon/client/metrics/MetricsService;->mBatchCreatorMap:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    .line 77
    .local v0, "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    :try_start_0
    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->enqueueBatchForTransmission()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 81
    :goto_1
    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->shutdown()V

    goto :goto_0

    .line 78
    :catch_0
    move-exception v2

    .line 79
    .local v2, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/amazon/client/metrics/MetricsService;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "shutdown"

    const-string/jumbo v6, "Exception enqueuing batches:"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 83
    .end local v0    # "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_0
    iget-object v4, p0, Lcom/amazon/client/metrics/MetricsService;->mBatchTransmitterList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    .line 84
    .local v1, "batchTransmitter":Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    invoke-virtual {v1}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->shutdown()V

    goto :goto_2

    .line 86
    .end local v1    # "batchTransmitter":Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    :cond_1
    invoke-static {}, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->shutdown()V

    .line 87
    return-void
.end method
