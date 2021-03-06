.class public Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnPullEventListener;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mCurrentMediaPlayer:Landroid/media/MediaPlayer;

.field private final mSoundMap:Ljava/util/HashMap;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mContext:Landroid/content/Context;

    .line 42
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mSoundMap:Ljava/util/HashMap;

    .line 43
    return-void
.end method

.method private playSound(I)V
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mCurrentMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 86
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mCurrentMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V

    .line 87
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mCurrentMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 90
    :cond_0
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Landroid/media/MediaPlayer;->create(Landroid/content/Context;I)Landroid/media/MediaPlayer;

    move-result-object v0

    iput-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mCurrentMediaPlayer:Landroid/media/MediaPlayer;

    .line 91
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mCurrentMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 92
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mCurrentMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 94
    :cond_1
    return-void
.end method


# virtual methods
.method public addSoundEvent(Lcom/handmark/pulltorefresh/library/PullToRefreshBase$State;I)V
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mSoundMap:Ljava/util/HashMap;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    return-void
.end method

.method public clearSounds()V
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mSoundMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 74
    return-void
.end method

.method public getCurrentMediaPlayer()Landroid/media/MediaPlayer;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mCurrentMediaPlayer:Landroid/media/MediaPlayer;

    return-object v0
.end method

.method public final onPullEvent(Lcom/handmark/pulltorefresh/library/PullToRefreshBase;Lcom/handmark/pulltorefresh/library/PullToRefreshBase$State;Lcom/handmark/pulltorefresh/library/PullToRefreshBase$Mode;)V
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->mSoundMap:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 48
    if-eqz v0, :cond_0

    .line 49
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/handmark/pulltorefresh/library/extras/SoundPullEventListener;->playSound(I)V

    .line 51
    :cond_0
    return-void
.end method
