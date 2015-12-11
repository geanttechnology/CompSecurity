.class public abstract Lcom/conviva/streamerProxies/NativeStreamerProxy;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/media/MediaPlayer$OnErrorListener;
.implements Landroid/media/MediaPlayer$OnInfoListener;
.implements Lcom/conviva/ConvivaStreamerProxy;


# instance fields
.field private final MEDIA_INFO_BUFFERING_END:I

.field private final MEDIA_INFO_BUFFERING_START:I

.field private _apiLevel:I

.field protected _duration:I

.field protected _inListener:Z

.field protected _mPlayer:Landroid/media/MediaPlayer;

.field protected _notifier:Lcom/conviva/monitor/IMonitorNotifier;

.field protected _onErrorListenerOrig:Landroid/media/MediaPlayer$OnErrorListener;

.field protected _onInfoListenerOrig:Landroid/media/MediaPlayer$OnInfoListener;

.field private _preparedState:Z

.field protected _utils:Lcom/conviva/utils/PlatformUtils;


# direct methods
.method public constructor <init>()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    iput-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_utils:Lcom/conviva/utils/PlatformUtils;

    iput-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    const/4 v0, -0x1

    iput v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_duration:I

    const/16 v0, 0x2bd

    iput v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->MEDIA_INFO_BUFFERING_START:I

    const/16 v0, 0x2be

    iput v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->MEDIA_INFO_BUFFERING_END:I

    iput-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onErrorListenerOrig:Landroid/media/MediaPlayer$OnErrorListener;

    iput-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onInfoListenerOrig:Landroid/media/MediaPlayer$OnInfoListener;

    iput v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_apiLevel:I

    iput-boolean v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_preparedState:Z

    iput-boolean v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    invoke-static {}, Lcom/conviva/utils/PlatformUtils;->getInstance()Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    iput-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_utils:Lcom/conviva/utils/PlatformUtils;

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    iput v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_apiLevel:I

    return-void
.end method


# virtual methods
.method public Cleanup()V
    .locals 3

    const/4 v2, 0x0

    const-string v0, "NativeStreamerProxy: clean up callbacks"

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->Log(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    iget-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onErrorListenerOrig:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    iget-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onInfoListenerOrig:Landroid/media/MediaPlayer$OnInfoListener;

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V

    iput-object v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    :cond_0
    iput-object v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onErrorListenerOrig:Landroid/media/MediaPlayer$OnErrorListener;

    iput-object v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onInfoListenerOrig:Landroid/media/MediaPlayer$OnInfoListener;

    return-void
.end method

.method public GetCapabilities()I
    .locals 1

    const/4 v0, 0x3

    return v0
.end method

.method public GetMinBufferLengthMs()I
    .locals 1

    const/16 v0, 0x5dc

    return v0
.end method

.method public GetPlayheadTimeMs()I
    .locals 5

    const/4 v0, -0x1

    :try_start_0
    iget-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_preparedState:Z

    if-nez v1, :cond_1

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_preparedState:Z

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v1

    if-lez v1, :cond_2

    iget v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_duration:I

    if-ne v2, v0, :cond_2

    iget-object v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v2

    iput v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_duration:I

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    const-string v3, "duration"

    iget v4, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_duration:I

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v3, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    invoke-interface {v3, v2}, Lcom/conviva/monitor/IMonitorNotifier;->OnMetadata(Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_2
    move v0, v1

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public GetRenderedFrameRate()D
    .locals 2

    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    return-wide v0
.end method

.method public GetStartingBufferLengthMs()I
    .locals 1

    const/16 v0, 0x2af8

    return v0
.end method

.method public GetStreamerVersion()Ljava/lang/String;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public Log(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    invoke-interface {v0, p1}, Lcom/conviva/monitor/IMonitorNotifier;->Log(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_utils:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0, p1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getApiLevel()I
    .locals 1

    iget v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_apiLevel:I

    return v0
.end method

.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 4

    const/4 v3, 0x0

    const/4 v1, 0x1

    iget-boolean v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Proxy: onError ("

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ")"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->Log(Ljava/lang/String;)V

    if-ne p2, v1, :cond_1

    const-string v0, "MEDIA_ERROR_UNKNOWN"

    :goto_1
    invoke-static {v0, v1}, Lcom/conviva/StreamerError;->makeUnscopedError(Ljava/lang/String;I)Lcom/conviva/StreamerError;

    move-result-object v0

    iget-object v2, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    invoke-interface {v2, v0}, Lcom/conviva/monitor/IMonitorNotifier;->OnError(Lcom/conviva/StreamerError;)V

    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onErrorListenerOrig:Landroid/media/MediaPlayer$OnErrorListener;

    if-eqz v0, :cond_4

    iput-boolean v1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    :try_start_0
    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onErrorListenerOrig:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-interface {v0, p1, p2, p3}, Landroid/media/MediaPlayer$OnErrorListener;->onError(Landroid/media/MediaPlayer;II)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    iput-boolean v3, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    goto :goto_0

    :cond_1
    const/16 v0, 0x64

    if-ne p2, v0, :cond_2

    const-string v0, "MEDIA_ERROR_SERVER_DIED"

    goto :goto_1

    :cond_2
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_3

    const-string v0, "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK"

    goto :goto_1

    :cond_3
    const-string v0, "MEDIA_ERROR_UNKNOWN"

    goto :goto_1

    :catchall_0
    move-exception v0

    iput-boolean v3, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    throw v0

    :cond_4
    move v0, v1

    goto :goto_0
.end method

.method public onInfo(Landroid/media/MediaPlayer;II)Z
    .locals 5

    const/16 v1, 0x64

    const/4 v2, 0x1

    const/4 v3, 0x0

    iget-boolean v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    if-eqz v0, :cond_0

    :goto_0
    return v2

    :cond_0
    const-string v0, "Proxy: onInfo"

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->Log(Ljava/lang/String;)V

    iget v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_apiLevel:I

    const/16 v4, 0x9

    if-lt v0, v4, :cond_6

    const/16 v0, 0x2bd

    if-ne p2, v0, :cond_2

    const-string v0, "Buffering start event"

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->Log(Ljava/lang/String;)V

    const/4 v0, 0x6

    :goto_1
    if-eq v0, v1, :cond_1

    iget-object v4, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    invoke-interface {v4, v0}, Lcom/conviva/monitor/IMonitorNotifier;->SetPlayingState(I)V

    :cond_1
    :goto_2
    iget-object v4, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onInfoListenerOrig:Landroid/media/MediaPlayer$OnInfoListener;

    if-eqz v4, :cond_4

    const/4 v0, 0x1

    :try_start_0
    iput-boolean v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    iget-object v0, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_onInfoListenerOrig:Landroid/media/MediaPlayer$OnInfoListener;

    invoke-interface {v0, p1, p2, p3}, Landroid/media/MediaPlayer$OnInfoListener;->onInfo(Landroid/media/MediaPlayer;II)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    iput-boolean v3, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    goto :goto_0

    :cond_2
    const/16 v0, 0x2be

    if-ne p2, v0, :cond_3

    const-string v0, "Buffering end event"

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->Log(Ljava/lang/String;)V

    const/4 v0, 0x3

    goto :goto_1

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "other events: "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " : ignored"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->Log(Ljava/lang/String;)V

    move v0, v1

    goto :goto_1

    :catchall_0
    move-exception v0

    iput-boolean v3, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_inListener:Z

    throw v0

    :cond_4
    if-eq v0, v1, :cond_5

    move v0, v2

    :goto_3
    move v2, v0

    goto :goto_0

    :cond_5
    move v0, v3

    goto :goto_3

    :cond_6
    move v0, v1

    goto :goto_2
.end method

.method public startMonitoring(Lcom/conviva/monitor/IMonitorNotifier;)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/streamerProxies/NativeStreamerProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    return-void
.end method
