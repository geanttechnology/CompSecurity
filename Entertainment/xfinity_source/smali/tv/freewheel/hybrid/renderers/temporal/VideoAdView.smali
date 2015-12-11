.class public Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
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
        Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;
    }
.end annotation


# instance fields
.field private adUrl:Ljava/lang/String;

.field private audioManager:Landroid/media/AudioManager;

.field protected constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

.field private errorListener:Landroid/media/MediaPlayer$OnErrorListener;

.field private hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

.field private isMuted:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private mCurrentState:I

.field private mDuration:I

.field private mSeekWhenPrepared:I

.field private mSurfaceHeight:I

.field private mSurfaceWidth:I

.field private mTargetState:I

.field private mVideoHeight:I

.field private mVideoWidth:I

.field private mediaController:Landroid/widget/MediaController;

.field private mediaPlayer:Landroid/media/MediaPlayer;

.field private final preloadEnabled:Z

.field private preloading:Z

.field preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

.field private surfaceHolder:Landroid/view/SurfaceHolder;

.field private videoAdController:Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;


# direct methods
.method private constructor <init>(Landroid/content/Context;Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "hostRenderer"    # Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    .prologue
    const/4 v1, 0x0

    .line 63
    invoke-direct {p0, p1}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    .line 39
    iput v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 40
    iput v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 48
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    .line 58
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xd

    if-le v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preloadEnabled:Z

    .line 59
    iput-boolean v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preloading:Z

    .line 116
    new-instance v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;-><init>(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->errorListener:Landroid/media/MediaPlayer$OnErrorListener;

    .line 150
    new-instance v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$2;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$2;-><init>(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    .line 65
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 66
    iput-object p2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    .line 67
    iget-object v0, p2, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .line 69
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->initVideoView()V

    .line 70
    invoke-virtual {p0, p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->audioManager:Landroid/media/AudioManager;

    .line 72
    sget-object v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->UNINITIALIZED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isMuted:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    .line 73
    return-void

    :cond_0
    move v0, v1

    .line 58
    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Z)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "hostRenderer"    # Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;
    .param p3, "withMediaController"    # Z

    .prologue
    const/4 v4, 0x0

    const/4 v3, -0x1

    .line 76
    invoke-direct {p0, p1, p2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;-><init>(Landroid/content/Context;Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)V

    .line 78
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v1, v0}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 79
    if-eqz p3, :cond_2

    new-instance v0, Landroid/widget/MediaController;

    invoke-direct {v0, p1}, Landroid/widget/MediaController;-><init>(Landroid/content/Context;)V

    :goto_1
    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    .line 81
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    .line 82
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    .line 84
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v1, 0x11

    invoke-direct {v0, v3, v3, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 86
    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preloadEnabled:Z

    if-nez v0, :cond_0

    .line 87
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->requestLayout()V

    .line 89
    :cond_0
    return-void

    .line 78
    :cond_1
    const-string v0, "out"

    goto :goto_0

    .line 79
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method static synthetic access$1000(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSurfaceHeight:I

    return v0
.end method

.method static synthetic access$102(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    .param p1, "x1"    # I

    .prologue
    .line 20
    iput p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    return p1
.end method

.method static synthetic access$1100(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Landroid/media/MediaPlayer;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    return v0
.end method

.method static synthetic access$202(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    .param p1, "x1"    # I

    .prologue
    .line 20
    iput p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    return p1
.end method

.method static synthetic access$300(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    return-object v0
.end method

.method static synthetic access$400(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    return-object v0
.end method

.method static synthetic access$500(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Z
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preloading:Z

    return v0
.end method

.method static synthetic access$600(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    return v0
.end method

.method static synthetic access$700(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    return v0
.end method

.method static synthetic access$702(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    .param p1, "x1"    # I

    .prologue
    .line 20
    iput p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    return p1
.end method

.method static synthetic access$800(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    return v0
.end method

.method static synthetic access$802(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    .param p1, "x1"    # I

    .prologue
    .line 20
    iput p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    return p1
.end method

.method static synthetic access$900(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    .prologue
    .line 20
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSurfaceWidth:I

    return v0
.end method

.method private initVideoView()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 92
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 93
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 94
    invoke-virtual {p0, v3}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->setFocusable(Z)V

    .line 95
    invoke-virtual {p0, v3}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->setFocusableInTouchMode(Z)V

    .line 96
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->requestFocus()Z

    .line 97
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 98
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 99
    return-void
.end method

.method private openVideo()V
    .locals 5

    .prologue
    const/4 v4, -0x1

    .line 240
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    if-nez v2, :cond_0

    .line 280
    :goto_0
    return-void

    .line 244
    :cond_0
    const/4 v2, 0x0

    invoke-direct {p0, v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->release(Z)V

    .line 246
    :try_start_0
    new-instance v2, Landroid/media/MediaPlayer;

    invoke-direct {v2}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 247
    const/4 v2, -0x1

    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mDuration:I

    .line 248
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 249
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 250
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->errorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 251
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 252
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2, p0}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 253
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2, p0}, Landroid/media/MediaPlayer;->setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 254
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 255
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setScreenOnWhilePlaying(Z)V

    .line 256
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->prepareAsync()V

    .line 257
    const/4 v2, 0x1

    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 258
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->prepareMediaController()V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 259
    :catch_0
    move-exception v0

    .line 260
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 261
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 262
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 264
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 265
    .local v1, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_INVALID_VALUE()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 266
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 268
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v2, v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 269
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    .end local v1    # "info":Landroid/os/Bundle;
    :catch_1
    move-exception v0

    .line 270
    .local v0, "e":Ljava/io/IOException;
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 271
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 273
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 274
    .restart local v1    # "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 275
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to open content: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

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

    .line 278
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v2, v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto/16 :goto_0
.end method

.method private prepareMediaController()V
    .locals 3

    .prologue
    .line 209
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 210
    new-instance v0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-direct {v0, v1, p0, v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;-><init>(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;Landroid/media/MediaPlayer;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->videoAdController:Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;

    .line 211
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->videoAdController:Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;

    invoke-virtual {v0, v1}, Landroid/widget/MediaController;->setMediaPlayer(Landroid/widget/MediaController$MediaPlayerControl;)V

    .line 212
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0, p0}, Landroid/widget/MediaController;->setAnchorView(Landroid/view/View;)V

    .line 213
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/MediaController;->setEnabled(Z)V

    .line 215
    :cond_0
    return-void
.end method

.method private release(Z)V
    .locals 2
    .param p1, "cleartargetstate"    # Z

    .prologue
    const/4 v1, 0x0

    .line 424
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 425
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 426
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 427
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 428
    iput v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 429
    if-eqz p1, :cond_0

    .line 430
    iput v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 433
    :cond_0
    return-void
.end method

.method private startPreloadedVideo()V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 218
    iput v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mDuration:I

    .line 219
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    invoke-virtual {v1, v2}, Landroid/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 220
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->errorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v1, v2}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 221
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1, p0}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 222
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1, p0}, Landroid/media/MediaPlayer;->setOnVideoSizeChangedListener(Landroid/media/MediaPlayer$OnVideoSizeChangedListener;)V

    .line 223
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/media/MediaPlayer;->setScreenOnWhilePlaying(Z)V

    .line 224
    iget v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    .line 225
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-interface {v1, v2}, Landroid/media/MediaPlayer$OnPreparedListener;->onPrepared(Landroid/media/MediaPlayer;)V

    .line 226
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->prepareMediaController()V

    .line 237
    :goto_0
    return-void

    .line 228
    :cond_0
    iput v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 229
    iput v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 231
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 232
    .local v0, "info":Landroid/os/Bundle;
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v1

    const-string v2, "MediaPlayer should in prepared state when start play"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 235
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v1, v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private toggleMediaControlsVisibility()V
    .locals 1

    .prologue
    .line 347
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-nez v0, :cond_0

    .line 355
    :goto_0
    return-void

    .line 350
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 351
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    goto :goto_0

    .line 353
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->show()V

    goto :goto_0
.end method


# virtual methods
.method public dispose()V
    .locals 2

    .prologue
    .line 313
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "dispose"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 314
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->release(Z)V

    .line 315
    return-void
.end method

.method public getDuration()D
    .locals 2

    .prologue
    .line 409
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 410
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mDuration:I

    if-lez v0, :cond_0

    .line 411
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mDuration:I

    int-to-double v0, v0

    .line 417
    :goto_0
    return-wide v0

    .line 413
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    iput v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mDuration:I

    .line 414
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mDuration:I

    int-to-double v0, v0

    goto :goto_0

    .line 416
    :cond_1
    const/4 v0, -0x1

    iput v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mDuration:I

    .line 417
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mDuration:I

    int-to-double v0, v0

    goto :goto_0
.end method

.method public getPlayheadTime()D
    .locals 2

    .prologue
    .line 402
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 403
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v0

    int-to-double v0, v0

    .line 405
    :goto_0
    return-wide v0

    :cond_0
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    goto :goto_0
.end method

.method protected isInPlaybackState()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 436
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v1, :cond_0

    iget v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    iget v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    if-eqz v1, :cond_0

    iget v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    if-eq v1, v0, :cond_0

    iget-boolean v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preloading:Z

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

    .line 475
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "loadContent"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 476
    new-instance v2, Landroid/media/MediaPlayer;

    invoke-direct {v2}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 478
    :try_start_0
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 479
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->errorListener:Landroid/media/MediaPlayer$OnErrorListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 480
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preparedListener:Landroid/media/MediaPlayer$OnPreparedListener;

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    .line 481
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/media/MediaPlayer;->setAudioStreamType(I)V

    .line 482
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->prepareAsync()V

    .line 483
    const/4 v2, 0x1

    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 484
    const/4 v2, 0x1

    iput-boolean v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preloading:Z
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 506
    :goto_0
    return-void

    .line 485
    :catch_0
    move-exception v0

    .line 486
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 487
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 488
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 490
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 491
    .local v1, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_INVALID_VALUE()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 492
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 494
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v2, v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto :goto_0

    .line 495
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    .end local v1    # "info":Landroid/os/Bundle;
    :catch_1
    move-exception v0

    .line 496
    .local v0, "e":Ljava/io/IOException;
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 497
    iput v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 499
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 500
    .restart local v1    # "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 501
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to open content: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

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

    .line 504
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v2, v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 359
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 360
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->toggleMediaControlsVisibility()V

    .line 366
    :goto_0
    return-void

    .line 361
    :cond_0
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 362
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdViewClicked()V

    goto :goto_0

    .line 364
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ignore click if not in playback state, current state "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 3
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    const/4 v2, 0x5

    .line 370
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "video completion"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 372
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 373
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 374
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 375
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 377
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdVideoViewComplete()V

    .line 378
    return-void
.end method

.method protected onImprTimer()V
    .locals 3

    .prologue
    .line 456
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->audioManager:Landroid/media/AudioManager;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    .line 457
    .local v0, "currentVolume":I
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isMuted:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    sget-object v2, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->MUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    if-ne v1, v2, :cond_2

    .line 458
    if-lez v0, :cond_0

    .line 459
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdUnMuted()V

    .line 467
    :cond_0
    :goto_0
    if-lez v0, :cond_3

    sget-object v1, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->UNMUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    :goto_1
    iput-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isMuted:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    .line 469
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->videoAdController:Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;

    if-eqz v1, :cond_1

    .line 470
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->videoAdController:Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdController;->onImprTimer()V

    .line 472
    :cond_1
    return-void

    .line 461
    :cond_2
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isMuted:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    sget-object v2, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->UNMUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    if-ne v1, v2, :cond_0

    .line 462
    if-nez v0, :cond_0

    .line 463
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdMuted()V

    goto :goto_0

    .line 467
    :cond_3
    sget-object v1, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;->MUTED:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$MuteState;

    goto :goto_1
.end method

.method protected onMeasure(II)V
    .locals 5
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 386
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    invoke-static {v2, p1}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getDefaultSize(II)I

    move-result v1

    .line 387
    .local v1, "measuredWidth":I
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    invoke-static {v2, p2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getDefaultSize(II)I

    move-result v0

    .line 389
    .local v0, "measuredHeight":I
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    if-lez v2, :cond_0

    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    if-lez v2, :cond_0

    .line 390
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    mul-int/2addr v3, v1

    if-le v2, v3, :cond_1

    .line 391
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    mul-int/2addr v2, v1

    iget v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    div-int v0, v2, v3

    .line 397
    :cond_0
    :goto_0
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 398
    invoke-virtual {p0, v1, v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->setMeasuredDimension(II)V

    .line 399
    return-void

    .line 392
    :cond_1
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    mul-int/2addr v3, v1

    if-ge v2, v3, :cond_0

    .line 393
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    mul-int/2addr v2, v0

    iget v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    div-int v1, v2, v3

    goto :goto_0
.end method

.method public onVideoSizeChanged(Landroid/media/MediaPlayer;II)V
    .locals 3
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 340
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 341
    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    if-eqz v0, :cond_0

    iget v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    if-eqz v0, :cond_0

    .line 342
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iget v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    invoke-interface {v0, v1, v2}, Landroid/view/SurfaceHolder;->setFixedSize(II)V

    .line 344
    :cond_0
    return-void
.end method

.method public pause()V
    .locals 3

    .prologue
    const/4 v2, 0x4

    .line 318
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "pause"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 319
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 320
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 321
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v0

    iput v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    .line 322
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 323
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 326
    :cond_0
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 327
    return-void
.end method

.method public seekTo(I)V
    .locals 3
    .param p1, "msec"    # I

    .prologue
    .line 444
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "seekTo : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 445
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 446
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p1}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 447
    const/4 v0, 0x0

    iput v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    .line 451
    :goto_0
    return-void

    .line 449
    :cond_0
    iput p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    goto :goto_0
.end method

.method public setAdUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 381
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;

    .line 382
    return-void
.end method

.method public start()V
    .locals 3

    .prologue
    const/4 v2, 0x3

    .line 330
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "start"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 331
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 332
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 333
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 335
    :cond_0
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 336
    return-void
.end method

.method public startPlayback()V
    .locals 2

    .prologue
    .line 296
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "startPlayback"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 297
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->start()V

    .line 298
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdViewStart()V

    .line 299
    return-void
.end method

.method public stop()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 302
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 303
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 304
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V

    .line 305
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 306
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 307
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I

    .line 308
    iput v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    .line 310
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

    .line 103
    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

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

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 104
    iput p3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSurfaceWidth:I

    .line 105
    iput p4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSurfaceHeight:I

    .line 106
    iget v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I

    const/4 v5, 0x3

    if-ne v4, v5, :cond_2

    move v1, v2

    .line 107
    .local v1, "isValidState":Z
    :goto_0
    iget v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoWidth:I

    if-ne v4, p3, :cond_3

    iget v4, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mVideoHeight:I

    if-ne v4, p4, :cond_3

    move v0, v2

    .line 108
    .local v0, "hasValidSize":Z
    :goto_1
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v2, :cond_1

    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    .line 109
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    if-eqz v2, :cond_0

    .line 110
    iget v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mSeekWhenPrepared:I

    invoke-virtual {p0, v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->seekTo(I)V

    .line 112
    :cond_0
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->start()V

    .line 114
    :cond_1
    return-void

    .end local v0    # "hasValidSize":Z
    .end local v1    # "isValidState":Z
    :cond_2
    move v1, v3

    .line 106
    goto :goto_0

    .restart local v1    # "isValidState":Z
    :cond_3
    move v0, v3

    .line 107
    goto :goto_1
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 198
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "surfaceCreated"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 199
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    .line 200
    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preloading:Z

    if-eqz v0, :cond_0

    .line 201
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->preloading:Z

    .line 202
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->startPreloadedVideo()V

    .line 206
    :goto_0
    return-void

    .line 204
    :cond_0
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->openVideo()V

    goto :goto_0
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 284
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "surfaceDestroyed"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 285
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->surfaceHolder:Landroid/view/SurfaceHolder;

    .line 286
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    if-eqz v0, :cond_0

    .line 287
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    .line 289
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    if-eqz v0, :cond_1

    .line 290
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdViewSurfaceDestroyed()V

    .line 292
    :cond_1
    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->dispose()V

    .line 293
    return-void
.end method
