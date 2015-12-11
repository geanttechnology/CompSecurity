.class final Lcom/amazon/communication/ParcelableConnectionPolicy$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/communication/ParcelableConnectionPolicy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/amazon/communication/ParcelableConnectionPolicy;",
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
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ParcelableConnectionPolicy;
    .locals 7

    const/4 v6, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    new-instance v3, Lcom/amazon/communication/ParcelableConnectionPolicy;

    invoke-direct {v3}, Lcom/amazon/communication/ParcelableConnectionPolicy;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setIsRoamingAllowed(Z)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setIsShortLived(Z)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setIsLowLatencyNecessary(Z)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    :goto_3
    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setIsRequestResponseOnly(Z)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    sget-object v4, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v4}, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->ordinal()I

    move-result v4

    if-ne v0, v4, :cond_4

    sget-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setCompressionOption(Lamazon/communication/connection/ConnectionPolicy$CompressionOption;)V

    :goto_4
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_7

    move v0, v1

    :goto_5
    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setIsClearText(Z)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_8

    move v0, v1

    :goto_6
    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setIsWiFiNecessary(Z)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_9

    move v0, v1

    :goto_7
    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setIsInstanceLocked(Z)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    sget-object v4, Lamazon/communication/connection/Priority;->PRIORITY_HIGH:Lamazon/communication/connection/Priority;

    invoke-virtual {v4}, Lamazon/communication/connection/Priority;->ordinal()I

    move-result v4

    if-ne v0, v4, :cond_a

    sget-object v0, Lamazon/communication/connection/Priority;->PRIORITY_HIGH:Lamazon/communication/connection/Priority;

    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setPriority(Lamazon/communication/connection/Priority;)V

    :goto_8
    return-object v3

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
    sget-object v4, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->NOT_ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v4}, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->ordinal()I

    move-result v4

    if-ne v0, v4, :cond_5

    sget-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->NOT_ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setCompressionOption(Lamazon/communication/connection/ConnectionPolicy$CompressionOption;)V

    goto :goto_4

    :cond_5
    sget-object v4, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->REQUIRED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v4}, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->ordinal()I

    move-result v4

    if-ne v0, v4, :cond_6

    sget-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->REQUIRED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setCompressionOption(Lamazon/communication/connection/ConnectionPolicy$CompressionOption;)V

    goto :goto_4

    :cond_6
    new-array v4, v6, [Ljava/lang/Object;

    const-string/jumbo v5, "Unknown ordinal value for CompressionOption "

    aput-object v5, v4, v2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v4, v1

    invoke-static {v2, v4}, Lcom/dp/utils/FailFast;->expectTrue(Z[Ljava/lang/Object;)V

    goto :goto_4

    :cond_7
    move v0, v2

    goto :goto_5

    :cond_8
    move v0, v2

    goto :goto_6

    :cond_9
    move v0, v2

    goto :goto_7

    :cond_a
    sget-object v4, Lamazon/communication/connection/Priority;->PRIORITY_NORMAL:Lamazon/communication/connection/Priority;

    invoke-virtual {v4}, Lamazon/communication/connection/Priority;->ordinal()I

    move-result v4

    if-ne v0, v4, :cond_b

    sget-object v0, Lamazon/communication/connection/Priority;->PRIORITY_NORMAL:Lamazon/communication/connection/Priority;

    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setPriority(Lamazon/communication/connection/Priority;)V

    goto :goto_8

    :cond_b
    sget-object v4, Lamazon/communication/connection/Priority;->PRIORITY_LOW:Lamazon/communication/connection/Priority;

    invoke-virtual {v4}, Lamazon/communication/connection/Priority;->ordinal()I

    move-result v4

    if-ne v0, v4, :cond_c

    sget-object v0, Lamazon/communication/connection/Priority;->PRIORITY_LOW:Lamazon/communication/connection/Priority;

    invoke-virtual {v3, v0}, Lcom/amazon/communication/ParcelableConnectionPolicy;->setPriority(Lamazon/communication/connection/Priority;)V

    goto :goto_8

    :cond_c
    new-array v4, v6, [Ljava/lang/Object;

    const-string/jumbo v5, "Unknown ordinal value for Priority "

    aput-object v5, v4, v2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v4, v1

    invoke-static {v2, v4}, Lcom/dp/utils/FailFast;->expectTrue(Z[Ljava/lang/Object;)V

    goto :goto_8
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ParcelableConnectionPolicy$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ParcelableConnectionPolicy;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/communication/ParcelableConnectionPolicy;
    .locals 1

    new-array v0, p1, [Lcom/amazon/communication/ParcelableConnectionPolicy;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ParcelableConnectionPolicy$1;->newArray(I)[Lcom/amazon/communication/ParcelableConnectionPolicy;

    move-result-object v0

    return-object v0
.end method
