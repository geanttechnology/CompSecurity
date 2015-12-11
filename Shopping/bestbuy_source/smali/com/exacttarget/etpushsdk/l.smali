.class Lcom/exacttarget/etpushsdk/l;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Ljava/lang/Thread;

.field final synthetic b:Lcom/exacttarget/etpushsdk/ETLocationManager;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Ljava/lang/Thread;)V
    .locals 0

    .prologue
    .line 692
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/l;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    iput-object p2, p0, Lcom/exacttarget/etpushsdk/l;->a:Ljava/lang/Thread;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 695
    :try_start_0
    const-string v0, "~!ETLocationManager"

    const-string v1, "Waiting for startWatchingProximity() to finish"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 696
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    const-wide/16 v2, 0x61a8

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v1}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 697
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "ETLocationManager stopWatchingProximity() timed out waiting for state change."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 702
    :catch_0
    move-exception v0

    .line 703
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 705
    :goto_0
    return-void

    .line 699
    :cond_0
    :try_start_1
    const-string v0, "~!ETLocationManager"

    const-string v1, "startWatchingProximity() finished.  So continue to stop watching proximity."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 700
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Ljava/util/concurrent/CountDownLatch;)Ljava/util/concurrent/CountDownLatch;

    .line 701
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/l;->a:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
