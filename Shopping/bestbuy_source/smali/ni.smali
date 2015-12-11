.class public Lni;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 12
    invoke-static {p0}, Lni;->b(Ljava/io/InputStream;)[B

    move-result-object v0

    .line 13
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V

    .line 14
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>([B)V

    return-object v1
.end method

.method public static a(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .locals 5

    .prologue
    const/16 v4, 0x400

    const/4 v3, 0x0

    .line 19
    new-array v0, v4, [B

    .line 21
    :goto_0
    invoke-virtual {p0, v0, v3, v4}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    .line 22
    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 26
    invoke-virtual {p1}, Ljava/io/OutputStream;->flush()V

    .line 27
    return-void

    .line 24
    :cond_0
    invoke-virtual {p1, v0, v3, v1}, Ljava/io/OutputStream;->write([BII)V

    goto :goto_0
.end method

.method public static b(Ljava/io/InputStream;)[B
    .locals 1

    .prologue
    .line 30
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 31
    invoke-static {p0, v0}, Lni;->a(Ljava/io/InputStream;Ljava/io/OutputStream;)V

    .line 32
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    return-object v0
.end method
