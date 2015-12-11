.class final Ln;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Landroid/content/Context;

.field private final c:Ljava/util/concurrent/ScheduledExecutorService;

.field private final d:Ljava/lang/String;

.field private final e:Ljava/lang/String;

.field private final f:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 354
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 355
    iput-object p1, p0, Ln;->a:Ljava/lang/String;

    .line 356
    iput-object p2, p0, Ln;->b:Landroid/content/Context;

    .line 357
    iput-object p3, p0, Ln;->c:Ljava/util/concurrent/ScheduledExecutorService;

    .line 358
    iput-object p4, p0, Ln;->d:Ljava/lang/String;

    .line 359
    iput-object p6, p0, Ln;->f:Ljava/lang/String;

    .line 360
    iput-object p5, p0, Ln;->e:Ljava/lang/String;

    .line 361
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V
    .locals 0

    .prologue
    .line 345
    invoke-direct/range {p0 .. p6}, Ln;-><init>(Ljava/lang/String;Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 15

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 368
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Started to run "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lbc;->a(Ljava/lang/String;)V

    .line 371
    :try_start_0
    new-instance v2, Lz;

    iget-object v3, p0, Ln;->b:Landroid/content/Context;

    invoke-direct {v2, v3}, Lz;-><init>(Landroid/content/Context;)V

    .line 372
    new-instance v3, Laa;

    invoke-direct {v3, v2}, Laa;-><init>(Lz;)V

    .line 374
    invoke-virtual {v3}, Laa;->a()V

    const-string v4, "disable_until"

    invoke-virtual {v3, v4}, Laa;->a(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-lez v4, :cond_0

    :goto_0
    if-eqz v0, :cond_1

    .line 375
    const/4 v0, 0x0

    sput-boolean v0, Ll;->e:Z

    .line 449
    :goto_1
    return-void

    :cond_0
    move v0, v1

    .line 374
    goto :goto_0

    .line 380
    :cond_1
    invoke-static {}, Ll;->b()Lav;

    move-result-object v0

    invoke-virtual {v0}, Lav;->a()I

    move-result v0

    .line 381
    if-lez v0, :cond_2

    .line 382
    sget-object v1, Ll;->d:Lb$1;

    int-to-long v4, v0

    invoke-virtual {v1, v4, v5}, Lb$1;->b(J)V

    .line 385
    :cond_2
    new-instance v0, Lan;

    new-instance v1, Ly;

    invoke-direct {v1, v2, v3}, Ly;-><init>(Lz;Laa;)V

    invoke-direct {v0, v1}, Lan;-><init>(Ly;)V

    .line 387
    new-instance v12, La;

    iget-object v1, p0, Ln;->b:Landroid/content/Context;

    invoke-direct {v12, v1}, La;-><init>(Landroid/content/Context;)V

    .line 388
    invoke-virtual {v12}, La;->a()V

    .line 389
    new-instance v11, Lae;

    invoke-direct {v11}, Lae;-><init>()V

    .line 390
    new-instance v8, Lam;

    iget-object v1, p0, Ln;->b:Landroid/content/Context;

    iget-object v2, p0, Ln;->f:Ljava/lang/String;

    iget-object v4, p0, Ln;->a:Ljava/lang/String;

    invoke-direct {v8, v1, v2, v4}, Lam;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 391
    iget-object v1, p0, Ln;->d:Ljava/lang/String;

    iget-object v2, p0, Ln;->e:Ljava/lang/String;

    invoke-static {}, Ll;->c()Lf;

    move-result-object v4

    invoke-static {v1, v2, v8, v4}, Lm;->a(Ljava/lang/String;Ljava/lang/String;Lam;Lf;)Lm;

    move-result-object v1

    .line 393
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 394
    sget-object v4, Ll;->g:Lg;

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 395
    new-instance v4, Laq;

    sget-object v5, Ll;->d:Lb$1;

    invoke-direct {v4, v1, v5, v2}, Laq;-><init>(Lm;Lb$1;Ljava/util/List;)V

    .line 396
    new-instance v2, Lao;

    const/4 v1, 0x1

    new-array v1, v1, [Lap;

    const/4 v5, 0x0

    sget-object v6, Ll;->f:Lbg;

    aput-object v6, v1, v5

    invoke-direct {v2, v4, v0, v8, v1}, Lao;-><init>(Laq;Lan;Lam;[Lap;)V

    .line 397
    new-instance v10, Lag;

    sget-object v0, Laz;->a:Laz;

    sget-object v1, Ll;->d:Lb$1;

    invoke-direct {v10, v8, v12, v0, v1}, Lag;-><init>(Lam;La;Laz;Lb$1;)V

    .line 398
    sget-object v0, Ll;->b:Ls;

    invoke-virtual {v0, v2}, Ls;->a(Lao;)V

    .line 399
    sget-object v0, Ll;->b:Ls;

    invoke-virtual {v0, v10}, Ls;->a(Lag;)V

    .line 400
    sget-object v0, Ll;->g:Lg;

    invoke-virtual {v0, v2}, Lg;->a(Lao;)V

    .line 401
    sget-object v0, Ll;->g:Lg;

    invoke-virtual {v0, v10}, Lg;->a(Lag;)V

    .line 402
    sget-object v0, Ll;->f:Lbg;

    invoke-virtual {v0, v10}, Lbg;->a(Lag;)V

    .line 403
    sget-object v0, Ll;->h:Lbi;

    invoke-virtual {v0, v10, v2}, Lbi;->a(Lag;Lao;)V

    .line 404
    new-instance v4, Lbk;

    sget-object v0, Ll;->a:Lab;

    invoke-direct {v4, v10, v2, v0}, Lbk;-><init>(Lag;Lao;Lab;)V

    .line 406
    new-instance v14, Lah;

    iget-object v0, p0, Ln;->c:Ljava/util/concurrent/ScheduledExecutorService;

    sget-object v1, Ll;->a:Lab;

    invoke-direct {v14, v2, v0, v1}, Lah;-><init>(Lao;Ljava/util/concurrent/ScheduledExecutorService;Lab;)V

    .line 407
    invoke-virtual {v11, v14}, Lae;->a(Lr;)V

    .line 409
    new-instance v0, Ln$1;

    invoke-direct {v0, p0, v4}, Ln$1;-><init>(Ln;Lbk;)V

    const/16 v1, 0x2710

    invoke-virtual {v14, v0, v1}, Lah;->a(Ljava/lang/Runnable;I)V

    .line 418
    new-instance v0, Lo;

    sget-object v1, Ll;->f:Lbg;

    sget-object v5, Ll;->g:Lg;

    invoke-direct {v0, v14, v1, v5}, Lo;-><init>(Lah;Lbg;Lg;)V

    .line 420
    sget v1, Lal;->c:I

    invoke-virtual {v14, v0, v1}, Lah;->a(Ljava/lang/Runnable;I)V

    .line 421
    new-instance v5, Lax;

    sget-object v0, Ll;->a:Lab;

    invoke-direct {v5, v10, v2, v0}, Lax;-><init>(Lag;Lao;Lab;)V

    .line 423
    new-instance v6, Lbf;

    const v0, 0xea60

    invoke-direct {v6, v2, v10, v0}, Lbf;-><init>(Lao;Lag;I)V

    .line 424
    new-instance v0, Ll;

    iget-object v1, p0, Ln;->a:Ljava/lang/String;

    iget-object v7, p0, Ln;->b:Landroid/content/Context;

    iget-object v9, p0, Ln;->c:Ljava/util/concurrent/ScheduledExecutorService;

    const/4 v13, 0x0

    invoke-direct/range {v0 .. v13}, Ll;-><init>(Ljava/lang/String;Lao;Laa;Lbk;Lax;Lbf;Landroid/content/Context;Lam;Ljava/util/concurrent/ScheduledExecutorService;Lag;Lae;La;B)V

    sput-object v0, Ll;->c:Ll;

    .line 437
    sget-object v0, Ll;->g:Lg;

    invoke-virtual {v0, v14}, Lg;->a(Lah;)V

    .line 438
    const-string v0, "Instrumentation has been initialized."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 439
    invoke-static {}, Ll;->b()Lav;

    move-result-object v0

    invoke-virtual {v0, v2}, Lav;->a(Lao;)V

    .line 441
    invoke-static {}, Ll;->b()Lav;

    move-result-object v0

    invoke-virtual {v0, v2, v14}, Lav;->a(Lao;Lah;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 443
    :catch_0
    move-exception v0

    .line 447
    const-string v1, "ADInstrumentation"

    const-string v2, "Error starting AppDynamics instrumentation"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_1
.end method
