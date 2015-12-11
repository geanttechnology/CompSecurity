.class public Lcom/amazon/client/metrics/BasicMetricEvent;
.super Ljava/lang/Object;
.source "BasicMetricEvent.java"

# interfaces
.implements Lcom/amazon/client/metrics/MetricEvent;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/BasicMetricEvent$1;
    }
.end annotation


# static fields
.field private static final ALLOW_RUNNING_TIMERS_KEY:Ljava/lang/String; = "AllowRunning"

.field public static final ATTRIBUTE_DELIMITER:Ljava/lang/String; = " ; "

.field private static final DATAPOINTS_MAP_KEY:Ljava/lang/String; = "Datapoints"

.field private static final DATAPOINT_DELIMITER:Ljava/lang/String; = "\t"

.field public static final LIST_DELIMITER:Ljava/lang/String; = ","

.field private static final METRIC_EVENT_TYPE_KEY:Ljava/lang/String; = "Type"

.field private static final PROGRAM_MAP_KEY:Ljava/lang/String; = "Program"

.field private static final SOURCE_MAP_KEY:Ljava/lang/String; = "Source"


# instance fields
.field private mAllowRunningTimers:Z

.field protected mCounters:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Double;",
            ">;"
        }
    .end annotation
.end field

.field private mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

.field private mProgram:Ljava/lang/String;

.field private mSource:Ljava/lang/String;

.field protected mStringClickstreamValues:Ljava/util/Map;
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

.field protected mStringDiscreteValues:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field protected mTimers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/client/metrics/AggregatingTimer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 63
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/client/metrics/BasicMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    .line 64
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 67
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/client/metrics/BasicMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V

    .line 68
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mCounters:Ljava/util/Map;

    .line 58
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mTimers:Ljava/util/Map;

    .line 59
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringDiscreteValues:Ljava/util/Map;

    .line 60
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringClickstreamValues:Ljava/util/Map;

    .line 72
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateString(Ljava/lang/String;)V

    .line 73
    invoke-direct {p0, p2}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateString(Ljava/lang/String;)V

    .line 74
    iput-object p1, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mProgram:Ljava/lang/String;

    .line 75
    iput-object p2, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mSource:Ljava/lang/String;

    .line 76
    iput-object p3, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    .line 77
    iput-boolean p4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mAllowRunningTimers:Z

    .line 78
    return-void
.end method

.method private addClickStreamData(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 348
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateString(Ljava/lang/String;)V

    .line 349
    invoke-direct {p0, p2}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateStringValue(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 350
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringClickstreamValues:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 352
    :cond_0
    return-void
.end method

.method private getOrCreateTimer(Ljava/lang/String;)Lcom/amazon/client/metrics/AggregatingTimer;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 355
    iget-object v1, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mTimers:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/AggregatingTimer;

    .line 358
    .local v0, "timer":Lcom/amazon/client/metrics/AggregatingTimer;
    if-nez v0, :cond_0

    .line 359
    new-instance v0, Lcom/amazon/client/metrics/AggregatingTimer;

    .end local v0    # "timer":Lcom/amazon/client/metrics/AggregatingTimer;
    iget-boolean v1, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mAllowRunningTimers:Z

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/AggregatingTimer;-><init>(Z)V

    .line 362
    .restart local v0    # "timer":Lcom/amazon/client/metrics/AggregatingTimer;
    :cond_0
    return-object v0
.end method

.method private listToString(Ljava/util/List;)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 275
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<*>;"
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 276
    const-string/jumbo v2, ""

    .line 285
    :goto_0
    return-object v2

    .line 279
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 280
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 281
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 282
    const-string/jumbo v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 281
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 285
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method private validateString(Ljava/lang/String;)V
    .locals 2
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 372
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 373
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Invalid string. Cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 375
    :cond_1
    return-void
.end method

.method private validateStringValue(Ljava/lang/String;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 384
    if-eqz p1, :cond_0

    const-string/jumbo v0, " ; "

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addCounter(Ljava/lang/String;D)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D

    .prologue
    .line 97
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/client/metrics/BasicMetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 98
    return-void
.end method

.method public addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V
    .locals 6
    .param p1, "dataPoint"    # Lcom/amazon/client/metrics/DataPoint;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/MetricsException;
        }
    .end annotation

    .prologue
    .line 290
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v0

    .line 292
    .local v0, "dataPointType":Lcom/amazon/client/metrics/DataPointType;
    :try_start_0
    sget-object v2, Lcom/amazon/client/metrics/BasicMetricEvent$1;->$SwitchMap$com$amazon$client$metrics$DataPointType:[I

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPointType;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 321
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "Invalid DataPointType"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 323
    :catch_0
    move-exception v1

    .line 324
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    new-instance v2, Lcom/amazon/client/metrics/MetricsException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Invalid DataPoint. DataPointType: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ", DataPoint value: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Lcom/amazon/client/metrics/MetricsException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 295
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    :pswitch_0
    :try_start_1
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v3

    invoke-virtual {p0, v2, v3, v4}, Lcom/amazon/client/metrics/BasicMetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 327
    :goto_0
    return-void

    .line 299
    :pswitch_1
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v3

    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getSamples()I

    move-result v5

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/amazon/client/metrics/BasicMetricEvent;->addTimer(Ljava/lang/String;DI)V

    goto :goto_0

    .line 315
    :pswitch_2
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/amazon/client/metrics/BasicMetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 318
    :pswitch_3
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Lcom/amazon/client/metrics/BasicMetricEvent;->addClickStreamData(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 292
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public addDataPoints(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/MetricsException;
        }
    .end annotation

    .prologue
    .line 331
    .local p1, "dataPointList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    const/4 v2, 0x0

    .line 332
    .local v2, "exceptionsCaught":I
    const/4 v4, 0x0

    .line 333
    .local v4, "lastExceptionCaught":Lcom/amazon/client/metrics/MetricsException;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/DataPoint;

    .line 335
    .local v0, "dataPoint":Lcom/amazon/client/metrics/DataPoint;
    :try_start_0
    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/BasicMetricEvent;->addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V
    :try_end_0
    .catch Lcom/amazon/client/metrics/MetricsException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 336
    :catch_0
    move-exception v1

    .line 337
    .local v1, "e":Lcom/amazon/client/metrics/MetricsException;
    add-int/lit8 v2, v2, 0x1

    .line 338
    move-object v4, v1

    goto :goto_0

    .line 341
    .end local v0    # "dataPoint":Lcom/amazon/client/metrics/DataPoint;
    .end local v1    # "e":Lcom/amazon/client/metrics/MetricsException;
    :cond_0
    if-eqz v2, :cond_1

    .line 342
    new-instance v5, Lcom/amazon/client/metrics/MetricsException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " MetricsExceptions were thrown"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " while adding datapoints"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6, v4}, Lcom/amazon/client/metrics/MetricsException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 345
    :cond_1
    return-void
.end method

.method public addString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 154
    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/BasicMetricEvent;->appendString(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    return-void
.end method

.method public addTimer(Ljava/lang/String;D)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D

    .prologue
    .line 118
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/client/metrics/BasicMetricEvent;->addTimer(Ljava/lang/String;DI)V

    .line 119
    return-void
.end method

.method public addTimer(Ljava/lang/String;DI)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D
    .param p4, "repeat"    # I

    .prologue
    .line 123
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateString(Ljava/lang/String;)V

    .line 124
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->getOrCreateTimer(Ljava/lang/String;)Lcom/amazon/client/metrics/AggregatingTimer;

    move-result-object v0

    .line 125
    .local v0, "timer":Lcom/amazon/client/metrics/AggregatingTimer;
    invoke-virtual {v0, p2, p3, p4}, Lcom/amazon/client/metrics/AggregatingTimer;->addTime(DI)V

    .line 126
    iget-object v1, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mTimers:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    return-void
.end method

.method public appendString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 159
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateString(Ljava/lang/String;)V

    .line 160
    invoke-direct {p0, p2}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateStringValue(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 161
    iget-object v1, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringDiscreteValues:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 162
    .local v0, "existingList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v0, :cond_0

    .line 163
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "existingList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 165
    .restart local v0    # "existingList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 166
    iget-object v1, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringDiscreteValues:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    .end local v0    # "existingList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    return-void
.end method

.method public clear()V
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mCounters:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 181
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mTimers:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 182
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringDiscreteValues:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 183
    return-void
.end method

.method protected convertDataPointToString(Lcom/amazon/client/metrics/DataPoint;)Ljava/lang/String;
    .locals 3
    .param p1, "d"    # Lcom/amazon/client/metrics/DataPoint;

    .prologue
    .line 454
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 455
    .local v0, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " ; "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 456
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/DataPointType;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " ; "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 457
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " ; "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 458
    invoke-virtual {p1}, Lcom/amazon/client/metrics/DataPoint;->getSamples()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 459
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method protected convertStringToDataPoint(Ljava/lang/String;)Lcom/amazon/client/metrics/DataPoint;
    .locals 6
    .param p1, "s"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 470
    const-string/jumbo v1, " ; "

    invoke-virtual {p1, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 471
    .local v0, "parts":[Ljava/lang/String;
    array-length v1, v0

    const/4 v2, 0x4

    if-ge v1, v2, :cond_0

    .line 472
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Not enough parts to the datapoint: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 474
    :cond_0
    new-instance v1, Lcom/amazon/client/metrics/DataPoint;

    const/4 v2, 0x0

    aget-object v2, v0, v2

    const/4 v3, 0x2

    aget-object v3, v0, v3

    const/4 v4, 0x3

    aget-object v4, v0, v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/4 v5, 0x1

    aget-object v5, v0, v5

    invoke-static {v5}, Lcom/amazon/client/metrics/DataPointType;->valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/DataPointType;

    move-result-object v5

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    return-object v1
.end method

.method public getAsDataPoints()Ljava/util/List;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 199
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 204
    .local v4, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    const/4 v5, 0x1

    .line 207
    .local v5, "defaultSamples":I
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/client/metrics/BasicMetricEvent;->mCounters:Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_0

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 208
    .local v3, "counter":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Double;>;"
    new-instance v6, Lcom/amazon/client/metrics/DataPoint;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/Double;

    invoke-virtual {v13}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v13

    invoke-static {v13, v14}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v13

    sget-object v14, Lcom/amazon/client/metrics/DataPointType;->CT:Lcom/amazon/client/metrics/DataPointType;

    invoke-direct {v6, v12, v13, v5, v14}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 210
    .local v6, "dp":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 214
    .end local v3    # "counter":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Double;>;"
    .end local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    :cond_0
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/client/metrics/BasicMetricEvent;->mTimers:Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_1
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_6

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/Map$Entry;

    .line 217
    .local v11, "timer":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/client/metrics/AggregatingTimer;>;"
    :try_start_0
    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/client/metrics/AggregatingTimer;

    invoke-virtual {v12}, Lcom/amazon/client/metrics/AggregatingTimer;->getSamples()I

    move-result v12

    if-nez v12, :cond_3

    .line 218
    move-object/from16 v0, p0

    iget-boolean v12, v0, Lcom/amazon/client/metrics/BasicMetricEvent;->mAllowRunningTimers:Z

    if-eqz v12, :cond_2

    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/client/metrics/AggregatingTimer;

    invoke-virtual {v12}, Lcom/amazon/client/metrics/AggregatingTimer;->numRunningTimers()I

    move-result v12

    if-gtz v12, :cond_1

    .line 223
    :cond_2
    new-instance v13, Ljava/lang/IllegalStateException;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v14, "Discarding timer as sample count is 0. Timer name: "

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-interface {v11}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-virtual {v14, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v13, v12}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 248
    :catch_0
    move-exception v12

    goto :goto_1

    .line 228
    :cond_3
    const/4 v6, 0x0

    .line 229
    .restart local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/client/metrics/BasicMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    sget-object v13, Lcom/amazon/client/metrics/MetricEventType;->AGGREGATING:Lcom/amazon/client/metrics/MetricEventType;

    invoke-virtual {v12, v13}, Lcom/amazon/client/metrics/MetricEventType;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_4

    .line 231
    new-instance v6, Lcom/amazon/client/metrics/DataPoint;

    .end local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {v11}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/amazon/client/metrics/AggregatingTimer;

    invoke-virtual {v13}, Lcom/amazon/client/metrics/AggregatingTimer;->getElapsedTime()D

    move-result-wide v13

    invoke-static {v13, v14}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v14

    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/amazon/client/metrics/AggregatingTimer;

    invoke-virtual {v13}, Lcom/amazon/client/metrics/AggregatingTimer;->getSamples()I

    move-result v13

    sget-object v15, Lcom/amazon/client/metrics/DataPointType;->TI:Lcom/amazon/client/metrics/DataPointType;

    invoke-direct {v6, v12, v14, v13, v15}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 247
    .restart local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    :goto_2
    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 251
    .end local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    :catch_1
    move-exception v12

    goto/16 :goto_1

    .line 235
    .restart local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    :cond_4
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/client/metrics/BasicMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    sget-object v13, Lcom/amazon/client/metrics/MetricEventType;->AVERAGING:Lcom/amazon/client/metrics/MetricEventType;

    invoke-virtual {v12, v13}, Lcom/amazon/client/metrics/MetricEventType;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_5

    .line 238
    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/client/metrics/AggregatingTimer;

    invoke-virtual {v12}, Lcom/amazon/client/metrics/AggregatingTimer;->getElapsedTime()D

    move-result-wide v13

    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/client/metrics/AggregatingTimer;

    invoke-virtual {v12}, Lcom/amazon/client/metrics/AggregatingTimer;->getSamples()I

    move-result v12

    int-to-double v15, v12

    div-double v1, v13, v15

    .line 239
    .local v1, "averageElapsedTime":D
    const/4 v10, 0x1

    .line 240
    .local v10, "samples":I
    new-instance v6, Lcom/amazon/client/metrics/DataPoint;

    .end local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {v11}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-static {v1, v2}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v13

    sget-object v14, Lcom/amazon/client/metrics/DataPointType;->TI:Lcom/amazon/client/metrics/DataPointType;

    invoke-direct {v6, v12, v13, v10, v14}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 242
    .restart local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    goto :goto_2

    .line 243
    .end local v1    # "averageElapsedTime":D
    .end local v10    # "samples":I
    :cond_5
    new-instance v12, Ljava/lang/IllegalArgumentException;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v14, "Unknown Metric event type. Metric event type: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/client/metrics/BasicMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v12
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 257
    .end local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    .end local v11    # "timer":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/client/metrics/AggregatingTimer;>;"
    :cond_6
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringDiscreteValues:Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_3
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_7

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 258
    .local v8, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    new-instance v6, Lcom/amazon/client/metrics/DataPoint;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/List;

    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/amazon/client/metrics/BasicMetricEvent;->listToString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v13

    sget-object v14, Lcom/amazon/client/metrics/DataPointType;->DV:Lcom/amazon/client/metrics/DataPointType;

    invoke-direct {v6, v12, v13, v5, v14}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 260
    .restart local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 264
    .end local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    .end local v8    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    :cond_7
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringClickstreamValues:Ljava/util/Map;

    invoke-interface {v12}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v12

    invoke-interface {v12}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_4
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_8

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map$Entry;

    .line 265
    .local v7, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lcom/amazon/client/metrics/DataPoint;

    invoke-interface {v7}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    invoke-interface {v7}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    sget-object v14, Lcom/amazon/client/metrics/DataPointType;->CK:Lcom/amazon/client/metrics/DataPointType;

    invoke-direct {v6, v12, v13, v5, v14}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    .line 267
    .restart local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 270
    .end local v6    # "dp":Lcom/amazon/client/metrics/DataPoint;
    .end local v7    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_8
    return-object v4
.end method

.method public getMetricEventType()Lcom/amazon/client/metrics/MetricEventType;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    return-object v0
.end method

.method public getProgram()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mProgram:Ljava/lang/String;

    return-object v0
.end method

.method public getSource()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mSource:Ljava/lang/String;

    return-object v0
.end method

.method public hasDataPoints()Z
    .locals 1

    .prologue
    .line 193
    invoke-virtual {p0}, Lcom/amazon/client/metrics/BasicMetricEvent;->getAsDataPoints()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public incrementCounter(Ljava/lang/String;D)V
    .locals 5
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "toAdd"    # D

    .prologue
    .line 102
    invoke-static {p2, p3}, Lcom/amazon/client/metrics/DoubleValidator;->validateDouble(D)V

    .line 103
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateString(Ljava/lang/String;)V

    .line 104
    const-wide/16 v0, 0x0

    .line 105
    .local v0, "oldValue":D
    iget-object v2, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mCounters:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 106
    iget-object v2, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mCounters:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Double;

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    .line 108
    :cond_0
    iget-object v2, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mCounters:Ljava/util/Map;

    add-double v3, v0, p2

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-interface {v2, p1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    return-void
.end method

.method public removeCounter(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mCounters:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    return-void
.end method

.method public removeString(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mStringDiscreteValues:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 175
    return-void
.end method

.method public removeTimer(Ljava/lang/String;)V
    .locals 1
    .param p1, "timer"    # Ljava/lang/String;

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mTimers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    return-void
.end method

.method public restoreFromMap(Ljava/util/Map;)V
    .locals 7
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

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 423
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v4, "Program"

    invoke-interface {p1, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    const-string/jumbo v4, "Source"

    invoke-interface {p1, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    const-string/jumbo v4, "Type"

    invoke-interface {p1, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    const-string/jumbo v4, "AllowRunning"

    invoke-interface {p1, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    const-string/jumbo v4, "Datapoints"

    invoke-interface {p1, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 428
    :cond_0
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v5, "Map doesn\'t capture a MetricEvent"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 430
    :cond_1
    const-string/jumbo v4, "Program"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iput-object v4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mProgram:Ljava/lang/String;

    .line 431
    const-string/jumbo v4, "Source"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iput-object v4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mSource:Ljava/lang/String;

    .line 432
    const-string/jumbo v4, "Type"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/client/metrics/MetricEventType;->valueOf(Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    .line 433
    const-string/jumbo v4, "1"

    const-string/jumbo v5, "AllowRunning"

    invoke-interface {p1, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 434
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mAllowRunningTimers:Z

    .line 439
    :goto_0
    const-string/jumbo v4, "Datapoints"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 440
    .local v0, "datapointString":Ljava/lang/String;
    const-string/jumbo v4, ""

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 441
    const-string/jumbo v4, "\t"

    invoke-virtual {v0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 442
    .local v1, "datapoints":[Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v4, v1

    if-ge v2, v4, :cond_3

    .line 444
    :try_start_0
    aget-object v4, v1, v2

    invoke-virtual {p0, v4}, Lcom/amazon/client/metrics/BasicMetricEvent;->convertStringToDataPoint(Ljava/lang/String;)Lcom/amazon/client/metrics/DataPoint;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/amazon/client/metrics/BasicMetricEvent;->addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V
    :try_end_0
    .catch Lcom/amazon/client/metrics/MetricsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 442
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 436
    .end local v0    # "datapointString":Ljava/lang/String;
    .end local v1    # "datapoints":[Ljava/lang/String;
    .end local v2    # "i":I
    :cond_2
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mAllowRunningTimers:Z

    goto :goto_0

    .line 445
    .restart local v0    # "datapointString":Ljava/lang/String;
    .restart local v1    # "datapoints":[Ljava/lang/String;
    .restart local v2    # "i":I
    :catch_0
    move-exception v3

    .line 446
    .local v3, "m":Lcom/amazon/client/metrics/MetricsException;
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Unable to restore, invalid datapoint string: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    aget-object v6, v1, v2

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4

    .line 451
    .end local v1    # "datapoints":[Ljava/lang/String;
    .end local v2    # "i":I
    .end local v3    # "m":Lcom/amazon/client/metrics/MetricsException;
    :cond_3
    return-void
.end method

.method public saveToMap(Ljava/util/Map;)V
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
    .line 407
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v3, "Program"

    iget-object v4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mProgram:Ljava/lang/String;

    invoke-interface {p1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 408
    const-string/jumbo v3, "Source"

    iget-object v4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mSource:Ljava/lang/String;

    invoke-interface {p1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 409
    const-string/jumbo v3, "Type"

    iget-object v4, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    invoke-virtual {v4}, Lcom/amazon/client/metrics/MetricEventType;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 410
    const-string/jumbo v4, "AllowRunning"

    iget-boolean v3, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mAllowRunningTimers:Z

    if-eqz v3, :cond_0

    const-string/jumbo v3, "1"

    :goto_0
    invoke-interface {p1, v4, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 412
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 413
    .local v2, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Lcom/amazon/client/metrics/BasicMetricEvent;->getAsDataPoints()Ljava/util/List;

    move-result-object v0

    .line 414
    .local v0, "dps":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 415
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/client/metrics/DataPoint;

    invoke-virtual {p0, v3}, Lcom/amazon/client/metrics/BasicMetricEvent;->convertDataPointToString(Lcom/amazon/client/metrics/DataPoint;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 416
    const-string/jumbo v3, "\t"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 414
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 410
    .end local v0    # "dps":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    .end local v1    # "i":I
    .end local v2    # "sb":Ljava/lang/StringBuilder;
    :cond_0
    const-string/jumbo v3, "0"

    goto :goto_0

    .line 418
    .restart local v0    # "dps":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    .restart local v1    # "i":I
    .restart local v2    # "sb":Ljava/lang/StringBuilder;
    :cond_1
    const-string/jumbo v3, "Datapoints"

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {p1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 419
    return-void
.end method

.method public startTimer(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 131
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateString(Ljava/lang/String;)V

    .line 132
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->getOrCreateTimer(Ljava/lang/String;)Lcom/amazon/client/metrics/AggregatingTimer;

    move-result-object v0

    .line 133
    .local v0, "timer":Lcom/amazon/client/metrics/AggregatingTimer;
    invoke-virtual {v0}, Lcom/amazon/client/metrics/AggregatingTimer;->startTimer()V

    .line 134
    iget-object v1, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mTimers:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 135
    return-void
.end method

.method public stopTimer(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 139
    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/BasicMetricEvent;->validateString(Ljava/lang/String;)V

    .line 140
    iget-object v1, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mTimers:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/AggregatingTimer;

    .line 141
    .local v0, "timer":Lcom/amazon/client/metrics/AggregatingTimer;
    if-nez v0, :cond_0

    .line 145
    :goto_0
    return-void

    .line 144
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/client/metrics/AggregatingTimer;->stopTimer()V

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 394
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 395
    .local v2, "sb":Ljava/lang/StringBuilder;
    iget-object v3, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mProgram:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 396
    iget-object v3, p0, Lcom/amazon/client/metrics/BasicMetricEvent;->mSource:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 397
    invoke-virtual {p0}, Lcom/amazon/client/metrics/BasicMetricEvent;->getAsDataPoints()Ljava/util/List;

    move-result-object v0

    .line 398
    .local v0, "dps":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v1, v3, :cond_0

    .line 399
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/client/metrics/DataPoint;

    invoke-virtual {v3}, Lcom/amazon/client/metrics/DataPoint;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 398
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 401
    :cond_0
    const-string/jumbo v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 402
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
