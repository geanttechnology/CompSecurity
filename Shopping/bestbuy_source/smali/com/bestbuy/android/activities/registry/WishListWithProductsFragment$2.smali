.class Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V
    .locals 0

    .prologue
    .line 766
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 6

    .prologue
    .line 772
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 773
    add-int v0, p2, p3

    .line 774
    if-lez p4, :cond_2

    .line 775
    if-ne v0, p4, :cond_2

    .line 777
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    mul-int/lit8 v0, v0, 0x19

    .line 778
    add-int/lit8 v2, v0, 0x19

    .line 779
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-le v1, v0, :cond_2

    .line 781
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 782
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-le v1, v2, :cond_0

    move v1, v2

    :goto_1
    if-ge v0, v1, :cond_1

    .line 783
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 782
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto :goto_1

    .line 786
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->e(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)I

    .line 787
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;Z)Z

    .line 788
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 789
    new-instance v0, Ljn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    const/4 v3, 0x0

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->f(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Z

    move-result v5

    invoke-direct/range {v0 .. v5}, Ljn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;Z)V

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 796
    :cond_2
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0

    .prologue
    .line 769
    return-void
.end method
