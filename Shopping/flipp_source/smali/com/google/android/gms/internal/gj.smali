.class final Lcom/google/android/gms/internal/gj;
.super Ljava/lang/Object;


# instance fields
.field final a:Ljava/lang/String;

.field final b:Lcom/google/android/gms/internal/gk;

.field final c:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Lcom/google/android/gms/internal/fw",
            "<*>.com/google/android/gms/internal/gb;>;"
        }
    .end annotation
.end field

.field d:I

.field e:Z

.field f:Landroid/os/IBinder;

.field g:Landroid/content/ComponentName;

.field final synthetic h:Lcom/google/android/gms/internal/gi;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/gi;Ljava/lang/String;)V
    .locals 1

    iput-object p1, p0, Lcom/google/android/gms/internal/gj;->h:Lcom/google/android/gms/internal/gi;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lcom/google/android/gms/internal/gj;->a:Ljava/lang/String;

    new-instance v0, Lcom/google/android/gms/internal/gk;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/gk;-><init>(Lcom/google/android/gms/internal/gj;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/gj;->b:Lcom/google/android/gms/internal/gk;

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/gj;->c:Ljava/util/HashSet;

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/internal/gj;->d:I

    return-void
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/internal/gb;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/fw",
            "<*>.com/google/android/gms/internal/gb;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/gj;->c:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public final b(Lcom/google/android/gms/internal/gb;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/fw",
            "<*>.com/google/android/gms/internal/gb;)Z"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/gj;->c:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
