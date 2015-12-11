.class public Lcom/amazon/communication/ByteBufferChain;
.super Ljava/lang/Object;
.source "ByteBufferChain.java"


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private mBufferArray:[Ljava/nio/ByteBuffer;

.field private final mBuffers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/nio/ByteBuffer;",
            ">;"
        }
    .end annotation
.end field

.field private mSavedPositions:[I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.ByteBufferChain"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/ByteBufferChain;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    .line 42
    iput-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBufferArray:[Ljava/nio/ByteBuffer;

    .line 43
    iput-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mSavedPositions:[I

    .line 44
    return-void
.end method

.method public constructor <init>([Ljava/nio/ByteBuffer;)V
    .locals 6
    .param p1, "buffers"    # [Ljava/nio/ByteBuffer;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-object p1, p0, Lcom/amazon/communication/ByteBufferChain;->mBufferArray:[Ljava/nio/ByteBuffer;

    .line 55
    new-instance v4, Ljava/util/ArrayList;

    array-length v5, p1

    invoke-direct {v4, v5}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v4, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    .line 56
    move-object v0, p1

    .local v0, "arr$":[Ljava/nio/ByteBuffer;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 57
    .local v1, "buffer":Ljava/nio/ByteBuffer;
    iget-object v4, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 56
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 59
    .end local v1    # "buffer":Ljava/nio/ByteBuffer;
    :cond_0
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 322
    if-ne p0, p1, :cond_1

    .line 339
    :cond_0
    :goto_0
    return v1

    .line 325
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 326
    goto :goto_0

    .line 328
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 329
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 331
    check-cast v0, Lcom/amazon/communication/ByteBufferChain;

    .line 332
    .local v0, "other":Lcom/amazon/communication/ByteBufferChain;
    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    if-nez v3, :cond_4

    .line 333
    iget-object v3, v0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    if-eqz v3, :cond_0

    move v1, v2

    .line 334
    goto :goto_0

    .line 336
    :cond_4
    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    iget-object v4, v0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 337
    goto :goto_0
.end method

.method public getByteBuffers()[Ljava/nio/ByteBuffer;
    .locals 2

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/communication/ByteBufferChain;->mBufferArray:[Ljava/nio/ByteBuffer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/communication/ByteBufferChain;->mBufferArray:[Ljava/nio/ByteBuffer;

    array-length v0, v0

    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-eq v0, v1, :cond_1

    .line 144
    :cond_0
    iget-object v0, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Ljava/nio/ByteBuffer;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/nio/ByteBuffer;

    iput-object v0, p0, Lcom/amazon/communication/ByteBufferChain;->mBufferArray:[Ljava/nio/ByteBuffer;

    .line 146
    :cond_1
    iget-object v0, p0, Lcom/amazon/communication/ByteBufferChain;->mBufferArray:[Ljava/nio/ByteBuffer;

    return-object v0
.end method

.method public getDataSize()I
    .locals 3

    .prologue
    .line 187
    const/4 v1, 0x0

    .line 188
    .local v1, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 189
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/nio/ByteBuffer;

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v2

    add-int/2addr v1, v2

    .line 188
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 191
    :cond_0
    return v1
.end method

.method public getInputStream()Lcom/amazon/communication/ByteBufferChainInputStream;
    .locals 1

    .prologue
    .line 167
    new-instance v0, Lcom/amazon/communication/ByteBufferChainInputStream;

    invoke-direct {v0, p0}, Lcom/amazon/communication/ByteBufferChainInputStream;-><init>(Lcom/amazon/communication/ByteBufferChain;)V

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 307
    const/16 v0, 0x1f

    .line 308
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 309
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    add-int/lit8 v1, v2, 0x1f

    .line 310
    return v1

    .line 309
    :cond_0
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_0
.end method

.method public loadSavedPositions()V
    .locals 3

    .prologue
    .line 230
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mSavedPositions:[I

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChain;->mSavedPositions:[I

    array-length v2, v2

    if-eq v1, v2, :cond_1

    .line 231
    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "loadSavedPositionsForAll cannot be called without a matching savePositionsForAll being called"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 234
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 235
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/nio/ByteBuffer;

    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChain;->mSavedPositions:[I

    aget v2, v2, v0

    invoke-virtual {v1, v2}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 234
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 237
    :cond_2
    return-void
.end method

.method public savePositions()V
    .locals 3

    .prologue
    .line 217
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [I

    iput-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mSavedPositions:[I

    .line 218
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 219
    iget-object v2, p0, Lcom/amazon/communication/ByteBufferChain;->mSavedPositions:[I

    iget-object v1, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    aput v1, v2, v0

    .line 218
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 221
    :cond_0
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 6

    .prologue
    const/16 v5, 0x1e

    .line 288
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "ByteBufferChain [mBuffers="

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 290
    .local v0, "builder":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 291
    .local v1, "i":I
    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 292
    .local v2, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/nio/ByteBuffer;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    if-ge v1, v5, :cond_0

    .line 293
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 292
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 296
    :cond_0
    iget-object v3, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-le v3, v5, :cond_1

    .line 297
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/communication/ByteBufferChain;->mBuffers:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1e

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " more ...)"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 300
    :cond_1
    const-string/jumbo v3, "]"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 302
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
