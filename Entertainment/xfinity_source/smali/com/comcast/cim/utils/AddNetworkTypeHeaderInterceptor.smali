.class public Lcom/comcast/cim/utils/AddNetworkTypeHeaderInterceptor;
.super Ljava/lang/Object;
.source "AddNetworkTypeHeaderInterceptor.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;


# instance fields
.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V
    .locals 0
    .param p1, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/comcast/cim/utils/AddNetworkTypeHeaderInterceptor;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 22
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 3
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 26
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    const-string v2, "X-FINITY-NETWORK"

    iget-object v1, p0, Lcom/comcast/cim/utils/AddNetworkTypeHeaderInterceptor;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnectedOnWiFi()Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "Wifi"

    :goto_0
    invoke-direct {v0, v2, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    .local v0, "networkHeader":Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 29
    return-void

    .line 26
    .end local v0    # "networkHeader":Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;
    :cond_0
    const-string v1, "Cellular"

    goto :goto_0
.end method
