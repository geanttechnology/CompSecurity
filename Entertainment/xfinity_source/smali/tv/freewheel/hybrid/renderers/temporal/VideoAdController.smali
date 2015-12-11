.class public Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;
.super Ljava/lang/Object;
.source "VideoAdController.java"

# interfaces
.implements Landroid/widget/MediaController$MediaPlayerControl;


# static fields
.field private static REWIND_INTERVAL:J


# instance fields
.field private lastRewindTime:J

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private mediaPlayer:Landroid/media/MediaPlayer;

.field private pausedByController:Z

.field private videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

.field private videoRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 14
    const-wide/16 v0, 0x3e8

    sput-wide v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->REWIND_INTERVAL:J

    return-void
.end method

.method public constructor <init>(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;Landroid/media/MediaPlayer;)V
    .locals 2
    .param p1, "hostRenderer"    # Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;
    .param p2, "view"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    .param p3, "player"    # Landroid/media/MediaPlayer;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->pausedByController:Z

    .line 15
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->lastRewindTime:J

    .line 20
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 21
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    .line 22
    iput-object p2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .line 23
    iput-object p3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 24
    return-void
.end method


# virtual methods
.method public canPause()Z
    .locals 1

    .prologue
    .line 84
    const/4 v0, 0x1

    return v0
.end method

.method public canSeekBackward()Z
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x1

    return v0
.end method

.method public canSeekForward()Z
    .locals 1

    .prologue
    .line 94
    const/4 v0, 0x0

    return v0
.end method

.method public getBufferPercentage()I
    .locals 1

    .prologue
    .line 79
    const/4 v0, 0x0

    return v0
.end method

.method public getCurrentPosition()I
    .locals 2

    .prologue
    .line 51
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getPlayheadTime()D

    move-result-wide v0

    double-to-int v0, v0

    return v0
.end method

.method public getDuration()I
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getDuration()D

    move-result-wide v0

    double-to-int v0, v0

    return v0
.end method

.method public isPlaying()Z
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onImprTimer()V
    .locals 2

    .prologue
    .line 98
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onImprTimer"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 99
    return-void
.end method

.method public pause()V
    .locals 2

    .prologue
    .line 38
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "pause"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 39
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->pause()V

    .line 40
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->pausedByController:Z

    .line 41
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdPaused()V

    .line 42
    return-void
.end method

.method public seekTo(I)V
    .locals 6
    .param p1, "msec"    # I

    .prologue
    .line 56
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "seekTo "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", currentPosition "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v4}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 57
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v2

    if-lt p1, v2, :cond_0

    .line 58
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "disallow seek forward"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 70
    :goto_0
    return-void

    .line 61
    :cond_0
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v2, p1}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->seekTo(I)V

    .line 63
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 65
    .local v0, "currentTime":J
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "current time "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", last rewind time "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->lastRewindTime:J

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 66
    iget-wide v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->lastRewindTime:J

    sget-wide v4, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->REWIND_INTERVAL:J

    add-long/2addr v2, v4

    cmp-long v2, v0, v2

    if-lez v2, :cond_1

    .line 67
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdRewind()V

    .line 69
    :cond_1
    iput-wide v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->lastRewindTime:J

    goto :goto_0
.end method

.method public start()V
    .locals 2

    .prologue
    .line 28
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "start"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 29
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->start()V

    .line 30
    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->pausedByController:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->pausedByController:Z

    .line 32
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->videoRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdResumed()V

    .line 34
    :cond_0
    return-void
.end method
