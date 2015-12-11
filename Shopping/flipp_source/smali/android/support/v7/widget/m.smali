.class final Landroid/support/v7/widget/m;
.super Landroid/support/v7/widget/r;
.source "SourceFile"


# instance fields
.field final synthetic a:Landroid/support/v7/widget/bi;

.field final synthetic b:I

.field final synthetic c:I

.field final synthetic d:Landroid/support/v4/view/cj;

.field final synthetic e:Landroid/support/v7/widget/g;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/g;Landroid/support/v7/widget/bi;IILandroid/support/v4/view/cj;)V
    .locals 1

    .prologue
    .line 284
    iput-object p1, p0, Landroid/support/v7/widget/m;->e:Landroid/support/v7/widget/g;

    iput-object p2, p0, Landroid/support/v7/widget/m;->a:Landroid/support/v7/widget/bi;

    iput p3, p0, Landroid/support/v7/widget/m;->b:I

    iput p4, p0, Landroid/support/v7/widget/m;->c:I

    iput-object p5, p0, Landroid/support/v7/widget/m;->d:Landroid/support/v4/view/cj;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/support/v7/widget/r;-><init>(B)V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 287
    return-void
.end method

.method public final b(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 300
    iget-object v0, p0, Landroid/support/v7/widget/m;->d:Landroid/support/v4/view/cj;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/view/cj;->a(Landroid/support/v4/view/cw;)Landroid/support/v4/view/cj;

    .line 301
    iget-object v0, p0, Landroid/support/v7/widget/m;->e:Landroid/support/v7/widget/g;

    iget-object v1, p0, Landroid/support/v7/widget/m;->a:Landroid/support/v7/widget/bi;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/g;->e(Landroid/support/v7/widget/bi;)V

    .line 302
    iget-object v0, p0, Landroid/support/v7/widget/m;->e:Landroid/support/v7/widget/g;

    iget-object v0, v0, Landroid/support/v7/widget/g;->e:Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/support/v7/widget/m;->a:Landroid/support/v7/widget/bi;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 303
    iget-object v0, p0, Landroid/support/v7/widget/m;->e:Landroid/support/v7/widget/g;

    invoke-virtual {v0}, Landroid/support/v7/widget/g;->c()V

    .line 304
    return-void
.end method

.method public final c(Landroid/view/View;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 291
    iget v0, p0, Landroid/support/v7/widget/m;->b:I

    if-eqz v0, :cond_0

    .line 292
    invoke-static {p1, v1}, Landroid/support/v4/view/ap;->a(Landroid/view/View;F)V

    .line 294
    :cond_0
    iget v0, p0, Landroid/support/v7/widget/m;->c:I

    if-eqz v0, :cond_1

    .line 295
    invoke-static {p1, v1}, Landroid/support/v4/view/ap;->b(Landroid/view/View;F)V

    .line 297
    :cond_1
    return-void
.end method
