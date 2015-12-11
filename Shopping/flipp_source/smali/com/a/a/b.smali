.class public final Lcom/a/a/b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Closeable;


# static fields
.field public static final a:[B

.field public static final b:[B

.field public static final c:[B


# instance fields
.field public final d:Lcom/a/a/v;

.field public e:Ljava/net/Socket;

.field public f:Ljava/io/InputStream;

.field public g:Ljava/io/OutputStream;

.field public h:Z

.field public i:Lcom/a/a/a/b/q;

.field public j:I

.field k:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 69
    const/16 v0, 0x10

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/a/a/b;->a:[B

    .line 73
    const/4 v0, 0x6

    new-array v0, v0, [B

    fill-array-data v0, :array_1

    sput-object v0, Lcom/a/a/b;->b:[B

    .line 76
    const/16 v0, 0x8

    new-array v0, v0, [B

    fill-array-data v0, :array_2

    sput-object v0, Lcom/a/a/b;->c:[B

    return-void

    .line 69
    nop

    :array_0
    .array-data 1
        0x6t
        0x73t
        0x70t
        0x64t
        0x79t
        0x2ft
        0x33t
        0x8t
        0x68t
        0x74t
        0x74t
        0x70t
        0x2ft
        0x31t
        0x2et
        0x31t
    .end array-data

    .line 73
    :array_1
    .array-data 1
        0x73t
        0x70t
        0x64t
        0x79t
        0x2ft
        0x33t
    .end array-data

    .line 76
    nop

    :array_2
    .array-data 1
        0x68t
        0x74t
        0x74t
        0x70t
        0x2ft
        0x31t
        0x2et
        0x31t
    .end array-data
.end method

.method public constructor <init>(Lcom/a/a/v;)V
    .locals 1

    .prologue
    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a/a/b;->h:Z

    .line 87
    const/4 v0, 0x1

    iput v0, p0, Lcom/a/a/b;->j:I

    .line 91
    iput-object p1, p0, Lcom/a/a/b;->d:Lcom/a/a/v;

    .line 92
    return-void
.end method


# virtual methods
.method public final a(Lcom/a/a/x;)V
    .locals 7

    .prologue
    .line 305
    new-instance v3, Lcom/a/a/a/a/v;

    invoke-direct {v3}, Lcom/a/a/a/a/v;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "CONNECT "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p1, Lcom/a/a/x;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p1, Lcom/a/a/x;->b:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " HTTP/1.1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;)V

    const-string v1, "Host"

    iget v0, p1, Lcom/a/a/x;->b:I

    const-string v2, "https"

    invoke-static {v2}, Lcom/a/a/a/u;->a(Ljava/lang/String;)I

    move-result v2

    if-ne v0, v2, :cond_1

    iget-object v0, p1, Lcom/a/a/x;->a:Ljava/lang/String;

    :goto_0
    invoke-virtual {v3, v1, v0}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "User-Agent"

    iget-object v1, p1, Lcom/a/a/x;->c:Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p1, Lcom/a/a/x;->d:Ljava/lang/String;

    if-eqz v0, :cond_0

    const-string v0, "Proxy-Authorization"

    iget-object v1, p1, Lcom/a/a/x;->d:Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    const-string v0, "Proxy-Connection"

    const-string v1, "Keep-Alive"

    invoke-virtual {v3, v0, v1}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v3

    .line 307
    :goto_1
    iget-object v1, p0, Lcom/a/a/b;->g:Ljava/io/OutputStream;

    invoke-virtual {v0}, Lcom/a/a/a/a/v;->b()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/OutputStream;->write([B)V

    .line 308
    iget-object v1, p0, Lcom/a/a/b;->f:Ljava/io/InputStream;

    invoke-static {v1}, Lcom/a/a/a/a/v;->a(Ljava/io/InputStream;)Lcom/a/a/a/a/v;

    move-result-object v2

    .line 310
    iget v1, v2, Lcom/a/a/a/a/v;->d:I

    sparse-switch v1, :sswitch_data_0

    .line 325
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Unexpected response code for CONNECT: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, v2, Lcom/a/a/a/a/v;->d:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 305
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p1, Lcom/a/a/x;->a:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v2, p1, Lcom/a/a/x;->b:I

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 314
    :sswitch_0
    new-instance v3, Lcom/a/a/a/a/v;

    invoke-direct {v3, v0}, Lcom/a/a/a/a/v;-><init>(Lcom/a/a/a/a/v;)V

    .line 315
    new-instance v5, Ljava/net/URL;

    const-string v0, "https"

    iget-object v1, p1, Lcom/a/a/x;->a:Ljava/lang/String;

    iget v4, p1, Lcom/a/a/x;->b:I

    const-string v6, "/"

    invoke-direct {v5, v0, v1, v4, v6}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    .line 316
    iget-object v0, p0, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v0, v0, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v0, v0, Lcom/a/a/a;->f:Lcom/a/a/o;

    const/16 v1, 0x197

    iget-object v4, p0, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v4, v4, Lcom/a/a/v;->b:Ljava/net/Proxy;

    invoke-static/range {v0 .. v5}, Lcom/a/a/a/a/d;->a(Lcom/a/a/o;ILcom/a/a/a/a/v;Lcom/a/a/a/a/v;Ljava/net/Proxy;Ljava/net/URL;)Z

    move-result v0

    .line 319
    if-nez v0, :cond_2

    .line 320
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Failed to authenticate with proxy"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 312
    :sswitch_1
    return-void

    :cond_2
    move-object v0, v3

    goto :goto_1

    .line 310
    :sswitch_data_0
    .sparse-switch
        0xc8 -> :sswitch_1
        0x197 -> :sswitch_0
    .end sparse-switch
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->isInputShutdown()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->isOutputShutdown()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final b()Z
    .locals 6

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 203
    iget-object v0, p0, Lcom/a/a/b;->f:Ljava/io/InputStream;

    instance-of v0, v0, Ljava/io/BufferedInputStream;

    if-nez v0, :cond_0

    move v0, v1

    .line 226
    :goto_0
    return v0

    .line 206
    :cond_0
    invoke-virtual {p0}, Lcom/a/a/b;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    .line 207
    goto :goto_0

    .line 209
    :cond_1
    iget-object v0, p0, Lcom/a/a/b;->f:Ljava/io/InputStream;

    check-cast v0, Ljava/io/BufferedInputStream;

    .line 211
    :try_start_0
    iget-object v3, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v3}, Ljava/net/Socket;->getSoTimeout()I
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v3

    .line 213
    :try_start_1
    iget-object v4, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 214
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Ljava/io/BufferedInputStream;->mark(I)V

    .line 215
    invoke-virtual {v0}, Ljava/io/BufferedInputStream;->read()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v4

    const/4 v5, -0x1

    if-ne v4, v5, :cond_2

    .line 216
    :try_start_2
    iget-object v0, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0, v3}, Ljava/net/Socket;->setSoTimeout(I)V
    :try_end_2
    .catch Ljava/net/SocketTimeoutException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    move v0, v2

    goto :goto_0

    .line 218
    :cond_2
    :try_start_3
    invoke-virtual {v0}, Ljava/io/BufferedInputStream;->reset()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 219
    :try_start_4
    iget-object v0, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0, v3}, Ljava/net/Socket;->setSoTimeout(I)V

    move v0, v1

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v4, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v4, v3}, Ljava/net/Socket;->setSoTimeout(I)V

    throw v0
    :try_end_4
    .catch Ljava/net/SocketTimeoutException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    .line 224
    :catch_0
    move-exception v0

    move v0, v1

    goto :goto_0

    .line 226
    :catch_1
    move-exception v0

    move v0, v2

    goto :goto_0
.end method

.method public final c()Z
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    invoke-virtual {v0}, Lcom/a/a/a/b/q;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final close()V
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    .line 177
    return-void
.end method

.method public final d()J
    .locals 2

    .prologue
    .line 255
    iget-object v0, p0, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    if-nez v0, :cond_0

    iget-wide v0, p0, Lcom/a/a/b;->k:J

    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    invoke-virtual {v0}, Lcom/a/a/a/b/q;->b()J

    move-result-wide v0

    goto :goto_0
.end method

.method public final e()Z
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
