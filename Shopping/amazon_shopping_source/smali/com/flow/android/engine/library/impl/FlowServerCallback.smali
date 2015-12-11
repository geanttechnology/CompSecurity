.class public Lcom/flow/android/engine/library/impl/FlowServerCallback;
.super Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;
.source "FlowServerCallback.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flow/android/engine/library/impl/FlowServerCallback$1;,
        Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;,
        Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;
    }
.end annotation


# instance fields
.field private mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

.field private mMode:Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;

.field private mServerResponse:Ljava/lang/String;

.field private mServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field private mServerState:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;


# direct methods
.method public constructor <init>(Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;)V
    .locals 1
    .param p1, "a_impl"    # Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;
    .param p2, "a_mode"    # Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/a9/vs/mobile/library/impl/jni/ServerDelegate;-><init>()V

    .line 29
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    .line 37
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    .line 38
    iput-object p2, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mMode:Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;

    .line 39
    invoke-virtual {p0}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->resetServerState()V

    .line 40
    return-void
.end method


# virtual methods
.method public declared-synchronized gotServerResponse(Ljava/lang/String;Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;D)V
    .locals 3
    .param p1, "response"    # Ljava/lang/String;
    .param p2, "responseType"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .param p3, "roundTripTimeInSeconds"    # D

    .prologue
    .line 95
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerState:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    sget-object v2, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_WAITING_RESPONSE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    if-ne v1, v2, :cond_0

    .line 96
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerResponse:Ljava/lang/String;

    .line 97
    iput-object p2, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 99
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;

    invoke-direct {v0}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;-><init>()V

    .line 100
    .local v0, "serverResponse":Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerResponse:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->setResponseStr(Ljava/lang/String;)V

    .line 101
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    invoke-virtual {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->setResponseType(Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;)V

    .line 102
    invoke-virtual {v0, p3, p4}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;->setRoundtripTime(D)V

    .line 103
    invoke-virtual {p0, v0}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->pushServerResponse(Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;)V

    .line 104
    invoke-virtual {p0}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->resetServerState()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 106
    .end local v0    # "serverResponse":Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;
    :cond_0
    monitor-exit p0

    return-void

    .line 95
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized resetServerState()V
    .locals 1

    .prologue
    .line 109
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_IDLE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerState:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    .line 110
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerResponse:Ljava/lang/String;

    .line 111
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 112
    monitor-exit p0

    return-void

    .line 109
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected sendServerRequestImpl(Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;)Z
    .locals 10
    .param p1, "request"    # Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;

    .prologue
    .line 44
    iget-object v6, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerState:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    sget-object v7, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_IDLE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    if-ne v6, v7, :cond_5

    .line 45
    sget-object v6, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_SERVER_WAITING_RESPONSE:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    iput-object v6, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerState:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    .line 46
    const/4 v5, 0x0

    .line 47
    .local v5, "success":Z
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 48
    .local v4, "paramsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 49
    .local v2, "metadataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 50
    .local v1, "metadataKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    const/4 v3, 0x0

    .line 51
    .local v3, "paramKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    sget-object v6, Lcom/flow/android/engine/library/impl/FlowServerCallback$1;->$SwitchMap$com$flow$android$engine$library$impl$FlowServerCallback$Mode:[I

    iget-object v7, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mMode:Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;

    invoke-virtual {v7}, Lcom/flow/android/engine/library/impl/FlowServerCallback$Mode;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 81
    const-string/jumbo v6, "FlowServerCallback"

    const-string/jumbo v7, "Error : Unsupported mode found."

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 85
    :goto_0
    if-nez v5, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/flow/android/engine/library/impl/FlowServerCallback;->resetServerState()V

    .line 91
    .end local v1    # "metadataKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .end local v2    # "metadataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "paramKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .end local v4    # "paramsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v5    # "success":Z
    :cond_0
    :goto_1
    return v5

    .line 54
    .restart local v1    # "metadataKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .restart local v2    # "metadataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v3    # "paramKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .restart local v4    # "paramsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v5    # "success":Z
    :pswitch_0
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getParams()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    move-result-object v6

    invoke-static {v6}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getKeys(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v3

    .line 55
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    int-to-long v6, v0

    invoke-virtual {v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v8

    cmp-long v6, v6, v8

    if-gez v6, :cond_1

    .line 56
    invoke-virtual {v3, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getParams()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    move-result-object v7

    invoke-virtual {v3, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v4, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 58
    :cond_1
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getMetadata()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    move-result-object v6

    invoke-static {v6}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getKeys(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v1

    .line 59
    const/4 v0, 0x0

    :goto_3
    int-to-long v6, v0

    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v8

    cmp-long v6, v6, v8

    if-gez v6, :cond_2

    .line 60
    invoke-virtual {v1, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getMetadata()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    move-result-object v7

    invoke-virtual {v1, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 63
    :cond_2
    iget-object v6, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getData()Lcom/a9/vs/mobile/library/impl/jni/ByteArray;

    move-result-object v7

    invoke-virtual {v6, v7, v4, v2}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->doImageMatch(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/util/Map;Ljava/util/Map;)Z

    move-result v5

    .line 64
    goto :goto_0

    .line 67
    .end local v0    # "i":I
    :pswitch_1
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getParams()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    move-result-object v6

    invoke-static {v6}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getKeys(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v3

    .line 68
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_4
    int-to-long v6, v0

    invoke-virtual {v3}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v8

    cmp-long v6, v6, v8

    if-gez v6, :cond_3

    .line 69
    invoke-virtual {v3, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getParams()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    move-result-object v7

    invoke-virtual {v3, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v4, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 72
    :cond_3
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getMetadata()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    move-result-object v6

    invoke-static {v6}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->getKeys(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;)Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;

    move-result-object v1

    .line 73
    const/4 v0, 0x0

    :goto_5
    int-to-long v6, v0

    invoke-virtual {v1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v8

    cmp-long v6, v6, v8

    if-gez v6, :cond_4

    .line 74
    invoke-virtual {v1, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getMetadata()Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;

    move-result-object v7

    invoke-virtual {v1, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToString;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 77
    :cond_4
    iget-object v6, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mImpl:Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ServerRequest;->getData()Lcom/a9/vs/mobile/library/impl/jni/ByteArray;

    move-result-object v7

    invoke-virtual {v6, v7, v4, v2}, Lcom/flow/android/engine/library/impl/FlowStateEngineImpl;->doTextMatch(Lcom/a9/vs/mobile/library/impl/jni/ByteArray;Ljava/util/Map;Ljava/util/Map;)Z

    move-result v5

    .line 78
    goto/16 :goto_0

    .line 91
    .end local v0    # "i":I
    .end local v1    # "metadataKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .end local v2    # "metadataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "paramKeys":Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .end local v4    # "paramsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v5    # "success":Z
    :cond_5
    const/4 v5, 0x0

    goto/16 :goto_1

    .line 51
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public declared-synchronized shutdownServerState()V
    .locals 1

    .prologue
    .line 115
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;->FLOW_ENGINE_SHUTDOWN:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerState:Lcom/flow/android/engine/library/impl/FlowServerCallback$FlowServerState;

    .line 116
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerResponse:Ljava/lang/String;

    .line 117
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowServerCallback;->mServerResponseType:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 118
    monitor-exit p0

    return-void

    .line 115
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
