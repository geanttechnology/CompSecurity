.class public Lcom/conviva/streamerProxies/VisualOnProxy;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/conviva/ConvivaStreamerProxy;
.implements Lcom/visualon/OSMPBasePlayer/voOSBasePlayer$onEventListener;


# instance fields
.field private _iListenerOrig:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer$onEventListener;

.field private _notifier:Lcom/conviva/monitor/IMonitorNotifier;

.field private _streamer:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;


# virtual methods
.method public Cleanup()V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_streamer:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;

    iget-object v1, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_iListenerOrig:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer$onEventListener;

    invoke-virtual {v0, v1}, Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;->setEventListener(Lcom/visualon/OSMPBasePlayer/voOSBasePlayer$onEventListener;)V

    iput-object v2, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_iListenerOrig:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer$onEventListener;

    iput-object v2, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_streamer:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;

    iput-object v2, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    return-void
.end method

.method public GetBufferLengthMs()I
    .locals 1

    const/4 v0, -0x1

    return v0
.end method

.method public GetCapabilities()I
    .locals 1

    const/4 v0, 0x7

    return v0
.end method

.method public GetMinBufferLengthMs()I
    .locals 1

    const/4 v0, -0x1

    return v0
.end method

.method public GetPlayheadTimeMs()I
    .locals 4

    const/4 v2, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_streamer:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_streamer:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;

    invoke-virtual {v0}, Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;->GetPos()I

    move-result v1

    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_streamer:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;

    const/16 v3, 0xe

    invoke-virtual {v0, v3}, Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;->GetParam(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v3, 0x3

    if-ne v0, v3, :cond_0

    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    const/16 v3, 0xc

    invoke-interface {v0, v3}, Lcom/conviva/monitor/IMonitorNotifier;->SetPlayingState(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    move v0, v1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    move v0, v2

    goto :goto_0

    :cond_1
    move v0, v2

    goto :goto_0
.end method

.method public GetRenderedFrameRate()D
    .locals 4

    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_streamer:Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;

    const/16 v1, 0x35

    invoke-virtual {v0, v1}, Lcom/visualon/OSMPBasePlayer/voOSBasePlayer;->GetParam(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/visualon/OSMPUtils/voOSVideoPerformance;

    if-eqz v0, :cond_0

    const-wide v2, 0x408f400000000000L    # 1000.0

    invoke-interface {v0}, Lcom/visualon/OSMPUtils/voOSVideoPerformance;->AverageRenderTime()I

    move-result v0

    int-to-double v0, v0

    div-double v0, v2, v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    goto :goto_0
.end method

.method public GetStartingBufferLengthMs()I
    .locals 1

    const/4 v0, -0x1

    return v0
.end method

.method public GetStreamerType()Ljava/lang/String;
    .locals 1

    const-string v0, "VisualOn"

    return-object v0
.end method

.method public GetStreamerVersion()Ljava/lang/String;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public startMonitoring(Lcom/conviva/monitor/IMonitorNotifier;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/streamerProxies/VisualOnProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    return-void
.end method
