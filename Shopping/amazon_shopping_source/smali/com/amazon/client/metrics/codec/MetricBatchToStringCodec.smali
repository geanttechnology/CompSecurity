.class public Lcom/amazon/client/metrics/codec/MetricBatchToStringCodec;
.super Ljava/lang/Object;
.source "MetricBatchToStringCodec.java"

# interfaces
.implements Lcom/amazon/client/metrics/codec/MetricBatchCodec;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public encode(Lcom/amazon/client/metrics/MetricBatch;)[B
    .locals 3
    .param p1, "metricBatch"    # Lcom/amazon/client/metrics/MetricBatch;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dp/framework/CodecException;
        }
    .end annotation

    .prologue
    .line 26
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricBatch;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "UTF-8"

    invoke-virtual {v1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 27
    :catch_0
    move-exception v0

    .line 28
    .local v0, "use":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Lcom/dp/framework/CodecException;

    invoke-direct {v1, v0}, Lcom/dp/framework/CodecException;-><init>(Ljava/lang/Exception;)V

    throw v1
.end method
