.class public Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field private A:I

.field private B:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private C:Ljava/lang/String;

.field private D:Ljava/lang/String;

.field private E:Ljava/lang/String;

.field private F:Landroid/widget/RelativeLayout;

.field private G:Z

.field private H:Landroid/widget/AbsListView$OnScrollListener;

.field private a:Landroid/app/Activity;

.field private b:Landroid/view/View;

.field private c:Ljava/lang/String;

.field private g:Landroid/view/View;

.field private h:I

.field private i:Lfl;

.field private j:Landroid/view/View;

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private l:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;",
            ">;"
        }
    .end annotation
.end field

.field private m:Z

.field private n:I

.field private o:Ljava/lang/String;

.field private p:I

.field private q:I

.field private r:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private t:Landroid/widget/ImageView;

.field private u:Landroid/widget/RatingBar;

.field private v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private w:Landroid/widget/ListView;

.field private x:Z

.field private y:D

.field private z:D


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 73
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 46
    iput v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->h:I

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->k:Ljava/util/ArrayList;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l:Ljava/util/ArrayList;

    .line 51
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->m:Z

    .line 52
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->n:I

    .line 55
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->q:I

    .line 62
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->x:Z

    .line 71
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->G:Z

    .line 243
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;-><init>(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->H:Landroid/widget/AbsListView$OnScrollListener;

    .line 75
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;DDLjava/lang/String;ILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            "Ljava/lang/String;",
            "DD",
            "Ljava/lang/String;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 96
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 46
    iput v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->h:I

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->k:Ljava/util/ArrayList;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l:Ljava/util/ArrayList;

    .line 51
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->m:Z

    .line 52
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->n:I

    .line 55
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->q:I

    .line 62
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->x:Z

    .line 71
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->G:Z

    .line 243
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;-><init>(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->H:Landroid/widget/AbsListView$OnScrollListener;

    .line 97
    iput-object p2, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->c:Ljava/lang/String;

    .line 98
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->r:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 99
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->E:Ljava/lang/String;

    .line 100
    iput-wide p3, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->y:D

    .line 101
    iput-wide p5, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->z:D

    .line 102
    iput-object p7, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->o:Ljava/lang/String;

    .line 103
    iput p8, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->A:I

    .line 104
    iput-object p9, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->B:Ljava/util/ArrayList;

    .line 105
    iput-object p10, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->C:Ljava/lang/String;

    .line 106
    iput-object p11, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->D:Ljava/lang/String;

    .line 107
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;I)I
    .locals 0

    .prologue
    .line 40
    iput p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->n:I

    return p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->m:Z

    return v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;Z)Z
    .locals 0

    .prologue
    .line 40
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->m:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->n:I

    return v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;I)I
    .locals 0

    .prologue
    .line 40
    iput p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->h:I

    return p1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->q:I

    return v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->p:I

    return v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->h:I

    return v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->o:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)D
    .locals 2

    .prologue
    .line 40
    iget-wide v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->y:D

    return-wide v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)D
    .locals 2

    .prologue
    .line 40
    iget-wide v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->z:D

    return-wide v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->c:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->r:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    return-object v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->B:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic m(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->C:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic n(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->D:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;)V
    .locals 9

    .prologue
    const v8, 0x7f0c0303

    const/16 v7, 0x8

    const/4 v3, 0x1

    const/4 v6, 0x0

    .line 192
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getTotalCount()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->p:I

    .line 193
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->G:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->p:I

    if-ne v0, v3, :cond_1

    .line 194
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;

    .line 195
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 196
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    check-cast v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v3

    .line 197
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    const-string v4, "DNMSubListContainer"

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Ljava/lang/String;)Z

    .line 198
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    invoke-virtual {v0, v1, v3}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Ljava/lang/String;)V

    .line 228
    :cond_0
    :goto_0
    return-void

    .line 201
    :cond_1
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->h:I

    if-gt v0, v3, :cond_3

    .line 202
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->G:Z

    if-eqz v0, :cond_2

    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->p:I

    if-le v0, v3, :cond_2

    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Product Availability"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 204
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->j:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->w:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->j:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 206
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->m:Z

    .line 207
    iput v6, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->n:I

    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 209
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->w:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->j:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v6}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0304

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 214
    iput v3, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->q:I

    .line 215
    new-instance v0, Lfl;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    const v2, 0x7f030035

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->k:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->f:Lnb;

    invoke-direct/range {v0 .. v5}, Lfl;-><init>(Landroid/content/Context;ILjava/util/ArrayList;Ljava/util/ArrayList;Lnb;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->i:Lfl;

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->w:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->i:Lfl;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->w:Landroid/widget/ListView;

    invoke-virtual {v0, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 223
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->w:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->H:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 224
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->p:I

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 225
    iput v6, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->q:I

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->j:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 219
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->i:Lfl;

    invoke-virtual {v0}, Lfl;->notifyDataSetChanged()V

    goto :goto_1
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 121
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 123
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 124
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->G:Z

    if-nez v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Product Availability"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 127
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeSearchBarVisibility(Z)V

    .line 128
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 110
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 111
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    .line 112
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 241
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 116
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 117
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 20

    .prologue
    .line 132
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    if-nez v2, :cond_6

    .line 133
    const v2, 0x7f030033

    const/4 v3, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v2, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    .line 134
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    const v3, 0x7f0c00de

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->w:Landroid/widget/ListView;

    .line 135
    const v2, 0x7f0300bc

    const/4 v3, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->j:Landroid/view/View;

    .line 136
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    const v3, 0x7f0c0064

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->g:Landroid/view/View;

    .line 137
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    const v3, 0x7f0c00c9

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 138
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    const v3, 0x7f0c00c8

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->t:Landroid/widget/ImageView;

    .line 139
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    const v3, 0x7f0c00dc

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RatingBar;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->u:Landroid/widget/RatingBar;

    .line 140
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    const v3, 0x7f0c00dd

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 141
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    const v3, 0x7f0c00db

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->F:Landroid/widget/RelativeLayout;

    .line 142
    new-instance v3, Lir;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->g:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->o:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->y:D

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->z:D

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->E:Ljava/lang/String;

    move-object/from16 v0, p0

    iget v15, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->h:I

    const/16 v16, 0x14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->B:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->C:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->D:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v5, p0

    invoke-direct/range {v3 .. v19}, Lir;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Lir;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 146
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->r:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    if-eqz v2, :cond_8

    .line 147
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->r:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v3

    .line 148
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 149
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->u:Landroid/widget/RatingBar;

    const/4 v4, 0x5

    invoke-virtual {v2, v4}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 150
    const/4 v2, 0x0

    .line 151
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 152
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v4

    double-to-float v2, v4

    .line 153
    :cond_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->u:Landroid/widget/RatingBar;

    invoke-virtual {v4, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 154
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v2

    .line 155
    const/4 v4, 0x1

    if-ne v2, v4, :cond_7

    .line 156
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, " "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    const v6, 0x7f0802df

    invoke-virtual {v5, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 172
    :goto_1
    const-string v2, ""

    .line 173
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 174
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 175
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 176
    :cond_1
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    const v5, 0x7f080068

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 177
    :cond_2
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_3

    .line 178
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 180
    :cond_3
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_4

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    const v5, 0x7f080068

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 181
    :cond_4
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 182
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 185
    :cond_5
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->t:Landroid/widget/ImageView;

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 188
    :goto_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    return-object v2

    .line 144
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b:Landroid/view/View;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto/16 :goto_0

    .line 158
    :cond_7
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, " "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    const v6, 0x7f0802e0

    invoke-virtual {v5, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 187
    :cond_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->F:Landroid/widget/RelativeLayout;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_2
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 9
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
    const/4 v8, 0x1

    .line 265
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 266
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v7

    .line 267
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getProductId()Ljava/lang/String;

    move-result-object v2

    iget-boolean v3, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->x:Z

    const/4 v5, 0x0

    iget v6, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->A:I

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZI)V

    .line 268
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-direct {v2, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;-><init>(Ljava/lang/String;)V

    .line 269
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    instance-of v1, v1, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;

    if-eqz v1, :cond_0

    .line 270
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;

    invoke-virtual {v1, v2, v8}, Lcom/bestbuy/android/activities/dnm/DNMSubListContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 273
    :goto_0
    invoke-virtual {v2, v0, v8}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 274
    return-void

    .line 272
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-virtual {v1, v2, v8}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 20

    .prologue
    .line 231
    invoke-super/range {p0 .. p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 232
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    check-cast v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v3, "Product Availability"

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 233
    invoke-virtual/range {p0 .. p0}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 234
    new-instance v3, Lir;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a:Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->g:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->o:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->y:D

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->z:D

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->r:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iget v15, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->h:I

    const/16 v16, 0x14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->B:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->C:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->D:Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v5, p0

    invoke-direct/range {v3 .. v19}, Lir;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Lir;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 236
    :cond_0
    return-void
.end method
