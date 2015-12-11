.class public abstract Lcom/amazon/android/service/IntentTimeoutService;
.super Landroid/app/Service;
.source "IntentTimeoutService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;,
        Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;
    }
.end annotation


# instance fields
.field private isFirstIntent:Z

.field private lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

.field private latestStartId:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final priority:I

.field private volatile serviceHandler:Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;

.field private volatile serviceLooper:Landroid/os/Looper;

.field private final serviceName:Ljava/lang/String;

.field private timeout:J

.field private final timer:Ljava/util/Timer;

.field private volatile timerCancelled:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 156
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/android/service/IntentTimeoutService;-><init>(Ljava/lang/String;I)V

    .line 157
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "priority"    # I

    .prologue
    .line 168
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 43
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->timer:Ljava/util/Timer;

    .line 46
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->timerCancelled:Z

    .line 49
    const-wide/16 v0, 0x7530

    iput-wide v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->timeout:J

    .line 55
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->isFirstIntent:Z

    .line 64
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->latestStartId:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 169
    iput-object p1, p0, Lcom/amazon/android/service/IntentTimeoutService;->serviceName:Ljava/lang/String;

    .line 170
    iput p2, p0, Lcom/amazon/android/service/IntentTimeoutService;->priority:I

    .line 171
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/android/service/IntentTimeoutService;Landroid/content/Intent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/android/service/IntentTimeoutService;
    .param p1, "x1"    # Landroid/content/Intent;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/amazon/android/service/IntentTimeoutService;->handleIntent(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/android/service/IntentTimeoutService;)Ljava/util/Timer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/android/service/IntentTimeoutService;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->timer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/android/service/IntentTimeoutService;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/android/service/IntentTimeoutService;

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->timerCancelled:Z

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/android/service/IntentTimeoutService;)Ljava/util/concurrent/atomic/AtomicInteger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/android/service/IntentTimeoutService;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->latestStartId:Ljava/util/concurrent/atomic/AtomicInteger;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/android/service/IntentTimeoutService;)Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/android/service/IntentTimeoutService;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/android/service/IntentTimeoutService;Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;)Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/android/service/IntentTimeoutService;
    .param p1, "x1"    # Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/android/service/IntentTimeoutService;->lastTask:Lcom/amazon/android/service/IntentTimeoutService$StopSelfTask;

    return-object p1
.end method

.method static synthetic access$500(Lcom/amazon/android/service/IntentTimeoutService;)J
    .locals 2
    .param p0, "x0"    # Lcom/amazon/android/service/IntentTimeoutService;

    .prologue
    .line 28
    iget-wide v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->timeout:J

    return-wide v0
.end method

.method private handleIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 267
    iget-boolean v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->isFirstIntent:Z

    if-eqz v0, :cond_0

    .line 268
    invoke-virtual {p0, p1}, Lcom/amazon/android/service/IntentTimeoutService;->beforeFirstHandleIntent(Landroid/content/Intent;)V

    .line 269
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->isFirstIntent:Z

    .line 271
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/android/service/IntentTimeoutService;->onHandleIntent(Landroid/content/Intent;)V

    .line 272
    return-void
.end method


# virtual methods
.method protected beforeFirstHandleIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 284
    return-void
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 234
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 3

    .prologue
    .line 179
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 180
    new-instance v0, Landroid/os/HandlerThread;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "IntentTimeoutService["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/android/service/IntentTimeoutService;->serviceName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget v2, p0, Lcom/amazon/android/service/IntentTimeoutService;->priority:I

    invoke-direct {v0, v1, v2}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    .line 182
    .local v0, "thread":Landroid/os/HandlerThread;
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 184
    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/android/service/IntentTimeoutService;->serviceLooper:Landroid/os/Looper;

    .line 185
    new-instance v1, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;

    iget-object v2, p0, Lcom/amazon/android/service/IntentTimeoutService;->serviceLooper:Landroid/os/Looper;

    invoke-direct {v1, p0, v2}, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;-><init>(Lcom/amazon/android/service/IntentTimeoutService;Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/amazon/android/service/IntentTimeoutService;->serviceHandler:Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;

    .line 186
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 216
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->serviceLooper:Landroid/os/Looper;

    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    .line 217
    iget-object v1, p0, Lcom/amazon/android/service/IntentTimeoutService;->timer:Ljava/util/Timer;

    monitor-enter v1

    .line 218
    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 219
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/android/service/IntentTimeoutService;->timerCancelled:Z

    .line 220
    monitor-exit v1

    .line 221
    return-void

    .line 220
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected abstract onHandleIntent(Landroid/content/Intent;)V
.end method

.method public onStart(Landroid/content/Intent;I)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "startId"    # I

    .prologue
    .line 194
    iget-object v1, p0, Lcom/amazon/android/service/IntentTimeoutService;->serviceHandler:Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;

    invoke-virtual {v1}, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 195
    .local v0, "msg":Landroid/os/Message;
    iput p2, v0, Landroid/os/Message;->arg1:I

    .line 196
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 197
    iget-object v1, p0, Lcom/amazon/android/service/IntentTimeoutService;->serviceHandler:Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;

    invoke-virtual {v1, v0}, Lcom/amazon/android/service/IntentTimeoutService$ServiceHandler;->sendMessage(Landroid/os/Message;)Z

    .line 198
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 206
    invoke-virtual {p0, p1, p3}, Lcom/amazon/android/service/IntentTimeoutService;->onStart(Landroid/content/Intent;I)V

    .line 207
    const/4 v0, 0x3

    return v0
.end method

.method protected onTimeout()V
    .locals 0

    .prologue
    .line 293
    return-void
.end method

.method public setTimeout(J)V
    .locals 0
    .param p1, "timeoutMs"    # J

    .prologue
    .line 245
    iput-wide p1, p0, Lcom/amazon/android/service/IntentTimeoutService;->timeout:J

    .line 246
    return-void
.end method
