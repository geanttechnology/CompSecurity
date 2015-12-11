.class public Lcom/comcast/cim/cmasl/analytics/AnalyticsResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "AnalyticsResponseHandler.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;-><init>()V

    .line 12
    new-instance v0, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;

    invoke-direct {v0}, Lcom/comcast/cim/cmasl/http/response/StrictHttpStatusCodeHandler;-><init>()V

    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsResponseHandler;->addDelegateHeadersHandler(Lcom/comcast/cim/cmasl/http/response/ResponseHeadersHandler;)V

    .line 13
    return-void
.end method


# virtual methods
.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 0
    .param p1, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 18
    return-void
.end method
