.class public Lcom/comcast/cim/cmasl/xip/XipResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "XipResponseHandler.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 12
    new-instance v0, Lcom/comcast/cim/cmasl/xip/XipErrorHeaderHandler;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/xip/XipErrorHeaderHandler;-><init>()V

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/xip/XipResponseHandler;->addDelegateHeadersHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;)V

    .line 13
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/xip/XipResponseHandler;->addDefaultHeaderHandlers()V

    .line 14
    return-void
.end method


# virtual methods
.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 0
    .param p1, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 19
    return-void
.end method
