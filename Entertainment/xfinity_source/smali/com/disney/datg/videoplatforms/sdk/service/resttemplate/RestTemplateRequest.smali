.class public Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;
.super Ljava/lang/Object;
.source "RestTemplateRequest.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/service/Request;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/disney/datg/videoplatforms/sdk/service/Request",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final clazz:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field private headers:Lorg/springframework/http/HttpHeaders;

.field private httpMethod:Lorg/springframework/http/HttpMethod;

.field private postParams:Lorg/springframework/util/MultiValueMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/springframework/util/MultiValueMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private serviceUri:Ljava/net/URI;


# direct methods
.method public constructor <init>(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Ljava/lang/Class;)V
    .locals 0
    .param p1, "serviceUri"    # Ljava/net/URI;
    .param p2, "method"    # Lorg/springframework/http/HttpMethod;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Lorg/springframework/http/HttpMethod;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    .local p3, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->clazz:Ljava/lang/Class;

    .line 38
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->setServiceUri(Ljava/net/URI;)V

    .line 39
    invoke-virtual {p0, p2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->setHttpMethod(Lorg/springframework/http/HttpMethod;)V

    .line 40
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/http/HttpHeaders;Lorg/springframework/util/MultiValueMap;Ljava/lang/Class;)V
    .locals 0
    .param p1, "serviceUri"    # Ljava/net/URI;
    .param p2, "method"    # Lorg/springframework/http/HttpMethod;
    .param p3, "headers"    # Lorg/springframework/http/HttpHeaders;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Lorg/springframework/http/HttpMethod;",
            "Lorg/springframework/http/HttpHeaders;",
            "Lorg/springframework/util/MultiValueMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/Class",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    .local p4, "postParams":Lorg/springframework/util/MultiValueMap;, "Lorg/springframework/util/MultiValueMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p5, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p5, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->clazz:Ljava/lang/Class;

    .line 23
    invoke-virtual {p0, p4}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->setPostParams(Lorg/springframework/util/MultiValueMap;)V

    .line 24
    invoke-virtual {p0, p3}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->setHeaders(Lorg/springframework/http/HttpHeaders;)V

    .line 25
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->setServiceUri(Ljava/net/URI;)V

    .line 26
    invoke-virtual {p0, p2}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->setHttpMethod(Lorg/springframework/http/HttpMethod;)V

    .line 27
    return-void
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 44
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->headers:Lorg/springframework/http/HttpHeaders;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->headers:Lorg/springframework/http/HttpHeaders;

    invoke-virtual {v0, p1, p2}, Lorg/springframework/http/HttpHeaders;->add(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    :cond_0
    return-void
.end method

.method public createHttpEntity()Lorg/springframework/http/HttpEntity;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lorg/springframework/http/HttpEntity",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 88
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->postParams:Lorg/springframework/util/MultiValueMap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->postParams:Lorg/springframework/util/MultiValueMap;

    invoke-interface {v0}, Lorg/springframework/util/MultiValueMap;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 89
    new-instance v0, Lorg/springframework/http/HttpEntity;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->postParams:Lorg/springframework/util/MultiValueMap;

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->getHeaders()Lorg/springframework/http/HttpHeaders;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/springframework/http/HttpEntity;-><init>(Ljava/lang/Object;Lorg/springframework/util/MultiValueMap;)V

    .line 92
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lorg/springframework/http/HttpEntity;

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->getHeaders()Lorg/springframework/http/HttpHeaders;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/springframework/http/HttpEntity;-><init>(Ljava/lang/Object;Lorg/springframework/util/MultiValueMap;)V

    goto :goto_0
.end method

.method public getHeaders()Lorg/springframework/http/HttpHeaders;
    .locals 1

    .prologue
    .line 50
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->headers:Lorg/springframework/http/HttpHeaders;

    return-object v0
.end method

.method public getHttpMethod()Lorg/springframework/http/HttpMethod;
    .locals 1

    .prologue
    .line 69
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->httpMethod:Lorg/springframework/http/HttpMethod;

    return-object v0
.end method

.method public getResponseType()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 79
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->clazz:Ljava/lang/Class;

    return-object v0
.end method

.method public getServiceUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 59
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->serviceUri:Ljava/net/URI;

    return-object v0
.end method

.method public setHeaders(Lorg/springframework/http/HttpHeaders;)V
    .locals 0
    .param p1, "headers"    # Lorg/springframework/http/HttpHeaders;

    .prologue
    .line 54
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->headers:Lorg/springframework/http/HttpHeaders;

    .line 55
    return-void
.end method

.method public setHttpMethod(Lorg/springframework/http/HttpMethod;)V
    .locals 0
    .param p1, "httpMethod"    # Lorg/springframework/http/HttpMethod;

    .prologue
    .line 74
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->httpMethod:Lorg/springframework/http/HttpMethod;

    .line 75
    return-void
.end method

.method public setPostParams(Lorg/springframework/util/MultiValueMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/springframework/util/MultiValueMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 97
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    .local p1, "postParams":Lorg/springframework/util/MultiValueMap;, "Lorg/springframework/util/MultiValueMap<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->postParams:Lorg/springframework/util/MultiValueMap;

    .line 98
    return-void
.end method

.method public setServiceUri(Ljava/net/URI;)V
    .locals 0
    .param p1, "serviceUri"    # Ljava/net/URI;

    .prologue
    .line 64
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;, "Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest<TT;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;->serviceUri:Ljava/net/URI;

    .line 65
    return-void
.end method
