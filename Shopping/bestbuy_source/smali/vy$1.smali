.class Lvy$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lvy;->a(JJ)Lvz;
.end annotation


# instance fields
.field final synthetic a:Lvx;

.field final synthetic b:Lvy;


# direct methods
.method constructor <init>(Lvy;Lvx;)V
    .locals 0

    iput-object p1, p0, Lvy$1;->b:Lvy;

    iput-object p2, p0, Lvy$1;->a:Lvx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lvy$1;->b:Lvy;

    invoke-static {v0}, Lvy;->a(Lvy;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lvy$1;->b:Lvy;

    invoke-static {v0}, Lvy;->b(Lvy;)I

    move-result v0

    const/4 v2, -0x2

    if-eq v0, v2, :cond_0

    monitor-exit v1

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lvy$1;->b:Lvy;

    iget-object v2, p0, Lvy$1;->b:Lvy;

    invoke-static {v2}, Lvy;->c(Lvy;)Lwg;

    move-result-object v2

    invoke-static {v0, v2}, Lvy;->a(Lvy;Lwg;)Lwg;

    iget-object v0, p0, Lvy$1;->b:Lvy;

    invoke-static {v0}, Lvy;->d(Lvy;)Lwg;

    move-result-object v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lvy$1;->b:Lvy;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Lvy;->a(I)V

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    iget-object v0, p0, Lvy$1;->a:Lvx;

    iget-object v2, p0, Lvy$1;->b:Lvy;

    invoke-virtual {v0, v2}, Lvx;->a(Lwa;)V

    iget-object v0, p0, Lvy$1;->b:Lvy;

    iget-object v2, p0, Lvy$1;->a:Lvx;

    invoke-static {v0, v2}, Lvy;->a(Lvy;Lvx;)V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method
