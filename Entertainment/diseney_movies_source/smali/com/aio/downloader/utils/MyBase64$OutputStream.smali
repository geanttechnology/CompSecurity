.class public Lcom/aio/downloader/utils/MyBase64$OutputStream;
.super Ljava/io/FilterOutputStream;
.source "MyBase64.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/utils/MyBase64;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OutputStream"
.end annotation


# instance fields
.field private b4:[B

.field private breakLines:Z

.field private buffer:[B

.field private bufferLength:I

.field private decodabet:[B

.field private encode:Z

.field private lineLength:I

.field private options:I

.field private position:I

.field private suspendEncoding:Z


# direct methods
.method public constructor <init>(Ljava/io/OutputStream;)V
    .locals 1
    .param p1, "out"    # Ljava/io/OutputStream;

    .prologue
    .line 2063
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/utils/MyBase64$OutputStream;-><init>(Ljava/io/OutputStream;I)V

    .line 2064
    return-void
.end method

.method public constructor <init>(Ljava/io/OutputStream;I)V
    .locals 4
    .param p1, "out"    # Ljava/io/OutputStream;
    .param p2, "options"    # I

    .prologue
    const/4 v3, 0x4

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 2091
    invoke-direct {p0, p1}, Ljava/io/FilterOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 2092
    and-int/lit8 v0, p2, 0x8

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->breakLines:Z

    .line 2093
    and-int/lit8 v0, p2, 0x1

    if-eqz v0, :cond_1

    :goto_1
    iput-boolean v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->encode:Z

    .line 2094
    iget-boolean v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->encode:Z

    if-eqz v0, :cond_2

    const/4 v0, 0x3

    :goto_2
    iput v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->bufferLength:I

    .line 2095
    iget v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->bufferLength:I

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->buffer:[B

    .line 2096
    iput v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    .line 2097
    iput v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->lineLength:I

    .line 2098
    iput-boolean v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->suspendEncoding:Z

    .line 2099
    new-array v0, v3, [B

    iput-object v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->b4:[B

    .line 2100
    iput p2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->options:I

    .line 2101
    # invokes: Lcom/aio/downloader/utils/MyBase64;->getDecodabet(I)[B
    invoke-static {p2}, Lcom/aio/downloader/utils/MyBase64;->access$0(I)[B

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->decodabet:[B

    .line 2102
    return-void

    :cond_0
    move v0, v2

    .line 2092
    goto :goto_0

    :cond_1
    move v1, v2

    .line 2093
    goto :goto_1

    :cond_2
    move v0, v3

    .line 2094
    goto :goto_2
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
    const/4 v0, 0x0

    .line 2214
    invoke-virtual {p0}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->flushBase64()V

    .line 2218
    invoke-super {p0}, Ljava/io/FilterOutputStream;->close()V

    .line 2220
    iput-object v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->buffer:[B

    .line 2221
    iput-object v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->out:Ljava/io/OutputStream;

    .line 2222
    return-void
.end method

.method public flushBase64()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2193
    iget v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    if-lez v0, :cond_0

    .line 2194
    iget-boolean v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->encode:Z

    if-eqz v0, :cond_1

    .line 2195
    iget-object v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->out:Ljava/io/OutputStream;

    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->b4:[B

    iget-object v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->buffer:[B

    iget v3, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    iget v4, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->options:I

    # invokes: Lcom/aio/downloader/utils/MyBase64;->encode3to4([B[BII)[B
    invoke-static {v1, v2, v3, v4}, Lcom/aio/downloader/utils/MyBase64;->access$3([B[BII)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write([B)V

    .line 2196
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    .line 2204
    :cond_0
    return-void

    .line 2199
    :cond_1
    new-instance v0, Ljava/io/IOException;

    .line 2200
    const-string v1, "Base64 input not properly padded."

    .line 2199
    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public resumeEncoding()V
    .locals 1

    .prologue
    .line 2244
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->suspendEncoding:Z

    .line 2245
    return-void
.end method

.method public suspendEncoding()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2233
    invoke-virtual {p0}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->flushBase64()V

    .line 2234
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->suspendEncoding:Z

    .line 2235
    return-void
.end method

.method public write(I)V
    .locals 7
    .param p1, "theByte"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, -0x5

    const/4 v6, 0x0

    .line 2117
    iget-boolean v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->suspendEncoding:Z

    if-eqz v1, :cond_1

    .line 2118
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, p1}, Ljava/io/OutputStream;->write(I)V

    .line 2156
    :cond_0
    :goto_0
    return-void

    .line 2123
    :cond_1
    iget-boolean v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->encode:Z

    if-eqz v1, :cond_3

    .line 2124
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->buffer:[B

    iget v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    int-to-byte v3, p1

    aput-byte v3, v1, v2

    .line 2125
    iget v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    iget v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->bufferLength:I

    if-lt v1, v2, :cond_0

    .line 2127
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->out:Ljava/io/OutputStream;

    iget-object v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->b4:[B

    iget-object v3, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->buffer:[B

    iget v4, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->bufferLength:I

    iget v5, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->options:I

    # invokes: Lcom/aio/downloader/utils/MyBase64;->encode3to4([B[BII)[B
    invoke-static {v2, v3, v4, v5}, Lcom/aio/downloader/utils/MyBase64;->access$3([B[BII)[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/OutputStream;->write([B)V

    .line 2129
    iget v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->lineLength:I

    add-int/lit8 v1, v1, 0x4

    iput v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->lineLength:I

    .line 2130
    iget-boolean v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->breakLines:Z

    if-eqz v1, :cond_2

    iget v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->lineLength:I

    const/16 v2, 0x4c

    if-lt v1, v2, :cond_2

    .line 2131
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->out:Ljava/io/OutputStream;

    const/16 v2, 0xa

    invoke-virtual {v1, v2}, Ljava/io/OutputStream;->write(I)V

    .line 2132
    iput v6, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->lineLength:I

    .line 2135
    :cond_2
    iput v6, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    goto :goto_0

    .line 2142
    :cond_3
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->decodabet:[B

    and-int/lit8 v2, p1, 0x7f

    aget-byte v1, v1, v2

    if-le v1, v3, :cond_4

    .line 2143
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->buffer:[B

    iget v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    add-int/lit8 v3, v2, 0x1

    iput v3, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    int-to-byte v3, p1

    aput-byte v3, v1, v2

    .line 2144
    iget v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    iget v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->bufferLength:I

    if-lt v1, v2, :cond_0

    .line 2146
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->buffer:[B

    iget-object v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->b4:[B

    iget v3, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->options:I

    # invokes: Lcom/aio/downloader/utils/MyBase64;->decode4to3([BI[BII)I
    invoke-static {v1, v6, v2, v6, v3}, Lcom/aio/downloader/utils/MyBase64;->access$2([BI[BII)I

    move-result v0

    .line 2147
    .local v0, "len":I
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->out:Ljava/io/OutputStream;

    iget-object v2, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->b4:[B

    invoke-virtual {v1, v2, v6, v0}, Ljava/io/OutputStream;->write([BII)V

    .line 2148
    iput v6, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->position:I

    goto :goto_0

    .line 2151
    .end local v0    # "len":I
    :cond_4
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->decodabet:[B

    and-int/lit8 v2, p1, 0x7f

    aget-byte v1, v1, v2

    if-eq v1, v3, :cond_0

    .line 2152
    new-instance v1, Ljava/io/IOException;

    .line 2153
    const-string v2, "Invalid character in Base64 data."

    .line 2152
    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public write([BII)V
    .locals 2
    .param p1, "theBytes"    # [B
    .param p2, "off"    # I
    .param p3, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2174
    iget-boolean v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->suspendEncoding:Z

    if-eqz v1, :cond_1

    .line 2175
    iget-object v1, p0, Lcom/aio/downloader/utils/MyBase64$OutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V

    .line 2183
    :cond_0
    return-void

    .line 2179
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p3, :cond_0

    .line 2180
    add-int v1, p2, v0

    aget-byte v1, p1, v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/utils/MyBase64$OutputStream;->write(I)V

    .line 2179
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method
