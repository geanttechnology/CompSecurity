.class public abstract Lacy;
.super Ljava/lang/Object;

# interfaces
.implements Ladg;
.implements Lqd;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Landroid/os/IInterface;",
        ">",
        "Ljava/lang/Object;",
        "Ladg;",
        "Lqd;"
    }
.end annotation


# static fields
.field public static final d:[Ljava/lang/String;


# instance fields
.field private final a:Landroid/content/Context;

.field final b:Landroid/os/Handler;

.field c:Z

.field private final e:Landroid/os/Looper;

.field private final f:Ljava/lang/Object;

.field private g:Landroid/os/IInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private final h:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lacy",
            "<TT;>.ada<*>;>;"
        }
    .end annotation
.end field

.field private i:Ladc;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lacy",
            "<TT;>.adc;"
        }
    .end annotation
.end field

.field private j:I

.field private final k:[Ljava/lang/String;

.field private final l:Lade;


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

    sput-object v0, Lacy;->d:[Ljava/lang/String;

    return-void
.end method

.method protected varargs constructor <init>(Landroid/content/Context;Landroid/os/Looper;Lqo;Lqp;[Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lacy;->f:Ljava/lang/Object;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lacy;->h:Ljava/util/ArrayList;

    const/4 v0, 0x1

    iput v0, p0, Lacy;->j:I

    const/4 v0, 0x0

    iput-boolean v0, p0, Lacy;->c:Z

    invoke-static {p1}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    iput-object v0, p0, Lacy;->a:Landroid/content/Context;

    const-string v0, "Looper must not be null"

    invoke-static {p2, v0}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Looper;

    iput-object v0, p0, Lacy;->e:Landroid/os/Looper;

    new-instance v0, Lade;

    invoke-direct {v0, p1, p2, p0}, Lade;-><init>(Landroid/content/Context;Landroid/os/Looper;Ladg;)V

    iput-object v0, p0, Lacy;->l:Lade;

    new-instance v0, Lacz;

    invoke-direct {v0, p0, p2}, Lacz;-><init>(Lacy;Landroid/os/Looper;)V

    iput-object v0, p0, Lacy;->b:Landroid/os/Handler;

    invoke-virtual {p0, p5}, Lacy;->a([Ljava/lang/String;)V

    iput-object p5, p0, Lacy;->k:[Ljava/lang/String;

    invoke-static {p3}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lqo;

    invoke-virtual {p0, v0}, Lacy;->a(Lqo;)V

    invoke-static {p4}, Lady;->a(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lqp;

    invoke-virtual {p0, v0}, Lacy;->a(Lqp;)V

    return-void
.end method

.method static synthetic a(Lacy;Ladc;)Ladc;
    .locals 0

    iput-object p1, p0, Lacy;->i:Ladc;

    return-object p1
.end method

.method static synthetic a(Lacy;)Lade;
    .locals 1

    iget-object v0, p0, Lacy;->l:Lade;

    return-object v0
.end method

.method private a(ILandroid/os/IInterface;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITT;)V"
        }
    .end annotation

    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x3

    if-ne p1, v2, :cond_0

    move v3, v0

    :goto_0
    if-eqz p2, :cond_1

    move v2, v0

    :goto_1
    if-ne v3, v2, :cond_2

    :goto_2
    invoke-static {v0}, Lady;->b(Z)V

    iget-object v1, p0, Lacy;->f:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput p1, p0, Lacy;->j:I

    iput-object p2, p0, Lacy;->g:Landroid/os/IInterface;

    monitor-exit v1

    return-void

    :cond_0
    move v3, v1

    goto :goto_0

    :cond_1
    move v2, v1

    goto :goto_1

    :cond_2
    move v0, v1

    goto :goto_2

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method static synthetic a(Lacy;ILandroid/os/IInterface;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lacy;->a(ILandroid/os/IInterface;)V

    return-void
.end method

.method private a(IILandroid/os/IInterface;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IITT;)Z"
        }
    .end annotation

    iget-object v1, p0, Lacy;->f:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v0, p0, Lacy;->j:I

    if-eq v0, p1, :cond_0

    const/4 v0, 0x0

    monitor-exit v1

    :goto_0
    return v0

    :cond_0
    invoke-direct {p0, p2, p3}, Lacy;->a(ILandroid/os/IInterface;)V

    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method static synthetic a(Lacy;IILandroid/os/IInterface;)Z
    .locals 1

    invoke-direct {p0, p1, p2, p3}, Lacy;->a(IILandroid/os/IInterface;)Z

    move-result v0

    return v0
.end method

.method static synthetic b(Lacy;)Ljava/util/ArrayList;
    .locals 1

    iget-object v0, p0, Lacy;->h:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic c(Lacy;)Ladc;
    .locals 1

    iget-object v0, p0, Lacy;->i:Ladc;

    return-object v0
.end method

.method static synthetic d(Lacy;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lacy;->a:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 4

    const/4 v2, 0x0

    const/4 v3, 0x3

    const/4 v1, 0x1

    iput-boolean v1, p0, Lacy;->c:Z

    const/4 v0, 0x2

    invoke-direct {p0, v0, v2}, Lacy;->a(ILandroid/os/IInterface;)V

    iget-object v0, p0, Lacy;->a:Landroid/content/Context;

    invoke-static {v0}, Lpu;->a(Landroid/content/Context;)I

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0, v1, v2}, Lacy;->a(ILandroid/os/IInterface;)V

    iget-object v1, p0, Lacy;->b:Landroid/os/Handler;

    iget-object v2, p0, Lacy;->b:Landroid/os/Handler;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lacy;->i:Ladc;

    if-eqz v0, :cond_2

    const-string v0, "GmsClient"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Calling connect() while still connected, missing disconnect() for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lacy;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lacy;->a:Landroid/content/Context;

    invoke-static {v0}, Ladh;->a(Landroid/content/Context;)Ladh;

    move-result-object v0

    invoke-virtual {p0}, Lacy;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lacy;->i:Ladc;

    invoke-virtual {v0, v1, v2}, Ladh;->b(Ljava/lang/String;Ladc;)V

    :cond_2
    new-instance v0, Ladc;

    invoke-direct {v0, p0}, Ladc;-><init>(Lacy;)V

    iput-object v0, p0, Lacy;->i:Ladc;

    iget-object v0, p0, Lacy;->a:Landroid/content/Context;

    invoke-static {v0}, Ladh;->a(Landroid/content/Context;)Ladh;

    move-result-object v0

    invoke-virtual {p0}, Lacy;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lacy;->i:Ladc;

    invoke-virtual {v0, v1, v2}, Ladh;->a(Ljava/lang/String;Ladc;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "GmsClient"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unable to connect to service: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lacy;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lacy;->b:Landroid/os/Handler;

    iget-object v1, p0, Lacy;->b:Landroid/os/Handler;

    const/16 v2, 0x9

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method

.method public a(I)V
    .locals 4

    iget-object v0, p0, Lacy;->b:Landroid/os/Handler;

    iget-object v1, p0, Lacy;->b:Landroid/os/Handler;

    const/4 v2, 0x4

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method

.method protected a(ILandroid/os/IBinder;Landroid/os/Bundle;)V
    .locals 4

    iget-object v0, p0, Lacy;->b:Landroid/os/Handler;

    iget-object v1, p0, Lacy;->b:Landroid/os/Handler;

    const/4 v2, 0x1

    new-instance v3, Ladd;

    invoke-direct {v3, p0, p1, p2, p3}, Ladd;-><init>(Lacy;ILandroid/os/IBinder;Landroid/os/Bundle;)V

    invoke-virtual {v1, v2, v3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method

.method public final a(Lada;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lacy",
            "<TT;>.ada<*>;)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    iget-object v1, p0, Lacy;->h:Ljava/util/ArrayList;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lacy;->h:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lacy;->b:Landroid/os/Handler;

    iget-object v1, p0, Lacy;->b:Landroid/os/Handler;

    const/4 v2, 0x2

    invoke-virtual {v1, v2, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method protected abstract a(Ladp;Ladb;)V
.end method

.method public a(Lqo;)V
    .locals 1

    iget-object v0, p0, Lacy;->l:Lade;

    invoke-virtual {v0, p1}, Lade;->a(Lqo;)V

    return-void
.end method

.method public a(Lqp;)V
    .locals 1

    iget-object v0, p0, Lacy;->l:Lade;

    invoke-virtual {v0, p1}, Lade;->a(Lpr;)V

    return-void
.end method

.method protected varargs a([Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method protected abstract b(Landroid/os/IBinder;)Landroid/os/IInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/IBinder;",
            ")TT;"
        }
    .end annotation
.end method

.method public b()V
    .locals 5

    const/4 v4, 0x0

    const/4 v0, 0x0

    iput-boolean v0, p0, Lacy;->c:Z

    iget-object v2, p0, Lacy;->h:Ljava/util/ArrayList;

    monitor-enter v2

    :try_start_0
    iget-object v1, p0, Lacy;->h:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    iget-object v0, p0, Lacy;->h:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lada;

    invoke-virtual {v0}, Lada;->d()V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lacy;->h:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/4 v0, 0x1

    invoke-direct {p0, v0, v4}, Lacy;->a(ILandroid/os/IInterface;)V

    iget-object v0, p0, Lacy;->i:Ladc;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lacy;->a:Landroid/content/Context;

    invoke-static {v0}, Ladh;->a(Landroid/content/Context;)Ladh;

    move-result-object v0

    invoke-virtual {p0}, Lacy;->d()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lacy;->i:Ladc;

    invoke-virtual {v0, v1, v2}, Ladh;->b(Ljava/lang/String;Ladc;)V

    iput-object v4, p0, Lacy;->i:Ladc;

    :cond_1
    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method protected final c(Landroid/os/IBinder;)V
    .locals 3

    :try_start_0
    invoke-static {p1}, Ladq;->a(Landroid/os/IBinder;)Ladp;

    move-result-object v0

    new-instance v1, Ladb;

    invoke-direct {v1, p0}, Ladb;-><init>(Lacy;)V

    invoke-virtual {p0, v0, v1}, Lacy;->a(Ladp;Ladb;)V
    :try_end_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_1

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v0, "GmsClient"

    const-string v1, "service died"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lacy;->a(I)V

    goto :goto_0

    :catch_1
    move-exception v0

    const-string v1, "GmsClient"

    const-string v2, "Remote exception occurred"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public c()Z
    .locals 3

    iget-object v1, p0, Lacy;->f:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v0, p0, Lacy;->j:I

    const/4 v2, 0x3

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public c_()Landroid/os/Bundle;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method protected abstract d()Ljava/lang/String;
.end method

.method public d_()Z
    .locals 1

    iget-boolean v0, p0, Lacy;->c:Z

    return v0
.end method

.method protected abstract e()Ljava/lang/String;
.end method

.method public g()Z
    .locals 3

    iget-object v1, p0, Lacy;->f:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v0, p0, Lacy;->j:I

    const/4 v2, 0x2

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final h()Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lacy;->a:Landroid/content/Context;

    return-object v0
.end method

.method protected final i()V
    .locals 2

    invoke-virtual {p0}, Lacy;->c()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Not connected. Call connect() and wait for onConnected() to be called."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method public final j()Landroid/os/IInterface;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget-object v1, p0, Lacy;->f:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v0, p0, Lacy;->j:I

    const/4 v2, 0x4

    if-ne v0, v2, :cond_0

    new-instance v0, Landroid/os/DeadObjectException;

    invoke-direct {v0}, Landroid/os/DeadObjectException;-><init>()V

    throw v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lacy;->i()V

    iget-object v0, p0, Lacy;->g:Landroid/os/IInterface;

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    const-string v2, "Client is connected but service is null"

    invoke-static {v0, v2}, Lady;->a(ZLjava/lang/Object;)V

    iget-object v0, p0, Lacy;->g:Landroid/os/IInterface;

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
