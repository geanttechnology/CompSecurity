.class final Lcom/google/android/gms/internal/cl;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/cj;

.field final synthetic b:Lcom/google/android/gms/internal/ck;

.field private final c:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/google/android/gms/internal/cj;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/ck;Lcom/google/android/gms/internal/cj;)V
    .locals 2

    iput-object p1, p0, Lcom/google/android/gms/internal/cl;->b:Lcom/google/android/gms/internal/ck;

    iput-object p2, p0, Lcom/google/android/gms/internal/cl;->a:Lcom/google/android/gms/internal/cj;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/ref/WeakReference;

    iget-object v1, p0, Lcom/google/android/gms/internal/cl;->a:Lcom/google/android/gms/internal/cj;

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/cl;->c:Ljava/lang/ref/WeakReference;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 7

    iget-object v0, p0, Lcom/google/android/gms/internal/cl;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/cj;

    iget-object v1, p0, Lcom/google/android/gms/internal/cl;->b:Lcom/google/android/gms/internal/ck;

    iget-boolean v1, v1, Lcom/google/android/gms/internal/ck;->b:Z

    if-nez v1, :cond_1

    if-eqz v0, :cond_1

    iget-object v1, v0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v1}, Landroid/widget/VideoView;->getCurrentPosition()I

    move-result v1

    int-to-long v2, v1

    iget-wide v4, v0, Lcom/google/android/gms/internal/cj;->e:J

    cmp-long v1, v4, v2

    if-eqz v1, :cond_0

    long-to-float v1, v2

    const/high16 v4, 0x447a0000    # 1000.0f

    div-float/2addr v1, v4

    iget-object v4, v0, Lcom/google/android/gms/internal/cj;->a:Lcom/google/android/gms/internal/ew;

    const-string v5, "timeupdate"

    const-string v6, "time"

    invoke-static {v1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v5, v6, v1}, Lcom/google/android/gms/internal/cj;->a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-wide v2, v0, Lcom/google/android/gms/internal/cj;->e:J

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cl;->b:Lcom/google/android/gms/internal/ck;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ck;->a()V

    :cond_1
    return-void
.end method
