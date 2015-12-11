.class public Lcom/wishabi/flipp/app/FavoritesFragment;
.super Landroid/app/Fragment;
.source "SourceFile"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Luk/co/senab/actionbarpulltorefresh/library/a/b;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Fragment;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Luk/co/senab/actionbarpulltorefresh/library/a/b;"
    }
.end annotation


# static fields
.field private static final m:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private static final n:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private a:I

.field private b:Lcom/wishabi/flipp/widget/CollectionView;

.field private c:Landroid/view/View;

.field private d:Lcom/wishabi/flipp/widget/ZeroCaseView;

.field private e:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

.field private final f:Landroid/util/SparseBooleanArray;

.field private g:Lcom/wishabi/flipp/widget/bw;

.field private h:Lcom/wishabi/flipp/widget/bc;

.field private i:Landroid/database/Cursor;

.field private j:Landroid/content/SharedPreferences;

.field private k:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

.field private final l:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/h;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/wishabi/flipp/app/FavoritesFragment;->m:Ljava/util/HashMap;

    .line 75
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/wishabi/flipp/app/FavoritesFragment;->n:Ljava/util/HashSet;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 57
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->f:Landroid/util/SparseBooleanArray;

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->l:Ljava/util/List;

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/FavoritesFragment;)Lcom/wishabi/flipp/widget/CollectionView;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    return-object v0
.end method

.method private a(Ljava/util/List;I)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/content/h;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 546
    sget-object v0, Lcom/wishabi/flipp/app/FavoritesFragment;->m:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 547
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->l:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 549
    :cond_0
    const/4 v1, 0x0

    .line 552
    sget-object v0, Lcom/wishabi/flipp/app/FavoritesFragment;->m:Ljava/util/HashMap;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 553
    if-eqz v0, :cond_3

    .line 554
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {p1, v0, v1}, Lcom/wishabi/flipp/content/h;->a(Ljava/util/List;J)Lcom/wishabi/flipp/content/h;

    move-result-object v0

    .line 557
    :goto_0
    if-nez v0, :cond_1

    .line 558
    invoke-static {p1}, Lcom/wishabi/flipp/content/h;->a(Ljava/util/List;)Lcom/wishabi/flipp/content/h;

    move-result-object v0

    .line 561
    :cond_1
    if-eqz v0, :cond_2

    .line 562
    iget-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->l:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 563
    sget-object v1, Lcom/wishabi/flipp/app/FavoritesFragment;->m:Ljava/util/HashMap;

    iget v2, v0, Lcom/wishabi/flipp/content/h;->b:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-wide v4, v0, Lcom/wishabi/flipp/content/h;->a:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 566
    :cond_2
    return-void

    :cond_3
    move-object v0, v1

    goto :goto_0
.end method

.method public static b()V
    .locals 1

    .prologue
    .line 78
    sget-object v0, Lcom/wishabi/flipp/app/FavoritesFragment;->m:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 79
    sget-object v0, Lcom/wishabi/flipp/app/FavoritesFragment;->n:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 80
    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/FavoritesFragment;)V
    .locals 8

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getActiveViews()Landroid/util/SparseArray;

    move-result-object v3

    invoke-virtual {v3}, Landroid/util/SparseArray;->size()I

    move-result v4

    const/4 v0, 0x0

    move v2, v0

    :goto_0
    if-ge v2, v4, :cond_1

    invoke-virtual {v3, v2}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v1

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/bw;->e(I)I

    move-result v0

    sget v5, Lcom/wishabi/flipp/widget/ca;->b:I

    if-ne v0, v5, :cond_0

    invoke-virtual {v3, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ba;

    iget-object v5, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    invoke-virtual {v5, v1}, Lcom/wishabi/flipp/widget/bw;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/database/Cursor;

    if-eqz v1, :cond_0

    const-string v5, "flyer_id"

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    if-ltz v5, :cond_0

    invoke-interface {v1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    sget-object v6, Lcom/wishabi/flipp/app/FavoritesFragment;->n:Ljava/util/HashSet;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ba;->getPercentVisibility()F

    move-result v6

    const/high16 v7, 0x42480000    # 50.0f

    cmpl-float v6, v6, v7

    if-lez v6, :cond_0

    sget-object v6, Lcom/wishabi/flipp/app/FavoritesFragment;->n:Ljava/util/HashSet;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    new-instance v5, Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {v5, v1}, Lcom/wishabi/flipp/content/Flyer$Model;-><init>(Landroid/database/Cursor;)V

    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v6, "Favorites"

    sget-object v7, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v6, v7}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ba;->getFeaturedItem()Lcom/wishabi/flipp/content/h;

    move-result-object v0

    invoke-virtual {v1, v5, v6, v0}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Ljava/lang/String;Lcom/wishabi/flipp/content/h;)V

    :cond_0
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    :cond_1
    return-void
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/FavoritesFragment;)Lcom/wishabi/flipp/widget/bw;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    return-object v0
.end method

.method private c()V
    .locals 4

    .prologue
    .line 279
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "favorites"

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 280
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 281
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v2, "favorites"

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/cz;->d:Landroid/database/Cursor;

    invoke-virtual {v1, v2, v3, v0}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Landroid/database/Cursor;)V

    .line 285
    :goto_0
    return-void

    .line 284
    :cond_0
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "favorites"

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->b(Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/FavoritesFragment;)I
    .locals 1

    .prologue
    .line 50
    iget v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->a:I

    return v0
.end method

.method private d()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 496
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 497
    if-nez v0, :cond_1

    .line 521
    :cond_0
    :goto_0
    return-void

    .line 500
    :cond_1
    invoke-static {v2}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 501
    if-eqz v0, :cond_0

    .line 504
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->e:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;->setRefreshing(Z)V

    .line 506
    sget-object v0, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    new-instance v1, Lcom/wishabi/flipp/app/an;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/an;-><init>(Lcom/wishabi/flipp/app/FavoritesFragment;)V

    invoke-virtual {v0, v2, v1}, Lcom/wishabi/flipp/b/u;->a(Ljava/lang/String;Lcom/wishabi/flipp/b/x;)I

    goto :goto_0
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/FavoritesFragment;)Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->e:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    return-object v0
.end method


# virtual methods
.method public final a()V
    .locals 0

    .prologue
    .line 539
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->d()V

    .line 540
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 84
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 86
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 87
    if-nez v0, :cond_1

    .line 114
    :cond_0
    :goto_0
    return-void

    .line 90
    :cond_1
    const-string v1, "com.wishabi.flipp.preferences"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->j:Landroid/content/SharedPreferences;

    .line 92
    new-instance v1, Lcom/wishabi/flipp/app/ah;

    invoke-direct {v1, p0, v0}, Lcom/wishabi/flipp/app/ah;-><init>(Lcom/wishabi/flipp/app/FavoritesFragment;Landroid/app/Activity;)V

    iput-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->k:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 108
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->j:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->k:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 112
    if-nez p1, :cond_0

    .line 113
    invoke-static {}, Lcom/wishabi/flipp/app/FavoritesFragment;->b()V

    goto :goto_0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 7
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
    const/4 v3, 0x0

    .line 289
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 290
    if-nez v1, :cond_0

    move-object v0, v3

    .line 308
    :goto_0
    return-object v0

    .line 293
    :cond_0
    packed-switch p1, :pswitch_data_0

    move-object v0, v3

    .line 308
    goto :goto_0

    .line 295
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->f:Landroid/net/Uri;

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 298
    :pswitch_1
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    const-string v4, "merchant_clause"

    invoke-virtual {p2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "merchant_args"

    invoke-virtual {p2, v5}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 302
    :pswitch_2
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->h:Landroid/net/Uri;

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 305
    :pswitch_3
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->e:Landroid/net/Uri;

    const-string v6, "flyer_id ASC"

    move-object v4, v3

    move-object v5, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 293
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 467
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    .line 468
    if-nez v2, :cond_1

    .line 493
    :cond_0
    :goto_0
    return-void

    .line 471
    :cond_1
    const v0, 0x7f100004

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 473
    const v0, 0x7f0b0155

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 474
    if-eqz v0, :cond_0

    .line 477
    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/SearchView;

    .line 478
    if-eqz v0, :cond_0

    .line 481
    const-string v1, "search"

    invoke-virtual {v2, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/SearchManager;

    .line 483
    invoke-virtual {v2}, Landroid/app/Activity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/SearchManager;->getSearchableInfo(Landroid/content/ComponentName;)Landroid/app/SearchableInfo;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/SearchView;->setSearchableInfo(Landroid/app/SearchableInfo;)V

    .line 485
    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/SearchView;->setIconifiedByDefault(Z)V

    .line 486
    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/SearchView;->setClearAfterQuery(Z)V

    .line 488
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 489
    const-string v2, "search_mode"

    sget v3, Lcom/wishabi/flipp/app/en;->a:I

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 491
    const-string v2, "com.wishabi.flipp.search_bundle"

    invoke-virtual {v0, v2, v1}, Lcom/wishabi/flipp/widget/SearchView;->setSearchExtraData(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v5, 0x1

    const/4 v6, 0x0

    const/4 v1, 0x0

    .line 131
    invoke-super {p0, p1, p2, p3}, Landroid/app/Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 133
    invoke-virtual {p0, v5}, Lcom/wishabi/flipp/app/FavoritesFragment;->setHasOptionsMenu(Z)V

    .line 135
    const v0, 0x7f030024

    invoke-virtual {p1, v0, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 137
    if-nez v2, :cond_0

    move-object v0, v1

    .line 260
    :goto_0
    return-object v0

    .line 140
    :cond_0
    const v0, 0x7f0b003e

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ZeroCaseView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->d:Lcom/wishabi/flipp/widget/ZeroCaseView;

    .line 142
    const v0, 0x7f0b0096

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->c:Landroid/view/View;

    .line 144
    const v0, 0x7f0b003f

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/CollectionView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    .line 146
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    if-nez v0, :cond_1

    move-object v0, v2

    .line 147
    goto :goto_0

    .line 149
    :cond_1
    const v0, 0x7f0b0095

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->e:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    .line 151
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Luk/co/senab/actionbarpulltorefresh/library/a;->a(Landroid/app/Activity;)Luk/co/senab/actionbarpulltorefresh/library/b;

    move-result-object v0

    new-array v3, v7, [Landroid/view/View;

    iget-object v4, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->c:Landroid/view/View;

    aput-object v4, v3, v5

    invoke-virtual {v0, v3}, Luk/co/senab/actionbarpulltorefresh/library/b;->a([Landroid/view/View;)Luk/co/senab/actionbarpulltorefresh/library/b;

    move-result-object v0

    iput-object p0, v0, Luk/co/senab/actionbarpulltorefresh/library/b;->b:Luk/co/senab/actionbarpulltorefresh/library/a/b;

    iget-object v3, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->e:Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;

    invoke-virtual {v0, v3}, Luk/co/senab/actionbarpulltorefresh/library/b;->a(Luk/co/senab/actionbarpulltorefresh/library/PullToRefreshLayout;)V

    .line 156
    new-instance v0, Lcom/wishabi/flipp/widget/eg;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-direct {v0, v3}, Lcom/wishabi/flipp/widget/eg;-><init>(Landroid/content/Context;)V

    .line 157
    new-instance v3, Lcom/wishabi/flipp/widget/ax;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    iget-object v5, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-direct {v3, v4, v5}, Lcom/wishabi/flipp/widget/ax;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/widget/CollectionView;)V

    iput-object v3, v0, Lcom/wishabi/flipp/widget/eg;->b:Lcom/wishabi/flipp/widget/eh;

    .line 158
    iget-object v3, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v3, v0}, Lcom/wishabi/flipp/widget/CollectionView;->setLayout(Lcom/wishabi/flipp/widget/n;)V

    .line 160
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    new-instance v3, Lcom/wishabi/flipp/app/ai;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/app/ai;-><init>(Lcom/wishabi/flipp/app/FavoritesFragment;)V

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/CollectionView;->setOnItemClickListener(Lcom/wishabi/flipp/widget/r;)V

    .line 185
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    new-instance v3, Lcom/wishabi/flipp/app/aj;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/app/aj;-><init>(Lcom/wishabi/flipp/app/FavoritesFragment;)V

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/CollectionView;->setOnScrollListener(Lcom/wishabi/flipp/widget/t;)V

    .line 193
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    new-instance v3, Lcom/wishabi/flipp/app/ak;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/app/ak;-><init>(Lcom/wishabi/flipp/app/FavoritesFragment;)V

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/CollectionView;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 203
    new-instance v0, Lcom/wishabi/flipp/app/al;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/al;-><init>(Lcom/wishabi/flipp/app/FavoritesFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->h:Lcom/wishabi/flipp/widget/bc;

    .line 253
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 254
    if-eqz v0, :cond_2

    .line 255
    invoke-virtual {v0, v6, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 256
    invoke-virtual {v0, v7, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 257
    const/4 v3, 0x3

    invoke-virtual {v0, v3, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_2
    move-object v0, v2

    .line 260
    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 118
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 120
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->k:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    if-eqz v0, :cond_0

    .line 121
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->j:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->k:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->unregisterOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 123
    iput-object v2, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->k:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 124
    iput-object v2, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->j:Landroid/content/SharedPreferences;

    .line 126
    :cond_0
    return-void
.end method

.method public onHiddenChanged(Z)V
    .locals 0

    .prologue
    .line 265
    invoke-super {p0, p1}, Landroid/app/Fragment;->onHiddenChanged(Z)V

    .line 266
    if-nez p1, :cond_0

    .line 267
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->c()V

    .line 268
    :cond_0
    return-void
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 10

    .prologue
    const v7, 0x7f0200d5

    const/4 v8, 0x0

    const/4 v2, 0x1

    .line 50
    move-object v3, p2

    check-cast v3, Landroid/database/Cursor;

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->i:Landroid/database/Cursor;

    if-eq v0, v3, :cond_0

    iput-object v3, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->i:Landroid/database/Cursor;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v4

    if-eqz v4, :cond_0

    if-eqz v3, :cond_0

    invoke-interface {v3}, Landroid/database/Cursor;->getCount()I

    move-result v0

    new-array v5, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_1

    :goto_1
    add-int/lit8 v1, v0, 0x1

    const-string v6, "_id"

    invoke-interface {v3, v6}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v3, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v0

    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_8

    :cond_1
    array-length v0, v5

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->d:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v0, v7}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->d:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v1, 0x7f0e00ea

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->d:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v1, 0x7f0e00eb

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setEmptyView(Landroid/view/View;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0, v8}, Lcom/wishabi/flipp/widget/CollectionView;->setAdapter(Landroid/widget/ListAdapter;)V

    invoke-virtual {v4, v2}, Landroid/app/LoaderManager;->destroyLoader(I)V

    goto :goto_0

    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    array-length v0, v5

    add-int/lit8 v0, v0, -0x1

    mul-int/lit8 v0, v0, 0x2

    add-int/lit8 v0, v0, 0xf

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v0, "merchant_id in (?"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move v0, v2

    :goto_2
    array-length v6, v5

    if-ge v0, v6, :cond_3

    const-string v6, ",?"

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_3
    const-string v0, ")"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {v3}, Landroid/database/Cursor;->getCount()I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->a:I

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v3, "merchant_clause"

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "merchant_args"

    invoke-virtual {v0, v1, v5}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    invoke-virtual {v4, v2, v0, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto/16 :goto_0

    :pswitch_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->d:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v0, v7}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->d:Lcom/wishabi/flipp/widget/ZeroCaseView;

    const v1, 0x7f0e00ec

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->d:Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v0, v8}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setEmptyView(Landroid/view/View;)V

    new-instance v0, Lcom/wishabi/flipp/app/am;

    iget-object v4, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->f:Landroid/util/SparseBooleanArray;

    iget-object v5, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->l:Ljava/util/List;

    sget-object v6, Lcom/wishabi/flipp/widget/cb;->a:Lcom/wishabi/flipp/widget/cb;

    iget-object v7, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->h:Lcom/wishabi/flipp/widget/bc;

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/wishabi/flipp/app/am;-><init>(Lcom/wishabi/flipp/app/FavoritesFragment;Landroid/content/Context;Landroid/database/Cursor;Landroid/util/SparseBooleanArray;Ljava/util/List;Lcom/wishabi/flipp/widget/cb;Lcom/wishabi/flipp/widget/bc;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    iget-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setAdapter(Landroid/widget/ListAdapter;)V

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_4

    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    const-string v1, "favorites"

    invoke-virtual {v0, v1, v8, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Ljava/lang/String;Landroid/database/Cursor;)V

    :cond_4
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v1, 0x3

    invoke-virtual {v0, v1, v8, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto/16 :goto_0

    :pswitch_2
    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_3
    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->f:Landroid/util/SparseBooleanArray;

    const-string v1, "_id"

    invoke-interface {v3, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v3, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-virtual {v0, v1, v2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_3

    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bw;->notifyDataSetChanged()V

    goto/16 :goto_0

    :pswitch_3
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    const/4 v1, -0x1

    invoke-interface {v3}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    move v9, v0

    move v0, v1

    move v1, v9

    :goto_4
    if-eqz v1, :cond_7

    new-instance v1, Lcom/wishabi/flipp/content/h;

    invoke-direct {v1, v3}, Lcom/wishabi/flipp/content/h;-><init>(Landroid/database/Cursor;)V

    iget v4, v1, Lcom/wishabi/flipp/content/h;->b:I

    if-eq v0, v4, :cond_6

    invoke-direct {p0, v2, v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->a(Ljava/util/List;I)V

    invoke-interface {v2}, Ljava/util/List;->clear()V

    iget v0, v1, Lcom/wishabi/flipp/content/h;->b:I

    :cond_6
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    goto :goto_4

    :cond_7
    invoke-direct {p0, v2, v0}, Lcom/wishabi/flipp/app/FavoritesFragment;->a(Ljava/util/List;I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bw;->notifyDataSetChanged()V

    goto/16 :goto_0

    :cond_8
    move v0, v1

    goto/16 :goto_1

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

    .line 448
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 458
    :goto_0
    return-void

    .line 450
    :pswitch_0
    iput-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->i:Landroid/database/Cursor;

    goto :goto_0

    .line 453
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->f:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    goto :goto_0

    .line 456
    :pswitch_2
    iput-object v1, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->g:Lcom/wishabi/flipp/widget/bw;

    .line 457
    iget-object v0, p0, Lcom/wishabi/flipp/app/FavoritesFragment;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_0

    .line 448
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 525
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 526
    if-nez v0, :cond_0

    .line 527
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    .line 534
    :goto_0
    return v0

    .line 529
    :cond_0
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v1, 0x7f0b0157

    if-ne v0, v1, :cond_1

    .line 530
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->d()V

    .line 531
    const/4 v0, 0x1

    goto :goto_0

    .line 534
    :cond_1
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 272
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 274
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->isHidden()Z

    move-result v0

    if-nez v0, :cond_0

    .line 275
    invoke-direct {p0}, Lcom/wishabi/flipp/app/FavoritesFragment;->c()V

    .line 276
    :cond_0
    return-void
.end method
