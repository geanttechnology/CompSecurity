.class Lcom/amazon/device/ads/AAXParameter$JSONObjectParameter;
.super Lcom/amazon/device/ads/AAXParameter;
.source "AAXParameter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AAXParameter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "JSONObjectParameter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/device/ads/AAXParameter",
        "<",
        "Lorg/json/JSONObject;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "debugProperty"    # Ljava/lang/String;

    .prologue
    .line 252
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/AAXParameter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 253
    return-void
.end method


# virtual methods
.method protected bridge synthetic getFromDebugProperties()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 248
    invoke-virtual {p0}, Lcom/amazon/device/ads/AAXParameter$JSONObjectParameter;->getFromDebugProperties()Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected getFromDebugProperties()Lorg/json/JSONObject;
    .locals 3

    .prologue
    .line 272
    invoke-virtual {p0}, Lcom/amazon/device/ads/AAXParameter$JSONObjectParameter;->getDebugName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 273
    .local v0, "debugProperty":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/AAXParameter$JSONObjectParameter;->parseFromString(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    return-object v1
.end method

.method protected bridge synthetic parseFromString(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 248
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AAXParameter$JSONObjectParameter;->parseFromString(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected parseFromString(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 6
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 260
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 266
    :goto_0
    return-object v1

    .line 262
    :catch_0
    move-exception v0

    .line 264
    .local v0, "e":Lorg/json/JSONException;
    # getter for: Lcom/amazon/device/ads/AAXParameter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AAXParameter;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Unable to parse the following value into a JSONObject: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AAXParameter$JSONObjectParameter;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 266
    const/4 v1, 0x0

    goto :goto_0
.end method
