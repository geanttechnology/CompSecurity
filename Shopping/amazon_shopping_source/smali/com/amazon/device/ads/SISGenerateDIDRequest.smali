.class Lcom/amazon/device/ads/SISGenerateDIDRequest;
.super Lcom/amazon/device/ads/SISDeviceRequest;
.source "SISRequests.java"


# static fields
.field private static final CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

.field private static final LOG_TAG:Ljava/lang/String; = "SISGenerateDIDRequest"

.field private static final PATH:Ljava/lang/String; = "/generate_did"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 130
    sget-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_REGISTER:Lcom/amazon/device/ads/Metrics$MetricType;

    sput-object v0, Lcom/amazon/device/ads/SISGenerateDIDRequest;->CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 135
    invoke-direct {p0}, Lcom/amazon/device/ads/SISDeviceRequest;-><init>()V

    .line 136
    sget-object v0, Lcom/amazon/device/ads/SISGenerateDIDRequest;->CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/SISGenerateDIDRequest;->setCallMetricType(Lcom/amazon/device/ads/Metrics$MetricType;)Lcom/amazon/device/ads/SISDeviceRequest;

    .line 137
    const-string/jumbo v0, "SISGenerateDIDRequest"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/SISGenerateDIDRequest;->setLogTag(Ljava/lang/String;)Lcom/amazon/device/ads/SISDeviceRequest;

    .line 138
    const-string/jumbo v0, "/generate_did"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/SISGenerateDIDRequest;->setPath(Ljava/lang/String;)Lcom/amazon/device/ads/SISDeviceRequest;

    .line 139
    return-void
.end method


# virtual methods
.method public onResponseReceived(Lorg/json/JSONObject;)V
    .locals 3
    .param p1, "payload"    # Lorg/json/JSONObject;

    .prologue
    .line 144
    const-string/jumbo v1, "adId"

    const-string/jumbo v2, ""

    invoke-static {p1, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getStringFromJSON(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 145
    .local v0, "adId":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 147
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/device/ads/SISGenerateDIDRequest;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lcom/amazon/device/ads/RegistrationInfo;->putAdId(Ljava/lang/String;Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)V

    .line 149
    :cond_0
    return-void
.end method
