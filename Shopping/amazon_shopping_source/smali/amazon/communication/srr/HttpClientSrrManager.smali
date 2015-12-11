.class public Lamazon/communication/srr/HttpClientSrrManager;
.super Ljava/lang/Object;
.source "HttpClientSrrManager.java"

# interfaces
.implements Lamazon/communication/srr/SrrManager;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mHttpClient:Lorg/apache/http/client/HttpClient;

.field private mIdentityResolver:Lamazon/communication/identity/IdentityResolver;

.field private final mRequestSigner:Lamazon/communication/authentication/RequestSigner;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 53
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.HttpClientSrrManager"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lamazon/communication/srr/HttpClientSrrManager;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lorg/apache/http/client/HttpClient;Lamazon/communication/authentication/RequestSigner;)V
    .locals 2
    .param p1, "httpClient"    # Lorg/apache/http/client/HttpClient;
    .param p2, "requestSigner"    # Lamazon/communication/authentication/RequestSigner;

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    if-nez p1, :cond_0

    .line 79
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The HttpClient must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 81
    :cond_0
    if-nez p2, :cond_1

    .line 82
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The RequestSigner must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 84
    :cond_1
    iput-object p1, p0, Lamazon/communication/srr/HttpClientSrrManager;->mHttpClient:Lorg/apache/http/client/HttpClient;

    .line 85
    iput-object p2, p0, Lamazon/communication/srr/HttpClientSrrManager;->mRequestSigner:Lamazon/communication/authentication/RequestSigner;

    .line 86
    return-void
.end method


# virtual methods
.method public makeRequestSync(Lamazon/communication/srr/SrrRequest;)Lorg/apache/http/HttpResponse;
    .locals 23
    .param p1, "srrRequest"    # Lamazon/communication/srr/SrrRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/TimeoutException;,
            Lamazon/communication/RequestFailedException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    .prologue
    .line 119
    if-nez p1, :cond_0

    .line 120
    new-instance v18, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v19, "The SrrRequest cannot be null"

    invoke-direct/range {v18 .. v19}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 123
    :cond_0
    invoke-virtual/range {p1 .. p1}, Lamazon/communication/srr/SrrRequest;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v11

    .line 124
    .local v11, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    if-nez v11, :cond_1

    .line 125
    new-instance v18, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v19, "The SrrRequest must have a MetricEvent"

    invoke-direct/range {v18 .. v19}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 128
    :cond_1
    invoke-virtual/range {p1 .. p1}, Lamazon/communication/srr/SrrRequest;->getTimeout()I

    move-result v12

    .line 129
    .local v12, "requestTimeout":I
    if-gez v12, :cond_2

    .line 130
    new-instance v18, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v19, "The SrrRequest must have a non-negative timeout"

    invoke-direct/range {v18 .. v19}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 131
    :cond_2
    if-nez v12, :cond_3

    .line 133
    const/16 v12, 0x2710

    .line 136
    :cond_3
    invoke-virtual/range {p0 .. p1}, Lamazon/communication/srr/HttpClientSrrManager;->validateConnectivityRequirements(Lamazon/communication/srr/SrrRequest;)V

    .line 138
    invoke-virtual/range {p1 .. p1}, Lamazon/communication/srr/SrrRequest;->getEndpointIdentity()Lamazon/communication/identity/EndpointIdentity;

    move-result-object v3

    .line 139
    .local v3, "destination":Lamazon/communication/identity/EndpointIdentity;
    const/4 v4, 0x0

    .line 141
    .local v4, "destinationHost":Lorg/apache/http/HttpHost;
    :try_start_0
    instance-of v0, v3, Lamazon/communication/identity/UrlEndpointIdentity;

    move/from16 v18, v0

    if-eqz v18, :cond_5

    .line 142
    new-instance v16, Ljava/net/URI;

    invoke-virtual {v3}, Lamazon/communication/identity/EndpointIdentity;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-direct {v0, v1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 143
    .local v16, "uri":Ljava/net/URI;
    new-instance v4, Lorg/apache/http/HttpHost;

    .end local v4    # "destinationHost":Lorg/apache/http/HttpHost;
    invoke-virtual/range {v16 .. v16}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v16 .. v16}, Ljava/net/URI;->getPort()I

    move-result v19

    invoke-virtual/range {v16 .. v16}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v18

    move/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v4, v0, v1, v2}, Lorg/apache/http/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 167
    .end local v16    # "uri":Ljava/net/URI;
    .restart local v4    # "destinationHost":Lorg/apache/http/HttpHost;
    :cond_4
    :goto_0
    if-nez v4, :cond_8

    .line 168
    new-instance v18, Ljava/lang/IllegalArgumentException;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v20, "HttpClientSrrManager only supports UriEndpointIdentity, or ServiceIdentity if IdentityResolver is set. identity: "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-static {v3}, Lamazon/communication/identity/EndpointIdentity;->logSafe(Lamazon/communication/identity/EndpointIdentity;)Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 146
    :cond_5
    :try_start_1
    instance-of v0, v3, Lamazon/communication/identity/ServiceIdentity;

    move/from16 v18, v0

    if-eqz v18, :cond_4

    .line 147
    move-object/from16 v0, p0

    iget-object v0, v0, Lamazon/communication/srr/HttpClientSrrManager;->mIdentityResolver:Lamazon/communication/identity/IdentityResolver;

    move-object/from16 v18, v0

    if-eqz v18, :cond_4

    .line 148
    move-object/from16 v0, p0

    iget-object v0, v0, Lamazon/communication/srr/HttpClientSrrManager;->mIdentityResolver:Lamazon/communication/identity/IdentityResolver;

    move-object/from16 v19, v0

    move-object v0, v3

    check-cast v0, Lamazon/communication/identity/ServiceIdentity;

    move-object/from16 v18, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-interface {v0, v1}, Lamazon/communication/identity/IdentityResolver;->resolveServiceEndpoint(Lamazon/communication/identity/ServiceIdentity;)Lamazon/communication/identity/IRServiceEndpoint;

    move-result-object v10

    .line 150
    .local v10, "irEndpoint":Lamazon/communication/identity/IRServiceEndpoint;
    if-nez v10, :cond_6

    .line 151
    new-instance v18, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v19, "irEndpoint is null"

    invoke-direct/range {v18 .. v19}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v18
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_0

    .line 163
    .end local v4    # "destinationHost":Lorg/apache/http/HttpHost;
    .end local v10    # "irEndpoint":Lamazon/communication/identity/IRServiceEndpoint;
    :catch_0
    move-exception v5

    .line 164
    .local v5, "e":Ljava/net/URISyntaxException;
    new-instance v18, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v19, "Improperly formatted URL"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v18

    .line 154
    .end local v5    # "e":Ljava/net/URISyntaxException;
    .restart local v4    # "destinationHost":Lorg/apache/http/HttpHost;
    .restart local v10    # "irEndpoint":Lamazon/communication/identity/IRServiceEndpoint;
    :cond_6
    :try_start_2
    invoke-virtual/range {p1 .. p1}, Lamazon/communication/srr/SrrRequest;->isClearTextAllowed()Z

    move-result v18

    if-eqz v18, :cond_7

    invoke-interface {v10}, Lamazon/communication/identity/IRServiceEndpoint;->getClearTextConnection()Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    move-result-object v18

    sget-object v19, Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;->ALLOWED:Lamazon/communication/identity/IRServiceEndpoint$ClearTextConnection;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-ne v0, v1, :cond_7

    .line 155
    new-instance v4, Lorg/apache/http/HttpHost;

    .end local v4    # "destinationHost":Lorg/apache/http/HttpHost;
    invoke-interface {v10}, Lamazon/communication/identity/IRServiceEndpoint;->getHostname()Ljava/lang/String;

    move-result-object v18

    invoke-interface {v10}, Lamazon/communication/identity/IRServiceEndpoint;->getPort()Ljava/lang/Integer;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/Integer;->intValue()I

    move-result v19

    sget-object v20, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->HTTP:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    invoke-virtual/range {v20 .. v20}, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v18

    move/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v4, v0, v1, v2}, Lorg/apache/http/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    .restart local v4    # "destinationHost":Lorg/apache/http/HttpHost;
    goto/16 :goto_0

    .line 158
    :cond_7
    new-instance v4, Lorg/apache/http/HttpHost;

    .end local v4    # "destinationHost":Lorg/apache/http/HttpHost;
    invoke-interface {v10}, Lamazon/communication/identity/IRServiceEndpoint;->getHostname()Ljava/lang/String;

    move-result-object v18

    invoke-interface {v10}, Lamazon/communication/identity/IRServiceEndpoint;->getSecurePort()Ljava/lang/Integer;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/Integer;->intValue()I

    move-result v19

    sget-object v20, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->HTTPS:Lamazon/communication/identity/IRServiceEndpoint$Scheme;

    invoke-virtual/range {v20 .. v20}, Lamazon/communication/identity/IRServiceEndpoint$Scheme;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v18

    move/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v4, v0, v1, v2}, Lorg/apache/http/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V
    :try_end_2
    .catch Ljava/net/URISyntaxException; {:try_start_2 .. :try_end_2} :catch_0

    .restart local v4    # "destinationHost":Lorg/apache/http/HttpHost;
    goto/16 :goto_0

    .line 173
    .end local v10    # "irEndpoint":Lamazon/communication/identity/IRServiceEndpoint;
    :cond_8
    invoke-virtual/range {p1 .. p1}, Lamazon/communication/srr/SrrRequest;->getRequest()Lorg/apache/http/client/methods/HttpRequestBase;

    move-result-object v8

    .line 175
    .local v8, "httpRequest":Lorg/apache/http/client/methods/HttpRequestBase;
    const/16 v17, 0x0

    .line 176
    .local v17, "useCompression":Z
    invoke-virtual/range {p1 .. p1}, Lamazon/communication/srr/SrrRequest;->getCompressionOption()Lamazon/communication/connection/CompressionOption;

    move-result-object v18

    sget-object v19, Lamazon/communication/connection/CompressionOption;->REQUIRED:Lamazon/communication/connection/CompressionOption;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-eq v0, v1, :cond_9

    invoke-virtual/range {p1 .. p1}, Lamazon/communication/srr/SrrRequest;->getCompressionOption()Lamazon/communication/connection/CompressionOption;

    move-result-object v18

    sget-object v19, Lamazon/communication/connection/CompressionOption;->ALLOWED:Lamazon/communication/connection/CompressionOption;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-ne v0, v1, :cond_a

    .line 179
    :cond_9
    const-string/jumbo v18, "Accept-Encoding"

    const-string/jumbo v19, "gzip"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v8, v0, v1}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    const/16 v17, 0x1

    .line 183
    :cond_a
    const-string/jumbo v18, "TimeSignRequest"

    move-object/from16 v0, v18

    invoke-interface {v11, v0}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V

    .line 189
    :try_start_3
    invoke-virtual {v8}, Lorg/apache/http/client/methods/HttpRequestBase;->getURI()Ljava/net/URI;

    move-result-object v13

    .line 190
    .local v13, "requestUri":Ljava/net/URI;
    invoke-static {v13, v4}, Lorg/apache/http/client/utils/URIUtils;->rewriteURI(Ljava/net/URI;Lorg/apache/http/HttpHost;)Ljava/net/URI;

    move-result-object v9

    .line 191
    .local v9, "httpUri":Ljava/net/URI;
    invoke-virtual {v8, v9}, Lorg/apache/http/client/methods/HttpRequestBase;->setURI(Ljava/net/URI;)V

    .line 192
    move-object/from16 v0, p0

    iget-object v0, v0, Lamazon/communication/srr/HttpClientSrrManager;->mRequestSigner:Lamazon/communication/authentication/RequestSigner;

    move-object/from16 v18, v0

    invoke-virtual/range {p1 .. p1}, Lamazon/communication/srr/SrrRequest;->getRequestContext()Lamazon/communication/authentication/RequestContext;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-interface {v0, v8, v1}, Lamazon/communication/authentication/RequestSigner;->signRequest(Lorg/apache/http/client/methods/HttpRequestBase;Lamazon/communication/authentication/RequestContext;)V
    :try_end_3
    .catch Ljava/net/URISyntaxException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Lamazon/communication/authentication/SigningException; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 207
    const-string/jumbo v18, "TimeSignRequest"

    move-object/from16 v0, v18

    invoke-interface {v11, v0}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 211
    :try_start_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lamazon/communication/srr/HttpClientSrrManager;->mHttpClient:Lorg/apache/http/client/HttpClient;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-static {v0, v12}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 212
    move-object/from16 v0, p0

    iget-object v0, v0, Lamazon/communication/srr/HttpClientSrrManager;->mHttpClient:Lorg/apache/http/client/HttpClient;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Lorg/apache/http/client/HttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-static {v0, v12}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 214
    const-string/jumbo v18, "TimeHttpClientExecuteRequest"

    move-object/from16 v0, v18

    invoke-interface {v11, v0}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V
    :try_end_4
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/net/SocketTimeoutException; {:try_start_4 .. :try_end_4} :catch_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_5

    .line 217
    :try_start_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lamazon/communication/srr/HttpClientSrrManager;->mHttpClient:Lorg/apache/http/client/HttpClient;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-interface {v0, v8}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    move-result-object v14

    .line 219
    .local v14, "response":Lorg/apache/http/HttpResponse;
    :try_start_6
    const-string/jumbo v18, "TimeHttpClientExecuteRequest"

    move-object/from16 v0, v18

    invoke-interface {v11, v0}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    .line 223
    invoke-static {v14}, Lcom/amazon/communication/HttpResponseValidator;->validateContentLength(Lorg/apache/http/HttpResponse;)Z

    .line 226
    invoke-static {v14}, Lcom/amazon/communication/HttpResponseDecompressor;->decompressResponseIfNecessary(Lorg/apache/http/HttpResponse;)Z

    move-result v15

    .line 227
    .local v15, "responseWasCompressed":Z
    if-eqz v15, :cond_b

    if-nez v17, :cond_b

    .line 228
    sget-object v18, Lamazon/communication/srr/HttpClientSrrManager;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v19, "makeRequestSync"

    const-string/jumbo v20, "HttpResponse was compressed but request does not expect compression"

    const/16 v21, 0x0

    move/from16 v0, v21

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v21, v0

    invoke-virtual/range {v18 .. v21}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_6
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/net/SocketTimeoutException; {:try_start_6 .. :try_end_6} :catch_4
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_5

    .line 232
    :cond_b
    return-object v14

    .line 193
    .end local v9    # "httpUri":Ljava/net/URI;
    .end local v13    # "requestUri":Ljava/net/URI;
    .end local v14    # "response":Lorg/apache/http/HttpResponse;
    .end local v15    # "responseWasCompressed":Z
    :catch_1
    move-exception v7

    .line 194
    .local v7, "exception":Ljava/net/URISyntaxException;
    :try_start_7
    new-instance v6, Lcom/amazon/dp/logger/DPFormattedMessage;

    const-string/jumbo v18, "makeRequestSync"

    const-string/jumbo v19, "Failed to parse the URI for the request."

    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string/jumbo v22, "destination"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    invoke-static {v3}, Lamazon/communication/identity/EndpointIdentity;->logSafe(Lamazon/communication/identity/EndpointIdentity;)Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    const/16 v21, 0x2

    aput-object v7, v20, v21

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v6, v0, v1, v2}, Lcom/amazon/dp/logger/DPFormattedMessage;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 197
    .local v6, "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    sget-object v18, Lamazon/communication/srr/HttpClientSrrManager;->log:Lcom/amazon/dp/logger/DPLogger;

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Lcom/amazon/dp/logger/DPFormattedMessage;)V

    .line 198
    new-instance v18, Lamazon/communication/RequestFailedException;

    invoke-virtual {v6}, Lcom/amazon/dp/logger/DPFormattedMessage;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v7}, Lamazon/communication/RequestFailedException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v18
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 207
    .end local v6    # "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    .end local v7    # "exception":Ljava/net/URISyntaxException;
    :catchall_0
    move-exception v18

    const-string/jumbo v19, "TimeSignRequest"

    move-object/from16 v0, v19

    invoke-interface {v11, v0}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    throw v18

    .line 200
    :catch_2
    move-exception v7

    .line 201
    .local v7, "exception":Lamazon/communication/authentication/SigningException;
    :try_start_8
    new-instance v6, Lcom/amazon/dp/logger/DPFormattedMessage;

    const-string/jumbo v18, "makeRequestSync"

    const-string/jumbo v19, "Failed to sign request."

    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string/jumbo v22, "destination"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    invoke-static {v3}, Lamazon/communication/identity/EndpointIdentity;->logSafe(Lamazon/communication/identity/EndpointIdentity;)Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    const/16 v21, 0x2

    aput-object v7, v20, v21

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v6, v0, v1, v2}, Lcom/amazon/dp/logger/DPFormattedMessage;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 204
    .restart local v6    # "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    sget-object v18, Lamazon/communication/srr/HttpClientSrrManager;->log:Lcom/amazon/dp/logger/DPLogger;

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Lcom/amazon/dp/logger/DPFormattedMessage;)V

    .line 205
    new-instance v18, Lamazon/communication/RequestFailedException;

    invoke-virtual {v6}, Lcom/amazon/dp/logger/DPFormattedMessage;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v7}, Lamazon/communication/RequestFailedException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v18
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 219
    .end local v6    # "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    .end local v7    # "exception":Lamazon/communication/authentication/SigningException;
    .restart local v9    # "httpUri":Ljava/net/URI;
    .restart local v13    # "requestUri":Ljava/net/URI;
    :catchall_1
    move-exception v18

    :try_start_9
    const-string/jumbo v19, "TimeHttpClientExecuteRequest"

    move-object/from16 v0, v19

    invoke-interface {v11, v0}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    throw v18
    :try_end_9
    .catch Lorg/apache/http/conn/ConnectTimeoutException; {:try_start_9 .. :try_end_9} :catch_3
    .catch Ljava/net/SocketTimeoutException; {:try_start_9 .. :try_end_9} :catch_4
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_5

    .line 233
    :catch_3
    move-exception v7

    .line 234
    .local v7, "exception":Lorg/apache/http/conn/ConnectTimeoutException;
    new-instance v6, Lcom/amazon/dp/logger/DPFormattedMessage;

    const-string/jumbo v18, "makeRequestSync"

    const-string/jumbo v19, "Timed out connecting for the request."

    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string/jumbo v22, "destination"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    invoke-static {v3}, Lamazon/communication/identity/EndpointIdentity;->logSafe(Lamazon/communication/identity/EndpointIdentity;)Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    const/16 v21, 0x2

    aput-object v7, v20, v21

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v6, v0, v1, v2}, Lcom/amazon/dp/logger/DPFormattedMessage;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 237
    .restart local v6    # "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    sget-object v18, Lamazon/communication/srr/HttpClientSrrManager;->log:Lcom/amazon/dp/logger/DPLogger;

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Lcom/amazon/dp/logger/DPFormattedMessage;)V

    .line 238
    new-instance v18, Lamazon/communication/TimeoutException;

    invoke-virtual {v6}, Lcom/amazon/dp/logger/DPFormattedMessage;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v7}, Lamazon/communication/TimeoutException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v18

    .line 239
    .end local v6    # "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    .end local v7    # "exception":Lorg/apache/http/conn/ConnectTimeoutException;
    :catch_4
    move-exception v7

    .line 240
    .local v7, "exception":Ljava/net/SocketTimeoutException;
    new-instance v6, Lcom/amazon/dp/logger/DPFormattedMessage;

    const-string/jumbo v18, "makeRequestSync"

    const-string/jumbo v19, "Timed out making the request."

    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string/jumbo v22, "destination"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    invoke-static {v3}, Lamazon/communication/identity/EndpointIdentity;->logSafe(Lamazon/communication/identity/EndpointIdentity;)Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    const/16 v21, 0x2

    aput-object v7, v20, v21

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v6, v0, v1, v2}, Lcom/amazon/dp/logger/DPFormattedMessage;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 243
    .restart local v6    # "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    sget-object v18, Lamazon/communication/srr/HttpClientSrrManager;->log:Lcom/amazon/dp/logger/DPLogger;

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Lcom/amazon/dp/logger/DPFormattedMessage;)V

    .line 244
    new-instance v18, Lamazon/communication/TimeoutException;

    invoke-virtual {v6}, Lcom/amazon/dp/logger/DPFormattedMessage;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v7}, Lamazon/communication/TimeoutException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v18

    .line 245
    .end local v6    # "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    .end local v7    # "exception":Ljava/net/SocketTimeoutException;
    :catch_5
    move-exception v7

    .line 246
    .local v7, "exception":Ljava/io/IOException;
    new-instance v6, Lcom/amazon/dp/logger/DPFormattedMessage;

    const-string/jumbo v18, "makeRequestSync"

    const-string/jumbo v19, "Failed to execute the request."

    const/16 v20, 0x3

    move/from16 v0, v20

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    const-string/jumbo v22, "destination"

    aput-object v22, v20, v21

    const/16 v21, 0x1

    invoke-static {v3}, Lamazon/communication/identity/EndpointIdentity;->logSafe(Lamazon/communication/identity/EndpointIdentity;)Ljava/lang/String;

    move-result-object v22

    aput-object v22, v20, v21

    const/16 v21, 0x2

    aput-object v7, v20, v21

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-object/from16 v2, v20

    invoke-direct {v6, v0, v1, v2}, Lcom/amazon/dp/logger/DPFormattedMessage;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 249
    .restart local v6    # "errorMessage":Lcom/amazon/dp/logger/DPFormattedMessage;
    sget-object v18, Lamazon/communication/srr/HttpClientSrrManager;->log:Lcom/amazon/dp/logger/DPLogger;

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Lcom/amazon/dp/logger/DPFormattedMessage;)V

    .line 250
    new-instance v18, Lamazon/communication/RequestFailedException;

    invoke-virtual {v6}, Lcom/amazon/dp/logger/DPFormattedMessage;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v7}, Lamazon/communication/RequestFailedException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v18
.end method

.method protected validateConnectivityRequirements(Lamazon/communication/srr/SrrRequest;)V
    .locals 0
    .param p1, "srrRequest"    # Lamazon/communication/srr/SrrRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/RequestFailedException;
        }
    .end annotation

    .prologue
    .line 280
    return-void
.end method
