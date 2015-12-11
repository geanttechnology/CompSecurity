.class public Labi;
.super Ljava/lang/Object;

# interfaces
.implements Lvm;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field public static final a:Ljava/lang/String;

.field private static final c:Labi;


# instance fields
.field public final b:Ljava/lang/String;

.field private final d:Ljava/lang/Object;

.field private final e:Labj;

.field private f:Laef;

.field private g:Ljava/math/BigInteger;

.field private final h:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Labf;",
            ">;"
        }
    .end annotation
.end field

.field private final i:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Labl;",
            ">;"
        }
    .end annotation
.end field

.field private j:Z

.field private k:Z

.field private l:Z

.field private m:Landroid/content/Context;

.field private n:Lcom/google/android/gms/internal/gs;

.field private o:Z

.field private p:Lsx;

.field private q:Lsy;

.field private r:Lsw;

.field private s:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Ljava/lang/Thread;",
            ">;"
        }
    .end annotation
.end field

.field private t:Z

.field private u:Landroid/os/Bundle;

.field private v:Lze;

.field private w:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Labi;

    invoke-direct {v0}, Labi;-><init>()V

    sput-object v0, Labi;->c:Labi;

    sget-object v0, Labi;->c:Labi;

    iget-object v0, v0, Labi;->b:Ljava/lang/String;

    sput-object v0, Labi;->a:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 4

    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Labi;->d:Ljava/lang/Object;

    sget-object v0, Ljava/math/BigInteger;->ONE:Ljava/math/BigInteger;

    iput-object v0, p0, Labi;->g:Ljava/math/BigInteger;

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Labi;->h:Ljava/util/HashSet;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Labi;->i:Ljava/util/HashMap;

    iput-boolean v2, p0, Labi;->j:Z

    iput-boolean v3, p0, Labi;->k:Z

    iput-boolean v2, p0, Labi;->l:Z

    iput-boolean v3, p0, Labi;->o:Z

    iput-object v1, p0, Labi;->p:Lsx;

    iput-object v1, p0, Labi;->q:Lsy;

    iput-object v1, p0, Labi;->r:Lsw;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Labi;->s:Ljava/util/LinkedList;

    iput-boolean v2, p0, Labi;->t:Z

    invoke-static {}, Lug;->a()Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Labi;->u:Landroid/os/Bundle;

    iput-object v1, p0, Labi;->v:Lze;

    invoke-static {}, Labq;->e()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Labi;->b:Ljava/lang/String;

    new-instance v0, Labj;

    iget-object v1, p0, Labi;->b:Ljava/lang/String;

    invoke-direct {v0, v1}, Labj;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Labi;->e:Labj;

    return-void
.end method

.method public static a()Labi;
    .locals 1

    sget-object v0, Labi;->c:Labi;

    return-object v0
.end method

.method public static a(Landroid/content/Context;Labk;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0, p0, p1, p2}, Labi;->b(Landroid/content/Context;Labk;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public static a(ILjava/lang/String;)Ljava/lang/String;
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0, p0, p1}, Labi;->b(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/content/Context;Lcom/google/android/gms/internal/gs;)V
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0, p0, p1}, Labi;->b(Landroid/content/Context;Lcom/google/android/gms/internal/gs;)V

    return-void
.end method

.method public static a(Landroid/content/Context;Z)V
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0, p0, p1}, Labi;->b(Landroid/content/Context;Z)V

    return-void
.end method

.method public static a(Ljava/lang/Throwable;)V
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0, p0}, Labi;->b(Ljava/lang/Throwable;)V

    return-void
.end method

.method public static a(Ljava/util/HashSet;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashSet",
            "<",
            "Labf;",
            ">;)V"
        }
    .end annotation

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0, p0}, Labi;->b(Ljava/util/HashSet;)V

    return-void
.end method

.method public static d()Ljava/lang/String;
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0}, Labi;->e()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static f()Labj;
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0}, Labi;->g()Labj;

    move-result-object v0

    return-object v0
.end method

.method public static h()Z
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0}, Labi;->i()Z

    move-result v0

    return v0
.end method

.method public static j()Z
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0}, Labi;->k()Z

    move-result v0

    return v0
.end method

.method public static l()Ljava/lang/String;
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0}, Labi;->m()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static n()Landroid/os/Bundle;
    .locals 1

    sget-object v0, Labi;->c:Labi;

    invoke-virtual {v0}, Labi;->o()Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lsy;
    .locals 10

    const/4 v0, 0x0

    invoke-static {}, Labi;->n()Landroid/os/Bundle;

    move-result-object v1

    sget-object v2, Lug;->i:Laco;

    invoke-virtual {v2}, Laco;->a()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Laej;->c()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Labi;->c()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v2, p0, Labi;->p:Lsx;

    if-nez v2, :cond_3

    instance-of v2, p1, Landroid/app/Activity;

    if-nez v2, :cond_2

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_2
    :try_start_1
    new-instance v2, Lsx;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Application;

    check-cast p1, Landroid/app/Activity;

    invoke-direct {v2, v0, p1}, Lsx;-><init>(Landroid/app/Application;Landroid/app/Activity;)V

    iput-object v2, p0, Labi;->p:Lsx;

    :cond_3
    iget-object v0, p0, Labi;->r:Lsw;

    if-nez v0, :cond_4

    new-instance v0, Lsw;

    invoke-direct {v0}, Lsw;-><init>()V

    iput-object v0, p0, Labi;->r:Lsw;

    :cond_4
    iget-object v0, p0, Labi;->q:Lsy;

    if-nez v0, :cond_5

    new-instance v0, Lsy;

    iget-object v2, p0, Labi;->p:Lsx;

    iget-object v3, p0, Labi;->r:Lsw;

    iget-object v4, p0, Labi;->u:Landroid/os/Bundle;

    new-instance v5, Lze;

    iget-object v6, p0, Labi;->m:Landroid/content/Context;

    iget-object v7, p0, Labi;->n:Lcom/google/android/gms/internal/gs;

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-direct {v5, v6, v7, v8, v9}, Lze;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/gs;Ljava/lang/Thread$UncaughtExceptionHandler;Ljava/lang/Thread$UncaughtExceptionHandler;)V

    invoke-direct {v0, v2, v3, v4, v5}, Lsy;-><init>(Lsx;Lsw;Landroid/os/Bundle;Lze;)V

    iput-object v0, p0, Labi;->q:Lsy;

    :cond_5
    iget-object v0, p0, Labi;->q:Lsy;

    invoke-virtual {v0}, Lsy;->a()V

    iget-object v0, p0, Labi;->q:Lsy;

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public a(Labf;)V
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Labi;->h:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 4

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_0
    iput-boolean v0, p0, Labi;->t:Z

    iput-object p1, p0, Labi;->u:Landroid/os/Bundle;

    :goto_0
    iget-object v0, p0, Labi;->s:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v2, p0, Labi;->m:Landroid/content/Context;

    iget-object v0, p0, Labi;->s:Ljava/util/LinkedList;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Ljava/util/LinkedList;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Thread;

    iget-object v3, p0, Labi;->n:Lcom/google/android/gms/internal/gs;

    invoke-static {v2, v0, v3}, Lze;->a(Landroid/content/Context;Ljava/lang/Thread;Lcom/google/android/gms/internal/gs;)Lze;

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method

.method public a(Ljava/lang/String;Labl;)V
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Labi;->i:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Ljava/lang/Thread;)V
    .locals 3

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Labi;->t:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Labi;->m:Landroid/content/Context;

    iget-object v2, p0, Labi;->n:Lcom/google/android/gms/internal/gs;

    invoke-static {v0, p1, v2}, Lze;->a(Landroid/content/Context;Ljava/lang/Thread;Lcom/google/android/gms/internal/gs;)Lze;

    :goto_0
    monitor-exit v1

    return-void

    :cond_0
    iget-object v0, p0, Labi;->s:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Z)V
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput-boolean p1, p0, Labi;->o:Z

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public b()Laef;
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Labi;->f:Laef;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public b(Landroid/content/Context;Labk;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 6

    iget-object v2, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v2

    :try_start_0
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    const-string v0, "app"

    iget-object v1, p0, Labi;->e:Labj;

    invoke-virtual {v1, p1, p3}, Labj;->a(Landroid/content/Context;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    iget-object v0, p0, Labi;->i:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Labi;->i:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Labl;

    invoke-virtual {v1}, Labl;->a()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    const-string v0, "slots"

    invoke-virtual {v3, v0, v4}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Labi;->h:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Labf;

    invoke-virtual {v0}, Labf;->d()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_1
    const-string v0, "ads"

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    iget-object v0, p0, Labi;->h:Ljava/util/HashSet;

    invoke-interface {p2, v0}, Labk;->a(Ljava/util/HashSet;)V

    iget-object v0, p0, Labi;->h:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v3
.end method

.method public b(ILjava/lang/String;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Labi;->n:Lcom/google/android/gms/internal/gs;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/gs;->e:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Labi;->m:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    :goto_0
    if-nez v0, :cond_1

    :goto_1
    return-object p2

    :cond_0
    iget-object v0, p0, Labi;->m:Landroid/content/Context;

    invoke-static {v0}, Lpu;->c(Landroid/content/Context;)Landroid/content/res/Resources;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p2

    goto :goto_1
.end method

.method public b(Landroid/content/Context;Lcom/google/android/gms/internal/gs;)V
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Labi;->l:Z

    if-nez v0, :cond_0

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Labi;->m:Landroid/content/Context;

    iput-object p2, p0, Labi;->n:Lcom/google/android/gms/internal/gs;

    invoke-static {p1}, Labo;->a(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Labi;->k:Z

    invoke-static {p1}, Laco;->a(Landroid/content/Context;)V

    invoke-static {p1, p0}, Lvk;->a(Landroid/content/Context;Lvm;)V

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {p0, v0}, Labi;->a(Ljava/lang/Thread;)V

    iget-object v0, p2, Lcom/google/android/gms/internal/gs;->b:Ljava/lang/String;

    invoke-static {p1, v0}, Labq;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Labi;->w:Ljava/lang/String;

    new-instance v0, Laeg;

    invoke-direct {v0}, Laeg;-><init>()V

    iput-object v0, p0, Labi;->f:Laef;

    const/4 v0, 0x1

    iput-boolean v0, p0, Labi;->l:Z

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

.method public b(Landroid/content/Context;Z)V
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Labi;->k:Z

    if-eq p2, v0, :cond_0

    iput-boolean p2, p0, Labi;->k:Z

    invoke-static {p1, p2}, Labo;->a(Landroid/content/Context;Z)V

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

.method public b(Ljava/lang/Throwable;)V
    .locals 4

    const/4 v3, 0x0

    iget-boolean v0, p0, Labi;->l:Z

    if-eqz v0, :cond_0

    new-instance v0, Lze;

    iget-object v1, p0, Labi;->m:Landroid/content/Context;

    iget-object v2, p0, Labi;->n:Lcom/google/android/gms/internal/gs;

    invoke-direct {v0, v1, v2, v3, v3}, Lze;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/gs;Ljava/lang/Thread$UncaughtExceptionHandler;Ljava/lang/Thread$UncaughtExceptionHandler;)V

    invoke-virtual {v0, p1}, Lze;->b(Ljava/lang/Throwable;)V

    :cond_0
    return-void
.end method

.method public b(Ljava/util/HashSet;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashSet",
            "<",
            "Labf;",
            ">;)V"
        }
    .end annotation

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Labi;->h:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public c()Z
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Labi;->o:Z

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public e()Ljava/lang/String;
    .locals 4

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Labi;->g:Ljava/math/BigInteger;

    invoke-virtual {v0}, Ljava/math/BigInteger;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Labi;->g:Ljava/math/BigInteger;

    sget-object v3, Ljava/math/BigInteger;->ONE:Ljava/math/BigInteger;

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->add(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    iput-object v2, p0, Labi;->g:Ljava/math/BigInteger;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public g()Labj;
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Labi;->e:Labj;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public i()Z
    .locals 3

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Labi;->j:Z

    const/4 v2, 0x1

    iput-boolean v2, p0, Labi;->j:Z

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public k()Z
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Labi;->k:Z

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public m()Ljava/lang/String;
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Labi;->w:Ljava/lang/String;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public o()Landroid/os/Bundle;
    .locals 2

    iget-object v1, p0, Labi;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Labi;->u:Landroid/os/Bundle;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
