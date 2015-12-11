.class public Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Landroid/widget/Button;

.field private b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private c:Landroid/view/View;

.field private g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private h:Landroid/widget/RelativeLayout;

.field private i:Landroid/widget/RelativeLayout;

.field private j:Landroid/widget/Button;

.field private k:Landroid/widget/Button;

.field private l:Lcv;

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private n:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private o:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->m:Ljava/util/ArrayList;

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->n:Ljava/util/ArrayList;

    .line 50
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->o:Z

    .line 53
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->m:Ljava/util/ArrayList;

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->n:Ljava/util/ArrayList;

    .line 50
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->o:Z

    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 57
    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 250
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 214
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 215
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->d()V

    .line 216
    return-void
.end method

.method public c()V
    .locals 6

    .prologue
    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->B()Ljava/util/ArrayList;

    move-result-object v1

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v2

    .line 221
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 222
    new-instance v3, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v0, v4}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;)V

    .line 223
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 224
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v4, 0x1

    const-string v5, "WishListWithProductsFragment"

    invoke-virtual {v0, v3, v4, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 225
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->f:Lnb;

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/util/ArrayList;)V

    .line 227
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->f:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->b(Z)V

    .line 229
    :cond_0
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 240
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 62
    check-cast p1, Landroid/support/v4/app/FragmentActivity;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    .line 63
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->k:Landroid/widget/Button;

    if-ne p1, v0, :cond_1

    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->instantiateSearch()V

    .line 178
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 179
    const-string v1, "Search Product"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    sget-object v1, Llu;->R:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 211
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->a:Landroid/widget/Button;

    if-ne p1, v0, :cond_2

    .line 182
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    const-string v2, "LIFE_EVENTS_PRODUCT_SCAN"

    const-string v3, "LIFE_EVENTS_PRODUCT_SCAN"

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 184
    const-string v1, "Product Scan"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 185
    sget-object v1, Llu;->T:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 186
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->j:Landroid/widget/Button;

    if-ne p1, v0, :cond_5

    .line 187
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {v2, v4}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;-><init>(Z)V

    .line 188
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 189
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v0, :cond_3

    move-object v0, v1

    .line 190
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "BrowseCategoryFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 192
    :cond_3
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_4

    .line 193
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v0, "BrowseCategoryFragment"

    invoke-virtual {v1, v2, v4, v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 195
    :cond_4
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 196
    const-string v1, "Browse Product"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 197
    sget-object v1, Llu;->S:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 198
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->h:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 199
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->g:Ljava/util/ArrayList;

    const-string v1, "Scan History"

    invoke-direct {v2, v4, v0, v1, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/util/ArrayList;Ljava/lang/String;Z)V

    .line 200
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 201
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v0, :cond_6

    move-object v0, v1

    .line 202
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "PLPFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 204
    :cond_6
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_7

    .line 205
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v0, "PLPFragment"

    invoke-virtual {v1, v2, v4, v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 207
    :cond_7
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 208
    const-string v1, "Scan History"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 209
    sget-object v1, Llu;->U:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 71
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    const/4 v4, 0x0

    .line 75
    const v0, 0x7f03006a

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    .line 76
    const v0, 0x7f0c0064

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->c:Landroid/view/View;

    .line 78
    const v0, 0x7f0c0040

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->j:Landroid/widget/Button;

    .line 79
    const v0, 0x7f0c0041

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->k:Landroid/widget/Button;

    .line 80
    const v0, 0x7f0c0044

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->a:Landroid/widget/Button;

    .line 81
    const v0, 0x7f0c0045

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->h:Landroid/widget/RelativeLayout;

    .line 82
    const v0, 0x7f0c003a

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->i:Landroid/widget/RelativeLayout;

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->j:Landroid/widget/Button;

    const v1, 0x7f0800d2

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->k:Landroid/widget/Button;

    const v1, 0x7f0802ee

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->k:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->j:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->a:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    const/4 v3, 0x0

    move-object v1, p0

    move v5, v4

    invoke-static/range {v0 .. v5}, Lmm;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;ZZ)Landroid/view/View;

    move-result-object v0

    .line 90
    if-eqz v0, :cond_0

    .line 91
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->removeAllViews()V

    .line 92
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 95
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    invoke-static {v0}, Lls;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->g:Ljava/util/ArrayList;

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcv;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->l:Lcv;

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->l:Lcv;

    invoke-interface {v0}, Lcv;->onCreateWishListFragmentLaunch()V

    .line 104
    new-instance v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 106
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 107
    const v2, 0x7f0c0048

    const-string v3, "RecentlyViewedListCard"

    invoke-virtual {v1, v2, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 108
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 117
    return-object v6

    .line 100
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->h:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 233
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 234
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->c()V

    .line 235
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 122
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 127
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 131
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    invoke-static {v0}, Lls;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->g:Ljava/util/ArrayList;

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 138
    :goto_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->V()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 144
    :cond_1
    return-void

    .line 136
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->h:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method
