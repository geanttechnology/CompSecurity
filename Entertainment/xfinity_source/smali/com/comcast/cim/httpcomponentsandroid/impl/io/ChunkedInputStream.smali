.class public Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;
.super Ljava/io/InputStream;
.source "ChunkedInputStream.java"


# instance fields
.field private final buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

.field private chunkSize:I

.field private closed:Z

.field private eof:Z

.field private footers:[Lcom/comcast/cim/httpcomponentsandroid/Header;

.field private final in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

.field private pos:I

.field private state:I


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;)V
    .locals 2
    .param p1, "in"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    .prologue
    const/4 v1, 0x0

    .line 93
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 80
    iput-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    .line 83
    iput-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->closed:Z

    .line 85
    new-array v0, v1, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->footers:[Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 94
    if-nez p1, :cond_0

    .line 95
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Session input buffer may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 97
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    .line 98
    iput v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    .line 99
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/16 v1, 0x10

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    .line 100
    const/4 v0, 0x1

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->state:I

    .line 101
    return-void
.end method

.method private getChunkSize()I
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, -0x1

    const/4 v4, 0x0

    .line 230
    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->state:I

    .line 231
    .local v3, "st":I
    packed-switch v3, :pswitch_data_0

    .line 260
    :pswitch_0
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "Inconsistent codec state"

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 233
    :pswitch_1
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->clear()V

    .line 234
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->readLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)I

    move-result v1

    .line 235
    .local v1, "i":I
    if-ne v1, v7, :cond_1

    .line 255
    :cond_0
    :goto_0
    return v4

    .line 238
    :cond_1
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_2

    .line 239
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;

    const-string v5, "Unexpected content at the end of chunk"

    invoke-direct {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 242
    :cond_2
    const/4 v5, 0x1

    iput v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->state:I

    .line 245
    .end local v1    # "i":I
    :pswitch_2
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->clear()V

    .line 246
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {v5, v6}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->readLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)I

    move-result v1

    .line 247
    .restart local v1    # "i":I
    if-eq v1, v7, :cond_0

    .line 250
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/16 v5, 0x3b

    invoke-virtual {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->indexOf(I)I

    move-result v2

    .line 251
    .local v2, "separator":I
    if-gez v2, :cond_3

    .line 252
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v2

    .line 255
    :cond_3
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->buffer:Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/4 v5, 0x0

    invoke-virtual {v4, v5, v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substringTrimmed(II)Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x10

    invoke-static {v4, v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    goto :goto_0

    .line 256
    :catch_0
    move-exception v0

    .line 257
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;

    const-string v5, "Bad chunk header"

    invoke-direct {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 231
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private nextChunk()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 204
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->getChunkSize()I

    move-result v0

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->chunkSize:I

    .line 205
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->chunkSize:I

    if-gez v0, :cond_0

    .line 206
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;

    const-string v1, "Negative chunk size"

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 208
    :cond_0
    const/4 v0, 0x2

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->state:I

    .line 209
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    .line 210
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->chunkSize:I

    if-nez v0, :cond_1

    .line 211
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    .line 212
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->parseTrailerHeaders()V

    .line 214
    :cond_1
    return-void
.end method

.method private parseTrailerHeaders()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 270
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    const/4 v3, -0x1

    const/4 v4, -0x1

    const/4 v5, 0x0

    invoke-static {v2, v3, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractMessageParser;->parseHeaders(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;IILcom/comcast/cim/httpcomponentsandroid/message/LineParser;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->footers:[Lcom/comcast/cim/httpcomponentsandroid/Header;
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_0 .. :try_end_0} :catch_0

    .line 278
    return-void

    .line 272
    :catch_0
    move-exception v0

    .line 273
    .local v0, "e":Lcom/comcast/cim/httpcomponentsandroid/HttpException;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Invalid footer: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/MalformedChunkCodingException;-><init>(Ljava/lang/String;)V

    .line 275
    .local v1, "ioe":Ljava/io/IOException;
    invoke-static {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/util/ExceptionUtils;->initCause(Ljava/lang/Throwable;Ljava/lang/Throwable;)V

    .line 276
    throw v1
.end method


# virtual methods
.method public available()I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 104
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    instance-of v1, v1, Lcom/comcast/cim/httpcomponentsandroid/io/BufferInfo;

    if-eqz v1, :cond_0

    .line 105
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/io/BufferInfo;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/io/BufferInfo;->length()I

    move-result v0

    .line 106
    .local v0, "len":I
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->chunkSize:I

    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 108
    .end local v0    # "len":I
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public close()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 287
    iget-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->closed:Z

    if-nez v1, :cond_2

    .line 289
    :try_start_0
    iget-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    if-nez v1, :cond_1

    .line 291
    const/16 v1, 0x800

    new-array v0, v1, [B

    .line 292
    .local v0, "buffer":[B
    :cond_0
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->read([B)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-gez v1, :cond_0

    .line 296
    .end local v0    # "buffer":[B
    :cond_1
    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    .line 297
    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->closed:Z

    .line 300
    :cond_2
    return-void

    .line 296
    :catchall_0
    move-exception v1

    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    .line 297
    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->closed:Z

    throw v1
.end method

.method public getFooters()[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->footers:[Lcom/comcast/cim/httpcomponentsandroid/Header;

    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    check-cast v0, [Lcom/comcast/cim/httpcomponentsandroid/Header;

    return-object v0
.end method

.method public read()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, -0x1

    .line 125
    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->closed:Z

    if-eqz v2, :cond_0

    .line 126
    new-instance v1, Ljava/io/IOException;

    const-string v2, "Attempted read from closed stream."

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 128
    :cond_0
    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    if-eqz v2, :cond_2

    move v0, v1

    .line 144
    :cond_1
    :goto_0
    return v0

    .line 131
    :cond_2
    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->state:I

    const/4 v3, 0x2

    if-eq v2, v3, :cond_3

    .line 132
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->nextChunk()V

    .line 133
    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    if-eqz v2, :cond_3

    move v0, v1

    .line 134
    goto :goto_0

    .line 137
    :cond_3
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->read()I

    move-result v0

    .line 138
    .local v0, "b":I
    if-eq v0, v1, :cond_1

    .line 139
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    .line 140
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->chunkSize:I

    if-lt v1, v2, :cond_1

    .line 141
    const/4 v1, 0x3

    iput v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->state:I

    goto :goto_0
.end method

.method public read([B)I
    .locals 2
    .param p1, "b"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 196
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->read([BII)I

    move-result v0

    return v0
.end method

.method public read([BII)I
    .locals 4
    .param p1, "b"    # [B
    .param p2, "off"    # I
    .param p3, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, -0x1

    .line 159
    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->closed:Z

    if-eqz v2, :cond_0

    .line 160
    new-instance v1, Ljava/io/IOException;

    const-string v2, "Attempted read from closed stream."

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 163
    :cond_0
    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    if-eqz v2, :cond_2

    move v0, v1

    .line 179
    :cond_1
    :goto_0
    return v0

    .line 166
    :cond_2
    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->state:I

    const/4 v3, 0x2

    if-eq v2, v3, :cond_3

    .line 167
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->nextChunk()V

    .line 168
    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    if-eqz v2, :cond_3

    move v0, v1

    .line 169
    goto :goto_0

    .line 172
    :cond_3
    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->chunkSize:I

    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    sub-int/2addr v2, v3

    invoke-static {p3, v2}, Ljava/lang/Math;->min(II)I

    move-result p3

    .line 173
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-interface {v2, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->read([BII)I

    move-result v0

    .line 174
    .local v0, "bytesRead":I
    if-eq v0, v1, :cond_4

    .line 175
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    add-int/2addr v1, v0

    iput v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    .line 176
    iget v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->chunkSize:I

    if-lt v1, v2, :cond_1

    .line 177
    const/4 v1, 0x3

    iput v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->state:I

    goto :goto_0

    .line 181
    :cond_4
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->eof:Z

    .line 182
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/TruncatedChunkException;

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Truncated chunk ( expected size: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->chunkSize:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "; actual size: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/ChunkedInputStream;->pos:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/TruncatedChunkException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
