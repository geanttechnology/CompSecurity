.class public Lhk;
.super Lka;
.source "SourceFile"


# static fields
.field private static a:I


# instance fields
.field private j:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

.field private k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    sput v0, Lhk;->a:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    iput-object p3, p0, Lhk;->g:Landroid/view/View;

    .line 26
    iput-object p4, p0, Lhk;->j:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    .line 27
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 18
    sput p0, Lhk;->a:I

    return p0
.end method

.method static synthetic a(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic b(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic c(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic d(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic e(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 39
    iget-object v0, p0, Lhk;->f:Landroid/app/Activity;

    iget-object v1, p0, Lhk;->j:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    invoke-static {v0, v1}, Lfs;->a(Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    move-result-object v0

    iput-object v0, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    .line 40
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 72
    const/4 v0, 0x0

    sput v0, Lhk;->a:I

    .line 73
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_1

    .line 74
    iget-object v0, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewed;->getRecommendations()Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedRecommendations;->getSkus()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 78
    :cond_0
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 79
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b()V

    .line 88
    :cond_1
    :goto_0
    return-void

    .line 82
    :cond_2
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 83
    iget-object v0, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v1, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;)V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 50
    iget-object v0, p0, Lhk;->f:Landroid/app/Activity;

    new-instance v1, Lhk$1;

    invoke-direct {v1, p0}, Lhk$1;-><init>(Lhk;)V

    new-instance v2, Lhk$2;

    invoke-direct {v2, p0}, Lhk$2;-><init>(Lhk;)V

    iget-boolean v3, p0, Lhk;->e:Z

    sget v4, Lhk;->a:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 68
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 44
    sget v0, Lhk;->a:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhk;->a:I

    .line 45
    new-instance v0, Lhk;

    iget-object v1, p0, Lhk;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhk;->g:Landroid/view/View;

    iget-object v4, p0, Lhk;->j:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    invoke-direct {v0, v1, v2, v3, v4}, Lhk;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhk;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 46
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 31
    iget-object v0, p0, Lhk;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Lhk;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 34
    :cond_0
    new-instance v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;-><init>()V

    iput-object v0, p0, Lhk;->k:Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    .line 35
    return-void
.end method
