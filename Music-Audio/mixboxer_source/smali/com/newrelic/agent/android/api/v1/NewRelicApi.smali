.class public interface abstract Lcom/newrelic/agent/android/api/v1/NewRelicApi;
.super Ljava/lang/Object;
.source "NewRelicApi.java"


# virtual methods
.method public abstract getDeviceInfo()Lcom/newrelic/agent/android/api/v1/DeviceInfo;
.end method

.method public abstract reset()V
.end method

.method public abstract sendConnect()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/InterruptedIOException;,
            Lcom/newrelic/agent/android/transport/TransportException;
        }
    .end annotation
.end method

.method public abstract sendData(DLjava/util/Collection;Ljava/util/Collection;Lcom/newrelic/agent/android/api/common/MachineMeasurements;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(D",
            "Ljava/util/Collection",
            "<",
            "Lcom/newrelic/agent/android/api/common/TransactionData;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/newrelic/agent/android/api/common/ErrorData;",
            ">;",
            "Lcom/newrelic/agent/android/api/common/MachineMeasurements;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/InterruptedIOException;,
            Lcom/newrelic/agent/android/transport/TransportException;
        }
    .end annotation
.end method

.method public abstract sendData(DLjava/util/Collection;Ljava/util/Collection;Lcom/newrelic/agent/android/api/common/MachineMeasurements;D)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(D",
            "Ljava/util/Collection",
            "<",
            "Lcom/newrelic/agent/android/api/common/TransactionData;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/newrelic/agent/android/api/common/ErrorData;",
            ">;",
            "Lcom/newrelic/agent/android/api/common/MachineMeasurements;",
            "D)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/InterruptedIOException;,
            Lcom/newrelic/agent/android/transport/TransportException;
        }
    .end annotation
.end method

.method public abstract setConnectionState(Lcom/newrelic/agent/android/api/common/ConnectionState;)V
.end method

.method public abstract setLocation(Lcom/newrelic/agent/android/instrumentation/Location;)V
.end method
