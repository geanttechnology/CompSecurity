.class Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;
.super Ljava/lang/Object;
.source "PriorityQueue.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/session/PriorityQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SweeperRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/analytics/session/PriorityQueue;


# direct methods
.method private constructor <init>(Lcom/amazon/analytics/session/PriorityQueue;)V
    .locals 0

    .prologue
    .line 172
    iput-object p1, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/session/PriorityQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/session/PriorityQueue;
    .param p2, "x1"    # Lcom/amazon/analytics/session/PriorityQueue$1;

    .prologue
    .line 172
    invoke-direct {p0, p1}, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;-><init>(Lcom/amazon/analytics/session/PriorityQueue;)V

    return-void
.end method

.method private canContinue(JLcom/amazon/analytics/util/Message;)Z
    .locals 8
    .param p1, "initialTime"    # J
    .param p3, "head"    # Lcom/amazon/analytics/util/Message;

    .prologue
    const/4 v4, 0x0

    .line 183
    if-nez p3, :cond_1

    .line 184
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v5

    const-string/jumbo v6, "Cannot continue.... head is empty"

    invoke-virtual {v5, v6}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 198
    :cond_0
    :goto_0
    return v4

    .line 188
    :cond_1
    invoke-virtual {p3}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v5

    const-string/jumbo v6, "TimeStamp"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    .line 189
    .local v3, "timestamp":Ljava/lang/Long;
    if-nez v3, :cond_2

    .line 190
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v5

    const-string/jumbo v6, "Cannot continue.... timestamp is empty"

    invoke-virtual {v5, v6}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 195
    :cond_2
    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    sub-long v5, p1, v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    .line 196
    .local v0, "delta":Ljava/lang/Long;
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Can we continue???? delta is "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " message timestamp "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 197
    iget-object v5, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # invokes: Lcom/amazon/analytics/session/PriorityQueue;->getSweeperDelay()J
    invoke-static {v5}, Lcom/amazon/analytics/session/PriorityQueue;->access$200(Lcom/amazon/analytics/session/PriorityQueue;)J

    move-result-wide v1

    .line 198
    .local v1, "sweeperDelay":J
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    cmp-long v5, v5, v1

    if-ltz v5, :cond_0

    const/4 v4, 0x1

    goto :goto_0
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    .line 208
    const/4 v1, 0x0

    .line 213
    .local v1, "currHead":Lcom/amazon/analytics/util/Message;
    :goto_0
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {v7}, Lcom/amazon/analytics/session/PriorityQueue;->access$300(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/locks/Lock;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 216
    if-eqz v1, :cond_0

    .line 218
    :try_start_0
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->messageQueue:Ljava/util/concurrent/BlockingQueue;
    invoke-static {v7}, Lcom/amazon/analytics/session/PriorityQueue;->access$400(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/BlockingQueue;

    move-result-object v7

    invoke-interface {v7, v1}, Ljava/util/concurrent/BlockingQueue;->put(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_4

    .line 224
    :cond_0
    :goto_1
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v7

    const-string/jumbo v8, "Running sweeper"

    invoke-virtual {v7, v8}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 226
    :try_start_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 229
    .local v4, "initialTime":J
    :goto_2
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->messageQueue:Ljava/util/concurrent/BlockingQueue;
    invoke-static {v7}, Lcom/amazon/analytics/session/PriorityQueue;->access$400(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/BlockingQueue;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/concurrent/BlockingQueue;->peek()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/analytics/util/Message;

    invoke-direct {p0, v4, v5, v7}, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->canContinue(JLcom/amazon/analytics/util/Message;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v7

    if-eqz v7, :cond_2

    .line 231
    const/4 v3, 0x0

    .line 233
    .local v3, "head":Lcom/amazon/analytics/util/Message;
    :try_start_2
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->messageQueue:Ljava/util/concurrent/BlockingQueue;
    invoke-static {v7}, Lcom/amazon/analytics/session/PriorityQueue;->access$400(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/BlockingQueue;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/concurrent/BlockingQueue;->take()Ljava/lang/Object;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Lcom/amazon/analytics/util/Message;

    move-object v3, v0
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 238
    :goto_3
    if-eqz v3, :cond_1

    .line 239
    :try_start_3
    invoke-virtual {v3}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v7

    const-string/jumbo v8, "TimeStamp"

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Long;

    .line 240
    .local v6, "timestamp":Ljava/lang/Long;
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Dequeing message with timestamp "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 241
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Remaining queue size "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->messageQueue:Ljava/util/concurrent/BlockingQueue;
    invoke-static {v9}, Lcom/amazon/analytics/session/PriorityQueue;->access$400(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/BlockingQueue;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/concurrent/BlockingQueue;->size()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 242
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # invokes: Lcom/amazon/analytics/session/PriorityQueue;->doPublish(Lcom/amazon/analytics/util/Message;)V
    invoke-static {v7, v3}, Lcom/amazon/analytics/session/PriorityQueue;->access$500(Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/util/Message;)V

    .line 246
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->lastMessagePushTime:Ljava/util/concurrent/atomic/AtomicLong;
    invoke-static {v7}, Lcom/amazon/analytics/session/PriorityQueue;->access$600(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/atomic/AtomicLong;

    move-result-object v7

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_2

    .line 251
    .end local v6    # "timestamp":Ljava/lang/Long;
    :catch_0
    move-exception v2

    .line 252
    .local v2, "e":Ljava/lang/Exception;
    :try_start_4
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v7

    const-string/jumbo v8, "Error dequeuing message"

    invoke-virtual {v7, v8, v2}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_2

    .line 255
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v3    # "head":Lcom/amazon/analytics/util/Message;
    .end local v4    # "initialTime":J
    :catch_1
    move-exception v2

    .line 256
    .restart local v2    # "e":Ljava/lang/Exception;
    :try_start_5
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v7

    const-string/jumbo v8, "An error occurred in the sweeper"

    invoke-virtual {v7, v8, v2}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 258
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {v7}, Lcom/amazon/analytics/session/PriorityQueue;->access$300(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/locks/Lock;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 261
    .end local v2    # "e":Ljava/lang/Exception;
    :goto_4
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v7

    const-string/jumbo v8, "Finished running through queue... Waiting for message maturity"

    invoke-virtual {v7, v8}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 263
    :try_start_6
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->messageQueue:Ljava/util/concurrent/BlockingQueue;
    invoke-static {v7}, Lcom/amazon/analytics/session/PriorityQueue;->access$400(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/BlockingQueue;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/concurrent/BlockingQueue;->take()Ljava/lang/Object;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Lcom/amazon/analytics/util/Message;

    move-object v1, v0
    :try_end_6
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_2

    .line 269
    :goto_5
    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v7

    if-eqz v7, :cond_3

    .line 270
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v7

    const-string/jumbo v8, "Sweeper thread is being interrupted. This will stop the processing of session events"

    invoke-virtual {v7, v8}, Lcom/amazon/device/analytics/log/Logger;->w(Ljava/lang/String;)V

    .line 277
    return-void

    .line 248
    .restart local v3    # "head":Lcom/amazon/analytics/util/Message;
    .restart local v4    # "initialTime":J
    :cond_1
    :try_start_7
    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/session/PriorityQueue;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v7

    const-string/jumbo v8, "breaking out of loop"

    invoke-virtual {v7, v8}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_0
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 258
    .end local v3    # "head":Lcom/amazon/analytics/util/Message;
    :cond_2
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {v7}, Lcom/amazon/analytics/session/PriorityQueue;->access$300(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/locks/Lock;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_4

    .end local v4    # "initialTime":J
    :catchall_0
    move-exception v7

    iget-object v8, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # getter for: Lcom/amazon/analytics/session/PriorityQueue;->queueLock:Ljava/util/concurrent/locks/Lock;
    invoke-static {v8}, Lcom/amazon/analytics/session/PriorityQueue;->access$300(Lcom/amazon/analytics/session/PriorityQueue;)Ljava/util/concurrent/locks/Lock;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v7

    .line 275
    :cond_3
    iget-object v7, p0, Lcom/amazon/analytics/session/PriorityQueue$SweeperRunnable;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    # invokes: Lcom/amazon/analytics/session/PriorityQueue;->waitForMessageMaturity(Lcom/amazon/analytics/util/Message;)V
    invoke-static {v7, v1}, Lcom/amazon/analytics/session/PriorityQueue;->access$700(Lcom/amazon/analytics/session/PriorityQueue;Lcom/amazon/analytics/util/Message;)V

    goto/16 :goto_0

    .line 264
    :catch_2
    move-exception v7

    goto :goto_5

    .line 234
    .restart local v3    # "head":Lcom/amazon/analytics/util/Message;
    .restart local v4    # "initialTime":J
    :catch_3
    move-exception v7

    goto/16 :goto_3

    .line 219
    .end local v3    # "head":Lcom/amazon/analytics/util/Message;
    .end local v4    # "initialTime":J
    :catch_4
    move-exception v7

    goto/16 :goto_1
.end method
