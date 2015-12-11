.class public Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Laiq;
.implements Landroid/view/View$OnClickListener;
.implements Lcf;
.implements Lqo;
.implements Lqp;


# static fields
.field public static b:Z

.field private static final c:Ljava/lang/String;


# instance fields
.field private A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private B:Ljava/lang/String;

.field private C:Z

.field private D:Z

.field private E:I

.field private F:D

.field private G:D

.field private H:Z

.field private I:Z

.field private J:I

.field private K:Landroid/view/View;

.field private L:I

.field private M:Lqm;

.field private N:Z

.field private O:Landroid/widget/AbsListView$OnScrollListener;

.field public a:Ldp;

.field private g:Landroid/view/View;

.field private h:Landroid/widget/LinearLayout;

.field private i:Landroid/widget/RelativeLayout;

.field private j:Landroid/widget/LinearLayout;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private l:Ljz;

.field private m:Laim;

.field private n:Landroid/support/v4/view/ViewPager;

.field private o:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private p:Landroid/view/View;

.field private q:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

.field private r:Lank;

.field private s:Lnb;

.field private t:Z

.field private u:Landroid/widget/ListView;

.field private v:Lea;

.field private w:Landroid/widget/LinearLayout;

.field private x:Z

.field private y:Lec;

.field private z:Lcom/bestbuy/android/bbyobjects/BBYTextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 75
    const-class v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->c:Ljava/lang/String;

    .line 91
    const/4 v0, 0x0

    sput-boolean v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 147
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 85
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    .line 90
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->t:Z

    .line 95
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->x:Z

    .line 100
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->C:Z

    .line 101
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->D:Z

    .line 102
    iput v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    .line 107
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->I:Z

    .line 108
    iput v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->J:I

    .line 110
    const/16 v0, 0x9

    iput v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->L:I

    .line 112
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->N:Z

    .line 606
    new-instance v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;-><init>(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->O:Landroid/widget/AbsListView$OnScrollListener;

    .line 148
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;I)I
    .locals 0

    .prologue
    .line 71
    iput p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    return p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Laim;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Ljz;)Ljz;
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->l:Ljz;

    return-object p1
.end method

.method private a(DD)V
    .locals 11

    .prologue
    const/4 v10, 0x0

    .line 266
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->x:Z

    .line 267
    iput-wide p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->F:D

    .line 268
    iput-wide p3, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->G:D

    .line 269
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "IS_MAP_VIEW"

    invoke-interface {v0, v1, v10}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    .line 270
    new-instance v0, Ljz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    iget v8, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    const/16 v9, 0x32

    move-object v2, p0

    move-wide v4, p1

    move-wide v6, p3

    invoke-direct/range {v0 .. v9}, Ljz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDII)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->l:Ljz;

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->l:Ljz;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v10, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 272
    return-void
.end method

.method private a(Lank;Lcom/google/android/gms/maps/model/LatLng;)V
    .locals 10

    .prologue
    const/4 v2, 0x0

    const/4 v3, -0x1

    .line 540
    .line 541
    const-wide v4, 0x3ee4f8b588e368f1L    # 1.0E-5

    move v1, v2

    .line 542
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 543
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 544
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLatitude()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v6

    .line 545
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLongitude()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v0

    .line 546
    invoke-virtual {v6}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    iget-wide v8, p2, Lcom/google/android/gms/maps/model/LatLng;->a:D

    sub-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->abs(D)D

    move-result-wide v6

    cmpg-double v6, v6, v4

    if-gez v6, :cond_1

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    iget-wide v8, p2, Lcom/google/android/gms/maps/model/LatLng;->b:D

    sub-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->abs(D)D

    move-result-wide v6

    cmpg-double v0, v6, v4

    if-gez v0, :cond_1

    .line 552
    :goto_1
    if-eq v1, v3, :cond_0

    .line 553
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->t:Z

    .line 554
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->n:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 556
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->r:Lank;

    const v1, 0x7f0201a6

    invoke-static {v1}, Lani;->a(I)Lanh;

    move-result-object v1

    invoke-virtual {v0, v1}, Lank;->a(Lanh;)V

    .line 557
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->r:Lank;

    .line 558
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->t:Z

    .line 559
    return-void

    .line 542
    :cond_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_2
    move v1, v3

    goto :goto_1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Lank;Lcom/google/android/gms/maps/model/LatLng;)V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lank;Lcom/google/android/gms/maps/model/LatLng;)V

    return-void
.end method

.method private a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 366
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    if-nez v0, :cond_1

    .line 367
    invoke-static {p0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a(Lcom/bestbuy/android/base/BBYBaseFragment;)Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->q:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    .line 368
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 369
    const v1, 0x7f0c0107

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->q:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 370
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 375
    :goto_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->C:Z

    if-eqz v0, :cond_0

    .line 376
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->C:Z

    .line 379
    :cond_0
    return-void

    .line 372
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->q:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a()V

    .line 373
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->y:Lec;

    invoke-virtual {v0}, Lec;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z
    .locals 0

    .prologue
    .line 71
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;I)I
    .locals 0

    .prologue
    .line 71
    iput p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->J:I

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z
    .locals 1

    .prologue
    .line 71
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->t:Z

    return v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z
    .locals 0

    .prologue
    .line 71
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->x:Z

    return p1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z
    .locals 0

    .prologue
    .line 71
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->I:Z

    return p1
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->L:I

    return v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z
    .locals 1

    .prologue
    .line 71
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->N:Z

    return v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    return v0
.end method

.method private f()V
    .locals 4

    .prologue
    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 261
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b:Z

    .line 262
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->s:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->s:Lnb;

    invoke-virtual {v2}, Lnb;->z()D

    move-result-wide v2

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(DD)V

    .line 263
    return-void
.end method

.method private g()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 350
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 351
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->w:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 352
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 353
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 354
    return-void
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z
    .locals 1

    .prologue
    .line 71
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->D:Z

    return v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method private h()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 451
    sget-object v0, Llu;->ae:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 452
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 453
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 454
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 455
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->w:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 456
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g()V

    .line 463
    :cond_0
    :goto_0
    return-void

    .line 459
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->w:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 460
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    return-object v0
.end method

.method private i()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/16 v1, 0x8

    .line 466
    sget-object v0, Llu;->af:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 467
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->w:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 468
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 469
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 470
    :cond_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 471
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 472
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 473
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->x:Z

    if-eqz v0, :cond_1

    .line 474
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Ljava/util/ArrayList;)V

    .line 475
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->x:Z

    .line 485
    :cond_1
    :goto_0
    return-void

    .line 477
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 478
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 479
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 480
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 482
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 483
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Ljz;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->l:Ljz;

    return-object v0
.end method

.method private j()V
    .locals 3

    .prologue
    .line 567
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 582
    :goto_0
    return-void

    .line 570
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 571
    const-string v1, "<font face = \'Sans-Serif\'>Location providers are disabled. Please enable it from your device\'s Location settings.</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 573
    const-string v1, "<font face = \'Sans-Serif\'>OK</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$3;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$3;-><init>(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 580
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 581
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)D
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->F:D

    return-wide v0
.end method

.method private k()Z
    .locals 2

    .prologue
    .line 602
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 603
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)D
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->G:D

    return-wide v0
.end method

.method static synthetic m(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z
    .locals 1

    .prologue
    .line 71
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->I:Z

    return v0
.end method

.method static synthetic n(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->J:I

    return v0
.end method

.method static synthetic o(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/remix/StoreList;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/16 v5, 0x8

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 280
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->isHasNext()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->N:Z

    .line 281
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->B:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->B:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 282
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->B:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 283
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->B:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 284
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->B:Ljava/lang/String;

    .line 286
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 287
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 288
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "IS_MAP_VIEW"

    invoke-interface {v0, v1, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    .line 289
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    if-eqz v0, :cond_4

    .line 290
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 293
    :goto_0
    sput-boolean v4, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b:Z

    .line 294
    iget v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    if-gt v0, v3, :cond_1

    .line 295
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 296
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->u:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->K:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 298
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 308
    iget v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    if-gt v0, v3, :cond_5

    .line 309
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 310
    const v1, 0x7f0300fc

    invoke-virtual {v0, v1, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->K:Landroid/view/View;

    .line 311
    new-instance v0, Lec;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2}, Lec;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->y:Lec;

    .line 312
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->n:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->y:Lec;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 313
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->I:Z

    .line 314
    iput v4, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->J:I

    .line 315
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->u:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->K:Landroid/view/View;

    invoke-virtual {v0, v1, v6, v4}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 316
    new-instance v0, Lea;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    move v5, v4

    invoke-direct/range {v0 .. v5}, Lea;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->v:Lea;

    .line 317
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->u:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->v:Lea;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 322
    :goto_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->N:Z

    if-nez v0, :cond_2

    .line 323
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->u:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->K:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 325
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Ljava/util/ArrayList;)V

    .line 326
    sput-boolean v4, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b:Z

    .line 327
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    if-nez v0, :cond_3

    .line 328
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g()V

    .line 329
    :cond_3
    return-void

    .line 292
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 319
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->y:Lec;

    invoke-virtual {v0}, Lec;->notifyDataSetChanged()V

    .line 320
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->v:Lea;

    invoke-virtual {v0}, Lea;->notifyDataSetChanged()V

    goto :goto_1
.end method

.method public a(Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v2, 0x1

    const/4 v7, 0x0

    .line 424
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->B:Ljava/lang/String;

    .line 425
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->w:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 426
    iput v7, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    .line 427
    invoke-static {p1}, Lnr;->c(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 428
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    .line 430
    :goto_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "IS_MAP_VIEW"

    invoke-interface {v0, v1, v7}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    .line 431
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 432
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->D:Z

    .line 433
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->x:Z

    .line 434
    new-instance v0, Ljy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    iget v5, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    const/16 v6, 0x32

    move-object v2, p0

    invoke-direct/range {v0 .. v6}, Ljy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;II)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 436
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 437
    const-string v1, "bb.searchTerm"

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 438
    const-string v1, "bb.numResults"

    const-string v2, "25"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 439
    sget-object v1, Llu;->aa:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 440
    return-void

    :cond_1
    move-object v4, p1

    goto :goto_0
.end method

.method public a(Lank;)Z
    .locals 1

    .prologue
    .line 530
    sget-object v0, Llu;->ag:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 531
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->r:Lank;

    invoke-virtual {p1, v0}, Lank;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 532
    const v0, 0x7f020183

    invoke-static {v0}, Lani;->a(I)Lanh;

    move-result-object v0

    invoke-virtual {p1, v0}, Lank;->a(Lanh;)V

    .line 533
    invoke-virtual {p1}, Lank;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v0

    .line 534
    invoke-direct {p0, p1, v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lank;Lcom/google/android/gms/maps/model/LatLng;)V

    .line 536
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public b()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 397
    sget-object v0, Llu;->ah:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 398
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 399
    iput v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->E:I

    .line 400
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->C:Z

    .line 401
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->D:Z

    .line 402
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f()V

    .line 403
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "BY"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 404
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "BY"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 408
    :goto_0
    return-void

    .line 406
    :cond_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j()V

    goto :goto_0
.end method

.method public b_()V
    .locals 8

    .prologue
    .line 489
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->q:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->b()Laim;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    .line 490
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 491
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    invoke-virtual {v0}, Laim;->b()V

    .line 492
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    new-instance v1, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$2;-><init>(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)V

    invoke-virtual {v0, v1}, Laim;->a(Laip;)V

    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    invoke-virtual {v0, p0}, Laim;->a(Laiq;)V

    .line 508
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    if-eqz v0, :cond_1

    .line 509
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 510
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 512
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLatitude()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v2

    .line 513
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLongitude()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v0

    .line 514
    new-instance v3, Lcom/google/android/gms/maps/model/LatLng;

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    .line 515
    if-nez v1, :cond_0

    .line 516
    const v0, 0x7f020183

    .line 517
    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    iget v4, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->L:I

    int-to-float v4, v4

    invoke-static {v3, v4}, Lail;->a(Lcom/google/android/gms/maps/model/LatLng;F)Laik;

    move-result-object v4

    invoke-virtual {v2, v4}, Laim;->a(Laik;)V

    .line 518
    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    new-instance v4, Lcom/google/android/gms/maps/model/MarkerOptions;

    invoke-direct {v4}, Lcom/google/android/gms/maps/model/MarkerOptions;-><init>()V

    invoke-virtual {v4, v3}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lcom/google/android/gms/maps/model/LatLng;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v3

    invoke-static {v0}, Lani;->a(I)Lanh;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lanh;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v0

    invoke-virtual {v2, v0}, Laim;->a(Lcom/google/android/gms/maps/model/MarkerOptions;)Lank;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->r:Lank;

    .line 509
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 520
    :cond_0
    const v0, 0x7f0201a6

    .line 521
    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m:Laim;

    new-instance v4, Lcom/google/android/gms/maps/model/MarkerOptions;

    invoke-direct {v4}, Lcom/google/android/gms/maps/model/MarkerOptions;-><init>()V

    invoke-virtual {v4, v3}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lcom/google/android/gms/maps/model/LatLng;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v3

    invoke-static {v0}, Lani;->a(I)Lanh;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lanh;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v0

    invoke-virtual {v2, v0}, Laim;->a(Lcom/google/android/gms/maps/model/MarkerOptions;)Lank;

    goto :goto_1

    .line 526
    :cond_1
    return-void
.end method

.method public c()V
    .locals 3

    .prologue
    .line 412
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 413
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "IS_MAP_VIEW"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    .line 414
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    if-eqz v0, :cond_1

    .line 415
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h()V

    .line 420
    :cond_0
    :goto_0
    return-void

    .line 417
    :cond_1
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i()V

    goto :goto_0
.end method

.method public d()V
    .locals 2

    .prologue
    .line 275
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->u:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->K:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 276
    return-void
.end method

.method public e()V
    .locals 1

    .prologue
    .line 443
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->w:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 444
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 134
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 135
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2

    .prologue
    .line 585
    const/16 v0, 0x3e8

    if-ne p1, v0, :cond_0

    .line 586
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 587
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->C:Z

    .line 588
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 589
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f()V

    .line 594
    :cond_0
    :goto_0
    return-void

    .line 591
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 116
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 117
    new-instance v0, Lqn;

    invoke-direct {v0, p1}, Lqn;-><init>(Landroid/content/Context;)V

    sget-object v1, Lahy;->a:Lpx;

    invoke-virtual {v0, v1}, Lqn;->a(Lpx;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqo;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqp;)Lqn;

    move-result-object v0

    invoke-virtual {v0}, Lqn;->b()Lqm;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->M:Lqm;

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->M:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    .line 123
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 389
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    if-ne p1, v0, :cond_0

    .line 390
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 391
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 393
    :cond_0
    return-void
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 671
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->M:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 672
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    .line 658
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 660
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    const/16 v1, 0x2328

    invoke-virtual {p1, v0, v1}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 667
    :goto_0
    return-void

    .line 661
    :catch_0
    move-exception v0

    .line 662
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 665
    :cond_0
    sget-object v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->c:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services connection failed with code "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lpp;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onConnectionSuspended(I)V
    .locals 3

    .prologue
    .line 676
    sget-object v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->c:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services suspended cause:  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 677
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 127
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    check-cast v0, Ldp;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a:Ldp;

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnActionIconClickListener(Lcf;)V

    .line 130
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    if-nez v0, :cond_1

    .line 153
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->s:Lnb;

    .line 154
    const v0, 0x7f0300ff

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c0106

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->u:Landroid/widget/ListView;

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c03c9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h:Landroid/widget/LinearLayout;

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c0036

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c03cc

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j:Landroid/widget/LinearLayout;

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c0034

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->w:Landroid/widget/LinearLayout;

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c03ca

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c03cd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c0037

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    const v1, 0x7f0c03cb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->n:Landroid/support/v4/view/ViewPager;

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->n:Landroid/support/v4/view/ViewPager;

    const/16 v1, 0x23

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setPageMargin(I)V

    .line 167
    new-instance v0, Lec;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2}, Lec;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->y:Lec;

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->n:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->y:Lec;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->u:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->O:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 170
    new-instance v0, Lea;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o:Ljava/util/ArrayList;

    move v5, v4

    invoke-direct/range {v0 .. v5}, Lea;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->v:Lea;

    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->u:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->v:Lea;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 172
    invoke-static {p0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a(Lcom/bestbuy/android/base/BBYBaseFragment;)Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->q:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    .line 173
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 174
    const v1, 0x7f0c0107

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->q:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 175
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 176
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 179
    sput-boolean v3, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b:Z

    .line 187
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a:Ldp;

    invoke-interface {v0}, Ldp;->onStoresFramentLaunch()V

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->n:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;-><init>(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 234
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    return-object v0

    .line 181
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0

    .line 185
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->p:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 4

    .prologue
    .line 249
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchAndQueryVisibility(Landroid/app/Activity;ZLjava/lang/String;)V

    .line 251
    return-void
.end method

.method public onDestroyView()V
    .locals 4

    .prologue
    .line 239
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroyView()V

    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a:Ldp;

    invoke-interface {v0}, Ldp;->onStoresFramentExit()V

    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->M:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 242
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->M:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    .line 244
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchAndQueryVisibility(Landroid/app/Activity;ZLjava/lang/String;)V

    .line 245
    return-void
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 640
    if-eqz p1, :cond_0

    .line 641
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->s:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->a(D)V

    .line 642
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->s:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->b(D)V

    .line 644
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->M:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 645
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->M:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 647
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 648
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->H:Z

    if-eqz v0, :cond_1

    .line 649
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 653
    :goto_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f()V

    .line 654
    return-void

    .line 651
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 139
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 140
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k()Z

    move-result v0

    if-nez v0, :cond_0

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Stores"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 145
    return-void
.end method

.method public onStop()V
    .locals 4

    .prologue
    .line 255
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onStop()V

    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchAndQueryVisibility(Landroid/app/Activity;ZLjava/lang/String;)V

    .line 257
    return-void
.end method
