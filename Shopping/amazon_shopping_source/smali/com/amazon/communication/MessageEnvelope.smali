.class public Lcom/amazon/communication/MessageEnvelope;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/communication/MessageEnvelope;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mMessage:Lamazon/communication/Message;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/amazon/communication/MessageEnvelope$1;

    invoke-direct {v0}, Lcom/amazon/communication/MessageEnvelope$1;-><init>()V

    sput-object v0, Lcom/amazon/communication/MessageEnvelope;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(Lamazon/communication/Message;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/amazon/communication/MessageEnvelope;->mMessage:Lamazon/communication/Message;

    return-void
.end method

.method private copyDataIntoParcelOrConvertToInputStream(Landroid/os/Parcel;)V
    .locals 9

    const/4 v2, 0x1

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/amazon/communication/MessageEnvelope;->mMessage:Lamazon/communication/Message;

    check-cast v0, Lcom/amazon/communication/ByteBufferChainMessageImpl;

    invoke-virtual {v0}, Lcom/amazon/communication/ByteBufferChainMessageImpl;->getPayloadSize()I

    move-result v4

    if-lez v4, :cond_0

    move v1, v2

    :goto_0
    new-array v5, v2, [Ljava/lang/Object;

    const-string/jumbo v6, "Message payload size is not greater than 0"

    aput-object v6, v5, v3

    invoke-static {v1, v5}, Lcom/dp/utils/FailFast;->expectTrue(Z[Ljava/lang/Object;)V

    const v1, 0x19000

    if-le v4, v1, :cond_1

    invoke-direct {p0, p1}, Lcom/amazon/communication/MessageEnvelope;->putInputStreamIntoParcel(Landroid/os/Parcel;)V

    :goto_1
    return-void

    :cond_0
    move v1, v3

    goto :goto_0

    :cond_1
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeByte(B)V

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {v0}, Lcom/amazon/communication/ByteBufferChainMessageImpl;->getByteBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v5

    array-length v0, v5

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    move v0, v3

    move v1, v3

    :goto_2
    array-length v6, v5

    if-ge v0, v6, :cond_2

    aget-object v6, v5, v0

    invoke-virtual {v6}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v6

    aget-object v7, v5, v0

    invoke-virtual {v7}, Ljava/nio/ByteBuffer;->position()I

    move-result v7

    aget-object v8, v5, v0

    invoke-virtual {v8}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v8

    invoke-virtual {p1, v6, v7, v8}, Landroid/os/Parcel;->writeByteArray([BII)V

    aget-object v6, v5, v0

    invoke-virtual {v6}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v6

    add-int/2addr v1, v6

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_2
    new-array v6, v2, [Ljava/lang/Object;

    const-string/jumbo v7, "Message payload size did not match the number of bytes written"

    aput-object v7, v6, v3

    invoke-static {v4, v1, v6}, Lcom/dp/utils/FailFast;->expectEquals(II[Ljava/lang/Object;)V

    array-length v1, v5

    new-array v2, v2, [Ljava/lang/Object;

    const-string/jumbo v4, "Did not write the expected number of buffers into the Parcel"

    aput-object v4, v2, v3

    invoke-static {v1, v0, v2}, Lcom/dp/utils/FailFast;->expectEquals(II[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method private isInputStreamBackedMessage()Z
    .locals 1

    iget-object v0, p0, Lcom/amazon/communication/MessageEnvelope;->mMessage:Lamazon/communication/Message;

    instance-of v0, v0, Lcom/amazon/communication/InputStreamMessageImpl;

    return v0
.end method

.method private putInputStreamIntoParcel(Landroid/os/Parcel;)V
    .locals 2

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    new-instance v0, Lcom/amazon/communication/InputStreamProxy;

    iget-object v1, p0, Lcom/amazon/communication/MessageEnvelope;->mMessage:Lamazon/communication/Message;

    invoke-interface {v1}, Lamazon/communication/Message;->getPayload()Ljava/io/InputStream;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/communication/InputStreamProxy;-><init>(Ljava/io/InputStream;)V

    invoke-virtual {v0}, Lcom/amazon/communication/InputStreamProxy;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    invoke-direct {p0}, Lcom/amazon/communication/MessageEnvelope;->isInputStreamBackedMessage()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/amazon/communication/MessageEnvelope;->putInputStreamIntoParcel(Landroid/os/Parcel;)V

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/communication/MessageEnvelope;->copyDataIntoParcelOrConvertToInputStream(Landroid/os/Parcel;)V

    goto :goto_0
.end method
