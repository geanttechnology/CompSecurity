.class public final Lcom/adobe/mediacore/MediaPlayerView;
.super Landroid/view/ViewGroup;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/MediaPlayerView$ScreenReceiver;,
        Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private _mReceiver:Landroid/content/BroadcastReceiver;

.field private _playbackEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

.field private _videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

.field private _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

.field private _videoEngineView:Lcom/adobe/ave/VideoEngineView;

.field private _videoEngineViewCallback:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

.field private currentPlayerState:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field private oldPlayerState:Lcom/adobe/mediacore/MediaPlayer$PlayerState;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/MediaPlayerView;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerView;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerView;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerView;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineDispatcher;)V
    .locals 2

    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerView$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/MediaPlayerView$1;-><init>(Lcom/adobe/mediacore/MediaPlayerView;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_playbackEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    if-nez p2, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine adapter parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez p3, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine adapter parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput-object p2, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iput-object p3, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerView;->initialize(Landroid/content/Context;)V

    return-void
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerView;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200()Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerView;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/MediaPlayerView;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerView;->restorePlayer()V

    return-void
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/MediaPlayerView;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerView;->suspendPlayer()V

    return-void
.end method

.method static synthetic access$602(Lcom/adobe/mediacore/MediaPlayerView;Lcom/adobe/mediacore/MediaPlayer$PlayerState;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerView;->currentPlayerState:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    return-object p1
.end method

.method private initialiseVideoEngineViewCallback(Landroid/content/Context;)V
    .locals 2

    new-instance v0, Lcom/adobe/ave/VideoEngineView;

    invoke-direct {v0, p1}, Lcom/adobe/ave/VideoEngineView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-direct {v0, p0, v1}, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;-><init>(Lcom/adobe/mediacore/MediaPlayerView;Landroid/view/SurfaceView;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineViewCallback:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/MediaPlayerView;->addView(Landroid/view/View;)V

    return-void
.end method

.method private initialize(Landroid/content/Context;)V
    .locals 3

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerView;->initialiseVideoEngineViewCallback(Landroid/content/Context;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerView;->_playbackEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.SCREEN_ON"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    const-string v1, "android.intent.action.SCREEN_OFF"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerView$ScreenReceiver;

    invoke-direct {v1, p0}, Lcom/adobe/mediacore/MediaPlayerView$ScreenReceiver;-><init>(Lcom/adobe/mediacore/MediaPlayerView;)V

    iput-object v1, p0, Lcom/adobe/mediacore/MediaPlayerView;->_mReceiver:Landroid/content/BroadcastReceiver;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerView;->_mReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, v1, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    return-void
.end method

.method private releaseVideoEngineViewCallback()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineViewCallback:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineViewCallback:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    # invokes: Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->release()V
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->access$000(Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineViewCallback:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    :cond_0
    return-void
.end method

.method private restorePlayer()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineViewCallback:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineViewCallback:Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerView$VideoEngineViewCallback;->hasSurface()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/MediaPlayerView;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerView;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#restorePlayer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to restore player. View surface is not created."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerView;->oldPlayerState:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->restorePlayer(Lcom/adobe/mediacore/MediaPlayer$PlayerState;)V

    goto :goto_0
.end method

.method private suspendPlayer()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlayerState()Lcom/adobe/ave/PlayState;

    move-result-object v0

    sget-object v1, Lcom/adobe/ave/PlayState;->SUSPENDED:Lcom/adobe/ave/PlayState;

    if-ne v0, v1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerView;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerView;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#suspendPlayer"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "The player is already suspended."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->currentPlayerState:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->oldPlayerState:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->suspendPlayer()V

    goto :goto_0
.end method


# virtual methods
.method public animate()Landroid/view/ViewPropertyAnimator;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    goto :goto_0
.end method

.method public buildDrawingCache()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->buildDrawingCache()V

    :cond_0
    return-void
.end method

.method public buildDrawingCache(Z)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->buildDrawingCache(Z)V

    :cond_0
    return-void
.end method

.method public clearAnimation()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->clearAnimation()V

    :cond_0
    return-void
.end method

.method public destroyDrawingCache()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->destroyDrawingCache()V

    :cond_0
    return-void
.end method

.method detachView()V
    .locals 4

    const/4 v3, 0x0

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerView;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerView;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#detachView"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Detaching view."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerView;->releaseVideoEngineViewCallback()V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerView;->_playbackEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iput-object v3, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object v3, p0, Lcom/adobe/mediacore/MediaPlayerView;->_playbackEventListener:Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerView;->_mReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    iput-object v3, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    return-void
.end method

.method public getAnimation()Landroid/view/animation/Animation;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    goto :goto_0
.end method

.method public getBackground()Landroid/graphics/drawable/Drawable;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0
.end method

.method public getDrawingCache()Landroid/graphics/Bitmap;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getDrawingCache()Landroid/graphics/Bitmap;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->getDrawingCache()Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0
.end method

.method public getDrawingCache(Z)Landroid/graphics/Bitmap;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->getDrawingCache(Z)Landroid/graphics/Bitmap;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->getDrawingCache(Z)Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0
.end method

.method public getDrawingCacheBackgroundColor()I
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getDrawingCacheBackgroundColor()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->getDrawingCacheBackgroundColor()I

    move-result v0

    goto :goto_0
.end method

.method public getDrawingCacheQuality()I
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getDrawingCacheQuality()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->getDrawingCacheQuality()I

    move-result v0

    goto :goto_0
.end method

.method public getDrawingTime()J
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getDrawingTime()J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->getDrawingTime()J

    move-result-wide v0

    goto :goto_0
.end method

.method public getKeepScreenOn()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getKeepScreenOn()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->getKeepScreenOn()Z

    move-result v0

    goto :goto_0
.end method

.method getVideoEngineView()Lcom/adobe/ave/VideoEngineView;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    return-object v0
.end method

.method public invalidate()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->invalidate()V

    :cond_0
    return-void
.end method

.method public invalidate(IIII)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/adobe/ave/VideoEngineView;->invalidate(IIII)V

    :cond_0
    return-void
.end method

.method public invalidate(Landroid/graphics/Rect;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->invalidate(Landroid/graphics/Rect;)V

    :cond_0
    return-void
.end method

.method public invalidateDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->invalidateDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_0
    return-void
.end method

.method public isDrawingCacheEnabled()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->isDrawingCacheEnabled()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->isDrawingCacheEnabled()Z

    move-result v0

    goto :goto_0
.end method

.method public notifyClick()V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {}, Lcom/adobe/mediacore/AdClickEvent;->createAdClickEvent()Lcom/adobe/mediacore/AdClickEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-super {p0}, Landroid/view/ViewGroup;->getWidth()I

    move-result v1

    invoke-super {p0}, Landroid/view/ViewGroup;->getHeight()I

    move-result v2

    invoke-virtual {v0, v3, v3, v1, v2}, Lcom/adobe/ave/VideoEngineView;->layout(IIII)V

    return-void
.end method

.method public refreshDrawableState()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->refreshDrawableState()V

    :cond_0
    return-void
.end method

.method resetView()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/MediaPlayerView;->updateView(Landroid/content/Context;)V

    return-void
.end method

.method public setAnimation(Landroid/view/animation/Animation;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setAnimation(Landroid/view/animation/Animation;)V

    :cond_0
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setBackgroundColor(I)V

    :cond_0
    return-void
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_0
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setBackgroundResource(I)V

    :cond_0
    return-void
.end method

.method public setDrawingCacheBackgroundColor(I)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setDrawingCacheBackgroundColor(I)V

    :cond_0
    return-void
.end method

.method public setDrawingCacheEnabled(Z)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setDrawingCacheEnabled(Z)V

    :cond_0
    return-void
.end method

.method public setDrawingCacheQuality(I)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setDrawingCacheQuality(I)V

    :cond_0
    return-void
.end method

.method public setKeepScreenOn(Z)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setKeepScreenOn(Z)V

    :cond_0
    return-void
.end method

.method public setWillNotCacheDrawing(Z)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setWillNotCacheDrawing(Z)V

    :cond_0
    return-void
.end method

.method public setWillNotDraw(Z)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->setWillNotDraw(Z)V

    :cond_0
    return-void
.end method

.method public startAnimation(Landroid/view/animation/Animation;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, p1}, Lcom/adobe/ave/VideoEngineView;->startAnimation(Landroid/view/animation/Animation;)V

    :cond_0
    return-void
.end method

.method updateVideoEngine(Landroid/content/Context;Lcom/adobe/mediacore/VideoEngineAdapter;)V
    .locals 0

    iput-object p2, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/MediaPlayerView;->updateView(Landroid/content/Context;)V

    return-void
.end method

.method updateView(Landroid/content/Context;)V
    .locals 2

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerView;->releaseVideoEngineViewCallback()V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/MediaPlayerView;->removeView(Landroid/view/View;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerView;->initialiseVideoEngineViewCallback(Landroid/content/Context;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setView(Lcom/adobe/ave/VideoEngineView;)V

    return-void
.end method

.method public willNotCacheDrawing()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->willNotCacheDrawing()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->willNotCacheDrawing()Z

    move-result v0

    goto :goto_0
.end method

.method public willNotDraw()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerView;->_videoEngineView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineView;->willNotDraw()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Landroid/view/ViewGroup;->willNotDraw()Z

    move-result v0

    goto :goto_0
.end method
