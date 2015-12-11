.class final Lcom/google/android/gms/internal/ck;
.super Ljava/lang/Object;


# instance fields
.field final a:Ljava/lang/Runnable;

.field volatile b:Z


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/cj;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/ck;->b:Z

    new-instance v0, Lcom/google/android/gms/internal/cl;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gms/internal/cl;-><init>(Lcom/google/android/gms/internal/ck;Lcom/google/android/gms/internal/cj;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/ck;->a:Ljava/lang/Runnable;

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    sget-object v0, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gms/internal/ck;->a:Ljava/lang/Runnable;

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method
