.class final Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;
.super Landroid/os/Handler;
.source "IntentTimeoutService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/service/IntentTimeoutService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "ServiceHandler"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/android/service/IntentTimeoutService;


# direct methods
.method public constructor <init>(Lcom/amazon/android/service/IntentTimeoutService;Landroid/os/Looper;)V
    .locals 0
    .param p2, "looper"    # Landroid/os/Looper;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    .line 78
    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 79
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 5
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 87
    iget-object v1, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/content/Intent;

    # invokes: Lcom/amazon/android/service/IntentTimeoutService;->handleIntent(Landroid/content/Intent;)V
    invoke-static {v1, v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$000(Lcom/amazon/android/service/IntentTimeoutService;Landroid/content/Intent;)V

    .line 89
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->timer:Ljava/util/Timer;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$100(Lcom/amazon/android/service/IntentTimeoutService;)Ljava/util/Timer;

    move-result-object v1

    monitor-enter v1

    .line 90
    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->timerCancelled:Z
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$200(Lcom/amazon/android/service/IntentTimeoutService;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 92
    monitor-exit v1

    .line 104
    :goto_0
    return-void

    .line 95
    :cond_0
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->latestStartId:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$300(Lcom/amazon/android/service/IntentTimeoutService;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v0

    iget v2, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v0, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 96
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$400(Lcom/amazon/android/service/IntentTimeoutService;)Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 97
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$400(Lcom/amazon/android/service/IntentTimeoutService;)Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->cancel()Z

    .line 98
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->timer:Ljava/util/Timer;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$100(Lcom/amazon/android/service/IntentTimeoutService;)Ljava/util/Timer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 99
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$400(Lcom/amazon/android/service/IntentTimeoutService;)Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->doStopSelf()V

    .line 101
    :cond_1
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    new-instance v2, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    iget-object v3, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    iget v4, p1, Landroid/os/Message;->arg1:I

    invoke-direct {v2, v3, v4}, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;-><init>(Lcom/amazon/android/service/IntentTimeoutService;I)V

    # setter for: Lcom/amazon/android/service/IntentTimeoutService;->lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
    invoke-static {v0, v2}, Lcom/amazon/android/service/IntentTimeoutService;->access$402(Lcom/amazon/android/service/IntentTimeoutService;Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;)Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    .line 102
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->timer:Ljava/util/Timer;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$100(Lcom/amazon/android/service/IntentTimeoutService;)Ljava/util/Timer;

    move-result-object v0

    iget-object v2, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
    invoke-static {v2}, Lcom/amazon/android/service/IntentTimeoutService;->access$400(Lcom/amazon/android/service/IntentTimeoutService;)Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->timeout:J
    invoke-static {v3}, Lcom/amazon/android/service/IntentTimeoutService;->access$500(Lcom/amazon/android/service/IntentTimeoutService;)J

    move-result-wide v3

    invoke-virtual {v0, v2, v3, v4}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 103
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
