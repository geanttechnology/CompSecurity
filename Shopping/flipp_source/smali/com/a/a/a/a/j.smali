.class public final Lcom/a/a/a/a/j;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/a/ae;


# instance fields
.field final a:Lcom/a/a/a/a/h;

.field final b:Ljava/io/InputStream;

.field private final c:Ljava/io/OutputStream;

.field private d:Ljava/io/OutputStream;


# direct methods
.method public constructor <init>(Lcom/a/a/a/a/h;Ljava/io/OutputStream;Ljava/io/InputStream;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    .line 56
    iput-object p2, p0, Lcom/a/a/a/a/j;->c:Ljava/io/OutputStream;

    .line 57
    iput-object p2, p0, Lcom/a/a/a/a/j;->d:Ljava/io/OutputStream;

    .line 58
    iput-object p3, p0, Lcom/a/a/a/a/j;->b:Ljava/io/InputStream;

    .line 59
    return-void
.end method

.method static a(Lcom/a/a/a/a/h;Ljava/io/InputStream;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 186
    iget-object v1, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    .line 187
    if-nez v1, :cond_1

    .line 200
    :cond_0
    :goto_0
    return v0

    .line 188
    :cond_1
    iget-object v1, v1, Lcom/a/a/b;->e:Ljava/net/Socket;

    .line 189
    if-eqz v1, :cond_0

    .line 191
    :try_start_0
    invoke-virtual {v1}, Ljava/net/Socket;->getSoTimeout()I

    move-result v2

    .line 192
    const/16 v3, 0x64

    invoke-virtual {v1, v3}, Ljava/net/Socket;->setSoTimeout(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 194
    :try_start_1
    invoke-static {p1}, Lcom/a/a/a/u;->b(Ljava/io/InputStream;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 195
    :try_start_2
    invoke-virtual {v1, v2}, Ljava/net/Socket;->setSoTimeout(I)V

    const/4 v0, 0x1

    goto :goto_0

    :catchall_0
    move-exception v3

    invoke-virtual {v1, v2}, Ljava/net/Socket;->setSoTimeout(I)V

    throw v3
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 200
    :catch_0
    move-exception v1

    goto :goto_0
.end method


# virtual methods
.method public final a(Ljava/net/CacheRequest;)Ljava/io/InputStream;
    .locals 4

    .prologue
    .line 205
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->k()Z

    move-result v0

    if-nez v0, :cond_0

    .line 206
    new-instance v0, Lcom/a/a/a/a/m;

    iget-object v1, p0, Lcom/a/a/a/a/j;->b:Ljava/io/InputStream;

    iget-object v2, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    const/4 v3, 0x0

    invoke-direct {v0, v1, p1, v2, v3}, Lcom/a/a/a/a/m;-><init>(Ljava/io/InputStream;Ljava/net/CacheRequest;Lcom/a/a/a/a/h;I)V

    .line 221
    :goto_0
    return-object v0

    .line 209
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    invoke-virtual {v0}, Lcom/a/a/a/a/z;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 210
    new-instance v0, Lcom/a/a/a/a/k;

    iget-object v1, p0, Lcom/a/a/a/a/j;->b:Ljava/io/InputStream;

    invoke-direct {v0, v1, p1, p0}, Lcom/a/a/a/a/k;-><init>(Ljava/io/InputStream;Ljava/net/CacheRequest;Lcom/a/a/a/a/j;)V

    goto :goto_0

    .line 213
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget v0, v0, Lcom/a/a/a/a/z;->s:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_2

    .line 214
    new-instance v0, Lcom/a/a/a/a/m;

    iget-object v1, p0, Lcom/a/a/a/a/j;->b:Ljava/io/InputStream;

    iget-object v2, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v3, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v3, v3, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget v3, v3, Lcom/a/a/a/a/z;->s:I

    invoke-direct {v0, v1, p1, v2, v3}, Lcom/a/a/a/a/m;-><init>(Ljava/io/InputStream;Ljava/net/CacheRequest;Lcom/a/a/a/a/h;I)V

    goto :goto_0

    .line 221
    :cond_2
    new-instance v0, Lcom/a/a/a/a/af;

    iget-object v1, p0, Lcom/a/a/a/a/j;->b:Ljava/io/InputStream;

    iget-object v2, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    invoke-direct {v0, v1, p1, v2}, Lcom/a/a/a/a/af;-><init>(Ljava/io/InputStream;Ljava/net/CacheRequest;Lcom/a/a/a/a/h;)V

    goto :goto_0
.end method

.method public final a()Ljava/io/OutputStream;
    .locals 8

    .prologue
    const-wide/16 v6, -0x1

    const/4 v4, 0x0

    .line 62
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    const-string v1, "chunked"

    iget-object v0, v0, Lcom/a/a/a/a/x;->i:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    .line 63
    if-nez v0, :cond_1

    iget-object v1, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v1}, Lcom/a/a/a/a/u;->d()I

    move-result v1

    if-lez v1, :cond_1

    iget-object v1, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget v1, v1, Lcom/a/a/b;->j:I

    if-eqz v1, :cond_1

    .line 66
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v1, v0, Lcom/a/a/a/a/x;->i:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v2, "Transfer-Encoding"

    invoke-virtual {v1, v2}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    :cond_0
    iget-object v1, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v2, "Transfer-Encoding"

    const-string v3, "chunked"

    invoke-virtual {v1, v2, v3}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "chunked"

    iput-object v1, v0, Lcom/a/a/a/a/x;->i:Ljava/lang/String;

    .line 67
    const/4 v0, 0x1

    .line 71
    :cond_1
    if-eqz v0, :cond_3

    .line 72
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v0}, Lcom/a/a/a/a/u;->d()I

    move-result v0

    .line 73
    const/4 v1, -0x1

    if-ne v0, v1, :cond_2

    .line 74
    const/16 v0, 0x400

    .line 76
    :cond_2
    invoke-virtual {p0}, Lcom/a/a/a/a/j;->c()V

    .line 77
    new-instance v1, Lcom/a/a/a/a/l;

    iget-object v2, p0, Lcom/a/a/a/a/j;->d:Ljava/io/OutputStream;

    invoke-direct {v1, v2, v0, v4}, Lcom/a/a/a/a/l;-><init>(Ljava/io/OutputStream;IB)V

    move-object v0, v1

    .line 103
    :goto_0
    return-object v0

    .line 81
    :cond_3
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v0}, Lcom/a/a/a/a/u;->c()J

    move-result-wide v2

    .line 82
    cmp-long v0, v2, v6

    if-eqz v0, :cond_4

    .line 83
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    invoke-virtual {v0, v2, v3}, Lcom/a/a/a/a/x;->a(J)V

    .line 84
    invoke-virtual {p0}, Lcom/a/a/a/a/j;->c()V

    .line 85
    new-instance v0, Lcom/a/a/a/a/n;

    iget-object v1, p0, Lcom/a/a/a/a/j;->d:Ljava/io/OutputStream;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/a/a/a/a/n;-><init>(Ljava/io/OutputStream;JB)V

    goto :goto_0

    .line 88
    :cond_4
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-wide v2, v0, Lcom/a/a/a/a/x;->h:J

    .line 89
    const-wide/32 v0, 0x7fffffff

    cmp-long v0, v2, v0

    if-lez v0, :cond_5

    .line 90
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 95
    :cond_5
    cmp-long v0, v2, v6

    if-eqz v0, :cond_6

    .line 96
    invoke-virtual {p0}, Lcom/a/a/a/a/j;->c()V

    .line 97
    new-instance v0, Lcom/a/a/a/a/ab;

    long-to-int v1, v2

    invoke-direct {v0, v1}, Lcom/a/a/a/a/ab;-><init>(I)V

    goto :goto_0

    .line 103
    :cond_6
    new-instance v0, Lcom/a/a/a/a/ab;

    invoke-direct {v0}, Lcom/a/a/a/a/ab;-><init>()V

    goto :goto_0
.end method

.method public final a(Lcom/a/a/a/a/ab;)V
    .locals 2

    .prologue
    .line 112
    iget-object v0, p0, Lcom/a/a/a/a/j;->d:Ljava/io/OutputStream;

    iget-object v1, p1, Lcom/a/a/a/a/ab;->b:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1, v0}, Ljava/io/ByteArrayOutputStream;->writeTo(Ljava/io/OutputStream;)V

    .line 113
    return-void
.end method

.method public final a(ZLjava/io/OutputStream;Ljava/io/InputStream;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 146
    if-eqz p1, :cond_1

    .line 173
    :cond_0
    :goto_0
    return v0

    .line 151
    :cond_1
    if-eqz p2, :cond_2

    check-cast p2, Lcom/a/a/a/a;

    iget-boolean v1, p2, Lcom/a/a/a/a;->a:Z

    if-eqz v1, :cond_0

    .line 156
    :cond_2
    iget-object v1, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    const-string v2, "close"

    iget-object v1, v1, Lcom/a/a/a/a/x;->l:Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 161
    iget-object v1, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    const-string v2, "close"

    iget-object v1, v1, Lcom/a/a/a/a/z;->t:Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 165
    :cond_3
    instance-of v1, p3, Lcom/a/a/a/a/af;

    if-nez v1, :cond_0

    .line 169
    if-eqz p3, :cond_4

    .line 170
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    invoke-static {v0, p3}, Lcom/a/a/a/a/j;->a(Lcom/a/a/a/a/h;Ljava/io/InputStream;)Z

    move-result v0

    goto :goto_0

    .line 173
    :cond_4
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public final b()V
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/a/a/a/a/j;->d:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V

    .line 108
    iget-object v0, p0, Lcom/a/a/a/a/j;->c:Ljava/io/OutputStream;

    iput-object v0, p0, Lcom/a/a/a/a/j;->d:Ljava/io/OutputStream;

    .line 109
    return-void
.end method

.method public final c()V
    .locals 2

    .prologue
    .line 128
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->b()V

    .line 129
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    .line 130
    invoke-virtual {v0}, Lcom/a/a/a/a/v;->b()[B

    move-result-object v0

    .line 131
    iget-object v1, p0, Lcom/a/a/a/a/j;->d:Ljava/io/OutputStream;

    invoke-virtual {v1, v0}, Ljava/io/OutputStream;->write([B)V

    .line 132
    return-void
.end method

.method public final d()Lcom/a/a/a/a/z;
    .locals 4

    .prologue
    .line 135
    iget-object v0, p0, Lcom/a/a/a/a/j;->b:Ljava/io/InputStream;

    invoke-static {v0}, Lcom/a/a/a/a/v;->a(Ljava/io/InputStream;)Lcom/a/a/a/a/v;

    move-result-object v1

    .line 136
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v2, v0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget v0, v1, Lcom/a/a/a/a/v;->c:I

    const/4 v3, -0x1

    if-eq v0, v3, :cond_0

    iget v0, v1, Lcom/a/a/a/a/v;->c:I

    :goto_0
    iput v0, v2, Lcom/a/a/b;->j:I

    .line 137
    iget-object v0, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/h;->a(Lcom/a/a/a/a/v;)V

    .line 139
    new-instance v0, Lcom/a/a/a/a/z;

    iget-object v2, p0, Lcom/a/a/a/a/j;->a:Lcom/a/a/a/a/h;

    iget-object v2, v2, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-direct {v0, v2, v1}, Lcom/a/a/a/a/z;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V

    .line 140
    const-string v1, "http/1.1"

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/z;->a(Ljava/lang/String;)V

    .line 141
    return-object v0

    .line 136
    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method
