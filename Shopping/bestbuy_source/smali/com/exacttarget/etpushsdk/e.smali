.class Lcom/exacttarget/etpushsdk/e;
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
    .line 271
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    iput-boolean p2, p0, Lcom/exacttarget/etpushsdk/e;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 274
    const-string v0, "~!ETLocationManager"

    const-string v1, "locationStateThread start started"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 277
    :try_start_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lqm;

    move-result-object v0

    if-nez v0, :cond_0

    .line 278
    const-string v0, "~!ETLocationManager"

    const-string v1, "Creating our GoogleApiClient"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 279
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    new-instance v1, Lqn;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lqn;-><init>(Landroid/content/Context;)V

    sget-object v2, Lahy;->a:Lpx;

    invoke-virtual {v1, v2}, Lqn;->a(Lpx;)Lqn;

    move-result-object v1

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->d(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    move-result-object v2

    invoke-virtual {v1, v2}, Lqn;->a(Lqo;)Lqn;

    move-result-object v1

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->d(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    move-result-object v2

    invoke-virtual {v1, v2}, Lqn;->a(Lqp;)Lqn;

    move-result-object v1

    invoke-virtual {v1}, Lqn;->b()Lqm;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;Lqm;)Lqm;

    .line 281
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lqm;

    move-result-object v0

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 282
    const-string v0, "~!ETLocationManager"

    const-string v1, "Connecting our GoogleApiClient"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 283
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lqm;

    move-result-object v0

    invoke-interface {v0}, Lqm;->b()V

    .line 290
    :cond_1
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/e;->a:Z

    if-eqz v0, :cond_2

    .line 291
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Z)V

    .line 296
    :cond_2
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 297
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Z)V

    .line 298
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/e;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Lcom/exacttarget/etpushsdk/ETLocationManager;)V

    .line 300
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 301
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v1, Lcom/exacttarget/etpushsdk/event/LocationStatusEvent;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/event/LocationStatusEvent;-><init>(Z)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 306
    :cond_3
    const-string v0, "~!ETLocationManager"

    const-string v1, "locationStateThread start ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 307
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 309
    :goto_0
    return-void

    .line 303
    :catch_0
    move-exception v0

    .line 304
    :try_start_1
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 306
    const-string v0, "~!ETLocationManager"

    const-string v1, "locationStateThread start ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 307
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    .line 306
    :catchall_0
    move-exception v0

    const-string v1, "~!ETLocationManager"

    const-string v2, "locationStateThread start ended"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 307
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h()Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v0
.end method
