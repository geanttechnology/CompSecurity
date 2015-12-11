.class public Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
.super Ljava/lang/Object;
.source "SecurityToken.java"


# static fields
.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private deviceId:Ljava/lang/String;

.field private isInHome:Z

.field private notOnOrAfter:Ljava/lang/String;

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

.field private type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;)V
    .locals 3
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "parser"    # Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    sget-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Creating Security Token. Token Type:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 41
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    .line 42
    invoke-virtual {p2}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->getToken()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->token:Ljava/lang/String;

    .line 43
    invoke-virtual {p2}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->getNotOnOrAfter()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->notOnOrAfter:Ljava/lang/String;

    .line 44
    invoke-virtual {p2}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->getInHome()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->isInHome:Z

    .line 45
    invoke-virtual {p2}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->deviceId:Ljava/lang/String;

    .line 46
    invoke-virtual {p2}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionParser;->getProperties()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->properties:Ljava/util/Map;

    .line 48
    sget-object v0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->logger:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Security Token Created. Token Type:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 49
    return-void
.end method

.method public constructor <init>(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .param p2, "token"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    .line 29
    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->token:Ljava/lang/String;

    .line 30
    return-void
.end method


# virtual methods
.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getNotOnOrAfter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->notOnOrAfter:Ljava/lang/String;

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
    .line 117
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->properties:Ljava/util/Map;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->token:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    return-object v0
.end method

.method public isInHome()Z
    .locals 1

    .prologue
    .line 76
    iget-boolean v0, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->isInHome:Z

    return v0
.end method

.method public isValid()Z
    .locals 5

    .prologue
    .line 88
    const/4 v3, 0x0

    .line 90
    .local v3, "result":Z
    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->token:Ljava/lang/String;

    invoke-static {v4}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 91
    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->notOnOrAfter:Ljava/lang/String;

    if-eqz v4, :cond_1

    .line 92
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v4, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    invoke-direct {v0, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 93
    .local v0, "df":Ljava/text/DateFormat;
    const-string v4, "Zulu"

    invoke-static {v4}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/text/DateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 95
    :try_start_0
    iget-object v4, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->notOnOrAfter:Ljava/lang/String;

    invoke-virtual {v0, v4}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 96
    .local v1, "parsedDate":Ljava/util/Date;
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v4, v1}, Ljava/util/Date;->before(Ljava/util/Date;)Z
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 105
    .end local v0    # "df":Ljava/text/DateFormat;
    .end local v1    # "parsedDate":Ljava/util/Date;
    :cond_0
    :goto_0
    return v3

    .line 97
    .restart local v0    # "df":Ljava/text/DateFormat;
    :catch_0
    move-exception v2

    .line 98
    .local v2, "pe":Ljava/text/ParseException;
    const/4 v3, 0x0

    goto :goto_0

    .line 101
    .end local v0    # "df":Ljava/text/DateFormat;
    .end local v2    # "pe":Ljava/text/ParseException;
    :cond_1
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->deviceId:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setName(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;)V
    .locals 0
    .param p1, "type"    # Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->type:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    .line 65
    return-void
.end method

.method public setNotOnOrAfter(Ljava/lang/String;)V
    .locals 0
    .param p1, "notOnOrAfter"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->notOnOrAfter:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setProperties(Ljava/util/Map;)V
    .locals 0
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

    .prologue
    .line 121
    .local p1, "properties":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->properties:Ljava/util/Map;

    .line 122
    return-void
.end method

.method public setToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->token:Ljava/lang/String;

    .line 73
    return-void
.end method
