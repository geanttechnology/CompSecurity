.class public abstract Landroid/support/v7/widget/au;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field p:Landroid/support/v7/widget/d;

.field q:Landroid/support/v7/widget/RecyclerView;

.field r:Landroid/support/v7/widget/bd;

.field s:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 4481
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4488
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/au;->s:Z

    return-void
.end method

.method public static a(IIIZ)I
    .locals 4

    .prologue
    const/high16 v0, 0x40000000    # 2.0f

    const/4 v1, 0x0

    .line 5571
    sub-int v2, p0, p1

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 5575
    if-eqz p3, :cond_2

    .line 5576
    if-ltz p2, :cond_1

    .line 5597
    :cond_0
    :goto_0
    invoke-static {p2, v0}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    return v0

    :cond_1
    move v0, v1

    move p2, v1

    .line 5583
    goto :goto_0

    .line 5586
    :cond_2
    if-gez p2, :cond_0

    .line 5589
    const/4 v3, -0x1

    if-ne p2, v3, :cond_3

    move p2, v2

    .line 5591
    goto :goto_0

    .line 5592
    :cond_3
    const/4 v0, -0x2

    if-ne p2, v0, :cond_4

    .line 5594
    const/high16 v0, -0x80000000

    move p2, v2

    goto :goto_0

    :cond_4
    move v0, v1

    move p2, v1

    goto :goto_0
.end method

.method public static a(Landroid/view/View;)I
    .locals 1

    .prologue
    .line 5017
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->c:Landroid/support/v7/widget/bi;

    invoke-virtual {v0}, Landroid/support/v7/widget/bi;->c()I

    move-result v0

    return v0
.end method

.method static synthetic a(Landroid/support/v7/widget/au;Landroid/support/v7/widget/bd;)V
    .locals 1

    .prologue
    .line 4481
    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    if-ne v0, p1, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    :cond_0
    return-void
.end method

.method public static a(Landroid/view/View;IIII)V
    .locals 4

    .prologue
    .line 5656
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    .line 5657
    iget v1, v0, Landroid/graphics/Rect;->left:I

    add-int/2addr v1, p1

    iget v2, v0, Landroid/graphics/Rect;->top:I

    add-int/2addr v2, p2

    iget v3, v0, Landroid/graphics/Rect;->right:I

    sub-int v3, p3, v3

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    sub-int v0, p4, v0

    invoke-virtual {p0, v1, v2, v3, v0}, Landroid/view/View;->layout(IIII)V

    .line 5659
    return-void
.end method

.method static synthetic a(Landroid/support/v7/widget/au;)Z
    .locals 1

    .prologue
    .line 4481
    iget-boolean v0, p0, Landroid/support/v7/widget/au;->s:Z

    return v0
.end method

.method public static b(Landroid/view/View;)I
    .locals 3

    .prologue
    .line 5610
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    .line 5611
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    iget v2, v0, Landroid/graphics/Rect;->left:I

    add-int/2addr v1, v2

    iget v0, v0, Landroid/graphics/Rect;->right:I

    add-int/2addr v0, v1

    return v0
.end method

.method static synthetic b(Landroid/support/v7/widget/au;)Z
    .locals 1

    .prologue
    .line 4481
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/au;->s:Z

    return v0
.end method

.method public static c(Landroid/view/View;)I
    .locals 3

    .prologue
    .line 5624
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    .line 5625
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    iget v2, v0, Landroid/graphics/Rect;->top:I

    add-int/2addr v1, v2

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v0, v1

    return v0
.end method

.method public static d(Landroid/view/View;)I
    .locals 2

    .prologue
    .line 5670
    invoke-virtual {p0}, Landroid/view/View;->getLeft()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->left:I

    sub-int v0, v1, v0

    return v0
.end method

.method public static e(Landroid/view/View;)I
    .locals 2

    .prologue
    .line 5682
    invoke-virtual {p0}, Landroid/view/View;->getTop()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->top:I

    sub-int v0, v1, v0

    return v0
.end method

.method public static f(Landroid/view/View;)I
    .locals 2

    .prologue
    .line 5694
    invoke-virtual {p0}, Landroid/view/View;->getRight()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->right:I

    add-int/2addr v0, v1

    return v0
.end method

.method public static g(Landroid/view/View;)I
    .locals 2

    .prologue
    .line 5706
    invoke-virtual {p0}, Landroid/view/View;->getBottom()I

    move-result v1

    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v0, v1

    return v0
.end method

.method private g(I)V
    .locals 4

    .prologue
    .line 4991
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/au;->c(I)Landroid/view/View;

    move-result-object v0

    .line 4992
    if-eqz v0, :cond_0

    .line 4993
    iget-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/d;->a(I)I

    move-result v1

    iget-object v2, v0, Landroid/support/v7/widget/d;->a:Landroid/support/v7/widget/f;

    invoke-interface {v2, v1}, Landroid/support/v7/widget/f;->b(I)Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v3, v0, Landroid/support/v7/widget/d;->a:Landroid/support/v7/widget/f;

    invoke-interface {v3, v1}, Landroid/support/v7/widget/f;->a(I)V

    iget-object v3, v0, Landroid/support/v7/widget/d;->b:Landroid/support/v7/widget/e;

    invoke-virtual {v3, v1}, Landroid/support/v7/widget/e;->c(I)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v0, v0, Landroid/support/v7/widget/d;->c:Ljava/util/List;

    invoke-interface {v0, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 4995
    :cond_0
    return-void
.end method

.method private h(I)V
    .locals 3

    .prologue
    .line 5098
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/au;->c(I)Landroid/view/View;

    iget-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/d;->a(I)I

    move-result v1

    iget-object v2, v0, Landroid/support/v7/widget/d;->a:Landroid/support/v7/widget/f;

    invoke-interface {v2, v1}, Landroid/support/v7/widget/f;->c(I)V

    iget-object v0, v0, Landroid/support/v7/widget/d;->b:Landroid/support/v7/widget/e;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/e;->c(I)Z

    .line 5099
    return-void
.end method


# virtual methods
.method public a(ILandroid/support/v7/widget/az;Landroid/support/v7/widget/bf;)I
    .locals 1

    .prologue
    .line 4746
    const/4 v0, 0x0

    return v0
.end method

.method public a(Landroid/support/v7/widget/az;Landroid/support/v7/widget/bf;)I
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 6412
    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v1}, Landroid/support/v7/widget/RecyclerView;->g(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/an;

    move-result-object v1

    if-nez v1, :cond_1

    .line 6415
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/widget/au;->f()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v0}, Landroid/support/v7/widget/RecyclerView;->g(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/an;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/an;->a()I

    move-result v0

    goto :goto_0
.end method

.method public a(Landroid/support/v7/widget/bf;)I
    .locals 1

    .prologue
    .line 6051
    const/4 v0, 0x0

    return v0
.end method

.method public a(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/av;
    .locals 1

    .prologue
    .line 4729
    new-instance v0, Landroid/support/v7/widget/av;

    invoke-direct {v0, p1, p2}, Landroid/support/v7/widget/av;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method public a(Landroid/view/ViewGroup$LayoutParams;)Landroid/support/v7/widget/av;
    .locals 1

    .prologue
    .line 4705
    instance-of v0, p1, Landroid/support/v7/widget/av;

    if-eqz v0, :cond_0

    .line 4706
    new-instance v0, Landroid/support/v7/widget/av;

    check-cast p1, Landroid/support/v7/widget/av;

    invoke-direct {v0, p1}, Landroid/support/v7/widget/av;-><init>(Landroid/support/v7/widget/av;)V

    .line 4710
    :goto_0
    return-object v0

    .line 4707
    :cond_0
    instance-of v0, p1, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v0, :cond_1

    .line 4708
    new-instance v0, Landroid/support/v7/widget/av;

    check-cast p1, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-direct {v0, p1}, Landroid/support/v7/widget/av;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    goto :goto_0

    .line 4710
    :cond_1
    new-instance v0, Landroid/support/v7/widget/av;

    invoke-direct {v0, p1}, Landroid/support/v7/widget/av;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0
.end method

.method public a(I)Landroid/view/View;
    .locals 5

    .prologue
    .line 5045
    invoke-virtual {p0}, Landroid/support/v7/widget/au;->j()I

    move-result v2

    .line 5046
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_2

    .line 5047
    invoke-virtual {p0, v1}, Landroid/support/v7/widget/au;->c(I)Landroid/view/View;

    move-result-object v0

    .line 5048
    invoke-static {v0}, Landroid/support/v7/widget/RecyclerView;->b(Landroid/view/View;)Landroid/support/v7/widget/bi;

    move-result-object v3

    .line 5049
    if-eqz v3, :cond_1

    .line 5050
    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->c()I

    move-result v4

    if-ne v4, p1, :cond_1

    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->b()Z

    move-result v4

    if-nez v4, :cond_1

    iget-object v4, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    iget-object v4, v4, Landroid/support/v7/widget/RecyclerView;->m:Landroid/support/v7/widget/bf;

    iget-boolean v4, v4, Landroid/support/v7/widget/bf;->i:Z

    if-nez v4, :cond_0

    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->m()Z

    move-result v3

    if-nez v3, :cond_1

    .line 5057
    :cond_0
    :goto_1
    return-object v0

    .line 5046
    :cond_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 5057
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public a()V
    .locals 0

    .prologue
    .line 5973
    return-void
.end method

.method public a(II)V
    .locals 0

    .prologue
    .line 5985
    return-void
.end method

.method public final a(ILandroid/support/v7/widget/az;)V
    .locals 1

    .prologue
    .line 5225
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/au;->c(I)Landroid/view/View;

    move-result-object v0

    .line 5226
    invoke-direct {p0, p1}, Landroid/support/v7/widget/au;->g(I)V

    .line 5227
    invoke-virtual {p2, v0}, Landroid/support/v7/widget/az;->a(Landroid/view/View;)V

    .line 5228
    return-void
.end method

.method public a(Landroid/os/Parcelable;)V
    .locals 0

    .prologue
    .line 6203
    return-void
.end method

.method final a(Landroid/support/v7/widget/RecyclerView;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 4491
    if-nez p1, :cond_0

    .line 4492
    iput-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    .line 4493
    iput-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    .line 4499
    :goto_0
    return-void

    .line 4495
    :cond_0
    iput-object p1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    .line 4496
    iget-object v0, p1, Landroid/support/v7/widget/RecyclerView;->c:Landroid/support/v7/widget/d;

    iput-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    goto :goto_0
.end method

.method public a(Landroid/support/v7/widget/RecyclerView;I)V
    .locals 2

    .prologue
    .line 4809
    const-string v0, "RecyclerView"

    const-string v1, "You must override smoothScrollToPosition to support smooth scrolling"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4810
    return-void
.end method

.method public a(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/az;)V
    .locals 0

    .prologue
    .line 4593
    return-void
.end method

.method public final a(Landroid/support/v7/widget/az;)V
    .locals 4

    .prologue
    .line 5447
    invoke-virtual {p0}, Landroid/support/v7/widget/au;->j()I

    move-result v0

    .line 5448
    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_6

    .line 5449
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/au;->c(I)Landroid/view/View;

    move-result-object v1

    .line 5450
    invoke-static {v1}, Landroid/support/v7/widget/RecyclerView;->b(Landroid/view/View;)Landroid/support/v7/widget/bi;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v7/widget/bi;->b()Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v2}, Landroid/support/v7/widget/bi;->i()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-virtual {v2}, Landroid/support/v7/widget/bi;->m()Z

    move-result v3

    if-nez v3, :cond_1

    invoke-virtual {v2}, Landroid/support/v7/widget/bi;->k()Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v3}, Landroid/support/v7/widget/RecyclerView;->g(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/an;

    move-result-object v3

    iget-boolean v3, v3, Landroid/support/v7/widget/an;->b:Z

    if-nez v3, :cond_1

    invoke-direct {p0, v0}, Landroid/support/v7/widget/au;->g(I)V

    invoke-virtual {p1, v2}, Landroid/support/v7/widget/az;->a(Landroid/support/v7/widget/bi;)V

    .line 5448
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 5450
    :cond_1
    invoke-direct {p0, v0}, Landroid/support/v7/widget/au;->h(I)V

    invoke-static {v1}, Landroid/support/v7/widget/RecyclerView;->b(Landroid/view/View;)Landroid/support/v7/widget/bi;

    move-result-object v1

    iput-object p1, v1, Landroid/support/v7/widget/bi;->j:Landroid/support/v7/widget/az;

    invoke-virtual {v1}, Landroid/support/v7/widget/bi;->k()Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p1, Landroid/support/v7/widget/az;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v2}, Landroid/support/v7/widget/RecyclerView;->h(Landroid/support/v7/widget/RecyclerView;)Z

    move-result v2

    if-nez v2, :cond_4

    :cond_2
    invoke-virtual {v1}, Landroid/support/v7/widget/bi;->i()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {v1}, Landroid/support/v7/widget/bi;->m()Z

    move-result v2

    if-nez v2, :cond_3

    iget-object v2, p1, Landroid/support/v7/widget/az;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v2}, Landroid/support/v7/widget/RecyclerView;->g(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/an;

    move-result-object v2

    iget-boolean v2, v2, Landroid/support/v7/widget/an;->b:Z

    if-nez v2, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    iget-object v2, p1, Landroid/support/v7/widget/az;->a:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_4
    iget-object v2, p1, Landroid/support/v7/widget/az;->b:Ljava/util/ArrayList;

    if-nez v2, :cond_5

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p1, Landroid/support/v7/widget/az;->b:Ljava/util/ArrayList;

    :cond_5
    iget-object v2, p1, Landroid/support/v7/widget/az;->b:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 5452
    :cond_6
    return-void
.end method

.method public a(Landroid/support/v7/widget/az;Landroid/support/v7/widget/bf;Landroid/view/View;Landroid/support/v4/view/a/e;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 6358
    invoke-virtual {p0}, Landroid/support/v7/widget/au;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p3}, Landroid/support/v7/widget/au;->a(Landroid/view/View;)I

    move-result v0

    .line 6359
    :goto_0
    invoke-virtual {p0}, Landroid/support/v7/widget/au;->e()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-static {p3}, Landroid/support/v7/widget/au;->a(Landroid/view/View;)I

    move-result v2

    .line 6360
    :goto_1
    invoke-static {v0, v3, v2, v3, v1}, Landroid/support/v4/view/a/n;->a(IIIIZ)Landroid/support/v4/view/a/n;

    move-result-object v0

    .line 6363
    invoke-virtual {p4, v0}, Landroid/support/v4/view/a/e;->a(Ljava/lang/Object;)V

    .line 6364
    return-void

    :cond_0
    move v0, v1

    .line 6358
    goto :goto_0

    :cond_1
    move v2, v1

    .line 6359
    goto :goto_1
.end method

.method public final a(Landroid/support/v7/widget/bd;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 4818
    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    if-eq p1, v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    iget-boolean v0, v0, Landroid/support/v7/widget/bd;->k:Z

    if-eqz v0, :cond_0

    .line 4820
    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    invoke-virtual {v0}, Landroid/support/v7/widget/bd;->b()V

    .line 4822
    :cond_0
    iput-object p1, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    .line 4823
    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    iput-object v1, v0, Landroid/support/v7/widget/bd;->h:Landroid/support/v7/widget/RecyclerView;

    iput-object p0, v0, Landroid/support/v7/widget/bd;->i:Landroid/support/v7/widget/au;

    iget v1, v0, Landroid/support/v7/widget/bd;->g:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid target position"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iget-object v1, v0, Landroid/support/v7/widget/bd;->h:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, v1, Landroid/support/v7/widget/RecyclerView;->m:Landroid/support/v7/widget/bf;

    iget v2, v0, Landroid/support/v7/widget/bd;->g:I

    iput v2, v1, Landroid/support/v7/widget/bf;->a:I

    iput-boolean v3, v0, Landroid/support/v7/widget/bd;->k:Z

    iput-boolean v3, v0, Landroid/support/v7/widget/bd;->j:Z

    iget v1, v0, Landroid/support/v7/widget/bd;->g:I

    iget-object v2, v0, Landroid/support/v7/widget/bd;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v2}, Landroid/support/v7/widget/RecyclerView;->e(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/au;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/support/v7/widget/au;->a(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v0, Landroid/support/v7/widget/bd;->l:Landroid/view/View;

    iget-object v0, v0, Landroid/support/v7/widget/bd;->h:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v0}, Landroid/support/v7/widget/RecyclerView;->w(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/bh;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/bh;->a()V

    .line 4824
    return-void
.end method

.method final a(Landroid/view/View;IZ)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v2, -0x1

    .line 4917
    invoke-static {p1}, Landroid/support/v7/widget/RecyclerView;->b(Landroid/view/View;)Landroid/support/v7/widget/bi;

    move-result-object v3

    .line 4918
    if-nez p3, :cond_0

    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->m()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 4920
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v0, p1}, Landroid/support/v7/widget/RecyclerView;->c(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)V

    .line 4929
    :goto_0
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av;

    .line 4930
    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->f()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->d()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 4931
    :cond_1
    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->d()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 4932
    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->e()V

    .line 4936
    :goto_1
    iget-object v1, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    invoke-virtual {v1, p1, p2, v2, v7}, Landroid/support/v7/widget/d;->a(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)V

    .line 4961
    :cond_2
    :goto_2
    iget-boolean v1, v0, Landroid/support/v7/widget/av;->f:Z

    if-eqz v1, :cond_3

    .line 4965
    iget-object v1, v3, Landroid/support/v7/widget/bi;->a:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->invalidate()V

    .line 4966
    iput-boolean v7, v0, Landroid/support/v7/widget/av;->f:Z

    .line 4968
    :cond_3
    return-void

    .line 4927
    :cond_4
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v0, p1}, Landroid/support/v7/widget/RecyclerView;->d(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)V

    goto :goto_0

    .line 4934
    :cond_5
    invoke-virtual {v3}, Landroid/support/v7/widget/bi;->g()V

    goto :goto_1

    .line 4940
    :cond_6
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    iget-object v4, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-ne v1, v4, :cond_d

    .line 4942
    iget-object v1, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    iget-object v4, v1, Landroid/support/v7/widget/d;->a:Landroid/support/v7/widget/f;

    invoke-interface {v4, p1}, Landroid/support/v7/widget/f;->a(Landroid/view/View;)I

    move-result v4

    if-ne v4, v2, :cond_8

    move v1, v2

    .line 4943
    :goto_3
    if-ne p2, v2, :cond_7

    .line 4944
    iget-object v4, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    invoke-virtual {v4}, Landroid/support/v7/widget/d;->a()I

    move-result p2

    .line 4946
    :cond_7
    if-ne v1, v2, :cond_a

    .line 4947
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Added View has RecyclerView as parent but view is not a real child. Unfiltered index:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v2, p1}, Landroid/support/v7/widget/RecyclerView;->indexOfChild(Landroid/view/View;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 4942
    :cond_8
    iget-object v5, v1, Landroid/support/v7/widget/d;->b:Landroid/support/v7/widget/e;

    invoke-virtual {v5, v4}, Landroid/support/v7/widget/e;->b(I)Z

    move-result v5

    if-eqz v5, :cond_9

    move v1, v2

    goto :goto_3

    :cond_9
    iget-object v1, v1, Landroid/support/v7/widget/d;->b:Landroid/support/v7/widget/e;

    invoke-virtual {v1, v4}, Landroid/support/v7/widget/e;->d(I)I

    move-result v1

    sub-int v1, v4, v1

    goto :goto_3

    .line 4951
    :cond_a
    if-eq v1, p2, :cond_2

    .line 4952
    iget-object v2, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v2}, Landroid/support/v7/widget/RecyclerView;->e(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/au;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/support/v7/widget/au;->c(I)Landroid/view/View;

    move-result-object v4

    if-nez v4, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Cannot move a child from non-existing index:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    invoke-direct {v2, v1}, Landroid/support/v7/widget/au;->h(I)V

    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/support/v7/widget/av;

    invoke-static {v4}, Landroid/support/v7/widget/RecyclerView;->b(Landroid/view/View;)Landroid/support/v7/widget/bi;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v7/widget/bi;->m()Z

    move-result v6

    if-eqz v6, :cond_c

    iget-object v6, v2, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v6, v4}, Landroid/support/v7/widget/RecyclerView;->c(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)V

    :goto_4
    iget-object v2, v2, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    invoke-virtual {v5}, Landroid/support/v7/widget/bi;->m()Z

    move-result v5

    invoke-virtual {v2, v4, p2, v1, v5}, Landroid/support/v7/widget/d;->a(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)V

    goto/16 :goto_2

    :cond_c
    iget-object v6, v2, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v6, v4}, Landroid/support/v7/widget/RecyclerView;->d(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)V

    goto :goto_4

    .line 4955
    :cond_d
    iget-object v1, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    invoke-virtual {v1, p1, p2, v7}, Landroid/support/v7/widget/d;->a(Landroid/view/View;IZ)V

    .line 4956
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/support/v7/widget/av;->e:Z

    .line 4957
    iget-object v1, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    if-eqz v1, :cond_2

    iget-object v1, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    iget-boolean v1, v1, Landroid/support/v7/widget/bd;->k:Z

    if-eqz v1, :cond_2

    .line 4958
    iget-object v1, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    invoke-static {p1}, Landroid/support/v7/widget/RecyclerView;->c(Landroid/view/View;)I

    move-result v2

    iget v4, v1, Landroid/support/v7/widget/bd;->g:I

    if-ne v2, v4, :cond_2

    iput-object p1, v1, Landroid/support/v7/widget/bd;->l:Landroid/view/View;

    goto/16 :goto_2
.end method

.method final a(Landroid/view/View;Landroid/support/v4/view/a/e;)V
    .locals 2

    .prologue
    .line 6334
    invoke-static {p1}, Landroid/support/v7/widget/RecyclerView;->b(Landroid/view/View;)Landroid/support/v7/widget/bi;

    move-result-object v0

    .line 6336
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/bi;->m()Z

    move-result v0

    if-nez v0, :cond_0

    .line 6337
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    iget-object v0, v0, Landroid/support/v7/widget/RecyclerView;->a:Landroid/support/v7/widget/az;

    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, v1, Landroid/support/v7/widget/RecyclerView;->m:Landroid/support/v7/widget/bf;

    invoke-virtual {p0, v0, v1, p1, p2}, Landroid/support/v7/widget/au;->a(Landroid/support/v7/widget/az;Landroid/support/v7/widget/bf;Landroid/view/View;Landroid/support/v4/view/a/e;)V

    .line 6340
    :cond_0
    return-void
.end method

.method public final a(Landroid/view/View;Landroid/support/v7/widget/az;)V
    .locals 3

    .prologue
    .line 5214
    iget-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    iget-object v1, v0, Landroid/support/v7/widget/d;->a:Landroid/support/v7/widget/f;

    invoke-interface {v1, p1}, Landroid/support/v7/widget/f;->a(Landroid/view/View;)I

    move-result v1

    if-ltz v1, :cond_0

    iget-object v2, v0, Landroid/support/v7/widget/d;->a:Landroid/support/v7/widget/f;

    invoke-interface {v2, v1}, Landroid/support/v7/widget/f;->a(I)V

    iget-object v2, v0, Landroid/support/v7/widget/d;->b:Landroid/support/v7/widget/e;

    invoke-virtual {v2, v1}, Landroid/support/v7/widget/e;->c(I)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v0, v0, Landroid/support/v7/widget/d;->c:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 5215
    :cond_0
    invoke-virtual {p2, p1}, Landroid/support/v7/widget/az;->a(Landroid/view/View;)V

    .line 5216
    return-void
.end method

.method public a(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    const/4 v0, 0x1

    .line 6301
    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, v1, Landroid/support/v7/widget/RecyclerView;->a:Landroid/support/v7/widget/az;

    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, v1, Landroid/support/v7/widget/RecyclerView;->m:Landroid/support/v7/widget/bf;

    invoke-static {p1}, Landroid/support/v4/view/a/a;->a(Landroid/view/accessibility/AccessibilityEvent;)Landroid/support/v4/view/a/ag;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-nez v2, :cond_1

    .line 6302
    :cond_0
    :goto_0
    return-void

    .line 6301
    :cond_1
    iget-object v2, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v2, v0}, Landroid/support/v4/view/ap;->b(Landroid/view/View;I)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v2, v3}, Landroid/support/v4/view/ap;->b(Landroid/view/View;I)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v2, v3}, Landroid/support/v4/view/ap;->a(Landroid/view/View;I)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v2, v0}, Landroid/support/v4/view/ap;->a(Landroid/view/View;I)Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_2
    :goto_1
    invoke-virtual {v1, v0}, Landroid/support/v4/view/a/ag;->a(Z)V

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v0}, Landroid/support/v7/widget/RecyclerView;->g(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/an;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v0}, Landroid/support/v7/widget/RecyclerView;->g(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/an;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/an;->a()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/support/v4/view/a/ag;->a(I)V

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 4531
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    .line 4532
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/RecyclerView;->a(Ljava/lang/String;)V

    .line 4534
    :cond_0
    return-void
.end method

.method public a(Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/bf;Landroid/view/View;Landroid/view/View;)Z
    .locals 1

    .prologue
    .line 5919
    invoke-virtual {p0}, Landroid/support/v7/widget/au;->i()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Landroid/support/v7/widget/RecyclerView;->v(Landroid/support/v7/widget/RecyclerView;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Landroid/support/v7/widget/av;)Z
    .locals 1

    .prologue
    .line 4688
    if-eqz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(ILandroid/support/v7/widget/az;Landroid/support/v7/widget/bf;)I
    .locals 1

    .prologue
    .line 4763
    const/4 v0, 0x0

    return v0
.end method

.method public b(Landroid/support/v7/widget/az;Landroid/support/v7/widget/bf;)I
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 6431
    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v1}, Landroid/support/v7/widget/RecyclerView;->g(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/an;

    move-result-object v1

    if-nez v1, :cond_1

    .line 6434
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/widget/au;->e()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-static {v0}, Landroid/support/v7/widget/RecyclerView;->g(Landroid/support/v7/widget/RecyclerView;)Landroid/support/v7/widget/an;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/an;->a()I

    move-result v0

    goto :goto_0
.end method

.method public b(Landroid/support/v7/widget/bf;)I
    .locals 1

    .prologue
    .line 6096
    const/4 v0, 0x0

    return v0
.end method

.method public abstract b()Landroid/support/v7/widget/av;
.end method

.method public b(I)V
    .locals 0

    .prologue
    .line 4796
    return-void
.end method

.method public b(II)V
    .locals 0

    .prologue
    .line 5995
    return-void
.end method

.method final b(Landroid/support/v7/widget/az;)V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 5482
    iget-object v0, p1, Landroid/support/v7/widget/az;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    move v1, v2

    .line 5483
    :goto_0
    if-ge v1, v3, :cond_2

    .line 5484
    iget-object v0, p1, Landroid/support/v7/widget/az;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/bi;

    iget-object v0, v0, Landroid/support/v7/widget/bi;->a:Landroid/view/View;

    .line 5485
    invoke-static {v0}, Landroid/support/v7/widget/RecyclerView;->b(Landroid/view/View;)Landroid/support/v7/widget/bi;

    move-result-object v4

    .line 5486
    invoke-virtual {v4}, Landroid/support/v7/widget/bi;->b()Z

    move-result v5

    if-nez v5, :cond_1

    .line 5487
    invoke-virtual {v4}, Landroid/support/v7/widget/bi;->n()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 5490
    iget-object v4, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v4, v0, v2}, Landroid/support/v7/widget/RecyclerView;->removeDetachedView(Landroid/view/View;Z)V

    .line 5492
    :cond_0
    invoke-virtual {p1, v0}, Landroid/support/v7/widget/az;->b(Landroid/view/View;)V

    .line 5483
    :cond_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 5494
    :cond_2
    iget-object v0, p1, Landroid/support/v7/widget/az;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 5495
    if-lez v3, :cond_3

    .line 5496
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->invalidate()V

    .line 5498
    :cond_3
    return-void
.end method

.method public c(Landroid/support/v7/widget/bf;)I
    .locals 1

    .prologue
    .line 6036
    const/4 v0, 0x0

    return v0
.end method

.method public final c(I)Landroid/view/View;
    .locals 1

    .prologue
    .line 5246
    iget-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/d;->b(I)Landroid/view/View;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c(ILandroid/support/v7/widget/az;Landroid/support/v7/widget/bf;)Landroid/view/View;
    .locals 1

    .prologue
    .line 5814
    const/4 v0, 0x0

    return-object v0
.end method

.method public c(II)V
    .locals 0

    .prologue
    .line 6005
    return-void
.end method

.method public final c(Landroid/support/v7/widget/az;)V
    .locals 2

    .prologue
    .line 6238
    invoke-virtual {p0}, Landroid/support/v7/widget/au;->j()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_1

    .line 6239
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/au;->c(I)Landroid/view/View;

    move-result-object v1

    .line 6240
    invoke-static {v1}, Landroid/support/v7/widget/RecyclerView;->b(Landroid/view/View;)Landroid/support/v7/widget/bi;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/bi;->b()Z

    move-result v1

    if-nez v1, :cond_0

    .line 6241
    invoke-virtual {p0, v0, p1}, Landroid/support/v7/widget/au;->a(ILandroid/support/v7/widget/az;)V

    .line 6238
    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 6244
    :cond_1
    return-void
.end method

.method public c(Landroid/support/v7/widget/az;Landroid/support/v7/widget/bf;)V
    .locals 2

    .prologue
    .line 4657
    const-string v0, "RecyclerView"

    const-string v1, "You must override onLayoutChildren(Recycler recycler, State state) "

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4658
    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 4557
    const/4 v0, 0x0

    return v0
.end method

.method public d(Landroid/support/v7/widget/bf;)I
    .locals 1

    .prologue
    .line 6081
    const/4 v0, 0x0

    return v0
.end method

.method public d()Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 6197
    const/4 v0, 0x0

    return-object v0
.end method

.method public d(I)V
    .locals 4

    .prologue
    .line 5379
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    .line 5380
    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    iget-object v0, v1, Landroid/support/v7/widget/RecyclerView;->c:Landroid/support/v7/widget/d;

    invoke-virtual {v0}, Landroid/support/v7/widget/d;->a()I

    move-result v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    iget-object v3, v1, Landroid/support/v7/widget/RecyclerView;->c:Landroid/support/v7/widget/d;

    invoke-virtual {v3, v0}, Landroid/support/v7/widget/d;->b(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, p1}, Landroid/view/View;->offsetLeftAndRight(I)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 5382
    :cond_0
    return-void
.end method

.method public d(II)V
    .locals 0

    .prologue
    .line 6021
    return-void
.end method

.method public e(Landroid/support/v7/widget/bf;)I
    .locals 1

    .prologue
    .line 6066
    const/4 v0, 0x0

    return v0
.end method

.method public e(I)V
    .locals 4

    .prologue
    .line 5391
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    .line 5392
    iget-object v1, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    iget-object v0, v1, Landroid/support/v7/widget/RecyclerView;->c:Landroid/support/v7/widget/d;

    invoke-virtual {v0}, Landroid/support/v7/widget/d;->a()I

    move-result v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    iget-object v3, v1, Landroid/support/v7/widget/RecyclerView;->c:Landroid/support/v7/widget/d;

    invoke-virtual {v3, v0}, Landroid/support/v7/widget/d;->b(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, p1}, Landroid/view/View;->offsetTopAndBottom(I)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 5394
    :cond_0
    return-void
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 4773
    const/4 v0, 0x0

    return v0
.end method

.method public f(Landroid/support/v7/widget/bf;)I
    .locals 1

    .prologue
    .line 6111
    const/4 v0, 0x0

    return v0
.end method

.method public f(I)V
    .locals 0

    .prologue
    .line 6223
    return-void
.end method

.method public f()Z
    .locals 1

    .prologue
    .line 4783
    const/4 v0, 0x0

    return v0
.end method

.method public final h()V
    .locals 1

    .prologue
    .line 4505
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    .line 4506
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->requestLayout()V

    .line 4508
    :cond_0
    return-void
.end method

.method public final i()Z
    .locals 1

    .prologue
    .line 4830
    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    iget-boolean v0, v0, Landroid/support/v7/widget/bd;->k:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final j()I
    .locals 1

    .prologue
    .line 5237
    iget-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->p:Landroid/support/v7/widget/d;

    invoke-virtual {v0}, Landroid/support/v7/widget/d;->a()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final k()I
    .locals 1

    .prologue
    .line 5255
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getWidth()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final l()I
    .locals 1

    .prologue
    .line 5264
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getHeight()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final m()I
    .locals 1

    .prologue
    .line 5273
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getPaddingLeft()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final n()I
    .locals 1

    .prologue
    .line 5282
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getPaddingTop()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final o()I
    .locals 1

    .prologue
    .line 5291
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getPaddingRight()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final p()I
    .locals 1

    .prologue
    .line 5300
    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/au;->q:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getPaddingBottom()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final q()V
    .locals 1

    .prologue
    .line 6206
    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    if-eqz v0, :cond_0

    .line 6207
    iget-object v0, p0, Landroid/support/v7/widget/au;->r:Landroid/support/v7/widget/bd;

    invoke-virtual {v0}, Landroid/support/v7/widget/bd;->b()V

    .line 6209
    :cond_0
    return-void
.end method
