.class public Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;
.super Ljava/lang/Object;
.source "ResponseProcessCookies.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final log:Lorg/apache/commons/logging/Log;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    .line 63
    return-void
.end method

.method private processCookies(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;)V
    .locals 8
    .param p1, "iterator"    # Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    .param p2, "cookieSpec"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;
    .param p3, "cookieOrigin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    .param p4, "cookieStore"    # Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;

    .prologue
    .line 112
    :cond_0
    :goto_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 113
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;->nextHeader()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v3

    .line 115
    .local v3, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :try_start_0
    invoke-interface {p2, v3, p3}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;->parse(Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;

    move-result-object v1

    .line 116
    .local v1, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException; {:try_start_0 .. :try_end_0} :catch_1

    .line 118
    .local v0, "cookie":Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    :try_start_1
    invoke-interface {p2, v0, p3}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;->validate(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)V

    .line 119
    invoke-interface {p4, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;->addCookie(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;)V

    .line 121
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 122
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Cookie accepted: \""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\". "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V
    :try_end_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 125
    :catch_0
    move-exception v2

    .line 126
    .local v2, "ex":Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
    :try_start_2
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isWarnEnabled()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 127
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Cookie rejected: \""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\". "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;)V
    :try_end_2
    .catch Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 132
    .end local v0    # "cookie":Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .end local v1    # "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;>;"
    .end local v2    # "ex":Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
    .end local v4    # "i$":Ljava/util/Iterator;
    :catch_1
    move-exception v2

    .line 133
    .restart local v2    # "ex":Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isWarnEnabled()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 134
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Invalid cookie header: \""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\". "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 139
    .end local v2    # "ex":Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
    .end local v3    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_2
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 6
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 67
    if-nez p1, :cond_0

    .line 68
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "HTTP request may not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 70
    :cond_0
    if-nez p2, :cond_1

    .line 71
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "HTTP context may not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 75
    :cond_1
    const-string v4, "http.cookie-spec"

    invoke-interface {p2, v4}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;

    .line 77
    .local v1, "cookieSpec":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;
    if-nez v1, :cond_3

    .line 78
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "Cookie spec not specified in HTTP context"

    invoke-interface {v4, v5}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 105
    :cond_2
    :goto_0
    return-void

    .line 82
    :cond_3
    const-string v4, "http.cookie-store"

    invoke-interface {p2, v4}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;

    .line 84
    .local v2, "cookieStore":Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;
    if-nez v2, :cond_4

    .line 85
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "Cookie store not specified in HTTP context"

    invoke-interface {v4, v5}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_0

    .line 89
    :cond_4
    const-string v4, "http.cookie-origin"

    invoke-interface {p2, v4}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .line 91
    .local v0, "cookieOrigin":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    if-nez v0, :cond_5

    .line 92
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "Cookie origin not specified in HTTP context"

    invoke-interface {v4, v5}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_0

    .line 95
    :cond_5
    const-string v4, "Set-Cookie"

    invoke-interface {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->headerIterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v3

    .line 96
    .local v3, "it":Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    invoke-direct {p0, v3, v1, v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->processCookies(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;)V

    .line 99
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;->getVersion()I

    move-result v4

    if-lez v4, :cond_2

    .line 102
    const-string v4, "Set-Cookie2"

    invoke-interface {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->headerIterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v3

    .line 103
    invoke-direct {p0, v3, v1, v0, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseProcessCookies;->processCookies(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;)V

    goto :goto_0
.end method
