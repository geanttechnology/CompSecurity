.class Lcom/adobe/mediacore/DefaultMediaPlayer$8;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/BufferingFullListener;


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

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$8;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFull()V
    .locals 6

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$8;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_currentStatus:Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1700(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$8;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

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

    const-string v2, "#onPlayerBufferFull"

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
    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$8;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

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

    const-string v2, "#onPlayerBufferFull"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Buffer full: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$8;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_playbackMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
    invoke-static {v3}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$500(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getBufferLength()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$8;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$8;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # invokes: Lcom/adobe/mediacore/DefaultMediaPlayer;->stopInternalTimer()V
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$2200(Lcom/adobe/mediacore/DefaultMediaPlayer;)V

    goto :goto_0
.end method
