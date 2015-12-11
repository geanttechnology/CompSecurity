.class public Lcom/comcast/cim/cmasl/http/response/DefaultHttpStatusCodeHandler;
.super Ljava/lang/Object;
.source "DefaultHttpStatusCodeHandler.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
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
    .line 16
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v0}, Lcom/comcast/cim/cmasl/http/utils/ResponseHandlerUtils;->statusCodeIndicatesError(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 17
    new-instance v0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    invoke-direct {v0, p2}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;-><init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V

    throw v0

    .line 19
    :cond_0
    return-void
.end method
