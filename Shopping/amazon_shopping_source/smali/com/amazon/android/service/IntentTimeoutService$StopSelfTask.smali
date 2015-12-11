.class final Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
.super Ljava/util/TimerTask;
.source "IntentTimeoutService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/service/IntentTimeoutService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "StopSelfTask"
.end annotation


# instance fields
.field private final startId:I

.field final synthetic this$0:Lcom/amazon/android/service/IntentTimeoutService;


# direct methods
.method public constructor <init>(Lcom/amazon/android/service/IntentTimeoutService;I)V
    .locals 0
    .param p2, "startId"    # I

    .prologue
    .line 121
    iput-object p1, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    .line 122
    iput p2, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->startId:I

    .line 123
    return-void
.end method


# virtual methods
.method public doStopSelf()V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->latestStartId:Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$300(Lcom/amazon/android/service/IntentTimeoutService;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    iget v1, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->startId:I

    if-ne v0, v1, :cond_0

    .line 143
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    invoke-virtual {v0}, Lcom/amazon/android/service/IntentTimeoutService;->onTimeout()V

    .line 145
    :cond_0
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    iget v1, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->startId:I

    invoke-virtual {v0, v1}, Lcom/amazon/android/service/IntentTimeoutService;->stopSelf(I)V

    .line 146
    return-void
.end method

.method public run()V
    .locals 3

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    # getter for: Lcom/amazon/android/service/IntentTimeoutService;->timer:Ljava/util/Timer;
    invoke-static {v0}, Lcom/amazon/android/service/IntentTimeoutService;->access$100(Lcom/amazon/android/service/IntentTimeoutService;)Ljava/util/Timer;

    move-result-object v1

    monitor-enter v1

    .line 132
    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->this$0:Lcom/amazon/android/service/IntentTimeoutService;

    const/4 v2, 0x0

    # setter for: Lcom/amazon/android/service/IntentTimeoutService;->lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
    invoke-static {v0, v2}, Lcom/amazon/android/service/IntentTimeoutService;->access$402(Lcom/amazon/android/service/IntentTimeoutService;Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;)Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    .line 133
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 134
    invoke-virtual {p0}, Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;->doStopSelf()V

    .line 135
    return-void

    .line 133
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
