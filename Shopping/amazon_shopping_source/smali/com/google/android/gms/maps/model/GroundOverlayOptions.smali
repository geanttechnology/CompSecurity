.class public final Lcom/google/android/gms/maps/model/GroundOverlayOptions;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/maps/model/GroundOverlayOptionsCreator;


# instance fields
.field private aaA:Lcom/google/android/gms/maps/model/BitmapDescriptor;

.field private aaB:Lcom/google/android/gms/maps/model/LatLng;

.field private aaC:F

.field private aaD:F

.field private aaE:Lcom/google/android/gms/maps/model/LatLngBounds;

.field private aaF:F

.field private aaG:F

.field private aaH:F

.field private aaq:F

.field private aax:F

.field private aay:Z

.field private final xM:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/maps/model/GroundOverlayOptionsCreator;

    invoke-direct {v0}, Lcom/google/android/gms/maps/model/GroundOverlayOptionsCreator;-><init>()V

    sput-object v0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->CREATOR:Lcom/google/android/gms/maps/model/GroundOverlayOptionsCreator;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    const/4 v2, 0x1

    const/high16 v1, 0x3f000000    # 0.5f

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v2, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aay:Z

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaF:F

    iput v1, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaG:F

    iput v1, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaH:F

    iput v2, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->xM:I

    return-void
.end method

.method constructor <init>(ILandroid/os/IBinder;Lcom/google/android/gms/maps/model/LatLng;FFLcom/google/android/gms/maps/model/LatLngBounds;FFZFFF)V
    .locals 2
    .param p1, "versionCode"    # I
    .param p2, "wrappedImage"    # Landroid/os/IBinder;
    .param p3, "location"    # Lcom/google/android/gms/maps/model/LatLng;
    .param p4, "width"    # F
    .param p5, "height"    # F
    .param p6, "bounds"    # Lcom/google/android/gms/maps/model/LatLngBounds;
    .param p7, "bearing"    # F
    .param p8, "zIndex"    # F
    .param p9, "visible"    # Z
    .param p10, "transparency"    # F
    .param p11, "anchorU"    # F
    .param p12, "anchorV"    # F

    .prologue
    const/high16 v1, 0x3f000000    # 0.5f

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aay:Z

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaF:F

    iput v1, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaG:F

    iput v1, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaH:F

    iput p1, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->xM:I

    new-instance v0, Lcom/google/android/gms/maps/model/BitmapDescriptor;

    invoke-static {p2}, Lcom/google/android/gms/dynamic/d$a;->ag(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/maps/model/BitmapDescriptor;-><init>(Lcom/google/android/gms/dynamic/d;)V

    iput-object v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaA:Lcom/google/android/gms/maps/model/BitmapDescriptor;

    iput-object p3, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaB:Lcom/google/android/gms/maps/model/LatLng;

    iput p4, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaC:F

    iput p5, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaD:F

    iput-object p6, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaE:Lcom/google/android/gms/maps/model/LatLngBounds;

    iput p7, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaq:F

    iput p8, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aax:F

    iput-boolean p9, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aay:Z

    iput p10, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaF:F

    iput p11, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaG:F

    iput p12, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaH:F

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public getAnchorU()F
    .locals 1

    iget v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaG:F

    return v0
.end method

.method public getAnchorV()F
    .locals 1

    iget v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaH:F

    return v0
.end method

.method public getBearing()F
    .locals 1

    iget v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaq:F

    return v0
.end method

.method public getBounds()Lcom/google/android/gms/maps/model/LatLngBounds;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaE:Lcom/google/android/gms/maps/model/LatLngBounds;

    return-object v0
.end method

.method public getHeight()F
    .locals 1

    iget v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaD:F

    return v0
.end method

.method public getLocation()Lcom/google/android/gms/maps/model/LatLng;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaB:Lcom/google/android/gms/maps/model/LatLng;

    return-object v0
.end method

.method public getTransparency()F
    .locals 1

    iget v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaF:F

    return v0
.end method

.method getVersionCode()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->xM:I

    return v0
.end method

.method public getWidth()F
    .locals 1

    iget v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaC:F

    return v0
.end method

.method public getZIndex()F
    .locals 1

    iget v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aax:F

    return v0
.end method

.method public isVisible()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aay:Z

    return v0
.end method

.method jN()Landroid/os/IBinder;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/maps/model/GroundOverlayOptions;->aaA:Lcom/google/android/gms/maps/model/BitmapDescriptor;

    invoke-virtual {v0}, Lcom/google/android/gms/maps/model/BitmapDescriptor;->jn()Lcom/google/android/gms/dynamic/d;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/android/gms/dynamic/d;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    invoke-static {}, Lcom/google/android/gms/maps/internal/v;->jL()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/maps/model/c;->a(Lcom/google/android/gms/maps/model/GroundOverlayOptions;Landroid/os/Parcel;I)V

    :goto_0
    return-void

    :cond_0
    invoke-static {p0, p1, p2}, Lcom/google/android/gms/maps/model/GroundOverlayOptionsCreator;->a(Lcom/google/android/gms/maps/model/GroundOverlayOptions;Landroid/os/Parcel;I)V

    goto :goto_0
.end method
