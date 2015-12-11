.class public Lcom/comcast/cim/cmasl/http/response/IdentifyResponseHandler;
.super Ljava/lang/Object;
.source "IdentifyResponseHandler.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;


# instance fields
.field private responseId:Lcom/comcast/cim/cmasl/http/response/ResponseId;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getLastModifiedHeaderValueFrom(Ljava/util/Map;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 31
    .local p1, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v0, "Last-Modified"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public getResponseId()Lcom/comcast/cim/cmasl/http/response/ResponseId;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/response/IdentifyResponseHandler;->responseId:Lcom/comcast/cim/cmasl/http/response/ResponseId;

    return-object v0
.end method

.method public handleResponseHeaders(Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)V
    .locals 2
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
    .line 20
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p3}, Lcom/comcast/cim/cmasl/http/response/IdentifyResponseHandler;->getLastModifiedHeaderValueFrom(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 21
    .local v0, "lastModified":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 22
    new-instance v1, Lcom/comcast/cim/cmasl/http/response/ResponseId;

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/http/response/ResponseId;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/comcast/cim/cmasl/http/response/IdentifyResponseHandler;->responseId:Lcom/comcast/cim/cmasl/http/response/ResponseId;

    .line 24
    :cond_0
    return-void
.end method
