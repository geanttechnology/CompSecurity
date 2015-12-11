.class public Lcom/amazon/identity/auth/attributes/CorPfmFetcher;
.super Ljava/lang/Object;
.source "CorPfmFetcher.java"


# static fields
.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthMethodFactory:Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

.field private final mContext:Landroid/content/Context;

.field private final mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

.field private final mUrlConnectionFactory:Lcom/amazon/identity/auth/device/framework/AuthenticatedUrlConnectionFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    .line 40
    const-class v0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mContext:Landroid/content/Context;

    .line 66
    new-instance v0, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

    invoke-direct {v0, p1, p2}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mAuthMethodFactory:Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

    .line 68
    const-string/jumbo v0, "dcp_authenticated_url_connection_factory"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/AuthenticatedUrlConnectionFactory;

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mUrlConnectionFactory:Lcom/amazon/identity/auth/device/framework/AuthenticatedUrlConnectionFactory;

    .line 71
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_device_info"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 72
    return-void
.end method

.method private buildRequestUrl()Ljava/net/URL;
    .locals 4

    .prologue
    .line 205
    :try_start_0
    new-instance v1, Landroid/net/Uri$Builder;

    invoke-direct {v1}, Landroid/net/Uri$Builder;-><init>()V

    const-string/jumbo v2, "https"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getDCAHost()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string/jumbo v2, "getCustomerAttribute"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string/jumbo v2, "version"

    const-string/jumbo v3, "1_0"

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string/jumbo v2, "preferences"

    const-string/jumbo v3, "cor,pfm"

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string/jumbo v2, "devicetype"

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 220
    .local v0, "uriBuilder":Landroid/net/Uri$Builder;
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mContext:Landroid/content/Context;

    sget-object v2, Lcom/amazon/identity/auth/device/features/Feature;->DSNWhenNotRegistered:Lcom/amazon/identity/auth/device/features/Feature;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/Platform;->hasFeature(Landroid/content/Context;Lcom/amazon/identity/auth/device/features/Feature;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 222
    const-string/jumbo v1, "dsn"

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mDeviceInfo:Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 225
    :cond_0
    new-instance v1, Ljava/net/URL;

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 230
    .end local v0    # "uriBuilder":Landroid/net/Uri$Builder;
    :goto_0
    return-object v1

    .line 229
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not contruct DCA endpoint"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private parseResponse(Ljava/net/HttpURLConnection;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .locals 18
    .param p1, "request"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 128
    const/4 v13, 0x0

    .line 131
    .local v13, "stream":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual/range {p1 .. p1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v13

    .line 132
    new-instance v10, Ljava/lang/String;

    invoke-static {v13}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B

    move-result-object v14

    invoke-direct {v10, v14}, Ljava/lang/String;-><init>([B)V

    .line 133
    .local v10, "response":Ljava/lang/String;
    sget-object v14, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    new-instance v14, Ljava/lang/StringBuilder;

    const-string/jumbo v15, "Response: "

    invoke-direct {v14, v15}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v14, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 135
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4, v10}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 137
    .local v4, "corPfmResponse":Lorg/json/JSONObject;
    const-string/jumbo v14, "customerAttribute"

    invoke-static {v4, v14}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getJSONObject(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    .line 138
    .local v7, "infoObj":Lorg/json/JSONObject;
    if-nez v7, :cond_0

    .line 140
    const-string/jumbo v14, "Message"

    const-string/jumbo v15, "Internal Error."

    invoke-static {v4, v14, v15}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 142
    .local v8, "message":Ljava/lang/String;
    sget-object v14, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string/jumbo v16, "The server returned an error with message: "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 143
    invoke-static {v13}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    const/4 v14, 0x0

    .line 198
    .end local v4    # "corPfmResponse":Lorg/json/JSONObject;
    .end local v7    # "infoObj":Lorg/json/JSONObject;
    .end local v8    # "message":Ljava/lang/String;
    .end local v10    # "response":Ljava/lang/String;
    :goto_0
    return-object v14

    .line 146
    .restart local v4    # "corPfmResponse":Lorg/json/JSONObject;
    .restart local v7    # "infoObj":Lorg/json/JSONObject;
    .restart local v10    # "response":Ljava/lang/String;
    :cond_0
    :try_start_1
    const-string/jumbo v14, "cor"

    invoke-virtual {v7, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_1

    const-string/jumbo v14, "pfm"

    invoke-virtual {v7, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_1

    .line 148
    const-string/jumbo v14, "Description"

    const-string/jumbo v15, "Generic Error. No COR or PFM found."

    invoke-static {v7, v14, v15}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 150
    .local v5, "description":Ljava/lang/String;
    sget-object v14, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string/jumbo v16, "The server did not return a cor pfm for the customer. Message: "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 152
    invoke-static {v13}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    const/4 v14, 0x0

    goto :goto_0

    .line 155
    .end local v5    # "description":Ljava/lang/String;
    :cond_1
    :try_start_2
    const-string/jumbo v14, "cor"

    const/4 v15, 0x0

    invoke-static {v7, v14, v15}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 156
    .local v3, "cor":Ljava/lang/String;
    const-string/jumbo v14, "pfm"

    const/4 v15, 0x0

    invoke-static {v7, v14, v15}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 158
    .local v9, "pfm":Ljava/lang/String;
    const-string/jumbo v14, "sourceOfComputationCOR"

    const/4 v15, 0x0

    invoke-static {v7, v14, v15}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 160
    .local v11, "sourceOfComputationCor":Ljava/lang/String;
    const-string/jumbo v14, "sourceOfComputationPFM"

    const/4 v15, 0x0

    invoke-static {v7, v14, v15}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 163
    .local v12, "sourceOfComputationPfm":Ljava/lang/String;
    const-string/jumbo v14, "computationConfidenceValue"

    const/4 v15, 0x0

    invoke-static {v7, v14, v15}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->getStringOrDefault(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 166
    .local v2, "computationConfidenceValueStr":Ljava/lang/String;
    sget-object v14, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    const-string/jumbo v15, "Received response with: \nCoR: %s \nPFM:%s \nSource Of Computation CoR: %s \n Source Of Computation PFM: %s \n Computation Confidence Value: %s"

    const/16 v16, 0x5

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    aput-object v3, v16, v17

    const/16 v17, 0x1

    aput-object v9, v16, v17

    const/16 v17, 0x2

    aput-object v11, v16, v17

    const/16 v17, 0x3

    aput-object v12, v16, v17

    const/16 v17, 0x4

    aput-object v2, v16, v17

    invoke-static/range {v15 .. v16}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    sget-object v14, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->CUSTOMER_PROVIDED:Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    invoke-static {v2, v14}, Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;->parseFromValue(Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;)Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;

    move-result-object v1

    .line 179
    .local v1, "computationConfidenceValue":Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    const-string/jumbo v14, "fetchCORPFMSuccess"

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/String;

    invoke-static {v14, v15}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 180
    new-instance v14, Lcom/amazon/identity/auth/attributes/CORPFMResponse;

    invoke-direct {v14, v3, v9, v1}, Lcom/amazon/identity/auth/attributes/CORPFMResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 195
    invoke-static {v13}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    goto/16 :goto_0

    .line 182
    .end local v1    # "computationConfidenceValue":Lcom/amazon/identity/auth/attributes/CORPFMResponse$ComputationConfidenceValue;
    .end local v2    # "computationConfidenceValueStr":Ljava/lang/String;
    .end local v3    # "cor":Ljava/lang/String;
    .end local v4    # "corPfmResponse":Lorg/json/JSONObject;
    .end local v7    # "infoObj":Lorg/json/JSONObject;
    .end local v9    # "pfm":Ljava/lang/String;
    .end local v10    # "response":Ljava/lang/String;
    .end local v11    # "sourceOfComputationCor":Ljava/lang/String;
    .end local v12    # "sourceOfComputationPfm":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 184
    .local v6, "e":Ljava/io/IOException;
    :try_start_3
    const-string/jumbo v14, "fetchCORPFMFailure"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/String;

    const/16 v16, 0x0

    const-string/jumbo v17, "IOException"

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 185
    const-string/jumbo v14, "DCA service"

    move-object/from16 v0, p1

    invoke-static {v0, v14}, Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;->writeErrorStream(Ljava/net/HttpURLConnection;Ljava/lang/String;)V

    .line 186
    throw v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 195
    .end local v6    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v14

    invoke-static {v13}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v14

    .line 188
    :catch_1
    move-exception v6

    .line 190
    .local v6, "e":Lorg/json/JSONException;
    :try_start_4
    const-string/jumbo v14, "fetchCORPFMFailure"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/String;

    const/16 v16, 0x0

    const-string/jumbo v17, "JSONException"

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 191
    sget-object v14, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string/jumbo v16, "Error parsing DCAS JSON Response: "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 195
    invoke-static {v13}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    .line 198
    const/4 v14, 0x0

    goto/16 :goto_0
.end method


# virtual methods
.method public fetch()Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    .locals 12

    .prologue
    const/4 v6, 0x0

    .line 76
    sget-object v7, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Fetching the COR and PFM values"

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->buildRequestUrl()Ljava/net/URL;

    move-result-object v5

    .line 79
    .local v5, "url":Ljava/net/URL;
    if-nez v5, :cond_0

    .line 123
    :goto_0
    return-object v6

    .line 84
    :cond_0
    sget-object v7, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v8, "fetch"

    invoke-static {v7, v8}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v4

    .line 85
    .local v4, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    const/4 v1, 0x0

    .line 88
    .local v1, "corPfmRequest":Ljava/net/HttpURLConnection;
    :try_start_0
    iget-object v7, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mAuthMethodFactory:Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

    sget-object v8, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v7, v8}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->newAuthenticationMethod(Lcom/amazon/identity/auth/device/api/AuthenticationType;)Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    move-result-object v0

    .line 91
    .local v0, "authMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    iget-object v7, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mUrlConnectionFactory:Lcom/amazon/identity/auth/device/framework/AuthenticatedUrlConnectionFactory;

    invoke-virtual {v7, v5, v0}, Lcom/amazon/identity/auth/device/framework/AuthenticatedUrlConnectionFactory;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v1

    .line 92
    const-string/jumbo v7, "GET"

    invoke-virtual {v1, v7}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 93
    const-string/jumbo v7, "Accept"

    const-string/jumbo v8, "application/json"

    invoke-virtual {v1, v7, v8}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v3

    .line 96
    .local v3, "responseCode":I
    sget-object v7, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Recieved Response Code %d from DCA"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->parseResponse(Ljava/net/HttpURLConnection;)Lcom/amazon/identity/auth/attributes/CORPFMResponse;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v6

    .line 116
    if-eqz v1, :cond_1

    .line 118
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 120
    :cond_1
    invoke-virtual {v4}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    .line 100
    .end local v0    # "authMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .end local v3    # "responseCode":I
    :catch_0
    move-exception v2

    .line 102
    .local v2, "e":Ljava/io/IOException;
    :try_start_1
    sget-object v7, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string/jumbo v9, "IOException: Could not call DCAS Service. E: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 104
    iget-object v7, p0, Lcom/amazon/identity/auth/attributes/CorPfmFetcher;->mContext:Landroid/content/Context;

    invoke-static {v7, v4}, Lcom/amazon/identity/platform/metric/MetricUtils;->checkConnectivity(Landroid/content/Context;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 106
    const-string/jumbo v7, "NetworkNotAvailable"

    invoke-static {v7}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->recordCorPfmRequestFailure(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 116
    :goto_1
    if-eqz v1, :cond_2

    .line 118
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 120
    :cond_2
    invoke-virtual {v4}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    goto :goto_0

    .line 111
    :cond_3
    :try_start_2
    const-string/jumbo v7, "fetchCORPFMFailure"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    const-string/jumbo v10, "IOException"

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 116
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v6

    if-eqz v1, :cond_4

    .line 118
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 120
    :cond_4
    invoke-virtual {v4}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v6
.end method
