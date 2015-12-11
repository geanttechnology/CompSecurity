.class final Lcom/squareup/okhttp/internal/okio/RealBufferedSource;
.super Ljava/lang/Object;
.source "RealBufferedSource.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/okio/BufferedSource;


# instance fields
.field public final buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

.field private closed:Z

.field public final source:Lcom/squareup/okhttp/internal/okio/Source;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/internal/okio/Source;)V
    .locals 1
    .param p1, "source"    # Lcom/squareup/okhttp/internal/okio/Source;

    .prologue
    .line 36
    new-instance v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-direct {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;-><init>(Lcom/squareup/okhttp/internal/okio/Source;Lcom/squareup/okhttp/internal/okio/OkBuffer;)V

    .line 37
    return-void
.end method

.method public constructor <init>(Lcom/squareup/okhttp/internal/okio/Source;Lcom/squareup/okhttp/internal/okio/OkBuffer;)V
    .locals 2
    .param p1, "source"    # Lcom/squareup/okhttp/internal/okio/Source;
    .param p2, "buffer"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "source == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 31
    :cond_0
    iput-object p2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 32
    iput-object p1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    .line 33
    return-void
.end method

.method static synthetic access$000(Lcom/squareup/okhttp/internal/okio/RealBufferedSource;)Z
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/okio/RealBufferedSource;

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->closed:Z

    return v0
.end method

.method private checkNotClosed()V
    .locals 2

    .prologue
    .line 215
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->closed:Z

    if-eqz v0, :cond_0

    .line 216
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 218
    :cond_0
    return-void
.end method


# virtual methods
.method public buffer()Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    return-object v0
.end method

.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 204
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->closed:Z

    if-eqz v0, :cond_0

    .line 208
    :goto_0
    return-void

    .line 205
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->closed:Z

    .line 206
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    invoke-interface {v0}, Lcom/squareup/okhttp/internal/okio/Source;->close()V

    .line 207
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->clear()V

    goto :goto_0
.end method

.method public deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Source;
    .locals 1
    .param p1, "deadline"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 199
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    invoke-interface {v0, p1}, Lcom/squareup/okhttp/internal/okio/Source;->deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Source;

    .line 200
    return-object p0
.end method

.method public exhausted()Z
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->checkNotClosed()V

    .line 58
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->exhausted()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    const-wide/16 v2, 0x800

    invoke-interface {v0, v1, v2, v3}, Lcom/squareup/okhttp/internal/okio/Source;->read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J

    move-result-wide v0

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public inputStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 153
    new-instance v0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource$1;

    invoke-direct {v0, p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource$1;-><init>(Lcom/squareup/okhttp/internal/okio/RealBufferedSource;)V

    return-object v0
.end method

.method public read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J
    .locals 10
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v8, 0x0

    const-wide/16 v4, -0x1

    .line 44
    cmp-long v6, p2, v8

    if-gez v6, :cond_0

    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "byteCount < 0: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 45
    :cond_0
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->checkNotClosed()V

    .line 47
    iget-object v6, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v6, v6, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v6, v6, v8

    if-nez v6, :cond_1

    .line 48
    iget-object v6, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    iget-object v7, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    const-wide/16 v8, 0x800

    invoke-interface {v6, v7, v8, v9}, Lcom/squareup/okhttp/internal/okio/Source;->read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J

    move-result-wide v0

    .line 49
    .local v0, "read":J
    cmp-long v6, v0, v4

    if-nez v6, :cond_1

    .line 53
    .end local v0    # "read":J
    :goto_0
    return-wide v4

    .line 52
    :cond_1
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v4, v4, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-static {p2, p3, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v2

    .line 53
    .local v2, "toRead":J
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v4, p1, v2, v3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J

    move-result-wide v4

    goto :goto_0
.end method

.method public readByte()B
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 69
    const-wide/16 v0, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->require(J)V

    .line 70
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByte()B

    move-result v0

    return v0
.end method

.method public readByteString(J)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 1
    .param p1, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 74
    invoke-virtual {p0, p1, p2}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->require(J)V

    .line 75
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1, p2}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByteString(J)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public readInt()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 120
    const-wide/16 v0, 0x4

    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->require(J)V

    .line 121
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readInt()I

    move-result v0

    return v0
.end method

.method public readIntLe()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 125
    const-wide/16 v0, 0x4

    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->require(J)V

    .line 126
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readIntLe()I

    move-result v0

    return v0
.end method

.method public readShort()S
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 110
    const-wide/16 v0, 0x2

    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->require(J)V

    .line 111
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readShort()S

    move-result v0

    return v0
.end method

.method public readShortLe()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 115
    const-wide/16 v0, 0x2

    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->require(J)V

    .line 116
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readShortLe()I

    move-result v0

    return v0
.end method

.method public readUtf8(J)Ljava/lang/String;
    .locals 1
    .param p1, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 79
    invoke-virtual {p0, p1, p2}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->require(J)V

    .line 80
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1, p2}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readUtf8(J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public readUtf8Line(Z)Ljava/lang/String;
    .locals 9
    .param p1, "throwOnEof"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 84
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->checkNotClosed()V

    .line 85
    const-wide/16 v3, 0x0

    .line 87
    .local v3, "start":J
    :cond_0
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    const/16 v6, 0xa

    invoke-virtual {v5, v6, v3, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->indexOf(BJ)J

    move-result-wide v0

    .local v0, "newline":J
    const-wide/16 v5, -0x1

    cmp-long v5, v0, v5

    if-nez v5, :cond_3

    .line 88
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v3, v5, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 89
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    iget-object v6, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    const-wide/16 v7, 0x800

    invoke-interface {v5, v6, v7, v8}, Lcom/squareup/okhttp/internal/okio/Source;->read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J

    move-result-wide v5

    const-wide/16 v7, -0x1

    cmp-long v5, v5, v7

    if-nez v5, :cond_0

    .line 90
    if-eqz p1, :cond_1

    new-instance v5, Ljava/io/EOFException;

    invoke-direct {v5}, Ljava/io/EOFException;-><init>()V

    throw v5

    .line 91
    :cond_1
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v5, v5, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    if-eqz v5, :cond_2

    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v5, v5, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-virtual {p0, v5, v6}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->readUtf8(J)Ljava/lang/String;

    move-result-object v5

    :goto_0
    move-object v2, v5

    .line 105
    :goto_1
    return-object v2

    .line 91
    :cond_2
    const/4 v5, 0x0

    goto :goto_0

    .line 95
    :cond_3
    const-wide/16 v5, 0x0

    cmp-long v5, v0, v5

    if-lez v5, :cond_4

    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    const-wide/16 v6, 0x1

    sub-long v6, v0, v6

    invoke-virtual {v5, v6, v7}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->getByte(J)B

    move-result v5

    const/16 v6, 0xd

    if-ne v5, v6, :cond_4

    .line 97
    const-wide/16 v5, 0x1

    sub-long v5, v0, v5

    invoke-virtual {p0, v5, v6}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->readUtf8(J)Ljava/lang/String;

    move-result-object v2

    .line 98
    .local v2, "result":Ljava/lang/String;
    const-wide/16 v5, 0x2

    invoke-virtual {p0, v5, v6}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->skip(J)V

    goto :goto_1

    .line 103
    .end local v2    # "result":Ljava/lang/String;
    :cond_4
    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->readUtf8(J)Ljava/lang/String;

    move-result-object v2

    .line 104
    .restart local v2    # "result":Ljava/lang/String;
    const-wide/16 v5, 0x1

    invoke-virtual {p0, v5, v6}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->skip(J)V

    goto :goto_1
.end method

.method public require(J)V
    .locals 4
    .param p1, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->checkNotClosed()V

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v0, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v0, v0, p1

    if-gez v0, :cond_1

    .line 64
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    const-wide/16 v2, 0x800

    invoke-interface {v0, v1, v2, v3}, Lcom/squareup/okhttp/internal/okio/Source;->read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J

    move-result-wide v0

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0

    .line 66
    :cond_1
    return-void
.end method

.method public seek(B)J
    .locals 10
    .param p1, "b"    # B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v8, -0x1

    .line 142
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->checkNotClosed()V

    .line 143
    const-wide/16 v2, 0x0

    .line 145
    .local v2, "start":J
    :cond_0
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v4, p1, v2, v3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->indexOf(BJ)J

    move-result-wide v0

    .local v0, "index":J
    cmp-long v4, v0, v8

    if-nez v4, :cond_1

    .line 146
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v2, v4, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 147
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    const-wide/16 v6, 0x800

    invoke-interface {v4, v5, v6, v7}, Lcom/squareup/okhttp/internal/okio/Source;->read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J

    move-result-wide v4

    cmp-long v4, v4, v8

    if-nez v4, :cond_0

    new-instance v4, Ljava/io/EOFException;

    invoke-direct {v4}, Ljava/io/EOFException;-><init>()V

    throw v4

    .line 149
    :cond_1
    return-wide v0
.end method

.method public skip(J)V
    .locals 8
    .param p1, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v6, 0x0

    .line 130
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->checkNotClosed()V

    .line 131
    :goto_0
    cmp-long v2, p1, v6

    if-lez v2, :cond_1

    .line 132
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v2, v2, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v2, v2, v6

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    const-wide/16 v4, 0x800

    invoke-interface {v2, v3, v4, v5}, Lcom/squareup/okhttp/internal/okio/Source;->read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J

    move-result-wide v2

    const-wide/16 v4, -0x1

    cmp-long v2, v2, v4

    if-nez v2, :cond_0

    .line 133
    new-instance v2, Ljava/io/EOFException;

    invoke-direct {v2}, Ljava/io/EOFException;-><init>()V

    throw v2

    .line 135
    :cond_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size()J

    move-result-wide v2

    invoke-static {p1, p2, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    .line 136
    .local v0, "toSkip":J
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v2, v0, v1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->skip(J)V

    .line 137
    sub-long/2addr p1, v0

    .line 138
    goto :goto_0

    .line 139
    .end local v0    # "toSkip":J
    :cond_1
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 211
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "buffer("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSource;->source:Lcom/squareup/okhttp/internal/okio/Source;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
