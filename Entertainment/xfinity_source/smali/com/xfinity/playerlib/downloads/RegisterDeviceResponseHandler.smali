.class public Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;
.source "RegisterDeviceResponseHandler.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private deviceRegistration:Lcom/xfinity/playerlib/downloads/DeviceRegistration;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "jsonObjectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 18
    return-void
.end method


# virtual methods
.method public getDeviceRegistration()Lcom/xfinity/playerlib/downloads/DeviceRegistration;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;->deviceRegistration:Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    return-object v0
.end method

.method protected handleAMSResponseBody(Lcom/fasterxml/jackson/databind/JsonNode;)V
    .locals 3
    .param p1, "rootNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;->jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JsonNode;->traverse()Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v1

    const-class v2, Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    invoke-virtual {v0, v1, v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;->deviceRegistration:Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    .line 23
    return-void
.end method
