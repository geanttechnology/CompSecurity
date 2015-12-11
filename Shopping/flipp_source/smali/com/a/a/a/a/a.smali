.class abstract Lcom/a/a/a/a/a;
.super Ljava/io/InputStream;
.source "SourceFile"


# instance fields
.field protected final a:Ljava/io/InputStream;

.field protected final b:Lcom/a/a/a/a/h;

.field protected c:Z

.field private final d:Ljava/net/CacheRequest;

.field private final e:Ljava/io/OutputStream;


# direct methods
.method constructor <init>(Ljava/io/InputStream;Lcom/a/a/a/a/h;Ljava/net/CacheRequest;)V
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 43
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/a/a/a/a/a;->a:Ljava/io/InputStream;

    .line 45
    iput-object p2, p0, Lcom/a/a/a/a/a;->b:Lcom/a/a/a/a/h;

    .line 47
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Ljava/net/CacheRequest;->getBody()Ljava/io/OutputStream;

    move-result-object v1

    .line 50
    :goto_0
    if-nez v1, :cond_0

    move-object p3, v0

    .line 54
    :cond_0
    iput-object v1, p0, Lcom/a/a/a/a/a;->e:Ljava/io/OutputStream;

    .line 55
    iput-object p3, p0, Lcom/a/a/a/a/a;->d:Ljava/net/CacheRequest;

    .line 56
    return-void

    :cond_1
    move-object v1, v0

    .line 47
    goto :goto_0
.end method


# virtual methods
.method protected final a()V
    .locals 2

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/a/a/a/a/a;->c:Z

    if-eqz v0, :cond_0

    .line 68
    new-instance v0, Ljava/io/IOException;

    const-string v1, "stream closed"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 70
    :cond_0
    return-void
.end method

.method protected final a([BII)V
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/a/a/a/a/a;->e:Ljava/io/OutputStream;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/a/a/a/a/a;->e:Ljava/io/OutputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V

    .line 76
    :cond_0
    return-void
.end method

.method protected final b()V
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Lcom/a/a/a/a/a;->d:Ljava/net/CacheRequest;

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Lcom/a/a/a/a/a;->e:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/a;->b:Lcom/a/a/a/a/h;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/h;->a(Z)V

    .line 87
    return-void
.end method

.method protected final c()V
    .locals 2

    .prologue
    .line 102
    iget-object v0, p0, Lcom/a/a/a/a/a;->d:Ljava/net/CacheRequest;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/a/a/a/a/a;->d:Ljava/net/CacheRequest;

    invoke-virtual {v0}, Ljava/net/CacheRequest;->abort()V

    .line 105
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/a;->b:Lcom/a/a/a/a/h;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/h;->a(Z)V

    .line 106
    return-void
.end method

.method public final read()I
    .locals 1

    .prologue
    .line 63
    invoke-static {p0}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;)I

    move-result v0

    return v0
.end method
