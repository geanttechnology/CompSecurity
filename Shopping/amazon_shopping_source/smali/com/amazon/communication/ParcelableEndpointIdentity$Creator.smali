.class Lcom/amazon/communication/ParcelableEndpointIdentity$Creator;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/communication/ParcelableEndpointIdentity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Creator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/amazon/communication/ParcelableEndpointIdentity;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ParcelableEndpointIdentity;
    .locals 2

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/identity/EndpointIdentityFactory;->createFromUrn(Ljava/lang/String;)Lamazon/communication/identity/EndpointIdentity;

    move-result-object v0

    new-instance v1, Lcom/amazon/communication/ParcelableEndpointIdentity;

    invoke-direct {v1, v0}, Lcom/amazon/communication/ParcelableEndpointIdentity;-><init>(Lamazon/communication/identity/EndpointIdentity;)V

    return-object v1
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ParcelableEndpointIdentity$Creator;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ParcelableEndpointIdentity;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/communication/ParcelableEndpointIdentity;
    .locals 1

    new-array v0, p1, [Lcom/amazon/communication/ParcelableEndpointIdentity;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ParcelableEndpointIdentity$Creator;->newArray(I)[Lcom/amazon/communication/ParcelableEndpointIdentity;

    move-result-object v0

    return-object v0
.end method
