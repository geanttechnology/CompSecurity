.class Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;
.super Ljava/lang/Object;
.source "AdRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "JSONObjectBuilder"
.end annotation


# instance fields
.field private aaxParameters:[Lcom/amazon/device/ads/AAXParameter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Lcom/amazon/device/ads/AAXParameter",
            "<*>;"
        }
    .end annotation
.end field

.field private advancedOptions:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final json:Lorg/json/JSONObject;

.field private parameterData:Lcom/amazon/device/ads/AAXParameter$ParameterData;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 252
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 253
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->json:Lorg/json/JSONObject;

    .line 254
    return-void
.end method


# virtual methods
.method build()V
    .locals 8

    .prologue
    .line 283
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->aaxParameters:[Lcom/amazon/device/ads/AAXParameter;

    .local v0, "arr$":[Lcom/amazon/device/ads/AAXParameter;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v4, v0, v2

    .line 285
    .local v4, "parameter":Lcom/amazon/device/ads/AAXParameter;, "Lcom/amazon/device/ads/AAXParameter<*>;"
    iget-object v6, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->parameterData:Lcom/amazon/device/ads/AAXParameter$ParameterData;

    invoke-virtual {v4, v6}, Lcom/amazon/device/ads/AAXParameter;->getValue(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Ljava/lang/Object;

    move-result-object v5

    .line 286
    .local v5, "value":Ljava/lang/Object;
    invoke-virtual {p0, v4, v5}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->putIntoJSON(Lcom/amazon/device/ads/AAXParameter;Ljava/lang/Object;)V

    .line 283
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 292
    .end local v4    # "parameter":Lcom/amazon/device/ads/AAXParameter;, "Lcom/amazon/device/ads/AAXParameter<*>;"
    .end local v5    # "value":Ljava/lang/Object;
    :cond_0
    iget-object v6, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->advancedOptions:Ljava/util/Map;

    if-eqz v6, :cond_2

    .line 294
    iget-object v6, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->advancedOptions:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 296
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-static {v6}, Lcom/amazon/device/ads/Utils;->isNullOrWhiteSpace(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 298
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {p0, v6, v7}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->putIntoJSON(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1

    .line 302
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_2
    return-void
.end method

.method getJSON()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 278
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->json:Lorg/json/JSONObject;

    return-object v0
.end method

.method getParameterData()Lcom/amazon/device/ads/AAXParameter$ParameterData;
    .locals 1

    .prologue
    .line 273
    iget-object v0, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->parameterData:Lcom/amazon/device/ads/AAXParameter$ParameterData;

    return-object v0
.end method

.method putIntoJSON(Lcom/amazon/device/ads/AAXParameter;Ljava/lang/Object;)V
    .locals 1
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/device/ads/AAXParameter",
            "<*>;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 306
    .local p1, "parameter":Lcom/amazon/device/ads/AAXParameter;, "Lcom/amazon/device/ads/AAXParameter<*>;"
    invoke-virtual {p1}, Lcom/amazon/device/ads/AAXParameter;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->putIntoJSON(Ljava/lang/String;Ljava/lang/Object;)V

    .line 307
    return-void
.end method

.method putIntoJSON(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 5
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 310
    if-eqz p2, :cond_0

    .line 314
    :try_start_0
    iget-object v1, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->json:Lorg/json/JSONObject;

    invoke-virtual {v1, p1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 321
    :cond_0
    :goto_0
    return-void

    .line 316
    :catch_0
    move-exception v0

    .line 318
    .local v0, "e":Lorg/json/JSONException;
    # getter for: Lcom/amazon/device/ads/AdRequest;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/AdRequest;->access$000()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Could not add parameter to JSON %s: %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method setAAXParameters([Lcom/amazon/device/ads/AAXParameter;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/amazon/device/ads/AAXParameter",
            "<*>;)",
            "Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;"
        }
    .end annotation

    .prologue
    .line 258
    .local p1, "aaxParameters":[Lcom/amazon/device/ads/AAXParameter;, "[Lcom/amazon/device/ads/AAXParameter<*>;"
    iput-object p1, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->aaxParameters:[Lcom/amazon/device/ads/AAXParameter;

    .line 259
    return-object p0
.end method

.method setAdvancedOptions(Ljava/util/Map;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;"
        }
    .end annotation

    .prologue
    .line 263
    .local p1, "advancedOptions":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->advancedOptions:Ljava/util/Map;

    .line 264
    return-object p0
.end method

.method setParameterData(Lcom/amazon/device/ads/AAXParameter$ParameterData;)Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;
    .locals 0
    .param p1, "parameterData"    # Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .prologue
    .line 268
    iput-object p1, p0, Lcom/amazon/device/ads/AdRequest$JSONObjectBuilder;->parameterData:Lcom/amazon/device/ads/AAXParameter$ParameterData;

    .line 269
    return-object p0
.end method
