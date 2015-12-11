.class public Lcom/comcast/cim/httpcomponentsandroid/entity/FileEntity;
.super Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;
.source "FileEntity.java"

# interfaces
.implements Ljava/lang/Cloneable;


# instance fields
.field protected final file:Ljava/io/File;


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 95
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getContent()Ljava/io/InputStream;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/FileEntity;->file:Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    return-object v0
.end method

.method public getContentLength()J
    .locals 2

    .prologue
    .line 59
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/FileEntity;->file:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v0

    return-wide v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 55
    const/4 v0, 0x1

    return v0
.end method

.method public isStreaming()Z
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x0

    return v0
.end method

.method public writeTo(Ljava/io/OutputStream;)V
    .locals 5
    .param p1, "outstream"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 67
    if-nez p1, :cond_0

    .line 68
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Output stream may not be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 70
    :cond_0
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/FileEntity;->file:Ljava/io/File;

    invoke-direct {v0, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 72
    .local v0, "instream":Ljava/io/InputStream;
    const/16 v3, 0x1000

    :try_start_0
    new-array v2, v3, [B

    .line 74
    .local v2, "tmp":[B
    :goto_0
    invoke-virtual {v0, v2}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .local v1, "l":I
    const/4 v3, -0x1

    if-eq v1, v3, :cond_1

    .line 75
    const/4 v3, 0x0

    invoke-virtual {p1, v2, v3, v1}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 79
    .end local v1    # "l":I
    .end local v2    # "tmp":[B
    :catchall_0
    move-exception v3

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    throw v3

    .line 77
    .restart local v1    # "l":I
    .restart local v2    # "tmp":[B
    :cond_1
    :try_start_1
    invoke-virtual {p1}, Ljava/io/OutputStream;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 79
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 81
    return-void
.end method
