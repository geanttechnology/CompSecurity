.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/ContentEncodingHttpClient;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;
.source "ContentEncodingHttpClient.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ContentEncodingHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 67
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 0
    .param p1, "conman"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 52
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 53
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 1
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ContentEncodingHttpClient;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 60
    return-void
.end method


# virtual methods
.method protected createHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    .locals 2

    .prologue
    .line 74
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient;->createHttpProcessor()Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;

    move-result-object v0

    .line 76
    .local v0, "result":Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestAcceptEncoding;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/RequestAcceptEncoding;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addRequestInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;)V

    .line 77
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseContentEncoding;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseContentEncoding;-><init>()V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpProcessor;->addResponseInterceptor(Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V

    .line 79
    return-object v0
.end method
