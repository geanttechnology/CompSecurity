.class public Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lkh;
.implements Lki;


# instance fields
.field private final a:Ljava/lang/String;

.field private b:Landroid/widget/FrameLayout;

.field private c:Landroid/widget/LinearLayout;

.field private g:Lhq;

.field private h:Landroid/support/v4/app/FragmentActivity;

.field private i:Landroid/widget/LinearLayout;

.field private j:Landroid/support/v4/app/Fragment;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

.field private l:Landroid/view/View;

.field private m:Landroid/widget/ImageView;

.field private n:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 422
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 410
    const-class v0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->a:Ljava/lang/String;

    .line 423
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;)I
    .locals 1

    .prologue
    .line 408
    iget v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->n:I

    return v0
.end method

.method private b(Ljava/util/List;)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 566
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 567
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    .line 568
    const/4 v0, 0x0

    move v2, v1

    move v1, v0

    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 569
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 570
    add-int/lit8 v2, v2, -0x1

    if-eq v1, v2, :cond_0

    .line 571
    const-string v0, "+"

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 568
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 574
    :cond_1
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private d()V
    .locals 3

    .prologue
    .line 452
    new-instance v0, Lhq;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->h:Landroid/support/v4/app/FragmentActivity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->b:Landroid/widget/FrameLayout;

    invoke-direct {v0, v1, p0, v2}, Lhq;-><init>(Landroid/app/Activity;Landroid/support/v4/app/Fragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->g:Lhq;

    .line 453
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->g:Lhq;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 454
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/offers/Offer;I)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 519
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 520
    const-string v1, "bb.prevPageLink"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Llu;->bi:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 521
    sget-object v1, Llu;->as:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 522
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getSkus()Ljava/util/ArrayList;

    move-result-object v0

    .line 523
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lt v1, v4, :cond_0

    .line 524
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 525
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080071

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 526
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 527
    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->b(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 528
    invoke-virtual {v1, v3}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 529
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->j:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 556
    :goto_0
    return-void

    .line 533
    :cond_0
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v4, :cond_1

    .line 539
    :try_start_0
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 540
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 541
    const-string v2, "ProductObject"

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 542
    const-string v2, "SKU"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getSku()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 543
    const-string v2, "ProductID"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getProductId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 544
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 545
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->j:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 546
    :catch_0
    move-exception v0

    .line 547
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->a:Ljava/lang/String;

    invoke-static {v1, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0

    .line 550
    :cond_1
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 551
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 552
    const-string v2, "mDotURL"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 553
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 554
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->j:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method public a(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    const/16 v7, 0x8

    const/4 v2, 0x0

    .line 470
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->i:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 471
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 473
    :cond_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 474
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->m:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 475
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->k:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->setVisibility(I)V

    .line 476
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    .line 477
    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    .line 478
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 479
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->m:Landroid/widget/ImageView;

    move v4, v2

    move-object v5, v3

    invoke-static/range {v0 .. v5}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;ZLjava/lang/Object;ILandroid/widget/RelativeLayout;)V

    .line 481
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->m:Landroid/widget/ImageView;

    new-instance v1, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard$1;

    invoke-direct {v1, p0, v6}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard$1;-><init>(Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;Lcom/bestbuy/android/api/lib/models/offers/Offer;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 496
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->b:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v7}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 497
    return-void

    .line 490
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->k:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->h:Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0, v1, p1, v3}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a(Landroid/content/Context;Ljava/util/List;Landroid/widget/ScrollView;)V

    .line 491
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->k:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->setPromoPagerListener(Lkh;)V

    .line 492
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->k:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->setShowPullDownListener(Lki;)V

    .line 493
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->m:Landroid/widget/ImageView;

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 494
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->k:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->setVisibility(I)V

    goto :goto_0
.end method

.method public b()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 504
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->i:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 505
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->i:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 506
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->b:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 509
    :cond_0
    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 580
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->j:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->g()V

    .line 581
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 442
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 443
    check-cast p1, Landroid/support/v4/app/FragmentActivity;

    iput-object p1, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->h:Landroid/support/v4/app/FragmentActivity;

    .line 444
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->j:Landroid/support/v4/app/Fragment;

    .line 445
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 427
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_1

    .line 428
    :cond_0
    const v0, 0x7f030043

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    .line 429
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->b:Landroid/widget/FrameLayout;

    .line 430
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    const v1, 0x7f0c010a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->c:Landroid/widget/LinearLayout;

    .line 431
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->c:Landroid/widget/LinearLayout;

    const v1, 0x7f0c010b

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->k:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    .line 432
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    const v1, 0x7f0c010c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->m:Landroid/widget/ImageView;

    .line 433
    check-cast p2, Landroid/widget/LinearLayout;

    iput-object p2, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->i:Landroid/widget/LinearLayout;

    .line 434
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->d()V

    .line 437
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    return-object v0

    .line 436
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 457
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 458
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 459
    invoke-direct {p0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->d()V

    .line 461
    :cond_0
    return-void
.end method
