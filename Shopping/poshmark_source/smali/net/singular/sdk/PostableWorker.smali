.class Lnet/singular/sdk/PostableWorker;
.super Ljava/lang/Object;
.source "PostableWorker.java"


# instance fields
.field private final log:Lnet/singular/sdk/SingularLog;

.field private final my_handler:Landroid/os/Handler;

.field private final my_thread:Landroid/os/HandlerThread;

.field private runnable_semaphore:Ljava/util/concurrent/Semaphore;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lnet/singular/sdk/SingularLog;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "log"    # Lnet/singular/sdk/SingularLog;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p2, p0, Lnet/singular/sdk/PostableWorker;->log:Lnet/singular/sdk/SingularLog;

    .line 17
    new-instance v0, Landroid/os/HandlerThread;

    invoke-direct {v0, p1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lnet/singular/sdk/PostableWorker;->my_thread:Landroid/os/HandlerThread;

    .line 18
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->my_thread:Landroid/os/HandlerThread;

    new-instance v1, Lnet/singular/sdk/PostableWorker$1;

    invoke-direct {v1, p0, p2, p1}, Lnet/singular/sdk/PostableWorker$1;-><init>(Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/SingularLog;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/HandlerThread;->setUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 30
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->my_thread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 31
    new-instance v0, Landroid/os/Handler;

    iget-object v1, p0, Lnet/singular/sdk/PostableWorker;->my_thread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lnet/singular/sdk/PostableWorker;->my_handler:Landroid/os/Handler;

    .line 33
    invoke-direct {p0}, Lnet/singular/sdk/PostableWorker;->blockThreadUntilStarted()V

    .line 34
    return-void
.end method

.method static synthetic access$000(Lnet/singular/sdk/PostableWorker;)Ljava/util/concurrent/Semaphore;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/PostableWorker;

    .prologue
    .line 9
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->runnable_semaphore:Ljava/util/concurrent/Semaphore;

    return-object v0
.end method

.method private blockThreadUntilStarted()V
    .locals 2

    .prologue
    .line 37
    new-instance v0, Ljava/util/concurrent/Semaphore;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/Semaphore;-><init>(I)V

    iput-object v0, p0, Lnet/singular/sdk/PostableWorker;->runnable_semaphore:Ljava/util/concurrent/Semaphore;

    .line 39
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->runnable_semaphore:Ljava/util/concurrent/Semaphore;

    invoke-virtual {v0}, Ljava/util/concurrent/Semaphore;->acquire()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    :goto_0
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->my_handler:Landroid/os/Handler;

    new-instance v1, Lnet/singular/sdk/PostableWorker$2;

    invoke-direct {v1, p0}, Lnet/singular/sdk/PostableWorker$2;-><init>(Lnet/singular/sdk/PostableWorker;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 50
    return-void

    .line 40
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public interruptThread()V
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->my_thread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->interrupt()V

    .line 70
    return-void
.end method

.method public postDelayed(Ljava/lang/Runnable;J)Z
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;
    .param p2, "delayMills"    # J

    .prologue
    .line 57
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->my_handler:Landroid/os/Handler;

    invoke-virtual {v0, p1, p2, p3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    move-result v0

    return v0
.end method

.method public postNow(Ljava/lang/Runnable;)Z
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 61
    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, v0, v1}, Lnet/singular/sdk/PostableWorker;->postDelayed(Ljava/lang/Runnable;J)Z

    move-result v0

    return v0
.end method

.method public removeCallback(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 65
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->my_handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 66
    return-void
.end method

.method public start()V
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker;->runnable_semaphore:Ljava/util/concurrent/Semaphore;

    invoke-virtual {v0}, Ljava/util/concurrent/Semaphore;->release()V

    .line 54
    return-void
.end method
