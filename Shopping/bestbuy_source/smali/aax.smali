.class public final Laax;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field a:Lcom/google/android/gms/internal/gu;

.field public final b:Lvd;

.field public final c:Lvd;

.field private final d:Ljava/lang/Object;

.field private e:Ljava/lang/String;

.field private f:Labs;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Labs",
            "<",
            "Laaz;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Laax;->d:Ljava/lang/Object;

    new-instance v0, Labs;

    invoke-direct {v0}, Labs;-><init>()V

    iput-object v0, p0, Laax;->f:Labs;

    new-instance v0, Laax$1;

    invoke-direct {v0, p0}, Laax$1;-><init>(Laax;)V

    iput-object v0, p0, Laax;->b:Lvd;

    new-instance v0, Laax$2;

    invoke-direct {v0, p0}, Laax$2;-><init>(Laax;)V

    iput-object v0, p0, Laax;->c:Lvd;

    iput-object p1, p0, Laax;->e:Ljava/lang/String;

    return-void
.end method

.method static synthetic a(Laax;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Laax;->d:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic b(Laax;)Labs;
    .locals 1

    iget-object v0, p0, Laax;->f:Labs;

    return-object v0
.end method

.method static synthetic c(Laax;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Laax;->e:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a()Ljava/util/concurrent/Future;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Future",
            "<",
            "Laaz;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Laax;->f:Labs;

    return-object v0
.end method

.method public a(Lcom/google/android/gms/internal/gu;)V
    .locals 1

    const-string v0, "setAdWebView must be called on the main thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iput-object p1, p0, Laax;->a:Lcom/google/android/gms/internal/gu;

    return-void
.end method

.method public b()V
    .locals 1

    const-string v0, "destroyAdWebView must be called on the main thread."

    invoke-static {v0}, Lady;->b(Ljava/lang/String;)V

    iget-object v0, p0, Laax;->a:Lcom/google/android/gms/internal/gu;

    if-eqz v0, :cond_0

    iget-object v0, p0, Laax;->a:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->destroy()V

    const/4 v0, 0x0

    iput-object v0, p0, Laax;->a:Lcom/google/android/gms/internal/gu;

    :cond_0
    return-void
.end method
