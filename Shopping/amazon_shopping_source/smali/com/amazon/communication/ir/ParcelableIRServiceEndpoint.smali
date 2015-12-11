.class public Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;
.super Ljava/lang/Object;

# interfaces
.implements Lamazon/communication/identity/IRServiceEndpoint;
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint$Creator;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint$Creator;

    invoke-direct {v0}, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint$Creator;-><init>()V

    sput-object v0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Lamazon/communication/identity/IRServiceEndpoint;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public getClearTextConnection()Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getClearTextConnection()Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    move-result-object v0

    return-object v0
.end method

.method public getDataCompression()Lamazon/communication/identity/IRServiceEndpoint$DataCompression;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getDataCompression()Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    move-result-object v0

    return-object v0
.end method

.method public getDirectConnection()Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getDirectConnection()Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    move-result-object v0

    return-object v0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getDomain()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHostname()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getHostname()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPort()Ljava/lang/Integer;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getPort()Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getRealm()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getRealm()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSecurePort()Ljava/lang/Integer;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getSecurePort()Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getTimeout()I
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getTimeout()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2

    const/4 v1, -0x1

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getHostname()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getDomain()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getDirectConnection()Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/identity/IRServiceEndpoint$DirectConnection;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getDataCompression()Lamazon/communication/identity/IRServiceEndpoint$DataCompression;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/identity/IRServiceEndpoint$DataCompression;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getClearTextConnection()Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getTimeout()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getPort()Ljava/lang/Integer;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getSecurePort()Ljava/lang/Integer;

    move-result-object v0

    if-nez v0, :cond_1

    :goto_1
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getRealm()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    return-void

    :cond_0
    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getPort()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/amazon/communication/ir/ParcelableIRServiceEndpoint;->mEndpoint:Lamazon/communication/identity/IRServiceEndpoint;

    invoke-interface {v0}, Lamazon/communication/identity/IRServiceEndpoint;->getSecurePort()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_1
.end method
