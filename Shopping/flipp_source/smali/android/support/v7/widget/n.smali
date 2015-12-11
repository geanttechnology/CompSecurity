.class final Landroid/support/v7/widget/n;
.super Landroid/support/v7/widget/r;
.source "SourceFile"


# instance fields
.field final synthetic a:Landroid/support/v7/widget/p;

.field final synthetic b:Landroid/support/v4/view/cj;

.field final synthetic c:Landroid/support/v7/widget/g;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/g;Landroid/support/v7/widget/p;Landroid/support/v4/view/cj;)V
    .locals 1

    .prologue
    .line 343
    iput-object p1, p0, Landroid/support/v7/widget/n;->c:Landroid/support/v7/widget/g;

    iput-object p2, p0, Landroid/support/v7/widget/n;->a:Landroid/support/v7/widget/p;

    iput-object p3, p0, Landroid/support/v7/widget/n;->b:Landroid/support/v4/view/cj;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/support/v7/widget/r;-><init>(B)V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 346
    return-void
.end method

.method public final b(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 351
    iget-object v0, p0, Landroid/support/v7/widget/n;->b:Landroid/support/v4/view/cj;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/cj;->a(Landroid/support/v4/view/cw;)Landroid/support/v4/view/cj;

    .line 352
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-static {p1, v0}, Landroid/support/v4/view/ap;->c(Landroid/view/View;F)V

    .line 353
    invoke-static {p1, v2}, Landroid/support/v4/view/ap;->a(Landroid/view/View;F)V

    .line 354
    invoke-static {p1, v2}, Landroid/support/v4/view/ap;->b(Landroid/view/View;F)V

    .line 355
    iget-object v0, p0, Landroid/support/v7/widget/n;->c:Landroid/support/v7/widget/g;

    iget-object v1, p0, Landroid/support/v7/widget/n;->a:Landroid/support/v7/widget/p;

    iget-object v1, v1, Landroid/support/v7/widget/p;->a:Landroid/support/v7/widget/bi;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/g;->g(Landroid/support/v7/widget/bi;)V

    .line 356
    iget-object v0, p0, Landroid/support/v7/widget/n;->c:Landroid/support/v7/widget/g;

    iget-object v0, v0, Landroid/support/v7/widget/g;->g:Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/support/v7/widget/n;->a:Landroid/support/v7/widget/p;

    iget-object v1, v1, Landroid/support/v7/widget/p;->a:Landroid/support/v7/widget/bi;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 357
    iget-object v0, p0, Landroid/support/v7/widget/n;->c:Landroid/support/v7/widget/g;

    invoke-virtual {v0}, Landroid/support/v7/widget/g;->c()V

    .line 358
    return-void
.end method
