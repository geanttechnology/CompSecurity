.class final Lcom/exacttarget/etpushsdk/u;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Ljava/lang/Thread;


# direct methods
.method constructor <init>(Ljava/lang/Thread;)V
    .locals 0

    .prologue
    .line 934
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/u;->a:Ljava/lang/Thread;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 937
    :try_start_0
    const-string v0, "~!ETPush"

    const-string v1, "Waiting for activityResumed() to finish"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 938
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->u()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    const-wide/16 v2, 0x61a8

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v1}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 939
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "ETPush activityPaused() timed out waiting for state change."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1

    .line 944
    :catch_0
    move-exception v0

    .line 945
    :goto_0
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 947
    :goto_1
    return-void

    .line 941
    :cond_0
    :try_start_1
    const-string v0, "~!ETPush"

    const-string v1, "activityResumed() finished.  So continue with pausing activity."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 942
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/concurrent/CountDownLatch;)Ljava/util/concurrent/CountDownLatch;

    .line 943
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/u;->a:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 944
    :catch_1
    move-exception v0

    goto :goto_0
.end method
