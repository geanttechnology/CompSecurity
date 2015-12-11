.class Lcom/exacttarget/etpushsdk/q;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETPush;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETPush;)V
    .locals 0

    .prologue
    .line 1410
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/q;->a:Lcom/exacttarget/etpushsdk/ETPush;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1413
    const-string v0, "~!ETPush"

    const-string v1, "disablePush()..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1417
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 1418
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/q;->a:Lcom/exacttarget/etpushsdk/ETPush;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush;->j()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1419
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/q;->a:Lcom/exacttarget/etpushsdk/ETPush;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->a(Lcom/exacttarget/etpushsdk/ETPush;Z)V

    .line 1420
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 1421
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v1, Lcom/exacttarget/etpushsdk/event/PushStatusEvent;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/event/PushStatusEvent;-><init>(Z)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1426
    :cond_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->v()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 1428
    :goto_0
    return-void

    .line 1423
    :catch_0
    move-exception v0

    .line 1424
    :try_start_1
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1426
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->v()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->v()Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v0
.end method
