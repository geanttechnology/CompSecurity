.class public Lcom/wishabi/flipp/app/CouponFragment;
.super Landroid/app/Fragment;
.source "SourceFile"

# interfaces
.implements Landroid/app/ActionBar$OnNavigationListener;
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Luk/co/senab/actionbarpulltorefresh/library/a/b;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Fragment;",
        "Landroid/app/ActionBar$OnNavigationListener;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Luk/co/senab/actionbarpulltorefresh/library/a/b;"
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

.field private c:Landroid/support/v7/widget/RecyclerView;

.field private d:Landroid/view/View;

.field private e:Landroid/view/MenuItem;

.field private f:I

.field private g:Landroid/content/SharedPreferences;

.field private h:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

.field private i:Lcom/wishabi/flipp/widget/an;

.field private j:Landroid/database/Cursor;

.field private k:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/o;",
            ">;>;"
        }
    .end annotation
.end field

.field private l:[Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Lcom/wishabi/flipp/app/dn;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 65
    const-class v0, Lcom/wishabi/flipp/app/CouponFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/CouponFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 60
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/CouponFragment;)Lcom/wishabi/flipp/widget/an;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    return-object v0
.end method

.method private a(I)V
    .locals 7

    .prologue
    .line 633
    iput p1, p0, Lcom/wishabi/flipp/app/CouponFragment;->f:I

    .line 634
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->e:Landroid/view/MenuItem;

    if-nez v0, :cond_0

    .line 643
    :goto_0
    return-void

    .line 637
    :cond_0
    iget v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->f:I

    if-nez v0, :cond_1

    .line 638
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->e:Landroid/view/MenuItem;

    const v1, 0x7f0e0105

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    goto :goto_0

    .line 640
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->e:Landroid/view/MenuItem;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0d0004

    iget v3, p0, Lcom/wishabi/flipp/app/CouponFragment;->f:I

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget v6, p0, Lcom/wishabi/flipp/app/CouponFragment;->f:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    goto :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/CouponFragment;I)V
    .locals 3

    .prologue
    .line 60
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->k:Ljava/util/HashMap;

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/an;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/app/CouponFragment;->k:Ljava/util/HashMap;

    iget v0, v0, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/o;

    new-instance v2, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    invoke-direct {v2, v1, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/content/o;)V

    invoke-virtual {v1, v2}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 697
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 698
    const-string v1, "category"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 699
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    .line 700
    if-eqz v1, :cond_0

    .line 701
    const/4 v2, 0x0

    invoke-virtual {v1, v2, v0, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 702
    :cond_0
    return-void
.end method

.method private a([Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 497
    iput-object p1, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    .line 500
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->isHidden()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 532
    :cond_0
    :goto_0
    return-void

    .line 503
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 506
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v2

    .line 508
    if-eqz v2, :cond_0

    .line 511
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-string v3, ""

    invoke-virtual {v1, v3}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 512
    const/4 v1, 0x1

    invoke-virtual {v2, v1}, Landroid/app/ActionBar;->setNavigationMode(I)V

    .line 513
    new-instance v1, Lcom/wishabi/flipp/app/l;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    iget-object v4, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    invoke-direct {v1, v3, v4}, Lcom/wishabi/flipp/app/l;-><init>(Landroid/content/Context;[Ljava/lang/String;)V

    invoke-virtual {v2, v1, p0}, Landroid/app/ActionBar;->setListNavigationCallbacks(Landroid/widget/SpinnerAdapter;Landroid/app/ActionBar$OnNavigationListener;)V

    .line 517
    iget-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    array-length v1, v1

    if-nez v1, :cond_3

    .line 518
    :cond_2
    invoke-virtual {v2, v0}, Landroid/app/ActionBar;->setNavigationMode(I)V

    .line 519
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const v1, 0x7f0e0086

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setTitle(I)V

    .line 520
    const-string v0, "All Deals"

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/CouponFragment;->a(Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    move v1, v0

    .line 526
    :goto_1
    iget-object v3, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    array-length v3, v3

    if-ge v0, v3, :cond_5

    .line 527
    iget-object v3, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    aget-object v3, v3, v0

    iget-object v4, p0, Lcom/wishabi/flipp/app/CouponFragment;->m:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    move v1, v0

    .line 526
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 531
    :cond_5
    invoke-virtual {v2, v1}, Landroid/app/ActionBar;->setSelectedNavigationItem(I)V

    goto :goto_0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/CouponFragment;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->b:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    return-object v0
.end method

.method private b()V
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 268
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    if-nez v0, :cond_1

    .line 274
    :cond_0
    :goto_0
    return-void

    .line 271
    :cond_1
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v2, "coupons"

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 272
    sget-object v2, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_2

    move-object v0, v1

    :goto_1
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    const-string v5, "count"

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v5, "category"

    invoke-virtual {v4, v5, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v5, "Coupons"

    invoke-virtual {v2, v5, v4}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    const-string v4, "coupon listing"

    const-string v5, "%s | %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v4, v6, v7

    const/4 v7, 0x1

    aput-object v0, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    int-to-long v6, v3

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v4, v0, v1, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V

    goto :goto_0

    :cond_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    if-nez v0, :cond_3

    move-object v0, v1

    goto :goto_1

    :cond_3
    invoke-virtual {v0}, Landroid/app/ActionBar;->getSelectedNavigationIndex()I

    move-result v0

    if-ltz v0, :cond_4

    iget-object v4, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    array-length v4, v4

    if-lt v0, v4, :cond_5

    :cond_4
    move-object v0, v1

    goto :goto_1

    :cond_5
    iget-object v4, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    aget-object v0, v4, v0

    goto :goto_1
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/CouponFragment;I)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 60
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/an;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    new-array v2, v4, [I

    const/4 v3, 0x0

    iget v0, v0, Lcom/wishabi/flipp/content/c;->a:I

    aput v0, v2, v3

    sget-object v0, Lcom/wishabi/flipp/b/p;->d:Lcom/wishabi/flipp/b/p;

    invoke-static {v1, v2, v4, v0}, Lcom/wishabi/flipp/app/dr;->a(Landroid/app/Activity;[IZLcom/wishabi/flipp/b/p;)I

    :cond_0
    return-void
.end method

.method private c()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 535
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 536
    if-nez v0, :cond_1

    .line 557
    :cond_0
    :goto_0
    return-void

    .line 539
    :cond_1
    invoke-static {v2}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 540
    if-eqz v0, :cond_0

    .line 543
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->b:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 545
    sget-object v0, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    new-instance v1, Lcom/wishabi/flipp/app/x;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/x;-><init>(Lcom/wishabi/flipp/app/CouponFragment;)V

    invoke-virtual {v0, v2, v1}, Lcom/wishabi/flipp/b/u;->a(Ljava/lang/String;Lcom/wishabi/flipp/b/x;)I

    goto :goto_0
.end method

.method private d()V
    .locals 10

    .prologue
    const/4 v2, 0x0

    const/16 v9, 0x8

    const/4 v6, 0x0

    .line 560
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 561
    if-nez v1, :cond_0

    .line 630
    :goto_0
    return-void

    .line 565
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->k:Ljava/util/HashMap;

    if-nez v0, :cond_2

    .line 566
    :cond_1
    iput-object v2, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    .line 567
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/an;)V

    .line 568
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->d:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    .line 569
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v9}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    goto :goto_0

    .line 574
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_3

    .line 575
    iput-object v2, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    .line 576
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/an;)V

    .line 577
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->d:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 578
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v9}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    goto :goto_0

    .line 583
    :cond_3
    new-instance v3, Lcom/wishabi/flipp/content/d;

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    invoke-direct {v3, v0}, Lcom/wishabi/flipp/content/d;-><init>(Landroid/database/Cursor;)V

    .line 587
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 588
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 589
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move v2, v6

    .line 591
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_7

    .line 592
    new-instance v7, Lcom/wishabi/flipp/content/c;

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    invoke-direct {v7, v0, v3}, Lcom/wishabi/flipp/content/c;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/d;)V

    .line 593
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->k:Ljava/util/HashMap;

    iget v8, v7, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v0, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 595
    if-eqz v0, :cond_4

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 596
    :cond_4
    new-instance v0, Landroid/util/Pair;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-direct {v0, v8, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 604
    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    .line 605
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    .line 606
    goto :goto_1

    .line 598
    :cond_5
    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/o;

    .line 599
    invoke-virtual {v0}, Lcom/wishabi/flipp/content/o;->b()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 600
    new-instance v0, Landroid/util/Pair;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-direct {v0, v8, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 602
    :cond_6
    new-instance v0, Landroid/util/Pair;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-direct {v0, v8, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 609
    :cond_7
    new-instance v0, Lcom/wishabi/flipp/app/m;

    iget-object v2, p0, Lcom/wishabi/flipp/app/CouponFragment;->k:Ljava/util/HashMap;

    invoke-direct {v0, v2}, Lcom/wishabi/flipp/app/m;-><init>(Ljava/util/HashMap;)V

    .line 610
    invoke-static {v4, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 611
    invoke-static {v5, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 614
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 615
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 616
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    .line 617
    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 618
    :cond_8
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    .line 619
    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 622
    :cond_9
    new-instance v0, Lcom/wishabi/flipp/widget/an;

    iget-object v4, p0, Lcom/wishabi/flipp/app/CouponFragment;->k:Ljava/util/HashMap;

    iget-object v5, p0, Lcom/wishabi/flipp/app/CouponFragment;->n:Lcom/wishabi/flipp/app/dn;

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/widget/an;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/util/HashMap;Lcom/wishabi/flipp/app/dn;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    .line 624
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->a(Landroid/support/v7/widget/an;)V

    .line 625
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v6}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 626
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->d:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    .line 629
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->e()V

    goto/16 :goto_0
.end method

.method private e()V
    .locals 1

    .prologue
    .line 708
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->i:Lcom/wishabi/flipp/widget/an;

    if-eqz v0, :cond_0

    .line 709
    new-instance v0, Lcom/wishabi/flipp/app/y;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/y;-><init>(Lcom/wishabi/flipp/app/CouponFragment;)V

    invoke-static {v0}, Lcom/wishabi/flipp/app/FlippApplication;->a(Ljava/lang/Runnable;)Z

    .line 716
    :cond_0
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 0

    .prologue
    .line 470
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->c()V

    .line 471
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 101
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 103
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->g:Landroid/content/SharedPreferences;

    .line 104
    new-instance v0, Lcom/wishabi/flipp/app/u;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/u;-><init>(Lcom/wishabi/flipp/app/CouponFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->h:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 130
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->g:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->h:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 133
    if-eqz p1, :cond_0

    .line 134
    const-string v0, "category"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->m:Ljava/lang/String;

    .line 136
    :cond_0
    invoke-direct {p0, v2}, Lcom/wishabi/flipp/app/CouponFragment;->a(I)V

    .line 140
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 141
    if-eqz v0, :cond_1

    .line 142
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 143
    invoke-virtual {v0, v2}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 144
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 145
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 147
    :cond_1
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x0

    const/4 v8, 0x1

    const/4 v5, 0x0

    .line 350
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 351
    if-nez v1, :cond_1

    .line 394
    :cond_0
    :goto_0
    return-object v5

    .line 354
    :cond_1
    invoke-static {v5}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 355
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 358
    packed-switch p1, :pswitch_data_0

    .line 398
    new-instance v0, Ljava/security/InvalidParameterException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invalid loader id "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 360
    :pswitch_0
    const-string v0, "category"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 361
    if-eqz v6, :cond_0

    .line 364
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "*"

    aput-object v4, v3, v9

    const-string v4, "clipped"

    aput-object v4, v3, v8

    const-string v4, "sent"

    aput-object v4, v3, v10

    const-string v4, "category"

    aput-object v4, v3, v11

    const-string v4, "category = ? AND postal_code = ? AND deleted = 0"

    new-array v5, v10, [Ljava/lang/String;

    aput-object v6, v5, v9

    aput-object v7, v5, v8

    const-string v6, "priority ASC, available_from DESC, _id DESC"

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, v0

    goto :goto_0

    .line 370
    :pswitch_1
    const-string v0, "coupon_ids"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v0

    .line 371
    if-eqz v0, :cond_0

    .line 373
    invoke-static {v1, v0, v9, v8}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;[IZZ)Landroid/content/Loader;

    move-result-object v5

    goto :goto_0

    .line 376
    :pswitch_2
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    new-array v3, v11, [Ljava/lang/String;

    const-string v4, "_id"

    aput-object v4, v3, v9

    const-string v4, "clipped"

    aput-object v4, v3, v8

    const-string v4, "sent"

    aput-object v4, v3, v10

    const-string v4, "clipped = 1 AND (sent = 0 OR sent IS NULL) AND deleted = 0"

    move-object v6, v5

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, v0

    goto :goto_0

    .line 381
    :pswitch_3
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v2, "coupon_category_order"

    invoke-interface {v0, v2, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 384
    if-eqz v0, :cond_3

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    move-object v0, v5

    .line 385
    :goto_1
    if-eqz v0, :cond_4

    const-string v2, "category"

    invoke-static {v2, v0, v8}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v6

    .line 389
    :goto_2
    new-array v5, v8, [Ljava/lang/String;

    aput-object v7, v5, v9

    .line 391
    if-eqz v0, :cond_2

    .line 392
    invoke-static {v5, v0}, Lcom/wishabi/flipp/util/a;->a([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    move-object v5, v0

    .line 394
    :cond_2
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    new-array v3, v11, [Ljava/lang/String;

    const-string v4, "DISTINCT category"

    aput-object v4, v3, v9

    const-string v4, "deleted"

    aput-object v4, v3, v8

    const-string v4, "postal_code"

    aput-object v4, v3, v10

    const-string v4, "deleted = 0 AND postal_code = ?"

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, v0

    goto/16 :goto_0

    :cond_3
    move-object v0, v5

    .line 384
    goto :goto_1

    .line 385
    :cond_4
    const-string v6, "category ASC"

    goto :goto_2

    .line 358
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 296
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 297
    if-nez v2, :cond_1

    .line 327
    :cond_0
    :goto_0
    return-void

    .line 300
    :cond_1
    const v0, 0x7f100001

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 302
    const v0, 0x7f0b0155

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 303
    if-eqz v0, :cond_0

    .line 306
    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/SearchView;

    .line 307
    if-eqz v0, :cond_0

    .line 311
    const-string v1, "search"

    invoke-virtual {v2, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/SearchManager;

    .line 313
    invoke-virtual {v2}, Landroid/app/Activity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 315
    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/SearchView;->setIconifiedByDefault(Z)V

    .line 316
    invoke-virtual {v0, v4}, Lcom/wishabi/flipp/widget/SearchView;->setClearAfterQuery(Z)V

    .line 317
    const v1, 0x7f0e011f

    invoke-virtual {v2, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/SearchView;->setQueryHint(Ljava/lang/CharSequence;)V

    .line 319
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 320
    const-string v2, "search_mode"

    sget v3, Lcom/wishabi/flipp/app/en;->c:I

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 322
    const-string v2, "com.wishabi.flipp.search_bundle"

    invoke-virtual {v0, v2, v1}, Lcom/wishabi/flipp/widget/SearchView;->setSearchExtraData(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 325
    const v0, 0x7f0b0156

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->e:Landroid/view/MenuItem;

    .line 326
    iget v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->f:I

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/CouponFragment;->a(I)V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9

    .prologue
    const/4 v8, 0x3

    const/4 v6, 0x0

    const/4 v3, 0x0

    const/4 v7, 0x1

    const/4 v2, 0x2

    .line 154
    invoke-super {p0, p1, p2, p3}, Landroid/app/Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 156
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 157
    if-nez v1, :cond_0

    move-object v0, v3

    .line 235
    :goto_0
    return-object v0

    .line 160
    :cond_0
    invoke-virtual {p0, v7}, Lcom/wishabi/flipp/app/CouponFragment;->setHasOptionsMenu(Z)V

    .line 162
    const v0, 0x7f03001e

    invoke-virtual {p1, v0, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 164
    const v0, 0x7f0b0095

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->b:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    .line 165
    const v0, 0x7f0b0097

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    .line 166
    const v0, 0x7f0b0096

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->d:Landroid/view/View;

    .line 168
    invoke-static {v1}, Luk/co/senab/actionbarpulltorefresh/library/a;->a(Landroid/app/Activity;)Luk/co/senab/actionbarpulltorefresh/library/b;

    move-result-object v0

    new-array v1, v2, [Landroid/view/View;

    iget-object v5, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    aput-object v5, v1, v6

    iget-object v5, p0, Lcom/wishabi/flipp/app/CouponFragment;->d:Landroid/view/View;

    aput-object v5, v1, v7

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/b;->a([Landroid/view/View;)Luk/co/senab/actionbarpulltorefresh/library/b;

    move-result-object v0

    const-class v1, Lcom/wishabi/flipp/widget/PullableRecyclerView;

    new-instance v5, Lcom/wishabi/flipp/widget/cy;

    invoke-direct {v5}, Lcom/wishabi/flipp/widget/cy;-><init>()V

    iget-object v6, v0, Luk/co/senab/actionbarpulltorefresh/library/b;->c:Ljava/util/HashMap;

    if-nez v6, :cond_1

    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    iput-object v6, v0, Luk/co/senab/actionbarpulltorefresh/library/b;->c:Ljava/util/HashMap;

    :cond_1
    iget-object v6, v0, Luk/co/senab/actionbarpulltorefresh/library/b;->c:Ljava/util/HashMap;

    invoke-virtual {v6, v1, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iput-object p0, v0, Luk/co/senab/actionbarpulltorefresh/library/b;->b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

    iget-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->b:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/b;->a(Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;)V

    .line 175
    new-instance v0, Lcom/wishabi/flipp/app/v;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/v;-><init>(Lcom/wishabi/flipp/app/CouponFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->n:Lcom/wishabi/flipp/app/dn;

    .line 190
    invoke-static {}, Lcom/wishabi/flipp/util/i;->a()I

    move-result v0

    div-int/lit16 v0, v0, 0xb4

    invoke-static {v0, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 192
    rem-int/lit8 v0, v1, 0x2

    if-ne v0, v7, :cond_4

    add-int/lit8 v0, v1, -0x1

    :goto_1
    div-int/lit8 v0, v0, 0x2

    .line 195
    if-ne v1, v8, :cond_2

    move v0, v2

    .line 198
    :cond_2
    mul-int v5, v1, v0

    .line 199
    div-int v0, v5, v0

    .line 200
    div-int v1, v5, v1

    .line 201
    new-instance v6, Landroid/support/v7/widget/s;

    invoke-direct {v6, v5}, Landroid/support/v7/widget/s;-><init>(I)V

    .line 202
    new-instance v7, Lcom/wishabi/flipp/app/w;

    invoke-direct {v7, p0, v5, v0, v1}, Lcom/wishabi/flipp/app/w;-><init>(Lcom/wishabi/flipp/app/CouponFragment;III)V

    iput-object v7, v6, Landroid/support/v7/widget/s;->g:Landroid/support/v7/widget/v;

    .line 221
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->c:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v6}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/au;)V

    .line 223
    const v0, 0x7f0b003e

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 225
    const v1, 0x7f0200d6

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    .line 226
    const v1, 0x7f0e00e8

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(I)V

    .line 227
    const v1, 0x7f0e00e9

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(I)V

    .line 229
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 230
    if-eqz v0, :cond_3

    .line 231
    invoke-virtual {v0, v2, v3, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 232
    invoke-virtual {v0, v8, v3, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_3
    move-object v0, v4

    .line 235
    goto/16 :goto_0

    :cond_4
    move v0, v1

    .line 192
    goto :goto_1
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 475
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 477
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->h:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    if-eqz v0, :cond_0

    .line 478
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->g:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->h:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->unregisterOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 480
    iput-object v2, p0, Lcom/wishabi/flipp/app/CouponFragment;->h:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 481
    iput-object v2, p0, Lcom/wishabi/flipp/app/CouponFragment;->g:Landroid/content/SharedPreferences;

    .line 483
    :cond_0
    return-void
.end method

.method public onHiddenChanged(Z)V
    .locals 1

    .prologue
    .line 240
    invoke-super {p0, p1}, Landroid/app/Fragment;->onHiddenChanged(Z)V

    .line 242
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_1

    .line 257
    :cond_0
    :goto_0
    return-void

    .line 245
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 247
    if-eqz v0, :cond_0

    .line 250
    if-nez p1, :cond_2

    .line 251
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/CouponFragment;->a([Ljava/lang/String;)V

    .line 252
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->b()V

    .line 256
    :cond_2
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->e()V

    goto :goto_0
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 60
    check-cast p2, Landroid/database/Cursor;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Finished loading "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    if-eq v0, p2, :cond_0

    iput-object p2, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    if-eqz p2, :cond_1

    const-string v0, "_id"

    invoke-static {p2, v0}, Lcom/wishabi/flipp/util/f;->a(Landroid/database/Cursor;Ljava/lang/String;)[I

    move-result-object v0

    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    const-string v3, "coupon_ids"

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    const/4 v0, 0x1

    invoke-virtual {v1, v0, v2, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_1
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->d()V

    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->b()V

    goto :goto_0

    :pswitch_1
    invoke-static {p2}, Lcom/wishabi/flipp/content/l;->b(Landroid/database/Cursor;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->k:Ljava/util/HashMap;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->d()V

    goto :goto_0

    :pswitch_2
    if-eqz p2, :cond_2

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-nez v1, :cond_3

    :cond_2
    :goto_1
    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/CouponFragment;->a(I)V

    goto :goto_0

    :cond_3
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    goto :goto_1

    :pswitch_3
    const-string v1, "category"

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    :goto_2
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v3

    if-ge v0, v3, :cond_4

    invoke-interface {p2, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v0

    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_4
    invoke-direct {p0, v2}, Lcom/wishabi/flipp/app/CouponFragment;->a([Ljava/lang/String;)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 450
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 466
    :goto_0
    return-void

    .line 452
    :pswitch_0
    iput-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->j:Landroid/database/Cursor;

    .line 453
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->d()V

    goto :goto_0

    .line 456
    :pswitch_1
    iput-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->k:Ljava/util/HashMap;

    .line 457
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->d()V

    goto :goto_0

    .line 460
    :pswitch_2
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/CouponFragment;->a(I)V

    goto :goto_0

    .line 463
    :pswitch_3
    invoke-direct {p0, v1}, Lcom/wishabi/flipp/app/CouponFragment;->a([Ljava/lang/String;)V

    goto :goto_0

    .line 450
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onNavigationItemSelected(IJ)Z
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 685
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    if-nez v0, :cond_1

    .line 693
    :cond_0
    :goto_0
    return v1

    .line 688
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    array-length v0, v0

    if-ge p1, v0, :cond_0

    .line 691
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->l:[Ljava/lang/String;

    aget-object v0, v0, p1

    iput-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->m:Ljava/lang/String;

    .line 692
    iget-object v0, p0, Lcom/wishabi/flipp/app/CouponFragment;->m:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/CouponFragment;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 331
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 332
    if-nez v1, :cond_0

    .line 333
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    .line 345
    :goto_0
    return v0

    .line 335
    :cond_0
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    const v2, 0x7f0b0157

    if-ne v1, v2, :cond_1

    .line 336
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->c()V

    goto :goto_0

    .line 340
    :cond_1
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    const v2, 0x7f0b0156

    if-ne v1, v2, :cond_2

    .line 341
    invoke-static {}, Lcom/wishabi/flipp/app/PrintCouponActivity;->a()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/app/CouponFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 345
    :cond_2
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 261
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 263
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/CouponFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_0

    .line 264
    invoke-direct {p0}, Lcom/wishabi/flipp/app/CouponFragment;->b()V

    .line 265
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 487
    const-string v0, "category"

    iget-object v1, p0, Lcom/wishabi/flipp/app/CouponFragment;->m:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 488
    return-void
.end method
