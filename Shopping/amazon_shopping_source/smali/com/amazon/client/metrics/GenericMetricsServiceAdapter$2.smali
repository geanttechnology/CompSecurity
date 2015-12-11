.class Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$2;
.super Lcom/amazon/client/metrics/IMetricsService$Stub;
.source "GenericMetricsServiceAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$2;->this$0:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    invoke-direct {p0}, Lcom/amazon/client/metrics/IMetricsService$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public getRecordMetricsSetting()Z
    .locals 1

    .prologue
    .line 160
    const/4 v0, 0x1

    return v0
.end method

.method public record(ILjava/lang/String;Ljava/lang/String;JLjava/util/List;)V
    .locals 8
    .param p1, "priority"    # I
    .param p2, "program"    # Ljava/lang/String;
    .param p3, "source"    # Ljava/lang/String;
    .param p4, "timestamp"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "J",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPointEnvelope;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 139
    .local p6, "datapointEnvelopes":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPointEnvelope;>;"
    # getter for: Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v0

    const-string/jumbo v1, "record"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "[ "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " , "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " ]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 147
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$2;->this$0:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->getHandler()Landroid/os/Handler;

    move-result-object v7

    .line 148
    .local v7, "handler":Landroid/os/Handler;
    invoke-virtual {v7}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v6

    .line 150
    .local v6, "entryMsg":Landroid/os/Message;
    iput p1, v6, Landroid/os/Message;->arg1:I

    .line 152
    invoke-static {p6}, Lcom/amazon/client/metrics/DataPointEnvelope;->convertFromEnvelopes(Ljava/util/List;)Ljava/util/List;

    move-result-object v5

    .line 153
    .local v5, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    new-instance v0, Lcom/amazon/client/metrics/MetricEntry;

    move-wide v1, p4

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/client/metrics/MetricEntry;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    iput-object v0, v6, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 154
    invoke-virtual {v7, v6}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 155
    return-void
.end method
