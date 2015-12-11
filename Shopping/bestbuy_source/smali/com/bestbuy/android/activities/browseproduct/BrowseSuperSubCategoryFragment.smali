.class public Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public a:Landroid/widget/LinearLayout;

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;"
        }
    .end annotation
.end field

.field private c:Led;

.field private g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private h:Landroid/widget/LinearLayout;

.field private i:Lhg;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Landroid/view/View;

.field private m:Landroid/view/View;

.field private n:Z

.field private o:Z

.field private p:Ljava/lang/String;

.field private q:Landroid/widget/ListView;

.field private r:Z

.field private s:Ldy;

.field private t:Ljava/lang/String;

.field private u:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

.field private v:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 65
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->n:Z

    .line 56
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->o:Z

    .line 57
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->p:Ljava/lang/String;

    .line 60
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->r:Z

    .line 66
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/browse/Category;Z)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 74
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->n:Z

    .line 56
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->o:Z

    .line 57
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->p:Ljava/lang/String;

    .line 60
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->r:Z

    .line 75
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getCategoryId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->j:Ljava/lang/String;

    .line 76
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    .line 77
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getGroups()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->b:Ljava/util/List;

    .line 78
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->r:Z

    .line 79
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->b:Ljava/util/List;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->u:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->r:Z

    return v0
.end method

.method private e()V
    .locals 2

    .prologue
    .line 284
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 285
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->b:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/browse/Category;

    .line 284
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 291
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/browse/Category;)V
    .locals 9

    .prologue
    const v8, 0x7f0c0033

    const/4 v3, 0x1

    .line 185
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->p:Ljava/lang/String;

    .line 186
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v6

    .line 187
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 188
    if-eqz v6, :cond_3

    .line 189
    const-string v0, "BaseCategory"

    const-string v2, ""

    invoke-virtual {v6, v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 190
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ": "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->p:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->t:Ljava/lang/String;

    .line 194
    :goto_0
    const-string v0, "BreadCrumb"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->t:Ljava/lang/String;

    invoke-virtual {v6, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    :goto_1
    const/4 v0, 0x0

    .line 200
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getGroups()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getGroups()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    move v0, v3

    .line 203
    :cond_0
    if-eqz v0, :cond_6

    .line 204
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->r:Z

    invoke-direct {v2, p1, v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;-><init>(Lcom/bestbuy/android/api/lib/models/browse/Category;Z)V

    .line 205
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 206
    const-string v4, "BaseCategory"

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    invoke-virtual {v2, v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->setArguments(Landroid/os/Bundle;)V

    .line 208
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 209
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v0, :cond_4

    .line 210
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v2, v3}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 216
    :goto_2
    sget-object v0, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,deptCat"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 217
    sget-object v0, Llu;->bp:Ljava/lang/String;

    const-string v2, "PRD"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->t:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 266
    :cond_1
    :goto_3
    return-void

    .line 192
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "BaseCategory"

    const-string v4, ""

    invoke-virtual {v6, v2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ": "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ": "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->p:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->t:Ljava/lang/String;

    goto/16 :goto_0

    .line 196
    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ": "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->p:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->t:Ljava/lang/String;

    goto/16 :goto_1

    .line 212
    :cond_4
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v2, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_2

    .line 214
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v3, "BrowseSuperSubCategoryFragment"

    invoke-virtual {v0, v8, v2, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_2

    .line 224
    :cond_6
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getSearchPath()Ljava/lang/String;

    move-result-object v2

    .line 230
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 242
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v1

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->t:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 244
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 245
    if-eqz v6, :cond_7

    .line 246
    const-string v2, "Category"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "BaseCategory"

    const-string v7, ""

    invoke-virtual {v6, v5, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 250
    :goto_4
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->setArguments(Landroid/os/Bundle;)V

    .line 251
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 252
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    instance-of v1, v1, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v1, :cond_8

    .line 253
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 254
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v1, v2, v3}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    move-object v1, v2

    .line 261
    :goto_5
    invoke-virtual {v1, v0, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_3

    .line 248
    :cond_7
    const-string v2, "Category"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    .line 257
    :cond_8
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v2, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>(Z)V

    .line 258
    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Z)V

    .line 259
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v4, "PLPFragmentContainer"

    invoke-virtual {v1, v8, v2, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    move-object v1, v2

    goto :goto_5

    .line 263
    :cond_9
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "PLPFragment"

    invoke-virtual {v1, v8, v0, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto/16 :goto_3
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v4, 0x1

    .line 328
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 329
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setVisibility(I)V

    .line 330
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->o:Z

    if-eqz v0, :cond_2

    .line 331
    iput-boolean v6, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->o:Z

    .line 332
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->m:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 339
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    .line 340
    if-eqz v2, :cond_3

    .line 341
    const-string v0, "BaseCategory"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v0, "BaseCategory"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 342
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "BaseCategory"

    invoke-virtual {v2, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object v2, p1

    move-object v3, p0

    invoke-direct/range {v0 .. v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->s:Ldy;

    .line 351
    :cond_0
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->s:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 352
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 353
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v4, :cond_1

    .line 354
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 356
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 378
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "product"

    const-string v2, "productsloadmostpopular"

    invoke-virtual {v0, v1, v2, p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->loadMostPopularRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 379
    return-void

    .line 335
    :cond_2
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->n:Z

    goto :goto_0

    .line 344
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 345
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    move-object v2, p1

    move-object v3, p0

    invoke-direct/range {v0 .. v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->s:Ldy;

    goto :goto_1

    .line 347
    :cond_4
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    const-string v5, "product"

    move-object v2, p1

    move-object v3, p0

    invoke-direct/range {v0 .. v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->s:Ldy;

    goto :goto_1
.end method

.method public a(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 269
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->n:Z

    if-eqz v0, :cond_1

    .line 270
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->n:Z

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->m:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 275
    :goto_0
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->b:Ljava/util/List;

    .line 276
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 277
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->e()V

    .line 278
    new-instance v0, Led;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1, v2, p1}, Led;-><init>(Landroid/content/Context;ILjava/util/List;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->c:Led;

    .line 279
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->q:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->c:Led;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 281
    :cond_0
    return-void

    .line 274
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->o:Z

    goto :goto_0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 182
    :cond_0
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 316
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->u:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 317
    return-void
.end method

.method public d()V
    .locals 2

    .prologue
    .line 320
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->u:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 321
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 152
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 154
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 147
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 148
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    .line 383
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->h:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 384
    new-instance v8, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 385
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "MostPopular"

    const-string v3, "Most Popular"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->j:Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    const/16 v7, 0x32

    invoke-direct/range {v0 .. v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 386
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v8, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 387
    invoke-virtual {v8, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 389
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 84
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->f:Lnb;

    .line 85
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9

    .prologue
    const v7, 0x7f0b0008

    const/high16 v5, 0x7f0b0000

    const/4 v6, 0x1

    const/4 v4, -0x1

    const/4 v8, 0x0

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->l:Landroid/view/View;

    if-nez v0, :cond_3

    .line 90
    const v0, 0x7f030016

    invoke-virtual {p1, v0, p2, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->l:Landroid/view/View;

    .line 91
    const v0, 0x7f030019

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->q:Landroid/widget/ListView;

    invoke-virtual {p1, v0, v1, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 92
    const v0, 0x7f0c0074

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v2, 0xf

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->l:Landroid/view/View;

    const v2, 0x7f0c0064

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->m:Landroid/view/View;

    .line 95
    const v0, 0x7f0c0071

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a:Landroid/widget/LinearLayout;

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->l:Landroid/view/View;

    const v2, 0x102000a

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->q:Landroid/widget/ListView;

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->q:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 98
    new-instance v0, Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 99
    new-instance v2, Landroid/widget/AbsListView$LayoutParams;

    const/4 v3, 0x3

    invoke-direct {v2, v4, v3}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 100
    invoke-virtual {v0, v7}, Landroid/view/View;->setBackgroundResource(I)V

    .line 101
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->q:Landroid/widget/ListView;

    invoke-virtual {v2, v0}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 102
    new-instance v0, Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 103
    new-instance v2, Landroid/widget/AbsListView$LayoutParams;

    invoke-direct {v2, v4, v6}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 104
    invoke-virtual {v0, v7}, Landroid/view/View;->setBackgroundResource(I)V

    .line 105
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->q:Landroid/widget/ListView;

    invoke-virtual {v2, v0}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 107
    const v0, 0x7f0c0073

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->h:Landroid/widget/LinearLayout;

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->l:Landroid/view/View;

    const v1, 0x7f0c006e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->u:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->u:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const v1, 0x7f0b0063

    const v2, 0x7f0b0063

    invoke-virtual {v0, v5, v1, v5, v2}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setColorScheme(IIII)V

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->u:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 112
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->v:Z

    .line 113
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->v:Z

    if-nez v0, :cond_1

    .line 114
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->c()V

    .line 118
    :goto_0
    new-instance v0, Lhg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->j:Ljava/lang/String;

    const/4 v5, 0x0

    const/16 v7, 0xa

    move-object v2, p0

    invoke-direct/range {v0 .. v8}, Lhg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;IIZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->i:Lhg;

    .line 119
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->r:Z

    if-eqz v0, :cond_2

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 125
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->b:Ljava/util/List;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a(Ljava/util/List;)V

    .line 129
    :goto_2
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->r:Z

    if-nez v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 131
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->q:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->l:Landroid/view/View;

    return-object v0

    .line 116
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d()V

    goto :goto_0

    .line 122
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->i:Lhg;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 127
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->l:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->l:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_2
.end method

.method public onDestroy()V
    .locals 4

    .prologue
    .line 393
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 394
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 395
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 396
    if-eqz v0, :cond_1

    .line 397
    sget-object v2, Llu;->bo:Ljava/lang/String;

    const-string v3, "browse,deptCat"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 398
    sget-object v2, Llu;->bp:Ljava/lang/String;

    const-string v3, "PRD"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 399
    const-string v2, "BaseCategory"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 400
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 409
    :goto_0
    return-void

    .line 402
    :cond_0
    const-string v2, "BaseCategory"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 405
    :cond_1
    sget-object v0, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,products"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 406
    sget-object v0, Llu;->bp:Ljava/lang/String;

    const-string v2, "PRD"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 407
    sget-object v0, Llu;->D:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0
.end method

.method public onRefresh()V
    .locals 4

    .prologue
    .line 295
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d()V

    .line 296
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 313
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 158
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 159
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->v:Z

    .line 160
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->v:Z

    if-nez v0, :cond_1

    .line 161
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->c()V

    .line 165
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->k:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 166
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->r:Z

    if-nez v0, :cond_2

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 173
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->s:Ldy;

    if-eqz v0, :cond_0

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->s:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 176
    :cond_0
    return-void

    .line 163
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d()V

    goto :goto_0

    .line 170
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    goto :goto_1
.end method
