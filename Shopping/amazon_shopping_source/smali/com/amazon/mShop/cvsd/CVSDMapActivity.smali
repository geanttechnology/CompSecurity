.class public Lcom/amazon/mShop/cvsd/CVSDMapActivity;
.super Lcom/google/android/maps/MapActivity;
.source "CVSDMapActivity.java"

# interfaces
.implements Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
.implements Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;,
        Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip2TextWatcher;,
        Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip1TextWatcher;,
        Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZipTextWatcher;,
        Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;,
        Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;,
        Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;
    }
.end annotation


# static fields
.field private static final MARKET_LOCALE_FR:Ljava/lang/String; = "FR"

.field private static final MARKET_LOCALE_JP:Ljava/lang/String; = "JP"

.field private static final VALUE_1E6:D

.field private static final VALUE_MY_LOCATION_ZOOM_DEFAULT_LEVEL:I = 0xf


# instance fields
.field private final Zip1MinLength:I

.field private final Zip2MinLength:I

.field private address:Landroid/widget/EditText;

.field private addressDialogPositiveButton:Landroid/widget/Button;

.field private addressTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;

.field private bubble:Landroid/widget/Button;

.field private cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;

.field private flyToCurrentLocationLocationListener:Landroid/location/LocationListener;

.field private landmark:Landroid/widget/EditText;

.field private landmarkDialogPositiveButton:Landroid/widget/Button;

.field private landmarkTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;

.field private mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

.field private mMapView:Lcom/google/android/maps/MapView;

.field private mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

.field private searchByCurrentLocationLocationListener:Landroid/location/LocationListener;

.field private zip:Landroid/widget/EditText;

.field private zip1:Landroid/widget/EditText;

.field private zip1TextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip1TextWatcher;

.field private zip2:Landroid/widget/EditText;

.field private zip2TextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip2TextWatcher;

.field private zipDialogPositiveButton:Landroid/widget/Button;

.field private zipTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZipTextWatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 66
    const-wide/high16 v0, 0x4024000000000000L    # 10.0

    const-wide/high16 v2, 0x4018000000000000L    # 6.0

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    sput-wide v0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->VALUE_1E6:D

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/google/android/maps/MapActivity;-><init>()V

    .line 70
    new-instance v0, Lcom/amazon/mShop/control/cvsd/CVSDController;

    invoke-direct {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;

    .line 985
    const/4 v0, 0x3

    iput v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->Zip1MinLength:I

    .line 986
    const/4 v0, 0x4

    iput v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->Zip2MinLength:I

    .line 992
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->createSearchOptionDialog()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation()V

    return-void
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByLandmark()V

    return-void
.end method

.method static synthetic access$1100(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocation()V

    return-void
.end method

.method static synthetic access$1200(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->clearMap()V

    return-void
.end method

.method static synthetic access$1300(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->address:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Lcom/amazon/mShop/control/cvsd/CVSDController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip2:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmark:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->addressTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/location/Location;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;
    .param p1, "x1"    # Landroid/location/Location;

    .prologue
    .line 59
    invoke-direct {p0, p1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation(Landroid/location/Location;)V

    return-void
.end method

.method static synthetic access$2000(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->addressDialogPositiveButton:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZipTextWatcher;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zipTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZipTextWatcher;

    return-object v0
.end method

.method static synthetic access$2200(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zipDialogPositiveButton:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$2300(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->checkJPZip()Z

    move-result v0

    return v0
.end method

.method static synthetic access$2400(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmarkTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;

    return-object v0
.end method

.method static synthetic access$2500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmarkDialogPositiveButton:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/location/LocationListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocationLocationListener:Landroid/location/LocationListener;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByCurrentLocation()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->showDialogRequestingUserToConfigLocationSettingsManually()V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 59
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByCurrentLocation(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$700(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/location/LocationListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocationLocationListener:Landroid/location/LocationListener;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByAddress()V

    return-void
.end method

.method static synthetic access$900(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByZipCode()V

    return-void
.end method

.method private centerMapBasedOnMarket()V
    .locals 5

    .prologue
    .line 208
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->opl_new_address_default_country_code:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 209
    .local v0, "market":Ljava/lang/String;
    const/4 v1, 0x0

    .line 210
    .local v1, "point":Lcom/google/android/maps/GeoPoint;
    const/4 v2, -0x1

    .line 213
    .local v2, "zoomLevel":I
    const-string/jumbo v3, "JP"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 214
    new-instance v1, Lcom/google/android/maps/GeoPoint;

    .end local v1    # "point":Lcom/google/android/maps/GeoPoint;
    const v3, 0x23036f5

    const v4, 0x8457e04

    invoke-direct {v1, v3, v4}, Lcom/google/android/maps/GeoPoint;-><init>(II)V

    .line 215
    .restart local v1    # "point":Lcom/google/android/maps/GeoPoint;
    const/4 v2, 0x5

    .line 221
    :cond_0
    :goto_0
    if-eqz v1, :cond_1

    const/4 v3, -0x1

    if-ne v2, v3, :cond_3

    .line 228
    :cond_1
    :goto_1
    return-void

    .line 216
    :cond_2
    const-string/jumbo v3, "FR"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 217
    new-instance v1, Lcom/google/android/maps/GeoPoint;

    .end local v1    # "point":Lcom/google/android/maps/GeoPoint;
    const v3, 0x2ced39a

    const v4, 0x24c4c3

    invoke-direct {v1, v3, v4}, Lcom/google/android/maps/GeoPoint;-><init>(II)V

    .line 218
    .restart local v1    # "point":Lcom/google/android/maps/GeoPoint;
    const/4 v2, 0x5

    goto :goto_0

    .line 225
    :cond_3
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v3}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/google/android/maps/MapController;->setCenter(Lcom/google/android/maps/GeoPoint;)V

    .line 226
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v3}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/google/android/maps/MapController;->setZoom(I)I

    goto :goto_1
.end method

.method private checkJPZip()Z
    .locals 2

    .prologue
    .line 989
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip2:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip2:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private clearMap()V
    .locals 3

    .prologue
    .line 927
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v1}, Lcom/google/android/maps/MapView;->getOverlays()Ljava/util/List;

    move-result-object v0

    .line 928
    .local v0, "overlays":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/maps/Overlay;>;"
    if-eqz v0, :cond_0

    .line 929
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    invoke-interface {v0, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 932
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    if-eqz v1, :cond_1

    .line 933
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 937
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v1}, Lcom/google/android/maps/MapView;->invalidate()V

    .line 938
    return-void
.end method

.method private createSearchOptionDialog()V
    .locals 7

    .prologue
    .line 542
    new-instance v3, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;

    invoke-direct {v3, p0, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/content/Context;)V

    .line 544
    .local v3, "optionListAdapter":Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;
    new-instance v6, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 545
    .local v6, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    .line 546
    .local v1, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_by:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v4, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;

    invoke-direct {v4, p0, v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$8;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Lcom/amazon/mShop/AmazonAlertDialog;)V

    const/4 v5, -0x1

    move-object v0, p0

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/AmazonAlertDialog;->customizeAlertDialog(Landroid/content/Context;Lcom/amazon/mShop/AmazonAlertDialog;Ljava/lang/String;Landroid/widget/ListAdapter;Landroid/widget/AdapterView$OnItemClickListener;I)V

    .line 568
    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 569
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 570
    return-void
.end method

.method private flyToCurrentLocation()V
    .locals 7

    .prologue
    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    .line 269
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->isLocationProviderEnabled()Z

    move-result v1

    if-nez v1, :cond_0

    .line 270
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->requestUserConfigLocationProvider()V

    .line 324
    :goto_0
    return-void

    .line 276
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    if-eqz v1, :cond_1

    .line 278
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    invoke-virtual {v1}, Lcom/google/android/maps/MyLocationOverlay;->enableMyLocation()Z

    .line 279
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    invoke-virtual {v1}, Lcom/google/android/maps/MyLocationOverlay;->getMyLocation()Lcom/google/android/maps/GeoPoint;

    move-result-object v6

    .line 280
    .local v6, "myLocationGeoPoint":Lcom/google/android/maps/GeoPoint;
    if-eqz v6, :cond_1

    .line 281
    invoke-direct {p0, v6}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation(Lcom/google/android/maps/GeoPoint;)V

    goto :goto_0

    .line 289
    .end local v6    # "myLocationGeoPoint":Lcom/google/android/maps/GeoPoint;
    :cond_1
    const-string/jumbo v1, "location"

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 291
    .local v0, "locationManager":Landroid/location/LocationManager;
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocationLocationListener:Landroid/location/LocationListener;

    if-nez v1, :cond_2

    .line 294
    new-instance v1, Lcom/amazon/mShop/cvsd/CVSDMapActivity$3;

    invoke-direct {v1, p0, v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$3;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/location/LocationManager;)V

    iput-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocationLocationListener:Landroid/location/LocationListener;

    .line 322
    :cond_2
    const-string/jumbo v1, "gps"

    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocationLocationListener:Landroid/location/LocationListener;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    .line 323
    const-string/jumbo v1, "network"

    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocationLocationListener:Landroid/location/LocationListener;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    goto :goto_0
.end method

.method private flyToCurrentLocation(Landroid/location/Location;)V
    .locals 6
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    .line 327
    if-eqz p1, :cond_0

    .line 329
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v1}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v1

    const/16 v2, 0xf

    invoke-virtual {v1, v2}, Lcom/google/android/maps/MapController;->setZoom(I)I

    .line 330
    new-instance v0, Lcom/google/android/maps/GeoPoint;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v1

    sget-wide v3, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->VALUE_1E6:D

    mul-double/2addr v1, v3

    double-to-int v1, v1

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    sget-wide v4, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->VALUE_1E6:D

    mul-double/2addr v2, v4

    double-to-int v2, v2

    invoke-direct {v0, v1, v2}, Lcom/google/android/maps/GeoPoint;-><init>(II)V

    .line 331
    .local v0, "currentGeoPoint":Lcom/google/android/maps/GeoPoint;
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v1}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/google/android/maps/MapController;->animateTo(Lcom/google/android/maps/GeoPoint;)V

    .line 333
    .end local v0    # "currentGeoPoint":Lcom/google/android/maps/GeoPoint;
    :cond_0
    return-void
.end method

.method private flyToCurrentLocation(Lcom/google/android/maps/GeoPoint;)V
    .locals 2
    .param p1, "gp"    # Lcom/google/android/maps/GeoPoint;

    .prologue
    .line 336
    if-eqz p1, :cond_0

    .line 338
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v0}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v0

    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/google/android/maps/MapController;->setZoom(I)I

    .line 339
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v0}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/android/maps/MapController;->animateTo(Lcom/google/android/maps/GeoPoint;)V

    .line 341
    :cond_0
    return-void
.end method

.method private isLocationProviderEnabled()Z
    .locals 2

    .prologue
    .line 480
    const-string/jumbo v1, "location"

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 481
    .local v0, "locationManager":Landroid/location/LocationManager;
    const-string/jumbo v1, "network"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private requestUserConfigLocationProvider()V
    .locals 5

    .prologue
    .line 368
    new-instance v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_location_settings_message:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    .line 370
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    new-instance v1, Lcom/amazon/mShop/cvsd/CVSDMapActivity$5;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$5;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 393
    .local v1, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 394
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_cancel_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 395
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_location_settings_title:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 396
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 397
    return-void
.end method

.method private searchByAddress()V
    .locals 11

    .prologue
    const/4 v10, 0x0

    .line 585
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    .line 586
    .local v4, "factory":Landroid/view/LayoutInflater;
    sget v8, Lcom/amazon/mShop/android/lib/R$layout;->cvsd_search_by_address_dialog_content:I

    const/4 v9, 0x0

    invoke-virtual {v4, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 587
    .local v3, "dialogContentView":Landroid/view/View;
    sget v8, Lcom/amazon/mShop/android/lib/R$id;->cvsd_address_edit:I

    invoke-virtual {v3, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/EditText;

    iput-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->address:Landroid/widget/EditText;

    .line 588
    new-instance v8, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;

    iget-object v9, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->address:Landroid/widget/EditText;

    invoke-direct {v8, p0, v9}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/widget/EditText;)V

    iput-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->addressTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyAddressTextWatcher;

    .line 590
    sget v8, Lcom/amazon/mShop/android/lib/R$id;->cvsd_states_spinner:I

    invoke-virtual {v3, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/Spinner;

    .line 591
    .local v7, "statesSpinner":Landroid/widget/Spinner;
    new-instance v0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;

    invoke-direct {v0, p0, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/content/Context;)V

    .line 592
    .local v0, "adapter":Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;
    invoke-virtual {v7, v0}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 594
    sget v8, Lcom/amazon/mShop/android/lib/R$id;->cvsd_search_by_address_jp_states_container:I

    invoke-virtual {v3, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 597
    .local v5, "jpStatesContainer":Landroid/view/View;
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->opl_new_address_default_country_code:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 598
    .local v6, "market":Ljava/lang/String;
    const-string/jumbo v8, "JP"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 599
    invoke-virtual {v5, v10}, Landroid/view/View;->setVisibility(I)V

    .line 604
    :goto_0
    new-instance v1, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 605
    .local v1, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_address:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 606
    invoke-virtual {v1, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setView(Landroid/view/View;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 608
    sget v8, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_store_button:I

    new-instance v9, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;

    invoke-direct {v9, p0, v6, v7}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$9;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Ljava/lang/String;Landroid/widget/Spinner;)V

    invoke-virtual {v1, v8, v9}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 630
    sget v8, Lcom/amazon/mShop/android/lib/R$string;->opl_cancel_button:I

    new-instance v9, Lcom/amazon/mShop/cvsd/CVSDMapActivity$10;

    invoke-direct {v9, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$10;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    invoke-virtual {v1, v8, v9}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 642
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    .line 643
    .local v2, "createdDialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 645
    const/4 v8, -0x1

    invoke-virtual {v2, v8}, Lcom/amazon/mShop/AmazonAlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->addressDialogPositiveButton:Landroid/widget/Button;

    .line 647
    iget-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->addressDialogPositiveButton:Landroid/widget/Button;

    invoke-virtual {v8, v10}, Landroid/widget/Button;->setEnabled(Z)V

    .line 649
    iget-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->address:Landroid/widget/EditText;

    invoke-static {v8}, Lcom/amazon/mShop/util/UIUtils;->showSoftKeyboard(Landroid/view/View;)V

    .line 650
    return-void

    .line 601
    .end local v1    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .end local v2    # "createdDialog":Lcom/amazon/mShop/AmazonAlertDialog;
    :cond_0
    const/16 v8, 0x8

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private searchByCurrentLocation()V
    .locals 2

    .prologue
    .line 575
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "allowUseUserCurrentlocation"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 576
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->clearMap()V

    .line 577
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByCurrentLocation()V

    .line 581
    :goto_0
    return-void

    .line 579
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->showUseCurrentLocationConfirmationDialog()V

    goto :goto_0
.end method

.method private searchByLandmark()V
    .locals 11

    .prologue
    const/4 v10, 0x0

    .line 743
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    .line 744
    .local v4, "factory":Landroid/view/LayoutInflater;
    sget v8, Lcom/amazon/mShop/android/lib/R$layout;->cvsd_search_by_landmark_dialog_content:I

    const/4 v9, 0x0

    invoke-virtual {v4, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 745
    .local v3, "dialogContentView":Landroid/view/View;
    sget v8, Lcom/amazon/mShop/android/lib/R$id;->cvsd_landmark_edit:I

    invoke-virtual {v3, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/EditText;

    iput-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmark:Landroid/widget/EditText;

    .line 746
    new-instance v8, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;

    iget-object v9, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmark:Landroid/widget/EditText;

    invoke-direct {v8, p0, v9}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/widget/EditText;)V

    iput-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmarkTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyLandmarkTextWatcher;

    .line 748
    sget v8, Lcom/amazon/mShop/android/lib/R$id;->cvsd_states_spinner:I

    invoke-virtual {v3, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/Spinner;

    .line 749
    .local v7, "statesSpinner":Landroid/widget/Spinner;
    new-instance v0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;

    invoke-direct {v0, p0, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/content/Context;)V

    .line 750
    .local v0, "adapter":Lcom/amazon/mShop/cvsd/CVSDMapActivity$StatesSpinnerAdapter;
    invoke-virtual {v7, v0}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 752
    sget v8, Lcom/amazon/mShop/android/lib/R$id;->cvsd_search_by_landmark_jp_states_container:I

    invoke-virtual {v3, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 755
    .local v5, "jpStatesContainer":Landroid/view/View;
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->opl_new_address_default_country_code:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 756
    .local v6, "market":Ljava/lang/String;
    const-string/jumbo v8, "JP"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 757
    invoke-virtual {v5, v10}, Landroid/view/View;->setVisibility(I)V

    .line 762
    :goto_0
    new-instance v1, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 763
    .local v1, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_landmark:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 764
    invoke-virtual {v1, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setView(Landroid/view/View;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 766
    sget v8, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_store_button:I

    new-instance v9, Lcom/amazon/mShop/cvsd/CVSDMapActivity$13;

    invoke-direct {v9, p0, v6, v7}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$13;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Ljava/lang/String;Landroid/widget/Spinner;)V

    invoke-virtual {v1, v8, v9}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 789
    sget v8, Lcom/amazon/mShop/android/lib/R$string;->opl_cancel_button:I

    new-instance v9, Lcom/amazon/mShop/cvsd/CVSDMapActivity$14;

    invoke-direct {v9, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$14;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    invoke-virtual {v1, v8, v9}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 801
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    .line 802
    .local v2, "createdDialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 804
    const/4 v8, -0x1

    invoke-virtual {v2, v8}, Lcom/amazon/mShop/AmazonAlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmarkDialogPositiveButton:Landroid/widget/Button;

    .line 806
    iget-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmarkDialogPositiveButton:Landroid/widget/Button;

    invoke-virtual {v8, v10}, Landroid/widget/Button;->setEnabled(Z)V

    .line 808
    iget-object v8, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->landmark:Landroid/widget/EditText;

    invoke-static {v8}, Lcom/amazon/mShop/util/UIUtils;->showSoftKeyboard(Landroid/view/View;)V

    .line 809
    return-void

    .line 759
    .end local v1    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .end local v2    # "createdDialog":Lcom/amazon/mShop/AmazonAlertDialog;
    :cond_0
    const/16 v8, 0x8

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private searchByZipCode()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 654
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 655
    .local v3, "factory":Landroid/view/LayoutInflater;
    sget v5, Lcom/amazon/mShop/android/lib/R$layout;->cvsd_search_by_zip_dialog_content:I

    const/4 v6, 0x0

    invoke-virtual {v3, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 658
    .local v2, "dialogContentView":Landroid/view/View;
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->opl_new_address_default_country_code:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 660
    .local v4, "market":Ljava/lang/String;
    const-string/jumbo v5, "JP"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 662
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->cvsd_search_by_zip_jp_container:I

    invoke-virtual {v2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, v7}, Landroid/view/View;->setVisibility(I)V

    .line 664
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->cvsd_zip1_edit:I

    invoke-virtual {v2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/EditText;

    iput-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;

    .line 665
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->cvsd_zip2_edit:I

    invoke-virtual {v2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/EditText;

    iput-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip2:Landroid/widget/EditText;

    .line 666
    new-instance v5, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip1TextWatcher;

    iget-object v6, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;

    invoke-direct {v5, p0, v6}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip1TextWatcher;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/widget/EditText;)V

    iput-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1TextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip1TextWatcher;

    .line 667
    new-instance v5, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip2TextWatcher;

    iget-object v6, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip2:Landroid/widget/EditText;

    invoke-direct {v5, p0, v6}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip2TextWatcher;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/widget/EditText;)V

    iput-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip2TextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZip2TextWatcher;

    .line 668
    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->opl_address_zip1_rule:I

    invoke-static {v5, v6}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 669
    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip2:Landroid/widget/EditText;

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->opl_address_zip2_rule:I

    invoke-static {v5, v6}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 678
    :cond_0
    :goto_0
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 680
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_zip:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 681
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setView(Landroid/view/View;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 683
    sget v5, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_store_button:I

    new-instance v6, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;

    invoke-direct {v6, p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$11;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Ljava/lang/String;)V

    invoke-virtual {v0, v5, v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 712
    sget v5, Lcom/amazon/mShop/android/lib/R$string;->opl_cancel_button:I

    new-instance v6, Lcom/amazon/mShop/cvsd/CVSDMapActivity$12;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$12;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    invoke-virtual {v0, v5, v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 724
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    .line 725
    .local v1, "createdDialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 727
    const/4 v5, -0x1

    invoke-virtual {v1, v5}, Lcom/amazon/mShop/AmazonAlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zipDialogPositiveButton:Landroid/widget/Button;

    .line 729
    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zipDialogPositiveButton:Landroid/widget/Button;

    invoke-virtual {v5, v7}, Landroid/widget/Button;->setEnabled(Z)V

    .line 731
    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;

    if-eqz v5, :cond_1

    .line 732
    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip1:Landroid/widget/EditText;

    invoke-static {v5}, Lcom/amazon/mShop/util/UIUtils;->showSoftKeyboard(Landroid/view/View;)V

    .line 735
    :cond_1
    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip:Landroid/widget/EditText;

    if-eqz v5, :cond_2

    .line 736
    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip:Landroid/widget/EditText;

    invoke-static {v5}, Lcom/amazon/mShop/util/UIUtils;->showSoftKeyboard(Landroid/view/View;)V

    .line 739
    :cond_2
    return-void

    .line 670
    .end local v0    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .end local v1    # "createdDialog":Lcom/amazon/mShop/AmazonAlertDialog;
    :cond_3
    const-string/jumbo v5, "FR"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 672
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->cvsd_search_by_zip_fr_container:I

    invoke-virtual {v2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5, v7}, Landroid/view/View;->setVisibility(I)V

    .line 674
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->cvsd_zip_edit:I

    invoke-virtual {v2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/EditText;

    iput-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip:Landroid/widget/EditText;

    .line 675
    new-instance v5, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZipTextWatcher;

    iget-object v6, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zip:Landroid/widget/EditText;

    invoke-direct {v5, p0, v6}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZipTextWatcher;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/widget/EditText;)V

    iput-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->zipTextWatcher:Lcom/amazon/mShop/cvsd/CVSDMapActivity$MyZipTextWatcher;

    goto :goto_0
.end method

.method private searchDeliveryLocationByAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V
    .locals 2
    .param p1, "address"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .prologue
    .line 491
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/amazon/mShop/control/cvsd/CVSDController;->searchDeliveryLocationByAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 492
    return-void
.end method

.method private searchDeliveryLocationByCurrentLocation()V
    .locals 9

    .prologue
    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    .line 421
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->isLocationProviderEnabled()Z

    move-result v1

    if-nez v1, :cond_0

    .line 422
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->requestUserConfigLocationProvider()V

    .line 477
    :goto_0
    return-void

    .line 427
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    if-eqz v1, :cond_1

    .line 428
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    invoke-virtual {v1}, Lcom/google/android/maps/MyLocationOverlay;->enableMyLocation()Z

    .line 430
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    invoke-virtual {v1}, Lcom/google/android/maps/MyLocationOverlay;->getMyLocation()Lcom/google/android/maps/GeoPoint;

    move-result-object v6

    .line 431
    .local v6, "myLocation":Lcom/google/android/maps/GeoPoint;
    if-eqz v6, :cond_1

    .line 432
    invoke-direct {p0, v6}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation(Lcom/google/android/maps/GeoPoint;)V

    .line 433
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6}, Lcom/google/android/maps/GeoPoint;->getLatitudeE6()I

    move-result v2

    int-to-double v2, v2

    sget-wide v4, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->VALUE_1E6:D

    div-double/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6}, Lcom/google/android/maps/GeoPoint;->getLongitudeE6()I

    move-result v3

    int-to-double v3, v3

    sget-wide v7, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->VALUE_1E6:D

    div-double/2addr v3, v7

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByCurrentLocation(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 441
    .end local v6    # "myLocation":Lcom/google/android/maps/GeoPoint;
    :cond_1
    const-string/jumbo v1, "location"

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 443
    .local v0, "locationManager":Landroid/location/LocationManager;
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocationLocationListener:Landroid/location/LocationListener;

    if-nez v1, :cond_2

    .line 445
    new-instance v1, Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;

    invoke-direct {v1, p0, v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/location/LocationManager;)V

    iput-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocationLocationListener:Landroid/location/LocationListener;

    .line 474
    :cond_2
    const-string/jumbo v1, "gps"

    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocationLocationListener:Landroid/location/LocationListener;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    .line 475
    const-string/jumbo v1, "network"

    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocationLocationListener:Landroid/location/LocationListener;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    goto :goto_0
.end method

.method private searchDeliveryLocationByCurrentLocation(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "lat"    # Ljava/lang/String;
    .param p2, "lon"    # Ljava/lang/String;

    .prologue
    .line 486
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/control/cvsd/CVSDController;->searchDeliveryLocationByCurrentLocation(Ljava/lang/String;Ljava/lang/String;)V

    .line 487
    return-void
.end method

.method private showDialogRequestingUserToConfigLocationSettingsManually()V
    .locals 5

    .prologue
    .line 400
    new-instance v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_manual_location_settings_message:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    .line 402
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    new-instance v1, Lcom/amazon/mShop/cvsd/CVSDMapActivity$6;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$6;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 412
    .local v1, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 413
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_manual_location_settings_title:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 414
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 415
    return-void
.end method

.method private showUseCurrentLocationConfirmationDialog()V
    .locals 5

    .prologue
    .line 345
    new-instance v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_use_current_location_confirm:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    .line 347
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    new-instance v1, Lcom/amazon/mShop/cvsd/CVSDMapActivity$4;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$4;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 361
    .local v1, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 362
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_cancel_button:I

    invoke-virtual {v0, v2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 363
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 364
    return-void
.end method


# virtual methods
.method protected isRouteDisplayed()Z
    .locals 1

    .prologue
    .line 877
    const/4 v0, 0x0

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 5
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v4, -0x1

    .line 899
    invoke-super {p0, p1, p2, p3}, Lcom/google/android/maps/MapActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 901
    const/16 v3, 0x8

    if-ne p1, v3, :cond_1

    .line 903
    if-ne p2, v4, :cond_0

    .line 904
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 905
    .local v1, "extra":Landroid/os/Bundle;
    const-string/jumbo v3, "com.amazon.mShop.cvsd.CVSDRefinementsView.KEY_REFINEMENTS_SELECTED_INDEX"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 906
    .local v2, "selectedIndex":I
    sget-object v3, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 908
    .local v0, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-static {}, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->reset()V

    .line 909
    invoke-direct {p0, v0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V

    .line 920
    .end local v0    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v1    # "extra":Landroid/os/Bundle;
    .end local v2    # "selectedIndex":I
    :cond_0
    :goto_0
    return-void

    .line 912
    :cond_1
    const/4 v3, 0x7

    if-ne p1, v3, :cond_2

    .line 913
    if-ne p2, v4, :cond_0

    .line 914
    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->setResult(I)V

    .line 915
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->finish()V

    goto :goto_0

    .line 917
    :cond_2
    const/16 v3, 0x9

    if-ne p1, v3, :cond_0

    .line 918
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->createSearchOptionDialog()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 99
    invoke-super {p0, p1}, Lcom/google/android/maps/MapActivity;->onCreate(Landroid/os/Bundle;)V

    .line 110
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_for_a_convenience_store:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->setTitle(I)V

    .line 117
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_for_a_convenience_store:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 119
    iget-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;

    invoke-virtual {v4, p0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->setSubscriber(Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;)V

    .line 121
    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->cvsd_map:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->setContentView(I)V

    .line 123
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->mapview:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/google/android/maps/MapView;

    iput-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    .line 125
    iget-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    if-nez v4, :cond_0

    .line 203
    :goto_0
    return-void

    .line 128
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/google/android/maps/MapView;->setBuiltInZoomControls(Z)V

    .line 129
    iget-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    sget-object v5, Lcom/google/android/maps/MapView$ReticleDrawMode;->DRAW_RETICLE_UNDER:Lcom/google/android/maps/MapView$ReticleDrawMode;

    invoke-virtual {v4, v5}, Lcom/google/android/maps/MapView;->setReticleDrawMode(Lcom/google/android/maps/MapView$ReticleDrawMode;)V

    .line 131
    iget-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v4}, Lcom/google/android/maps/MapView;->getOverlays()Ljava/util/List;

    move-result-object v2

    .line 134
    .local v2, "mapOverlays":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/maps/Overlay;>;"
    new-instance v4, Lcom/google/android/maps/MyLocationOverlay;

    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-direct {v4, p0, v5}, Lcom/google/android/maps/MyLocationOverlay;-><init>(Landroid/content/Context;Lcom/google/android/maps/MapView;)V

    iput-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    .line 135
    iget-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 138
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->cvsd_search_option_button:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 139
    .local v3, "searchOptionsButton":Landroid/widget/Button;
    new-instance v4, Lcom/amazon/mShop/cvsd/CVSDMapActivity$1;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$1;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 152
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->cvsd_current_location_button:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 153
    .local v0, "currentLocationButton":Landroid/widget/Button;
    new-instance v4, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$2;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 194
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 195
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v4, "allowUseUserCurrentlocation"

    invoke-interface {v1, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 196
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByCurrentLocation()V

    .line 202
    :goto_1
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->centerMapBasedOnMarket()V

    goto :goto_0

    .line 198
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->showUseCurrentLocationConfirmationDialog()V

    goto :goto_1
.end method

.method public onDeliveryLocationsReceived(Ljava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "resultAddressList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Address;>;"
    const/4 v9, 0x0

    const-wide v7, 0x3ff3333333333333L    # 1.2

    .line 1005
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 1006
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->android_cvsd_pin:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 1007
    .local v2, "pinDrawable":Landroid/graphics/drawable/Drawable;
    new-instance v3, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    invoke-direct {v3, v2, p1, p0}, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;-><init>(Landroid/graphics/drawable/Drawable;Ljava/util/List;Lcom/amazon/mShop/cvsd/ConvenienceStoreMarkerTapListener;)V

    iput-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    .line 1008
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v3}, Lcom/google/android/maps/MapView;->getOverlays()Ljava/util/List;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1009
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v3}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    invoke-virtual {v4}, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->getLatSpanE6()I

    move-result v4

    int-to-double v4, v4

    mul-double/2addr v4, v7

    double-to-int v4, v4

    iget-object v5, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    invoke-virtual {v5}, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->getLonSpanE6()I

    move-result v5

    int-to-double v5, v5

    mul-double/2addr v5, v7

    double-to-int v5, v5

    invoke-virtual {v3, v4, v5}, Lcom/google/android/maps/MapController;->zoomToSpan(II)V

    .line 1011
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    invoke-virtual {v3, v9}, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->getItem(I)Lcom/google/android/maps/OverlayItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/maps/OverlayItem;->getPoint()Lcom/google/android/maps/GeoPoint;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/maps/GeoPoint;->getLatitudeE6()I

    move-result v0

    .line 1012
    .local v0, "lat":I
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    invoke-virtual {v3, v9}, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->getItem(I)Lcom/google/android/maps/OverlayItem;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/maps/OverlayItem;->getPoint()Lcom/google/android/maps/GeoPoint;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/maps/GeoPoint;->getLongitudeE6()I

    move-result v1

    .line 1013
    .local v1, "lon":I
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v3}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v3

    new-instance v4, Lcom/google/android/maps/GeoPoint;

    invoke-direct {v4, v0, v1}, Lcom/google/android/maps/GeoPoint;-><init>(II)V

    invoke-virtual {v3, v4}, Lcom/google/android/maps/MapController;->animateTo(Lcom/google/android/maps/GeoPoint;)V

    .line 1015
    .end local v0    # "lat":I
    .end local v1    # "lon":I
    .end local v2    # "pinDrawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 1036
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/cvsd/CVSDController;->setSubscriber(Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;)V

    .line 1037
    invoke-super {p0}, Lcom/google/android/maps/MapActivity;->onDestroy()V

    .line 1038
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 1032
    return-void
.end method

.method public onNoOverlayItemTap()V
    .locals 2

    .prologue
    .line 870
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    if-eqz v0, :cond_0

    .line 871
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 873
    :cond_0
    return-void
.end method

.method public onOnlyMessageReceived(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 1019
    invoke-static {p0, p1}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;)V

    .line 1020
    return-void
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 232
    invoke-super {p0}, Lcom/google/android/maps/MapActivity;->onPause()V

    .line 238
    const-string/jumbo v1, "location"

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 240
    .local v0, "locationManager":Landroid/location/LocationManager;
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocationLocationListener:Landroid/location/LocationListener;

    if-eqz v1, :cond_0

    .line 241
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocationLocationListener:Landroid/location/LocationListener;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 244
    :cond_0
    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocationLocationListener:Landroid/location/LocationListener;

    if-eqz v1, :cond_1

    .line 245
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocationLocationListener:Landroid/location/LocationListener;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 249
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    if-eqz v1, :cond_2

    .line 250
    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    invoke-virtual {v1}, Lcom/google/android/maps/MyLocationOverlay;->disableMyLocation()V

    .line 252
    :cond_2
    return-void
.end method

.method public onRefinementsReceived()V
    .locals 2

    .prologue
    .line 1024
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/amazon/mShop/cvsd/CVSDRefinmentsActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1025
    .local v0, "intent":Landroid/content/Intent;
    const/16 v1, 0x8

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1027
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 256
    invoke-super {p0}, Lcom/google/android/maps/MapActivity;->onResume()V

    .line 258
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "allowUseUserCurrentlocation"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 259
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    if-eqz v0, :cond_0

    .line 260
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMyLocationOverlay:Lcom/google/android/maps/MyLocationOverlay;

    invoke-virtual {v0}, Lcom/google/android/maps/MyLocationOverlay;->enableMyLocation()Z

    .line 263
    :cond_0
    return-void
.end method

.method public onTap(Lcom/google/android/maps/OverlayItem;)V
    .locals 13
    .param p1, "item"    # Lcom/google/android/maps/OverlayItem;

    .prologue
    const/16 v6, 0x51

    const/4 v4, 0x0

    const/4 v1, -0x2

    .line 816
    invoke-virtual {p1}, Lcom/google/android/maps/OverlayItem;->getPoint()Lcom/google/android/maps/GeoPoint;

    move-result-object v3

    .line 818
    .local v3, "gp":Lcom/google/android/maps/GeoPoint;
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v0}, Lcom/google/android/maps/MapView;->getProjection()Lcom/google/android/maps/Projection;

    move-result-object v9

    .line 820
    .local v9, "projection":Lcom/google/android/maps/Projection;
    new-instance v8, Landroid/graphics/Point;

    invoke-direct {v8}, Landroid/graphics/Point;-><init>()V

    .line 822
    .local v8, "p":Landroid/graphics/Point;
    invoke-interface {v9, v3, v8}, Lcom/google/android/maps/Projection;->toPixels(Lcom/google/android/maps/GeoPoint;Landroid/graphics/Point;)Landroid/graphics/Point;

    .line 824
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$drawable;->android_cvsd_pin:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v7

    .line 826
    .local v7, "height":I
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    if-nez v0, :cond_0

    .line 827
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->cvsd_bubble_button:I

    const/4 v5, 0x0

    invoke-virtual {v0, v2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    .line 828
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setSingleLine(Z)V

    .line 829
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 831
    iget-object v12, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    new-instance v0, Lcom/google/android/maps/MapView$LayoutParams;

    neg-int v5, v7

    move v2, v1

    invoke-direct/range {v0 .. v6}, Lcom/google/android/maps/MapView$LayoutParams;-><init>(IILcom/google/android/maps/GeoPoint;III)V

    invoke-virtual {v12, v0}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 834
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    invoke-virtual {p1}, Lcom/google/android/maps/OverlayItem;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 836
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    invoke-virtual {v0, v1}, Lcom/google/android/maps/MapView;->addView(Landroid/view/View;)V

    .line 844
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mConvenienceStoreOverlay:Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/cvsd/ConvenienceStoreOverlay;->getOverlayItemIndex(Lcom/google/android/maps/OverlayItem;)I

    move-result v11

    .line 847
    .local v11, "selectedItemIndex":I
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->mMapView:Lcom/google/android/maps/MapView;

    invoke-virtual {v0}, Lcom/google/android/maps/MapView;->getController()Lcom/google/android/maps/MapController;

    move-result-object v0

    invoke-virtual {p1}, Lcom/google/android/maps/OverlayItem;->getPoint()Lcom/google/android/maps/GeoPoint;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/maps/MapController;->animateTo(Lcom/google/android/maps/GeoPoint;)V

    .line 849
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->cvsdController:Lcom/amazon/mShop/control/cvsd/CVSDController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->getResultAddressList()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 851
    .local v10, "selectedAddress":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    new-instance v1, Lcom/amazon/mShop/cvsd/CVSDMapActivity$15;

    invoke-direct {v1, p0, v10}, Lcom/amazon/mShop/cvsd/CVSDMapActivity$15;-><init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Lcom/amazon/rio/j2me/client/services/mShop/Address;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 866
    return-void

    .line 838
    .end local v10    # "selectedAddress":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v11    # "selectedItemIndex":I
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 839
    iget-object v12, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    new-instance v0, Lcom/google/android/maps/MapView$LayoutParams;

    neg-int v5, v7

    move v2, v1

    invoke-direct/range {v0 .. v6}, Lcom/google/android/maps/MapView$LayoutParams;-><init>(IILcom/google/android/maps/GeoPoint;III)V

    invoke-virtual {v12, v0}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 841
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->bubble:Landroid/widget/Button;

    invoke-virtual {p1}, Lcom/google/android/maps/OverlayItem;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
