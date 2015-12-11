.class public Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Landroid/view/View$OnClickListener;
.implements Lqo;
.implements Lqp;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private c:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Landroid/widget/LinearLayout;

.field private i:Landroid/widget/LinearLayout;

.field private j:Landroid/widget/LinearLayout;

.field private k:Landroid/widget/LinearLayout;

.field private l:Landroid/widget/EditText;

.field private m:Landroid/widget/ListView;

.field private n:Ldq;

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

.field private p:Ljava/lang/String;

.field private q:Landroid/widget/LinearLayout;

.field private r:Z

.field private s:Landroid/widget/LinearLayout;

.field private t:Landroid/widget/LinearLayout;

.field private u:Landroid/widget/LinearLayout;

.field private v:Landroid/widget/RelativeLayout;

.field private w:Landroid/widget/FrameLayout;

.field private x:Lqm;

.field private y:Landroid/widget/LinearLayout;

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 68
    const-class v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 92
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->o:Ljava/util/ArrayList;

    .line 82
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->r:Z

    .line 90
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->z:Z

    .line 94
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 1

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->o:Ljava/util/ArrayList;

    .line 82
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->r:Z

    .line 90
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->z:Z

    .line 97
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 98
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->l:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->k:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method private d()Z
    .locals 2

    .prologue
    .line 349
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 350
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->m:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/Double;Ljava/lang/Double;)V
    .locals 9

    .prologue
    .line 354
    new-instance v0, Lij;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const/4 v3, 0x0

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-virtual {p2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v8

    move-object v2, p0

    invoke-direct/range {v0 .. v8}, Lij;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDLjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lij;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 355
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 299
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b(Ljava/lang/String;)V

    .line 300
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 5
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
    const/16 v4, 0x8

    const/4 v2, 0x0

    .line 303
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 304
    if-eqz p1, :cond_2

    move v1, v2

    .line 305
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 306
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 307
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 308
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 309
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;->getPickupMessage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Pickup;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;->getPickupMessage()Ljava/lang/String;

    move-result-object v0

    const-string v3, "Unavailable"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 311
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 305
    :cond_0
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_0

    .line 314
    :cond_1
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getInStoreOnly()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getInStoreOnly()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 315
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getInStoreOnly()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;->getPickupMessage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/SKUAvailability;->getSku()Lcom/bestbuy/android/api/lib/models/store/Sku;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Sku;->getAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/Availability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/Availability;->getInStoreOnly()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreOnly;->getInStoreAvailability()Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/availability/InStoreAvailability;->getPickupMessage()Ljava/lang/String;

    move-result-object v0

    const-string v3, "Unavailable"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 317
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 325
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->n:Ldq;

    invoke-virtual {v0}, Ldq;->notifyDataSetChanged()V

    .line 326
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 327
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 330
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 331
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 332
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 334
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->o:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-eqz v0, :cond_5

    .line 335
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->m:Landroid/widget/ListView;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 336
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->z:Z

    .line 346
    :cond_4
    :goto_2
    return-void

    .line 338
    :cond_5
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->z:Z

    .line 339
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->m:Landroid/widget/ListView;

    invoke-virtual {v0, v4}, Landroid/widget/ListView;->setVisibility(I)V

    .line 340
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->z:Z

    if-eqz v0, :cond_4

    .line 341
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->z:Z

    .line 342
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->u:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0083

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "We could not find any results for Current Location. Please try another."

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 343
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->u:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    goto :goto_2
.end method

.method public b()V
    .locals 2

    .prologue
    .line 384
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->w:Landroid/widget/FrameLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 385
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->s:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 386
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 358
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->u:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0083

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "We could not find any results for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". Please try another."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 359
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->u:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 360
    return-void
.end method

.method public c()V
    .locals 4

    .prologue
    .line 478
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    .line 479
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 480
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 481
    const-string v2, "<font face = \'Sans-Serif\'> <small>You will be redirected to BestBuy.com to complete your transaction. Do you want to continue?</small> </font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 483
    const-string v2, "<font face = \'Sans-Serif\'> <b>Yes</b> </font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$3;

    invoke-direct {v3, p0, v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 491
    const-string v0, "<font face = \'Sans-Serif\'>No</font>"

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$4;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$4;-><init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)V

    invoke-virtual {v1, v0, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 497
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 498
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 499
    return-void
.end method

.method public c(Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 363
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->w:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v6}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 364
    new-instance v0, Lin;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    move-object v2, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lin;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    new-array v1, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lin;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 365
    return-void
.end method

.method public d(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 389
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->w:Landroid/widget/FrameLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 390
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 391
    :cond_0
    const v0, 0x7f08009e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 392
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->t:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0339

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 393
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->t:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 394
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 125
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Product Availability"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 129
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    const-wide/16 v4, 0x0

    .line 102
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 103
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    move-object v0, p1

    .line 104
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 105
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 109
    :cond_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    .line 111
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    invoke-virtual {v1}, Lnb;->z()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    .line 112
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    cmpl-double v0, v2, v4

    if-eqz v0, :cond_1

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    cmpl-double v0, v0, v4

    if-nez v0, :cond_2

    .line 113
    :cond_1
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

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->x:Lqm;

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->x:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    .line 121
    :cond_2
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 399
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_2

    .line 400
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v0, :cond_1

    .line 401
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    .line 402
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->a_()V

    .line 433
    :cond_0
    :goto_0
    return-void

    .line 404
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_0

    .line 405
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    .line 406
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->d()V

    goto :goto_0

    .line 408
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->s:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_3

    .line 410
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_0

    .line 411
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 412
    const v1, 0x7f0c0033

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 413
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_0

    .line 414
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 415
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    goto :goto_0

    .line 418
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->y:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    goto :goto_0
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 463
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->x:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 464
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    .line 450
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 452
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const/16 v1, 0x2328

    invoke-virtual {p1, v0, v1}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 459
    :goto_0
    return-void

    .line 453
    :catch_0
    move-exception v0

    .line 454
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 457
    :cond_0
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a:Ljava/lang/String;

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
    .line 468
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a:Ljava/lang/String;

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

    .line 469
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9

    .prologue
    .line 133
    const v0, 0x7f0300cc

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c032e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0330

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->y:Landroid/widget/LinearLayout;

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c006c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->q:Landroid/widget/LinearLayout;

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0332

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0334

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0036

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->k:Landroid/widget/LinearLayout;

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0106

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->m:Landroid/widget/ListView;

    .line 141
    new-instance v0, Ldq;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->o:Ljava/util/ArrayList;

    const/4 v3, 0x0

    const/4 v4, 0x1

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-object v5, p0

    invoke-direct/range {v0 .. v6}, Ldq;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;ZZLcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->n:Ldq;

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->m:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->n:Ldq;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0080

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->s:Landroid/widget/LinearLayout;

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0082

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->u:Landroid/widget/LinearLayout;

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0338

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->t:Landroid/widget/LinearLayout;

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->s:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c032d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->v:Landroid/widget/RelativeLayout;

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->w:Landroid/widget/FrameLayout;

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->w:Landroid/widget/FrameLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setBackgroundColor(I)V

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->y:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    const v1, 0x7f0c022b

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 154
    const/4 v1, 0x0

    .line 155
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 156
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 157
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 159
    :cond_0
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    const v2, 0x7f080068

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 160
    :cond_1
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getBackImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 161
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getBackImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 164
    :cond_2
    if-eqz v1, :cond_5

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5

    const v2, 0x7f080068

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 165
    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 170
    :cond_3
    :goto_0
    if-eqz v1, :cond_6

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_6

    const v2, 0x7f080068

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 171
    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 177
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->p:Ljava/lang/String;

    .line 180
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->h:Landroid/widget/LinearLayout;

    const v1, 0x7f0c032f

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 181
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->p:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->y:Landroid/widget/LinearLayout;

    const v1, 0x7f0c00cb

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    .line 184
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->y:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0331

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 185
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v2, :cond_8

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    if-eqz v2, :cond_8

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    if-eqz v2, :cond_8

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmpl-double v2, v2, v4

    if-eqz v2, :cond_8

    .line 186
    const/4 v2, 0x5

    invoke-virtual {v0, v2}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 187
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v2

    double-to-float v2, v2

    invoke-virtual {v0, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    .line 189
    const/4 v2, 0x1

    if-ne v0, v2, :cond_7

    .line 190
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const v3, 0x7f0802df

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 198
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->z()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    .line 200
    if-eqz v2, :cond_9

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    const-wide/16 v4, 0x0

    cmpl-double v0, v0, v4

    if-eqz v0, :cond_9

    if-eqz v6, :cond_9

    invoke-virtual {v6}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    const-wide/16 v4, 0x0

    cmpl-double v0, v0, v4

    if-eqz v0, :cond_9

    .line 201
    new-instance v0, Lij;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-virtual {v6}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v8

    move-object v2, p0

    invoke-direct/range {v0 .. v8}, Lij;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDLjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lij;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0335

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 204
    const-string v1, "Results for \"Current Location\" "

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0336

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 206
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 229
    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0333

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->l:Landroid/widget/EditText;

    .line 230
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->l:Landroid/widget/EditText;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 277
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->g:Landroid/view/View;

    return-object v0

    .line 167
    :cond_5
    const v2, 0x7f020130

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 173
    :cond_6
    const v1, 0x7f020130

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 192
    :cond_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const v3, 0x7f0802e0

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 195
    :cond_8
    const v0, -0x777778

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const v2, 0x7f080394

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 223
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->i:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 224
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->j:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->k:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->m:Landroid/widget/ListView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    goto/16 :goto_3
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 282
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 283
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 284
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 285
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 287
    :cond_0
    return-void
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 291
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroyView()V

    .line 292
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->x:Lqm;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->x:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->x:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    .line 295
    :cond_0
    return-void
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 9

    .prologue
    .line 437
    if-eqz p1, :cond_0

    .line 438
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->a(D)V

    .line 439
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->b(D)V

    .line 441
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->x:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 442
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->x:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 444
    :cond_0
    new-instance v0, Lij;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->y()D

    move-result-wide v4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->z()D

    move-result-wide v6

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v8

    move-object v2, p0

    invoke-direct/range {v0 .. v8}, Lij;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDLjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lij;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 446
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 473
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 474
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Product Availability"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 475
    return-void
.end method
