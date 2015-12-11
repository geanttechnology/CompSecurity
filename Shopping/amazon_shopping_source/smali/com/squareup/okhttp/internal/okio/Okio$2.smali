.class final Lcom/squareup/okhttp/internal/okio/Okio$2;
.super Ljava/lang/Object;
.source "Okio.java"

# interfaces
.implements Lcom/squareup/okhttp/internal/okio/Source;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/squareup/okhttp/internal/okio/Okio;->source(Ljava/io/InputStream;)Lcom/squareup/okhttp/internal/okio/Source;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field private deadline:Lcom/squareup/okhttp/internal/okio/Deadline;

.field final synthetic val$in:Ljava/io/InputStream;


# direct methods
.method constructor <init>(Ljava/io/InputStream;)V
    .locals 1

    .prologue
    .line 105
    iput-object p1, p0, Lcom/squareup/okhttp/internal/okio/Okio$2;->val$in:Ljava/io/InputStream;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 106
    sget-object v0, Lcom/squareup/okhttp/internal/okio/Deadline;->NONE:Lcom/squareup/okhttp/internal/okio/Deadline;

    iput-object v0, p0, Lcom/squareup/okhttp/internal/okio/Okio$2;->deadline:Lcom/squareup/okhttp/internal/okio/Deadline;

    return-void
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
    iget-object v0, p0, Lcom/squareup/okhttp/internal/okio/Okio$2;->val$in:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 122
    return-void
.end method

.method public deadline(Lcom/squareup/okhttp/internal/okio/Deadline;)Lcom/squareup/okhttp/internal/okio/Source;
    .locals 2
    .param p1, "deadline"    # Lcom/squareup/okhttp/internal/okio/Deadline;

    .prologue
    .line 125
    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "deadline == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 126
    :cond_0
    iput-object p1, p0, Lcom/squareup/okhttp/internal/okio/Okio$2;->deadline:Lcom/squareup/okhttp/internal/okio/Deadline;

    .line 127
    return-object p0
.end method

.method public read(Lcom/squareup/okhttp/internal/okio/OkBuffer;J)J
    .locals 7
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/OkBuffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 109
    const-wide/16 v3, 0x0

    cmp-long v3, p2, v3

    if-gez v3, :cond_0

    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "byteCount < 0: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 110
    :cond_0
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/Okio$2;->deadline:Lcom/squareup/okhttp/internal/okio/Deadline;

    invoke-virtual {v3}, Lcom/squareup/okhttp/internal/okio/Deadline;->throwIfReached()V

    .line 111
    const/4 v3, 0x1

    invoke-virtual {p1, v3}, Lcom/squareup/okhttp/internal/okio/OkBuffer;->writableSegment(I)Lcom/squareup/okhttp/internal/okio/Segment;

    move-result-object v2

    .line 112
    .local v2, "tail":Lcom/squareup/okhttp/internal/okio/Segment;
    iget v3, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    rsub-int v3, v3, 0x800

    int-to-long v3, v3

    invoke-static {p2, p3, v3, v4}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v3

    long-to-int v1, v3

    .line 113
    .local v1, "maxToCopy":I
    iget-object v3, p0, Lcom/squareup/okhttp/internal/okio/Okio$2;->val$in:Ljava/io/InputStream;

    iget-object v4, v2, Lcom/squareup/okhttp/internal/okio/Segment;->data:[B

    iget v5, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    invoke-virtual {v3, v4, v5, v1}, Ljava/io/InputStream;->read([BII)I

    move-result v0

    .line 114
    .local v0, "bytesRead":I
    const/4 v3, -0x1

    if-ne v0, v3, :cond_1

    const-wide/16 v3, -0x1

    .line 117
    :goto_0
    return-wide v3

    .line 115
    :cond_1
    iget v3, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    add-int/2addr v3, v0

    iput v3, v2, Lcom/squareup/okhttp/internal/okio/Segment;->limit:I

    .line 116
    iget-wide v3, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    int-to-long v5, v0

    add-long/2addr v3, v5

    iput-wide v3, p1, Lcom/squareup/okhttp/internal/okio/OkBuffer;->size:J

    .line 117
    int-to-long v3, v0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 131
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "source("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/squareup/okhttp/internal/okio/Okio$2;->val$in:Ljava/io/InputStream;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
