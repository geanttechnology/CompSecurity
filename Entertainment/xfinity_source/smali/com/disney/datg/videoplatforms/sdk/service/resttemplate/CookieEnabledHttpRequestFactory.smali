.class public Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;
.super Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;
.source "CookieEnabledHttpRequestFactory.java"


# static fields
.field private static cookieStore:Lorg/apache/http/client/CookieStore;

.field private static httpContext:Lorg/apache/http/protocol/HttpContext;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    new-instance v0, Lorg/apache/http/impl/client/BasicCookieStore;

    invoke-direct {v0}, Lorg/apache/http/impl/client/BasicCookieStore;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->cookieStore:Lorg/apache/http/client/CookieStore;

    .line 17
    const/4 v0, 0x0

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->httpContext:Lorg/apache/http/protocol/HttpContext;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lorg/springframework/http/client/HttpComponentsClientHttpRequestFactory;-><init>()V

    return-void
.end method

.method public static getSWID()Ljava/lang/String;
    .locals 5

    .prologue
    .line 35
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->cookieStore:Lorg/apache/http/client/CookieStore;

    invoke-interface {v3}, Lorg/apache/http/client/CookieStore;->getCookies()Ljava/util/List;

    move-result-object v1

    .line 37
    .local v1, "cookieBox":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 38
    .local v0, "c":Lorg/apache/http/cookie/Cookie;
    const-string v3, "SWID"

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 39
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 43
    .end local v0    # "c":Lorg/apache/http/cookie/Cookie;
    :goto_0
    return-object v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected createHttpContext(Lorg/springframework/http/HttpMethod;Ljava/net/URI;)Lorg/apache/http/protocol/HttpContext;
    .locals 3
    .param p1, "httpMethod"    # Lorg/springframework/http/HttpMethod;
    .param p2, "uri"    # Ljava/net/URI;

    .prologue
    .line 22
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->httpContext:Lorg/apache/http/protocol/HttpContext;

    if-nez v0, :cond_0

    .line 23
    new-instance v0, Lorg/apache/http/protocol/BasicHttpContext;

    invoke-direct {v0}, Lorg/apache/http/protocol/BasicHttpContext;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->httpContext:Lorg/apache/http/protocol/HttpContext;

    .line 24
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->httpContext:Lorg/apache/http/protocol/HttpContext;

    const-string v1, "http.cookie-store"

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->cookieStore:Lorg/apache/http/client/CookieStore;

    invoke-interface {v0, v1, v2}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 27
    :cond_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/CookieEnabledHttpRequestFactory;->httpContext:Lorg/apache/http/protocol/HttpContext;

    return-object v0
.end method
