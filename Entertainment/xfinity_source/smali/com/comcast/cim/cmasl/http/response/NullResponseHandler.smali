.class public Lcom/comcast/cim/cmasl/http/response/NullResponseHandler;
.super Ljava/lang/Object;
.source "NullResponseHandler.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/response/ResponseHandler;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 0
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 15
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
    .line 11
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    return-void
.end method
