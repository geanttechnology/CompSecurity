.class public final Lcom/penthera/virtuososdk/utility/Serialization;
.super Ljava/lang/Object;
.source "Serialization.java"


# direct methods
.method public static deserializeObject([B)Ljava/lang/Object;
    .locals 9
    .param p0, "b"    # [B

    .prologue
    const/4 v5, 0x0

    .line 43
    const/4 v2, 0x0

    .line 45
    .local v2, "in":Ljava/io/ObjectInputStream;
    :try_start_0
    new-instance v3, Ljava/io/ObjectInputStream;

    new-instance v6, Ljava/io/ByteArrayInputStream;

    invoke-direct {v6, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-direct {v3, v6}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 46
    .end local v2    # "in":Ljava/io/ObjectInputStream;
    .local v3, "in":Ljava/io/ObjectInputStream;
    :try_start_1
    invoke-virtual {v3}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v5

    .line 57
    .local v5, "object":Ljava/lang/Object;
    if-eqz v3, :cond_0

    .line 59
    :try_start_2
    invoke-virtual {v3}, Ljava/io/ObjectInputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    :cond_0
    :goto_0
    move-object v2, v3

    .line 55
    .end local v3    # "in":Ljava/io/ObjectInputStream;
    .end local v5    # "object":Ljava/lang/Object;
    .restart local v2    # "in":Ljava/io/ObjectInputStream;
    :cond_1
    :goto_1
    return-object v5

    .line 60
    .end local v2    # "in":Ljava/io/ObjectInputStream;
    .restart local v3    # "in":Ljava/io/ObjectInputStream;
    .restart local v5    # "object":Ljava/lang/Object;
    :catch_0
    move-exception v1

    .line 61
    .local v1, "e":Ljava/io/IOException;
    const-string v6, "deserializeObject"

    const-string v7, "io error2"

    invoke-static {v6, v7, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 48
    .end local v1    # "e":Ljava/io/IOException;
    .end local v3    # "in":Ljava/io/ObjectInputStream;
    .end local v5    # "object":Ljava/lang/Object;
    .restart local v2    # "in":Ljava/io/ObjectInputStream;
    :catch_1
    move-exception v0

    .line 49
    .local v0, "cnfe":Ljava/lang/ClassNotFoundException;
    :goto_2
    :try_start_3
    const-string v6, "deserializeObject"

    const-string v7, "class not found error"

    invoke-static {v6, v7, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 57
    if-eqz v2, :cond_1

    .line 59
    :try_start_4
    invoke-virtual {v2}, Ljava/io/ObjectInputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_1

    .line 60
    :catch_2
    move-exception v1

    .line 61
    .restart local v1    # "e":Ljava/io/IOException;
    const-string v6, "deserializeObject"

    const-string v7, "io error2"

    invoke-static {v6, v7, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 52
    .end local v0    # "cnfe":Ljava/lang/ClassNotFoundException;
    .end local v1    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v4

    .line 53
    .local v4, "ioe":Ljava/io/IOException;
    :goto_3
    :try_start_5
    const-string v6, "deserializeObject"

    const-string v7, "io error"

    invoke-static {v6, v7, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 57
    if-eqz v2, :cond_1

    .line 59
    :try_start_6
    invoke-virtual {v2}, Ljava/io/ObjectInputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    goto :goto_1

    .line 60
    :catch_4
    move-exception v1

    .line 61
    .restart local v1    # "e":Ljava/io/IOException;
    const-string v6, "deserializeObject"

    const-string v7, "io error2"

    invoke-static {v6, v7, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 56
    .end local v1    # "e":Ljava/io/IOException;
    .end local v4    # "ioe":Ljava/io/IOException;
    :catchall_0
    move-exception v6

    .line 57
    :goto_4
    if-eqz v2, :cond_2

    .line 59
    :try_start_7
    invoke-virtual {v2}, Ljava/io/ObjectInputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_5

    .line 64
    :cond_2
    :goto_5
    throw v6

    .line 60
    :catch_5
    move-exception v1

    .line 61
    .restart local v1    # "e":Ljava/io/IOException;
    const-string v7, "deserializeObject"

    const-string v8, "io error2"

    invoke-static {v7, v8, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_5

    .line 56
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "in":Ljava/io/ObjectInputStream;
    .restart local v3    # "in":Ljava/io/ObjectInputStream;
    :catchall_1
    move-exception v6

    move-object v2, v3

    .end local v3    # "in":Ljava/io/ObjectInputStream;
    .restart local v2    # "in":Ljava/io/ObjectInputStream;
    goto :goto_4

    .line 52
    .end local v2    # "in":Ljava/io/ObjectInputStream;
    .restart local v3    # "in":Ljava/io/ObjectInputStream;
    :catch_6
    move-exception v4

    move-object v2, v3

    .end local v3    # "in":Ljava/io/ObjectInputStream;
    .restart local v2    # "in":Ljava/io/ObjectInputStream;
    goto :goto_3

    .line 48
    .end local v2    # "in":Ljava/io/ObjectInputStream;
    .restart local v3    # "in":Ljava/io/ObjectInputStream;
    :catch_7
    move-exception v0

    move-object v2, v3

    .end local v3    # "in":Ljava/io/ObjectInputStream;
    .restart local v2    # "in":Ljava/io/ObjectInputStream;
    goto :goto_2
.end method

.method public static serializeObject(Ljava/lang/Object;)[B
    .locals 10
    .param p0, "o"    # Ljava/lang/Object;

    .prologue
    .line 17
    const/4 v0, 0x0

    .line 18
    .local v0, "bos":Ljava/io/ByteArrayOutputStream;
    const/4 v5, 0x0

    .line 20
    .local v5, "out":Ljava/io/ObjectOutput;
    :try_start_0
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 21
    .end local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    .local v1, "bos":Ljava/io/ByteArrayOutputStream;
    :try_start_1
    new-instance v6, Ljava/io/ObjectOutputStream;

    invoke-direct {v6, v1}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 22
    .end local v5    # "out":Ljava/io/ObjectOutput;
    .local v6, "out":Ljava/io/ObjectOutput;
    :try_start_2
    invoke-interface {v6, p0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 25
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result-object v2

    .line 31
    .local v2, "buf":[B
    if-eqz v6, :cond_0

    .line 33
    :try_start_3
    invoke-interface {v6}, Ljava/io/ObjectOutput;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    :cond_0
    :goto_0
    move-object v5, v6

    .end local v6    # "out":Ljava/io/ObjectOutput;
    .restart local v5    # "out":Ljava/io/ObjectOutput;
    move-object v0, v1

    .line 39
    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v2    # "buf":[B
    .restart local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    :goto_1
    return-object v2

    .line 34
    .end local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "out":Ljava/io/ObjectOutput;
    .restart local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "buf":[B
    .restart local v6    # "out":Ljava/io/ObjectOutput;
    :catch_0
    move-exception v3

    .line 35
    .local v3, "e":Ljava/io/IOException;
    const-string v7, "serializeObject"

    const-string v8, "error2"

    invoke-static {v7, v8, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 28
    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v2    # "buf":[B
    .end local v3    # "e":Ljava/io/IOException;
    .end local v6    # "out":Ljava/io/ObjectOutput;
    .restart local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v5    # "out":Ljava/io/ObjectOutput;
    :catch_1
    move-exception v4

    .line 29
    .local v4, "ioe":Ljava/io/IOException;
    :goto_2
    :try_start_4
    const-string v7, "serializeObject"

    const-string v8, "error"

    invoke-static {v7, v8, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 31
    if-eqz v5, :cond_1

    .line 33
    :try_start_5
    invoke-interface {v5}, Ljava/io/ObjectOutput;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2

    .line 39
    :cond_1
    :goto_3
    const/4 v2, 0x0

    goto :goto_1

    .line 34
    :catch_2
    move-exception v3

    .line 35
    .restart local v3    # "e":Ljava/io/IOException;
    const-string v7, "serializeObject"

    const-string v8, "error2"

    invoke-static {v7, v8, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 30
    .end local v3    # "e":Ljava/io/IOException;
    .end local v4    # "ioe":Ljava/io/IOException;
    :catchall_0
    move-exception v7

    .line 31
    :goto_4
    if-eqz v5, :cond_2

    .line 33
    :try_start_6
    invoke-interface {v5}, Ljava/io/ObjectOutput;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3

    .line 38
    :cond_2
    :goto_5
    throw v7

    .line 34
    :catch_3
    move-exception v3

    .line 35
    .restart local v3    # "e":Ljava/io/IOException;
    const-string v8, "serializeObject"

    const-string v9, "error2"

    invoke-static {v8, v9, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_5

    .line 30
    .end local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v3    # "e":Ljava/io/IOException;
    .restart local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    :catchall_1
    move-exception v7

    move-object v0, v1

    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    goto :goto_4

    .end local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "out":Ljava/io/ObjectOutput;
    .restart local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "out":Ljava/io/ObjectOutput;
    :catchall_2
    move-exception v7

    move-object v5, v6

    .end local v6    # "out":Ljava/io/ObjectOutput;
    .restart local v5    # "out":Ljava/io/ObjectOutput;
    move-object v0, v1

    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    goto :goto_4

    .line 28
    .end local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    :catch_4
    move-exception v4

    move-object v0, v1

    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    goto :goto_2

    .end local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "out":Ljava/io/ObjectOutput;
    .restart local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "out":Ljava/io/ObjectOutput;
    :catch_5
    move-exception v4

    move-object v5, v6

    .end local v6    # "out":Ljava/io/ObjectOutput;
    .restart local v5    # "out":Ljava/io/ObjectOutput;
    move-object v0, v1

    .end local v1    # "bos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "bos":Ljava/io/ByteArrayOutputStream;
    goto :goto_2
.end method
