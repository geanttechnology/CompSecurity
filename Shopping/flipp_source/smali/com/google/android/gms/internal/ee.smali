.class public abstract Lcom/google/android/gms/internal/ee;
.super Ljava/lang/Object;


# instance fields
.field final e:Ljava/lang/Runnable;

.field volatile f:Ljava/lang/Thread;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/gms/internal/ef;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/ef;-><init>(Lcom/google/android/gms/internal/ee;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/ee;->e:Ljava/lang/Runnable;

    return-void
.end method


# virtual methods
.method public abstract a()V
.end method

.method public abstract b_()V
.end method

.method public final e()V
    .locals 1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/ee;->b_()V

    iget-object v0, p0, Lcom/google/android/gms/internal/ee;->f:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/ee;->f:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    :cond_0
    return-void
.end method
