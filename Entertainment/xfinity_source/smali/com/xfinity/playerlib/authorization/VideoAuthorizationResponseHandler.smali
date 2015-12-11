.class public Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;
.source "VideoAuthorizationResponseHandler.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private videoAuthorization:Lcom/xfinity/playerlib/authorization/VideoAuthorization;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "jsonObjectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 19
    return-void
.end method


# virtual methods
.method public getVideoAuthorization()Lcom/xfinity/playerlib/authorization/VideoAuthorization;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;->videoAuthorization:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    return-object v0
.end method

.method public handleAMSResponseBody(Lcom/fasterxml/jackson/databind/JsonNode;)V
    .locals 9
    .param p1, "rootNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 23
    const-string v8, "deviceId"

    invoke-virtual {p1, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v8

    invoke-virtual {v8}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v2

    .line 27
    .local v2, "deviceId":Ljava/lang/String;
    const-string v8, "sessionToken"

    invoke-virtual {p1, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v5

    .line 28
    .local v5, "sessionNode":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JsonNode;->isMissingNode()Z

    move-result v8

    if-nez v8, :cond_0

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v6

    .line 30
    .local v6, "sessionToken":Ljava/lang/String;
    :goto_0
    const-string v8, "deviceAuthorizationToken"

    invoke-virtual {p1, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 31
    .local v0, "authorizationNode":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->isMissingNode()Z

    move-result v8

    if-nez v8, :cond_1

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v1

    .line 33
    .local v1, "authorizationToken":Ljava/lang/String;
    :goto_1
    const-string v7, "drmToken"

    invoke-virtual {p1, v7}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    .line 34
    .local v4, "drmToken":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string v7, "devicePlaybackToken"

    invoke-virtual {v4, v7}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v7

    invoke-virtual {v7}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v3

    .line 36
    .local v3, "devicePlaybackToken":Ljava/lang/String;
    new-instance v7, Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-direct {v7, v1, v2, v6, v3}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v7, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;->videoAuthorization:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    .line 37
    return-void

    .end local v0    # "authorizationNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v1    # "authorizationToken":Ljava/lang/String;
    .end local v3    # "devicePlaybackToken":Ljava/lang/String;
    .end local v4    # "drmToken":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v6    # "sessionToken":Ljava/lang/String;
    :cond_0
    move-object v6, v7

    .line 28
    goto :goto_0

    .restart local v0    # "authorizationNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .restart local v6    # "sessionToken":Ljava/lang/String;
    :cond_1
    move-object v1, v7

    .line 31
    goto :goto_1
.end method
