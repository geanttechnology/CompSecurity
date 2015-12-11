.class public Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Landroid/widget/RelativeLayout;

.field private b:Landroid/widget/TextView;

.field private c:Landroid/widget/Button;

.field private g:Landroid/widget/Button;

.field private h:Landroid/widget/RelativeLayout;

.field private i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private j:Landroid/view/View;

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private l:Ljava/lang/String;

.field private m:Landroid/widget/RelativeLayout;

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

.field private o:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->n:Ljava/util/ArrayList;

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->o:Ljava/util/ArrayList;

    .line 60
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->n:Ljava/util/ArrayList;

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->o:Ljava/util/ArrayList;

    .line 63
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 64
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v0, v4}, Lnb;->c(Z)V

    .line 169
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 170
    new-instance v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 171
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 172
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 173
    const v2, 0x7f0c0048

    const-string v3, "RecentlyViewedListCard"

    invoke-virtual {v1, v2, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 174
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    const/4 v5, 0x1

    move-object v1, p0

    move-object v3, p1

    invoke-static/range {v0 .. v5}, Lmm;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;ZZ)Landroid/view/View;

    move-result-object v0

    .line 176
    if-eqz v0, :cond_0

    .line 177
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->m:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->removeAllViews()V

    .line 178
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->m:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 180
    :cond_0
    return-void
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V
    .locals 0

    .prologue
    .line 251
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 3
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
    .line 299
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->n:Ljava/util/ArrayList;

    .line 300
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->o:Ljava/util/ArrayList;

    .line 301
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 302
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 303
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->n:Ljava/util/ArrayList;

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 304
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->o:Ljava/util/ArrayList;

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 302
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 307
    :cond_0
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    .line 244
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->l:Ljava/lang/String;

    .line 245
    new-instance v0, Ljj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->j:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->l:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Ljj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 246
    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v0}, Lnb;->C()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 255
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 256
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->d()V

    .line 258
    :cond_0
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 164
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 149
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v0}, Lnb;->E()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 151
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->b()V

    .line 159
    :goto_0
    return-void

    .line 153
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_1

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    goto :goto_0

    .line 156
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->b()V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 68
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 69
    check-cast p1, Landroid/support/v4/app/FragmentActivity;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    .line 70
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const/4 v3, 0x1

    .line 192
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 240
    :goto_0
    return-void

    .line 194
    :sswitch_0
    new-instance v1, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->n:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->o:Ljava/util/ArrayList;

    invoke-direct {v1, v3, v0, v2}, Lcom/bestbuy/android/activities/registry/RecommendationsFragment;-><init>(ZLjava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 195
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 196
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v2, :cond_0

    .line 197
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v2, "RecommendationsFragment"

    invoke-virtual {v0, v1, v3, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 199
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 200
    const-string v1, "Need Some Inspiration"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 201
    sget-object v1, Llu;->aA:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 204
    :sswitch_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->instantiateSearch()V

    .line 205
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 206
    const-string v1, "Search Product"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 207
    sget-object v1, Llu;->aB:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 210
    :sswitch_2
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {v1, v3}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;-><init>(Z)V

    .line 211
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 212
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v2, :cond_1

    .line 213
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 215
    :cond_1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 216
    const-string v1, "Browse Product"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 217
    sget-object v1, Llu;->aC:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 220
    :sswitch_3
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    const-string v2, "LIFE_EVENTS_PRODUCT_SCAN"

    const-string v3, "LIFE_EVENTS_PRODUCT_SCAN"

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 222
    const-string v1, "Product Scan"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    sget-object v1, Llu;->aD:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 227
    :sswitch_4
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->k:Ljava/util/ArrayList;

    const-string v2, "Scan History"

    invoke-direct {v1, v3, v0, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/util/ArrayList;Ljava/lang/String;Z)V

    .line 228
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 229
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v2, :cond_2

    .line 230
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 232
    :cond_2
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 233
    const-string v1, "Scan History"

    const-string v2, "Selected"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 234
    sget-object v1, Llu;->aE:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 192
    :sswitch_data_0
    .sparse-switch
        0x7f0c003c -> :sswitch_0
        0x7f0c0044 -> :sswitch_3
        0x7f0c0045 -> :sswitch_4
        0x7f0c017d -> :sswitch_2
        0x7f0c017e -> :sswitch_1
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_0

    .line 78
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 114
    const v0, 0x7f03006b

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 115
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->j:Landroid/view/View;

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 117
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 118
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 120
    :cond_0
    const v0, 0x7f0c003c

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a:Landroid/widget/RelativeLayout;

    .line 121
    const v0, 0x7f0c017e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->g:Landroid/widget/Button;

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->g:Landroid/widget/Button;

    const v2, 0x7f0802ee

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->g:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    const v0, 0x7f0c017d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->c:Landroid/widget/Button;

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->c:Landroid/widget/Button;

    const v2, 0x7f0800d2

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->c:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 127
    const v0, 0x7f0c003a

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->m:Landroid/widget/RelativeLayout;

    .line 128
    const v0, 0x7f0c0044

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->b:Landroid/widget/TextView;

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->b:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 131
    const v0, 0x7f0c0045

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->h:Landroid/widget/RelativeLayout;

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    invoke-static {v0}, Lls;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->k:Ljava/util/ArrayList;

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 139
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->n:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 145
    :goto_1
    return-object v1

    .line 137
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0

    .line 143
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_1
.end method

.method public onDestroy()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 272
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 284
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v0}, Lnb;->C()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 285
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v0}, Lnb;->B()Ljava/util/ArrayList;

    move-result-object v1

    .line 286
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v2

    .line 287
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 288
    new-instance v3, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v0, v4, v5}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;Z)V

    .line 289
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 290
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v4, "WishListWithProductsFragment"

    invoke-virtual {v0, v3, v5, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 291
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 292
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/util/ArrayList;)V

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->b(Z)V

    .line 296
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 268
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 269
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 86
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v0}, Lnb;->E()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_2

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 92
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 98
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    invoke-static {v0}, Lls;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    .line 99
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->f:Lnb;

    invoke-virtual {v0}, Lnb;->C()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 107
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->c()V

    .line 109
    :cond_1
    new-instance v0, Lji;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->j:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Lji;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lji;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 110
    return-void

    .line 95
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto :goto_0

    .line 103
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->h:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_1
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 81
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onStart()V

    .line 82
    return-void
.end method

.method public onViewStateRestored(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 265
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onViewStateRestored(Landroid/os/Bundle;)V

    .line 266
    return-void
.end method
