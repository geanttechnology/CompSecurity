.class final Lqw;
.super Ljava/lang/Object;

# interfaces
.implements Lqm;


# instance fields
.field final a:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lra",
            "<*>;>;"
        }
    .end annotation
.end field

.field final b:Landroid/os/Handler;

.field c:Landroid/content/BroadcastReceiver;

.field final d:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lra",
            "<*>;>;"
        }
    .end annotation
.end field

.field private final e:Ljava/util/concurrent/locks/Lock;

.field private final f:Ljava/util/concurrent/locks/Condition;

.field private final g:Lade;

.field private final h:I

.field private final i:Landroid/content/Context;

.field private final j:Landroid/os/Looper;

.field private k:Lpp;

.field private l:I

.field private volatile m:I

.field private volatile n:Z

.field private o:Z

.field private p:I

.field private q:J

.field private r:J

.field private final s:Landroid/os/Bundle;

.field private final t:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lqf",
            "<*>;",
            "Lqd;",
            ">;"
        }
    .end annotation
.end field

.field private final u:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private v:Z

.field private final w:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lrb",
            "<*>;>;"
        }
    .end annotation
.end field

.field private final x:Lqy;

.field private final y:Lqo;

.field private final z:Ladg;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;I)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/os/Looper;",
            "Lcom/google/android/gms/internal/jg;",
            "Ljava/util/Map",
            "<",
            "Lpx",
            "<*>;",
            "Lpy;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Lqo;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Lqp;",
            ">;I)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v2, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v2}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v2, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    iget-object v2, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v2

    iput-object v2, p0, Lqw;->f:Ljava/util/concurrent/locks/Condition;

    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    iput-object v2, p0, Lqw;->a:Ljava/util/Queue;

    const/4 v2, 0x4

    iput v2, p0, Lqw;->m:I

    const/4 v2, 0x0

    iput-boolean v2, p0, Lqw;->o:Z

    const-wide/32 v2, 0x1d4c0

    iput-wide v2, p0, Lqw;->q:J

    const-wide/16 v2, 0x1388

    iput-wide v2, p0, Lqw;->r:J

    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    iput-object v2, p0, Lqw;->s:Landroid/os/Bundle;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    iput-object v2, p0, Lqw;->t:Ljava/util/Map;

    new-instance v2, Ljava/util/WeakHashMap;

    invoke-direct {v2}, Ljava/util/WeakHashMap;-><init>()V

    invoke-static {v2}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v2

    iput-object v2, p0, Lqw;->w:Ljava/util/Set;

    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v2}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v2}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v2

    iput-object v2, p0, Lqw;->d:Ljava/util/Set;

    new-instance v2, Lqw$1;

    invoke-direct {v2, p0}, Lqw$1;-><init>(Lqw;)V

    iput-object v2, p0, Lqw;->x:Lqy;

    new-instance v2, Lqw$2;

    invoke-direct {v2, p0}, Lqw$2;-><init>(Lqw;)V

    iput-object v2, p0, Lqw;->y:Lqo;

    new-instance v2, Lqw$3;

    invoke-direct {v2, p0}, Lqw$3;-><init>(Lqw;)V

    iput-object v2, p0, Lqw;->z:Ladg;

    iput-object p1, p0, Lqw;->i:Landroid/content/Context;

    new-instance v2, Lade;

    iget-object v3, p0, Lqw;->z:Ladg;

    invoke-direct {v2, p1, p2, v3}, Lade;-><init>(Landroid/content/Context;Landroid/os/Looper;Ladg;)V

    iput-object v2, p0, Lqw;->g:Lade;

    iput-object p2, p0, Lqw;->j:Landroid/os/Looper;

    new-instance v2, Lqz;

    invoke-direct {v2, p0, p2}, Lqz;-><init>(Lqw;Landroid/os/Looper;)V

    iput-object v2, p0, Lqw;->b:Landroid/os/Handler;

    move/from16 v0, p7

    iput v0, p0, Lqw;->h:I

    invoke-interface/range {p5 .. p5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lqo;

    iget-object v4, p0, Lqw;->g:Lade;

    invoke-virtual {v4, v2}, Lade;->a(Lqo;)V

    goto :goto_0

    :cond_0
    invoke-interface/range {p6 .. p6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lqp;

    iget-object v4, p0, Lqw;->g:Lade;

    invoke-virtual {v4, v2}, Lade;->a(Lpr;)V

    goto :goto_1

    :cond_1
    invoke-interface/range {p4 .. p4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    move-object v4, v2

    check-cast v4, Lpx;

    invoke-virtual {v4}, Lpx;->a()Lqe;

    move-result-object v2

    move-object/from16 v0, p4

    invoke-interface {v0, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    iget-object v10, p0, Lqw;->t:Ljava/util/Map;

    invoke-virtual {v4}, Lpx;->c()Lqf;

    move-result-object v11

    iget-object v7, p0, Lqw;->y:Lqo;

    new-instance v8, Lqw$4;

    invoke-direct {v8, p0, v2}, Lqw$4;-><init>(Lqw;Lqe;)V

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    invoke-static/range {v2 .. v8}, Lqw;->a(Lqe;Ljava/lang/Object;Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Lqo;Lqp;)Lqd;

    move-result-object v2

    invoke-interface {v10, v11, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    :cond_2
    invoke-virtual {p3}, Lcom/google/android/gms/internal/jg;->b()Ljava/util/List;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lqw;->u:Ljava/util/List;

    return-void
.end method

.method static synthetic a(Lqw;)Ljava/util/concurrent/locks/Lock;
    .locals 1

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    return-object v0
.end method

.method static synthetic a(Lqw;Lpp;)Lpp;
    .locals 0

    iput-object p1, p0, Lqw;->k:Lpp;

    return-object p1
.end method

.method private static a(Lqe;Ljava/lang/Object;Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Lqo;Lqp;)Lqd;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<C::",
            "Lqd;",
            "O:",
            "Ljava/lang/Object;",
            ">(",
            "Lqe",
            "<TC;TO;>;",
            "Ljava/lang/Object;",
            "Landroid/content/Context;",
            "Landroid/os/Looper;",
            "Lcom/google/android/gms/internal/jg;",
            "Lqo;",
            "Lqp;",
            ")TC;"
        }
    .end annotation

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v4, p1

    move-object v5, p5

    move-object v6, p6

    invoke-interface/range {v0 .. v6}, Lqe;->a(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Ljava/lang/Object;Lqo;Lqp;)Lqd;

    move-result-object v0

    return-object v0
.end method

.method private a(I)V
    .locals 5

    const/4 v1, 0x3

    const/4 v3, 0x1

    const/4 v4, -0x1

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    iget v0, p0, Lqw;->m:I

    if-eq v0, v1, :cond_b

    if-ne p1, v4, :cond_5

    invoke-virtual {p0}, Lqw;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lqw;->a:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lra;

    invoke-interface {v0}, Lra;->g()I

    move-result v2

    if-eq v2, v3, :cond_0

    invoke-interface {v0}, Lra;->c()V

    invoke-interface {v1}, Ljava/util/Iterator;->remove()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    :cond_1
    :try_start_1
    iget-object v0, p0, Lqw;->a:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    :cond_2
    iget-object v0, p0, Lqw;->d:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lra;

    invoke-interface {v0}, Lra;->c()V

    goto :goto_1

    :cond_3
    iget-object v0, p0, Lqw;->d:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    iget-object v0, p0, Lqw;->w:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lrb;

    invoke-virtual {v0}, Lrb;->a()V

    goto :goto_2

    :cond_4
    iget-object v0, p0, Lqw;->w:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    iget-object v0, p0, Lqw;->k:Lpp;

    if-nez v0, :cond_5

    iget-object v0, p0, Lqw;->a:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    const/4 v0, 0x1

    iput-boolean v0, p0, Lqw;->o:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    :goto_3
    return-void

    :cond_5
    :try_start_2
    invoke-virtual {p0}, Lqw;->e()Z

    move-result v0

    invoke-virtual {p0}, Lqw;->d()Z

    move-result v1

    const/4 v2, 0x3

    iput v2, p0, Lqw;->m:I

    if-eqz v0, :cond_7

    if-ne p1, v4, :cond_6

    const/4 v0, 0x0

    iput-object v0, p0, Lqw;->k:Lpp;

    :cond_6
    iget-object v0, p0, Lqw;->f:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V

    :cond_7
    const/4 v0, 0x0

    iput-boolean v0, p0, Lqw;->v:Z

    iget-object v0, p0, Lqw;->t:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_8
    :goto_4
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lqd;

    invoke-interface {v0}, Lqd;->c()Z

    move-result v3

    if-eqz v3, :cond_8

    invoke-interface {v0}, Lqd;->b()V

    goto :goto_4

    :cond_9
    const/4 v0, 0x1

    iput-boolean v0, p0, Lqw;->v:Z

    const/4 v0, 0x4

    iput v0, p0, Lqw;->m:I

    if-eqz v1, :cond_b

    if-eq p1, v4, :cond_a

    iget-object v0, p0, Lqw;->g:Lade;

    invoke-virtual {v0, p1}, Lade;->a(I)V

    :cond_a
    const/4 v0, 0x0

    iput-boolean v0, p0, Lqw;->v:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_b
    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_3
.end method

.method static synthetic a(Lqw;I)V
    .locals 0

    invoke-direct {p0, p1}, Lqw;->a(I)V

    return-void
.end method

.method private a(Lra;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<A::",
            "Lqd;",
            ">(",
            "Lra",
            "<TA;>;)V"
        }
    .end annotation

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    invoke-interface {p1}, Lra;->f()Lqf;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v1, "This task can not be executed or enqueued (it\'s probably a Batch or malformed)"

    invoke-static {v0, v1}, Lady;->b(ZLjava/lang/Object;)V

    iget-object v0, p0, Lqw;->d:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lqw;->x:Lqy;

    invoke-interface {p1, v0}, Lra;->a(Lqy;)V

    invoke-virtual {p0}, Lqw;->f()Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-interface {p1, v0}, Lra;->b(Lcom/google/android/gms/common/api/Status;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    :goto_1
    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    :try_start_1
    invoke-interface {p1}, Lra;->f()Lqf;

    move-result-object v0

    invoke-virtual {p0, v0}, Lqw;->a(Lqf;)Lqd;

    move-result-object v0

    invoke-interface {p1, v0}, Lra;->a(Lqd;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method static synthetic a(Lqw;Z)Z
    .locals 0

    iput-boolean p1, p0, Lqw;->n:Z

    return p1
.end method

.method static synthetic b(Lqw;)I
    .locals 1

    iget v0, p0, Lqw;->m:I

    return v0
.end method

.method static synthetic b(Lqw;I)I
    .locals 0

    iput p1, p0, Lqw;->l:I

    return p1
.end method

.method static synthetic c(Lqw;)Landroid/os/Bundle;
    .locals 1

    iget-object v0, p0, Lqw;->s:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic d(Lqw;)V
    .locals 0

    invoke-direct {p0}, Lqw;->g()V

    return-void
.end method

.method static synthetic e(Lqw;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lqw;->i:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic f(Lqw;)J
    .locals 2

    iget-wide v0, p0, Lqw;->q:J

    return-wide v0
.end method

.method static synthetic g(Lqw;)J
    .locals 2

    iget-wide v0, p0, Lqw;->r:J

    return-wide v0
.end method

.method private g()V
    .locals 3

    const/4 v2, 0x0

    iget v0, p0, Lqw;->p:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lqw;->p:I

    iget v0, p0, Lqw;->p:I

    if-nez v0, :cond_2

    iget-object v0, p0, Lqw;->k:Lpp;

    if-eqz v0, :cond_3

    iput-boolean v2, p0, Lqw;->o:Z

    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lqw;->a(I)V

    invoke-virtual {p0}, Lqw;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lqw;->i:Landroid/content/Context;

    iget-object v1, p0, Lqw;->k:Lpp;

    invoke-virtual {v1}, Lpp;->c()I

    move-result v1

    invoke-static {v0, v1}, Lpu;->c(Landroid/content/Context;I)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-direct {p0}, Lqw;->j()V

    iget-object v0, p0, Lqw;->g:Lade;

    iget-object v1, p0, Lqw;->k:Lpp;

    invoke-virtual {v0, v1}, Lade;->a(Lpp;)V

    :cond_1
    iput-boolean v2, p0, Lqw;->v:Z

    :cond_2
    :goto_0
    return-void

    :cond_3
    const/4 v0, 0x2

    iput v0, p0, Lqw;->m:I

    invoke-direct {p0}, Lqw;->j()V

    iget-object v0, p0, Lqw;->f:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V

    invoke-direct {p0}, Lqw;->h()V

    iget-boolean v0, p0, Lqw;->o:Z

    if-eqz v0, :cond_4

    iput-boolean v2, p0, Lqw;->o:Z

    const/4 v0, -0x1

    invoke-direct {p0, v0}, Lqw;->a(I)V

    goto :goto_0

    :cond_4
    iget-object v0, p0, Lqw;->s:Landroid/os/Bundle;

    invoke-virtual {v0}, Landroid/os/Bundle;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_5

    const/4 v0, 0x0

    :goto_1
    iget-object v1, p0, Lqw;->g:Lade;

    invoke-virtual {v1, v0}, Lade;->a(Landroid/os/Bundle;)V

    goto :goto_0

    :cond_5
    iget-object v0, p0, Lqw;->s:Landroid/os/Bundle;

    goto :goto_1
.end method

.method private h()V
    .locals 3

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    invoke-virtual {p0}, Lqw;->d()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lqw;->f()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    const-string v1, "GoogleApiClient is not connected yet."

    invoke-static {v0, v1}, Lady;->a(ZLjava/lang/Object;)V

    :goto_1
    iget-object v0, p0, Lqw;->a:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->isEmpty()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_2

    :try_start_1
    iget-object v0, p0, Lqw;->a:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->remove()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lra;

    invoke-direct {p0, v0}, Lqw;->a(Lra;)V
    :try_end_1
    .catch Landroid/os/DeadObjectException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catch_0
    move-exception v0

    :try_start_2
    const-string v1, "GoogleApiClientImpl"

    const-string v2, "Service died while flushing queue"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void
.end method

.method static synthetic h(Lqw;)Z
    .locals 1

    iget-boolean v0, p0, Lqw;->v:Z

    return v0
.end method

.method private i()V
    .locals 2

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    invoke-virtual {p0}, Lqw;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lqw;->b()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method static synthetic i(Lqw;)V
    .locals 0

    invoke-direct {p0}, Lqw;->j()V

    return-void
.end method

.method private j()V
    .locals 2

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    iget-boolean v0, p0, Lqw;->n:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    :goto_0
    return-void

    :cond_0
    const/4 v0, 0x0

    :try_start_1
    iput-boolean v0, p0, Lqw;->n:Z

    iget-object v0, p0, Lqw;->b:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lqw;->b:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lqw;->i:Landroid/content/Context;

    iget-object v1, p0, Lqw;->c:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method static synthetic j(Lqw;)V
    .locals 0

    invoke-direct {p0}, Lqw;->i()V

    return-void
.end method

.method static synthetic k(Lqw;)Lpp;
    .locals 1

    iget-object v0, p0, Lqw;->k:Lpp;

    return-object v0
.end method

.method static synthetic l(Lqw;)I
    .locals 1

    iget v0, p0, Lqw;->l:I

    return v0
.end method


# virtual methods
.method public a()Landroid/os/Looper;
    .locals 1

    iget-object v0, p0, Lqw;->j:Landroid/os/Looper;

    return-object v0
.end method

.method public a(JLjava/util/concurrent/TimeUnit;)Lpp;
    .locals 5

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_1

    const/4 v0, 0x1

    :goto_0
    const-string v1, "blockingConnect must not be called on the UI thread"

    invoke-static {v0, v1}, Lady;->a(ZLjava/lang/Object;)V

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    invoke-virtual {p0}, Lqw;->b()V

    invoke-virtual {p3, p1, p2}, Ljava/util/concurrent/TimeUnit;->toNanos(J)J

    move-result-wide v0

    :cond_0
    invoke-virtual {p0}, Lqw;->e()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-eqz v2, :cond_2

    :try_start_1
    iget-object v2, p0, Lqw;->f:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v2, v0, v1}, Ljava/util/concurrent/locks/Condition;->awaitNanos(J)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-gtz v2, :cond_0

    new-instance v0, Lpp;

    const/16 v1, 0xe

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lpp;-><init>(ILandroid/app/PendingIntent;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    :goto_1
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    new-instance v0, Lpp;

    const/16 v1, 0xf

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lpp;-><init>(ILandroid/app/PendingIntent;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_1

    :cond_2
    :try_start_3
    invoke-virtual {p0}, Lqw;->d()Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lpp;->a:Lpp;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_1

    :cond_3
    :try_start_4
    iget-object v0, p0, Lqw;->k:Lpp;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lqw;->k:Lpp;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_1

    :cond_4
    :try_start_5
    new-instance v0, Lpp;

    const/16 v1, 0xd

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lpp;-><init>(ILandroid/app/PendingIntent;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public a(Lqf;)Lqd;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<C::",
            "Lqd;",
            ">(",
            "Lqf",
            "<TC;>;)TC;"
        }
    .end annotation

    iget-object v0, p0, Lqw;->t:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lqd;

    const-string v1, "Appropriate Api was not requested."

    invoke-static {v0, v1}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-object v0
.end method

.method public a(Lqj;)Lqj;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<A::",
            "Lqd;",
            "R::",
            "Lqt;",
            "T:",
            "Lqj",
            "<TR;TA;>;>(TT;)TT;"
        }
    .end annotation

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    invoke-virtual {p0}, Lqw;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lqw;->b(Lqj;)Lqj;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-object p1

    :cond_0
    :try_start_1
    iget-object v0, p0, Lqw;->a:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public a(Lqo;)V
    .locals 1

    iget-object v0, p0, Lqw;->g:Lade;

    invoke-virtual {v0, p1}, Lade;->a(Lqo;)V

    return-void
.end method

.method public a(Lqp;)V
    .locals 1

    iget-object v0, p0, Lqw;->g:Lade;

    invoke-virtual {v0, p1}, Lade;->a(Lpr;)V

    return-void
.end method

.method public b(Lqj;)Lqj;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<A::",
            "Lqd;",
            "T:",
            "Lqj",
            "<+",
            "Lqt;",
            "TA;>;>(TT;)TT;"
        }
    .end annotation

    const/4 v1, 0x1

    invoke-virtual {p0}, Lqw;->d()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lqw;->f()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v1

    :goto_0
    const-string v2, "GoogleApiClient is not connected yet."

    invoke-static {v0, v2}, Lady;->a(ZLjava/lang/Object;)V

    invoke-direct {p0}, Lqw;->h()V

    :try_start_0
    invoke-direct {p0, p1}, Lqw;->a(Lra;)V
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    return-object p1

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-direct {p0, v1}, Lqw;->a(I)V

    goto :goto_1
.end method

.method public b()V
    .locals 2

    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    const/4 v0, 0x0

    :try_start_0
    iput-boolean v0, p0, Lqw;->o:Z

    invoke-virtual {p0}, Lqw;->d()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lqw;->e()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    :goto_0
    return-void

    :cond_1
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lqw;->v:Z

    const/4 v0, 0x0

    iput-object v0, p0, Lqw;->k:Lpp;

    const/4 v0, 0x1

    iput v0, p0, Lqw;->m:I

    iget-object v0, p0, Lqw;->s:Landroid/os/Bundle;

    invoke-virtual {v0}, Landroid/os/Bundle;->clear()V

    iget-object v0, p0, Lqw;->t:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    iput v0, p0, Lqw;->p:I

    iget-object v0, p0, Lqw;->t:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lqd;

    invoke-interface {v0}, Lqd;->a()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    :cond_2
    iget-object v0, p0, Lqw;->e:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0
.end method

.method public b(Lqo;)V
    .locals 1

    iget-object v0, p0, Lqw;->g:Lade;

    invoke-virtual {v0, p1}, Lade;->b(Lqo;)V

    return-void
.end method

.method public b(Lqp;)V
    .locals 1

    iget-object v0, p0, Lqw;->g:Lade;

    invoke-virtual {v0, p1}, Lade;->b(Lpr;)V

    return-void
.end method

.method public c()V
    .locals 1

    invoke-direct {p0}, Lqw;->j()V

    const/4 v0, -0x1

    invoke-direct {p0, v0}, Lqw;->a(I)V

    return-void
.end method

.method public d()Z
    .locals 2

    iget v0, p0, Lqw;->m:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public e()Z
    .locals 2

    const/4 v0, 0x1

    iget v1, p0, Lqw;->m:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method f()Z
    .locals 1

    iget-boolean v0, p0, Lqw;->n:Z

    return v0
.end method
