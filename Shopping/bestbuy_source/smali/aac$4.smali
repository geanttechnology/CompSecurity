.class Laac$4;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laac;->a(J)V
.end annotation


# instance fields
.field final synthetic a:Lzy;

.field final synthetic b:Laac;


# direct methods
.method constructor <init>(Laac;Lzy;)V
    .locals 0

    iput-object p1, p0, Laac$4;->b:Laac;

    iput-object p2, p0, Laac$4;->a:Lzy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Laac$4;->b:Laac;

    invoke-static {v0}, Laac;->a(Laac;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Laac$4;->b:Laac;

    invoke-static {v0}, Laac;->c(Laac;)Lcom/google/android/gms/internal/fj;

    move-result-object v0

    iget v0, v0, Lcom/google/android/gms/internal/fj;->e:I

    const/4 v2, -0x2

    if-eq v0, v2, :cond_0

    monitor-exit v1

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Laac$4;->b:Laac;

    invoke-static {v0}, Laac;->d(Laac;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v0

    iget-object v2, p0, Laac$4;->b:Laac;

    invoke-virtual {v0, v2}, Lace;->a(Lacf;)V

    iget-object v0, p0, Laac$4;->a:Lzy;

    iget-object v2, p0, Laac$4;->b:Laac;

    invoke-static {v2}, Laac;->c(Laac;)Lcom/google/android/gms/internal/fj;

    move-result-object v2

    invoke-virtual {v0, v2}, Lzy;->a(Lcom/google/android/gms/internal/fj;)V

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
