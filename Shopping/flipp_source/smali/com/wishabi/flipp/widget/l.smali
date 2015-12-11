.class final Lcom/wishabi/flipp/widget/l;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# static fields
.field static final synthetic a:Z


# instance fields
.field final synthetic b:Lcom/wishabi/flipp/widget/j;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 857
    const-class v0, Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/wishabi/flipp/widget/l;->a:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method constructor <init>(Lcom/wishabi/flipp/widget/j;)V
    .locals 0

    .prologue
    .line 857
    iput-object p1, p0, Lcom/wishabi/flipp/widget/l;->b:Lcom/wishabi/flipp/widget/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onLongClick(Landroid/view/View;)Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 860
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/o;

    .line 862
    sget-boolean v3, Lcom/wishabi/flipp/widget/l;->a:Z

    if-nez v3, :cond_0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 863
    :cond_0
    iget v3, v0, Lcom/wishabi/flipp/widget/o;->d:I

    .line 864
    iget-object v0, p0, Lcom/wishabi/flipp/widget/l;->b:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_1

    if-gez v3, :cond_3

    .line 866
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/l;->b:Lcom/wishabi/flipp/widget/j;

    iget-object v4, v0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    iget v0, v4, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    const/4 v5, 0x3

    if-ne v0, v5, :cond_6

    iget-object v0, v4, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-nez v0, :cond_4

    iget-object v0, v4, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    invoke-virtual {v4, v0}, Lcom/wishabi/flipp/widget/CollectionView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {v4, v3, v1}, Lcom/wishabi/flipp/widget/CollectionView;->a(IZ)V

    invoke-virtual {v4, v2}, Lcom/wishabi/flipp/widget/CollectionView;->performHapticFeedback(I)Z

    :cond_2
    :goto_1
    return v1

    .line 864
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/l;->b:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-interface {v0, v3}, Landroid/widget/ListAdapter;->getItemId(I)J

    goto :goto_0

    .line 866
    :cond_4
    iget-object v0, v4, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-eqz v0, :cond_2

    iget-object v0, v4, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, v3, v2}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v0

    if-nez v0, :cond_5

    move v0, v1

    :goto_2
    invoke-virtual {v4, v3, v0}, Lcom/wishabi/flipp/widget/CollectionView;->a(IZ)V

    goto :goto_1

    :cond_5
    move v0, v2

    goto :goto_2

    :cond_6
    iget-object v0, v4, Lcom/wishabi/flipp/widget/CollectionView;->a:Lcom/wishabi/flipp/widget/s;

    if-eqz v0, :cond_8

    invoke-virtual {v4, v2}, Lcom/wishabi/flipp/widget/CollectionView;->performHapticFeedback(I)Z

    if-eqz p1, :cond_7

    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Landroid/view/View;->sendAccessibilityEvent(I)V

    :cond_7
    iget-object v0, v4, Lcom/wishabi/flipp/widget/CollectionView;->a:Lcom/wishabi/flipp/widget/s;

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/s;->a()Z

    move-result v1

    goto :goto_1

    :cond_8
    move v1, v2

    goto :goto_1
.end method
