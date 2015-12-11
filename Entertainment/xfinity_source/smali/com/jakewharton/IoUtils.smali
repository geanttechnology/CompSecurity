.class Lcom/jakewharton/IoUtils;
.super Ljava/lang/Object;
.source "IOUtils.java"


# direct methods
.method static closeQuietly(Ljava/io/Closeable;)V
    .locals 2
    .param p0, "closeable"    # Ljava/io/Closeable;

    .prologue
    .line 25
    if-eqz p0, :cond_0

    .line 27
    :try_start_0
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 33
    :cond_0
    :goto_0
    return-void

    .line 28
    :catch_0
    move-exception v0

    .line 29
    .local v0, "rethrown":Ljava/lang/RuntimeException;
    throw v0

    .line 30
    .end local v0    # "rethrown":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method static deleteContents(Ljava/io/File;)V
    .locals 8
    .param p0, "dir"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 10
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 11
    .local v2, "files":[Ljava/io/File;
    if-nez v2, :cond_0

    .line 12
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "not a directory: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 14
    :cond_0
    move-object v0, v2

    .local v0, "arr$":[Ljava/io/File;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_3

    aget-object v1, v0, v3

    .line 15
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->isDirectory()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 16
    invoke-static {v1}, Lcom/jakewharton/IoUtils;->deleteContents(Ljava/io/File;)V

    .line 18
    :cond_1
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v5

    if-nez v5, :cond_2

    .line 19
    new-instance v5, Ljava/io/IOException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "failed to delete file: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 14
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 22
    .end local v1    # "file":Ljava/io/File;
    :cond_3
    return-void
.end method
