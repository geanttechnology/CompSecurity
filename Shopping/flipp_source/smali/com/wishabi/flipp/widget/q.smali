.class final Lcom/wishabi/flipp/widget/q;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/p;


# instance fields
.field a:Lcom/wishabi/flipp/widget/p;

.field final synthetic b:Lcom/wishabi/flipp/widget/CollectionView;


# direct methods
.method private constructor <init>(Lcom/wishabi/flipp/widget/CollectionView;)V
    .locals 0

    .prologue
    .line 781
    iput-object p1, p0, Lcom/wishabi/flipp/widget/q;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/wishabi/flipp/widget/CollectionView;B)V
    .locals 0

    .prologue
    .line 781
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/widget/q;-><init>(Lcom/wishabi/flipp/widget/CollectionView;)V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/ActionMode;IJZ)V
    .locals 7

    .prologue
    .line 820
    iget-object v1, p0, Lcom/wishabi/flipp/widget/q;->a:Lcom/wishabi/flipp/widget/p;

    move-object v2, p1

    move v3, p2

    move-wide v4, p3

    move v6, p5

    invoke-interface/range {v1 .. v6}, Lcom/wishabi/flipp/widget/p;->a(Landroid/view/ActionMode;IJZ)V

    .line 822
    iget-object v0, p0, Lcom/wishabi/flipp/widget/q;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 823
    invoke-virtual {p1}, Landroid/view/ActionMode;->finish()V

    .line 824
    :cond_0
    return-void
.end method

.method public final onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 1

    .prologue
    .line 804
    iget-object v0, p0, Lcom/wishabi/flipp/widget/q;->a:Lcom/wishabi/flipp/widget/p;

    invoke-interface {v0, p1, p2}, Lcom/wishabi/flipp/widget/p;->onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public final onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 790
    iget-object v1, p0, Lcom/wishabi/flipp/widget/q;->a:Lcom/wishabi/flipp/widget/p;

    invoke-interface {v1, p1, p2}, Lcom/wishabi/flipp/widget/p;->onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 791
    iget-object v1, p0, Lcom/wishabi/flipp/widget/q;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/widget/CollectionView;->setLongClickable(Z)V

    .line 792
    const/4 v0, 0x1

    .line 794
    :cond_0
    return v0
.end method

.method public final onDestroyActionMode(Landroid/view/ActionMode;)V
    .locals 2

    .prologue
    .line 809
    iget-object v0, p0, Lcom/wishabi/flipp/widget/q;->a:Lcom/wishabi/flipp/widget/p;

    invoke-interface {v0, p1}, Lcom/wishabi/flipp/widget/p;->onDestroyActionMode(Landroid/view/ActionMode;)V

    .line 810
    iget-object v0, p0, Lcom/wishabi/flipp/widget/q;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CollectionView;->a(Lcom/wishabi/flipp/widget/CollectionView;)Landroid/view/ActionMode;

    .line 812
    iget-object v0, p0, Lcom/wishabi/flipp/widget/q;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CollectionView;->b(Lcom/wishabi/flipp/widget/CollectionView;)Landroid/util/SparseBooleanArray;

    move-result-object v0

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 813
    iget-object v0, p0, Lcom/wishabi/flipp/widget/q;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->requestLayout()V

    .line 814
    iget-object v0, p0, Lcom/wishabi/flipp/widget/q;->b:Lcom/wishabi/flipp/widget/CollectionView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setLongClickable(Z)V

    .line 815
    return-void
.end method

.method public final onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1

    .prologue
    .line 799
    iget-object v0, p0, Lcom/wishabi/flipp/widget/q;->a:Lcom/wishabi/flipp/widget/p;

    invoke-interface {v0, p1, p2}, Lcom/wishabi/flipp/widget/p;->onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method
