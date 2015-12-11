.class public final Lcom/a/a/a/a/ad;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/a/a/ae;


# instance fields
.field private final a:Lcom/a/a/a/a/h;

.field private final b:Lcom/a/a/a/b/q;

.field private c:Lcom/a/a/a/b/x;


# direct methods
.method public constructor <init>(Lcom/a/a/a/a/h;Lcom/a/a/a/b/q;)V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    .line 36
    iput-object p2, p0, Lcom/a/a/a/a/ad;->b:Lcom/a/a/a/b/q;

    .line 37
    return-void
.end method


# virtual methods
.method public final a(Ljava/net/CacheRequest;)Ljava/io/InputStream;
    .locals 3

    .prologue
    .line 81
    new-instance v0, Lcom/a/a/a/a/af;

    iget-object v1, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    iget-object v1, v1, Lcom/a/a/a/b/x;->e:Lcom/a/a/a/b/y;

    iget-object v2, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    invoke-direct {v0, v1, p1, v2}, Lcom/a/a/a/a/af;-><init>(Ljava/io/InputStream;Ljava/net/CacheRequest;Lcom/a/a/a/a/h;)V

    return-object v0
.end method

.method public final a()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/a/a/a/a/ad;->c()V

    .line 42
    iget-object v0, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    invoke-virtual {v0}, Lcom/a/a/a/b/x;->d()Ljava/io/OutputStream;

    move-result-object v0

    return-object v0
.end method

.method public final a(Lcom/a/a/a/a/ab;)V
    .locals 1

    .prologue
    .line 63
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public final a(ZLjava/io/OutputStream;Ljava/io/InputStream;)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 86
    if-eqz p1, :cond_0

    .line 87
    iget-object v1, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    if-eqz v1, :cond_1

    .line 88
    iget-object v1, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    sget-object v2, Lcom/a/a/a/b/a;->l:Lcom/a/a/a/b/a;

    invoke-virtual {v1, v2}, Lcom/a/a/a/b/x;->b(Lcom/a/a/a/b/a;)V

    .line 97
    :cond_0
    :goto_0
    return v0

    .line 94
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final b()V
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    invoke-virtual {v0}, Lcom/a/a/a/b/x;->d()Ljava/io/OutputStream;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 68
    return-void
.end method

.method public final c()V
    .locals 11

    .prologue
    const/4 v2, 0x0

    .line 46
    iget-object v0, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    if-eqz v0, :cond_0

    .line 60
    :goto_0
    return-void

    .line 49
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->b()V

    .line 50
    iget-object v0, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v4, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    .line 51
    iget-object v0, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget v0, v0, Lcom/a/a/b;->j:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    const-string v0, "HTTP/1.1"

    .line 52
    :goto_1
    iget-object v1, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v1}, Lcom/a/a/a/a/u;->getURL()Ljava/net/URL;

    move-result-object v1

    .line 53
    iget-object v3, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    iget-object v3, v3, Lcom/a/a/a/a/h;->c:Ljava/lang/String;

    invoke-static {v1}, Lcom/a/a/a/a/h;->a(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v1}, Lcom/a/a/a/a/h;->b(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    iget-object v6, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    iget-object v6, v6, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-virtual {v6}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v6

    const-string v7, ":method"

    invoke-virtual {v4, v7, v3}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, ":scheme"

    invoke-virtual {v4, v3, v6}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, ":path"

    invoke-virtual {v4, v3, v5}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, ":version"

    invoke-virtual {v4, v3, v0}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, ":host"

    invoke-virtual {v4, v0, v1}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    iget-object v0, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    invoke-virtual {v0}, Lcom/a/a/a/a/h;->c()Z

    move-result v5

    .line 56
    iget-object v6, p0, Lcom/a/a/a/a/ad;->b:Lcom/a/a/a/b/q;

    new-instance v7, Ljava/util/HashSet;

    invoke-direct {v7}, Ljava/util/HashSet;-><init>()V

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    move v3, v2

    :goto_2
    iget-object v0, v4, Lcom/a/a/a/a/v;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v3, v0, :cond_5

    iget-object v0, v4, Lcom/a/a/a/a/v;->a:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v9

    iget-object v0, v4, Lcom/a/a/a/a/v;->a:Ljava/util/List;

    add-int/lit8 v1, v3, 0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Ljava/lang/String;

    const-string v0, "connection"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "host"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "keep-alive"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "proxy-connection"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "transfer-encoding"

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-interface {v7, v9}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    :goto_3
    add-int/lit8 v0, v3, 0x2

    move v3, v0

    goto :goto_2

    .line 51
    :cond_2
    const-string v0, "HTTP/1.0"

    goto/16 :goto_1

    :cond_3
    move v0, v2

    .line 56
    :goto_4
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v10

    if-ge v0, v10, :cond_1

    invoke-interface {v8, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4

    add-int/lit8 v9, v0, 0x1

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v0, v0, 0x1

    invoke-interface {v8, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v10, "\u0000"

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8, v9, v0}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    :cond_4
    add-int/lit8 v0, v0, 0x2

    goto :goto_4

    :cond_5
    invoke-virtual {v6, v8, v5}, Lcom/a/a/a/b/q;->a(Ljava/util/List;Z)Lcom/a/a/a/b/x;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    .line 59
    iget-object v0, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    iget-object v1, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    iget-object v1, v1, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget v1, v1, Lcom/a/a/r;->m:I

    int-to-long v2, v1

    iput-wide v2, v0, Lcom/a/a/a/b/x;->c:J

    goto/16 :goto_0
.end method

.method public final d()Lcom/a/a/a/a/z;
    .locals 3

    .prologue
    .line 71
    iget-object v0, p0, Lcom/a/a/a/a/ad;->c:Lcom/a/a/a/b/x;

    invoke-virtual {v0}, Lcom/a/a/a/b/x;->c()Ljava/util/List;

    move-result-object v0

    .line 72
    invoke-static {v0}, Lcom/a/a/a/a/v;->a(Ljava/util/List;)Lcom/a/a/a/a/v;

    move-result-object v0

    .line 73
    iget-object v1, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    invoke-virtual {v1, v0}, Lcom/a/a/a/a/h;->a(Lcom/a/a/a/a/v;)V

    .line 75
    new-instance v1, Lcom/a/a/a/a/z;

    iget-object v2, p0, Lcom/a/a/a/a/ad;->a:Lcom/a/a/a/a/h;

    iget-object v2, v2, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-direct {v1, v2, v0}, Lcom/a/a/a/a/z;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V

    .line 76
    const-string v0, "spdy/3"

    invoke-virtual {v1, v0}, Lcom/a/a/a/a/z;->a(Ljava/lang/String;)V

    .line 77
    return-object v1
.end method
