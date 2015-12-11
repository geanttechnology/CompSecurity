.class public Lcom/comcast/cim/microdata/http/apache/ApacheHttpRequester;
.super Ljava/lang/Object;
.source "ApacheHttpRequester.java"

# interfaces
.implements Lcom/comcast/cim/microdata/http/HttpRequester;


# instance fields
.field private httpClient:Lorg/apache/http/client/HttpClient;

.field private httpContext:Lorg/apache/http/protocol/HttpContext;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getHttpClient()Lorg/apache/http/client/HttpClient;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/apache/ApacheHttpRequester;->httpClient:Lorg/apache/http/client/HttpClient;

    return-object v0
.end method

.method public getHttpContext()Lorg/apache/http/protocol/HttpContext;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/apache/ApacheHttpRequester;->httpContext:Lorg/apache/http/protocol/HttpContext;

    return-object v0
.end method

.method public setHttpClient(Lorg/apache/http/client/HttpClient;)V
    .locals 0
    .param p1, "httpClient"    # Lorg/apache/http/client/HttpClient;

    .prologue
    .line 86
    iput-object p1, p0, Lcom/comcast/cim/microdata/http/apache/ApacheHttpRequester;->httpClient:Lorg/apache/http/client/HttpClient;

    .line 87
    return-void
.end method

.method public setHttpContext(Lorg/apache/http/protocol/HttpContext;)V
    .locals 0
    .param p1, "httpContext"    # Lorg/apache/http/protocol/HttpContext;

    .prologue
    .line 94
    iput-object p1, p0, Lcom/comcast/cim/microdata/http/apache/ApacheHttpRequester;->httpContext:Lorg/apache/http/protocol/HttpContext;

    .line 95
    return-void
.end method
