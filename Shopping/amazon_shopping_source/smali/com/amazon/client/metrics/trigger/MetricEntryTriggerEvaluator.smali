.class public Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;
.super Ljava/lang/Object;
.source "MetricEntryTriggerEvaluator.java"

# interfaces
.implements Lcom/amazon/client/metrics/trigger/TriggerEvaluator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/client/metrics/trigger/TriggerEvaluator",
        "<",
        "Lcom/amazon/client/metrics/MetricEntry;",
        ">;"
    }
.end annotation


# static fields
.field private static final TRIGGER_ACTION_METRIC_NAME:Ljava/lang/String; = "TriggerActionCount"

.field private static final TRIGGER_EVALUATOR_METRIC_NAME:Ljava/lang/String; = "TriggerEvaluator"

.field private static final TRIGGER_REASON_METRIC_NAME:Ljava/lang/String; = "TriggerReason"

.field private static final TRIGGER_RULE_ID_DELIMITER:Ljava/lang/String; = "."


# instance fields
.field private final mDefaultTriggerAction:Lcom/amazon/client/metrics/trigger/TriggerAction;

.field private final mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

.field private final mTriggerExpressionCodec:Lcom/amazon/client/metrics/trigger/TriggerExpressionCodec;

.field private final mTriggerRuleDataSource:Lcom/amazon/client/metrics/trigger/TriggerRuleDataSource;

.field private final mTriggerRuleId:Lcom/amazon/client/metrics/trigger/TriggerRuleId;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/trigger/TriggerExpressionCodec;Lcom/amazon/client/metrics/trigger/TriggerRuleDataSource;Lcom/amazon/client/metrics/trigger/TriggerRuleId;Lcom/amazon/client/metrics/trigger/TriggerAction;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V
    .locals 2
    .param p1, "triggerExpressionCodec"    # Lcom/amazon/client/metrics/trigger/TriggerExpressionCodec;
    .param p2, "triggerRuleDataSource"    # Lcom/amazon/client/metrics/trigger/TriggerRuleDataSource;
    .param p3, "triggerRuleId"    # Lcom/amazon/client/metrics/trigger/TriggerRuleId;
    .param p4, "defaultTriggerAction"    # Lcom/amazon/client/metrics/trigger/TriggerAction;
    .param p5, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    if-nez p1, :cond_0

    .line 72
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "triggerExpressionCodec must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :cond_0
    if-nez p2, :cond_1

    .line 76
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "triggerRuleDataSource must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 79
    :cond_1
    if-nez p3, :cond_2

    .line 80
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "triggerRuleId must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 83
    :cond_2
    if-nez p4, :cond_3

    .line 84
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "defaultTriggerAction must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 87
    :cond_3
    if-nez p5, :cond_4

    .line 88
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "periodicMetricReporter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 91
    :cond_4
    iput-object p1, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerExpressionCodec:Lcom/amazon/client/metrics/trigger/TriggerExpressionCodec;

    .line 92
    iput-object p2, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleDataSource:Lcom/amazon/client/metrics/trigger/TriggerRuleDataSource;

    .line 93
    iput-object p3, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleId:Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    .line 94
    iput-object p4, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mDefaultTriggerAction:Lcom/amazon/client/metrics/trigger/TriggerAction;

    .line 95
    iput-object p5, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .line 96
    return-void
.end method

.method private addCommonPrefixToTriggerRuleId(Lcom/amazon/client/metrics/MetricEntry;Lcom/amazon/client/metrics/trigger/TriggerRuleId;)V
    .locals 2
    .param p1, "metricEntry"    # Lcom/amazon/client/metrics/MetricEntry;
    .param p2, "triggerRuleId"    # Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    .prologue
    .line 196
    invoke-interface {p2}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->reset()V

    .line 199
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getProgram()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->append(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    move-result-object v0

    const-string/jumbo v1, "."

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->append(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getSource()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->append(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    .line 203
    invoke-interface {p2}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->markCommonPrefix()V

    .line 204
    return-void
.end method

.method private addDataPointSpecificDataToTriggerRuleId(Lcom/amazon/client/metrics/DataPoint;Lcom/amazon/client/metrics/trigger/TriggerRuleId;)V
    .locals 2
    .param p1, "dataPoint"    # Lcom/amazon/client/metrics/DataPoint;
    .param p2, "triggerRuleId"    # Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    .prologue
    .line 210
    invoke-interface {p2}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->resetToCommonPrefix()V

    .line 214
    const-string/jumbo v0, "."

    invoke-interface {p2, v0}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->append(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->append(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    move-result-object v0

    const-string/jumbo v1, "."

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->append(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/DataPointType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->append(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    .line 218
    return-void
.end method

.method private isAcceptedDataPointType(Lcom/amazon/client/metrics/DataPointType;)Z
    .locals 1
    .param p1, "dataPointType"    # Lcom/amazon/client/metrics/DataPointType;

    .prologue
    .line 189
    invoke-static {}, Lcom/amazon/client/metrics/DataPointType;->getCounterType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v0

    if-eq p1, v0, :cond_0

    invoke-static {}, Lcom/amazon/client/metrics/DataPointType;->getTimerType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v0

    if-ne p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private retrieveTriggerExpression(Lcom/amazon/client/metrics/trigger/TriggerRuleId;)Lcom/amazon/client/metrics/trigger/TriggerExpression;
    .locals 2
    .param p1, "triggerRuleId"    # Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    .prologue
    .line 223
    iget-object v1, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleDataSource:Lcom/amazon/client/metrics/trigger/TriggerRuleDataSource;

    invoke-interface {v1, p1}, Lcom/amazon/client/metrics/trigger/TriggerRuleDataSource;->getTriggerRuleDataForTriggerRuleId(Lcom/amazon/client/metrics/trigger/TriggerRuleId;)Ljava/lang/String;

    move-result-object v0

    .line 227
    .local v0, "serializedTriggerExpression":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 228
    const/4 v1, 0x0

    .line 232
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerExpressionCodec:Lcom/amazon/client/metrics/trigger/TriggerExpressionCodec;

    invoke-virtual {v1, v0}, Lcom/amazon/client/metrics/trigger/TriggerExpressionCodec;->deserializeTriggerExpression(Ljava/lang/String;)Lcom/amazon/client/metrics/trigger/TriggerExpression;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized evaluate(Lcom/amazon/client/metrics/MetricEntry;)V
    .locals 13
    .param p1, "metricEntry"    # Lcom/amazon/client/metrics/MetricEntry;

    .prologue
    .line 108
    monitor-enter p0

    if-nez p1, :cond_0

    .line 184
    :goto_0
    monitor-exit p0

    return-void

    .line 112
    :cond_0
    :try_start_0
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v9}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v9

    const-string/jumbo v10, "TriggerEvaluator"

    invoke-interface {v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 117
    :try_start_1
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleId:Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    invoke-direct {p0, p1, v9}, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->addCommonPrefixToTriggerRuleId(Lcom/amazon/client/metrics/MetricEntry;Lcom/amazon/client/metrics/trigger/TriggerRuleId;)V

    .line 123
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleDataSource:Lcom/amazon/client/metrics/trigger/TriggerRuleDataSource;

    iget-object v10, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleId:Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    invoke-interface {v9, v10}, Lcom/amazon/client/metrics/trigger/TriggerRuleDataSource;->triggerRulesExistForTriggerRuleIdPrefix(Lcom/amazon/client/metrics/trigger/TriggerRuleId;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v9

    if-nez v9, :cond_1

    .line 182
    :try_start_2
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v9}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v9

    const-string/jumbo v10, "TriggerEvaluator"

    invoke-interface {v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 108
    :catchall_0
    move-exception v9

    monitor-exit p0

    throw v9

    .line 128
    :cond_1
    const/4 v5, 0x0

    .line 129
    .local v5, "triggerActionReasons":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .line 131
    .local v2, "triggerActionCount":I
    :try_start_3
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getDatapoints()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/DataPoint;

    .line 133
    .local v0, "dataPoint":Lcom/amazon/client/metrics/DataPoint;
    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v9

    invoke-direct {p0, v9}, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->isAcceptedDataPointType(Lcom/amazon/client/metrics/DataPointType;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 139
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleId:Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    invoke-direct {p0, v0, v9}, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->addDataPointSpecificDataToTriggerRuleId(Lcom/amazon/client/metrics/DataPoint;Lcom/amazon/client/metrics/trigger/TriggerRuleId;)V

    .line 142
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleId:Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    invoke-direct {p0, v9}, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->retrieveTriggerExpression(Lcom/amazon/client/metrics/trigger/TriggerRuleId;)Lcom/amazon/client/metrics/trigger/TriggerExpression;

    move-result-object v6

    .line 145
    .local v6, "triggerExpression":Lcom/amazon/client/metrics/trigger/TriggerExpression;
    if-eqz v6, :cond_2

    .line 150
    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v7

    .line 153
    .local v7, "value":D
    invoke-interface {v6, v7, v8}, Lcom/amazon/client/metrics/trigger/TriggerExpression;->evaluate(D)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 154
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mTriggerRuleId:Lcom/amazon/client/metrics/trigger/TriggerRuleId;

    invoke-interface {v9}, Lcom/amazon/client/metrics/trigger/TriggerRuleId;->toString()Ljava/lang/String;

    move-result-object v3

    .line 156
    .local v3, "triggerActionReason":Ljava/lang/String;
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mDefaultTriggerAction:Lcom/amazon/client/metrics/trigger/TriggerAction;

    invoke-interface {v9, v3}, Lcom/amazon/client/metrics/trigger/TriggerAction;->execute(Ljava/lang/CharSequence;)V

    .line 159
    if-nez v5, :cond_3

    .line 160
    new-instance v5, Ljava/lang/StringBuilder;

    .end local v5    # "triggerActionReasons":Ljava/lang/StringBuilder;
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 163
    .restart local v5    # "triggerActionReasons":Ljava/lang/StringBuilder;
    :cond_3
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, " "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 164
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 168
    .end local v0    # "dataPoint":Lcom/amazon/client/metrics/DataPoint;
    .end local v3    # "triggerActionReason":Ljava/lang/String;
    .end local v6    # "triggerExpression":Lcom/amazon/client/metrics/trigger/TriggerExpression;
    .end local v7    # "value":D
    :cond_4
    if-lez v2, :cond_5

    .line 172
    new-instance v4, Lcom/amazon/client/metrics/DataPoint;

    const-string/jumbo v9, "TriggerReason"

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    const/4 v11, 0x1

    invoke-static {}, Lcom/amazon/client/metrics/DataPointType;->getDiscreteValueType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v12

    invoke-direct {v4, v9, v10, v11, v12}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 175
    .local v4, "triggerActionReasonDataPoint":Lcom/amazon/client/metrics/DataPoint;
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getDatapoints()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 178
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v9}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v9

    const-string/jumbo v10, "TriggerActionCount"

    int-to-double v11, v2

    invoke-interface {v9, v10, v11, v12}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 182
    .end local v4    # "triggerActionReasonDataPoint":Lcom/amazon/client/metrics/DataPoint;
    :cond_5
    :try_start_4
    iget-object v9, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v9}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v9

    const-string/jumbo v10, "TriggerEvaluator"

    invoke-interface {v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "triggerActionCount":I
    .end local v5    # "triggerActionReasons":Ljava/lang/StringBuilder;
    :catchall_1
    move-exception v9

    iget-object v10, p0, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v10}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v10

    const-string/jumbo v11, "TriggerEvaluator"

    invoke-interface {v10, v11}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    throw v9
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method public bridge synthetic evaluate(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 22
    check-cast p1, Lcom/amazon/client/metrics/MetricEntry;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/trigger/MetricEntryTriggerEvaluator;->evaluate(Lcom/amazon/client/metrics/MetricEntry;)V

    return-void
.end method
