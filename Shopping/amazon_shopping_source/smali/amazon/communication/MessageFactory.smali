.class public final Lamazon/communication/MessageFactory;
.super Ljava/lang/Object;
.source "MessageFactory.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    return-void
.end method

.method public static createMessage(Ljava/io/InputStream;)Lamazon/communication/Message;
    .locals 2
    .param p0, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 61
    if-nez p0, :cond_0

    .line 62
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "InputStream should not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 64
    :cond_0
    new-instance v0, Lcom/amazon/communication/InputStreamMessageImpl;

    invoke-direct {v0, p0}, Lcom/amazon/communication/InputStreamMessageImpl;-><init>(Ljava/io/InputStream;)V

    return-object v0
.end method

.method public static createMessage([Ljava/nio/ByteBuffer;)Lamazon/communication/Message;
    .locals 2
    .param p0, "buffers"    # [Ljava/nio/ByteBuffer;

    .prologue
    .line 48
    if-eqz p0, :cond_0

    array-length v0, p0

    if-nez v0, :cond_1

    .line 49
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "ByteBuffer should not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_1
    new-instance v0, Lcom/amazon/communication/ByteBufferChainMessageImpl;

    invoke-direct {v0, p0}, Lcom/amazon/communication/ByteBufferChainMessageImpl;-><init>([Ljava/nio/ByteBuffer;)V

    return-object v0
.end method
