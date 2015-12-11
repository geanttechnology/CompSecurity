.class Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)V
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 0

    .prologue
    .line 232
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    .prologue
    .line 228
    return-void
.end method

.method public onPageSelected(I)V
    .locals 11

    .prologue
    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Laim;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->c(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 194
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLatitude()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v1

    .line 195
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getLongitude()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v0

    .line 196
    new-instance v2, Lcom/google/android/gms/maps/model/LatLng;

    invoke-virtual {v1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    invoke-direct {v2, v4, v5, v0, v1}, Lcom/google/android/gms/maps/model/LatLng;-><init>(DD)V

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Laim;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I

    move-result v1

    int-to-float v1, v1

    invoke-static {v2, v1}, Lail;->a(Lcom/google/android/gms/maps/model/LatLng;F)Laik;

    move-result-object v1

    invoke-virtual {v0, v1}, Laim;->a(Laik;)V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Laim;

    move-result-object v0

    invoke-virtual {v0}, Laim;->a()Lcom/google/android/gms/maps/model/CameraPosition;

    move-result-object v0

    iget-object v0, v0, Lcom/google/android/gms/maps/model/CameraPosition;->a:Lcom/google/android/gms/maps/model/LatLng;

    .line 199
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Laim;

    move-result-object v1

    new-instance v3, Lcom/google/android/gms/maps/model/MarkerOptions;

    invoke-direct {v3}, Lcom/google/android/gms/maps/model/MarkerOptions;-><init>()V

    invoke-virtual {v3, v2}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lcom/google/android/gms/maps/model/LatLng;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v2

    const v3, 0x7f020183

    invoke-static {v3}, Lani;->a(I)Lanh;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/android/gms/maps/model/MarkerOptions;->a(Lanh;)Lcom/google/android/gms/maps/model/MarkerOptions;

    move-result-object v2

    invoke-virtual {v1, v2}, Laim;->a(Lcom/google/android/gms/maps/model/MarkerOptions;)Lank;

    move-result-object v1

    .line 201
    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v2, v1, v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Lank;Lcom/google/android/gms/maps/model/LatLng;)V

    .line 203
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->c(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ne p1, v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->e(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I

    move-result v1

    add-int/lit8 v1, v1, 0xa

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;I)I

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "IS_MAP_VIEW"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->h(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    .line 208
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 209
    const-string v1, "bb.searchTerm"

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 210
    const-string v1, "bb.numResults"

    const-string v2, "25"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 211
    sget-object v1, Llu;->ad:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 212
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z

    .line 214
    new-instance v0, Ljy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Landroid/view/View;

    move-result-object v3

    iget-object v5, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I

    move-result v5

    const/16 v6, 0x32

    invoke-direct/range {v0 .. v6}, Ljy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;II)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 223
    :cond_1
    :goto_0
    return-void

    .line 217
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Ljz;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 218
    iget-object v10, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    new-instance v0, Ljz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->i(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)D

    move-result-wide v4

    iget-object v6, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->l(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)D

    move-result-wide v6

    iget-object v8, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I

    move-result v8

    const/16 v9, 0x32

    invoke-direct/range {v0 .. v9}, Ljz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDII)V

    invoke-static {v10, v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Ljz;)Ljz;

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$1;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Ljz;

    move-result-object v0

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
