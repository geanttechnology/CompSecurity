.class public Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;
.super Ljava/lang/Object;
.source "MultipartFormOutputStream.java"


# instance fields
.field private boundary:Ljava/lang/String;

.field private out:Ljava/io/DataOutputStream;


# direct methods
.method public constructor <init>(Ljava/io/OutputStream;Ljava/lang/String;)V
    .locals 2
    .param p1, "os"    # Ljava/io/OutputStream;
    .param p2, "a_boundary"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    .line 16
    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->boundary:Ljava/lang/String;

    .line 19
    if-nez p1, :cond_0

    .line 20
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Output stream is required."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 22
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_2

    .line 23
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Boundary stream is required."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 25
    :cond_2
    new-instance v0, Ljava/io/DataOutputStream;

    invoke-direct {v0, p1}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    .line 26
    iput-object p2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->boundary:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public static createBoundary()Ljava/lang/String;
    .locals 4

    .prologue
    .line 197
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "--------------------"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const/16 v3, 0x10

    invoke-static {v1, v2, v3}, Ljava/lang/Long;->toString(JI)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getContentType(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "boundary"    # Ljava/lang/String;

    .prologue
    .line 202
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "multipart/form-data; boundary="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public close()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 170
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v1, "--"

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 171
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    iget-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->boundary:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 172
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v1, "--"

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 173
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v1, "\r\n"

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 174
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 175
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->close()V

    .line 176
    return-void
.end method

.method public flush()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 166
    return-void
.end method

.method public writeField(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 66
    if-nez p1, :cond_0

    .line 67
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Name cannot be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 69
    :cond_0
    if-nez p2, :cond_1

    .line 70
    const-string/jumbo p2, ""

    .line 73
    :cond_1
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v1, "--"

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 74
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    iget-object v1, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->boundary:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 75
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v1, "\r\n"

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 77
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Content-Disposition: form-data; name=\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 78
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v1, "\r\n"

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 79
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v1, "\r\n"

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 81
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p2}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 82
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v1, "\r\n"

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 83
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V

    .line 84
    return-void
.end method

.method public writeField(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    new-instance v0, Ljava/lang/Boolean;

    invoke-direct {v0, p2}, Ljava/lang/Boolean;-><init>(Z)V

    invoke-virtual {v0}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->writeField(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    return-void
.end method

.method public writeFile(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "mimeType"    # Ljava/lang/String;
    .param p3, "fileName"    # Ljava/lang/String;
    .param p4, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 103
    if-nez p4, :cond_0

    .line 104
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "Input stream cannot be null."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 106
    :cond_0
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_2

    .line 107
    :cond_1
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "File name cannot be null or empty."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 110
    :cond_2
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v3, "--"

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 111
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    iget-object v3, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->boundary:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 112
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v3, "\r\n"

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 114
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Content-Disposition: form-data; name=\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\"; filename=\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 116
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v3, "\r\n"

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 117
    if-eqz p2, :cond_3

    .line 118
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Content-Type: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 119
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v3, "\r\n"

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 121
    :cond_3
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v3, "\r\n"

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 123
    const/16 v2, 0x400

    new-array v0, v2, [B

    .line 124
    .local v0, "data":[B
    const/4 v1, 0x0

    .line 125
    .local v1, "r":I
    :goto_0
    array-length v2, v0

    invoke-virtual {p4, v0, v5, v2}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_4

    .line 126
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    invoke-virtual {v2, v0, v5, v1}, Ljava/io/DataOutputStream;->write([BII)V

    goto :goto_0

    .line 130
    :cond_4
    :try_start_0
    invoke-virtual {p4}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 132
    :goto_1
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    const-string/jumbo v3, "\r\n"

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 133
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/servermatch/MultipartFormOutputStream;->out:Ljava/io/DataOutputStream;

    invoke-virtual {v2}, Ljava/io/DataOutputStream;->flush()V

    .line 134
    return-void

    .line 131
    :catch_0
    move-exception v2

    goto :goto_1
.end method
