.class public Lcom/xfinity/playerlib/downloads/UnregisterDeviceResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;
.source "UnregisterDeviceResponseHandler.java"


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "jsonObjectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;-><init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 15
    return-void
.end method


# virtual methods
.method protected handleAMSResponseBody(Lcom/fasterxml/jackson/databind/JsonNode;)V
    .locals 0
    .param p1, "rootNode"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 25
    return-void
.end method

.method public handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "detailedRequestStatus"    # Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 19
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V

    .line 20
    return-void
.end method
