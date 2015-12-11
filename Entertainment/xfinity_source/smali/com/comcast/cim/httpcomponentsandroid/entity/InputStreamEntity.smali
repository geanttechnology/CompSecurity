.class public Lcom/comcast/cim/httpcomponentsandroid/entity/InputStreamEntity;
.super Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;
.source "InputStreamEntity.java"


# instance fields
.field private final content:Ljava/io/InputStream;

.field private final length:J


# virtual methods
.method public getContent()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 65
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/InputStreamEntity;->content:Ljava/io/InputStream;

    return-object v0
.end method

.method public getContentLength()J
    .locals 2

    .prologue
    .line 61
    iget-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/InputStreamEntity;->length:J

    return-wide v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 57
    const/4 v0, 0x0

    return v0
.end method

.method public isStreaming()Z
    .locals 1

    .prologue
    .line 99
    const/4 v0, 0x1

    return v0
.end method

.method public writeTo(Ljava/io/OutputStream;)V
    .locals 12
    .param p1, "outstream"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v10, 0x0

    const/4 v8, -0x1

    .line 69
    if-nez p1, :cond_0

    .line 70
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v6, "Output stream may not be null"

    invoke-direct {v3, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 72
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/InputStreamEntity;->content:Ljava/io/InputStream;

    .line 74
    .local v1, "instream":Ljava/io/InputStream;
    const/16 v3, 0x800

    :try_start_0
    new-array v0, v3, [B

    .line 76
    .local v0, "buffer":[B
    iget-wide v6, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/InputStreamEntity;->length:J

    cmp-long v3, v6, v10

    if-gez v3, :cond_1

    .line 78
    :goto_0
    invoke-virtual {v1, v0}, Ljava/io/InputStream;->read([B)I

    move-result v2

    .local v2, "l":I
    if-eq v2, v8, :cond_2

    .line 79
    const/4 v3, 0x0

    invoke-virtual {p1, v0, v3, v2}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 94
    .end local v0    # "buffer":[B
    .end local v2    # "l":I
    :catchall_0
    move-exception v3

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    throw v3

    .line 83
    .restart local v0    # "buffer":[B
    :cond_1
    :try_start_1
    iget-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/InputStreamEntity;->length:J

    .line 84
    .local v4, "remaining":J
    :goto_1
    cmp-long v3, v4, v10

    if-lez v3, :cond_2

    .line 85
    const/4 v3, 0x0

    const-wide/16 v6, 0x800

    invoke-static {v6, v7, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v6

    long-to-int v6, v6

    invoke-virtual {v1, v0, v3, v6}, Ljava/io/InputStream;->read([BII)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    .line 86
    .restart local v2    # "l":I
    if-ne v2, v8, :cond_3

    .line 94
    .end local v2    # "l":I
    .end local v4    # "remaining":J
    :cond_2
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 96
    return-void

    .line 89
    .restart local v2    # "l":I
    .restart local v4    # "remaining":J
    :cond_3
    const/4 v3, 0x0

    :try_start_2
    invoke-virtual {p1, v0, v3, v2}, Ljava/io/OutputStream;->write([BII)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 90
    int-to-long v6, v2

    sub-long/2addr v4, v6

    goto :goto_1
.end method
