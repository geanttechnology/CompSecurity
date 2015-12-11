.class public Lcom/amazon/communication/ByteBufferChainInputStream;
.super Ljava/io/InputStream;
.source "ByteBufferChainInputStream.java"


# instance fields
.field private final mBuffers:[Ljava/nio/ByteBuffer;

.field private mPosition:I


# direct methods
.method public constructor <init>(Lcom/amazon/communication/ByteBufferChain;)V
    .locals 1
    .param p1, "chain"    # Lcom/amazon/communication/ByteBufferChain;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 33
    invoke-virtual {p1}, Lcom/amazon/communication/ByteBufferChain;->getByteBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    .line 34
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    .line 35
    return-void
.end method


# virtual methods
.method public available()I
    .locals 3

    .prologue
    .line 117
    const/4 v0, 0x0

    .line 118
    .local v0, "available":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 119
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    aget-object v2, v2, v1

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v2

    add-int/2addr v0, v2

    .line 118
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 121
    :cond_0
    return v0
.end method

.method public read()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 51
    const/4 v0, -0x1

    .line 52
    .local v0, "data":I
    :goto_0
    iget v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    array-length v3, v3

    if-ge v2, v3, :cond_0

    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    iget v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v2

    if-nez v2, :cond_0

    .line 53
    iget v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    goto :goto_0

    .line 55
    :cond_0
    iget v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    array-length v3, v3

    if-ge v2, v3, :cond_1

    .line 57
    :try_start_0
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    iget v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->get()B
    :try_end_0
    .catch Ljava/nio/BufferUnderflowException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    and-int/lit16 v0, v2, 0xff

    .line 62
    :cond_1
    return v0

    .line 58
    :catch_0
    move-exception v1

    .line 59
    .local v1, "e":Ljava/nio/BufferUnderflowException;
    new-instance v2, Ljava/io/IOException;

    invoke-direct {v2, v1}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method public read([BII)I
    .locals 5
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 81
    if-ltz p2, :cond_0

    if-ltz p3, :cond_0

    array-length v2, p1

    if-le p2, v2, :cond_1

    .line 82
    :cond_0
    new-instance v2, Ljava/lang/ArrayIndexOutOfBoundsException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "length="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v4, p1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "; regionStart="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "; regionLength="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 85
    :cond_1
    if-nez p3, :cond_3

    .line 86
    const/4 v1, 0x0

    .line 107
    :cond_2
    :goto_0
    return v1

    .line 89
    :cond_3
    :goto_1
    iget v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    array-length v3, v3

    if-ge v2, v3, :cond_4

    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    iget v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v2

    if-nez v2, :cond_4

    .line 90
    iget v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    goto :goto_1

    .line 93
    :cond_4
    const/4 v1, 0x0

    .line 95
    .local v1, "totalRead":I
    :cond_5
    :goto_2
    if-ge v1, p3, :cond_6

    iget v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    array-length v3, v3

    if-ge v2, v3, :cond_6

    .line 96
    sub-int v2, p3, v1

    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    iget v4, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    aget-object v3, v3, v4

    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 97
    .local v0, "amountToRead":I
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mBuffers:[Ljava/nio/ByteBuffer;

    iget v3, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    aget-object v2, v2, v3

    add-int v3, p2, v1

    invoke-virtual {v2, p1, v3, v0}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    .line 98
    add-int/2addr v1, v0

    .line 99
    if-ge v1, p3, :cond_5

    .line 100
    iget v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/amazon/communication/ByteBufferChainInputStream;->mPosition:I

    goto :goto_2

    .line 104
    .end local v0    # "amountToRead":I
    :cond_6
    if-gtz v1, :cond_2

    .line 107
    const/4 v1, -0x1

    goto :goto_0
.end method
