.class Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue$1;
.super Ljava/lang/Object;
.source "NonVolatileBoundedByteArrayQueue.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->readPersistedData()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ljava/io/File;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;


# direct methods
.method constructor <init>(Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue$1;->this$0:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Ljava/io/File;Ljava/io/File;)I
    .locals 12
    .param p1, "file1"    # Ljava/io/File;
    .param p2, "file2"    # Ljava/io/File;

    .prologue
    const-wide/16 v10, 0x0

    const/4 v9, 0x0

    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    .line 95
    new-instance v1, Ljava/lang/Long;

    invoke-direct {v1, v10, v11}, Ljava/lang/Long;-><init>(J)V

    .line 97
    .local v1, "file1TimeStamp":Ljava/lang/Long;
    :try_start_0
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 105
    :goto_0
    new-instance v2, Ljava/lang/Long;

    invoke-direct {v2, v10, v11}, Ljava/lang/Long;-><init>(J)V

    .line 107
    .local v2, "file2TimeStamp":Ljava/lang/Long;
    :try_start_1
    invoke-virtual {p2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v2

    .line 114
    :goto_1
    invoke-virtual {v1, v2}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v3

    return v3

    .line 99
    .end local v2    # "file2TimeStamp":Ljava/lang/Long;
    :catch_0
    move-exception v0

    .line 100
    .local v0, "e":Ljava/lang/NumberFormatException;
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue$1;->this$0:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    iget-object v3, v3, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v3}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v3

    const-string/jumbo v4, "queueRead.NumberFormatException"

    invoke-interface {v3, v4, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 101
    # getter for: Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v3

    const-string/jumbo v4, "readPersistedData"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Unsupported file name format: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-array v6, v9, [Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 109
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    .restart local v2    # "file2TimeStamp":Ljava/lang/Long;
    :catch_1
    move-exception v0

    .line 110
    .restart local v0    # "e":Ljava/lang/NumberFormatException;
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue$1;->this$0:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    iget-object v3, v3, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v3}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v3

    const-string/jumbo v4, "queueRead.NumberFormatException"

    invoke-interface {v3, v4, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 111
    # getter for: Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v3

    const-string/jumbo v4, "readPersistedData"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Unsupported file name format: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-array v6, v9, [Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 93
    check-cast p1, Ljava/io/File;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Ljava/io/File;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue$1;->compare(Ljava/io/File;Ljava/io/File;)I

    move-result v0

    return v0
.end method
