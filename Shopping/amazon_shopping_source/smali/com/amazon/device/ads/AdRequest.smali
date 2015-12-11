.class Lcom/amazon/device/ads/AdRequest;
.super Ljava/lang/Object;
.source "AdRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;,
        Lcom/amazon/device/ads/AdRequest$LOISlot;
    }
.end annotation


# static fields
.field private static final AAX_ENDPOINT:Ljava/lang/String; = "/e/msdk/ads"

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final PARAMETERS:[Lcom/amazon/device/ads/AAXParameter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Lcom/amazon/device/ads/AAXParameter",
            "<*>;"
        }
    .end annotation
.end field


# instance fields
.field private advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

.field private final connectionType:Ljava/lang/String;

.field private instrPixelUrl:Ljava/lang/String;

.field private final jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

.field private final opt:Lcom/amazon/device/ads/AdTargetingOptions;

.field private final orientation:Ljava/lang/String;

.field private final screenSize:Lcom/amazon/device/ads/Size;

.field protected final slots:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/amazon/device/ads/AdRequest$LOISlot;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 25
    const-class v0, Lcom/amazon/device/ads/AdRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AdRequest;->LOG_TAG:Ljava/lang/String;

    .line 28
    const/16 v0, 0x10

    new-array v0, v0, [Lcom/amazon/device/ads/AAXParameter;

    const/4 v1, 0x0

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->APP_KEY:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->CHANNEL:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->PUBLISHER_KEYWORDS:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->PUBLISHER_ASINS:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->USER_AGENT:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->SDK_VERSION:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->GEOLOCATION:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->USER_INFO:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->DEVICE_INFO:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->PACKAGE_INFO:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->TEST:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->SIS_DEVICE_IDENTIFIER:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->SHA1_UDID:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->MD5_UDID:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->ADVERTISING_IDENTIFIER:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/device/ads/AAXParameter;->OPT_OUT:Lcom/amazon/device/ads/AAXParameter;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/device/ads/AdRequest;->PARAMETERS:[Lcom/amazon/device/ads/AAXParameter;

    return-void
.end method

.method constructor <init>(Lcom/amazon/device/ads/AdTargetingOptions;)V
    .locals 5
    .param p1, "opt"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "UseSparseArrays"
        }
    .end annotation

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object p1, p0, Lcom/amazon/device/ads/AdRequest;->opt:Lcom/amazon/device/ads/AdTargetingOptions;

    .line 69
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    iput-object v3, p0, Lcom/amazon/device/ads/AdRequest;->slots:Ljava/util/Map;

    .line 70
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v1

    .line 71
    .local v1, "deviceInfo":Lcom/amazon/device/ads/DeviceInfo;
    invoke-virtual {v1}, Lcom/amazon/device/ads/DeviceInfo;->getOrientation()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/device/ads/AdRequest;->orientation:Ljava/lang/String;

    .line 72
    iget-object v3, p0, Lcom/amazon/device/ads/AdRequest;->orientation:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/amazon/device/ads/DeviceInfo;->getScreenSize(Ljava/lang/String;)Lcom/amazon/device/ads/Size;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/device/ads/AdRequest;->screenSize:Lcom/amazon/device/ads/Size;

    .line 73
    invoke-virtual {v1}, Lcom/amazon/device/ads/DeviceInfo;->getConnectionType()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/device/ads/AdRequest;->connectionType:Ljava/lang/String;

    .line 75
    iget-object v3, p0, Lcom/amazon/device/ads/AdRequest;->opt:Lcom/amazon/device/ads/AdTargetingOptions;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdTargetingOptions;->getCopyOfAdvancedOptions()Ljava/util/HashMap;

    move-result-object v0

    .line 76
    .local v0, "advancedOptions":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v3, Lcom/amazon/device/ads/AAXParameter$ParameterData;

    invoke-direct {v3}, Lcom/amazon/device/ads/AAXParameter$ParameterData;-><init>()V

    invoke-virtual {v3, v0}, Lcom/amazon/device/ads/AAXParameter$ParameterData;->setAdvancedOptions(Ljava/util/Map;)Lcom/amazon/device/ads/AAXParameter$ParameterData;

    move-result-object v3

    invoke-virtual {v3, p0}, Lcom/amazon/device/ads/AAXParameter$ParameterData;->setAdRequest(Lcom/amazon/device/ads/AdRequest;)Lcom/amazon/device/ads/AAXParameter$ParameterData;

    move-result-object v2

    .line 79
    .local v2, "parameterData":Lcom/amazon/device/ads/AAXParameter$ParameterData;
    new-instance v3, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    invoke-direct {v3}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;-><init>()V

    sget-object v4, Lcom/amazon/device/ads/AdRequest;->PARAMETERS:[Lcom/amazon/device/ads/AAXParameter;

    invoke-virtual {v3, v4}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->setAAXParameters([Lcom/amazon/device/ads/AAXParameter;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->setAdvancedOptions(Ljava/util/Map;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->setParameterData(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/device/ads/AdRequest;->jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    .line 83
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/amazon/device/ads/AdRequest;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method getAdTargetingOptions()Lcom/amazon/device/ads/AdTargetingOptions;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest;->opt:Lcom/amazon/device/ads/AdTargetingOptions;

    return-object v0
.end method

.method getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    return-object v0
.end method

.method public getInstrumentationPixelURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest;->instrPixelUrl:Ljava/lang/String;

    return-object v0
.end method

.method getOrientation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest;->orientation:Ljava/lang/String;

    return-object v0
.end method

.method protected getSlots()Lorg/json/JSONArray;
    .locals 4

    .prologue
    .line 137
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 138
    .local v0, "array":Lorg/json/JSONArray;
    iget-object v3, p0, Lcom/amazon/device/ads/AdRequest;->slots:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/ads/AdRequest$LOISlot;

    .line 140
    .local v2, "slot":Lcom/amazon/device/ads/AdRequest$LOISlot;
    invoke-virtual {v2}, Lcom/amazon/device/ads/AdRequest$LOISlot;->getJSON()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v0, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 143
    .end local v2    # "slot":Lcom/amazon/device/ads/AdRequest$LOISlot;
    :cond_0
    return-object v0
.end method

.method public getWebRequest()Lcom/amazon/device/ads/WebRequest;
    .locals 3

    .prologue
    .line 152
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->createNewWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v0

    .line 153
    .local v0, "request":Lcom/amazon/device/ads/WebRequest;
    sget-object v1, Lcom/amazon/device/ads/AdRequest;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setExternalLogTag(Ljava/lang/String;)V

    .line 154
    sget-object v1, Lcom/amazon/device/ads/WebRequest$HttpMethod;->POST:Lcom/amazon/device/ads/WebRequest$HttpMethod;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setHttpMethod(Lcom/amazon/device/ads/WebRequest$HttpMethod;)V

    .line 155
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v1

    sget-object v2, Lcom/amazon/device/ads/Configuration$ConfigOption;->AAX_HOSTNAME:Lcom/amazon/device/ads/Configuration$ConfigOption;

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/Configuration;->getString(Lcom/amazon/device/ads/Configuration$ConfigOption;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setHost(Ljava/lang/String;)V

    .line 156
    const-string/jumbo v1, "/e/msdk/ads"

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setPath(Ljava/lang/String;)V

    .line 157
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->enableLog(Z)V

    .line 158
    const-string/jumbo v1, "application/json"

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/WebRequest;->setContentType(Ljava/lang/String;)V

    .line 160
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AdRequest;->setParametersInWebRequest(Lcom/amazon/device/ads/WebRequest;)V

    .line 161
    return-object v0
.end method

.method public putSlot(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdTargetingOptions;)V
    .locals 3
    .param p1, "adData"    # Lcom/amazon/device/ads/AdData;
    .param p2, "adTargetingOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;

    .prologue
    .line 119
    iget-object v1, p0, Lcom/amazon/device/ads/AdRequest;->connectionType:Ljava/lang/String;

    invoke-virtual {p1, v1}, Lcom/amazon/device/ads/AdData;->setConnectionType(Ljava/lang/String;)V

    .line 120
    iget-object v1, p0, Lcom/amazon/device/ads/AdRequest;->screenSize:Lcom/amazon/device/ads/Size;

    invoke-virtual {v1}, Lcom/amazon/device/ads/Size;->getHeight()I

    move-result v1

    invoke-virtual {p1, v1}, Lcom/amazon/device/ads/AdData;->setScreenHeight(I)V

    .line 121
    iget-object v1, p0, Lcom/amazon/device/ads/AdRequest;->screenSize:Lcom/amazon/device/ads/Size;

    invoke-virtual {v1}, Lcom/amazon/device/ads/Size;->getWidth()I

    move-result v1

    invoke-virtual {p1, v1}, Lcom/amazon/device/ads/AdData;->setScreenWidth(I)V

    .line 123
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRequest;->getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/AdvertisingIdentifier$Info;->hasSISDeviceIdentifier()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 125
    invoke-virtual {p1}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v1

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_IDENTIFIED_DEVICE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 128
    :cond_0
    new-instance v0, Lcom/amazon/device/ads/AdRequest$LOISlot;

    invoke-direct {v0, p1, p2, p0}, Lcom/amazon/device/ads/AdRequest$LOISlot;-><init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/AdTargetingOptions;Lcom/amazon/device/ads/AdRequest;)V

    .line 129
    .local v0, "slot":Lcom/amazon/device/ads/AdRequest$LOISlot;
    iget-object v1, p0, Lcom/amazon/device/ads/AdRequest;->slots:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdRequest$LOISlot;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/device/ads/AdData;->getSlotId()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 130
    return-void
.end method

.method setAdvertisingIdentifierInfo(Lcom/amazon/device/ads/AdvertisingIdentifier$Info;)Lcom/amazon/device/ads/AdRequest;
    .locals 0
    .param p1, "advertisingIdentifierInfo"    # Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/amazon/device/ads/AdRequest;->advertisingIdentifierInfo:Lcom/amazon/device/ads/AdvertisingIdentifier$Info;

    .line 114
    return-object p0
.end method

.method public setInstrumentationPixelURL(Ljava/lang/String;)V
    .locals 0
    .param p1, "instrPixelUrl"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/amazon/device/ads/AdRequest;->instrPixelUrl:Ljava/lang/String;

    .line 88
    return-void
.end method

.method protected setParametersInWebRequest(Lcom/amazon/device/ads/WebRequest;)V
    .locals 5
    .param p1, "request"    # Lcom/amazon/device/ads/WebRequest;

    .prologue
    .line 166
    iget-object v3, p0, Lcom/amazon/device/ads/AdRequest;->jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->build()V

    .line 169
    sget-object v3, Lcom/amazon/device/ads/AAXParameter;->SLOTS:Lcom/amazon/device/ads/AAXParameter;

    iget-object v4, p0, Lcom/amazon/device/ads/AdRequest;->jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    invoke-virtual {v4}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->getParameterData()Lcom/amazon/device/ads/AAXParameter$ParameterData;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/device/ads/AAXParameter;->getValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/Object;

    move-result-object v2

    .line 170
    .local v2, "slots":Ljava/lang/Object;
    if-nez v2, :cond_0

    .line 172
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdRequest;->getSlots()Lorg/json/JSONArray;

    move-result-object v2

    .line 174
    .end local v2    # "slots":Ljava/lang/Object;
    :cond_0
    iget-object v3, p0, Lcom/amazon/device/ads/AdRequest;->jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    sget-object v4, Lcom/amazon/device/ads/AAXParameter;->SLOTS:Lcom/amazon/device/ads/AAXParameter;

    invoke-virtual {v3, v4, v2}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->putIntoJSON(Lcom/amazon/device/ads/AAXParameter;Ljava/lang/Object;)V

    .line 175
    iget-object v3, p0, Lcom/amazon/device/ads/AdRequest;->jsonObjectBuilder:Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;

    invoke-virtual {v3}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->getJSON()Lorg/json/JSONObject;

    move-result-object v1

    .line 178
    .local v1, "json":Lorg/json/JSONObject;
    const-string/jumbo v3, "debug.aaxAdParams"

    const/4 v4, 0x0

    invoke-static {v3, v4}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 179
    .local v0, "additionalTargetingParams":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/device/ads/Utils;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 181
    invoke-virtual {p1, v0}, Lcom/amazon/device/ads/WebRequest;->setAdditionalQueryParamsString(Ljava/lang/String;)V

    .line 183
    :cond_1
    invoke-virtual {p0, p1, v1}, Lcom/amazon/device/ads/AdRequest;->setRequestBodyString(Lcom/amazon/device/ads/WebRequest;Lorg/json/JSONObject;)V

    .line 184
    return-void
.end method

.method protected setRequestBodyString(Lcom/amazon/device/ads/WebRequest;Lorg/json/JSONObject;)V
    .locals 1
    .param p1, "request"    # Lcom/amazon/device/ads/WebRequest;
    .param p2, "json"    # Lorg/json/JSONObject;

    .prologue
    .line 188
    invoke-virtual {p2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/amazon/device/ads/WebRequest;->setRequestBodyString(Ljava/lang/String;)V

    .line 189
    return-void
.end method
