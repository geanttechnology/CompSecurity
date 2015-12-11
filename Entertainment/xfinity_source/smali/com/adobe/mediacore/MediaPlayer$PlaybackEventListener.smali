.class public interface abstract Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$EventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "PlaybackEventListener"
.end annotation


# virtual methods
.method public abstract onPlayComplete()V
.end method

.method public abstract onPlayStart()V
.end method

.method public abstract onPrepared()V
.end method

.method public abstract onProfileChanged(JJ)V
.end method

.method public abstract onRatePlaying(F)V
.end method

.method public abstract onRateSelected(F)V
.end method

.method public abstract onReplaceMediaPlayerItem()V
.end method

.method public abstract onSizeAvailable(JJ)V
.end method

.method public abstract onStateChanged(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)V
.end method

.method public abstract onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
.end method

.method public abstract onTimelineUpdated()V
.end method

.method public abstract onUpdated()V
.end method
