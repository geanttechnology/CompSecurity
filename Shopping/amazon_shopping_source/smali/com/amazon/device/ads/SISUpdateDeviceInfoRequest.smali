.class Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;
.super Lcom/amazon/device/ads/SISDeviceRequest;
.source "SISRequests.java"


# static fields
.field private static final CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

.field private static final LOG_TAG:Ljava/lang/String; = "SISUpdateDeviceInfoRequest"

.field private static final PATH:Ljava/lang/String; = "/update_dev_info"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 156
    sget-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_UPDATE_DEVICE_INFO:Lcom/amazon/device/ads/Metrics$MetricType;

    sput-object v0, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;->CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 161
    invoke-direct {p0}, Lcom/amazon/device/ads/SISDeviceRequest;-><init>()V

    .line 162
    sget-object v0, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;->CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;->setCallMetricType(Lcom/amazon/device/ads/Metrics$MetricType;)Lcom/amazon/device/ads/SISDeviceRequest;

    .line 163
    const-string/jumbo v0, "SISUpdateDeviceInfoRequest"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;->setLogTag(Ljava/lang/String;)Lcom/amazon/device/ads/SISDeviceRequest;

    .line 164
    const-string/jumbo v0, "/update_dev_info"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;->setPath(Ljava/lang/String;)Lcom/amazon/device/ads/SISDeviceRequest;

    .line 165
    return-void
.end method


# virtual methods
.method public getQueryParameters()Lcom/amazon/device/ads/WebRequest$QueryStringParameters;
    .locals 4

    .prologue
    .line 170
    const-string/jumbo v2, "debug.adid"

    invoke-virtual {p0}, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getSISDeviceIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 174
    .local v0, "adId":Ljava/lang/String;
    invoke-super {p0}, Lcom/amazon/device/ads/SISDeviceRequest;->getQueryParameters()Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    move-result-object v1

    .line 175
    .local v1, "baseQueryParameters":Lcom/amazon/device/ads/WebRequest$QueryStringParameters;
    invoke-static {v0}, Lcom/amazon/device/ads/Utils;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 177
    const-string/jumbo v2, "adId"

    invoke-virtual {v1, v2, v0}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    :cond_0
    return-object v1
.end method

.method public onResponseReceived(Lorg/json/JSONObject;)V
    .locals 4
    .param p1, "payload"    # Lorg/json/JSONObject;

    .prologue
    .line 189
    const-string/jumbo v2, "adId"

    const-string/jumbo v3, ""

    invoke-static {p1, v2, v3}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 190
    .local v0, "adId":Ljava/lang/String;
    const-string/jumbo v2, "idChanged"

    const/4 v3, 0x0

    invoke-static {p1, v2, v3}, Lcom/amazon/device/ads/JSONUtils;->getBooleanFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Z)Z

    move-result v1

    .line 192
    .local v1, "idChanged":Z
    if-eqz v1, :cond_0

    .line 194
    invoke-static {}, Lcom/amazon/device/ads/Metrics;->getInstance()Lcom/amazon/device/ads/Metrics;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/Metrics;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 196
    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 198
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/device/ads/SISUpdateDeviceInfoRequest;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Lcom/amazon/device/ads/RegistrationInfo;->putAdId(Ljava/lang/String;Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)V

    .line 200
    :cond_1
    return-void
.end method
