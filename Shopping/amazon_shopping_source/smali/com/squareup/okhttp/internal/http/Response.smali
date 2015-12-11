.class public final Lcom/squareup/okhttp/internal/http/Response;
.super Ljava/lang/Object;
.source "Response.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/okhttp/internal/http/Response$1;,
        Lcom/squareup/okhttp/internal/http/Response$Builder;,
        Lcom/squareup/okhttp/internal/http/Response$Receiver;,
        Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;,
        Lcom/squareup/okhttp/internal/http/Response$Body;
    }
.end annotation


# instance fields
.field private final body:Lcom/squareup/okhttp/internal/http/Response$Body;

.field private volatile cacheControl:Lcom/squareup/okhttp/CacheControl;

.field private final handshake:Lcom/squareup/okhttp/Handshake;

.field private final headers:Lcom/squareup/okhttp/internal/http/Headers;

.field private volatile parsedHeaders:Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

.field private final redirectedBy:Lcom/squareup/okhttp/internal/http/Response;

.field private final request:Lcom/squareup/okhttp/internal/http/Request;

.field private final statusLine:Lcom/squareup/okhttp/internal/http/StatusLine;


# direct methods
.method private constructor <init>(Lcom/squareup/okhttp/internal/http/Response$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/squareup/okhttp/internal/http/Response$Builder;

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    # getter for: Lcom/squareup/okhttp/internal/http/Response$Builder;->request:Lcom/squareup/okhttp/internal/http/Request;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->access$000(Lcom/squareup/okhttp/internal/http/Response$Builder;)Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 60
    # getter for: Lcom/squareup/okhttp/internal/http/Response$Builder;->statusLine:Lcom/squareup/okhttp/internal/http/StatusLine;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->access$100(Lcom/squareup/okhttp/internal/http/Response$Builder;)Lcom/squareup/okhttp/internal/http/StatusLine;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->statusLine:Lcom/squareup/okhttp/internal/http/StatusLine;

    .line 61
    # getter for: Lcom/squareup/okhttp/internal/http/Response$Builder;->handshake:Lcom/squareup/okhttp/Handshake;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->access$200(Lcom/squareup/okhttp/internal/http/Response$Builder;)Lcom/squareup/okhttp/Handshake;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->handshake:Lcom/squareup/okhttp/Handshake;

    .line 62
    # getter for: Lcom/squareup/okhttp/internal/http/Response$Builder;->headers:Lcom/squareup/okhttp/internal/http/Headers$Builder;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->access$300(Lcom/squareup/okhttp/internal/http/Response$Builder;)Lcom/squareup/okhttp/internal/http/Headers$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/Headers$Builder;->build()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    .line 63
    # getter for: Lcom/squareup/okhttp/internal/http/Response$Builder;->body:Lcom/squareup/okhttp/internal/http/Response$Body;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->access$400(Lcom/squareup/okhttp/internal/http/Response$Builder;)Lcom/squareup/okhttp/internal/http/Response$Body;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->body:Lcom/squareup/okhttp/internal/http/Response$Body;

    .line 64
    # getter for: Lcom/squareup/okhttp/internal/http/Response$Builder;->redirectedBy:Lcom/squareup/okhttp/internal/http/Response;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Response$Builder;->access$500(Lcom/squareup/okhttp/internal/http/Response$Builder;)Lcom/squareup/okhttp/internal/http/Response;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->redirectedBy:Lcom/squareup/okhttp/internal/http/Response;

    .line 65
    return-void
.end method

.method synthetic constructor <init>(Lcom/squareup/okhttp/internal/http/Response$Builder;Lcom/squareup/okhttp/internal/http/Response$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/squareup/okhttp/internal/http/Response$Builder;
    .param p2, "x1"    # Lcom/squareup/okhttp/internal/http/Response$1;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lcom/squareup/okhttp/internal/http/Response;-><init>(Lcom/squareup/okhttp/internal/http/Response$Builder;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/squareup/okhttp/internal/http/Response;)Lcom/squareup/okhttp/internal/http/StatusLine;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->statusLine:Lcom/squareup/okhttp/internal/http/StatusLine;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/squareup/okhttp/internal/http/Response;)Lcom/squareup/okhttp/Handshake;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->handshake:Lcom/squareup/okhttp/Handshake;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/squareup/okhttp/internal/http/Response;)Lcom/squareup/okhttp/internal/http/Headers;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/squareup/okhttp/internal/http/Response;)Lcom/squareup/okhttp/internal/http/Response$Body;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->body:Lcom/squareup/okhttp/internal/http/Response$Body;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/squareup/okhttp/internal/http/Response;)Lcom/squareup/okhttp/internal/http/Response;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->redirectedBy:Lcom/squareup/okhttp/internal/http/Response;

    return-object v0
.end method

.method static synthetic access$900(Lcom/squareup/okhttp/internal/http/Response;)Lcom/squareup/okhttp/internal/http/Request;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->request:Lcom/squareup/okhttp/internal/http/Request;

    return-object v0
.end method

.method private parsedHeaders()Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;
    .locals 3

    .prologue
    .line 278
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->parsedHeaders:Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    .line 279
    .local v0, "result":Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;
    if-eqz v0, :cond_0

    .end local v0    # "result":Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;
    :goto_0
    return-object v0

    .restart local v0    # "result":Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;
    :cond_0
    new-instance v0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    .end local v0    # "result":Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/Response;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;-><init>(Lcom/squareup/okhttp/internal/http/Headers;Lcom/squareup/okhttp/internal/http/Response$1;)V

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->parsedHeaders:Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    goto :goto_0
.end method


# virtual methods
.method public body()Lcom/squareup/okhttp/internal/http/Response$Body;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->body:Lcom/squareup/okhttp/internal/http/Response$Body;

    return-object v0
.end method

.method public cacheControl()Lcom/squareup/okhttp/CacheControl;
    .locals 2

    .prologue
    .line 287
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->cacheControl:Lcom/squareup/okhttp/CacheControl;

    .line 288
    .local v0, "result":Lcom/squareup/okhttp/CacheControl;
    if-eqz v0, :cond_0

    .end local v0    # "result":Lcom/squareup/okhttp/CacheControl;
    :goto_0
    return-object v0

    .restart local v0    # "result":Lcom/squareup/okhttp/CacheControl;
    :cond_0
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/Response;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    invoke-static {v1}, Lcom/squareup/okhttp/CacheControl;->parse(Lcom/squareup/okhttp/internal/http/Headers;)Lcom/squareup/okhttp/CacheControl;

    move-result-object v0

    .end local v0    # "result":Lcom/squareup/okhttp/CacheControl;
    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->cacheControl:Lcom/squareup/okhttp/CacheControl;

    goto :goto_0
.end method

.method public code()I
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->statusLine:Lcom/squareup/okhttp/internal/http/StatusLine;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/StatusLine;->code()I

    move-result v0

    return v0
.end method

.method public getVaryFields()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 144
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Response;->parsedHeaders()Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    move-result-object v0

    # getter for: Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->varyFields:Ljava/util/Set;
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->access$700(Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;)Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public handshake()Lcom/squareup/okhttp/Handshake;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->handshake:Lcom/squareup/okhttp/Handshake;

    return-object v0
.end method

.method public hasVaryAll()Z
    .locals 2

    .prologue
    .line 153
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Response;->parsedHeaders()Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    move-result-object v0

    # getter for: Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->varyFields:Ljava/util/Set;
    invoke-static {v0}, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->access$700(Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;)Ljava/util/Set;

    move-result-object v0

    const-string/jumbo v1, "*"

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public header(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 112
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/squareup/okhttp/internal/http/Response;->header(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public header(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 116
    iget-object v1, p0, Lcom/squareup/okhttp/internal/http/Response;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    invoke-virtual {v1, p1}, Lcom/squareup/okhttp/internal/http/Headers;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 117
    .local v0, "result":Ljava/lang/String;
    if-eqz v0, :cond_0

    .end local v0    # "result":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "result":Ljava/lang/String;
    :cond_0
    move-object v0, p2

    goto :goto_0
.end method

.method public headers()Lcom/squareup/okhttp/internal/http/Headers;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->headers:Lcom/squareup/okhttp/internal/http/Headers;

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
    .line 108
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->headers:Lcom/squareup/okhttp/internal/http/Headers;

    invoke-virtual {v0, p1}, Lcom/squareup/okhttp/internal/http/Headers;->values(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public httpMinorVersion()I
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->statusLine:Lcom/squareup/okhttp/internal/http/StatusLine;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/StatusLine;->httpMinorVersion()I

    move-result v0

    return v0
.end method

.method public newBuilder()Lcom/squareup/okhttp/internal/http/Response$Builder;
    .locals 2

    .prologue
    .line 129
    new-instance v0, Lcom/squareup/okhttp/internal/http/Response$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/squareup/okhttp/internal/http/Response$Builder;-><init>(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Response$1;)V

    return-object v0
.end method

.method public redirectedBy()Lcom/squareup/okhttp/internal/http/Response;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->redirectedBy:Lcom/squareup/okhttp/internal/http/Response;

    return-object v0
.end method

.method public request()Lcom/squareup/okhttp/internal/http/Request;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->request:Lcom/squareup/okhttp/internal/http/Request;

    return-object v0
.end method

.method public statusLine()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->statusLine:Lcom/squareup/okhttp/internal/http/StatusLine;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/StatusLine;->getStatusLine()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public statusMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Response;->statusLine:Lcom/squareup/okhttp/internal/http/StatusLine;

    invoke-virtual {v0}, Lcom/squareup/okhttp/internal/http/StatusLine;->message()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public validate(Lcom/squareup/okhttp/internal/http/Response;)Z
    .locals 6
    .param p1, "network"    # Lcom/squareup/okhttp/internal/http/Response;

    .prologue
    const/4 v1, 0x1

    .line 174
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v2

    const/16 v3, 0x130

    if-ne v2, v3, :cond_1

    .line 188
    :cond_0
    :goto_0
    return v1

    .line 181
    :cond_1
    invoke-direct {p1}, Lcom/squareup/okhttp/internal/http/Response;->parsedHeaders()Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    move-result-object v0

    .line 182
    .local v0, "networkHeaders":Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Response;->parsedHeaders()Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    move-result-object v2

    iget-object v2, v2, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->lastModified:Ljava/util/Date;

    if-eqz v2, :cond_2

    iget-object v2, v0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->lastModified:Ljava/util/Date;

    if-eqz v2, :cond_2

    iget-object v2, v0, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->lastModified:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Response;->parsedHeaders()Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    move-result-object v4

    iget-object v4, v4, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->lastModified:Ljava/util/Date;

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    .line 188
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public varyMatches(Lcom/squareup/okhttp/internal/http/Headers;Lcom/squareup/okhttp/internal/http/Request;)Z
    .locals 4
    .param p1, "varyHeaders"    # Lcom/squareup/okhttp/internal/http/Headers;
    .param p2, "newRequest"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    .line 162
    invoke-direct {p0}, Lcom/squareup/okhttp/internal/http/Response;->parsedHeaders()Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;

    move-result-object v2

    # getter for: Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->varyFields:Ljava/util/Set;
    invoke-static {v2}, Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;->access$700(Lcom/squareup/okhttp/internal/http/Response$ParsedHeaders;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 163
    .local v0, "field":Ljava/lang/String;
    invoke-virtual {p1, v0}, Lcom/squareup/okhttp/internal/http/Headers;->values(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p2, v0}, Lcom/squareup/okhttp/internal/http/Request;->headers(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/squareup/okhttp/internal/Util;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x0

    .line 165
    .end local v0    # "field":Ljava/lang/String;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x1

    goto :goto_0
.end method
