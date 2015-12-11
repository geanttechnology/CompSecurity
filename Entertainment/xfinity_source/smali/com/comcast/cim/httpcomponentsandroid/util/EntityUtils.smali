.class public final Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;
.super Ljava/lang/Object;
.source "EntityUtils.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    return-void
.end method

.method public static consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 2
    .param p0, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 61
    if-nez p0, :cond_1

    .line 70
    :cond_0
    :goto_0
    return-void

    .line 64
    :cond_1
    invoke-interface {p0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isStreaming()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 65
    invoke-interface {p0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    .line 66
    .local v0, "instream":Ljava/io/InputStream;
    if-eqz v0, :cond_0

    .line 67
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    goto :goto_0
.end method

.method public static toByteArray(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)[B
    .locals 10
    .param p0, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 82
    if-nez p0, :cond_0

    .line 83
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "HTTP entity may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 85
    :cond_0
    invoke-interface {p0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v2

    .line 86
    .local v2, "instream":Ljava/io/InputStream;
    if-nez v2, :cond_1

    .line 87
    const/4 v5, 0x0

    .line 105
    :goto_0
    return-object v5

    .line 90
    :cond_1
    :try_start_0
    invoke-interface {p0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v6

    const-wide/32 v8, 0x7fffffff

    cmp-long v5, v6, v8

    if-lez v5, :cond_2

    .line 91
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "HTTP entity too large to be buffered in memory"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 105
    :catchall_0
    move-exception v5

    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    throw v5

    .line 93
    :cond_2
    :try_start_1
    invoke-interface {p0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentLength()J

    move-result-wide v6

    long-to-int v1, v6

    .line 94
    .local v1, "i":I
    if-gez v1, :cond_3

    .line 95
    const/16 v1, 0x1000

    .line 97
    :cond_3
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/ByteArrayBuffer;

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/ByteArrayBuffer;-><init>(I)V

    .line 98
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/ByteArrayBuffer;
    const/16 v5, 0x1000

    new-array v4, v5, [B

    .line 100
    .local v4, "tmp":[B
    :goto_1
    invoke-virtual {v2, v4}, Ljava/io/InputStream;->read([B)I

    move-result v3

    .local v3, "l":I
    const/4 v5, -0x1

    if-eq v3, v5, :cond_4

    .line 101
    const/4 v5, 0x0

    invoke-virtual {v0, v4, v5, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/ByteArrayBuffer;->append([BII)V

    goto :goto_1

    .line 103
    :cond_4
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/ByteArrayBuffer;->toByteArray()[B
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .line 105
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    goto :goto_0
.end method
