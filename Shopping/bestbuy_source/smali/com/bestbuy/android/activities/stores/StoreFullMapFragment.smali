.class public Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Laiq;


# instance fields
.field private a:Landroid/view/View;

.field private b:Laim;

.field private c:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

.field private g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/remix/Store;",
            ">;"
        }
    .end annotation
.end field

.field private h:Lank;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->g:Ljava/util/ArrayList;

    return-void
.end method

.method private b()V
    .locals 3

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->b:Laim;

    if-nez v0, :cond_0

    .line 53
    invoke-static {p0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a(Lcom/bestbuy/android/base/BBYBaseFragment;)Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->c:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    .line 54
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 56
    const v1, 0x7f0c0107

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->c:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 57
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 59
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Lank;)Z
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->h:Lank;

    invoke-virtual {p1, v0}, Lank;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 88
    const v0, 0x7f020183

    invoke-static {v0}, Lani;->a(I)Lanh;

    move-result-object v0

    invoke-virtual {p1, v0}, Lank;->a(Lanh;)V

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->h:Lank;

    const v1, 0x7f0201a6

    invoke-static {v1}, Lani;->a(I)Lanh;

    move-result-object v1

    invoke-virtual {v0, v1}, Lank;->a(Lanh;)V

    .line 90
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->h:Lank;

    .line 92
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public b_()V
    .locals 8

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->c:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->b()Laim;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->b:Laim;

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->b:Laim;

    invoke-virtual {v0, p0}, Laim;->a(Laiq;)V

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->b:Laim;

    if-eqz v0, :cond_1

    .line 66
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    const/16 v0, 0xa

    if-ge v1, v0, :cond_1

    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->g:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/remix/Store;

    .line 69
    new-instance v2, Lcom/google/android/gms/maps/model/LatLng;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getLat()D

    move-result-wide v4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getLng()D

    move-result-wide v6

    invoke-direct {v2, v4, v5, v6, v7}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    .line 70
    if-nez v1, :cond_0

    .line 71
    const v0, 0x7f020183

    .line 72
    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->b:Laim;

    const/high16 v4, 0x41200000    # 10.0f

    invoke-static {v2, v4}, Lail;->a(Lcom/google/android/gms/maps/model/LatLng;F)Laik;

    move-result-object v4

    invoke-virtual {v3, v4}, Laim;->a(Laik;)V

    .line 74
    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->b:Laim;

    new-instance v4, Lcom/google/android/gms/maps/model/MarkerOptions;

    invoke-direct {v4}, Lcom/google/android/gms/maps/model/MarkerOptions;-><init>()V

    invoke-virtual {v4, v2}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lcom/google/android/gms/maps/model/LatLng;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v2

    invoke-static {v0}, Lani;->a(I)Lanh;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lanh;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v0

    invoke-virtual {v3, v0}, Laim;->a(Lcom/google/android/gms/maps/model/MarkerOptions;)Lank;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->h:Lank;

    .line 66
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 77
    :cond_0
    const v0, 0x7f0201a6

    .line 78
    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->b:Laim;

    new-instance v4, Lcom/google/android/gms/maps/model/MarkerOptions;

    invoke-direct {v4}, Lcom/google/android/gms/maps/model/MarkerOptions;-><init>()V

    invoke-virtual {v4, v2}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lcom/google/android/gms/maps/model/LatLng;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v2

    invoke-static {v0}, Lani;->a(I)Lanh;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lanh;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v0

    invoke-virtual {v3, v0}, Laim;->a(Lcom/google/android/gms/maps/model/MarkerOptions;)Lank;

    goto :goto_1

    .line 83
    :cond_1
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 33
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 34
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 39
    const v0, 0x7f0300fb

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->a:Landroid/view/View;

    .line 41
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "STORE_LIST"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->g:Ljava/util/ArrayList;

    .line 42
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->b()V

    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreFullMapFragment;->a:Landroid/view/View;

    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 48
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroyView()V

    .line 49
    return-void
.end method
