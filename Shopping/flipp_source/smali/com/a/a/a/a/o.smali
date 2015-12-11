.class public Lcom/a/a/a/a/o;
.super Ljava/net/HttpURLConnection;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/a/u;


# instance fields
.field final a:Lcom/a/a/r;

.field protected b:Ljava/io/IOException;

.field protected c:Lcom/a/a/a/a/h;

.field private final d:Lcom/a/a/a/a/v;

.field private e:J

.field private f:I


# direct methods
.method public constructor <init>(Ljava/net/URL;Lcom/a/a/r;)V
    .locals 2

    .prologue
    .line 80
    invoke-direct {p0, p1}, Ljava/net/HttpURLConnection;-><init>(Ljava/net/URL;)V

    .line 72
    new-instance v0, Lcom/a/a/a/a/v;

    invoke-direct {v0}, Lcom/a/a/a/a/v;-><init>()V

    iput-object v0, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    .line 74
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/a/a/a/a/o;->e:J

    .line 81
    iput-object p2, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    .line 82
    return-void
.end method

.method private a(Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)Lcom/a/a/a/a/h;
    .locals 7

    .prologue
    .line 273
    iget-object v0, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v0

    const-string v1, "http"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 274
    new-instance v0, Lcom/a/a/a/a/h;

    iget-object v1, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    move-object v2, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lcom/a/a/a/a/h;-><init>(Lcom/a/a/r;Lcom/a/a/a/a/u;Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)V

    .line 276
    :goto_0
    return-object v0

    .line 275
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v0

    const-string v1, "https"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 276
    new-instance v0, Lcom/a/a/a/a/q;

    iget-object v1, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    move-object v2, p0

    move-object v3, p1

    move-object v4, p2

    move-object v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lcom/a/a/a/a/q;-><init>(Lcom/a/a/r;Lcom/a/a/a/a/u;Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)V

    goto :goto_0

    .line 278
    :cond_1
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0
.end method

.method private a(Ljava/lang/String;Z)V
    .locals 5

    .prologue
    .line 545
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 546
    if-eqz p2, :cond_0

    .line 547
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->c:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 549
    :cond_0
    const-string v0, ","

    const/4 v2, -0x1

    invoke-virtual {p1, v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v2

    array-length v3, v2

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v3, :cond_1

    aget-object v4, v2, v0

    .line 550
    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 549
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 552
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    invoke-static {v1}, Lcom/a/a/a/u;->a(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    const-string v2, "http/1.1"

    invoke-interface {v1, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "transports doesn\'t contain http/1.1: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "transports must not contain null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    const-string v2, ""

    invoke-interface {v1, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "transports contains an empty string"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    iput-object v1, v0, Lcom/a/a/r;->c:Ljava/util/List;

    .line 553
    return-void
.end method

.method private a(Z)Z
    .locals 8

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 344
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->a()V

    .line 345
    if-eqz p1, :cond_0

    .line 346
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->n()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 351
    :cond_0
    :goto_0
    return v2

    .line 349
    :catch_0
    move-exception v0

    move-object v4, v0

    .line 350
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    iget-object v6, v0, Lcom/a/a/a/a/h;->e:Lcom/a/a/a/a/ac;

    if-eqz v6, :cond_2

    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v0, v0, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v1, v0, Lcom/a/a/v;->b:Ljava/net/Proxy;

    invoke-virtual {v1}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v1

    sget-object v5, Ljava/net/Proxy$Type;->DIRECT:Ljava/net/Proxy$Type;

    if-eq v1, v5, :cond_1

    iget-object v1, v6, Lcom/a/a/a/a/ac;->b:Ljava/net/ProxySelector;

    if-eqz v1, :cond_1

    iget-object v1, v6, Lcom/a/a/a/a/ac;->b:Ljava/net/ProxySelector;

    iget-object v5, v6, Lcom/a/a/a/a/ac;->a:Ljava/net/URI;

    iget-object v7, v0, Lcom/a/a/v;->b:Ljava/net/Proxy;

    invoke-virtual {v7}, Ljava/net/Proxy;->address()Ljava/net/SocketAddress;

    move-result-object v7

    invoke-virtual {v1, v5, v7, v4}, Ljava/net/ProxySelector;->connectFailed(Ljava/net/URI;Ljava/net/SocketAddress;Ljava/io/IOException;)V

    :cond_1
    iget-object v1, v6, Lcom/a/a/a/a/ac;->c:Lcom/a/a/w;

    invoke-virtual {v1, v0, v4}, Lcom/a/a/w;->a(Lcom/a/a/v;Ljava/io/IOException;)V

    :cond_2
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->d()Ljava/io/OutputStream;

    move-result-object v0

    if-eqz v0, :cond_3

    instance-of v1, v0, Lcom/a/a/a/a/ab;

    if-eqz v1, :cond_8

    :cond_3
    move v5, v2

    :goto_1
    if-nez v6, :cond_4

    iget-object v1, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-eqz v1, :cond_7

    :cond_4
    if-eqz v6, :cond_6

    invoke-virtual {v6}, Lcom/a/a/a/a/ac;->b()Z

    move-result v1

    if-nez v1, :cond_5

    invoke-virtual {v6}, Lcom/a/a/a/a/ac;->a()Z

    move-result v1

    if-nez v1, :cond_5

    iget-boolean v1, v6, Lcom/a/a/a/a/ac;->d:Z

    if-nez v1, :cond_5

    invoke-virtual {v6}, Lcom/a/a/a/a/ac;->c()Z

    move-result v1

    if-eqz v1, :cond_9

    :cond_5
    move v1, v2

    :goto_2
    if-eqz v1, :cond_7

    :cond_6
    instance-of v1, v4, Ljavax/net/ssl/SSLHandshakeException;

    if-eqz v1, :cond_a

    invoke-virtual {v4}, Ljava/io/IOException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    instance-of v1, v1, Ljava/security/cert/CertificateException;

    if-eqz v1, :cond_a

    move v1, v2

    :goto_3
    instance-of v7, v4, Ljava/net/ProtocolException;

    if-nez v1, :cond_b

    if-nez v7, :cond_b

    move v1, v2

    :goto_4
    if-eqz v1, :cond_7

    if-nez v5, :cond_c

    :cond_7
    iput-object v4, p0, Lcom/a/a/a/a/o;->b:Ljava/io/IOException;

    move v2, v3

    :goto_5
    if-eqz v2, :cond_d

    move v2, v3

    .line 351
    goto/16 :goto_0

    :cond_8
    move v5, v3

    .line 350
    goto :goto_1

    :cond_9
    move v1, v3

    goto :goto_2

    :cond_a
    move v1, v3

    goto :goto_3

    :cond_b
    move v1, v3

    goto :goto_4

    :cond_c
    iget-object v1, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v1, v2}, Lcom/a/a/a/a/h;->a(Z)V

    check-cast v0, Lcom/a/a/a/a/ab;

    iget-object v1, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    iget-object v5, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    const/4 v7, 0x0

    invoke-direct {p0, v1, v5, v7, v0}, Lcom/a/a/a/a/o;->a(Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)Lcom/a/a/a/a/h;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    iput-object v6, v0, Lcom/a/a/a/a/h;->e:Lcom/a/a/a/a/ac;

    goto :goto_5

    .line 353
    :cond_d
    throw v4
.end method

.method private e()V
    .locals 4

    .prologue
    .line 243
    iget-object v0, p0, Lcom/a/a/a/a/o;->b:Ljava/io/IOException;

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Lcom/a/a/a/a/o;->b:Ljava/io/IOException;

    throw v0

    .line 245
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    if-eqz v0, :cond_1

    .line 264
    :goto_0
    return-void

    .line 249
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/o;->connected:Z

    .line 251
    :try_start_0
    iget-boolean v0, p0, Lcom/a/a/a/a/o;->doOutput:Z

    if-eqz v0, :cond_2

    .line 252
    iget-object v0, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    const-string v1, "GET"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 254
    const-string v0, "POST"

    iput-object v0, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    .line 260
    :cond_2
    iget-object v0, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    iget-object v1, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/a/a/a/a/o;->a(Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)Lcom/a/a/a/a/h;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 261
    :catch_0
    move-exception v0

    .line 262
    iput-object v0, p0, Lcom/a/a/a/a/o;->b:Ljava/io/IOException;

    .line 263
    throw v0

    .line 255
    :cond_3
    :try_start_1
    iget-object v0, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    const-string v1, "PUT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 257
    new-instance v0, Ljava/net/ProtocolException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " does not support writing"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
.end method

.method private f()Lcom/a/a/a/a/h;
    .locals 8

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 288
    invoke-direct {p0}, Lcom/a/a/a/a/o;->e()V

    .line 290
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->e()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 291
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    .line 302
    :goto_0
    return-object v0

    .line 326
    :cond_0
    sget v3, Lcom/a/a/a/a/p;->c:I

    if-ne v1, v3, :cond_1

    .line 327
    iget-object v1, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v1}, Lcom/a/a/a/a/h;->j()V

    .line 330
    :cond_1
    iget-object v1, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v1, v7}, Lcom/a/a/a/a/h;->a(Z)V

    .line 332
    iget-object v1, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    iget-object v3, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v3}, Lcom/a/a/a/a/h;->i()Lcom/a/a/b;

    move-result-object v3

    check-cast v0, Lcom/a/a/a/a/ab;

    invoke-direct {p0, v2, v1, v3, v0}, Lcom/a/a/a/a/o;->a(Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)Lcom/a/a/a/a/h;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    .line 295
    :cond_2
    invoke-direct {p0, v6}, Lcom/a/a/a/a/o;->a(Z)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 296
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v0, v0, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v4, v0, Lcom/a/a/v;->b:Ljava/net/Proxy;

    :goto_1
    invoke-virtual {p0}, Lcom/a/a/a/a/o;->getResponseCode()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    :cond_3
    sget v0, Lcom/a/a/a/a/p;->a:I

    move v1, v0

    .line 300
    :goto_2
    sget v0, Lcom/a/a/a/a/p;->a:I

    if-ne v1, v0, :cond_d

    .line 301
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->j()V

    .line 302
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    goto :goto_0

    .line 296
    :cond_4
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    iget-object v4, v0, Lcom/a/a/r;->b:Ljava/net/Proxy;

    goto :goto_1

    :sswitch_0
    invoke-virtual {v4}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v0

    sget-object v1, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    if-eq v0, v1, :cond_5

    new-instance v0, Ljava/net/ProtocolException;

    const-string v1, "Received HTTP_PROXY_AUTH (407) code while not using proxy"

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5
    :sswitch_1
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->i:Lcom/a/a/o;

    invoke-virtual {p0}, Lcom/a/a/a/a/o;->getResponseCode()I

    move-result v1

    iget-object v2, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v2}, Lcom/a/a/a/a/h;->f()Lcom/a/a/a/a/z;

    move-result-object v2

    iget-object v2, v2, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget-object v3, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    iget-object v5, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-static/range {v0 .. v5}, Lcom/a/a/a/a/d;->a(Lcom/a/a/o;ILcom/a/a/a/a/v;Lcom/a/a/a/a/v;Ljava/net/Proxy;Ljava/net/URL;)Z

    move-result v0

    if-eqz v0, :cond_6

    sget v0, Lcom/a/a/a/a/p;->b:I

    move v1, v0

    goto :goto_2

    :cond_6
    sget v0, Lcom/a/a/a/a/p;->a:I

    move v1, v0

    goto :goto_2

    :sswitch_2
    invoke-virtual {p0}, Lcom/a/a/a/a/o;->getInstanceFollowRedirects()Z

    move-result v1

    if-eqz v1, :cond_3

    iget v1, p0, Lcom/a/a/a/a/o;->f:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/a/a/a/a/o;->f:I

    const/16 v2, 0x14

    if-le v1, v2, :cond_7

    new-instance v0, Ljava/net/ProtocolException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Too many redirects: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/a/a/a/a/o;->f:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_7
    const/16 v1, 0x133

    if-ne v0, v1, :cond_8

    iget-object v0, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    const-string v1, "GET"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    iget-object v0, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    const-string v1, "HEAD"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_8
    const-string v0, "Location"

    invoke-virtual {p0, v0}, Lcom/a/a/a/a/o;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v1, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    new-instance v2, Ljava/net/URL;

    invoke-direct {v2, v1, v0}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    iget-object v0, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v0

    const-string v2, "https"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    iget-object v0, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v0

    const-string v2, "http"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_9
    invoke-virtual {v1}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-virtual {v2}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_a

    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    iget-boolean v0, v0, Lcom/a/a/r;->k:Z

    if-eqz v0, :cond_3

    :cond_a
    invoke-virtual {v1}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v0

    iget-object v3, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-virtual {v3}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    invoke-static {v1}, Lcom/a/a/a/u;->a(Ljava/net/URL;)I

    move-result v0

    iget-object v1, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-static {v1}, Lcom/a/a/a/u;->a(Ljava/net/URL;)I

    move-result v1

    if-ne v0, v1, :cond_b

    move v0, v6

    :goto_3
    if-eqz v3, :cond_c

    if-eqz v0, :cond_c

    if-eqz v2, :cond_c

    sget v0, Lcom/a/a/a/a/p;->b:I

    move v1, v0

    goto/16 :goto_2

    :cond_b
    move v0, v7

    goto :goto_3

    :cond_c
    sget v0, Lcom/a/a/a/a/p;->c:I

    move v1, v0

    goto/16 :goto_2

    .line 306
    :cond_d
    iget-object v2, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    .line 307
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->d()Ljava/io/OutputStream;

    move-result-object v0

    .line 312
    invoke-virtual {p0}, Lcom/a/a/a/a/o;->getResponseCode()I

    move-result v3

    .line 313
    const/16 v4, 0x12c

    if-eq v3, v4, :cond_e

    const/16 v4, 0x12d

    if-eq v3, v4, :cond_e

    const/16 v4, 0x12e

    if-eq v3, v4, :cond_e

    const/16 v4, 0x12f

    if-ne v3, v4, :cond_f

    .line 317
    :cond_e
    const-string v2, "GET"

    .line 318
    const/4 v0, 0x0

    .line 321
    :cond_f
    if-eqz v0, :cond_0

    instance-of v3, v0, Lcom/a/a/a/a/ab;

    if-nez v3, :cond_0

    .line 322
    new-instance v0, Ljava/net/HttpRetryException;

    const-string v1, "Cannot retry streamed HTTP body"

    iget-object v2, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v2}, Lcom/a/a/a/a/h;->g()I

    move-result v2

    invoke-direct {v0, v1, v2}, Ljava/net/HttpRetryException;-><init>(Ljava/lang/String;I)V

    throw v0

    .line 296
    nop

    :sswitch_data_0
    .sparse-switch
        0x12c -> :sswitch_2
        0x12d -> :sswitch_2
        0x12e -> :sswitch_2
        0x12f -> :sswitch_2
        0x133 -> :sswitch_2
        0x191 -> :sswitch_1
        0x197 -> :sswitch_0
    .end sparse-switch
.end method


# virtual methods
.method public a()Ljava/net/HttpURLConnection;
    .locals 0

    .prologue
    .line 268
    return-object p0
.end method

.method public final addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 517
    iget-boolean v0, p0, Lcom/a/a/a/a/o;->connected:Z

    if-eqz v0, :cond_0

    .line 518
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot add request property after connection is made"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 520
    :cond_0
    if-nez p1, :cond_1

    .line 521
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "field == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 523
    :cond_1
    if-nez p2, :cond_2

    .line 529
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Ignoring header "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " because its value was null."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/m;->a(Ljava/lang/String;)V

    .line 538
    :goto_0
    return-void

    .line 533
    :cond_2
    const-string v0, "X-Android-Transports"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 534
    const/4 v0, 0x1

    invoke-direct {p0, p2, v0}, Lcom/a/a/a/a/o;->a(Ljava/lang/String;Z)V

    goto :goto_0

    .line 536
    :cond_3
    iget-object v0, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v0, p1, p2}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public final b()Lcom/a/a/a/a/h;
    .locals 1

    .prologue
    .line 397
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    return-object v0
.end method

.method public final c()J
    .locals 2

    .prologue
    .line 472
    iget-wide v0, p0, Lcom/a/a/a/a/o;->e:J

    return-wide v0
.end method

.method public final connect()V
    .locals 1

    .prologue
    .line 85
    invoke-direct {p0}, Lcom/a/a/a/a/o;->e()V

    .line 88
    :cond_0
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/a/a/a/a/o;->a(Z)Z

    move-result v0

    .line 89
    if-eqz v0, :cond_0

    .line 90
    return-void
.end method

.method public final d()I
    .locals 1

    .prologue
    .line 476
    iget v0, p0, Lcom/a/a/a/a/o;->chunkLength:I

    return v0
.end method

.method public final disconnect()V
    .locals 2

    .prologue
    .line 94
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    if-eqz v0, :cond_1

    .line 100
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->h()Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/h;->a(Z)V

    .line 105
    :cond_1
    return-void
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    iget v0, v0, Lcom/a/a/r;->l:I

    return v0
.end method

.method public final getErrorStream()Ljava/io/InputStream;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 113
    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/a/o;->f()Lcom/a/a/a/a/h;

    move-result-object v1

    .line 114
    invoke-virtual {v1}, Lcom/a/a/a/a/h;->k()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Lcom/a/a/a/a/h;->g()I

    move-result v2

    const/16 v3, 0x190

    if-lt v2, v3, :cond_0

    .line 115
    invoke-virtual {v1}, Lcom/a/a/a/a/h;->h()Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 119
    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public final getHeaderField(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/a/o;->f()Lcom/a/a/a/a/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->f()Lcom/a/a/a/a/z;

    move-result-object v0

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/v;->b(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 131
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getHeaderField(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/a/o;->f()Lcom/a/a/a/a/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->f()Lcom/a/a/a/a/z;

    move-result-object v0

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    .line 143
    if-nez p1, :cond_0

    iget-object v0, v0, Lcom/a/a/a/a/v;->b:Ljava/lang/String;

    .line 145
    :goto_0
    return-object v0

    .line 143
    :cond_0
    invoke-virtual {v0, p1}, Lcom/a/a/a/a/v;->e(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 145
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getHeaderFieldKey(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/a/o;->f()Lcom/a/a/a/a/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->f()Lcom/a/a/a/a/z;

    move-result-object v0

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/v;->a(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 153
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getHeaderFields()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 159
    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/a/o;->f()Lcom/a/a/a/a/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->f()Lcom/a/a/a/a/z;

    move-result-object v0

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->a(Z)Ljava/util/Map;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 161
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getInputStream()Ljava/io/InputStream;
    .locals 3

    .prologue
    .line 174
    iget-boolean v0, p0, Lcom/a/a/a/a/o;->doInput:Z

    if-nez v0, :cond_0

    .line 175
    new-instance v0, Ljava/net/ProtocolException;

    const-string v1, "This protocol does not support input"

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 178
    :cond_0
    invoke-direct {p0}, Lcom/a/a/a/a/o;->f()Lcom/a/a/a/a/h;

    move-result-object v0

    .line 184
    invoke-virtual {p0}, Lcom/a/a/a/a/o;->getResponseCode()I

    move-result v1

    const/16 v2, 0x190

    if-lt v1, v2, :cond_1

    .line 185
    new-instance v0, Ljava/io/FileNotFoundException;

    iget-object v1, p0, Lcom/a/a/a/a/o;->url:Ljava/net/URL;

    invoke-virtual {v1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 188
    :cond_1
    invoke-virtual {v0}, Lcom/a/a/a/a/h;->h()Ljava/io/InputStream;

    move-result-object v0

    .line 189
    if-nez v0, :cond_2

    .line 190
    new-instance v0, Ljava/net/ProtocolException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "No response body exists; responseCode="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/a/a/a/a/o;->getResponseCode()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 192
    :cond_2
    return-object v0
.end method

.method public final getOutputStream()Ljava/io/OutputStream;
    .locals 3

    .prologue
    .line 196
    invoke-virtual {p0}, Lcom/a/a/a/a/o;->connect()V

    .line 198
    iget-object v0, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->d()Ljava/io/OutputStream;

    move-result-object v0

    .line 199
    if-nez v0, :cond_0

    .line 200
    new-instance v0, Ljava/net/ProtocolException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "method does not support a request body: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/a/a/a/a/o;->method:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 201
    :cond_0
    iget-object v1, p0, Lcom/a/a/a/a/o;->c:Lcom/a/a/a/a/h;

    invoke-virtual {v1}, Lcom/a/a/a/a/h;->e()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 202
    new-instance v0, Ljava/net/ProtocolException;

    const-string v1, "cannot write request body after response has been read"

    invoke-direct {v0, v1}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 205
    :cond_1
    return-object v0
.end method

.method public final getPermission()Ljava/security/Permission;
    .locals 4

    .prologue
    .line 209
    invoke-virtual {p0}, Lcom/a/a/a/a/o;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 210
    invoke-virtual {p0}, Lcom/a/a/a/a/o;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/net/URL;)I

    move-result v0

    .line 211
    invoke-virtual {p0}, Lcom/a/a/a/a/o;->usingProxy()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 212
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->b:Ljava/net/Proxy;

    invoke-virtual {v0}, Ljava/net/Proxy;->address()Ljava/net/SocketAddress;

    move-result-object v0

    check-cast v0, Ljava/net/InetSocketAddress;

    .line 213
    invoke-virtual {v0}, Ljava/net/InetSocketAddress;->getHostName()Ljava/lang/String;

    move-result-object v1

    .line 214
    invoke-virtual {v0}, Ljava/net/InetSocketAddress;->getPort()I

    move-result v0

    .line 216
    :cond_0
    new-instance v2, Ljava/net/SocketPermission;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, ":"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "connect, resolve"

    invoke-direct {v2, v0, v1}, Ljava/net/SocketPermission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v2
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    iget v0, v0, Lcom/a/a/r;->m:I

    return v0
.end method

.method public final getRequestProperties()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 166
    iget-boolean v0, p0, Lcom/a/a/a/a/o;->connected:Z

    if-eqz v0, :cond_0

    .line 167
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot access request header fields after connection is set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 170
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->a(Z)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public final getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    if-nez p1, :cond_0

    .line 221
    const/4 v0, 0x0

    .line 223
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v0, p1}, Lcom/a/a/a/a/v;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public final getResponseCode()I
    .locals 1

    .prologue
    .line 489
    invoke-direct {p0}, Lcom/a/a/a/a/o;->f()Lcom/a/a/a/a/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->g()I

    move-result v0

    return v0
.end method

.method public getResponseMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 485
    invoke-direct {p0}, Lcom/a/a/a/a/o;->f()Lcom/a/a/a/a/h;

    move-result-object v0

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->f()Lcom/a/a/a/a/z;

    move-result-object v0

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget-object v0, v0, Lcom/a/a/a/a/v;->e:Ljava/lang/String;

    return-object v0
.end method

.method public setConnectTimeout(I)V
    .locals 6

    .prologue
    .line 227
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    int-to-long v2, p1

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-gez v4, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "timeout < 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez v1, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "unit == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v2

    const-wide/32 v4, 0x7fffffff

    cmp-long v1, v2, v4

    if-lez v1, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Timeout too large."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    long-to-int v1, v2

    iput v1, v0, Lcom/a/a/r;->l:I

    .line 228
    return-void
.end method

.method public setFixedLengthStreamingMode(I)V
    .locals 2

    .prologue
    .line 556
    int-to-long v0, p1

    invoke-virtual {p0, v0, v1}, Lcom/a/a/a/a/o;->setFixedLengthStreamingMode(J)V

    .line 557
    return-void
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 3

    .prologue
    .line 561
    iget-boolean v0, p0, Ljava/net/HttpURLConnection;->connected:Z

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Already connected"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 562
    :cond_0
    iget v0, p0, Lcom/a/a/a/a/o;->chunkLength:I

    if-lez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Already in chunked mode"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 563
    :cond_1
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "contentLength < 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 564
    :cond_2
    iput-wide p1, p0, Lcom/a/a/a/a/o;->e:J

    .line 565
    const-wide/32 v0, 0x7fffffff

    invoke-static {p1, p2, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int v0, v0

    iput v0, p0, Ljava/net/HttpURLConnection;->fixedContentLength:I

    .line 566
    return-void
.end method

.method public setReadTimeout(I)V
    .locals 6

    .prologue
    .line 235
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    int-to-long v2, p1

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-gez v4, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "timeout < 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez v1, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "unit == null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v2

    const-wide/32 v4, 0x7fffffff

    cmp-long v1, v2, v4

    if-lez v1, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Timeout too large."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    long-to-int v1, v2

    iput v1, v0, Lcom/a/a/r;->m:I

    .line 236
    return-void
.end method

.method public final setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 493
    iget-boolean v0, p0, Lcom/a/a/a/a/o;->connected:Z

    if-eqz v0, :cond_0

    .line 494
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot set request property after connection is made"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 496
    :cond_0
    if-nez p1, :cond_1

    .line 497
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "field == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 499
    :cond_1
    if-nez p2, :cond_2

    .line 505
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Ignoring header "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " because its value was null."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/m;->a(Ljava/lang/String;)V

    .line 514
    :goto_0
    return-void

    .line 509
    :cond_2
    const-string v0, "X-Android-Transports"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 510
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/a/a/a/a/o;->a(Ljava/lang/String;Z)V

    goto :goto_0

    .line 512
    :cond_3
    iget-object v0, p0, Lcom/a/a/a/a/o;->d:Lcom/a/a/a/a/v;

    invoke-virtual {v0, p1, p2}, Lcom/a/a/a/a/v;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public final usingProxy()Z
    .locals 2

    .prologue
    .line 480
    iget-object v0, p0, Lcom/a/a/a/a/o;->a:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->b:Ljava/net/Proxy;

    .line 481
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v0

    sget-object v1, Ljava/net/Proxy$Type;->DIRECT:Ljava/net/Proxy$Type;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
