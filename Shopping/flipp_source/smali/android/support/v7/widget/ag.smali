.class final Landroid/support/v7/widget/ag;
.super Landroid/support/v7/widget/af;
.source "SourceFile"


# direct methods
.method constructor <init>(Landroid/support/v7/widget/au;)V
    .locals 1

    .prologue
    .line 194
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/af;-><init>(Landroid/support/v7/widget/au;B)V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;)I
    .locals 2

    .prologue
    .line 240
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    .line 242
    invoke-static {p1}, Landroid/support/v7/widget/au;->d(Landroid/view/View;)I

    move-result v1

    iget v0, v0, Landroid/support/v7/widget/av;->leftMargin:I

    sub-int v0, v1, v0

    return v0
.end method

.method public final a(I)V
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/au;->d(I)V

    .line 208
    return-void
.end method

.method public final b()I
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v0}, Landroid/support/v7/widget/au;->m()I

    move-result v0

    return v0
.end method

.method public final b(Landroid/view/View;)I
    .locals 2

    .prologue
    .line 233
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    .line 235
    invoke-static {p1}, Landroid/support/v7/widget/au;->f(Landroid/view/View;)I

    move-result v1

    iget v0, v0, Landroid/support/v7/widget/av;->rightMargin:I

    add-int/2addr v0, v1

    return v0
.end method

.method public final c()I
    .locals 2

    .prologue
    .line 197
    iget-object v0, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v0}, Landroid/support/v7/widget/au;->k()I

    move-result v0

    iget-object v1, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v1}, Landroid/support/v7/widget/au;->o()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method public final c(Landroid/view/View;)I
    .locals 3

    .prologue
    .line 217
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    .line 219
    invoke-static {p1}, Landroid/support/v7/widget/au;->b(Landroid/view/View;)I

    move-result v1

    iget v2, v0, Landroid/support/v7/widget/av;->leftMargin:I

    add-int/2addr v1, v2

    iget v0, v0, Landroid/support/v7/widget/av;->rightMargin:I

    add-int/2addr v0, v1

    return v0
.end method

.method public final d()I
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v0}, Landroid/support/v7/widget/au;->k()I

    move-result v0

    return v0
.end method

.method public final d(Landroid/view/View;)I
    .locals 3

    .prologue
    .line 225
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    .line 227
    invoke-static {p1}, Landroid/support/v7/widget/au;->c(Landroid/view/View;)I

    move-result v1

    iget v2, v0, Landroid/support/v7/widget/av;->topMargin:I

    add-int/2addr v1, v2

    iget v0, v0, Landroid/support/v7/widget/av;->bottomMargin:I

    add-int/2addr v0, v1

    return v0
.end method

.method public final e()I
    .locals 2

    .prologue
    .line 247
    iget-object v0, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v0}, Landroid/support/v7/widget/au;->k()I

    move-result v0

    iget-object v1, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v1}, Landroid/support/v7/widget/au;->m()I

    move-result v1

    sub-int/2addr v0, v1

    iget-object v1, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v1}, Landroid/support/v7/widget/au;->o()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method public final f()I
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Landroid/support/v7/widget/ag;->a:Landroid/support/v7/widget/au;

    invoke-virtual {v0}, Landroid/support/v7/widget/au;->o()I

    move-result v0

    return v0
.end method
