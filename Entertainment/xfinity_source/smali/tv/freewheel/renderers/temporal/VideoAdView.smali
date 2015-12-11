.class public Ltv/freewheel/renderers/temporal/VideoAdView;
.super Landroid/view/SurfaceView;
.source "VideoAdView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;
.implements Landroid/media/MediaPlayer$OnVideoSizeChangedListener;
.implements Landroid/view/SurfaceHolder$Callback;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;
    }
.end annotation


# instance fields
.field private adUrl:Ljava/lang/String;

.field private audioManager:Landroid/media/AudioManager;

.field protected constants:Ltv/freewheel/ad/interfaces/IConstants;

.field private errorListener:Landroid/media/MediaPlayer$OnErrorListener;

.field private hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

.field private isMuted:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

.field private logger:Ltv/freewheel/utils/Logger;

.field private mCurrentState:I

.field private mDuration:I

.field private mLastPlayheadTime:I

.field private mSeekWhenPrepared:I

.field private mSurfaceHeight:I

.field private mSurfaceWidth:I

.field private mTargetState:I

.field private mVideoHeight:I

.field private mVideoWidth:I

.field private mediaController:Landroid/widget/MediaController;

.field private mediaPlayer:Landroid/media/MediaPlayer;

.field onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

.field onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

.field private final preloadEnabled:Z

.field private preloading:Z

.field preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

.field private surfaceHolder:Landroid/view/SurfaceHolder;

.field private videoAdController:Ltv/freewheel/renderers/temporal/VideoAdController;


# direct methods
.method private constructor <init>(Landroid/content/Context;Ltv/freewheel/renderers/temporal/VideoRenderer;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "hostRenderer"    # Ltv/freewheel/renderers/temporal/VideoRenderer;

    .prologue
    const/4 v1, 0x0

    .line 68
    invoke-direct {p0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    .line 43
    iput v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 44
    iput v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 52
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    .line 63
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xd

    if-le v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preloadEnabled:Z

    .line 64
    iput-boolean v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preloading:Z

    .line 121
    new-instance v0, Ltv/freewheel/renderers/temporal/VideoAdView$1;

    invoke-direct {v0, p0}, Ltv/freewheel/renderers/temporal/VideoAdView$1;-><init>(Ltv/freewheel/renderers/temporal/VideoAdView;)V

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->errorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 155
    new-instance v0, Ltv/freewheel/renderers/temporal/VideoAdView$2;

    invoke-direct {v0, p0}, Ltv/freewheel/renderers/temporal/VideoAdView$2;-><init>(Ltv/freewheel/renderers/temporal/VideoAdView;)V

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 201
    new-instance v0, Ltv/freewheel/renderers/temporal/VideoAdView$3;

    invoke-direct {v0, p0}, Ltv/freewheel/renderers/temporal/VideoAdView$3;-><init>(Ltv/freewheel/renderers/temporal/VideoAdView;)V

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    .line 220
    new-instance v0, Ltv/freewheel/renderers/temporal/VideoAdView$4;

    invoke-direct {v0, p0}, Ltv/freewheel/renderers/temporal/VideoAdView$4;-><init>(Ltv/freewheel/renderers/temporal/VideoAdView;)V

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    .line 70
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    .line 71
    iput-object p2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    .line 72
    iget-object v0, p2, Ltv/freewheel/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 74
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->initVideoView()V

    .line 75
    invoke-virtual {p0, p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 76
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->audioManager:Landroid/media/AudioManager;

    .line 77
    sget-object v0, Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;->UNINITIALIZED:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->isMuted:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    .line 78
    return-void

    :cond_0
    move v0, v1

    .line 63
    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;Ltv/freewheel/renderers/temporal/VideoRenderer;Z)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "hostRenderer"    # Ltv/freewheel/renderers/temporal/VideoRenderer;
    .param p3, "withMediaController"    # Z

    .prologue
    const/4 v4, 0x0

    const/4 v3, -0x1

    .line 81
    invoke-direct {p0, p1, p2}, Ltv/freewheel/renderers/temporal/VideoAdView;-><init>(Landroid/content/Context;Ltv/freewheel/renderers/temporal/VideoRenderer;)V

    .line 83
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "with"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-eqz p3, :cond_1

    const-string v0, ""

    :goto_0
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " MediaController"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 84
    if-eqz p3, :cond_2

    new-instance v0, Landroid/widget/MediaController;

    invoke-direct {v0, p1}, Landroid/widget/MediaController;-><init>(Landroid/content/Context;)V

    :goto_1
    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    .line 86
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    .line 87
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    .line 89
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v1, 0x11

    invoke-direct {v0, v3, v3, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    invoke-virtual {p0, v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 91
    iget-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preloadEnabled:Z

    if-nez v0, :cond_0

    .line 92
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->requestLayout()V

    .line 94
    :cond_0
    return-void

    .line 83
    :cond_1
    const-string v0, "out"

    goto :goto_0

    .line 84
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static synthetic access$000(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    return-object v0
.end method

.method static synthetic access$1000(Ltv/freewheel/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSurfaceHeight:I

    return v0
.end method

.method static synthetic access$102(Ltv/freewheel/renderers/temporal/VideoAdView;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;
    .param p1, "x1"    # I

    .prologue
    .line 24
    iput p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    return p1
.end method

.method static synthetic access$1100(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/media/MediaPlayer;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    return-object v0
.end method

.method static synthetic access$1200(Ltv/freewheel/renderers/temporal/VideoAdView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1202(Ltv/freewheel/renderers/temporal/VideoAdView;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$200(Ltv/freewheel/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    return v0
.end method

.method static synthetic access$202(Ltv/freewheel/renderers/temporal/VideoAdView;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;
    .param p1, "x1"    # I

    .prologue
    .line 24
    iput p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    return p1
.end method

.method static synthetic access$300(Ltv/freewheel/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    return-object v0
.end method

.method static synthetic access$400(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/renderers/temporal/VideoRenderer;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    return-object v0
.end method

.method static synthetic access$500(Ltv/freewheel/renderers/temporal/VideoAdView;)Z
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preloading:Z

    return v0
.end method

.method static synthetic access$600(Ltv/freewheel/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    return v0
.end method

.method static synthetic access$700(Ltv/freewheel/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    return v0
.end method

.method static synthetic access$702(Ltv/freewheel/renderers/temporal/VideoAdView;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;
    .param p1, "x1"    # I

    .prologue
    .line 24
    iput p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    return p1
.end method

.method static synthetic access$800(Ltv/freewheel/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    return v0
.end method

.method static synthetic access$802(Ltv/freewheel/renderers/temporal/VideoAdView;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;
    .param p1, "x1"    # I

    .prologue
    .line 24
    iput p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    return p1
.end method

.method static synthetic access$900(Ltv/freewheel/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/temporal/VideoAdView;

    .prologue
    .line 24
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSurfaceWidth:I

    return v0
.end method

.method private initVideoView()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 97
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 98
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 99
    invoke-virtual {p0, v3}, Ltv/freewheel/renderers/temporal/VideoAdView;->setFocusable(Z)V

    .line 100
    invoke-virtual {p0, v3}, Ltv/freewheel/renderers/temporal/VideoAdView;->setFocusableInTouchMode(Z)V

    .line 101
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->requestFocus()Z

    .line 102
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 103
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 104
    return-void
.end method

.method private openVideo()V
    .locals 5

    .prologue
    const/4 v4, -0x1

    .line 270
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    if-nez v2, :cond_0

    .line 312
    :goto_0
    return-void

    .line 274
    :cond_0
    const/4 v2, 0x0

    invoke-direct {p0, v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->release(Z)V

    .line 276
    :try_start_0
    new-instance v2, Landroid/media/MediaPlayer;

    invoke-direct {v2}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 277
    const/4 v2, -0x1

    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mDuration:I

    .line 278
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 279
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 280
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->errorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 281
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 282
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V

    .line 283
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 284
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2, p0}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 285
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2, p0}, Landroid/media/MediaPlayer;->setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 286
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 287
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setScreenOnWhilePlaying(Z)V

    .line 288
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->prepareAsync()V

    .line 289
    const/4 v2, 0x1

    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 290
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->prepareMediaController()V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 291
    :catch_0
    move-exception v0

    .line 292
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 293
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 294
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 296
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 297
    .local v1, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_INVALID_VALUE()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v2, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 301
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    .end local v1    # "info":Landroid/os/Bundle;
    :catch_1
    move-exception v0

    .line 302
    .local v0, "e":Ljava/io/IOException;
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 303
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 305
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 306
    .restart local v1    # "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to open content: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", error: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 310
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v2, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto/16 :goto_0
.end method

.method private prepareMediaController()V
    .locals 3

    .prologue
    .line 239
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 240
    new-instance v0, Ltv/freewheel/renderers/temporal/VideoAdController;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-direct {v0, v1, p0, v2}, Ltv/freewheel/renderers/temporal/VideoAdController;-><init>(Ltv/freewheel/renderers/temporal/VideoRenderer;Ltv/freewheel/renderers/temporal/VideoAdView;Landroid/media/MediaPlayer;)V

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->videoAdController:Ltv/freewheel/renderers/temporal/VideoAdController;

    .line 241
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->videoAdController:Ltv/freewheel/renderers/temporal/VideoAdController;

    invoke-virtual {v0, v1}, Landroid/widget/MediaController;->setMediaPlayer(Landroid/widget/MediaController$MediaPlayerControl;)V

    .line 242
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0, p0}, Landroid/widget/MediaController;->setAnchorView(Landroid/view/View;)V

    .line 243
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/MediaController;->setEnabled(Z)V

    .line 245
    :cond_0
    return-void
.end method

.method private release(Z)V
    .locals 2
    .param p1, "cleartargetstate"    # Z

    .prologue
    const/4 v1, 0x0

    .line 469
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 470
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 471
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 472
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 473
    iput v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 474
    if-eqz p1, :cond_0

    .line 475
    iput v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 478
    :cond_0
    return-void
.end method

.method private startPreloadedVideo()V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 248
    iput v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mDuration:I

    .line 249
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    invoke-virtual {v1, v2}, Landroid/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 250
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->errorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v1, v2}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 251
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1, p0}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 252
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1, p0}, Landroid/media/MediaPlayer;->setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 253
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/media/MediaPlayer;->setScreenOnWhilePlaying(Z)V

    .line 254
    iget v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    .line 255
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-interface {v1, v2}, Landroid/media/MediaPlayer$OnPreparedListener;->onPrepared(Landroid/media/MediaPlayer;)V

    .line 256
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->prepareMediaController()V

    .line 267
    :goto_0
    return-void

    .line 258
    :cond_0
    iput v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 259
    iput v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 261
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 262
    .local v0, "info":Landroid/os/Bundle;
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v1

    const-string v2, "MediaPlayer should in prepared state when start play"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v1, v0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private toggleMediaControlsVisibility()V
    .locals 1

    .prologue
    .line 382
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-nez v0, :cond_0

    .line 390
    :goto_0
    return-void

    .line 385
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 386
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    goto :goto_0

    .line 388
    :cond_1
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->show()V

    goto :goto_0
.end method


# virtual methods
.method public dispose()V
    .locals 2

    .prologue
    .line 345
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "dispose"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 346
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->release(Z)V

    .line 347
    return-void
.end method

.method public getDuration()D
    .locals 2

    .prologue
    .line 454
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 455
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mDuration:I

    if-lez v0, :cond_0

    .line 456
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mDuration:I

    int-to-double v0, v0

    .line 462
    :goto_0
    return-wide v0

    .line 458
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mDuration:I

    .line 459
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mDuration:I

    int-to-double v0, v0

    goto :goto_0

    .line 461
    :cond_1
    const/4 v0, -0x1

    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mDuration:I

    .line 462
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mDuration:I

    int-to-double v0, v0

    goto :goto_0
.end method

.method public getPlayheadTime()D
    .locals 4

    .prologue
    .line 437
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 438
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v0

    .line 439
    .local v0, "playheadTime":I
    iget v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mLastPlayheadTime:I

    if-lez v1, :cond_0

    .line 440
    if-nez v0, :cond_1

    .line 441
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mLastPlayheadTime:I

    .line 446
    :cond_0
    :goto_0
    int-to-double v2, v0

    .line 450
    .end local v0    # "playheadTime":I
    :goto_1
    return-wide v2

    .line 443
    .restart local v0    # "playheadTime":I
    :cond_1
    const/4 v1, 0x0

    iput v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mLastPlayheadTime:I

    goto :goto_0

    .line 447
    .end local v0    # "playheadTime":I
    :cond_2
    iget v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mLastPlayheadTime:I

    if-lez v1, :cond_3

    .line 448
    iget v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mLastPlayheadTime:I

    int-to-double v2, v1

    goto :goto_1

    .line 450
    :cond_3
    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    goto :goto_1
.end method

.method protected isInPlaybackState()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 481
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v1, :cond_0

    iget v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    iget v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    if-eqz v1, :cond_0

    iget v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    if-eq v1, v0, :cond_0

    iget-boolean v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preloading:Z

    if-nez v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected loadContent()V
    .locals 5

    .prologue
    const/4 v4, -0x1

    .line 520
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "loadContent"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 521
    new-instance v2, Landroid/media/MediaPlayer;

    invoke-direct {v2}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 523
    :try_start_0
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 524
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->errorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 525
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->onInfoListener:Landroid/media/MediaPlayer$OnInfoListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnInfoListener(Landroid/media/MediaPlayer$OnInfoListener;)V

    .line 526
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->onBufferingUpdateListener:Landroid/media/MediaPlayer$OnBufferingUpdateListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnBufferingUpdateListener(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V

    .line 527
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 528
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 529
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->prepareAsync()V

    .line 530
    const/4 v2, 0x1

    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 531
    const/4 v2, 0x1

    iput-boolean v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preloading:Z
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 553
    :goto_0
    return-void

    .line 532
    :catch_0
    move-exception v0

    .line 533
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 534
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 535
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 537
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 538
    .local v1, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_INVALID_VALUE()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 539
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 541
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v2, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 542
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    .end local v1    # "info":Landroid/os/Bundle;
    :catch_1
    move-exception v0

    .line 543
    .local v0, "e":Ljava/io/IOException;
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 544
    iput v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 546
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 547
    .restart local v1    # "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 548
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to open content: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", error: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 551
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v2, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 394
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 395
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->toggleMediaControlsVisibility()V

    .line 401
    :goto_0
    return-void

    .line 396
    :cond_0
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 397
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdViewClicked()V

    goto :goto_0

    .line 399
    :cond_1
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ignore click if not in playback state, current state "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 3
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    const/4 v2, 0x5

    .line 405
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "video completion"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 407
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 408
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 409
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 410
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 412
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdVideoViewComplete()V

    .line 413
    return-void
.end method

.method protected onImprTimer()V
    .locals 3

    .prologue
    .line 501
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->audioManager:Landroid/media/AudioManager;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    .line 502
    .local v0, "currentVolume":I
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->isMuted:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    sget-object v2, Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;->MUTED:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    if-ne v1, v2, :cond_2

    .line 503
    if-lez v0, :cond_0

    .line 504
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdUnMuted()V

    .line 512
    :cond_0
    :goto_0
    if-lez v0, :cond_3

    sget-object v1, Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;->UNMUTED:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    :goto_1
    iput-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->isMuted:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    .line 514
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->videoAdController:Ltv/freewheel/renderers/temporal/VideoAdController;

    if-eqz v1, :cond_1

    .line 515
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->videoAdController:Ltv/freewheel/renderers/temporal/VideoAdController;

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoAdController;->onImprTimer()V

    .line 517
    :cond_1
    return-void

    .line 506
    :cond_2
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->isMuted:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    sget-object v2, Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;->UNMUTED:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    if-ne v1, v2, :cond_0

    .line 507
    if-nez v0, :cond_0

    .line 508
    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdMuted()V

    goto :goto_0

    .line 512
    :cond_3
    sget-object v1, Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;->MUTED:Ltv/freewheel/renderers/temporal/VideoAdView$MuteState;

    goto :goto_1
.end method

.method protected onMeasure(II)V
    .locals 5
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 421
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    invoke-static {v2, p1}, Ltv/freewheel/renderers/temporal/VideoAdView;->getDefaultSize(II)I

    move-result v1

    .line 422
    .local v1, "measuredWidth":I
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    invoke-static {v2, p2}, Ltv/freewheel/renderers/temporal/VideoAdView;->getDefaultSize(II)I

    move-result v0

    .line 424
    .local v0, "measuredHeight":I
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    if-lez v2, :cond_0

    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    if-lez v2, :cond_0

    .line 425
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    mul-int/2addr v3, v1

    if-le v2, v3, :cond_1

    .line 426
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    mul-int/2addr v2, v1

    iget v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    div-int v0, v2, v3

    .line 432
    :cond_0
    :goto_0
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "onMeasure width: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " height: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 433
    invoke-virtual {p0, v1, v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->setMeasuredDimension(II)V

    .line 434
    return-void

    .line 427
    :cond_1
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    mul-int/2addr v3, v1

    if-ge v2, v3, :cond_0

    .line 428
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    div-int v1, v2, v3

    goto :goto_0
.end method

.method public onVideoSizeChanged(Landroid/media/MediaPlayer;II)V
    .locals 3
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 373
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onVideoSizeChanged width: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " height: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 374
    invoke-virtual {p1}, Landroid/media/MediaPlayer;->getVideoWidth()I

    move-result v0

    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    .line 375
    invoke-virtual {p1}, Landroid/media/MediaPlayer;->getVideoHeight()I

    move-result v0

    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    .line 376
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    if-eqz v0, :cond_0

    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    if-eqz v0, :cond_0

    .line 377
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iget v1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    invoke-interface {v0, v1, v2}, Landroid/view/SurfaceHolder;->setFixedSize(II)V

    .line 379
    :cond_0
    return-void
.end method

.method public pause()V
    .locals 3

    .prologue
    const/4 v2, 0x4

    .line 350
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "pause"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 351
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 352
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 353
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v0

    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    .line 354
    iget v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mLastPlayheadTime:I

    .line 355
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 356
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 359
    :cond_0
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 360
    return-void
.end method

.method public seekTo(I)V
    .locals 3
    .param p1, "msec"    # I

    .prologue
    .line 489
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "seekTo : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 490
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 491
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 492
    const/4 v0, 0x0

    iput v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    .line 496
    :goto_0
    return-void

    .line 494
    :cond_0
    iput p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    goto :goto_0
.end method

.method public setAdUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 416
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    .line 417
    return-void
.end method

.method public start()V
    .locals 3

    .prologue
    const/4 v2, 0x3

    .line 363
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "start"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 364
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 365
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 366
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 368
    :cond_0
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 369
    return-void
.end method

.method public startPlayback()V
    .locals 2

    .prologue
    .line 328
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "startPlayback"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 329
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->start()V

    .line 330
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdViewStart()V

    .line 331
    return-void
.end method

.method public stop()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 334
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 335
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 336
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V

    .line 337
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 338
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 339
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 340
    iput v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    .line 342
    :cond_0
    return-void
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 7
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 108
    iget-object v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "surfaceChanged w:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " h:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 109
    iput p3, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSurfaceWidth:I

    .line 110
    iput p4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSurfaceHeight:I

    .line 111
    iget v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mTargetState:I

    const/4 v5, 0x3

    if-ne v4, v5, :cond_2

    move v1, v2

    .line 112
    .local v1, "isValidState":Z
    :goto_0
    iget v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoWidth:I

    if-ne v4, p3, :cond_3

    iget v4, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mVideoHeight:I

    if-ne v4, p4, :cond_3

    move v0, v2

    .line 113
    .local v0, "hasValidSize":Z
    :goto_1
    iget-object v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v2, :cond_1

    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    .line 114
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    if-eqz v2, :cond_0

    .line 115
    iget v2, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    invoke-virtual {p0, v2}, Ltv/freewheel/renderers/temporal/VideoAdView;->seekTo(I)V

    .line 117
    :cond_0
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->start()V

    .line 119
    :cond_1
    return-void

    .end local v0    # "hasValidSize":Z
    .end local v1    # "isValidState":Z
    :cond_2
    move v1, v3

    .line 111
    goto :goto_0

    .restart local v1    # "isValidState":Z
    :cond_3
    move v0, v3

    .line 112
    goto :goto_1
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 228
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "surfaceCreated"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 229
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    .line 230
    iget-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preloading:Z

    if-eqz v0, :cond_0

    .line 231
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->preloading:Z

    .line 232
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->startPreloadedVideo()V

    .line 236
    :goto_0
    return-void

    .line 234
    :cond_0
    invoke-direct {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->openVideo()V

    goto :goto_0
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 316
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "surfaceDestroyed"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 317
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    .line 318
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 319
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 321
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    if-eqz v0, :cond_1

    .line 322
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdViewSurfaceDestroyed()V

    .line 324
    :cond_1
    invoke-virtual {p0}, Ltv/freewheel/renderers/temporal/VideoAdView;->dispose()V

    .line 325
    return-void
.end method

.method public tryToGetRedirectedUrl(Ljava/lang/String;I)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "timeoutMs"    # I

    .prologue
    .line 556
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Ltv/freewheel/renderers/temporal/VideoAdView$5;

    invoke-direct {v1, p0, p1, p2}, Ltv/freewheel/renderers/temporal/VideoAdView$5;-><init>(Ltv/freewheel/renderers/temporal/VideoAdView;Ljava/lang/String;I)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 587
    return-void
.end method
