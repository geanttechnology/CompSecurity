.class public final Lcom/a/a/a/a/q;
.super Lcom/a/a/a/a/h;
.source "SourceFile"


# instance fields
.field public k:Ljavax/net/ssl/SSLSocket;


# direct methods
.method public constructor <init>(Lcom/a/a/r;Lcom/a/a/a/a/u;Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)V
    .locals 1

    .prologue
    .line 40
    invoke-direct/range {p0 .. p6}, Lcom/a/a/a/a/h;-><init>(Lcom/a/a/r;Lcom/a/a/a/a/u;Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)V

    .line 41
    if-eqz p5, :cond_0

    iget-object v0, p5, Lcom/a/a/b;->e:Ljava/net/Socket;

    check-cast v0, Ljavax/net/ssl/SSLSocket;

    :goto_0
    iput-object v0, p0, Lcom/a/a/a/a/q;->k:Ljavax/net/ssl/SSLSocket;

    .line 42
    return-void

    .line 41
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected final a(Lcom/a/a/b;)V
    .locals 1

    .prologue
    .line 45
    iget-object v0, p1, Lcom/a/a/b;->e:Ljava/net/Socket;

    check-cast v0, Ljavax/net/ssl/SSLSocket;

    iput-object v0, p0, Lcom/a/a/a/a/q;->k:Ljavax/net/ssl/SSLSocket;

    .line 46
    return-void
.end method

.method protected final a(Ljava/net/CacheResponse;)Z
    .locals 1

    .prologue
    .line 49
    instance-of v0, p1, Ljava/net/SecureCacheResponse;

    return v0
.end method

.method protected final l()Z
    .locals 1

    .prologue
    .line 54
    const/4 v0, 0x0

    return v0
.end method

.method protected final o()Lcom/a/a/x;
    .locals 5

    .prologue
    .line 62
    iget-object v0, p0, Lcom/a/a/a/a/q;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->j:Ljava/lang/String;

    .line 63
    if-nez v0, :cond_0

    .line 64
    invoke-static {}, Lcom/a/a/a/a/q;->m()Ljava/lang/String;

    move-result-object v0

    .line 67
    :cond_0
    iget-object v1, p0, Lcom/a/a/a/a/q;->a:Lcom/a/a/a/a/u;

    invoke-interface {v1}, Lcom/a/a/a/a/u;->getURL()Ljava/net/URL;

    move-result-object v1

    .line 68
    new-instance v2, Lcom/a/a/x;

    invoke-virtual {v1}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1}, Lcom/a/a/a/u;->a(Ljava/net/URL;)I

    move-result v1

    iget-object v4, p0, Lcom/a/a/a/a/q;->i:Lcom/a/a/a/a/x;

    iget-object v4, v4, Lcom/a/a/a/a/x;->p:Ljava/lang/String;

    invoke-direct {v2, v3, v1, v0, v4}, Lcom/a/a/x;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    return-object v2
.end method
