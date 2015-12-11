.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;
.super Ljava/lang/Object;
.source "IOUtils.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method static closeSilently(Ljava/io/Closeable;)V
    .locals 1
    .param p0, "closable"    # Ljava/io/Closeable;

    .prologue
    .line 52
    :try_start_0
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 55
    :goto_0
    return-void

    .line 53
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static copy(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .locals 3
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "out"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 43
    const/16 v2, 0x800

    new-array v0, v2, [B

    .line 45
    .local v0, "buf":[B
    :goto_0
    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, "len":I
    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    .line 46
    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v1}, Ljava/io/OutputStream;->write([BII)V

    goto :goto_0

    .line 48
    :cond_0
    return-void
.end method

.method static copyAndClose(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .locals 1
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "out"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    :try_start_0
    invoke-static {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;)V

    .line 60
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V

    .line 61
    invoke-virtual {p1}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    return-void

    .line 62
    :catch_0
    move-exception v0

    .line 63
    .local v0, "ex":Ljava/io/IOException;
    invoke-static {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;->closeSilently(Ljava/io/Closeable;)V

    .line 64
    invoke-static {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;->closeSilently(Ljava/io/Closeable;)V

    .line 66
    throw v0
.end method

.method static copyFile(Ljava/io/File;Ljava/io/File;)V
    .locals 9
    .param p0, "in"    # Ljava/io/File;
    .param p1, "out"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 71
    new-instance v7, Ljava/io/RandomAccessFile;

    const-string v2, "r"

    invoke-direct {v7, p0, v2}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 72
    .local v7, "f1":Ljava/io/RandomAccessFile;
    new-instance v8, Ljava/io/RandomAccessFile;

    const-string v2, "rw"

    invoke-direct {v8, p1, v2}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 74
    .local v8, "f2":Ljava/io/RandomAccessFile;
    :try_start_0
    invoke-virtual {v7}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    .line 75
    .local v1, "c1":Ljava/nio/channels/FileChannel;
    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v6

    .line 77
    .local v6, "c2":Ljava/nio/channels/FileChannel;
    const-wide/16 v2, 0x0

    :try_start_1
    invoke-virtual {v7}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v4

    invoke-virtual/range {v1 .. v6}, Ljava/nio/channels/FileChannel;->transferTo(JJLjava/nio/channels/WritableByteChannel;)J

    .line 78
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V

    .line 79
    invoke-virtual {v6}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 86
    :try_start_2
    invoke-virtual {v7}, Ljava/io/RandomAccessFile;->close()V

    .line 87
    invoke-virtual {v8}, Ljava/io/RandomAccessFile;->close()V

    .line 94
    return-void

    .line 80
    :catch_0
    move-exception v0

    .line 81
    .local v0, "ex":Ljava/io/IOException;
    invoke-static {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;->closeSilently(Ljava/io/Closeable;)V

    .line 82
    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;->closeSilently(Ljava/io/Closeable;)V

    .line 84
    throw v0
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 88
    .end local v0    # "ex":Ljava/io/IOException;
    .end local v1    # "c1":Ljava/nio/channels/FileChannel;
    .end local v6    # "c2":Ljava/nio/channels/FileChannel;
    :catch_1
    move-exception v0

    .line 89
    .restart local v0    # "ex":Ljava/io/IOException;
    invoke-static {v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;->closeSilently(Ljava/io/Closeable;)V

    .line 90
    invoke-static {v8}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/IOUtils;->closeSilently(Ljava/io/Closeable;)V

    .line 92
    throw v0
.end method
