.class Lcom/exacttarget/etpushsdk/i;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lcom/exacttarget/etpushsdk/ETLocationManager;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Z)V
    .locals 0

    .prologue
    .line 538
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/i;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    iput-boolean p2, p0, Lcom/exacttarget/etpushsdk/i;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 541
    const-string v0, "~!ETLocationManager"

    const-string v1, "locationStateThread stop started"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 544
    :try_start_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/i;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    iget-boolean v1, p0, Lcom/exacttarget/etpushsdk/i;->a:Z

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Z)V

    .line 546
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/i;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->d(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    move-result-object v0

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Ljava/lang/Boolean;)V

    .line 547
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/i;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->d(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;)V

    .line 549
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/i;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i(Lcom/exacttarget/etpushsdk/ETLocationManager;)V

    .line 551
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/i;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lqm;

    move-result-object v0

    invoke-interface {v0}, Lqm;->c()V

    .line 554
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 556
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v1, Lcom/exacttarget/etpushsdk/event/LocationStatusEvent;

    iget-boolean v2, p0, Lcom/exacttarget/etpushsdk/i;->a:Z

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/event/LocationStatusEvent;-><init>(Z)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    .line 557
    const-string v0, "~!ETLocationManager"

    const-string v1, " ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 561
    const-string v0, "~!ETLocationManager"

    const-string v1, "locationStateThread stop ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 562
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 564
    :goto_0
    return-void

    .line 558
    :catch_0
    move-exception v0

    .line 559
    :try_start_1
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 561
    const-string v0, "~!ETLocationManager"

    const-string v1, "locationStateThread stop ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 562
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    .line 561
    :catchall_0
    move-exception v0

    const-string v1, "~!ETLocationManager"

    const-string v2, "locationStateThread stop ended"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 562
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h()Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v0
.end method
