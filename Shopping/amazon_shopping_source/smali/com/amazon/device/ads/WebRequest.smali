.class abstract Lcom/amazon/device/ads/WebRequest;
.super Ljava/lang/Object;
.source "WebRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/WebRequest$QueryStringParameters;,
        Lcom/amazon/device/ads/WebRequest$WebRequestFactory;,
        Lcom/amazon/device/ads/WebRequest$WebRequestStatus;,
        Lcom/amazon/device/ads/WebRequest$WebRequestException;,
        Lcom/amazon/device/ads/WebRequest$WebResponse;,
        Lcom/amazon/device/ads/WebRequest$HttpMethod;
    }
.end annotation


# static fields
.field private static final CHARSET_KEY:Ljava/lang/String; = "charset"

.field public static final CHARSET_UTF_16:Ljava/lang/String; = "UTF-16"

.field public static final CHARSET_UTF_8:Ljava/lang/String; = "UTF-8"

.field public static final CONTENT_TYPE_CSS:Ljava/lang/String; = "text/css"

.field public static final CONTENT_TYPE_HTML:Ljava/lang/String; = "text/html"

.field public static final CONTENT_TYPE_JAVASCRIPT:Ljava/lang/String; = "application/javascript"

.field public static final CONTENT_TYPE_JSON:Ljava/lang/String; = "application/json"

.field public static final CONTENT_TYPE_PLAIN_TEXT:Ljava/lang/String; = "text/plain"

.field public static final DEFAULT_PORT:I = -0x1

.field public static final DEFAULT_TIMEOUT:I = 0x4e20

.field private static final HEADER_ACCEPT_KEY:Ljava/lang/String; = "Accept"

.field private static final HEADER_CONTENT_TYPE:Ljava/lang/String; = "Content-Type"

.field private static final LOG_TAG:Ljava/lang/String;

.field private static webRequestFactory:Lcom/amazon/device/ads/WebRequest$WebRequestFactory;


# instance fields
.field acceptContentType:Ljava/lang/String;

.field charset:Ljava/lang/String;

.field contentType:Ljava/lang/String;

.field protected final headers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private httpMethod:Lcom/amazon/device/ads/WebRequest$HttpMethod;

.field logRequestBodyEnabled:Z

.field logResponseEnabled:Z

.field private logTag:Ljava/lang/String;

.field protected logUrlEnabled:Z

.field private metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

.field private nonSecureHost:Ljava/lang/String;

.field private path:Ljava/lang/String;

.field private port:I

.field protected postParameters:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected queryStringParameters:Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

.field requestBody:Ljava/lang/String;

.field protected secure:Z

.field private secureHost:Ljava/lang/String;

.field protected serviceCallLatencyMetric:Lcom/amazon/device/ads/Metrics$MetricType;

.field private timeout:I

.field private urlString:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    const-class v0, Lcom/amazon/device/ads/WebRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;

    .line 83
    new-instance v0, Lcom/amazon/device/ads/WebRequest$WebRequestFactory;

    invoke-direct {v0}, Lcom/amazon/device/ads/WebRequest$WebRequestFactory;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/WebRequest;->webRequestFactory:Lcom/amazon/device/ads/WebRequest$WebRequestFactory;

    return-void
.end method

.method protected constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x0

    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->requestBody:Ljava/lang/String;

    .line 59
    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->acceptContentType:Ljava/lang/String;

    .line 60
    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->contentType:Ljava/lang/String;

    .line 61
    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->charset:Ljava/lang/String;

    .line 63
    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->urlString:Ljava/lang/String;

    .line 64
    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->secureHost:Ljava/lang/String;

    .line 65
    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->nonSecureHost:Ljava/lang/String;

    .line 66
    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->path:Ljava/lang/String;

    .line 67
    const/4 v1, -0x1

    iput v1, p0, Lcom/amazon/device/ads/WebRequest;->port:I

    .line 68
    sget-object v1, Lcom/amazon/device/ads/WebRequest$HttpMethod;->GET:Lcom/amazon/device/ads/WebRequest$HttpMethod;

    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->httpMethod:Lcom/amazon/device/ads/WebRequest$HttpMethod;

    .line 69
    const/16 v1, 0x4e20

    iput v1, p0, Lcom/amazon/device/ads/WebRequest;->timeout:I

    .line 75
    iput-boolean v3, p0, Lcom/amazon/device/ads/WebRequest;->logRequestBodyEnabled:Z

    .line 76
    iput-boolean v3, p0, Lcom/amazon/device/ads/WebRequest;->logResponseEnabled:Z

    .line 78
    iput-boolean v3, p0, Lcom/amazon/device/ads/WebRequest;->logUrlEnabled:Z

    .line 79
    iput-boolean v3, p0, Lcom/amazon/device/ads/WebRequest;->secure:Z

    .line 80
    sget-object v1, Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;

    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->logTag:Ljava/lang/String;

    .line 90
    new-instance v1, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    invoke-direct {v1}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;-><init>()V

    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->queryStringParameters:Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    .line 91
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->headers:Ljava/util/HashMap;

    .line 92
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/amazon/device/ads/WebRequest;->postParameters:Ljava/util/HashMap;

    .line 93
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v1

    const-string/jumbo v2, "tlsEnabled"

    invoke-virtual {v1, v2, v3}, Lcom/amazon/device/ads/Settings;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 94
    .local v0, "tlsEnabled":Z
    const-string/jumbo v1, "debug.tlsEnabled"

    invoke-static {v1, v0}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/amazon/device/ads/WebRequest;->secure:Z

    .line 95
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static final createJSONGetWebRequest()Lcom/amazon/device/ads/WebRequest;
    .locals 3

    .prologue
    .line 116
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->createNewWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    .line 117
    .local v0, "request":Lcom/amazon/device/ads/WebRequest;
    sget-object v1, Lcom/amazon/device/ads/WebRequest$HttpMethod;->GET:Lcom/amazon/device/ads/WebRequest$HttpMethod;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setHttpMethod(Lcom/amazon/device/ads/WebRequest$HttpMethod;)V

    .line 118
    const-string/jumbo v1, "Accept"

    const-string/jumbo v2, "application/json"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/WebRequest;->putHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    return-object v0
.end method

.method public static final createJSONPostWebRequest()Lcom/amazon/device/ads/WebRequest;
    .locals 1

    .prologue
    .line 127
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->createNewWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    .line 128
    .local v0, "request":Lcom/amazon/device/ads/WebRequest;
    invoke-virtual {v0}, Lcom/amazon/device/ads/WebRequest;->convertToJSONPostRequest()V

    .line 129
    return-object v0
.end method

.method public static final createNewWebRequest()Lcom/amazon/device/ads/WebRequest;
    .locals 1

    .prologue
    .line 103
    sget-object v0, Lcom/amazon/device/ads/WebRequest;->webRequestFactory:Lcom/amazon/device/ads/WebRequest$WebRequestFactory;

    invoke-virtual {v0}, Lcom/amazon/device/ads/WebRequest$WebRequestFactory;->createWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    return-object v0
.end method

.method public static final executeWebRequestInThread(Ljava/lang/String;)V
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 799
    new-instance v0, Lcom/amazon/device/ads/WebRequest$1;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/WebRequest$1;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/amazon/device/ads/ThreadUtils;->executeRunnable(Ljava/lang/Runnable;)V

    .line 816
    return-void
.end method

.method static setWebRequestFactory(Lcom/amazon/device/ads/WebRequest$WebRequestFactory;)V
    .locals 0
    .param p0, "webRequestFactory"    # Lcom/amazon/device/ads/WebRequest$WebRequestFactory;

    .prologue
    .line 108
    sput-object p0, Lcom/amazon/device/ads/WebRequest;->webRequestFactory:Lcom/amazon/device/ads/WebRequest$WebRequestFactory;

    .line 109
    return-void
.end method


# virtual methods
.method protected appendQuery(Ljava/lang/StringBuilder;)V
    .locals 1
    .param p1, "builder"    # Ljava/lang/StringBuilder;

    .prologue
    .line 744
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->queryStringParameters:Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->append(Ljava/lang/StringBuilder;)V

    .line 745
    return-void
.end method

.method public convertToJSONPostRequest()V
    .locals 2

    .prologue
    .line 137
    sget-object v0, Lcom/amazon/device/ads/WebRequest$HttpMethod;->POST:Lcom/amazon/device/ads/WebRequest$HttpMethod;

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/WebRequest;->setHttpMethod(Lcom/amazon/device/ads/WebRequest$HttpMethod;)V

    .line 138
    const-string/jumbo v0, "Accept"

    const-string/jumbo v1, "application/json"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/device/ads/WebRequest;->putHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    const-string/jumbo v0, "Content-Type"

    const-string/jumbo v1, "application/json; charset=UTF-8"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/device/ads/WebRequest;->putHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    return-void
.end method

.method protected createURI(Ljava/lang/String;)Ljava/net/URI;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;,
            Ljava/net/URISyntaxException;
        }
    .end annotation

    .prologue
    .line 724
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/WebRequest;->createURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/WebRequest;->createURI(Ljava/net/URL;)Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method protected createURI(Ljava/net/URL;)Ljava/net/URI;
    .locals 1
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/URISyntaxException;
        }
    .end annotation

    .prologue
    .line 729
    invoke-virtual {p1}, Ljava/net/URL;->toURI()Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method protected createURL(Ljava/lang/String;)Ljava/net/URL;
    .locals 1
    .param p1, "urlString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 734
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method protected createUri()Ljava/net/URI;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/URISyntaxException;,
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 719
    new-instance v0, Ljava/net/URL;

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getUrlString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/URL;->toURI()Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method protected abstract doHttpNetworkCall(Ljava/net/URL;)Lcom/amazon/device/ads/WebRequest$WebResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation
.end method

.method public enableLog(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 222
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/WebRequest;->enableLogUrl(Z)V

    .line 223
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/WebRequest;->enableLogRequestBody(Z)V

    .line 224
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/WebRequest;->enableLogResponse(Z)V

    .line 225
    return-void
.end method

.method public enableLogRequestBody(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 206
    iput-boolean p1, p0, Lcom/amazon/device/ads/WebRequest;->logRequestBodyEnabled:Z

    .line 207
    return-void
.end method

.method public enableLogResponse(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 214
    iput-boolean p1, p0, Lcom/amazon/device/ads/WebRequest;->logResponseEnabled:Z

    .line 215
    return-void
.end method

.method public enableLogUrl(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 198
    iput-boolean p1, p0, Lcom/amazon/device/ads/WebRequest;->logUrlEnabled:Z

    .line 199
    return-void
.end method

.method public getAcceptContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 561
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->acceptContentType:Ljava/lang/String;

    return-object v0
.end method

.method public getCharset()Ljava/lang/String;
    .locals 1

    .prologue
    .line 596
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->charset:Ljava/lang/String;

    return-object v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 578
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->contentType:Ljava/lang/String;

    return-object v0
.end method

.method public getHeader(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 329
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 331
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The name must not be null or empty string."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 333
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->headers:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 381
    iget-boolean v0, p0, Lcom/amazon/device/ads/WebRequest;->secure:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->secureHost:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->nonSecureHost:Ljava/lang/String;

    goto :goto_0
.end method

.method public getHttpMethod()Lcom/amazon/device/ads/WebRequest$HttpMethod;
    .locals 1

    .prologue
    .line 358
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->httpMethod:Lcom/amazon/device/ads/WebRequest$HttpMethod;

    return-object v0
.end method

.method protected getLogTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 662
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->logTag:Ljava/lang/String;

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 452
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getPort()I
    .locals 1

    .prologue
    .line 435
    iget v0, p0, Lcom/amazon/device/ads/WebRequest;->port:I

    return v0
.end method

.method public getPostParameter(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 291
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 293
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The name must not be null or empty string."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 295
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->postParameters:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 247
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->queryStringParameters:Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRequestBody()Ljava/lang/String;
    .locals 5

    .prologue
    .line 531
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getRequestBodyString()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 533
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getRequestBodyString()Ljava/lang/String;

    move-result-object v3

    .line 544
    :goto_0
    return-object v3

    .line 535
    :cond_0
    iget-object v3, p0, Lcom/amazon/device/ads/WebRequest;->postParameters:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 537
    const/4 v3, 0x0

    goto :goto_0

    .line 539
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 540
    .local v0, "builder":Ljava/lang/StringBuilder;
    iget-object v3, p0, Lcom/amazon/device/ads/WebRequest;->postParameters:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 542
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0x3d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ";\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 544
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public getRequestBodyString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 522
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->requestBody:Ljava/lang/String;

    return-object v0
.end method

.method protected getScheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 753
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getUseSecure()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 755
    const-string/jumbo v0, "https"

    .line 759
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "http"

    goto :goto_0
.end method

.method protected abstract getSubLogTag()Ljava/lang/String;
.end method

.method public getTimeout()I
    .locals 1

    .prologue
    .line 605
    iget v0, p0, Lcom/amazon/device/ads/WebRequest;->timeout:I

    return v0
.end method

.method protected getUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 774
    iget-object v1, p0, Lcom/amazon/device/ads/WebRequest;->urlString:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 776
    iget-object v1, p0, Lcom/amazon/device/ads/WebRequest;->urlString:Ljava/lang/String;

    .line 789
    :goto_0
    return-object v1

    .line 779
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getScheme()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 780
    .local v0, "builder":Ljava/lang/StringBuilder;
    const-string/jumbo v1, "://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 781
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 782
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getPort()I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_1

    .line 784
    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 785
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getPort()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 787
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 788
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/WebRequest;->appendQuery(Ljava/lang/StringBuilder;)V

    .line 789
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getUrlString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 504
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->urlString:Ljava/lang/String;

    return-object v0
.end method

.method public getUseSecure()Z
    .locals 1

    .prologue
    .line 470
    iget-boolean v0, p0, Lcom/amazon/device/ads/WebRequest;->secure:Z

    return v0
.end method

.method protected logUrl(Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 233
    iget-boolean v0, p0, Lcom/amazon/device/ads/WebRequest;->logUrlEnabled:Z

    if-eqz v0, :cond_0

    .line 235
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getLogTag()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "%s %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getHttpMethod()Lcom/amazon/device/ads/WebRequest$HttpMethod;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 237
    :cond_0
    return-void
.end method

.method public makeCall()Lcom/amazon/device/ads/WebRequest$WebResponse;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    .line 151
    invoke-static {}, Lcom/amazon/device/ads/ThreadUtils;->isOnMainThread()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 153
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest;->logTag:Ljava/lang/String;

    const-string/jumbo v5, "The network request should not be performed on the main thread."

    invoke-static {v4, v5}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->setContentTypeHeaders()V

    .line 157
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v3

    .line 161
    .local v3, "urlString":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/WebRequest;->createURL(Ljava/lang/String;)Ljava/net/URL;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 169
    .local v2, "url":Ljava/net/URL;
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest;->serviceCallLatencyMetric:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/WebRequest;->writeMetricStart(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 173
    :try_start_1
    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/WebRequest;->doHttpNetworkCall(Ljava/net/URL;)Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_1
    .catch Lcom/amazon/device/ads/WebRequest$WebRequestException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v1

    .line 181
    .local v1, "response":Lcom/amazon/device/ads/WebRequest$WebResponse;
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest;->serviceCallLatencyMetric:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {p0, v4}, Lcom/amazon/device/ads/WebRequest;->writeMetricStop(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 183
    return-object v1

    .line 163
    .end local v1    # "response":Lcom/amazon/device/ads/WebRequest$WebResponse;
    .end local v2    # "url":Ljava/net/URL;
    :catch_0
    move-exception v0

    .line 165
    .local v0, "e":Ljava/net/MalformedURLException;
    iget-object v4, p0, Lcom/amazon/device/ads/WebRequest;->logTag:Ljava/lang/String;

    const-string/jumbo v5, "Problem with URI syntax: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v0}, Ljava/net/MalformedURLException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 166
    new-instance v4, Lcom/amazon/device/ads/WebRequest$WebRequestException;

    sget-object v5, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->MALFORMED_URL:Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Could not construct URL from String "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, p0, v5, v6, v0}, Lcom/amazon/device/ads/WebRequest$WebRequestException;-><init>(Lcom/amazon/device/ads/WebRequest;Lcom/amazon/device/ads/WebRequest$WebRequestStatus;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4

    .line 175
    .end local v0    # "e":Ljava/net/MalformedURLException;
    .restart local v2    # "url":Ljava/net/URL;
    :catch_1
    move-exception v0

    .line 177
    .local v0, "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    :try_start_2
    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 181
    .end local v0    # "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    :catchall_0
    move-exception v4

    iget-object v5, p0, Lcom/amazon/device/ads/WebRequest;->serviceCallLatencyMetric:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {p0, v5}, Lcom/amazon/device/ads/WebRequest;->writeMetricStop(Lcom/amazon/device/ads/Metrics$MetricType;)V

    throw v4
.end method

.method public putHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 345
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 347
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The name must not be null or empty string."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 349
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->headers:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 350
    return-void
.end method

.method public putPostParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 307
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 309
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The name must not be null or empty string."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 311
    :cond_0
    if-nez p2, :cond_1

    .line 313
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->postParameters:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 319
    :goto_0
    return-void

    .line 317
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->postParameters:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 274
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->queryStringParameters:Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUnencoded(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 260
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->queryStringParameters:Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    return-void
.end method

.method public setAcceptContentType(Ljava/lang/String;)V
    .locals 1
    .param p1, "acceptContentType"    # Ljava/lang/String;

    .prologue
    .line 553
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->contentType:Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/device/ads/WebRequest;->acceptContentType:Ljava/lang/String;

    .line 554
    return-void
.end method

.method public setAdditionalQueryParamsString(Ljava/lang/String;)V
    .locals 1
    .param p1, "paramsString"    # Ljava/lang/String;

    .prologue
    .line 641
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->queryStringParameters:Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->setRawAppendage(Ljava/lang/String;)V

    .line 642
    return-void
.end method

.method public setCharset(Ljava/lang/String;)V
    .locals 0
    .param p1, "charset"    # Ljava/lang/String;

    .prologue
    .line 587
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->charset:Ljava/lang/String;

    .line 588
    return-void
.end method

.method public setContentType(Ljava/lang/String;)V
    .locals 0
    .param p1, "contentType"    # Ljava/lang/String;

    .prologue
    .line 570
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->contentType:Ljava/lang/String;

    .line 571
    return-void
.end method

.method protected setContentTypeHeaders()V
    .locals 3

    .prologue
    .line 669
    iget-object v1, p0, Lcom/amazon/device/ads/WebRequest;->acceptContentType:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 671
    const-string/jumbo v1, "Accept"

    iget-object v2, p0, Lcom/amazon/device/ads/WebRequest;->contentType:Ljava/lang/String;

    invoke-virtual {p0, v1, v2}, Lcom/amazon/device/ads/WebRequest;->putHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 673
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/ads/WebRequest;->contentType:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 675
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->contentType:Ljava/lang/String;

    .line 676
    .local v0, "contentType":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/device/ads/WebRequest;->charset:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 678
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "; charset="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/WebRequest;->charset:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 680
    :cond_1
    const-string/jumbo v1, "Content-Type"

    invoke-virtual {p0, v1, v0}, Lcom/amazon/device/ads/WebRequest;->putHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 682
    .end local v0    # "contentType":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public setExternalLogTag(Ljava/lang/String;)V
    .locals 2
    .param p1, "externalLogTag"    # Ljava/lang/String;

    .prologue
    .line 650
    if-nez p1, :cond_0

    .line 652
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getSubLogTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/WebRequest;->logTag:Ljava/lang/String;

    .line 658
    :goto_0
    return-void

    .line 656
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/amazon/device/ads/WebRequest;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getSubLogTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/WebRequest;->logTag:Ljava/lang/String;

    goto :goto_0
.end method

.method public setHost(Ljava/lang/String;)V
    .locals 2
    .param p1, "host"    # Ljava/lang/String;

    .prologue
    .line 392
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 394
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The host must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 396
    :cond_0
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->secureHost:Ljava/lang/String;

    .line 397
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->nonSecureHost:Ljava/lang/String;

    .line 398
    return-void
.end method

.method public setHttpMethod(Lcom/amazon/device/ads/WebRequest$HttpMethod;)V
    .locals 2
    .param p1, "httpMethod"    # Lcom/amazon/device/ads/WebRequest$HttpMethod;

    .prologue
    .line 368
    if-nez p1, :cond_0

    .line 370
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The httpMethod must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 372
    :cond_0
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->httpMethod:Lcom/amazon/device/ads/WebRequest$HttpMethod;

    .line 373
    return-void
.end method

.method public setMetricsCollector(Lcom/amazon/device/ads/MetricsCollector;)V
    .locals 0
    .param p1, "metricsCollector"    # Lcom/amazon/device/ads/MetricsCollector;

    .prologue
    .line 623
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    .line 624
    return-void
.end method

.method public setNonSecureHost(Ljava/lang/String;)V
    .locals 2
    .param p1, "nonSecureHost"    # Ljava/lang/String;

    .prologue
    .line 423
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 425
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The host must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 427
    :cond_0
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->nonSecureHost:Ljava/lang/String;

    .line 428
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 461
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->path:Ljava/lang/String;

    .line 462
    return-void
.end method

.method public setPort(I)V
    .locals 0
    .param p1, "port"    # I

    .prologue
    .line 443
    iput p1, p0, Lcom/amazon/device/ads/WebRequest;->port:I

    .line 444
    return-void
.end method

.method public setQueryStringParameters(Lcom/amazon/device/ads/WebRequest$QueryStringParameters;)V
    .locals 0
    .param p1, "queryStringParameters"    # Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    .prologue
    .line 280
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->queryStringParameters:Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    .line 281
    return-void
.end method

.method public setRequestBodyString(Ljava/lang/String;)V
    .locals 0
    .param p1, "requestBody"    # Ljava/lang/String;

    .prologue
    .line 514
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->requestBody:Ljava/lang/String;

    .line 515
    return-void
.end method

.method public setSecureHost(Ljava/lang/String;)V
    .locals 2
    .param p1, "secureHost"    # Ljava/lang/String;

    .prologue
    .line 408
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 410
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The host must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 412
    :cond_0
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->secureHost:Ljava/lang/String;

    .line 413
    return-void
.end method

.method public setServiceCallLatencyMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V
    .locals 0
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;

    .prologue
    .line 632
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->serviceCallLatencyMetric:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 633
    return-void
.end method

.method public setTimeout(I)V
    .locals 0
    .param p1, "timeout"    # I

    .prologue
    .line 613
    iput p1, p0, Lcom/amazon/device/ads/WebRequest;->timeout:I

    .line 614
    return-void
.end method

.method public setUrlString(Ljava/lang/String;)V
    .locals 2
    .param p1, "urlString"    # Ljava/lang/String;

    .prologue
    .line 491
    if-eqz p1, :cond_0

    iget-boolean v0, p0, Lcom/amazon/device/ads/WebRequest;->secure:Z

    if-eqz v0, :cond_0

    const-string/jumbo v0, "http:"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 493
    const-string/jumbo v0, "http"

    const-string/jumbo v1, "https"

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 495
    :cond_0
    iput-object p1, p0, Lcom/amazon/device/ads/WebRequest;->urlString:Ljava/lang/String;

    .line 496
    return-void
.end method

.method public setUseSecure(Z)V
    .locals 0
    .param p1, "secure"    # Z

    .prologue
    .line 478
    iput-boolean p1, p0, Lcom/amazon/device/ads/WebRequest;->secure:Z

    .line 479
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 769
    invoke-virtual {p0}, Lcom/amazon/device/ads/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected writeMetricStart(Lcom/amazon/device/ads/Metrics$MetricType;)V
    .locals 1
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;

    .prologue
    .line 690
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    if-eqz v0, :cond_0

    .line 692
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/MetricsCollector;->startMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 694
    :cond_0
    return-void
.end method

.method protected writeMetricStop(Lcom/amazon/device/ads/Metrics$MetricType;)V
    .locals 1
    .param p1, "metric"    # Lcom/amazon/device/ads/Metrics$MetricType;

    .prologue
    .line 702
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    if-eqz v0, :cond_0

    .line 704
    iget-object v0, p0, Lcom/amazon/device/ads/WebRequest;->metricsCollector:Lcom/amazon/device/ads/MetricsCollector;

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/MetricsCollector;->stopMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 706
    :cond_0
    return-void
.end method
