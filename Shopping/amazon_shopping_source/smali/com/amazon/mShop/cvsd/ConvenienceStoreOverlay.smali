.class public Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;
.super Lcom/google/android/maps/ItemizedOverlay;
.source "ConvenienceStoreOverlay.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/maps/ItemizedOverlay",
        "<",
        "Lcom/google/android/maps/OverlayItem;",
        ">;"
    }
.end annotation


# instance fields
.field private final mConvenienceStoreOverlayItemList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/maps/OverlayItem;",
            ">;"
        }
    .end annotation
.end field

.field private mConvenienceStoreResultList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;"
        }
    .end annotation
.end field

.field private final mStoreMarkerTapListener:Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;Ljava/util/List;Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;)V
    .locals 18
    .param p1, "defaultMarker"    # Landroid/graphics/drawable/Drawable;
    .param p3, "storeMarkerTapListener"    # Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/drawable/Drawable;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;",
            "Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 23
    .local p2, "result":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Address;>;"
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->boundCenterBottom(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v12

    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/google/android/maps/ItemizedOverlay;-><init>(Landroid/graphics/drawable/Drawable;)V

    .line 17
    new-instance v12, Ljava/util/ArrayList;

    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    iput-object v12, v0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreOverlayItemList:Ljava/util/List;

    .line 24
    move-object/from16 v0, p2

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreResultList:Ljava/util/List;

    .line 25
    move-object/from16 v0, p3

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mStoreMarkerTapListener:Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;

    .line 28
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreOverlayItemList:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->clear()V

    .line 30
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreResultList:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v12

    if-ge v4, v12, :cond_0

    .line 32
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreResultList:Ljava/util/List;

    invoke-interface {v12, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 34
    .local v2, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getLocation()Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    move-result-object v12

    invoke-virtual {v12}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getLatitude()Ljava/lang/String;

    move-result-object v8

    .line 35
    .local v8, "latString":Ljava/lang/String;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getLocation()Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;

    move-result-object v12

    invoke-virtual {v12}, Lcom/amazon/rio/j2me/client/services/mShop/Coordinates;->getLongitude()Ljava/lang/String;

    move-result-object v11

    .line 37
    .local v11, "lonString":Ljava/lang/String;
    invoke-static {v8}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    .line 38
    .local v7, "latFloat":F
    float-to-double v12, v7

    const-wide/high16 v14, 0x4024000000000000L    # 10.0

    const-wide/high16 v16, 0x4018000000000000L    # 6.0

    invoke-static/range {v14 .. v17}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v14

    mul-double/2addr v12, v14

    double-to-int v6, v12

    .line 40
    .local v6, "lat":I
    invoke-static {v11}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v10

    .line 41
    .local v10, "lonFloat":F
    float-to-double v12, v10

    const-wide/high16 v14, 0x4024000000000000L    # 10.0

    const-wide/high16 v16, 0x4018000000000000L    # 6.0

    invoke-static/range {v14 .. v17}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v14

    mul-double/2addr v12, v14

    double-to-int v9, v12

    .line 43
    .local v9, "lon":I
    new-instance v3, Lcom/google/android/maps/GeoPoint;

    invoke-direct {v3, v6, v9}, Lcom/google/android/maps/GeoPoint;-><init>(II)V

    .line 45
    .local v3, "geoPoint":Lcom/google/android/maps/GeoPoint;
    new-instance v5, Lcom/google/android/maps/OverlayItem;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getName()Ljava/lang/String;

    move-result-object v12

    const-string/jumbo v13, ""

    invoke-direct {v5, v3, v12, v13}, Lcom/google/android/maps/OverlayItem;-><init>(Lcom/google/android/maps/GeoPoint;Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    .local v5, "item":Lcom/google/android/maps/OverlayItem;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreOverlayItemList:Ljava/util/List;

    invoke-interface {v12, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 49
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->populate()V

    .line 30
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 52
    .end local v2    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v3    # "geoPoint":Lcom/google/android/maps/GeoPoint;
    .end local v5    # "item":Lcom/google/android/maps/OverlayItem;
    .end local v6    # "lat":I
    .end local v7    # "latFloat":F
    .end local v8    # "latString":Ljava/lang/String;
    .end local v9    # "lon":I
    .end local v10    # "lonFloat":F
    .end local v11    # "lonString":Ljava/lang/String;
    :cond_0
    return-void
.end method


# virtual methods
.method protected createItem(I)Lcom/google/android/maps/OverlayItem;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreOverlayItemList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/maps/OverlayItem;

    return-object v0
.end method

.method public getOverlayItemIndex(Lcom/google/android/maps/OverlayItem;)I
    .locals 1
    .param p1, "item"    # Lcom/google/android/maps/OverlayItem;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreOverlayItemList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method protected onTap(I)Z
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 84
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mStoreMarkerTapListener:Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;

    iget-object v0, p0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreOverlayItemList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/maps/OverlayItem;

    invoke-interface {v1, v0}, Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;->onTap(Lcom/google/android/maps/OverlayItem;)V

    .line 86
    const/4 v0, 0x1

    return v0
.end method

.method public onTap(Lcom/google/android/maps/GeoPoint;Lcom/google/android/maps/MapView;)Z
    .locals 2
    .param p1, "p"    # Lcom/google/android/maps/GeoPoint;
    .param p2, "mapView"    # Lcom/google/android/maps/MapView;

    .prologue
    .line 72
    invoke-super {p0, p1, p2}, Lcom/google/android/maps/ItemizedOverlay;->onTap(Lcom/google/android/maps/GeoPoint;Lcom/google/android/maps/MapView;)Z

    move-result v0

    .line 74
    .local v0, "handle":Z
    if-nez v0, :cond_0

    .line 75
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mStoreMarkerTapListener:Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;

    invoke-interface {v1}, Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;->onNoOverlayItemTap()V

    .line 78
    :cond_0
    return v0
.end method

.method public size()I
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->mConvenienceStoreOverlayItemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method
