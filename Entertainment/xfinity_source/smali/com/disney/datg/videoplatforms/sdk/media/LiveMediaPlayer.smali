.class public Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;
.super Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
.source "LiveMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$3;,
        Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$AuthZTimeoutTask;
    }
.end annotation


# static fields
.field public static STREAM_AUTHORIZATION_ERROR:I

.field private static TAG:Ljava/lang/String;


# instance fields
.field private doingAuthZ:Z

.field private forceAuthZ:Z

.field protected liveAuthZIntervalTimer:Ljava/util/Timer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_AUTHZ_FAILED_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getErrorCode()I

    move-result v0

    sput v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->STREAM_AUTHORIZATION_ERROR:I

    .line 23
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 40
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;-><init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V

    .line 24
    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->doingAuthZ:Z

    .line 25
    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->forceAuthZ:Z

    .line 41
    return-void
.end method

.method static synthetic access$000(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->authTimerDone()V

    return-void
.end method

.method static synthetic access$102(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 19
    iput-boolean p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->doingAuthZ:Z

    return p1
.end method

.method static synthetic access$202(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 19
    iput-boolean p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->forceAuthZ:Z

    return p1
.end method

.method static synthetic access$300()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->startLiveIntervalAuthTimer()V

    return-void
.end method

.method private authTimerDone()V
    .locals 2

    .prologue
    .line 329
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->forceAuthZ:Z

    .line 330
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->TAG:Ljava/lang/String;

    const-string v1, "AUTHZ Timer expired --AUTHZ will commence on the next break"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 331
    return-void
.end method

.method private reauthorization()V
    .locals 2

    .prologue
    .line 285
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->doingAuthZ:Z

    if-nez v0, :cond_0

    .line 287
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->TAG:Ljava/lang/String;

    const-string v1, "DOING AUTHZ For Live"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 288
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->doingAuthZ:Z

    .line 291
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->stopLiveIntervalAuthTimer()V

    .line 293
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 296
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$2;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getPlayableAssetUrl(Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 324
    :cond_0
    return-void
.end method

.method private restartLiveStream()V
    .locals 3

    .prologue
    .line 122
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->TAG:Ljava/lang/String;

    const-string v2, "restarting live stream"

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v0

    .line 124
    .local v0, "media":Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->reset()V

    .line 125
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$1;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->setDataSource(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 141
    return-void
.end method

.method private startLiveIntervalAuthTimer()V
    .locals 4

    .prologue
    .line 335
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->stopLiveIntervalAuthTimer()V

    .line 337
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->liveAuthZIntervalTimer:Ljava/util/Timer;

    .line 339
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->liveAuthZIntervalTimer:Ljava/util/Timer;

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$AuthZTimeoutTask;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$AuthZTimeoutTask;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;)V

    sget v2, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->LIVE_STREAM_AUTHZ_INTERVAL:I

    mul-int/lit16 v2, v2, 0x3e8

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 341
    return-void
.end method

.method private stopLiveIntervalAuthTimer()V
    .locals 1

    .prologue
    .line 344
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->liveAuthZIntervalTimer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 345
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->liveAuthZIntervalTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 346
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->liveAuthZIntervalTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 348
    :cond_0
    return-void
.end method


# virtual methods
.method public canSeek()Z
    .locals 2

    .prologue
    .line 146
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 156
    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 148
    :pswitch_0
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->canSeek()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->canSeekBackward()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->canSeekForward()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 150
    :cond_1
    const/4 v0, 0x1

    goto :goto_0

    .line 154
    :pswitch_1
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->canSeek()Z

    move-result v0

    goto :goto_0

    .line 146
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onAssetBoundary(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V
    .locals 3
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "assetId"    # Ljava/lang/String;

    .prologue
    .line 161
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->isPlaying()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 162
    invoke-super {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onAssetBoundary(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V

    .line 164
    :try_start_0
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->doGeo()V
    :try_end_0
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_0 .. :try_end_0} :catch_0

    .line 170
    :cond_0
    :goto_0
    return-void

    .line 165
    :catch_0
    move-exception v0

    .line 167
    .local v0, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCaptionEvent(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionEvent;)Z
    .locals 4
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "event"    # Lcom/uplynk/media/CaptionEvent;

    .prologue
    .line 269
    if-eqz p2, :cond_0

    iget-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->closeCaptionsOn:Z

    if-eqz v2, :cond_0

    .line 271
    iget-object v1, p2, Lcom/uplynk/media/CaptionEvent;->eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    .line 272
    .local v1, "captionEvent":Lcom/uplynk/media/CaptionEvent$CaptionEventType;
    if-eqz v1, :cond_0

    .line 274
    const-string v2, "00:00:00"

    const-string v3, "00:00:00"

    invoke-static {p2, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionUtils;->parseEvent(Lcom/uplynk/media/CaptionEvent;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;

    move-result-object v0

    .line 275
    .local v0, "captionData":Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->getWebVTT()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->sendTimedText(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;)V

    .line 276
    const/4 v2, 0x1

    .line 279
    .end local v0    # "captionData":Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
    .end local v1    # "captionEvent":Lcom/uplynk/media/CaptionEvent$CaptionEventType;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public onError(Lcom/uplynk/media/MediaPlayer;II)Z
    .locals 8
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    const/16 v3, 0x64

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 96
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 97
    .local v0, "bundle":Landroid/os/Bundle;
    if-eq p2, v3, :cond_0

    if-ne p2, v3, :cond_1

    .line 98
    :cond_0
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_PLAYBACK_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v3

    const-string v4, "[video id]"

    const-string v5, "live"

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 99
    .local v2, "message":Ljava/lang/String;
    const-string v3, "trackCode"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const-string v3, "live:feed:%s"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 102
    .local v1, "errorMessage":Ljava/lang/String;
    const-string v3, "error"

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    :goto_0
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->MEDIA_ERROR:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v3, v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;)V

    .line 113
    invoke-super {p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onError(Lcom/uplynk/media/MediaPlayer;II)Z

    .line 114
    return v6

    .line 105
    .end local v1    # "errorMessage":Ljava/lang/String;
    .end local v2    # "message":Ljava/lang/String;
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "unknown:liveplayer:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 106
    .restart local v2    # "message":Ljava/lang/String;
    const-string v3, "trackCode"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    const-string v3, "live:feed:%s"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 109
    .restart local v1    # "errorMessage":Ljava/lang/String;
    const-string v3, "error"

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onUplynkMetadata(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)Z
    .locals 10
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "uplynkMetadata"    # Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    .prologue
    const/4 v6, 0x1

    const/4 v9, -0x1

    const/4 v5, 0x0

    .line 176
    invoke-super {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onUplynkMetadata(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)Z

    .line 178
    iget-boolean v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->processNextAsset:Z

    if-eqz v7, :cond_a

    .line 180
    if-eqz p2, :cond_a

    invoke-virtual {p2}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetID()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_a

    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentAssetId:Ljava/lang/String;

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_a

    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentAssetId:Ljava/lang/String;

    invoke-virtual {p2}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetID()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_a

    .line 185
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v7

    if-eqz v7, :cond_0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 186
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v7

    invoke-virtual {v7, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->setUplynkMetadata(Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)V

    .line 189
    :cond_0
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->TAG:Ljava/lang/String;

    const-string v8, "processing uplynk metadata"

    invoke-static {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    invoke-virtual {p2}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetInfo()Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v3

    .line 192
    .local v3, "tempAssetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    if-eqz v3, :cond_a

    .line 194
    iput-boolean v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->processNextAsset:Z

    .line 197
    invoke-virtual {v3}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->isAd()Z

    move-result v7

    if-eqz v7, :cond_3

    .line 198
    iput-boolean v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->seekAllowed:Z

    .line 200
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->getUplynkMetadata()Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->getUplynkMetadata()Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetInfo()Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 205
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->getUplynkMetadata()Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetInfo()Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->isAd()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 206
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_END:Ljava/lang/String;

    invoke-virtual {p0, v5}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->sendMetadataEvent(Ljava/lang/String;)V

    .line 210
    :cond_1
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_START:Ljava/lang/String;

    invoke-virtual {p0, v5}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->sendMetadataEvent(Ljava/lang/String;)V

    .line 263
    .end local v3    # "tempAssetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_2
    :goto_0
    return v6

    .line 216
    .restart local v3    # "tempAssetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_3
    iput-boolean v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->seekAllowed:Z

    .line 217
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentAssetId:Ljava/lang/String;

    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentProgramId:Ljava/lang/String;

    invoke-static {v7, v8}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_9

    .line 220
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_PROGRAM_START:Ljava/lang/String;

    invoke-virtual {p0, v7}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->sendMetadataEvent(Ljava/lang/String;)V

    .line 221
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 222
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v7, "start_video"

    const-string v8, ""

    invoke-virtual {v0, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PROGRAM_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v7, v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;)V

    .line 225
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentAssetId:Ljava/lang/String;

    iput-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentProgramId:Ljava/lang/String;

    .line 227
    invoke-virtual {v3}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getTvRating()I

    move-result v4

    .line 228
    .local v4, "tvrating":I
    invoke-virtual {v3}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getMovieRating()I

    move-result v1

    .line 230
    .local v1, "movierating":I
    const/4 v2, 0x0

    .line 233
    .local v2, "needAuthZ":Z
    iget v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentRating:I

    if-eq v7, v9, :cond_5

    .line 235
    iget-boolean v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->forceAuthZ:Z

    if-nez v7, :cond_4

    iget v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentRating:I

    if-ne v7, v4, :cond_4

    iget v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentRating:I

    if-eq v7, v1, :cond_8

    :cond_4
    move v2, v6

    .line 241
    :cond_5
    :goto_1
    if-eq v4, v9, :cond_6

    iput v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentRating:I

    .line 242
    :cond_6
    if-eq v1, v9, :cond_7

    iput v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentRating:I

    .line 244
    :cond_7
    if-eqz v2, :cond_2

    .line 245
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->reauthorization()V

    goto :goto_0

    :cond_8
    move v2, v5

    .line 235
    goto :goto_1

    .line 249
    .end local v0    # "bundle":Landroid/os/Bundle;
    .end local v1    # "movierating":I
    .end local v2    # "needAuthZ":Z
    .end local v4    # "tvrating":I
    :cond_9
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 250
    .restart local v0    # "bundle":Landroid/os/Bundle;
    const-string v5, "start_video"

    const-string v7, ""

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PROGRAM_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v5, v0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;)V

    goto :goto_0

    .end local v0    # "bundle":Landroid/os/Bundle;
    .end local v3    # "tempAssetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_a
    move v6, v5

    .line 263
    goto :goto_0
.end method

.method public setDataSource(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 4
    .param p1, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 46
    .local p2, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 47
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v3, "valid Media object must be set"

    invoke-direct {v1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    .line 50
    :cond_0
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v0

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->LIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    if-eq v0, v1, :cond_1

    .line 51
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_MEDIA_INITIALIZED_ON_WRONG_PLAYER_TYPE_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v3, "Media must be a VOD type"

    invoke-direct {v1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    .line 55
    :cond_1
    invoke-super {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDataSource(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public start()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 62
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 77
    :goto_0
    return-void

    .line 64
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PAUSED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->STOPPED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    if-ne v0, v1, :cond_1

    :cond_0
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->hdmiError:Z

    if-nez v0, :cond_1

    .line 68
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->restartLiveStream()V

    goto :goto_0

    .line 70
    :cond_1
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->start()V

    goto :goto_0

    .line 74
    :pswitch_1
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->start()V

    goto :goto_0

    .line 62
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 81
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 91
    :goto_0
    return-void

    .line 83
    :pswitch_0
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stop()V

    .line 84
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->forceAuthZ:Z

    .line 85
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer;->stopLiveIntervalAuthTimer()V

    goto :goto_0

    .line 88
    :pswitch_1
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stop()V

    goto :goto_0

    .line 81
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
