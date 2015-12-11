.class public Lcom/xfinity/playerlib/authorization/VideoContinueResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;
.source "VideoContinueResponseHandler.java"


# instance fields
.field private videoContinue:Lcom/xfinity/playerlib/authorization/VideoContinue;


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
.method public getVideoContinue()Lcom/xfinity/playerlib/authorization/VideoSession;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoContinueResponseHandler;->videoContinue:Lcom/xfinity/playerlib/authorization/VideoContinue;

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
    .line 19
    new-instance v0, Lcom/xfinity/playerlib/authorization/VideoContinue;

    iget-object v1, p0, Lcom/xfinity/playerlib/authorization/VideoContinueResponseHandler;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusMessage()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoContinueResponseHandler;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/authorization/VideoContinue;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoContinueResponseHandler;->videoContinue:Lcom/xfinity/playerlib/authorization/VideoContinue;

    .line 20
    return-void
.end method
