.class final Lcom/amazon/communication/ParcelablePolicy$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/communication/ParcelablePolicy;
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
        "Lcom/amazon/communication/ParcelablePolicy;",
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
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ParcelablePolicy;
    .locals 12

    const/4 v2, 0x0

    const/4 v1, 0x1

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_6

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/connection/CompressionOption;->valueOf(Ljava/lang/String;)Lamazon/communication/connection/CompressionOption;

    move-result-object v7

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/connection/Priority;->valueOf(Ljava/lang/String;)Lamazon/communication/connection/Priority;

    move-result-object v8

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v3

    if-eqz v3, :cond_1

    move v3, v1

    :goto_1
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v4

    if-eqz v4, :cond_2

    move v4, v1

    :goto_2
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v5

    if-eqz v5, :cond_3

    move v5, v1

    :goto_3
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v6

    if-eqz v6, :cond_4

    move v6, v1

    :goto_4
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v9

    if-eqz v9, :cond_5

    :goto_5
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    new-instance v9, Lamazon/communication/connection/Policy$Builder;

    invoke-direct {v9}, Lamazon/communication/connection/Policy$Builder;-><init>()V

    invoke-virtual {v9, v7}, Lamazon/communication/connection/Policy$Builder;->setCompressionOption(Lamazon/communication/connection/CompressionOption;)Lamazon/communication/connection/Policy$Builder;

    move-result-object v7

    invoke-virtual {v7, v8}, Lamazon/communication/connection/Policy$Builder;->setPriority(Lamazon/communication/connection/Priority;)Lamazon/communication/connection/Policy$Builder;

    move-result-object v7

    invoke-virtual {v7, v0}, Lamazon/communication/connection/Policy$Builder;->setIsLowLatencyNecessary(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v3}, Lamazon/communication/connection/Policy$Builder;->setIsRequestResponseOnly(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v4}, Lamazon/communication/connection/Policy$Builder;->setIsClearText(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v5}, Lamazon/communication/connection/Policy$Builder;->setIsWiFiNecessary(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v6}, Lamazon/communication/connection/Policy$Builder;->setIsAnonymousCredentialsAllowed(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Lamazon/communication/connection/Policy$Builder;->setIsDedicated(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    new-instance v1, Lamazon/communication/connection/Purpose;

    invoke-direct {v1, v2}, Lamazon/communication/connection/Purpose;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lamazon/communication/connection/Policy$Builder;->setPurpose(Lamazon/communication/connection/Purpose;)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/Policy$Builder;->build()Lamazon/communication/connection/Policy;

    move-result-object v1

    new-instance v0, Lcom/amazon/communication/ParcelablePolicy;

    invoke-direct {v0, v1}, Lcom/amazon/communication/ParcelablePolicy;-><init>(Lamazon/communication/connection/Policy;)V

    :goto_6
    return-object v0

    :cond_0
    move v0, v2

    goto :goto_0

    :cond_1
    move v3, v2

    goto :goto_1

    :cond_2
    move v4, v2

    goto :goto_2

    :cond_3
    move v5, v2

    goto :goto_3

    :cond_4
    move v6, v2

    goto :goto_4

    :cond_5
    move v1, v2

    goto :goto_5

    :cond_6
    const/4 v3, 0x2

    if-ne v0, v3, :cond_e

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/connection/CompressionOption;->valueOf(Ljava/lang/String;)Lamazon/communication/connection/CompressionOption;

    move-result-object v8

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/connection/Priority;->valueOf(Ljava/lang/String;)Lamazon/communication/connection/Priority;

    move-result-object v9

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_7

    move v0, v1

    :goto_7
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v3

    if-eqz v3, :cond_8

    move v3, v1

    :goto_8
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v4

    if-eqz v4, :cond_9

    move v4, v1

    :goto_9
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v5

    if-eqz v5, :cond_a

    move v5, v1

    :goto_a
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v6

    if-eqz v6, :cond_b

    move v6, v1

    :goto_b
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v7

    if-eqz v7, :cond_c

    move v7, v1

    :goto_c
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v11

    if-eqz v11, :cond_d

    :goto_d
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lamazon/communication/connection/KeepAlive;->valueOf(Ljava/lang/String;)Lamazon/communication/connection/KeepAlive;

    move-result-object v2

    new-instance v11, Lamazon/communication/connection/Policy$Builder;

    invoke-direct {v11}, Lamazon/communication/connection/Policy$Builder;-><init>()V

    invoke-virtual {v11, v8}, Lamazon/communication/connection/Policy$Builder;->setCompressionOption(Lamazon/communication/connection/CompressionOption;)Lamazon/communication/connection/Policy$Builder;

    move-result-object v8

    invoke-virtual {v8, v9}, Lamazon/communication/connection/Policy$Builder;->setPriority(Lamazon/communication/connection/Priority;)Lamazon/communication/connection/Policy$Builder;

    move-result-object v8

    invoke-virtual {v8, v0}, Lamazon/communication/connection/Policy$Builder;->setIsLowLatencyNecessary(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v3}, Lamazon/communication/connection/Policy$Builder;->setIsRequestResponseOnly(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v4}, Lamazon/communication/connection/Policy$Builder;->setIsClearText(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v5}, Lamazon/communication/connection/Policy$Builder;->setIsWiFiNecessary(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v6}, Lamazon/communication/connection/Policy$Builder;->setIsAnonymousCredentialsAllowed(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v7}, Lamazon/communication/connection/Policy$Builder;->setIsDedicated(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    new-instance v3, Lamazon/communication/connection/Purpose;

    invoke-direct {v3, v10}, Lamazon/communication/connection/Purpose;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Lamazon/communication/connection/Policy$Builder;->setPurpose(Lamazon/communication/connection/Purpose;)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Lamazon/communication/connection/Policy$Builder;->setReconnectOnFailure(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v2}, Lamazon/communication/connection/Policy$Builder;->setKeepAlive(Lamazon/communication/connection/KeepAlive;)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/Policy$Builder;->build()Lamazon/communication/connection/Policy;

    move-result-object v1

    new-instance v0, Lcom/amazon/communication/ParcelablePolicy;

    invoke-direct {v0, v1}, Lcom/amazon/communication/ParcelablePolicy;-><init>(Lamazon/communication/connection/Policy;)V

    goto/16 :goto_6

    :cond_7
    move v0, v2

    goto :goto_7

    :cond_8
    move v3, v2

    goto :goto_8

    :cond_9
    move v4, v2

    goto :goto_9

    :cond_a
    move v5, v2

    goto :goto_a

    :cond_b
    move v6, v2

    goto :goto_b

    :cond_c
    move v7, v2

    goto :goto_c

    :cond_d
    move v1, v2

    goto :goto_d

    :cond_e
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Unrecognized version: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ParcelablePolicy$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/ParcelablePolicy;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/communication/ParcelablePolicy;
    .locals 1

    new-array v0, p1, [Lcom/amazon/communication/ParcelablePolicy;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/ParcelablePolicy$1;->newArray(I)[Lcom/amazon/communication/ParcelablePolicy;

    move-result-object v0

    return-object v0
.end method
