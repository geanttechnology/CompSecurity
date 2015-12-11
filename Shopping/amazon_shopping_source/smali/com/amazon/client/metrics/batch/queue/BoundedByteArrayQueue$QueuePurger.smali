.class Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;
.super Ljava/lang/Object;
.source "BoundedByteArrayQueue.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "QueuePurger"
.end annotation


# instance fields
.field private final mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic this$0:Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;)V
    .locals 2

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;->this$0:Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 127
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 132
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_0

    .line 133
    # getter for: Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v0

    const-string/jumbo v1, "QueuePurger.run"

    const-string/jumbo v2, "Shutdown invoked."

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 138
    :goto_0
    return-void

    .line 136
    :cond_0
    # getter for: Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v0

    const-string/jumbo v1, "QueuePurger.run"

    const-string/jumbo v2, "Purging expired batches."

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 137
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;->this$0:Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->purgeExpiredBatches()V

    goto :goto_0
.end method

.method public shutdown()V
    .locals 2

    .prologue
    .line 141
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 142
    return-void
.end method
