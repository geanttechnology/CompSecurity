.class public Lcom/conviva/streamerProxies/NexStreamingProxy;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/conviva/ConvivaStreamerProxy;
.implements Lcom/nexstreaming/nexplayerengine/NexPlayer$IListener;


# instance fields
.field private _iListenerOrig:Lcom/nexstreaming/nexplayerengine/NexPlayer$IListener;

.field private _notifier:Lcom/conviva/monitor/IMonitorNotifier;

.field private _playheadSec:I

.field private _streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

.field private _utils:Lcom/conviva/utils/PlatformUtils;


# virtual methods
.method public Cleanup()V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

    iget-object v1, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_iListenerOrig:Lcom/nexstreaming/nexplayerengine/NexPlayer$IListener;

    invoke-virtual {v0, v1}, Lcom/nexstreaming/nexplayerengine/NexPlayer;->setListener(Lcom/nexstreaming/nexplayerengine/NexPlayer$IListener;)V

    iput-object v2, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_iListenerOrig:Lcom/nexstreaming/nexplayerengine/NexPlayer$IListener;

    iput-object v2, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

    iput-object v2, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    iput-object v2, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_utils:Lcom/conviva/utils/PlatformUtils;

    return-void
.end method

.method public GetBufferLengthMs()I
    .locals 2

    iget-object v0, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

    const/4 v1, 0x7

    invoke-virtual {v0, v1}, Lcom/nexstreaming/nexplayerengine/NexPlayer;->getContentInfoInt(I)I

    move-result v0

    return v0
.end method

.method public GetCapabilities()I
    .locals 1

    const/4 v0, 0x7

    return v0
.end method

.method public GetMinBufferLengthMs()I
    .locals 2

    iget-object v0, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

    sget-object v1, Lcom/nexstreaming/nexplayerengine/NexPlayer$NexProperty;->RE_BUFFERING_DURATION:Lcom/nexstreaming/nexplayerengine/NexPlayer$NexProperty;

    invoke-virtual {v0, v1}, Lcom/nexstreaming/nexplayerengine/NexPlayer;->getProperty(Lcom/nexstreaming/nexplayerengine/NexPlayer$NexProperty;)I

    move-result v0

    return v0
.end method

.method public GetPlayheadTimeMs()I
    .locals 1

    iget v0, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_playheadSec:I

    return v0
.end method

.method public GetRenderedFrameRate()D
    .locals 2

    iget-object v0, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/nexstreaming/nexplayerengine/NexPlayer;->getContentInfoInt(I)I

    move-result v0

    int-to-double v0, v0

    return-wide v0
.end method

.method public GetStartingBufferLengthMs()I
    .locals 2

    iget-object v0, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

    sget-object v1, Lcom/nexstreaming/nexplayerengine/NexPlayer$NexProperty;->INITIAL_BUFFERING_DURATION:Lcom/nexstreaming/nexplayerengine/NexPlayer$NexProperty;

    invoke-virtual {v0, v1}, Lcom/nexstreaming/nexplayerengine/NexPlayer;->getProperty(Lcom/nexstreaming/nexplayerengine/NexPlayer$NexProperty;)I

    move-result v0

    return v0
.end method

.method public GetStreamerType()Ljava/lang/String;
    .locals 1

    const-string v0, "NexPlayer"

    return-object v0
.end method

.method public GetStreamerVersion()Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/nexstreaming/nexplayerengine/NexPlayer;->getVersion(I)I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_streamer:Lcom/nexstreaming/nexplayerengine/NexPlayer;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/nexstreaming/nexplayerengine/NexPlayer;->getVersion(I)I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public startMonitoring(Lcom/conviva/monitor/IMonitorNotifier;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/streamerProxies/NexStreamingProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    return-void
.end method
