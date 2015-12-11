.class final Lcom/google/android/gms/internal/dx;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/af;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/dw;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/dw;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/dx;->a:Lcom/google/android/gms/internal/dw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/internal/ew;Ljava/util/Map;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/ew;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/dx;->a:Lcom/google/android/gms/internal/dw;

    iget-object v2, v0, Lcom/google/android/gms/internal/dw;->a:Ljava/lang/Object;

    monitor-enter v2

    :try_start_0
    const-string v0, "type"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v1, "errors"

    invoke-interface {p2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Invalid "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " request error: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/dx;->a:Lcom/google/android/gms/internal/dw;

    const/4 v1, 0x1

    iput v1, v0, Lcom/google/android/gms/internal/dw;->d:I

    iget-object v0, p0, Lcom/google/android/gms/internal/dx;->a:Lcom/google/android/gms/internal/dw;

    iget-object v0, v0, Lcom/google/android/gms/internal/dw;->a:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v2

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
