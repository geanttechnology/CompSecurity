.class public Ljn;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private l:Z

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private n:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private o:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    sput v0, Ljn;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ljn;->a:Ljava/util/ArrayList;

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ljn;->j:Ljava/util/ArrayList;

    .line 27
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ljn;->n:Ljava/util/ArrayList;

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ljn;->o:Ljava/util/ArrayList;

    .line 34
    iput-object p3, p0, Ljn;->g:Landroid/view/View;

    .line 35
    iput-boolean p5, p0, Ljn;->l:Z

    .line 36
    iput-object p4, p0, Ljn;->m:Ljava/util/ArrayList;

    .line 37
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 21
    sput p0, Ljn;->k:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 46
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    move v1, v2

    .line 47
    :goto_0
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 48
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getSku()Ljava/lang/String;

    move-result-object v0

    iget-object v4, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    iget-object v4, p0, Ljn;->a:Ljava/util/ArrayList;

    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getSku()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 47
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 51
    :cond_0
    iget-object v0, p0, Ljn;->a:Ljava/util/ArrayList;

    invoke-static {v0}, Lfs;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Ljn;->j:Ljava/util/ArrayList;

    .line 52
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 53
    iget-object v0, p0, Ljn;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    iget-object v0, p0, Ljn;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 54
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 55
    iget-object v0, p0, Ljn;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 56
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 58
    :cond_1
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v5, p0, Ljn;->j:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-le v0, v5, :cond_4

    .line 59
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    .line 60
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getSku()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 61
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getSku()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 63
    :cond_2
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 65
    :cond_3
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 66
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 72
    :cond_4
    :goto_3
    iget-object v0, p0, Ljn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    if-eqz v0, :cond_8

    .line 73
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    if-eqz v0, :cond_8

    .line 74
    :goto_4
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_7

    .line 75
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->isFavorite()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 76
    iget-object v0, p0, Ljn;->n:Ljava/util/ArrayList;

    iget-object v1, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 74
    :goto_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .line 69
    :cond_5
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    goto :goto_3

    .line 78
    :cond_6
    iget-object v0, p0, Ljn;->o:Ljava/util/ArrayList;

    iget-object v1, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 80
    :cond_7
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 81
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    iget-object v1, p0, Ljn;->n:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 82
    iget-object v0, p0, Ljn;->m:Ljava/util/ArrayList;

    iget-object v1, p0, Ljn;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 85
    :cond_8
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    .line 89
    const/4 v0, 0x0

    sput v0, Ljn;->k:I

    .line 90
    iget-object v0, p0, Ljn;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 91
    iget-object v0, p0, Ljn;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 92
    :cond_0
    iget-object v0, p0, Ljn;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 93
    iget-object v0, p0, Ljn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 94
    iget-object v0, p0, Ljn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v1, p0, Ljn;->j:Ljava/util/ArrayList;

    iget-object v2, p0, Ljn;->m:Ljava/util/ArrayList;

    iget-boolean v3, p0, Ljn;->l:Z

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V

    .line 96
    :cond_1
    iget-object v0, p0, Ljn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 97
    iget-object v0, p0, Ljn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    iget-object v1, p0, Ljn;->j:Ljava/util/ArrayList;

    iget-object v2, p0, Ljn;->m:Ljava/util/ArrayList;

    iget-boolean v3, p0, Ljn;->l:Z

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V

    .line 100
    :cond_2
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 110
    iget-object v0, p0, Ljn;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Ljn;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 112
    :cond_0
    iget-object v0, p0, Ljn;->f:Landroid/app/Activity;

    new-instance v1, Ljn$1;

    invoke-direct {v1, p0}, Ljn$1;-><init>(Ljn;)V

    new-instance v2, Ljn$2;

    invoke-direct {v2, p0}, Ljn$2;-><init>(Ljn;)V

    iget-boolean v3, p0, Ljn;->e:Z

    sget v4, Ljn;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 123
    return-void
.end method

.method public d()V
    .locals 6

    .prologue
    .line 104
    sget v0, Ljn;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljn;->k:I

    .line 105
    new-instance v0, Ljn;

    iget-object v1, p0, Ljn;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljn;->g:Landroid/view/View;

    iget-object v4, p0, Ljn;->m:Ljava/util/ArrayList;

    iget-boolean v5, p0, Ljn;->l:Z

    invoke-direct/range {v0 .. v5}, Ljn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;Z)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 106
    return-void
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 41
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 42
    return-void
.end method
