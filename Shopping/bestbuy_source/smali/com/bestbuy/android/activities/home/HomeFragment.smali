.class public Lcom/bestbuy/android/activities/home/HomeFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private final a:Ljava/lang/String;

.field private b:Lck;

.field private c:Lmy;

.field private g:Landroid/view/View;

.field private h:Landroid/widget/ScrollView;

.field private i:Landroid/widget/LinearLayout;

.field private j:Landroid/app/Activity;

.field private k:Landroid/view/View;

.field private l:Landroid/view/View;

.field private m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private n:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private o:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private p:Z

.field private q:Ljava/lang/String;

.field private r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

.field private s:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

.field private t:Z

.field private u:Landroid/widget/ImageView;

.field private v:Landroid/view/View$OnClickListener;

.field private w:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 58
    const-string v0, "HomeFragment.java"

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->a:Ljava/lang/String;

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->c:Lmy;

    .line 71
    const-string v0, "market://details?id=com.bestbuy.android"

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->q:Ljava/lang/String;

    .line 157
    new-instance v0, Lcom/bestbuy/android/activities/home/HomeFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/home/HomeFragment$1;-><init>(Lcom/bestbuy/android/activities/home/HomeFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->v:Landroid/view/View$OnClickListener;

    .line 174
    new-instance v0, Lcom/bestbuy/android/activities/home/HomeFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/home/HomeFragment$2;-><init>(Lcom/bestbuy/android/activities/home/HomeFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->w:Landroid/view/View$OnClickListener;

    .line 78
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    return-object v0
.end method

.method private a(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/home/Recommendation;
    .locals 2

    .prologue
    .line 444
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;->getRecommendations()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 445
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;->getRecommendations()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 446
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;->getRecommendations()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->getRecommendationsType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 447
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;->getRecommendations()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    .line 451
    :goto_1
    return-object v0

    .line 445
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 451
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private a(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 253
    new-instance v0, Lit;

    invoke-direct {v0, p1, p0}, Lit;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lit;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 254
    return-void
.end method

.method private a(Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V
    .locals 5

    .prologue
    const/16 v3, 0xdf

    .line 428
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 429
    const-string v1, "LAYOUT_ID"

    invoke-virtual {p1}, Landroid/widget/LinearLayout;->getId()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 430
    invoke-virtual {p2, v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->setArguments(Landroid/os/Bundle;)V

    .line 431
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeFragment$5;

    invoke-direct {v1, p0, p1, p2}, Lcom/bestbuy/android/activities/home/HomeFragment$5;-><init>(Lcom/bestbuy/android/activities/home/HomeFragment;Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 436
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 437
    new-instance v0, Landroid/view/View;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 438
    invoke-static {v3, v3, v3}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 439
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    const/4 v3, -0x1

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 441
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/HomeFragment;Z)V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Z)V

    return-void
.end method

.method private a(Lmy;)V
    .locals 10

    .prologue
    const/4 v5, -0x2

    const/4 v3, 0x0

    .line 353
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->h:Landroid/widget/ScrollView;

    invoke-virtual {v0}, Landroid/widget/ScrollView;->removeAllViews()V

    .line 354
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 355
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->h:Landroid/widget/ScrollView;

    invoke-virtual {v0, v3}, Landroid/widget/ScrollView;->setVerticalScrollBarEnabled(Z)V

    .line 356
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->h:Landroid/widget/ScrollView;

    invoke-virtual {v0, v3}, Landroid/widget/ScrollView;->setHorizontalScrollBarEnabled(Z)V

    .line 357
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    move-result-object v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;

    move-result-object v0

    if-eqz v0, :cond_a

    .line 361
    if-eqz p1, :cond_9

    invoke-virtual {p1}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_9

    move v2, v3

    .line 362
    :goto_0
    invoke-virtual {p1}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_8

    .line 364
    invoke-virtual {p1}, Lmy;->a()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmx;

    .line 365
    invoke-virtual {v0}, Lmx;->b()Ljava/util/ArrayList;

    move-result-object v0

    .line 366
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move v1, v3

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmw;

    .line 368
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v4

    invoke-virtual {v0}, Lmw;->g()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v8

    double-to-int v6, v8

    invoke-virtual {v4, v6}, Lnb;->a(I)F

    move-result v4

    float-to-int v6, v4

    .line 369
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v4

    invoke-virtual {v0}, Lmw;->h()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v8

    double-to-int v8, v8

    invoke-virtual {v4, v8}, Lnb;->b(I)F

    move-result v4

    float-to-int v4, v4

    .line 370
    new-instance v8, Landroid/widget/LinearLayout;

    iget-object v9, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-direct {v8, v9}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 371
    if-nez v6, :cond_0

    move v6, v5

    .line 374
    :cond_0
    if-nez v4, :cond_1

    move v4, v5

    .line 378
    :cond_1
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v9, v6, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 379
    invoke-virtual {v8, v9}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 380
    add-int/lit8 v4, v1, 0x1

    invoke-virtual {v8, v4}, Landroid/widget/LinearLayout;->setId(I)V

    .line 381
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v8, v1}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    .line 382
    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lkb;->a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v1

    .line 383
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    if-eqz v0, :cond_3

    .line 388
    invoke-direct {p0, v8, v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    :cond_2
    :goto_2
    move v1, v4

    .line 409
    goto :goto_1

    .line 389
    :cond_3
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/DODHomeCard;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;->getDealsOfTheDay()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 390
    new-instance v6, Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;

    invoke-direct {v6}, Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;-><init>()V

    .line 391
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponseData;->getResponse()Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/HomeScreenData;->getDealsOfTheDay()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/bestbuy/android/api/lib/models/home/DealsOfTheDay;->setDealsOfTheDay(Ljava/util/List;)V

    move-object v0, v1

    .line 392
    check-cast v0, Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/activities/home/DODHomeCard;->a(Lgu;)V

    .line 393
    invoke-direct {p0, v8, v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    goto :goto_2

    .line 394
    :cond_4
    instance-of v0, v1, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_5

    .line 395
    const-string v0, "recentlyViewedAlsoViewed"

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    move-result-object v6

    .line 396
    if-eqz v6, :cond_2

    move-object v0, v1

    .line 397
    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Lgu;)V

    .line 398
    invoke-direct {p0, v8, v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    goto :goto_2

    .line 400
    :cond_5
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;

    if-eqz v0, :cond_6

    .line 401
    const-string v0, "trendingMostPopular"

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    move-result-object v6

    .line 402
    if-eqz v6, :cond_2

    move-object v0, v1

    .line 403
    check-cast v0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->a(Lgu;)V

    .line 404
    invoke-direct {p0, v8, v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    goto :goto_2

    .line 407
    :cond_6
    invoke-direct {p0, v8, v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    goto :goto_2

    .line 362
    :cond_7
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto/16 :goto_0

    .line 411
    :cond_8
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->p:Z

    if-eqz v0, :cond_9

    .line 412
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08018a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 413
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYButton;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08027b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setText(Ljava/lang/CharSequence;)V

    .line 414
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->o:Lcom/bestbuy/android/bbyobjects/BBYButton;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080392

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setText(Ljava/lang/CharSequence;)V

    .line 415
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->k:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 418
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->h:Landroid/widget/ScrollView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V

    .line 420
    :cond_a
    return-void
.end method

.method private a(Z)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    const-string v1, "sharedPrefs"

    invoke-virtual {v0, v1, v3}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 152
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "ratingReminder"

    invoke-interface {v1, v2, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 153
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "launchCount"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 154
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->p:Z

    .line 155
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYButton;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->o:Lcom/bestbuy/android/bbyobjects/BBYButton;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->k:Landroid/view/View;

    return-object v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->s:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    return-object v0
.end method

.method private h()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    const-string v1, "sharedPrefs"

    invoke-virtual {v0, v1, v6}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 128
    const-string v1, "ratingReminder"

    invoke-interface {v0, v1, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 129
    const-string v2, "launchCount"

    invoke-interface {v0, v2, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 130
    const-string v3, "appVersion"

    const/4 v4, 0x0

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 131
    iget-object v4, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->f:Lnb;

    invoke-virtual {v4}, Lnb;->l()Ljava/lang/String;

    move-result-object v4

    .line 132
    if-eqz v3, :cond_0

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 133
    :cond_0
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "appVersion"

    invoke-interface {v1, v2, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 134
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "launchCount"

    invoke-interface {v1, v2, v5}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 135
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "ratingReminder"

    invoke-interface {v0, v1, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 136
    iput-boolean v5, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->p:Z

    .line 148
    :cond_1
    :goto_0
    return-void

    .line 139
    :cond_2
    if-eqz v1, :cond_3

    .line 140
    add-int/lit8 v1, v2, 0x1

    .line 141
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v2, "launchCount"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 142
    const/16 v0, 0xa

    if-le v1, v0, :cond_1

    .line 143
    iput-boolean v5, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->p:Z

    goto :goto_0

    .line 146
    :cond_3
    iput-boolean v6, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->p:Z

    goto :goto_0
.end method

.method private i()V
    .locals 2

    .prologue
    .line 474
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 475
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->q:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 476
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 477
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 206
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SENDTO"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 207
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "mailto:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "?subject="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p2}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&body="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p3}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 208
    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 209
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 210
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v1, v0, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 211
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 222
    :goto_0
    return-object v0

    .line 216
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 217
    const-string v1, "message/rfc822"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 218
    const-string v1, "android.intent.extra.EMAIL"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    aput-object p1, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 219
    const-string v1, "android.intent.extra.SUBJECT"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 220
    const-string v1, "android.intent.extra.TEXT"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 222
    const-string v1, "Choose an Email client :"

    invoke-static {v0, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    goto :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;)V
    .locals 0

    .prologue
    .line 480
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->r:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    .line 481
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->d()V

    .line 482
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 306
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->s:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 307
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 310
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->s:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 311
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 324
    :try_start_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "Hometiles"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 325
    new-instance v1, Lmy;

    const-string v2, "Hometiles"

    invoke-direct {v1, v0, v2}, Lmy;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->c:Lmy;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 329
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->c:Lmy;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lmy;)V

    .line 333
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Lfq;->a(J)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 334
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeFragment$4;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeFragment$4;-><init>(Lcom/bestbuy/android/activities/home/HomeFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 349
    :cond_0
    return-void

    .line 326
    :catch_0
    move-exception v0

    .line 327
    const-string v1, "HomeFragment.java"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not create all UISections: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public e()V
    .locals 7

    .prologue
    const v6, 0x7f0c03f0

    const/high16 v5, 0x40000000    # 2.0f

    .line 455
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v0, -0x1

    const/4 v2, -0x2

    invoke-direct {v1, v0, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 456
    const/16 v0, 0xc

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 457
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-static {v5, v0}, Lnf;->b(FLandroid/content/Context;)I

    move-result v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-static {v5, v2}, Lnf;->b(FLandroid/content/Context;)I

    move-result v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-static {v5, v3}, Lnf;->b(FLandroid/content/Context;)I

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-static {v5, v4}, Lnf;->b(FLandroid/content/Context;)I

    move-result v4

    invoke-virtual {v1, v0, v2, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 458
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    invoke-virtual {v0, v2, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 459
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    const v1, 0x7f0c024f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 460
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    const v2, 0x7f0c0067

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 461
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    invoke-virtual {v2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 463
    invoke-virtual {v1, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 464
    invoke-virtual {v2, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 465
    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 467
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 468
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 469
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->bringToFront()V

    .line 470
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080269

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 471
    return-void
.end method

.method public f()V
    .locals 3

    .prologue
    .line 485
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    .line 486
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 487
    if-eqz v0, :cond_0

    .line 488
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    if-nez v2, :cond_1

    instance-of v2, v0, Lcom/bestbuy/android/activities/home/DODHomeCard;

    if-nez v2, :cond_1

    instance-of v2, v0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;

    if-nez v2, :cond_1

    instance-of v2, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v2, :cond_0

    .line 489
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    .line 490
    invoke-virtual {v2, v0}, Landroid/support/v4/app/FragmentTransaction;->detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 491
    invoke-virtual {v2, v0}, Landroid/support/v4/app/FragmentTransaction;->attach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 492
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    goto :goto_0

    .line 496
    :cond_2
    return-void
.end method

.method public g()V
    .locals 2

    .prologue
    .line 516
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->u:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 517
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->u:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 519
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 232
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 233
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 5

    .prologue
    .line 237
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 238
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    .line 239
    const/4 v0, 0x0

    :goto_0
    sget-object v1, Lnb;->d:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 240
    new-instance v2, Lnc;

    invoke-direct {v2}, Lnc;-><init>()V

    .line 241
    const/4 v1, 0x0

    .line 243
    :try_start_0
    sget-object v3, Lnb;->e:Ljava/lang/String;

    sget-object v4, Lnb;->d:[Ljava/lang/String;

    aget-object v4, v4, v0

    invoke-virtual {v2, p1, v3, v4}, Lnc;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 247
    :goto_1
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v2

    invoke-virtual {v2}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    sget-object v3, Lnb;->d:[Ljava/lang/String;

    aget-object v3, v3, v0

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 239
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 244
    :catch_0
    move-exception v2

    .line 245
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 249
    :cond_0
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Landroid/app/Activity;)V

    .line 250
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 500
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 513
    :cond_0
    :goto_0
    return-void

    .line 503
    :sswitch_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->i()V

    goto :goto_0

    .line 506
    :sswitch_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 500
    :sswitch_data_0
    .sparse-switch
        0x7f0c0067 -> :sswitch_1
        0x7f0c024f -> :sswitch_0
        0x7f0c03f0 -> :sswitch_0
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 82
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 83
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->f:Lnb;

    .line 84
    new-instance v0, Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->i:Landroid/widget/LinearLayout;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, -0x2

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 87
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->h()V

    .line 88
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const v4, 0x7f0b0063

    const/high16 v2, 0x7f0b0000

    const/4 v3, 0x0

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    if-nez v0, :cond_1

    .line 93
    const v0, 0x7f030050

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    .line 94
    const v0, 0x7f0300dd

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->k:Landroid/view/View;

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0120

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->h:Landroid/widget/ScrollView;

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->k:Landroid/view/View;

    const v1, 0x7f0c035d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->k:Landroid/view/View;

    const v1, 0x7f0c035e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->k:Landroid/view/View;

    const v1, 0x7f0c035f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->o:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYButton;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->v:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->o:Lcom/bestbuy/android/bbyobjects/BBYButton;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->w:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    const v1, 0x7f0c006d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->u:Landroid/widget/ImageView;

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    const v1, 0x7f0c006e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->s:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->s:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, v2, v4, v2, v4}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setColorScheme(IIII)V

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->s:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 105
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->t:Z

    .line 106
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->t:Z

    if-nez v0, :cond_0

    .line 107
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->b()V

    .line 112
    :goto_0
    const v0, 0x7f030110

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->l:Landroid/view/View;

    .line 117
    new-instance v0, Lis;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p0, v2}, Lis;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 118
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lis;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 123
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    return-object v0

    .line 109
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->c()V

    goto :goto_0

    .line 121
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_1
.end method

.method public onDetach()V
    .locals 1

    .prologue
    .line 282
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDetach()V

    .line 283
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->b:Lck;

    .line 284
    return-void
.end method

.method public onRefresh()V
    .locals 4

    .prologue
    .line 288
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->c()V

    .line 289
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/home/HomeFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/home/HomeFragment$3;-><init>(Lcom/bestbuy/android/activities/home/HomeFragment;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 303
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 257
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 258
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->t:Z

    .line 259
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->t:Z

    if-nez v0, :cond_2

    .line 260
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->b()V

    .line 265
    :goto_0
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Home"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 266
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment;->j:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 271
    :goto_1
    invoke-static {}, Lfr;->j()Ljava/lang/String;

    move-result-object v0

    .line 272
    sget-boolean v1, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a:Z

    if-eqz v1, :cond_1

    .line 273
    if-eqz v0, :cond_0

    const-string v1, "10130"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 274
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->f()V

    .line 276
    :cond_0
    const/4 v0, 0x0

    sput-boolean v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a:Z

    .line 278
    :cond_1
    return-void

    .line 262
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeFragment;->c()V

    goto :goto_0

    .line 267
    :catch_0
    move-exception v0

    .line 268
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method
