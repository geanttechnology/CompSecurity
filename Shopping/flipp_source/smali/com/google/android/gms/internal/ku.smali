.class final Lcom/google/android/gms/internal/ku;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/kr;

.field final synthetic b:Lcom/google/android/gms/internal/kt;

.field private final c:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/google/android/gms/internal/kr;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/kt;Lcom/google/android/gms/internal/kr;)V
    .locals 2

    iput-object p1, p0, Lcom/google/android/gms/internal/ku;->b:Lcom/google/android/gms/internal/kt;

    iput-object p2, p0, Lcom/google/android/gms/internal/ku;->a:Lcom/google/android/gms/internal/kr;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/ref/WeakReference;

    iget-object v1, p0, Lcom/google/android/gms/internal/ku;->a:Lcom/google/android/gms/internal/kr;

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/ku;->c:Ljava/lang/ref/WeakReference;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/ku;->b:Lcom/google/android/gms/internal/kt;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/google/android/gms/internal/kt;->b:Z

    iget-object v0, p0, Lcom/google/android/gms/internal/ku;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/kr;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/google/android/gms/internal/ku;->b:Lcom/google/android/gms/internal/kt;

    iget-object v2, v1, Lcom/google/android/gms/internal/kt;->a:Lcom/google/android/gms/internal/v;

    iget-object v1, v0, Lcom/google/android/gms/internal/kr;->a:Lcom/google/android/gms/internal/ks;

    iget-object v1, v1, Lcom/google/android/gms/internal/ks;->a:Landroid/widget/ViewSwitcher;

    invoke-virtual {v1}, Landroid/widget/ViewSwitcher;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    instance-of v3, v1, Landroid/view/View;

    if-eqz v3, :cond_1

    check-cast v1, Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->isShown()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {}, Lcom/google/android/gms/internal/ej;->a()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/kr;->a(Lcom/google/android/gms/internal/v;)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    const-string v1, "Ad is not visible. Not refreshing ad."

    invoke-static {v1}, Lcom/google/android/gms/internal/et;->b(Ljava/lang/String;)V

    iget-object v0, v0, Lcom/google/android/gms/internal/kr;->b:Lcom/google/android/gms/internal/kt;

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/kt;->a(Lcom/google/android/gms/internal/v;)V

    goto :goto_0
.end method
