.class final Lcom/wishabi/flipp/widget/k;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field static final synthetic a:Z


# instance fields
.field final synthetic b:Lcom/wishabi/flipp/widget/j;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 844
    const-class v0, Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/wishabi/flipp/widget/k;->a:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method constructor <init>(Lcom/wishabi/flipp/widget/j;)V
    .locals 0

    .prologue
    .line 844
    iput-object p1, p0, Lcom/wishabi/flipp/widget/k;->b:Lcom/wishabi/flipp/widget/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 847
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/o;

    .line 849
    sget-boolean v1, Lcom/wishabi/flipp/widget/k;->a:Z

    if-nez v1, :cond_0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 850
    :cond_0
    iget v0, v0, Lcom/wishabi/flipp/widget/o;->d:I

    .line 851
    iget-object v1, p0, Lcom/wishabi/flipp/widget/k;->b:Lcom/wishabi/flipp/widget/j;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/j;->b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;

    move-result-object v1

    if-eqz v1, :cond_1

    if-gez v0, :cond_2

    .line 853
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/wishabi/flipp/widget/k;->b:Lcom/wishabi/flipp/widget/j;

    iget-object v1, v1, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v1, p1, v0}, Lcom/wishabi/flipp/widget/CollectionView;->a(Landroid/view/View;I)V

    .line 854
    return-void

    .line 851
    :cond_2
    iget-object v1, p0, Lcom/wishabi/flipp/widget/k;->b:Lcom/wishabi/flipp/widget/j;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/j;->b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/widget/ListAdapter;->getItemId(I)J

    goto :goto_0
.end method
