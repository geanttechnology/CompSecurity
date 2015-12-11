.class abstract Lay;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field protected final a:Lorg/apache/http/client/HttpClient;

.field protected b:Lorg/apache/http/HttpResponse;

.field private c:Ljava/io/IOException;

.field private d:Ljava/net/URL;

.field private e:J

.field private synthetic f:Lax;


# direct methods
.method constructor <init>(Lax;Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)V
    .locals 4

    .prologue
    .line 47
    iput-object p1, p0, Lay;->f:Lax;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p2, p0, Lay;->a:Lorg/apache/http/client/HttpClient;

    .line 49
    const/4 v0, 0x0

    .line 51
    :try_start_0
    invoke-interface {p3}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->toURL()Ljava/net/URL;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 56
    :goto_0
    iput-object v0, p0, Lay;->d:Ljava/net/URL;

    .line 57
    invoke-static {p3}, Lay;->a(Lorg/apache/http/HttpRequest;)V

    .line 58
    return-void

    .line 52
    :catch_0
    move-exception v1

    .line 53
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Error constructing URL from URI ("

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p3}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v3

    invoke-virtual {v3}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private static a(Lorg/apache/http/HttpRequest;)V
    .locals 5

    .prologue
    .line 79
    invoke-static {}, Lq;->a()Ljava/util/Map;

    move-result-object v0

    .line 80
    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 81
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 82
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {p0, v2, v1}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 85
    :cond_1
    const-string v0, "Agent added server correlation header to request."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 86
    return-void
.end method


# virtual methods
.method protected abstract a()Ljava/lang/Object;
.end method

.method final b()Ljava/lang/Object;
    .locals 11

    .prologue
    .line 89
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lay;->e:J

    iget-object v0, p0, Lay;->f:Lax;

    invoke-static {v0}, Lax;->a(Lax;)Lab;

    move-result-object v0

    sget-object v1, Lad;->a:Lad;

    invoke-virtual {v0, v1}, Lab;->a(Ljava/lang/Object;)V

    .line 91
    :try_start_0
    invoke-virtual {p0}, Lay;->a()Ljava/lang/Object;

    move-result-object v9

    .line 92
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iget-object v0, p0, Lay;->d:Ljava/net/URL;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lay;->b:Lorg/apache/http/HttpResponse;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v0

    iget-object v1, p0, Lay;->b:Lorg/apache/http/HttpResponse;

    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v1

    invoke-interface {v1}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v6

    const/4 v7, 0x0

    const/16 v1, 0x190

    if-lt v6, v1, :cond_0

    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v7

    :cond_0
    new-instance v8, Lv;

    invoke-direct {v8}, Lv;-><init>()V

    iget-object v0, p0, Lay;->b:Lorg/apache/http/HttpResponse;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v1

    if-eqz v1, :cond_1

    array-length v2, v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_1

    aget-object v3, v1, v0

    invoke-interface {v3}, Lorg/apache/http/Header;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v3}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-virtual {v8, v10, v3}, Lv;->a(Ljava/lang/String;Ljava/util/List;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lay;->f:Lax;

    invoke-static {v0}, Lax;->b(Lax;)Lag;

    move-result-object v0

    iget-object v1, p0, Lay;->d:Ljava/net/URL;

    iget-wide v2, p0, Lay;->e:J

    invoke-virtual {v8}, Lv;->a()Lt;

    move-result-object v8

    invoke-virtual/range {v0 .. v8}, Lag;->a(Ljava/net/URL;JJILjava/lang/String;Lt;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v1, p0, Lay;->f:Lax;

    invoke-static {v1}, Lax;->c(Lax;)Lao;

    move-result-object v1

    invoke-virtual {v1, v0}, Lao;->b(Lorg/json/JSONObject;)V

    :cond_2
    iget-object v0, p0, Lay;->f:Lax;

    invoke-static {v0}, Lax;->a(Lax;)Lab;

    move-result-object v0

    sget-object v1, Lad;->b:Lad;

    invoke-virtual {v0, v1}, Lab;->a(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 93
    return-object v9

    .line 94
    :catch_0
    move-exception v0

    .line 95
    iput-object v0, p0, Lay;->c:Ljava/io/IOException;

    .line 96
    iget-object v1, p0, Lay;->d:Ljava/net/URL;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lay;->f:Lax;

    invoke-static {v1}, Lax;->b(Lax;)Lag;

    move-result-object v1

    iget-object v2, p0, Lay;->d:Ljava/net/URL;

    iget-object v3, p0, Lay;->c:Ljava/io/IOException;

    iget-wide v4, p0, Lay;->e:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-virtual/range {v1 .. v7}, Lag;->a(Ljava/net/URL;Ljava/lang/Exception;JJ)Lorg/json/JSONObject;

    move-result-object v1

    if-eqz v1, :cond_3

    iget-object v2, p0, Lay;->f:Lax;

    invoke-static {v2}, Lax;->c(Lax;)Lao;

    move-result-object v2

    invoke-virtual {v2, v1}, Lao;->b(Lorg/json/JSONObject;)V

    :cond_3
    iget-object v1, p0, Lay;->f:Lax;

    invoke-static {v1}, Lax;->a(Lax;)Lab;

    move-result-object v1

    sget-object v2, Lad;->c:Lad;

    invoke-virtual {v1, v2}, Lab;->a(Ljava/lang/Object;)V

    .line 97
    throw v0
.end method
