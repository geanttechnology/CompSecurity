.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "BackgroundState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private keyguardReciever:Landroid/content/BroadcastReceiver;

.field private previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p2, "previousState"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 20
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 21
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->returnFromBackground()V

    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->unregisterKeyguardReceiver()V

    return-void
.end method

.method private returnFromBackground()V
    .locals 4

    .prologue
    .line 77
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->previousState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 78
    return-void
.end method

.method private declared-synchronized unregisterKeyguardReceiver()V
    .locals 2

    .prologue
    .line 70
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->keyguardReciever:Landroid/content/BroadcastReceiver;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 74
    :cond_0
    monitor-exit p0

    return-void

    .line 70
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    const-string v0, "BackgroundState"

    return-object v0
.end method

.method public onActivityResumed()V
    .locals 5

    .prologue
    .line 46
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v1

    const-string v2, "keyguard"

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/KeyguardManager;

    .line 47
    .local v0, "keyguardManager":Landroid/app/KeyguardManager;
    invoke-virtual {v0}, Landroid/app/KeyguardManager;->inKeyguardRestrictedInputMode()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 49
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->unregisterKeyguardReceiver()V

    .line 51
    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    .line 63
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->keyguardReciever:Landroid/content/BroadcastReceiver;

    new-instance v3, Landroid/content/IntentFilter;

    const-string v4, "android.intent.action.USER_PRESENT"

    invoke-direct {v3, v4}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 67
    :goto_0
    return-void

    .line 65
    :cond_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->returnFromBackground()V

    goto :goto_0
.end method

.method public onBufferComplete()V
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideSpinner()V

    .line 88
    return-void
.end method

.method public onPlayStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 1
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 92
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne p1, v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->pause()V

    .line 95
    :cond_0
    return-void
.end method

.method public onVideoSeekComplete()V
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideSpinner()V

    .line 83
    return-void
.end method

.method public run()V
    .locals 0

    .prologue
    .line 42
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->unregisterKeyguardReceiver()V

    .line 27
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    if-eqz v0, :cond_0

    .line 28
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 32
    :goto_0
    return-void

    .line 30
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
