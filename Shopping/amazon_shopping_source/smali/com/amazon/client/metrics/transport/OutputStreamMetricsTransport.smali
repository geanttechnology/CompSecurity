.class public Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;
.super Ljava/lang/Object;
.source "OutputStreamMetricsTransport.java"

# interfaces
.implements Lcom/amazon/client/metrics/transport/MetricsTransport;
.implements Lcom/amazon/client/metrics/transport/TransportStateNotifier;


# static fields
.field private static final TAG:Ljava/lang/String; = "Metrics:OutputStreamMetricsTransport"


# instance fields
.field private final mOutputStream:Ljava/io/OutputStream;


# direct methods
.method public constructor <init>(Ljava/io/OutputStream;)V
    .locals 0
    .param p1, "outputStream"    # Ljava/io/OutputStream;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;->mOutputStream:Ljava/io/OutputStream;

    .line 30
    return-void
.end method


# virtual methods
.method public close()V
    .locals 0

    .prologue
    .line 57
    return-void
.end method

.method public listenForTransportWarmed(Lcom/amazon/client/metrics/transport/TransportStateNotifier$TransportWarmedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/client/metrics/transport/TransportStateNotifier$TransportWarmedListener;

    .prologue
    .line 74
    return-void
.end method

.method public shutdown()V
    .locals 3

    .prologue
    .line 65
    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;->mOutputStream:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    :goto_0
    return-void

    .line 66
    :catch_0
    move-exception v0

    .line 67
    .local v0, "ioe":Ljava/io/IOException;
    const-string/jumbo v1, "Metrics:OutputStreamMetricsTransport"

    const-string/jumbo v2, "Unable to shutdown transport."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public transmit([BLcom/amazon/client/metrics/MetricEvent;)I
    .locals 3
    .param p1, "data"    # [B
    .param p2, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 42
    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;->mOutputStream:Ljava/io/OutputStream;

    invoke-virtual {v1, p1}, Ljava/io/OutputStream;->write([B)V

    .line 43
    iget-object v1, p0, Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;->mOutputStream:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 44
    const/4 v1, 0x1

    .line 47
    :goto_0
    return v1

    .line 45
    :catch_0
    move-exception v0

    .line 46
    .local v0, "ioe":Ljava/io/IOException;
    const-string/jumbo v1, "Metrics:OutputStreamMetricsTransport"

    const-string/jumbo v2, "Unable to transmit."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 47
    const/4 v1, 0x3

    goto :goto_0
.end method
