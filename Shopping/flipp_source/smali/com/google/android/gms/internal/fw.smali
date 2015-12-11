.class public abstract Lcom/google/android/gms/internal/fw;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/b;
.implements Lcom/google/android/gms/internal/gg;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Landroid/os/IInterface;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/common/b;",
        "Lcom/google/android/gms/internal/gg;"
    }
.end annotation


# static fields
.field public static final e:[Ljava/lang/String;


# instance fields
.field final a:Landroid/content/Context;

.field final b:Landroid/os/Handler;

.field c:Z

.field d:Z

.field private f:Landroid/os/IInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private final g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/internal/fw",
            "<TT;>.com/google/android/gms/internal/fy<*>;>;"
        }
    .end annotation
.end field

.field private h:Lcom/google/android/gms/internal/gb;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/fw",
            "<TT;>.com/google/android/gms/internal/gb;"
        }
    .end annotation
.end field

.field private final i:[Ljava/lang/String;

.field private final j:Lcom/google/android/gms/internal/ge;

.field private final k:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "service_esmobile"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "service_googleme"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gms/internal/fw;->e:[Ljava/lang/String;

    return-void
.end method

.method private varargs constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/api/b;Lcom/google/android/gms/common/api/c;[Ljava/lang/String;)V
    .locals 6

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/fw;->g:Ljava/util/ArrayList;

    iput-boolean v1, p0, Lcom/google/android/gms/internal/fw;->c:Z

    iput-boolean v1, p0, Lcom/google/android/gms/internal/fw;->d:Z

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/fw;->k:Ljava/lang/Object;

    invoke-static {p1}, Lcom/google/android/gms/internal/ha;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    iput-object v0, p0, Lcom/google/android/gms/internal/fw;->a:Landroid/content/Context;

    new-instance v0, Lcom/google/android/gms/internal/ge;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/ge;-><init>(Lcom/google/android/gms/internal/gg;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/fw;->j:Lcom/google/android/gms/internal/ge;

    new-instance v0, Lcom/google/android/gms/internal/fx;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/fx;-><init>(Lcom/google/android/gms/internal/fw;Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/fw;->b:Landroid/os/Handler;

    iput-object p4, p0, Lcom/google/android/gms/internal/fw;->i:[Ljava/lang/String;

    invoke-static {p2}, Lcom/google/android/gms/internal/ha;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/b;

    iget-object v1, p0, Lcom/google/android/gms/internal/fw;->j:Lcom/google/android/gms/internal/ge;

    invoke-static {v0}, Lcom/google/android/gms/internal/ha;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, v1, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    monitor-enter v2

    :try_start_0
    iget-object v3, v1, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v3, "GmsClientEvents"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "registerConnectionCallbacks(): listener "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " is already registered"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :goto_0
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v2, v1, Lcom/google/android/gms/internal/ge;->a:Lcom/google/android/gms/internal/gg;

    invoke-interface {v2}, Lcom/google/android/gms/internal/gg;->e()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, v1, Lcom/google/android/gms/internal/ge;->f:Landroid/os/Handler;

    iget-object v1, v1, Lcom/google/android/gms/internal/ge;->f:Landroid/os/Handler;

    const/4 v3, 0x1

    invoke-virtual {v1, v3, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    :cond_0
    invoke-static {p3}, Lcom/google/android/gms/internal/ha;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/c;

    iget-object v1, p0, Lcom/google/android/gms/internal/fw;->j:Lcom/google/android/gms/internal/ge;

    invoke-static {v0}, Lcom/google/android/gms/internal/ha;->a(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, v1, Lcom/google/android/gms/internal/ge;->e:Ljava/util/ArrayList;

    monitor-enter v2

    :try_start_1
    iget-object v3, v1, Lcom/google/android/gms/internal/ge;->e:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    const-string v1, "GmsClientEvents"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "registerConnectionFailedListener(): listener "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " is already registered"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    return-void

    :cond_1
    :try_start_2
    iget-boolean v3, v1, Lcom/google/android/gms/internal/ge;->d:Z

    if-eqz v3, :cond_2

    new-instance v3, Ljava/util/ArrayList;

    iget-object v4, v1, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v3, v1, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    :cond_2
    iget-object v3, v1, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    :cond_3
    :try_start_3
    iget-boolean v3, v1, Lcom/google/android/gms/internal/ge;->g:Z

    if-eqz v3, :cond_4

    new-instance v3, Ljava/util/ArrayList;

    iget-object v4, v1, Lcom/google/android/gms/internal/ge;->e:Ljava/util/ArrayList;

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v3, v1, Lcom/google/android/gms/internal/ge;->e:Ljava/util/ArrayList;

    :cond_4
    iget-object v1, v1, Lcom/google/android/gms/internal/ge;->e:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :catchall_1
    move-exception v0

    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0
.end method

.method protected varargs constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;[Ljava/lang/String;)V
    .locals 2

    new-instance v0, Lcom/google/android/gms/internal/fz;

    invoke-direct {v0, p2}, Lcom/google/android/gms/internal/fz;-><init>(Lcom/google/android/gms/common/c;)V

    new-instance v1, Lcom/google/android/gms/internal/gc;

    invoke-direct {v1, p3}, Lcom/google/android/gms/internal/gc;-><init>(Lcom/google/android/gms/common/d;)V

    invoke-direct {p0, p1, v0, v1, p4}, Lcom/google/android/gms/internal/fw;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/api/b;Lcom/google/android/gms/common/api/c;[Ljava/lang/String;)V

    return-void
.end method

.method static synthetic a(Lcom/google/android/gms/internal/fw;Landroid/os/IInterface;)Landroid/os/IInterface;
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/fw;->f:Landroid/os/IInterface;

    return-object p1
.end method

.method static synthetic a(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/ge;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->j:Lcom/google/android/gms/internal/ge;

    return-object v0
.end method

.method static synthetic b(Lcom/google/android/gms/internal/fw;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->k:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic c(Lcom/google/android/gms/internal/fw;)Ljava/util/ArrayList;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->g:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic d(Lcom/google/android/gms/internal/fw;)Landroid/os/IInterface;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->f:Landroid/os/IInterface;

    return-object v0
.end method

.method static synthetic e(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/gb;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    return-object v0
.end method

.method static synthetic f(Lcom/google/android/gms/internal/fw;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->a:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic g(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/gb;
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    return-object v0
.end method


# virtual methods
.method protected abstract a(Landroid/os/IBinder;)Landroid/os/IInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/IBinder;",
            ")TT;"
        }
    .end annotation
.end method

.method protected abstract a()Ljava/lang/String;
.end method

.method protected abstract a(Lcom/google/android/gms/internal/gr;Lcom/google/android/gms/internal/ga;)V
.end method

.method protected abstract b()Ljava/lang/String;
.end method

.method protected final b(Landroid/os/IBinder;)V
    .locals 2

    :try_start_0
    invoke-static {p1}, Lcom/google/android/gms/internal/gs;->a(Landroid/os/IBinder;)Lcom/google/android/gms/internal/gr;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/ga;

    invoke-direct {v1, p0}, Lcom/google/android/gms/internal/ga;-><init>(Lcom/google/android/gms/internal/fw;)V

    invoke-virtual {p0, v0, v1}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/gr;Lcom/google/android/gms/internal/ga;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v0, "GmsClient"

    const-string v1, "service died"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public final d()V
    .locals 4

    const/4 v3, 0x3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/fw;->c:Z

    iget-object v1, p0, Lcom/google/android/gms/internal/fw;->k:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_0
    iput-boolean v0, p0, Lcom/google/android/gms/internal/fw;->d:Z

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/common/g;->a(Landroid/content/Context;)I

    move-result v0

    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/google/android/gms/internal/fw;->b:Landroid/os/Handler;

    iget-object v2, p0, Lcom/google/android/gms/internal/fw;->b:Landroid/os/Handler;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    :cond_0
    :goto_0
    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    if-eqz v0, :cond_2

    const-string v0, "GmsClient"

    const-string v1, "Calling connect() while still connected, missing disconnect()."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/fw;->f:Landroid/os/IInterface;

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/gi;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/gi;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/fw;->a()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gi;->b(Ljava/lang/String;Lcom/google/android/gms/internal/gb;)V

    :cond_2
    new-instance v0, Lcom/google/android/gms/internal/gb;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/gb;-><init>(Lcom/google/android/gms/internal/fw;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/gi;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/gi;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/fw;->a()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gi;->a(Ljava/lang/String;Lcom/google/android/gms/internal/gb;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "GmsClient"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "unable to connect to service: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/android/gms/internal/fw;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->b:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gms/internal/fw;->b:Landroid/os/Handler;

    const/16 v2, 0x9

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method

.method public final e()Z
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->f:Landroid/os/IInterface;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final f()Z
    .locals 2

    iget-object v1, p0, Lcom/google/android/gms/internal/fw;->k:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gms/internal/fw;->d:Z

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public g()V
    .locals 5

    const/4 v4, 0x0

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/fw;->c:Z

    iget-object v1, p0, Lcom/google/android/gms/internal/fw;->k:Ljava/lang/Object;

    monitor-enter v1

    const/4 v2, 0x0

    :try_start_0
    iput-boolean v2, p0, Lcom/google/android/gms/internal/fw;->d:Z

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v2, p0, Lcom/google/android/gms/internal/fw;->g:Ljava/util/ArrayList;

    monitor-enter v2

    :try_start_1
    iget-object v1, p0, Lcom/google/android/gms/internal/fw;->g:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->g:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/fy;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/fy;->c()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    :cond_0
    :try_start_3
    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    iput-object v4, p0, Lcom/google/android/gms/internal/fw;->f:Landroid/os/IInterface;

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/android/gms/internal/gi;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/gi;

    move-result-object v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/fw;->a()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gi;->b(Ljava/lang/String;Lcom/google/android/gms/internal/gb;)V

    iput-object v4, p0, Lcom/google/android/gms/internal/fw;->h:Lcom/google/android/gms/internal/gb;

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->j:Lcom/google/android/gms/internal/ge;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ge;->a()V

    :cond_1
    return-void

    :catchall_1
    move-exception v0

    :try_start_4
    monitor-exit v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v0
.end method

.method protected final h()V
    .locals 2

    invoke-virtual {p0}, Lcom/google/android/gms/internal/fw;->e()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Not connected. Call connect() and wait for onConnected() to be called."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method protected final i()Landroid/os/IInterface;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/internal/fw;->h()V

    iget-object v0, p0, Lcom/google/android/gms/internal/fw;->f:Landroid/os/IInterface;

    return-object v0
.end method

.method public final j()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/internal/fw;->c:Z

    return v0
.end method
