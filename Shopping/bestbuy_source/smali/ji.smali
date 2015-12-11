.class public Lji;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 22
    iput-object p3, p0, Lji;->g:Landroid/view/View;

    .line 23
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 34
    invoke-static {}, Lfs;->e()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lji;->a:Ljava/util/ArrayList;

    .line 35
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 39
    iget-object v0, p0, Lji;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 40
    iget-object v0, p0, Lji;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 43
    :cond_0
    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 44
    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    iget-object v1, p0, Lji;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->a(Ljava/util/ArrayList;)V

    .line 50
    :cond_1
    :goto_0
    return-void

    .line 45
    :cond_2
    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 46
    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    iget-object v1, p0, Lji;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 47
    :cond_3
    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Lji;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;

    iget-object v1, p0, Lji;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 26
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 27
    iget-object v0, p0, Lji;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 28
    iget-object v0, p0, Lji;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 30
    :cond_0
    return-void
.end method
