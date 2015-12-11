.class final Lcom/amazon/communication/MessageEnvelope$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/communication/MessageEnvelope;
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
        "Lcom/amazon/communication/MessageEnvelope;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private createFromByteArrayParcel(Landroid/os/Parcel;)Lcom/amazon/communication/MessageEnvelope;
    .locals 11

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v6

    new-array v7, v6, [Ljava/nio/ByteBuffer;

    move v3, v2

    move v4, v2

    :goto_0
    if-ge v4, v5, :cond_1

    invoke-virtual {p1}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v8

    array-length v0, v8

    add-int/2addr v0, v4

    if-gt v0, v5, :cond_0

    move v0, v1

    :goto_1
    new-array v9, v1, [Ljava/lang/Object;

    const-string/jumbo v10, "Received more data than expected from a Parcel"

    aput-object v10, v9, v2

    invoke-static {v0, v9}, Lcom/dp/utils/FailFast;->expectTrue(Z[Ljava/lang/Object;)V

    invoke-static {v8}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    aput-object v0, v7, v3

    array-length v0, v8

    add-int/2addr v4, v0

    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_0

    :cond_0
    move v0, v2

    goto :goto_1

    :cond_1
    new-array v0, v1, [Ljava/lang/Object;

    const-string/jumbo v8, "Expected message size did not match total number of bytes read"

    aput-object v8, v0, v2

    invoke-static {v5, v4, v0}, Lcom/dp/utils/FailFast;->expectEquals(II[Ljava/lang/Object;)V

    new-array v0, v1, [Ljava/lang/Object;

    const-string/jumbo v1, "Did not read the expected number of buffers from the parcel"

    aput-object v1, v0, v2

    invoke-static {v6, v3, v0}, Lcom/dp/utils/FailFast;->expectEquals(II[Ljava/lang/Object;)V

    new-instance v0, Lcom/amazon/communication/MessageEnvelope;

    invoke-static {v7}, Lamazon/communication/MessageFactory;->createMessage([Ljava/nio/ByteBuffer;)Lamazon/communication/Message;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/communication/MessageEnvelope;-><init>(Lamazon/communication/Message;)V

    return-object v0
.end method

.method private createFromInputStreamParcel(Landroid/os/Parcel;)Lcom/amazon/communication/MessageEnvelope;
    .locals 3

    invoke-virtual {p1}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/communication/LargeArrayOptimizedIInputStream;->makeIInputStream(Landroid/os/IBinder;)Lcom/amazon/communication/IInputStream;

    move-result-object v0

    new-instance v1, Lcom/amazon/communication/MessageEnvelope;

    new-instance v2, Lcom/amazon/communication/ServiceSideInputStreamProxy;

    invoke-direct {v2, v0}, Lcom/amazon/communication/ServiceSideInputStreamProxy;-><init>(Lcom/amazon/communication/IInputStream;)V

    invoke-static {v2}, Lamazon/communication/MessageFactory;->createMessage(Ljava/io/InputStream;)Lamazon/communication/Message;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/amazon/communication/MessageEnvelope;-><init>(Lamazon/communication/Message;)V

    return-object v1
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/MessageEnvelope;
    .locals 2

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    invoke-direct {p0, p1}, Lcom/amazon/communication/MessageEnvelope$1;->createFromInputStreamParcel(Landroid/os/Parcel;)Lcom/amazon/communication/MessageEnvelope;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/communication/MessageEnvelope$1;->createFromByteArrayParcel(Landroid/os/Parcel;)Lcom/amazon/communication/MessageEnvelope;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/MessageEnvelope$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/communication/MessageEnvelope;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/communication/MessageEnvelope;
    .locals 1

    new-array v0, p1, [Lcom/amazon/communication/MessageEnvelope;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/communication/MessageEnvelope$1;->newArray(I)[Lcom/amazon/communication/MessageEnvelope;

    move-result-object v0

    return-object v0
.end method
