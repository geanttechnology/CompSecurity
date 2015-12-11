.class final Laav$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laav;->a(Landroid/content/Context;Luf;Lvr;Labb;Lcom/google/android/gms/internal/fh;)Lcom/google/android/gms/internal/fj;
.end annotation


# instance fields
.field final synthetic a:Landroid/content/Context;

.field final synthetic b:Lcom/google/android/gms/internal/fh;

.field final synthetic c:Laax;

.field final synthetic d:Lacf;

.field final synthetic e:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laax;Lacf;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Laav$1;->a:Landroid/content/Context;

    iput-object p2, p0, Laav$1;->b:Lcom/google/android/gms/internal/fh;

    iput-object p3, p0, Laav$1;->c:Laax;

    iput-object p4, p0, Laav$1;->d:Lacf;

    iput-object p5, p0, Laav$1;->e:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    const/4 v2, 0x0

    iget-object v0, p0, Laav$1;->a:Landroid/content/Context;

    new-instance v1, Lcom/google/android/gms/internal/ay;

    invoke-direct {v1}, Lcom/google/android/gms/internal/ay;-><init>()V

    const/4 v4, 0x0

    iget-object v3, p0, Laav$1;->b:Lcom/google/android/gms/internal/fh;

    iget-object v5, v3, Lcom/google/android/gms/internal/fh;->k:Lcom/google/android/gms/internal/gs;

    move v3, v2

    invoke-static/range {v0 .. v5}, Lcom/google/android/gms/internal/gu;->a(Landroid/content/Context;Lcom/google/android/gms/internal/ay;ZZLaea;Lcom/google/android/gms/internal/gs;)Lcom/google/android/gms/internal/gu;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/gu;->setWillNotDraw(Z)V

    iget-object v1, p0, Laav$1;->c:Laax;

    invoke-virtual {v1, v0}, Laax;->a(Lcom/google/android/gms/internal/gu;)V

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->f()Lace;

    move-result-object v1

    const-string v2, "/invalidRequest"

    iget-object v3, p0, Laav$1;->c:Laax;

    iget-object v3, v3, Laax;->b:Lvd;

    invoke-virtual {v1, v2, v3}, Lace;->a(Ljava/lang/String;Lvd;)V

    const-string v2, "/loadAdURL"

    iget-object v3, p0, Laav$1;->c:Laax;

    iget-object v3, v3, Laax;->c:Lvd;

    invoke-virtual {v1, v2, v3}, Lace;->a(Ljava/lang/String;Lvd;)V

    const-string v2, "/log"

    sget-object v3, Lvc;->h:Lvd;

    invoke-virtual {v1, v2, v3}, Lace;->a(Ljava/lang/String;Lvd;)V

    iget-object v2, p0, Laav$1;->d:Lacf;

    invoke-virtual {v1, v2}, Lace;->a(Lacf;)V

    const-string v1, "Loading the JS library."

    invoke-static {v1}, Lacb;->a(Ljava/lang/String;)V

    iget-object v1, p0, Laav$1;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/gu;->loadUrl(Ljava/lang/String;)V

    return-void
.end method
