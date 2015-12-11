.class Lahk;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field public final a:Lahj;

.field public final b:Ljava/lang/String;

.field public final c:Landroid/content/Context;

.field public final d:Laea;

.field public final e:Lcom/google/android/gms/internal/gs;

.field public f:Ltn;

.field public g:Labn;

.field public h:Labn;

.field public i:Lcom/google/android/gms/internal/ay;

.field public j:Labd;

.field public k:Labe;

.field public l:Labf;

.field public m:Ltw;

.field public n:Lyv;

.field public o:Lyj;

.field public p:Luy;

.field public q:Luz;

.field public r:Lum;

.field public s:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public t:Lye;

.field public u:Labl;

.field public v:Landroid/view/View;

.field public w:I

.field public x:Z

.field public y:Z

.field private z:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Labf;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/ay;Ljava/lang/String;Lcom/google/android/gms/internal/gs;)V
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v1, p0, Lahk;->u:Labl;

    iput-object v1, p0, Lahk;->v:Landroid/view/View;

    iput v0, p0, Lahk;->w:I

    iput-boolean v0, p0, Lahk;->x:Z

    iput-boolean v0, p0, Lahk;->y:Z

    iput-object v1, p0, Lahk;->z:Ljava/util/HashSet;

    iget-boolean v0, p2, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v0, :cond_0

    iput-object v1, p0, Lahk;->a:Lahj;

    :goto_0
    iput-object p2, p0, Lahk;->i:Lcom/google/android/gms/internal/ay;

    iput-object p3, p0, Lahk;->b:Ljava/lang/String;

    iput-object p1, p0, Lahk;->c:Landroid/content/Context;

    iput-object p4, p0, Lahk;->e:Lcom/google/android/gms/internal/gs;

    new-instance v0, Laea;

    new-instance v1, Lahp;

    invoke-direct {v1, p0}, Lahp;-><init>(Lahk;)V

    invoke-direct {v0, v1}, Laea;-><init>(Labh;)V

    iput-object v0, p0, Lahk;->d:Laea;

    return-void

    :cond_0
    new-instance v0, Lahj;

    invoke-direct {v0, p1}, Lahj;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lahk;->a:Lahj;

    iget-object v0, p0, Lahk;->a:Lahj;

    iget v1, p2, Lcom/google/android/gms/internal/ay;->g:I

    invoke-virtual {v0, v1}, Lahj;->setMinimumWidth(I)V

    iget-object v0, p0, Lahk;->a:Lahj;

    iget v1, p2, Lcom/google/android/gms/internal/ay;->d:I

    invoke-virtual {v0, v1}, Lahj;->setMinimumHeight(I)V

    iget-object v0, p0, Lahk;->a:Lahj;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lahj;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public a()Ljava/util/HashSet;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashSet",
            "<",
            "Labf;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lahk;->z:Ljava/util/HashSet;

    return-object v0
.end method

.method public a(Ljava/util/HashSet;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashSet",
            "<",
            "Labf;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lahk;->z:Ljava/util/HashSet;

    return-void
.end method
