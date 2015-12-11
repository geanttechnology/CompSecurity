.class public Lcom/comcast/cim/cmasl/http/response/BasicResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "BasicResponseHandler.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 11
    new-instance v0, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;-><init>()V

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/http/response/BasicResponseHandler;->addDelegateHeadersHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;)V

    .line 12
    return-void
.end method


# virtual methods
.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 0
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 17
    return-void
.end method
