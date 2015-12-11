.class public Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;
.super Ljava/lang/Object;
.source "StrictHttpStatusCodeHandler.java"

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
    .line 15
    .local p3, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;->getStatusCode()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/16 v1, 0xc8

    if-eq v0, v1, :cond_0

    .line 16
    new-instance v0, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;

    invoke-direct {v0, p2}, Lcom/comcast/cim/cmasl/http/exceptions/CimHttpException;-><init>(Lcom/comcast/cim/cmasl/http/response/DetailedRequestStatus;)V

    throw v0

    .line 18
    :cond_0
    return-void
.end method
