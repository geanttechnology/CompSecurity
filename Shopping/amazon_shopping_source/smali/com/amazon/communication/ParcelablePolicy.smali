.class public Lcom/amazon/communication/ParcelablePolicy;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/communication/ParcelablePolicy;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mPolicy:Lamazon/communication/connection/Policy;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/amazon/communication/ParcelablePolicy$1;

    invoke-direct {v0}, Lcom/amazon/communication/ParcelablePolicy$1;-><init>()V

    sput-object v0, Lcom/amazon/communication/ParcelablePolicy;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Lamazon/communication/connection/Policy;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "policy must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 3

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v0, 0x2

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->getCompressionOption()Lamazon/communication/connection/CompressionOption;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/CompressionOption;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->getPriority()Lamazon/communication/connection/Priority;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/Priority;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->isLowLatencyNecessary()Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->isRequestResponseOnly()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->isClearText()Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->isWiFiNecessary()Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_3
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->isAnonymousCredentialsAllowed()Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    :goto_4
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->isDedicated()Z

    move-result v0

    if-eqz v0, :cond_5

    move v0, v1

    :goto_5
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->getPurpose()Lamazon/communication/connection/Purpose;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/Purpose;->getPurpose()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->getReconnectOnFailure()Z

    move-result v0

    if-eqz v0, :cond_6

    :goto_6
    int-to-byte v0, v1

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/amazon/communication/ParcelablePolicy;->mPolicy:Lamazon/communication/connection/Policy;

    invoke-virtual {v0}, Lamazon/communication/connection/Policy;->getKeepAlive()Lamazon/communication/connection/KeepAlive;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/KeepAlive;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    return-void

    :cond_0
    move v0, v2

    goto :goto_0

    :cond_1
    move v0, v2

    goto :goto_1

    :cond_2
    move v0, v2

    goto :goto_2

    :cond_3
    move v0, v2

    goto :goto_3

    :cond_4
    move v0, v2

    goto :goto_4

    :cond_5
    move v0, v2

    goto :goto_5

    :cond_6
    move v1, v2

    goto :goto_6
.end method
