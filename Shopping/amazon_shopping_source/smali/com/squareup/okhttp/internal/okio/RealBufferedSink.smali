.class final Lcom/squareup/okhttp/internal/okio/RealBufferedSink;
.super Ljava/lang/Object;
.source "RealBufferedSink.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/okio/BufferedSink;


# instance fields
.field public final buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

.field private closed:Z

.field public final sink:Lcom/squareup/okhttp/internal/okio/Sink;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/internal/okio/Sink;)V
    .locals 1
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/Sink;

    .prologue
    .line 33
    new-instance v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-direct {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;-><init>(Lcom/squareup/okhttp/internal/okio/Sink;Lcom/squareup/okhttp/internal/okio/OkBuffer;)V

    .line 34
    return-void
.end method

.method public constructor <init>(Lcom/squareup/okhttp/internal/okio/Sink;Lcom/squareup/okhttp/internal/okio/OkBuffer;)V
    .locals 2
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/Sink;
    .param p2, "buffer"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "sink == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 28
    :cond_0
    iput-object p2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 29
    iput-object p1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->sink:Lcom/squareup/okhttp/internal/okio/Sink;

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/squareup/okhttp/internal/okio/RealBufferedSink;)Z
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/okio/RealBufferedSink;

    .prologue
    .line 21
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->closed:Z

    return v0
.end method

.method private checkNotClosed()V
    .locals 2

    .prologue
    .line 176
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->closed:Z

    if-eqz v0, :cond_0

    .line 177
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 179
    :cond_0
    return-void
.end method


# virtual methods
.method public buffer()Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    return-object v0
.end method

.method public close()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 143
    iget-boolean v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->closed:Z

    if-eqz v2, :cond_1

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 147
    :cond_1
    const/4 v1, 0x0

    .line 149
    .local v1, "thrown":Ljava/lang/Throwable;
    :try_start_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v2, v2, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_2

    .line 150
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->sink:Lcom/squareup/okhttp/internal/okio/Sink;

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v4, v4, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-interface {v2, v3, v4, v5}, Lcom/squareup/okhttp/internal/okio/Sink;->write(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 157
    :cond_2
    :goto_1
    :try_start_1
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->sink:Lcom/squareup/okhttp/internal/okio/Sink;

    invoke-interface {v2}, Lcom/squareup/okhttp/internal/okio/Sink;->close()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 161
    :cond_3
    :goto_2
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->closed:Z

    .line 163
    if-eqz v1, :cond_0

    invoke-static {v1}, Lcom/squareup/okhttp/internal/okio/Util;->sneakyRethrow(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 152
    :catch_0
    move-exception v0

    .line 153
    .local v0, "e":Ljava/lang/Throwable;
    move-object v1, v0

    goto :goto_1

    .line 158
    .end local v0    # "e":Ljava/lang/Throwable;
    :catch_1
    move-exception v0

    .line 159
    .restart local v0    # "e":Ljava/lang/Throwable;
    if-nez v1, :cond_3

    move-object v1, v0

    goto :goto_2
.end method

.method public deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Sink;
    .locals 1
    .param p1, "deadline"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->sink:Lcom/squareup/okhttp/internal/okio/Sink;

    invoke-interface {v0, p1}, Lcom/squareup/okhttp/internal/okio/Sink;->deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Sink;

    .line 168
    return-object p0
.end method

.method public emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 90
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 91
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->completeSegmentByteCount()J

    move-result-wide v0

    .line 92
    .local v0, "byteCount":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-lez v2, :cond_0

    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->sink:Lcom/squareup/okhttp/internal/okio/Sink;

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-interface {v2, v3, v0, v1}, Lcom/squareup/okhttp/internal/okio/Sink;->write(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V

    .line 93
    :cond_0
    return-object p0
.end method

.method public flush()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 135
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 136
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v0, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->sink:Lcom/squareup/okhttp/internal/okio/Sink;

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    iget-wide v2, v2, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-interface {v0, v1, v2, v3}, Lcom/squareup/okhttp/internal/okio/Sink;->write(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V

    .line 139
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->sink:Lcom/squareup/okhttp/internal/okio/Sink;

    invoke-interface {v0}, Lcom/squareup/okhttp/internal/okio/Sink;->flush()V

    .line 140
    return-void
.end method

.method public outputStream()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 97
    new-instance v0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;

    invoke-direct {v0, p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink$1;-><init>(Lcom/squareup/okhttp/internal/okio/RealBufferedSink;)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 172
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "buffer("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->sink:Lcom/squareup/okhttp/internal/okio/Sink;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "byteString"    # Lcom/squareup/okhttp/internal/okio/ByteString;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 49
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write(Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 50
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    return-object v0
.end method

.method public write([B)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "source"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 60
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 61
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([B)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 62
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    return-object v0
.end method

.method public write([BII)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "source"    # [B
    .param p2, "offset"    # I
    .param p3, "byteCount"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 67
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1, p2, p3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 68
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V
    .locals 1
    .param p1, "source"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 43
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1, p2, p3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V

    .line 44
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    .line 45
    return-void
.end method

.method public writeByte(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "b"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 73
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeByte(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 74
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    return-object v0
.end method

.method public writeInt(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "i"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 84
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 85
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeInt(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 86
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    return-object v0
.end method

.method public writeShort(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "s"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 78
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 79
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeShort(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 80
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    return-object v0
.end method

.method public writeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->checkNotClosed()V

    .line 55
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->buffer:Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 56
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/RealBufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    return-object v0
.end method
