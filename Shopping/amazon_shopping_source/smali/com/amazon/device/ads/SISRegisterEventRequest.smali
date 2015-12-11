.class Lcom/amazon/device/ads/SISRegisterEventRequest;
.super Ljava/lang/Object;
.source "SISRequests.java"

# interfaces
.implements Lcom/amazon/device/ads/SISRequest;


# static fields
.field private static final CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

.field private static final LOG_TAG:Ljava/lang/String; = "SISRegisterEventRequest"

.field private static final PATH:Ljava/lang/String; = "/register_event"


# instance fields
.field private final advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

.field private final appEvents:Lorg/json/JSONArray;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 210
    sget-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_REGISTER_EVENT:Lcom/amazon/device/ads/Metrics$MetricType;

    sput-object v0, Lcom/amazon/device/ads/SISRegisterEventRequest;->CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;Lorg/json/JSONArray;)V
    .locals 0
    .param p1, "advertisingIdentifierInfo"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .param p2, "appEvents"    # Lorg/json/JSONArray;

    .prologue
    .line 219
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 220
    iput-object p1, p0, Lcom/amazon/device/ads/SISRegisterEventRequest;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .line 221
    iput-object p2, p0, Lcom/amazon/device/ads/SISRegisterEventRequest;->appEvents:Lorg/json/JSONArray;

    .line 222
    return-void
.end method


# virtual methods
.method public getCallMetricType()Lcom/amazon/device/ads/Metrics$MetricType;
    .locals 1

    .prologue
    .line 233
    sget-object v0, Lcom/amazon/device/ads/SISRegisterEventRequest;->CALL_METRIC_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    return-object v0
.end method

.method public getLogTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 227
    const-string/jumbo v0, "SISRegisterEventRequest"

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 239
    const-string/jumbo v0, "/register_event"

    return-object v0
.end method

.method public getPostParameters()Ljava/util/HashMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 261
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 262
    .local v0, "eventsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "events"

    iget-object v2, p0, Lcom/amazon/device/ads/SISRegisterEventRequest;->appEvents:Lorg/json/JSONArray;

    invoke-virtual {v2}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 263
    return-object v0
.end method

.method public getQueryParameters()Lcom/amazon/device/ads/WebRequest$QueryStringParameters;
    .locals 5

    .prologue
    .line 245
    new-instance v0, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;

    invoke-direct {v0}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;-><init>()V

    .line 246
    .local v0, "queryStringParameters":Lcom/amazon/device/ads/WebRequest$QueryStringParameters;
    const-string/jumbo v2, "adId"

    iget-object v3, p0, Lcom/amazon/device/ads/SISRegisterEventRequest;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->getSISDeviceIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    const-string/jumbo v2, "dt"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 249
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v1

    .line 250
    .local v1, "registrationInfo":Lcom/amazon/device/ads/RegistrationInfo;
    const-string/jumbo v2, "app"

    invoke-virtual {v1}, Lcom/amazon/device/ads/RegistrationInfo;->getAppName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    const-string/jumbo v2, "appId"

    invoke-virtual {v1}, Lcom/amazon/device/ads/RegistrationInfo;->getAppKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 253
    const-string/jumbo v2, "aud"

    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v3

    sget-object v4, Lcom/amazon/device/ads/Configuration$ConfigOption;->SIS_DOMAIN:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v3, v4}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/amazon/device/ads/WebRequest$QueryStringParameters;->putUrlEncoded(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    return-object v0
.end method

.method public onResponseReceived(Lorg/json/JSONObject;)V
    .locals 4
    .param p1, "payload"    # Lorg/json/JSONObject;

    .prologue
    .line 269
    const-string/jumbo v1, "rcode"

    const/4 v2, 0x0

    invoke-static {p1, v1, v2}, Lcom/amazon/device/ads/JSONUtils;->getIntegerFromJSON(Lorg/json/JSONObject;Ljava/lang/String;I)I

    move-result v0

    .line 271
    .local v0, "statusCode":I
    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 273
    const-string/jumbo v1, "SISRegisterEventRequest"

    const-string/jumbo v2, "Application events registered successfully."

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    invoke-static {}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->getInstance()Lcom/amazon/device/ads/AppEventRegistrationHandler;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->onAppEventsRegistered()V

    .line 280
    :goto_0
    return-void

    .line 278
    :cond_0
    const-string/jumbo v1, "SISRegisterEventRequest"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Application events not registered. rcode:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
