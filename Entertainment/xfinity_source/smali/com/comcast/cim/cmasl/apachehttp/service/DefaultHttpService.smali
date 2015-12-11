.class public Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;
.super Ljava/lang/Object;
.source "DefaultHttpService.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/service/HttpService;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<RP::",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
        ">;>",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/service/HttpService",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
        "TRP;>;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 0
    .param p1, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 33
    .local p0, "this":Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;, "Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService<TRP;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 35
    return-void
.end method

.method private convertHeadersToMap([Lcom/comcast/cim/httpcomponentsandroid/Header;)Ljava/util/Map;
    .locals 7
    .param p1, "headers"    # [Lcom/comcast/cim/httpcomponentsandroid/Header;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 82
    .local p0, "this":Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;, "Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService<TRP;>;"
    new-instance v2, Ljava/util/HashMap;

    array-length v5, p1

    invoke-direct {v2, v5}, Ljava/util/HashMap;-><init>(I)V

    .line 83
    .local v2, "headerMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    move-object v0, p1

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v1, v0, v3

    .line 84
    .local v1, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 87
    .end local v1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_0
    return-object v2
.end method


# virtual methods
.method public executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<RS::",
            "Lcom/comcast/cim/cmasl/http/response/ResponseHandler;",
            ">(TRP;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<TRS;>;)TRS;"
        }
    .end annotation

    .prologue
    .line 39
    .local p0, "this":Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;, "Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService<TRP;>;"
    .local p1, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "TRP;"
    .local p2, "responseHandlerProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<TRS;>;"
    invoke-interface {p2}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    .line 41
    .local v8, "responseHandler":Lcom/comcast/cim/cmasl/http/response/ResponseHandler;, "TRS;"
    invoke-interface {p1}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->createRequest()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    .line 42
    .local v7, "req":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;-><init>()V

    .line 44
    .local v0, "context":Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    const/4 v4, 0x0

    .line 47
    .local v4, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    :try_start_0
    iget-object v10, p0, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-interface {v10, v7, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;->execute(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    move-result-object v6

    .line 48
    .local v6, "httpResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v4

    .line 51
    const-string v10, "http.request"

    invoke-interface {v0, v10}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    .line 52
    .local v5, "finalReq":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    const-string v10, "http.target_host"

    invoke-interface {v0, v10}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 54
    .local v1, "currentHost":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v10

    invoke-virtual {v10}, Ljava/net/URI;->isAbsolute()Z

    move-result v10

    if-eqz v10, :cond_1

    .line 55
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v10

    invoke-virtual {v10}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v9

    .line 60
    .local v9, "url":Ljava/lang/String;
    :goto_0
    new-instance v2, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v10

    invoke-interface {v10}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v10

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v11

    invoke-interface {v11}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v2, v10, v11}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;-><init>(Ljava/lang/Integer;Ljava/lang/String;)V

    .line 61
    .local v2, "detailedRequestStatus":Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v10

    invoke-direct {p0, v10}, Lcom/comcast/cim/cmasl/apachehttp/service/DefaultHttpService;->convertHeadersToMap([Lcom/comcast/cim/httpcomponentsandroid/Header;)Ljava/util/Map;

    move-result-object v10

    invoke-interface {v8, v9, v2, v10}, Lcom/comcast/cim/cmasl/http/response/ResponseHandler;->handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V

    .line 64
    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v10

    invoke-interface {v10}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v10

    const/16 v11, 0xcc

    if-eq v10, v11, :cond_0

    .line 65
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 66
    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v10

    invoke-interface {v8, v10}, Lcom/comcast/cim/cmasl/http/response/ResponseHandler;->handleResponseBody(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 73
    :cond_0
    :try_start_1
    invoke-static {v4}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 78
    :goto_1
    return-object v8

    .line 57
    .end local v2    # "detailedRequestStatus":Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .end local v9    # "url":Ljava/lang/String;
    :cond_1
    :try_start_2
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->toURI()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v9

    .restart local v9    # "url":Ljava/lang/String;
    goto :goto_0

    .line 69
    .end local v1    # "currentHost":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .end local v5    # "finalReq":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .end local v6    # "httpResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .end local v9    # "url":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 70
    .local v3, "e":Ljava/io/IOException;
    :try_start_3
    new-instance v10, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v10, v3}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v10
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 72
    .end local v3    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v10

    .line 73
    :try_start_4
    invoke-static {v4}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 75
    :goto_2
    throw v10

    .line 74
    .restart local v1    # "currentHost":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .restart local v2    # "detailedRequestStatus":Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .restart local v5    # "finalReq":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .restart local v6    # "httpResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .restart local v9    # "url":Ljava/lang/String;
    :catch_1
    move-exception v10

    goto :goto_1

    .end local v1    # "currentHost":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .end local v2    # "detailedRequestStatus":Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .end local v5    # "finalReq":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    .end local v6    # "httpResponse":Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .end local v9    # "url":Ljava/lang/String;
    :catch_2
    move-exception v11

    goto :goto_2
.end method
