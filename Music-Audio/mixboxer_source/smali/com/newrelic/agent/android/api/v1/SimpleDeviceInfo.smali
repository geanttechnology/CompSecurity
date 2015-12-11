.class public final Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;
.super Ljava/lang/Object;
.source "SimpleDeviceInfo.java"

# interfaces
.implements Lcom/newrelic/agent/android/api/v1/DeviceInfo;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;
    }
.end annotation


# instance fields
.field private final jsonArray:Lorg/json/JSONArray;


# direct methods
.method public constructor <init>()V
    .locals 9

    .prologue
    const/4 v1, 0x0

    .line 27
    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    move-object v5, v1

    move-object v6, v1

    move-object v7, v1

    move-object v8, v1

    invoke-direct/range {v0 .. v8}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 28
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 5
    .param p1, "osName"    # Ljava/lang/String;
    .param p2, "osVersion"    # Ljava/lang/String;
    .param p3, "manufacturer"    # Ljava/lang/String;
    .param p4, "model"    # Ljava/lang/String;
    .param p5, "agentName"    # Ljava/lang/String;
    .param p6, "agentVersion"    # Ljava/lang/String;
    .param p7, "deviceId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p8, "misc":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v4, 0x0

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const/16 v0, 0xa

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/4 v1, 0x1

    aput-object p2, v0, v1

    const/4 v1, 0x2

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x3

    aput-object p5, v0, v1

    const/4 v1, 0x4

    aput-object p6, v0, v1

    const/4 v1, 0x5

    aput-object p7, v0, v1

    const/4 v1, 0x6

    aput-object v4, v0, v1

    const/4 v1, 0x7

    aput-object v4, v0, v1

    const/16 v1, 0x8

    aput-object p3, v0, v1

    const/16 v1, 0x9

    aput-object p8, v0, v1

    invoke-static {v0}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->newJSONArray([Ljava/lang/Object;)Lorg/json/JSONArray;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->jsonArray:Lorg/json/JSONArray;

    .line 32
    return-void
.end method

.method private constructor <init>(Lorg/json/JSONArray;)V
    .locals 3
    .param p1, "array"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1}, Lorg/json/JSONArray;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->jsonArray:Lorg/json/JSONArray;

    .line 36
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 37
    iget-object v1, p0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->jsonArray:Lorg/json/JSONArray;

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 36
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 39
    :cond_0
    return-void
.end method

.method private static convertValue(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "arg"    # Ljava/lang/Object;

    .prologue
    .line 102
    instance-of v0, p0, Ljava/util/Collection;

    if-eqz v0, :cond_1

    .line 103
    new-instance v0, Lorg/json/JSONArray;

    check-cast p0, Ljava/util/Collection;

    .end local p0    # "arg":Ljava/lang/Object;
    invoke-direct {v0, p0}, Lorg/json/JSONArray;-><init>(Ljava/util/Collection;)V

    move-object p0, v0

    .line 112
    :cond_0
    :goto_0
    return-object p0

    .line 105
    .restart local p0    # "arg":Ljava/lang/Object;
    :cond_1
    instance-of v0, p0, Ljava/util/Map;

    if-eqz v0, :cond_2

    .line 106
    new-instance v0, Lorg/json/JSONObject;

    check-cast p0, Ljava/util/Map;

    .end local p0    # "arg":Ljava/lang/Object;
    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    move-object p0, v0

    goto :goto_0

    .line 108
    .restart local p0    # "arg":Ljava/lang/Object;
    :cond_2
    if-nez p0, :cond_0

    .line 109
    sget-object p0, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    goto :goto_0
.end method

.method private static varargs newJSONArray([Ljava/lang/Object;)Lorg/json/JSONArray;
    .locals 6
    .param p0, "args"    # [Ljava/lang/Object;

    .prologue
    .line 117
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1}, Lorg/json/JSONArray;-><init>()V

    .line 118
    .local v1, "arr":Lorg/json/JSONArray;
    move-object v2, p0

    .local v2, "arr$":[Ljava/lang/Object;
    array-length v4, v2

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, v2, v3

    .line 119
    .local v0, "arg":Ljava/lang/Object;
    invoke-static {v0}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->convertValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v1, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 118
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 121
    .end local v0    # "arg":Ljava/lang/Object;
    :cond_0
    return-object v1
.end method

.method private put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V
    .locals 3
    .param p1, "field"    # Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 98
    iget-object v0, p0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->jsonArray:Lorg/json/JSONArray;

    invoke-virtual {p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->ordinal()I

    move-result v1

    invoke-static {p2}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->convertValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONArray;->put(ILjava/lang/Object;)Lorg/json/JSONArray;

    .line 99
    return-void
.end method


# virtual methods
.method public setAgentName(Ljava/lang/String;)V
    .locals 1
    .param p1, "agentName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 65
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->AGENT_NAME:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 66
    return-void
.end method

.method public setAgentVersion(Ljava/lang/String;)V
    .locals 1
    .param p1, "agentVersion"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 69
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->AGENT_VERSION:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 70
    return-void
.end method

.method public setCountryCode(Ljava/lang/String;)V
    .locals 1
    .param p1, "countryCode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 77
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->COUNTRY_CODE:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 78
    return-void
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 1
    .param p1, "deviceId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 73
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->DEVICE_ID:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 74
    return-void
.end method

.method public setManufacturer(Ljava/lang/String;)V
    .locals 1
    .param p1, "manufacturer"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 85
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MANUFACTURER:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 86
    return-void
.end method

.method public setMisc(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 89
    .local p1, "misc":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MISC:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 90
    return-void
.end method

.method public setModel(Ljava/lang/String;)V
    .locals 1
    .param p1, "model"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 61
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->MANUFACTURER_MODEL:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 62
    return-void
.end method

.method public setOsName(Ljava/lang/String;)V
    .locals 1
    .param p1, "osName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 53
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->OS_NAME:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 54
    return-void
.end method

.method public setOsVersion(Ljava/lang/String;)V
    .locals 1
    .param p1, "osVersion"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 57
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->OS_VERSION:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 58
    return-void
.end method

.method public setRegionCode(Ljava/lang/String;)V
    .locals 1
    .param p1, "regionCode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 81
    sget-object v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;->REGION_CODE:Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;

    invoke-direct {p0, v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->put(Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field;Ljava/lang/Object;)V

    .line 82
    return-void
.end method

.method public toJSONArray()Lorg/json/JSONArray;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->jsonArray:Lorg/json/JSONArray;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    invoke-virtual {p0}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->toJSONArray()Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v0}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public withLocation(Ljava/lang/String;Ljava/lang/String;)Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;
    .locals 2
    .param p1, "countryCode"    # Ljava/lang/String;
    .param p2, "regionCode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 42
    new-instance v0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;

    iget-object v1, p0, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->jsonArray:Lorg/json/JSONArray;

    invoke-direct {v0, v1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;-><init>(Lorg/json/JSONArray;)V

    .line 43
    .local v0, "deviceInfo":Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;
    invoke-virtual {v0, p1}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->setCountryCode(Ljava/lang/String;)V

    .line 44
    invoke-virtual {v0, p2}, Lcom/newrelic/agent/android/api/v1/SimpleDeviceInfo;->setRegionCode(Ljava/lang/String;)V

    .line 45
    return-object v0
.end method
