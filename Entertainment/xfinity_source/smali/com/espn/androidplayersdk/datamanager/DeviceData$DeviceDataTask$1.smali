.class Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;
.super Ljava/lang/Object;
.source "DeviceData.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;->this$1:Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;

    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleError(I)V
    .locals 4
    .param p1, "errorCode"    # I

    .prologue
    .line 163
    const-string v0, "Device ID failed. Setting defaults."

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 167
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "isDeviceIdentified"

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 168
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "deviceType"

    const-string v3, "handset"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 169
    return-void
.end method

.method public update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V
    .locals 0
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 173
    return-void
.end method

.method public update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 8
    .param p1, "object"    # Lorg/json/JSONObject;
    .param p2, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v7, 0x0

    .line 130
    :try_start_0
    const-string v3, "access_token"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    const-string v3, "access_token"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 131
    const-string v3, "Device token success. Requesting device ID"

    const/4 v4, 0x2

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 132
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "http://api.devicedata.go.com/deviceDataWS/rs/composite-views/deviceatlas/devices/oneshot?oauth_token="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "access_token"

    invoke-virtual {p1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 134
    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;->this$1:Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;

    invoke-virtual {v3, p2}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->getRequest(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 135
    .local v2, "obj":Lorg/json/JSONObject;
    if-eqz v2, :cond_3

    const-string v3, "capabilities"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    const-string v3, "capabilities"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 136
    const-string v3, "Device Data received"

    const/4 v4, 0x2

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 137
    const-string v3, "capabilities"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 138
    .local v0, "capabilities":Lorg/json/JSONObject;
    const-string v3, "isTablet"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "isTablet"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 139
    :cond_0
    const-string v3, "1"

    const-string v4, "isTablet"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 140
    const-string v3, "Device is a tablet"

    const/4 v4, 0x2

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 141
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "config"

    const-string v5, "isDeviceIdentified"

    const/4 v6, 0x1

    invoke-virtual {v3, v4, v5, v6}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 142
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "config"

    const-string v5, "deviceType"

    const-string v6, "tablet"

    invoke-virtual {v3, v4, v5, v6}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    .end local v0    # "capabilities":Lorg/json/JSONObject;
    .end local v2    # "obj":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 144
    .restart local v0    # "capabilities":Lorg/json/JSONObject;
    .restart local v2    # "obj":Lorg/json/JSONObject;
    :cond_1
    const-string v3, "Device is a phone"

    const/4 v4, 0x2

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 145
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "config"

    const-string v5, "isDeviceIdentified"

    const/4 v6, 0x1

    invoke-virtual {v3, v4, v5, v6}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putBooleanField(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 146
    new-instance v3, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v4, "config"

    const-string v5, "deviceType"

    const-string v6, "handset"

    invoke-virtual {v3, v4, v5, v6}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 155
    .end local v0    # "capabilities":Lorg/json/JSONObject;
    .end local v2    # "obj":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 156
    .local v1, "e":Lorg/json/JSONException;
    const-string v3, "Error: Device ID failed"

    const/4 v4, 0x5

    invoke-static {v3, v4, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 157
    invoke-virtual {p0, v7}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;->handleError(I)V

    goto :goto_0

    .line 149
    .end local v1    # "e":Lorg/json/JSONException;
    .restart local v0    # "capabilities":Lorg/json/JSONObject;
    .restart local v2    # "obj":Lorg/json/JSONObject;
    :cond_2
    const/4 v3, 0x0

    :try_start_1
    invoke-virtual {p0, v3}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;->handleError(I)V

    goto :goto_0

    .line 151
    .end local v0    # "capabilities":Lorg/json/JSONObject;
    :cond_3
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;->handleError(I)V

    goto :goto_0

    .line 153
    .end local v2    # "obj":Lorg/json/JSONObject;
    :cond_4
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;->handleError(I)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
