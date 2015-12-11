.class public abstract Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/XipResponseHandler;
.source "AMSResponseHandler.java"


# instance fields
.field private detailedRequestStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

.field protected detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

.field private httpException:Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

.field protected final jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p1, "jsonObjectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/xip/XipResponseHandler;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 24
    return-void
.end method


# virtual methods
.method protected abstract handleAMSResponseBody(Lcom/fasterxml/jackson/databind/JsonNode;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 7
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 48
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v5, Lcom/fasterxml/jackson/databind/JsonNode;

    invoke-virtual {v4, p1, v5}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/fasterxml/jackson/databind/JsonNode;

    .line 49
    .local v3, "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    iget-object v4, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->jsonObjectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v3}, Lcom/fasterxml/jackson/databind/JsonNode;->traverse()Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v5

    const-class v6, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;

    invoke-virtual {v4, v5, v6}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;

    .line 50
    .local v2, "responseStatus":Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;
    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;->toDetailedRequestStatus()Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    move-result-object v4

    iput-object v4, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .line 51
    iget-object v4, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->detailedRequestStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    iget-object v5, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->detailedStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    invoke-static {v4, v5}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;->fromHttpStatusAndAMSStatus(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;

    move-result-object v0

    .line 52
    .local v0, "amsException":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    if-eqz v0, :cond_0

    .line 53
    throw v0
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    .end local v0    # "amsException":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .end local v2    # "responseStatus":Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;
    .end local v3    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :catch_0
    move-exception v1

    .line 59
    .local v1, "e":Ljava/io/IOException;
    :try_start_1
    iget-object v4, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->httpException:Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    if-eqz v4, :cond_1

    .line 60
    iget-object v4, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->httpException:Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    throw v4
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 67
    .end local v1    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 68
    .restart local v1    # "e":Ljava/io/IOException;
    new-instance v4, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v4, v1}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v4

    .line 54
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v0    # "amsException":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .restart local v2    # "responseStatus":Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;
    .restart local v3    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_0
    :try_start_2
    iget-object v4, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->httpException:Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    if-eqz v4, :cond_2

    .line 55
    iget-object v4, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->httpException:Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    throw v4
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 62
    .end local v0    # "amsException":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .end local v2    # "responseStatus":Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;
    .end local v3    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .restart local v1    # "e":Ljava/io/IOException;
    :cond_1
    :try_start_3
    new-instance v4, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v4, v1}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v4

    .line 66
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v0    # "amsException":Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
    .restart local v2    # "responseStatus":Lcom/comcast/cim/cmasl/xip/ams/AmsRequestStatus;
    .restart local v3    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_2
    invoke-virtual {p0, v3}, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->handleAMSResponseBody(Lcom/fasterxml/jackson/databind/JsonNode;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 70
    return-void
.end method

.method public handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V
    .locals 1
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
    .line 35
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/cmasl/xip/XipResponseHandler;->handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException; {:try_start_0 .. :try_end_0} :catch_0

    .line 39
    :goto_0
    iput-object p2, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->detailedRequestStatus:Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;

    .line 40
    return-void

    .line 36
    :catch_0
    move-exception v0

    .line 37
    .local v0, "e":Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;
    iput-object v0, p0, Lcom/comcast/cim/cmasl/xip/ams/AMSResponseHandler;->httpException:Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    goto :goto_0
.end method
