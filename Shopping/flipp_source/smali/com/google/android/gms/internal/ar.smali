.class public final Lcom/google/android/gms/internal/ar;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/au;


# instance fields
.field final a:Lcom/google/android/gms/internal/an;

.field final b:Lcom/google/android/gms/internal/v;

.field final c:Lcom/google/android/gms/internal/x;

.field final d:Landroid/content/Context;

.field final e:Ljava/lang/Object;

.field final f:Lcom/google/android/gms/internal/cu;

.field g:Lcom/google/android/gms/internal/bq;

.field h:I

.field private final i:Ljava/lang/String;

.field private final j:Lcom/google/android/gms/internal/bn;

.field private final k:J


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/internal/bn;Lcom/google/android/gms/internal/ao;Lcom/google/android/gms/internal/an;Lcom/google/android/gms/internal/v;Lcom/google/android/gms/internal/x;Lcom/google/android/gms/internal/cu;)V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/ar;->e:Ljava/lang/Object;

    const/4 v0, -0x2

    iput v0, p0, Lcom/google/android/gms/internal/ar;->h:I

    iput-object p1, p0, Lcom/google/android/gms/internal/ar;->d:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/ar;->i:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/ar;->j:Lcom/google/android/gms/internal/bn;

    iget-wide v0, p4, Lcom/google/android/gms/internal/ao;->b:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p4, Lcom/google/android/gms/internal/ao;->b:J

    :goto_0
    iput-wide v0, p0, Lcom/google/android/gms/internal/ar;->k:J

    iput-object p5, p0, Lcom/google/android/gms/internal/ar;->a:Lcom/google/android/gms/internal/an;

    iput-object p6, p0, Lcom/google/android/gms/internal/ar;->b:Lcom/google/android/gms/internal/v;

    iput-object p7, p0, Lcom/google/android/gms/internal/ar;->c:Lcom/google/android/gms/internal/x;

    iput-object p8, p0, Lcom/google/android/gms/internal/ar;->f:Lcom/google/android/gms/internal/cu;

    return-void

    :cond_0
    const-wide/16 v0, 0x2710

    goto :goto_0
.end method


# virtual methods
.method public final a(J)Lcom/google/android/gms/internal/at;
    .locals 15

    iget-object v6, p0, Lcom/google/android/gms/internal/ar;->e:Ljava/lang/Object;

    monitor-enter v6

    :try_start_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    new-instance v4, Lcom/google/android/gms/internal/aq;

    invoke-direct {v4}, Lcom/google/android/gms/internal/aq;-><init>()V

    sget-object v2, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    new-instance v3, Lcom/google/android/gms/internal/as;

    invoke-direct {v3, p0, v4}, Lcom/google/android/gms/internal/as;-><init>(Lcom/google/android/gms/internal/ar;Lcom/google/android/gms/internal/aq;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    iget-wide v2, p0, Lcom/google/android/gms/internal/ar;->k:J

    :goto_0
    iget v5, p0, Lcom/google/android/gms/internal/ar;->h:I

    const/4 v7, -0x2

    if-ne v5, v7, :cond_2

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v8

    sub-long v10, v8, v0

    sub-long v10, v2, v10

    const-wide/32 v12, 0xea60

    sub-long v8, v8, p1

    sub-long v8, v12, v8

    const-wide/16 v12, 0x0

    cmp-long v5, v10, v12

    if-lez v5, :cond_0

    const-wide/16 v12, 0x0

    cmp-long v5, v8, v12

    if-gtz v5, :cond_1

    :cond_0
    const-string v5, "Timed out waiting for adapter."

    invoke-static {v5}, Lcom/google/android/gms/internal/et;->b(Ljava/lang/String;)V

    const/4 v5, 0x3

    iput v5, p0, Lcom/google/android/gms/internal/ar;->h:I

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    iget-object v5, p0, Lcom/google/android/gms/internal/ar;->e:Ljava/lang/Object;

    invoke-static {v10, v11, v8, v9}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v8

    invoke-virtual {v5, v8, v9}, Ljava/lang/Object;->wait(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v5

    const/4 v5, -0x1

    :try_start_2
    iput v5, p0, Lcom/google/android/gms/internal/ar;->h:I

    goto :goto_0

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/at;

    iget-object v1, p0, Lcom/google/android/gms/internal/ar;->a:Lcom/google/android/gms/internal/an;

    iget-object v2, p0, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    iget-object v3, p0, Lcom/google/android/gms/internal/ar;->i:Ljava/lang/String;

    iget v5, p0, Lcom/google/android/gms/internal/ar;->h:I

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/at;-><init>(Lcom/google/android/gms/internal/an;Lcom/google/android/gms/internal/bq;Ljava/lang/String;Lcom/google/android/gms/internal/aq;I)V

    monitor-exit v6
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    return-object v0
.end method

.method final a()Lcom/google/android/gms/internal/bq;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Instantiating mediation adapter: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/google/android/gms/internal/ar;->i:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->b(Ljava/lang/String;)V

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/ar;->j:Lcom/google/android/gms/internal/bn;

    iget-object v1, p0, Lcom/google/android/gms/internal/ar;->i:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/google/android/gms/internal/bn;->a(Ljava/lang/String;)Lcom/google/android/gms/internal/bq;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Could not instantiate mediation adapter: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/google/android/gms/internal/ar;->i:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x3

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->a(I)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "Ads"

    invoke-static {v2, v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final a(I)V
    .locals 2

    iget-object v1, p0, Lcom/google/android/gms/internal/ar;->e:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput p1, p0, Lcom/google/android/gms/internal/ar;->h:I

    iget-object v0, p0, Lcom/google/android/gms/internal/ar;->e:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
