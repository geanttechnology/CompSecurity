.class public Lcom/comcast/cim/cmasl/http/response/LenientResponseHeaderHandler;
.super Ljava/lang/Object;
.source "LenientResponseHeaderHandler.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
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
    .line 14
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 15
    .local v0, "statusCode":I
    const/16 v1, 0xc8

    if-lt v0, v1, :cond_0

    const/16 v1, 0x12c

    if-lt v0, v1, :cond_1

    .line 16
    :cond_0
    new-instance v1, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    invoke-direct {v1, p2}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;-><init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V

    throw v1

    .line 18
    :cond_1
    return-void
.end method
