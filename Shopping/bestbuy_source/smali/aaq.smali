.class public Laaq;
.super Labn;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Laab;

.field private final b:Lcom/google/android/gms/internal/fj;

.field private final c:Labe;

.field private final d:Laar;

.field private final e:Ljava/lang/Object;

.field private f:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<",
            "Labd;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Labe;Laab;Laar;)V
    .locals 1

    invoke-direct {p0}, Labn;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Laaq;->e:Ljava/lang/Object;

    iput-object p1, p0, Laaq;->c:Labe;

    iget-object v0, p1, Labe;->b:Lcom/google/android/gms/internal/fj;

    iput-object v0, p0, Laaq;->b:Lcom/google/android/gms/internal/fj;

    iput-object p2, p0, Laaq;->a:Laab;

    iput-object p3, p0, Laaq;->d:Laar;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lahi;Lst;Labe;Laab;)V
    .locals 6

    new-instance v0, Laar;

    new-instance v4, Labw;

    invoke-direct {v4}, Labw;-><init>()V

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Laar;-><init>(Landroid/content/Context;Lahi;Lst;Labw;Labe;)V

    invoke-direct {p0, p4, p5, v0}, Laaq;-><init>(Labe;Laab;Laar;)V

    return-void
.end method

.method static synthetic a(Laaq;)Laab;
    .locals 1

    iget-object v0, p0, Laaq;->a:Laab;

    return-object v0
.end method

.method private a(I)Labd;
    .locals 31

    new-instance v2, Labd;

    move-object/from16 v0, p0

    iget-object v3, v0, Laaq;->c:Labe;

    iget-object v3, v3, Labe;->a:Lcom/google/android/gms/internal/fh;

    iget-object v3, v3, Lcom/google/android/gms/internal/fh;->c:Lcom/google/android/gms/internal/av;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->b:Lcom/google/android/gms/internal/fj;

    iget v9, v6, Lcom/google/android/gms/internal/fj;->l:I

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->b:Lcom/google/android/gms/internal/fj;

    iget-wide v10, v6, Lcom/google/android/gms/internal/fj;->k:J

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->c:Labe;

    iget-object v6, v6, Labe;->a:Lcom/google/android/gms/internal/fh;

    iget-object v12, v6, Lcom/google/android/gms/internal/fh;->i:Ljava/lang/String;

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->b:Lcom/google/android/gms/internal/fj;

    iget-wide v0, v6, Lcom/google/android/gms/internal/fj;->i:J

    move-wide/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->c:Labe;

    iget-object v0, v6, Labe;->d:Lcom/google/android/gms/internal/ay;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->b:Lcom/google/android/gms/internal/fj;

    iget-wide v0, v6, Lcom/google/android/gms/internal/fj;->g:J

    move-wide/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->c:Labe;

    iget-wide v0, v6, Labe;->f:J

    move-wide/from16 v24, v0

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->b:Lcom/google/android/gms/internal/fj;

    iget-wide v0, v6, Lcom/google/android/gms/internal/fj;->n:J

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->b:Lcom/google/android/gms/internal/fj;

    iget-object v0, v6, Lcom/google/android/gms/internal/fj;->o:Ljava/lang/String;

    move-object/from16 v28, v0

    move-object/from16 v0, p0

    iget-object v6, v0, Laaq;->c:Labe;

    iget-object v0, v6, Labe;->h:Lorg/json/JSONObject;

    move-object/from16 v29, v0

    const/16 v30, 0x0

    move/from16 v6, p1

    invoke-direct/range {v2 .. v30}, Labd;-><init>(Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/gu;Ljava/util/List;ILjava/util/List;Ljava/util/List;IJLjava/lang/String;ZLvu;Lwg;Ljava/lang/String;Lvv;Lvx;JLcom/google/android/gms/internal/ay;JJJLjava/lang/String;Lorg/json/JSONObject;Lut;)V

    return-object v2
.end method


# virtual methods
.method public a()V
    .locals 8

    const/4 v3, -0x1

    const/4 v2, -0x2

    const/4 v1, 0x0

    :try_start_0
    iget-object v4, p0, Laaq;->e:Ljava/lang/Object;

    monitor-enter v4
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/CancellationException; {:try_start_0 .. :try_end_0} :catch_3

    :try_start_1
    iget-object v0, p0, Laaq;->d:Laar;

    invoke-static {v0}, Labp;->a(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    iput-object v0, p0, Laaq;->f:Ljava/util/concurrent/Future;

    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iget-object v0, p0, Laaq;->f:Ljava/util/concurrent/Future;

    const-wide/32 v4, 0xea60

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, v4, v5, v6}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Labd;
    :try_end_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/util/concurrent/CancellationException; {:try_start_2 .. :try_end_2} :catch_3

    move v1, v2

    :goto_0
    if-eqz v0, :cond_0

    :goto_1
    sget-object v1, Laca;->a:Landroid/os/Handler;

    new-instance v2, Laaq$1;

    invoke-direct {v2, p0, v0}, Laaq$1;-><init>(Laaq;Labd;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void

    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/InterruptedException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/util/concurrent/CancellationException; {:try_start_4 .. :try_end_4} :catch_3

    :catch_0
    move-exception v0

    const-string v0, "Timed out waiting for native ad."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    const/4 v0, 0x2

    move-object v7, v1

    move v1, v0

    move-object v0, v7

    goto :goto_0

    :catch_1
    move-exception v0

    const/4 v0, 0x0

    move-object v7, v1

    move v1, v0

    move-object v0, v7

    goto :goto_0

    :catch_2
    move-exception v0

    move-object v0, v1

    move v1, v3

    goto :goto_0

    :catch_3
    move-exception v0

    move-object v0, v1

    move v1, v3

    goto :goto_0

    :cond_0
    invoke-direct {p0, v1}, Laaq;->a(I)Labd;

    move-result-object v0

    goto :goto_1
.end method

.method public b()V
    .locals 3

    iget-object v1, p0, Laaq;->e:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Laaq;->f:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_0

    iget-object v0, p0, Laaq;->f:Ljava/util/concurrent/Future;

    const/4 v2, 0x1

    invoke-interface {v0, v2}, Ljava/util/concurrent/Future;->cancel(Z)Z

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
