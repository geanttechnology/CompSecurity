.class public abstract Lorg/springframework/util/FileCopyUtils;
.super Ljava/lang/Object;
.source "FileCopyUtils.java"


# direct methods
.method public static copy(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    .locals 5
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "out"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 106
    const-string v3, "No InputStream specified"

    invoke-static {p0, v3}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 107
    const-string v3, "No OutputStream specified"

    invoke-static {p1, v3}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 109
    const/4 v1, 0x0

    .line 110
    .local v1, "byteCount":I
    const/16 v3, 0x1000

    :try_start_0
    new-array v0, v3, [B

    .line 111
    .local v0, "buffer":[B
    const/4 v2, -0x1

    .line 112
    .local v2, "bytesRead":I
    :goto_0
    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 113
    const/4 v3, 0x0

    invoke-virtual {p1, v0, v3, v2}, Ljava/io/OutputStream;->write([BII)V

    .line 114
    add-int/2addr v1, v2

    goto :goto_0

    .line 116
    :cond_0
    invoke-virtual {p1}, Ljava/io/OutputStream;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 121
    :try_start_1
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 126
    :goto_1
    :try_start_2
    invoke-virtual {p1}, Ljava/io/OutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 129
    :goto_2
    return v1

    .line 120
    .end local v0    # "buffer":[B
    .end local v2    # "bytesRead":I
    :catchall_0
    move-exception v3

    .line 121
    :try_start_3
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    .line 126
    :goto_3
    :try_start_4
    invoke-virtual {p1}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 129
    :goto_4
    throw v3

    .line 123
    .restart local v0    # "buffer":[B
    .restart local v2    # "bytesRead":I
    :catch_0
    move-exception v3

    goto :goto_1

    .line 128
    :catch_1
    move-exception v3

    goto :goto_2

    .line 123
    .end local v0    # "buffer":[B
    .end local v2    # "bytesRead":I
    :catch_2
    move-exception v4

    goto :goto_3

    .line 128
    :catch_3
    move-exception v4

    goto :goto_4
.end method

.method public static copy(Ljava/io/Reader;Ljava/io/Writer;)I
    .locals 5
    .param p0, "in"    # Ljava/io/Reader;
    .param p1, "out"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 182
    const-string v3, "No Reader specified"

    invoke-static {p0, v3}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 183
    const-string v3, "No Writer specified"

    invoke-static {p1, v3}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 185
    const/4 v1, 0x0

    .line 186
    .local v1, "byteCount":I
    const/16 v3, 0x1000

    :try_start_0
    new-array v0, v3, [C

    .line 187
    .local v0, "buffer":[C
    const/4 v2, -0x1

    .line 188
    .local v2, "bytesRead":I
    :goto_0
    invoke-virtual {p0, v0}, Ljava/io/Reader;->read([C)I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 189
    const/4 v3, 0x0

    invoke-virtual {p1, v0, v3, v2}, Ljava/io/Writer;->write([CII)V

    .line 190
    add-int/2addr v1, v2

    goto :goto_0

    .line 192
    :cond_0
    invoke-virtual {p1}, Ljava/io/Writer;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 197
    :try_start_1
    invoke-virtual {p0}, Ljava/io/Reader;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 202
    :goto_1
    :try_start_2
    invoke-virtual {p1}, Ljava/io/Writer;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 205
    :goto_2
    return v1

    .line 196
    .end local v0    # "buffer":[C
    .end local v2    # "bytesRead":I
    :catchall_0
    move-exception v3

    .line 197
    :try_start_3
    invoke-virtual {p0}, Ljava/io/Reader;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    .line 202
    :goto_3
    :try_start_4
    invoke-virtual {p1}, Ljava/io/Writer;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 205
    :goto_4
    throw v3

    .line 199
    .restart local v0    # "buffer":[C
    .restart local v2    # "bytesRead":I
    :catch_0
    move-exception v3

    goto :goto_1

    .line 204
    :catch_1
    move-exception v3

    goto :goto_2

    .line 199
    .end local v0    # "buffer":[C
    .end local v2    # "bytesRead":I
    :catch_2
    move-exception v4

    goto :goto_3

    .line 204
    :catch_3
    move-exception v4

    goto :goto_4
.end method

.method public static copy(Ljava/lang/String;Ljava/io/Writer;)V
    .locals 2
    .param p0, "in"    # Ljava/lang/String;
    .param p1, "out"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 217
    const-string v0, "No input String specified"

    invoke-static {p0, v0}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 218
    const-string v0, "No Writer specified"

    invoke-static {p1, v0}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 220
    :try_start_0
    invoke-virtual {p1, p0}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 224
    :try_start_1
    invoke-virtual {p1}, Ljava/io/Writer;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 229
    :goto_0
    return-void

    .line 223
    :catchall_0
    move-exception v0

    .line 224
    :try_start_2
    invoke-virtual {p1}, Ljava/io/Writer;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 227
    :goto_1
    throw v0

    .line 226
    :catch_0
    move-exception v0

    goto :goto_0

    :catch_1
    move-exception v1

    goto :goto_1
.end method

.method public static copy([BLjava/io/OutputStream;)V
    .locals 2
    .param p0, "in"    # [B
    .param p1, "out"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 141
    const-string v0, "No input byte array specified"

    invoke-static {p0, v0}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 142
    const-string v0, "No OutputStream specified"

    invoke-static {p1, v0}, Lorg/springframework/util/Assert;->notNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 144
    :try_start_0
    invoke-virtual {p1, p0}, Ljava/io/OutputStream;->write([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 148
    :try_start_1
    invoke-virtual {p1}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 153
    :goto_0
    return-void

    .line 147
    :catchall_0
    move-exception v0

    .line 148
    :try_start_2
    invoke-virtual {p1}, Ljava/io/OutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 151
    :goto_1
    throw v0

    .line 150
    :catch_0
    move-exception v0

    goto :goto_0

    :catch_1
    move-exception v1

    goto :goto_1
.end method

.method public static copyToByteArray(Ljava/io/InputStream;)[B
    .locals 2
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 163
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    const/16 v1, 0x1000

    invoke-direct {v0, v1}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    .line 164
    .local v0, "out":Ljava/io/ByteArrayOutputStream;
    invoke-static {p0, v0}, Lorg/springframework/util/FileCopyUtils;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;)I

    .line 165
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    return-object v1
.end method

.method public static copyToString(Ljava/io/Reader;)Ljava/lang/String;
    .locals 2
    .param p0, "in"    # Ljava/io/Reader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 239
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 240
    .local v0, "out":Ljava/io/StringWriter;
    invoke-static {p0, v0}, Lorg/springframework/util/FileCopyUtils;->copy(Ljava/io/Reader;Ljava/io/Writer;)I

    .line 241
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
