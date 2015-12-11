.class public Lcom/google/android/exoplayer/ExoPlayer;
.super Ljava/lang/Object;
.source "ExoPlayer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/exoplayer/ExoPlayer$Factory;,
        Lcom/google/android/exoplayer/ExoPlayer$Listener;
    }
.end annotation


# static fields
.field public static final STATE_BUFFERING:I = 0x3

.field public static final STATE_ENDED:I = 0x4

.field public static final STATE_IDLE:I = 0x1

.field public static final STATE_PREPARING:I = 0x2

.field public static final STATE_READY:I = 0x5


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 96
    return-void
.end method


# virtual methods
.method public addListener(Lcom/google/android/exoplayer/ExoPlayer$Listener;)V
    .locals 0
    .param p1, "listener"    # Lcom/google/android/exoplayer/ExoPlayer$Listener;

    .prologue
    .line 26
    return-void
.end method

.method public blockingSendMessage(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "mExoVideoRenderer"    # Ljava/lang/Object;
    .param p2, "msgSetSurface"    # Ljava/lang/Object;
    .param p3, "mSurfaceHolder"    # Ljava/lang/Object;

    .prologue
    .line 57
    return-void
.end method

.method public getCurrentPosition()I
    .locals 1

    .prologue
    .line 41
    const/4 v0, 0x0

    return v0
.end method

.method public getDuration()I
    .locals 1

    .prologue
    .line 45
    const/4 v0, 0x0

    return v0
.end method

.method public getPlayWhenReady()Z
    .locals 1

    .prologue
    .line 49
    const/4 v0, 0x0

    return v0
.end method

.method public prepare(Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;)V
    .locals 0
    .param p1, "videoRenderer"    # Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;
    .param p2, "audioRenderer"    # Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;

    .prologue
    .line 30
    return-void
.end method

.method public release()V
    .locals 0

    .prologue
    .line 54
    return-void
.end method

.method public seekTo(I)V
    .locals 0
    .param p1, "msec"    # I

    .prologue
    .line 38
    return-void
.end method

.method public sendMessage(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "mExoVideoRenderer"    # Ljava/lang/Object;
    .param p2, "msgSetSurface"    # Ljava/lang/Object;
    .param p3, "mSurfaceHolder"    # Ljava/lang/Object;

    .prologue
    .line 22
    return-void
.end method

.method public setPlayWhenReady(Z)V
    .locals 0
    .param p1, "b"    # Z

    .prologue
    .line 34
    return-void
.end method

.method public stop()V
    .locals 0

    .prologue
    .line 61
    return-void
.end method
