.class public Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;
.source "RegistrationListResponseHandler.java"


# instance fields
.field private deviceList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "jsonObjectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 17
    return-void
.end method


# virtual methods
.method public getDeviceList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;->deviceList:Ljava/util/List;

    return-object v0
.end method

.method public handleAMSResponseBody(Lcom/fasterxml/jackson/databind/JsonNode;)V
    .locals 4
    .param p1, "rootNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    const-string v1, "devices"

    invoke-virtual {p1, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 23
    .local v0, "listNode":Lcom/fasterxml/jackson/databind/JsonNode;
    if-eqz v0, :cond_0

    .line 24
    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;->jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->traverse()Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v2

    new-instance v3, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler$1;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler$1;-><init>(Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;)V

    invoke-virtual {v1, v2, v3}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/core/type/TypeReference;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    iput-object v1, p0, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;->deviceList:Ljava/util/List;

    .line 28
    :goto_0
    return-void

    .line 26
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;->deviceList:Ljava/util/List;

    goto :goto_0
.end method
