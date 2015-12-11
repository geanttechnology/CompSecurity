.class public Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;
.super Ljava/lang/Object;
.source "DecompressingHttpClient.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# instance fields
.field private acceptEncodingInterceptor:Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

.field private backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private contentEncodingInterceptor:Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 2
    .param p1, "backend"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 96
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestAcceptEncoding;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestAcceptEncoding;-><init>()V

    new-instance v1, Lcom/comcast/cim/cmasl/apachehttp/ResponseContentEncoding;

    invoke-direct {v1}, Lcom/comcast/cim/cmasl/apachehttp/ResponseContentEncoding;-><init>()V

    invoke-direct {p0, p1, v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V

    .line 97
    return-void
.end method

.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V
    .locals 0
    .param p1, "backend"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p2, "requestInterceptor"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    .param p3, "responseInterceptor"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .prologue
    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 100
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 101
    iput-object p2, p0, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->acceptEncodingInterceptor:Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .line 102
    iput-object p3, p0, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->contentEncodingInterceptor:Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .line 103
    return-void
.end method


# virtual methods
.method public execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 7
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 132
    if-nez p3, :cond_0

    .line 133
    :try_start_0
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;-><init>()V

    .end local p3    # "context":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .local v0, "context":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    move-object p3, v0

    .line 136
    .end local v0    # "context":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .restart local p3    # "context":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    :cond_0
    instance-of v5, p2, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v5, :cond_2

    .line 137
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;

    check-cast p2, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    .end local p2    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    invoke-direct {v4, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V

    .line 141
    .local v4, "wrapped":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :goto_0
    iget-object v5, p0, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->acceptEncodingInterceptor:Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    invoke-interface {v5, v4, p3}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;->process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 142
    iget-object v5, p0, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v5, p1, v4, p3}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :try_end_0
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    .line 144
    .local v3, "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :try_start_1
    iget-object v5, p0, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->contentEncodingInterceptor:Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    invoke-interface {v5, v3, p3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;->process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 145
    sget-object v5, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    const-string v6, "http.client.response.uncompressed"

    invoke-interface {p3, v6}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 146
    const-string v5, "Content-Length"

    invoke-interface {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->removeHeaders(Ljava/lang/String;)V

    .line 147
    const-string v5, "Content-Encoding"

    invoke-interface {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->removeHeaders(Ljava/lang/String;)V

    .line 148
    const-string v5, "Content-MD5"

    invoke-interface {v3, v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->removeHeaders(Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_3

    .line 150
    :cond_1
    return-object v3

    .line 139
    .end local v3    # "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .end local v4    # "wrapped":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .restart local p2    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :cond_2
    :try_start_2
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;

    invoke-direct {v4, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .restart local v4    # "wrapped":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    goto :goto_0

    .line 151
    .end local p2    # "request":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .restart local v3    # "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    :catch_0
    move-exception v2

    .line 152
    .local v2, "ex":Lcom/comcast/cim/httpcomponentsandroid/HttpException;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v5

    invoke-static {v5}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 153
    throw v2
    :try_end_2
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_2 .. :try_end_2} :catch_1

    .line 161
    .end local v2    # "ex":Lcom/comcast/cim/httpcomponentsandroid/HttpException;
    .end local v3    # "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .end local v4    # "wrapped":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :catch_1
    move-exception v1

    .line 162
    .local v1, "e":Lcom/comcast/cim/httpcomponentsandroid/HttpException;
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;

    invoke-direct {v5, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 154
    .end local v1    # "e":Lcom/comcast/cim/httpcomponentsandroid/HttpException;
    .restart local v3    # "response":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .restart local v4    # "wrapped":Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    :catch_2
    move-exception v2

    .line 155
    .local v2, "ex":Ljava/io/IOException;
    :try_start_3
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v5

    invoke-static {v5}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 156
    throw v2

    .line 157
    .end local v2    # "ex":Ljava/io/IOException;
    :catch_3
    move-exception v2

    .line 158
    .local v2, "ex":Ljava/lang/RuntimeException;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v5

    invoke-static {v5}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 159
    throw v2
    :try_end_3
    .catch Lcom/comcast/cim/httpcomponentsandroid/HttpException; {:try_start_3 .. :try_end_3} :catch_1
.end method

.method public execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 114
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->getHttpHost(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v1

    const/4 v0, 0x0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    invoke-virtual {p0, v1, p1, v0}, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 123
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->getHttpHost(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v0

    invoke-virtual {p0, v0, p1, p2}, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->getConnectionManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v0

    return-object v0
.end method

.method getHttpHost(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    .prologue
    .line 118
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    .line 119
    .local v0, "uri":Ljava/net/URI;
    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URIUtils;->extractHost(Ljava/net/URI;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v1

    return-object v1
.end method

.method public getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/client/DecompressingHttpClient;->backend:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v0

    return-object v0
.end method
