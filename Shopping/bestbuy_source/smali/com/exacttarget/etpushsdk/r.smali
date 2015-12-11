.class Lcom/exacttarget/etpushsdk/r;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Ljava/lang/Thread;

.field final synthetic b:Lcom/exacttarget/etpushsdk/ETPush;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETPush;Ljava/lang/Thread;)V
    .locals 0

    .prologue
    .line 1437
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/r;->b:Lcom/exacttarget/etpushsdk/ETPush;

    iput-object p2, p0, Lcom/exacttarget/etpushsdk/r;->a:Ljava/lang/Thread;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 1440
    :try_start_0
    const-string v0, "~!ETPush"

    const-string v1, "Waiting for enablePush() to finish"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1441
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->v()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    const-wide/16 v2, 0x61a8

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v1}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1442
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "ETPush disablePush() timed out waiting for state change."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1447
    :catch_0
    move-exception v0

    .line 1448
    :goto_0
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1450
    :goto_1
    return-void

    .line 1444
    :cond_0
    :try_start_1
    const-string v0, "~!ETPush"

    const-string v1, "enablePush() finished.  So continue with disabling push."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1445
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->b(Ljava/util/concurrent/CountDownLatch;)Ljava/util/concurrent/CountDownLatch;

    .line 1446
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/r;->a:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 1447
    :catch_1
    move-exception v0

    goto :goto_0
.end method
