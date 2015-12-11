.class public final Lcom/a/a/a/a/x;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:Lcom/a/a/a/a/v;

.field b:Z

.field c:I

.field d:I

.field e:I

.field f:Z

.field g:Z

.field h:J

.field i:Ljava/lang/String;

.field j:Ljava/lang/String;

.field k:Ljava/lang/String;

.field l:Ljava/lang/String;

.field m:Ljava/lang/String;

.field n:Ljava/lang/String;

.field o:Ljava/lang/String;

.field p:Ljava/lang/String;

.field private final q:Ljava/net/URI;

.field private r:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v0, -0x1

    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput v0, p0, Lcom/a/a/a/a/x;->c:I

    .line 32
    iput v0, p0, Lcom/a/a/a/a/x;->d:I

    .line 33
    iput v0, p0, Lcom/a/a/a/a/x;->e:I

    .line 51
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/a/a/a/a/x;->h:J

    .line 63
    iput-object p1, p0, Lcom/a/a/a/a/x;->q:Ljava/net/URI;

    .line 64
    iput-object p2, p0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    .line 66
    new-instance v1, Lcom/a/a/a/a/y;

    invoke-direct {v1, p0}, Lcom/a/a/a/a/y;-><init>(Lcom/a/a/a/a/x;)V

    .line 82
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p2}, Lcom/a/a/a/a/v;->a()I

    move-result v2

    if-ge v0, v2, :cond_d

    .line 83
    invoke-virtual {p2, v0}, Lcom/a/a/a/a/v;->a(I)Ljava/lang/String;

    move-result-object v2

    .line 84
    invoke-virtual {p2, v0}, Lcom/a/a/a/a/v;->b(I)Ljava/lang/String;

    move-result-object v3

    .line 85
    const-string v4, "Cache-Control"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 86
    invoke-static {v3, v1}, Lcom/a/a/a/a/b;->a(Ljava/lang/String;Lcom/a/a/a/a/c;)V

    .line 82
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 87
    :cond_1
    const-string v4, "Pragma"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 88
    const-string v2, "no-cache"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 89
    iput-boolean v5, p0, Lcom/a/a/a/a/x;->b:Z

    goto :goto_1

    .line 91
    :cond_2
    const-string v4, "If-None-Match"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 92
    iput-object v3, p0, Lcom/a/a/a/a/x;->o:Ljava/lang/String;

    goto :goto_1

    .line 93
    :cond_3
    const-string v4, "If-Modified-Since"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 94
    iput-object v3, p0, Lcom/a/a/a/a/x;->r:Ljava/lang/String;

    goto :goto_1

    .line 95
    :cond_4
    const-string v4, "Authorization"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 96
    iput-boolean v5, p0, Lcom/a/a/a/a/x;->g:Z

    goto :goto_1

    .line 97
    :cond_5
    const-string v4, "Content-Length"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 99
    :try_start_0
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    int-to-long v2, v2

    iput-wide v2, p0, Lcom/a/a/a/a/x;->h:J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 101
    :catch_0
    move-exception v2

    goto :goto_1

    .line 102
    :cond_6
    const-string v4, "Transfer-Encoding"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 103
    iput-object v3, p0, Lcom/a/a/a/a/x;->i:Ljava/lang/String;

    goto :goto_1

    .line 104
    :cond_7
    const-string v4, "User-Agent"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 105
    iput-object v3, p0, Lcom/a/a/a/a/x;->j:Ljava/lang/String;

    goto :goto_1

    .line 106
    :cond_8
    const-string v4, "Host"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 107
    iput-object v3, p0, Lcom/a/a/a/a/x;->k:Ljava/lang/String;

    goto :goto_1

    .line 108
    :cond_9
    const-string v4, "Connection"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 109
    iput-object v3, p0, Lcom/a/a/a/a/x;->l:Ljava/lang/String;

    goto :goto_1

    .line 110
    :cond_a
    const-string v4, "Accept-Encoding"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_b

    .line 111
    iput-object v3, p0, Lcom/a/a/a/a/x;->m:Ljava/lang/String;

    goto :goto_1

    .line 112
    :cond_b
    const-string v4, "Content-Type"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_c

    .line 113
    iput-object v3, p0, Lcom/a/a/a/a/x;->n:Ljava/lang/String;

    goto/16 :goto_1

    .line 114
    :cond_c
    const-string v4, "Proxy-Authorization"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 115
    iput-object v3, p0, Lcom/a/a/a/a/x;->p:Ljava/lang/String;

    goto/16 :goto_1

    .line 118
    :cond_d
    return-void
.end method


# virtual methods
.method public final a(J)V
    .locals 5

    .prologue
    .line 209
    iget-wide v0, p0, Lcom/a/a/a/a/x;->h:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 210
    iget-object v0, p0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v1, "Content-Length"

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    .line 212
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v1, "Content-Length"

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    iput-wide p1, p0, Lcom/a/a/a/a/x;->h:J

    .line 214
    return-void
.end method

.method public final a(Ljava/util/Date;)V
    .locals 3

    .prologue
    .line 257
    iget-object v0, p0, Lcom/a/a/a/a/x;->r:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v1, "If-Modified-Since"

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    .line 260
    :cond_0
    invoke-static {p1}, Lcom/a/a/a/a/f;->a(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 261
    iget-object v1, p0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v2, "If-Modified-Since"

    invoke-virtual {v1, v2, v0}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    iput-object v0, p0, Lcom/a/a/a/a/x;->r:Ljava/lang/String;

    .line 263
    return-void
.end method

.method public final a(Ljava/util/Map;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 283
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 284
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 285
    const-string v3, "Cookie"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    const-string v3, "Cookie2"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 286
    :cond_1
    iget-object v3, p0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v1, v0}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 289
    :cond_2
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/a/a/a/a/x;->r:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/x;->o:Ljava/lang/String;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
