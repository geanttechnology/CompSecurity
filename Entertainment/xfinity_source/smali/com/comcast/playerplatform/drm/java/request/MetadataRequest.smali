.class public Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;
.super Ljava/lang/Object;
.source "MetadataRequest.java"


# instance fields
.field private httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 0
    .param p1, "responseEventListener"    # Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;->responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    .line 20
    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 21
    return-void
.end method


# virtual methods
.method public submitRequest()V
    .locals 9

    .prologue
    .line 24
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v7

    .line 26
    .local v7, "configurationManager":Lcom/comcast/playerplatform/util/android/ConfigurationManager;
    invoke-virtual {v7}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady()Z

    move-result v0

    if-nez v0, :cond_0

    .line 28
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;->responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->configurationNotReady()V

    .line 39
    :goto_0
    return-void

    .line 32
    :cond_0
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v8

    new-instance v0, Lcom/comcast/playerplatform/util/android/XrestHelper;

    const-string v1, ""

    const-string v2, "MetadataEndPoint"

    invoke-virtual {v7, v2}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getConfigValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "GET"

    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    iget-object v5, p0, Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;->responseEventListener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    iget-object v6, p0, Lcom/comcast/playerplatform/drm/java/request/MetadataRequest;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/util/android/XrestHelper;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    invoke-virtual {v8, v0}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
