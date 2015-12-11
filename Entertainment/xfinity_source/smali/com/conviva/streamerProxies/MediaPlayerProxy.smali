.class public Lcom/conviva/streamerProxies/MediaPlayerProxy;
.super Lcom/conviva/streamerProxies/NativeStreamerProxy;

# interfaces
.implements Landroid/media/MediaPlayer$OnBufferingUpdateListener;


# instance fields
.field private _bufferingPercentage:I

.field private _onBufferingUpdateListenerOrig:Landroid/media/MediaPlayer$OnBufferingUpdateListener;


# virtual methods
.method public Cleanup()V
    .locals 2

    const-string v0, "MediaPlayerStreamerProxy.Cleanup()"

    invoke-virtual {p0, v0}, Lcom/conviva/streamerProxies/MediaPlayerProxy;->Log(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    iget-object v1, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_onBufferingUpdateListenerOrig:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_onBufferingUpdateListenerOrig:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-super {p0}, Lcom/conviva/streamerProxies/NativeStreamerProxy;->Cleanup()V

    return-void
.end method

.method public GetBufferLengthMs()I
    .locals 6

    const/4 v0, -0x1

    :try_start_0
    iget-object v1, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_duration:I

    if-lez v1, :cond_0

    iget v1, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_duration:I

    iget v2, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_bufferingPercentage:I

    mul-int/2addr v1, v2

    int-to-double v2, v1

    const-wide/high16 v4, 0x4059000000000000L    # 100.0

    div-double/2addr v2, v4

    double-to-int v1, v2

    iget-object v2, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getCurrentPosition()I
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    sub-int v0, v1, v0

    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v1

    const-string v1, "player is not in the proper state when GetBufferLengthMs() is called"

    invoke-virtual {p0, v1}, Lcom/conviva/streamerProxies/MediaPlayerProxy;->Log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public GetStreamerType()Ljava/lang/String;
    .locals 1

    const-string v0, "MediaPlay"

    return-object v0
.end method

.method public onBufferingUpdate(Landroid/media/MediaPlayer;I)V
    .locals 1

    iput p2, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_bufferingPercentage:I

    iget-object v0, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_onBufferingUpdateListenerOrig:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/conviva/streamerProxies/MediaPlayerProxy;->_onBufferingUpdateListenerOrig:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-interface {v0, p1, p2}, Landroid/media/MediaPlayer$OnBufferingUpdateListener;->onBufferingUpdate(Landroid/media/MediaPlayer;I)V

    :cond_0
    return-void
.end method
