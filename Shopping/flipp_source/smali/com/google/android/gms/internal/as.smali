.class final Lcom/google/android/gms/internal/as;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/aq;

.field final synthetic b:Lcom/google/android/gms/internal/ar;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/ar;Lcom/google/android/gms/internal/aq;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    iput-object p2, p0, Lcom/google/android/gms/internal/as;->a:Lcom/google/android/gms/internal/aq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 15

    iget-object v0, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    iget-object v13, v0, Lcom/google/android/gms/internal/ar;->e:Ljava/lang/Object;

    monitor-enter v13

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    iget v0, v0, Lcom/google/android/gms/internal/ar;->h:I

    const/4 v1, -0x2

    if-eq v0, v1, :cond_0

    monitor-exit v13

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    iget-object v1, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/ar;->a()Lcom/google/android/gms/internal/bq;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    iget-object v0, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    iget-object v0, v0, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/ar;->a(I)V

    monitor-exit v13

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v13
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/as;->a:Lcom/google/android/gms/internal/aq;

    iget-object v1, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    iget-object v2, v0, Lcom/google/android/gms/internal/aq;->a:Ljava/lang/Object;

    monitor-enter v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iput-object v1, v0, Lcom/google/android/gms/internal/aq;->b:Lcom/google/android/gms/internal/au;

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :try_start_3
    iget-object v14, p0, Lcom/google/android/gms/internal/as;->b:Lcom/google/android/gms/internal/ar;

    iget-object v5, p0, Lcom/google/android/gms/internal/as;->a:Lcom/google/android/gms/internal/aq;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->f:Lcom/google/android/gms/internal/cu;

    iget v0, v0, Lcom/google/android/gms/internal/cu;->d:I

    const v1, 0x3e8fa0

    if-ge v0, v1, :cond_3

    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->c:Lcom/google/android/gms/internal/x;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/x;->e:Z

    if-eqz v0, :cond_2

    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    iget-object v1, v14, Lcom/google/android/gms/internal/ar;->d:Landroid/content/Context;

    invoke-static {v1}, Lcom/google/android/gms/a/d;->a(Ljava/lang/Object;)Lcom/google/android/gms/a/a;

    move-result-object v1

    iget-object v2, v14, Lcom/google/android/gms/internal/ar;->b:Lcom/google/android/gms/internal/v;

    iget-object v3, v14, Lcom/google/android/gms/internal/ar;->a:Lcom/google/android/gms/internal/an;

    iget-object v3, v3, Lcom/google/android/gms/internal/an;->f:Ljava/lang/String;

    invoke-interface {v0, v1, v2, v3, v5}, Lcom/google/android/gms/internal/bq;->a(Lcom/google/android/gms/a/a;Lcom/google/android/gms/internal/v;Ljava/lang/String;Lcom/google/android/gms/internal/bt;)V
    :try_end_4
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :goto_1
    :try_start_5
    monitor-exit v13
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_0

    :catchall_1
    move-exception v0

    :try_start_6
    monitor-exit v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    :try_start_7
    throw v0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    :cond_2
    :try_start_8
    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    iget-object v1, v14, Lcom/google/android/gms/internal/ar;->d:Landroid/content/Context;

    invoke-static {v1}, Lcom/google/android/gms/a/d;->a(Ljava/lang/Object;)Lcom/google/android/gms/a/a;

    move-result-object v1

    iget-object v2, v14, Lcom/google/android/gms/internal/ar;->c:Lcom/google/android/gms/internal/x;

    iget-object v3, v14, Lcom/google/android/gms/internal/ar;->b:Lcom/google/android/gms/internal/v;

    iget-object v4, v14, Lcom/google/android/gms/internal/ar;->a:Lcom/google/android/gms/internal/an;

    iget-object v4, v4, Lcom/google/android/gms/internal/an;->f:Ljava/lang/String;

    invoke-interface/range {v0 .. v5}, Lcom/google/android/gms/internal/bq;->a(Lcom/google/android/gms/a/a;Lcom/google/android/gms/internal/x;Lcom/google/android/gms/internal/v;Ljava/lang/String;Lcom/google/android/gms/internal/bt;)V
    :try_end_8
    .catch Landroid/os/RemoteException; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_1

    :catch_0
    move-exception v0

    :try_start_9
    const-string v1, "Could not request ad from mediation adapter."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x5

    invoke-virtual {v14, v0}, Lcom/google/android/gms/internal/ar;->a(I)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto :goto_1

    :cond_3
    :try_start_a
    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->c:Lcom/google/android/gms/internal/x;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/x;->e:Z

    if-eqz v0, :cond_4

    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    iget-object v1, v14, Lcom/google/android/gms/internal/ar;->d:Landroid/content/Context;

    invoke-static {v1}, Lcom/google/android/gms/a/d;->a(Ljava/lang/Object;)Lcom/google/android/gms/a/a;

    move-result-object v1

    iget-object v2, v14, Lcom/google/android/gms/internal/ar;->b:Lcom/google/android/gms/internal/v;

    iget-object v3, v14, Lcom/google/android/gms/internal/ar;->a:Lcom/google/android/gms/internal/an;

    iget-object v3, v3, Lcom/google/android/gms/internal/an;->f:Ljava/lang/String;

    iget-object v4, v14, Lcom/google/android/gms/internal/ar;->a:Lcom/google/android/gms/internal/an;

    iget-object v4, v4, Lcom/google/android/gms/internal/an;->a:Ljava/lang/String;

    invoke-interface/range {v0 .. v5}, Lcom/google/android/gms/internal/bq;->a(Lcom/google/android/gms/a/a;Lcom/google/android/gms/internal/v;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/bt;)V

    goto :goto_1

    :cond_4
    iget-object v6, v14, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->d:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/a/d;->a(Ljava/lang/Object;)Lcom/google/android/gms/a/a;

    move-result-object v7

    iget-object v8, v14, Lcom/google/android/gms/internal/ar;->c:Lcom/google/android/gms/internal/x;

    iget-object v9, v14, Lcom/google/android/gms/internal/ar;->b:Lcom/google/android/gms/internal/v;

    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->a:Lcom/google/android/gms/internal/an;

    iget-object v10, v0, Lcom/google/android/gms/internal/an;->f:Ljava/lang/String;

    iget-object v0, v14, Lcom/google/android/gms/internal/ar;->a:Lcom/google/android/gms/internal/an;

    iget-object v11, v0, Lcom/google/android/gms/internal/an;->a:Ljava/lang/String;

    move-object v12, v5

    invoke-interface/range {v6 .. v12}, Lcom/google/android/gms/internal/bq;->a(Lcom/google/android/gms/a/a;Lcom/google/android/gms/internal/x;Lcom/google/android/gms/internal/v;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/bt;)V
    :try_end_a
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_a} :catch_0
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    goto :goto_1
.end method
