.class public Lco/vine/android/player/SdkVideoView;
.super Landroid/view/TextureView;
.source "SdkVideoView.java"

# interfaces
.implements Landroid/widget/MediaController$MediaPlayerControl;
.implements Lco/vine/android/player/VideoViewInterface;
.implements Lcom/google/android/exoplayer/ExoPlayer$Listener;
.implements Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer$EventListener;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;
    }
.end annotation


# static fields
.field private static final DISABLE_OPEN_ON_SEPARATE_THREAD:Z

.field private static final LOCK:[I

.field private static OPEN_ON_MAIN_THREAD:Z = false

.field private static final OPEN_ON_MAIN_THREAD_THRESHOLD:J = 0x28L

.field public static final PREPARE_SUCCESS_LOG:Ljava/lang/String; = "Successfully prepared the new MediaPlayer."

.field public static final RENDERER_COUNT:I = 0x2

.field public static final STATE_BUFFERING:I = 0x3

.field public static final STATE_ERROR:I = -0x1

.field public static final STATE_IDLE:I = 0x1

.field public static final STATE_PAUSED:I = 0x7

.field public static final STATE_PLAYBACK_COMPLETED:I = 0x5

.field public static final STATE_PLAYING:I = 0x6

.field public static final STATE_PREPARED:I = 0x4

.field public static final STATE_PREPARING:I = 0x2

.field private static final TAG:Ljava/lang/String;

.field private static final USE_EXO:Z

.field private static currentState:I

.field private static currentUri:Landroid/net/Uri;

.field private static currentView:Landroid/view/View;

.field private static sTotalVideoViewed:I

.field private static singlePlayer:Landroid/media/MediaPlayer;


# instance fields
.field private final SINGLE_PLAYER:Z

.field private mAttributes:Landroid/util/AttributeSet;

.field private mAudioSession:I

.field private mAutoPlayOnPrepared:Z

.field private mAutoShow:Z

.field private mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

.field private mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

.field private mContext:Landroid/content/Context;

.field private mCurrentBufferPercentage:I

.field public mCurrentState:I

.field private mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

.field private mExoAudioRenderer:Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;

.field private mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

.field private mExoVideoRenderer:Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;

.field private final mHandler:Landroid/os/Handler;

.field private mHasNotRetriedBefore:Z

.field private mHeaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mIsPrepared:Z

.field private final mLock:[I

.field private mLooping:Z

.field private mMediaController:Landroid/widget/MediaController;

.field private mMediaPlayer:Landroid/media/MediaPlayer;

.field private mMuted:Z

.field private mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

.field private mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;

.field private mOnInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

.field private final mOnOpenErrorListener:Ljava/lang/Runnable;

.field private mOnPreparedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

.field public final mOpenRunnable:Ljava/lang/Runnable;

.field private mOpenThread:Ljava/lang/Thread;

.field private mPath:Ljava/lang/String;

.field private mPlayingPosition:I

.field mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

.field private mReportOpenError:Z

.field private mSHCallback:Landroid/view/TextureView$SurfaceTextureListener;

.field private final mSaveVideoClicker:Lco/vine/android/player/SaveVideoClicker;

.field private mSeekWhenPrepared:I

.field final mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

.field private mSurfaceHeight:I

.field private mSurfaceHolder:Landroid/view/Surface;

.field private mSurfaceReadyListener:Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;

.field private mSurfaceWidth:I

.field private mTargetState:I

.field private mUri:Landroid/net/Uri;

.field protected mVideoHeight:I

.field protected mVideoWidth:I

.field private mWasMuted:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 51
    const-class v0, Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    .line 53
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-ne v0, v3, :cond_0

    move v0, v1

    :goto_0
    sput-boolean v0, Lco/vine/android/player/SdkVideoView;->DISABLE_OPEN_ON_SEPARATE_THREAD:Z

    .line 54
    sput-boolean v2, Lco/vine/android/player/SdkVideoView;->OPEN_ON_MAIN_THREAD:Z

    .line 59
    sput-boolean v2, Lco/vine/android/player/SdkVideoView;->USE_EXO:Z

    .line 113
    const/4 v0, 0x0

    sput-object v0, Lco/vine/android/player/SdkVideoView;->singlePlayer:Landroid/media/MediaPlayer;

    .line 116
    sput v1, Lco/vine/android/player/SdkVideoView;->currentState:I

    .line 117
    new-array v0, v2, [I

    sput-object v0, Lco/vine/android/player/SdkVideoView;->LOCK:[I

    return-void

    :cond_0
    move v0, v2

    .line 53
    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 176
    invoke-direct {p0, p1}, Landroid/view/TextureView;-><init>(Landroid/content/Context;)V

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    .line 124
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    .line 125
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 133
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/player/SdkVideoView;->mPlayingPosition:I

    .line 135
    new-array v0, v1, [I

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mLock:[I

    .line 136
    iput-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    .line 137
    iput-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mWasMuted:Z

    .line 138
    iput v1, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I

    .line 142
    new-instance v0, Lco/vine/android/player/SaveVideoClicker;

    invoke-direct {v0}, Lco/vine/android/player/SaveVideoClicker;-><init>()V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSaveVideoClicker:Lco/vine/android/player/SaveVideoClicker;

    .line 144
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mHandler:Landroid/os/Handler;

    .line 148
    new-instance v0, Lco/vine/android/player/SdkVideoView$1;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$1;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOnOpenErrorListener:Ljava/lang/Runnable;

    .line 294
    new-instance v0, Lco/vine/android/player/SdkVideoView$2;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$2;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOpenRunnable:Ljava/lang/Runnable;

    .line 486
    new-instance v0, Lco/vine/android/player/SdkVideoView$4;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$4;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 497
    new-instance v0, Lco/vine/android/player/SdkVideoView$5;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$5;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 559
    new-instance v0, Lco/vine/android/player/SdkVideoView$6;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$6;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    .line 577
    new-instance v0, Lco/vine/android/player/SdkVideoView$7;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$7;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 602
    new-instance v0, Lco/vine/android/player/SdkVideoView$8;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$8;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .line 693
    new-instance v0, Lco/vine/android/player/SdkVideoView$9;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$9;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSHCallback:Landroid/view/TextureView$SurfaceTextureListener;

    .line 177
    invoke-static {p1}, Lco/vine/android/util/SystemUtil;->isSinglePlayerEnabled(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    .line 178
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->initVideoView()V

    .line 179
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 182
    invoke-direct {p0, p1, p2}, Landroid/view/TextureView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    .line 124
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    .line 125
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 133
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/player/SdkVideoView;->mPlayingPosition:I

    .line 135
    new-array v0, v1, [I

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mLock:[I

    .line 136
    iput-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    .line 137
    iput-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mWasMuted:Z

    .line 138
    iput v1, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I

    .line 142
    new-instance v0, Lco/vine/android/player/SaveVideoClicker;

    invoke-direct {v0}, Lco/vine/android/player/SaveVideoClicker;-><init>()V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSaveVideoClicker:Lco/vine/android/player/SaveVideoClicker;

    .line 144
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mHandler:Landroid/os/Handler;

    .line 148
    new-instance v0, Lco/vine/android/player/SdkVideoView$1;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$1;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOnOpenErrorListener:Ljava/lang/Runnable;

    .line 294
    new-instance v0, Lco/vine/android/player/SdkVideoView$2;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$2;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOpenRunnable:Ljava/lang/Runnable;

    .line 486
    new-instance v0, Lco/vine/android/player/SdkVideoView$4;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$4;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 497
    new-instance v0, Lco/vine/android/player/SdkVideoView$5;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$5;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 559
    new-instance v0, Lco/vine/android/player/SdkVideoView$6;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$6;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    .line 577
    new-instance v0, Lco/vine/android/player/SdkVideoView$7;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$7;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 602
    new-instance v0, Lco/vine/android/player/SdkVideoView$8;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$8;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .line 693
    new-instance v0, Lco/vine/android/player/SdkVideoView$9;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$9;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSHCallback:Landroid/view/TextureView$SurfaceTextureListener;

    .line 183
    invoke-static {p1}, Lco/vine/android/util/SystemUtil;->isSinglePlayerEnabled(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    .line 184
    iput-object p2, p0, Lco/vine/android/player/SdkVideoView;->mAttributes:Landroid/util/AttributeSet;

    .line 185
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->initVideoView()V

    .line 186
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 189
    invoke-direct {p0, p1, p2, p3}, Landroid/view/TextureView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    .line 124
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    .line 125
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 133
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/player/SdkVideoView;->mPlayingPosition:I

    .line 135
    new-array v0, v1, [I

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mLock:[I

    .line 136
    iput-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    .line 137
    iput-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mWasMuted:Z

    .line 138
    iput v1, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I

    .line 142
    new-instance v0, Lco/vine/android/player/SaveVideoClicker;

    invoke-direct {v0}, Lco/vine/android/player/SaveVideoClicker;-><init>()V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSaveVideoClicker:Lco/vine/android/player/SaveVideoClicker;

    .line 144
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mHandler:Landroid/os/Handler;

    .line 148
    new-instance v0, Lco/vine/android/player/SdkVideoView$1;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$1;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOnOpenErrorListener:Ljava/lang/Runnable;

    .line 294
    new-instance v0, Lco/vine/android/player/SdkVideoView$2;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$2;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOpenRunnable:Ljava/lang/Runnable;

    .line 486
    new-instance v0, Lco/vine/android/player/SdkVideoView$4;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$4;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 497
    new-instance v0, Lco/vine/android/player/SdkVideoView$5;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$5;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 559
    new-instance v0, Lco/vine/android/player/SdkVideoView$6;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$6;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    .line 577
    new-instance v0, Lco/vine/android/player/SdkVideoView$7;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$7;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 602
    new-instance v0, Lco/vine/android/player/SdkVideoView$8;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$8;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .line 693
    new-instance v0, Lco/vine/android/player/SdkVideoView$9;

    invoke-direct {v0, p0}, Lco/vine/android/player/SdkVideoView$9;-><init>(Lco/vine/android/player/SdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSHCallback:Landroid/view/TextureView$SurfaceTextureListener;

    .line 190
    invoke-static {p1}, Lco/vine/android/util/SystemUtil;->isSinglePlayerEnabled(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    .line 191
    iput-object p2, p0, Lco/vine/android/player/SdkVideoView;->mAttributes:Landroid/util/AttributeSet;

    .line 192
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->initVideoView()V

    .line 193
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/player/SdkVideoView;)Landroid/media/MediaPlayer;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/player/SdkVideoView;)Landroid/media/MediaPlayer$OnErrorListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    return-object v0
.end method

.method static synthetic access$1000()Z
    .locals 1

    .prologue
    .line 48
    sget-boolean v0, Lco/vine/android/player/SdkVideoView;->USE_EXO:Z

    return v0
.end method

.method static synthetic access$1100(Lco/vine/android/player/SdkVideoView;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->openExoPlayer()V

    return-void
.end method

.method static synthetic access$1200(Lco/vine/android/player/SdkVideoView;)Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoVideoRenderer:Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;

    return-object v0
.end method

.method static synthetic access$1300(Lco/vine/android/player/SdkVideoView;)Lcom/google/android/exoplayer/ExoPlayer;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    return-object v0
.end method

.method static synthetic access$1400(Lco/vine/android/player/SdkVideoView;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->openMediaPlayer()V

    return-void
.end method

.method static synthetic access$1502(Lco/vine/android/player/SdkVideoView;Ljava/lang/Thread;)Ljava/lang/Thread;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;
    .param p1, "x1"    # Ljava/lang/Thread;

    .prologue
    .line 48
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mOpenThread:Ljava/lang/Thread;

    return-object p1
.end method

.method static synthetic access$1601(Lco/vine/android/player/SdkVideoView;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;
    .param p1, "x1"    # Z

    .prologue
    .line 48
    invoke-super {p0, p1}, Landroid/view/View;->setKeepScreenOn(Z)V

    return-void
.end method

.method static synthetic access$1700(Lco/vine/android/player/SdkVideoView;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mAutoPlayOnPrepared:Z

    return v0
.end method

.method static synthetic access$1800(Lco/vine/android/player/SdkVideoView;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->onPlayerPrepared()V

    return-void
.end method

.method static synthetic access$1900(Lco/vine/android/player/SdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnPreparedListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOnPreparedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    return-object v0
.end method

.method static synthetic access$200()[I
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lco/vine/android/player/SdkVideoView;->LOCK:[I

    return-object v0
.end method

.method static synthetic access$2000(Lco/vine/android/player/SdkVideoView;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->onComplete()V

    return-void
.end method

.method static synthetic access$2100(Lco/vine/android/player/SdkVideoView;II)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;
    .param p1, "x1"    # I
    .param p2, "x2"    # I

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Lco/vine/android/player/SdkVideoView;->onError(II)Z

    move-result v0

    return v0
.end method

.method static synthetic access$2202(Lco/vine/android/player/SdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 48
    iput p1, p0, Lco/vine/android/player/SdkVideoView;->mCurrentBufferPercentage:I

    return p1
.end method

.method static synthetic access$2300(Lco/vine/android/player/SdkVideoView;)Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceReadyListener:Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;

    return-object v0
.end method

.method static synthetic access$2400(Lco/vine/android/player/SdkVideoView;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->openVideo()V

    return-void
.end method

.method static synthetic access$2502(Lco/vine/android/player/SdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 48
    iput p1, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceWidth:I

    return p1
.end method

.method static synthetic access$2602(Lco/vine/android/player/SdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 48
    iput p1, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHeight:I

    return p1
.end method

.method static synthetic access$2700(Lco/vine/android/player/SdkVideoView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    return v0
.end method

.method static synthetic access$2800(Lco/vine/android/player/SdkVideoView;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->hasPlayer()Z

    move-result v0

    return v0
.end method

.method static synthetic access$2900(Lco/vine/android/player/SdkVideoView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I

    return v0
.end method

.method static synthetic access$3000(Lco/vine/android/player/SdkVideoView;)Landroid/widget/MediaController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    return-object v0
.end method

.method static synthetic access$302(Landroid/view/View;)Landroid/view/View;
    .locals 0
    .param p0, "x0"    # Landroid/view/View;

    .prologue
    .line 48
    sput-object p0, Lco/vine/android/player/SdkVideoView;->currentView:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$400(Lco/vine/android/player/SdkVideoView;)Landroid/net/Uri;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;

    return-object v0
.end method

.method static synthetic access$500()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/player/SdkVideoView;)Landroid/view/Surface;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;

    return-object v0
.end method

.method static synthetic access$602(Lco/vine/android/player/SdkVideoView;Landroid/view/Surface;)Landroid/view/Surface;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;
    .param p1, "x1"    # Landroid/view/Surface;

    .prologue
    .line 48
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;

    return-object p1
.end method

.method static synthetic access$700(Lco/vine/android/player/SdkVideoView;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mAutoShow:Z

    return v0
.end method

.method static synthetic access$800(Lco/vine/android/player/SdkVideoView;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 48
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/player/SdkVideoView;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/SdkVideoView;
    .param p1, "x1"    # Z

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lco/vine/android/player/SdkVideoView;->release(Z)V

    return-void
.end method

.method private attachMediaController()V
    .locals 3

    .prologue
    .line 477
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v1, :cond_0

    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->hasPlayer()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 478
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v1, p0}, Landroid/widget/MediaController;->setMediaPlayer(Landroid/widget/MediaController$MediaPlayerControl;)V

    .line 479
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    instance-of v1, v1, Landroid/view/View;

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    move-object v0, v1

    .line 481
    .local v0, "anchorView":Landroid/view/View;
    :goto_0
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v1, v0}, Landroid/widget/MediaController;->setAnchorView(Landroid/view/View;)V

    .line 482
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/MediaController;->setEnabled(Z)V

    .line 484
    .end local v0    # "anchorView":Landroid/view/View;
    :cond_0
    return-void

    :cond_1
    move-object v0, p0

    .line 479
    goto :goto_0
.end method

.method private getCurrentState()I
    .locals 1

    .prologue
    .line 164
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-eqz v0, :cond_0

    sget v0, Lco/vine/android/player/SdkVideoView;->currentState:I

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    goto :goto_0
.end method

.method public static getCurrentUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 1197
    sget-object v0, Lco/vine/android/player/SdkVideoView;->currentUri:Landroid/net/Uri;

    return-object v0
.end method

.method private getPlayer()Landroid/media/MediaPlayer;
    .locals 1

    .prologue
    .line 156
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-eqz v0, :cond_0

    sget-object v0, Lco/vine/android/player/SdkVideoView;->singlePlayer:Landroid/media/MediaPlayer;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    goto :goto_0
.end method

.method public static getViewStateFromExoState(I)I
    .locals 1
    .param p0, "state"    # I

    .prologue
    .line 98
    packed-switch p0, :pswitch_data_0

    .line 110
    const/4 v0, -0x1

    :goto_0
    return v0

    .line 100
    :pswitch_0
    const/4 v0, 0x1

    goto :goto_0

    .line 102
    :pswitch_1
    const/4 v0, 0x2

    goto :goto_0

    .line 104
    :pswitch_2
    const/4 v0, 0x3

    goto :goto_0

    .line 106
    :pswitch_3
    const/4 v0, 0x5

    goto :goto_0

    .line 108
    :pswitch_4
    const/4 v0, 0x4

    goto :goto_0

    .line 98
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method private hasPlayer()Z
    .locals 1

    .prologue
    .line 160
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private initVideoView()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 222
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mContext:Landroid/content/Context;

    .line 223
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    .line 224
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    .line 225
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSHCallback:Landroid/view/TextureView$SurfaceTextureListener;

    invoke-virtual {p0, v0}, Lco/vine/android/player/SdkVideoView;->setSurfaceTextureListener(Landroid/view/TextureView$SurfaceTextureListener;)V

    .line 226
    invoke-virtual {p0, v1}, Lco/vine/android/player/SdkVideoView;->setFocusable(Z)V

    .line 227
    invoke-virtual {p0, v1}, Lco/vine/android/player/SdkVideoView;->setFocusableInTouchMode(Z)V

    .line 228
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->requestFocus()Z

    .line 229
    iput v1, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 230
    return-void
.end method

.method private onComplete()V
    .locals 1

    .prologue
    const/4 v0, 0x5

    .line 567
    invoke-direct {p0, v0}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 568
    iput v0, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 569
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 570
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 572
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    if-eqz v0, :cond_1

    .line 573
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    invoke-interface {v0, p0}, Lco/vine/android/player/VideoViewInterface$OnCompletionListener;->onCompletion(Lco/vine/android/player/VideoViewInterface;)V

    .line 575
    :cond_1
    return-void
.end method

.method private onError(II)Z
    .locals 7
    .param p1, "framework_err"    # I
    .param p2, "impl_err"    # I

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    const/4 v6, -0x1

    .line 586
    const-string v2, "Error: {}, {}, {}, {}."

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v4, 0x2

    aput-object p0, v3, v4

    const/4 v4, 0x3

    iget-object v5, p0, Lco/vine/android/player/SdkVideoView;->mPath:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 587
    invoke-direct {p0, v6}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 588
    iput v6, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 589
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/player/SdkVideoView;->mPath:Ljava/lang/String;

    .line 590
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v2, :cond_0

    .line 591
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->hide()V

    .line 594
    :cond_0
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    if-eqz v2, :cond_1

    .line 595
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    invoke-interface {v2, p0, p1, p2}, Lco/vine/android/player/VideoViewInterface$OnErrorListener;->onError(Lco/vine/android/player/VideoViewInterface;II)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 599
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private onPlayerPrepared()V
    .locals 4

    .prologue
    const/4 v3, 0x6

    const/4 v2, 0x1

    .line 520
    const/4 v1, 0x4

    invoke-direct {p0, v1}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 521
    iput-boolean v2, p0, Lco/vine/android/player/SdkVideoView;->mIsPrepared:Z

    .line 522
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v1, :cond_0

    .line 523
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v1, v2}, Landroid/widget/MediaController;->setEnabled(Z)V

    .line 526
    :cond_0
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I

    .line 527
    .local v0, "seekToPosition":I
    if-eqz v0, :cond_1

    .line 528
    invoke-virtual {p0, v0}, Lco/vine/android/player/SdkVideoView;->seekTo(I)V

    .line 530
    :cond_1
    iget v1, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    if-eqz v1, :cond_5

    iget v1, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    if-eqz v1, :cond_5

    .line 533
    iget v1, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceWidth:I

    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    if-ne v1, v2, :cond_2

    iget v1, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHeight:I

    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    if-ne v1, v2, :cond_2

    .line 537
    iget v1, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    if-ne v1, v3, :cond_3

    .line 538
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->start()V

    .line 539
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v1, :cond_2

    .line 540
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v1}, Landroid/widget/MediaController;->show()V

    .line 557
    :cond_2
    :goto_0
    return-void

    .line 542
    :cond_3
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isPlaying()Z

    move-result v1

    if-nez v1, :cond_2

    if-nez v0, :cond_4

    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->getCurrentPosition()I

    move-result v1

    if-lez v1, :cond_2

    .line 544
    :cond_4
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v1, :cond_2

    .line 546
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/MediaController;->show(I)V

    goto :goto_0

    .line 553
    :cond_5
    iget v1, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    if-ne v1, v3, :cond_2

    .line 554
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->start()V

    goto :goto_0
.end method

.method private openExoPlayer()V
    .locals 13
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    const/4 v12, -0x1

    const/4 v11, 0x0

    const/4 v10, 0x2

    const/4 v9, 0x1

    .line 359
    const/4 v2, 0x2

    const/16 v3, 0x3e8

    const/16 v4, 0x1388

    :try_start_0
    invoke-static {v2, v3, v4}, Lcom/google/android/exoplayer/ExoPlayer$Factory;->newInstance(III)Lcom/google/android/exoplayer/ExoPlayer;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    .line 360
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v2, p0}, Lcom/google/android/exoplayer/ExoPlayer;->addListener(Lcom/google/android/exoplayer/ExoPlayer$Listener;)V

    .line 361
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->attachMediaController()V

    .line 362
    new-instance v1, Lcom/google/android/exoplayer/FrameworkSampleSource;

    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;

    const/4 v4, 0x0

    const/4 v5, 0x2

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/google/android/exoplayer/FrameworkSampleSource;-><init>(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/Object;I)V

    .line 363
    .local v1, "sampleSource":Lcom/google/android/exoplayer/FrameworkSampleSource;
    new-instance v0, Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;

    const/4 v2, 0x1

    const/4 v3, 0x0

    iget-object v4, p0, Lco/vine/android/player/SdkVideoView;->mHandler:Landroid/os/Handler;

    const/16 v6, 0x32

    move-object v5, p0

    invoke-direct/range {v0 .. v6}, Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;-><init>(Lcom/google/android/exoplayer/FrameworkSampleSource;IILandroid/os/Handler;Lco/vine/android/player/SdkVideoView;I)V

    .line 366
    .local v0, "videoRenderer":Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;
    new-instance v7, Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;

    invoke-direct {v7, v1}, Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;-><init>(Lcom/google/android/exoplayer/FrameworkSampleSource;)V

    .line 367
    .local v7, "audioRenderer":Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;
    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoVideoRenderer:Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;

    .line 368
    iput-object v7, p0, Lco/vine/android/player/SdkVideoView;->mExoAudioRenderer:Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;

    .line 369
    const/4 v2, 0x2

    invoke-direct {p0, v2}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 370
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v2, v0, v7}, Lcom/google/android/exoplayer/ExoPlayer;->prepare(Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;)V

    .line 371
    const-string v2, "videosViewed"

    sget v3, Lco/vine/android/player/SdkVideoView;->sTotalVideoViewed:I

    add-int/lit8 v3, v3, 0x1

    sput v3, Lco/vine/android/player/SdkVideoView;->sTotalVideoViewed:I

    invoke-static {v2, v3}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;I)V

    .line 372
    sget-object v2, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    const-string v3, "Successfully prepared the new MediaPlayer."

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 373
    iget-boolean v2, p0, Lco/vine/android/player/SdkVideoView;->mAutoPlayOnPrepared:Z

    if-eqz v2, :cond_0

    .line 374
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/google/android/exoplayer/ExoPlayer;->setPlayWhenReady(Z)V

    .line 376
    :cond_0
    sget-object v2, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    const-string v3, "This is a exo player success."

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 385
    .end local v0    # "videoRenderer":Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;
    .end local v1    # "sampleSource":Lcom/google/android/exoplayer/FrameworkSampleSource;
    .end local v7    # "audioRenderer":Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;
    :goto_0
    return-void

    .line 377
    :catch_0
    move-exception v8

    .line 378
    .local v8, "ex":Ljava/lang/RuntimeException;
    iget-boolean v2, p0, Lco/vine/android/player/SdkVideoView;->mReportOpenError:Z

    if-eqz v2, :cond_1

    .line 379
    const-string v2, "Exo Unable to open content {}, {}."

    new-array v3, v10, [Ljava/lang/Object;

    iget-object v4, p0, Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;

    aput-object v4, v3, v11

    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->getTag()Ljava/lang/Object;

    move-result-object v4

    aput-object v4, v3, v9

    invoke-static {v8, v2, v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 381
    :cond_1
    invoke-direct {p0, v12}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 382
    iput v12, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 383
    invoke-direct {p0, v9, v11}, Lco/vine/android/player/SdkVideoView;->onError(II)Z

    goto :goto_0
.end method

.method private openMediaPlayer()V
    .locals 13

    .prologue
    const/4 v12, 0x2

    const/4 v11, -0x1

    const/4 v7, 0x0

    const/4 v8, 0x1

    .line 393
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 394
    .local v4, "startTime":J
    iget-boolean v6, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-eqz v6, :cond_0

    .line 395
    sget-object v6, Lco/vine/android/player/SdkVideoView;->singlePlayer:Landroid/media/MediaPlayer;

    if-nez v6, :cond_0

    .line 396
    new-instance v6, Landroid/media/MediaPlayer;

    invoke-direct {v6}, Landroid/media/MediaPlayer;-><init>()V

    sput-object v6, Lco/vine/android/player/SdkVideoView;->singlePlayer:Landroid/media/MediaPlayer;

    .line 400
    :cond_0
    :try_start_0
    iget-boolean v6, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-nez v6, :cond_1

    .line 401
    new-instance v6, Landroid/media/MediaPlayer;

    invoke-direct {v6}, Landroid/media/MediaPlayer;-><init>()V

    invoke-direct {p0, v6}, Lco/vine/android/player/SdkVideoView;->setPlayer(Landroid/media/MediaPlayer;)V

    .line 403
    :cond_1
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v1

    .line 404
    .local v1, "player":Landroid/media/MediaPlayer;
    iget v6, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I

    if-eqz v6, :cond_5

    .line 405
    iget v6, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setAudioSessionId(I)V

    .line 409
    :goto_0
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 410
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 411
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 412
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 413
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mOnInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V

    .line 414
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 415
    const/4 v6, 0x0

    iput v6, p0, Lco/vine/android/player/SdkVideoView;->mCurrentBufferPercentage:I

    .line 416
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mContext:Landroid/content/Context;

    iget-object v9, p0, Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;

    iget-object v10, p0, Lco/vine/android/player/SdkVideoView;->mHeaders:Ljava/util/Map;

    invoke-virtual {v1, v6, v9, v10}, Landroid/media/MediaPlayer;->setDataSource(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V

    .line 417
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setSurface(Landroid/view/Surface;)V

    .line 418
    iget-boolean v6, p0, Lco/vine/android/player/SdkVideoView;->mLooping:Z

    if-eqz v6, :cond_2

    .line 419
    const/4 v6, 0x1

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setLooping(Z)V

    .line 421
    :cond_2
    const/4 v6, 0x1

    invoke-virtual {p0, v6}, Lco/vine/android/player/SdkVideoView;->setKeepScreenOn(Z)V

    .line 422
    const/4 v6, 0x3

    invoke-virtual {v1, v6}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 423
    iget-boolean v6, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    if-eqz v6, :cond_3

    .line 424
    const/4 v6, 0x0

    const/4 v9, 0x0

    invoke-virtual {v1, v6, v9}, Landroid/media/MediaPlayer;->setVolume(FF)V

    .line 426
    :cond_3
    invoke-virtual {v1}, Landroid/media/MediaPlayer;->prepareAsync()V

    .line 427
    const-string v6, "videosViewed"

    sget v9, Lco/vine/android/player/SdkVideoView;->sTotalVideoViewed:I

    add-int/lit8 v9, v9, 0x1

    sput v9, Lco/vine/android/player/SdkVideoView;->sTotalVideoViewed:I

    invoke-static {v6, v9}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;I)V

    .line 430
    const/4 v6, 0x2

    invoke-direct {p0, v6}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 431
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->attachMediaController()V

    .line 432
    sget-object v6, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    const-string v9, "Successfully prepared the new MediaPlayer."

    invoke-static {v6, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 433
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    sub-long v2, v9, v4

    .line 434
    .local v2, "prepareTime":J
    sget-boolean v6, Lco/vine/android/player/SdkVideoView;->DISABLE_OPEN_ON_SEPARATE_THREAD:Z

    if-nez v6, :cond_4

    const-wide/16 v9, 0x28

    cmp-long v6, v2, v9

    if-gez v6, :cond_7

    :cond_4
    move v6, v8

    :goto_1
    sput-boolean v6, Lco/vine/android/player/SdkVideoView;->OPEN_ON_MAIN_THREAD:Z

    .line 435
    const-string v6, "Prepare took {}ms"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-static {v6, v9}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 448
    .end local v1    # "player":Landroid/media/MediaPlayer;
    .end local v2    # "prepareTime":J
    :goto_2
    return-void

    .line 407
    .restart local v1    # "player":Landroid/media/MediaPlayer;
    :cond_5
    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getAudioSessionId()I

    move-result v6

    iput v6, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 436
    .end local v1    # "player":Landroid/media/MediaPlayer;
    :catch_0
    move-exception v0

    .line 437
    .local v0, "ex":Ljava/lang/Exception;
    iget-boolean v6, p0, Lco/vine/android/player/SdkVideoView;->mReportOpenError:Z

    if-eqz v6, :cond_6

    .line 438
    const-string v6, "Unable to open content {}, {}."

    new-array v9, v12, [Ljava/lang/Object;

    iget-object v10, p0, Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;

    aput-object v10, v9, v7

    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->getTag()Ljava/lang/Object;

    move-result-object v7

    aput-object v7, v9, v8

    invoke-static {v0, v6, v9}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 440
    :cond_6
    invoke-direct {p0, v11}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 441
    iput v11, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 442
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v6

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v7

    if-eq v6, v7, :cond_8

    .line 443
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mHandler:Landroid/os/Handler;

    iget-object v7, p0, Lco/vine/android/player/SdkVideoView;->mOnOpenErrorListener:Ljava/lang/Runnable;

    invoke-virtual {v6, v7}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_2

    .end local v0    # "ex":Ljava/lang/Exception;
    .restart local v1    # "player":Landroid/media/MediaPlayer;
    .restart local v2    # "prepareTime":J
    :cond_7
    move v6, v7

    .line 434
    goto :goto_1

    .line 445
    .end local v1    # "player":Landroid/media/MediaPlayer;
    .end local v2    # "prepareTime":J
    .restart local v0    # "ex":Ljava/lang/Exception;
    :cond_8
    iget-object v6, p0, Lco/vine/android/player/SdkVideoView;->mOnOpenErrorListener:Ljava/lang/Runnable;

    invoke-interface {v6}, Ljava/lang/Runnable;->run()V

    goto :goto_2
.end method

.method private openVideo()V
    .locals 4

    .prologue
    .line 339
    sget-boolean v2, Lco/vine/android/player/SdkVideoView;->OPEN_ON_MAIN_THREAD:Z

    if-eqz v2, :cond_0

    .line 340
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mOpenRunnable:Ljava/lang/Runnable;

    invoke-interface {v2}, Ljava/lang/Runnable;->run()V

    .line 354
    :goto_0
    return-void

    .line 342
    :cond_0
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mOpenThread:Ljava/lang/Thread;

    .line 343
    .local v1, "thread":Ljava/lang/Thread;
    if-eqz v1, :cond_1

    .line 344
    const-string v2, "Another open thread was running already."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->w(Ljava/lang/String;)V

    .line 346
    const-wide/16 v2, 0x64

    :try_start_0
    invoke-virtual {v1, v2, v3}, Ljava/lang/Thread;->join(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 351
    :cond_1
    :goto_1
    new-instance v2, Ljava/lang/Thread;

    iget-object v3, p0, Lco/vine/android/player/SdkVideoView;->mOpenRunnable:Ljava/lang/Runnable;

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v2, p0, Lco/vine/android/player/SdkVideoView;->mOpenThread:Ljava/lang/Thread;

    .line 352
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mOpenThread:Ljava/lang/Thread;

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 347
    :catch_0
    move-exception v0

    .line 348
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v2, "Join was interrupted."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private declared-synchronized release(Z)V
    .locals 3
    .param p1, "cleartargetstate"    # Z

    .prologue
    .line 855
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mLock:[I

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 856
    :try_start_1
    sget-boolean v1, Lco/vine/android/player/SdkVideoView;->USE_EXO:Z

    if-eqz v1, :cond_1

    .line 857
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v1, :cond_0

    .line 858
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v1}, Lcom/google/android/exoplayer/ExoPlayer;->release()V

    .line 859
    const/4 v1, 0x0

    iput-object v1, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    .line 861
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lco/vine/android/player/SdkVideoView;->mExoVideoRenderer:Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;

    .line 890
    :goto_0
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 891
    monitor-exit p0

    return-void

    .line 863
    :cond_1
    :try_start_2
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    .line 864
    .local v0, "player":Landroid/media/MediaPlayer;
    if-eqz v0, :cond_4

    .line 866
    :try_start_3
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 867
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V
    :try_end_3
    .catch Ljava/lang/IllegalStateException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 873
    :cond_2
    :goto_1
    :try_start_4
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V
    :try_end_4
    .catch Ljava/lang/IllegalStateException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 877
    :goto_2
    :try_start_5
    iget-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-nez v1, :cond_3

    .line 878
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 879
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lco/vine/android/player/SdkVideoView;->setPlayer(Landroid/media/MediaPlayer;)V

    .line 881
    :cond_3
    const/4 v1, 0x0

    iput-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mIsPrepared:Z

    .line 882
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 883
    if-eqz p1, :cond_4

    .line 884
    const/4 v1, 0x1

    iput v1, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 885
    const/4 v1, 0x0

    iput-object v1, p0, Lco/vine/android/player/SdkVideoView;->mPath:Ljava/lang/String;

    .line 888
    :cond_4
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lco/vine/android/player/SdkVideoView;->setKeepScreenOn(Z)V

    goto :goto_0

    .line 890
    .end local v0    # "player":Landroid/media/MediaPlayer;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    throw v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 855
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1

    .line 874
    .restart local v0    # "player":Landroid/media/MediaPlayer;
    :catch_0
    move-exception v1

    goto :goto_2

    .line 869
    :catch_1
    move-exception v1

    goto :goto_1
.end method

.method public static releaseStaticIfNeeded()V
    .locals 3

    .prologue
    .line 743
    sget-object v2, Lco/vine/android/player/SdkVideoView;->LOCK:[I

    monitor-enter v2

    .line 745
    :try_start_0
    sget-object v1, Lco/vine/android/player/SdkVideoView;->singlePlayer:Landroid/media/MediaPlayer;

    if-eqz v1, :cond_0

    .line 746
    sget-object v1, Lco/vine/android/player/SdkVideoView;->singlePlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->release()V

    .line 747
    const/4 v1, 0x0

    sput-object v1, Lco/vine/android/player/SdkVideoView;->singlePlayer:Landroid/media/MediaPlayer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 752
    .local v0, "e":Ljava/lang/Exception;
    :cond_0
    :goto_0
    :try_start_1
    monitor-exit v2

    .line 753
    return-void

    .line 749
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_0
    move-exception v0

    .line 750
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v1, "Failed to release static player."

    invoke-static {v1, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 752
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method private setCurrentState(I)V
    .locals 1
    .param p1, "state"    # I

    .prologue
    .line 168
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-eqz v0, :cond_0

    .line 169
    sput p1, Lco/vine/android/player/SdkVideoView;->currentState:I

    .line 173
    :goto_0
    return-void

    .line 171
    :cond_0
    iput p1, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    goto :goto_0
.end method

.method private setPlayer(Landroid/media/MediaPlayer;)V
    .locals 1
    .param p1, "player"    # Landroid/media/MediaPlayer;

    .prologue
    .line 756
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-eqz v0, :cond_0

    .line 757
    sput-object p1, Lco/vine/android/player/SdkVideoView;->singlePlayer:Landroid/media/MediaPlayer;

    .line 761
    :goto_0
    return-void

    .line 759
    :cond_0
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    goto :goto_0
.end method

.method private setVideoURI(Landroid/net/Uri;)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 260
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/player/SdkVideoView;->setVideoURI(Landroid/net/Uri;Ljava/util/Map;)V

    .line 261
    return-void
.end method

.method private setVideoURI(Landroid/net/Uri;Ljava/util/Map;)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 264
    .local p2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;

    .line 265
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;

    sput-object v0, Lco/vine/android/player/SdkVideoView;->currentUri:Landroid/net/Uri;

    .line 266
    iput-object p2, p0, Lco/vine/android/player/SdkVideoView;->mHeaders:Ljava/util/Map;

    .line 267
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I

    .line 268
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->openVideo()V

    .line 269
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->requestLayout()V

    .line 270
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->postInvalidate()V

    .line 271
    return-void
.end method

.method private stopPlaybackInternal()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 774
    sget-boolean v0, Lco/vine/android/player/SdkVideoView;->USE_EXO:Z

    if-eqz v0, :cond_1

    .line 775
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v0, :cond_0

    .line 776
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v0}, Lcom/google/android/exoplayer/ExoPlayer;->stop()V

    .line 777
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v0}, Lcom/google/android/exoplayer/ExoPlayer;->release()V

    .line 778
    iput-object v2, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    .line 779
    invoke-direct {p0, v1}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 780
    iput v1, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 791
    :cond_0
    :goto_0
    return-void

    .line 783
    :cond_1
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 784
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V

    .line 785
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 786
    invoke-direct {p0, v2}, Lco/vine/android/player/SdkVideoView;->setPlayer(Landroid/media/MediaPlayer;)V

    .line 787
    invoke-direct {p0, v1}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 788
    iput v1, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    goto :goto_0
.end method

.method private toggleMediaControlsVisibility()V
    .locals 1

    .prologue
    .line 966
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 967
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 971
    :goto_0
    return-void

    .line 969
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->show()V

    goto :goto_0
.end method


# virtual methods
.method public canPause()Z
    .locals 1

    .prologue
    .line 1119
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mIsPrepared:Z

    return v0
.end method

.method public canSeekBackward()Z
    .locals 1

    .prologue
    .line 1123
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mIsPrepared:Z

    return v0
.end method

.method public canSeekForward()Z
    .locals 1

    .prologue
    .line 1127
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mIsPrepared:Z

    return v0
.end method

.method public getAttributes()Landroid/util/AttributeSet;
    .locals 1

    .prologue
    .line 1140
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mAttributes:Landroid/util/AttributeSet;

    return-object v0
.end method

.method public getAudioSessionId()I
    .locals 2

    .prologue
    .line 1131
    iget v1, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I

    if-nez v1, :cond_0

    .line 1132
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    .line 1133
    .local v0, "foo":Landroid/media/MediaPlayer;
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getAudioSessionId()I

    move-result v1

    iput v1, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I

    .line 1134
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 1136
    .end local v0    # "foo":Landroid/media/MediaPlayer;
    :cond_0
    iget v1, p0, Lco/vine/android/player/SdkVideoView;->mAudioSession:I

    return v1
.end method

.method public getBufferPercentage()I
    .locals 1

    .prologue
    .line 1101
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->hasPlayer()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1102
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mCurrentBufferPercentage:I

    .line 1104
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentPosition()I
    .locals 2

    .prologue
    .line 1064
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1065
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v1, :cond_0

    .line 1066
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v1}, Lcom/google/android/exoplayer/ExoPlayer;->getCurrentPosition()I

    move-result v1

    .line 1075
    :goto_0
    return v1

    .line 1068
    :cond_0
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 1069
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v1

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getCurrentPosition()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    goto :goto_0

    .line 1072
    :catch_0
    move-exception v0

    .line 1073
    .local v0, "e":Ljava/lang/Exception;
    const/4 v1, -0x1

    goto :goto_0

    .line 1075
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getDuration()I
    .locals 5

    .prologue
    const/4 v2, -0x1

    .line 1045
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1046
    iget-object v3, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v3, :cond_1

    .line 1047
    iget-object v3, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v3}, Lcom/google/android/exoplayer/ExoPlayer;->getDuration()I

    move-result v2

    .line 1059
    :cond_0
    :goto_0
    return v2

    .line 1049
    :cond_1
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v1

    .line 1050
    .local v1, "player":Landroid/media/MediaPlayer;
    if-eqz v1, :cond_0

    .line 1051
    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getDuration()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 1056
    .end local v1    # "player":Landroid/media/MediaPlayer;
    :catch_0
    move-exception v0

    .line 1057
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "It\'s ok. probably a race condition."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v0, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mPath:Ljava/lang/String;

    return-object v0
.end method

.method public getPlayingPosition()I
    .locals 1

    .prologue
    .line 214
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mPlayingPosition:I

    return v0
.end method

.method public hasControlOfPlayer()Z
    .locals 2

    .prologue
    .line 1108
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-eqz v0, :cond_0

    sget-object v0, Lco/vine/android/player/SdkVideoView;->currentView:Landroid/view/View;

    if-ne v0, p0, :cond_1

    sget-object v0, Lco/vine/android/player/SdkVideoView;->currentUri:Landroid/net/Uri;

    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasStarted()Z
    .locals 1

    .prologue
    .line 1016
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    return v0
.end method

.method public isInPlaybackState()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 1112
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->hasPlayer()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getCurrentState()I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getCurrentState()I

    move-result v1

    if-eq v1, v0, :cond_0

    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getCurrentState()I

    move-result v1

    const/4 v2, 0x2

    if-eq v1, v2, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPathPlaying(Ljava/lang/String;)Z
    .locals 1
    .param p1, "newPath"    # Ljava/lang/String;

    .prologue
    .line 1193
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->hasControlOfPlayer()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mPath:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPaused()Z
    .locals 2

    .prologue
    .line 1020
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getCurrentState()I

    move-result v0

    const/4 v1, 0x7

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPlayerPlaying()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 917
    sget-boolean v2, Lco/vine/android/player/SdkVideoView;->USE_EXO:Z

    if-eqz v2, :cond_2

    .line 918
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v2}, Lcom/google/android/exoplayer/ExoPlayer;->getPlayWhenReady()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 920
    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    .line 918
    goto :goto_0

    .line 920
    :cond_2
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v2

    if-eqz v2, :cond_3

    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v2

    if-nez v2, :cond_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public isPlaying()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 1094
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isPlayerPlaying()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 1096
    :cond_0
    :goto_0
    return v1

    .line 1095
    :catch_0
    move-exception v0

    .line 1096
    .local v0, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method public isSurfaceReady()Z
    .locals 1

    .prologue
    .line 285
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCryptoError(Landroid/media/MediaCodec$CryptoException;)V
    .locals 2
    .param p1, "e"    # Landroid/media/MediaCodec$CryptoException;

    .prologue
    .line 848
    sget-object v0, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    const-string v1, "onCryptoError"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 849
    return-void
.end method

.method public onDecoderInitializationError(Lcom/google/android/exoplayer/MediaCodecTrackRenderer$DecoderInitializationException;)V
    .locals 2
    .param p1, "e"    # Lcom/google/android/exoplayer/MediaCodecTrackRenderer$DecoderInitializationException;

    .prologue
    .line 843
    sget-object v0, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    const-string v1, "onDecoderInitializationError"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 844
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 1146
    :try_start_0
    invoke-super {p0}, Landroid/view/TextureView;->onDetachedFromWindow()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1161
    :goto_0
    return-void

    .line 1147
    :catch_0
    move-exception v0

    .line 1148
    .local v0, "e":Ljava/lang/Exception;
    const/4 v3, 0x0

    .line 1149
    .local v3, "tx":Landroid/graphics/SurfaceTexture;
    const/4 v2, 0x1

    .line 1151
    .local v2, "success":Z
    :try_start_1
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->getSurfaceTexture()Landroid/graphics/SurfaceTexture;

    move-result-object v3

    .line 1152
    if-eqz v3, :cond_0

    .line 1153
    invoke-virtual {v3}, Landroid/graphics/SurfaceTexture;->release()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 1159
    :cond_0
    :goto_1
    const-string v4, "Failed to detach from window, but it\'s ok, since we won\'t use this anyways: {}, {}."

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    aput-object v6, v5, v7

    aput-object v3, v5, v8

    invoke-static {v0, v4, v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 1155
    :catch_1
    move-exception v1

    .line 1156
    .local v1, "e2":Ljava/lang/Exception;
    const/4 v2, 0x0

    .line 1157
    const-string v4, "Failed to release: {}."

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v7

    invoke-static {v4, v5}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method

.method public onDrawnToSurface(Landroid/view/Surface;)V
    .locals 2
    .param p1, "surface"    # Landroid/view/Surface;

    .prologue
    .line 833
    sget-object v0, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    const-string v1, "Rendering has started successfully!"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 834
    return-void
.end method

.method public onDroppedFrames(IJ)V
    .locals 3
    .param p1, "count"    # I
    .param p2, "elapsed"    # J

    .prologue
    .line 838
    sget-object v0, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Dropped frames: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 839
    return-void
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 234
    invoke-super {p0, p1}, Landroid/view/TextureView;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 235
    const-class v0, Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 236
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 1
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 240
    invoke-super {p0, p1}, Landroid/view/TextureView;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 241
    const-class v0, Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 242
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    const/4 v1, 0x1

    .line 926
    const/4 v2, 0x4

    if-eq p1, v2, :cond_2

    const/16 v2, 0x18

    if-eq p1, v2, :cond_2

    const/16 v2, 0x19

    if-eq p1, v2, :cond_2

    const/16 v2, 0xa4

    if-eq p1, v2, :cond_2

    const/16 v2, 0x52

    if-eq p1, v2, :cond_2

    const/4 v2, 0x5

    if-eq p1, v2, :cond_2

    const/4 v2, 0x6

    if-eq p1, v2, :cond_2

    move v0, v1

    .line 933
    .local v0, "isKeyCodeSupported":Z
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v2

    if-eqz v2, :cond_8

    if-eqz v0, :cond_8

    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v2, :cond_8

    .line 934
    const/16 v2, 0x4f

    if-eq p1, v2, :cond_0

    const/16 v2, 0x55

    if-ne p1, v2, :cond_4

    .line 936
    :cond_0
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 937
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 938
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->show()V

    .line 962
    :cond_1
    :goto_1
    return v1

    .line 926
    .end local v0    # "isKeyCodeSupported":Z
    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 940
    .restart local v0    # "isKeyCodeSupported":Z
    :cond_3
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->start()V

    .line 941
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->hide()V

    goto :goto_1

    .line 944
    :cond_4
    const/16 v2, 0x7e

    if-ne p1, v2, :cond_5

    .line 945
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v2

    if-nez v2, :cond_1

    .line 946
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->start()V

    .line 947
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->hide()V

    goto :goto_1

    .line 950
    :cond_5
    const/16 v2, 0x56

    if-eq p1, v2, :cond_6

    const/16 v2, 0x7f

    if-ne p1, v2, :cond_7

    .line 952
    :cond_6
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 953
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 954
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->show()V

    goto :goto_1

    .line 958
    :cond_7
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->toggleMediaControlsVisibility()V

    .line 962
    :cond_8
    invoke-super {p0, p1, p2}, Landroid/view/TextureView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_1
.end method

.method protected onMeasure(II)V
    .locals 4
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 201
    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    invoke-static {v2, p1}, Lco/vine/android/player/SdkVideoView;->getDefaultSize(II)I

    move-result v1

    .line 202
    .local v1, "width":I
    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    invoke-static {v2, p2}, Lco/vine/android/player/SdkVideoView;->getDefaultSize(II)I

    move-result v0

    .line 203
    .local v0, "height":I
    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    if-lez v2, :cond_0

    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    if-lez v2, :cond_0

    .line 204
    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    mul-int/2addr v3, v1

    if-le v2, v3, :cond_1

    .line 205
    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    mul-int/2addr v2, v1

    iget v3, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    div-int v0, v2, v3

    .line 210
    :cond_0
    :goto_0
    invoke-virtual {p0, v1, v0}, Lco/vine/android/player/SdkVideoView;->setMeasuredDimension(II)V

    .line 211
    return-void

    .line 206
    :cond_1
    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    mul-int/2addr v3, v1

    if-ge v2, v3, :cond_0

    .line 207
    iget v2, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    div-int v1, v2, v3

    goto :goto_0
.end method

.method public onPlayWhenReadyCommitted()V
    .locals 0

    .prologue
    .line 811
    return-void
.end method

.method public onPlayerError(Lcom/google/android/exoplayer/ExoPlaybackException;)V
    .locals 3
    .param p1, "e"    # Lcom/google/android/exoplayer/ExoPlaybackException;

    .prologue
    const/4 v2, -0x1

    .line 815
    sget-object v0, Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;

    const-string v1, "Player error!"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 816
    invoke-direct {p0, v2, v2}, Lco/vine/android/player/SdkVideoView;->onError(II)Z

    .line 817
    return-void
.end method

.method public onPlayerStateChanged(ZI)V
    .locals 2
    .param p1, "playWhenReady"    # Z
    .param p2, "playbackState"    # I

    .prologue
    .line 795
    invoke-static {p2}, Lco/vine/android/player/SdkVideoView;->getViewStateFromExoState(I)I

    move-result v0

    invoke-direct {p0, v0}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 796
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 797
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->onPrepared()V

    .line 799
    :cond_0
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    const/4 v1, 0x5

    if-ne v0, v1, :cond_2

    .line 800
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mLooping:Z

    if-eqz v0, :cond_1

    .line 801
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/android/exoplayer/ExoPlayer;->seekTo(I)V

    .line 802
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/exoplayer/ExoPlayer;->setPlayWhenReady(Z)V

    .line 804
    :cond_1
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->onComplete()V

    .line 806
    :cond_2
    return-void
.end method

.method public onPrepared()V
    .locals 2

    .prologue
    .line 1025
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 1026
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->hasPlayer()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOnPreparedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    if-eqz v0, :cond_0

    .line 1027
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mOnPreparedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    invoke-interface {v0, p0}, Lco/vine/android/player/VideoViewInterface$OnPreparedListener;->onPrepared(Lco/vine/android/player/VideoViewInterface;)V

    .line 1030
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 902
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 903
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->toggleMediaControlsVisibility()V

    .line 905
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public onTrackballEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 910
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 911
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->toggleMediaControlsVisibility()V

    .line 913
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public onVideoSizeChanged(II)V
    .locals 1
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 821
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    if-ne v0, p2, :cond_0

    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    if-eq v0, p1, :cond_1

    .line 822
    :cond_0
    iput p1, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    .line 823
    iput p2, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    .line 824
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mVideoWidth:I

    if-eqz v0, :cond_1

    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mVideoHeight:I

    if-eqz v0, :cond_1

    .line 826
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->requestLayout()V

    .line 829
    :cond_1
    return-void
.end method

.method public onViewClicked()V
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSaveVideoClicker:Lco/vine/android/player/SaveVideoClicker;

    invoke-virtual {v0, p0}, Lco/vine/android/player/SaveVideoClicker;->onClick(Lco/vine/android/player/SdkVideoView;)V

    .line 197
    return-void
.end method

.method public pause()V
    .locals 3

    .prologue
    const/4 v2, 0x7

    .line 995
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 996
    sget-boolean v0, Lco/vine/android/player/SdkVideoView;->USE_EXO:Z

    if-eqz v0, :cond_1

    .line 997
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/android/exoplayer/ExoPlayer;->setPlayWhenReady(Z)V

    .line 998
    iget v0, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    .line 999
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    .line 1008
    :cond_0
    :goto_0
    iput v2, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 1009
    return-void

    .line 1002
    :cond_1
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1003
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 1004
    invoke-direct {p0, v2}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    goto :goto_0
.end method

.method public releaseSurface()V
    .locals 1

    .prologue
    .line 894
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;

    if-eqz v0, :cond_0

    .line 895
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;

    invoke-virtual {v0}, Landroid/view/Surface;->release()V

    .line 896
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;

    .line 898
    :cond_0
    return-void
.end method

.method public restart()V
    .locals 4

    .prologue
    .line 660
    sget-object v2, Lco/vine/android/player/SdkVideoView;->LOCK:[I

    monitor-enter v2

    .line 661
    :try_start_0
    sget-boolean v1, Lco/vine/android/player/SdkVideoView;->USE_EXO:Z

    if-eqz v1, :cond_1

    .line 662
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v1, :cond_0

    .line 663
    iget-object v1, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Lcom/google/android/exoplayer/ExoPlayer;->seekTo(I)V

    .line 664
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->resume()V

    .line 674
    :cond_0
    :goto_0
    monitor-exit v2

    .line 675
    return-void

    .line 667
    :cond_1
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    .line 668
    .local v0, "mediaPlayer":Landroid/media/MediaPlayer;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 669
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 670
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 671
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    goto :goto_0

    .line 674
    .end local v0    # "mediaPlayer":Landroid/media/MediaPlayer;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public resume()V
    .locals 1

    .prologue
    .line 1037
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mWasMuted:Z

    .line 1038
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    invoke-virtual {p0, v0}, Lco/vine/android/player/SdkVideoView;->setMute(Z)V

    .line 1039
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->start()V

    .line 1040
    return-void

    .line 1037
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public retryOpenVideo(Z)Z
    .locals 4
    .param p1, "forced"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 274
    const-string v3, "Retry open video: {}"

    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mHasNotRetriedBefore:Z

    if-nez v0, :cond_2

    move v0, v1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v3, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 275
    if-nez p1, :cond_0

    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mHasNotRetriedBefore:Z

    if-nez v0, :cond_1

    .line 276
    :cond_0
    iput-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mHasNotRetriedBefore:Z

    .line 277
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->openVideo()V

    move v2, v1

    .line 280
    :cond_1
    return v2

    :cond_2
    move v0, v2

    .line 274
    goto :goto_0
.end method

.method public seekTo(I)V
    .locals 1
    .param p1, "msec"    # I

    .prologue
    .line 1079
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1080
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1081
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 1083
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v0, :cond_1

    .line 1084
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    invoke-virtual {v0, p1}, Lcom/google/android/exoplayer/ExoPlayer;->seekTo(I)V

    .line 1086
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I

    .line 1090
    :goto_0
    return-void

    .line 1088
    :cond_2
    iput p1, p0, Lco/vine/android/player/SdkVideoView;->mSeekWhenPrepared:I

    goto :goto_0
.end method

.method public setAutoPlayOnPrepared(Z)V
    .locals 0
    .param p1, "autoPlay"    # Z

    .prologue
    .line 620
    iput-boolean p1, p0, Lco/vine/android/player/SdkVideoView;->mAutoPlayOnPrepared:Z

    .line 621
    return-void
.end method

.method public setAutoShow(Z)V
    .locals 0
    .param p1, "autoShow"    # Z

    .prologue
    .line 465
    iput-boolean p1, p0, Lco/vine/android/player/SdkVideoView;->mAutoShow:Z

    .line 466
    return-void
.end method

.method public setKeepScreenOn(Z)V
    .locals 2
    .param p1, "keepScreenOn"    # Z

    .prologue
    .line 452
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 453
    invoke-super {p0, p1}, Landroid/view/TextureView;->setKeepScreenOn(Z)V

    .line 462
    :goto_0
    return-void

    .line 455
    :cond_0
    new-instance v0, Lco/vine/android/player/SdkVideoView$3;

    invoke-direct {v0, p0, p1}, Lco/vine/android/player/SdkVideoView$3;-><init>(Lco/vine/android/player/SdkVideoView;Z)V

    invoke-virtual {p0, v0}, Lco/vine/android/player/SdkVideoView;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public setLooping(Z)V
    .locals 0
    .param p1, "looping"    # Z

    .prologue
    .line 1033
    iput-boolean p1, p0, Lco/vine/android/player/SdkVideoView;->mLooping:Z

    .line 1034
    return-void
.end method

.method public setMediaController(Landroid/widget/MediaController;)V
    .locals 1
    .param p1, "controller"    # Landroid/widget/MediaController;

    .prologue
    .line 469
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 470
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 472
    :cond_0
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mMediaController:Landroid/widget/MediaController;

    .line 473
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->attachMediaController()V

    .line 474
    return-void
.end method

.method public setMute(Z)V
    .locals 4
    .param p1, "mute"    # Z

    .prologue
    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    .line 1164
    iput-boolean p1, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    .line 1165
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mWasMuted:Z

    iget-boolean v1, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    if-eq v0, v1, :cond_0

    .line 1166
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    if-eqz v0, :cond_1

    .line 1167
    invoke-virtual {p0, v2, v2}, Lco/vine/android/player/SdkVideoView;->setVolume(FF)V

    .line 1172
    :cond_0
    :goto_0
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    iput-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mWasMuted:Z

    .line 1173
    return-void

    .line 1169
    :cond_1
    invoke-virtual {p0, v3, v3}, Lco/vine/android/player/SdkVideoView;->setVolume(FF)V

    goto :goto_0
.end method

.method public setOnCompletionListener(Lco/vine/android/player/VideoViewInterface$OnCompletionListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    .prologue
    .line 630
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    .line 631
    return-void
.end method

.method public setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    .prologue
    .line 642
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    .line 643
    return-void
.end method

.method public setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V
    .locals 0
    .param p1, "l"    # Landroid/media/MediaPlayer$OnInfoListener;

    .prologue
    .line 652
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mOnInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    .line 653
    return-void
.end method

.method public setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    .prologue
    .line 616
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mOnPreparedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    .line 617
    return-void
.end method

.method public setPlayingPosition(I)V
    .locals 0
    .param p1, "playingPosition"    # I

    .prologue
    .line 218
    iput p1, p0, Lco/vine/android/player/SdkVideoView;->mPlayingPosition:I

    .line 219
    return-void
.end method

.method public setReportOpenError(Z)V
    .locals 0
    .param p1, "reportError"    # Z

    .prologue
    .line 656
    iput-boolean p1, p0, Lco/vine/android/player/SdkVideoView;->mReportOpenError:Z

    .line 657
    return-void
.end method

.method public setSurfaceReadyListener(Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;

    .prologue
    .line 690
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mSurfaceReadyListener:Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;

    .line 691
    return-void
.end method

.method public setVideoPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 246
    invoke-virtual {p0, p1}, Lco/vine/android/player/SdkVideoView;->setVideoPathDirect(Ljava/lang/String;)V

    .line 247
    return-void
.end method

.method public setVideoPathDirect(Ljava/lang/String;)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 250
    const-string v0, "mPath={}."

    invoke-static {v0, p1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 251
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView;->mPath:Ljava/lang/String;

    .line 252
    if-eqz p1, :cond_0

    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    :goto_0
    invoke-direct {p0, v0}, Lco/vine/android/player/SdkVideoView;->setVideoURI(Landroid/net/Uri;)V

    .line 253
    return-void

    .line 252
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setVolume(FF)V
    .locals 5
    .param p1, "left"    # F
    .param p2, "right"    # F

    .prologue
    .line 1176
    sget-object v1, Lco/vine/android/player/SdkVideoView;->LOCK:[I

    monitor-enter v1

    .line 1177
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->mWasMuted:Z

    iget-boolean v2, p0, Lco/vine/android/player/SdkVideoView;->mMuted:Z

    if-eq v0, v2, :cond_1

    .line 1178
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    if-eqz v0, :cond_2

    .line 1179
    cmpl-float v0, p1, p2

    if-eqz v0, :cond_0

    .line 1180
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v2, "Currently AudioTrackRenderer only take 1 item and it will be set for both left and right."

    invoke-direct {v0, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1189
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 1182
    :cond_0
    :try_start_1
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    iget-object v2, p0, Lco/vine/android/player/SdkVideoView;->mExoAudioRenderer:Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;

    sget-object v3, Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;->MSG_SET_VOLUME:Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    invoke-virtual {v0, v2, v3, v4}, Lcom/google/android/exoplayer/ExoPlayer;->sendMessage(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1189
    :cond_1
    :goto_0
    monitor-exit v1

    .line 1190
    return-void

    .line 1184
    :cond_2
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 1185
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/media/MediaPlayer;->setVolume(FF)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public start()V
    .locals 1

    .prologue
    .line 974
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/player/SdkVideoView;->start(Z)V

    .line 975
    return-void
.end method

.method public start(Z)V
    .locals 4
    .param p1, "ensureVisibility"    # Z

    .prologue
    const/4 v3, 0x6

    .line 978
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_0

    .line 979
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 981
    :cond_0
    sget-object v1, Lco/vine/android/player/SdkVideoView;->LOCK:[I

    monitor-enter v1

    .line 982
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 983
    sget-boolean v0, Lco/vine/android/player/SdkVideoView;->USE_EXO:Z

    if-eqz v0, :cond_2

    .line 984
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lcom/google/android/exoplayer/ExoPlayer;->setPlayWhenReady(Z)V

    .line 988
    :goto_0
    const/4 v0, 0x6

    invoke-direct {p0, v0}, Lco/vine/android/player/SdkVideoView;->setCurrentState(I)V

    .line 990
    :cond_1
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 991
    iput v3, p0, Lco/vine/android/player/SdkVideoView;->mTargetState:I

    .line 992
    return-void

    .line 986
    :cond_2
    :try_start_1
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->getPlayer()Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    goto :goto_0

    .line 990
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public startOpenVideo()V
    .locals 0

    .prologue
    .line 289
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->openVideo()V

    .line 290
    return-void
.end method

.method public stopPlayback()V
    .locals 2

    .prologue
    .line 764
    iget-boolean v0, p0, Lco/vine/android/player/SdkVideoView;->SINGLE_PLAYER:Z

    if-eqz v0, :cond_0

    .line 765
    sget-object v1, Lco/vine/android/player/SdkVideoView;->LOCK:[I

    monitor-enter v1

    .line 766
    :try_start_0
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->stopPlaybackInternal()V

    .line 767
    monitor-exit v1

    .line 771
    :goto_0
    return-void

    .line 767
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 769
    :cond_0
    invoke-direct {p0}, Lco/vine/android/player/SdkVideoView;->stopPlaybackInternal()V

    goto :goto_0
.end method

.method public suspend()V
    .locals 1

    .prologue
    .line 1012
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/player/SdkVideoView;->release(Z)V

    .line 1013
    return-void
.end method
