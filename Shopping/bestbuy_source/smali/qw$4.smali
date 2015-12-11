.class Lqw$4;
.super Ljava/lang/Object;

# interfaces
.implements Lqp;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lqw;-><init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/internal/jg;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;I)V
.end annotation


# instance fields
.field final synthetic a:Lqe;

.field final synthetic b:Lqw;


# direct methods
.method constructor <init>(Lqw;Lqe;)V
    .locals 0

    iput-object p1, p0, Lqw$4;->b:Lqw;

    iput-object p2, p0, Lqw$4;->a:Lqe;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConnectionFailed(Lpp;)V
    .locals 2

    iget-object v0, p0, Lqw$4;->b:Lqw;

    invoke-static {v0}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    iget-object v0, p0, Lqw$4;->b:Lqw;

    invoke-static {v0}, Lqw;->k(Lqw;)Lpp;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lqw$4;->a:Lqe;

    invoke-interface {v0}, Lqe;->a()I

    move-result v0

    iget-object v1, p0, Lqw$4;->b:Lqw;

    invoke-static {v1}, Lqw;->l(Lqw;)I

    move-result v1

    if-ge v0, v1, :cond_1

    :cond_0
    iget-object v0, p0, Lqw$4;->b:Lqw;

    invoke-static {v0, p1}, Lqw;->a(Lqw;Lpp;)Lpp;

    iget-object v0, p0, Lqw$4;->b:Lqw;

    iget-object v1, p0, Lqw$4;->a:Lqe;

    invoke-interface {v1}, Lqe;->a()I

    move-result v1

    invoke-static {v0, v1}, Lqw;->b(Lqw;I)I

    :cond_1
    iget-object v0, p0, Lqw$4;->b:Lqw;

    invoke-static {v0}, Lqw;->d(Lqw;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lqw$4;->b:Lqw;

    invoke-static {v0}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw$4;->b:Lqw;

    invoke-static {v1}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method
