.class public Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.super Landroid/support/v4/app/FragmentActivity;
.source "SourceFile"


# static fields
.field public static GC_SCAN_SUCCESS:I

.field public static MANUAL_ENTER:I

.field public static PRODUCT_SCAN:I

.field public static final REQUEST:Lcom/google/android/gms/location/LocationRequest;

.field private static TAG:Ljava/lang/String;

.field public static baseFragmentActivity:Lcom/bestbuy/android/base/BBYBaseFragmentActivity;


# instance fields
.field private BACKGROUND:Ljava/lang/String;

.field private FOREGROUND:Ljava/lang/String;

.field public appData:Lnb;

.field private isActionBarHidden:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/16 v1, 0x64

    .line 53
    const-class v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->TAG:Ljava/lang/String;

    .line 54
    sput v1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->MANUAL_ENTER:I

    .line 55
    const/16 v0, 0xc8

    sput v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->GC_SCAN_SUCCESS:I

    .line 56
    const/16 v0, 0x12c

    sput v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->PRODUCT_SCAN:I

    .line 64
    invoke-static {}, Lcom/google/android/gms/location/LocationRequest;->a()Lcom/google/android/gms/location/LocationRequest;

    move-result-object v0

    const-wide/16 v2, 0x2710

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/location/LocationRequest;->a(J)Lcom/google/android/gms/location/LocationRequest;

    move-result-object v0

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/location/LocationRequest;->b(J)Lcom/google/android/gms/location/LocationRequest;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/google/android/gms/location/LocationRequest;->a(I)Lcom/google/android/gms/location/LocationRequest;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 57
    const-string v0, "Background"

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->BACKGROUND:Ljava/lang/String;

    .line 58
    const-string v0, "Foreground"

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->FOREGROUND:Ljava/lang/String;

    .line 61
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->isActionBarHidden:Z

    return-void
.end method

.method private enableAfterCheck(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;)V
    .locals 2

    .prologue
    .line 549
    instance-of v0, p2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, p2

    .line 550
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 551
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v1, :cond_0

    .line 552
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b()V

    .line 554
    :cond_0
    instance-of v0, p2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_2

    .line 555
    check-cast p2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 556
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v1, :cond_1

    .line 557
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->h()V

    .line 565
    :cond_1
    :goto_0
    return-void

    .line 558
    :cond_2
    instance-of v0, p2, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    if-eqz v0, :cond_3

    .line 559
    check-cast p2, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-virtual {p2}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->c()V

    goto :goto_0

    .line 560
    :cond_3
    instance-of v0, p2, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    if-eqz v0, :cond_4

    .line 561
    check-cast p2, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {p2}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c()V

    goto :goto_0

    .line 562
    :cond_4
    instance-of v0, p2, Lcom/bestbuy/android/activities/home/HomeFragment;

    if-eqz v0, :cond_1

    .line 563
    check-cast p2, Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {p2}, Lcom/bestbuy/android/activities/home/HomeFragment;->b()V

    goto :goto_0
.end method


# virtual methods
.method public changeActionBarAddToVisibility(Landroid/app/Activity;Z)V
    .locals 1

    .prologue
    .line 472
    instance-of v0, p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_0

    .line 473
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, p2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setAddToVisible(Z)V

    .line 474
    :cond_0
    return-void
.end method

.method public changeActionBarClearVisibility(Landroid/app/Activity;Z)V
    .locals 0

    .prologue
    .line 477
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, p2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setClearVisible(Z)V

    .line 478
    return-void
.end method

.method public changeActionBarSearchAndQueryVisibility(Landroid/app/Activity;ZLjava/lang/String;)V
    .locals 0

    .prologue
    .line 468
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, p2, p3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setSearchAndQueryVisible(ZLjava/lang/String;)V

    .line 469
    return-void
.end method

.method public changeActionBarSearchVisibility(Landroid/app/Activity;Z)V
    .locals 0

    .prologue
    .line 464
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, p2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setSearchVisible(Z)V

    .line 465
    return-void
.end method

.method public changeActionBarShareVisibility(Landroid/app/Activity;Z)V
    .locals 0

    .prologue
    .line 460
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, p2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setShareVisible(Z)V

    .line 461
    return-void
.end method

.method public disablePullDown()V
    .locals 2

    .prologue
    .line 533
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 534
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_0

    .line 535
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 536
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    if-nez v1, :cond_0

    .line 537
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "HOME"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 538
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v1, :cond_0

    .line 539
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 540
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    if-eqz v1, :cond_0

    .line 541
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->c()V

    .line 546
    :cond_0
    return-void
.end method

.method public getCurrentActionBarTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 452
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 453
    if-eqz v0, :cond_0

    .line 454
    const v1, 0x7f0c0059

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 456
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hideActionBarHome()V
    .locals 5

    .prologue
    const v4, 0x7f0c0059

    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 361
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 362
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 363
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 364
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 365
    if-eqz v0, :cond_0

    .line 366
    iput-boolean v1, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->isActionBarHidden:Z

    .line 367
    const v1, 0x7f0c0058

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 368
    check-cast p0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeSearchBarVisibility(Z)V

    .line 369
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x1e

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 370
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 372
    :cond_0
    return-void
.end method

.method public hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V
    .locals 5

    .prologue
    const v4, 0x7f0c0059

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 394
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 395
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 396
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 397
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 398
    if-eqz v0, :cond_0

    .line 399
    iput-boolean v2, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->isActionBarHidden:Z

    .line 400
    const v1, 0x7f0c0058

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 401
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeSearchBarVisibility(Z)V

    .line 402
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x1e

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 403
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 405
    :cond_0
    return-void
.end method

.method public hideStoresSearchActionBar(Landroid/app/Activity;)V
    .locals 5

    .prologue
    const v4, 0x7f0c0059

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 408
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 409
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 410
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 411
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 412
    if-eqz v0, :cond_0

    .line 413
    iput-boolean v2, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->isActionBarHidden:Z

    .line 414
    const v1, 0x7f0c0058

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 415
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeStoresSearchVisibility(Z)V

    .line 416
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x1e

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 417
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 419
    :cond_0
    return-void
.end method

.method public isActionBarHidden()Z
    .locals 1

    .prologue
    .line 422
    iget-boolean v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->isActionBarHidden:Z

    return v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 8

    .prologue
    const/4 v2, 0x2

    const v7, 0x7f0c0033

    const/4 v6, 0x1

    .line 147
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/app/FragmentActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 148
    const/16 v0, 0x115c

    if-ne p1, v0, :cond_0

    .line 149
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 151
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_0

    .line 152
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 153
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    if-ne v1, v2, :cond_2

    .line 154
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "STORES"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 155
    instance-of v1, v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v1, :cond_0

    .line 156
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 157
    instance-of v1, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    if-eqz v1, :cond_0

    .line 158
    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 159
    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 174
    :cond_0
    :goto_0
    const/16 v0, 0x3e8

    if-ne p1, v0, :cond_3

    .line 175
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 176
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_1

    .line 177
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 178
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    if-ne v1, v2, :cond_1

    .line 179
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "STORES"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 180
    instance-of v1, v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v1, :cond_1

    .line 181
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 182
    instance-of v1, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v1, :cond_1

    .line 183
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 328
    :cond_1
    :goto_1
    return-void

    .line 162
    :cond_2
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    if-nez v1, :cond_0

    .line 163
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "HOME"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 164
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v1, :cond_0

    .line 165
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 166
    instance-of v1, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    if-eqz v1, :cond_0

    .line 167
    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 168
    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0

    .line 188
    :cond_3
    const/16 v0, 0x270f

    if-eq p1, v0, :cond_4

    const/16 v0, 0x1388

    if-ne p1, v0, :cond_8

    .line 189
    :cond_4
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 190
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_7

    .line 191
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 192
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    if-ne v1, v6, :cond_5

    .line 193
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "PRODUCTS"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 194
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v1, :cond_1

    .line 195
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 196
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-eqz v1, :cond_1

    .line 197
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 198
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v1, :cond_1

    .line 199
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_1

    .line 202
    :cond_5
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    if-nez v1, :cond_1

    .line 203
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "HOME"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 204
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v1, :cond_1

    .line 205
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 206
    instance-of v1, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    if-eqz v1, :cond_6

    .line 207
    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 208
    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto/16 :goto_1

    .line 209
    :cond_6
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-eqz v1, :cond_1

    .line 210
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 211
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v1, :cond_1

    .line 212
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto/16 :goto_1

    .line 216
    :cond_7
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-eqz v1, :cond_1

    .line 217
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 218
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v1, :cond_1

    .line 219
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto/16 :goto_1

    .line 221
    :cond_8
    const/16 v0, 0xd05

    if-ne p1, v0, :cond_a

    .line 222
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 223
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_1

    .line 224
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 225
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    if-nez v1, :cond_9

    .line 226
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "HOME"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 227
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v1, :cond_1

    .line 228
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 229
    instance-of v1, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    if-eqz v1, :cond_1

    .line 230
    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 231
    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto/16 :goto_1

    .line 234
    :cond_9
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    if-ne v1, v2, :cond_1

    .line 235
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "STORES"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 236
    instance-of v1, v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v1, :cond_1

    .line 237
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 238
    instance-of v1, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v1, :cond_1

    .line 239
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->onActivityResult(IILandroid/content/Intent;)V

    goto/16 :goto_1

    .line 244
    :cond_a
    const/16 v0, 0x457

    if-ne p1, v0, :cond_b

    .line 245
    check-cast p0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    goto/16 :goto_1

    .line 247
    :cond_b
    const/16 v0, 0x1ed2

    if-ne p1, v0, :cond_13

    .line 248
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ACTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    move-object v0, p0

    .line 249
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 252
    new-instance v2, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    const/4 v1, 0x0

    invoke-direct {v2, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 253
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v3, "ACTION"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    const-string v3, "CREATE_ACCOUNT"

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 254
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 255
    const-string v3, "mDotURL"

    check-cast p0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f08014e

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 266
    :cond_c
    :goto_2
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_12

    .line 267
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 268
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 269
    if-eqz v1, :cond_1

    .line 270
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_d

    move-object v0, v1

    .line 271
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v0, v2, v6}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 273
    :cond_d
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v0, :cond_e

    move-object v0, v1

    .line 274
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    invoke-virtual {v0, v2, v6}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 276
    :cond_e
    instance-of v0, v1, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v0, :cond_f

    move-object v0, v1

    .line 277
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    invoke-virtual {v0, v2, v6}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 279
    :cond_f
    instance-of v0, v1, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    if-eqz v0, :cond_1

    .line 280
    check-cast v1, Lcom/bestbuy/android/activities/cart/CartTabContainer;

    invoke-virtual {v1, v2, v6}, Lcom/bestbuy/android/activities/cart/CartTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1

    .line 257
    :cond_10
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v3, "ACTION"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    const-string v3, "FORGOT_PWD"

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 258
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 259
    const-string v3, "mDotURL"

    iget-object v4, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    invoke-virtual {v4}, Lnb;->k()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    goto :goto_2

    .line 261
    :cond_11
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v3, "ACTION"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    const-string v3, "TERMS_OF_USE"

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 262
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 263
    const-string v3, "mDotURL"

    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f08012f

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    goto/16 :goto_2

    .line 283
    :cond_12
    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v1, :cond_1

    .line 284
    check-cast v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    invoke-virtual {v0, v2, v6}, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1

    .line 287
    :cond_13
    const/16 v0, 0xd80

    if-ne p1, v0, :cond_1a

    .line 288
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ACTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 289
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ACTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "BROWSE_PRODUCTS"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    move-object v0, p0

    .line 291
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 292
    const-string v0, "EmptyWeddingRegistryContainer"

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    .line 293
    if-nez v0, :cond_14

    .line 294
    const-string v0, "WishListFragmentContainer"

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    .line 296
    :cond_14
    if-nez v0, :cond_15

    .line 297
    const-string v0, "RegistryFragmentContainer"

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    .line 299
    :cond_15
    instance-of v1, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v1, :cond_16

    .line 300
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {v1, v6}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;-><init>(Z)V

    .line 301
    invoke-virtual {v0, v1, v6}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 307
    :cond_16
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ACTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "SEARCH_PRODUCTS"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_17

    move-object v0, p0

    .line 308
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->instantiateSearch()V

    .line 310
    :cond_17
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ACTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "START_SCAN"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_18

    .line 311
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    const-string v2, "LIFE_EVENTS_PRODUCT_SCAN"

    const-string v3, ""

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v4, "ListUid"

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v5, "ListType"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    move-object v1, p0

    invoke-virtual/range {v0 .. v5}, Lmf;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 314
    :cond_18
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ACTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "CLOSE"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 316
    :cond_19
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ACTION"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, "SCAN_HISTORY"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 317
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "skuList"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 318
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 319
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "Scan History"

    invoke-direct {v1, v6, v0, v2, v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/util/ArrayList;Ljava/lang/String;Z)V

    .line 320
    check-cast p0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v0, "PLPFragment"

    invoke-virtual {p0, v7, v1, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 325
    :cond_1a
    new-instance v0, Lmf;

    invoke-direct {v0}, Lmf;-><init>()V

    invoke-virtual {v0, p1, p2, p3, p0}, Lmf;->a(IILandroid/content/Intent;Landroid/app/Activity;)V

    goto/16 :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    invoke-static {p0}, Lp;->a(Landroid/app/Activity;)V

    .line 70
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 71
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    .line 72
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    invoke-static {p0}, Lp;->d(Landroid/app/Activity;)V

    .line 142
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onDestroy()V

    .line 143
    return-void
.end method

.method public onPause()V
    .locals 3

    .prologue
    invoke-static {p0}, Lp;->g(Landroid/app/Activity;)V

    .line 86
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 87
    invoke-static {}, Llu;->a()V

    .line 88
    sget-boolean v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    if-eqz v0, :cond_0

    .line 90
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->stopService(Landroid/content/Intent;)Z

    .line 92
    :cond_0
    return-void
.end method

.method protected onRestart()V
    .locals 0

    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onRestart()V

    invoke-static {p0}, Lp;->e(Landroid/app/Activity;)V

    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    invoke-static {p0}, Lp;->f(Landroid/app/Activity;)V

    .line 96
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 97
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 98
    sput-object p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->baseFragmentActivity:Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    invoke-virtual {v0}, Lnb;->A()Ljava/lang/String;

    move-result-object v0

    .line 101
    instance-of v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    if-nez v1, :cond_1

    .line 102
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->BACKGROUND:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    iget-object v1, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->FOREGROUND:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lnb;->c(Ljava/lang/String;)V

    .line 105
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "shake_your_device"

    const-string v2, "Off"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 107
    if-eqz v0, :cond_1

    const-string v1, "Off"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 108
    invoke-static {}, Lcom/bestbuy/android/base/BBYApplication;->getInstance()Lcom/bestbuy/android/base/BBYApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYApplication;->registerSensor()V

    .line 112
    :cond_1
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 113
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/inc247/ChatSDK;->addChat(Landroid/app/Activity;)V

    .line 115
    :cond_2
    sget-boolean v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    if-eqz v0, :cond_3

    .line 117
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 119
    :cond_3
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    invoke-static {p0}, Lp;->b(Landroid/app/Activity;)V

    .line 137
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onStart()V

    .line 138
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    invoke-static {p0}, Lp;->c(Landroid/app/Activity;)V

    .line 81
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onStop()V

    .line 82
    return-void
.end method

.method public onUserLeaveHint()V
    .locals 2

    .prologue
    .line 124
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onUserLeaveHint()V

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    invoke-virtual {v0}, Lnb;->A()Ljava/lang/String;

    move-result-object v0

    .line 126
    iget-object v1, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->FOREGROUND:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    iget-object v1, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->BACKGROUND:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lnb;->c(Ljava/lang/String;)V

    .line 129
    invoke-static {}, Lcom/bestbuy/android/base/BBYApplication;->getInstance()Lcom/bestbuy/android/base/BBYApplication;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYApplication;->unRegisterSensor()V

    .line 133
    :cond_0
    return-void
.end method

.method public reEnablePullDown()V
    .locals 4

    .prologue
    .line 481
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 482
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_3

    move-object v0, v1

    .line 483
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 484
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_1

    .line 485
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v2, "PRODUCTS"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 486
    instance-of v2, v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v2, :cond_0

    .line 487
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 488
    invoke-direct {p0, v1, v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->enableAfterCheck(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;)V

    .line 530
    :cond_0
    :goto_0
    return-void

    .line 490
    :cond_1
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v2

    if-nez v2, :cond_2

    .line 491
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v2, "HOME"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 492
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v2, :cond_0

    .line 493
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 494
    invoke-direct {p0, v1, v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->enableAfterCheck(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;)V

    goto :goto_0

    .line 496
    :cond_2
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    .line 497
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v2, "STORES"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 498
    instance-of v2, v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v2, :cond_0

    .line 499
    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 500
    invoke-direct {p0, v1, v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->enableAfterCheck(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/Fragment;)V

    goto :goto_0

    .line 503
    :cond_3
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    if-eqz v0, :cond_4

    .line 504
    check-cast v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 505
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v1, :cond_0

    .line 506
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b()V

    goto :goto_0

    .line 508
    :cond_4
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_5

    .line 509
    check-cast v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 510
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v1, :cond_0

    .line 511
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->h()V

    goto :goto_0

    .line 513
    :cond_5
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v0, :cond_7

    .line 514
    check-cast v1, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 515
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v1, :cond_6

    .line 516
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b()V

    goto/16 :goto_0

    .line 517
    :cond_6
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    if-eqz v1, :cond_0

    .line 518
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c()V

    goto/16 :goto_0

    .line 520
    :cond_7
    instance-of v0, v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v0, :cond_0

    .line 521
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 522
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v1, :cond_8

    .line 523
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b()V

    goto/16 :goto_0

    .line 524
    :cond_8
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    if-eqz v1, :cond_9

    .line 525
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c()V

    goto/16 :goto_0

    .line 526
    :cond_9
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    if-eqz v1, :cond_0

    .line 527
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->c()V

    goto/16 :goto_0
.end method

.method public setContentView(I)V
    .locals 0

    .prologue
    .line 76
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->setContentView(I)V

    .line 77
    return-void
.end method

.method public showActionBarHome()V
    .locals 5

    .prologue
    const v4, 0x7f0c0059

    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 331
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 332
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 333
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 334
    iput-boolean v3, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->isActionBarHidden:Z

    .line 335
    instance-of v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_1

    move-object v0, p0

    .line 336
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeSearchBarVisibility(Z)V

    .line 337
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 338
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_0

    .line 339
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 340
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_3

    sget-boolean v1, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-eqz v1, :cond_3

    move-object v0, p0

    .line 341
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeStoresSearchVisibility(Z)V

    :cond_0
    :goto_0
    move-object v0, p0

    .line 349
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setShareVisible(Z)V

    move-object v0, p0

    .line 350
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setAddToVisible(Z)V

    .line 352
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 353
    if-eqz v0, :cond_2

    .line 354
    const v1, 0x7f0c0058

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 355
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x1e

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 356
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 358
    :cond_2
    return-void

    .line 342
    :cond_3
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v0

    if-nez v0, :cond_0

    .line 343
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    invoke-virtual {v0}, Lnb;->U()Ljava/util/Stack;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Stack;->clear()V

    .line 344
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    invoke-virtual {v0}, Lnb;->U()Ljava/util/Stack;

    move-result-object v0

    const-string v1, "Home"

    invoke-virtual {v0, v1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    move-object v0, p0

    .line 346
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->appData:Lnb;

    invoke-virtual {v1}, Lnb;->U()Ljava/util/Stack;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public showSearchBarWithBackButton()V
    .locals 5

    .prologue
    const v4, 0x7f0c0059

    const/4 v3, 0x0

    .line 375
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 376
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 377
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 378
    iput-boolean v3, p0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->isActionBarHidden:Z

    .line 379
    instance-of v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_0

    move-object v0, p0

    .line 380
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeSearchBarVisibility(Z)V

    .line 381
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-object v0, p0

    .line 382
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setShareVisible(Z)V

    move-object v0, p0

    .line 383
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setAddToVisible(Z)V

    .line 385
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 386
    if-eqz v0, :cond_1

    .line 387
    const v1, 0x7f0c0058

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 388
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/16 v2, 0x1e

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 389
    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 391
    :cond_1
    return-void
.end method

.method public updateActionBarTitle(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 427
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 428
    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 429
    const v1, 0x7f0c0059

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 431
    :cond_0
    return-void
.end method

.method public updateActionBarTitleAndSubTitle(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    const v3, 0x7f0c0059

    .line 434
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 435
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 436
    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 437
    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 438
    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "<small>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "<br/>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</small>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 441
    :cond_0
    return-void
.end method

.method public updateOverviewActionBarTitle(Ljava/lang/String;I)V
    .locals 3

    .prologue
    const v2, 0x7f0c0059

    .line 444
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 445
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 446
    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setEms(I)V

    .line 447
    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 449
    :cond_0
    return-void
.end method
