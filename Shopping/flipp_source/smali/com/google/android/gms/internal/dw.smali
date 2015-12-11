.class public final Lcom/google/android/gms/internal/dw;
.super Ljava/lang/Object;


# instance fields
.field final a:Ljava/lang/Object;

.field b:Lcom/google/android/gms/internal/ew;

.field c:Ljava/lang/String;

.field d:I

.field e:Ljava/lang/String;

.field public final f:Lcom/google/android/gms/internal/af;

.field public final g:Lcom/google/android/gms/internal/af;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/dw;->a:Ljava/lang/Object;

    const/4 v0, -0x2

    iput v0, p0, Lcom/google/android/gms/internal/dw;->d:I

    new-instance v0, Lcom/google/android/gms/internal/dx;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/dx;-><init>(Lcom/google/android/gms/internal/dw;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/dw;->f:Lcom/google/android/gms/internal/af;

    new-instance v0, Lcom/google/android/gms/internal/dy;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/dy;-><init>(Lcom/google/android/gms/internal/dw;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/dw;->g:Lcom/google/android/gms/internal/af;

    iput-object p1, p0, Lcom/google/android/gms/internal/dw;->c:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final a()I
    .locals 2

    iget-object v1, p0, Lcom/google/android/gms/internal/dw;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget v0, p0, Lcom/google/android/gms/internal/dw;->d:I

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final b()Ljava/lang/String;
    .locals 3

    iget-object v1, p0, Lcom/google/android/gms/internal/dw;->a:Ljava/lang/Object;

    monitor-enter v1

    :goto_0
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/dw;->e:Ljava/lang/String;

    if-nez v0, :cond_0

    iget v0, p0, Lcom/google/android/gms/internal/dw;->d:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/4 v2, -0x2

    if-ne v0, v2, :cond_0

    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/internal/dw;->a:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    const-string v0, "Ad request service was interrupted."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    const/4 v0, 0x0

    monitor-exit v1

    :goto_1
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/dw;->e:Ljava/lang/String;

    monitor-exit v1

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0
.end method
