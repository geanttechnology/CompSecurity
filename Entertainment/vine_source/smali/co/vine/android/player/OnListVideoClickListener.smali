.class public Lco/vine/android/player/OnListVideoClickListener;
.super Ljava/lang/Object;
.source "OnListVideoClickListener.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private final mAdapter:Lco/vine/android/player/HasVideoPlayerAdapter;

.field private mPosition:I


# direct methods
.method public constructor <init>(Lco/vine/android/player/HasVideoPlayerAdapter;)V
    .locals 0
    .param p1, "adapter"    # Lco/vine/android/player/HasVideoPlayerAdapter;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lco/vine/android/player/OnListVideoClickListener;->mAdapter:Lco/vine/android/player/HasVideoPlayerAdapter;

    .line 17
    return-void
.end method


# virtual methods
.method public getPosition()I
    .locals 1

    .prologue
    .line 50
    iget v0, p0, Lco/vine/android/player/OnListVideoClickListener;->mPosition:I

    return v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 21
    iget-object v1, p0, Lco/vine/android/player/OnListVideoClickListener;->mAdapter:Lco/vine/android/player/HasVideoPlayerAdapter;

    iget v2, p0, Lco/vine/android/player/OnListVideoClickListener;->mPosition:I

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Lco/vine/android/player/HasVideoPlayerAdapter;->getPlayer(IZ)Lco/vine/android/player/SdkVideoView;

    move-result-object v0

    .line 22
    .local v0, "player":Lco/vine/android/player/SdkVideoView;
    iget-object v1, p0, Lco/vine/android/player/OnListVideoClickListener;->mAdapter:Lco/vine/android/player/HasVideoPlayerAdapter;

    invoke-interface {v1}, Lco/vine/android/player/HasVideoPlayerAdapter;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v1

    if-eq v1, v0, :cond_0

    .line 23
    iget-object v1, p0, Lco/vine/android/player/OnListVideoClickListener;->mAdapter:Lco/vine/android/player/HasVideoPlayerAdapter;

    invoke-interface {v1}, Lco/vine/android/player/HasVideoPlayerAdapter;->pauseCurrentPlayer()V

    .line 25
    :cond_0
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->hasStarted()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 26
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_1

    .line 27
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->onViewClicked()V

    .line 29
    :cond_1
    iget v1, p0, Lco/vine/android/player/OnListVideoClickListener;->mPosition:I

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->getPlayingPosition()I

    move-result v2

    if-ne v1, v2, :cond_3

    .line 30
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isPaused()Z

    move-result v1

    if-nez v1, :cond_2

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isPlaying()Z

    move-result v1

    if-nez v1, :cond_4

    .line 31
    :cond_2
    invoke-virtual {p0, v0}, Lco/vine/android/player/OnListVideoClickListener;->resume(Lco/vine/android/player/SdkVideoView;)V

    .line 39
    :cond_3
    :goto_0
    return-void

    .line 33
    :cond_4
    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->pause()V

    goto :goto_0

    .line 37
    :cond_5
    iget-object v1, p0, Lco/vine/android/player/OnListVideoClickListener;->mAdapter:Lco/vine/android/player/HasVideoPlayerAdapter;

    iget v2, p0, Lco/vine/android/player/OnListVideoClickListener;->mPosition:I

    invoke-interface {v1, v2}, Lco/vine/android/player/HasVideoPlayerAdapter;->play(I)V

    goto :goto_0
.end method

.method protected resume(Lco/vine/android/player/SdkVideoView;)V
    .locals 0
    .param p1, "player"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 42
    invoke-virtual {p1}, Lco/vine/android/player/SdkVideoView;->resume()V

    .line 43
    return-void
.end method

.method public setPosition(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 46
    iput p1, p0, Lco/vine/android/player/OnListVideoClickListener;->mPosition:I

    .line 47
    return-void
.end method
