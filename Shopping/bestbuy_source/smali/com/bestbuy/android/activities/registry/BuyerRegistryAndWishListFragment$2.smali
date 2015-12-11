.class Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)V
    .locals 0

    .prologue
    .line 351
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 357
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->k(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 358
    add-int v0, p2, p3

    .line 359
    if-lez p4, :cond_2

    .line 360
    if-ne v0, p4, :cond_2

    .line 361
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->l(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    mul-int/lit8 v0, v0, 0x19

    .line 362
    add-int/lit8 v2, v0, 0x19

    .line 363
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-le v1, v0, :cond_2

    .line 365
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 366
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-le v1, v2, :cond_0

    move v1, v2

    :goto_1
    if-ge v0, v1, :cond_1

    .line 367
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 366
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto :goto_1

    .line 369
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)I

    .line 370
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;Z)Z

    .line 371
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 372
    new-instance v0, Ljn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;->a:Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    const/4 v3, 0x0

    invoke-direct/range {v0 .. v5}, Ljn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;Z)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v5, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 378
    :cond_2
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0

    .prologue
    .line 354
    return-void
.end method
