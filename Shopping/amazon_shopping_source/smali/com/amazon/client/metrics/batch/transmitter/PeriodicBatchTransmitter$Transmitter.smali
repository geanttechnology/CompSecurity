.class public Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;
.super Ljava/lang/Object;
.source "PeriodicBatchTransmitter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "Transmitter"
.end annotation


# instance fields
.field private final mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic this$0:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;)V
    .locals 2

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->this$0:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 76
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 81
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_0

    .line 82
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v0

    const-string/jumbo v1, "Transmitter.run"

    const-string/jumbo v2, "Shutdown invoked."

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 91
    :goto_0
    return-void

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->this$0:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;

    invoke-virtual {v0, v3}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->transmitBatches(Z)V

    .line 89
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v0

    const-string/jumbo v1, "Transmitter.run"

    const-string/jumbo v2, "Rescheduling next transmission."

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 90
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->this$0:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;

    # getter for: Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    invoke-static {v0}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->access$200(Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;)Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->this$0:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;

    # getter for: Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mTransmitter:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;
    invoke-static {v1}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->access$100(Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;)Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->this$0:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;

    iget-object v2, v2, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v2}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getTransmissionPeriodMillis()J

    move-result-wide v2

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    goto :goto_0
.end method

.method public shutdown()V
    .locals 2

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 95
    return-void
.end method
