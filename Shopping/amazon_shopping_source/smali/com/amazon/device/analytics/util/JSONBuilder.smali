.class public Lcom/amazon/device/analytics/util/JSONBuilder;
.super Ljava/lang/Object;
.source "JSONBuilder.java"

# interfaces
.implements Lcom/amazon/device/analytics/util/JSONSerializable;


# instance fields
.field private json:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 2
    .param p1, "component"    # Ljava/lang/Object;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/util/JSONBuilder;->json:Lorg/json/JSONObject;

    .line 15
    if-eqz p1, :cond_0

    .line 16
    const-string/jumbo v0, "class"

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 17
    const-string/jumbo v0, "hashCode"

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 19
    :cond_0
    return-void
.end method


# virtual methods
.method public toJSONObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/device/analytics/util/JSONBuilder;->json:Lorg/json/JSONObject;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 45
    :try_start_0
    iget-object v1, p0, Lcom/amazon/device/analytics/util/JSONBuilder;->json:Lorg/json/JSONObject;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 47
    :goto_0
    return-object v1

    .line 46
    :catch_0
    move-exception v0

    .line 47
    .local v0, "e":Lorg/json/JSONException;
    iget-object v1, p0, Lcom/amazon/device/analytics/util/JSONBuilder;->json:Lorg/json/JSONObject;

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 22
    if-nez p2, :cond_0

    .line 34
    .end local p2    # "value":Ljava/lang/Object;
    :goto_0
    return-object p0

    .line 27
    .restart local p2    # "value":Ljava/lang/Object;
    :cond_0
    :try_start_0
    const-class v0, Lcom/amazon/device/analytics/util/JSONSerializable;

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 28
    iget-object v0, p0, Lcom/amazon/device/analytics/util/JSONBuilder;->json:Lorg/json/JSONObject;

    check-cast p2, Lcom/amazon/device/analytics/util/JSONSerializable;

    .end local p2    # "value":Ljava/lang/Object;
    invoke-interface {p2}, Lcom/amazon/device/analytics/util/JSONSerializable;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 32
    :catch_0
    move-exception v0

    goto :goto_0

    .line 30
    .restart local p2    # "value":Ljava/lang/Object;
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/analytics/util/JSONBuilder;->json:Lorg/json/JSONObject;

    invoke-virtual {v0, p1, p2}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0
.end method
