.class public Lcom/amazon/identity/auth/request/HttpRequestAdapter;
.super Ljava/lang/Object;
.source "HttpRequestAdapter.java"

# interfaces
.implements Lcom/amazon/identity/auth/request/IRequestAdapter;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field public final mHttpRequest:Lorg/apache/http/HttpRequest;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lorg/apache/http/HttpRequest;)V
    .locals 0
    .param p1, "request"    # Lorg/apache/http/HttpRequest;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->mHttpRequest:Lorg/apache/http/HttpRequest;

    .line 29
    return-void
.end method


# virtual methods
.method public getBody()[B
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 64
    iget-object v2, p0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->mHttpRequest:Lorg/apache/http/HttpRequest;

    instance-of v2, v2, Lorg/apache/http/HttpEntityEnclosingRequest;

    if-nez v2, :cond_0

    .line 66
    new-array v2, v4, [B

    .line 85
    :goto_0
    return-object v2

    .line 69
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->mHttpRequest:Lorg/apache/http/HttpRequest;

    check-cast v2, Lorg/apache/http/HttpEntityEnclosingRequest;

    .line 70
    invoke-interface {v2}, Lorg/apache/http/HttpEntityEnclosingRequest;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    .line 71
    .local v1, "httpEntity":Lorg/apache/http/HttpEntity;
    if-nez v1, :cond_1

    .line 73
    new-array v2, v4, [B

    goto :goto_0

    .line 78
    :cond_1
    :try_start_0
    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 80
    :catch_0
    move-exception v0

    .line 82
    .local v0, "e":Ljava/io/IOException;
    sget-object v2, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Could not turn body into byte array"

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 85
    new-array v2, v4, [B

    goto :goto_0
.end method

.method public getHeader(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 34
    iget-object v1, p0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->mHttpRequest:Lorg/apache/http/HttpRequest;

    invoke-interface {v1, p1}, Lorg/apache/http/HttpRequest;->getFirstHeader(Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v0

    .line 35
    .local v0, "header":Lorg/apache/http/Header;
    if-nez v0, :cond_0

    .line 37
    const/4 v1, 0x0

    .line 40
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {v0}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getHeaders()Ljava/util/Map;
    .locals 8
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
    .line 91
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 92
    .local v2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    iget-object v7, p0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->mHttpRequest:Lorg/apache/http/HttpRequest;

    invoke-interface {v7}, Lorg/apache/http/HttpRequest;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v0

    .local v0, "arr$":[Lorg/apache/http/Header;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v1, v0, v3

    .line 94
    .local v1, "header":Lorg/apache/http/Header;
    invoke-interface {v1}, Lorg/apache/http/Header;->getName()Ljava/lang/String;

    move-result-object v5

    .line 95
    .local v5, "name":Ljava/lang/String;
    invoke-interface {v1}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    .line 97
    .local v6, "value":Ljava/lang/String;
    invoke-interface {v2, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 99
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v2, v5, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    :cond_0
    invoke-interface {v2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/List;

    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 92
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 105
    .end local v1    # "header":Lorg/apache/http/Header;
    .end local v5    # "name":Ljava/lang/String;
    .end local v6    # "value":Ljava/lang/String;
    :cond_1
    return-object v2
.end method

.method public getHttpVerb()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->mHttpRequest:Lorg/apache/http/HttpRequest;

    invoke-interface {v0}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->mHttpRequest:Lorg/apache/http/HttpRequest;

    invoke-interface {v0}, Lorg/apache/http/HttpRequest;->getRequestLine()Lorg/apache/http/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public setHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpRequestAdapter;->mHttpRequest:Lorg/apache/http/HttpRequest;

    invoke-interface {v0, p1, p2}, Lorg/apache/http/HttpRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    return-void
.end method
