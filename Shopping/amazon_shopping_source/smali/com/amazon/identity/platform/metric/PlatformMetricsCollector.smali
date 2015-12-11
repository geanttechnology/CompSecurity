.class public interface abstract Lcom/amazon/identity/platform/metric/PlatformMetricsCollector;
.super Ljava/lang/Object;
.source "PlatformMetricsCollector.java"


# virtual methods
.method public abstract createPeriodicTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
.end method

.method public abstract createTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
.end method

.method public varargs abstract increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
.end method

.method public abstract incrementCounter(Ljava/lang/String;)V
.end method

.method public abstract incrementCounter(Ljava/lang/String;D)V
.end method

.method public abstract incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation
.end method

.method public varargs abstract incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
.end method

.method public abstract incrementStateMetricCounter(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract recordEvent()V
.end method

.method public abstract recordMetricTimerEvent(Ljava/lang/String;Ljava/lang/String;J)V
.end method
