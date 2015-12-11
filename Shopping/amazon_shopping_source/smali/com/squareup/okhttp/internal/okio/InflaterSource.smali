.class public final Lcom/squareup/okhttp/internal/okio/InflaterSource;
.super Ljava/lang/Object;
.source "InflaterSource.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/okio/Source;


# instance fields
.field private bufferBytesHeldByInflater:I

.field private closed:Z

.field private final inflater:Ljava/util/zip/Inflater;

.field private final source:Lcom/squareup/okhttp/internal/okio/BufferedSource;


# direct methods
.method constructor <init>(Lcom/squareup/okhttp/internal/okio/BufferedSource;Ljava/util/zip/Inflater;)V
    .locals 2
    .param p1, "source"    # Lcom/squareup/okhttp/internal/okio/BufferedSource;
    .param p2, "inflater"    # Ljava/util/zip/Inflater;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "source == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    if-nez p2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "inflater == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_1
    iput-object p1, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    .line 52
    iput-object p2, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    .line 53
    return-void
.end method

.method public constructor <init>(Lcom/squareup/okhttp/internal/okio/Source;Ljava/util/zip/Inflater;)V
    .locals 1
    .param p1, "source"    # Lcom/squareup/okhttp/internal/okio/Source;
    .param p2, "inflater"    # Ljava/util/zip/Inflater;

    .prologue
    .line 40
    invoke-static {p1}, Lcom/squareup/okhttp/internal/okio/Okio;->buffer(Lcom/squareup/okhttp/internal/okio/Source;)Lcom/squareup/okhttp/internal/okio/BufferedSource;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lcom/squareup/okhttp/internal/okio/InflaterSource;-><init>(Lcom/squareup/okhttp/internal/okio/BufferedSource;Ljava/util/zip/Inflater;)V

    .line 41
    return-void
.end method

.method private releaseInflatedBytes()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 109
    iget v1, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->bufferBytesHeldByInflater:I

    if-nez v1, :cond_0

    .line 113
    :goto_0
    return-void

    .line 110
    :cond_0
    iget v1, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->bufferBytesHeldByInflater:I

    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    invoke-virtual {v2}, Ljava/util/zip/Inflater;->getRemaining()I

    move-result v2

    sub-int v0, v1, v2

    .line 111
    .local v0, "toRelease":I
    iget v1, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->bufferBytesHeldByInflater:I

    sub-int/2addr v1, v0

    iput v1, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->bufferBytesHeldByInflater:I

    .line 112
    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    int-to-long v2, v0

    invoke-interface {v1, v2, v3}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->skip(J)V

    goto :goto_0
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 121
    iget-boolean v0, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->closed:Z

    if-eqz v0, :cond_0

    .line 125
    :goto_0
    return-void

    .line 122
    :cond_0
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    invoke-virtual {v0}, Ljava/util/zip/Inflater;->end()V

    .line 123
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->closed:Z

    .line 124
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    invoke-interface {v0}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->close()V

    goto :goto_0
.end method

.method public deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Source;
    .locals 1
    .param p1, "deadline"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    invoke-interface {v0, p1}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Source;

    .line 117
    return-object p0
.end method

.method public read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J
    .locals 9
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v5, 0x0

    .line 57
    cmp-long v7, p2, v5

    if-gez v7, :cond_0

    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "byteCount < 0: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 58
    :cond_0
    iget-boolean v7, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->closed:Z

    if-eqz v7, :cond_1

    new-instance v5, Ljava/lang/IllegalStateException;

    const-string/jumbo v6, "closed"

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 59
    :cond_1
    cmp-long v7, p2, v5

    if-nez v7, :cond_2

    .line 75
    :goto_0
    return-wide v5

    .line 62
    :cond_2
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/InflaterSource;->refill()Z

    move-result v3

    .line 66
    .local v3, "sourceExhausted":Z
    const/4 v5, 0x1

    :try_start_0
    invoke-virtual {p1, v5}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writableSegment(I)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v4

    .line 67
    .local v4, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    iget-object v6, v4, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v7, v4, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v8, v4, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    rsub-int v8, v8, 0x800

    invoke-virtual {v5, v6, v7, v8}, Ljava/util/zip/Inflater;->inflate([BII)I

    move-result v0

    .line 68
    .local v0, "bytesInflated":I
    if-lez v0, :cond_3

    .line 69
    iget v5, v4, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    add-int/2addr v5, v0

    iput v5, v4, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 70
    iget-wide v5, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    int-to-long v7, v0

    add-long/2addr v5, v7

    iput-wide v5, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 71
    int-to-long v5, v0

    goto :goto_0

    .line 73
    :cond_3
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    invoke-virtual {v5}, Ljava/util/zip/Inflater;->finished()Z

    move-result v5

    if-nez v5, :cond_4

    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    invoke-virtual {v5}, Ljava/util/zip/Inflater;->needsDictionary()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 74
    :cond_4
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/InflaterSource;->releaseInflatedBytes()V

    .line 75
    const-wide/16 v5, -0x1

    goto :goto_0

    .line 77
    :cond_5
    if-eqz v3, :cond_2

    new-instance v5, Ljava/io/EOFException;

    const-string/jumbo v6, "source exhausted prematurely"

    invoke-direct {v5, v6}, Ljava/io/EOFException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_0
    .catch Ljava/util/zip/DataFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    .end local v0    # "bytesInflated":I
    .end local v4    # "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    :catch_0
    move-exception v1

    .line 79
    .local v1, "e":Ljava/util/zip/DataFormatException;
    new-instance v2, Ljava/io/IOException;

    invoke-direct {v2}, Ljava/io/IOException;-><init>()V

    .line 80
    .local v2, "io":Ljava/io/IOException;
    invoke-virtual {v2, v1}, Ljava/io/IOException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 81
    throw v2
.end method

.method public refill()Z
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 92
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    invoke-virtual {v2}, Ljava/util/zip/Inflater;->needsInput()Z

    move-result v2

    if-nez v2, :cond_0

    .line 104
    :goto_0
    return v1

    .line 94
    :cond_0
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/okio/InflaterSource;->releaseInflatedBytes()V

    .line 95
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    invoke-virtual {v2}, Ljava/util/zip/Inflater;->getRemaining()I

    move-result v2

    if-eqz v2, :cond_1

    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "?"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 98
    :cond_1
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    invoke-interface {v2}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->exhausted()Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v1, 0x1

    goto :goto_0

    .line 101
    :cond_2
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->source:Lcom/squareup/okhttp/internal/okio/BufferedSource;

    invoke-interface {v2}, Lcom/squareup/okhttp/internal/okio/BufferedSource;->buffer()Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v2

    iget-object v0, v2, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 102
    .local v0, "head":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v2, v0, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v3, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v2, v3

    iput v2, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->bufferBytesHeldByInflater:I

    .line 103
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->inflater:Ljava/util/zip/Inflater;

    iget-object v3, v0, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v4, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget v5, p0, Lcom/squareup/okhttp/internal/okio/InflaterSource;->bufferBytesHeldByInflater:I

    invoke-virtual {v2, v3, v4, v5}, Ljava/util/zip/Inflater;->setInput([BII)V

    goto :goto_0
.end method
