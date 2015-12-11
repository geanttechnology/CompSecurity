.class final Landroid/support/v4/widget/a;
.super Landroid/support/v4/view/a;
.source "SourceFile"


# instance fields
.field final synthetic b:Landroid/support/v4/widget/DrawerLayout;

.field private final c:Landroid/graphics/Rect;


# direct methods
.method constructor <init>(Landroid/support/v4/widget/DrawerLayout;)V
    .locals 1

    .prologue
    .line 1799
    iput-object p1, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-direct {p0}, Landroid/support/v4/view/a;-><init>()V

    .line 1800
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/support/v4/widget/a;->c:Landroid/graphics/Rect;

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;Landroid/support/v4/view/a/e;)V
    .locals 5

    .prologue
    .line 1804
    invoke-static {}, Landroid/support/v4/widget/DrawerLayout;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1805
    invoke-super {p0, p1, p2}, Landroid/support/v4/view/a;->a(Landroid/view/View;Landroid/support/v4/view/a/e;)V

    .line 1824
    :cond_0
    const-class v0, Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/support/v4/view/a/e;->a(Ljava/lang/CharSequence;)V

    .line 1825
    return-void

    .line 1809
    :cond_1
    invoke-static {p2}, Landroid/support/v4/view/a/e;->a(Landroid/support/v4/view/a/e;)Landroid/support/v4/view/a/e;

    move-result-object v1

    .line 1811
    invoke-super {p0, p1, v1}, Landroid/support/v4/view/a;->a(Landroid/view/View;Landroid/support/v4/view/a/e;)V

    .line 1813
    sget-object v0, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v2, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v0, v2, p1}, Landroid/support/v4/view/a/h;->c(Ljava/lang/Object;Landroid/view/View;)V

    .line 1814
    invoke-static {p1}, Landroid/support/v4/view/ap;->i(Landroid/view/View;)Landroid/view/ViewParent;

    move-result-object v0

    .line 1815
    instance-of v2, v0, Landroid/view/View;

    if-eqz v2, :cond_2

    .line 1816
    check-cast v0, Landroid/view/View;

    invoke-virtual {p2, v0}, Landroid/support/v4/view/a/e;->a(Landroid/view/View;)V

    .line 1818
    :cond_2
    iget-object v0, p0, Landroid/support/v4/widget/a;->c:Landroid/graphics/Rect;

    invoke-virtual {v1, v0}, Landroid/support/v4/view/a/e;->a(Landroid/graphics/Rect;)V

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->c(Ljava/lang/Object;Landroid/graphics/Rect;)V

    invoke-virtual {v1, v0}, Landroid/support/v4/view/a/e;->b(Landroid/graphics/Rect;)V

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->d(Ljava/lang/Object;Landroid/graphics/Rect;)V

    sget-object v0, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v2, v1, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v0, v2}, Landroid/support/v4/view/a/h;->r(Ljava/lang/Object;)Z

    move-result v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->h(Ljava/lang/Object;Z)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->h()Ljava/lang/CharSequence;

    move-result-object v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->c(Ljava/lang/Object;Ljava/lang/CharSequence;)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->i()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/support/v4/view/a/e;->a(Ljava/lang/CharSequence;)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->j()Ljava/lang/CharSequence;

    move-result-object v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->b(Ljava/lang/Object;Ljava/lang/CharSequence;)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->g()Z

    move-result v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->b(Ljava/lang/Object;Z)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->e()Z

    move-result v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->a(Ljava/lang/Object;Z)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->b()Z

    move-result v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->c(Ljava/lang/Object;Z)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->c()Z

    move-result v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->d(Ljava/lang/Object;Z)V

    sget-object v0, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v2, v1, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v0, v2}, Landroid/support/v4/view/a/h;->s(Ljava/lang/Object;)Z

    move-result v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->i(Ljava/lang/Object;Z)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->d()Z

    move-result v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->g(Ljava/lang/Object;Z)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->f()Z

    move-result v0

    sget-object v2, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v3, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v0}, Landroid/support/v4/view/a/h;->e(Ljava/lang/Object;Z)V

    invoke-virtual {v1}, Landroid/support/v4/view/a/e;->a()I

    move-result v0

    invoke-virtual {p2, v0}, Landroid/support/v4/view/a/e;->a(I)V

    .line 1819
    sget-object v0, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v1, v1, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v0, v1}, Landroid/support/v4/view/a/h;->q(Ljava/lang/Object;)V

    .line 1821
    check-cast p1, Landroid/view/ViewGroup;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_0

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v4/widget/DrawerLayout;->h(Landroid/view/View;)Z

    move-result v3

    if-eqz v3, :cond_3

    sget-object v3, Landroid/support/v4/view/a/e;->a:Landroid/support/v4/view/a/h;

    iget-object v4, p2, Landroid/support/v4/view/a/e;->b:Ljava/lang/Object;

    invoke-interface {v3, v4, v2}, Landroid/support/v4/view/a/h;->a(Ljava/lang/Object;Landroid/view/View;)V

    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public final a(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 1

    .prologue
    .line 1861
    invoke-static {}, Landroid/support/v4/widget/DrawerLayout;->c()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Landroid/support/v4/widget/DrawerLayout;->h(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1862
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/view/a;->a(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    .line 1864
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final b(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 4

    .prologue
    .line 1841
    invoke-virtual {p2}, Landroid/view/accessibility/AccessibilityEvent;->getEventType()I

    move-result v0

    const/16 v1, 0x20

    if-ne v0, v1, :cond_3

    .line 1842
    invoke-virtual {p2}, Landroid/view/accessibility/AccessibilityEvent;->getText()Ljava/util/List;

    move-result-object v1

    .line 1843
    iget-object v0, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-static {v0}, Landroid/support/v4/widget/DrawerLayout;->a(Landroid/support/v4/widget/DrawerLayout;)Landroid/view/View;

    move-result-object v0

    .line 1844
    if-eqz v0, :cond_0

    .line 1845
    iget-object v2, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v2, v0}, Landroid/support/v4/widget/DrawerLayout;->c(Landroid/view/View;)I

    move-result v0

    .line 1846
    iget-object v2, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-static {v2}, Landroid/support/v4/view/ap;->h(Landroid/view/View;)I

    move-result v3

    invoke-static {v0, v3}, Landroid/support/v4/view/n;->a(II)I

    move-result v0

    const/4 v3, 0x3

    if-ne v0, v3, :cond_1

    iget-object v0, v2, Landroid/support/v4/widget/DrawerLayout;->f:Ljava/lang/CharSequence;

    .line 1847
    :goto_0
    if-eqz v0, :cond_0

    .line 1848
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1852
    :cond_0
    const/4 v0, 0x1

    .line 1855
    :goto_1
    return v0

    .line 1846
    :cond_1
    const/4 v3, 0x5

    if-ne v0, v3, :cond_2

    iget-object v0, v2, Landroid/support/v4/widget/DrawerLayout;->g:Ljava/lang/CharSequence;

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 1855
    :cond_3
    invoke-super {p0, p1, p2}, Landroid/support/v4/view/a;->b(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    goto :goto_1
.end method

.method public final d(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1

    .prologue
    .line 1829
    invoke-super {p0, p1, p2}, Landroid/support/v4/view/a;->d(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    .line 1831
    const-class v0, Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 1832
    return-void
.end method
