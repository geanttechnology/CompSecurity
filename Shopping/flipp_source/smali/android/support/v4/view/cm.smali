.class Landroid/support/v4/view/cm;
.super Landroid/support/v4/view/ck;
.source "SourceFile"


# instance fields
.field b:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap",
            "<",
            "Landroid/view/View;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 335
    invoke-direct {p0}, Landroid/support/v4/view/ck;-><init>()V

    .line 336
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/view/cm;->b:Ljava/util/WeakHashMap;

    .line 497
    return-void
.end method


# virtual methods
.method public final a(Landroid/support/v4/view/cj;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 435
    invoke-static {p2}, Landroid/support/v4/view/cs;->a(Landroid/view/View;)V

    .line 436
    return-void
.end method

.method public final a(Landroid/support/v4/view/cj;Landroid/view/View;F)V
    .locals 0

    .prologue
    .line 345
    invoke-static {p2, p3}, Landroid/support/v4/view/cs;->a(Landroid/view/View;F)V

    .line 346
    return-void
.end method

.method public a(Landroid/support/v4/view/cj;Landroid/view/View;Landroid/support/v4/view/cw;)V
    .locals 1

    .prologue
    .line 475
    const/high16 v0, 0x7e000000

    invoke-virtual {p2, v0, p3}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 476
    new-instance v0, Landroid/support/v4/view/cn;

    invoke-direct {v0, p1}, Landroid/support/v4/view/cn;-><init>(Landroid/support/v4/view/cj;)V

    invoke-static {p2, v0}, Landroid/support/v4/view/cs;->a(Landroid/view/View;Landroid/support/v4/view/cw;)V

    .line 477
    return-void
.end method

.method public final a(Landroid/view/View;J)V
    .locals 0

    .prologue
    .line 340
    invoke-static {p1, p2, p3}, Landroid/support/v4/view/cs;->a(Landroid/view/View;J)V

    .line 341
    return-void
.end method

.method public final b(Landroid/support/v4/view/cj;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 470
    invoke-static {p2}, Landroid/support/v4/view/cs;->b(Landroid/view/View;)V

    .line 471
    return-void
.end method

.method public final b(Landroid/support/v4/view/cj;Landroid/view/View;F)V
    .locals 0

    .prologue
    .line 350
    invoke-static {p2, p3}, Landroid/support/v4/view/cs;->b(Landroid/view/View;F)V

    .line 351
    return-void
.end method

.method public final c(Landroid/support/v4/view/cj;Landroid/view/View;F)V
    .locals 0

    .prologue
    .line 355
    invoke-static {p2, p3}, Landroid/support/v4/view/cs;->c(Landroid/view/View;F)V

    .line 356
    return-void
.end method
