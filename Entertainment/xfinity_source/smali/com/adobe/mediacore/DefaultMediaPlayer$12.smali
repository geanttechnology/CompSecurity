.class Lcom/adobe/mediacore/DefaultMediaPlayer$12;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/VideoStateChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/DefaultMediaPlayer;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onStateChanged(Lcom/adobe/mediacore/MediaPlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1700(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1400()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onStateChanged"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ignore event as media player is in ERROR state."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/DefaultMediaPlayer$13;->$SwitchMap$com$adobe$mediacore$MediaPlayerState:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1400()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onPlayPaused"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Playback paused."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1400()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onPlayStart"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Playback started."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimerRunning:Z
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # invokes: Lcom/adobe/mediacore/DefaultMediaPlayer;->startInternalTimer()V
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$700(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAY_START:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->COMPLETE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v0, v1, v3}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1400()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onPlaybackComplete"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Playback completed."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$900(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TimelineMonitor;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$900(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TimelineMonitor;

    move-result-object v0

    invoke-virtual {v0, v3}, Lcom/adobe/mediacore/TimelineMonitor;->updateCurrentAdInfo(Lcom/adobe/mediacore/AdTimeline$Info;)V

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # invokes: Lcom/adobe/mediacore/DefaultMediaPlayer;->stopInternalTimer()V
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$2200(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->COMPLETE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v0, v1, v3}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->PLAY_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1400()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onStateChanged"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Playback suspended"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$12;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v0, v1, v3}, Lcom/adobe/mediacore/DefaultMediaPlayer;->setStatus(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
