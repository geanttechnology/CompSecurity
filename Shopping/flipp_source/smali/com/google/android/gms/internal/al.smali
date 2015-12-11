.class public final Lcom/google/android/gms/internal/al;
.super Ljava/lang/Object;


# instance fields
.field final a:Ljava/lang/Object;

.field b:Z

.field c:Lcom/google/android/gms/internal/ar;

.field private final d:Lcom/google/android/gms/internal/bz;

.field private final e:Lcom/google/android/gms/internal/bn;

.field private final f:Landroid/content/Context;

.field private final g:Lcom/google/android/gms/internal/ao;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/bn;Lcom/google/android/gms/internal/ao;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/al;->a:Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/al;->b:Z

    iput-object p1, p0, Lcom/google/android/gms/internal/al;->f:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/al;->d:Lcom/google/android/gms/internal/bz;

    iput-object p3, p0, Lcom/google/android/gms/internal/al;->e:Lcom/google/android/gms/internal/bn;

    iput-object p4, p0, Lcom/google/android/gms/internal/al;->g:Lcom/google/android/gms/internal/ao;

    return-void
.end method


# virtual methods
.method public final a(J)Lcom/google/android/gms/internal/at;
    .locals 13

    const-string v0, "Starting mediation."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/al;->g:Lcom/google/android/gms/internal/ao;

    iget-object v0, v0, Lcom/google/android/gms/internal/ao;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gms/internal/an;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Trying mediation network: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, v5, Lcom/google/android/gms/internal/an;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->b(Ljava/lang/String;)V

    iget-object v0, v5, Lcom/google/android/gms/internal/an;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :cond_1
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iget-object v11, p0, Lcom/google/android/gms/internal/al;->a:Ljava/lang/Object;

    monitor-enter v11

    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gms/internal/al;->b:Z

    if-eqz v0, :cond_2

    new-instance v0, Lcom/google/android/gms/internal/at;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/at;-><init>(I)V

    monitor-exit v11

    :goto_1
    return-object v0

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/ar;

    iget-object v1, p0, Lcom/google/android/gms/internal/al;->f:Landroid/content/Context;

    iget-object v3, p0, Lcom/google/android/gms/internal/al;->e:Lcom/google/android/gms/internal/bn;

    iget-object v4, p0, Lcom/google/android/gms/internal/al;->g:Lcom/google/android/gms/internal/ao;

    iget-object v6, p0, Lcom/google/android/gms/internal/al;->d:Lcom/google/android/gms/internal/bz;

    iget-object v6, v6, Lcom/google/android/gms/internal/bz;->c:Lcom/google/android/gms/internal/v;

    iget-object v7, p0, Lcom/google/android/gms/internal/al;->d:Lcom/google/android/gms/internal/bz;

    iget-object v7, v7, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget-object v8, p0, Lcom/google/android/gms/internal/al;->d:Lcom/google/android/gms/internal/bz;

    iget-object v8, v8, Lcom/google/android/gms/internal/bz;->k:Lcom/google/android/gms/internal/cu;

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gms/internal/ar;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/internal/bn;Lcom/google/android/gms/internal/ao;Lcom/google/android/gms/internal/an;Lcom/google/android/gms/internal/v;Lcom/google/android/gms/internal/x;Lcom/google/android/gms/internal/cu;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/al;->c:Lcom/google/android/gms/internal/ar;

    monitor-exit v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/google/android/gms/internal/al;->c:Lcom/google/android/gms/internal/ar;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gms/internal/ar;->a(J)Lcom/google/android/gms/internal/at;

    move-result-object v0

    iget v1, v0, Lcom/google/android/gms/internal/at;->a:I

    if-nez v1, :cond_3

    const-string v1, "Adapter succeeded."

    invoke-static {v1}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    goto :goto_1

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v11
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_3
    iget-object v1, v0, Lcom/google/android/gms/internal/at;->c:Lcom/google/android/gms/internal/bq;

    if-eqz v1, :cond_1

    sget-object v1, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    new-instance v2, Lcom/google/android/gms/internal/am;

    invoke-direct {v2, p0, v0}, Lcom/google/android/gms/internal/am;-><init>(Lcom/google/android/gms/internal/al;Lcom/google/android/gms/internal/at;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    :cond_4
    new-instance v0, Lcom/google/android/gms/internal/at;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/at;-><init>(I)V

    goto :goto_1
.end method
