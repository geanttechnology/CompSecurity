.class public Lcom/squareup/tape/QueueFile;
.super Ljava/lang/Object;
.source "QueueFile.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/tape/QueueFile$ElementReader;,
        Lcom/squareup/tape/QueueFile$Element;,
        Lcom/squareup/tape/QueueFile$ElementInputStream;
    }
.end annotation


# static fields
.field private static final LOGGER:Ljava/util/logging/Logger;

.field private static final ZEROES:[B


# instance fields
.field private final buffer:[B

.field private elementCount:I

.field fileLength:I

.field private first:Lcom/squareup/tape/QueueFile$Element;

.field private last:Lcom/squareup/tape/QueueFile$Element;

.field final raf:Ljava/io/RandomAccessFile;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    const-class v0, Lcom/squareup/tape/QueueFile;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/squareup/tape/QueueFile;->LOGGER:Ljava/util/logging/Logger;

    .line 61
    const/16 v0, 0x1000

    new-array v0, v0, [B

    sput-object v0, Lcom/squareup/tape/QueueFile;->ZEROES:[B

    return-void
.end method

.method public constructor <init>(Ljava/io/File;)V
    .locals 1
    .param p1, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    const/16 v0, 0x10

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    .line 115
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Lcom/squareup/tape/QueueFile;->initialize(Ljava/io/File;)V

    .line 116
    :cond_0
    invoke-static {p1}, Lcom/squareup/tape/QueueFile;->open(Ljava/io/File;)Ljava/io/RandomAccessFile;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    .line 117
    invoke-direct {p0}, Lcom/squareup/tape/QueueFile;->readHeader()V

    .line 118
    return-void
.end method

.method static synthetic access$100(Lcom/squareup/tape/QueueFile;I)I
    .locals 1
    .param p0, "x0"    # Lcom/squareup/tape/QueueFile;
    .param p1, "x1"    # I

    .prologue
    .line 54
    invoke-direct {p0, p1}, Lcom/squareup/tape/QueueFile;->wrapPosition(I)I

    move-result v0

    return v0
.end method

.method static synthetic access$200(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Ljava/lang/Object;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 54
    invoke-static {p0, p1}, Lcom/squareup/tape/QueueFile;->nonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/squareup/tape/QueueFile;I[BII)V
    .locals 0
    .param p0, "x0"    # Lcom/squareup/tape/QueueFile;
    .param p1, "x1"    # I
    .param p2, "x2"    # [B
    .param p3, "x3"    # I
    .param p4, "x4"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 54
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/squareup/tape/QueueFile;->ringRead(I[BII)V

    return-void
.end method

.method private expandIfNecessary(I)V
    .locals 13
    .param p1, "dataLength"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 360
    add-int/lit8 v7, p1, 0x4

    .line 361
    .local v7, "elementLength":I
    invoke-direct {p0}, Lcom/squareup/tape/QueueFile;->remainingBytes()I

    move-result v12

    .line 362
    .local v12, "remainingBytes":I
    if-lt v12, v7, :cond_0

    .line 399
    :goto_0
    return-void

    .line 365
    :cond_0
    iget v11, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    .line 369
    .local v11, "previousLength":I
    :cond_1
    add-int/2addr v12, v11

    .line 370
    shl-int/lit8 v10, v11, 0x1

    .line 371
    .local v10, "newLength":I
    move v11, v10

    .line 372
    if-lt v12, v7, :cond_1

    .line 374
    invoke-direct {p0, v10}, Lcom/squareup/tape/QueueFile;->setLength(I)V

    .line 377
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/lit8 v2, v2, 0x4

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->length:I

    add-int/2addr v2, v3

    invoke-direct {p0, v2}, Lcom/squareup/tape/QueueFile;->wrapPosition(I)I

    move-result v8

    .line 380
    .local v8, "endOfLastElement":I
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->position:I

    if-gt v8, v2, :cond_2

    .line 381
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    .line 382
    .local v1, "channel":Ljava/nio/channels/FileChannel;
    iget v2, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    int-to-long v2, v2

    invoke-virtual {v1, v2, v3}, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;

    .line 383
    add-int/lit8 v0, v8, -0x4

    .line 384
    .local v0, "count":I
    const-wide/16 v2, 0x10

    int-to-long v4, v0

    move-object v6, v1

    invoke-virtual/range {v1 .. v6}, Ljava/nio/channels/FileChannel;->transferTo(JJLjava/nio/channels/WritableByteChannel;)J

    move-result-wide v2

    int-to-long v4, v0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_2

    .line 385
    new-instance v2, Ljava/lang/AssertionError;

    const-string v3, "Copied insufficient number of bytes!"

    invoke-direct {v2, v3}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2

    .line 390
    .end local v0    # "count":I
    .end local v1    # "channel":Ljava/nio/channels/FileChannel;
    :cond_2
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->position:I

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->position:I

    if-ge v2, v3, :cond_3

    .line 391
    iget v2, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/2addr v2, v3

    add-int/lit8 v9, v2, -0x10

    .line 392
    .local v9, "newLastPosition":I
    iget v2, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->position:I

    invoke-direct {p0, v10, v2, v3, v9}, Lcom/squareup/tape/QueueFile;->writeHeader(IIII)V

    .line 393
    new-instance v2, Lcom/squareup/tape/QueueFile$Element;

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->length:I

    invoke-direct {v2, v9, v3}, Lcom/squareup/tape/QueueFile$Element;-><init>(II)V

    iput-object v2, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    .line 398
    .end local v9    # "newLastPosition":I
    :goto_1
    iput v10, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    goto :goto_0

    .line 395
    :cond_3
    iget v2, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->position:I

    iget-object v4, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v4, v4, Lcom/squareup/tape/QueueFile$Element;->position:I

    invoke-direct {p0, v10, v2, v3, v4}, Lcom/squareup/tape/QueueFile;->writeHeader(IIII)V

    goto :goto_1
.end method

.method private static initialize(Ljava/io/File;)V
    .locals 6
    .param p0, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 197
    new-instance v2, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".tmp"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 198
    .local v2, "tempFile":Ljava/io/File;
    invoke-static {v2}, Lcom/squareup/tape/QueueFile;->open(Ljava/io/File;)Ljava/io/RandomAccessFile;

    move-result-object v1

    .line 200
    .local v1, "raf":Ljava/io/RandomAccessFile;
    const-wide/16 v4, 0x1000

    :try_start_0
    invoke-virtual {v1, v4, v5}, Ljava/io/RandomAccessFile;->setLength(J)V

    .line 201
    const-wide/16 v4, 0x0

    invoke-virtual {v1, v4, v5}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 202
    const/16 v3, 0x10

    new-array v0, v3, [B

    .line 203
    .local v0, "headerBuffer":[B
    const/4 v3, 0x4

    new-array v3, v3, [I

    fill-array-data v3, :array_0

    invoke-static {v0, v3}, Lcom/squareup/tape/QueueFile;->writeInts([B[I)V

    .line 204
    invoke-virtual {v1, v0}, Ljava/io/RandomAccessFile;->write([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 206
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V

    .line 210
    invoke-virtual {v2, p0}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v3

    if-nez v3, :cond_0

    new-instance v3, Ljava/io/IOException;

    const-string v4, "Rename failed!"

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 206
    .end local v0    # "headerBuffer":[B
    :catchall_0
    move-exception v3

    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V

    throw v3

    .line 211
    .restart local v0    # "headerBuffer":[B
    :cond_0
    return-void

    .line 203
    nop

    :array_0
    .array-data 4
        0x1000
        0x0
        0x0
        0x0
    .end array-data
.end method

.method private static nonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 443
    .local p0, "t":Ljava/lang/Object;, "TT;"
    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0, p1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 444
    :cond_0
    return-object p0
.end method

.method private static open(Ljava/io/File;)Ljava/io/RandomAccessFile;
    .locals 2
    .param p0, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 215
    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v1, "rwd"

    invoke-direct {v0, p0, v1}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object v0
.end method

.method private readElement(I)Lcom/squareup/tape/QueueFile$Element;
    .locals 4
    .param p1, "position"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 189
    if-nez p1, :cond_0

    sget-object v0, Lcom/squareup/tape/QueueFile$Element;->NULL:Lcom/squareup/tape/QueueFile$Element;

    .line 191
    :goto_0
    return-object v0

    .line 190
    :cond_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    int-to-long v2, p1

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 191
    new-instance v0, Lcom/squareup/tape/QueueFile$Element;

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->readInt()I

    move-result v1

    invoke-direct {v0, p1, v1}, Lcom/squareup/tape/QueueFile$Element;-><init>(II)V

    goto :goto_0
.end method

.method private readHeader()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 159
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    const-wide/16 v4, 0x0

    invoke-virtual {v2, v4, v5}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 160
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    invoke-virtual {v2, v3}, Ljava/io/RandomAccessFile;->readFully([B)V

    .line 161
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/squareup/tape/QueueFile;->readInt([BI)I

    move-result v2

    iput v2, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    .line 162
    iget v2, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    int-to-long v2, v2

    iget-object v4, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v4}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 163
    new-instance v2, Ljava/io/IOException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "File is truncated. Expected length: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", Actual length: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v4}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 164
    :cond_0
    iget v2, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    if-nez v2, :cond_1

    .line 165
    new-instance v2, Ljava/io/IOException;

    const-string v3, "File is corrupt; length stored in header is 0."

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 167
    :cond_1
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/4 v3, 0x4

    invoke-static {v2, v3}, Lcom/squareup/tape/QueueFile;->readInt([BI)I

    move-result v2

    iput v2, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    .line 168
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/16 v3, 0x8

    invoke-static {v2, v3}, Lcom/squareup/tape/QueueFile;->readInt([BI)I

    move-result v0

    .line 169
    .local v0, "firstOffset":I
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/16 v3, 0xc

    invoke-static {v2, v3}, Lcom/squareup/tape/QueueFile;->readInt([BI)I

    move-result v1

    .line 170
    .local v1, "lastOffset":I
    invoke-direct {p0, v0}, Lcom/squareup/tape/QueueFile;->readElement(I)Lcom/squareup/tape/QueueFile$Element;

    move-result-object v2

    iput-object v2, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    .line 171
    invoke-direct {p0, v1}, Lcom/squareup/tape/QueueFile;->readElement(I)Lcom/squareup/tape/QueueFile$Element;

    move-result-object v2

    iput-object v2, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    .line 172
    return-void
.end method

.method private static readInt([BI)I
    .locals 2
    .param p0, "buffer"    # [B
    .param p1, "offset"    # I

    .prologue
    .line 151
    aget-byte v0, p0, p1

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x18

    add-int/lit8 v1, p1, 0x1

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x10

    add-int/2addr v0, v1

    add-int/lit8 v1, p1, 0x2

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x8

    add-int/2addr v0, v1

    add-int/lit8 v1, p1, 0x3

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    add-int/2addr v0, v1

    return v0
.end method

.method private remainingBytes()I
    .locals 2

    .prologue
    .line 345
    iget v0, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    invoke-direct {p0}, Lcom/squareup/tape/QueueFile;->usedBytes()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method private ringErase(II)V
    .locals 3
    .param p1, "position"    # I
    .param p2, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 249
    :goto_0
    if-lez p2, :cond_0

    .line 250
    sget-object v1, Lcom/squareup/tape/QueueFile;->ZEROES:[B

    array-length v1, v1

    invoke-static {p2, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 251
    .local v0, "chunk":I
    sget-object v1, Lcom/squareup/tape/QueueFile;->ZEROES:[B

    const/4 v2, 0x0

    invoke-direct {p0, p1, v1, v2, v0}, Lcom/squareup/tape/QueueFile;->ringWrite(I[BII)V

    .line 252
    sub-int/2addr p2, v0

    .line 253
    add-int/2addr p1, v0

    .line 254
    goto :goto_0

    .line 255
    .end local v0    # "chunk":I
    :cond_0
    return-void
.end method

.method private ringRead(I[BII)V
    .locals 4
    .param p1, "position"    # I
    .param p2, "buffer"    # [B
    .param p3, "offset"    # I
    .param p4, "count"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 265
    invoke-direct {p0, p1}, Lcom/squareup/tape/QueueFile;->wrapPosition(I)I

    move-result p1

    .line 266
    add-int v1, p1, p4

    iget v2, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    if-gt v1, v2, :cond_0

    .line 267
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    int-to-long v2, p1

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 268
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v1, p2, p3, p4}, Ljava/io/RandomAccessFile;->readFully([BII)V

    .line 278
    :goto_0
    return-void

    .line 272
    :cond_0
    iget v1, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    sub-int v0, v1, p1

    .line 273
    .local v0, "beforeEof":I
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    int-to-long v2, p1

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 274
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v1, p2, p3, v0}, Ljava/io/RandomAccessFile;->readFully([BII)V

    .line 275
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x10

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 276
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    add-int v2, p3, v0

    sub-int v3, p4, v0

    invoke-virtual {v1, p2, v2, v3}, Ljava/io/RandomAccessFile;->readFully([BII)V

    goto :goto_0
.end method

.method private ringWrite(I[BII)V
    .locals 4
    .param p1, "position"    # I
    .param p2, "buffer"    # [B
    .param p3, "offset"    # I
    .param p4, "count"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 233
    invoke-direct {p0, p1}, Lcom/squareup/tape/QueueFile;->wrapPosition(I)I

    move-result p1

    .line 234
    add-int v1, p1, p4

    iget v2, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    if-gt v1, v2, :cond_0

    .line 235
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    int-to-long v2, p1

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 236
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v1, p2, p3, p4}, Ljava/io/RandomAccessFile;->write([BII)V

    .line 246
    :goto_0
    return-void

    .line 240
    :cond_0
    iget v1, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    sub-int v0, v1, p1

    .line 241
    .local v0, "beforeEof":I
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    int-to-long v2, p1

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 242
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v1, p2, p3, v0}, Ljava/io/RandomAccessFile;->write([BII)V

    .line 243
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x10

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 244
    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    add-int v2, p3, v0

    sub-int v3, p4, v0

    invoke-virtual {v1, p2, v2, v3}, Ljava/io/RandomAccessFile;->write([BII)V

    goto :goto_0
.end method

.method private setLength(I)V
    .locals 4
    .param p1, "newLength"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 404
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    int-to-long v2, p1

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->setLength(J)V

    .line 405
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/nio/channels/FileChannel;->force(Z)V

    .line 406
    return-void
.end method

.method private usedBytes()I
    .locals 2

    .prologue
    .line 328
    iget v0, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    if-nez v0, :cond_0

    const/16 v0, 0x10

    .line 337
    :goto_0
    return v0

    .line 330
    :cond_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->position:I

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->position:I

    if-lt v0, v1, :cond_1

    .line 332
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->position:I

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->position:I

    sub-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x4

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->length:I

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x10

    goto :goto_0

    .line 337
    :cond_1
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v0, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/lit8 v0, v0, 0x4

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->length:I

    add-int/2addr v0, v1

    iget v1, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v1, Lcom/squareup/tape/QueueFile$Element;->position:I

    sub-int/2addr v0, v1

    goto :goto_0
.end method

.method private wrapPosition(I)I
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 220
    iget v0, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    if-ge p1, v0, :cond_0

    .end local p1    # "position":I
    :goto_0
    return p1

    .restart local p1    # "position":I
    :cond_0
    add-int/lit8 v0, p1, 0x10

    iget v1, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    sub-int p1, v0, v1

    goto :goto_0
.end method

.method private writeHeader(IIII)V
    .locals 4
    .param p1, "fileLength"    # I
    .param p2, "elementCount"    # I
    .param p3, "firstPosition"    # I
    .param p4, "lastPosition"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 182
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/4 v1, 0x4

    new-array v1, v1, [I

    const/4 v2, 0x0

    aput p1, v1, v2

    const/4 v2, 0x1

    aput p2, v1, v2

    const/4 v2, 0x2

    aput p3, v1, v2

    const/4 v2, 0x3

    aput p4, v1, v2

    invoke-static {v0, v1}, Lcom/squareup/tape/QueueFile;->writeInts([B[I)V

    .line 183
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 184
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    iget-object v1, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    invoke-virtual {v0, v1}, Ljava/io/RandomAccessFile;->write([B)V

    .line 185
    return-void
.end method

.method private static writeInt([BII)V
    .locals 2
    .param p0, "buffer"    # [B
    .param p1, "offset"    # I
    .param p2, "value"    # I

    .prologue
    .line 131
    shr-int/lit8 v0, p2, 0x18

    int-to-byte v0, v0

    aput-byte v0, p0, p1

    .line 132
    add-int/lit8 v0, p1, 0x1

    shr-int/lit8 v1, p2, 0x10

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    .line 133
    add-int/lit8 v0, p1, 0x2

    shr-int/lit8 v1, p2, 0x8

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    .line 134
    add-int/lit8 v0, p1, 0x3

    int-to-byte v1, p2

    aput-byte v1, p0, v0

    .line 135
    return-void
.end method

.method private static varargs writeInts([B[I)V
    .locals 4
    .param p0, "buffer"    # [B
    .param p1, "values"    # [I

    .prologue
    .line 142
    const/4 v0, 0x0

    .line 143
    .local v0, "offset":I
    array-length v3, p1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v3, :cond_0

    aget v1, p1, v2

    .line 144
    .local v1, "value":I
    invoke-static {p0, v0, v1}, Lcom/squareup/tape/QueueFile;->writeInt([BII)V

    .line 145
    add-int/lit8 v0, v0, 0x4

    .line 143
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 147
    .end local v1    # "value":I
    :cond_0
    return-void
.end method


# virtual methods
.method public declared-synchronized add([BII)V
    .locals 8
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "count"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 299
    monitor-enter p0

    :try_start_0
    const-string v4, "buffer"

    invoke-static {p1, v4}, Lcom/squareup/tape/QueueFile;->nonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 300
    or-int v4, p2, p3

    if-ltz v4, :cond_0

    array-length v4, p1

    sub-int/2addr v4, p2

    if-le p3, v4, :cond_1

    .line 301
    :cond_0
    new-instance v4, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 299
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 304
    :cond_1
    :try_start_1
    invoke-direct {p0, p3}, Lcom/squareup/tape/QueueFile;->expandIfNecessary(I)V

    .line 307
    invoke-virtual {p0}, Lcom/squareup/tape/QueueFile;->isEmpty()Z

    move-result v3

    .line 308
    .local v3, "wasEmpty":Z
    if-eqz v3, :cond_3

    const/16 v2, 0x10

    .line 309
    .local v2, "position":I
    :goto_0
    new-instance v1, Lcom/squareup/tape/QueueFile$Element;

    invoke-direct {v1, v2, p3}, Lcom/squareup/tape/QueueFile$Element;-><init>(II)V

    .line 312
    .local v1, "newLast":Lcom/squareup/tape/QueueFile$Element;
    iget-object v4, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/4 v5, 0x0

    invoke-static {v4, v5, p3}, Lcom/squareup/tape/QueueFile;->writeInt([BII)V

    .line 313
    iget v4, v1, Lcom/squareup/tape/QueueFile$Element;->position:I

    iget-object v5, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/4 v6, 0x0

    const/4 v7, 0x4

    invoke-direct {p0, v4, v5, v6, v7}, Lcom/squareup/tape/QueueFile;->ringWrite(I[BII)V

    .line 316
    iget v4, v1, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/lit8 v4, v4, 0x4

    invoke-direct {p0, v4, p1, p2, p3}, Lcom/squareup/tape/QueueFile;->ringWrite(I[BII)V

    .line 319
    if-eqz v3, :cond_4

    iget v0, v1, Lcom/squareup/tape/QueueFile$Element;->position:I

    .line 320
    .local v0, "firstPosition":I
    :goto_1
    iget v4, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    iget v5, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    add-int/lit8 v5, v5, 0x1

    iget v6, v1, Lcom/squareup/tape/QueueFile$Element;->position:I

    invoke-direct {p0, v4, v5, v0, v6}, Lcom/squareup/tape/QueueFile;->writeHeader(IIII)V

    .line 321
    iput-object v1, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    .line 322
    iget v4, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    .line 323
    if-eqz v3, :cond_2

    iget-object v4, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iput-object v4, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 324
    :cond_2
    monitor-exit p0

    return-void

    .line 308
    .end local v0    # "firstPosition":I
    .end local v1    # "newLast":Lcom/squareup/tape/QueueFile$Element;
    .end local v2    # "position":I
    :cond_3
    :try_start_2
    iget-object v4, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v4, v4, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/lit8 v4, v4, 0x4

    iget-object v5, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v5, v5, Lcom/squareup/tape/QueueFile$Element;->length:I

    add-int/2addr v4, v5

    invoke-direct {p0, v4}, Lcom/squareup/tape/QueueFile;->wrapPosition(I)I

    move-result v2

    goto :goto_0

    .line 319
    .restart local v1    # "newLast":Lcom/squareup/tape/QueueFile$Element;
    .restart local v2    # "position":I
    :cond_4
    iget-object v4, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v0, v4, Lcom/squareup/tape/QueueFile$Element;->position:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public declared-synchronized clear()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x1000

    .line 514
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 515
    iget-object v0, p0, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    sget-object v1, Lcom/squareup/tape/QueueFile;->ZEROES:[B

    invoke-virtual {v0, v1}, Ljava/io/RandomAccessFile;->write([B)V

    .line 516
    const/16 v0, 0x1000

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/squareup/tape/QueueFile;->writeHeader(IIII)V

    .line 517
    const/4 v0, 0x0

    iput v0, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    .line 518
    sget-object v0, Lcom/squareup/tape/QueueFile$Element;->NULL:Lcom/squareup/tape/QueueFile$Element;

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    .line 519
    sget-object v0, Lcom/squareup/tape/QueueFile$Element;->NULL:Lcom/squareup/tape/QueueFile$Element;

    iput-object v0, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    .line 520
    iget v0, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    if-le v0, v4, :cond_0

    const/16 v0, 0x1000

    invoke-direct {p0, v0}, Lcom/squareup/tape/QueueFile;->setLength(I)V

    .line 521
    :cond_0
    const/16 v0, 0x1000

    iput v0, p0, Lcom/squareup/tape/QueueFile;->fileLength:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 522
    monitor-exit p0

    return-void

    .line 514
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized forEach(Lcom/squareup/tape/QueueFile$ElementReader;)V
    .locals 5
    .param p1, "reader"    # Lcom/squareup/tape/QueueFile$ElementReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 429
    monitor-enter p0

    :try_start_0
    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v3, Lcom/squareup/tape/QueueFile$Element;->position:I

    .line 430
    .local v2, "position":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v3, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    if-ge v1, v3, :cond_0

    .line 431
    invoke-direct {p0, v2}, Lcom/squareup/tape/QueueFile;->readElement(I)Lcom/squareup/tape/QueueFile$Element;

    move-result-object v0

    .line 432
    .local v0, "current":Lcom/squareup/tape/QueueFile$Element;
    new-instance v3, Lcom/squareup/tape/QueueFile$ElementInputStream;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v0, v4}, Lcom/squareup/tape/QueueFile$ElementInputStream;-><init>(Lcom/squareup/tape/QueueFile;Lcom/squareup/tape/QueueFile$Element;Lcom/squareup/tape/QueueFile$1;)V

    iget v4, v0, Lcom/squareup/tape/QueueFile$Element;->length:I

    invoke-interface {p1, v3, v4}, Lcom/squareup/tape/QueueFile$ElementReader;->read(Ljava/io/InputStream;I)V

    .line 433
    iget v3, v0, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/lit8 v3, v3, 0x4

    iget v4, v0, Lcom/squareup/tape/QueueFile$Element;->length:I

    add-int/2addr v3, v4

    invoke-direct {p0, v3}, Lcom/squareup/tape/QueueFile;->wrapPosition(I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    .line 430
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 435
    .end local v0    # "current":Lcom/squareup/tape/QueueFile$Element;
    :cond_0
    monitor-exit p0

    return-void

    .line 429
    .end local v1    # "i":I
    .end local v2    # "position":I
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized isEmpty()Z
    .locals 1

    .prologue
    .line 350
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/tape/QueueFile;->elementCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized peek()[B
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 410
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/squareup/tape/QueueFile;->isEmpty()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-eqz v2, :cond_0

    const/4 v0, 0x0

    .line 414
    :goto_0
    monitor-exit p0

    return-object v0

    .line 411
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v1, v2, Lcom/squareup/tape/QueueFile$Element;->length:I

    .line 412
    .local v1, "length":I
    new-array v0, v1, [B

    .line 413
    .local v0, "data":[B
    iget-object v2, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v2, v2, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/lit8 v2, v2, 0x4

    const/4 v3, 0x0

    invoke-direct {p0, v2, v0, v3, v1}, Lcom/squareup/tape/QueueFile;->ringRead(I[BII)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 410
    .end local v0    # "data":[B
    .end local v1    # "length":I
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized remove()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 494
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/squareup/tape/QueueFile;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_0

    new-instance v3, Ljava/util/NoSuchElementException;

    invoke-direct {v3}, Ljava/util/NoSuchElementException;-><init>()V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 495
    :cond_0
    :try_start_1
    iget v3, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    .line 496
    invoke-virtual {p0}, Lcom/squareup/tape/QueueFile;->clear()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 510
    :goto_0
    monitor-exit p0

    return-void

    .line 499
    :cond_1
    :try_start_2
    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->length:I

    add-int/lit8 v0, v3, 0x4

    .line 501
    .local v0, "firstTotalLength":I
    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->position:I

    invoke-direct {p0, v3, v0}, Lcom/squareup/tape/QueueFile;->ringErase(II)V

    .line 503
    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    iget v3, v3, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/2addr v3, v0

    invoke-direct {p0, v3}, Lcom/squareup/tape/QueueFile;->wrapPosition(I)I

    move-result v2

    .line 504
    .local v2, "newFirstPosition":I
    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/4 v4, 0x0

    const/4 v5, 0x4

    invoke-direct {p0, v2, v3, v4, v5}, Lcom/squareup/tape/QueueFile;->ringRead(I[BII)V

    .line 505
    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->buffer:[B

    const/4 v4, 0x0

    invoke-static {v3, v4}, Lcom/squareup/tape/QueueFile;->readInt([BI)I

    move-result v1

    .line 506
    .local v1, "length":I
    iget v3, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    iget v4, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    add-int/lit8 v4, v4, -0x1

    iget-object v5, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    iget v5, v5, Lcom/squareup/tape/QueueFile$Element;->position:I

    invoke-direct {p0, v3, v4, v2, v5}, Lcom/squareup/tape/QueueFile;->writeHeader(IIII)V

    .line 507
    iget v3, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    .line 508
    new-instance v3, Lcom/squareup/tape/QueueFile$Element;

    invoke-direct {v3, v2, v1}, Lcom/squareup/tape/QueueFile$Element;-><init>(II)V

    iput-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public declared-synchronized size()I
    .locals 1

    .prologue
    .line 485
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/squareup/tape/QueueFile;->elementCount:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 530
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 531
    .local v0, "builder":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0x5b

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 532
    const-string v2, "fileLength="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/squareup/tape/QueueFile;->fileLength:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 533
    const-string v2, ", size="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/squareup/tape/QueueFile;->elementCount:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 534
    const-string v2, ", first="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->first:Lcom/squareup/tape/QueueFile$Element;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 535
    const-string v2, ", last="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/squareup/tape/QueueFile;->last:Lcom/squareup/tape/QueueFile$Element;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 536
    const-string v2, ", element lengths=["

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 538
    :try_start_0
    new-instance v2, Lcom/squareup/tape/QueueFile$1;

    invoke-direct {v2, p0, v0}, Lcom/squareup/tape/QueueFile$1;-><init>(Lcom/squareup/tape/QueueFile;Ljava/lang/StringBuilder;)V

    invoke-virtual {p0, v2}, Lcom/squareup/tape/QueueFile;->forEach(Lcom/squareup/tape/QueueFile$ElementReader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 553
    :goto_0
    const-string v2, "]]"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 554
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 550
    :catch_0
    move-exception v1

    .line 551
    .local v1, "e":Ljava/io/IOException;
    sget-object v2, Lcom/squareup/tape/QueueFile;->LOGGER:Ljava/util/logging/Logger;

    sget-object v3, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    const-string v4, "read error"

    invoke-virtual {v2, v3, v4, v1}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
