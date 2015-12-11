.class Landroid/support/v4/view/au;
.super Landroid/support/v4/view/at;
.source "SourceFile"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 752
    invoke-direct {p0}, Landroid/support/v4/view/at;-><init>()V

    return-void
.end method


# virtual methods
.method final a()J
    .locals 2

    .prologue
    .line 755
    invoke-static {}, Landroid/support/v4/view/bc;->a()J

    move-result-wide v0

    return-wide v0
.end method

.method public final a(Landroid/view/View;F)V
    .locals 0

    .prologue
    .line 803
    invoke-static {p1, p2}, Landroid/support/v4/view/bc;->a(Landroid/view/View;F)V

    .line 804
    return-void
.end method

.method public final a(Landroid/view/View;ILandroid/graphics/Paint;)V
    .locals 0

    .prologue
    .line 763
    invoke-static {p1, p2, p3}, Landroid/support/v4/view/bc;->a(Landroid/view/View;ILandroid/graphics/Paint;)V

    .line 764
    return-void
.end method

.method public a(Landroid/view/View;Landroid/graphics/Paint;)V
    .locals 1

    .prologue
    .line 773
    invoke-static {p1}, Landroid/support/v4/view/bc;->b(Landroid/view/View;)I

    move-result v0

    invoke-static {p1, v0, p2}, Landroid/support/v4/view/bc;->a(Landroid/view/View;ILandroid/graphics/Paint;)V

    .line 775
    invoke-virtual {p1}, Landroid/view/View;->invalidate()V

    .line 776
    return-void
.end method

.method public final b(Landroid/view/View;F)V
    .locals 0

    .prologue
    .line 807
    invoke-static {p1, p2}, Landroid/support/v4/view/bc;->b(Landroid/view/View;F)V

    .line 808
    return-void
.end method

.method public final c(Landroid/view/View;F)V
    .locals 0

    .prologue
    .line 811
    invoke-static {p1, p2}, Landroid/support/v4/view/bc;->c(Landroid/view/View;F)V

    .line 812
    return-void
.end method

.method public final f(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 759
    invoke-static {p1}, Landroid/support/v4/view/bc;->a(Landroid/view/View;)F

    move-result v0

    return v0
.end method

.method public final g(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 767
    invoke-static {p1}, Landroid/support/v4/view/bc;->b(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method public final k(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 795
    invoke-static {p1}, Landroid/support/v4/view/bc;->c(Landroid/view/View;)F

    move-result v0

    return v0
.end method

.method public final l(Landroid/view/View;)F
    .locals 1

    .prologue
    .line 799
    invoke-static {p1}, Landroid/support/v4/view/bc;->d(Landroid/view/View;)F

    move-result v0

    return v0
.end method
