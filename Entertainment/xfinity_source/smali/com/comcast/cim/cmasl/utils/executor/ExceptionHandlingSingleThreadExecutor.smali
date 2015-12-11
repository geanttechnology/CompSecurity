.class public Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;
.super Ljava/util/concurrent/ThreadPoolExecutor;
.source "ExceptionHandlingSingleThreadExecutor.java"


# instance fields
.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 8
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 15
    const-wide/16 v4, 0x0

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    move-object v1, p0

    move v3, v2

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    .line 16
    iput-object p1, p0, Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;->name:Ljava/lang/String;

    .line 17
    return-void
.end method


# virtual methods
.method protected afterExecute(Ljava/lang/Runnable;Ljava/lang/Throwable;)V
    .locals 5
    .param p1, "r"    # Ljava/lang/Runnable;
    .param p2, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 21
    invoke-super {p0, p1, p2}, Ljava/util/concurrent/ThreadPoolExecutor;->afterExecute(Ljava/lang/Runnable;Ljava/lang/Throwable;)V

    .line 22
    if-nez p2, :cond_0

    instance-of v2, p1, Ljava/util/concurrent/Future;

    if-eqz v2, :cond_0

    .line 24
    :try_start_0
    check-cast p1, Ljava/util/concurrent/Future;

    .end local p1    # "r":Ljava/lang/Runnable;
    invoke-interface {p1}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/CancellationException; {:try_start_0 .. :try_end_0} :catch_1

    .line 33
    :cond_0
    :goto_0
    return-void

    .line 25
    :catch_0
    move-exception v1

    .line 26
    .local v1, "ee":Ljava/util/concurrent/ExecutionException;
    invoke-virtual {v1}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 28
    .local v0, "cause":Ljava/lang/Throwable;
    new-instance v2, Ljava/lang/RuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/comcast/cim/cmasl/utils/executor/ExceptionHandlingSingleThreadExecutor;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": exception occurred in background task"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 30
    .end local v0    # "cause":Ljava/lang/Throwable;
    .end local v1    # "ee":Ljava/util/concurrent/ExecutionException;
    :catch_1
    move-exception v2

    goto :goto_0

    .line 29
    :catch_2
    move-exception v2

    goto :goto_0
.end method
