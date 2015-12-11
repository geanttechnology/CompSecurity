.class public abstract Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
.super Landroid/media/MediaPlayer;
.source "VPMediaPlayer.java"

# interfaces
.implements Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;
.implements Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;
.implements Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;
.implements Lcom/uplynk/media/MediaPlayer$OnCompletionListener;
.implements Lcom/uplynk/media/MediaPlayer$OnErrorListener;
.implements Lcom/uplynk/media/MediaPlayer$OnInfoListener;
.implements Lcom/uplynk/media/MediaPlayer$OnPreparedListener;
.implements Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;
.implements Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;
.implements Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$ProgressionTask;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TimedText;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPOnTimedTextListener;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;,
        Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;
    }
.end annotation


# instance fields
.field private authenticated:Z

.field closeCaptionsOn:Z

.field protected configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

.field protected context:Landroid/content/Context;

.field protected currentAssetId:Ljava/lang/String;

.field protected currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

.field private currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

.field protected currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

.field protected currentProgramId:Ljava/lang/String;

.field protected currentRating:I

.field didReceiveUplynkMetadata:Z

.field protected futureDataSource:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field protected hdmiError:Z

.field protected isCancelled:Z

.field protected omnitureTracker:Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

.field private onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

.field private onCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

.field private onErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

.field private onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

.field private onMediaMetadataListener:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;

.field private onPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

.field private onSeekCompleteListener:Landroid/media/MediaPlayer$OnSeekCompleteListener;

.field private onTimedTextListener:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPOnTimedTextListener;

.field private onVideoSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

.field protected playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field processNextAsset:Z

.field protected progressionTimer:Ljava/util/Timer;

.field protected seekAllowed:Z

.field protected sloggerTracker:Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

.field protected uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;


# direct methods
.method protected constructor <init>()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 164
    invoke-direct {p0}, Landroid/media/MediaPlayer;-><init>()V

    .line 121
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentProgramId:Ljava/lang/String;

    .line 122
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentAssetId:Ljava/lang/String;

    .line 123
    const/4 v0, -0x1

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentRating:I

    .line 124
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->seekAllowed:Z

    .line 125
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->processNextAsset:Z

    .line 127
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->closeCaptionsOn:Z

    .line 128
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->didReceiveUplynkMetadata:Z

    .line 133
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    .line 136
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->authenticated:Z

    .line 137
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    .line 158
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->hdmiError:Z

    .line 165
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v2, "Unsupported creation -- must be created through PlayerManager"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v0
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 175
    invoke-direct {p0}, Landroid/media/MediaPlayer;-><init>()V

    .line 121
    const-string v1, ""

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentProgramId:Ljava/lang/String;

    .line 122
    const-string v1, ""

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentAssetId:Ljava/lang/String;

    .line 123
    const/4 v1, -0x1

    iput v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentRating:I

    .line 124
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->seekAllowed:Z

    .line 125
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->processNextAsset:Z

    .line 127
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->closeCaptionsOn:Z

    .line 128
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->didReceiveUplynkMetadata:Z

    .line 133
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    .line 136
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->authenticated:Z

    .line 137
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    .line 158
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->hdmiError:Z

    .line 177
    if-nez p1, :cond_0

    .line 178
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v3, "Activity is required for playback"

    invoke-direct {v1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v1

    .line 181
    :cond_0
    :try_start_0
    new-instance v1, Lcom/uplynk/media/MediaPlayer;

    invoke-direct {v1}, Lcom/uplynk/media/MediaPlayer;-><init>()V

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    .line 182
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p1}, Lcom/uplynk/media/MediaPlayer;->setContext(Landroid/content/Context;)V

    .line 183
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .line 184
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->context:Landroid/content/Context;
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 192
    if-nez p2, :cond_1

    .line 193
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_INVALID_CONFIGURATION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v3, "misconfiguration - configuration was not set up correctly"

    invoke-direct {v1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v1

    .line 186
    :catch_0
    move-exception v0

    .line 188
    .local v0, "e":Ljava/lang/UnsatisfiedLinkError;
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_UNSUPPORTED_DEVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v1, v2, v0}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v1

    .line 195
    .end local v0    # "e":Ljava/lang/UnsatisfiedLinkError;
    :cond_1
    invoke-virtual {p2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v1

    if-nez v1, :cond_2

    .line 196
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_INVALID_CONFIGURATION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v3, "misconfiguration - config was never called"

    invoke-direct {v1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v1

    .line 205
    :cond_2
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnBufferingUpdateListener(Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 206
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnCompletionListener(Lcom/uplynk/media/MediaPlayer$OnCompletionListener;)V

    .line 207
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnPreparedListener(Lcom/uplynk/media/MediaPlayer$OnPreparedListener;)V

    .line 208
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnVideoSizeChangedListener(Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 209
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnErrorListener(Lcom/uplynk/media/MediaPlayer$OnErrorListener;)V

    .line 210
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnInfoListener(Lcom/uplynk/media/MediaPlayer$OnInfoListener;)V

    .line 211
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnSeekCompleteListener(Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;)V

    .line 212
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnAssetBoundaryListener(Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;)V

    .line 213
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnUplynkMetadataListener(Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;)V

    .line 214
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1, p0}, Lcom/uplynk/media/MediaPlayer;->setOnCaptionEventListener(Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;)V

    .line 217
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->IDLE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 218
    return-void
.end method

.method static synthetic access$002(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 49
    iput-boolean p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->authenticated:Z

    return p1
.end method

.method private shutdown()V
    .locals 1

    .prologue
    .line 1247
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->forceCancel()V

    .line 1248
    return-void
.end method

.method private startProgressionTimer(Z)V
    .locals 6
    .param p1, "reset"    # Z

    .prologue
    .line 1283
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stopProgressionTimer()V

    .line 1284
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->progressionTimer:Ljava/util/Timer;

    .line 1285
    const-wide/16 v2, 0x7530

    .line 1286
    .local v2, "delay":J
    if-nez p1, :cond_0

    .line 1287
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentPosition()I

    move-result v0

    rem-int/lit16 v0, v0, 0x7530

    rsub-int v0, v0, 0x7530

    int-to-long v2, v0

    .line 1289
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->progressionTimer:Ljava/util/Timer;

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$ProgressionTask;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$ProgressionTask;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;)V

    const-wide/16 v4, 0x7530

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 1290
    return-void
.end method

.method private stopProgressionTimer()V
    .locals 1

    .prologue
    .line 1293
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->progressionTimer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 1294
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->progressionTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 1295
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->progressionTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 1297
    :cond_0
    return-void
.end method


# virtual methods
.method protected addTrackers()V
    .locals 4

    .prologue
    .line 569
    :try_start_0
    sget-boolean v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->ANALYTICS_ENABLED:Z

    if-eqz v1, :cond_0

    .line 570
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->OMNITURE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->context:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-static {v2, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory;->getTracker(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    move-result-object v1

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->omnitureTracker:Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 572
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->omnitureTracker:Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->registerTracker(Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 580
    :cond_0
    :goto_0
    :try_start_1
    sget-boolean v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SLOGGER_ENABLED:Z

    if-eqz v1, :cond_1

    .line 581
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->SLOGGER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->context:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-static {v2, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory;->getTracker(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    move-result-object v1

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sloggerTracker:Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 583
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sloggerTracker:Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    invoke-static {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->registerTracker(Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 588
    :cond_1
    :goto_1
    return-void

    .line 574
    :catch_0
    move-exception v0

    .line 575
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "VPMediaPlayer"

    const-string v2, "Analytics Tracker could not be initialized"

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 585
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 586
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v1, "VPMediaPlayer"

    const-string v2, "Slogger Tracker could not be initialized"

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public canSeek()Z
    .locals 1

    .prologue
    .line 1094
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->seekAllowed:Z

    if-eqz v0, :cond_0

    .line 1095
    const/4 v0, 0x1

    .line 1097
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public cancel()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 1252
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    .line 1258
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->futureDataSource:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_0

    .line 1259
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->futureDataSource:Ljava/util/concurrent/Future;

    invoke-interface {v0, v1}, Ljava/util/concurrent/Future;->cancel(Z)Z

    .line 1260
    :cond_0
    return-void
.end method

.method protected doGeo()V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x1

    .line 1305
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v7

    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->context:Landroid/content/Context;

    invoke-virtual {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->doLBS(Landroid/content/Context;)Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    move-result-object v4

    .line 1307
    .local v4, "geo":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v7

    const-string v8, "001"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentNetwork()Ljava/lang/String;

    move-result-object v7

    const-string v8, "abc"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 1310
    :cond_0
    if-eqz v4, :cond_5

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v7

    if-eqz v7, :cond_5

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v7

    if-eqz v7, :cond_5

    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_5

    .line 1312
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1313
    .local v2, "bundle":Landroid/os/Bundle;
    const/4 v3, 0x0

    .line 1315
    .local v3, "found":Z
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1316
    .local v1, "affiliateList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v4}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    move-result-object v7

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;->getAffiliates()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;

    .line 1318
    .local v0, "affiliate":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v8

    iget-object v8, v8, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->affiliateId:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 1319
    const/4 v3, 0x1

    .line 1320
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_CURRENT_AFFILIATE:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v8

    iget-object v8, v8, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->affiliateId:Ljava/lang/String;

    invoke-virtual {v2, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1322
    :cond_1
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1325
    .end local v0    # "affiliate":Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
    :cond_2
    if-nez v3, :cond_3

    .line 1327
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnErrorListener()Landroid/media/MediaPlayer$OnErrorListener;

    move-result-object v7

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_UNSUPPORTED_AFFILIATE:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getErrorCode()I

    move-result v8

    invoke-interface {v7, p0, v9, v8}, Landroid/media/MediaPlayer$OnErrorListener;->onError(Landroid/media/MediaPlayer;II)Z

    .line 1328
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stop()V

    .line 1329
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->reset()V

    .line 1330
    new-instance v7, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_UNSUPPORTED_AFFILIATE:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v7

    .line 1332
    :cond_3
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v7

    new-array v6, v7, [Ljava/lang/String;

    .line 1333
    .local v6, "strArr":[Ljava/lang/String;
    invoke-virtual {v1, v6}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v6

    .end local v6    # "strArr":[Ljava/lang/String;
    check-cast v6, [Ljava/lang/String;

    .line 1334
    .restart local v6    # "strArr":[Ljava/lang/String;
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ASSET_SUPPORTED_AFFILIATES:Ljava/lang/String;

    invoke-virtual {v2, v7, v6}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 1335
    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->METADATA_EVENT:Ljava/lang/String;

    invoke-virtual {p0, v7, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendMetadataEvent(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 1347
    .end local v1    # "affiliateList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v2    # "bundle":Landroid/os/Bundle;
    .end local v3    # "found":Z
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v6    # "strArr":[Ljava/lang/String;
    :cond_4
    return-void

    .line 1341
    :cond_5
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnErrorListener()Landroid/media/MediaPlayer$OnErrorListener;

    move-result-object v7

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_UNSUPPORTED_AREA:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getErrorCode()I

    move-result v8

    invoke-interface {v7, p0, v9, v8}, Landroid/media/MediaPlayer$OnErrorListener;->onError(Landroid/media/MediaPlayer;II)Z

    .line 1342
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stop()V

    .line 1343
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->reset()V

    .line 1344
    new-instance v7, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_UNSUPPORTED_AREA:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v7, v8}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v7
.end method

.method public enableClosedCaptioning(Z)V
    .locals 4
    .param p1, "closedCaptionEnabled"    # Z

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 948
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 968
    :cond_0
    :goto_0
    return-void

    .line 950
    :pswitch_0
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 951
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 952
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->closeCaptionsOn:Z

    if-eqz v0, :cond_1

    if-nez p1, :cond_1

    .line 953
    iput-boolean v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->closeCaptionsOn:Z

    .line 954
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v3}, Lcom/uplynk/media/MediaPlayer;->setCaptionsEnabled(Z)V

    goto :goto_0

    .line 955
    :cond_1
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->closeCaptionsOn:Z

    if-nez v0, :cond_0

    if-ne p1, v2, :cond_0

    .line 956
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->closeCaptionsOn:Z

    .line 957
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    if-nez v0, :cond_2

    .line 959
    new-instance v0, Lcom/uplynk/media/CaptionStyle;

    invoke-direct {v0}, Lcom/uplynk/media/CaptionStyle;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    .line 961
    :cond_2
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setCaptionStyle(Lcom/uplynk/media/CaptionStyle;)V

    .line 962
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v2}, Lcom/uplynk/media/MediaPlayer;->setCaptionsEnabled(Z)V

    goto :goto_0

    .line 948
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method protected finalize()V
    .locals 2

    .prologue
    .line 1269
    const-string v0, "VPMediaPlayer"

    const-string v1, "finalizing VPMediaPlayer"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    .line 1270
    invoke-super {p0}, Landroid/media/MediaPlayer;->finalize()V

    .line 1271
    return-void
.end method

.method public getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .locals 1

    .prologue
    .line 1054
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    return-object v0
.end method

.method public getCurrentPosition()I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 680
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    if-nez v1, :cond_0

    .line 691
    :goto_0
    return v0

    .line 682
    :cond_0
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 684
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 685
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->getCurrentPosition()I

    move-result v0

    goto :goto_0

    .line 689
    :cond_1
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v0

    goto :goto_0

    .line 682
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getDuration()I
    .locals 2

    .prologue
    .line 698
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 707
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 700
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 701
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->getDuration()I

    move-result v0

    goto :goto_0

    .line 705
    :cond_0
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    goto :goto_0

    .line 698
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getOnBufferingUpdateListener()Landroid/media/MediaPlayer$OnBufferingUpdateListener;
    .locals 1

    .prologue
    .line 1008
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    return-object v0
.end method

.method public getOnCompletionListener()Landroid/media/MediaPlayer$OnCompletionListener;
    .locals 1

    .prologue
    .line 1012
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    return-object v0
.end method

.method public getOnErrorListener()Landroid/media/MediaPlayer$OnErrorListener;
    .locals 1

    .prologue
    .line 1024
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    return-object v0
.end method

.method public getOnInfoListener()Landroid/media/MediaPlayer$OnInfoListener;
    .locals 1

    .prologue
    .line 1028
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    return-object v0
.end method

.method public getOnMediaMetadataListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;
    .locals 1

    .prologue
    .line 1036
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onMediaMetadataListener:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;

    return-object v0
.end method

.method public getOnPreparedListener()Landroid/media/MediaPlayer$OnPreparedListener;
    .locals 1

    .prologue
    .line 1016
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    return-object v0
.end method

.method public getOnSeekCompleteListener()Landroid/media/MediaPlayer$OnSeekCompleteListener;
    .locals 1

    .prologue
    .line 1032
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onSeekCompleteListener:Landroid/media/MediaPlayer$OnSeekCompleteListener;

    return-object v0
.end method

.method public getOnTimedTextListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPOnTimedTextListener;
    .locals 1

    .prologue
    .line 1045
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onTimedTextListener:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPOnTimedTextListener;

    return-object v0
.end method

.method public getOnVideoSizeChangedListener()Landroid/media/MediaPlayer$OnVideoSizeChangedListener;
    .locals 1

    .prologue
    .line 1020
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onVideoSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    return-object v0
.end method

.method public getVideoHeight()I
    .locals 2

    .prologue
    .line 713
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 722
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 715
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 716
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->getVideoHeight()I

    move-result v0

    goto :goto_0

    .line 720
    :cond_0
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->getVideoHeight()I

    move-result v0

    goto :goto_0

    .line 713
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getVideoWidth()I
    .locals 2

    .prologue
    .line 729
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 738
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 731
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 732
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->getVideoWidth()I

    move-result v0

    goto :goto_0

    .line 736
    :cond_0
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->getVideoWidth()I

    move-result v0

    goto :goto_0

    .line 729
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected isAuthenticated()Z
    .locals 1

    .prologue
    .line 1090
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->authenticated:Z

    return v0
.end method

.method public isPlaying()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 745
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    if-nez v1, :cond_1

    .line 758
    :cond_0
    :goto_0
    return v0

    .line 747
    :cond_1
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    if-eqz v1, :cond_0

    .line 749
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 751
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_2

    .line 752
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->isPlaying()Z

    move-result v0

    goto :goto_0

    .line 756
    :cond_2
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    goto :goto_0

    .line 749
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onAssetBoundary(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V
    .locals 5
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "assetId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 934
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    if-eqz v0, :cond_1

    .line 935
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->release()V

    .line 936
    const-string v0, "VPMediaPlayer"

    const-string v1, "releasing player since cancelled has been called"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 944
    :cond_0
    :goto_0
    return-void

    .line 938
    :cond_1
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 939
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentAssetId:Ljava/lang/String;

    .line 940
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->processNextAsset:Z

    .line 941
    const-string v0, "VPMediaPlayer"

    const-string v1, "uplynk onAssetBoundary called-%s"

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onBufferingUpdate(Lcom/uplynk/media/MediaPlayer;I)V
    .locals 3
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "percent"    # I

    .prologue
    .line 844
    const-string v0, "VPMediaPlayer"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "uplynk onBufferingUpdate percent:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 845
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnBufferingUpdateListener()Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 846
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnBufferingUpdateListener()Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    move-result-object v0

    invoke-interface {v0, p0, p2}, Landroid/media/MediaPlayer$OnBufferingUpdateListener;->onBufferingUpdate(Landroid/media/MediaPlayer;I)V

    .line 848
    :cond_0
    return-void
.end method

.method public onCompletion(Lcom/uplynk/media/MediaPlayer;)V
    .locals 2
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;

    .prologue
    .line 852
    const-string v0, "VPMediaPlayer"

    const-string v1, "uplynk onCompletion called"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 853
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnCompletionListener()Landroid/media/MediaPlayer$OnCompletionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 854
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnCompletionListener()Landroid/media/MediaPlayer$OnCompletionListener;

    move-result-object v0

    invoke-interface {v0, p0}, Landroid/media/MediaPlayer$OnCompletionListener;->onCompletion(Landroid/media/MediaPlayer;)V

    .line 855
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_PROGRAM_END:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendMetadataEvent(Ljava/lang/String;)V

    .line 857
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->COMPLETE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 858
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stopProgressionTimer()V

    .line 860
    :cond_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PLAYBACK_COMPLETED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 861
    return-void
.end method

.method public onError(Lcom/uplynk/media/MediaPlayer;II)Z
    .locals 2
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    .line 897
    const-string v0, "VPMediaPlayer"

    const-string v1, "uplynk onError called"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 898
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnErrorListener()Landroid/media/MediaPlayer$OnErrorListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 899
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnErrorListener()Landroid/media/MediaPlayer$OnErrorListener;

    move-result-object v0

    invoke-interface {v0, p0, p2, p3}, Landroid/media/MediaPlayer$OnErrorListener;->onError(Landroid/media/MediaPlayer;II)Z

    .line 901
    :cond_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->ERROR:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 902
    const/4 v0, 0x0

    return v0
.end method

.method public onInfo(Lcom/uplynk/media/MediaPlayer;II)Z
    .locals 2
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    .line 888
    const-string v0, "VPMediaPlayer"

    const-string v1, "uplynk onInfo called"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 889
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnInfoListener()Landroid/media/MediaPlayer$OnInfoListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 890
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnInfoListener()Landroid/media/MediaPlayer$OnInfoListener;

    move-result-object v0

    invoke-interface {v0, p0, p2, p3}, Landroid/media/MediaPlayer$OnInfoListener;->onInfo(Landroid/media/MediaPlayer;II)Z

    .line 892
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public onPrepared(Lcom/uplynk/media/MediaPlayer;)V
    .locals 2
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;

    .prologue
    .line 866
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    if-nez v0, :cond_1

    .line 867
    const-string v0, "VPMediaPlayer"

    const-string v1, "uplynk onPrepared called"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 868
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnPreparedListener()Landroid/media/MediaPlayer$OnPreparedListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 869
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnPreparedListener()Landroid/media/MediaPlayer$OnPreparedListener;

    move-result-object v0

    invoke-interface {v0, p0}, Landroid/media/MediaPlayer$OnPreparedListener;->onPrepared(Landroid/media/MediaPlayer;)V

    .line 871
    :cond_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PREPARED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 876
    :goto_0
    return-void

    .line 874
    :cond_1
    const-string v0, "VPMediaPlayer"

    const-string v1, "media has been cancelled"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onSeekComplete(Lcom/uplynk/media/MediaPlayer;)V
    .locals 2
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;

    .prologue
    .line 907
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnSeekCompleteListener()Landroid/media/MediaPlayer$OnSeekCompleteListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 908
    const-string v0, "VPMediaPlayer"

    const-string v1, "uplynk onSeekComplete called"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 909
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnSeekCompleteListener()Landroid/media/MediaPlayer$OnSeekCompleteListener;

    move-result-object v0

    invoke-interface {v0, p0}, Landroid/media/MediaPlayer$OnSeekCompleteListener;->onSeekComplete(Landroid/media/MediaPlayer;)V

    .line 911
    :cond_0
    return-void
.end method

.method public onUplynkMetadata(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)Z
    .locals 6
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "uplynkMetadata"    # Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 917
    iget-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    if-eqz v2, :cond_1

    .line 918
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->release()V

    .line 919
    const-string v0, "VPMediaPlayer"

    const-string v2, "releasing player since cancelled has been called"

    invoke-static {v0, v2}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    move v0, v1

    .line 928
    :goto_0
    return v0

    .line 921
    :cond_1
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isPlaying()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 922
    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->didReceiveUplynkMetadata:Z

    .line 923
    const-string v2, "VPMediaPlayer"

    const-string v3, "uplynk onUplynkMetadata called-%s"

    new-array v4, v0, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v1

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onVideoSizeChanged(Lcom/uplynk/media/MediaPlayer;II)V
    .locals 2
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 880
    const-string v0, "VPMediaPlayer"

    const-string v1, "uplynk onVideoSizeChanged called"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGV(Ljava/lang/String;Ljava/lang/String;)V

    .line 881
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnVideoSizeChangedListener()Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 882
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnVideoSizeChangedListener()Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    move-result-object v0

    invoke-interface {v0, p0, p2, p3}, Landroid/media/MediaPlayer$OnVideoSizeChangedListener;->onVideoSizeChanged(Landroid/media/MediaPlayer;II)V

    .line 884
    :cond_0
    return-void
.end method

.method public pause()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 498
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 512
    :cond_0
    :goto_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PAUSED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 513
    return-void

    .line 500
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 503
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->pause()V

    .line 504
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PROGRAM_PAUSED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 505
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stopProgressionTimer()V

    goto :goto_0

    .line 509
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->pause()V

    goto :goto_0

    .line 498
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public prepare()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 418
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 436
    :cond_0
    :goto_0
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PREPARED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 437
    return-void

    .line 420
    :pswitch_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v1, :cond_0

    .line 422
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    if-nez v1, :cond_1

    .line 423
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "dataSource with VPMedia object should be set before prepare is called"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 426
    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1}, Lcom/uplynk/media/MediaPlayer;->prepare()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 427
    :catch_0
    move-exception v0

    .line 428
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 433
    .end local v0    # "e":Ljava/lang/Exception;
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->prepare()V

    goto :goto_0

    .line 418
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public prepareAsync()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 442
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 459
    :cond_0
    :goto_0
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PREPARED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 460
    return-void

    .line 444
    :pswitch_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v1, :cond_0

    .line 445
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    if-nez v1, :cond_1

    .line 446
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "dataSource with VPMedia object should be set before prepare is called"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 449
    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v1}, Lcom/uplynk/media/MediaPlayer;->prepareAsync()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 450
    :catch_0
    move-exception v0

    .line 451
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 456
    .end local v0    # "e":Ljava/lang/Exception;
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->prepareAsync()V

    goto :goto_0

    .line 442
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public release()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 537
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 563
    :cond_0
    :goto_0
    return-void

    .line 540
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 541
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 542
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->stop()V

    .line 544
    :cond_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->release()V

    .line 545
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->release()V

    .line 547
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->cancel()V

    .line 548
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stopProgressionTimer()V

    .line 549
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->removeListeners()V

    .line 550
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->removeTrackers()V

    .line 552
    iput-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    .line 553
    iput-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 556
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->shutdown()V

    goto :goto_0

    .line 560
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->release()V

    goto :goto_0

    .line 537
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected removeListeners()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1103
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .line 1104
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    .line 1105
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 1106
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    .line 1107
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 1108
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onSeekCompleteListener:Landroid/media/MediaPlayer$OnSeekCompleteListener;

    .line 1109
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onVideoSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 1110
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onMediaMetadataListener:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;

    .line 1112
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 1113
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 1114
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 1115
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V

    .line 1116
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 1117
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onSeekCompleteListener:Landroid/media/MediaPlayer$OnSeekCompleteListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnSeekCompleteListener(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V

    .line 1118
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onVideoSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 1120
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 1121
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnAssetBoundaryListener(Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;)V

    .line 1122
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnBufferingUpdateListener(Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 1123
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnCaptionEventListener(Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;)V

    .line 1124
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnCompletionListener(Lcom/uplynk/media/MediaPlayer$OnCompletionListener;)V

    .line 1125
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnErrorListener(Lcom/uplynk/media/MediaPlayer$OnErrorListener;)V

    .line 1126
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnInfoListener(Lcom/uplynk/media/MediaPlayer$OnInfoListener;)V

    .line 1127
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnPreparedListener(Lcom/uplynk/media/MediaPlayer$OnPreparedListener;)V

    .line 1128
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnSeekCompleteListener(Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;)V

    .line 1129
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnUplynkMetadataListener(Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;)V

    .line 1130
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setOnVideoSizeChangedListener(Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 1132
    :cond_0
    return-void
.end method

.method protected removeTrackers()V
    .locals 0

    .prologue
    .line 599
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->removeAllTrackers()V

    .line 601
    return-void
.end method

.method public reset()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 606
    const-string v0, "VPMediaPlayer"

    const-string v1, "resetting resources back to IDLE state"

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 607
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 630
    :cond_0
    :goto_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->IDLE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 631
    return-void

    .line 609
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 610
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 611
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->stop()V

    .line 612
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->reset()V

    .line 613
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 614
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->processNextAsset:Z

    .line 615
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->seekAllowed:Z

    .line 616
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->closeCaptionsOn:Z

    .line 617
    iput-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->didReceiveUplynkMetadata:Z

    .line 618
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentProgramId:Ljava/lang/String;

    .line 619
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentAssetId:Ljava/lang/String;

    .line 620
    const/4 v0, -0x1

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentRating:I

    .line 621
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->removeListeners()V

    .line 622
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->removeTrackers()V

    goto :goto_0

    .line 626
    :pswitch_1
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->removeListeners()V

    .line 627
    invoke-super {p0}, Landroid/media/MediaPlayer;->reset()V

    goto :goto_0

    .line 607
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected sendMetadataEvent(Ljava/lang/String;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 1062
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnMediaMetadataListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1066
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->createBoundaryEvent(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 1067
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnMediaMetadataListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;->onBoundaryEventReceived(Landroid/os/Bundle;)V

    .line 1069
    .end local v0    # "bundle":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method protected sendMetadataEvent(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 1072
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnMediaMetadataListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1076
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->createBoundaryEvent(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 1077
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {v0, p2}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 1078
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnMediaMetadataListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPMediaMetadataListener;->onBoundaryEventReceived(Landroid/os/Bundle;)V

    .line 1080
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method protected sendTimedText(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;)V
    .locals 2
    .param p1, "caption"    # Ljava/lang/String;
    .param p2, "captionData"    # Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;

    .prologue
    .line 1083
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnTimedTextListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPOnTimedTextListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1085
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getOnTimedTextListener()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPOnTimedTextListener;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TimedText;

    invoke-direct {v1, p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TimedText;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;)V

    invoke-interface {v0, p0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$VPOnTimedTextListener;->onTimedText(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TimedText;)V

    .line 1087
    :cond_0
    return-void
.end method

.method protected sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V
    .locals 1
    .param p1, "state"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    .prologue
    .line 1135
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;)V

    .line 1136
    return-void
.end method

.method protected declared-synchronized sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;)V
    .locals 4
    .param p1, "state"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 1140
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->getLinkTrackers()Ljava/util/Vector;

    move-result-object v2

    .line 1141
    .local v2, "trackers":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;>;"
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 1142
    invoke-virtual {v2}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;

    .line 1143
    .local v1, "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;
    if-eqz v1, :cond_0

    .line 1144
    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, p1, p2, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1148
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;
    .end local v2    # "trackers":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;>;"
    :catch_0
    move-exception v3

    .line 1150
    :cond_1
    monitor-exit p0

    return-void

    .line 1140
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method protected sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 8
    .param p1, "state"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;
    .param p2, "bundle"    # Landroid/os/Bundle;
    .param p3, "trackableName"    # Ljava/lang/String;

    .prologue
    .line 1161
    :try_start_0
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;

    invoke-direct {v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;-><init>()V

    .line 1162
    .local v2, "trackable":Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;
    invoke-virtual {v2, p3}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->setName(Ljava/lang/String;)V

    .line 1163
    const-string v4, "activity"

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->context:Landroid/content/Context;

    check-cast v3, Landroid/app/Activity;

    invoke-virtual {v2, v4, v3}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1164
    const-string v3, "currentMedia"

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1165
    const-string v3, "authenticated"

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isAuthenticated()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1166
    const-string v3, "position"

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentPosition()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1167
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$TrackableState:[I

    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 1241
    .end local v2    # "trackable":Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;
    :cond_0
    :goto_0
    return-void

    .line 1169
    .restart local v2    # "trackable":Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;
    :pswitch_0
    if-eqz p2, :cond_1

    .line 1170
    const-string v3, "start_video"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1171
    const-string v3, "start_video"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1174
    :cond_1
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1238
    .end local v2    # "trackable":Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;
    :catch_0
    move-exception v0

    .line 1239
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "VPMediaPlayer"

    const-string v4, "Error sending Omniture/Slogger tracking:%s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1177
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v2    # "trackable":Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;
    :pswitch_1
    :try_start_1
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->RESUMED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1180
    :pswitch_2
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->FORWARD:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1183
    :pswitch_3
    if-eqz p2, :cond_2

    .line 1184
    const-string v3, "10_sec_rewind"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 1185
    const-string v3, "10_sec_rewind"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1188
    :cond_2
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->REWIND:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1191
    :pswitch_4
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->PAUSED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1194
    :pswitch_5
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->STOPPED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1197
    :pswitch_6
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackAd(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1200
    :pswitch_7
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->COMPLETED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackAd(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1203
    :pswitch_8
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_STARTED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackAuthZ(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1206
    :pswitch_9
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_FAILED:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackAuthZ(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1209
    :pswitch_a
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->AUTH_Z_SUCCESS:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackAuthZ(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto :goto_0

    .line 1212
    :pswitch_b
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->FIRST_QUARTER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto/16 :goto_0

    .line 1215
    :pswitch_c
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->MID_POINT:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto/16 :goto_0

    .line 1218
    :pswitch_d
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->THIRD_QUARTER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto/16 :goto_0

    .line 1222
    :pswitch_e
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->COMPLETE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto/16 :goto_0

    .line 1225
    :pswitch_f
    if-eqz p2, :cond_0

    .line 1226
    const-string v3, "error"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1227
    .local v1, "error":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1228
    const-string v3, "error"

    invoke-virtual {v2, v3, v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/AppTrackable;->addContext(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1229
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->ERROR:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    goto/16 :goto_0

    .line 1234
    .end local v1    # "error":Ljava/lang/String;
    :pswitch_10
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->PING:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;

    invoke-static {v3, v2}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 1167
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_e
        :pswitch_f
        :pswitch_10
    .end packed-switch
.end method

.method public setAudioStreamType(I)V
    .locals 2
    .param p1, "streamtype"    # I

    .prologue
    .line 648
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 659
    :cond_0
    :goto_0
    return-void

    .line 650
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 651
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/MediaPlayer;->setAudioStreamType(I)V

    goto :goto_0

    .line 655
    :pswitch_1
    invoke-super {p0, p1}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    goto :goto_0

    .line 648
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public setCaptionStyle(Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;)V
    .locals 2
    .param p1, "captionStyle"    # Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 994
    if-eqz p1, :cond_0

    .line 996
    new-instance v0, Lcom/uplynk/media/CaptionStyle;

    invoke-direct {v0}, Lcom/uplynk/media/CaptionStyle;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    .line 997
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->getBackgroundColor()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionStyle;->setBackgroundColor(I)V

    .line 998
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->getEdgeType()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionStyle;->setEdgeType(I)V

    .line 999
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->getTextColor()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionStyle;->setTextColor(I)V

    .line 1000
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->getTextSize()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionStyle;->setTextSize(I)V

    .line 1001
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->getTypeFace()Landroid/graphics/Typeface;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1002
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentCaptionStyle:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;->getTypeFace()Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionStyle;->setTypeface(Landroid/graphics/Typeface;)V

    .line 1005
    :cond_0
    return-void
.end method

.method public setClosedCaptionContainer(Landroid/widget/RelativeLayout;)V
    .locals 3
    .param p1, "ccContainer"    # Landroid/widget/RelativeLayout;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 973
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 989
    :cond_0
    :goto_0
    return-void

    .line 975
    :pswitch_0
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->context:Landroid/content/Context;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->context:Landroid/content/Context;

    instance-of v1, v1, Landroid/app/Activity;

    if-eqz v1, :cond_0

    .line 976
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->context:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    .line 977
    .local v0, "activity":Landroid/app/Activity;
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v1, :cond_0

    if-eqz p1, :cond_0

    .line 978
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$2;

    invoke-direct {v1, p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$2;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Landroid/widget/RelativeLayout;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 973
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public setCurrentMedia(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 0
    .param p1, "currentMedia"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    .line 1058
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentMedia:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .line 1059
    return-void
.end method

.method public setDataSource(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
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
    .line 233
    .local p2, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Ljava/lang/String;>;"
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->getManager()Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;

    move-result-object v0

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)V

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/common/ThreadPoolAccessor;->execute(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->futureDataSource:Ljava/util/concurrent/Future;

    .line 328
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->futureDataSource:Ljava/util/concurrent/Future;

    return-object v0
.end method

.method public setDataSource(Landroid/content/Context;Landroid/net/Uri;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 373
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    .line 374
    invoke-super {p0, p1, p2}, Landroid/media/MediaPlayer;->setDataSource(Landroid/content/Context;Landroid/net/Uri;)V

    .line 375
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 376
    return-void
.end method

.method public setDataSource(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/net/Uri;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 382
    .local p3, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    .line 383
    invoke-super {p0, p1, p2, p3}, Landroid/media/MediaPlayer;->setDataSource(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V

    .line 384
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 385
    return-void
.end method

.method public setDataSource(Ljava/io/FileDescriptor;)V
    .locals 1
    .param p1, "fd"    # Ljava/io/FileDescriptor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 398
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    .line 399
    invoke-super {p0, p1}, Landroid/media/MediaPlayer;->setDataSource(Ljava/io/FileDescriptor;)V

    .line 400
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 401
    return-void
.end method

.method public setDataSource(Ljava/io/FileDescriptor;JJ)V
    .locals 2
    .param p1, "fd"    # Ljava/io/FileDescriptor;
    .param p2, "offset"    # J
    .param p4, "length"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 390
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    .line 391
    invoke-super/range {p0 .. p5}, Landroid/media/MediaPlayer;->setDataSource(Ljava/io/FileDescriptor;JJ)V

    .line 392
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 393
    return-void
.end method

.method public setDataSource(Ljava/lang/String;)V
    .locals 4
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 337
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 341
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->UPLYNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    .line 343
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v0

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getAssetUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "?"

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getAssetUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 347
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AuthState:[I

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v1

    iget-object v1, v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->authState:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 355
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 356
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 357
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 368
    :cond_1
    :goto_0
    return-void

    .line 349
    :pswitch_0
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v3, "invalid asset url"

    invoke-direct {v1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    .line 364
    :cond_2
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->NATIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    .line 365
    invoke-super {p0, p1}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 366
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    goto :goto_0

    .line 347
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public setDisplay(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "sh"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 406
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 407
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 413
    :goto_0
    return-void

    .line 411
    :cond_0
    invoke-super {p0, p1}, Landroid/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    goto :goto_0
.end method

.method public setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .prologue
    .line 774
    if-eqz p1, :cond_0

    .line 775
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .line 777
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 778
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p0}, Lcom/uplynk/media/MediaPlayer;->setOnBufferingUpdateListener(Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 780
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 781
    return-void
.end method

.method public setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/media/MediaPlayer$OnCompletionListener;

    .prologue
    .line 763
    if-eqz p1, :cond_0

    .line 764
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    .line 766
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 767
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p0}, Lcom/uplynk/media/MediaPlayer;->setOnCompletionListener(Lcom/uplynk/media/MediaPlayer$OnCompletionListener;)V

    .line 769
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 770
    return-void
.end method

.method public setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/media/MediaPlayer$OnErrorListener;

    .prologue
    .line 786
    if-eqz p1, :cond_0

    .line 787
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 789
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 790
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p0}, Lcom/uplynk/media/MediaPlayer;->setOnErrorListener(Lcom/uplynk/media/MediaPlayer$OnErrorListener;)V

    .line 792
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 793
    return-void
.end method

.method public setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/media/MediaPlayer$OnInfoListener;

    .prologue
    .line 797
    if-eqz p1, :cond_0

    .line 798
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    .line 800
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 801
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p0}, Lcom/uplynk/media/MediaPlayer;->setOnInfoListener(Lcom/uplynk/media/MediaPlayer$OnInfoListener;)V

    .line 803
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V

    .line 804
    return-void
.end method

.method public setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/media/MediaPlayer$OnPreparedListener;

    .prologue
    .line 820
    if-eqz p1, :cond_0

    .line 821
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 823
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 824
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p0}, Lcom/uplynk/media/MediaPlayer;->setOnPreparedListener(Lcom/uplynk/media/MediaPlayer$OnPreparedListener;)V

    .line 827
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 828
    return-void
.end method

.method public setOnSeekCompleteListener(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/media/MediaPlayer$OnSeekCompleteListener;

    .prologue
    .line 832
    if-eqz p1, :cond_0

    .line 833
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onSeekCompleteListener:Landroid/media/MediaPlayer$OnSeekCompleteListener;

    .line 835
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 836
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p0}, Lcom/uplynk/media/MediaPlayer;->setOnSeekCompleteListener(Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;)V

    .line 838
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onSeekCompleteListener:Landroid/media/MediaPlayer$OnSeekCompleteListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnSeekCompleteListener(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V

    .line 840
    return-void
.end method

.method public setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    .prologue
    .line 809
    if-eqz p1, :cond_0

    .line 810
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onVideoSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 812
    :cond_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 813
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p0}, Lcom/uplynk/media/MediaPlayer;->setOnVideoSizeChangedListener(Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 815
    :cond_1
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onVideoSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    invoke-super {p0, v0}, Landroid/media/MediaPlayer;->setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 816
    return-void
.end method

.method public setScreenOnWhilePlaying(Z)V
    .locals 2
    .param p1, "screenOn"    # Z

    .prologue
    .line 664
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 676
    :cond_0
    :goto_0
    return-void

    .line 666
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 667
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/MediaPlayer;->setScreenOnWhilePlaying(Z)V

    goto :goto_0

    .line 672
    :pswitch_1
    invoke-super {p0, p1}, Landroid/media/MediaPlayer;->setScreenOnWhilePlaying(Z)V

    goto :goto_0

    .line 664
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public setSurface(Landroid/view/Surface;)V
    .locals 2
    .param p1, "surface"    # Landroid/view/Surface;

    .prologue
    .line 635
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 643
    :goto_0
    :pswitch_0
    return-void

    .line 640
    :pswitch_1
    invoke-super {p0, p1}, Landroid/media/MediaPlayer;->setSurface(Landroid/view/Surface;)V

    goto :goto_0

    .line 635
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public start()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 464
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 488
    :cond_0
    :goto_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->STARTED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 489
    return-void

    .line 468
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->hdmiError:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->isCancelled:Z

    if-nez v0, :cond_0

    .line 473
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->start()V

    .line 474
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PAUSED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    if-ne v0, v1, :cond_1

    .line 475
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PROGRAM_RESUME:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 476
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->startProgressionTimer(Z)V

    goto :goto_0

    .line 478
    :cond_1
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PROGRAM_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 479
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->startProgressionTimer(Z)V

    goto :goto_0

    .line 485
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->start()V

    goto :goto_0

    .line 464
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 518
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$3;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 530
    :cond_0
    :goto_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->STOPPED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->playerState:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    .line 531
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->reset()V

    .line 532
    return-void

    .line 520
    :pswitch_0
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 521
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->stop()V

    .line 522
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PROGRAM_STOPPED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 523
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stopProgressionTimer()V

    goto :goto_0

    .line 527
    :pswitch_1
    invoke-super {p0}, Landroid/media/MediaPlayer;->stop()V

    goto :goto_0

    .line 518
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
