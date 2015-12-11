.class public interface abstract Lcom/adobe/mediacore/MediaPlayer;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;,
        Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;,
        Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;,
        Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;,
        Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;,
        Lcom/adobe/mediacore/MediaPlayer$EventListener;,
        Lcom/adobe/mediacore/MediaPlayer$Event;,
        Lcom/adobe/mediacore/MediaPlayer$Visibility;,
        Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    }
.end annotation


# static fields
.field public static final LIVE_POINT:J = -0x2L


# virtual methods
.method public abstract addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V
.end method

.method public abstract convertToLocalTime(J)J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getBufferControlParameters()Lcom/adobe/mediacore/BufferControlParameters;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getBufferedRange()Lcom/adobe/mediacore/utils/TimeRange;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getCCStyle()Lcom/adobe/mediacore/TextFormat;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getCCVisibility()Lcom/adobe/mediacore/MediaPlayer$Visibility;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getCurrentItem()Lcom/adobe/mediacore/MediaPlayerItem;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getCurrentTime()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getDRMManager()Lcom/adobe/ave/drm/DRMManager;
.end method

.method public abstract getLocalTime()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getNotificationHistory()Lcom/adobe/mediacore/session/NotificationHistory;
.end method

.method public abstract getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getRate()F
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getStatus()Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getTimeline()Lcom/adobe/mediacore/timeline/Timeline;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract getView()Lcom/adobe/mediacore/MediaPlayerView;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract pause()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract play()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract prepareBuffer()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract prepareToPlay()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract prepareToPlay(J)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract registerAdClientFactory(Lcom/adobe/mediacore/AdClientFactory;)V
.end method

.method public abstract registerCurrentItemAsBackgroundItem()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract release()V
.end method

.method public abstract removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V
.end method

.method public abstract replaceCurrentItem(Lcom/adobe/mediacore/MediaResource;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract reset()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract seek(J)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract seekToLocalTime(J)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setABRControlParameters(Lcom/adobe/mediacore/ABRControlParameters;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setCCStyle(Lcom/adobe/mediacore/TextFormat;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setCCVisibility(Lcom/adobe/mediacore/MediaPlayer$Visibility;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setCustomConfiguration(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setRate(F)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setVolume(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract shouldTriggerSubscribedTagEvent()Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract unregisterCurrentBackgroundItem()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method
