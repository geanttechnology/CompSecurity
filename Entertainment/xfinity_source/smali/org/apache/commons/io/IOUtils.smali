.class public Lorg/apache/commons/io/IOUtils;
.super Ljava/lang/Object;
.source "IOUtils.java"


# static fields
.field public static final DIR_SEPARATOR:C

.field public static final LINE_SEPARATOR:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 100
    sget-char v2, Ljava/io/File;->separatorChar:C

    sput-char v2, Lorg/apache/commons/io/IOUtils;->DIR_SEPARATOR:C

    .line 115
    new-instance v0, Lorg/apache/commons/io/output/StringBuilderWriter;

    const/4 v2, 0x4

    invoke-direct {v0, v2}, Lorg/apache/commons/io/output/StringBuilderWriter;-><init>(I)V

    .line 116
    .local v0, "buf":Lorg/apache/commons/io/output/StringBuilderWriter;
    new-instance v1, Ljava/io/PrintWriter;

    invoke-direct {v1, v0}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    .line 117
    .local v1, "out":Ljava/io/PrintWriter;
    invoke-virtual {v1}, Ljava/io/PrintWriter;->println()V

    .line 118
    invoke-virtual {v0}, Lorg/apache/commons/io/output/StringBuilderWriter;->toString()Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lorg/apache/commons/io/IOUtils;->LINE_SEPARATOR:Ljava/lang/String;

    .line 119
    invoke-virtual {v1}, Ljava/io/PrintWriter;->close()V

    .line 120
    return-void
.end method

.method public static closeQuietly(Ljava/io/Closeable;)V
    .locals 1
    .param p0, "closeable"    # Ljava/io/Closeable;

    .prologue
    .line 280
    if-eqz p0, :cond_0

    .line 281
    :try_start_0
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 286
    :cond_0
    :goto_0
    return-void

    .line 283
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public static closeQuietly(Ljava/io/InputStream;)V
    .locals 0
    .param p0, "input"    # Ljava/io/InputStream;

    .prologue
    .line 224
    invoke-static {p0}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 225
    return-void
.end method

.method public static closeQuietly(Ljava/io/OutputStream;)V
    .locals 0
    .param p0, "output"    # Ljava/io/OutputStream;

    .prologue
    .line 252
    invoke-static {p0}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 253
    return-void
.end method

.method public static copy(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    .locals 4
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "output"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1357
    invoke-static {p0, p1}, Lorg/apache/commons/io/IOUtils;->copyLarge(Ljava/io/InputStream;Ljava/io/OutputStream;)J

    move-result-wide v0

    .line 1358
    .local v0, "count":J
    const-wide/32 v2, 0x7fffffff

    cmp-long v2, v0, v2

    if-lez v2, :cond_0

    .line 1359
    const/4 v2, -0x1

    .line 1361
    :goto_0
    return v2

    :cond_0
    long-to-int v2, v0

    goto :goto_0
.end method

.method public static copy(Ljava/io/Reader;Ljava/io/Writer;)I
    .locals 4
    .param p0, "input"    # Ljava/io/Reader;
    .param p1, "output"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1461
    invoke-static {p0, p1}, Lorg/apache/commons/io/IOUtils;->copyLarge(Ljava/io/Reader;Ljava/io/Writer;)J

    move-result-wide v0

    .line 1462
    .local v0, "count":J
    const-wide/32 v2, 0x7fffffff

    cmp-long v2, v0, v2

    if-lez v2, :cond_0

    .line 1463
    const/4 v2, -0x1

    .line 1465
    :goto_0
    return v2

    :cond_0
    long-to-int v2, v0

    goto :goto_0
.end method

.method public static copy(Ljava/io/InputStream;Ljava/io/Writer;)V
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "output"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1407
    new-instance v0, Ljava/io/InputStreamReader;

    invoke-direct {v0, p0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 1408
    .local v0, "in":Ljava/io/InputStreamReader;
    invoke-static {v0, p1}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/Reader;Ljava/io/Writer;)I

    .line 1409
    return-void
.end method

.method public static copy(Ljava/io/InputStream;Ljava/io/Writer;Ljava/lang/String;)V
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "output"    # Ljava/io/Writer;
    .param p2, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1432
    if-nez p2, :cond_0

    .line 1433
    invoke-static {p0, p1}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/Writer;)V

    .line 1438
    :goto_0
    return-void

    .line 1435
    :cond_0
    new-instance v0, Ljava/io/InputStreamReader;

    invoke-direct {v0, p0, p2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 1436
    .local v0, "in":Ljava/io/InputStreamReader;
    invoke-static {v0, p1}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/Reader;Ljava/io/Writer;)I

    goto :goto_0
.end method

.method public static copyLarge(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    .locals 6
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "output"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1380
    const/16 v4, 0x1000

    new-array v0, v4, [B

    .line 1381
    .local v0, "buffer":[B
    const-wide/16 v2, 0x0

    .line 1382
    .local v2, "count":J
    const/4 v1, 0x0

    .line 1383
    .local v1, "n":I
    :goto_0
    const/4 v4, -0x1

    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    if-eq v4, v1, :cond_0

    .line 1384
    const/4 v4, 0x0

    invoke-virtual {p1, v0, v4, v1}, Ljava/io/OutputStream;->write([BII)V

    .line 1385
    int-to-long v4, v1

    add-long/2addr v2, v4

    goto :goto_0

    .line 1387
    :cond_0
    return-wide v2
.end method

.method public static copyLarge(Ljava/io/Reader;Ljava/io/Writer;)J
    .locals 6
    .param p0, "input"    # Ljava/io/Reader;
    .param p1, "output"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1482
    const/16 v4, 0x1000

    new-array v0, v4, [C

    .line 1483
    .local v0, "buffer":[C
    const-wide/16 v2, 0x0

    .line 1484
    .local v2, "count":J
    const/4 v1, 0x0

    .line 1485
    .local v1, "n":I
    :goto_0
    const/4 v4, -0x1

    invoke-virtual {p0, v0}, Ljava/io/Reader;->read([C)I

    move-result v1

    if-eq v4, v1, :cond_0

    .line 1486
    const/4 v4, 0x0

    invoke-virtual {p1, v0, v4, v1}, Ljava/io/Writer;->write([CII)V

    .line 1487
    int-to-long v4, v1

    add-long/2addr v2, v4

    goto :goto_0

    .line 1489
    :cond_0
    return-wide v2
.end method

.method public static toInputStream(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    .locals 2
    .param p0, "input"    # Ljava/lang/String;
    .param p1, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 908
    if-eqz p1, :cond_0

    invoke-virtual {p0, p1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    .line 909
    .local v0, "bytes":[B
    :goto_0
    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-direct {v1, v0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    return-object v1

    .line 908
    .end local v0    # "bytes":[B
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    goto :goto_0
.end method

.method public static toString(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 584
    new-instance v0, Lorg/apache/commons/io/output/StringBuilderWriter;

    invoke-direct {v0}, Lorg/apache/commons/io/output/StringBuilderWriter;-><init>()V

    .line 585
    .local v0, "sw":Lorg/apache/commons/io/output/StringBuilderWriter;
    invoke-static {p0, v0, p1}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/Writer;Ljava/lang/String;)V

    .line 586
    invoke-virtual {v0}, Lorg/apache/commons/io/output/StringBuilderWriter;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
