.class public Lcom/conviva/streamerProxies/VideoViewProxy;
.super Lcom/conviva/streamerProxies/NativeStreamerProxy;

# interfaces
.implements Landroid/media/MediaPlayer$OnPreparedListener;


# instance fields
.field private _mVideoView:Landroid/widget/VideoView;

.field private _onPreparedListenerOrig:Landroid/media/MediaPlayer$OnPreparedListener;


# virtual methods
.method public Cleanup()V
    .locals 2

    const-string v0, "VideoViewStreamerProxy.Cleanup()"

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/VideoViewProxy;->Log(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    iget-object v1, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_onErrorListenerOrig:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    iget-object v1, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_onPreparedListenerOrig:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    :cond_0
    invoke-super {p0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->Cleanup()V

    return-void
.end method

.method public GetBufferLengthMs()I
    .locals 4

    :try_start_0
    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_duration:I

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->getBufferPercentage()I

    move-result v0

    int-to-double v0, v0

    const-wide/high16 v2, 0x4059000000000000L    # 100.0

    div-double/2addr v0, v2

    iget v2, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_duration:I

    int-to-double v2, v2

    mul-double/2addr v0, v2

    iget-object v2, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    invoke-virtual {v2}, Landroid/widget/VideoView;->getCurrentPosition()I
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    int-to-double v2, v2

    sub-double/2addr v0, v2

    double-to-int v0, v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public GetPlayheadTimeMs()I
    .locals 5

    const/4 v1, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->getCurrentPosition()I

    move-result v0

    if-lez v0, :cond_0

    iget v2, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_duration:I

    if-ne v2, v1, :cond_0

    iget-object v2, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mVideoView:Landroid/widget/VideoView;

    invoke-virtual {v2}, Landroid/widget/VideoView;->getDuration()I

    move-result v2

    iput v2, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_duration:I

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    const-string v3, "duration"

    iget v4, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_duration:I

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v3, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_notifier:Lcom/conviva/monitor/IMonitorNotifier;

    invoke-interface {v3, v2}, Lcom/conviva/monitor/IMonitorNotifier;->OnMetadata(Ljava/util/Map;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public GetStreamerType()Ljava/lang/String;
    .locals 1

    const-string v0, "VideoView"

    return-object v0
.end method

.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 6

    const/4 v1, 0x0

    iget-boolean v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_inListener:Z

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    const-string v0, "VideoViewProxy: onPrepared"

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/VideoViewProxy;->Log(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_onPreparedListenerOrig:Landroid/media/MediaPlayer$OnPreparedListener;

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    :try_start_0
    iput-boolean v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_inListener:Z

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_onPreparedListenerOrig:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-interface {v0, p1}, Landroid/media/MediaPlayer$OnPreparedListener;->onPrepared(Landroid/media/MediaPlayer;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iput-boolean v1, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_inListener:Z

    :cond_2
    iput-object p1, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mPlayer:Landroid/media/MediaPlayer;

    :try_start_1
    const-class v0, Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    array-length v3, v2

    move v0, v1

    :goto_1
    if-ge v0, v3, :cond_0

    aget-object v1, v2, v0

    const-class v4, Landroid/media/MediaPlayer$OnInfoListener;

    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/MediaPlayer$OnInfoListener;

    iput-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_onInfoListenerOrig:Landroid/media/MediaPlayer$OnInfoListener;

    iget-object v0, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_2

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/SecurityException;->printStackTrace()V

    goto :goto_0

    :catchall_0
    move-exception v0

    iput-boolean v1, p0, Lcom/conviva/streamerProxies/VideoViewProxy;->_inListener:Z

    throw v0

    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0

    :catch_2
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method
