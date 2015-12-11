.class public final Lcom/google/android/gms/internal/kt;
.super Ljava/lang/Object;


# instance fields
.field a:Lcom/google/android/gms/internal/v;

.field b:Z

.field private final c:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/kr;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/kt;->b:Z

    new-instance v0, Lcom/google/android/gms/internal/ku;

    invoke-direct {v0, p0, p1}, Lcom/google/android/gms/internal/ku;-><init>(Lcom/google/android/gms/internal/kt;Lcom/google/android/gms/internal/kr;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/kt;->c:Ljava/lang/Runnable;

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    sget-object v0, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gms/internal/kt;->c:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    return-void
.end method

.method public final a(Lcom/google/android/gms/internal/v;)V
    .locals 2

    const-wide/32 v0, 0xea60

    invoke-virtual {p0, p1, v0, v1}, Lcom/google/android/gms/internal/kt;->a(Lcom/google/android/gms/internal/v;J)V

    return-void
.end method

.method public final a(Lcom/google/android/gms/internal/v;J)V
    .locals 2

    iget-boolean v0, p0, Lcom/google/android/gms/internal/kt;->b:Z

    if-eqz v0, :cond_0

    const-string v0, "An ad refresh is already scheduled."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Scheduling ad refresh "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " milliseconds from now."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->b(Ljava/lang/String;)V

    iput-object p1, p0, Lcom/google/android/gms/internal/kt;->a:Lcom/google/android/gms/internal/v;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/kt;->b:Z

    sget-object v0, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gms/internal/kt;->c:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method
