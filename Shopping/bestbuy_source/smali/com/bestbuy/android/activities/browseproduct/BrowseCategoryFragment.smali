.class public Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public a:Landroid/widget/LinearLayout;

.field private b:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

.field private c:Led;

.field private g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private h:Landroid/widget/LinearLayout;

.field private i:Lhg;

.field private j:Lii;

.field private k:Landroid/app/Activity;

.field private l:Landroid/view/View;

.field private m:Landroid/view/View;

.field private n:Landroid/widget/ListView;

.field private o:Z

.field private p:Z

.field private q:Z

.field private r:Ldy;

.field private s:Ljava/lang/String;

.field private t:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

.field private u:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 69
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 60
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->o:Z

    .line 61
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->p:Z

    .line 63
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    .line 70
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 72
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 60
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->o:Z

    .line 61
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->p:Z

    .line 63
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    .line 73
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    .line 74
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->b:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->s:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->s:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Z
    .locals 1

    .prologue
    .line 48
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    return v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->t:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    return-object v0
.end method

.method private e()V
    .locals 2

    .prologue
    .line 257
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->b:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;->getHeader()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->b:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;->getHeader()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/browse/Category;

    .line 257
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 264
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;)V
    .locals 4

    .prologue
    const/16 v1, 0x8

    const/4 v3, 0x0

    .line 241
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->o:Z

    if-eqz v0, :cond_1

    .line 242
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->o:Z

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->m:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 247
    :goto_0
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->b:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a(Landroid/view/View;)Landroid/widget/FrameLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 249
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;->getHeader()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 250
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->e()V

    .line 251
    new-instance v0, Led;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;->getHeader()Ljava/util/List;

    move-result-object v2

    invoke-direct {v0, v1, v3, v2}, Led;-><init>(Landroid/content/Context;ILjava/util/List;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c:Led;

    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->n:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c:Led;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 254
    :cond_0
    return-void

    .line 246
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->p:Z

    goto :goto_0
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
    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 267
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 268
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setVisibility(I)V

    .line 269
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->p:Z

    if-eqz v0, :cond_1

    .line 270
    iput-boolean v6, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->p:Z

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->m:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 278
    :goto_0
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    const-string v5, "product"

    move-object v2, p1

    move-object v3, p0

    invoke-direct/range {v0 .. v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->r:Ldy;

    .line 279
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->r:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 280
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 281
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v4, :cond_0

    .line 282
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 283
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 305
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "product"

    const-string v2, "productsloadmostpopular"

    invoke-virtual {v0, v1, v2, p1}, Lcom/bestbuy/android/activities/home/HomeActivity;->loadMostPopularRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 306
    return-void

    .line 274
    :cond_1
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->o:Z

    goto :goto_0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    if-nez v0, :cond_0

    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 238
    :cond_0
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 347
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->t:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 348
    return-void
.end method

.method public d()V
    .locals 2

    .prologue
    .line 351
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->t:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 352
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 188
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 189
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    if-nez v0, :cond_2

    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 195
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->i:Lhg;

    invoke-virtual {v0}, Lhg;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    if-nez v0, :cond_0

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->i:Lhg;

    invoke-virtual {v0}, Lhg;->d()V

    .line 197
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->j:Lii;

    invoke-virtual {v0}, Lii;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->j:Lii;

    invoke-virtual {v0}, Lii;->d()V

    .line 199
    :cond_1
    return-void

    .line 193
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 182
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 183
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    .line 184
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    .line 310
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->h:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 311
    new-instance v8, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 312
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "MostPopular"

    const-string v3, "Most Popular"

    const-string v4, "all"

    const/4 v5, 0x0

    const-string v6, "Products"

    const/16 v7, 0xa

    invoke-direct/range {v0 .. v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 313
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v8, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 314
    invoke-virtual {v8, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 316
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 78
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 79
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9

    .prologue
    const v5, 0x7f0b0008

    const/high16 v4, 0x7f0b0000

    const/4 v6, 0x1

    const/4 v3, -0x1

    const/4 v8, 0x0

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    if-nez v0, :cond_2

    .line 84
    const v0, 0x7f030016

    invoke-virtual {p1, v0, p2, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    .line 85
    const v0, 0x7f030019

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->n:Landroid/widget/ListView;

    invoke-virtual {p1, v0, v1, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 86
    const v0, 0x7f0c0074

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 87
    const v0, 0x7f0c0071

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a:Landroid/widget/LinearLayout;

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->g:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v2, 0xf

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    const v2, 0x7f0c0064

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->m:Landroid/view/View;

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    const v2, 0x102000a

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->n:Landroid/widget/ListView;

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->n:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 92
    new-instance v0, Landroid/view/View;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 93
    new-instance v1, Landroid/widget/AbsListView$LayoutParams;

    const/4 v2, 0x3

    invoke-direct {v1, v3, v2}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 94
    invoke-virtual {v0, v5}, Landroid/view/View;->setBackgroundResource(I)V

    .line 95
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->n:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 96
    new-instance v0, Landroid/view/View;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 97
    new-instance v1, Landroid/widget/AbsListView$LayoutParams;

    invoke-direct {v1, v3, v6}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 98
    invoke-virtual {v0, v5}, Landroid/view/View;->setBackgroundResource(I)V

    .line 99
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->n:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    const v1, 0x7f0c0073

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->h:Landroid/widget/LinearLayout;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    const v1, 0x7f0c006e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->t:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->t:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const v1, 0x7f0b0063

    const v2, 0x7f0b0063

    invoke-virtual {v0, v4, v1, v4, v2}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setColorScheme(IIII)V

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->t:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 105
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->u:Z

    .line 106
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->u:Z

    if-nez v0, :cond_0

    .line 107
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c()V

    .line 112
    :goto_0
    new-instance v0, Lhg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    const/4 v3, 0x0

    const-string v4, "all"

    const/4 v5, 0x0

    const/16 v7, 0xa

    move-object v2, p0

    invoke-direct/range {v0 .. v8}, Lhg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;IIZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->i:Lhg;

    .line 113
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    if-eqz v0, :cond_1

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 118
    :goto_1
    new-instance v0, Lii;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->m:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Lii;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->j:Lii;

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->j:Lii;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lii;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 123
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->n:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    return-object v0

    .line 109
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->d()V

    goto :goto_0

    .line 116
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->i:Lhg;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1

    .line 121
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_2
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 319
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 323
    return-void
.end method

.method public onPause()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 227
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 228
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->m:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->m:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 230
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->i:Lhg;

    invoke-virtual {v0, v2}, Lhg;->cancel(Z)Z

    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->j:Lii;

    invoke-virtual {v0, v2}, Lii;->cancel(Z)Z

    .line 232
    return-void
.end method

.method public onRefresh()V
    .locals 4

    .prologue
    .line 326
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->d()V

    .line 327
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 344
    return-void
.end method

.method public onResume()V
    .locals 9

    .prologue
    const/4 v3, 0x0

    const/4 v8, 0x0

    .line 203
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 204
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->u:Z

    .line 205
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->u:Z

    if-nez v0, :cond_2

    .line 206
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c()V

    .line 210
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Products"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 211
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 212
    new-instance v0, Lhg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    const-string v4, "all"

    const/4 v6, 0x1

    const/16 v7, 0xa

    move-object v2, p0

    move-object v5, v3

    invoke-direct/range {v0 .. v8}, Lhg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;IIZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->i:Lhg;

    .line 213
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->q:Z

    if-eqz v0, :cond_3

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 218
    :goto_1
    new-instance v0, Lii;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->k:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->m:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Lii;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->j:Lii;

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->j:Lii;

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lii;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 221
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->r:Ldy;

    if-eqz v0, :cond_1

    .line 222
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->r:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 224
    :cond_1
    return-void

    .line 208
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->d()V

    goto :goto_0

    .line 216
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->i:Lhg;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1
.end method
