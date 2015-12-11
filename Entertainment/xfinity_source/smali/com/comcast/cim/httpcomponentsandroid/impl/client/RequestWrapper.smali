.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
.super Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;
.source "RequestWrapper.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private execCount:I

.field private method:Ljava/lang/String;

.field private final original:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

.field private uri:Ljava/net/URI;

.field private version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V
    .locals 5
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;-><init>()V

    .line 67
    if-nez p1, :cond_0

    .line 68
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "HTTP request may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 70
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->original:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    .line 71
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 72
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 74
    instance-of v2, p1, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    if-eqz v2, :cond_1

    move-object v2, p1

    .line 75
    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->uri:Ljava/net/URI;

    .line 76
    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getMethod()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->method:Ljava/lang/String;

    .line 77
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .line 89
    :goto_0
    const/4 v2, 0x0

    iput v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->execCount:I

    .line 90
    return-void

    .line 79
    .restart local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_1
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v1

    .line 81
    .local v1, "requestLine":Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    :try_start_0
    new-instance v2, Ljava/net/URI;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->uri:Ljava/net/URI;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 86
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->method:Ljava/lang/String;

    .line 87
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    goto :goto_0

    .line 82
    :catch_0
    move-exception v0

    .line 83
    .local v0, "ex":Ljava/net/URISyntaxException;
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid request URI: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method


# virtual methods
.method public getExecCount()I
    .locals 1

    .prologue
    .line 159
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->execCount:I

    return v0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->method:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginal()Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->original:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    return-object v0
.end method

.method public getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    if-nez v0, :cond_0

    .line 111
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->getVersion(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .line 113
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    return-object v0
.end method

.method public getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    .locals 4

    .prologue
    .line 130
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getMethod()Ljava/lang/String;

    move-result-object v0

    .line 131
    .local v0, "method":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v2

    .line 132
    .local v2, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    const/4 v1, 0x0

    .line 133
    .local v1, "uritext":Ljava/lang/String;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->uri:Ljava/net/URI;

    if-eqz v3, :cond_0

    .line 134
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->uri:Ljava/net/URI;

    invoke-virtual {v3}, Ljava/net/URI;->toASCIIString()Ljava/lang/String;

    move-result-object v1

    .line 136
    :cond_0
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_2

    .line 137
    :cond_1
    const-string v1, "/"

    .line 139
    :cond_2
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/message/BasicRequestLine;

    invoke-direct {v3, v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicRequestLine;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    return-object v3
.end method

.method public getURI()Ljava/net/URI;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->uri:Ljava/net/URI;

    return-object v0
.end method

.method public incrementExecCount()V
    .locals 1

    .prologue
    .line 163
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->execCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->execCount:I

    .line 164
    return-void
.end method

.method public isAborted()Z
    .locals 1

    .prologue
    .line 147
    const/4 v0, 0x0

    return v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 155
    const/4 v0, 0x1

    return v0
.end method

.method public resetHeaders()V
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->clear()V

    .line 95
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->original:Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 96
    return-void
.end method

.method public setMethod(Ljava/lang/String;)V
    .locals 2
    .param p1, "method"    # Ljava/lang/String;

    .prologue
    .line 103
    if-nez p1, :cond_0

    .line 104
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Method name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 106
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->method:Ljava/lang/String;

    .line 107
    return-void
.end method

.method public setProtocolVersion(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V
    .locals 0
    .param p1, "version"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .line 118
    return-void
.end method

.method public setURI(Ljava/net/URI;)V
    .locals 0
    .param p1, "uri"    # Ljava/net/URI;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;->uri:Ljava/net/URI;

    .line 127
    return-void
.end method
