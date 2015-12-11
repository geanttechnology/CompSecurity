.class public abstract Laag;
.super Labn;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lcom/google/android/gms/internal/fh;

.field private final b:Laaf;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/fh;Laaf;)V
    .locals 0

    invoke-direct {p0}, Labn;-><init>()V

    iput-object p1, p0, Laag;->a:Lcom/google/android/gms/internal/fh;

    iput-object p2, p0, Laag;->b:Laaf;

    return-void
.end method

.method private static a(Laan;Lcom/google/android/gms/internal/fh;)Lcom/google/android/gms/internal/fj;
    .locals 3

    const/4 v0, 0x0

    :try_start_0
    invoke-interface {p0, p1}, Laan;->a(Lcom/google/android/gms/internal/fh;)Lcom/google/android/gms/internal/fj;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    const-string v2, "Could not fetch ad response from ad request service."

    invoke-static {v2, v1}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    :catch_1
    move-exception v1

    const-string v2, "Could not fetch ad response from ad request service due to an Exception."

    invoke-static {v2, v1}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    :catch_2
    move-exception v1

    const-string v2, "Could not fetch ad response from ad request service due to an Exception."

    invoke-static {v2, v1}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    :catch_3
    move-exception v1

    invoke-static {v1}, Labi;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 2

    :try_start_0
    invoke-virtual {p0}, Laag;->d()Laan;

    move-result-object v0

    if-nez v0, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/fj;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/fj;-><init>(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    invoke-virtual {p0}, Laag;->c()V

    iget-object v1, p0, Laag;->b:Laaf;

    invoke-interface {v1, v0}, Laaf;->a(Lcom/google/android/gms/internal/fj;)V

    return-void

    :cond_1
    :try_start_1
    iget-object v1, p0, Laag;->a:Lcom/google/android/gms/internal/fh;

    invoke-static {v0, v1}, Laag;->a(Laan;Lcom/google/android/gms/internal/fh;)Lcom/google/android/gms/internal/fj;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/fj;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/fj;-><init>(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Laag;->c()V

    throw v0
.end method

.method public final b()V
    .locals 0

    invoke-virtual {p0}, Laag;->c()V

    return-void
.end method

.method public abstract c()V
.end method

.method public abstract d()Laan;
.end method
