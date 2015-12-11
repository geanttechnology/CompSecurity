.class Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->a(Ljava/util/ArrayList;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/util/ArrayList;

.field final synthetic b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->a:Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "weddingregistrylists"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->a(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    const-string v1, "weddingregistry"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setListType(Ljava/lang/String;)V

    .line 111
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->b(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->b(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 112
    new-instance v1, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->a(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->b(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v0, v3}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;Ljava/lang/String;)V

    move-object v2, v1

    .line 117
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 118
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 119
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "EditListDetailsFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 121
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_1

    move-object v0, v1

    .line 122
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "EditListDetailsFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 124
    :cond_1
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_2

    .line 125
    check-cast v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v1, v2, v4}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 127
    :cond_2
    return-void

    .line 107
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->a(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v1

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setListType(Ljava/lang/String;)V

    goto :goto_0

    .line 114
    :cond_4
    new-instance v1, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->b:Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->a(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v2, v0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;)V

    move-object v2, v1

    goto :goto_1
.end method
