.class public Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;
.super Ljava/lang/Object;
.source "FlowStateEngineImpl.java"

# interfaces
.implements Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;


# instance fields
.field private m_eventCallback:Lcom/flow/android/engine/library/impl/FlowEventCallback;

.field private m_httpManager:Lcom/flow/android/engine/library/impl/servermatch/HttpManager;

.field private m_imageMatchServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

.field private m_interface:Lcom/flow/android/engine/library/FlowStateEngineInterface;

.field private m_textServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;


# direct methods
.method public constructor <init>(Lcom/flow/android/engine/library/FlowStateEngineInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;)V
    .locals 2
    .param p1, "a_interface"    # Lcom/flow/android/engine/library/FlowStateEngineInterface;
    .param p2, "a_clientInfo"    # Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_httpManager:Lcom/flow/android/engine/library/impl/servermatch/HttpManager;

    .line 25
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_interface:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .line 26
    new-instance v0, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;

    invoke-direct {v0, p0, p2}, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;-><init>(Lcom/flow/android/engine/library/impl/servermatch/HttpManagerInterface;Lcom/flow/android/engine/library/impl/servermatch/ClientDeviceInfo;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_httpManager:Lcom/flow/android/engine/library/impl/servermatch/HttpManager;

    .line 27
    new-instance v0, Lcom/flow/android/engine/library/impl/FlowServerCallback;

    sget-object v1, Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;->IMAGEMATCH:Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;

    invoke-direct {v0, p0, v1}, Lcom/flow/android/engine/library/impl/FlowServerCallback;-><init>(Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_imageMatchServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    .line 28
    new-instance v0, Lcom/flow/android/engine/library/impl/FlowServerCallback;

    sget-object v1, Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;->TEXT:Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;

    invoke-direct {v0, p0, v1}, Lcom/flow/android/engine/library/impl/FlowServerCallback;-><init>(Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_textServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    .line 29
    new-instance v0, Lcom/flow/android/engine/library/impl/FlowEventCallback;

    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_interface:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-direct {v0, v1}, Lcom/flow/android/engine/library/impl/FlowEventCallback;-><init>(Lcom/flow/android/engine/library/FlowStateEngineInterface;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_eventCallback:Lcom/flow/android/engine/library/impl/FlowEventCallback;

    .line 30
    return-void
.end method


# virtual methods
.method public didReceiveImageMatchResponse(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;D)V
    .locals 2
    .param p1, "a_response"    # Ljava/lang/String;
    .param p2, "a_responseType"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .param p3, "roundTripTimeInSeconds"    # D

    .prologue
    .line 97
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_imageMatchServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->gotServerResponse(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;D)V

    .line 98
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_eventCallback:Lcom/flow/android/engine/library/impl/FlowEventCallback;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/flow/android/engine/library/impl/FlowEventCallback;->setNetworkErrorMode(Z)V

    .line 99
    return-void
.end method

.method public didReceiveTextMatchResponse(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;D)V
    .locals 2
    .param p1, "a_response"    # Ljava/lang/String;
    .param p2, "a_responseType"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .param p3, "roundTripTimeInSeconds"    # D

    .prologue
    .line 103
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_textServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->gotServerResponse(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;D)V

    .line 104
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_eventCallback:Lcom/flow/android/engine/library/impl/FlowEventCallback;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/flow/android/engine/library/impl/FlowEventCallback;->setNetworkErrorMode(Z)V

    .line 105
    return-void
.end method

.method public doImageMatch(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/util/Map;Ljava/util/Map;)Z
    .locals 3
    .param p1, "data"    # Lcom/a9/vs/mobile/library/impl/jni/ByteArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ByteArray;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 69
    .local p2, "customParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "metadataParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ByteArray;->getData()[B

    move-result-object v0

    .line 70
    .local v0, "arr":[B
    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-direct {v1, v0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 71
    .local v1, "inputStream":Ljava/io/ByteArrayInputStream;
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_httpManager:Lcom/flow/android/engine/library/impl/servermatch/HttpManager;

    invoke-virtual {v2, v1, p2, p3}, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->doImageMatch(Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V

    .line 72
    const/4 v2, 0x1

    return v2
.end method

.method public doMetricsReporting(Lcom/flow/android/engine/library/FlowStateEngineMetrics;)V
    .locals 1
    .param p1, "a_engineMetrics"    # Lcom/flow/android/engine/library/FlowStateEngineMetrics;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_httpManager:Lcom/flow/android/engine/library/impl/servermatch/HttpManager;

    invoke-virtual {v0, p1}, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->doMetricsReporting(Lcom/flow/android/engine/library/FlowStateEngineMetrics;)V

    .line 93
    return-void
.end method

.method public doTextMatch(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/util/Map;Ljava/util/Map;)Z
    .locals 3
    .param p1, "data"    # Lcom/a9/vs/mobile/library/impl/jni/ByteArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ByteArray;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 76
    .local p2, "customParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "metadataParamsPair":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ByteArray;->getData()[B

    move-result-object v0

    .line 77
    .local v0, "arr":[B
    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-direct {v1, v0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 78
    .local v1, "inputStream":Ljava/io/ByteArrayInputStream;
    iget-object v2, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_httpManager:Lcom/flow/android/engine/library/impl/servermatch/HttpManager;

    invoke-virtual {v2, v1, p2, p3}, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->doTextMatch(Ljava/io/ByteArrayInputStream;Ljava/util/Map;Ljava/util/Map;)V

    .line 79
    const/4 v2, 0x1

    return v2
.end method

.method public getEventCallback()Lcom/flow/android/engine/library/impl/FlowEventCallback;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_eventCallback:Lcom/flow/android/engine/library/impl/FlowEventCallback;

    return-object v0
.end method

.method public getImageMatchServerCallback()Lcom/flow/android/engine/library/impl/FlowServerCallback;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_imageMatchServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    return-object v0
.end method

.method public getTextServerCallback()Lcom/flow/android/engine/library/impl/FlowServerCallback;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_textServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    return-object v0
.end method

.method public resetServerDelegates()V
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_imageMatchServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_imageMatchServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->resetServerState()V

    .line 53
    :cond_0
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_textServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    if-eqz v0, :cond_1

    .line 54
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_textServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->resetServerState()V

    .line 56
    :cond_1
    return-void
.end method

.method public setInterface(Lcom/flow/android/engine/library/FlowStateEngineInterface;)V
    .locals 2
    .param p1, "a_interface"    # Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_interface:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .line 34
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_eventCallback:Lcom/flow/android/engine/library/impl/FlowEventCallback;

    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_interface:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-virtual {v0, v1}, Lcom/flow/android/engine/library/impl/FlowEventCallback;->setInterface(Lcom/flow/android/engine/library/FlowStateEngineInterface;)V

    .line 35
    return-void
.end method

.method public shutdownServerDelegates()V
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_httpManager:Lcom/flow/android/engine/library/impl/servermatch/HttpManager;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/servermatch/HttpManager;->cancelFSERequests()V

    .line 60
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_imageMatchServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_imageMatchServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->shutdownServerState()V

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_textServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    if-eqz v0, :cond_1

    .line 64
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->m_textServerCallback:Lcom/flow/android/engine/library/impl/FlowServerCallback;

    invoke-virtual {v0}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->shutdownServerState()V

    .line 66
    :cond_1
    return-void
.end method
