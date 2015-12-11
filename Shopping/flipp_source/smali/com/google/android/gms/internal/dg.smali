.class public abstract Lcom/google/android/gms/internal/dg;
.super Lcom/google/android/gms/internal/ee;


# instance fields
.field private final a:Lcom/google/android/gms/internal/bz;

.field private final b:Lcom/google/android/gms/internal/df;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/df;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/ee;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/dg;->a:Lcom/google/android/gms/internal/bz;

    iput-object p2, p0, Lcom/google/android/gms/internal/dg;->b:Lcom/google/android/gms/internal/df;

    return-void
.end method

.method private static a(Lcom/google/android/gms/internal/do;Lcom/google/android/gms/internal/bz;)Lcom/google/android/gms/internal/cb;
    .locals 2

    :try_start_0
    invoke-interface {p0, p1}, Lcom/google/android/gms/internal/do;->a(Lcom/google/android/gms/internal/bz;)Lcom/google/android/gms/internal/cb;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "Could not fetch ad response from ad request service."

    invoke-static {v1, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 2

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/dg;->d()Lcom/google/android/gms/internal/do;

    move-result-object v0

    if-nez v0, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/cb;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cb;-><init>(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/dg;->c()V

    iget-object v1, p0, Lcom/google/android/gms/internal/dg;->b:Lcom/google/android/gms/internal/df;

    invoke-interface {v1, v0}, Lcom/google/android/gms/internal/df;->a(Lcom/google/android/gms/internal/cb;)V

    return-void

    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/google/android/gms/internal/dg;->a:Lcom/google/android/gms/internal/bz;

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/dg;->a(Lcom/google/android/gms/internal/do;Lcom/google/android/gms/internal/bz;)Lcom/google/android/gms/internal/cb;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/cb;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/cb;-><init>(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/dg;->c()V

    throw v0
.end method

.method public final b_()V
    .locals 0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/dg;->c()V

    return-void
.end method

.method public abstract c()V
.end method

.method public abstract d()Lcom/google/android/gms/internal/do;
.end method
