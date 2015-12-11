.class Lcom/adobe/mediacore/qos/QOSProvider$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/qos/QOSProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/qos/QOSProvider;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/qos/QOSProvider;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/qos/QOSProvider$2;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPlayComplete()V
    .locals 0

    return-void
.end method

.method public onPlayStart()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$2;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$200(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->recordTimeToFirstFrame()V

    return-void
.end method

.method public onPrepared()V
    .locals 0

    return-void
.end method

.method public onProfileChanged(JJ)V
    .locals 0

    return-void
.end method

.method public onRatePlaying(F)V
    .locals 0

    return-void
.end method

.method public onRateSelected(F)V
    .locals 0

    return-void
.end method

.method public onReplaceMediaPlayerItem()V
    .locals 0

    return-void
.end method

.method public onSizeAvailable(JJ)V
    .locals 0

    return-void
.end method

.method public onStateChanged(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/qos/QOSProvider$3;->$SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$2;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$200(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->recordPlaybackInit()V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$2;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$200(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->recordPlaybackLoad()V

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$2;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$200(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->recordTimeToPrepare()V

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$2;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_playbackLoadMetrics:Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$200(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackLoadMetrics;->recordPlaybackStart()V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 0

    return-void
.end method

.method public onTimelineUpdated()V
    .locals 0

    return-void
.end method

.method public onUpdated()V
    .locals 0

    return-void
.end method
