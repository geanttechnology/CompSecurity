.class public Lcom/wishabi/flipp/app/MainActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# static fields
.field private static final a:[Ljava/lang/String;

.field private static final b:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private c:Landroid/support/v4/app/a;

.field private d:Lcom/wishabi/flipp/app/FeaturedFragment;

.field private e:Lcom/wishabi/flipp/app/CouponFragment;

.field private f:Lcom/wishabi/flipp/app/SearchFragment;

.field private g:Landroid/view/View;

.field private h:Landroid/support/v4/widget/DrawerLayout;

.field private i:Ljava/lang/String;

.field private j:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

.field private k:I

.field private l:Ljava/lang/String;

.field private m:Landroid/content/SharedPreferences;

.field private final n:Landroid/content/BroadcastReceiver;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 63
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "RequestDialogTag"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "AllowPushDialogTag"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "CouponDialogTag"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "TutorialHeroDialogTag"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "TutorialPrintCouponDialogTag"

    aput-object v2, v0, v1

    sput-object v0, Lcom/wishabi/flipp/app/MainActivity;->a:[Ljava/lang/String;

    .line 71
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 74
    sput-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    const-string v1, "All Flyers"

    const v2, 0x7f0b0025

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    sget-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    const-string v1, "Favorites"

    const v2, 0x7f0b0024

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    sget-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    const-string v1, "Clippings"

    const v2, 0x7f0b0023

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    sget-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    const-string v1, "Shopping List"

    const v2, 0x7f0b0026

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    sget-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    const-string v1, "Coupons"

    const v2, 0x7f0b0027

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    sget-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    const-string v1, "Print Coupons"

    const v2, 0x7f0b0028

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 98
    const/4 v0, -0x1

    iput v0, p0, Lcom/wishabi/flipp/app/MainActivity;->k:I

    .line 102
    new-instance v0, Lcom/wishabi/flipp/app/dh;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/dh;-><init>(Lcom/wishabi/flipp/app/MainActivity;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->n:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/MainActivity;)Lcom/wishabi/flipp/app/SearchFragment;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->f:Lcom/wishabi/flipp/app/SearchFragment;

    return-object v0
.end method

.method private a()V
    .locals 5

    .prologue
    .line 414
    sget-object v2, Lcom/wishabi/flipp/app/MainActivity;->a:[Ljava/lang/String;

    array-length v3, v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 415
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Landroid/app/DialogFragment;

    .line 418
    if-eqz v0, :cond_0

    .line 419
    invoke-virtual {v0}, Landroid/app/DialogFragment;->dismiss()V

    .line 414
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 421
    :cond_1
    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/MainActivity;)Landroid/support/v4/widget/DrawerLayout;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->h:Landroid/support/v4/widget/DrawerLayout;

    return-object v0
.end method

.method private b(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 214
    invoke-direct {p0}, Lcom/wishabi/flipp/app/MainActivity;->a()V

    .line 215
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 217
    const-string v1, "AllowPushDialogTag"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 218
    new-instance v1, Lcom/wishabi/flipp/app/a;

    invoke-direct {v1}, Lcom/wishabi/flipp/app/a;-><init>()V

    invoke-virtual {v1, v0, p1}, Lcom/wishabi/flipp/app/a;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 221
    :cond_0
    :goto_0
    return-void

    .line 219
    :cond_1
    const-string v1, "RequestDialogTag"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 220
    new-instance v1, Lcom/wishabi/flipp/app/fg;

    invoke-direct {v1}, Lcom/wishabi/flipp/app/fg;-><init>()V

    invoke-virtual {v1, v0, p1}, Lcom/wishabi/flipp/app/fg;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/MainActivity;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->j:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/MainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->l:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/MainActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->l:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f(Lcom/wishabi/flipp/app/MainActivity;)I
    .locals 1

    .prologue
    .line 43
    const/4 v0, -0x1

    iput v0, p0, Lcom/wishabi/flipp/app/MainActivity;->k:I

    return v0
.end method


# virtual methods
.method protected final a(Ljava/lang/String;)V
    .locals 7

    .prologue
    const v2, 0x7f0b0025

    const/4 v6, 0x0

    .line 333
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->i:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->i:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 381
    :goto_0
    return-void

    .line 336
    :cond_0
    iput-object p1, p0, Lcom/wishabi/flipp/app/MainActivity;->i:Ljava/lang/String;

    .line 340
    invoke-static {p1}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Ljava/lang/String;)I

    move-result v0

    .line 342
    const v1, 0x7f0e0086

    if-ne v0, v1, :cond_2

    .line 343
    const-string v0, ""

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 349
    :goto_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 351
    if-eqz v0, :cond_1

    .line 352
    invoke-virtual {v0, v6}, Landroid/app/ActionBar;->setNavigationMode(I)V

    .line 356
    :cond_1
    sget-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_a

    .line 357
    sget-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    move v1, v0

    .line 359
    :goto_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v3

    .line 361
    sget-object v0, Lcom/wishabi/flipp/app/MainActivity;->b:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 362
    if-ne v0, v1, :cond_4

    .line 363
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v5

    invoke-virtual {v5, v0}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/app/FragmentTransaction;->show(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    goto :goto_3

    .line 344
    :cond_2
    if-nez v0, :cond_3

    .line 345
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/app/MainActivity;->setTitle(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 347
    :cond_3
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->setTitle(I)V

    goto :goto_1

    .line 365
    :cond_4
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v5

    invoke-virtual {v5, v0}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/app/FragmentTransaction;->hide(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    goto :goto_3

    .line 368
    :cond_5
    if-ne v1, v2, :cond_7

    .line 369
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->d:Lcom/wishabi/flipp/app/FeaturedFragment;

    iget-object v2, v0, Lcom/wishabi/flipp/app/FeaturedFragment;->a:Ljava/lang/String;

    if-eqz v2, :cond_6

    iget-object v2, v0, Lcom/wishabi/flipp/app/FeaturedFragment;->a:Ljava/lang/String;

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_7

    :cond_6
    iput-object p1, v0, Lcom/wishabi/flipp/app/FeaturedFragment;->a:Ljava/lang/String;

    iget-object v2, v0, Lcom/wishabi/flipp/app/FeaturedFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v2, v6, v6}, Lcom/wishabi/flipp/widget/CollectionView;->scrollTo(II)V

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/FeaturedFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v2

    if-eqz v2, :cond_7

    const/4 v4, 0x0

    invoke-virtual {v2, v6, v4, v0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 371
    :cond_7
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->f:Lcom/wishabi/flipp/app/SearchFragment;

    if-eqz v0, :cond_8

    .line 372
    const v0, 0x7f0b0026

    if-ne v1, v0, :cond_9

    .line 373
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->f:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v3, v0}, Landroid/app/FragmentTransaction;->show(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 374
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->f:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v0, v6}, Lcom/wishabi/flipp/app/SearchFragment;->onHiddenChanged(Z)V

    .line 380
    :cond_8
    :goto_4
    invoke-virtual {v3}, Landroid/app/FragmentTransaction;->commit()I

    goto/16 :goto_0

    .line 376
    :cond_9
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->f:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v3, v0}, Landroid/app/FragmentTransaction;->hide(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    goto :goto_4

    :cond_a
    move v1, v2

    goto/16 :goto_2
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 3

    .prologue
    .line 302
    invoke-super {p0, p1}, Landroid/app/Activity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 303
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->c:Landroid/support/v4/app/a;

    iget-boolean v1, v0, Landroid/support/v4/app/a;->d:Z

    if-nez v1, :cond_0

    invoke-virtual {v0}, Landroid/support/v4/app/a;->d()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, v0, Landroid/support/v4/app/a;->e:Landroid/graphics/drawable/Drawable;

    :cond_0
    iget-object v1, v0, Landroid/support/v4/app/a;->a:Landroid/app/Activity;

    iget v2, v0, Landroid/support/v4/app/a;->g:I

    invoke-static {v1, v2}, Landroid/support/v4/a/a;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, v0, Landroid/support/v4/app/a;->f:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/support/v4/app/a;->a()V

    .line 304
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 123
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 125
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    .line 127
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->n:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.TIMEZONE_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/MainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 129
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->n:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.TIME_SET"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/MainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 131
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->n:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "android.intent.action.DATE_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/app/MainActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 134
    const v0, 0x7f030003

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->setContentView(I)V

    .line 135
    const v0, 0x7f0e001b

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->setTitle(I)V

    .line 137
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 138
    const v0, 0x7f0b0025

    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/FeaturedFragment;

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->d:Lcom/wishabi/flipp/app/FeaturedFragment;

    .line 140
    const v0, 0x7f0b0027

    invoke-virtual {v1, v0}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/CouponFragment;

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->e:Lcom/wishabi/flipp/app/CouponFragment;

    .line 142
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0b002b

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/SearchFragment;

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->f:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0b0026

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/ShoppingListFragment;

    iget-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->f:Lcom/wishabi/flipp/app/SearchFragment;

    if-eqz v1, :cond_0

    if-nez v0, :cond_5

    .line 144
    :cond_0
    :goto_0
    const-string v0, "All Flyers"

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->a(Ljava/lang/String;)V

    .line 145
    const v0, 0x7f0b0022

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/DrawerLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->h:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0b002a

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/DrawerFragment;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/DrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->g:Landroid/view/View;

    new-instance v1, Lcom/wishabi/flipp/app/dj;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/dj;-><init>(Lcom/wishabi/flipp/app/MainActivity;)V

    iput-object v1, v0, Lcom/wishabi/flipp/app/DrawerFragment;->a:Lcom/wishabi/flipp/app/af;

    :cond_1
    new-instance v0, Landroid/support/v4/app/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->h:Landroid/support/v4/widget/DrawerLayout;

    invoke-direct {v0, p0, v1}, Landroid/support/v4/app/a;-><init>(Landroid/app/Activity;Landroid/support/v4/widget/DrawerLayout;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->c:Landroid/support/v4/app/a;

    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->h:Landroid/support/v4/widget/DrawerLayout;

    iget-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->c:Landroid/support/v4/app/a;

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->setDrawerListener(Landroid/support/v4/widget/f;)V

    .line 147
    const v0, 0x7f0b0029

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->j:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    .line 148
    invoke-static {p0}, Luk/co/senab/actionbarpulltorefresh/library/a;->a(Landroid/app/Activity;)Luk/co/senab/actionbarpulltorefresh/library/b;

    move-result-object v0

    invoke-static {}, Luk/co/senab/actionbarpulltorefresh/library/h;->a()Luk/co/senab/actionbarpulltorefresh/library/i;

    move-result-object v1

    iget-object v2, v1, Luk/co/senab/actionbarpulltorefresh/library/i;->a:Luk/co/senab/actionbarpulltorefresh/library/h;

    const/4 v3, 0x0

    iput-boolean v3, v2, Luk/co/senab/actionbarpulltorefresh/library/h;->g:Z

    iget-object v1, v1, Luk/co/senab/actionbarpulltorefresh/library/i;->a:Luk/co/senab/actionbarpulltorefresh/library/h;

    iput-object v1, v0, Luk/co/senab/actionbarpulltorefresh/library/b;->a:Luk/co/senab/actionbarpulltorefresh/library/h;

    iget-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->j:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/b;->a(Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;)V

    .line 152
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 153
    if-eqz v0, :cond_2

    .line 154
    invoke-virtual {v0, v4}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 155
    invoke-virtual {v0, v4}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 158
    :cond_2
    if-eqz p1, :cond_4

    .line 159
    const-string v0, "mCategoryName"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 160
    if-eqz v0, :cond_3

    .line 161
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->a(Ljava/lang/String;)V

    .line 163
    :cond_3
    const-string v0, "mDeepLinkFilterUri"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->l:Ljava/lang/String;

    .line 165
    :cond_4
    return-void

    .line 142
    :cond_5
    iget-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->f:Lcom/wishabi/flipp/app/SearchFragment;

    sget v2, Lcom/wishabi/flipp/app/en;->b:I

    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/app/SearchFragment;->a(I)V

    new-instance v1, Lcom/wishabi/flipp/app/di;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/di;-><init>(Lcom/wishabi/flipp/app/MainActivity;)V

    iput-object v1, v0, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    goto/16 :goto_0
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 116
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 117
    sget-object v0, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    iget v1, p0, Lcom/wishabi/flipp/app/MainActivity;->k:I

    iget-object v0, v0, Lcom/wishabi/flipp/b/u;->d:Ljava/util/HashMap;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/AsyncTask;

    if-eqz v0, :cond_0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->cancel(Z)Z

    .line 118
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->n:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 119
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 209
    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    .line 210
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/app/MainActivity;->setIntent(Landroid/content/Intent;)V

    .line 211
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 6

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    const v5, 0x800003

    .line 308
    iget-object v2, p0, Lcom/wishabi/flipp/app/MainActivity;->c:Landroid/support/v4/app/a;

    if-eqz p1, :cond_2

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v3

    const v4, 0x102002c

    if-ne v3, v4, :cond_2

    iget-boolean v3, v2, Landroid/support/v4/app/a;->c:Z

    if-eqz v3, :cond_2

    iget-object v3, v2, Landroid/support/v4/app/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v3, v5}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-static {v3}, Landroid/support/v4/widget/DrawerLayout;->g(Landroid/view/View;)Z

    move-result v1

    :cond_0
    if-eqz v1, :cond_3

    iget-object v1, v2, Landroid/support/v4/app/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1, v5}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v2

    if-nez v2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "No drawer view found with gravity "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Landroid/support/v4/widget/DrawerLayout;->b(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {v1, v2}, Landroid/support/v4/widget/DrawerLayout;->f(Landroid/view/View;)V

    :goto_0
    move v1, v0

    :cond_2
    if-eqz v1, :cond_5

    .line 318
    :goto_1
    return v0

    .line 308
    :cond_3
    iget-object v1, v2, Landroid/support/v4/app/a;->b:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v1, v5}, Landroid/support/v4/widget/DrawerLayout;->a(I)Landroid/view/View;

    move-result-object v2

    if-nez v2, :cond_4

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "No drawer view found with gravity "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Landroid/support/v4/widget/DrawerLayout;->b(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    invoke-virtual {v1, v2}, Landroid/support/v4/widget/DrawerLayout;->e(Landroid/view/View;)V

    goto :goto_0

    .line 311
    :cond_5
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f0b015b

    if-ne v0, v1, :cond_7

    .line 312
    const-string v0, "RequestDialogTag"

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->b(Ljava/lang/String;)V

    .line 318
    :cond_6
    :goto_2
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_1

    .line 313
    :cond_7
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f0b015c

    if-ne v0, v1, :cond_8

    .line 314
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/wishabi/flipp/app/SettingsActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 315
    :cond_8
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f0b015d

    if-ne v0, v1, :cond_6

    .line 316
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/wishabi/flipp/app/EulaActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_2
.end method

.method public onPostCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 169
    invoke-super {p0, p1}, Landroid/app/Activity;->onPostCreate(Landroid/os/Bundle;)V

    .line 170
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->c:Landroid/support/v4/app/a;

    invoke-virtual {v0}, Landroid/support/v4/app/a;->a()V

    .line 172
    sget-object v0, Lcom/wishabi/flipp/app/do;->a:Lcom/wishabi/flipp/app/do;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/do;->a()I

    move-result v0

    .line 173
    const/4 v1, 0x3

    if-eq v0, v1, :cond_0

    .line 174
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/wishabi/flipp/app/HelpActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 175
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 176
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->finish()V

    .line 178
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 13

    .prologue
    const/4 v1, 0x1

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 183
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 185
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    const-string v4, "postal_code"

    invoke-interface {v0, v4, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    const-string v5, "allow_push"

    invoke-interface {v0, v5}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {v4}, Lcom/wishabi/flipp/util/k;->c(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_17

    move v0, v1

    :goto_0
    iget-object v5, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    const-string v6, "allow_push"

    invoke-interface {v5, v6, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    const-string v5, "has_responded_to_push_prompt"

    invoke-interface {v0, v5, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {v4}, Lcom/wishabi/flipp/util/k;->b(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_a

    .line 186
    :cond_1
    :goto_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    if-eqz v4, :cond_6

    const-string v0, "was_handled"

    invoke-virtual {v4, v0, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_6

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v5, "EXTRA_OPENED_BY_PUSH_PLATFORM"

    invoke-virtual {v0, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v6

    if-eqz v5, :cond_2

    sget-object v7, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {v7, v5}, Lcom/wishabi/flipp/b/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    const-string v0, "platform"

    invoke-virtual {v8, v0, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "device_token"

    invoke-virtual {v8, v0, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v10, "url"

    if-eqz v6, :cond_b

    invoke-virtual {v6}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_2
    invoke-virtual {v8, v10, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "push_notification_click"

    invoke-virtual {v7, v0, v8, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/util/Map;Z)V

    if-eqz v6, :cond_c

    invoke-virtual {v6}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_3
    const-string v8, "Push Notification"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Push Notification | URL "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    const-string v11, "Push Notification | URL %s | TOKEN %s"

    const/4 v12, 0x2

    new-array v12, v12, [Ljava/lang/Object;

    aput-object v0, v12, v2

    aput-object v9, v12, v1

    invoke-static {v11, v12}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v8, v10, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    if-nez v5, :cond_3

    if-eqz v6, :cond_5

    :cond_3
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {v0, v5, v6}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Landroid/net/Uri;)V

    const-string v0, "All Flyers"

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->a(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/wishabi/flipp/app/MainActivity;->a()V

    if-eqz v6, :cond_13

    const-string v0, "com.wishabi.flipp.preferences"

    invoke-virtual {p0, v0, v2}, Lcom/wishabi/flipp/app/MainActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v5, "postal_code"

    invoke-interface {v0, v5, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v5

    if-eqz v0, :cond_4

    if-eqz v5, :cond_4

    const-string v0, ""

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    :cond_4
    move-object v0, v3

    :goto_4
    if-eqz v0, :cond_14

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_5
    iput-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->l:Ljava/lang/String;

    :cond_5
    const-string v0, "was_handled"

    invoke-virtual {v4, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 188
    :cond_6
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 189
    invoke-static {}, Lcom/wishabi/flipp/util/g;->b()I

    move-result v6

    .line 191
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    const-string v7, "last_flyer_fetch_time"

    const-wide/16 v8, 0x0

    invoke-interface {v0, v7, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v8

    .line 192
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    const-string v7, "last_flyer_fetch_locale"

    const-string v10, ""

    invoke-interface {v0, v7, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 193
    iget-object v7, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    const-string v10, "last_flyer_fetch_version_code"

    const/4 v11, -0x1

    invoke-interface {v7, v10, v11}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v7

    .line 195
    sub-long/2addr v4, v8

    long-to-float v4, v4

    const v5, 0x4a5bba00    # 3600000.0f

    cmpl-float v4, v4, v5

    if-gtz v4, :cond_7

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->l:Ljava/lang/String;

    if-nez v0, :cond_7

    if-eq v6, v7, :cond_8

    .line 198
    :cond_7
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->l:Ljava/lang/String;

    if-eqz v0, :cond_15

    move v0, v1

    :goto_6
    sget-object v4, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    iget v5, p0, Lcom/wishabi/flipp/app/MainActivity;->k:I

    iget-object v4, v4, Lcom/wishabi/flipp/b/u;->d:Ljava/util/HashMap;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_16

    :goto_7
    if-nez v1, :cond_8

    const-string v1, "com.wishabi.flipp.preferences"

    invoke-virtual {p0, v1, v2}, Lcom/wishabi/flipp/app/MainActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "postal_code"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    new-instance v4, Lcom/wishabi/flipp/app/dk;

    invoke-direct {v4, p0, v0, v1}, Lcom/wishabi/flipp/app/dk;-><init>(Lcom/wishabi/flipp/app/MainActivity;ZLjava/lang/String;)V

    invoke-virtual {v2, v3, v4}, Lcom/wishabi/flipp/b/u;->a(Ljava/lang/String;Lcom/wishabi/flipp/b/x;)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/MainActivity;->k:I

    .line 200
    :cond_8
    if-eq v6, v7, :cond_9

    .line 201
    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->m:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "last_flyer_fetch_version_code"

    invoke-interface {v0, v1, v6}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 205
    :cond_9
    return-void

    .line 185
    :cond_a
    const-string v0, "AllowPushDialogTag"

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/MainActivity;->b(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 186
    :cond_b
    const-string v0, "<null>"

    goto/16 :goto_2

    :cond_c
    const-string v0, "(null)"

    goto/16 :goto_3

    :cond_d
    const-string v0, "flyers"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    sget-object v0, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v5, "flyer_ids"

    invoke-virtual {v6, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_e

    const-string v5, "filter_field"

    const-string v7, "flyer_id"

    invoke-virtual {v0, v5, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v5, "filter_values"

    const-string v7, "flyer_ids"

    invoke-virtual {v6, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    :goto_8
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    goto/16 :goto_4

    :cond_e
    const-string v5, "flyer_run_ids"

    invoke-virtual {v6, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_f

    const-string v5, "filter_field"

    const-string v7, "flyer_run_id"

    invoke-virtual {v0, v5, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v5, "filter_values"

    const-string v7, "flyer_run_ids"

    invoke-virtual {v6, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_8

    :cond_f
    const-string v5, "merchant_ids"

    invoke-virtual {v6, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_10

    const-string v5, "filter_field"

    const-string v7, "merchant_id"

    invoke-virtual {v0, v5, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v5, "filter_values"

    const-string v7, "merchant_ids"

    invoke-virtual {v6, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_8

    :cond_10
    const-string v5, "flyer_type_ids"

    invoke-virtual {v6, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_11

    const-string v5, "filter_field"

    const-string v7, "flyer_type_id"

    invoke-virtual {v0, v5, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v5, "filter_values"

    const-string v7, "flyer_type_ids"

    invoke-virtual {v6, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_8

    :cond_11
    const-string v5, "categories"

    invoke-virtual {v6, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_12

    const-string v5, "filter_field"

    const-string v7, "categories"

    invoke-virtual {v0, v5, v7}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    const-string v5, "filter_values"

    const-string v7, "categories"

    invoke-virtual {v6, v7}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_8

    :cond_12
    move-object v0, v3

    goto/16 :goto_4

    :cond_13
    move-object v0, v3

    goto/16 :goto_4

    :cond_14
    move-object v0, v3

    goto/16 :goto_5

    :cond_15
    move v0, v2

    .line 198
    goto/16 :goto_6

    :cond_16
    move v1, v2

    goto/16 :goto_7

    :cond_17
    move v0, v2

    goto/16 :goto_0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 323
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/MainActivity;->isChangingConfigurations()Z

    move-result v0

    if-nez v0, :cond_0

    .line 324
    iget-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->g:Landroid/view/View;

    new-instance v2, Landroid/support/v4/widget/g;

    iget-object v0, p0, Lcom/wishabi/flipp/app/MainActivity;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/g;

    invoke-direct {v2, v0}, Landroid/support/v4/widget/g;-><init>(Landroid/support/v4/widget/g;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 327
    :cond_0
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 328
    const-string v0, "mCategoryName"

    iget-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->i:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    const-string v0, "mDeepLinkFilterUri"

    iget-object v1, p0, Lcom/wishabi/flipp/app/MainActivity;->l:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 330
    return-void
.end method
