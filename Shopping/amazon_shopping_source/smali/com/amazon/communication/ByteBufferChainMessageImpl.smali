.class public Lcom/amazon/communication/ByteBufferChainMessageImpl;
.super Ljava/lang/Object;
.source "ByteBufferChainMessageImpl.java"

# interfaces
.implements Lamazon/communication/Message;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

.field private mPayloadSize:I

.field private mPreviousPayload:Ljava/io/InputStream;

.field private mSavedPositions:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.ByteBufferChainMessageImpl"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 80
    new-instance v0, Lcom/amazon/communication/ByteBufferChain;

    invoke-direct {v0}, Lcom/amazon/communication/ByteBufferChain;-><init>()V

    invoke-direct {p0, v0}, Lcom/amazon/communication/ByteBufferChainMessageImpl;-><init>(Lcom/amazon/communication/ByteBufferChain;)V

    .line 81
    return-void
.end method

.method public constructor <init>(Lcom/amazon/communication/ByteBufferChain;)V
    .locals 2
    .param p1, "chain"    # Lcom/amazon/communication/ByteBufferChain;

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mSavedPositions:Z

    .line 59
    if-nez p1, :cond_0

    .line 60
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "ByteBufferChain cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_0
    iput-object p1, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    .line 63
    invoke-direct {p0}, Lcom/amazon/communication/ByteBufferChainMessageImpl;->calculatePayloadSize()V

    .line 64
    return-void
.end method

.method public constructor <init>([Ljava/nio/ByteBuffer;)V
    .locals 1
    .param p1, "buffers"    # [Ljava/nio/ByteBuffer;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mSavedPositions:Z

    .line 54
    new-instance v0, Lcom/amazon/communication/ByteBufferChain;

    invoke-direct {v0, p1}, Lcom/amazon/communication/ByteBufferChain;-><init>([Ljava/nio/ByteBuffer;)V

    iput-object v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    .line 55
    invoke-direct {p0}, Lcom/amazon/communication/ByteBufferChainMessageImpl;->calculatePayloadSize()V

    .line 56
    return-void
.end method

.method private calculatePayloadSize()V
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    invoke-virtual {v0}, Lcom/amazon/communication/ByteBufferChain;->getDataSize()I

    move-result v0

    iput v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mPayloadSize:I

    .line 211
    return-void
.end method

.method private resetByteBufferChain()V
    .locals 1

    .prologue
    .line 225
    iget-boolean v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mSavedPositions:Z

    if-eqz v0, :cond_0

    .line 226
    iget-object v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    invoke-virtual {v0}, Lcom/amazon/communication/ByteBufferChain;->loadSavedPositions()V

    .line 228
    :cond_0
    iget-object v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    invoke-virtual {v0}, Lcom/amazon/communication/ByteBufferChain;->savePositions()V

    .line 229
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mSavedPositions:Z

    .line 230
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 283
    if-ne p0, p1, :cond_1

    .line 300
    :cond_0
    :goto_0
    return v1

    .line 286
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 287
    goto :goto_0

    .line 289
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 290
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 292
    check-cast v0, Lcom/amazon/communication/ByteBufferChainMessageImpl;

    .line 293
    .local v0, "other":Lcom/amazon/communication/ByteBufferChainMessageImpl;
    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    if-nez v3, :cond_4

    .line 294
    iget-object v3, v0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    if-eqz v3, :cond_0

    move v1, v2

    .line 295
    goto :goto_0

    .line 297
    :cond_4
    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    iget-object v4, v0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    invoke-virtual {v3, v4}, Lcom/amazon/communication/ByteBufferChain;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 298
    goto :goto_0
.end method

.method public getByteBuffers()[Ljava/nio/ByteBuffer;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    invoke-virtual {v0}, Lcom/amazon/communication/ByteBufferChain;->getByteBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v0

    return-object v0
.end method

.method public getPayload()Ljava/io/InputStream;
    .locals 6

    .prologue
    .line 245
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mPreviousPayload:Ljava/io/InputStream;

    if-eqz v1, :cond_0

    .line 247
    :try_start_0
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mPreviousPayload:Ljava/io/InputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->available()I

    move-result v1

    if-lez v1, :cond_0

    .line 248
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Unconsumed bytes found in previously returned payload. Not allowed to process multiple InputStreams returned from getPayload concurrently."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 252
    :catch_0
    move-exception v0

    .line 254
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/communication/ByteBufferChainMessageImpl;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "getPayload"

    const-string/jumbo v3, "unexpected exception while trying to find the size of previously returned payload"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 258
    .end local v0    # "e":Ljava/io/IOException;
    :cond_0
    invoke-direct {p0}, Lcom/amazon/communication/ByteBufferChainMessageImpl;->resetByteBufferChain()V

    .line 260
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    invoke-virtual {v1}, Lcom/amazon/communication/ByteBufferChain;->getInputStream()Lcom/amazon/communication/ByteBufferChainInputStream;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mPreviousPayload:Ljava/io/InputStream;

    .line 262
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mPreviousPayload:Ljava/io/InputStream;

    return-object v1
.end method

.method public getPayloadSize()I
    .locals 1

    .prologue
    .line 267
    iget v0, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mPayloadSize:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 275
    const/16 v0, 0x1f

    .line 276
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 277
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    add-int/lit8 v1, v2, 0x1f

    .line 278
    return v1

    .line 277
    :cond_0
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    invoke-virtual {v2}, Lcom/amazon/communication/ByteBufferChain;->hashCode()I

    move-result v2

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 305
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "ByteBufferChainMessageImpl [mByteBufferChain="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChainMessageImpl;->mByteBufferChain:Lcom/amazon/communication/ByteBufferChain;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
