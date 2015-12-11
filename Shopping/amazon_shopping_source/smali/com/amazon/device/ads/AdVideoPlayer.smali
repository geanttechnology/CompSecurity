.class final Lcom/amazon/device/ads/AdVideoPlayer;
.super Ljava/lang/Object;
.source "AdVideoPlayer.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;
.implements Landroid/media/MediaPlayer$OnErrorListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;
    }
.end annotation


# static fields
.field private static LOG_TAG:Ljava/lang/String;


# instance fields
.field private audioManager_:Landroid/media/AudioManager;

.field private contentUrl_:Ljava/lang/String;

.field private context_:Landroid/content/Context;

.field private layoutParams_:Landroid/view/ViewGroup$LayoutParams;

.field private listener_:Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;

.field private playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

.field private released_:Z

.field private videoView_:Landroid/widget/VideoView;

.field private viewGroup_:Landroid/view/ViewGroup;

.field private volumeBeforeMuting_:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-string/jumbo v0, "AdVideoPlayer"

    sput-object v0, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->released_:Z

    .line 39
    iput-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    .line 40
    iput-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->layoutParams_:Landroid/view/ViewGroup$LayoutParams;

    .line 41
    iput-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->viewGroup_:Landroid/view/ViewGroup;

    .line 45
    iput-object p1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->context_:Landroid/content/Context;

    .line 47
    new-instance v0, Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-direct {v0}, Lcom/amazon/device/ads/Controller$PlayerProperties;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    .line 48
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->context_:Landroid/content/Context;

    const-string/jumbo v1, "audio"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->audioManager_:Landroid/media/AudioManager;

    .line 49
    return-void
.end method

.method private displayPlayerControls()V
    .locals 3

    .prologue
    .line 120
    sget-object v1, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "in displayPlayerControls"

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-virtual {v1}, Lcom/amazon/device/ads/Controller$PlayerProperties;->showControl()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 123
    new-instance v0, Landroid/widget/MediaController;

    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->context_:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/MediaController;-><init>(Landroid/content/Context;)V

    .line 124
    .local v0, "controller":Landroid/widget/MediaController;
    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    invoke-virtual {v1, v0}, Landroid/widget/VideoView;->setMediaController(Landroid/widget/MediaController;)V

    .line 125
    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    invoke-virtual {v0, v1}, Landroid/widget/MediaController;->setAnchorView(Landroid/view/View;)V

    .line 126
    invoke-virtual {v0}, Landroid/widget/MediaController;->requestFocus()Z

    .line 128
    .end local v0    # "controller":Landroid/widget/MediaController;
    :cond_0
    return-void
.end method

.method private initializeVideoView()V
    .locals 3

    .prologue
    .line 95
    new-instance v0, Landroid/widget/VideoView;

    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->context_:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/VideoView;-><init>(Landroid/content/Context;)V

    .line 96
    .local v0, "videoView":Landroid/widget/VideoView;
    invoke-virtual {v0, p0}, Landroid/widget/VideoView;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 97
    invoke-virtual {v0, p0}, Landroid/widget/VideoView;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    .line 98
    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->layoutParams_:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 100
    iput-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    .line 101
    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->viewGroup_:Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 102
    return-void
.end method

.method private loadPlayerContent()V
    .locals 2

    .prologue
    .line 106
    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->contentUrl_:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 107
    .local v0, "uri":Landroid/net/Uri;
    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    invoke-virtual {v1, v0}, Landroid/widget/VideoView;->setVideoURI(Landroid/net/Uri;)V

    .line 108
    return-void
.end method

.method private removePlayerFromParent()V
    .locals 2

    .prologue
    .line 157
    sget-object v0, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "in removePlayerFromParent"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->viewGroup_:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 159
    return-void
.end method


# virtual methods
.method public mutePlayer()V
    .locals 4

    .prologue
    const/4 v3, 0x3

    .line 82
    sget-object v0, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "in mutePlayer"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->audioManager_:Landroid/media/AudioManager;

    invoke-virtual {v0, v3}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->volumeBeforeMuting_:I

    .line 84
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->audioManager_:Landroid/media/AudioManager;

    const/4 v1, 0x0

    const/4 v2, 0x4

    invoke-virtual {v0, v3, v1, v2}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 85
    return-void
.end method

.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 1
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-virtual {v0}, Lcom/amazon/device/ads/Controller$PlayerProperties;->doLoop()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 144
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    .line 153
    :cond_0
    :goto_0
    return-void

    .line 146
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-virtual {v0}, Lcom/amazon/device/ads/Controller$PlayerProperties;->exitOnComplete()Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    iget-boolean v0, v0, Lcom/amazon/device/ads/Controller$PlayerProperties;->inline:Z

    if-eqz v0, :cond_0

    .line 148
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->releasePlayer()V

    .line 150
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->listener_:Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->listener_:Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;

    invoke-interface {v0}, Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;->onComplete()V

    goto :goto_0
.end method

.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 1
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    .line 133
    invoke-direct {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->removePlayerFromParent()V

    .line 134
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->listener_:Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->listener_:Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;

    invoke-interface {v0}, Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;->onError()V

    .line 136
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public playAudio()V
    .locals 2

    .prologue
    .line 76
    sget-object v0, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "in playAudio"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    invoke-direct {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->loadPlayerContent()V

    .line 78
    return-void
.end method

.method public playVideo()V
    .locals 2

    .prologue
    .line 65
    sget-object v0, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "in playVideo"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-virtual {v0}, Lcom/amazon/device/ads/Controller$PlayerProperties;->doMute()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->mutePlayer()V

    .line 69
    :cond_0
    invoke-direct {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->initializeVideoView()V

    .line 70
    invoke-direct {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->loadPlayerContent()V

    .line 71
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->startPlaying()V

    .line 72
    return-void
.end method

.method public releasePlayer()V
    .locals 2

    .prologue
    .line 163
    sget-object v0, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "in releasePlayer"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    iget-boolean v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->released_:Z

    if-eqz v0, :cond_1

    .line 174
    :cond_0
    :goto_0
    return-void

    .line 167
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->released_:Z

    .line 169
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->stopPlayback()V

    .line 170
    invoke-direct {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->removePlayerFromParent()V

    .line 172
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-virtual {v0}, Lcom/amazon/device/ads/Controller$PlayerProperties;->doMute()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 173
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->unmutePlayer()V

    goto :goto_0
.end method

.method public setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 0
    .param p1, "layoutParams"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 178
    iput-object p1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->layoutParams_:Landroid/view/ViewGroup$LayoutParams;

    .line 179
    return-void
.end method

.method public setListener(Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->listener_:Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;

    .line 61
    return-void
.end method

.method public setPlayData(Lcom/amazon/device/ads/Controller$PlayerProperties;Ljava/lang/String;)V
    .locals 1
    .param p1, "properties"    # Lcom/amazon/device/ads/Controller$PlayerProperties;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 53
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->released_:Z

    .line 54
    if-eqz p1, :cond_0

    iput-object p1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    .line 55
    :cond_0
    iput-object p2, p0, Lcom/amazon/device/ads/AdVideoPlayer;->contentUrl_:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setViewGroup(Landroid/view/ViewGroup;)V
    .locals 0
    .param p1, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 183
    iput-object p1, p0, Lcom/amazon/device/ads/AdVideoPlayer;->viewGroup_:Landroid/view/ViewGroup;

    .line 184
    return-void
.end method

.method public startPlaying()V
    .locals 2

    .prologue
    .line 112
    sget-object v0, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "in startPlaying"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    invoke-direct {p0}, Lcom/amazon/device/ads/AdVideoPlayer;->displayPlayerControls()V

    .line 114
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->playerProperties_:Lcom/amazon/device/ads/Controller$PlayerProperties;

    invoke-virtual {v0}, Lcom/amazon/device/ads/Controller$PlayerProperties;->isAutoPlay()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->videoView_:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    .line 116
    :cond_0
    return-void
.end method

.method public unmutePlayer()V
    .locals 4

    .prologue
    .line 89
    sget-object v0, Lcom/amazon/device/ads/AdVideoPlayer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "in unmutePlayer"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/amazon/device/ads/AdVideoPlayer;->audioManager_:Landroid/media/AudioManager;

    const/4 v1, 0x3

    iget v2, p0, Lcom/amazon/device/ads/AdVideoPlayer;->volumeBeforeMuting_:I

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 91
    return-void
.end method
