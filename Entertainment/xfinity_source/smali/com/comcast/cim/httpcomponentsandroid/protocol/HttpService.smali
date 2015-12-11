.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpService;
.super Ljava/lang/Object;
.source "HttpService.java"


# instance fields
.field private volatile connStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

.field private volatile expectationVerifier:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpExpectationVerifier;

.field private volatile handlerResolver:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestHandlerResolver;

.field private volatile params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

.field private volatile processor:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

.field private volatile responseFactory:Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;


# virtual methods
.method public getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpService;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    return-object v0
.end method

.method public setConnReuseStrategy(Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;)V
    .locals 2
    .param p1, "connStrategy"    # Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    .prologue
    .line 177
    if-nez p1, :cond_0

    .line 178
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Connection reuse strategy may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 180
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpService;->connStrategy:Lcom/comcast/cim/httpcomponentsandroid/ConnectionReuseStrategy;

    .line 181
    return-void
.end method

.method public setExpectationVerifier(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpExpectationVerifier;)V
    .locals 0
    .param p1, "expectationVerifier"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpExpectationVerifier;

    .prologue
    .line 211
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpService;->expectationVerifier:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpExpectationVerifier;

    .line 212
    return-void
.end method

.method public setHandlerResolver(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestHandlerResolver;)V
    .locals 0
    .param p1, "handlerResolver"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestHandlerResolver;

    .prologue
    .line 204
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpService;->handlerResolver:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestHandlerResolver;

    .line 205
    return-void
.end method

.method public setHttpProcessor(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;)V
    .locals 2
    .param p1, "processor"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

    .prologue
    .line 167
    if-nez p1, :cond_0

    .line 168
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP processor may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 170
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpService;->processor:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;

    .line 171
    return-void
.end method

.method public setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 0
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 197
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpService;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 198
    return-void
.end method

.method public setResponseFactory(Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;)V
    .locals 2
    .param p1, "responseFactory"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;

    .prologue
    .line 187
    if-nez p1, :cond_0

    .line 188
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Response factory may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 190
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpService;->responseFactory:Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;

    .line 191
    return-void
.end method
