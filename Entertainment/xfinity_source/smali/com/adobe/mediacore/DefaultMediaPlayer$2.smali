.class Lcom/adobe/mediacore/DefaultMediaPlayer$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


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

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$200(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/VideoEngineAdapter;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$500(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getCurrentTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;
    invoke-static {v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$800(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/AdTimeline;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;
    invoke-static {v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$800(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/AdTimeline;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/AdTimeline;->update(J)V

    :cond_0
    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;
    invoke-static {v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$900(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TimelineMonitor;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;
    invoke-static {v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$900(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TimelineMonitor;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/TimelineMonitor;->update(J)V

    :cond_1
    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;
    invoke-static {v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1000(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TrickPlayManager;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_trickPlayManager:Lcom/adobe/mediacore/TrickPlayManager;
    invoke-static {v2}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1000(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/TrickPlayManager;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/TrickPlayManager;->update(J)V

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_shouldStopInternalTimer:Z
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1100(Lcom/adobe/mediacore/DefaultMediaPlayer;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1300(Lcom/adobe/mediacore/DefaultMediaPlayer;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$2;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_internalTimer:Ljava/lang/Runnable;
    invoke-static {v1}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1200(Lcom/adobe/mediacore/DefaultMediaPlayer;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_3
    return-void
.end method
