.class public final Lvt;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lcom/google/android/gms/internal/fh;

.field private final b:Lwd;

.field private final c:Landroid/content/Context;

.field private final d:Ljava/lang/Object;

.field private final e:Lvv;

.field private f:Z

.field private g:Lvy;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Lwd;Lvv;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lvt;->d:Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lvt;->f:Z

    iput-object p1, p0, Lvt;->c:Landroid/content/Context;

    iput-object p2, p0, Lvt;->a:Lcom/google/android/gms/internal/fh;

    iput-object p3, p0, Lvt;->b:Lwd;

    iput-object p4, p0, Lvt;->e:Lvv;

    return-void
.end method


# virtual methods
.method public a(JJ)Lvz;
    .locals 17

    const-string v4, "Starting mediation."

    invoke-static {v4}, Lacb;->a(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v4, v0, Lvt;->e:Lvv;

    iget-object v4, v4, Lvv;->a:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :cond_0
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lvu;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Trying mediation network: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, v9, Lvu;->b:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lacb;->c(Ljava/lang/String;)V

    iget-object v4, v9, Lvu;->c:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :cond_1
    :goto_0
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v15, v0, Lvt;->d:Ljava/lang/Object;

    monitor-enter v15

    :try_start_0
    move-object/from16 v0, p0

    iget-boolean v4, v0, Lvt;->f:Z

    if-eqz v4, :cond_2

    new-instance v4, Lvz;

    const/4 v5, -0x1

    invoke-direct {v4, v5}, Lvz;-><init>(I)V

    monitor-exit v15

    :goto_1
    return-object v4

    :cond_2
    new-instance v4, Lvy;

    move-object/from16 v0, p0

    iget-object v5, v0, Lvt;->c:Landroid/content/Context;

    move-object/from16 v0, p0

    iget-object v7, v0, Lvt;->b:Lwd;

    move-object/from16 v0, p0

    iget-object v8, v0, Lvt;->e:Lvv;

    move-object/from16 v0, p0

    iget-object v10, v0, Lvt;->a:Lcom/google/android/gms/internal/fh;

    iget-object v10, v10, Lcom/google/android/gms/internal/fh;->c:Lcom/google/android/gms/internal/av;

    move-object/from16 v0, p0

    iget-object v11, v0, Lvt;->a:Lcom/google/android/gms/internal/fh;

    iget-object v11, v11, Lcom/google/android/gms/internal/fh;->d:Lcom/google/android/gms/internal/ay;

    move-object/from16 v0, p0

    iget-object v12, v0, Lvt;->a:Lcom/google/android/gms/internal/fh;

    iget-object v12, v12, Lcom/google/android/gms/internal/fh;->k:Lcom/google/android/gms/internal/gs;

    invoke-direct/range {v4 .. v12}, Lvy;-><init>(Landroid/content/Context;Ljava/lang/String;Lwd;Lvv;Lvu;Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/ay;Lcom/google/android/gms/internal/gs;)V

    move-object/from16 v0, p0

    iput-object v4, v0, Lvt;->g:Lvy;

    monitor-exit v15
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object/from16 v0, p0

    iget-object v4, v0, Lvt;->g:Lvy;

    move-wide/from16 v0, p1

    move-wide/from16 v2, p3

    invoke-virtual {v4, v0, v1, v2, v3}, Lvy;->a(JJ)Lvz;

    move-result-object v4

    iget v5, v4, Lvz;->a:I

    if-nez v5, :cond_3

    const-string v5, "Adapter succeeded."

    invoke-static {v5}, Lacb;->a(Ljava/lang/String;)V

    goto :goto_1

    :catchall_0
    move-exception v4

    :try_start_1
    monitor-exit v15
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v4

    :cond_3
    iget-object v5, v4, Lvz;->c:Lwg;

    if-eqz v5, :cond_1

    sget-object v5, Laca;->a:Landroid/os/Handler;

    new-instance v6, Lvt$1;

    move-object/from16 v0, p0

    invoke-direct {v6, v0, v4}, Lvt$1;-><init>(Lvt;Lvz;)V

    invoke-virtual {v5, v6}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    :cond_4
    new-instance v4, Lvz;

    const/4 v5, 0x1

    invoke-direct {v4, v5}, Lvz;-><init>(I)V

    goto :goto_1
.end method

.method public a()V
    .locals 2

    iget-object v1, p0, Lvt;->d:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_0
    iput-boolean v0, p0, Lvt;->f:Z

    iget-object v0, p0, Lvt;->g:Lvy;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lvt;->g:Lvy;

    invoke-virtual {v0}, Lvy;->a()V

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
