.class public Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;
.super Ljava/lang/Object;
.source "AndroidPlayer.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnErrorListener;
.implements Landroid/media/MediaPlayer$OnPreparedListener;
.implements Lcom/comcast/playerplatform/primetime/android/player/Player;


# instance fields
.field private appContext:Landroid/content/Context;

.field private currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

.field private listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

.field private playerSurface:Landroid/view/SurfaceView;

.field private primeTimePlayer:Landroid/media/MediaPlayer;

.field private status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->IDLE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 44
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    .line 45
    new-instance v0, Landroid/view/SurfaceView;

    invoke-direct {v0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->playerSurface:Landroid/view/SurfaceView;

    .line 46
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->appContext:Landroid/content/Context;

    .line 47
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 48
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 49
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setScreenOnWhilePlaying(Z)V

    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$1;

    invoke-direct {v1, p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$1;-><init>(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)V

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 57
    return-void
.end method

.method static synthetic access$002(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;
    .param p1, "x1"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object p1
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V

    return-void
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->appContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)Landroid/media/MediaPlayer;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    return-object v0
.end method

.method private declared-synchronized notifyPlayStateChange()V
    .locals 2

    .prologue
    .line 76
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_0

    .line 77
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 78
    :cond_0
    monitor-exit p0

    return-void

    .line 76
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private sendMediaOpened()V
    .locals 15

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    const-string v1, "HLS"

    const-string v2, "Live"

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->getAvailableAudioLanguages()Ljava/util/List;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->getAvailableClosedCaptionTracks()Ljava/util/List;

    move-result-object v5

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->getVideoWidth()J

    move-result-wide v6

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->getVideoHeight()J

    move-result-wide v8

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->getDuration()J

    move-result-wide v10

    const-wide/16 v12, 0x0

    const/4 v14, 0x0

    invoke-virtual/range {v0 .. v14}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaOpened(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;JJJDZ)V

    .line 73
    :cond_0
    return-void
.end method


# virtual methods
.method public addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 0
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 317
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 318
    return-void
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 83
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 84
    return-void
.end method

.method public getAdManager()Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
    .locals 1

    .prologue
    .line 307
    const/4 v0, 0x0

    return-object v0
.end method

.method public getAvailableAudioLanguages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;",
            ">;"
        }
    .end annotation

    .prologue
    .line 242
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getAvailableBitrates()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 287
    const/4 v0, 0x0

    return-object v0
.end method

.method public getAvailableClosedCaptionTracks()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;",
            ">;"
        }
    .end annotation

    .prologue
    .line 252
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getAvailableProfiles()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 282
    const/4 v0, 0x0

    return-object v0
.end method

.method public getClosedCaptionsStatus()Z
    .locals 1

    .prologue
    .line 267
    const/4 v0, 0x0

    return v0
.end method

.method public getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    .locals 1

    .prologue
    .line 247
    const/4 v0, 0x0

    return-object v0
.end method

.method public getCurrentBitrate()I
    .locals 1

    .prologue
    .line 277
    const/4 v0, 0x0

    return v0
.end method

.method public getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1

    .prologue
    .line 302
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    return-object v0
.end method

.method public getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
    .locals 1

    .prologue
    .line 257
    const/4 v0, 0x0

    return-object v0
.end method

.method public getCurrentPlaybackSpeed()F
    .locals 1

    .prologue
    .line 237
    const/4 v0, 0x0

    return v0
.end method

.method public getCurrentPosition()J
    .locals 2

    .prologue
    .line 222
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 227
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getEndPosition()J
    .locals 2

    .prologue
    .line 217
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getFragmentInfo()Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
    .locals 1

    .prologue
    .line 366
    const/4 v0, 0x0

    return-object v0
.end method

.method public getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
    .locals 1

    .prologue
    .line 297
    const/4 v0, 0x0

    return-object v0
.end method

.method public getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1

    .prologue
    .line 262
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object v0
.end method

.method public getSupportedClosedCaptionsOptions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 292
    const/4 v0, 0x0

    return-object v0
.end method

.method public getSupportedPlaybackSpeeds()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation

    .prologue
    .line 232
    const/4 v0, 0x0

    return-object v0
.end method

.method public getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 1

    .prologue
    .line 327
    const/4 v0, 0x0

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 312
    const/4 v0, 0x0

    return-object v0
.end method

.method public getVideoHeight()J
    .locals 2

    .prologue
    .line 347
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getVideoHeight()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1

    .prologue
    .line 352
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    return-object v0
.end method

.method public getVideoWidth()J
    .locals 2

    .prologue
    .line 342
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getVideoWidth()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public getView()Landroid/view/View;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->playerSurface:Landroid/view/SurfaceView;

    return-object v0
.end method

.method public hasCC()Z
    .locals 1

    .prologue
    .line 337
    const/4 v0, 0x0

    return v0
.end method

.method public hasDRM()Z
    .locals 1

    .prologue
    .line 332
    const/4 v0, 0x0

    return v0
.end method

.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 3
    .param p1, "mediaPlayer"    # Landroid/media/MediaPlayer;
    .param p2, "i"    # I
    .param p3, "i2"    # I

    .prologue
    .line 371
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    if-eqz v0, :cond_0

    .line 372
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 375
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->ERROR:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 377
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V

    .line 379
    const/4 v0, 0x1

    return v0
.end method

.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 3
    .param p1, "mediaPlayer"    # Landroid/media/MediaPlayer;

    .prologue
    .line 384
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 385
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V

    .line 386
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->sendMediaOpened()V

    .line 387
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 388
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V

    .line 389
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->playerSurface:Landroid/view/SurfaceView;

    invoke-virtual {v2}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 390
    const/4 v0, 0x0

    .line 391
    .local v0, "testVal":Z
    invoke-virtual {p1}, Landroid/media/MediaPlayer;->start()V

    .line 392
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 393
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 394
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V

    .line 401
    :cond_0
    :goto_0
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V

    .line 402
    return-void

    .line 396
    :cond_1
    if-eqz v0, :cond_0

    .line 397
    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    iput-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 398
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V

    goto :goto_0
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 94
    return-void
.end method

.method public play()V
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 89
    return-void
.end method

.method public removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 322
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->listener:Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .line 323
    return-void
.end method

.method public seekToLive()V
    .locals 0

    .prologue
    .line 166
    return-void
.end method

.method public setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
    .locals 4
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p2, "startPosition"    # J
    .param p4, "adManager"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    .line 108
    :try_start_0
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$2;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$2;-><init>(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)V

    .line 121
    .local v0, "_itemLoaderListener":Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v2

    new-instance v3, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;

    invoke-direct {v3, p0, p1}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;-><init>(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;Lcom/comcast/playerplatform/primetime/android/asset/Asset;)V

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 161
    .end local v0    # "_itemLoaderListener":Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;
    :goto_0
    return-void

    .line 158
    :catch_0
    move-exception v1

    .line 159
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public setClosedCaptionsEnabled(Z)V
    .locals 2
    .param p1, "flag"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 182
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->selectTrack(I)V

    .line 183
    return-void
.end method

.method public setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V
    .locals 6
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 188
    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v4}, Landroid/media/MediaPlayer;->getTrackInfo()[Landroid/media/MediaPlayer$TrackInfo;

    move-result-object v0

    .local v0, "arr$":[Landroid/media/MediaPlayer$TrackInfo;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 189
    .local v3, "trackInfo":Landroid/media/MediaPlayer$TrackInfo;
    invoke-virtual {v3}, Landroid/media/MediaPlayer$TrackInfo;->getLanguage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 188
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 193
    .end local v3    # "trackInfo":Landroid/media/MediaPlayer$TrackInfo;
    :cond_1
    return-void
.end method

.method public setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V
    .locals 0
    .param p1, "logFactory"    # Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    .prologue
    .line 213
    return-void
.end method

.method public setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
    .locals 0
    .param p1, "verbosity"    # Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .prologue
    .line 358
    return-void
.end method

.method public setPosition(JZ)V
    .locals 3
    .param p1, "seconds"    # J
    .param p3, "skipAds"    # Z

    .prologue
    .line 170
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    long-to-int v1, p1

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 171
    return-void
.end method

.method public setPositionRelative(J)V
    .locals 3
    .param p1, "seconds"    # J

    .prologue
    .line 175
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v1

    long-to-int v2, p1

    add-int/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 176
    return-void
.end method

.method public setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
    .locals 0
    .param p1, "track"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .prologue
    .line 198
    return-void
.end method

.method public setVolume(I)V
    .locals 0
    .param p1, "volume"    # I

    .prologue
    .line 208
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 99
    return-void
.end method
