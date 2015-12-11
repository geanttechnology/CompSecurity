.class public Lcom/comcast/cim/cmasl/xip/XipErrorHeaderHandler;
.super Ljava/lang/Object;
.source "XipErrorHeaderHandler.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
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
    .line 15
    .local p3, "headerMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p2, p3}, Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;->fromHttpResponse(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;Ljava/util/Map;)Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;

    move-result-object v0

    .line 16
    .local v0, "xipException":Lcom/comcast/cim/cmasl/xip/XipHttpErrorException;
    if-eqz v0, :cond_0

    .line 17
    throw v0

    .line 19
    :cond_0
    return-void
.end method
