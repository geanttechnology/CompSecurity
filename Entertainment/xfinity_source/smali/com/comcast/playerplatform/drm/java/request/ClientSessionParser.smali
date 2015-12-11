.class public Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;
.super Ljava/lang/Object;
.source "ClientSessionParser.java"


# instance fields
.field private deviceId:Ljava/lang/String;

.field private notOnOrAfter:Ljava/lang/String;

.field private parsed:Z

.field private properties:Ljava/util/Map;
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

.field private token:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/adobe/ave/drm/DRMLicense;)V
    .locals 1
    .param p1, "drmLicense"    # Lcom/adobe/ave/drm/DRMLicense;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->parsed:Z

    .line 34
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->parse(Lcom/adobe/ave/drm/DRMLicense;)V

    .line 35
    return-void
.end method

.method private parse(Lcom/adobe/ave/drm/DRMLicense;)V
    .locals 6
    .param p1, "license"    # Lcom/adobe/ave/drm/DRMLicense;

    .prologue
    .line 41
    :try_start_0
    new-instance v1, Ljava/lang/String;

    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getCustomProperties()Ljava/util/Map;

    move-result-object v2

    const-string v3, "client:authnToken"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>([B)V

    .line 42
    .local v1, "token":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    const/4 v3, 0x2

    invoke-static {v2, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->token:Ljava/lang/String;

    .line 43
    new-instance v3, Ljava/lang/String;

    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getCustomProperties()Ljava/util/Map;

    move-result-object v2

    const-string v4, "client:authnTokenNotOnOrAfter"

    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    invoke-direct {v3, v2}, Ljava/lang/String;-><init>([B)V

    iput-object v3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->notOnOrAfter:Ljava/lang/String;

    .line 44
    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getCustomProperties()Ljava/util/Map;

    move-result-object v2

    const-string v3, "client:authnTokenClaims"

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 45
    new-instance v3, Lorg/json/JSONObject;

    new-instance v4, Ljava/lang/String;

    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getCustomProperties()Ljava/util/Map;

    move-result-object v2

    const-string v5, "client:authnTokenClaims"

    invoke-interface {v2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    invoke-direct {v4, v2}, Ljava/lang/String;-><init>([B)V

    invoke-direct {v3, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v3}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->parsePropertiesJson(Lorg/json/JSONObject;)V

    .line 47
    :cond_0
    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getCustomProperties()Ljava/util/Map;

    move-result-object v2

    const-string v3, "client:providerDeviceId"

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 48
    new-instance v3, Ljava/lang/String;

    invoke-virtual {p1}, Lcom/adobe/ave/drm/DRMLicense;->getCustomProperties()Ljava/util/Map;

    move-result-object v2

    const-string v4, "client:providerDeviceId"

    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    invoke-direct {v3, v2}, Ljava/lang/String;-><init>([B)V

    iput-object v3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->deviceId:Ljava/lang/String;

    .line 51
    :cond_1
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->parsed:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    .end local v1    # "token":Ljava/lang/String;
    :goto_0
    return-void

    .line 53
    :catch_0
    move-exception v0

    .line 55
    .local v0, "e":Ljava/lang/Exception;
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->parsed:Z

    goto :goto_0
.end method

.method private parsePropertiesJson(Lorg/json/JSONObject;)V
    .locals 4
    .param p1, "jsonObject"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 62
    new-instance v2, Ljava/util/Hashtable;

    invoke-direct {v2}, Ljava/util/Hashtable;-><init>()V

    iput-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    .line 63
    invoke-virtual {p1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 64
    .local v1, "keyIterator":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 65
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 66
    .local v0, "key":Ljava/lang/String;
    iget-object v2, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 68
    .end local v0    # "key":Ljava/lang/String;
    :cond_0
    return-void
.end method


# virtual methods
.method public getDeviceId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    const-string v1, "device:xcal:id"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    const-string v1, "device:xcal:id"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 100
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->deviceId:Ljava/lang/String;

    goto :goto_0
.end method

.method public getInHome()Ljava/lang/Boolean;
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    const-string v1, "device:xcal:locationInHome"

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    const-string v1, "device:xcal:locationInHome"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    .line 83
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method public getNotOnOrAfter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->notOnOrAfter:Ljava/lang/String;

    return-object v0
.end method

.method public getProperties()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 87
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->properties:Ljava/util/Map;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->token:Ljava/lang/String;

    return-object v0
.end method

.method public isParsed()Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->parsed:Z

    return v0
.end method
