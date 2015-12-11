.class public Lcom/amazon/client/metrics/NullMetricEvent;
.super Ljava/lang/Object;
.source "NullMetricEvent.java"

# interfaces
.implements Lcom/amazon/client/metrics/MetricEvent;


# instance fields
.field private final mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

.field private final mProgram:Ljava/lang/String;

.field private final mSource:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 32
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    .line 33
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V
    .locals 0
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/amazon/client/metrics/NullMetricEvent;->mProgram:Ljava/lang/String;

    .line 37
    iput-object p2, p0, Lcom/amazon/client/metrics/NullMetricEvent;->mSource:Ljava/lang/String;

    .line 38
    iput-object p3, p0, Lcom/amazon/client/metrics/NullMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    .line 39
    return-void
.end method


# virtual methods
.method public addCounter(Ljava/lang/String;D)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D

    .prologue
    .line 59
    return-void
.end method

.method public addDataPoint(Lcom/amazon/client/metrics/DataPoint;)V
    .locals 0
    .param p1, "dataPoint"    # Lcom/amazon/client/metrics/DataPoint;

    .prologue
    .line 129
    return-void
.end method

.method public addDataPoints(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 134
    .local p1, "dataPointList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    return-void
.end method

.method public addString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 84
    return-void
.end method

.method public addTimer(Ljava/lang/String;D)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D

    .prologue
    .line 69
    return-void
.end method

.method public addTimer(Ljava/lang/String;DI)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # D
    .param p4, "repeat"    # I

    .prologue
    .line 124
    return-void
.end method

.method public appendString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 89
    return-void
.end method

.method public clear()V
    .locals 0

    .prologue
    .line 119
    return-void
.end method

.method public getAsDataPoints()Ljava/util/List;
    .locals 2
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
    .line 98
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    return-object v0
.end method

.method public getMetricEventType()Lcom/amazon/client/metrics/MetricEventType;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/client/metrics/NullMetricEvent;->mMetricEventType:Lcom/amazon/client/metrics/MetricEventType;

    return-object v0
.end method

.method public getProgram()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/client/metrics/NullMetricEvent;->mProgram:Ljava/lang/String;

    return-object v0
.end method

.method public getSource()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/client/metrics/NullMetricEvent;->mSource:Ljava/lang/String;

    return-object v0
.end method

.method public hasDataPoints()Z
    .locals 1

    .prologue
    .line 93
    const/4 v0, 0x0

    return v0
.end method

.method public incrementCounter(Ljava/lang/String;D)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "toAdd"    # D

    .prologue
    .line 64
    return-void
.end method

.method public removeCounter(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 104
    return-void
.end method

.method public removeString(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 109
    return-void
.end method

.method public removeTimer(Ljava/lang/String;)V
    .locals 0
    .param p1, "timer"    # Ljava/lang/String;

    .prologue
    .line 114
    return-void
.end method

.method public restoreFromMap(Ljava/util/Map;)V
    .locals 0
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
    .line 144
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    return-void
.end method

.method public saveToMap(Ljava/util/Map;)V
    .locals 0
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
    .line 139
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    return-void
.end method

.method public startTimer(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 74
    return-void
.end method

.method public stopTimer(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 79
    return-void
.end method
