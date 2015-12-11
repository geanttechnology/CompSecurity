.class public Lp;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    .locals 2

    .prologue
    .line 152
    :try_start_0
    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    .line 153
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->j:Lax;

    new-instance v1, Lax$1;

    invoke-direct {v1, v0, p0, p1, p1}, Lax$1;-><init>(Lax;Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/methods/HttpUriRequest;)V

    invoke-virtual {v1}, Lay;->b()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    .line 160
    :goto_0
    return-object v0

    .line 155
    :catch_0
    move-exception v0

    .line 156
    throw v0

    .line 157
    :catch_1
    move-exception v0

    .line 158
    const-string v1, "Exception while executing http request"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 160
    :cond_0
    invoke-interface {p0, p1}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    goto :goto_0
.end method

.method public static a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 6

    .prologue
    .line 168
    :try_start_0
    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    .line 169
    sget-object v0, Ll;->c:Ll;

    iget-object v1, v0, Ll;->j:Lax;

    new-instance v0, Lax$2;

    move-object v2, p0

    move-object v3, p1

    move-object v4, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lax$2;-><init>(Lax;Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)V

    invoke-virtual {v0}, Lay;->b()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/HttpResponse;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    .line 176
    :goto_0
    return-object v0

    .line 171
    :catch_0
    move-exception v0

    .line 172
    throw v0

    .line 173
    :catch_1
    move-exception v0

    .line 174
    const-string v1, "Exception while executing http request"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 176
    :cond_0
    invoke-interface {p0, p1, p2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    goto :goto_0
.end method

.method public static a(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 38
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2

    .prologue
    .line 60
    :try_start_0
    invoke-static {p0, p1}, Lbc;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 61
    sget-object v0, Ll;->c:Ll;

    if-nez v0, :cond_0

    .line 69
    :goto_0
    return-void

    .line 64
    :cond_0
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->l:Lbf;

    invoke-virtual {v0, p0, p1}, Lbf;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 65
    :catch_0
    move-exception v0

    .line 67
    const-string v1, "Error sending log message"

    invoke-static {v1, v0}, Lbc;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static a(Ljava/net/URLConnection;)V
    .locals 2

    .prologue
    .line 76
    :try_start_0
    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    .line 77
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->i:Lbk;

    invoke-virtual {v0, p0}, Lbk;->b(Ljava/net/URLConnection;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :cond_0
    :goto_0
    return-void

    .line 79
    :catch_0
    move-exception v0

    .line 80
    const-string v1, "Exception in pre-request handler"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static a(Ljava/net/URLConnection;Ljava/io/IOException;)V
    .locals 1

    .prologue
    .line 110
    :try_start_0
    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    .line 111
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->i:Lbk;

    invoke-virtual {v0, p0, p1}, Lbk;->a(Ljava/net/URLConnection;Ljava/lang/Exception;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 116
    :cond_0
    :goto_0
    return-void

    .line 114
    :catch_0
    move-exception v0

    const-string v0, "Exception in network request handler"

    invoke-static {v0, p1}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static b(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 42
    sget-object v0, Ll;->h:Lbi;

    invoke-virtual {v0, p0}, Lbi;->a(Landroid/app/Activity;)V

    .line 43
    return-void
.end method

.method public static b(Ljava/net/URLConnection;)V
    .locals 2

    .prologue
    .line 88
    :try_start_0
    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    .line 89
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->i:Lbk;

    invoke-virtual {v0, p0}, Lbk;->c(Ljava/net/URLConnection;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    :cond_0
    :goto_0
    return-void

    .line 91
    :catch_0
    move-exception v0

    .line 92
    const-string v1, "Exception in post-request handler"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static c(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 47
    sget-object v0, Ll;->h:Lbi;

    invoke-virtual {v0, p0}, Lbi;->b(Landroid/app/Activity;)V

    .line 48
    return-void
.end method

.method public static c(Ljava/net/URLConnection;)V
    .locals 2

    .prologue
    .line 98
    :try_start_0
    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    .line 99
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->i:Lbk;

    invoke-virtual {v0, p0}, Lbk;->a(Ljava/net/URLConnection;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    :cond_0
    :goto_0
    return-void

    .line 101
    :catch_0
    move-exception v0

    .line 102
    const-string v1, "Exception in marking request as reportable"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static d(Ljava/net/URLConnection;)Ljava/io/InputStream;
    .locals 2

    .prologue
    .line 122
    :try_start_0
    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    .line 123
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->i:Lbk;

    new-instance v1, Lbk$1;

    invoke-direct {v1, v0, p0}, Lbk$1;-><init>(Lbk;Ljava/net/URLConnection;)V

    invoke-virtual {v1, p0}, Lbk$1;->a(Ljava/net/URLConnection;)Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 130
    :goto_0
    return-object v0

    .line 125
    :catch_0
    move-exception v0

    .line 126
    throw v0

    .line 127
    :catch_1
    move-exception v0

    .line 128
    const-string v1, "Exception while fetching input stream"

    invoke-static {v1, v0}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 130
    :cond_0
    invoke-virtual {p0}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0
.end method

.method public static d(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 52
    return-void
.end method

.method public static e(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 56
    return-void
.end method

.method public static f(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 282
    sget-object v0, Ll;->b:Ls;

    if-eqz v0, :cond_0

    .line 283
    sget-object v0, Ll;->b:Ls;

    invoke-virtual {v0}, Ls;->c()V

    .line 286
    :cond_0
    sget-object v0, Ll;->h:Lbi;

    invoke-virtual {v0, p0}, Lbi;->c(Landroid/app/Activity;)V

    .line 287
    return-void
.end method

.method public static g(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 291
    sget-object v0, Ll;->b:Ls;

    if-eqz v0, :cond_0

    .line 292
    sget-object v0, Ll;->b:Ls;

    invoke-virtual {v0}, Ls;->b()V

    .line 294
    :cond_0
    return-void
.end method
