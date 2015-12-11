.class Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;
.super Ljava/lang/Thread;
.source "HarvestHeartbeat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalSendData(JJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

.field final synthetic val$lastHarvestTime:J

.field final synthetic val$sessionStartTime:J

.field final synthetic val$thisTime:J


# direct methods
.method constructor <init>(Lcom/newrelic/agent/android/background/HarvestHeartbeat;JJJ)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    iput-wide p2, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->val$sessionStartTime:J

    iput-wide p4, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->val$thisTime:J

    iput-wide p6, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->val$lastHarvestTime:J

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 13

    .prologue
    .line 218
    :try_start_0
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$000(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_4

    .line 220
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvesting:Z
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$100(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-eqz v0, :cond_0

    .line 222
    :try_start_2
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->harvestCond:Ljava/util/concurrent/locks/Condition;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$200(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_0

    .line 224
    :catch_0
    move-exception v8

    .line 225
    .local v8, "e":Ljava/lang/InterruptedException;
    :try_start_3
    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;
    invoke-static {}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$300()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    const-string v1, "Interrupted waiting for harvest to finish"

    invoke-interface {v0, v1, v8}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 231
    :try_start_4
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$000(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_4

    .line 250
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThreadLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$700(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 251
    :try_start_5
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    const/4 v2, 0x0

    # setter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;
    invoke-static {v0, v2}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$802(Lcom/newrelic/agent/android/background/HarvestHeartbeat;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 252
    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 254
    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;
    invoke-static {}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$300()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    const-string v1, "Background thread has completed"

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V

    .line 256
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # invokes: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->afterStop()V
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$900(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)V

    .line 258
    .end local v8    # "e":Ljava/lang/InterruptedException;
    :goto_1
    return-void

    .line 252
    .restart local v8    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v0

    :try_start_6
    monitor-exit v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    throw v0

    .line 231
    .end local v8    # "e":Ljava/lang/InterruptedException;
    :cond_0
    :try_start_7
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$000(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 234
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getAndClearTransactionData()Ljava/util/List;

    move-result-object v3

    .line 235
    .local v3, "transactions":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getAndClearErrorData()Ljava/util/List;

    move-result-object v4

    .line 237
    .local v4, "errors":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v9

    .line 238
    .local v9, "sessionEndTime":J
    iget-wide v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->val$sessionStartTime:J

    sub-long v0, v9, v0

    long-to-double v0, v0

    const-wide v11, 0x41cdcd6500000000L    # 1.0E9

    div-double v6, v0, v11

    .line 239
    .local v6, "sessionTime":D
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->connectivitySampler:Lcom/newrelic/agent/android/util/ConnectivitySampler;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$400(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Lcom/newrelic/agent/android/util/ConnectivitySampler;

    move-result-object v0

    invoke-interface {v0}, Lcom/newrelic/agent/android/util/ConnectivitySampler;->sample()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 240
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->api1:Lcom/newrelic/agent/android/api/v1/NewRelicApi;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$600(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Lcom/newrelic/agent/android/api/v1/NewRelicApi;

    move-result-object v0

    iget-wide v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->val$thisTime:J

    iget-wide v11, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->val$lastHarvestTime:J

    sub-long/2addr v1, v11

    long-to-double v1, v1

    const-wide v11, 0x408f400000000000L    # 1000.0

    div-double/2addr v1, v11

    iget-object v5, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->machineMeasurementsSampler:Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;
    invoke-static {v5}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$500(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;

    move-result-object v5

    invoke-interface {v5}, Lcom/newrelic/agent/android/util/MachineMeasurementsSampler;->sample()Lcom/newrelic/agent/android/api/common/MachineMeasurements;

    move-result-object v5

    invoke-interface/range {v0 .. v7}, Lcom/newrelic/agent/android/api/v1/NewRelicApi;->sendData(DLjava/util/Collection;Ljava/util/Collection;Lcom/newrelic/agent/android/api/common/MachineMeasurements;D)V

    .line 243
    invoke-static {}, Lcom/newrelic/agent/android/stats/StatsEngine;->reset()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    .line 250
    :cond_1
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThreadLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$700(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 251
    :try_start_8
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    const/4 v2, 0x0

    # setter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;
    invoke-static {v0, v2}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$802(Lcom/newrelic/agent/android/background/HarvestHeartbeat;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 252
    monitor-exit v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    .line 254
    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;
    invoke-static {}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$300()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    const-string v1, "Background thread has completed"

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V

    .line 256
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # invokes: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->afterStop()V
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$900(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)V

    goto :goto_1

    .line 231
    .end local v3    # "transactions":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    .end local v4    # "errors":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    .end local v6    # "sessionTime":D
    .end local v9    # "sessionEndTime":J
    :catchall_1
    move-exception v0

    :try_start_9
    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->lock:Ljava/util/concurrent/locks/ReentrantLock;
    invoke-static {v1}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$000(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/util/concurrent/locks/ReentrantLock;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_1
    .catchall {:try_start_9 .. :try_end_9} :catchall_4

    .line 246
    :catch_1
    move-exception v8

    .line 247
    .local v8, "e":Ljava/lang/Exception;
    :try_start_a
    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;
    invoke-static {}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$300()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    const-string v1, "Failed to send final post"

    invoke-interface {v0, v1, v8}, Lcom/newrelic/agent/android/logging/AgentLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_4

    .line 250
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThreadLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$700(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 251
    :try_start_b
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    const/4 v2, 0x0

    # setter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;
    invoke-static {v0, v2}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$802(Lcom/newrelic/agent/android/background/HarvestHeartbeat;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 252
    monitor-exit v1
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_3

    .line 254
    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;
    invoke-static {}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$300()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    const-string v1, "Background thread has completed"

    invoke-interface {v0, v1}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V

    .line 256
    iget-object v0, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # invokes: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->afterStop()V
    invoke-static {v0}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$900(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)V

    goto/16 :goto_1

    .line 252
    .end local v8    # "e":Ljava/lang/Exception;
    .restart local v3    # "transactions":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    .restart local v4    # "errors":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    .restart local v6    # "sessionTime":D
    .restart local v9    # "sessionEndTime":J
    :catchall_2
    move-exception v0

    :try_start_c
    monitor-exit v1
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_2

    throw v0

    .end local v3    # "transactions":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/TransactionData;>;"
    .end local v4    # "errors":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/api/common/ErrorData;>;"
    .end local v6    # "sessionTime":D
    .end local v9    # "sessionEndTime":J
    .restart local v8    # "e":Ljava/lang/Exception;
    :catchall_3
    move-exception v0

    :try_start_d
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_3

    throw v0

    .line 250
    .end local v8    # "e":Ljava/lang/Exception;
    :catchall_4
    move-exception v0

    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThreadLock:Ljava/lang/Object;
    invoke-static {v1}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$700(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 251
    :try_start_e
    iget-object v2, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    const/4 v5, 0x0

    # setter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->finalThread:Ljava/lang/Thread;
    invoke-static {v2, v5}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$802(Lcom/newrelic/agent/android/background/HarvestHeartbeat;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 252
    monitor-exit v1
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_5

    .line 254
    # getter for: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->log:Lcom/newrelic/agent/android/logging/AgentLog;
    invoke-static {}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$300()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v1

    const-string v2, "Background thread has completed"

    invoke-interface {v1, v2}, Lcom/newrelic/agent/android/logging/AgentLog;->info(Ljava/lang/String;)V

    .line 256
    iget-object v1, p0, Lcom/newrelic/agent/android/background/HarvestHeartbeat$2;->this$0:Lcom/newrelic/agent/android/background/HarvestHeartbeat;

    # invokes: Lcom/newrelic/agent/android/background/HarvestHeartbeat;->afterStop()V
    invoke-static {v1}, Lcom/newrelic/agent/android/background/HarvestHeartbeat;->access$900(Lcom/newrelic/agent/android/background/HarvestHeartbeat;)V

    throw v0

    .line 252
    :catchall_5
    move-exception v0

    :try_start_f
    monitor-exit v1
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_5

    throw v0
.end method
