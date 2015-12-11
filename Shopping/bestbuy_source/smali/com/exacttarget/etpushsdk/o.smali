.class final Lcom/exacttarget/etpushsdk/o;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETPushConfig;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETPushConfig;)V
    .locals 0

    .prologue
    .line 376
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const/4 v4, 0x0

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 380
    :try_start_0
    new-instance v0, Lcom/exacttarget/etpushsdk/ETPush$a;

    const/4 v3, 0x1

    invoke-direct {v0, v3}, Lcom/exacttarget/etpushsdk/ETPush$a;-><init>(I)V

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Lcom/exacttarget/etpushsdk/ETPush$a;)Lcom/exacttarget/etpushsdk/ETPush$a;

    .line 388
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->b:Ljava/lang/String;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Ljava/lang/String;)V

    .line 389
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->c:Ljava/lang/String;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->b(Ljava/lang/String;)V

    .line 390
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->d:Ljava/lang/String;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->c(Ljava/lang/String;)V

    .line 391
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->e:Z

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Z)V

    .line 392
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->f:Z

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->b(Z)V

    .line 393
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->g:Z

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->c(Z)V

    .line 394
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->i:Z

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->e(Z)V

    .line 395
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->h:Z

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->d(Z)V

    .line 399
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->a()V

    .line 405
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/i;->a(Landroid/content/Context;)V

    .line 407
    new-instance v0, Lcom/exacttarget/etpushsdk/ETPush;

    const/4 v3, 0x0

    invoke-direct {v0, v3}, Lcom/exacttarget/etpushsdk/ETPush;-><init>(Lcom/exacttarget/etpushsdk/o;)V

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Lcom/exacttarget/etpushsdk/ETPush;)Lcom/exacttarget/etpushsdk/ETPush;

    .line 408
    new-instance v0, Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/data/Registration;-><init>()V

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Lcom/exacttarget/etpushsdk/data/Registration;)Lcom/exacttarget/etpushsdk/data/Registration;

    .line 409
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->l()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 410
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->n()Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v0

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->m()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Registration;->setPushEnabled(Ljava/lang/Boolean;)V

    .line 413
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->o()Lcom/exacttarget/etpushsdk/ETPush$a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->c()V

    .line 414
    const-string v0, "~!ETPush"

    const-string v3, "ETPush singleton getInstance initialization completed."

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 416
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 419
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->p()V

    .line 422
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->e:Z

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v3, v3, Lcom/exacttarget/etpushsdk/ETPushConfig;->f:Z

    or-int/2addr v0, v3

    if-eqz v0, :cond_1

    .line 424
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(Landroid/content/Context;)V

    .line 427
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->g:Z

    if-eqz v0, :cond_2

    .line 429
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Landroid/content/Context;)V

    .line 432
    :cond_2
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/o;->a:Lcom/exacttarget/etpushsdk/ETPushConfig;

    iget-boolean v0, v0, Lcom/exacttarget/etpushsdk/ETPushConfig;->i:Z

    if-eqz v0, :cond_3

    .line 434
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETCloudPageManager;->a(Landroid/content/Context;)V
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0

    .line 448
    :cond_3
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->r()Lcom/exacttarget/etpushsdk/ETPush$a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->c()V

    .line 449
    const-string v0, "~!ETPush"

    const-string v3, "readyAimFire() initialization completed"

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 451
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->s()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 453
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->s()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/util/EventBus;->register(Ljava/lang/Object;)V

    .line 455
    :cond_4
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v3, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;

    invoke-direct {v3, v1}, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;-><init>(Z)V

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    .line 459
    :try_start_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_5

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->s()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush;->j()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 461
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->n()Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->getSystemTokenFromCache()Ljava/lang/String;

    move-result-object v0

    .line 465
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    move v0, v1

    .line 490
    :goto_0
    if-eqz v0, :cond_8

    .line 492
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->s()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush;->i()V
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_1

    .line 501
    :cond_5
    :goto_1
    return-void

    .line 436
    :catch_0
    move-exception v0

    .line 437
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 438
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->q()V

    .line 440
    invoke-static {v4}, Lcom/exacttarget/etpushsdk/ETPush;->a(Lcom/exacttarget/etpushsdk/ETPush;)Lcom/exacttarget/etpushsdk/ETPush;

    .line 441
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    new-instance v3, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;

    invoke-direct {v3, v2, v0}, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;-><init>(ZLjava/lang/Exception;)V

    invoke-virtual {v1, v3}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    goto :goto_1

    .line 475
    :cond_6
    :try_start_2
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v3, "gcm_app_version_key"

    const/high16 v4, -0x80000000

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v7

    const-string v8, "~!ETPush"

    const/4 v9, 0x0

    invoke-virtual {v7, v8, v9}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v0, v3, v4, v5}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 476
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/n;->a()I

    move-result v3

    .line 477
    if-eq v0, v3, :cond_7

    .line 478
    const-string v0, "~!ETPush"

    const-string v2, "App version code changed."

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->b(Ljava/lang/String;Ljava/lang/String;)I

    move v2, v1

    .line 482
    :cond_7
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v3, "gcm_sender_id_key"

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v7

    const-string v8, "~!ETPush"

    const/4 v9, 0x0

    invoke-virtual {v7, v8, v9}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v0, v3, v4, v5}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 484
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->d()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    .line 485
    const-string v2, "~!ETPush"

    const-string v3, "GCM Sender Id changed. Old: %s New: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    const/4 v0, 0x1

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->d()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    .line 486
    goto/16 :goto_0

    .line 495
    :cond_8
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V
    :try_end_2
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 498
    :catch_1
    move-exception v0

    .line 499
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_1

    :cond_9
    move v0, v2

    goto/16 :goto_0
.end method
