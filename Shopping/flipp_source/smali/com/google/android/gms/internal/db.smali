.class final Lcom/google/android/gms/internal/db;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/eb;

.field final synthetic b:Lcom/google/android/gms/internal/cz;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/cz;Lcom/google/android/gms/internal/eb;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/db;->b:Lcom/google/android/gms/internal/cz;

    iput-object p2, p0, Lcom/google/android/gms/internal/db;->a:Lcom/google/android/gms/internal/eb;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/internal/db;->b:Lcom/google/android/gms/internal/cz;

    iget-object v1, v0, Lcom/google/android/gms/internal/cz;->c:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/db;->b:Lcom/google/android/gms/internal/cz;

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->a:Lcom/google/android/gms/internal/cy;

    iget-object v2, p0, Lcom/google/android/gms/internal/db;->a:Lcom/google/android/gms/internal/eb;

    invoke-interface {v0, v2}, Lcom/google/android/gms/internal/cy;->a(Lcom/google/android/gms/internal/eb;)V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
