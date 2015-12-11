.class public final Lcom/squareup/okhttp/internal/okio/OkBuffer;
.super Ljava/lang/Object;
.source "OkBuffer.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/okio/BufferedSink;
.implements Lcom/squareup/okhttp/internal/okio/BufferedSource;
.implements Ljava/lang/Cloneable;


# instance fields
.field head:Lcom/squareup/okhttp/internal/okio/Segment;

.field size:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    return-void
.end method

.method private readBytes(J)[B
    .locals 10
    .param p1, "byteCount"    # J

    .prologue
    .line 303
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v2, 0x0

    move-wide v4, p1

    invoke-static/range {v0 .. v5}, Lcom/squareup/okhttp/internal/okio/Util;->checkOffsetAndCount(JJJ)V

    .line 304
    const-wide/32 v0, 0x7fffffff

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    .line 305
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "byteCount > Integer.MAX_VALUE: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 308
    :cond_0
    const/4 v6, 0x0

    .line 309
    .local v6, "offset":I
    long-to-int v0, p1

    new-array v7, v0, [B

    .line 311
    .local v7, "result":[B
    :cond_1
    :goto_0
    int-to-long v0, v6

    cmp-long v0, v0, p1

    if-gez v0, :cond_2

    .line 312
    int-to-long v0, v6

    sub-long v0, p1, v0

    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v2, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v3, v3, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v2, v3

    int-to-long v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int v8, v0

    .line 313
    .local v8, "toCopy":I
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v0, v0, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v1, v1, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    invoke-static {v0, v1, v7, v6, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 315
    add-int/2addr v6, v8

    .line 316
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v1, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    add-int/2addr v1, v8

    iput v1, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 318
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v0, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v1, v1, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    if-ne v0, v1, :cond_1

    .line 319
    iget-object v9, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 320
    .local v9, "toRecycle":Lcom/squareup/okhttp/internal/okio/Segment;
    invoke-virtual {v9}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 321
    sget-object v0, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v0, v9}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->recycle(Lcom/squareup/okhttp/internal/okio/Segment;)V

    goto :goto_0

    .line 325
    .end local v8    # "toCopy":I
    .end local v9    # "toRecycle":Lcom/squareup/okhttp/internal/okio/Segment;
    :cond_2
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    sub-long/2addr v0, p1

    iput-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 326
    return-object v7
.end method


# virtual methods
.method public buffer()Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 0

    .prologue
    .line 59
    return-object p0
.end method

.method public clear()V
    .locals 2

    .prologue
    .line 352
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->skip(J)V

    .line 353
    return-void
.end method

.method public clone()Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 6

    .prologue
    .line 684
    new-instance v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;

    invoke-direct {v0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;-><init>()V

    .line 685
    .local v0, "result":Lcom/squareup/okhttp/internal/okio/OkBuffer;
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 692
    :cond_0
    return-object v0

    .line 687
    :cond_1
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v2, v2, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v3, v3, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v4, v4, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v5, v5, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v4, v5

    invoke-virtual {v0, v2, v3, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 688
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v1, v2, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .local v1, "s":Lcom/squareup/okhttp/internal/okio/Segment;
    :goto_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-eq v1, v2, :cond_0

    .line 689
    iget-object v2, v1, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v3, v1, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget v4, v1, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v5, v1, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v4, v5

    invoke-virtual {v0, v2, v3, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 688
    iget-object v1, v1, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    goto :goto_0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->clone()Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public close()V
    .locals 0

    .prologue
    .line 601
    return-void
.end method

.method public completeSegmentByteCount()J
    .locals 6

    .prologue
    const-wide/16 v3, 0x0

    .line 131
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 132
    .local v0, "result":J
    cmp-long v5, v0, v3

    if-nez v5, :cond_0

    .line 140
    :goto_0
    return-wide v3

    .line 135
    :cond_0
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v2, v3, Lcom/squareup/okhttp/internal/okio/Segment;->prev:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 136
    .local v2, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v3, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    const/16 v4, 0x800

    if-ge v3, v4, :cond_1

    .line 137
    iget v3, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v4, v2, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v3, v4

    int-to-long v3, v3

    sub-long/2addr v0, v3

    :cond_1
    move-wide v3, v0

    .line 140
    goto :goto_0
.end method

.method public deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 0
    .param p1, "deadline"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 561
    return-object p0
.end method

.method public bridge synthetic deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Sink;
    .locals 1
    .param p1, "x0"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Source;
    .locals 1
    .param p1, "x0"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public emitCompleteSegments()Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 0

    .prologue
    .line 85
    return-object p0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 17
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 615
    move-object/from16 v0, p1

    instance-of v13, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;

    if-nez v13, :cond_0

    const/4 v13, 0x0

    .line 643
    :goto_0
    return v13

    :cond_0
    move-object/from16 v12, p1

    .line 616
    check-cast v12, Lcom/squareup/okhttp/internal/okio/OkBuffer;

    .line 617
    .local v12, "that":Lcom/squareup/okhttp/internal/okio/OkBuffer;
    move-object/from16 v0, p0

    iget-wide v13, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    iget-wide v15, v12, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v13, v13, v15

    if-eqz v13, :cond_1

    const/4 v13, 0x0

    goto :goto_0

    .line 618
    :cond_1
    move-object/from16 v0, p0

    iget-wide v13, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v15, 0x0

    cmp-long v13, v13, v15

    if-nez v13, :cond_2

    const/4 v13, 0x1

    goto :goto_0

    .line 620
    :cond_2
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 621
    .local v10, "sa":Lcom/squareup/okhttp/internal/okio/Segment;
    iget-object v11, v12, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 622
    .local v11, "sb":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v6, v10, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 623
    .local v6, "posA":I
    iget v8, v11, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 625
    .local v8, "posB":I
    const-wide/16 v4, 0x0

    .local v4, "pos":J
    :goto_1
    move-object/from16 v0, p0

    iget-wide v13, v0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v13, v4, v13

    if-gez v13, :cond_5

    .line 626
    iget v13, v10, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    sub-int/2addr v13, v6

    iget v14, v11, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    sub-int/2addr v14, v8

    invoke-static {v13, v14}, Ljava/lang/Math;->min(II)I

    move-result v13

    int-to-long v1, v13

    .line 628
    .local v1, "count":J
    const/4 v3, 0x0

    .local v3, "i":I
    move v9, v8

    .end local v8    # "posB":I
    .local v9, "posB":I
    move v7, v6

    .end local v6    # "posA":I
    .local v7, "posA":I
    :goto_2
    int-to-long v13, v3

    cmp-long v13, v13, v1

    if-gez v13, :cond_4

    .line 629
    iget-object v13, v10, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    add-int/lit8 v6, v7, 0x1

    .end local v7    # "posA":I
    .restart local v6    # "posA":I
    aget-byte v13, v13, v7

    iget-object v14, v11, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    add-int/lit8 v8, v9, 0x1

    .end local v9    # "posB":I
    .restart local v8    # "posB":I
    aget-byte v14, v14, v9

    if-eq v13, v14, :cond_3

    const/4 v13, 0x0

    goto :goto_0

    .line 628
    :cond_3
    add-int/lit8 v3, v3, 0x1

    move v9, v8

    .end local v8    # "posB":I
    .restart local v9    # "posB":I
    move v7, v6

    .end local v6    # "posA":I
    .restart local v7    # "posA":I
    goto :goto_2

    .line 632
    :cond_4
    iget v13, v10, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    if-ne v7, v13, :cond_7

    .line 633
    iget-object v10, v10, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 634
    iget v6, v10, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 637
    .end local v7    # "posA":I
    .restart local v6    # "posA":I
    :goto_3
    iget v13, v11, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    if-ne v9, v13, :cond_6

    .line 638
    iget-object v11, v11, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 639
    iget v8, v11, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 625
    .end local v9    # "posB":I
    .restart local v8    # "posB":I
    :goto_4
    add-long/2addr v4, v1

    goto :goto_1

    .line 643
    .end local v1    # "count":J
    .end local v3    # "i":I
    :cond_5
    const/4 v13, 0x1

    goto :goto_0

    .end local v8    # "posB":I
    .restart local v1    # "count":J
    .restart local v3    # "i":I
    .restart local v9    # "posB":I
    :cond_6
    move v8, v9

    .end local v9    # "posB":I
    .restart local v8    # "posB":I
    goto :goto_4

    .end local v6    # "posA":I
    .end local v8    # "posB":I
    .restart local v7    # "posA":I
    .restart local v9    # "posB":I
    :cond_7
    move v6, v7

    .end local v7    # "posA":I
    .restart local v6    # "posA":I
    goto :goto_3
.end method

.method public exhausted()Z
    .locals 4

    .prologue
    .line 89
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public flush()V
    .locals 0

    .prologue
    .line 598
    return-void
.end method

.method public getByte(J)B
    .locals 8
    .param p1, "i"    # J

    .prologue
    .line 166
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v4, 0x1

    move-wide v2, p1

    invoke-static/range {v0 .. v5}, Lcom/squareup/okhttp/internal/okio/Util;->checkOffsetAndCount(JJJ)V

    .line 167
    iget-object v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 168
    .local v6, "s":Lcom/squareup/okhttp/internal/okio/Segment;
    :goto_0
    iget v0, v6, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v1, v6, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int v7, v0, v1

    .line 169
    .local v7, "segmentByteCount":I
    int-to-long v0, v7

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    iget-object v0, v6, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v1, v6, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    long-to-int v2, p1

    add-int/2addr v1, v2

    aget-byte v0, v0, v1

    return v0

    .line 170
    :cond_0
    int-to-long v0, v7

    sub-long/2addr p1, v0

    .line 167
    iget-object v6, v6, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    goto :goto_0
.end method

.method public hashCode()I
    .locals 6

    .prologue
    .line 647
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 648
    .local v3, "s":Lcom/squareup/okhttp/internal/okio/Segment;
    if-nez v3, :cond_0

    const/4 v2, 0x0

    .line 656
    :goto_0
    return v2

    .line 649
    :cond_0
    const/4 v2, 0x1

    .line 651
    .local v2, "result":I
    :cond_1
    iget v1, v3, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .local v1, "pos":I
    iget v0, v3, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .local v0, "limit":I
    :goto_1
    if-ge v1, v0, :cond_2

    .line 652
    mul-int/lit8 v4, v2, 0x1f

    iget-object v5, v3, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    aget-byte v5, v5, v1

    add-int v2, v4, v5

    .line 651
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 654
    :cond_2
    iget-object v3, v3, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 655
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-ne v3, v4, :cond_1

    goto :goto_0
.end method

.method public indexOf(B)J
    .locals 2
    .param p1, "b"    # B

    .prologue
    .line 569
    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, v0, v1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->indexOf(BJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public indexOf(BJ)J
    .locals 13
    .param p1, "b"    # B
    .param p2, "fromIndex"    # J

    .prologue
    .line 577
    iget-object v7, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 578
    .local v7, "s":Lcom/squareup/okhttp/internal/okio/Segment;
    if-nez v7, :cond_0

    const-wide/16 v9, -0x1

    .line 594
    :goto_0
    return-wide v9

    .line 579
    :cond_0
    const-wide/16 v3, 0x0

    .line 581
    .local v3, "offset":J
    :cond_1
    iget v9, v7, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v10, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int v8, v9, v10

    .line 582
    .local v8, "segmentByteCount":I
    int-to-long v9, v8

    cmp-long v9, p2, v9

    if-lez v9, :cond_2

    .line 583
    int-to-long v9, v8

    sub-long/2addr p2, v9

    .line 591
    :goto_1
    int-to-long v9, v8

    add-long/2addr v3, v9

    .line 592
    iget-object v7, v7, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 593
    iget-object v9, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-ne v7, v9, :cond_1

    .line 594
    const-wide/16 v9, -0x1

    goto :goto_0

    .line 585
    :cond_2
    iget-object v0, v7, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    .line 586
    .local v0, "data":[B
    iget v9, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    int-to-long v9, v9

    add-long v5, v9, p2

    .local v5, "pos":J
    iget v9, v7, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    int-to-long v1, v9

    .local v1, "limit":J
    :goto_2
    cmp-long v9, v5, v1

    if-gez v9, :cond_4

    .line 587
    long-to-int v9, v5

    aget-byte v9, v0, v9

    if-ne v9, p1, :cond_3

    add-long v9, v3, v5

    iget v11, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    int-to-long v11, v11

    sub-long/2addr v9, v11

    goto :goto_0

    .line 586
    :cond_3
    const-wide/16 v9, 0x1

    add-long/2addr v5, v9

    goto :goto_2

    .line 589
    :cond_4
    const-wide/16 p2, 0x0

    goto :goto_1
.end method

.method public inputStream()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 103
    new-instance v0, Lcom/squareup/okhttp/internal/okio/OkBuffer$2;

    invoke-direct {v0, p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer$2;-><init>(Lcom/squareup/okhttp/internal/okio/OkBuffer;)V

    return-object v0
.end method

.method public outputStream()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 63
    new-instance v0, Lcom/squareup/okhttp/internal/okio/OkBuffer$1;

    invoke-direct {v0, p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer$1;-><init>(Lcom/squareup/okhttp/internal/okio/OkBuffer;)V

    return-object v0
.end method

.method read([BII)I
    .locals 6
    .param p1, "sink"    # [B
    .param p2, "offset"    # I
    .param p3, "byteCount"    # I

    .prologue
    .line 331
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 332
    .local v0, "s":Lcom/squareup/okhttp/internal/okio/Segment;
    if-nez v0, :cond_1

    const/4 v1, -0x1

    .line 344
    :cond_0
    :goto_0
    return v1

    .line 333
    :cond_1
    iget v2, v0, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v3, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v2, v3

    invoke-static {p3, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 334
    .local v1, "toCopy":I
    iget-object v2, v0, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v3, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    invoke-static {v2, v3, p1, p2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 336
    iget v2, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    add-int/2addr v2, v1

    iput v2, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 337
    iget-wide v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    int-to-long v4, v1

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 339
    iget v2, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget v3, v0, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    if-ne v2, v3, :cond_0

    .line 340
    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v2

    iput-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 341
    sget-object v2, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v2, v0}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->recycle(Lcom/squareup/okhttp/internal/okio/Segment;)V

    goto :goto_0
.end method

.method public read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J
    .locals 4
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J

    .prologue
    .line 553
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const-wide/16 v0, -0x1

    .line 556
    :goto_0
    return-wide v0

    .line 554
    :cond_0
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v0, p2, v0

    if-lez v0, :cond_1

    iget-wide p2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 555
    :cond_1
    invoke-virtual {p1, p0, p2, p3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V

    move-wide v0, p2

    .line 556
    goto :goto_0
.end method

.method public readByte()B
    .locals 10

    .prologue
    .line 144
    iget-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v8, 0x0

    cmp-long v6, v6, v8

    if-nez v6, :cond_0

    new-instance v6, Ljava/lang/IllegalStateException;

    const-string/jumbo v7, "size == 0"

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 146
    :cond_0
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 147
    .local v5, "segment":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v3, v5, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 148
    .local v3, "pos":I
    iget v2, v5, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 150
    .local v2, "limit":I
    iget-object v1, v5, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    .line 151
    .local v1, "data":[B
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "pos":I
    .local v4, "pos":I
    aget-byte v0, v1, v3

    .line 152
    .local v0, "b":B
    iget-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v8, 0x1

    sub-long/2addr v6, v8

    iput-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 154
    if-ne v4, v2, :cond_1

    .line 155
    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v6

    iput-object v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 156
    sget-object v6, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v6, v5}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->recycle(Lcom/squareup/okhttp/internal/okio/Segment;)V

    .line 161
    :goto_0
    return v0

    .line 158
    :cond_1
    iput v4, v5, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    goto :goto_0
.end method

.method public readByteString(J)Lcom/squareup/okhttp/internal/okio/ByteString;
    .locals 2
    .param p1, "byteCount"    # J

    .prologue
    .line 244
    new-instance v0, Lcom/squareup/okhttp/internal/okio/ByteString;

    invoke-direct {p0, p1, p2}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readBytes(J)[B

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/squareup/okhttp/internal/okio/ByteString;-><init>([B)V

    return-object v0
.end method

.method public readInt()I
    .locals 10

    .prologue
    const-wide/16 v8, 0x4

    .line 204
    iget-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v6, v6, v8

    if-gez v6, :cond_0

    new-instance v6, Ljava/lang/IllegalArgumentException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "size < 4: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-wide v8, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 206
    :cond_0
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 207
    .local v5, "segment":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v3, v5, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 208
    .local v3, "pos":I
    iget v2, v5, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 211
    .local v2, "limit":I
    sub-int v6, v2, v3

    const/4 v7, 0x4

    if-ge v6, v7, :cond_1

    .line 212
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByte()B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x18

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByte()B

    move-result v7

    and-int/lit16 v7, v7, 0xff

    shl-int/lit8 v7, v7, 0x10

    or-int/2addr v6, v7

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByte()B

    move-result v7

    and-int/lit16 v7, v7, 0xff

    shl-int/lit8 v7, v7, 0x8

    or-int/2addr v6, v7

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByte()B

    move-result v7

    and-int/lit16 v7, v7, 0xff

    or-int v1, v6, v7

    .line 232
    :goto_0
    return v1

    .line 218
    :cond_1
    iget-object v0, v5, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    .line 219
    .local v0, "data":[B
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "pos":I
    .local v4, "pos":I
    aget-byte v6, v0, v3

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x18

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "pos":I
    .restart local v3    # "pos":I
    aget-byte v7, v0, v4

    and-int/lit16 v7, v7, 0xff

    shl-int/lit8 v7, v7, 0x10

    or-int/2addr v6, v7

    add-int/lit8 v4, v3, 0x1

    .end local v3    # "pos":I
    .restart local v4    # "pos":I
    aget-byte v7, v0, v3

    and-int/lit16 v7, v7, 0xff

    shl-int/lit8 v7, v7, 0x8

    or-int/2addr v6, v7

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "pos":I
    .restart local v3    # "pos":I
    aget-byte v7, v0, v4

    and-int/lit16 v7, v7, 0xff

    or-int v1, v6, v7

    .line 223
    .local v1, "i":I
    iget-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    sub-long/2addr v6, v8

    iput-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 225
    if-ne v3, v2, :cond_2

    .line 226
    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v6

    iput-object v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 227
    sget-object v6, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v6, v5}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->recycle(Lcom/squareup/okhttp/internal/okio/Segment;)V

    goto :goto_0

    .line 229
    :cond_2
    iput v3, v5, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    goto :goto_0
.end method

.method public readIntLe()I
    .locals 1

    .prologue
    .line 240
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readInt()I

    move-result v0

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/Util;->reverseBytesInt(I)I

    move-result v0

    return v0
.end method

.method public readShort()S
    .locals 10

    .prologue
    const-wide/16 v8, 0x2

    .line 175
    iget-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v6, v6, v8

    if-gez v6, :cond_0

    new-instance v6, Ljava/lang/IllegalArgumentException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "size < 2: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-wide v8, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 177
    :cond_0
    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 178
    .local v5, "segment":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v2, v5, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 179
    .local v2, "pos":I
    iget v1, v5, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 182
    .local v1, "limit":I
    sub-int v6, v1, v2

    const/4 v7, 0x2

    if-ge v6, v7, :cond_1

    .line 183
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByte()B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x8

    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByte()B

    move-result v7

    and-int/lit16 v7, v7, 0xff

    or-int v4, v6, v7

    .line 185
    .local v4, "s":I
    int-to-short v6, v4

    .line 200
    :goto_0
    return v6

    .line 188
    .end local v4    # "s":I
    :cond_1
    iget-object v0, v5, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    .line 189
    .local v0, "data":[B
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "pos":I
    .local v3, "pos":I
    aget-byte v6, v0, v2

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x8

    add-int/lit8 v2, v3, 0x1

    .end local v3    # "pos":I
    .restart local v2    # "pos":I
    aget-byte v7, v0, v3

    and-int/lit16 v7, v7, 0xff

    or-int v4, v6, v7

    .line 191
    .restart local v4    # "s":I
    iget-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    sub-long/2addr v6, v8

    iput-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 193
    if-ne v2, v1, :cond_2

    .line 194
    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v6

    iput-object v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 195
    sget-object v6, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v6, v5}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->recycle(Lcom/squareup/okhttp/internal/okio/Segment;)V

    .line 200
    :goto_1
    int-to-short v6, v4

    goto :goto_0

    .line 197
    :cond_2
    iput v2, v5, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    goto :goto_1
.end method

.method public readShortLe()I
    .locals 1

    .prologue
    .line 236
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readShort()S

    move-result v0

    invoke-static {v0}, Lcom/squareup/okhttp/internal/okio/Util;->reverseBytesShort(S)I

    move-result v0

    return v0
.end method

.method public readUtf8(J)Ljava/lang/String;
    .locals 9
    .param p1, "byteCount"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 248
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    move-wide v4, p1

    invoke-static/range {v0 .. v5}, Lcom/squareup/okhttp/internal/okio/Util;->checkOffsetAndCount(JJJ)V

    .line 249
    const-wide/32 v0, 0x7fffffff

    cmp-long v0, p1, v0

    if-lez v0, :cond_0

    .line 250
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "byteCount > Integer.MAX_VALUE: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 252
    :cond_0
    cmp-long v0, p1, v2

    if-nez v0, :cond_2

    const-string/jumbo v8, ""

    .line 274
    :cond_1
    :goto_0
    return-object v8

    .line 254
    :cond_2
    iget-object v7, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 255
    .local v7, "head":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v0, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    int-to-long v0, v0

    add-long/2addr v0, p1

    iget v2, v7, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_3

    .line 258
    :try_start_0
    new-instance v8, Ljava/lang/String;

    invoke-direct {p0, p1, p2}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readBytes(J)[B

    move-result-object v0

    const-string/jumbo v1, "UTF-8"

    invoke-direct {v8, v0, v1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 259
    :catch_0
    move-exception v6

    .line 260
    .local v6, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0, v6}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0

    .line 265
    .end local v6    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_3
    :try_start_1
    new-instance v8, Ljava/lang/String;

    iget-object v0, v7, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v1, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    long-to-int v2, p1

    const-string/jumbo v3, "UTF-8"

    invoke-direct {v8, v0, v1, v2, v3}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V

    .line 266
    .local v8, "result":Ljava/lang/String;
    iget v0, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    int-to-long v0, v0

    add-long/2addr v0, p1

    long-to-int v0, v0

    iput v0, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 267
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    sub-long/2addr v0, p1

    iput-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 269
    iget v0, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget v1, v7, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    if-ne v0, v1, :cond_1

    .line 270
    invoke-virtual {v7}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 271
    sget-object v0, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v0, v7}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->recycle(Lcom/squareup/okhttp/internal/okio/Segment;)V
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 275
    .end local v8    # "result":Ljava/lang/String;
    :catch_1
    move-exception v6

    .line 276
    .restart local v6    # "e":Ljava/io/UnsupportedEncodingException;
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0, v6}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0
.end method

.method public readUtf8Line(Z)Ljava/lang/String;
    .locals 9
    .param p1, "throwOnEof"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/EOFException;
        }
    .end annotation

    .prologue
    const-wide/16 v7, 0x0

    const-wide/16 v5, 0x1

    .line 281
    const/16 v3, 0xa

    invoke-virtual {p0, v3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->indexOf(B)J

    move-result-wide v0

    .line 283
    .local v0, "newline":J
    const-wide/16 v3, -0x1

    cmp-long v3, v0, v3

    if-nez v3, :cond_2

    .line 284
    if-eqz p1, :cond_0

    new-instance v3, Ljava/io/EOFException;

    invoke-direct {v3}, Ljava/io/EOFException;-><init>()V

    throw v3

    .line 285
    :cond_0
    iget-wide v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v3, v3, v7

    if-eqz v3, :cond_1

    iget-wide v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-virtual {p0, v3, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readUtf8(J)Ljava/lang/String;

    move-result-object v3

    :goto_0
    move-object v2, v3

    .line 298
    :goto_1
    return-object v2

    .line 285
    :cond_1
    const/4 v3, 0x0

    goto :goto_0

    .line 288
    :cond_2
    cmp-long v3, v0, v7

    if-lez v3, :cond_3

    sub-long v3, v0, v5

    invoke-virtual {p0, v3, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->getByte(J)B

    move-result v3

    const/16 v4, 0xd

    if-ne v3, v4, :cond_3

    .line 290
    sub-long v3, v0, v5

    invoke-virtual {p0, v3, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readUtf8(J)Ljava/lang/String;

    move-result-object v2

    .line 291
    .local v2, "result":Ljava/lang/String;
    const-wide/16 v3, 0x2

    invoke-virtual {p0, v3, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->skip(J)V

    goto :goto_1

    .line 296
    .end local v2    # "result":Ljava/lang/String;
    :cond_3
    invoke-virtual {p0, v0, v1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readUtf8(J)Ljava/lang/String;

    move-result-object v2

    .line 297
    .restart local v2    # "result":Ljava/lang/String;
    invoke-virtual {p0, v5, v6}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->skip(J)V

    goto :goto_1
.end method

.method public require(J)V
    .locals 2
    .param p1, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/EOFException;
        }
    .end annotation

    .prologue
    .line 93
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    cmp-long v0, v0, p1

    if-gez v0, :cond_0

    new-instance v0, Ljava/io/EOFException;

    invoke-direct {v0}, Ljava/io/EOFException;-><init>()V

    throw v0

    .line 94
    :cond_0
    return-void
.end method

.method public seek(B)J
    .locals 4
    .param p1, "b"    # B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/EOFException;
        }
    .end annotation

    .prologue
    .line 97
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->indexOf(B)J

    move-result-wide v0

    .line 98
    .local v0, "index":J
    const-wide/16 v2, -0x1

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    new-instance v2, Ljava/io/EOFException;

    invoke-direct {v2}, Ljava/io/EOFException;-><init>()V

    throw v2

    .line 99
    :cond_0
    return-wide v0
.end method

.method segmentSizes()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 605
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-nez v2, :cond_1

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 611
    :cond_0
    return-object v0

    .line 606
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 607
    .local v0, "result":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v2, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v3, v3, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 608
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v1, v2, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .local v1, "s":Lcom/squareup/okhttp/internal/okio/Segment;
    :goto_0
    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-eq v1, v2, :cond_0

    .line 609
    iget v2, v1, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v3, v1, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 608
    iget-object v1, v1, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    goto :goto_0
.end method

.method public size()J
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    return-wide v0
.end method

.method public skip(J)V
    .locals 8
    .param p1, "byteCount"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 357
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    move-wide v4, p1

    invoke-static/range {v0 .. v5}, Lcom/squareup/okhttp/internal/okio/Util;->checkOffsetAndCount(JJJ)V

    .line 359
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    sub-long/2addr v0, p1

    iput-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 360
    :cond_0
    :goto_0
    cmp-long v0, p1, v2

    if-lez v0, :cond_1

    .line 361
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v0, v0, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v1, v1, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v0, v1

    int-to-long v0, v0

    invoke-static {p1, p2, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int v7, v0

    .line 362
    .local v7, "toSkip":I
    int-to-long v0, v7

    sub-long/2addr p1, v0

    .line 363
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v1, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    add-int/2addr v1, v7

    iput v1, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    .line 365
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v0, v0, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v1, v1, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    if-ne v0, v1, :cond_0

    .line 366
    iget-object v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 367
    .local v6, "toRecycle":Lcom/squareup/okhttp/internal/okio/Segment;
    invoke-virtual {v6}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 368
    sget-object v0, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v0, v6}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->recycle(Lcom/squareup/okhttp/internal/okio/Segment;)V

    goto :goto_0

    .line 371
    .end local v6    # "toRecycle":Lcom/squareup/okhttp/internal/okio/Segment;
    .end local v7    # "toSkip":I
    :cond_1
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 660
    iget-wide v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v6, 0x0

    cmp-long v4, v4, v6

    if-nez v4, :cond_0

    .line 661
    const-string/jumbo v4, "OkBuffer[size=0]"

    .line 675
    :goto_0
    return-object v4

    .line 664
    :cond_0
    iget-wide v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v6, 0x10

    cmp-long v4, v4, v6

    if-gtz v4, :cond_1

    .line 665
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->clone()Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v4

    iget-wide v5, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-virtual {v4, v5, v6}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->readByteString(J)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v0

    .line 666
    .local v0, "data":Lcom/squareup/okhttp/internal/okio/ByteString;
    const-string/jumbo v4, "OkBuffer[size=%s data=%s]"

    new-array v5, v10, [Ljava/lang/Object;

    iget-wide v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/okio/ByteString;->hex()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v9

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 670
    .end local v0    # "data":Lcom/squareup/okhttp/internal/okio/ByteString;
    :cond_1
    :try_start_0
    const-string/jumbo v4, "MD5"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    .line 671
    .local v2, "md5":Ljava/security/MessageDigest;
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v4, v4, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget-object v5, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v5, v5, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget-object v6, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v6, v6, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget-object v7, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v7, v7, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v6, v7

    invoke-virtual {v2, v4, v5, v6}, Ljava/security/MessageDigest;->update([BII)V

    .line 672
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v3, v4, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .local v3, "s":Lcom/squareup/okhttp/internal/okio/Segment;
    :goto_1
    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-eq v3, v4, :cond_2

    .line 673
    iget-object v4, v3, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v5, v3, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    iget v6, v3, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v7, v3, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v6, v7

    invoke-virtual {v2, v4, v5, v6}, Ljava/security/MessageDigest;->update([BII)V

    .line 672
    iget-object v3, v3, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    goto :goto_1

    .line 675
    :cond_2
    const-string/jumbo v4, "OkBuffer[size=%s md5=%s]"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-wide v7, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-virtual {v2}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v7

    invoke-static {v7}, Lcom/squareup/okhttp/internal/okio/ByteString;->of([B)Lcom/squareup/okhttp/internal/okio/ByteString;

    move-result-object v7

    invoke-virtual {v7}, Lcom/squareup/okhttp/internal/okio/ByteString;->hex()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    goto :goto_0

    .line 677
    .end local v2    # "md5":Ljava/security/MessageDigest;
    .end local v3    # "s":Lcom/squareup/okhttp/internal/okio/Segment;
    :catch_0
    move-exception v1

    .line 678
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    new-instance v4, Ljava/lang/AssertionError;

    invoke-direct {v4}, Ljava/lang/AssertionError;-><init>()V

    throw v4
.end method

.method writableSegment(I)Lcom/squareup/okhttp/internal/okio/Segment;
    .locals 3
    .param p1, "minimumCapacity"    # I

    .prologue
    const/16 v2, 0x800

    .line 447
    const/4 v1, 0x1

    if-lt p1, v1, :cond_0

    if-le p1, v2, :cond_1

    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 449
    :cond_1
    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-nez v1, :cond_3

    .line 450
    sget-object v1, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->take()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v1

    iput-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 451
    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v2, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iput-object v0, v2, Lcom/squareup/okhttp/internal/okio/Segment;->prev:Lcom/squareup/okhttp/internal/okio/Segment;

    iput-object v0, v1, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 458
    :cond_2
    :goto_0
    return-object v0

    .line 454
    :cond_3
    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v0, v1, Lcom/squareup/okhttp/internal/okio/Segment;->prev:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 455
    .local v0, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v1, v0, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    add-int/2addr v1, p1

    if-le v1, v2, :cond_2

    .line 456
    sget-object v1, Lcom/squareup/okhttp/internal/okio/SegmentPool;->INSTANCE:Lcom/squareup/okhttp/internal/okio/SegmentPool;

    invoke-virtual {v1}, Lcom/squareup/okhttp/internal/okio/SegmentPool;->take()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/okio/Segment;->push(Lcom/squareup/okhttp/internal/okio/Segment;)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic write(Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "x0"    # Lcom/squareup/okhttp/internal/okio/ByteString;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write(Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic write([B)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "x0"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([B)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic write([BII)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "x0"    # [B
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0, p1, p2, p3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public write(Lcom/squareup/okhttp/internal/okio/ByteString;)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 3
    .param p1, "byteString"    # Lcom/squareup/okhttp/internal/okio/ByteString;

    .prologue
    .line 375
    iget-object v0, p1, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    const/4 v1, 0x0

    iget-object v2, p1, Lcom/squareup/okhttp/internal/okio/ByteString;->data:[B

    array-length v2, v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public write([B)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 2
    .param p1, "source"    # [B

    .prologue
    .line 389
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 7
    .param p1, "source"    # [B
    .param p2, "offset"    # I
    .param p3, "byteCount"    # I

    .prologue
    .line 393
    add-int v0, p2, p3

    .line 394
    .local v0, "limit":I
    :goto_0
    if-ge p2, v0, :cond_0

    .line 395
    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writableSegment(I)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v1

    .line 397
    .local v1, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    sub-int v3, v0, p2

    iget v4, v1, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    rsub-int v4, v4, 0x800

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 398
    .local v2, "toCopy":I
    iget-object v3, v1, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v4, v1, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    invoke-static {p1, p2, v3, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 400
    add-int/2addr p2, v2

    .line 401
    iget v3, v1, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    add-int/2addr v3, v2

    iput v3, v1, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    goto :goto_0

    .line 404
    .end local v1    # "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    .end local v2    # "toCopy":I
    :cond_0
    iget-wide v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    int-to-long v5, p3

    add-long/2addr v3, v5

    iput-wide v3, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 405
    return-object p0
.end method

.method public write(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)V
    .locals 10
    .param p1, "source"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 512
    if-ne p1, p0, :cond_0

    .line 513
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "source == this"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 515
    :cond_0
    iget-wide v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    move-wide v4, p2

    invoke-static/range {v0 .. v5}, Lcom/squareup/okhttp/internal/okio/Util;->checkOffsetAndCount(JJJ)V

    .line 517
    :goto_0
    cmp-long v0, p2, v2

    if-lez v0, :cond_5

    .line 519
    iget-object v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v0, v0, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget-object v1, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget v1, v1, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v0, v1

    int-to-long v0, v0

    cmp-long v0, p2, v0

    if-gez v0, :cond_2

    .line 520
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v9, v0, Lcom/squareup/okhttp/internal/okio/Segment;->prev:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 521
    .local v9, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    :goto_1
    if-eqz v9, :cond_1

    iget v0, v9, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v1, v9, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v0, v1

    int-to-long v0, v0

    add-long/2addr v0, p2

    const-wide/16 v4, 0x800

    cmp-long v0, v0, v4

    if-lez v0, :cond_4

    .line 524
    :cond_1
    iget-object v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    long-to-int v1, p2

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/okio/Segment;->split(I)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v0

    iput-object v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 535
    .end local v9    # "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    :cond_2
    iget-object v8, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 536
    .local v8, "segmentToMove":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v0, v8, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    iget v1, v8, Lcom/squareup/okhttp/internal/okio/Segment;->pos:I

    sub-int/2addr v0, v1

    int-to-long v6, v0

    .line 537
    .local v6, "movedByteCount":J
    invoke-virtual {v8}, Lcom/squareup/okhttp/internal/okio/Segment;->pop()Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v0

    iput-object v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 538
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    if-nez v0, :cond_6

    .line 539
    iput-object v8, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 540
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iput-object v4, v1, Lcom/squareup/okhttp/internal/okio/Segment;->prev:Lcom/squareup/okhttp/internal/okio/Segment;

    iput-object v4, v0, Lcom/squareup/okhttp/internal/okio/Segment;->next:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 546
    :goto_2
    iget-wide v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    sub-long/2addr v0, v6

    iput-wide v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 547
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    add-long/2addr v0, v6

    iput-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 548
    sub-long/2addr p2, v6

    .line 549
    goto :goto_0

    .line 520
    .end local v6    # "movedByteCount":J
    .end local v8    # "segmentToMove":Lcom/squareup/okhttp/internal/okio/Segment;
    :cond_3
    const/4 v9, 0x0

    goto :goto_1

    .line 527
    .restart local v9    # "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    :cond_4
    iget-object v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    long-to-int v1, p2

    invoke-virtual {v0, v9, v1}, Lcom/squareup/okhttp/internal/okio/Segment;->writeTo(Lcom/squareup/okhttp/internal/okio/Segment;I)V

    .line 528
    iget-wide v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    sub-long/2addr v0, p2

    iput-wide v0, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 529
    iget-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    add-long/2addr v0, p2

    iput-wide v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 550
    .end local v9    # "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    :cond_5
    return-void

    .line 542
    .restart local v6    # "movedByteCount":J
    .restart local v8    # "segmentToMove":Lcom/squareup/okhttp/internal/okio/Segment;
    :cond_6
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->head:Lcom/squareup/okhttp/internal/okio/Segment;

    iget-object v9, v0, Lcom/squareup/okhttp/internal/okio/Segment;->prev:Lcom/squareup/okhttp/internal/okio/Segment;

    .line 543
    .restart local v9    # "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    invoke-virtual {v9, v8}, Lcom/squareup/okhttp/internal/okio/Segment;->push(Lcom/squareup/okhttp/internal/okio/Segment;)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v9

    .line 544
    invoke-virtual {v9}, Lcom/squareup/okhttp/internal/okio/Segment;->compact()V

    goto :goto_2
.end method

.method public bridge synthetic writeByte(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "x0"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeByte(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public writeByte(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 5
    .param p1, "b"    # I

    .prologue
    .line 410
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writableSegment(I)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v0

    .line 411
    .local v0, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    iget-object v1, v0, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v2, v0, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    add-int/lit8 v3, v2, 0x1

    iput v3, v0, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    int-to-byte v3, p1

    aput-byte v3, v1, v2

    .line 412
    iget-wide v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iput-wide v1, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 413
    return-object p0
.end method

.method public bridge synthetic writeInt(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "x0"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeInt(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public writeInt(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 8
    .param p1, "i"    # I

    .prologue
    .line 430
    const/4 v4, 0x4

    invoke-virtual {p0, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writableSegment(I)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v3

    .line 431
    .local v3, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    iget-object v0, v3, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    .line 432
    .local v0, "data":[B
    iget v1, v3, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 433
    .local v1, "limit":I
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "limit":I
    .local v2, "limit":I
    shr-int/lit8 v4, p1, 0x18

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v0, v1

    .line 434
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "limit":I
    .restart local v1    # "limit":I
    shr-int/lit8 v4, p1, 0x10

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v0, v2

    .line 435
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "limit":I
    .restart local v2    # "limit":I
    shr-int/lit8 v4, p1, 0x8

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v0, v1

    .line 436
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "limit":I
    .restart local v1    # "limit":I
    and-int/lit16 v4, p1, 0xff

    int-to-byte v4, v4

    aput-byte v4, v0, v2

    .line 437
    iput v1, v3, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 438
    iget-wide v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v6, 0x4

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 439
    return-object p0
.end method

.method public bridge synthetic writeShort(I)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "x0"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeShort(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public writeShort(I)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 8
    .param p1, "s"    # I

    .prologue
    .line 418
    const/4 v4, 0x2

    invoke-virtual {p0, v4}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writableSegment(I)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v3

    .line 419
    .local v3, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    iget-object v0, v3, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    .line 420
    .local v0, "data":[B
    iget v1, v3, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 421
    .local v1, "limit":I
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "limit":I
    .local v2, "limit":I
    shr-int/lit8 v4, p1, 0x8

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v0, v1

    .line 422
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "limit":I
    .restart local v1    # "limit":I
    and-int/lit16 v4, p1, 0xff

    int-to-byte v4, v4

    aput-byte v4, v0, v2

    .line 423
    iput v1, v3, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 424
    iget-wide v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    const-wide/16 v6, 0x2

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 425
    return-object p0
.end method

.method public bridge synthetic writeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/OkBuffer;

    move-result-object v0

    return-object v0
.end method

.method public writeUtf8(Ljava/lang/String;)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .locals 4
    .param p1, "string"    # Ljava/lang/String;

    .prologue
    .line 381
    :try_start_0
    const-string/jumbo v2, "UTF-8"

    invoke-virtual {p1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    .line 382
    .local v0, "data":[B
    const/4 v2, 0x0

    array-length v3, v0

    invoke-virtual {p0, v0, v2, v3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->write([BII)Lcom/squareup/okhttp/internal/okio/OkBuffer;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 383
    .end local v0    # "data":[B
    :catch_0
    move-exception v1

    .line 384
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/AssertionError;

    invoke-direct {v2, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2
.end method
