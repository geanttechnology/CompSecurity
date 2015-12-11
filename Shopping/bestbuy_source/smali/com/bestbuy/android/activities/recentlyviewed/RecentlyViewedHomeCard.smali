.class public Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field private a:Landroid/widget/LinearLayout;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Lhk;

.field private i:Lhe;

.field private j:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private k:Landroid/widget/LinearLayout;

.field private l:Landroid/widget/ListView;

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private n:Lds;

.field private o:Landroid/widget/LinearLayout;

.field private p:Landroid/widget/RelativeLayout;

.field private q:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private r:Ldy;

.field private s:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

.field private t:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private u:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b:Ljava/util/ArrayList;

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->m:Ljava/util/ArrayList;

    .line 66
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->q:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;Lhe;)Lhe;
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->i:Lhe;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->m:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;)V

    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b:Ljava/util/ArrayList;

    return-object v0
.end method

.method private b(Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;)V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 348
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 349
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getRelatedSkus()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    move v1, v2

    .line 355
    :goto_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getRelatedSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 357
    new-instance v4, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;-><init>()V

    .line 358
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getRelatedSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;->getEp()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setEp(Ljava/lang/String;)V

    .line 360
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getRelatedSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 362
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getRelatedSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSkuId(Ljava/lang/String;)V

    .line 364
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getRelatedSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RelatedSkus;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V

    .line 366
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 356
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_0

    .line 368
    :cond_0
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Ljava/util/ArrayList;)V

    .line 370
    :cond_1
    return-void
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->k:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method private c(Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    const/4 v0, 0x3

    .line 240
    .line 241
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v1, v0, :cond_2

    .line 242
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    move v1, v0

    .line 244
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 245
    const/4 v0, 0x0

    move v2, v0

    :goto_1
    if-ge v2, v1, :cond_1

    .line 246
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 247
    add-int/lit8 v0, v1, -0x1

    if-eq v2, v0, :cond_0

    .line 248
    const/16 v0, 0x2c

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 245
    :cond_0
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    .line 251
    :cond_1
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_2
    move v1, v0

    goto :goto_0
.end method

.method private d(Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 255
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 256
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 257
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 258
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 259
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-eq v1, v0, :cond_0

    .line 260
    const/16 v0, 0x2c

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 257
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 264
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Ljava/util/List;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->t:Ljava/util/List;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->p:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lhe;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->i:Lhe;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->q:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->u:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)Landroid/view/View;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->g:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;)V
    .locals 5

    .prologue
    .line 317
    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->u:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    .line 319
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 320
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 321
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 323
    new-instance v4, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;-><init>()V

    .line 324
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getEp()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setEp(Ljava/lang/String;)V

    .line 326
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 328
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSkuId(Ljava/lang/String;)V

    .line 330
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V

    .line 332
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedSku;->getRelatedUrl()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 334
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 322
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_0

    .line 338
    :cond_0
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Ljava/util/List;)V

    .line 339
    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Ljava/util/ArrayList;)V

    .line 342
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;)V

    .line 344
    return-void
.end method

.method public a(Lgu;)V
    .locals 0

    .prologue
    .line 307
    check-cast p1, Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->s:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    .line 308
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 8
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
    const/16 v7, 0x8

    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 179
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 180
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 181
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 182
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v3

    if-nez v3, :cond_0

    .line 183
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    .line 185
    :cond_1
    invoke-virtual {p1}, Ljava/util/ArrayList;->clear()V

    .line 186
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 187
    if-eqz p1, :cond_2

    if-eqz p1, :cond_5

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 188
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b()V

    .line 213
    :cond_3
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->c:Landroid/view/View;

    if-eqz v0, :cond_4

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->c:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 215
    :cond_4
    return-void

    .line 192
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 194
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b:Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v3

    const-string v5, "recentlyviewed"

    invoke-direct/range {v0 .. v5}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->r:Ldy;

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->j:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->r:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->j:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->a(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->startAnimation(Landroid/view/animation/Animation;)V

    .line 197
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v4, :cond_6

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->j:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 199
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 200
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 201
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 202
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l:Landroid/widget/ListView;

    invoke-virtual {v1, v7}, Landroid/widget/ListView;->setVisibility(I)V

    .line 203
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->q:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    if-eqz v1, :cond_7

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "homeloadrecentlyviewed"

    const-string v2, "GHP"

    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->q:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto :goto_1

    .line 206
    :cond_7
    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "homeloadrecentlyviewed"

    const-string v3, "GHP"

    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto/16 :goto_1
.end method

.method public a(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 311
    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->t:Ljava/util/List;

    .line 313
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 175
    :cond_0
    return-void
.end method

.method public b(Ljava/util/ArrayList;)V
    .locals 5
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
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 218
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->p:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 222
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 223
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 224
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->n:Lds;

    invoke-virtual {v0}, Lds;->notifyDataSetChanged()V

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->q:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    if-eqz v0, :cond_0

    .line 227
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "homeloadalsoviewed"

    const-string v2, "GHP"

    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->c(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->q:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 237
    :goto_0
    return-void

    .line 229
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "homeloadalsoviewed"

    const-string v3, "GHP"

    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->c(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v2, v3, v4, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto :goto_0

    .line 233
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->p:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 234
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l:Landroid/widget/ListView;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 151
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 152
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    .line 76
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->o:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 294
    new-instance v8, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 295
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "RecenltyViewed"

    const-string v3, "Recenlty Viewed"

    const-string v4, "all"

    const/4 v5, 0x0

    const-string v6, "Home"

    const/16 v7, 0xa

    invoke-direct/range {v0 .. v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 296
    iget-object v2, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    check-cast v2, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    const v3, 0x7f0c0033

    invoke-virtual {v2, v3}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 297
    instance-of v3, v2, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v3, :cond_0

    .line 298
    check-cast v2, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 299
    invoke-virtual {v2}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 300
    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v8, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 301
    invoke-virtual {v8, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 304
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 69
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 70
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 80
    const v0, 0x7f030052

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0073

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->o:Landroid/widget/LinearLayout;

    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->c:Landroid/view/View;

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    const v1, 0x7f0c012c

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->g:Landroid/view/View;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->j:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    const v1, 0x7f0c012b

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->k:Landroid/widget/LinearLayout;

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    const v1, 0x7f0c00b9

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->p:Landroid/widget/RelativeLayout;

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    const v1, 0x7f0c012d

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l:Landroid/widget/ListView;

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->o:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$1;-><init>(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$2;-><init>(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->j:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    new-instance v1, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$3;-><init>(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 141
    new-instance v0, Lds;

    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->m:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2}, Lds;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->n:Lds;

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->n:Lds;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 143
    new-instance v0, Lhk;

    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->c:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->s:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    invoke-direct {v0, v1, p0, v2, v3}, Lhk;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->h:Lhk;

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->h:Lhk;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhk;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 0
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
    .line 289
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 167
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 168
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 155
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 156
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 157
    new-instance v0, Lhk;

    iget-object v1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->c:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->s:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    invoke-direct {v0, v1, p0, v2, v3}, Lhk;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->h:Lhk;

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->h:Lhk;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhk;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 161
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->r:Ldy;

    if-eqz v0, :cond_1

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->r:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 164
    :cond_1
    return-void
.end method
