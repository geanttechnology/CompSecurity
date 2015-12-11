.class final Lcom/google/android/gms/internal/ef;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/ee;


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/ee;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/ef;->a:Lcom/google/android/gms/internal/ee;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/internal/ef;->a:Lcom/google/android/gms/internal/ee;

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/internal/ee;->f:Ljava/lang/Thread;

    iget-object v0, p0, Lcom/google/android/gms/internal/ef;->a:Lcom/google/android/gms/internal/ee;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ee;->a()V

    return-void
.end method
