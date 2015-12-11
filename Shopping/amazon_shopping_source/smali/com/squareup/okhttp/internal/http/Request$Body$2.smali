.class final Lcom/squareup/okhttp/internal/http/Request$Body$2;
.super Lcom/squareup/okhttp/internal/http/Request$Body;
.source "Request.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/squareup/okhttp/internal/http/Request$Body;->create(Lcom/squareup/okhttp/MediaType;Ljava/io/File;)Lcom/squareup/okhttp/internal/http/Request$Body;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$contentType:Lcom/squareup/okhttp/MediaType;

.field final synthetic val$file:Ljava/io/File;


# direct methods
.method constructor <init>(Lcom/squareup/okhttp/MediaType;Ljava/io/File;)V
    .locals 0

    .prologue
    .line 206
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/Request$Body$2;->val$contentType:Lcom/squareup/okhttp/MediaType;

    iput-object p2, p0, Lcom/squareup/okhttp/internal/http/Request$Body$2;->val$file:Ljava/io/File;

    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Request$Body;-><init>()V

    return-void
.end method


# virtual methods
.method public contentLength()J
    .locals 2

    .prologue
    .line 212
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request$Body$2;->val$file:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v0

    return-wide v0
.end method

.method public contentType()Lcom/squareup/okhttp/MediaType;
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request$Body$2;->val$contentType:Lcom/squareup/okhttp/MediaType;

    return-object v0
.end method

.method public writeTo(Lcom/squareup/okhttp/internal/okio/BufferedSink;)V
    .locals 8
    .param p1, "sink"    # Lcom/squareup/okhttp/internal/okio/BufferedSink;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 216
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request$Body$2;->contentLength()J

    move-result-wide v4

    .line 217
    .local v4, "length":J
    const-wide/16 v6, 0x0

    cmp-long v6, v4, v6

    if-nez v6, :cond_0

    .line 229
    :goto_0
    return-void

    .line 219
    :cond_0
    const/4 v2, 0x0

    .line 221
    .local v2, "in":Ljava/io/InputStream;
    :try_start_0
    new-instance v3, Ljava/io/FileInputStream;

    iget-object v6, p0, Lcom/squareup/okhttp/internal/http/Request$Body$2;->val$file:Ljava/io/File;

    invoke-direct {v3, v6}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 222
    .end local v2    # "in":Ljava/io/InputStream;
    .local v3, "in":Ljava/io/InputStream;
    const-wide/16 v6, 0x2000

    :try_start_1
    invoke-static {v6, v7, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v6

    long-to-int v6, v6

    new-array v0, v6, [B

    .line 223
    .local v0, "buffer":[B
    :goto_1
    invoke-virtual {v3, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, "c":I
    const/4 v6, -0x1

    if-eq v1, v6, :cond_1

    .line 224
    const/4 v6, 0x0

    invoke-interface {p1, v0, v6, v1}, Lcom/squareup/okhttp/internal/okio/BufferedSink;->write([BII)Lcom/squareup/okhttp/internal/okio/BufferedSink;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 227
    .end local v0    # "buffer":[B
    .end local v1    # "c":I
    :catchall_0
    move-exception v6

    move-object v2, v3

    .end local v3    # "in":Ljava/io/InputStream;
    .restart local v2    # "in":Ljava/io/InputStream;
    :goto_2
    invoke-static {v2}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    throw v6

    .end local v2    # "in":Ljava/io/InputStream;
    .restart local v0    # "buffer":[B
    .restart local v1    # "c":I
    .restart local v3    # "in":Ljava/io/InputStream;
    :cond_1
    invoke-static {v3}, Lcom/squareup/okhttp/internal/Util;->closeQuietly(Ljava/io/Closeable;)V

    goto :goto_0

    .end local v0    # "buffer":[B
    .end local v1    # "c":I
    .end local v3    # "in":Ljava/io/InputStream;
    .restart local v2    # "in":Ljava/io/InputStream;
    :catchall_1
    move-exception v6

    goto :goto_2
.end method
