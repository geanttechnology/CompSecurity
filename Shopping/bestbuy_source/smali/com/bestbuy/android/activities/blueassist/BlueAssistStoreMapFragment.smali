.class public Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Laio;
.implements Laiq;


# instance fields
.field private a:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

.field private b:Laim;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field

.field private g:Lank;

.field private h:I

.field private i:Landroid/app/Activity;

.field private j:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/google/android/gms/maps/model/LatLng;",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    .line 36
    const/16 v0, 0x9

    iput v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->h:I

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->j:Ljava/util/Map;

    .line 41
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;)V
    .locals 1
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
    .line 43
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    .line 36
    const/16 v0, 0x9

    iput v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->h:I

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->j:Ljava/util/Map;

    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 45
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;Lank;)Landroid/view/View;
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c(Lank;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private a(Lank;Lcom/google/android/gms/maps/model/LatLng;)V
    .locals 8

    .prologue
    .line 148
    const-wide v2, 0x3ee4f8b588e368f1L    # 1.0E-5

    .line 149
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 151
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLatitude()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v4

    .line 152
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLongitude()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v0

    .line 153
    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    iget-wide v6, p2, Lcom/google/android/gms/maps/model/LatLng;->a:D

    sub-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(D)D

    move-result-wide v4

    cmpg-double v4, v4, v2

    if-gez v4, :cond_1

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    iget-wide v6, p2, Lcom/google/android/gms/maps/model/LatLng;->b:D

    sub-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(D)D

    move-result-wide v4

    cmpg-double v0, v4, v2

    if-gez v0, :cond_1

    .line 158
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->g:Lank;

    const v1, 0x7f020049

    invoke-static {v1}, Lani;->a(I)Lanh;

    move-result-object v1

    invoke-virtual {v0, v1}, Lank;->a(Lanh;)V

    .line 159
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->g:Lank;

    .line 160
    return-void

    .line 149
    :cond_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0
.end method

.method private c(Lank;)Landroid/view/View;
    .locals 7

    .prologue
    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->i:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0300fd

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 120
    invoke-virtual {p1}, Lank;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v0

    .line 121
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->j:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 122
    const v1, 0x7f0c0024

    invoke-virtual {v5, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 123
    const v2, 0x7f0c0027

    invoke-virtual {v5, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 124
    const v3, 0x7f0c0026

    invoke-virtual {v5, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 125
    const v4, 0x7f0c0025

    invoke-virtual {v5, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 126
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 127
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, ", "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, " "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 129
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 130
    invoke-static {v0}, Lnr;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 132
    return-object v5
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;I)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 163
    const/4 v0, 0x1

    if-gt p2, v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 166
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 167
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b_()V

    .line 168
    return-void
.end method

.method public a(Lank;)Z
    .locals 1

    .prologue
    .line 137
    sget-object v0, Llu;->ag:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->g:Lank;

    invoke-virtual {p1, v0}, Lank;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 139
    const v0, 0x7f020048

    invoke-static {v0}, Lani;->a(I)Lanh;

    move-result-object v0

    invoke-virtual {p1, v0}, Lank;->a(Lanh;)V

    .line 140
    invoke-virtual {p1}, Lank;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v0

    .line 141
    invoke-virtual {p1}, Lank;->b()V

    .line 142
    invoke-direct {p0, p1, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->a(Lank;Lcom/google/android/gms/maps/model/LatLng;)V

    .line 144
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public b(Lank;)V
    .locals 2

    .prologue
    .line 172
    invoke-virtual {p1}, Lank;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v0

    .line 173
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->j:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 174
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->i:Landroid/app/Activity;

    instance-of v1, v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    if-eqz v1, :cond_0

    .line 175
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->i:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    .line 177
    :cond_0
    return-void
.end method

.method public b_()V
    .locals 8

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->a:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    if-eqz v0, :cond_1

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->a:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->b()Laim;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    invoke-virtual {v0}, Laim;->b()V

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    new-instance v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment$1;-><init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;)V

    invoke-virtual {v0, v1}, Laim;->a(Lain;)V

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    invoke-virtual {v0, p0}, Laim;->a(Laio;)V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    invoke-virtual {v0, p0}, Laim;->a(Laiq;)V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    if-eqz v0, :cond_1

    .line 96
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 99
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLatitude()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v2

    .line 100
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLongitude()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v3

    .line 101
    new-instance v4, Lcom/google/android/gms/maps/model/LatLng;

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    invoke-virtual {v3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    invoke-direct {v4, v6, v7, v2, v3}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    .line 102
    if-nez v1, :cond_0

    .line 103
    const v2, 0x7f020048

    .line 104
    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    iget v5, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->h:I

    int-to-float v5, v5

    invoke-static {v4, v5}, Lail;->a(Lcom/google/android/gms/maps/model/LatLng;F)Laik;

    move-result-object v5

    invoke-virtual {v3, v5}, Laim;->a(Laik;)V

    .line 105
    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    new-instance v5, Lcom/google/android/gms/maps/model/MarkerOptions;

    invoke-direct {v5}, Lcom/google/android/gms/maps/model/MarkerOptions;-><init>()V

    invoke-virtual {v5, v4}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lcom/google/android/gms/maps/model/LatLng;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v4

    invoke-static {v2}, Lani;->a(I)Lanh;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lanh;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v2

    invoke-virtual {v3, v2}, Laim;->a(Lcom/google/android/gms/maps/model/MarkerOptions;)Lank;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->g:Lank;

    .line 106
    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->j:Ljava/util/Map;

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->g:Lank;

    invoke-virtual {v3}, Lank;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 108
    :cond_0
    const v2, 0x7f020049

    .line 109
    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->b:Laim;

    new-instance v5, Lcom/google/android/gms/maps/model/MarkerOptions;

    invoke-direct {v5}, Lcom/google/android/gms/maps/model/MarkerOptions;-><init>()V

    invoke-virtual {v5, v4}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lcom/google/android/gms/maps/model/LatLng;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v4

    invoke-static {v2}, Lani;->a(I)Lanh;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lanh;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v2

    invoke-virtual {v3, v2}, Laim;->a(Lcom/google/android/gms/maps/model/MarkerOptions;)Lank;

    move-result-object v2

    .line 110
    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->j:Ljava/util/Map;

    invoke-virtual {v2}, Lank;->a()Lcom/google/android/gms/maps/model/LatLng;

    move-result-object v2

    invoke-interface {v3, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 116
    :cond_1
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 64
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 65
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->i:Landroid/app/Activity;

    .line 66
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 49
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 50
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 54
    const v0, 0x7f03003f

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 55
    invoke-static {p0}, Lcom/bestbuy/android/bbyobjects/MapBaseFragment;->a(Lcom/bestbuy/android/base/BBYBaseFragment;)Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->a:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    .line 56
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 57
    const v2, 0x7f0c0107

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreMapFragment;->a:Lcom/bestbuy/android/bbyobjects/MapBaseFragment;

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 58
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 59
    return-object v0
.end method

.method public onDetach()V
    .locals 2

    .prologue
    .line 181
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDetach()V

    .line 183
    :try_start_0
    const-class v0, Landroid/support/v4/app/Fragment;

    const-string v1, "mChildFragmentManager"

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    .line 184
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 185
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 192
    return-void

    .line 187
    :catch_0
    move-exception v0

    .line 188
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 189
    :catch_1
    move-exception v0

    .line 190
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 70
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onStart()V

    .line 71
    sget-object v0, Llu;->aO:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 72
    return-void
.end method
