.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;
.super Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;
.source "BasicHttpRequest.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;


# instance fields
.field private final method:Ljava/lang/String;

.field private requestline:Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

.field private final uri:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V
    .locals 2
    .param p1, "requestline"    # Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    .prologue
    .line 94
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;-><init>()V

    .line 95
    if-nez p1, :cond_0

    .line 96
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request line may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 98
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->requestline:Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    .line 99
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->method:Ljava/lang/String;

    .line 100
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->uri:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "ver"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 85
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicRequestLine;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicRequestLine;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;-><init>(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V

    .line 86
    return-void
.end method


# virtual methods
.method public getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 1

    .prologue
    .line 112
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    return-object v0
.end method

.method public getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    .locals 4

    .prologue
    .line 123
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->requestline:Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    if-nez v1, :cond_0

    .line 124
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->getVersion(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    .line 125
    .local v0, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicRequestLine;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->method:Ljava/lang/String;

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->uri:Ljava/lang/String;

    invoke-direct {v1, v2, v3, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicRequestLine;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->requestline:Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    .line 127
    .end local v0    # "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->requestline:Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    return-object v1
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 131
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->method:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->uri:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
