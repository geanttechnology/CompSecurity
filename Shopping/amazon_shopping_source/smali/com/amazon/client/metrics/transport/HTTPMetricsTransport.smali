.class public Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;
.super Ljava/lang/Object;
.source "HTTPMetricsTransport.java"

# interfaces
.implements Lcom/amazon/client/metrics/transport/MetricsTransport;
.implements Lcom/amazon/client/metrics/transport/TransportStateNotifier;


# static fields
.field protected static final PATH:Ljava/lang/String; = "/metricsBatch"

.field private static final SERVICE_NAME:Ljava/lang/String; = "DeviceMetricsService"

.field protected static final USE_DEFAULT_TIMEOUT:I

.field protected static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

.field private mContext:Landroid/content/Context;

.field private mHttpClient:Lorg/apache/http/client/HttpClient;

.field private mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

.field private mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

.field protected mSrrManager:Lamazon/communication/srr/SrrManager;

.field private mStaticCredentialRequestSigner:Lamazon/communication/authentication/RequestSigner;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 70
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "HTTPMetricsTransport"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/client/metrics/configuration/MetricsConfiguration;Lcom/amazon/device/utils/DeviceUtil;Lamazon/communication/authentication/RequestSigner;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "metricsConfiguration"    # Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
    .param p3, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;
    .param p4, "requestSigner"    # Lamazon/communication/authentication/RequestSigner;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mHttpClient:Lorg/apache/http/client/HttpClient;

    .line 85
    if-nez p1, :cond_0

    .line 86
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "context cannot be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 88
    :cond_0
    if-nez p2, :cond_1

    .line 89
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "metricsConfiguration cannot be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 91
    :cond_1
    if-nez p3, :cond_2

    .line 92
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "deviceUtil cannot be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 94
    :cond_2
    if-nez p4, :cond_3

    .line 95
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "requestSigner cannot be null"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 99
    :cond_3
    :try_start_0
    iput-object p1, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    .line 100
    iput-object p2, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    .line 101
    iput-object p4, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    .line 102
    new-instance v3, Lcom/amazon/client/metrics/transport/StaticCredentialRequestSigner;

    invoke-direct {v3, p3}, Lcom/amazon/client/metrics/transport/StaticCredentialRequestSigner;-><init>(Lcom/amazon/device/utils/DeviceUtil;)V

    iput-object v3, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mStaticCredentialRequestSigner:Lamazon/communication/authentication/RequestSigner;

    .line 103
    invoke-direct {p0, p2, p4}, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->createMetricsHttpRequestSigner(Lcom/amazon/client/metrics/configuration/MetricsConfiguration;Lamazon/communication/authentication/RequestSigner;)Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    .line 104
    const-string/jumbo v3, "DeviceMetricsService"

    invoke-static {v3}, Lcom/amazon/client/metrics/transport/HttpClientFactory;->getSecureHttpClient(Ljava/lang/String;)Lorg/apache/http/client/HttpClient;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mHttpClient:Lorg/apache/http/client/HttpClient;

    .line 105
    new-instance v3, Lamazon/communication/srr/HttpClientSrrManager;

    iget-object v4, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mHttpClient:Lorg/apache/http/client/HttpClient;

    iget-object v5, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    invoke-direct {v3, v4, v5}, Lamazon/communication/srr/HttpClientSrrManager;-><init>(Lorg/apache/http/client/HttpClient;Lamazon/communication/authentication/RequestSigner;)V

    iput-object v3, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mSrrManager:Lamazon/communication/srr/SrrManager;
    :try_end_0
    .catch Ljava/security/KeyManagementException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/security/UnrecoverableKeyException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/security/cert/CertificateException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4

    .line 122
    return-void

    .line 106
    :catch_0
    move-exception v2

    .line 107
    .local v2, "kme":Ljava/security/KeyManagementException;
    sget-object v3, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "HTTPMetricsTransport"

    const-string/jumbo v5, "Failed to create HttpClient from HttpClientFactory: "

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v2, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 108
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 109
    .end local v2    # "kme":Ljava/security/KeyManagementException;
    :catch_1
    move-exception v1

    .line 110
    .local v1, "e":Ljava/security/UnrecoverableKeyException;
    sget-object v3, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "HTTPMetricsTransport"

    const-string/jumbo v5, "Failed to create HttpClient from HttpClientFactory: "

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v1, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 111
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 112
    .end local v1    # "e":Ljava/security/UnrecoverableKeyException;
    :catch_2
    move-exception v1

    .line 113
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    sget-object v3, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "HTTPMetricsTransport"

    const-string/jumbo v5, "Failed to create HttpClient from HttpClientFactory: "

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v1, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 114
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 115
    .end local v1    # "e":Ljava/security/NoSuchAlgorithmException;
    :catch_3
    move-exception v0

    .line 116
    .local v0, "ce":Ljava/security/cert/CertificateException;
    sget-object v3, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "HTTPMetricsTransport"

    const-string/jumbo v5, "Failed to create HttpClient from HttpClientFactory: "

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v0, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 117
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 118
    .end local v0    # "ce":Ljava/security/cert/CertificateException;
    :catch_4
    move-exception v1

    .line 119
    .local v1, "e":Ljava/io/IOException;
    sget-object v3, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "HTTPMetricsTransport"

    const-string/jumbo v5, "Failed to create HttpClient from HttpClientFactory: "

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v1, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 120
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method private attemptToTransmit([BLcom/amazon/client/metrics/MetricEvent;Lamazon/communication/identity/EndpointIdentity;Z)I
    .locals 13
    .param p1, "data"    # [B
    .param p2, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p3, "endpointIdentity"    # Lamazon/communication/identity/EndpointIdentity;
    .param p4, "fallbackToStaticCredential"    # Z

    .prologue
    .line 211
    const/4 v6, 0x0

    .line 212
    .local v6, "wakeLock":Landroid/os/PowerManager$WakeLock;
    const/4 v7, 0x0

    .line 216
    .local v7, "wifiLock":Landroid/net/wifi/WifiManager$WifiLock;
    :try_start_0
    iget-object v8, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v8}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v8

    const-string/jumbo v9, "HTTPMetricsTransportWakeLock"

    invoke-virtual {v8, v9}, Lcom/amazon/device/utils/NetworkManager;->createWakeLock(Ljava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v6

    .line 217
    iget-object v8, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v8}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v8

    invoke-virtual {v8, v6}, Lcom/amazon/device/utils/NetworkManager;->acquireWakeLock(Landroid/os/PowerManager$WakeLock;)V

    .line 220
    iget-object v8, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v8}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v8

    const-string/jumbo v9, "HTTPMetricsTransport"

    invoke-virtual {v8, v9}, Lcom/amazon/device/utils/NetworkManager;->createWifiLock(Ljava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;

    move-result-object v7

    .line 221
    if-eqz v7, :cond_0

    .line 222
    iget-object v8, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v8}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v8

    invoke-virtual {v8, v7}, Lcom/amazon/device/utils/NetworkManager;->acquireWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 224
    :cond_0
    invoke-direct/range {p0 .. p3}, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->makeRequest([BLcom/amazon/client/metrics/MetricEvent;Lamazon/communication/identity/EndpointIdentity;)I
    :try_end_0
    .catch Lamazon/communication/MissingCredentialsException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lamazon/communication/RequestFailedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Lamazon/communication/TimeoutException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_5
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v8

    .line 250
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    :goto_0
    return v8

    .line 225
    :catch_0
    move-exception v3

    .line 227
    .local v3, "mce":Lamazon/communication/MissingCredentialsException;
    if-eqz p4, :cond_1

    .line 228
    :try_start_1
    iget-object v8, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mStaticCredentialRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v8, v9}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 229
    iget-object v8, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v8}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getStaticCredentialEndpointIdentity()Lamazon/communication/identity/EndpointIdentity;

    move-result-object v8

    const/4 v9, 0x0

    invoke-direct {p0, p1, p2, v8, v9}, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->attemptToTransmit([BLcom/amazon/client/metrics/MetricEvent;Lamazon/communication/identity/EndpointIdentity;Z)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v8

    .line 250
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    goto :goto_0

    .line 231
    :cond_1
    :try_start_2
    sget-object v8, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "transmit"

    const-string/jumbo v10, "MissingCredentialsException while transmitting"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v3, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 232
    const/4 v8, 0x5

    .line 250
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    goto :goto_0

    .line 234
    .end local v3    # "mce":Lamazon/communication/MissingCredentialsException;
    :catch_1
    move-exception v4

    .line 235
    .local v4, "rfe":Lamazon/communication/RequestFailedException;
    :try_start_3
    sget-object v8, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "transmit"

    const-string/jumbo v10, "RequestFailedException while transmitting"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v4, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 236
    const/16 v8, 0x9

    .line 250
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    goto/16 :goto_0

    .line 237
    .end local v4    # "rfe":Lamazon/communication/RequestFailedException;
    :catch_2
    move-exception v2

    .line 238
    .local v2, "ioe":Ljava/io/IOException;
    :try_start_4
    sget-object v8, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "transmit"

    const-string/jumbo v10, "IOException while getting response content after transmitting"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v2, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 239
    const/16 v8, 0xa

    .line 250
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    goto/16 :goto_0

    .line 240
    .end local v2    # "ioe":Ljava/io/IOException;
    :catch_3
    move-exception v1

    .line 241
    .local v1, "iae":Ljava/lang/IllegalAccessException;
    :try_start_5
    sget-object v8, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "transmit"

    const-string/jumbo v10, "IllegalAccessException while transmitting"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v1, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 242
    const/16 v8, 0xb

    .line 250
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    goto/16 :goto_0

    .line 243
    .end local v1    # "iae":Ljava/lang/IllegalAccessException;
    :catch_4
    move-exception v5

    .line 244
    .local v5, "toe":Lamazon/communication/TimeoutException;
    :try_start_6
    sget-object v8, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "transmit"

    const-string/jumbo v10, "TimeoutException while transmitting"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v5, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 245
    const/4 v8, 0x2

    .line 250
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    goto/16 :goto_0

    .line 246
    .end local v5    # "toe":Lamazon/communication/TimeoutException;
    :catch_5
    move-exception v0

    .line 247
    .local v0, "e":Ljava/lang/Exception;
    :try_start_7
    sget-object v8, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "transmit"

    const-string/jumbo v10, "Exception while transmitting"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v0, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 248
    const/4 v8, 0x6

    .line 250
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    goto/16 :goto_0

    .line 250
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v8

    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    iget-object v10, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mConfiguredRequestSigner:Lamazon/communication/authentication/RequestSigner;

    invoke-virtual {v9, v10}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->setNextRequestSigner(Lamazon/communication/authentication/RequestSigner;)V

    .line 251
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v7}, Lcom/amazon/device/utils/NetworkManager;->releaseWifiLock(Landroid/net/wifi/WifiManager$WifiLock;)V

    .line 252
    iget-object v9, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v9}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v9

    invoke-virtual {v9, v6}, Lcom/amazon/device/utils/NetworkManager;->releaseWakeLock(Landroid/os/PowerManager$WakeLock;)V

    throw v8
.end method

.method private createMetricsHttpRequestSigner(Lcom/amazon/client/metrics/configuration/MetricsConfiguration;Lamazon/communication/authentication/RequestSigner;)Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;
    .locals 3
    .param p1, "metricsConfiguration"    # Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
    .param p2, "requestSigner"    # Lamazon/communication/authentication/RequestSigner;

    .prologue
    .line 129
    const/4 v0, 0x0

    .line 130
    .local v0, "metricsHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getCodecConfiguration()Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->getCodecType()Lcom/amazon/client/metrics/configuration/CodecType;

    move-result-object v1

    sget-object v2, Lcom/amazon/client/metrics/configuration/CodecType;->PROTOCOL_BUFFERS:Lcom/amazon/client/metrics/configuration/CodecType;

    if-ne v1, v2, :cond_0

    .line 132
    new-instance v0, Ljava/util/HashMap;

    .end local v0    # "metricsHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 133
    .restart local v0    # "metricsHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "x-codec-format"

    invoke-virtual {p1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getCodecConfiguration()Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->getCodecType()Lcom/amazon/client/metrics/configuration/CodecType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/CodecType;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 135
    const-string/jumbo v1, "x-codec-version"

    invoke-virtual {p1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getCodecConfiguration()Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->getCodecVersion()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 138
    :cond_0
    new-instance v1, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    invoke-direct {v1, v0, p2}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;-><init>(Ljava/util/Map;Lamazon/communication/authentication/RequestSigner;)V

    return-object v1
.end method

.method private makeRequest([BLcom/amazon/client/metrics/MetricEvent;Lamazon/communication/identity/EndpointIdentity;)I
    .locals 11
    .param p1, "data"    # [B
    .param p2, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p3, "endpointIdentity"    # Lamazon/communication/identity/EndpointIdentity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lamazon/communication/MissingCredentialsException;,
            Lamazon/communication/RequestFailedException;,
            Ljava/io/IOException;,
            Ljava/lang/IllegalAccessException;,
            Lamazon/communication/TimeoutException;
        }
    .end annotation

    .prologue
    .line 266
    new-instance v3, Lorg/apache/http/client/methods/HttpPost;

    const-string/jumbo v7, "/metricsBatch"

    invoke-direct {v3, v7}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 267
    .local v3, "postRequest":Lorg/apache/http/client/methods/HttpPost;
    new-instance v0, Lorg/apache/http/entity/ByteArrayEntity;

    invoke-direct {v0, p1}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V

    .line 269
    .local v0, "byteArrayEntity":Lorg/apache/http/entity/ByteArrayEntity;
    invoke-virtual {v3, v0}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 271
    new-instance v7, Lamazon/communication/srr/SrrRequest$Builder;

    invoke-direct {v7}, Lamazon/communication/srr/SrrRequest$Builder;-><init>()V

    invoke-virtual {v7, v3}, Lamazon/communication/srr/SrrRequest$Builder;->setRequest(Lorg/apache/http/client/methods/HttpRequestBase;)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    invoke-virtual {v7, p3}, Lamazon/communication/srr/SrrRequest$Builder;->setEndpointIdentity(Lamazon/communication/identity/EndpointIdentity;)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Lamazon/communication/srr/SrrRequest$Builder;->setTimeout(I)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    invoke-virtual {v7, p2}, Lamazon/communication/srr/SrrRequest$Builder;->setMetricEvent(Lcom/amazon/client/metrics/MetricEvent;)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v8

    iget-object v7, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsHttpRequestSigner:Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;

    invoke-virtual {v7}, Lcom/amazon/client/metrics/transport/MetricsHttpRequestSigner;->getNextRequestSigner()Lamazon/communication/authentication/RequestSigner;

    move-result-object v7

    instance-of v7, v7, Lcom/amazon/communication/authentication/DcpRequestSigner;

    if-eqz v7, :cond_1

    sget-object v7, Lamazon/communication/authentication/AccountRequestContext;->EMPTY_ACCOUNT:Lamazon/communication/authentication/AccountRequestContext;

    :goto_0
    invoke-virtual {v8, v7}, Lamazon/communication/srr/SrrRequest$Builder;->setRequestContext(Lamazon/communication/authentication/RequestContext;)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    invoke-virtual {v7}, Lamazon/communication/srr/SrrRequest$Builder;->build()Lamazon/communication/srr/SrrRequest;

    move-result-object v5

    .line 280
    .local v5, "srrRequest":Lamazon/communication/srr/SrrRequest;
    iget-object v7, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mSrrManager:Lamazon/communication/srr/SrrManager;

    invoke-interface {v7, v5}, Lamazon/communication/srr/SrrManager;->makeRequestSync(Lamazon/communication/srr/SrrRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v4

    .line 282
    .local v4, "response":Lorg/apache/http/HttpResponse;
    if-eqz v4, :cond_5

    .line 284
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v6

    .line 285
    .local v6, "status":Lorg/apache/http/StatusLine;
    sget-object v7, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "transmit"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "HttpResponse status code:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 288
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    .line 289
    .local v1, "entity":Lorg/apache/http/HttpEntity;
    if-nez v1, :cond_2

    const/4 v2, 0x0

    .line 290
    .local v2, "entityInputStream":Ljava/io/InputStream;
    :goto_1
    if-eqz v2, :cond_0

    .line 291
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    .line 294
    :cond_0
    if-eqz v6, :cond_5

    .line 295
    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0xc8

    if-lt v7, v8, :cond_3

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x12c

    if-ge v7, v8, :cond_3

    .line 296
    sget-object v7, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "transmit"

    const-string/jumbo v9, "Succesfully transmitted Metric"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 297
    const/4 v7, 0x1

    .line 305
    .end local v1    # "entity":Lorg/apache/http/HttpEntity;
    .end local v2    # "entityInputStream":Ljava/io/InputStream;
    .end local v6    # "status":Lorg/apache/http/StatusLine;
    :goto_2
    return v7

    .line 271
    .end local v4    # "response":Lorg/apache/http/HttpResponse;
    .end local v5    # "srrRequest":Lamazon/communication/srr/SrrRequest;
    :cond_1
    const/4 v7, 0x0

    goto :goto_0

    .line 289
    .restart local v1    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v4    # "response":Lorg/apache/http/HttpResponse;
    .restart local v5    # "srrRequest":Lamazon/communication/srr/SrrRequest;
    .restart local v6    # "status":Lorg/apache/http/StatusLine;
    :cond_2
    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v2

    goto :goto_1

    .line 298
    .restart local v2    # "entityInputStream":Ljava/io/InputStream;
    :cond_3
    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x190

    if-lt v7, v8, :cond_4

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x1f4

    if-ge v7, v8, :cond_4

    .line 299
    const/4 v7, 0x3

    goto :goto_2

    .line 300
    :cond_4
    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x1f4

    if-lt v7, v8, :cond_5

    .line 301
    const/4 v7, 0x4

    goto :goto_2

    .line 305
    .end local v1    # "entity":Lorg/apache/http/HttpEntity;
    .end local v2    # "entityInputStream":Ljava/io/InputStream;
    .end local v6    # "status":Lorg/apache/http/StatusLine;
    :cond_5
    const/16 v7, 0xc

    goto :goto_2
.end method


# virtual methods
.method public close()V
    .locals 4

    .prologue
    .line 313
    iget-object v0, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    const-wide/16 v1, 0x0

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, v1, v2, v3}, Lorg/apache/http/conn/ClientConnectionManager;->closeIdleConnections(JLjava/util/concurrent/TimeUnit;)V

    .line 314
    iget-object v0, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/conn/ClientConnectionManager;->closeExpiredConnections()V

    .line 315
    return-void
.end method

.method protected isEthernetAvailable()Z
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 155
    iget-object v1, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getNetworkConfiguration()Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/client/metrics/configuration/NetworkConfiguration;->getNetworkTypes()Ljava/util/Set;

    move-result-object v1

    sget-object v2, Lcom/amazon/client/metrics/configuration/NetworkType;->ETHERNET:Lcom/amazon/client/metrics/configuration/NetworkType;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    .line 156
    .local v0, "isEthernetAllowed":Z
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/utils/NetworkManager;->isEthernetConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected isWanAvailable()Z
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 164
    iget-object v1, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getNetworkConfiguration()Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/client/metrics/configuration/NetworkConfiguration;->getNetworkTypes()Ljava/util/Set;

    move-result-object v1

    sget-object v2, Lcom/amazon/client/metrics/configuration/NetworkType;->WAN:Lcom/amazon/client/metrics/configuration/NetworkType;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    .line 165
    .local v0, "isWanAllowed":Z
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/utils/NetworkManager;->isWanConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected isWifiAvailable()Z
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 146
    iget-object v1, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getNetworkConfiguration()Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/client/metrics/configuration/NetworkConfiguration;->getNetworkTypes()Ljava/util/Set;

    move-result-object v1

    sget-object v2, Lcom/amazon/client/metrics/configuration/NetworkType;->WIFI:Lcom/amazon/client/metrics/configuration/NetworkType;

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    .line 147
    .local v0, "isWifiAllowed":Z
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/device/utils/NetworkManager;->instance(Landroid/content/Context;)Lcom/amazon/device/utils/NetworkManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/utils/NetworkManager;->isWifiConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public listenForTransportWarmed(Lcom/amazon/client/metrics/transport/TransportStateNotifier$TransportWarmedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/client/metrics/transport/TransportStateNotifier$TransportWarmedListener;

    .prologue
    .line 332
    return-void
.end method

.method public shutdown()V
    .locals 1

    .prologue
    .line 323
    iget-object v0, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-interface {v0}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    .line 324
    return-void
.end method

.method public transmit([BLcom/amazon/client/metrics/MetricEvent;)I
    .locals 4
    .param p1, "data"    # [B
    .param p2, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    const/4 v3, 0x0

    .line 185
    if-eqz p1, :cond_0

    array-length v0, p1

    if-nez v0, :cond_1

    .line 186
    :cond_0
    sget-object v0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "transmit"

    const-string/jumbo v2, "Transmitted metricBatch cannot be null"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 187
    const/16 v0, 0x8

    .line 196
    :goto_0
    return v0

    .line 190
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->isWifiAvailable()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {p0}, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->isEthernetAvailable()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {p0}, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->isWanAvailable()Z

    move-result v0

    if-nez v0, :cond_2

    .line 191
    sget-object v0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "transmit"

    const-string/jumbo v2, "Aborting metrics transmission because there is no usable connection."

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 192
    const/4 v0, 0x7

    goto :goto_0

    .line 196
    :cond_2
    iget-object v0, p0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getEndpointIdentity()Lamazon/communication/identity/EndpointIdentity;

    move-result-object v0

    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;->attemptToTransmit([BLcom/amazon/client/metrics/MetricEvent;Lamazon/communication/identity/EndpointIdentity;Z)I

    move-result v0

    goto :goto_0
.end method
