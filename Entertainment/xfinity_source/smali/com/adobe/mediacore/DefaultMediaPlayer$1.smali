.class Lcom/adobe/mediacore/DefaultMediaPlayer$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/SeekAdjustCompletedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/DefaultMediaPlayer;
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

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdjustCompleted(J)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$000(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SEEK_ADJUST_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_seekAdjustCompletedListener:Lcom/adobe/mediacore/SeekAdjustCompletedListener;
    invoke-static {v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$000(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$200(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineAdapter;

    move-result-object v0

    const/4 v1, -0x1

    invoke-static {v1, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->seek(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-virtual {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    if-eq v0, v1, :cond_1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-virtual {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v1

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$200(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->play()V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_item:Lcom/adobe/mediacore/MediaPlayerItem;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$300(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerItem;

    move-result-object v0

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$400(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerClient;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$400(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayerClient;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
    invoke-static {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$500(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getTime()J

    move-result-wide v2

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
    invoke-static {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$500(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Lcom/adobe/mediacore/MediaPlayerClient;->update(JLcom/adobe/mediacore/utils/TimeRange;)V

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimerRunning:Z
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$1;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # invokes: Lcom/adobe/mediacore/DefaultMediaPlayer;->startInternalTimer()V
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$700(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    :cond_3
    return-void
.end method
