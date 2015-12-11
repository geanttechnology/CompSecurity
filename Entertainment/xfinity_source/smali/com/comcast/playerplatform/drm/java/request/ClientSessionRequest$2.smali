.class Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$2;
.super Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
.source "ClientSessionRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$2;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public configurationNotReady()V
    .locals 4

    .prologue
    .line 78
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v1, "MetaDataResponse Error: 7505.1"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 80
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$2;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v2, "7505.1"

    const-string v3, "Metadata ErrorNetwork Request Error"

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    return-void
.end method

.method public requestFailed(Ljava/lang/String;)V
    .locals 4
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 71
    sget-object v0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v1, "MetaDataResponse Error: 7505.0"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 73
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$2;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->drmResponseEventListener:Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$100(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    const-string v2, "7505.0"

    const-string v3, "Metadata ErrorNetwork Request Error"

    invoke-virtual {v0, v1, v2, v3}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmEventListener;->internalDRMError(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    return-void
.end method

.method public responseReceived(Ljava/lang/String;)V
    .locals 5
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 85
    sget-object v3, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->logger:Lorg/slf4j/Logger;

    const-string v4, "MetaDataResponse Received. Creating Meta token"

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 87
    new-instance v2, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;

    sget-object v3, Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;->META:Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;

    invoke-direct {v2, v3, p1}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;-><init>(Lcom/comcast/playerplatform/drm/java/client/SecurityTokenType;Ljava/lang/String;)V

    .line 89
    .local v2, "metadataToken":Lcom/comcast/playerplatform/drm/java/client/SecurityToken;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 90
    .local v0, "cal":Ljava/util/Calendar;
    const-string v3, "Zulu"

    invoke-static {v3}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/Calendar;->setTimeZone(Ljava/util/TimeZone;)V

    .line 91
    const/16 v3, 0xb

    const/16 v4, 0x18

    invoke-virtual {v0, v3, v4}, Ljava/util/Calendar;->add(II)V

    .line 93
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v3, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    invoke-direct {v1, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 94
    .local v1, "df":Ljava/text/DateFormat;
    const-string v3, "Zulu"

    invoke-static {v3}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/text/DateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 96
    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/drm/java/client/SecurityToken;->setNotOnOrAfter(Ljava/lang/String;)V

    .line 97
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$2;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # getter for: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;
    invoke-static {v3}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$200(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;

    move-result-object v3

    invoke-interface {v3, v2}, Lcom/comcast/playerplatform/drm/java/client/ClientStateInterface;->addSecurityToken(Lcom/comcast/playerplatform/drm/java/client/SecurityToken;)V

    .line 99
    iget-object v3, p0, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest$2;->this$0:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    # invokes: Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->acquireLicense()V
    invoke-static {v3}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->access$000(Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;)V

    .line 100
    return-void
.end method
