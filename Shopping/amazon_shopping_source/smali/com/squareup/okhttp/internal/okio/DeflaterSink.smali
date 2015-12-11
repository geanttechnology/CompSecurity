.class public final Lcom/squareup/okhttp/internal/okio/DeflaterSink;
.super Ljava/lang/Object;
.source "DeflaterSink.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/okio/Sink;


# instance fields
.field private closed:Z

.field private final deflater:Ljava/util/zip/Deflater;

.field private final sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/internal/okio/Sink;Ljava/util/zip/Deflater;)V
    .locals 1
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/Sink;
    .param p2, "deflater"    # Ljava/util/zip/Deflater;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-static {p1}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Sink;)Lcom/squareup/okhttp/internal/okio/BufferedSink;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    .line 45
    iput-object p2, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflater:Ljava/util/zip/Deflater;

    .line 46
    return-void
.end method

.method private deflate(Z)V
    .locals 8
    .param p1, "syncFlush"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .annotation build Lorg/codehaus/mojo/animal_sniffer/IgnoreJRERequirement;
    .end annotation

    .prologue
    .line 74
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->buffer()Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    .line 76
    .local v0, "buffer":Lcom/squareup/okhttp/internal/okio/OkBuffer;
    :cond_0
    :goto_0
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writableSegment(I)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v2

    .line 82
    .local v2, "s":Lcom/squareup/okhttp/internal/okio/Segment;
    if-eqz p1, :cond_1

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflater:Ljava/util/zip/Deflater;

    iget-object v4, v2, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v5, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v6, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    rsub-int v6, v6, 0x800

    const/4 v7, 0x2

    invoke-virtual {v3, v4, v5, v6, v7}, Ljava/util/zip/Deflater;->deflate([BIII)I

    move-result v1

    .line 86
    .local v1, "deflated":I
    :goto_1
    if-lez v1, :cond_2

    .line 87
    iget v3, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    add-int/2addr v3, v1

    iput v3, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 88
    iget-wide v3, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    int-to-long v5, v1

    add-long/2addr v3, v5

    iput-wide v3, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 89
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-interface {v3}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;

    goto :goto_0

    .line 82
    .end local v1    # "deflated":I
    :cond_1
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflater:Ljava/util/zip/Deflater;

    iget-object v4, v2, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v5, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v6, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    rsub-int v6, v6, 0x800

    invoke-virtual {v3, v4, v5, v6}, Ljava/util/zip/Deflater;->deflate([BII)I

    move-result v1

    goto :goto_1

    .line 90
    .restart local v1    # "deflated":I
    :cond_2
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflater:Ljava/util/zip/Deflater;

    invoke-virtual {v3}, Ljava/util/zip/Deflater;->needsInput()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 91
    return-void
.end method


# virtual methods
.method public close()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 102
    iget-boolean v2, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->closed:Z

    if-eqz v2, :cond_1

    .line 128
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    const/4 v1, 0x0

    .line 108
    .local v1, "thrown":Ljava/lang/Throwable;
    :try_start_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflater:Ljava/util/zip/Deflater;

    invoke-virtual {v2}, Ljava/util/zip/Deflater;->finish()V

    .line 109
    const/4 v2, 0x0

    invoke-direct {p0, v2}, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflate(Z)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 115
    :goto_1
    :try_start_1
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflater:Ljava/util/zip/Deflater;

    invoke-virtual {v2}, Ljava/util/zip/Deflater;->end()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 121
    :cond_2
    :goto_2
    :try_start_2
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-interface {v2}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->close()V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_2

    .line 125
    :cond_3
    :goto_3
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->closed:Z

    .line 127
    if-eqz v1, :cond_0

    invoke-static {v1}, Lcom/squareup/okhttp/internal/okio/Util;->sneakyRethrow(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 110
    :catch_0
    move-exception v0

    .line 111
    .local v0, "e":Ljava/lang/Throwable;
    move-object v1, v0

    goto :goto_1

    .line 116
    .end local v0    # "e":Ljava/lang/Throwable;
    :catch_1
    move-exception v0

    .line 117
    .restart local v0    # "e":Ljava/lang/Throwable;
    if-nez v1, :cond_2

    move-object v1, v0

    goto :goto_2

    .line 122
    .end local v0    # "e":Ljava/lang/Throwable;
    :catch_2
    move-exception v0

    .line 123
    .restart local v0    # "e":Ljava/lang/Throwable;
    if-nez v1, :cond_3

    move-object v1, v0

    goto :goto_3
.end method

.method public deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Sink;
    .locals 1
    .param p1, "deadline"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-interface {v0, p1}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Sink;

    .line 132
    return-object p0
.end method

.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 97
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflate(Z)V

    .line 98
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-interface {v0}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->flush()V

    .line 99
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 136
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "DeflaterSink("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->sink:Lcom/squareup/okhttp/internal/okio/BufferedSink;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V
    .locals 8
    .param p1, "source"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v2, 0x0

    .line 50
    iget-wide v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    move-wide v4, p2

    invoke-static/range {v0 .. v5}, Lcom/squareup/okhttp/internal/okio/Util;->checkOffsetAndCount(JJJ)V

    .line 51
    :goto_0
    cmp-long v0, p2, v2

    if-lez v0, :cond_1

    .line 53
    iget-object v6, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 54
    .local v6, "head":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v0, v6, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v1, v6, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v0, v1

    int-to-long v0, v0

    invoke-static {p2, p3, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int v7, v0

    .line 55
    .local v7, "toDeflate":I
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflater:Ljava/util/zip/Deflater;

    iget-object v1, v6, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v4, v6, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    invoke-virtual {v0, v1, v4, v7}, Ljava/util/zip/Deflater;->setInput([BII)V

    .line 58
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/squareup/okhttp/internal/okio/DeflaterSink;->deflate(Z)V

    .line 61
    iget-wide v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    int-to-long v4, v7

    sub-long/2addr v0, v4

    iput-wide v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 62
    iget v0, v6, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    add-int/2addr v0, v7

    iput v0, v6, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 63
    iget v0, v6, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget v1, v6, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    if-ne v0, v1, :cond_0

    .line 64
    invoke-virtual {v6}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v0

    iput-object v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 65
    sget-object v0, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v0, v6}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->recycle(Lcom/squareup/okhttp/internal/okio/Segment;)V

    .line 68
    :cond_0
    int-to-long v0, v7

    sub-long/2addr p2, v0

    .line 69
    goto :goto_0

    .line 70
    .end local v6    # "head":Lcom/squareup/okhttp/internal/okio/Segment;
    .end local v7    # "toDeflate":I
    :cond_1
    return-void
.end method
