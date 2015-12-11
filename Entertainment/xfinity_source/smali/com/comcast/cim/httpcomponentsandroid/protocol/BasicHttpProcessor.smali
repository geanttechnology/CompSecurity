.class public final Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
.super Ljava/lang/Object;
.source "BasicHttpProcessor.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;
.implements Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpRequestInterceptorList;
.implements Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpResponseInterceptorList;
.implements Ljava/lang/Cloneable;


# instance fields
.field protected final requestInterceptors:Ljava/util/List;

.field protected final responseInterceptors:Ljava/util/List;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public final addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V
    .locals 0
    .param p1, "interceptor"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .prologue
    .line 101
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addRequestInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 102
    return-void
.end method

.method public final addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V
    .locals 0
    .param p1, "interceptor"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .prologue
    .line 130
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addResponseInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V

    .line 131
    return-void
.end method

.method public addRequestInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V
    .locals 1
    .param p1, "itcp"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .prologue
    .line 58
    if-nez p1, :cond_0

    .line 62
    :goto_0
    return-void

    .line 61
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public addResponseInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V
    .locals 1
    .param p1, "itcp"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .prologue
    .line 123
    if-nez p1, :cond_0

    .line 127
    :goto_0
    return-void

    .line 126
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 240
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    .line 241
    .local v0, "clone":Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->copyInterceptors(Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;)V

    .line 242
    return-object v0
.end method

.method protected copyInterceptors(Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;)V
    .locals 2
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    .prologue
    .line 222
    iget-object v0, p1, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 223
    iget-object v0, p1, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 224
    iget-object v0, p1, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 225
    iget-object v0, p1, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 226
    return-void
.end method

.method public getRequestInterceptor(I)Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 113
    if-ltz p1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_1

    .line 114
    :cond_0
    const/4 v0, 0x0

    .line 115
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    goto :goto_0
.end method

.method public getRequestInterceptorCount()I
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getResponseInterceptor(I)Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 142
    if-ltz p1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_1

    .line 143
    :cond_0
    const/4 v0, 0x0

    .line 144
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    goto :goto_0
.end method

.method public getResponseInterceptorCount()I
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    .line 197
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 198
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .line 200
    .local v1, "interceptor":Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    invoke-interface {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;->process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 197
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 202
    .end local v1    # "interceptor":Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    :cond_0
    return-void
.end method

.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 3
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    .line 208
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 209
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .line 211
    .local v1, "interceptor":Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;
    invoke-interface {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;->process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 208
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 213
    .end local v1    # "interceptor":Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;
    :cond_0
    return-void
.end method

.method public setInterceptors(Ljava/util/List;)V
    .locals 4
    .param p1, "list"    # Ljava/util/List;

    .prologue
    .line 169
    if-nez p1, :cond_0

    .line 170
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "List must not be null."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 172
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->requestInterceptors:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 173
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->responseInterceptors:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 174
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_3

    .line 175
    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    .line 176
    .local v1, "obj":Ljava/lang/Object;
    instance-of v2, v1, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    if-eqz v2, :cond_1

    move-object v2, v1

    .line 177
    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    invoke-virtual {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 179
    :cond_1
    instance-of v2, v1, Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    if-eqz v2, :cond_2

    .line 180
    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .end local v1    # "obj":Ljava/lang/Object;
    invoke-virtual {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V

    .line 174
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 183
    :cond_3
    return-void
.end method
