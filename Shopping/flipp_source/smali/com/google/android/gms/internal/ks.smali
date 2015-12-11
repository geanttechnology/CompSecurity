.class final Lcom/google/android/gms/internal/ks;
.super Ljava/lang/Object;


# instance fields
.field public final a:Landroid/widget/ViewSwitcher;

.field public final b:Ljava/lang/String;

.field public final c:Landroid/content/Context;

.field public final d:Lcom/google/android/gms/internal/jg;

.field public final e:Lcom/google/android/gms/internal/cu;

.field public f:Lcom/google/android/gms/internal/c;

.field public g:Lcom/google/android/gms/internal/ee;

.field public h:Lcom/google/android/gms/internal/x;

.field public i:Lcom/google/android/gms/internal/eb;

.field public j:Lcom/google/android/gms/internal/l;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/x;Ljava/lang/String;Lcom/google/android/gms/internal/cu;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iget-boolean v0, p2, Lcom/google/android/gms/internal/x;->e:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/ks;->a:Landroid/widget/ViewSwitcher;

    :goto_0
    iput-object p2, p0, Lcom/google/android/gms/internal/ks;->h:Lcom/google/android/gms/internal/x;

    iput-object p3, p0, Lcom/google/android/gms/internal/ks;->b:Ljava/lang/String;

    iput-object p1, p0, Lcom/google/android/gms/internal/ks;->c:Landroid/content/Context;

    new-instance v0, Lcom/google/android/gms/internal/jg;

    iget-object v1, p4, Lcom/google/android/gms/internal/cu;->b:Ljava/lang/String;

    invoke-static {v1, p1}, Lcom/google/android/gms/internal/ie;->a(Ljava/lang/String;Landroid/content/Context;)Lcom/google/android/gms/internal/ie;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/jg;-><init>(Lcom/google/android/gms/internal/fl;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/ks;->d:Lcom/google/android/gms/internal/jg;

    iput-object p4, p0, Lcom/google/android/gms/internal/ks;->e:Lcom/google/android/gms/internal/cu;

    return-void

    :cond_0
    new-instance v0, Landroid/widget/ViewSwitcher;

    invoke-direct {v0, p1}, Landroid/widget/ViewSwitcher;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/ks;->a:Landroid/widget/ViewSwitcher;

    iget-object v0, p0, Lcom/google/android/gms/internal/ks;->a:Landroid/widget/ViewSwitcher;

    iget v1, p2, Lcom/google/android/gms/internal/x;->g:I

    invoke-virtual {v0, v1}, Landroid/widget/ViewSwitcher;->setMinimumWidth(I)V

    iget-object v0, p0, Lcom/google/android/gms/internal/ks;->a:Landroid/widget/ViewSwitcher;

    iget v1, p2, Lcom/google/android/gms/internal/x;->d:I

    invoke-virtual {v0, v1}, Landroid/widget/ViewSwitcher;->setMinimumHeight(I)V

    iget-object v0, p0, Lcom/google/android/gms/internal/ks;->a:Landroid/widget/ViewSwitcher;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ViewSwitcher;->setVisibility(I)V

    goto :goto_0
.end method
