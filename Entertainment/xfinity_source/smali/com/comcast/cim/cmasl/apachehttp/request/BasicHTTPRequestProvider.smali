.class public Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;
.super Ljava/lang/Object;
.source "BasicHTTPRequestProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
        ">;"
    }
.end annotation


# instance fields
.field private final headers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private final httpEntityParams:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private method:Ljava/lang/String;

.field private final queryParams:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private socketTimeoutInMillis:Ljava/lang/Long;

.field private uri:Ljava/net/URI;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "urlString"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-static {p1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;-><init>(Ljava/net/URI;)V

    .line 48
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "urlString"    # Ljava/lang/String;
    .param p2, "method"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-static {p1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;-><init>(Ljava/net/URI;Ljava/lang/String;)V

    .line 52
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;)V
    .locals 1
    .param p1, "uri"    # Ljava/net/URI;

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;-><init>(Ljava/net/URI;Ljava/lang/String;)V

    .line 39
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;Ljava/lang/String;)V
    .locals 2
    .param p1, "uri"    # Ljava/net/URI;
    .param p2, "method"    # Ljava/lang/String;

    .prologue
    const/16 v1, 0xa

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->queryParams:Ljava/util/List;

    .line 33
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->httpEntityParams:Ljava/util/List;

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->headers:Ljava/util/List;

    .line 42
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    .line 43
    if-nez p2, :cond_0

    const-string p2, "GET"

    .end local p2    # "method":Ljava/lang/String;
    :cond_0
    iput-object p2, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->method:Ljava/lang/String;

    .line 44
    return-void
.end method

.method private addEntityParamsToRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;Ljava/util/List;)V
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 124
    .local p2, "params":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    :try_start_0
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/entity/UrlEncodedFormEntity;

    const-string v2, "UTF-8"

    invoke-direct {v1, p2, v2}, Lcom/comcast/cim/httpcomponentsandroid/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 128
    return-void

    .line 125
    :catch_0
    move-exception v0

    .line 126
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 110
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->headers:Ljava/util/List;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;

    invoke-direct {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 111
    return-void
.end method

.method public addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->httpEntityParams:Ljava/util/List;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;

    invoke-direct {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 106
    return-void
.end method

.method public addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 100
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->queryParams:Ljava/util/List;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;

    invoke-direct {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 101
    return-void
.end method

.method public createRequest()Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .locals 14

    .prologue
    .line 57
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 58
    .local v6, "combinedGetParams":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    const-string v1, "UTF-8"

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;->parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v6, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 59
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->queryParams:Ljava/util/List;

    invoke-interface {v6, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 61
    :try_start_0
    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v4, 0x0

    .line 62
    .local v4, "query":Ljava/lang/String;
    :goto_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-virtual {v0}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-virtual {v1}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-virtual {v2}, Ljava/net/URI;->getPort()I

    move-result v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-virtual {v3}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v3

    iget-object v5, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-virtual {v5}, Ljava/net/URI;->getFragment()Ljava/lang/String;

    move-result-object v5

    invoke-static/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URIUtils;->createURI(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->method:Ljava/lang/String;

    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 69
    new-instance v11, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;

    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-direct {v11, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;-><init>(Ljava/net/URI;)V

    .line 70
    .local v11, "postRequest":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->httpEntityParams:Ljava/util/List;

    invoke-direct {p0, v11, v0}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->addEntityParamsToRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;Ljava/util/List;)V

    .line 71
    invoke-virtual {p0, v11}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->onHttpEntityEnclosingRequestCreated(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V

    .line 72
    move-object v13, v11

    .line 84
    .end local v11    # "postRequest":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;
    .local v13, "request":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    :goto_1
    invoke-interface {v13}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v10

    .line 85
    .local v10, "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    const-string v0, "http.protocol.expect-continue"

    const/4 v1, 0x0

    invoke-interface {v10, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 87
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->socketTimeoutInMillis:Ljava/lang/Long;

    if-eqz v0, :cond_0

    .line 88
    invoke-interface {v13}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->socketTimeoutInMillis:Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->intValue()I

    move-result v1

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setSoTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 91
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->headers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    .line 92
    .local v8, "header":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v13, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 61
    .end local v4    # "query":Ljava/lang/String;
    .end local v8    # "header":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v10    # "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .end local v13    # "request":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    :cond_1
    :try_start_1
    const-string v0, "UTF-8"

    invoke-static {v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;->format(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v4

    goto :goto_0

    .line 63
    :catch_0
    move-exception v7

    .line 64
    .local v7, "e":Ljava/net/URISyntaxException;
    new-instance v0, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v0, v7}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    .line 73
    .end local v7    # "e":Ljava/net/URISyntaxException;
    .restart local v4    # "query":Ljava/lang/String;
    :cond_2
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->method:Ljava/lang/String;

    const-string v1, "PUT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 74
    new-instance v12, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPut;

    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-direct {v12, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPut;-><init>(Ljava/net/URI;)V

    .line 75
    .local v12, "putRequest":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPut;
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->httpEntityParams:Ljava/util/List;

    invoke-direct {p0, v12, v0}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->addEntityParamsToRequest(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;Ljava/util/List;)V

    .line 76
    invoke-virtual {p0, v12}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->onHttpEntityEnclosingRequestCreated(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V

    .line 77
    move-object v13, v12

    .line 78
    .restart local v13    # "request":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    goto :goto_1

    .end local v12    # "putRequest":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPut;
    .end local v13    # "request":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    :cond_3
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->method:Ljava/lang/String;

    const-string v1, "DELETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 79
    new-instance v13, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpDelete;

    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-direct {v13, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpDelete;-><init>(Ljava/net/URI;)V

    .restart local v13    # "request":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    goto :goto_1

    .line 81
    .end local v13    # "request":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    :cond_4
    new-instance v13, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;

    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->uri:Ljava/net/URI;

    invoke-direct {v13, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpGet;-><init>(Ljava/net/URI;)V

    .restart local v13    # "request":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    goto :goto_1

    .line 95
    .restart local v9    # "i$":Ljava/util/Iterator;
    .restart local v10    # "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    :cond_5
    return-object v13
.end method

.method public bridge synthetic createRequest()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->createRequest()Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    move-result-object v0

    return-object v0
.end method

.method protected onHttpEntityEnclosingRequestCreated(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V
    .locals 0
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    .prologue
    .line 120
    return-void
.end method

.method public setSocketTimeout(J)V
    .locals 1
    .param p1, "timeoutInMillis"    # J

    .prologue
    .line 115
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/request/BasicHTTPRequestProvider;->socketTimeoutInMillis:Ljava/lang/Long;

    .line 116
    return-void
.end method
