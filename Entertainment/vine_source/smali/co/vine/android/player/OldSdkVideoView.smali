.class public Lco/vine/android/player/OldSdkVideoView;
.super Landroid/view/SurfaceView;
.source "OldSdkVideoView.java"

# interfaces
.implements Landroid/widget/MediaController$MediaPlayerControl;
.implements Lco/vine/android/player/VideoViewInterface;


# static fields
.field private static final STATE_ERROR:I = -0x1

.field private static final STATE_IDLE:I = 0x0

.field private static final STATE_PAUSED:I = 0x4

.field private static final STATE_PLAYBACK_COMPLETED:I = 0x5

.field private static final STATE_PLAYING:I = 0x3

.field private static final STATE_PREPARED:I = 0x2

.field private static final STATE_PREPARING:I = 0x1


# instance fields
.field private mAudioSession:I

.field private mAutoPlay:Z

.field private mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

.field private mCanPause:Z

.field private mCanSeekBack:Z

.field private mCanSeekForward:Z

.field private mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

.field private mCurrentBufferPercentage:I

.field private mCurrentState:I

.field private mCustomOnPreParedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

.field private mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

.field private mInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

.field private mLooping:Z

.field private mMediaController:Landroid/widget/MediaController;

.field private mMediaPlayer:Landroid/media/MediaPlayer;

.field private mMuted:Z

.field private mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

.field private mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;

.field private mOnInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

.field private final mOnPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

.field mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

.field private mReportVideoError:Z

.field mSHCallback:Landroid/view/SurfaceHolder$Callback;

.field private mSeekWhenPrepared:I

.field mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

.field private mSurfaceHeight:I

.field private mSurfaceHolder:Landroid/view/SurfaceHolder;

.field private mSurfaceWidth:I

.field private mTargetState:I

.field private mUri:Landroid/net/Uri;

.field private mVideoHeight:I

.field private mVideoWidth:I

.field private mWasMuted:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 91
    invoke-direct {p0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    .line 36
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$1;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$1;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mOnPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 65
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 66
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 69
    iput-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 70
    iput-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    .line 86
    iput-boolean v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    .line 87
    iput-boolean v1, p0, Lco/vine/android/player/OldSdkVideoView;->mWasMuted:Z

    .line 314
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$2;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$2;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 326
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$3;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$3;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 375
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$4;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$4;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    .line 389
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$5;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$5;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    .line 399
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$6;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$6;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 421
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$7;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$7;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .line 460
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$8;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$8;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSHCallback:Landroid/view/SurfaceHolder$Callback;

    .line 92
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->initVideoView()V

    .line 93
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 96
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/player/OldSdkVideoView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 97
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->initVideoView()V

    .line 98
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 101
    invoke-direct {p0, p1, p2, p3}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 36
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$1;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$1;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mOnPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 65
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 66
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 69
    iput-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 70
    iput-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    .line 86
    iput-boolean v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    .line 87
    iput-boolean v1, p0, Lco/vine/android/player/OldSdkVideoView;->mWasMuted:Z

    .line 314
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$2;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$2;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 326
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$3;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$3;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 375
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$4;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$4;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    .line 389
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$5;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$5;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    .line 399
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$6;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$6;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 421
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$7;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$7;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .line 460
    new-instance v0, Lco/vine/android/player/OldSdkVideoView$8;

    invoke-direct {v0, p0}, Lco/vine/android/player/OldSdkVideoView$8;-><init>(Lco/vine/android/player/OldSdkVideoView;)V

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSHCallback:Landroid/view/SurfaceHolder$Callback;

    .line 102
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->initVideoView()V

    .line 103
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/player/OldSdkVideoView;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mAutoPlay:Z

    return v0
.end method

.method static synthetic access$100(Lco/vine/android/player/OldSdkVideoView;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mLooping:Z

    return v0
.end method

.method static synthetic access$1000(Lco/vine/android/player/OldSdkVideoView;)Landroid/media/MediaPlayer;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    return-object v0
.end method

.method static synthetic access$1100(Lco/vine/android/player/OldSdkVideoView;)Landroid/widget/MediaController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    return-object v0
.end method

.method static synthetic access$1200(Lco/vine/android/player/OldSdkVideoView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSeekWhenPrepared:I

    return v0
.end method

.method static synthetic access$1300(Lco/vine/android/player/OldSdkVideoView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceWidth:I

    return v0
.end method

.method static synthetic access$1302(Lco/vine/android/player/OldSdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    iput p1, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceWidth:I

    return p1
.end method

.method static synthetic access$1400(Lco/vine/android/player/OldSdkVideoView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceHeight:I

    return v0
.end method

.method static synthetic access$1402(Lco/vine/android/player/OldSdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    iput p1, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceHeight:I

    return p1
.end method

.method static synthetic access$1500(Lco/vine/android/player/OldSdkVideoView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    return v0
.end method

.method static synthetic access$1502(Lco/vine/android/player/OldSdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    iput p1, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    return p1
.end method

.method static synthetic access$1600(Lco/vine/android/player/OldSdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnCompletionListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    return-object v0
.end method

.method static synthetic access$1700(Lco/vine/android/player/OldSdkVideoView;)Landroid/media/MediaPlayer$OnInfoListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mOnInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    return-object v0
.end method

.method static synthetic access$1800(Lco/vine/android/player/OldSdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnErrorListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    return-object v0
.end method

.method static synthetic access$1902(Lco/vine/android/player/OldSdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    iput p1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentBufferPercentage:I

    return p1
.end method

.method static synthetic access$200(Lco/vine/android/player/OldSdkVideoView;)Lco/vine/android/player/VideoViewInterface$OnPreparedListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mCustomOnPreParedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    return-object v0
.end method

.method static synthetic access$2002(Lco/vine/android/player/OldSdkVideoView;Landroid/view/SurfaceHolder;)Landroid/view/SurfaceHolder;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 26
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    return-object p1
.end method

.method static synthetic access$2100(Lco/vine/android/player/OldSdkVideoView;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->openVideo()V

    return-void
.end method

.method static synthetic access$2200(Lco/vine/android/player/OldSdkVideoView;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # Z

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lco/vine/android/player/OldSdkVideoView;->release(Z)V

    return-void
.end method

.method static synthetic access$300(Lco/vine/android/player/OldSdkVideoView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    return v0
.end method

.method static synthetic access$302(Lco/vine/android/player/OldSdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    iput p1, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    return p1
.end method

.method static synthetic access$400(Lco/vine/android/player/OldSdkVideoView;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    return v0
.end method

.method static synthetic access$402(Lco/vine/android/player/OldSdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    iput p1, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    return p1
.end method

.method static synthetic access$502(Lco/vine/android/player/OldSdkVideoView;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    iput p1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    return p1
.end method

.method static synthetic access$602(Lco/vine/android/player/OldSdkVideoView;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # Z

    .prologue
    .line 26
    iput-boolean p1, p0, Lco/vine/android/player/OldSdkVideoView;->mCanPause:Z

    return p1
.end method

.method static synthetic access$702(Lco/vine/android/player/OldSdkVideoView;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # Z

    .prologue
    .line 26
    iput-boolean p1, p0, Lco/vine/android/player/OldSdkVideoView;->mCanSeekBack:Z

    return p1
.end method

.method static synthetic access$802(Lco/vine/android/player/OldSdkVideoView;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;
    .param p1, "x1"    # Z

    .prologue
    .line 26
    iput-boolean p1, p0, Lco/vine/android/player/OldSdkVideoView;->mCanSeekForward:Z

    return p1
.end method

.method static synthetic access$900(Lco/vine/android/player/OldSdkVideoView;)Landroid/media/MediaPlayer$OnPreparedListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/player/OldSdkVideoView;

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mOnPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    return-object v0
.end method

.method private attachMediaController()V
    .locals 3

    .prologue
    .line 305
    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v1, :cond_0

    .line 306
    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v1, p0}, Landroid/widget/MediaController;->setMediaPlayer(Landroid/widget/MediaController$MediaPlayerControl;)V

    .line 307
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    instance-of v1, v1, Landroid/view/View;

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    move-object v0, v1

    .line 309
    .local v0, "anchorView":Landroid/view/View;
    :goto_0
    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v1, v0}, Landroid/widget/MediaController;->setAnchorView(Landroid/view/View;)V

    .line 310
    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/MediaController;->setEnabled(Z)V

    .line 312
    .end local v0    # "anchorView":Landroid/view/View;
    :cond_0
    return-void

    :cond_1
    move-object v0, p0

    .line 307
    goto :goto_0
.end method

.method private initVideoView()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 174
    iput v2, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    .line 175
    iput v2, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    .line 176
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView;->mSHCallback:Landroid/view/SurfaceHolder$Callback;

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 177
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 178
    invoke-virtual {p0, v3}, Lco/vine/android/player/OldSdkVideoView;->setFocusable(Z)V

    .line 179
    invoke-virtual {p0, v3}, Lco/vine/android/player/OldSdkVideoView;->setFocusableInTouchMode(Z)V

    .line 180
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->requestFocus()Z

    .line 181
    iput v2, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 182
    iput v2, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 183
    return-void
.end method

.method private openVideo()V
    .locals 9

    .prologue
    const/4 v8, -0x1

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 239
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mUri:Landroid/net/Uri;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    if-nez v3, :cond_1

    .line 294
    :cond_0
    :goto_0
    return-void

    .line 244
    :cond_1
    new-instance v2, Landroid/content/Intent;

    const-string v3, "com.android.music.musicservicecommand"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 245
    .local v2, "i":Landroid/content/Intent;
    const-string v3, "command"

    const-string v4, "pause"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 246
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 250
    invoke-direct {p0, v6}, Lco/vine/android/player/OldSdkVideoView;->release(Z)V

    .line 252
    :try_start_0
    new-instance v3, Landroid/media/MediaPlayer;

    invoke-direct {v3}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    .line 254
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 256
    .local v0, "context":Landroid/content/Context;
    iget v3, p0, Lco/vine/android/player/OldSdkVideoView;->mAudioSession:I

    if-eqz v3, :cond_4

    .line 257
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget v4, p0, Lco/vine/android/player/OldSdkVideoView;->mAudioSession:I

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setAudioSessionId(I)V

    .line 261
    :goto_1
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 262
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mSizeChangedListener:Landroid/media/MediaPlayer$OnVideoSizeChangedListener;

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 263
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mCompletionListener:Landroid/media/MediaPlayer$OnCompletionListener;

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 264
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 265
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V

    .line 266
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 267
    const/4 v3, 0x0

    iput v3, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentBufferPercentage:I

    .line 268
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mUri:Landroid/net/Uri;

    invoke-virtual {v3, v0, v4}, Landroid/media/MediaPlayer;->setDataSource(Landroid/content/Context;Landroid/net/Uri;)V

    .line 269
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 270
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    const/4 v4, 0x3

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 271
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/media/MediaPlayer;->setScreenOnWhilePlaying(Z)V

    .line 272
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v3}, Landroid/media/MediaPlayer;->prepareAsync()V

    .line 274
    iget-boolean v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    if-eqz v3, :cond_2

    .line 275
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/media/MediaPlayer;->setVolume(FF)V

    .line 280
    :cond_2
    const/4 v3, 0x1

    iput v3, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 281
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->attachMediaController()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_1

    goto/16 :goto_0

    .line 282
    .end local v0    # "context":Landroid/content/Context;
    :catch_0
    move-exception v1

    .line 283
    .local v1, "ex":Ljava/lang/Exception;
    iget-boolean v3, p0, Lco/vine/android/player/OldSdkVideoView;->mReportVideoError:Z

    if-eqz v3, :cond_3

    .line 284
    const-string v3, "Unable to open content {}, {}."

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lco/vine/android/player/OldSdkVideoView;->mUri:Landroid/net/Uri;

    aput-object v5, v4, v6

    invoke-static {v1, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 286
    :cond_3
    iput v8, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 287
    iput v8, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 288
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mErrorListener:Landroid/media/MediaPlayer$OnErrorListener;

    iget-object v4, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-interface {v3, v4, v7, v6}, Landroid/media/MediaPlayer$OnErrorListener;->onError(Landroid/media/MediaPlayer;II)Z

    goto/16 :goto_0

    .line 259
    .end local v1    # "ex":Ljava/lang/Exception;
    .restart local v0    # "context":Landroid/content/Context;
    :cond_4
    :try_start_1
    iget-object v3, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v3}, Landroid/media/MediaPlayer;->getAudioSessionId()I

    move-result v3

    iput v3, p0, Lco/vine/android/player/OldSdkVideoView;->mAudioSession:I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_1

    .line 289
    .end local v0    # "context":Landroid/content/Context;
    :catch_1
    move-exception v1

    .line 290
    .local v1, "ex":Ljava/lang/IllegalStateException;
    iput v8, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 291
    iput v8, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 292
    const-string v3, "IllegalState error {}, {}."

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lco/vine/android/player/OldSdkVideoView;->mUri:Landroid/net/Uri;

    aput-object v5, v4, v6

    invoke-static {v1, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0
.end method

.method private release(Z)V
    .locals 2
    .param p1, "cleartargetstate"    # Z

    .prologue
    const/4 v1, 0x0

    .line 492
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 493
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 494
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 495
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    .line 496
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 497
    if-eqz p1, :cond_0

    .line 498
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 501
    :cond_0
    return-void
.end method

.method private toggleMediaControlsVisiblity()V
    .locals 1

    .prologue
    .line 561
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 562
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 566
    :goto_0
    return-void

    .line 564
    :cond_0
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->show()V

    goto :goto_0
.end method


# virtual methods
.method public canPause()Z
    .locals 1

    .prologue
    .line 679
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mCanPause:Z

    return v0
.end method

.method public canSeekBackward()Z
    .locals 1

    .prologue
    .line 684
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mCanSeekBack:Z

    return v0
.end method

.method public canSeekForward()Z
    .locals 1

    .prologue
    .line 689
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mCanSeekForward:Z

    return v0
.end method

.method public getAudioSessionId()I
    .locals 2

    .prologue
    .line 694
    iget v1, p0, Lco/vine/android/player/OldSdkVideoView;->mAudioSession:I

    if-nez v1, :cond_0

    .line 695
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    .line 696
    .local v0, "foo":Landroid/media/MediaPlayer;
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getAudioSessionId()I

    move-result v1

    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mAudioSession:I

    .line 697
    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 699
    .end local v0    # "foo":Landroid/media/MediaPlayer;
    :cond_0
    iget v1, p0, Lco/vine/android/player/OldSdkVideoView;->mAudioSession:I

    return v1
.end method

.method public getBufferPercentage()I
    .locals 1

    .prologue
    .line 664
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 665
    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentBufferPercentage:I

    .line 667
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentPosition()I
    .locals 1

    .prologue
    .line 613
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 614
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v0

    .line 616
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDuration()I
    .locals 1

    .prologue
    .line 604
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 605
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    .line 608
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public getPlayingPosition()I
    .locals 1

    .prologue
    .line 646
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 647
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v0

    .line 649
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public hasStarted()Z
    .locals 1

    .prologue
    .line 641
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    return v0
.end method

.method public isInPlaybackState()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 671
    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v1, :cond_0

    iget v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    iget v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    if-eqz v1, :cond_0

    iget v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    if-eq v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPaused()Z
    .locals 1

    .prologue
    .line 636
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPlaying()Z
    .locals 1

    .prologue
    .line 631
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

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

.method public isReportErrorOn()Z
    .locals 1

    .prologue
    .line 734
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mReportVideoError:Z

    return v0
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 521
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

    .line 528
    .local v0, "isKeyCodeSupported":Z
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v2

    if-eqz v2, :cond_8

    if-eqz v0, :cond_8

    iget-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v2, :cond_8

    .line 529
    const/16 v2, 0x4f

    if-eq p1, v2, :cond_0

    const/16 v2, 0x55

    if-ne p1, v2, :cond_4

    .line 531
    :cond_0
    iget-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 532
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->pause()V

    .line 533
    iget-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->show()V

    .line 557
    :cond_1
    :goto_1
    return v1

    .line 521
    .end local v0    # "isKeyCodeSupported":Z
    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    .line 535
    .restart local v0    # "isKeyCodeSupported":Z
    :cond_3
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->start()V

    .line 536
    iget-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->hide()V

    goto :goto_1

    .line 539
    :cond_4
    const/16 v2, 0x7e

    if-ne p1, v2, :cond_5

    .line 540
    iget-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v2

    if-nez v2, :cond_1

    .line 541
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->start()V

    .line 542
    iget-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->hide()V

    goto :goto_1

    .line 545
    :cond_5
    const/16 v2, 0x56

    if-eq p1, v2, :cond_6

    const/16 v2, 0x7f

    if-ne p1, v2, :cond_7

    .line 547
    :cond_6
    iget-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 548
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->pause()V

    .line 549
    iget-object v2, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v2}, Landroid/widget/MediaController;->show()V

    goto :goto_1

    .line 553
    :cond_7
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->toggleMediaControlsVisiblity()V

    .line 557
    :cond_8
    invoke-super {p0, p1, p2}, Landroid/view/SurfaceView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_1
.end method

.method protected onMeasure(II)V
    .locals 9
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v7, 0x40000000    # 2.0f

    const/high16 v8, -0x80000000

    .line 110
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    invoke-static {v6, p1}, Lco/vine/android/player/OldSdkVideoView;->getDefaultSize(II)I

    move-result v3

    .line 111
    .local v3, "width":I
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    invoke-static {v6, p2}, Lco/vine/android/player/OldSdkVideoView;->getDefaultSize(II)I

    move-result v0

    .line 112
    .local v0, "height":I
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    if-lez v6, :cond_0

    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    if-lez v6, :cond_0

    .line 114
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v4

    .line 115
    .local v4, "widthSpecMode":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v5

    .line 116
    .local v5, "widthSpecSize":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .line 117
    .local v1, "heightSpecMode":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 119
    .local v2, "heightSpecSize":I
    if-ne v4, v7, :cond_2

    if-ne v1, v7, :cond_2

    .line 121
    move v3, v5

    .line 122
    move v0, v2

    .line 125
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    mul-int/2addr v6, v0

    iget v7, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    mul-int/2addr v7, v3

    if-ge v6, v7, :cond_1

    .line 127
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    mul-int/2addr v6, v0

    iget v7, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    div-int v3, v6, v7

    .line 166
    .end local v1    # "heightSpecMode":I
    .end local v2    # "heightSpecSize":I
    .end local v4    # "widthSpecMode":I
    .end local v5    # "widthSpecSize":I
    :cond_0
    :goto_0
    invoke-virtual {p0, v3, v0}, Lco/vine/android/player/OldSdkVideoView;->setMeasuredDimension(II)V

    .line 167
    return-void

    .line 128
    .restart local v1    # "heightSpecMode":I
    .restart local v2    # "heightSpecSize":I
    .restart local v4    # "widthSpecMode":I
    .restart local v5    # "widthSpecSize":I
    :cond_1
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    mul-int/2addr v6, v0

    iget v7, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    mul-int/2addr v7, v3

    if-le v6, v7, :cond_0

    .line 130
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    mul-int/2addr v6, v3

    iget v7, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    div-int v0, v6, v7

    goto :goto_0

    .line 132
    :cond_2
    if-ne v4, v7, :cond_3

    .line 134
    move v3, v5

    .line 135
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    mul-int/2addr v6, v3

    iget v7, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    div-int v0, v6, v7

    .line 136
    if-ne v1, v8, :cond_0

    if-le v0, v2, :cond_0

    .line 138
    move v0, v2

    goto :goto_0

    .line 140
    :cond_3
    if-ne v1, v7, :cond_4

    .line 142
    move v0, v2

    .line 143
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    mul-int/2addr v6, v0

    iget v7, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    div-int v3, v6, v7

    .line 144
    if-ne v4, v8, :cond_0

    if-le v3, v5, :cond_0

    .line 146
    move v3, v5

    goto :goto_0

    .line 150
    :cond_4
    iget v3, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    .line 151
    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    .line 152
    if-ne v1, v8, :cond_5

    if-le v0, v2, :cond_5

    .line 154
    move v0, v2

    .line 155
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    mul-int/2addr v6, v0

    iget v7, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    div-int v3, v6, v7

    .line 157
    :cond_5
    if-ne v4, v8, :cond_0

    if-le v3, v5, :cond_0

    .line 159
    move v3, v5

    .line 160
    iget v6, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoHeight:I

    mul-int/2addr v6, v3

    iget v7, p0, Lco/vine/android/player/OldSdkVideoView;->mVideoWidth:I

    div-int v0, v6, v7

    goto :goto_0
.end method

.method public onPrepared()V
    .locals 2

    .prologue
    .line 655
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 656
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 657
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mOnPreparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    iget-object v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-interface {v0, v1}, Landroid/media/MediaPlayer$OnPreparedListener;->onPrepared(Landroid/media/MediaPlayer;)V

    .line 660
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 505
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 506
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->toggleMediaControlsVisiblity()V

    .line 508
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public onTrackballEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 513
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 514
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->toggleMediaControlsVisiblity()V

    .line 516
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public pause()V
    .locals 2

    .prologue
    const/4 v1, 0x4

    .line 579
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 580
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 581
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 582
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 585
    :cond_0
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 586
    return-void
.end method

.method public removeVideoUri()V
    .locals 1

    .prologue
    .line 210
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mUri:Landroid/net/Uri;

    .line 211
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSeekWhenPrepared:I

    .line 212
    return-void
.end method

.method public resolveAdjustedSize(II)I
    .locals 1
    .param p1, "desiredSize"    # I
    .param p2, "measureSpec"    # I

    .prologue
    .line 170
    invoke-static {p1, p2}, Lco/vine/android/player/OldSdkVideoView;->getDefaultSize(II)I

    move-result v0

    return v0
.end method

.method public resume()V
    .locals 1

    .prologue
    .line 593
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mWasMuted:Z

    .line 594
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    invoke-virtual {p0, v0}, Lco/vine/android/player/OldSdkVideoView;->setMute(Z)V

    .line 595
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 596
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 600
    :goto_1
    return-void

    .line 593
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 598
    :cond_1
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->openVideo()V

    goto :goto_1
.end method

.method public seekTo(I)V
    .locals 1
    .param p1, "msec"    # I

    .prologue
    .line 621
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 622
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 623
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSeekWhenPrepared:I

    .line 627
    :goto_0
    return-void

    .line 625
    :cond_0
    iput p1, p0, Lco/vine/android/player/OldSdkVideoView;->mSeekWhenPrepared:I

    goto :goto_0
.end method

.method public setAutoPlayOnPrepared(Z)V
    .locals 0
    .param p1, "autoPlay"    # Z

    .prologue
    .line 708
    iput-boolean p1, p0, Lco/vine/android/player/OldSdkVideoView;->mAutoPlay:Z

    .line 709
    return-void
.end method

.method public setLooping(Z)V
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 713
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mLooping:Z

    .line 714
    return-void
.end method

.method public setMediaController(Landroid/widget/MediaController;)V
    .locals 1
    .param p1, "controller"    # Landroid/widget/MediaController;

    .prologue
    .line 297
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 298
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 300
    :cond_0
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaController:Landroid/widget/MediaController;

    .line 301
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->attachMediaController()V

    .line 302
    return-void
.end method

.method public setMute(Z)V
    .locals 4
    .param p1, "mute"    # Z

    .prologue
    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    .line 717
    iput-boolean p1, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    .line 718
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mWasMuted:Z

    iget-boolean v1, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    if-eq v0, v1, :cond_0

    .line 719
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    if-eqz v0, :cond_1

    .line 720
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, v2, v2}, Landroid/media/MediaPlayer;->setVolume(FF)V

    .line 725
    :cond_0
    :goto_0
    iget-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMuted:Z

    iput-boolean v0, p0, Lco/vine/android/player/OldSdkVideoView;->mWasMuted:Z

    .line 726
    return-void

    .line 722
    :cond_1
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, v3, v3}, Landroid/media/MediaPlayer;->setVolume(FF)V

    goto :goto_0
.end method

.method public setOnCompletionListener(Lco/vine/android/player/VideoViewInterface$OnCompletionListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    .prologue
    .line 435
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView;->mOnCompletionListener:Lco/vine/android/player/VideoViewInterface$OnCompletionListener;

    .line 436
    return-void
.end method

.method public setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V
    .locals 0
    .param p1, "l"    # Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    .prologue
    .line 447
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView;->mOnErrorListener:Lco/vine/android/player/VideoViewInterface$OnErrorListener;

    .line 448
    return-void
.end method

.method public setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V
    .locals 0
    .param p1, "l"    # Landroid/media/MediaPlayer$OnInfoListener;

    .prologue
    .line 457
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView;->mOnInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    .line 458
    return-void
.end method

.method public setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    .prologue
    .line 703
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView;->mCustomOnPreParedListener:Lco/vine/android/player/VideoViewInterface$OnPreparedListener;

    .line 704
    return-void
.end method

.method public setReportOpenVideoError(Z)V
    .locals 0
    .param p1, "reportVideoError"    # Z

    .prologue
    .line 729
    iput-boolean p1, p0, Lco/vine/android/player/OldSdkVideoView;->mReportVideoError:Z

    .line 730
    return-void
.end method

.method public setVideoPath(Ljava/lang/String;)V
    .locals 2
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 190
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lco/vine/android/provider/VineVideoProvider;->CONTENT_AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/player/OldSdkVideoView;->setVideoURI(Landroid/net/Uri;)V

    .line 191
    return-void
.end method

.method public setVideoPathDirect(Ljava/lang/String;)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 198
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/player/OldSdkVideoView;->setVideoURI(Landroid/net/Uri;)V

    .line 199
    return-void
.end method

.method public setVideoURI(Landroid/net/Uri;)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 202
    iput-object p1, p0, Lco/vine/android/player/OldSdkVideoView;->mUri:Landroid/net/Uri;

    .line 203
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/player/OldSdkVideoView;->mSeekWhenPrepared:I

    .line 204
    invoke-direct {p0}, Lco/vine/android/player/OldSdkVideoView;->openVideo()V

    .line 205
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->requestLayout()V

    .line 206
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->invalidate()V

    .line 207
    return-void
.end method

.method public start()V
    .locals 2

    .prologue
    const/4 v1, 0x3

    .line 570
    invoke-virtual {p0}, Lco/vine/android/player/OldSdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 571
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 572
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 574
    :cond_0
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 575
    return-void
.end method

.method public stopPlayback()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 215
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 216
    const-string v0, "Playback stopped."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 218
    :try_start_0
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_2

    .line 223
    :goto_0
    :try_start_1
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_1

    .line 228
    :goto_1
    :try_start_2
    iget-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V
    :try_end_2
    .catch Ljava/lang/IllegalStateException; {:try_start_2 .. :try_end_2} :catch_0

    .line 232
    :goto_2
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/player/OldSdkVideoView;->mMediaPlayer:Landroid/media/MediaPlayer;

    .line 233
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mCurrentState:I

    .line 234
    iput v1, p0, Lco/vine/android/player/OldSdkVideoView;->mTargetState:I

    .line 236
    :cond_0
    return-void

    .line 229
    :catch_0
    move-exception v0

    goto :goto_2

    .line 224
    :catch_1
    move-exception v0

    goto :goto_1

    .line 219
    :catch_2
    move-exception v0

    goto :goto_0
.end method

.method public suspend()V
    .locals 1

    .prologue
    .line 589
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/player/OldSdkVideoView;->release(Z)V

    .line 590
    return-void
.end method
