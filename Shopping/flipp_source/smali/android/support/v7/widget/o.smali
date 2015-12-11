.class final Landroid/support/v7/widget/o;
.super Landroid/support/v7/widget/r;
.source "SourceFile"


# instance fields
.field final synthetic a:Landroid/support/v7/widget/p;

.field final synthetic b:Landroid/support/v4/view/cj;

.field final synthetic c:Landroid/view/View;

.field final synthetic d:Landroid/support/v7/widget/g;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/g;Landroid/support/v7/widget/p;Landroid/support/v4/view/cj;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 365
    iput-object p1, p0, Landroid/support/v7/widget/o;->d:Landroid/support/v7/widget/g;

    iput-object p2, p0, Landroid/support/v7/widget/o;->a:Landroid/support/v7/widget/p;

    iput-object p3, p0, Landroid/support/v7/widget/o;->b:Landroid/support/v4/view/cj;

    iput-object p4, p0, Landroid/support/v7/widget/o;->c:Landroid/view/View;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/support/v7/widget/r;-><init>(B)V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 368
    return-void
.end method

.method public final b(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 372
    iget-object v0, p0, Landroid/support/v7/widget/o;->b:Landroid/support/v4/view/cj;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/cj;->a(Landroid/support/v4/view/cw;)Landroid/support/v4/view/cj;

    .line 373
    iget-object v0, p0, Landroid/support/v7/widget/o;->c:Landroid/view/View;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-static {v0, v1}, Landroid/support/v4/view/ap;->c(Landroid/view/View;F)V

    .line 374
    iget-object v0, p0, Landroid/support/v7/widget/o;->c:Landroid/view/View;

    invoke-static {v0, v2}, Landroid/support/v4/view/ap;->a(Landroid/view/View;F)V

    .line 375
    iget-object v0, p0, Landroid/support/v7/widget/o;->c:Landroid/view/View;

    invoke-static {v0, v2}, Landroid/support/v4/view/ap;->b(Landroid/view/View;F)V

    .line 376
    iget-object v0, p0, Landroid/support/v7/widget/o;->d:Landroid/support/v7/widget/g;

    iget-object v1, p0, Landroid/support/v7/widget/o;->a:Landroid/support/v7/widget/p;

    iget-object v1, v1, Landroid/support/v7/widget/p;->b:Landroid/support/v7/widget/bi;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/g;->g(Landroid/support/v7/widget/bi;)V

    .line 377
    iget-object v0, p0, Landroid/support/v7/widget/o;->d:Landroid/support/v7/widget/g;

    iget-object v0, v0, Landroid/support/v7/widget/g;->g:Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/support/v7/widget/o;->a:Landroid/support/v7/widget/p;

    iget-object v1, v1, Landroid/support/v7/widget/p;->b:Landroid/support/v7/widget/bi;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 378
    iget-object v0, p0, Landroid/support/v7/widget/o;->d:Landroid/support/v7/widget/g;

    invoke-virtual {v0}, Landroid/support/v7/widget/g;->c()V

    .line 379
    return-void
.end method
