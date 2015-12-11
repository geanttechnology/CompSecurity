.class Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint$Creator;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;
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
        "Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;",
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
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;
    .locals 12

    const/4 v9, 0x0

    const/4 v11, -0x1

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;->parse(Ljava/lang/String;)Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    move-result-object v4

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->parse(Ljava/lang/String;)Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    move-result-object v5

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;->parse(Ljava/lang/String;)Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    move-result-object v6

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v7

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v8

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v10

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    new-instance v0, Lcom/amazon/communication/ir/IRServiceEndpointImpl;

    if-ne v8, v11, :cond_0

    move-object v8, v9

    :goto_0
    if-ne v10, v11, :cond_1

    :goto_1
    invoke-direct/range {v0 .. v9}, Lcom/amazon/communication/ir/IRServiceEndpointImpl;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;Lamazon/communication/identity/IRServiceEndpoint$DataCompression;Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;ILjava/lang/Integer;Ljava/lang/Integer;)V

    new-instance v1, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;

    invoke-direct {v1, v0}, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;-><init>(Lamazon/communication/identity/IRServiceEndpoint;)V

    return-object v1

    :cond_0
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    goto :goto_0

    :cond_1
    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    goto :goto_1
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint$Creator;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;
    .locals 1

    new-array v0, p1, [Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint$Creator;->newArray(I)[Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;

    move-result-object v0

    return-object v0
.end method
