.class public final Lcom/squareup/okhttp/internal/http/Request;
.super Ljava/lang/Object;
.source "Request.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/okhttp/internal/http/Request$1;,
        Lcom/squareup/okhttp/internal/http/Request$Builder;,
        Lcom/squareup/okhttp/internal/http/Request$Body;,
        Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;
    }
.end annotation


# instance fields
.field private final body:Lcom/squareup/okhttp/internal/http/Request$Body;

.field private volatile cacheControl:Lcom/squareup/okhttp/CacheControl;

.field private final headers:Lcom/squareup/okhttp/internal/http/Headers;

.field private final method:Ljava/lang/String;

.field private volatile parsedHeaders:Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;

.field private final tag:Ljava/lang/Object;

.field private volatile uri:Ljava/net/URI;

.field private final url:Ljava/net/URL;


# direct methods
.method private constructor <init>(Lcom/squareup/okhttp/internal/http/Request$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/squareup/okhttp/internal/http/Request$Builder;

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    # getter for: Lcom/squareup/okhttp/internal/http/Request$Builder;->url:Ljava/net/URL;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->access$000(Lcom/squareup/okhttp/internal/http/Request$Builder;)Ljava/net/URL;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->url:Ljava/net/URL;

    .line 51
    # getter for: Lcom/squareup/okhttp/internal/http/Request$Builder;->method:Ljava/lang/String;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->access$100(Lcom/squareup/okhttp/internal/http/Request$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->method:Ljava/lang/String;

    .line 52
    # getter for: Lcom/squareup/okhttp/internal/http/Request$Builder;->headers:Lcom/squareup/okhttp/internal/http/Headers$Builder;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->access$200(Lcom/squareup/okhttp/internal/http/Request$Builder;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->build()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    .line 53
    # getter for: Lcom/squareup/okhttp/internal/http/Request$Builder;->body:Lcom/squareup/okhttp/internal/http/Request$Body;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->access$300(Lcom/squareup/okhttp/internal/http/Request$Builder;)Lcom/squareup/okhttp/internal/http/Request$Body;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->body:Lcom/squareup/okhttp/internal/http/Request$Body;

    .line 54
    # getter for: Lcom/squareup/okhttp/internal/http/Request$Builder;->tag:Ljava/lang/Object;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->access$400(Lcom/squareup/okhttp/internal/http/Request$Builder;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    # getter for: Lcom/squareup/okhttp/internal/http/Request$Builder;->tag:Ljava/lang/Object;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Request$Builder;->access$400(Lcom/squareup/okhttp/internal/http/Request$Builder;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->tag:Ljava/lang/Object;

    .line 55
    return-void

    :cond_0
    move-object v0, p0

    .line 54
    goto :goto_0
.end method

.method synthetic constructor <init>(Lcom/squareup/okhttp/internal/http/Request$Builder;Lcom/squareup/okhttp/internal/http/Request$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/squareup/okhttp/internal/http/Request$Builder;
    .param p2, "x1"    # Lcom/squareup/okhttp/internal/http/Request$1;

    .prologue
    .line 38
    invoke-direct {p0, p1}, Lcom/squareup/okhttp/internal/http/Request;-><init>(Lcom/squareup/okhttp/internal/http/Request$Builder;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Request$Body;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->body:Lcom/squareup/okhttp/internal/http/Request$Body;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/squareup/okhttp/internal/http/Request;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->tag:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/squareup/okhttp/internal/http/Request;)Lcom/squareup/okhttp/internal/http/Headers;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    return-object v0
.end method

.method static synthetic access$800(Lcom/squareup/okhttp/internal/http/Request;)Ljava/net/URL;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->url:Ljava/net/URL;

    return-object v0
.end method

.method static synthetic access$900(Lcom/squareup/okhttp/internal/http/Request;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->method:Ljava/lang/String;

    return-object v0
.end method

.method private parsedHeaders()Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;
    .locals 2

    .prologue
    .line 115
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->parsedHeaders:Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;

    .line 116
    .local v0, "result":Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;
    if-eqz v0, :cond_0

    .end local v0    # "result":Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;
    :goto_0
    return-object v0

    .restart local v0    # "result":Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;
    :cond_0
    new-instance v0, Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;

    .end local v0    # "result":Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/Request;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    invoke-direct {v0, v1}, Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;-><init>(Lcom/squareup/okhttp/internal/http/Headers;)V

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->parsedHeaders:Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;

    goto :goto_0
.end method


# virtual methods
.method public body()Lcom/squareup/okhttp/internal/http/Request$Body;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->body:Lcom/squareup/okhttp/internal/http/Request$Body;

    return-object v0
.end method

.method public cacheControl()Lcom/squareup/okhttp/CacheControl;
    .locals 2

    .prologue
    .line 124
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->cacheControl:Lcom/squareup/okhttp/CacheControl;

    .line 125
    .local v0, "result":Lcom/squareup/okhttp/CacheControl;
    if-eqz v0, :cond_0

    .end local v0    # "result":Lcom/squareup/okhttp/CacheControl;
    :goto_0
    return-object v0

    .restart local v0    # "result":Lcom/squareup/okhttp/CacheControl;
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/Request;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    invoke-static {v1}, Lcom/squareup/okhttp/CacheControl;->parse(Lcom/squareup/okhttp/internal/http/Headers;)Lcom/squareup/okhttp/CacheControl;

    move-result-object v0

    .end local v0    # "result":Lcom/squareup/okhttp/CacheControl;
    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->cacheControl:Lcom/squareup/okhttp/CacheControl;

    goto :goto_0
.end method

.method public getHeaders()Lcom/squareup/okhttp/internal/http/Headers;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    return-object v0
.end method

.method public getProxyAuthorization()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Request;->parsedHeaders()Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;

    move-result-object v0

    # getter for: Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;->proxyAuthorization:Ljava/lang/String;
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;->access$700(Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Request;->parsedHeaders()Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;

    move-result-object v0

    # getter for: Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;->userAgent:Ljava/lang/String;
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;->access$600(Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public header(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/http/Headers;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public headers()Lcom/squareup/okhttp/internal/http/Headers;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    return-object v0
.end method

.method public headers(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 87
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/http/Headers;->values(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public isHttps()Z
    .locals 2

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "https"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public method()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->method:Ljava/lang/String;

    return-object v0
.end method

.method public newBuilder()Lcom/squareup/okhttp/internal/http/Request$Builder;
    .locals 2

    .prologue
    .line 99
    new-instance v0, Lcom/squareup/okhttp/internal/http/Request$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/squareup/okhttp/internal/http/Request$Builder;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Request$1;)V

    return-object v0
.end method

.method public tag()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->tag:Ljava/lang/Object;

    return-object v0
.end method

.method public uri()Ljava/net/URI;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    :try_start_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/Request;->uri:Ljava/net/URI;

    .line 64
    .local v1, "result":Ljava/net/URI;
    if-eqz v1, :cond_0

    .end local v1    # "result":Ljava/net/URI;
    :goto_0
    return-object v1

    .restart local v1    # "result":Ljava/net/URI;
    :cond_0
    invoke-static {}, Lcom/squareup/okhttp/internal/Platform;->get()Lcom/squareup/okhttp/internal/Platform;

    move-result-object v2

    iget-object v3, p0, Lcom/squareup/okhttp/internal/http/Request;->url:Ljava/net/URL;

    invoke-virtual {v2, v3}, Lcom/squareup/okhttp/internal/Platform;->toUriLenient(Ljava/net/URL;)Ljava/net/URI;

    move-result-object v1

    .end local v1    # "result":Ljava/net/URI;
    iput-object v1, p0, Lcom/squareup/okhttp/internal/http/Request;->uri:Ljava/net/URI;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 65
    :catch_0
    move-exception v0

    .line 66
    .local v0, "e":Ljava/net/URISyntaxException;
    new-instance v2, Ljava/io/IOException;

    invoke-virtual {v0}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public url()Ljava/net/URL;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->url:Ljava/net/URL;

    return-object v0
.end method

.method public urlString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request;->url:Ljava/net/URL;

    invoke-virtual {v0}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
