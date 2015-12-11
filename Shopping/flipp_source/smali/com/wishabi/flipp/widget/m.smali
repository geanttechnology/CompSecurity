.class final Lcom/wishabi/flipp/widget/m;
.super Landroid/database/DataSetObserver;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/j;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/j;)V
    .locals 0

    .prologue
    .line 871
    iput-object p1, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public final onChanged()V
    .locals 4

    .prologue
    .line 874
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/j;->removeAllViews()V

    .line 875
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->c(Lcom/wishabi/flipp/widget/j;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 876
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/j;->a:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 878
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 879
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v1

    .line 880
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_0

    .line 881
    iget-object v2, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/j;->c(Lcom/wishabi/flipp/widget/j;)Ljava/util/List;

    move-result-object v2

    new-instance v3, Ljava/util/Stack;

    invoke-direct {v3}, Ljava/util/Stack;-><init>()V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 880
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 884
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CollectionView;->c(Lcom/wishabi/flipp/widget/CollectionView;)V

    .line 885
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/j;->requestLayout()V

    .line 886
    return-void
.end method

.method public final onInvalidated()V
    .locals 4

    .prologue
    .line 890
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/j;->removeAllViews()V

    .line 891
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->c(Lcom/wishabi/flipp/widget/j;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 892
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/j;->a:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 894
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 895
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v1

    .line 896
    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_0

    .line 897
    iget-object v2, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-static {v2}, Lcom/wishabi/flipp/widget/j;->c(Lcom/wishabi/flipp/widget/j;)Ljava/util/List;

    move-result-object v2

    new-instance v3, Ljava/util/Stack;

    invoke-direct {v3}, Ljava/util/Stack;-><init>()V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 896
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 900
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CollectionView;->c(Lcom/wishabi/flipp/widget/CollectionView;)V

    .line 901
    iget-object v0, p0, Lcom/wishabi/flipp/widget/m;->a:Lcom/wishabi/flipp/widget/j;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/j;->requestLayout()V

    .line 902
    return-void
.end method
