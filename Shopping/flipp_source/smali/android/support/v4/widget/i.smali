.class final Landroid/support/v4/widget/i;
.super Landroid/support/v4/widget/ak;
.source "SourceFile"


# instance fields
.field final a:I

.field b:Landroid/support/v4/widget/ah;

.field final synthetic c:Landroid/support/v4/widget/DrawerLayout;

.field private final d:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>(Landroid/support/v4/widget/DrawerLayout;I)V
    .locals 1

    .prologue
    .line 1605
    iput-object p1, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-direct {p0}, Landroid/support/v4/widget/ak;-><init>()V

    .line 1599
    new-instance v0, Landroid/support/v4/widget/j;

    invoke-direct {v0, p0}, Landroid/support/v4/widget/j;-><init>(Landroid/support/v4/widget/i;)V

    iput-object v0, p0, Landroid/support/v4/widget/i;->d:Ljava/lang/Runnable;

    .line 1606
    iput p2, p0, Landroid/support/v4/widget/i;->a:I

    .line 1607
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 1614
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    iget-object v1, p0, Landroid/support/v4/widget/i;->d:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1615
    return-void
.end method

.method public final a(I)V
    .locals 8

    .prologue
    const/4 v0, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 1627
    iget-object v4, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    iget-object v1, p0, Landroid/support/v4/widget/i;->b:Landroid/support/v4/widget/ah;

    iget-object v5, v1, Landroid/support/v4/widget/ah;->m:Landroid/view/View;

    iget-object v1, v4, Landroid/support/v4/widget/DrawerLayout;->a:Landroid/support/v4/widget/ah;

    iget v1, v1, Landroid/support/v4/widget/ah;->a:I

    iget-object v6, v4, Landroid/support/v4/widget/DrawerLayout;->b:Landroid/support/v4/widget/ah;

    iget v6, v6, Landroid/support/v4/widget/ah;->a:I

    if-eq v1, v3, :cond_0

    if-ne v6, v3, :cond_4

    :cond_0
    move v1, v3

    :goto_0
    if-eqz v5, :cond_2

    if-nez p1, :cond_2

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget v6, v0, Landroid/support/v4/widget/g;->b:F

    const/4 v7, 0x0

    cmpl-float v6, v6, v7

    if-nez v6, :cond_7

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget-boolean v3, v0, Landroid/support/v4/widget/g;->d:Z

    if-eqz v3, :cond_2

    iput-boolean v2, v0, Landroid/support/v4/widget/g;->d:Z

    iget-object v0, v4, Landroid/support/v4/widget/DrawerLayout;->e:Landroid/support/v4/widget/f;

    if-eqz v0, :cond_1

    iget-object v0, v4, Landroid/support/v4/widget/DrawerLayout;->e:Landroid/support/v4/widget/f;

    invoke-interface {v0}, Landroid/support/v4/widget/f;->c()V

    :cond_1
    invoke-virtual {v4, v5, v2}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;Z)V

    invoke-virtual {v4}, Landroid/support/v4/widget/DrawerLayout;->hasWindowFocus()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {v4}, Landroid/support/v4/widget/DrawerLayout;->getRootView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_2

    const/16 v2, 0x20

    invoke-virtual {v0, v2}, Landroid/view/View;->sendAccessibilityEvent(I)V

    :cond_2
    :goto_1
    iget v0, v4, Landroid/support/v4/widget/DrawerLayout;->c:I

    if-eq v1, v0, :cond_3

    iput v1, v4, Landroid/support/v4/widget/DrawerLayout;->c:I

    .line 1628
    :cond_3
    return-void

    .line 1627
    :cond_4
    if-eq v1, v0, :cond_5

    if-ne v6, v0, :cond_6

    :cond_5
    move v1, v0

    goto :goto_0

    :cond_6
    move v1, v2

    goto :goto_0

    :cond_7
    iget v0, v0, Landroid/support/v4/widget/g;->b:F

    const/high16 v2, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v2

    if-nez v0, :cond_2

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    iget-boolean v2, v0, Landroid/support/v4/widget/g;->d:Z

    if-nez v2, :cond_2

    iput-boolean v3, v0, Landroid/support/v4/widget/g;->d:Z

    iget-object v0, v4, Landroid/support/v4/widget/DrawerLayout;->e:Landroid/support/v4/widget/f;

    if-eqz v0, :cond_8

    iget-object v0, v4, Landroid/support/v4/widget/DrawerLayout;->e:Landroid/support/v4/widget/f;

    invoke-interface {v0}, Landroid/support/v4/widget/f;->b()V

    :cond_8
    invoke-virtual {v4, v5, v3}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;Z)V

    invoke-virtual {v5}, Landroid/view/View;->requestFocus()Z

    goto :goto_1
.end method

.method public final a(II)V
    .locals 2

    .prologue
    .line 1729
    and-int/lit8 v0, p1, 0x1

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 1730
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v0

    .line 1735
    :goto_0
    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;)I

    move-result v1

    if-nez v1, :cond_0

    .line 1736
    iget-object v1, p0, Landroid/support/v4/widget/i;->b:Landroid/support/v4/widget/ah;

    invoke-virtual {v1, v0, p2}, Landroid/support/v4/widget/ah;->a(Landroid/view/View;I)V

    .line 1738
    :cond_0
    return-void

    .line 1732
    :cond_1
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method public final a(Landroid/view/View;F)V
    .locals 6

    .prologue
    const/high16 v5, 0x3f000000    # 0.5f

    const/4 v4, 0x0

    .line 1667
    invoke-static {p1}, Landroid/support/v4/widget/DrawerLayout;->b(Landroid/view/View;)F

    move-result v1

    .line 1668
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v2

    .line 1671
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    const/4 v3, 0x3

    invoke-virtual {v0, p1, v3}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1672
    cmpl-float v0, p2, v4

    if-gtz v0, :cond_0

    cmpl-float v0, p2, v4

    if-nez v0, :cond_2

    cmpl-float v0, v1, v5

    if-lez v0, :cond_2

    :cond_0
    const/4 v0, 0x0

    .line 1678
    :cond_1
    :goto_0
    iget-object v1, p0, Landroid/support/v4/widget/i;->b:Landroid/support/v4/widget/ah;

    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v2

    iget-boolean v3, v1, Landroid/support/v4/widget/ah;->n:Z

    if-nez v3, :cond_5

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1672
    :cond_2
    neg-int v0, v2

    goto :goto_0

    .line 1674
    :cond_3
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v0

    .line 1675
    cmpg-float v3, p2, v4

    if-ltz v3, :cond_4

    cmpl-float v3, p2, v4

    if-nez v3, :cond_1

    cmpl-float v1, v1, v5

    if-lez v1, :cond_1

    :cond_4
    sub-int/2addr v0, v2

    goto :goto_0

    .line 1678
    :cond_5
    iget-object v3, v1, Landroid/support/v4/widget/ah;->i:Landroid/view/VelocityTracker;

    iget v4, v1, Landroid/support/v4/widget/ah;->c:I

    invoke-static {v3, v4}, Landroid/support/v4/view/ak;->a(Landroid/view/VelocityTracker;I)F

    move-result v3

    float-to-int v3, v3

    iget-object v4, v1, Landroid/support/v4/widget/ah;->i:Landroid/view/VelocityTracker;

    iget v5, v1, Landroid/support/v4/widget/ah;->c:I

    invoke-static {v4, v5}, Landroid/support/v4/view/ak;->b(Landroid/view/VelocityTracker;I)F

    move-result v4

    float-to-int v4, v4

    invoke-virtual {v1, v0, v2, v3, v4}, Landroid/support/v4/widget/ah;->a(IIII)Z

    .line 1679
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->invalidate()V

    .line 1680
    return-void
.end method

.method public final a(Landroid/view/View;I)V
    .locals 3

    .prologue
    .line 1633
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v0

    .line 1636
    iget-object v1, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    const/4 v2, 0x3

    invoke-virtual {v1, p1, v2}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1637
    add-int v1, v0, p2

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    .line 1642
    :goto_0
    iget-object v1, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1, p1, v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;F)V

    .line 1643
    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_1

    const/4 v0, 0x4

    :goto_1
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 1644
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->invalidate()V

    .line 1645
    return-void

    .line 1639
    :cond_0
    iget-object v1, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v1

    .line 1640
    sub-int/2addr v1, p2

    int-to-float v1, v1

    int-to-float v0, v0

    div-float v0, v1, v0

    goto :goto_0

    .line 1643
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public final a(Landroid/view/View;)Z
    .locals 2

    .prologue
    .line 1621
    invoke-static {p1}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    iget v1, p0, Landroid/support/v4/widget/i;->a:I

    invoke-virtual {v0, p1, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;)I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final b(Landroid/view/View;I)I
    .locals 2

    .prologue
    .line 1747
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x3

    invoke-virtual {v0, p1, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1748
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v0

    neg-int v0, v0

    const/4 v1, 0x0

    invoke-static {p2, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 1751
    :goto_0
    return v0

    .line 1750
    :cond_0
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Landroid/support/v4/widget/DrawerLayout;->getWidth()I

    move-result v0

    .line 1751
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v1

    sub-int v1, v0, v1

    invoke-static {p2, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_0
.end method

.method final b()V
    .locals 2

    .prologue
    const/4 v0, 0x3

    .line 1656
    iget v1, p0, Landroid/support/v4/widget/i;->a:I

    if-ne v1, v0, :cond_0

    const/4 v0, 0x5

    .line 1657
    :cond_0
    iget-object v1, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1, v0}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v0

    .line 1658
    if-eqz v0, :cond_1

    .line 1659
    iget-object v1, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1, v0}, Landroid/support/v4/widget/DrawerLayout;->f(Landroid/view/View;)V

    .line 1661
    :cond_1
    return-void
.end method

.method public final b(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 1649
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    .line 1650
    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/support/v4/widget/g;->c:Z

    .line 1652
    invoke-virtual {p0}, Landroid/support/v4/widget/i;->b()V

    .line 1653
    return-void
.end method

.method public final c(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1742
    invoke-static {p1}, Landroid/support/v4/widget/DrawerLayout;->d(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final c()V
    .locals 4

    .prologue
    .line 1684
    iget-object v0, p0, Landroid/support/v4/widget/i;->c:Landroid/support/v4/widget/DrawerLayout;

    iget-object v1, p0, Landroid/support/v4/widget/i;->d:Ljava/lang/Runnable;

    const-wide/16 v2, 0xa0

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/widget/DrawerLayout;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1685
    return-void
.end method

.method public final d(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1757
    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v0

    return v0
.end method
