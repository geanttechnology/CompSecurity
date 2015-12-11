.class public Lcom/amazon/communication/ParcelableEndpointIdentity;
.super Lamazon/communication/identity/EndpointIdentity;

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/communication/ParcelableEndpointIdentity$Creator;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/communication/ParcelableEndpointIdentity;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mIdentity:Lamazon/communication/identity/EndpointIdentity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/amazon/communication/ParcelableEndpointIdentity$Creator;

    invoke-direct {v0}, Lcom/amazon/communication/ParcelableEndpointIdentity$Creator;-><init>()V

    sput-object v0, Lcom/amazon/communication/ParcelableEndpointIdentity;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Lamazon/communication/identity/EndpointIdentity;)V
    .locals 0

    invoke-direct {p0}, Lamazon/communication/identity/EndpointIdentity;-><init>()V

    iput-object p1, p0, Lcom/amazon/communication/ParcelableEndpointIdentity;->mIdentity:Lamazon/communication/identity/EndpointIdentity;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public toLogSafeString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ParcelableEndpointIdentity;->mIdentity:Lamazon/communication/identity/EndpointIdentity;

    invoke-virtual {v0}, Lamazon/communication/identity/EndpointIdentity;->toLogSafeString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ParcelableEndpointIdentity;->mIdentity:Lamazon/communication/identity/EndpointIdentity;

    invoke-virtual {v0}, Lamazon/communication/identity/EndpointIdentity;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ParcelableEndpointIdentity;->mIdentity:Lamazon/communication/identity/EndpointIdentity;

    invoke-virtual {v0}, Lamazon/communication/identity/EndpointIdentity;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    return-void
.end method
