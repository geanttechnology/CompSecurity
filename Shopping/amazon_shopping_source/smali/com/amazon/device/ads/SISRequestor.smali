.class Lcom/amazon/device/ads/SISRequestor;
.super Ljava/lang/Object;
.source "SISRequestor.java"


# static fields
.field protected static final API_LEVEL_ENDPOINT:Ljava/lang/String; = "/api3"


# instance fields
.field private final sisRequestorCallback:Lcom/amazon/device/ads/SISRequestorCallback;

.field private final sisRequests:[Lcom/amazon/device/ads/SISRequest;


# direct methods
.method public varargs constructor <init>(Lcom/amazon/device/ads/SISRequestorCallback;[Lcom/amazon/device/ads/SISRequest;)V
    .locals 0
    .param p1, "sisRequestorCallback"    # Lcom/amazon/device/ads/SISRequestorCallback;
    .param p2, "sisRequests"    # [Lcom/amazon/device/ads/SISRequest;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/amazon/device/ads/SISRequestor;->sisRequestorCallback:Lcom/amazon/device/ads/SISRequestorCallback;

    .line 36
    iput-object p2, p0, Lcom/amazon/device/ads/SISRequestor;->sisRequests:[Lcom/amazon/device/ads/SISRequest;

    .line 37
    return-void
.end method

.method public varargs constructor <init>([Lcom/amazon/device/ads/SISRequest;)V
    .locals 1
    .param p1, "sisRequests"    # [Lcom/amazon/device/ads/SISRequest;

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Lcom/amazon/device/ads/SISRequestor;-><init>(Lcom/amazon/device/ads/SISRequestorCallback;[Lcom/amazon/device/ads/SISRequest;)V

    .line 31
    return-void
.end method

.method protected static getEndpoint(Lcom/amazon/device/ads/SISRequest;)Ljava/lang/String;
    .locals 4
    .param p0, "sisRequest"    # Lcom/amazon/device/ads/SISRequest;

    .prologue
    .line 145
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Configuration$ConfigOption;->SIS_URL:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v0

    .line 147
    .local v0, "endpoint":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 149
    const-string/jumbo v2, "/"

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 150
    .local v1, "endpointIndex":I
    const/4 v2, -0x1

    if-le v1, v2, :cond_1

    .line 153
    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 161
    .end local v1    # "endpointIndex":I
    :cond_0
    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "/api3"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {p0}, Lcom/amazon/device/ads/SISRequest;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 162
    return-object v0

    .line 157
    .restart local v1    # "endpointIndex":I
    :cond_1
    const-string/jumbo v0, ""

    goto :goto_0
.end method

.method protected static getHostname()Ljava/lang/String;
    .locals 4

    .prologue
    .line 128
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Configuration$ConfigOption;->SIS_URL:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v1

    .line 129
    .local v1, "hostname":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 131
    const-string/jumbo v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 132
    .local v0, "endpointIndex":I
    const/4 v2, -0x1

    if-le v0, v2, :cond_0

    .line 134
    const/4 v2, 0x0

    invoke-virtual {v1, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 137
    .end local v0    # "endpointIndex":I
    :cond_0
    return-object v1
.end method


# virtual methods
.method protected callSIS()V
    .locals 4

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/device/ads/SISRequestor;->sisRequests:[Lcom/amazon/device/ads/SISRequest;

    .local v0, "arr$":[Lcom/amazon/device/ads/SISRequest;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 53
    .local v3, "sisRequest":Lcom/amazon/device/ads/SISRequest;
    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/SISRequestor;->callSIS(Lcom/amazon/device/ads/SISRequest;)V

    .line 51
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 55
    .end local v3    # "sisRequest":Lcom/amazon/device/ads/SISRequest;
    :cond_0
    return-void
.end method

.method protected callSIS(Lcom/amazon/device/ads/SISRequest;)V
    .locals 12
    .param p1, "sisRequest"    # Lcom/amazon/device/ads/SISRequest;

    .prologue
    const/4 v8, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 59
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/SISRequestor;->getWebRequest(Lcom/amazon/device/ads/SISRequest;)Lcom/amazon/device/ads/WebRequest;

    move-result-object v4

    .line 60
    .local v4, "request":Lcom/amazon/device/ads/WebRequest;
    const/4 v5, 0x0

    .line 63
    .local v5, "response":Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_start_0
    invoke-virtual {v4}, Lcom/amazon/device/ads/WebRequest;->makeCall()Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_0
    .catch Lcom/amazon/device/ads/WebRequest$WebRequestException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 71
    invoke-virtual {v5}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getJSONObjectBody()Lorg/json/JSONObject;

    move-result-object v1

    .line 72
    .local v1, "jsonPayload":Lorg/json/JSONObject;
    if-nez v1, :cond_0

    .line 92
    .end local v1    # "jsonPayload":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 65
    :catch_0
    move-exception v0

    .line 68
    .local v0, "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    goto :goto_0

    .line 79
    .end local v0    # "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    .restart local v1    # "jsonPayload":Lorg/json/JSONObject;
    :cond_0
    const-string/jumbo v6, "rcode"

    invoke-static {v1, v6, v10}, Lcom/amazon/device/ads/JSONUtils;->getIntegerFromJSON(Lorg/json/JSONObject;Ljava/lang/String;I)I

    move-result v3

    .line 80
    .local v3, "rcode":I
    const-string/jumbo v6, "msg"

    const-string/jumbo v7, ""

    invoke-static {v1, v6, v7}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 83
    .local v2, "msg":Ljava/lang/String;
    if-ne v3, v11, :cond_1

    .line 85
    invoke-interface {p1}, Lcom/amazon/device/ads/SISRequest;->getLogTag()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Result - code: %d, msg: %s"

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    aput-object v2, v8, v11

    invoke-static {v6, v7, v8}, Lcom/amazon/device/ads/Log;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 86
    invoke-interface {p1, v1}, Lcom/amazon/device/ads/SISRequest;->onResponseReceived(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 90
    :cond_1
    invoke-interface {p1}, Lcom/amazon/device/ads/SISRequest;->getLogTag()Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "Result - code: %d, msg: %s"

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    aput-object v2, v8, v11

    invoke-static {v6, v7, v8}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected getSisRequestorCallback()Lcom/amazon/device/ads/SISRequestorCallback;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/amazon/device/ads/SISRequestor;->sisRequestorCallback:Lcom/amazon/device/ads/SISRequestorCallback;

    return-object v0
.end method

.method protected getWebRequest(Lcom/amazon/device/ads/SISRequest;)Lcom/amazon/device/ads/WebRequest;
    .locals 7
    .param p1, "sisRequest"    # Lcom/amazon/device/ads/SISRequest;

    .prologue
    .line 96
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->createNewWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v4

    .line 97
    .local v4, "request":Lcom/amazon/device/ads/WebRequest;
    invoke-interface {p1}, Lcom/amazon/device/ads/SISRequest;->getLogTag()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebRequest;->setExternalLogTag(Ljava/lang/String;)V

    .line 98
    sget-object v5, Lcom/amazon/device/ads/WebRequest$HttpMethod;->POST:Lcom/amazon/device/ads/WebRequest$HttpMethod;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebRequest;->setHttpMethod(Lcom/amazon/device/ads/WebRequest$HttpMethod;)V

    .line 99
    invoke-static {}, Lcom/amazon/device/ads/SISRequestor;->getHostname()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebRequest;->setHost(Ljava/lang/String;)V

    .line 100
    invoke-static {p1}, Lcom/amazon/device/ads/SISRequestor;->getEndpoint(Lcom/amazon/device/ads/SISRequest;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebRequest;->setPath(Ljava/lang/String;)V

    .line 101
    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebRequest;->enableLog(Z)V

    .line 103
    invoke-interface {p1}, Lcom/amazon/device/ads/SISRequest;->getPostParameters()Ljava/util/HashMap;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 105
    invoke-interface {p1}, Lcom/amazon/device/ads/SISRequest;->getPostParameters()Ljava/util/HashMap;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 107
    .local v1, "postParameter":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v4, v5, v6}, Lcom/amazon/device/ads/WebRequest;->putPostParameter(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 111
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "postParameter":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-interface {p1}, Lcom/amazon/device/ads/SISRequest;->getQueryParameters()Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    move-result-object v2

    .line 112
    .local v2, "queryStringParameters":Lcom/amazon/device/ads/WebRequest$QueryStringParameters;
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v3

    .line 113
    .local v3, "registrationInfo":Lcom/amazon/device/ads/RegistrationInfo;
    const-string/jumbo v5, "appId"

    invoke-virtual {v3}, Lcom/amazon/device/ads/RegistrationInfo;->getAppKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    const-string/jumbo v5, "sdkVer"

    invoke-static {}, Lcom/amazon/device/ads/Version;->getSDKVersion()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    invoke-virtual {v4, v2}, Lcom/amazon/device/ads/WebRequest;->setQueryStringParameters(Lcom/amazon/device/ads/WebRequest$QueryStringParameters;)V

    .line 117
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/device/ads/Metrics;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebRequest;->setMetricsCollector(Lcom/amazon/device/ads/MetricsCollector;)V

    .line 118
    invoke-interface {p1}, Lcom/amazon/device/ads/SISRequest;->getCallMetricType()Lcom/amazon/device/ads/Metrics$MetricType;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebRequest;->setServiceCallLatencyMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 119
    return-object v4
.end method

.method public startCallSIS()V
    .locals 1

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/amazon/device/ads/SISRequestor;->callSIS()V

    .line 42
    invoke-virtual {p0}, Lcom/amazon/device/ads/SISRequestor;->getSisRequestorCallback()Lcom/amazon/device/ads/SISRequestorCallback;

    move-result-object v0

    .line 43
    .local v0, "sisRequestorCallback":Lcom/amazon/device/ads/SISRequestorCallback;
    if-eqz v0, :cond_0

    .line 45
    invoke-interface {v0}, Lcom/amazon/device/ads/SISRequestorCallback;->onSISCallComplete()V

    .line 47
    :cond_0
    return-void
.end method
