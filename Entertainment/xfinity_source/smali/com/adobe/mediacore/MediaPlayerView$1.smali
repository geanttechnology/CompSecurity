.class Lcom/adobe/mediacore/MediaPlayerView$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/MediaPlayerView;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/MediaPlayerView;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerView$1;->this$0:Lcom/adobe/mediacore/MediaPlayerView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPlayComplete()V
    .locals 0

    return-void
.end method

.method public onPlayStart()V
    .locals 0

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
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView$1;->this$0:Lcom/adobe/mediacore/MediaPlayerView;

    # setter for: Lcom/adobe/mediacore/MediaPlayerView;->currentPlayerState:Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    invoke-static {v0, p1}, Lcom/adobe/mediacore/MediaPlayerView;->access$602(Lcom/adobe/mediacore/MediaPlayerView;Lcom/adobe/mediacore/MediaPlayer$PlayerState;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    return-void
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
