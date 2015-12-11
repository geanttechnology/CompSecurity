.class public Lcom/conviva/streamerProxies/VisualOnImplProxy;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/conviva/ConvivaStreamerProxy;
.implements Lcom/visualon/OSMPPlayer/VOCommonPlayerListener;


# instance fields
.field private _iListenerOrig:Lcom/visualon/OSMPPlayer/VOCommonPlayerListener;

.field private _notifier:Lcom/conviva/monitor/IMonitorNotifier;

.field private _streamer:Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;


# virtual methods
.method public Cleanup()V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_streamer:Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;

    iget-object v1, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_iListenerOrig:Lcom/visualon/OSMPPlayer/VOCommonPlayerListener;

    invoke-virtual {v0, v1}, Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;->setOnEventListener(Lcom/visualon/OSMPPlayer/VOCommonPlayerListener;)Lcom/visualon/OSMPPlayer/VOOSMPType$VO_OSMP_RETURN_CODE;

    iput-object v2, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_iListenerOrig:Lcom/visualon/OSMPPlayer/VOCommonPlayerListener;

    iput-object v2, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_streamer:Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;

    iput-object v2, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

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

    const/4 v1, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_streamer:Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_streamer:Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;

    invoke-virtual {v0}, Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;->getPosition()J

    move-result-wide v2

    long-to-int v0, v2

    iget-object v2, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_streamer:Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;

    invoke-virtual {v2}, Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;->getPlayerStatus()Lcom/visualon/OSMPPlayer/VOOSMPType$VO_OSMP_STATUS;

    move-result-object v2

    sget-object v3, Lcom/visualon/OSMPPlayer/VOOSMPType$VO_OSMP_STATUS;->VO_OSMP_STATUS_PAUSED:Lcom/visualon/OSMPPlayer/VOOSMPType$VO_OSMP_STATUS;

    if-ne v2, v3, :cond_0

    iget-object v2, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    const/16 v3, 0xc

    invoke-interface {v2, v3}, Lcom/conviva/monitor/IMonitorNotifier;->SetPlayingState(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v0

    move v0, v1

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public GetRenderedFrameRate()D
    .locals 2

    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    return-wide v0
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
    .locals 2

    iget-object v0, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_streamer:Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;

    sget-object v1, Lcom/visualon/OSMPPlayer/VOOSMPType$VO_OSMP_MODULE_TYPE;->VO_OSMP_MODULE_TYPE_SDK:Lcom/visualon/OSMPPlayer/VOOSMPType$VO_OSMP_MODULE_TYPE;

    invoke-virtual {v0, v1}, Lcom/visualon/OSMPPlayerImpl/VOCommonPlayerImpl;->getVersion(Lcom/visualon/OSMPPlayer/VOOSMPType$VO_OSMP_MODULE_TYPE;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public startMonitoring(Lcom/conviva/monitor/IMonitorNotifier;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/streamerProxies/VisualOnImplProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    return-void
.end method
